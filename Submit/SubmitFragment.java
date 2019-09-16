package com.joytechnologies.rentacar.Submit;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.joytechnologies.rentacar.R;
import com.squareup.picasso.Picasso;

import java.util.Objects;


public class SubmitFragment extends Fragment {
    private String car_name, car_img, car_amount;
    private TextView car_name_t, car_amount_t, car_total_t;
    private ImageView imageView;
    private Spinner spinner;
    private String airport_name;
    private Button process;
    private ProgressDialog progressDialog;
    private TextInputEditText et_Location, et_days;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_submit, container, false);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Processing....");
        car_name = String.valueOf(getArguments().get("car_name"));
        car_img = getArguments().getString("car_img");
        Toast.makeText(getActivity(), "" + car_name, Toast.LENGTH_SHORT).show();
        car_amount = getArguments().getString("car_amount");
        spinner = view.findViewById(R.id.spinner);
        car_amount_t = view.findViewById(R.id.car_amount);
        car_name_t = view.findViewById(R.id.car_name);
        imageView = view.findViewById(R.id.car_img);
        car_total_t = view.findViewById(R.id.car_total);
        process = view.findViewById(R.id.process);
        car_name_t.setText(car_name);
        car_amount_t.setText(car_amount + "Taka BDT / Day ");
        SetSpinner(spinner, R.array.airport);
        Picasso.get().load(car_img).into(imageView);
        et_Location = view.findViewById(R.id.to_location);
        et_days = view.findViewById(R.id.days);
        process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String toLocation = et_Location.getText().toString();
                String day = et_days.getText().toString();
                progressDialog.show();
                if (TextUtils.isEmpty(airport_name)) {

                    spinner.requestFocus();
                    progressDialog.dismiss();
                    Toast.makeText(getActivity(), "Please Select The Pickup Location", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(toLocation)) {
                    progressDialog.dismiss();
                    et_Location.requestFocus();
                    et_Location.setError("Please Enter Destination Address");
                    Toast.makeText(getActivity(), "Enter the Destination Address", Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(day)) {
                    progressDialog.dismiss();
                    et_days.requestFocus();
                    et_days.setError("Please Enter the Day");
                    Toast.makeText(getActivity(), "Please Enter the day", Toast.LENGTH_SHORT).show();
                } else {
                    int amounts = Integer.parseInt(car_amount);
                    int days = Integer.parseInt(day);

                    new AlertDialog.Builder(getActivity())
                            .setTitle("Confirmation")
                            .setMessage("Totol Amount is " + amounts * days + "Taka BDT. Sent Request To Driver?")
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int whichButton) {
                                    progressDialog.dismiss();
                                    dialog.dismiss();
                                    Toast.makeText(getActivity(), "Request Submitted", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            }).show();


                }

            }
        });
        return view;
    }

    private void SetSpinner(Spinner gender_spinner, int gender1) {

        @SuppressLint({"NewApi", "LocalSuppress"}) ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(Objects.requireNonNull(getActivity()), gender1, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender_spinner.setAdapter(arrayAdapter);
        gender_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i > 0) {
                    airport_name = String.valueOf(adapterView.getItemAtPosition(i));
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}
