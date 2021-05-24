package com.rgpro.megamall.presenters;

import androidx.annotation.NonNull;

import com.rgpro.megamall.contracts.SignUpContract.SignUpPresenterItf;
import com.rgpro.megamall.contracts.SignUpContract.SignUpViewItf;
import com.rgpro.megamall.models.BackEndInteractor;

public class SignUpPresenterImpl implements SignUpPresenterItf {
    private SignUpViewItf mViewItf ;

    public SignUpPresenterImpl(@NonNull  SignUpViewItf viewItf){
        this.mViewItf=viewItf ;
    }


    @Override
    public void RequestSignUp(String Username, String email, String password) {
        BackEndInteractor.getInstance().SignUp(this,Username,email,password);
    }

    @Override
    public void setResultMessage(String message) {
        mViewItf.resultMessage(message);
    }
}
