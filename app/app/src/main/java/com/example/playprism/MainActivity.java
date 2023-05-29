package com.example.playprism;

import android.os.Bundle;
import android.view.View;

import com.example.playprism.databinding.ActivityMainBinding;
import com.example.playprism.ui.giveaways.GiveawaysItemFragment;
import com.example.playprism.ui.purchasehistory.PurchaseHistoryFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("MainActivity");

        // Displaying the MainActivity layout
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        // Displaying the BottomNavigationView
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_profile, R.id.navigation_giveaways, R.id.navigation_settings).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        navView.setVisibility(View.GONE);
    }

    public void hideBottomNavigationView() {
        binding.navView.setVisibility(View.GONE);
    }

    public void showBottomNavigationView() {
        binding.navView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_activity_main);
        List<Fragment> fragments = fragment.getChildFragmentManager().getFragments();
        fragment = fragments.get(0);

        if (fragment instanceof GiveawaysItemFragment || fragment instanceof PurchaseHistoryFragment) {
            super.onBackPressed();
        }
    }
}