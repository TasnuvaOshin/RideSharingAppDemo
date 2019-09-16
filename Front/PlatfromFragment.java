package com.joytechnologies.rentacar.Front;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.joytechnologies.rentacar.Auth.DriverAuthFragment;
import com.joytechnologies.rentacar.Auth.UserAuthFragment;
import com.joytechnologies.rentacar.Auth.UserLoginFragment;
import com.joytechnologies.rentacar.R;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class PlatfromFragment extends Fragment {
    Button rent,driver;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_platfrom, container, false);
        rent = view.findViewById(R.id.rent);
        driver = view.findViewById(R.id.driver);
        rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // UserAuthFragment userAuthFragment = new UserAuthFragment();
SetFragment(new UserLoginFragment());
            }
        });
        driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetFragment(new DriverAuthFragment());
            }
        });
        return view;
    }
    //set fragment to change the home page
    private void SetFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack("fragment").replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();

    }

}
