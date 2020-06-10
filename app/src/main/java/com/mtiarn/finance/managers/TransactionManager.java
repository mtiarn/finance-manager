package com.mtiarn.finance.managers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.preference.PreferenceManager;
import android.widget.Toast;

import com.mtiarn.finance.ActivityEditTransaction;
import com.mtiarn.finance.dao.AccountsDAO;
import com.mtiarn.finance.dao.CategoriesDAO;
import com.mtiarn.finance.dao.LocationsDAO;
import com.mtiarn.finance.dao.PayeesDAO;
import com.mtiarn.finance.dao.SimpleDebtsDAO;
import com.mtiarn.finance.dao.TransactionsDAO;
import com.mtiarn.finance.model.Account;
import com.mtiarn.finance.model.Cabbage;
import com.mtiarn.finance.model.Category;
import com.mtiarn.finance.model.Location;
import com.mtiarn.finance.model.Payee;
import com.mtiarn.finance.model.SimpleDebt;
import com.mtiarn.finance.model.Template;
import com.mtiarn.finance.model.Transaction;
import com.mtiarn.finance.R;
import com.mtiarn.finance.utils.CabbageFormatter;
import com.mtiarn.finance.utils.DateTimeFormatter;
import com.mtiarn.finance.utils.PrefUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TransactionManager {

    public static Category getCategory(Transaction transaction, Context context){
        CategoriesDAO categoriesDAO = CategoriesDAO.getInstance(context);
        return categoriesDAO.getCategoryByID(transaction.getCategoryID());
    }

    public static Payee getPayee(Transaction transaction, Context context){
        PayeesDAO payeesDAO = PayeesDAO.getInstance(context);
        return payeesDAO.getPayeeByID(transaction.getPayeeID());
    }

    public static Account getSrcAccount(Transaction transaction, Context context){
        AccountsDAO accountsDAO = AccountsDAO.getInstance(context);
        return accountsDAO.getAccountByID(transaction.getAccountID());
    }

    public static Account getDestAccount(Transaction transaction, Context context){
        AccountsDAO accountsDAO = AccountsDAO.getInstance(context);
        return accountsDAO.getAccountByID(transaction.getDestAccountID());
    }

    public static Cabbage getSrcCabbage(Transaction transaction, Context context) {
        return AccountManager.getCabbage(AccountsDAO.getInstance(context).getAccountByID(transaction.getAccountID()), context);
    }

    public static Cabbage getDstCabbage(Transaction transaction, Context context) {
        return AccountManager.getCabbage(AccountsDAO.getInstance(context).getAccountByID(transaction.getDestAccountID()), context);
    }

    public static SimpleDebt getSimpleDebt(Transaction transaction, Context context){
        SimpleDebtsDAO simpleDebtsDAO = SimpleDebtsDAO.getInstance(context);
        return simpleDebtsDAO.getSimpleDebtByID(transaction.getSimpleDebtID());
    }

    public static Location getLocation(Transaction transaction, Context context){
        LocationsDAO locationsDAO = LocationsDAO.getInstance(context);
        return locationsDAO.getLocationByID(transaction.getLocationID());
    }

    public static String transactionToString(Transaction transaction, Context context){
        AccountsDAO accountsDAO = AccountsDAO.getInstance(context);
        PayeesDAO payeesDAO = PayeesDAO.getInstance(context);
        Account account = accountsDAO.getAccountByID(transaction.getAccountID());
        CabbageFormatter cf = new CabbageFormatter(AccountManager.getCabbage(account, context));
        return String.format("%s, %s, %s", account.getName(), payeesDAO.getPayeeByID(transaction.getPayeeID()).getName(),
                cf.format(transaction.getAmount()));
    }

    public static Transaction templateToTransaction(Template template, Context context) {
        Transaction transaction = new Transaction(PrefUtils.getDefDepID(context));
        transaction.setAccountID(template.getAccountID());
        transaction.setPayeeID(template.getPayeeID());
        transaction.setCategoryID(template.getCategoryID());
        transaction.setAmount(template.getAmount(), template.getTrType());
        transaction.setProjectID(template.getProjectID());
        transaction.setDepartmentID(template.getDepartmentID());
        transaction.setLocationID(template.getLocationID());
        transaction.setDestAccountID(template.getDestAccountID());
        transaction.setExchangeRate(template.getExchangeRate());
        transaction.setTransactionType(template.getTrType());
        transaction.setComment(template.getComment());
        return transaction;
    }

    public static void createTransactionFromTemplate(Template template, Context context) {
        Transaction transaction = TransactionManager.templateToTransaction(template, context);
        if (transaction.getAmount().compareTo(BigDecimal.ZERO) == 0 || !transaction.isValidToAutoCreate()) {
            Intent intent = new Intent(context, ActivityEditTransaction.class);
            intent.putExtra("transaction", transaction);
            intent.putExtra("focus_to_amount", true);
            context.startActivity(intent);
        } else {
            try {
                TransactionsDAO.getInstance(context).createModel(transaction);
            } catch (Exception e) {
                Toast.makeText(context, R.string.msg_error_on_write_to_db, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static Transaction createTransactionFromQR(Transaction transaction, String text, Context context) {
        //t=20171219T155200&s=1286.00&fn=8710000100022003&i=54813&fp=3906717812&n=1
        if (transaction == null) {
            transaction = new Transaction(PrefUtils.getDefDepID(context));
        }
        String items[] = text.split("&");
        String keyValue[];
        for (String s : items) {
            keyValue = s.split("=");
            if (keyValue.length == 2) {
                switch (keyValue[0]) {
                    case "t" :
                        String dts;
                        if (keyValue[1].length() == 15) {
                            dts = keyValue[1];
                        } else {
                            dts = keyValue[1] + "00";
                        }
                        transaction.setDateTime(DateTimeFormatter.getInstance(context).parseDateTimeQrString(dts.replace("T","")));
                        break;
                    case "s":
                        transaction.setAmount(new BigDecimal(Double.valueOf(keyValue[1])), Transaction.TRANSACTION_TYPE_EXPENSE);
                        break;
                    case "fn":
                        try {
                            transaction.setFN(Long.valueOf(keyValue[1]));
                        } catch (NumberFormatException e) {
                            transaction.setFN(0);
                        }
                        break;
                    case "i":
                        try {
                            transaction.setFD(Long.valueOf(keyValue[1]));
                        } catch (NumberFormatException e) {
                            transaction.setFD(0);
                        }
                        break;
                    case "fp":
                        try {
                            transaction.setFP(Long.valueOf(keyValue[1]));
                        } catch (NumberFormatException e) {
                            transaction.setFP(0);
                        }
                        break;
                }
            }
        }

        Transaction lastTransaction = TransactionsDAO.getInstance(context).getLastTransactionForFN(transaction);

        if (transaction.getAccountID() < 0) {
            transaction.setAccountID(lastTransaction.getAccountID());
        }
        if (transaction.getPayeeID() < 0) {
            transaction.setPayeeID(lastTransaction.getPayeeID());
            transaction.setCategoryID(PayeeManager.getDefCategory(PayeesDAO.getInstance(context).getPayeeByID(transaction.getPayeeID()),context).getID());
        }

        return transaction;
    }

    public static boolean isValidToSmsAutocreate(Transaction transaction, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        Set<String> defValues = new HashSet<>(Arrays.asList(context.getResources().getStringArray(R.array.pref_autocreate_prerequisites_values)));
        Set<String> set = preferences.getStringSet("autocreate_prerequisites", defValues);
        boolean result = true;
        if (set.contains("account")) {
            result = transaction.getAccountID() > 0;
        }
        if (set.contains("amount")) {
            result = result & transaction.getAmount().compareTo(BigDecimal.ZERO) != 0;
        }
        if (set.contains("payee") & transaction.getTransactionType() != Transaction.TRANSACTION_TYPE_TRANSFER) {
            result = result & transaction.getPayeeID() > 0;
        }
        if (set.contains("category") & transaction.getTransactionType() != Transaction.TRANSACTION_TYPE_TRANSFER) {
            result = result & transaction.getCategoryID() > 0;
        }
        if (transaction.getTransactionType() == Transaction.TRANSACTION_TYPE_TRANSFER) {
            result = result & transaction.getDestAccountID() > 0;
        }
        return result;
    }
}
