package com.bawei.mymodel.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.bawei.mymodel.R;
import com.bawei.mymodel.base.BaseActivity;
import com.bawei.mymodel.base.mvp.BasePresenter;
import com.bawei.mymodel.centract.IHomeContract;
import com.bawei.mymodel.presenter.HomePresenter;
import com.bawei.mymodel.view.fragment.HomeFragment;
import com.bawei.mymodel.view.fragment.OtherFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<HomePresenter> implements IHomeContract.IView {
    private ViewPager vp;
    private RadioGroup rg ;
    private List<Fragment> fragments;

    @Override
    protected HomePresenter initPresenter() {
        return null;
    }


    @Override
    protected void initData() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(OtherFragment.getInstance("北京"));
        fragments.add(OtherFragment.getInstance("我的"));

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
    }

    @Override
    protected void initView() {
        vp = findViewById(R.id.vp_activityMain);
        rg = findViewById(R.id.rg_activityMain);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1_Main:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rb2_Main:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rb3_Main:
                        vp.setCurrentItem(2);
                        break;
                }
            }
        });
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void success(Object data) {

    }

    @Override
    public void error(Throwable throwable) {

    }
}
