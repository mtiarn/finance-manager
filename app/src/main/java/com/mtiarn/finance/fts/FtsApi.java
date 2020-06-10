package com.mtiarn.finance.fts;

import com.mtiarn.finance.fts.models.FtsResponse;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

public interface FtsApi {
    @GET
    Single<Response<FtsResponse>> getData(
            @Url String url,
            @Header("Authorization") String authorization,
            @Header("User-Agent") String userAgent,
            @Header("Device-Id") String deviceID,
            @Header("Device-OS") String deviceOS,
            @Header("Version") String version,
            @Header("ClientVersion") String clientVersion,
            @Header("Host") String host,
            @Header("Connection") String connection
    );
}
