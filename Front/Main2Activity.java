package com.joytechnologies.rentacar.Front;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.joytechnologies.rentacar.R;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SetFragment(new SplashFragment());
    }

    //set fragment to change the home page
    private void SetFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack("fragment").replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();

    }
}
