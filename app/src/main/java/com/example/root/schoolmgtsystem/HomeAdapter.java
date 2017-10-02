package com.example.root.schoolmgtsystem;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    //Memeber variables
    private ArrayList<HomeModel> mHomeData;
    private Context mContext;

    //Constructor that passes the homeData and mContext
    public HomeAdapter(Context context, ArrayList<HomeModel> homeData) {
        this.mHomeData = homeData;
        this.mContext = context;
    }

    //Required method for creatimg the viewHolder object
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.home_main_layout, parent, false));
    }

    //Required method that binds the method to the ViewHolder
    @Override
    public void onBindViewHolder(HomeAdapter.ViewHolder holder, int position) {
        //Get current homeImage
        HomeModel mCurrentImage = mHomeData.get(position);
        //Retrieve image resource from image object
        Glide.with(mContext).load(mCurrentImage.getImageResource()).into(holder.homeImages);
        //Populate the imageView with data
        holder.bindTo(mCurrentImage);

    }

    @Override
    public int getItemCount() {
        return mHomeData.size();
    }

    //ViewHolder class that represents each row of data in the recycler view
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //Member variables for the TextView and ImageView
        private TextView homeText;
        private ImageView homeImages;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            homeText = (TextView)itemView.findViewById(R.id.name);
            homeImages = (ImageView)itemView.findViewById(R.id.image);
        }

        @Override
        public void onClick(View view) {

        }

        public void bindTo(HomeModel mCurrentImage) {
            //Bind the corresponding text to images
            homeText.setText(mCurrentImage.getTitle());
        }
    }
}
