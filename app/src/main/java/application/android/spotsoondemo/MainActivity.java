package application.android.spotsoondemo;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.viewpagerindicator.CirclePageIndicator;


public class MainActivity extends AppCompatActivity {
    ViewPager view;
    TabLayout tab1;
    ViewPager view1;
    FragmentState state;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    CirclePageIndicator circlePageIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view1 = (ViewPager) findViewById(R.id.viewer);
        view = (ViewPager) findViewById(R.id.viewpager);
        tab1 = (TabLayout) findViewById(R.id.tabLayout1);
        TabLayout.Tab viewTab1 = tab1.newTab();
        TabLayout.Tab viewTab2 = tab1.newTab();
        TabLayout.Tab viewTab3 = tab1.newTab();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);


        circlePageIndicator=(CirclePageIndicator)findViewById(R.id.indicator);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("HOME");
        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        // getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // getSupportActionBar().setHomeButtonEnabled(true);
        final ActionBarDrawerToggle bar = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close) {


            @Override
            public void onDrawerOpened(View drawerView) {

                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        bar.syncState();
        drawerLayout.addDrawerListener(bar);


        viewTab1.setCustomView(getTabView(R.drawable.tab_selector, "VIDEOS"));
        viewTab2.setCustomView(getTabView(R.drawable.tab2_selector, "IMAGES"));
        viewTab3.setCustomView(getTabView(R.drawable.tab3_selector, "MILESTONES"));
        tab1.addTab(viewTab1);
        tab1.addTab(viewTab2);
        tab1.addTab(viewTab3);
        view.setAdapter(new PageAdapter(getSupportFragmentManager()));
        tab1.setTabGravity(TabLayout.GRAVITY_FILL);

        state = new FragmentState(getSupportFragmentManager(), tab1.getTabCount());
        view1.setAdapter(state);
        view1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab1));
        int i = tab1.getSelectedTabPosition();
        circlePageIndicator.setViewPager(view);
        tab1.setSelectedTabIndicatorColor(Color.parseColor("#FE5A1D"));
        if (tab1.getTabAt(0).isSelected()) {
            TextView txt = (TextView) tab1.getTabAt(0).getCustomView().findViewById(R.id.tabText);
            txt.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.saffron));
        }
        tab1.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                TextView txt = (TextView) tab.getCustomView().findViewById(R.id.tabText);
                txt.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.saffron));
                view1.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                TextView txt = (TextView) tab.getCustomView().findViewById(R.id.tabText);
                txt.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.grey));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


    private View getTabView(int draw, String content) {
        View v = getLayoutInflater().inflate(R.layout.imagelayout, null);
        ImageView img = (ImageView) v.findViewById(R.id.image);
        TextView text1 = (TextView) v.findViewById(R.id.tabText);
        img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, draw));
        text1.setText(content);
        return v;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(this, "sd", Toast.LENGTH_SHORT).show();

        }
        return true;
    }
}
