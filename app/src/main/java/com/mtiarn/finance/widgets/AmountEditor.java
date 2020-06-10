package com.mtiarn.finance.widgets;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import android.util.Log;
import com.mtiarn.finance.FgConst;
import com.mtiarn.finance.R;
import com.mtiarn.finance.calc.CalculatorBuilder;
import com.mtiarn.finance.dao.CabbagesDAO;
import com.mtiarn.finance.model.Cabbage;
import com.mtiarn.finance.model.Events;
import com.mtiarn.finance.receivers.CalcReciever;
import com.mtiarn.finance.utils.AmountColorizer;
import com.mtiarn.finance.utils.NumberTextWatcher;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AmountEditor extends LinearLayout {

//    private static final String TAG = "AmountEditor";

    public OnAmountChangeListener mOnAmountChangeListener;
    public OnCabbageChangeListener mOnCabbageChangeListener;
    @BindView(R.id.imagebutton_amount_sign)
    public ImageButton btnAmountSign;
    @BindView(R.id.edittext_amount)
    EditText edAmount;
    @BindView(R.id.imageButtonCalc)
    ImageButton btnCalc;
    @BindView(R.id.editTextCabbage)
    EditText spinnerCabbage;
    @BindView(R.id.textInputLayoutCabbage)
    TextInputLayout mTextInputLayoutCabbage;
    @BindView(R.id.textInputLayoutAmount)
    TextInputLayout mTextInputLayoutAmount;
    private boolean mAllowChangeCabbage = true;
    private int type;
    private int scale;
    private Activity activity;
    private boolean lockType;
    private Cabbage cabbage;
    private AmountColorizer mAmountColorizer;

    public AmountEditor(Context context, OnAmountChangeListener onAmountChangeListener, int type, int scale, Activity activity) {
        super(context);
        this.mOnAmountChangeListener = onAmountChangeListener;
        this.type = type;
        this.scale = scale;
        this.activity = activity;
        mAmountColorizer = new AmountColorizer(activity);
        init(context);
    }

    public void setOnCabbageChangeListener(OnCabbageChangeListener onCabbageChangeListener) {
        mOnCabbageChangeListener = onCabbageChangeListener;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        EventBus.getDefault().register(this);
//        setFocus();
    }

    @Override
    protected void onDetachedFromWindow() {
        EventBus.getDefault().unregister(this);
        super.onDetachedFromWindow();
    }

    public AmountEditor(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void setmAllowChangeCabbage(boolean mAllowChangeCabbage) {
        this.mAllowChangeCabbage = mAllowChangeCabbage;
    }

    public Cabbage getCabbage() {
        return cabbage;
    }

    public void showCabbageError() {
        //getString(R.string.err_specify_account_currency)
        mTextInputLayoutCabbage.setErrorEnabled(true);
        mTextInputLayoutCabbage.setError(activity.getString(R.string.err_specify_currency));
    }

    @SuppressWarnings("unchecked")
    public void setCabbage(Cabbage inCabbage) {
        cabbage = inCabbage;
        mTextInputLayoutCabbage.setVisibility(VISIBLE);
        spinnerCabbage.setText(inCabbage.toString());
        if (mOnCabbageChangeListener != null) {
            mOnCabbageChangeListener.OnCabbageChange(inCabbage);
        }

        if (mAllowChangeCabbage) {
            spinnerCabbage.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    String caption = activity.getString(R.string.ent_currency);

                    final ArrayAdapter<Cabbage> arrayAdapterCabbages = new ArrayAdapter<>(activity, android.R.layout.select_dialog_singlechoice);
                    CabbagesDAO cabbagesDAO = CabbagesDAO.getInstance(activity);
                    List<Cabbage> cabbages;
                    try {
                        cabbages = (List<Cabbage>) cabbagesDAO.getAllModels();
                    } catch (Exception e) {
                        cabbages = new ArrayList<>();
                    }

                    int index = -1;
                    for (int i = 0; i < cabbages.size(); i++) {
                        if (cabbages.get(i).getID() == cabbage.getID()) {
                            index = i;
                            break;
                        }
                    }

                    arrayAdapterCabbages.addAll(cabbages);

                    android.support.v7.app.AlertDialog.Builder builderSingle = new android.support.v7.app.AlertDialog.Builder(activity);
                    builderSingle.setSingleChoiceItems(arrayAdapterCabbages, index,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(final DialogInterface dialog, final int which) {
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            dialog.cancel();
                                            ListView lw = ((android.support.v7.app.AlertDialog) dialog).getListView();
                                            Cabbage cabbage = (Cabbage) lw.getAdapter().getItem(which);
                                            setCabbage(cabbage);
                                        }
                                    }, 200);

                                }
                            });
                    builderSingle.setTitle(caption);

                    builderSingle.setNegativeButton(
                            getResources().getString(android.R.string.cancel),
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    builderSingle.show();
                }
            });
        }
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(Events.EventOnChangeCabbageInAmountEditor event) {
        AmountEditor.this.setCabbage(event.getCabbage());
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        if (!lockType) {
            this.type = type;
        }
        setBtnAmountIcon();
    }

    public void setLockType(boolean lockType) {
        this.lockType = lockType;
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        Log.d("Amount Editor", "onSaveInstanceState " + String.valueOf(getId()));
        ss.state = new AmountState(scale, type, edAmount.getText().toString());
        return ss;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setFocus() {
//        edAmountCents.requestFocus();
        edAmount.requestFocus();
        edAmount.selectAll();
    }

    private void init(final Context context) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.widget_amount_edit, null);
        this.addView(view);
        ButterKnife.bind(this);
        scale = 2;

        mAmountColorizer = new AmountColorizer(context);
        mTextInputLayoutCabbage.setVisibility(GONE);

        TextWatcher textWatcher = new TextWatcher() {
            private String current = "";

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("TC", "beforeTC " + s.toString() + " "
                        + s.subSequence(start, start + count).toString());
                if (!s.toString().equals(current)) {
                    current = s.toString();

                    if (mOnAmountChangeListener != null) {
                        mOnAmountChangeListener.OnAmountChange(getAmount(), type);
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i("TC", "beforeTC " + s.toString() + " "
                    + s.subSequence(start, start + count).toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i("TC", "afterTC " + s.toString());
            }
        };
        edAmount.addTextChangedListener(textWatcher);
        edAmount.addTextChangedListener(new NumberTextWatcher(edAmount, textWatcher));

        edAmount.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus & activity != null) {
                    final InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                    edAmount.selectAll();
                    edAmount.postDelayed(
                            new Runnable() {
                                @Override
                                public void run() {
                                    if (imm != null) {
                                        imm.showSoftInput(edAmount, 0);
                                    }
                                }
                            } , 100);
                }
            }
        });

        btnAmountSign.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type != 0) {
                    AmountEditor.this.setType(type * -1);
                    mOnAmountChangeListener.OnAmountChange(AmountEditor.this.getAmount(), type);
                }
            }
        });
    }

    public BigDecimal getAmount() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        symbols.setGroupingSeparator(' ');
        DecimalFormat df = new DecimalFormat("#,###.##");
        df.setDecimalSeparatorAlwaysShown(true);
        df.setDecimalFormatSymbols(symbols);
        df.setParseBigDecimal(true);
        try {
            String s = edAmount.getText().toString();
            if (s.equals("")) {
                s = "0";
            }
            return ((BigDecimal) df.parse(s.replaceAll(" ", ""))).setScale(2, RoundingMode.HALF_UP);
        } catch (NumberFormatException | ParseException nfe) {
            return BigDecimal.ZERO;
        }
    }

    public void setAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) != 0) {
//            String amountvalue = amount.abs().setScale(scale, RoundingMode.HALF_EVEN).toString();
            edAmount.setText(amount.abs().toString());
        } else {
            edAmount.setText("");
        }
        setBtnAmountIcon();
    }

    private void setBtnAmountIcon() {
        if (mAmountColorizer != null) {
            btnAmountSign.setImageDrawable(mAmountColorizer.getTransactionIcon(type));
        }
    }

    public void setHint(String hint) {
//        edAmount.setHint("");
        mTextInputLayoutAmount.setHint(hint);
    }

    @OnClick(R.id.imageButtonCalc)
    void onCalculatorClick() {
        CalcReciever receiver = new CalcReciever(this, activity);
        activity.registerReceiver(receiver, new IntentFilter(FgConst.ACT_CALC_DONE));
        new CalculatorBuilder()
                .withTitle("calc")
                .withValue(getAmount().toString())
                .start(activity);
    }

    public interface OnAmountChangeListener {
        void OnAmountChange(BigDecimal newAmount, int newType);
    }

    public interface OnCabbageChangeListener {
        void OnCabbageChange(Cabbage cabbage);
    }

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR
                = new Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        AmountState state;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            state = in.readParcelable(AmountState.class.getClassLoader());
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeParcelable(state, flags);
        }
    }

    private static class AmountState implements Parcelable {
        public static final Creator<AmountState> CREATOR = new Creator<AmountState>() {
            public AmountState createFromParcel(Parcel source) {
                return new AmountState(source);
            }

            public AmountState[] newArray(int size) {
                return new AmountState[size];
            }
        };
        final int scale;
        final int type;
        final String amount;

        AmountState(int scale, int type, String amount) {
            this.scale = scale;
            this.type = type;
            this.amount = amount;

        }

        AmountState(Parcel in) {
            this.scale = in.readInt();
            this.type = in.readInt();
            this.amount = in.readString();
        }

        public int getType() {
            return type;
        }

        public String getAmount() {
            return amount;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.scale);
            dest.writeInt(this.type);
            dest.writeString(this.amount);
        }
    }

}
