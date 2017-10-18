package com.devdream.cookall.core.api.responses;

import com.google.gson.annotations.SerializedName;

public class LoginAuthResponse extends BaseResponse<LoginAuthResponse> {

    @SerializedName("id")
    private String token;

    @SerializedName("userId")
    private int userId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
