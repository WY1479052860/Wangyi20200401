package com.bawei.wangyi20200401.model;

import com.bawei.wangyi20200401.bean.LoginBean;
import com.bawei.wangyi20200401.contract.LogiContract;
import com.bawei.wangyi20200401.utils.NetUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 登录的m层
 */
public class LoginModel implements LogiContract.IModel {

    @Override
    public void Login(String phone, String pwd, final IModelCallBack callBack) {
        NetUtils.getInstance().getApis().dologin(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean bean) {
                        if(callBack!=null){
                            callBack.LoginShopSuccess(bean);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        if(callBack!=null){
                            callBack.LoginShopFailure(e.getMessage());
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
