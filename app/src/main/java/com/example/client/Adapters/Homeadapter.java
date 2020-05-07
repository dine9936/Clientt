package com.example.client.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.client.Models.Homemodel;
import com.example.client.R;

import org.w3c.dom.Text;

import java.util.List;

public class Homeadapter extends RecyclerView.Adapter<Homeadapter.VieHolder>{
    public Context mContext;
    public List<Homemodel> mHomeList;

    public Homeadapter(Context mContext, List<Homemodel> mHomeList) {
        this.mContext = mContext;
        this.mHomeList = mHomeList;
    }


    @NonNull
    @Override
    public VieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_home_item,parent,false);

        return new Homeadapter.VieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Homeadapter.VieHolder holder, int position) {

        Homemodel homemodel = mHomeList.get(position);

        holder.itemname.setText(homemodel.getItemName());
        holder.itempricekg.setText(homemodel.getItemPricekg());
        holder.itempricepcs.setText(homemodel.getItemPricepcs());

    }



    @Override
    public int getItemCount() {
        return mHomeList.size();
    }


    public class VieHolder extends RecyclerView.ViewHolder {
        public TextView itemname;
        public TextView itempricekg;
        public TextView itempricepcs;

        public VieHolder(@NonNull View itemView) {
            super(itemView);

            itemname = itemView.findViewById(R.id.item_name);
            itempricekg = itemView.findViewById(R.id.item_price_kg);
            itempricepcs = itemView.findViewById(R.id.item_price_pcs);
        }
    }
}
