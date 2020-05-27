package com.example.laksha.kksp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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
        //Variable bottom_nav
        bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);



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
