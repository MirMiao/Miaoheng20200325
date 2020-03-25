package com.bw.miaoheng20200325.model;

import com.bw.miaoheng20200325.api.ILoginApiService;
import com.bw.miaoheng20200325.api.IRegApiService;
import com.bw.miaoheng20200325.contract.IContract;
import com.bw.miaoheng20200325.entity.LoginEntity;
import com.bw.miaoheng20200325.entity.RegEntity;
import com.bw.miaoheng20200325.util.RetfofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 时间 :2020/3/25  13:54
 * 作者 :苗恒
 * 功能 :
 */
public class Model implements IContract.IModel {
    @Override
    public void login(String phone, String pwd, final ModelCallBack modelCallBack) {
        RetfofitUtil.getInstance().creatService(ILoginApiService.class)
                .login(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginEntity>() {
                    @Override
                    public void accept(LoginEntity loginEntity) throws Exception {
                            modelCallBack.seccess(loginEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                            modelCallBack.failur(throwable);
                    }
                });
    }

    @Override
    public void reg(String phone, String pwd, final ModelCallBack modelCallBack) {
        RetfofitUtil.getInstance().creatService(IRegApiService.class)
                .reg(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegEntity>() {
                    @Override
                    public void accept(RegEntity regEntity) throws Exception {
                        modelCallBack.seccess(regEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                            modelCallBack.failur(throwable);
                    }
                });
    }
}
