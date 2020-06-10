package com.mtiarn.finance.managers;

import android.content.Context;

import com.mtiarn.finance.dao.SendersDAO;
import com.mtiarn.finance.model.Sender;
import com.mtiarn.finance.model.Sms;

public class SmsManager {
    public static Sender getSender(Sms sms, Context context) {
        return SendersDAO.getInstance(context).getSenderByID(sms.getSenderId());
    }
}
