package com.nevdia.atta.atta_app;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.nevdia.atta.atta_app.Adapter.TabAdapter;

public class HomeActivity extends AppCompatActivity {

private ViewPager viewPager ;
private TabLayout tabLayout;
private TabAdapter tabAdapter;

private int [] tabIcons={R.drawable.ic_format_align_left_black_24dp,R.drawable.ic_star_black_24dp,R.drawable.ic_build_black_24dp,R.drawable.ic_call_black_24dp};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        tabLayout=(TabLayout) findViewById(R.id.tab_indicator);
        tabAdapter=new TabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);





    }


}
