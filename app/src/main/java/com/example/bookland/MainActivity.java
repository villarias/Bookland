package com.example.bookland;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.bookland.network.NetworkDataSource;
import com.example.bookland.network.NetworkRunnable;
import com.example.bookland.vista.HomeFragment;
import com.squareup.picasso.Picasso;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if (savedInstanceState == null) {
            HomeFragment fragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame, fragment)
                    .commit();
        }
    }
}