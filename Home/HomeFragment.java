package com.joytechnologies.rentacar.Home;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.joytechnologies.rentacar.R;
import com.joytechnologies.rentacar.Recyclerview.bottom_Adapter;
import com.joytechnologies.rentacar.Recyclerview.top_Adapter;
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

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class HomeFragment extends Fragment {
    ArrayList<top_Class> arrayList;
    RecyclerView recyclerView_top,recyclerView_down;
    Dialog dialog;
    ProgressDialog progressDialog;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.custom_dialog_lay);
        dialog.setCancelable(false);
//dialog.setTitle("Progress");

        TextView text = (TextView) dialog.findViewById(R.id.text);
        text.setText("Loading .........");
        ImageView image = (ImageView) dialog.findViewById(R.id.img);
        image.setImageResource(R.drawable.c);
        dialog.show();

        Glide.with(getActivity()).load(R.drawable.c)
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.RESOURCE)
                        .error(R.drawable.c)).into(image);
        arrayList = new ArrayList<top_Class>();
        recyclerView_top = view.findViewById(R.id.rv_top);
        recyclerView_down = view.findViewById(R.id.rv_down);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView_top.setLayoutManager(layoutManager);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);

        recyclerView_down.setLayoutManager(mLayoutManager);
        recyclerView_down.setHasFixedSize(true);
        recyclerView_down.setItemViewCacheSize(20);
        recyclerView_down.setDrawingCacheEnabled(true);
        recyclerView_down.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);


        recyclerView_top.setHasFixedSize(true);
        recyclerView_top.setItemViewCacheSize(20);
        recyclerView_top.setDrawingCacheEnabled(true);
        recyclerView_top.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        GetCar getCar = new GetCar();
        getCar.execute();

        return view;
    }

    public class GetCar extends AsyncTask<String, String, String> {

        HttpURLConnection httpURLConnection = null;
        BufferedReader bufferedReader = null;

        @Override
        protected String doInBackground(String... strings) {
            URL url = null;
            try {

                url = new URL("https://tasnuvaoshin.com/car/get/get_car.php");
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();
                String line = "";
                String myFile;
                int i;

                while ((line = bufferedReader.readLine()) != null) {

                    stringBuffer.append(line);

                }

                myFile = stringBuffer.toString();
                Log.d("response", myFile);

                JSONArray jsonArray = new JSONArray(myFile);
                for (int x = 0; x < jsonArray.length(); x++) {
                    String name = jsonArray.getJSONObject(x).getString("car_name");
                    String amount = jsonArray.getJSONObject(x).getString("car_amount");
                    String capacity = jsonArray.getJSONObject(x).getString("car_capacity");
                    String rating = jsonArray.getJSONObject(x).getString("car_rating");
                    String img = jsonArray.getJSONObject(x).getString("car_img");

                    arrayList.add(new top_Class(name, amount, capacity, rating, img));

                }
                return myFile;


            } catch (IOException e) {
                e.printStackTrace();

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;


        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (arrayList.size() > 0) {
                dialog.dismiss();
                top_Adapter top_adapter = new top_Adapter(getActivity(),arrayList);
                recyclerView_top.setAdapter(top_adapter);
                bottom_Adapter bottom_adapter = new bottom_Adapter(getActivity(),arrayList);
                recyclerView_down.setAdapter(bottom_adapter);
            }


        }
    }
}
