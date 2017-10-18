package com.devdream.cookall.core.dto;

public class UserAuthDTO {

    private String token;
    private String email;
    private String password;

    public UserAuthDTO(final String _email, final String _password) {
        email = _email;
        password = _password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
