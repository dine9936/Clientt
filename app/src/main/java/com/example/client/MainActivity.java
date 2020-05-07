package com.example.client;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bttmNvgtnvw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new Home());

        bttmNvgtnvw = findViewById(R.id.bottom_nav_bar);
        bttmNvgtnvw.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragmenta = null;
        switch (menuItem.getItemId()) {
            case R.id.home:
                fragmenta = new Home();
                break;
            case R.id.order:
                fragmenta = new Myorder();
                break;
            case R.id.cart:
                fragmenta = new Cart();
                break;
            case R.id.profile:
                fragmenta = new Profile();
                break;

        }
        return loadFragment(fragmenta);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
