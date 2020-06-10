package com.mtiarn.finance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.mtiarn.finance.adapter.NestedItemFullNameAdapter;
import com.mtiarn.finance.dao.CategoriesDAO;
import com.mtiarn.finance.dao.CreditsDAO;
import com.mtiarn.finance.dao.PayeesDAO;
import com.mtiarn.finance.interfaces.IAbstractModel;
import com.mtiarn.finance.managers.AccountManager;
import com.mtiarn.finance.managers.DebtsManager;
import com.mtiarn.finance.managers.PayeeManager;
import com.mtiarn.finance.model.Account;
import com.mtiarn.finance.model.Cabbage;
import com.mtiarn.finance.model.Category;
import com.mtiarn.finance.model.Credit;
import com.mtiarn.finance.model.Payee;
import com.mtiarn.finance.utils.RequestCodes;
import com.mtiarn.finance.widgets.ToolbarActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.mtiarn.finance.utils.RequestCodes.REQUEST_CODE_SELECT_MODEL;

public class ActivityEditCredit extends ToolbarActivity implements FragmentPayee.FragmentPayeeListener{

//    private static final String TAG = "ActivityEditCredit";

    @BindView(R.id.textViewAccount)
    EditText textViewAccount;
    @BindView(R.id.textViewCategory)
    EditText textViewCategory;
    @BindView(R.id.editTextComment)
    EditText textViewComment;
    @BindView(R.id.imageButtonDeleteCategory)
    ImageButton mImageButtonDeleteCategory;
    @BindView(R.id.buttonSaveTransaction)
    Button mButtonSaveTransaction;
    private Credit mCredit;
    private FragmentPayee fragmentPayee;
    private String mPayeeName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);
        mCredit = getIntent().getParcelableExtra("credit");
    }

    @Override
    public void onResume() {
        super.onResume();
        initUI();
    }

    private void initUI() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getLayoutTitle());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(ContextCompat.getDrawable(this, R.drawable.ic_close_white));
        }

        initAccount();
        initPayee();
        initCategory();
        initComment();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("payee_name", mPayeeName);
        outState.putParcelable("credit", mCredit);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mPayeeName = savedInstanceState.getString("payee_name");
        mCredit = savedInstanceState.getParcelable("credit");
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_edit_credit_2;
    }

    @Override
    protected String getLayoutTitle() {
        if (mCredit == null) {
            return "";
        }
        if (mCredit.getID() < 0) {
            return getResources().getString(R.string.ent_new_credit);
        } else {
            return getResources().getString(R.string.ent_edit_credit);
        }
    }

    private void initAccount() {
        Account account = DebtsManager.getAccount(mCredit, this);
        Cabbage cabbage = AccountManager.getCabbage(account, this);
        if (account.getID() < 0) {
            textViewAccount.setText("");
        } else {
            textViewAccount.setText(String.format("%s (%s)", account.getName(), cabbage.getSimbol()));
        }

        textViewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityEditCredit.this, ActivityAccounts.class);
                intent.putExtra("showHomeButton", false);
                intent.putExtra("model", new Account());
                ActivityEditCredit.this.startActivityForResult(intent, RequestCodes.REQUEST_CODE_SELECT_MODEL);
            }
        });
    }

    private void initPayee() {
        fragmentPayee = (FragmentPayee) getSupportFragmentManager().findFragmentById(R.id.fragmentPayee);
        Payee payee = DebtsManager.getPayee(mCredit, this);
        setPayeeName(payee.getFullName());
//        fragmentPayee.setHint(getString(R.string.ent_payee));
    }

    @Override
    public String getPayeeName() {
        return mPayeeName;
    }

    @Override
    public String getPayeeHint() {
        return getString(R.string.ent_payee);
    }

    @Override
    public void onPayeeTextViewClick() {
        Intent intent = new Intent(ActivityEditCredit.this.getApplicationContext(), ActivityList.class);
        intent.putExtra("showHomeButton", false);
        intent.putExtra("model", PayeesDAO.getInstance(getApplicationContext()).getPayeeByID(mCredit.getPayeeID()));
        intent.putExtra("requestCode", REQUEST_CODE_SELECT_MODEL);
        ActivityEditCredit.this.startActivityForResult(intent, REQUEST_CODE_SELECT_MODEL);
    }

    @Override
    public void onPayeeItemClick(long payeeID) {

    }

    @Override
    public void onPayeeTyping(String payeeName) {
        mPayeeName = payeeName;
    }

    @Override
    public void onClearPayee() {
        mCredit.setPayeeID(-1);
        setPayeeName("");
    }

    @Override
    public int getPayeeSelectionStyle() {
        return 0;
    }

    @Override
    public boolean isShowKeyboard() {
        return false;
    }

    @Override
    public NestedItemFullNameAdapter getPayeeNameAutocompleteAdapter() {
        return null;
    }

    private void initCategory() {
        textViewCategory.setText("");
        Category category = DebtsManager.getCategory(mCredit, this);
        textViewCategory.setText(category.getFullName());
        textViewCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityEditCredit.this.getApplicationContext(), ActivityList.class);
                intent.putExtra("showHomeButton", false);
                intent.putExtra("model", CategoriesDAO.getInstance(getApplicationContext()).getCategoryByID(mCredit.getCategoryID()));
                intent.putExtra("requestCode", RequestCodes.REQUEST_CODE_SELECT_MODEL);
                ActivityEditCredit.this.startActivityForResult(intent, RequestCodes.REQUEST_CODE_SELECT_MODEL);
            }
        });
    }

    private void initComment() {
        textViewComment.setText(mCredit.getComment());
        textViewComment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCredit.setComment(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == RequestCodes.REQUEST_CODE_SELECT_MODEL && data != null) {
            IAbstractModel model = data.getParcelableExtra("model");
            switch (model.getModelType()) {
                case IAbstractModel.MODEL_TYPE_ACCOUNT:
                    Account selectedAccount = (Account) model;
                    textViewAccount.setText(selectedAccount.getName());
                    mCredit.setAccountID(selectedAccount.getID());
//                    fragmentPayee.edPayee.requestFocus();
                    Cabbage cabbage = AccountManager.getCabbage(selectedAccount, ActivityEditCredit.this);
                    textViewAccount.setText(String.format("%s (%s)", selectedAccount.getName(), cabbage.getSimbol()));
                    break;
                case IAbstractModel.MODEL_TYPE_CATEGORY:
                    mCredit.setCategoryID(model.getID());
                    initCategory();
                    break;
                case IAbstractModel.MODEL_TYPE_PAYEE:
                    mCredit.setPayeeID(model.getID());
                    mPayeeName = model.getFullName();
                    break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.findItem(R.id.action_go_home).setVisible(false);
        menu.findItem(R.id.action_show_help).setVisible(true);
        return true;

    }

    private void checkPayeeAndCreateIfNecessary() {
        if ((mCredit.getPayeeID() < 0) & !mPayeeName.isEmpty()) {
            Payee payee = new Payee(-1, mPayeeName, mCredit.getCategoryID(), -1, 0, false);
            try {
                payee = (Payee) PayeesDAO.getInstance(getApplicationContext()).createModel(payee);
            } catch (Exception e) {
                e.printStackTrace();
            }
            mCredit.setPayeeID(payee.getID());
        }
    }

    @OnClick(R.id.buttonSaveTransaction)
    public void onSaveClick() {
        checkPayeeAndCreateIfNecessary();

        //Устанавливаем текущему получателю в качестве категории по умолчанию текущую категорию
        Payee payee = DebtsManager.getPayee(mCredit, this);
        Category category = DebtsManager.getCategory(mCredit, this);
        Category defCategory = PayeeManager.getDefCategory(payee, this);
        if (defCategory.getID() != category.getID()) {
            PayeesDAO payeesDAO = PayeesDAO.getInstance(getApplicationContext());
            payee.setDefCategoryID(category.getID());
            try {
                payeesDAO.createModel(payee);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (mCredit.isValid()) {
            Credit newCredit;
            try {
                newCredit = (Credit) CreditsDAO.getInstance(this).createModel(mCredit);
            } catch (Exception e) {
                Toast.makeText(this, R.string.msg_error_on_write_to_db, Toast.LENGTH_SHORT).show();
                return;
            }
            if (newCredit.getID() >= 0) {
                finish();
            }
        }
    }

    @OnClick(R.id.imageButtonDeleteCategory)
    public void onClick() {
        mCredit.setCategoryID(-1);
        initCategory();
    }

    private void setPayeeName(String payeeName) {
        mPayeeName = payeeName;
        if (fragmentPayee != null) {
            fragmentPayee.setPayeeName(payeeName);
        }
    }
}
