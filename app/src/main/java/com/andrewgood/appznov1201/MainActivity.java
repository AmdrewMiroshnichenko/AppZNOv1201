package com.andrewgood.appznov1201;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.andrewgood.appznov1201.ui.course.CourseFragment;
import com.andrewgood.appznov1201.ui.learn.LearnFragment;
import com.andrewgood.appznov1201.ui.profile.ProfileFragment;
import com.andrewgood.appznov1201.ui.words.WordsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;
import com.google.android.material.navigation.NavigationView;
import java.util.Objects;

public class
MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private Toolbar toolbar;

    private DrawerLayout drawerLayuot;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private TextView toolbarTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbarTitle = findViewById(R.id.toolbar_tv);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);//

        //*navController = Navigation.findNavController(this, R.id.frame_layout);

        drawerLayuot = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);

        toggle = new ActionBarDrawerToggle(this, drawerLayuot, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayuot.addDrawerListener(toggle);
        toggle.syncState();

        //  Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(this);
        loadFragment(LearnFragment.newInstance());

        //*NavigationUI.setupWithNavController(bottomNavigationView, navController);

        setCustomSettings();

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        toolbarTitle.setText(R.string.learn);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.id_learn){
            Toast.makeText(this, "Вивчаю", Toast.LENGTH_SHORT).show();
            drawerLayuot.closeDrawer(GravityCompat.START);
        } else if(id == R.id.id_buy_the_whole_course){

            
        } else if(id == R.id.id_evaluate_the_application){
            Toast.makeText(this, "Оцінити додаток", Toast.LENGTH_SHORT).show();
            drawerLayuot.closeDrawer(GravityCompat.START);
        } else if(id == R.id.id_share_with_friends) {
            Toast.makeText(this, "Поділитися з друзями", Toast.LENGTH_SHORT).show();
            drawerLayuot.closeDrawer(GravityCompat.START);
        } else if(id == R.id.id_contact_us){
            Toast.makeText(this, "Контакт", Toast.LENGTH_SHORT).show();
            drawerLayuot.closeDrawer(GravityCompat.START);
        } else if (id == R.id.id_settings) {
            Toast.makeText(this, "Налаштування", Toast.LENGTH_SHORT).show();
            drawerLayuot.closeDrawer(GravityCompat.START);
        }

        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            if(id == R.id.navigation_learn){
                toolbarTitle.setText(R.string.learn);
                loadFragment(LearnFragment.newInstance());
                return true;
            } else if(id == R.id.navigation_words){
                toolbarTitle.setText(R.string.bottom_words);
                loadFragment(WordsFragment.newInstance());
                return true;
            } else if(id == R.id.navigation_course){
                toolbarTitle.setText(R.string.bottom_course);
                loadFragment(CourseFragment.newInstance());
                return true;
            } else if(id == R.id.navigation_profile){
                toolbarTitle.setText(R.string.title_profile);
                loadFragment(ProfileFragment.newInstance());
                return true;
            }

            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, fragment);
        ft.commit();
    }



    private void setCustomSettings(){
        navigationView.setItemIconTintList(null);

        toolbar.setNavigationIcon(R.drawable.ic_toolbar_icon);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
    }


}