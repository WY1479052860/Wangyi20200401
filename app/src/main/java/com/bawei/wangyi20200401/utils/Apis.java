package com.bawei.wangyi20200401.utils;

import com.bawei.wangyi20200401.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * 接口
 */
public interface Apis {
    @POST("small/user/v1/login")
    Observable<LoginBean> dologin(@Field("phone") String phone,@Field("pwd")String pwd);
}
