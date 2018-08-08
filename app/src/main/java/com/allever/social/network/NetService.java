package com.allever.social.network;


import com.allever.social.network.listener.NetCallback;

public interface NetService {
    void login(String username, String password, NetCallback netCallback);
    void autoLogin(NetCallback netCallback);
    void getUserList(String requestPage, NetCallback netCallback);
    void pullRefreshUser(NetCallback netCallback);
}
