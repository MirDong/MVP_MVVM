package com.dzk.mvp_mvvm.presenter;

import com.dzk.mvp_mvvm.contract.LoginContract;
import com.dzk.mvp_mvvm.model.LoginModelImpl;

public class LoginPresenterIMpl implements LoginContract.ILoginPresenter, LoginContract.OnLoginFinishListener {
    private LoginContract.ILoginView mLoginView;
    private LoginContract.ILoginModel mLoginModel;
    @Override
    public void attachView(LoginContract.ILoginView loginView) {
        this.mLoginView = loginView;
        this.mLoginModel = new LoginModelImpl();
    }

    @Override
    public void onDetach() {
        this.mLoginView = null;
    }

    @Override
    public void login(String userName, String password) {
            if (mLoginView != null){
                mLoginView.showLoading();
            }
            mLoginModel.login(userName,password,this);
    }

    @Override
    public boolean isAttachView() {
        return this.mLoginView != null;
    }

    @Override
    public void onLoginSuccess() {
        if (isAttachView()){
            mLoginView.hideLoading();
            mLoginView.loadSuccess();
        }
    }

    @Override
    public void onLoginError(String errMsg) {
        if (isAttachView()){
            mLoginView.hideLoading();
            mLoginView.loadError(errMsg);
        }
    }
}
