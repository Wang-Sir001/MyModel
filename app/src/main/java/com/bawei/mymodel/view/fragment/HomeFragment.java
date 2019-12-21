package com.bawei.mymodel.view.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.mymodel.R;
import com.bawei.mymodel.base.BaseFragment;
import com.bawei.mymodel.centract.IHomeContract;
import com.bawei.mymodel.model.adapter.RecyAdapter;
import com.bawei.mymodel.model.entity.HomeEntity;
import com.bawei.mymodel.model.entity.ProductEntity;
import com.bawei.mymodel.presenter.HomePresenter;
import com.bawei.mymodel.view.activity.SecondActivity;
import com.bawei.mymodel.view.weight.FlowLayout;

import java.net.URLEncoder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements IHomeContract.IView {
    private EditText et;
    private Button button;
    private FlowLayout flow;
    private RecyclerView recy;

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView(View inflate) {
        et = inflate.findViewById(R.id.et_Home);
        button = inflate.findViewById(R.id.button_Home);
        flow = inflate.findViewById(R.id.flow_Home);
        recy = inflate.findViewById(R.id.recy_Home);
  recy.setLayoutManager(new GridLayoutManager(getContext(),2));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = et.getText().toString();
                presenter.getProductData("http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword="+URLEncoder.encode(s)+"&page=1&count=10");

                flow.adds(s);
            }
        });
        flow.setFlowCallback(new FlowLayout.FlowCallback() {
            @Override
            public void succes(String name) {
                Toast.makeText(getContext(), name, Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        presenter.getHomeData("http://blog.zhaoliang5156.cn/baweiapi/"+ URLEncoder.encode("手机"));
    }

    @Override
    public void success(Object data) {
        if (data instanceof HomeEntity){
            HomeEntity homeEntity = (HomeEntity) data;
            flow.add(homeEntity.tags);
        }else if (data instanceof ProductEntity){
            ProductEntity productEntity = (ProductEntity) data;
            Toast.makeText(getContext(), productEntity+"", Toast.LENGTH_SHORT).show();
            RecyAdapter recyAdapter = new RecyAdapter(getContext(), productEntity.result);
            recy.setAdapter(recyAdapter);
            recyAdapter.setRectCallback(new RecyAdapter.RectCallback() {
                @Override
                public void success() {
                    Intent intent = new Intent(getContext(), SecondActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void error(Throwable throwable) {

    }
}
