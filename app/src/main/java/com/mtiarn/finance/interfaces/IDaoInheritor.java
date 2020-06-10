package com.mtiarn.finance.interfaces;

import android.database.Cursor;

public interface IDaoInheritor {
    IAbstractModel cursorToModel(Cursor cursor);
}
