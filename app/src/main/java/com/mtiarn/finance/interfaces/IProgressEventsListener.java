package com.mtiarn.finance.interfaces;

public interface IProgressEventsListener {


    int CODE_OK = 0;
    int CODE_ERROR = 1;

    void onProgressChange(int progress);
    void onOperationComplete(int code);
    void onOperationComplete(int code, int[] stats);
}
