package com.bawei.wangyi20200401.base;

import java.lang.ref.WeakReference;

/**
 * presenter的封装
 */
public abstract class BasePersenter<V extends IBaseView>{
      WeakReference<V> weakReference;
    public BasePersenter(V v) {
        weakReference = new WeakReference<>(v);
        initModel();
    }
    public V getView(){
        if(weakReference!=null){
            return weakReference.get();
        }
        return null;
    }
    public void datchView(){
        if(weakReference!=null){
            weakReference.clear();
            weakReference=null;
        }
    }

    protected abstract void initModel();
}
