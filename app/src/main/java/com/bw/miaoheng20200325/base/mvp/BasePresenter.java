package com.bw.miaoheng20200325.base.mvp;

import java.lang.ref.WeakReference;

/**
 * 时间 :2020/3/25  13:39
 * 作者 :苗恒
 * 功能 :
 */
public abstract class BasePresenter<M extends IBaseModel,V extends IBaseView> {
    public M model;
    public WeakReference<V> weakReference;

    public BasePresenter() {
        model=initModel();
    }
    public void attach(V v){
        weakReference=new WeakReference<>(v);
    }
    public void deatch(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference=null;
        }
    }
    public V getView(){
        return weakReference.get();
    }

    protected abstract M initModel();
}
