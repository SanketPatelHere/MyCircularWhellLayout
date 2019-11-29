package com.example.sanket;

import android.app.Activity;
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
 * Created by Ekta Bhatt on 29-11-2019.
 */
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    ArrayList<DataPojo> mylst;
    Activity activity;
    MyClickListener listener;
    public FoodAdapter(Activity activity, ArrayList<DataPojo> mylst, MyClickListener listener) {
        this.activity = activity;
        this.mylst = mylst;
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return mylst.size();
    }

    @Override
    public FoodAdapter.FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = activity.getLayoutInflater();
        View v = li.inflate(R.layout.rv_layout, parent, false);
        return new FoodViewHolder(v);
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{
        ImageView imgFood, imgFavIcon;
        TextView imgFavIcon2;
        TextView tvShopName, tvFoodName, tvRating, tvTime;
        public FoodViewHolder(View itemView) {
            super(itemView);
            imgFood = (ImageView)itemView.findViewById(R.id.imgFood);
            tvShopName = (TextView) itemView.findViewById(R.id.tvShopName);
            tvFoodName = (TextView) itemView.findViewById(R.id.tvFoodName);
            tvRating = (TextView) itemView.findViewById(R.id.tvRating);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            imgFavIcon = (ImageView) itemView.findViewById(R.id.imgFavIcon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //DataPojo dp = mylst.get(position);
                    listener.myOnClick(v,10);

                }
            });
        }
    }

    @Override
    public void onBindViewHolder(FoodAdapter.FoodViewHolder holder, final int position) {
        DataPojo dp = mylst.get(position);
        holder.imgFood.setImageResource(dp.getImg());
        holder.tvShopName.setText(dp.getShopName());
        holder.tvFoodName.setText(dp.getFoodName());
        holder.tvRating.setText(dp.getRating());
        holder.tvTime.setText(dp.getTime());
        holder.imgFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.myOnClick((position+1));
            }
        });



        if(dp.getFavIconValue()==0)
        {
            //holder.imgFavIcon.setText(R.drawable.fav_icon);
            holder.imgFavIcon.setImageResource(R.drawable.fav_icon);
        }
    }


}
