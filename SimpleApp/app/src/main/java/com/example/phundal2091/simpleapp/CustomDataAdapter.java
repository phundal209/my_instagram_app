package com.example.phundal2091.simpleapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.data.CustomData;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by phundal2091 on 9/1/17.
 */

public class CustomDataAdapter extends RecyclerView.Adapter<CustomDataAdapter.ViewHolder> {

    private Context context;
    private List<CustomData> data;

    public CustomDataAdapter(Context context, List<CustomData> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CustomData customData = data.get(position);
        holder.title.setText(customData.getTitle());
        holder.desc.setText(customData.getDesc());
        Picasso.with(context).
                load(customData.getUrl()).
                into(holder.image);
    }

    @Override
    public int getItemCount() {
        if(data != null) { return data.size(); }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        public TextView title;
        @BindView(R.id.desc)
        public TextView desc;
        @BindView(R.id.image)
        public ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
