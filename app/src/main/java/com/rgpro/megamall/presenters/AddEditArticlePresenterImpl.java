package com.rgpro.megamall.presenters;

import android.os.Bundle;
import androidx.annotation.NonNull;

import com.rgpro.megamall.contracts.AddEditArticleContract.AddEditArticleViewItf;
import com.rgpro.megamall.contracts.AddEditArticleContract.AddEditArticlePresenterItf;
import com.rgpro.megamall.models.BackEndInteractor;

public class AddEditArticlePresenterImpl implements AddEditArticlePresenterItf {
    private AddEditArticleViewItf mViewItf ;

    public AddEditArticlePresenterImpl(@NonNull AddEditArticleViewItf viewItf) {
        this.mViewItf = viewItf;
    }

    @Override
    public void SetArticleData(Bundle article,boolean newArticle) {
        BackEndInteractor.getInstance().SetArticleData(this,article,newArticle);

    }

    @Override
    public void GetArticleData(String articleid) {
        BackEndInteractor.getInstance().GetArticleData(this,articleid) ;
    }

    @Override
    public void requestDeleteArticle(String articleID) {
        BackEndInteractor.getInstance().deleteArticle(this,articleID) ;
    }

    @Override
    public void dealWithIt(Bundle input) {
       mViewItf.dealWithIt(input);
    }

    @Override
    public void dealWithIt(Object input) {
        this.mViewItf.dealWithIt(input);
    }
}
