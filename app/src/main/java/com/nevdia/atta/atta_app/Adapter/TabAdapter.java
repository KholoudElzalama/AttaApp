package com.nevdia.atta.atta_app.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nevdia.atta.atta_app.Classes.FirstFragment;
import com.nevdia.atta.atta_app.Classes.FourthFragment;
import com.nevdia.atta.atta_app.Classes.SecondFragment;
import com.nevdia.atta.atta_app.Classes.ThirdFragment;


/**
 * Created by hadirsamir on 24/03/18.
 */

public class TabAdapter extends FragmentPagerAdapter {
    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
               return new FirstFragment();
            case 1:
               return  new SecondFragment();

            case 2:
               return new ThirdFragment();

            case 3:
                return  new FourthFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "الاصناف";
            case 1 :
                return "الماركات";
            case 2:
                return "الصيانة";
            case 3:
                return "اتصل بنا";
        }



        return super.getPageTitle(position);
    }
}
