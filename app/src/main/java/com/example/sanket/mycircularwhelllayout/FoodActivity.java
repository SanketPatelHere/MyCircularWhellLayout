package com.example.sanket.mycircularwhelllayout;
import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
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
        lst.add(new DataPojo(R.drawable.bien_bio, 0, "Pizza Coutry", "Italian Pizza", "0.0 (0)", "30 mins"));
        lst.add(new DataPojo(R.drawable.basket_icon, 0, "Pizza Coutry", "Italian Pizza", "0.0 (0)", "30 mins"));
        lst.add(new DataPojo(R.drawable.bein_etre, 0, "Pizza Coutry", "Italian Pizza", "0.0 (0)", "30 mins"));
        lst.add(new DataPojo(R.drawable.marche, 0, "Pizza Coutry", "Italian Pizza", "0.0 (0)", "30 mins"));
        lst.add(new DataPojo(R.drawable.share_icon, 0, "Pizza Coutry", "Italian Pizza", "0.0 (0)", "30 mins"));
        lst.add(new DataPojo(R.drawable.star_icon, 0, "Pizza Coutry", "Italian Pizza", "0.0 (0)", "30 mins"));
        lst.add(new DataPojo(R.drawable.bien_bio, 0, "Pizza Coutry", "Italian Pizza", "0.0 (0)", "30 mins"));



        listener = new MyClickListener() {
            @Override
            public void myOnClick(int position) {
                Toast.makeText(getApplicationContext(), "MyOnClick = "+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void myOnClick(View v, int position) {
                Toast.makeText(getApplicationContext(), "MyOnClick with view = "+position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void myOnLongClick(View v, int position) {
                Toast.makeText(getApplicationContext(), "MyOnLongClick", Toast.LENGTH_SHORT).show();
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

        MenuItem item3 = menu.findItem(R.id.filterClose);
        item3.setVisible(false);

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
                return false;
            }
        });
        return true;
    }
    boolean id2 = true;
    int id;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        id = item.getItemId();

        if(id==R.id.filterClose)
        {
            Drawable myDrawable = getResources().getDrawable(R.drawable.filter_icon);
            item.setIcon(myDrawable);
            id = R.id.filter;
            Log.i("My outer menuicon = ","second false "+id2);
            id2 = true;
        }
        switch (item.getItemId()) {
            //int id = item.getItemId();
            case android.R.id.home:
                finish();
                //NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.filter:
                Toast.makeText(this, "Filter", Toast.LENGTH_SHORT).show();
                //int id = item.getItemId();

                //if(id==R.id.filter)
                //if(id2)
                //{
                    Drawable myDrawable = getResources().getDrawable(R.drawable.close);
                    item.setIcon(myDrawable);
                    Log.i("My menuicon = ","first true "+id2);
                    id = R.id.filterClose;
                    id2 = false;
                //}
                /*else //if(false)
                {
                    Drawable myDrawable = getResources().getDrawable(R.drawable.filter_icon);
                    item.setIcon(myDrawable);
                    Log.i("My menuicon = ","second false "+id2);
                    id2 = true;
                }*/
                CustomDialogClass cd = new CustomDialogClass(this);
                cd.show();
                Drawable myDrawable3 = getResources().getDrawable(R.drawable.filter_icon);
                item.setIcon(myDrawable3);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
