package com.example.sanket;

/**
 * Created by Ekta Bhatt on 03-12-2019.
 */
public class ShopFood {
    int img;
    String foodName;
    String price;
    public ShopFood()
    {

    }
    public ShopFood(int img, String foodName, String price) {
        this.img = img;
        this.foodName = foodName;
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
