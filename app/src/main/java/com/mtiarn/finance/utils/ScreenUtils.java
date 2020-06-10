package com.mtiarn.finance.utils;

import android.content.Context;
import android.util.DisplayMetrics;


public class ScreenUtils {


    public static int dpToPx(float dp, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static float PxToDp(final Context context, final float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }
}
