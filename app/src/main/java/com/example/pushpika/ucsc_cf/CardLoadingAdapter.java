package com.example.pushpika.ucsc_cf;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import static com.example.pushpika.ucsc_cf.MainActivity.isAdmin;
import static com.example.pushpika.ucsc_cf.MainActivity.myRef;

/**
 * Created by pushpika on 8/25/17.
 */

public class CardLoadingAdapter extends RecyclerView.Adapter<CardLoadingAdapter.MyHorizontalViewHolder> {

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


    public CardLoadingAdapter(Context mContext, List<CompanyCard> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public CardLoadingAdapter.MyHorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.company_card, parent, false);

        return new CardLoadingAdapter.MyHorizontalViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(final CardLoadingAdapter.MyHorizontalViewHolder holder, final int position) {
        final CompanyCard album = albumList.get(position);
        holder.stoleName.setText(album.getStoleName());
        holder.availability.setText(album.getIsAvailable());
        holder.stoleNumber.setText("Stole No : "+album.getStoleNumber());
        if (album.getIsAvailable().equals("Available")){
            holder.availabilityColor.setBackgroundColor(Color.parseColor("#00FF00"));
        }
        else{
            holder.availabilityColor.setBackgroundColor(Color.parseColor("#FF0000"));
        }
        //holder.quantity.getSelectedItem();
//        if (album.getIsOrdered()){
//            holder.addToOrder.setText(R.string.order_added);
//            holder.addToOrder.setTextColor(Color.parseColor("#FC7A10"));
//            holder.addToOrder.setBackgroundColor(Color.parseColor("#FFFFFF"));
//            holder.addToOrder.setEnabled(false);
//        }

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.d("click deseert --> ", "at : "+position+" quantity :");
//
//                Log.d("Card Activity:",albumList.get(position).getAuthorizedUser());
                if( albumList.get(position).getAuthorizedUser().equals(MainActivity.userEmailAddress) || isAdmin){

                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                    builder.setMessage("Are you sure you want to change this state ?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //update

                                    try {
                                        if (albumList.get(position).getIsAvailable().equals("Yes")){
                                            myRef.child(String.valueOf(albumList.get(position).getKey())).child("isAvailable").setValue("No");
                                        }
                                        else{
                                            myRef.child(String.valueOf(albumList.get(position).getKey())).child("isAvailable").setValue("Yes");
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

}

