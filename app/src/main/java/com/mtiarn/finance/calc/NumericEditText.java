package com.mtiarn.finance.calc;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;

import org.apache.commons.lang3.StringUtils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class NumericEditText extends AppCompatEditText {
    private final char GROUPING_SEPARATOR = ' ';
    private final char DECIMAL_SEPARATOR = '.';
    private final String LEADING_ZERO_FILTER_REGEX = "^0+(?!$)";

    private String mDefaultText = null;
    private String mPreviousText = "";
    private String mNumberFilterRegex = "[^\\d\\-" + DECIMAL_SEPARATOR + "]";

    private char mDecimalSeparator = DECIMAL_SEPARATOR;
    private boolean hasCustomDecimalSeparator = false;
    private List<NumericValueWatcher> mNumericListeners = new ArrayList<>();
    private final TextWatcher mTextWatcher = new TextWatcher() {
        private boolean validateLock = false;

        @Override
        public void afterTextChanged(Editable s) {
            if (validateLock) {
                return;
            }


            if (StringUtils.countMatches(s.toString(), String.valueOf(mDecimalSeparator)) > 1) {
                validateLock = true;
                setText(mPreviousText); // cancel change and revert to previous input
                setSelection(mPreviousText.length());
                validateLock = false;
                return;
            }

            if (s.length() == 0) {
                handleNumericValueCleared();
                return;
            }

            setTextInternal(format(s.toString()));
            setSelection(getText().length());
            handleNumericValueChanged();
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // do nothing
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // do nothing
        }
    };

    public NumericEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        addTextChangedListener(mTextWatcher);
        setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // disable moving cursor
                setSelection(getText().length());
            }
        });
    }

    private void handleNumericValueCleared() {
        mPreviousText = "";
        for (NumericValueWatcher listener : mNumericListeners) {
            listener.onCleared();
        }
    }

    private void handleNumericValueChanged() {
        mPreviousText = getText().toString();
        for (NumericValueWatcher listener : mNumericListeners) {
            listener.onChanged(getNumericValue());
        }
    }


    public void addNumericValueChangedListener(NumericValueWatcher watcher) {
        mNumericListeners.add(watcher);
    }


    public void removeAllNumericValueChangedListeners() {
        while (!mNumericListeners.isEmpty()) {
            mNumericListeners.remove(0);
        }
    }


    public void setDefaultNumericValue(double defaultNumericValue, final String defaultNumericFormat) {
        mDefaultText = String.format(defaultNumericFormat, defaultNumericValue);
        if (hasCustomDecimalSeparator) {
            // swap locale decimal separator with custom one for display
            mDefaultText = StringUtils.replace(mDefaultText,
                    String.valueOf(DECIMAL_SEPARATOR), String.valueOf(mDecimalSeparator));
        }

        setTextInternal(mDefaultText);
    }


    public void setCustomDecimalSeparator(char customDecimalSeparator) {
        mDecimalSeparator = customDecimalSeparator;
        hasCustomDecimalSeparator = true;
        mNumberFilterRegex = "[^\\d\\" + mDecimalSeparator + "]";
    }


    public void clear() {
        setTextInternal(mDefaultText != null ? mDefaultText : "");
        if (mDefaultText != null) {
            handleNumericValueChanged();
        }
    }


    public double getNumericValue() {
        String original = getText().toString().replaceAll(mNumberFilterRegex, "");
        if (hasCustomDecimalSeparator) {
            // swap custom decimal separator with locale one to allow parsing
            original = StringUtils.replace(original,
                    String.valueOf(mDecimalSeparator), String.valueOf(DECIMAL_SEPARATOR));
        }

        try {
            return NumberFormat.getInstance().parse(original).doubleValue();
        } catch (ParseException e) {
            return Double.NaN;
        }
    }


    private String format(final String original) {
        final String[] parts = original.split("\\" + mDecimalSeparator, -1);
        String number = parts[0] // since we split with limit -1 there will always be at least 1 part
                .replaceAll(mNumberFilterRegex, "")
                .replaceFirst(LEADING_ZERO_FILTER_REGEX, "");

        // only add grouping separators for non custom decimal separator
        if (!hasCustomDecimalSeparator) {

            number = StringUtils.reverse(
                    StringUtils.reverse(number).replaceAll("(.{3})", "$1" + GROUPING_SEPARATOR));
            number = StringUtils.removeStart(number, String.valueOf(GROUPING_SEPARATOR));
        }

        // add fraction part if any
        if (parts.length > 1) {
            if (parts[1].length() > 4) {
                number += mDecimalSeparator + parts[1].substring(0, 3);
            } else {
                number += mDecimalSeparator + parts[1];
            }
        }

        return number;
    }

    private void setTextInternal(String text) {
        removeTextChangedListener(mTextWatcher);
        setText(text);
        addTextChangedListener(mTextWatcher);
    }

    interface NumericValueWatcher {

        void onChanged(double newValue);

        void onCleared();
    }
}