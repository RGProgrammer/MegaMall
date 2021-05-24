package com.rgpro.megamall.contracts;

import com.rgpro.megamall.models.AccountData;

public class LoginContract {
    public interface LoginViewItf {
        void initLoginScreen();
        void showErrorMessage(String Message);
        void showNavigationActivity();
    }
    public  interface LoginPresenterItf {
        void checkLoginData(String username, String password);
        void showErrorMessage(String Message);
        void Login(AccountData data);
    }
}
