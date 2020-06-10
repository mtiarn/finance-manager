package com.mtiarn.finance.managers;

import com.mtiarn.finance.interfaces.IAbstractModel;
import com.mtiarn.finance.model.BaseModel;
import com.mtiarn.finance.utils.BaseNode;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;

public class TreeManager {

    public static BaseNode convertListToTree(List<IAbstractModel> models, int modelType) {
        BaseNode tree = new BaseNode(BaseModel.createModelByType(modelType), null);

        HashSet<Long> processedIds = new HashSet<>();

        int lastIdCount = 0;
        while (models.size() != processedIds.size()) {
            for (IAbstractModel model : models) {
                if (!processedIds.contains(model.getID())) {
                    if (tree.addChild(model) != null) {
                        processedIds.add(model.getID());
                    }
                }
            }
            if (processedIds.size() == lastIdCount) {
                break;
            }
            lastIdCount = processedIds.size();
        }

        return tree;
    }

    public static void updateInExSumsForParents(BaseNode root) {
        IAbstractModel rootModel = root.getModel();
        IAbstractModel childModel;
        int notEmptyChildCount = 0;

        for (BaseNode node : root.getFlatChildrenList()) {
            childModel = node.getModel();
            if (childModel.getExpense().compareTo(BigDecimal.ZERO) != 0 || childModel.getIncome().compareTo(BigDecimal.ZERO) != 0) {
                notEmptyChildCount++;
                rootModel.setExpense(rootModel.getExpense().add(childModel.getExpense()));
                rootModel.setIncome(rootModel.getIncome().add(childModel.getIncome()));
            }
        }
        if (notEmptyChildCount > 0) {
            rootModel.setName(String.format("%s +%s", rootModel.getName(), String.valueOf(notEmptyChildCount)));
        }

        for (BaseNode node : root.getChildren()) {
            updateInExSumsForParents(node);
        }

//        int i = root.getNumberOfChildren();
//        if (i > 0) {
//            rootModel.setName(String.format("%s +%s", rootModel.getName(), String.valueOf(i)));
//        }
//        for (BaseNode node : root.getChildren()) {
//            childModel = node.getModel();
//            rootModel.setExpense(rootModel.getExpense().add(childModel.getExpense()));
//            rootModel.setIncome(rootModel.getIncome().add(childModel.getIncome()));
//            if (node.getChildren().size() > 0) {
//                updateInExSumsForParents(node);
//            }
//        }
    }
}
