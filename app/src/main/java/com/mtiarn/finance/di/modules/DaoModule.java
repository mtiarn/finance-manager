package com.mtiarn.finance.di.modules;

import android.content.Context;

import com.mtiarn.finance.dao.AccountsDAO;
import com.mtiarn.finance.dao.BudgetCreditsDAO;
import com.mtiarn.finance.dao.BudgetDAO;
import com.mtiarn.finance.dao.CabbagesDAO;
import com.mtiarn.finance.dao.CategoriesDAO;
import com.mtiarn.finance.dao.CreditsDAO;
import com.mtiarn.finance.dao.DepartmentsDAO;
import com.mtiarn.finance.dao.LocationsDAO;
import com.mtiarn.finance.dao.PayeesDAO;
import com.mtiarn.finance.dao.ProductsDAO;
import com.mtiarn.finance.dao.ProjectsDAO;
import com.mtiarn.finance.dao.SendersDAO;
import com.mtiarn.finance.dao.SimpleDebtsDAO;
import com.mtiarn.finance.dao.SmsDAO;
import com.mtiarn.finance.dao.SmsMarkersDAO;
import com.mtiarn.finance.dao.TemplatesDAO;
import com.mtiarn.finance.dao.TransactionsDAO;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ContextModule.class})
public class DaoModule {

    @Provides
    @Singleton
    public CabbagesDAO provideCabbagesDAO(Context context) {
        return CabbagesDAO.getInstance(context);
    }

    @Provides
    @Singleton
    public LocationsDAO provideLocationsDAO(Context context) {
        return LocationsDAO.getInstance(context);
    }

    @Provides
    @Singleton
    public PayeesDAO providePayeesDAO(Context context) {
        return PayeesDAO.getInstance(context);
    }

    @Provides
    @Singleton
    public ProjectsDAO provideProjectsDAO(Context context) {
        return ProjectsDAO.getInstance(context);
    }

    @Provides
    @Singleton
    public SmsMarkersDAO provideSmsMarkersDAO(Context context) {
        return SmsMarkersDAO.getInstance(context);
    }

    @Provides
    @Singleton
    public AccountsDAO provideAccountsDAO(Context context) {
        return AccountsDAO.getInstance(context);
    }

    @Provides
    @Singleton
    public CategoriesDAO provideCategoriesDAO(Context context) {
        return CategoriesDAO.getInstance(context);
    }

    @Provides
    @Singleton
    public SmsDAO provideSmsDAO(Context context) {
        return SmsDAO.getInstance(context);
    }

    @Provides
    @Singleton
    public TransactionsDAO provideTransactionsDAO(Context context) {
        return TransactionsDAO.getInstance(context);
    }

    @Provides
    @Singleton
    public CreditsDAO provideCreditsDAO(Context context) {
        return CreditsDAO.getInstance(context);
    }

    @Provides
    @Singleton
    public TemplatesDAO provideTemplatesDAO(Context context) {
        return TemplatesDAO.getInstance(context);
    }

    @Provides
    @Singleton
    public DepartmentsDAO provideDepartmentsDAO(Context context) {
        return DepartmentsDAO.getInstance(context);
    }

    @Provides
    @Singleton
    public SimpleDebtsDAO provideSimpleDebtsDAO(Context context) {
        return SimpleDebtsDAO.getInstance(context);
    }

    @Provides
    @Singleton
    public SendersDAO provideSendersDAO(Context context) {
        return SendersDAO.getInstance(context);
    }

    @Provides
    @Singleton
    public BudgetDAO provideBudgetDAO(Context context) {
        return BudgetDAO.getInstance(context);
    }

    @Provides
    @Singleton
    public BudgetCreditsDAO provideBudgetCreditsDAO(Context context) {
        return BudgetCreditsDAO.getInstance(context);
    }

    @Provides
    @Singleton
    public ProductsDAO provideProductsDAO(Context context) {
        return ProductsDAO.getInstance(context);
    }
}
