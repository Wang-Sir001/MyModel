package com.bawei.mymodel.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.mymodel.R;
import com.bawei.mymodel.base.BaseFragment;
import com.bawei.mymodel.base.mvp.BasePresenter;
import com.bawei.mymodel.centract.IHomeContract;
import com.bawei.mymodel.presenter.HomePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class OtherFragment extends BaseFragment<HomePresenter> implements IHomeContract.IView {

    private TextView tv;

    @Override
    protected HomePresenter initPresenter() {
        return null;
    }


    @Override
    protected void initView(View inflate) {
        tv = inflate.findViewById(R.id.tv_fragmentOther);

    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_other;
    }

    @Override
    protected void initData() {
        String key = getArguments().getString("key");
        tv.setText(key);
    }

    @Override
    public void success(Object data) {

    }

    @Override
    public void error(Throwable throwable) {

    }

    public static OtherFragment getInstance(String value) {
        OtherFragment otherFragment = new OtherFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key",value);
        otherFragment.setArguments(bundle);
        return otherFragment;
    }
}
