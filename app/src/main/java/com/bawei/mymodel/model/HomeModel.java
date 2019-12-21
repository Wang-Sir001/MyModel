package com.bawei.mymodel.model;

import com.bawei.mymodel.centract.IHomeContract;
import com.bawei.mymodel.model.entity.HomeEntity;
import com.bawei.mymodel.model.entity.ProductEntity;
import com.bawei.mymodel.utils.VolleyUtils;
import com.google.gson.Gson;

public class HomeModel implements IHomeContract.IModel {
    @Override
    public void getHomeData(String url, final ModelCallback modelCallback) {
        VolleyUtils.getInstance().doGet(url, new VolleyUtils.VolleyCallback() {
            @Override
            public void success(String data) {
                HomeEntity homeEntity = new Gson().fromJson(data, HomeEntity.class);
                modelCallback.success(homeEntity);
            }

            @Override
            public void error(Throwable throwable) {
                modelCallback.error(throwable);
            }
        });
    }

    @Override
    public void getProductData(String url, final ModelCallback modelCallback) {
        VolleyUtils.getInstance().doGet(url, new VolleyUtils.VolleyCallback() {
            @Override
            public void success(String data) {
                ProductEntity productEntity = new Gson().fromJson(data, ProductEntity.class);
                modelCallback.success(productEntity);
            }

            @Override
            public void error(Throwable throwable) {
                modelCallback.error(throwable);
            }
        });
    }
}
