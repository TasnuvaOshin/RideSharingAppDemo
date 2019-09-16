package com.joytechnologies.rentacar.Auth;

        import android.content.Context;
        import android.net.Uri;
        import android.os.Bundle;
        import android.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.TextView;

        import com.joytechnologies.rentacar.Home.HomeFragment;
        import com.joytechnologies.rentacar.R;

        import java.util.Set;

        import androidx.fragment.app.FragmentTransaction;


public class UserLoginFragment extends androidx.fragment.app.Fragment {
    TextView textView;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_login, container, false);

       textView =view.findViewById(R.id.register);
       button = view.findViewById(R.id.submit);
       textView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               SetFragment(new UserAuthFragment());

           }
       });

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               SetFragment(new HomeFragment());
           }
       });
        return view;
    }


    //set fragment to change the home page
    private void SetFragment(androidx.fragment.app.Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack("fragment").replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();

    }

}
