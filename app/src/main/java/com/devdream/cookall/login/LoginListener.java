package com.devdream.cookall.login;

import com.devdream.cookall.core.listeners.NetworkListener;

interface LoginListener extends NetworkListener {

    void startLoginProcess();
    void successLoginProcess();
    void errorLoginProcess();

}
