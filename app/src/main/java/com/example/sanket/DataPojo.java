package com.example.sanket;

/**
 * Created by Ekta Bhatt on 29-11-2019.
 */
public class DataPojo {
    int img, favIconValue;
    String shopName, foodName, rating, time;
    public DataPojo()
    {

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
}
