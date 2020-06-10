package com.mtiarn.finance.widgets;

import android.content.Context;
import android.util.AttributeSet;


import java.util.ArrayList;
import java.util.List;

public class SmsEditText extends android.support.v7.widget.AppCompatEditText {
    interface onSelectionChangedListener {
        void onSelectionChanged(int selStart, int selEnd);
    }


    private final List<onSelectionChangedListener> listeners;

    public SmsEditText(Context context) {
        super(context);
        listeners = new ArrayList<>();
    }

    public SmsEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        listeners = new ArrayList<>();
    }

    public SmsEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        listeners = new ArrayList<>();
    }

    protected void onSelectionChanged(int selStart, int selEnd) {
        if (listeners != null && listeners.size() > 0) {
            for (onSelectionChangedListener l : listeners) {
                if (l != null) {
                    l.onSelectionChanged(selStart, selEnd);
                }
            }
        }
    }
}