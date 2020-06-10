package com.mtiarn.finance.interfaces;

public interface IOnUnzipComplete {
    void onComplete();

    void onError();

    void onWrongPassword();
}
