package com.allever.social.network.impl;

import android.util.Log;

import com.allever.social.network.NetResponse;
import com.allever.social.network.NetService;
import com.allever.social.network.listener.NetCallback;
import com.allever.social.network.util.OkhttpUtil;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class OkHttpService implements NetService{

    private static final String TAG = "OkHttpService";

    @Override
    public void login(String username, String password, final NetCallback netCallback) {
        OkhttpUtil.getIns().login(username, password, new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                netCallback.onFail(e.getMessage());
            }

            @Override
            public void onResponse(Response response) throws IOException {
                NetResponse netResponse = new NetResponse();
                netResponse.setString(response.body().string());
                netCallback.onSuccess(netResponse);
            }
        });
    }

    @Override
    public void autoLogin(final NetCallback netCallback) {
        Log.d(TAG, "autoLogin: ");
        OkhttpUtil.getIns().autoLogin(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                netCallback.onFail(e.getMessage());
            }

            @Override
            public void onResponse(Response response) throws IOException {
                NetResponse netResponse = new NetResponse();
                netResponse.setString(response.body().string());
                netCallback.onSuccess(netResponse);
            }
        });
    }
}
