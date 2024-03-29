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
 * Created by Ekta Bhatt on 29-11-2019.
 */
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    Activity activity;
    ArrayList<DataPojo> mylst;
    MyClickListener listener;
    SharedPreferences sp;
    int fav = 0;
    public FoodAdapter(Activity activity, ArrayList<DataPojo> mylst) {
        this.activity = activity;
        this.mylst = mylst;
    }
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

            imgFavIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(fav==0)
                    {
                        imgFavIcon.setImageResource(R.drawable.selected_fav);
                        fav = 1;
                    }
                    else
                    {
                        imgFavIcon.setImageResource(R.drawable.unselected_fav);
                        fav = 0;
                    }
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(FoodAdapter.FoodViewHolder holder, final int position) {
        final DataPojo dp = mylst.get(position);
        holder.imgFood.setImageResource(dp.getImg());
        holder.tvShopName.setText(dp.getShopName());
        holder.tvFoodName.setText(dp.getFoodName());
        holder.tvRating.setText(dp.getRating());
        holder.tvTime.setText(dp.getTime());
        //holder.imgFavIcon.setImageResource(dp.getFavIconValue());

        holder.imgFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.myOnClick((position+1));
                //listener.myOnClick((position+1), dp.getShopName(), dp.getFoodName());
                //listener.myOnClick((position+1), dp.getImg(), dp.getShopName(), dp.getFoodName(), dp.getRating(), dp.getTime(), dp.getFavIconValue());
                listener.myOnClick((position+1), dp.getImg(), dp.getShopName(), dp.getFoodName(), dp.getRating(), dp.getTime(), R.drawable.fav_icon);
            }
        });



        if(dp.getFavIconValue()==0)
        {
            //holder.imgFavIcon.setText(R.drawable.fav_icon);
            holder.imgFavIcon.setImageResource(R.drawable.fav_icon);
        }
    }

    public void setFilter(ArrayList<DataPojo> f)
    {
        mylst = f;
        Log.i("My mylst2 = ",mylst+"");
        notifyDataSetChanged();
    }


}
