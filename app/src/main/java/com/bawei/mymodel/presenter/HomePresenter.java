package com.bawei.mymodel.presenter;


import android.util.Log;

import com.bawei.mymodel.base.mvp.BasePresenter;
import com.bawei.mymodel.centract.IHomeContract;
import com.bawei.mymodel.model.HomeModel;

public class HomePresenter extends BasePresenter<HomeModel, IHomeContract.IView> implements IHomeContract.IPresenter {
    @Override
    public void getHomeData(String url) {
        model.getHomeData(url, new IHomeContract.IModel.ModelCallback() {
            @Override
            public void success(Object data) {
                getView().success(data);
            }

            @Override
            public void error(Throwable throwable) {
                getView().error(throwable);
            }
        });
    }

    @Override
    public void getProductData(String url) {
        model.getProductData(url, new IHomeContract.IModel.ModelCallback() {
            @Override
            public void success(Object data) {
                Log.i("xxx",data+"");
                getView().success(data);
            }

            @Override
            public void error(Throwable throwable) {
                getView().error(throwable);
            }
        });
    }

    @Override
    protected HomeModel initModel() {
        return new HomeModel();
    }
}
