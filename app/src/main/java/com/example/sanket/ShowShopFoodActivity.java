package com.example.sanket;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
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

public class ShowShopFoodActivity extends AppCompatActivity //implements SearchView.OnQueryTextListener
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_shop_food);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        imgFood2 = (ImageView)findViewById(R.id.imgFood2);
        tvShopName2 = (TextView) findViewById(R.id.tvShopName2);
        tvFoodName2 = (TextView) findViewById(R.id.tvFoodName2);
        tvRating2 = (TextView) findViewById(R.id.tvRating2);
        tvTime2 = (TextView) findViewById(R.id.tvTime2);
        imgFavIcon2 = (ImageView)findViewById(R.id.imgFavIcon2);
        tvQuantity = (TextView)findViewById(R.id.tvQuantity);
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

        sfd = new ShopFoodAdapter(this, lstShopFood);
        //sfd.notifyDataSetChanged();
        rv2.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rv2.setAdapter(sfd);

        sp = getApplicationContext().getSharedPreferences("MyPrefData",0);
        final SharedPreferences.Editor editor = sp.edit();
        editor.putInt("fav",fav).commit();


        imgFavIcon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if(fav==0)
                if(sp.getInt("fav", -1)==0)
                {
                    imgFavIcon2.setImageResource(R.drawable.selected_fav);
                    fav = 1;
                    editor.putInt("fav",fav).commit();
                }
                else
                {
                    imgFavIcon2.setImageResource(R.drawable.unselected_fav);
                    fav = 0;
                    editor.putInt("fav",fav).commit();
                }
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
                Toast.makeText(ShowShopFoodActivity.this, "Searching for = "+newText, Toast.LENGTH_SHORT).show();

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
