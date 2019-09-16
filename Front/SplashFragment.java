package com.joytechnologies.rentacar.Front;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.joytechnologies.rentacar.R;


public class SplashFragment extends Fragment {
    ImageView imageView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        imageView = view.findViewById(R.id.logo);
        Glide.with(getActivity()).load(R.drawable.gear)
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE)
                        .error(R.drawable.gear)).into(imageView);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SetFragment(new PlatfromFragment());
            }
        }, 3000);

        return view;
    }

    //set fragment to change the home page
    private void SetFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();

    }
}
