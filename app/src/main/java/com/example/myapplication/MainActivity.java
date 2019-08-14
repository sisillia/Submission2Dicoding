package com.example.myapplication;

import android.content.Intent;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabListAdapter tabListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabListAdapter = new TabListAdapter(getSupportFragmentManager());
        tabListAdapter.addFragment(new ListMovieFragment(), getResources().getString(R.string.title_fragment_movie));
        tabListAdapter.addFragment(new ListTvFragment(), getResources().getString(R.string.title_fragment_tvshow));

        viewPager.setAdapter(tabListAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_change_settings){
            Intent setting = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(setting);
        }

        return super.onOptionsItemSelected(item);
    }
}
