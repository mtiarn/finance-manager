package com.mtiarn.finance.fts;

import com.mtiarn.finance.model.ProductEntry;

import java.util.List;

public interface IDownloadProductsListener {
    public void onDownload(List<ProductEntry> productEntries, String payeeName);

    public void onAccepted();

    public void onFailure(String errorMessage, boolean tryAgain);
}
