package com.finalexam.rentalcar;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter extends RecyclerView.Adapter {
    private Integer[] mData;
    private LayoutInflater mInflater;
    private ItemClickListener itemClickListener;
    //ImageView image;

    public ImageAdapter(Context context, Integer[] data){
        mInflater = LayoutInflater.from(context);
        mData = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycleviewritem ,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).image.setImageResource(mData[position]);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    void setClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    Integer getItem(int id){
        return mData[id];
    }

    //inner class
    public class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener{

        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imgSmall);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(itemClickListener!=null)
                itemClickListener.onItemClick(v,getAdapterPosition());
        }
    }

    //inner interface
    public interface ItemClickListener{
        void onItemClick(View view,int position);
    }

}
