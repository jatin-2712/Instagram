package com.masterandroid.instagram;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationBarView;
import com.masterandroid.instagram.databinding.ActivityMainBinding;
import com.masterandroid.instagram.ui.home.HomeFragment;
import com.masterandroid.instagram.ui.home.HomeViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);


        ImageView cameraToolbar = toolbar.findViewById(R.id.camera);

        cameraToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Camera is Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        navView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId()==R.id.navigation_home){
                    HomeFragment homeFragment = new HomeFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.nav_host_fragment_activity_main,homeFragment);
                }

                else if(item.getItemId()==R.id.search){
                    Toast.makeText(MainActivity.this, "Search Coming Soon", Toast.LENGTH_SHORT).show();
                }
                else if(item.getItemId()==R.id.post){
                    Toast.makeText(MainActivity.this, "Post add Coming Soon", Toast.LENGTH_SHORT).show();
                }
                else if(item.getItemId()==R.id.like){
                    Toast.makeText(MainActivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                }
                else if(item.getItemId()==R.id.userprofile){
                    Toast.makeText(MainActivity.this, "Profile View Coming Soon", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });

    }

}