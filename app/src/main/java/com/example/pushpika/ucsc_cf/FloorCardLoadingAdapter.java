package com.example.pushpika.ucsc_cf;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


/**
 * Created by pushpika on 8/26/17.
 */

public class FloorCardLoadingAdapter extends RecyclerView.Adapter<FloorCardLoadingAdapter.MyHorizontalViewHolder> {

    private Context mContext;
    private List<CompanyCard> albumList;

    public class MyHorizontalViewHolder extends RecyclerView.ViewHolder {
        public TextView stoleName, stoleNumber,availability, availabilityColor;
        public ImageView thumbnail;
        public CardView cardView;


        public MyHorizontalViewHolder(View view) {
            super(view);
            stoleName = (TextView) view.findViewById(R.id.stole_name);
            stoleNumber = (TextView) view.findViewById(R.id.stole_number);
            availability = (TextView) view.findViewById(R.id.availability);
            availabilityColor = (TextView) view.findViewById(R.id.availability_color);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            cardView = (CardView) view.findViewById(R.id.card_view);
        }

    }


    public FloorCardLoadingAdapter(Context mContext, List<CompanyCard> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public FloorCardLoadingAdapter.MyHorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.company_card, parent, false);

        return new FloorCardLoadingAdapter.MyHorizontalViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(final FloorCardLoadingAdapter.MyHorizontalViewHolder holder, final int position) {
        final CompanyCard album = albumList.get(position);
        holder.stoleName.setText(album.getStoleName());
        holder.availability.setText(album.getIsAvailable());
        holder.stoleNumber.setText("Stole No : "+album.getStoleID());
        if (album.getIsAvailable().equals("Available")){
            holder.availabilityColor.setBackgroundColor(Color.parseColor("#00FF00"));
        }
        else{
            holder.availabilityColor.setBackgroundColor(Color.parseColor("#FF0000"));
        }

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

}

