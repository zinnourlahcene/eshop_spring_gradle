package com.lahcenezinnour.util;

/**
 * Created by lahcen on 6/4/17.
 */
public class Login {
    private Boolean login;
    private String message;

    public Login() {
    }

    public Login(Boolean login, String message) {
        this.login = login;
        this.message = message;
    }

    public Boolean getLogin() {
        return login;
    }

    public void setLogin(Boolean login) {
        this.login = login;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
