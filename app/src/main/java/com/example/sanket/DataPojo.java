package com.example.sanket;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ekta Bhatt on 29-11-2019.
 */
public class DataPojo implements Parcelable {
    int img, favIconValue;
    String shopName, foodName, rating, time;
    public DataPojo()
    {

    }
    public DataPojo(String shopName, String foodName) {
        this.shopName = shopName;
        this.foodName = foodName;

    }
    public DataPojo(int img, int favIconValue, String shopName, String foodName, String rating, String time) {
        this.img = img;
        this.favIconValue = favIconValue;
        this.shopName = shopName;
        this.foodName = foodName;
        this.rating = rating;
        this.time = time;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getFavIconValue() {
        return favIconValue;
    }

    public void setFavIconValue(int favIconValue) {
        this.favIconValue = favIconValue;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    //parcelling part
    public DataPojo(Parcel in)
    {
        String data[] = new String[6];
        in.readStringArray(data);
        this.img = Integer.parseInt(data[0]);
        this.favIconValue = Integer.parseInt(data[1]);
        this.shopName = data[2];
        this.foodName = data[3];
        this.rating = data[4];
        this.time = data[5];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //dest.writeStringArray(new String[]{this.shopName, this.foodName});
        dest.writeStringArray(new String[]{this.img+"", this.favIconValue+"", this.shopName, this.foodName, this.rating, this.time});
    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){

        @Override
        public DataPojo createFromParcel(Parcel in) {
            return new DataPojo(in);
        }

        @Override
        public DataPojo[] newArray(int size) {
            return new DataPojo[size];
        }
    };
}
