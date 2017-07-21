package application.android.spotsoondemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by avinashs on 7/19/2017.
 */

public class FragmentState extends FragmentStatePagerAdapter {
   int num;
    FragmentState(FragmentManager fm,int in){
        super(fm);
        num=in;
    }

    @Override
    public Fragment getItem(int position) {
         switch (position)
         {
             case 0:return new Layout1();
             case 1:return  new Layout2();
             case 2:return  new Layout3();
             default:return new Layout1();
         }


    }

    @Override
    public int getCount() {

        return num;
    }
}
