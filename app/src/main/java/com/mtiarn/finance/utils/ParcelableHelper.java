package com.mtiarn.finance.utils;


import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableHelper {

    public static Parcelable immediateDeepCopy(Parcelable input) {
        return immediateDeepCopy(input, input.getClass().getClassLoader());
    }


    public static Parcelable immediateDeepCopy(Parcelable input, ClassLoader classLoader) {
        Parcel parcel = null;
        try {
            parcel = Parcel.obtain();
            parcel.writeParcelable(input, 0);
            parcel.setDataPosition(0);
            return parcel.readParcelable(classLoader);
        } finally {
            if (parcel != null) {
                parcel.recycle();
            }
        }
    }
}
