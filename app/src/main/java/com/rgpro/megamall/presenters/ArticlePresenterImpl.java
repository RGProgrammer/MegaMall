package com.rgpro.megamall.presenters;

import android.os.Bundle;
import androidx.annotation.NonNull;

import com.rgpro.megamall.contracts.ArticleContract.ArticleViewItf;
import com.rgpro.megamall.contracts.ArticleContract.ArticlePresenterItf;
import com.rgpro.megamall.models.AccountData;
import com.rgpro.megamall.models.ArticleReview;
import com.rgpro.megamall.models.BackEndInteractor;

public class ArticlePresenterImpl implements ArticlePresenterItf {

    private ArticleViewItf mViewItf ;

    public ArticlePresenterImpl(@NonNull ArticleViewItf viewItf) {
        this.mViewItf=viewItf ;
    }


    @Override
    public void getArticlePageDetails(String id) {
        BackEndInteractor.getInstance().GetArticleData(this,id);
    }

    @Override
    public void getArticlePageReviews(String id) {
        BackEndInteractor.getInstance().GetArticleReviews(this,id ) ;
    }

    @Override
    public void submitComment(String articleid, ArticleReview review) {
        BackEndInteractor.getInstance().AddReviewOnArticle(this,articleid,review);

    }

    @Override
    public AccountData getMyAccountData() {
        return BackEndInteractor.getInstance().getAccountData();
    }

    @Override
    public void showOrHideConfigButtons(String boutiqueid) {

        if(BackEndInteractor.getInstance().isCurrentUserBoutique(boutiqueid)){
            mViewItf.showArticleConfigButton(true);
        }else{
            mViewItf.showArticleConfigButton(false);
        }
    }

    @Override
    public void dealWithIt(Bundle input) {
        this.mViewItf.dealWithIt(input);
    }

    @Override
    public void dealWithIt(Object input) {
        this.mViewItf.dealWithIt(input);
    }
}