package com.bawei.mymodel.centract;

import com.bawei.mymodel.base.mvp.IBaseModel;
import com.bawei.mymodel.base.mvp.IBaseView;

public interface IHomeContract {
    interface IModel extends IBaseModel {
        void getHomeData(String url,ModelCallback modelCallback);
        void getProductData(String url,ModelCallback modelCallback);

        interface ModelCallback{
            void success(Object data);
            void error(Throwable throwable);
        }
    }
    interface IView extends IBaseView {
        void success(Object data);
        void error(Throwable throwable);
    }
    interface IPresenter{
        void getHomeData(String url);
        void getProductData(String url);
    }
}
