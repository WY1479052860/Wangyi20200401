package com.bawei.wangyi20200401.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bawei.wangyi20200401.R;

public abstract class BaseActivity<P extends BasePersenter> extends AppCompatActivity implements IBaseView {
   P presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        presenter=initPresenter();

        initView();
        iniData();
    }

    protected abstract P initPresenter();

    public P getPresenter() {
        return presenter;
    }

    protected abstract int getLayout();
    protected abstract void initView();
    protected abstract void iniData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.datchView();
            presenter=null;
        }
    }
}
