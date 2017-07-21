package application.android.spotsoondemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by avinashs on 7/19/2017.
 */

public class Layout1 extends Fragment {

    private static final String BASEURL = "http://www.json-generator.com/api/json/";
    RecyclerView recycle;

    RecycleViewAdapter rec = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout1, container, false);
        recycle = (RecyclerView) v.findViewById(R.id.recycleView);
        Retrofit rf = new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build();
        ApiService service = rf.create(ApiService.class);
        service.getResults().enqueue(new Callback<ArrayList<CountryListArray>>() {
            @Override
            public void onResponse(Call<ArrayList<CountryListArray>> call, Response<ArrayList<CountryListArray>> response) {
                Log.d("TAG", "the success");
                ArrayList<CountryListArray> ary = response.body();
                recycleviewIntialization(ary);

            }

            @Override
            public void onFailure(Call<ArrayList<CountryListArray>> call, Throwable t) {
                Log.d("TAG", "the failure");
            }
        });
        return v;
    }

    private void recycleviewIntialization(ArrayList<CountryListArray> list) {

        if (!list.isEmpty()) {
            rec = new RecycleViewAdapter(getActivity().getApplicationContext(), list);
        }

        RecyclerView.LayoutManager layout = new LinearLayoutManager(getActivity());
        recycle.setLayoutManager(layout);
        recycle.setAdapter(rec);
        rec.notifyDataSetChanged();
    }
}
