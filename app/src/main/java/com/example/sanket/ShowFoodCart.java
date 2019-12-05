package com.example.sanket;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Toast;

import com.example.sanket.mycircularwhelllayout.FoodActivity;
import com.example.sanket.mycircularwhelllayout.MainActivity;
import com.example.sanket.mycircularwhelllayout.R;

import java.util.ArrayList;
import java.util.List;

public class ShowFoodCart extends AppCompatActivity //implements SearchView.OnQueryTextListener
{

    Toolbar toolbar;
    ActionBar actionBar;
    MenuItem search;
    SearchView searchView;
    MyClickListener listener;

    ImageView imgFood2, imgFavIcon2;
    TextView tvShopName2, tvFoodName2, tvRating2, tvTime2;

    RecyclerView rv2;
    ArrayList<ShopFood> lstShopFood;
    ArrayList<ShopFood> filterList;
    ShopFoodAdapter sfd;
    TextView tvQuantity;
    int fav = 0;
    SharedPreferences sp;
    Button btnCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_food_cart);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        final int position = getIntent().getExtras().getInt("position");
        Log.i("My position = ",position+"");
        imgFood2 = (ImageView)findViewById(R.id.imgFood2);
        tvShopName2 = (TextView) findViewById(R.id.tvShopName2);
        tvFoodName2 = (TextView) findViewById(R.id.tvFoodName2);
        tvRating2 = (TextView) findViewById(R.id.tvRating2);
        tvTime2 = (TextView) findViewById(R.id.tvTime2);
        imgFavIcon2 = (ImageView)findViewById(R.id.imgFavIcon2);
        tvQuantity = (TextView)findViewById(R.id.tvQuantity);
        btnCart = (Button) findViewById(R.id.btnCart);
        //Intent i = getIntent();
        //String data = getIntent().getStringExtra("data");

        //Toast.makeText(MainActivity .this, "Anything", Toast.LENGTH_SHORT).show();
        //Log.i("My data", data+"");
        Bundle data = getIntent().getExtras();
        DataPojo dp = (DataPojo)data.getParcelable("data");
        Log.i("My data", dp+"");
        //Log.i("My getImg", dp.getImg()+"");
        //Log.i("My getFavIconValue", dp.getFavIconValue()+"");
        Log.i("My getShopName", dp.getShopName()+"");
        Log.i("My getFoodName", dp.getFoodName()+"");
        Log.i("My getRating", dp.getRating()+"");
        Log.i("My getTime", dp.getTime()+"");

        //for pass data to next screen
        imgFood2.setImageResource(dp.getImg());
        tvFoodName2.setText(dp.getFoodName());
        tvShopName2.setText(dp.getShopName());
        tvRating2.setText(dp.getRating());
        tvTime2.setText(dp.getTime());
        imgFavIcon2.setImageResource(dp.getFavIconValue());

        rv2 = (RecyclerView)findViewById(R.id.rv2);
        lstShopFood = new ArrayList<>();
        lstShopFood.add(new ShopFood(R.drawable.marche, "Orange juice 1","₹ 10"));
        lstShopFood.add(new ShopFood(R.drawable.jai_faim, "Orange shake 1","₹ 20"));
        lstShopFood.add(new ShopFood(R.drawable.marche, "Mango juice 2","₹ 10"));
        lstShopFood.add(new ShopFood(R.drawable.jai_faim, "Mango shake 2","₹ 20"));
        lstShopFood.add(new ShopFood(R.drawable.marche, "Abc icecream","₹ 20"));
        lstShopFood.add(new ShopFood(R.drawable.jai_faim, "Aaa cake shop","₹ 20"));
        lstShopFood.add(new ShopFood(R.drawable.marche, "Xyz nuddles","₹ 20"));
        lstShopFood.add(new ShopFood(R.drawable.jai_faim, "Zzz chocolate","₹ 20"));


        listener = new MyClickListener() {
            @Override
            public void myOnClick(int position) {
                Toast.makeText(getApplicationContext(), "MyOnClick = "+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void myOnClick(View v, int position) {
                //Toast.makeText(getApplicationContext(), "MyOnClick with view = "+position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void myOnClick(int position, String shopName, String foodName) {
                Toast.makeText(getApplicationContext(), "MyOnClick = "+position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void myOnClick(int position, int imgFood, String shopName, String foodName, String rating, String time, int imgFavIcon) {
                Toast.makeText(getApplicationContext(), "MyOnClick = "+position, Toast.LENGTH_SHORT).show();

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

        sfd = new ShopFoodAdapter(this, lstShopFood, position);
        //sfd = new ShopFoodAdapter(this, lstShopFood, position, sp.getInt("fav",-1));
        //sfd.notifyDataSetChanged();
        rv2.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rv2.setAdapter(sfd);

        sp = getApplicationContext().getSharedPreferences("MyPrefData",0);
        final SharedPreferences.Editor editor = sp.edit();
        //editor.putInt("fav",fav).commit();
        if(sp.getInt("fav",-1)==0)
        {
            imgFavIcon2.setImageResource(R.drawable.unselected_fav);
            Log.i("My unfav = ",sp.getInt("fav",-1)+"");
        }
        else if(sp.getInt("fav",-1)==1)
        {
            imgFavIcon2.setImageResource(R.drawable.selected_fav);
            Log.i("My fav = ",sp.getInt("fav",-1)+"");

        }
        else
        {
            Log.i("My fav = ","else");
        }
        imgFavIcon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if(fav==0)
                if(sp.getInt("fav", -1)==0)
                {
                    imgFavIcon2.setImageResource(R.drawable.selected_fav);
                    fav = 1;
                    editor.putInt("fav",fav).commit();
                    editor.putInt("positionAt",position).commit();
                    Log.i("My selected fav = ",fav+" "+sp.getInt("fav",-1));
                }
                else
                {
                    imgFavIcon2.setImageResource(R.drawable.unselected_fav);
                    //fav = 0;
                    editor.putInt("fav",fav).commit();
                    editor.putInt("positionAt",position).commit();
                    Log.i("My unselected fav = ",fav+" "+sp.getInt("fav",-1));
                }
            }
        });
        
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ShowFoodCart.this, "Cart", Toast.LENGTH_SHORT).show();
            }
        });

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

        MenuItem item3 = menu.findItem(R.id.filter);
        item3.setVisible(false);
        /*MenuItem item4 = menu.findItem(R.id.basketCart);
        item4.setVisible(false);*/

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
                Toast.makeText(ShowFoodCart.this, "Searching for = "+newText, Toast.LENGTH_SHORT).show();

                if(newText.isEmpty())
                {
                    filterList = lstShopFood;
                    tvQuantity.setText("search another item");
                }
                else
                {
                    ArrayList<ShopFood> filteredList = new ArrayList<>();
                    for(ShopFood row:lstShopFood)
                    {
                        Log.i("My row.getFoodName() = ",row.getFoodName()+"");
                        if(row.getFoodName().toLowerCase().contains(newText.toLowerCase()))
                        {
                            filteredList.add(row);
                        }
                        else
                        {
                            tvQuantity.setText("search another item");
                        }
                        filterList = filteredList;
                        tvQuantity.setText(newText+" ("+filterList.size()+" items)");

                    }
                }

                //tvQuantity.setText("more items");
                sfd.setFilter(filterList);
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
                cd.getWindow().setGravity(Gravity.TOP|Gravity.RIGHT);
                WindowManager.LayoutParams layoutParams = cd.getWindow().getAttributes();
                layoutParams.y = 100; // bottom margin  //for put space for top
                cd.getWindow().setAttributes(layoutParams);
                cd.setCancelable(false);  //both same work = not close dialog without yes, no
                //cd.setCanceledOnTouchOutside(false);
                cd.show();

                return true;
            case R.id.likeCart:
                Toast.makeText(this, "like cart", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.basketCart:
                Toast.makeText(this, "basket cart", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    


}
