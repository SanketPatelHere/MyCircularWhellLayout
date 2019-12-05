package com.example.sanket;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sanket.mycircularwhelllayout.R;

import java.util.ArrayList;

/**
 * Created by Ekta Bhatt on 03-12-2019.
 */
public class ShopFoodAdapter extends RecyclerView.Adapter<ShopFoodAdapter.MyShopFoodAdapter> {
    Activity activity;
    ArrayList<ShopFood> mylst2;
    SharedPreferences sp;
    int position;
    int fav = 0;
    public ShopFoodAdapter(Activity activity, ArrayList<ShopFood> mylst2)
    {
        this.activity = activity;
        this.mylst2 = mylst2;
    }
    public ShopFoodAdapter(Activity activity, ArrayList<ShopFood> mylst2, int position)
    {
        this.activity = activity;
        this.mylst2 = mylst2;
        //position = sp.getInt("fav",-1);
        this.position = position;
        Log.i("My Adapter position = ",position+"");
    }
    public ShopFoodAdapter(Activity activity, ArrayList<ShopFood> mylst2, int position, int fav)
    {
        this.activity = activity;
        this.mylst2 = mylst2;
        //position = sp.getInt("fav",-1);
        this.position = position;
        this.fav = fav;
        Log.i("My Adapter position = ",position+"");
        Log.i("My Adapter fav = ",fav+"");
    }
    @Override
    public int getItemCount()
    {
        return mylst2.size();
    }
    @Override
    public MyShopFoodAdapter onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater li = activity.getLayoutInflater();
        View v = li.inflate(R.layout.sub_rv_layout, parent, false);
        return new MyShopFoodAdapter(v);
    }
    public class MyShopFoodAdapter extends RecyclerView.ViewHolder {
        ImageView imgFood2;
        TextView tvFoodsName2, tvPrice2, tvSubFoodName2;
        public MyShopFoodAdapter(View itemView) {
            super(itemView);
            imgFood2 = (ImageView)itemView.findViewById(R.id.imgFood2);
            tvFoodsName2 = (TextView) itemView.findViewById(R.id.tvFoodsName2);
            tvSubFoodName2 = (TextView) itemView.findViewById(R.id.tvSubFoodsName2);
            tvPrice2 = (TextView) itemView.findViewById(R.id.tvPrice2);

            //listener.myOnClick(v,10);
        }
    }
    @Override
    public void onBindViewHolder(MyShopFoodAdapter holder, int position) {
        ShopFood sf = mylst2.get(position);
        holder.imgFood2.setImageResource(sf.getImg());
        holder.tvFoodsName2.setText(sf.getFoodName());
        holder.tvSubFoodName2.setText(sf.getFoodName());
        holder.tvPrice2.setText(sf.getPrice()+".00");


    }

    public void setFilter(ArrayList<ShopFood> f)
    {
        mylst2 = f;
        Log.i("My mylst2 = ",mylst2+"");
        notifyDataSetChanged();
    }




}
