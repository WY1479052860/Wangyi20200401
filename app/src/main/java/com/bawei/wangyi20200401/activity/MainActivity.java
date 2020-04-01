package com.bawei.wangyi20200401.activity;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.wangyi20200401.R;
import com.bawei.wangyi20200401.base.BaseActivity;
import com.bawei.wangyi20200401.base.BasePersenter;
import com.bawei.wangyi20200401.bean.LoginBean;
import com.bawei.wangyi20200401.contract.LogiContract;
import com.bawei.wangyi20200401.presenter.LoginPresenter;

public class MainActivity extends BaseActivity implements LogiContract.IView {


    private EditText et_name,et_pwd;
    private Button bt;

    @Override
    protected BasePersenter initPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        et_name = findViewById(R.id.et_name);
        et_pwd = findViewById(R.id.et_pwd);
        bt = findViewById(R.id.bt);

    }

    @Override
    protected void iniData() {
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = et_name.getText().toString();
                String pwd = et_pwd.getText().toString();
                BasePersenter presenter = getPresenter();
                if(presenter instanceof LoginPresenter){
                    ((LoginPresenter) presenter).Login(phone,pwd);
                }

            }
        });

    }

    @Override
    public void LoginShopSuccess(LoginBean bean) {
        String message = bean.getMessage();
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void LoginShopFailure(String str) {

    }
}
