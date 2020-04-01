package com.bawei.wangyi20200401.contract;

import com.bawei.wangyi20200401.base.IBaseView;
import com.bawei.wangyi20200401.bean.LoginBean;

/**
 * 契约类
 */
public interface LogiContract {
    interface IView extends IBaseView{
        void LoginShopSuccess(LoginBean bean);
        void LoginShopFailure(String str);
    }
    interface IPresenter{
        void Login(String phone,String pwd);
    }
    interface IModel{
        void Login(String phone,String pwd,IModelCallBack callBack);
        interface IModelCallBack{
            void LoginShopSuccess(LoginBean bean);
            void LoginShopFailure(String str);
        }
    }
}
