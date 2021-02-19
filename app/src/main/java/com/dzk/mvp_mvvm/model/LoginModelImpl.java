package com.dzk.mvp_mvvm.model;

import com.dzk.mvp_mvvm.api.LoginClient;
import com.dzk.mvp_mvvm.contract.LoginContract;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class LoginModelImpl implements LoginContract.ILoginModel {
    public LoginModelImpl() {

    }

    @Override
    public void login(String userName, String password, final LoginContract.OnLoginFinishListener loginFinishListener) {
        //这里可以使用Retrofit来进行网络请求
        LoginClient.getService().login(userName, password)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())//切换到主线程
                .subscribe(new Observer<Response>(){

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Response response) {
                        if (response.isSuccessful()){
                            loginFinishListener.onLoginSuccess();
                        }else {
                            loginFinishListener.onLoginError(response.message());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (null != loginFinishListener){
                            loginFinishListener.onLoginError(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
