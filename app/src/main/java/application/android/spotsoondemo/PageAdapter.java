package application.android.spotsoondemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by avinashs on 7/19/2017.
 */

public class PageAdapter extends FragmentPagerAdapter {

    PageAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:{
                  return new Fragment1();

            }
            case 1:{
                return new Fragment2();

            }

            case 2:{
               return new Fragment3();

            }

            default:{
                return  new Fragment1();

            }
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
