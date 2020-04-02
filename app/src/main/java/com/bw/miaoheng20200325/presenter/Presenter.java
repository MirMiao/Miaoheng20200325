package com.bw.miaoheng20200325.presenter;

import com.bw.miaoheng20200325.base.mvp.BasePresenter;
import com.bw.miaoheng20200325.contract.IContract;
import com.bw.miaoheng20200325.model.Model;

/**
 * 时间 :2020/3/25  13:55
 * 作者 :苗恒
 * 功能 :
 */
public class Presenter extends BasePresenter<Model , IContract.IView> implements IContract.IPresenter {
    @Override
    protected Model initModel() {
        return new Model();
    }

    @Override
    public void login(String phone, String pwd) {
            model.login(phone, pwd, new IContract.IModel.ModelCallBack() {
                @Override
                public void seccess(Object object) {
                    getView().seccess(object);
                }

                @Override
                public void failur(Throwable throwable) {
                    getView().failur(throwable);
                }
            });
    }

    @Override
    public void reg(String phone, String pwd) {
        model.reg(phone, pwd, new IContract.IModel.ModelCallBack() {
            @Override
            public void seccess(Object object) {
                getView().seccess(object);
            }

            @Override
            public void failur(Throwable throwable) {
                getView().failur(throwable);
            }
        });
    }

    @Override
    public void getHomeData() {
        model.getHomeData(new IContract.IModel.ModelCallBack() {
            @Override
            public void seccess(Object object) {
                getView().seccess(object);
            }

            @Override
            public void failur(Throwable throwable) {
                getView().failur(throwable);
            }
        });
    }
}
