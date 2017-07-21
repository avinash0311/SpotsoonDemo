package application.android.spotsoondemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avinashs on 7/20/2017.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<ViewHolderAdapter> {
    private ArrayList<CountryListArray> countryLists;
    private Context con;
    RecycleViewAdapter(Context con, ArrayList<CountryListArray> countryList)
    {
        countryLists=countryList;
        this.con=con;
    }

    @Override
    public int getItemCount() {

        return countryLists.size();
    }

    @Override
    public void onBindViewHolder(ViewHolderAdapter holder, int position) {
          holder.title.setText(countryLists.get(position).getCountry());
          holder.content.setText(countryLists.get(position).getRank());
        Picasso.with(con).load(countryLists.get(position).getFlag()).into(holder.image);
    }

    @Override
    public ViewHolderAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(con).inflate(R.layout.cardlayout,parent,false);
        ViewHolderAdapter vw=new ViewHolderAdapter(v);
        return vw;
    }
}
