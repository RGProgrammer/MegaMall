package com.rgpro.megamall.presenters;

import android.net.Uri;

import androidx.annotation.NonNull;

import com.rgpro.megamall.contracts.AccountContract.AccountViewItf;
import com.rgpro.megamall.contracts.AccountContract.AccountPresenterItf;
import com.rgpro.megamall.models.AccountData;
import com.rgpro.megamall.models.BackEndInteractor;

public class AccountPresenterImpl implements AccountPresenterItf {
    private AccountViewItf mViewItf ;

    public AccountPresenterImpl(@NonNull AccountViewItf mViewItf) {
        this.mViewItf = mViewItf;
    }

    @Override
    public void getAccountData() {
        mViewItf.showAccountData(BackEndInteractor.getInstance().getAccountData());
    }

    @Override
    public void UpdatePassword(String oldpassword, String newpassword, String confirmpassword) {
        AccountData data = BackEndInteractor.getInstance().getAccountData();
        if(!oldpassword.equals(data.getPassword())){
            mViewItf.showMessage("Wrong password entered");
            return;
        }
        if(!newpassword.equals(confirmpassword)){
            mViewItf.showMessage("New password and confirm password are not the same");
            return ;
        }
        AccountData newdata = new AccountData(data.getId(),data.getUsername(),
                newpassword,//the new change
                data.getEmail(),
                data.getFirstname(),
                data.getLastName(),
                data.getAdresse(),
                data.getIconUrl(),
                data.getPhoneNumber());
    }

    @Override
    public void UpdatePersonalInfo(String firstName, String lastname, String adresse, String phonenumber) {
        AccountData data = BackEndInteractor.getInstance().getAccountData();
        AccountData newData = new AccountData(data);
        newData.setFirstname(firstName);
        newData.setFirstname(lastname);
        newData.setFirstname(adresse);
        newData.setFirstname(phonenumber);
        BackEndInteractor.getInstance().UpdateAccoutData(this,newData);
    }

    @Override
    public void NotifyView(String message) {
        mViewItf.showMessage(message);
    }

    @Override
    public void UpdateUserProfilPic(Uri uri) {

    }

}
