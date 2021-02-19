package com.dzk.mvp_mvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dzk.mvp_mvvm.contract.LoginContract;
import com.dzk.mvp_mvvm.presenter.LoginPresenterIMpl;

public class MainActivity extends AppCompatActivity implements LoginContract.ILoginView {
    private EditText et_userName;
    private EditText et_password;
    private ProgressBar progress_bar;
    private LoginContract.ILoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new LoginPresenterIMpl();
        presenter.attachView(this);
        et_userName = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        progress_bar = findViewById(R.id.progress_bar);
    }

    @Override
    public void showLoading() {
        //显示加载条
    }

    @Override
    public void hideLoading() {
        //隐藏加载条
    }

    @Override
    public void loadSuccess() {
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadError(String errMsg) {
        Toast.makeText(this,"登录失败: " + errMsg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }

    public void login(View view) {
        presenter.login(et_userName.getText().toString(),et_password.getText().toString());
    }
}