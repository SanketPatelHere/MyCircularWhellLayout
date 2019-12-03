package com.example.sanket;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.widget.Toast;

import com.example.sanket.mycircularwhelllayout.FoodActivity;
import com.example.sanket.mycircularwhelllayout.MainActivity;
import com.example.sanket.mycircularwhelllayout.R;
public class ShowShopFoodActivity extends AppCompatActivity {

    Toolbar toolbar;
    ActionBar actionBar;
    MenuItem search;
    SearchView searchView;
    MyClickListener listener;

    ImageView imgFood2, imgFavIcon2;
    TextView tvShopName2, tvFoodName2, tvRating2, tvTime2;

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
