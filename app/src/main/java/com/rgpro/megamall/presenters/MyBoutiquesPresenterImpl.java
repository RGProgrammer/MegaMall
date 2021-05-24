package com.rgpro.megamall.presenters;

import android.os.Bundle;
import androidx.annotation.NonNull;

import com.rgpro.megamall.contracts.MyBoutiquesContract.MyBouttiquesViewItf;
import com.rgpro.megamall.contracts.MyBoutiquesContract.MyBoutiquesPresenterItf;
import com.rgpro.megamall.models.BackEndInteractor;

public class MyBoutiquesPresenterImpl implements MyBoutiquesPresenterItf {
    private MyBouttiquesViewItf mViewItf ;
    public MyBoutiquesPresenterImpl(@NonNull MyBouttiquesViewItf viewItf){
        this.mViewItf=viewItf ;
    }

    @Override
    public void getMyBoutiquesList() {
        BackEndInteractor.getInstance().getBoutiquesByUserId(this,BackEndInteractor.getInstance().getAccountData().getId());
    }

    @Override
    public void dealWithIt(Bundle input) {
        //nothing here
    }

    @Override
    public void dealWithIt(Object input) {
        this.mViewItf.dealWithIt(input);

    }
}
