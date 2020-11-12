package com.example.laksha.kksp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class home extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;
    FrameLayout container;
    LinearLayout layout_tab;
    TabLayout tab;
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        layout_tab=(LinearLayout) findViewById(R.id.layout_tab);
        container = (FrameLayout) findViewById(R.id.container);

        tab=(TabLayout) findViewById(R.id.tab);
        tab.setTabGravity(TabLayout.GRAVITY_FILL);
        viewpager=(ViewPager) findViewById(R.id.viewpager);
        Tab_adapter tab_adapter=new Tab_adapter(getSupportFragmentManager(), tab.getTabCount());
        viewpager.setAdapter(tab_adapter);
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //Variable bottom_nav
        bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);
        load_fragment_bottom(new HomeFragment());


    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod=new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment fragment=null;
                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            layout_tab.setVisibility(View.GONE);
                            container.setVisibility(View.VISIBLE);
                            load_fragment_bottom(new HomeFragment());
                            return true;
                        case R.id.nav_dash :
                            layout_tab.setVisibility(View.VISIBLE);
                            container.setVisibility(View.GONE);
                            return true;

                        case R.id.nav_create:
                            layout_tab.setVisibility(View.GONE);
                            container.setVisibility(View.VISIBLE);
                            load_fragment_bottom(new CreateFragment());
                            return true;

                    }

return false;


                }
            };
Boolean load_fragment_bottom(Fragment fragment)
{
    if (fragment!=null)
    {
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container,fragment).commit();
        return true;
    }
    return false;

}


}
class Tab_adapter extends FragmentStatePagerAdapter
{
    int jumlahtab;
    public Tab_adapter(@NonNull FragmentManager fm, int jmltab) {
        super(fm);
        this.jumlahtab=jmltab;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                Tab1 tab1=new Tab1();
                return tab1;
            case 1:
                Tab2 tab2=new Tab2();
                return tab2;
            case 2:
                Tab3 tab3=new Tab3();
                return tab3;
            case 3:
                Tab4 tab4=new Tab4();
                return tab4;

        }
        return null;
    }

    @Override
    public int getCount() {
        return jumlahtab;
    }
}