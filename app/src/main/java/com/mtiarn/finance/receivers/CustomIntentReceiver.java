package com.mtiarn.finance.receivers;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.mtiarn.finance.ActivityEditTransaction;
import com.mtiarn.finance.dao.AccountsDAO;
import com.mtiarn.finance.dao.CategoriesDAO;
import com.mtiarn.finance.dao.LocationsDAO;
import com.mtiarn.finance.dao.PayeesDAO;
import com.mtiarn.finance.dao.ProjectsDAO;
import com.mtiarn.finance.dao.SendersDAO;
import com.mtiarn.finance.dao.TemplatesDAO;
import com.mtiarn.finance.dao.TransactionsDAO;
import com.mtiarn.finance.managers.TransactionManager;
import com.mtiarn.finance.model.Category;
import com.mtiarn.finance.model.Payee;
import com.mtiarn.finance.model.Sms;
import com.mtiarn.finance.model.Template;
import com.mtiarn.finance.model.Transaction;
import com.mtiarn.finance.utils.PrefUtils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomIntentReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            if (action.equals("com.mtiarn.finance.intent.action.CREATE_SMS")) {
                String senderName = intent.getStringExtra("sender");
                long senderID = -1;
                if (senderName != null) {
                    try {
                        senderID = SendersDAO.getInstance(context).getModelByName(senderName).getID();
                    } catch (Exception e) {
                        senderID = -1;
                    }
                }
                String body = intent.getStringExtra("body").replaceAll("%s", " ");
                if (senderID >= 0 && body != null && !body.isEmpty()) {
                    Sms sms = new Sms(-1, new Date(), senderID, body);
                    try {
                        SMSReceiver smsReceiver = new SMSReceiver();
                        smsReceiver.parseSMS(context, sms);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if (action.equals("com.mtiarn.finance.intent.action.CREATE_TRANSACTION")) {
                Transaction transaction = createTransactionFromIntent(context, intent);

                String showEditorS;
                if (intent.getIntExtra("show_editor", Integer.MAX_VALUE) < Integer.MAX_VALUE) {
                    showEditorS = String.valueOf(intent.getIntExtra("show_editor", Integer.MAX_VALUE));
                } else {
                    showEditorS = intent.getStringExtra("show_editor");
                }
                boolean showEditor = false;
                if (showEditorS != null) {
                    showEditor = showEditorS.equals("1");
                }

                if (!transaction.isValidToAutoCreate() || showEditor) {
                    Intent intent1 = new Intent(context, ActivityEditTransaction.class);
                    intent1.putExtra("transaction", transaction);
                    intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent1);
                } else {
                    try {
                        TransactionsDAO.getInstance(context).createModel(transaction);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private Transaction createTransactionFromIntent(Context context, Intent intent) {
        Transaction transaction = new Transaction(PrefUtils.getDefDepID(context));

        String templateName = intent.getStringExtra("template");
        if (templateName != null) {
            try {
                Template template = (Template) TemplatesDAO.getInstance(context).getModelByName(templateName);
                transaction = TransactionManager.templateToTransaction(template, context);
            } catch (Exception e) {
                transaction = new Transaction(PrefUtils.getDefDepID(context));
            }
        }
        
        String accountName = intent.getStringExtra("account");
        if (accountName != null) {
            long accID;
            try {
                accID = AccountsDAO.getInstance(context).getModelByName(accountName).getID();
            } catch (Exception e) {
                accID = -1;
            }
            transaction.setAccountID(accID);
        }

        String typeS;
        if (intent.getIntExtra("type", Integer.MAX_VALUE) < Integer.MAX_VALUE) {
            typeS = String.valueOf(intent.getIntExtra("type", Integer.MAX_VALUE));
        } else {
            typeS = intent.getStringExtra("type");
        }
        String amountS;
        if (intent.getIntExtra("amount", Integer.MAX_VALUE) < Integer.MAX_VALUE) {
            amountS = String.valueOf(intent.getIntExtra("amount", Integer.MAX_VALUE));
        } else if (intent.getFloatExtra("amount", Float.MAX_VALUE) < Float.MAX_VALUE) {
            amountS = String.valueOf(intent.getFloatExtra("amount", Float.MAX_VALUE));
        } else {
            amountS = intent.getStringExtra("amount");
        }
        if (templateName == null) {
            if (typeS != null && amountS != null) {
                int type = Transaction.TRANSACTION_TYPE_EXPENSE;
                if (typeS.equals("0")) type = Transaction.TRANSACTION_TYPE_TRANSFER;
                if (typeS.equals("1")) type = Transaction.TRANSACTION_TYPE_INCOME;
                BigDecimal amount;
                try {
                    amount = new BigDecimal(amountS);
                } catch (NumberFormatException e) {
                    amount = BigDecimal.ZERO;
                }
                transaction.setAmount(amount, type);
            }
        } else {
            if (amountS != null) {
                BigDecimal amount;
                try {
                    amount = new BigDecimal(amountS);
                } catch (NumberFormatException e) {
                    amount = BigDecimal.ZERO;
                }
                transaction.setAmount(amount, transaction.getTransactionType());
            }
        }

        if (transaction.getTransactionType() == Transaction.TRANSACTION_TYPE_TRANSFER) {
            String destAccountName = intent.getStringExtra("dest_account");
            if (accountName != null) {
                long accID;
                try {
                    accID = AccountsDAO.getInstance(context).getModelByName(destAccountName).getID();
                } catch (Exception e) {
                    accID = -1;
                }
                transaction.setDestAccountID(accID);
            }
        } else {
            String payeeName = intent.getStringExtra("payee");
            if (payeeName != null) {
                try {
                    long payeeId = PayeesDAO.getInstance(context).getModelByName(payeeName).getID();
                    if (payeeId < 0 & !payeeName.isEmpty()) {
                        payeeId = PayeesDAO.getInstance(context).createModel(new Payee(-1, payeeName, -1, -1, 0, false)).getID();
                    }
                    transaction.setPayeeID(payeeId);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        String categoryName = intent.getStringExtra("category");
        if (categoryName != null) {
            try {
                transaction.setCategoryID(CategoriesDAO.getInstance(context).getModelByName(categoryName).getID());
            } catch (Exception e) {
                transaction.setCategoryID(-1);
            }
        }

        if (transaction.getCategoryID() < 0) {
            Payee payee = PayeesDAO.getInstance(context).getPayeeByID(transaction.getPayeeID());
            Category category = CategoriesDAO.getInstance(context).getCategoryByID(payee.getDefCategoryID());
            transaction.setCategoryID(category.getID());
        }

        String projectName = intent.getStringExtra("project");
        if (projectName != null) {
            try {
                transaction.setProjectID(ProjectsDAO.getInstance(context).getModelByName(projectName).getID());
            } catch (Exception e) {
                transaction.setProjectID(-1);
            }
        }

        String locationName = intent.getStringExtra("location");
        if (locationName != null) {
            try {
                transaction.setLocationID(LocationsDAO.getInstance(context).getModelByName(locationName).getID());
            } catch (Exception e) {
                transaction.setLocationID(-1);
            }
        }

        String comment = intent.getStringExtra("comment");
        if (comment != null) {
            transaction.setComment(comment);
        }

        String dateS = intent.getStringExtra("datetime");
        String format = intent.getStringExtra("dtformat");
        if (format == null) {
            format = "yyyy-MM-dd_HH:mm:ss";
        }
        if (dateS != null) {
            Date date;
            @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat(format);
            try {
                date = dateFormat.parse(dateS);
            } catch (ParseException e) {
                date = new Date();
            }
            transaction.setDateTime(date);
        }

        return transaction;
    }
}
