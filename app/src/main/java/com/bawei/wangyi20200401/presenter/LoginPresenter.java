package com.bawei.wangyi20200401.presenter;

import com.bawei.wangyi20200401.base.BasePersenter;
import com.bawei.wangyi20200401.base.IBaseView;
import com.bawei.wangyi20200401.bean.LoginBean;
import com.bawei.wangyi20200401.contract.LogiContract;
import com.bawei.wangyi20200401.model.LoginModel;

public class LoginPresenter extends BasePersenter implements LogiContract.IPresenter {

    private LoginModel model;

    public LoginPresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    @Override
    protected void initModel() {
        model = new LoginModel();

    }

    @Override
    public void Login(String phone, String pwd) {
        model.Login(phone, pwd, new LogiContract.IModel.IModelCallBack() {
            @Override
            public void LoginShopSuccess(LoginBean bean) {
                IBaseView view = getView();
                if(view instanceof LogiContract.IView){
                    ((LogiContract.IView) view).LoginShopSuccess(bean);
                }
            }

            @Override
            public void LoginShopFailure(String str) {
                IBaseView view = getView();
                if(view instanceof LogiContract.IView){
                    ((LogiContract.IView) view).LoginShopFailure(str);
                }
            }
        });

    }
}
