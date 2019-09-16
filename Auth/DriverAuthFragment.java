package com.joytechnologies.rentacar.Auth;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.joytechnologies.rentacar.R;


public class DriverAuthFragment extends androidx.fragment.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_driver_auth, container, false);


        return view;
    }


}
