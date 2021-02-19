package com.dzk.mvp_mvvm.contract;

public class LoginContract {
   public interface ILoginView {
        void showLoading();
        void hideLoading();
        void loadSuccess();
        void loadError(String errMsg);
    }

    public interface ILoginPresenter {
       void attachView(ILoginView loginView);
       void onDetach();
       void login(String userName,String password);
       boolean isAttachView();
    }

    public interface ILoginModel {
       void login(String userName,String password,OnLoginFinishListener loginFinishListener);
    }

    public interface OnLoginFinishListener {
       void onLoginSuccess();
       void onLoginError(String errMsg);
    }

}
