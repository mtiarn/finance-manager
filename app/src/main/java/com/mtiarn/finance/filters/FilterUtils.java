package com.mtiarn.finance.filters;

import android.content.Context;
import android.util.Pair;

import com.mtiarn.finance.dao.BaseDAO;
import com.mtiarn.finance.interfaces.IAbstractModel;
import com.mtiarn.finance.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class FilterUtils {
    public static List<IAbstractModel> CreateModelsListFromTransaction(Transaction transaction, Context context) {
        List<Pair<Integer, Long>> entities = new ArrayList<>();
        entities.add(new Pair<>(IAbstractModel.MODEL_TYPE_ACCOUNT, transaction.getAccountID()));
//        entities.add(new Pair<>(IAbstractModel.MODEL_TYPE_ACCOUNT, transaction.getDestAccountID()));
        entities.add(new Pair<>(IAbstractModel.MODEL_TYPE_CATEGORY, transaction.getCategoryID()));
        entities.add(new Pair<>(IAbstractModel.MODEL_TYPE_PAYEE, transaction.getPayeeID()));
        entities.add(new Pair<>(IAbstractModel.MODEL_TYPE_LOCATION, transaction.getLocationID()));
        entities.add(new Pair<>(IAbstractModel.MODEL_TYPE_PROJECT, transaction.getProjectID()));
        entities.add(new Pair<>(IAbstractModel.MODEL_TYPE_DEPARTMENT, transaction.getDepartmentID()));

        List<IAbstractModel> models = new ArrayList<>();
        for (Pair<Integer, Long> entity : entities) {
            if (entity.second >= 0) {
                models.add(BaseDAO.getDAO(entity.first, context).getModelById(entity.second));
            }
        }
        return models;
    }
}
