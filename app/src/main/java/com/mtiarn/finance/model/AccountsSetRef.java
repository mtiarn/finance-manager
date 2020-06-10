package com.mtiarn.finance.model;

import android.content.ContentValues;
import android.os.Parcel;


import com.mtiarn.finance.DBHelper;
import com.mtiarn.finance.interfaces.IAbstractModel;

public class AccountsSetRef extends BaseModel implements IAbstractModel {
    private String mName;

    public AccountsSetRef() {
        super();
        this.mName = "";
    }

    public AccountsSetRef(long id) {
        super(id);
    }

    public AccountsSetRef(long id, String name) {
        setID(id);
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    @Override
    public ContentValues getCV() {
        ContentValues values = super.getCV();
        values.put(DBHelper.C_REF_ACCOUNTS_SETS_NAME, getName());
        return values;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.mName);
    }

    protected AccountsSetRef(Parcel in) {
        super(in);
        this.mName = in.readString();
    }

    public static final Creator<AccountsSetRef> CREATOR = new Creator<AccountsSetRef>() {
        @Override
        public AccountsSetRef createFromParcel(Parcel source) {
            return new AccountsSetRef(source);
        }

        @Override
        public AccountsSetRef[] newArray(int size) {
            return new AccountsSetRef[size];
        }
    };
}
