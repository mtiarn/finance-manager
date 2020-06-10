package com.mtiarn.finance.managers;

import android.content.Context;

import com.mtiarn.finance.dao.AccountsDAO;
import com.mtiarn.finance.dao.CategoriesDAO;
import com.mtiarn.finance.dao.PayeesDAO;
import com.mtiarn.finance.model.Account;
import com.mtiarn.finance.model.Category;
import com.mtiarn.finance.model.Credit;
import com.mtiarn.finance.model.Payee;

import java.math.BigDecimal;

public class DebtsManager {

    public static Account getAccount(Credit credit, Context context){
        AccountsDAO accountsDAO = AccountsDAO.getInstance(context);
        return accountsDAO.getAccountByID(credit.getAccountID());
    }

    public static Category getCategory(Credit credit, Context context){
        CategoriesDAO categoriesDAO = CategoriesDAO.getInstance(context);
        return categoriesDAO.getCategoryByID(credit.getCategoryID());
    }

    public static Payee getPayee(Credit credit, Context context){
        PayeesDAO payeesDAO = PayeesDAO.getInstance(context);
        return payeesDAO.getPayeeByID(credit.getPayeeID());
    }

    public static BigDecimal getSum(Credit credit, Context context){
        AccountsDAO accountsDAO = AccountsDAO.getInstance(context);
        return accountsDAO.getAccountByID(credit.getAccountID()).getCurrentBalance();
    }
}
