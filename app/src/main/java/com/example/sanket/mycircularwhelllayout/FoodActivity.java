package com.example.sanket.mycircularwhelllayout;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sanket.CustomDialogClass;
import com.example.sanket.DataPojo;
import com.example.sanket.FoodAdapter;
import com.example.sanket.MyClickListener;
import com.example.sanket.ShopFood;
import com.example.sanket.ShowShopFoodActivity;

import java.util.ArrayList;

//import androidx.appcompat.app.AppCompatActivity;
//import android.app.Activity.*;
public class FoodActivity extends AppCompatActivity {
    Toolbar toolbar;
    ActionBar actionBar;
    MenuItem search;
    SearchView searchView;

    RecyclerView rv;
    ArrayList<DataPojo> lst;
    ArrayList<DataPojo> filterList;
    DataPojo dp;
    FoodAdapter fa;
    MyClickListener listener;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        /*actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);*/

        //toolbar.setNavigationIcon(R.drawable.anything_icon);




        rv = (RecyclerView)findViewById(R.id.rv);
        lst = new ArrayList<>();
        lst.add(new DataPojo(R.drawable.chhouitte, 0, "Ice cream parlor", "chocolate ice creame", "0.0", "40 mins"));
        lst.add(new DataPojo(R.drawable.jai_faim, 0, "Pizza Coutry", "Italian Pizza", "0.0 (0)", "30 mins"));
        lst.add(new DataPojo(R.drawable.chhouitte, 0, "Pizza Studio", "Italian Pizza", "0.0 (0)", "30 mins"));
        lst.add(new DataPojo(R.drawable.jai_faim, 0, "Ice cream one", "Italian Pizza", "0.0 (0)", "30 mins"));
        lst.add(new DataPojo(R.drawable.chhouitte, 0, "One shop", "Italian Pizza", "0.0 (0)", "30 mins"));
        lst.add(new DataPojo(R.drawable.jai_faim, 0, "Your shop", "Italian Pizza", "0.0 (0)", "30 mins"));
        lst.add(new DataPojo(R.drawable.chhouitte, 0, "Mac Donalds", "Italian Pizza", "0.0 (0)", "30 mins"));
        lst.add(new DataPojo(R.drawable.jai_faim , 0, "Chocolate shake", "Italian Pizza", "0.0 (0)", "30 mins"));



        listener = new MyClickListener() {
            @Override
            public void myOnClick(int position) {
                Toast.makeText(getApplicationContext(), "MyOnClick = "+position, Toast.LENGTH_SHORT).show();
                //Intent i = new Intent(FoodActivity.this, ShowShopFoodActivity.class);
                //i.putExtra("data",lst.get(new DataPojo(position)));
                //i.putExtra("data", lst.get(position));
                //i.putExtra("data", new DataPojo("Pizza Coutry", "Italian Pizza"));
                //i.putExtra("data", new DataPojo(R.drawable.bien_bio , 0, "Pizza Coutry", "Italian Pizza", "0.0 (0)", "30 mins"));
                //startActivity(i);
            }

            @Override
            public void myOnClick(View v, int position) {
                Toast.makeText(getApplicationContext(), "MyOnClick with view = "+position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void myOnClick(int position, String shopName, String foodName) {
                Toast.makeText(getApplicationContext(), "MyOnClick = "+position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void myOnClick(int position, int imgFood, String shopName, String foodName, String rating, String time, int imgFavIcon) {
                Toast.makeText(getApplicationContext(), "MyOnClick = "+position, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(FoodActivity.this, ShowShopFoodActivity.class);
                //i.putExtra("data",lst.get(new DataPojo(position)));
                //i.putExtra("data", lst.get(position));
                //i.putExtra("data", new DataPojo("Pizza Coutry", "Italian Pizza"));
                //i.putExtra("data", new DataPojo(shopName, foodName));
                i.putExtra("data", new DataPojo(imgFood, imgFavIcon, shopName, foodName, rating, time));
                //i.putExtra("data", new DataPojo(R.drawable.bien_bio , 0, "Pizza Coutry", "Italian Pizza", "0.0 (0)", "30 mins"));
                startActivity(i);
            }

            @Override
            public void myOnLongClick(View v, int position) {
                Toast.makeText(getApplicationContext(), "MyOnLongClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void myOnDialogClose(MenuItem item) {
                //for once again set filter icon = when dialog close
                //Toast.makeText(getApplicationContext(), "myOnDialogClose = "+item, Toast.LENGTH_SHORT).show();
                item.setIcon(R.drawable.filter_icon);
            }
        };

        fa = new FoodAdapter(this, lst, listener);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(fa);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //Toast.makeText(this, "finish", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.search_menu, menu);


        search = menu.findItem(R.id.search);
        searchView  = (SearchView) MenuItemCompat.getActionView(search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(FoodActivity.this, "Searching for = "+newText, Toast.LENGTH_SHORT).show();
                if(newText.isEmpty())
                {
                    filterList = lst;
                }
                else
                {
                    ArrayList<DataPojo> filteredList = new ArrayList<>();
                    for(DataPojo row:lst)
                    {
                        Log.i("My row.getFoodName() = ",row.getFoodName()+"");
                        if(row.getShopName().toLowerCase().contains(newText.toLowerCase()) || row.getFoodName().toLowerCase().contains(newText.toLowerCase()))
                        {
                            filteredList.add(row);
                        }
                        filterList = filteredList;
                    }
                }


                fa.setFilter(filterList);
                return false;
            }
        });
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (item.getItemId()) {
            //int id = item.getItemId();
            case android.R.id.home:
                finish();
                return true;
            case R.id.filter:
                //Toast.makeText(this, "Filter", Toast.LENGTH_SHORT).show();
                    Drawable myDrawable = getResources().getDrawable(R.drawable.close);
                    item.setIcon(myDrawable);
                CustomDialogClass cd = new CustomDialogClass(this, listener, item);

                /*RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) tv.getLayoutParams();
                lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                tv.setLayoutParams(lp);*/

                cd.show();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
