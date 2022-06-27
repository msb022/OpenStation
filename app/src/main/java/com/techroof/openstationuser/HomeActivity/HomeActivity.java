package com.techroof.openstationuser.HomeActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.techroof.openstationuser.HostFragments.DashboardHostFragment;
import com.techroof.openstationuser.HostFragments.InboxHostFragment;
import com.techroof.openstationuser.HostFragments.ListingsHostFragment;
import com.techroof.openstationuser.HostFragments.ProfileHostFragment;
import com.techroof.openstationuser.HostFragments.ReservationsHostFragment;
import com.techroof.openstationuser.R;
import com.techroof.openstationuser.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding activityHomeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = activityHomeBinding.getRoot();
        setContentView(view);

        //Bottom Navigation Bar

        activityHomeBinding.bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new DashboardHostFragment()).commit();
        }

    }


    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.dashboard:

                    selectedFragment = new DashboardHostFragment();
                    break;
                case R.id.reservation:
                    selectedFragment = new ReservationsHostFragment();
                    break;
                case R.id.listings:
                    selectedFragment = new ListingsHostFragment();
                    break;
                case R.id.inbox:
                    selectedFragment = new InboxHostFragment();
                    break;
                case R.id.profile:
                    selectedFragment = new ProfileHostFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();

            return true;
        }


    };

}