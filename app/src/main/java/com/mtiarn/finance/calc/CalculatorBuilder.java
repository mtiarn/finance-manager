package com.mtiarn.finance.calc;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;

public class CalculatorBuilder {
    private String activityTitle;
    private String value;

    public CalculatorBuilder() {
    }

    public CalculatorBuilder withValue(String value) {
        this.value = value;
        return this;
    }


    public CalculatorBuilder withTitle(String activityTitle) {
        this.activityTitle = activityTitle;
        return this;
    }


    public void start(Activity activity) {
        Intent i = new Intent(activity, CalculatorActivity.class);
        if (!TextUtils.isEmpty(activityTitle)) {
            i.putExtra(CalculatorActivity.TITLE_ACTIVITY, activityTitle);
        }

        if (!TextUtils.isEmpty(value)) {
            i.putExtra(CalculatorActivity.VALUE, value);
        }

        activity.startActivityForResult(i, CalculatorActivity.REQUEST_RESULT_SUCCESSFUL);
    }
}