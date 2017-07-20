package application.android.spotsoondemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by boobeshb on 7/20/2017.
 */

public class ViewHolderAdapter extends RecyclerView.ViewHolder {
public ImageView image;
public TextView title;
public TextView content;
    ViewHolderAdapter(View v){
        super(v);
        image=(ImageView)v.findViewById(R.id.image);
        title=(TextView)v.findViewById(R.id.title);
        content=(TextView)v.findViewById(R.id.content);
    }

}
