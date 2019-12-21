package com.bawei.mymodel.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bawei.mymodel.base.mvp.BasePresenter;
import com.bawei.mymodel.base.mvp.IBaseView;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {
    public P presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(LayoutId(), container, false);
        presenter = initPresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
        initView(inflate);
        return inflate;
    }

    protected abstract P initPresenter();

    protected abstract void initView(View inflate);

    protected abstract int LayoutId();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
