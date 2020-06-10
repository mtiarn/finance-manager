package com.mtiarn.finance.model;

import android.content.ContentValues;
import android.os.Parcel;

import com.mtiarn.finance.DBHelper;
import com.mtiarn.finance.interfaces.IAbstractModel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transaction extends BaseModel implements IAbstractModel {
    public static final String TAG = "com.mtiarn.finance.Model.Transaction";

    public static final int TRANSACTION_TYPE_INCOME = 1;
    public static final int TRANSACTION_TYPE_EXPENSE = -1;
    public static final int TRANSACTION_TYPE_TRANSFER = 0;
    public static final int TRANSACTION_TYPE_UNDEFINED = -8;
    public static final Creator<Transaction> CREATOR = new Creator<Transaction>() {
        @Override
        public Transaction createFromParcel(Parcel source) {
            return new Transaction(source);
        }

        @Override
        public Transaction[] newArray(int size) {
            return new Transaction[size];
        }
    };
    public int headerPosition = 0;
    private Date mDateTime;
    private long mAccountID;
    private long mDestAccountID;
    private long mPayeeID;
    private long mCategoryID;
    private BigDecimal mAmount;
    private BigDecimal mFromAccountBalance;
    private BigDecimal mToAccountBalance;
    private long mProjectID;
    private long mSimpleDebtID;
    private long mDepartmentID;
    private long mLocationID;
    private double mLat;
    private double mLon;
    private int mAccuracy;
    private String mComment;
    private String mFile;
    private boolean mTransactionOpened = false;
    private BigDecimal mExchangeRate;
    private int mTransactionType;
    private boolean mSelected;
    private boolean mAutoCreated;
    private boolean isExRateEvalDisabled = false;
    private boolean isDayFirst = false;
    private boolean isDayLast = false;
    private long mFN;
    private long mFD;
    private long mFP;
    private List<ProductEntry> mProductEntries;

    public Transaction(long defaultDepartmentID) {
        super();
        this.mDateTime = new Date();
        this.mAccountID = -1;
        this.mPayeeID = -1;
        this.mCategoryID = -1;
        this.mAmount = BigDecimal.ZERO;
        this.mFromAccountBalance = BigDecimal.ZERO;
        this.mToAccountBalance = BigDecimal.ZERO;
        this.mExchangeRate = BigDecimal.ONE;
        this.mProjectID = -1;
        this.mSimpleDebtID = -1;
        this.mLocationID = -1;
        this.mComment = "";
        this.mFile = "";
        this.mDestAccountID = -1;
        this.mAutoCreated = false;
        this.mTransactionType = TRANSACTION_TYPE_EXPENSE;
        this.mLat = 0d;
        this.mLon = 0d;
        this.mAccuracy = -1;
        this.mSelected = false;
        this.mDepartmentID = defaultDepartmentID;
        this.mFN = 0;
        this.mFD = 0;
        this.mFP = 0;
        mProductEntries = new ArrayList<>();
    }

    public Transaction(Transaction src) {
        super();
        mDateTime = src.getDateTime();
        mAccountID = src.getAccountID();
        mPayeeID = src.getPayeeID();
        mCategoryID = src.getCategoryID();
        mAmount = src.getAmount().abs();
        mFromAccountBalance = src.getFromAccountBalance();
        mToAccountBalance = src.getToAccountBalance();
        mExchangeRate = new BigDecimal(src.getExchangeRate().doubleValue());
        mProjectID = src.getProjectID();
        mSimpleDebtID = src.getSimpleDebtID();
        mLocationID = src.getLocationID();
        mComment = src.getComment();
        mFile = src.getFile();
        mDestAccountID = src.getDestAccountID();
        mAutoCreated = src.isAutoCreated();
        mTransactionType = src.getTransactionType();
        mLat = src.getLat();
        mLon = src.getLon();
        mAccuracy = src.getAccuracy();
        mSelected = src.isSelected();
        mDepartmentID = src.mDepartmentID;
        mFN = src.mFN;
        mFD = src.mFD;
        mFP = src.mFP;
        mProductEntries = new ArrayList<>();
        for (ProductEntry entry : src.getProductEntries()) {
            mProductEntries.add(new ProductEntry(-1, entry.getProductID(), entry.getQuantity(), entry.getPrice(), entry.getCategoryID(), entry.getProjectID(), getID()));
        }
    }

    protected Transaction(Parcel in) {
        super(in);
        this.headerPosition = in.readInt();
        long tmpMDateTime = in.readLong();
        this.mDateTime = tmpMDateTime == -1 ? null : new Date(tmpMDateTime);
        this.mAccountID = in.readLong();
        this.mDestAccountID = in.readLong();
        this.mPayeeID = in.readLong();
        this.mCategoryID = in.readLong();
        this.mAmount = (BigDecimal) in.readSerializable();
        this.mFromAccountBalance = (BigDecimal) in.readSerializable();
        this.mToAccountBalance = (BigDecimal) in.readSerializable();
        this.mProjectID = in.readLong();
        this.mSimpleDebtID = in.readLong();
        this.mDepartmentID = in.readLong();
        this.mLocationID = in.readLong();
        this.mLat = in.readDouble();
        this.mLon = in.readDouble();
        this.mAccuracy = in.readInt();
        this.mComment = in.readString();
        this.mFile = in.readString();
        this.mTransactionOpened = in.readByte() != 0;
        this.mExchangeRate = (BigDecimal) in.readSerializable();
        this.mTransactionType = in.readInt();
        this.mSelected = in.readByte() != 0;
        this.mAutoCreated = in.readByte() != 0;
        this.isExRateEvalDisabled = in.readByte() != 0;
        this.isDayFirst = in.readByte() != 0;
        this.isDayLast = in.readByte() != 0;
        this.mFN = in.readLong();
        this.mFD = in.readLong();
        this.mFP = in.readLong();
        this.mProductEntries = in.createTypedArrayList(ProductEntry.CREATOR);
    }

    public BigDecimal getFromAccountBalance() {
        return mFromAccountBalance;
    }

    public void setFromAccountBalance(BigDecimal fromAccountBalance) {
        mFromAccountBalance = fromAccountBalance;
    }

    public BigDecimal getToAccountBalance() {
        return mToAccountBalance;
    }

    public void setToAccountBalance(BigDecimal toAccountBalance) {
        mToAccountBalance = toAccountBalance;
    }

    public long getDepartmentID() {
        return mDepartmentID;
    }

    public void setDepartmentID(long departmentID) {
        mDepartmentID = departmentID;
    }

    public long getCategoryID() {
        return mCategoryID;
    }

    public void setCategoryID(long mCategoryID) {
        this.mCategoryID = mCategoryID;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public long getID() {
        return super.getID();
    }

    public boolean isSelected() {
        return mSelected;
    }

    public void setSelected(boolean selected) {
        mSelected = selected;
    }

    public int getAccuracy() {
        return mAccuracy;
    }

    public void setAccuracy(int mAccuracy) {
        this.mAccuracy = mAccuracy;
    }

    public double getLat() {
        return mLat;
    }

    public void setLat(double mLat) {
        this.mLat = mLat;
    }

    public double getLon() {
        return mLon;
    }

    public void setLon(double mLon) {
        this.mLon = mLon;
    }

    public Date getDateTime() {
        return mDateTime;
    }

    public void setDateTime(Date mDateTime) {
        this.mDateTime = mDateTime;
    }

    public long getAccountID() {
        return mAccountID;
    }

    public void setAccountID(long mAccountID) {
        this.mAccountID = mAccountID;
    }

    public long getDestAccountID() {
        return mDestAccountID;
    }

    public void setDestAccountID(long mDestAccountID) {
        this.mDestAccountID = mDestAccountID;
    }

    public long getPayeeID() {
        return mPayeeID;
    }

    public void setPayeeID(long mPayeeID) {
        this.mPayeeID = mPayeeID;
    }

    public BigDecimal getAmount() {
        BigDecimal sign = (mTransactionType > 0) ? BigDecimal.ONE : BigDecimal.ONE.negate();
        return mAmount.multiply(sign);
    }

    public void setAmount(BigDecimal mAmount, int transactionType) {
        this.mAmount = mAmount.abs();
        if (transactionType != TRANSACTION_TYPE_UNDEFINED) {
            this.mTransactionType = transactionType;
        } else {
            if (mDestAccountID >= 0) {
                mTransactionType = TRANSACTION_TYPE_TRANSFER;
            } else {
                mTransactionType = (mAmount.compareTo(BigDecimal.ZERO) < 0) ? TRANSACTION_TYPE_EXPENSE : TRANSACTION_TYPE_INCOME;
            }
        }
    }

    public long getProjectID() {
        return mProjectID;
    }

    public void setProjectID(long mProjectID) {
        this.mProjectID = mProjectID;
    }

    public long getSimpleDebtID() {
        return mSimpleDebtID;
    }

    public void setSimpleDebtID(long simpleDebtID) {
        mSimpleDebtID = simpleDebtID;
    }

    public long getLocationID() {
        return mLocationID;
    }

    public void setLocationID(long mLocationID) {
        this.mLocationID = mLocationID;
    }

    public boolean hasLocation() {
        return mLocationID >= 0 || (mLat + mLon) != 0;
    }

    public String getComment() {
        if (mComment != null) {
            return mComment;
        } else {
            mComment = "";
            return mComment;
        }
    }

    public void setComment(String mComment) {
        this.mComment = mComment;
    }

    public String getFile() {
        return mFile;
    }

    public void setFile(String mFile) {
        this.mFile = mFile;
    }

    public boolean isAutoCreated() {
        return mAutoCreated;
    }

    public void setAutoCreated(boolean mAutoCreated) {
        this.mAutoCreated = mAutoCreated;
    }

    public BigDecimal getExchangeRate() {
        return mExchangeRate;
    }

    public void setExchangeRate(BigDecimal mExchangeRate) {
        this.mExchangeRate = mExchangeRate.abs();
    }

    public int getTransactionType() {
        if (mTransactionType == TRANSACTION_TYPE_UNDEFINED) {
            if (getDestAccountID() >= 0) {
                mTransactionType = TRANSACTION_TYPE_TRANSFER;
            } else {
                if (mAmount.compareTo(BigDecimal.ZERO) <= 0) {
                    mTransactionType = TRANSACTION_TYPE_EXPENSE;
                } else {
                    mTransactionType = TRANSACTION_TYPE_INCOME;
                }
            }
        }
        return mTransactionType;
    }

    public void setTransactionType(int mTransactionType) {
        this.mTransactionType = mTransactionType;
    }

    public boolean getAmountSign() {
        return mTransactionType > 0;
    }

    public boolean isTransactionOpened() {
        return mTransactionOpened;
    }

    public void setTransactionOpened(boolean mTransactionOpened) {
        this.mTransactionOpened = mTransactionOpened;
    }

    public List<ProductEntry> getProductEntries() {
        return mProductEntries;
    }

    public void setProductEntries(List<ProductEntry> productEntries) {
        mProductEntries = productEntries;
    }

    public BigDecimal getResidue() {
        if (getProductEntries().isEmpty()) return BigDecimal.ZERO;
        BigDecimal residue = new BigDecimal(getAmount().doubleValue()).setScale(2, RoundingMode.HALF_UP);
        for (ProductEntry entry : mProductEntries) {
            residue = residue.subtract((entry.getPrice().multiply(entry.getQuantity())).setScale(2, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP);
        }
        return residue;
    }

    @Override
    public String getSearchString() {
        return "";
    }

    public boolean isValidToAutoCreate() {
        boolean ok;
        ok = (getAccountID() > 0);
        if (getTransactionType() == TRANSACTION_TYPE_TRANSFER) {
            ok = ok & (getDestAccountID() > 0);
        } else {
            ok = ok & (getPayeeID() > 0);
            ok = ok & (getCategoryID() > 0);
        }
        ok = ok & (getAmount().compareTo(BigDecimal.ZERO) != 0);
        return ok;
    }

    @Override
    public ContentValues getCV() {
        ContentValues values = super.getCV();

        values.put(DBHelper.C_LOG_TRANSACTIONS_DATETIME, getDateTime().getTime());
        values.put(DBHelper.C_LOG_TRANSACTIONS_SRCACCOUNT, getAccountID());
        values.put(DBHelper.C_LOG_TRANSACTIONS_PAYEE, getPayeeID());
        values.put(DBHelper.C_LOG_TRANSACTIONS_CATEGORY, getCategoryID());
        values.put(DBHelper.C_LOG_TRANSACTIONS_AMOUNT, getAmount().doubleValue());
        values.put(DBHelper.C_LOG_TRANSACTIONS_EXCHANGERATE, getExchangeRate().doubleValue());
        values.put(DBHelper.C_LOG_TRANSACTIONS_PROJECT, getProjectID());
        values.put(DBHelper.C_LOG_TRANSACTIONS_SIMPLEDEBT, getSimpleDebtID());
        values.put(DBHelper.C_LOG_TRANSACTIONS_DEPARTMENT, getDepartmentID());
        values.put(DBHelper.C_LOG_TRANSACTIONS_LOCATION, getLocationID());
        values.put(DBHelper.C_LOG_TRANSACTIONS_COMMENT, getComment());
        values.put(DBHelper.C_LOG_TRANSACTIONS_FILE, getFile());
        values.put(DBHelper.C_LOG_TRANSACTIONS_DESTACCOUNT, getDestAccountID());
        values.put(DBHelper.C_LOG_TRANSACTIONS_AUTOCREATED, isAutoCreated() ? 1 : 0);
        values.put(DBHelper.C_LOG_TRANSACTIONS_LAT, getLat());
        values.put(DBHelper.C_LOG_TRANSACTIONS_LON, getLon());
        values.put(DBHelper.C_LOG_TRANSACTIONS_ACCURACY, getAccuracy());
        values.put(DBHelper.C_LOG_TRANSACTIONS_FN, getFN());
        values.put(DBHelper.C_LOG_TRANSACTIONS_FD, getFD());
        values.put(DBHelper.C_LOG_TRANSACTIONS_FP, getFP());
        values.put(DBHelper.C_LOG_TRANSACTIONS_SPLIT, getProductEntries().size() == 0 ? 0 : 1);
        return values;
    }

    @Override
    public String getLogTransactionsField() {
        return null;
    }

    public void setDayFirst(boolean dayFirst) {
        isDayFirst = dayFirst;
    }

    public boolean isDayLast() {
        return isDayLast;
    }

    public void setDayLast(boolean dayLast) {
        isDayLast = dayLast;
    }

    public long getFN() {
        return mFN;
    }

    public void setFN(long FN) {
        mFN = FN;
    }

    public long getFD() {
        return mFD;
    }

    public void setFD(long FD) {
        mFD = FD;
    }

    public long getFP() {
        return mFP;
    }

    public void setFP(long FP) {
        mFP = FP;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.headerPosition);
        dest.writeLong(this.mDateTime != null ? this.mDateTime.getTime() : -1);
        dest.writeLong(this.mAccountID);
        dest.writeLong(this.mDestAccountID);
        dest.writeLong(this.mPayeeID);
        dest.writeLong(this.mCategoryID);
        dest.writeSerializable(this.mAmount);
        dest.writeSerializable(this.mFromAccountBalance);
        dest.writeSerializable(this.mToAccountBalance);
        dest.writeLong(this.mProjectID);
        dest.writeLong(this.mSimpleDebtID);
        dest.writeLong(this.mDepartmentID);
        dest.writeLong(this.mLocationID);
        dest.writeDouble(this.mLat);
        dest.writeDouble(this.mLon);
        dest.writeInt(this.mAccuracy);
        dest.writeString(this.mComment);
        dest.writeString(this.mFile);
        dest.writeByte(this.mTransactionOpened ? (byte) 1 : (byte) 0);
        dest.writeSerializable(this.mExchangeRate);
        dest.writeInt(this.mTransactionType);
        dest.writeByte(this.mSelected ? (byte) 1 : (byte) 0);
        dest.writeByte(this.mAutoCreated ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isExRateEvalDisabled ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isDayFirst ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isDayLast ? (byte) 1 : (byte) 0);
        dest.writeLong(this.mFN);
        dest.writeLong(this.mFD);
        dest.writeLong(this.mFP);
        dest.writeTypedList(this.mProductEntries);
    }
}
