package com.joytechnologies.rentacar;


import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.joytechnologies.rentacar.Home.HomeFragment;
import com.joytechnologies.rentacar.Recyclerview.top_Class;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetFragment(new HomeFragment());

    }


    //set fragment to change the home page
    private void SetFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack("fragment").replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();

    }


}
