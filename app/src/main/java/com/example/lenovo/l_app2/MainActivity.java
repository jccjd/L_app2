package com.example.lenovo.l_app2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.lenovo.l_app2.ui.ImageFragment;
import com.example.lenovo.l_app2.ui.NewsFragment;
import com.example.lenovo.l_app2.ui.VideoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    private BottomNavigationBar mNavigationBar;
    private ViewPager viewPager;
    private List<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();
    }

    private void init() {
        //
        mFragments = new ArrayList<>();
        mFragments.add(new NewsFragment());
        mFragments.add(new VideoFragment());
        mFragments.add(new ImageFragment());

        //填写代码
        mNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "News"))
                .addItem(new BottomNavigationItem(R.drawable.ic_favorite_white_24dp, "Video"))
                .addItem(new BottomNavigationItem(R.drawable.ic_github_circle_white_24dp, "Image"))
                .setMode(BottomNavigationBar.MODE_FIXED).initialise();

        //填写代码
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        });
        viewPager.addOnPageChangeListener(this);
        mNavigationBar.setTabSelectedListener(this);
        viewPager.setCurrentItem(0);
    }

    private void initView() {
        mNavigationBar = (BottomNavigationBar) findViewById(R.id.btm_nav_bar);
        viewPager = (ViewPager) findViewById(R.id.view_page);
    }


    @Override
    public void onTabSelected(int position) {
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        mNavigationBar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
