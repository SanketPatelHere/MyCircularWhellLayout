package com.example.sanket.mycircularwhelllayout;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sanket.CustomDialogClass;
import com.example.sanket.CustomDialogClass2;
import com.example.sanket.DataPojo;
import com.example.sanket.FoodAdapter;
import com.example.sanket.MyClickListener;
import com.example.sanket.MyScrollingActivity;
import com.example.sanket.ShopFood;
import com.example.sanket.ShowFoodCart;
import com.example.sanket.ShowShopFoodActivity;
import com.michael.easydialog.EasyDialog;

import java.util.ArrayList;

//import androidx.appcompat.app.AppCompatActivity;
//import android.app.Activity.*;
public class FoodActivity extends AppCompatActivity {
    Toolbar toolbar;
    ActionBar actionBar;
    MenuItem search;
    SearchView searchView;
    LinearLayout lv1, lv2;
    RecyclerView rv;
    ArrayList<DataPojo> lst;
    ArrayList<DataPojo> filterList;
    DataPojo dp;
    FoodAdapter fa;
    MyClickListener listener;
    CustomDialogClass2 cd2;
    FrameLayout viewFrame;
    //CustomDialogClass
    Button btnPrice1, btnPrice2, btnPrice3, btnPrice4;
    Button btnTime1, btnTime2, btnTime3;
    Button btnDistance1, btnDistance2, btnDistance3;
    Button btnZone1, btnZone2;
    Button btnTag1, btnTag2;
    TextView yes, no;
    View v;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        viewFrame = (FrameLayout) findViewById(R.id.viewFrame);
        lv1 = (LinearLayout) findViewById(R.id.lv1);
        lv2 = (LinearLayout) findViewById(R.id.lv2);



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
                //Toast.makeText(getApplicationContext(), "MyOnClick with view = "+position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void myOnClick(int position, String shopName, String foodName) {
                Toast.makeText(getApplicationContext(), "MyOnClick = "+position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void myOnClick(int position, int imgFood, String shopName, String foodName, String rating, String time, int imgFavIcon) {
                Toast.makeText(getApplicationContext(), "MyOnClick = "+position, Toast.LENGTH_SHORT).show();
                //Intent i = new Intent(FoodActivity.this, ShowShopFoodActivity.class);
                Intent i = new Intent(FoodActivity.this, ShowFoodCart.class);
                i.putExtra("position",position);
                //Intent i = new Intent(FoodActivity.this, MyScrollingActivity.class);





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
                //cd2.dismiss();
                viewFrame.setVisibility(View.GONE);

            }
        };

        //fa = new FoodAdapter(this, lst);
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

        MenuItem item3 = menu.findItem(R.id.likeCart);
        item3.setVisible(false);
        MenuItem item4 = menu.findItem(R.id.basketCart);
        item4.setVisible(false);
        MenuItem item5 = menu.findItem(R.id.close);
        item5.setVisible(false);

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
    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (item.getItemId()) {
            //int id = item.getItemId();
            case android.R.id.home:
                finish();
                return true;
            case R.id.close:
                Toast.makeText(this, "Close Clicked", Toast.LENGTH_SHORT).show();
                Log.e("My close = ",item+"");
                Log.e("My close = ",item.getItemId()+"");
                //viewFrame.setVisibility(View.GONE);
            case R.id.filter:
                OpenFiltrrDialog(item);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    void OpenFiltrrDialog(final MenuItem item)
    {
        v = getLayoutInflater().inflate(R.layout.dialoglayout, null, false);
        viewFrame.addView(v);
        viewFrame.setTop(-5);

        yes = (TextView)v.findViewById(R.id.btnYes);
        no = (TextView)v.findViewById(R.id.btnNo);

        btnPrice1 = (Button)v.findViewById(R.id.btnPrice1);
        btnPrice2 = (Button)v.findViewById(R.id.btnPrice2);
        btnPrice3 = (Button)v.findViewById(R.id.btnPrice3);
        btnPrice4 = (Button)v.findViewById(R.id.btnPrice4);

        btnTime1 = (Button)v.findViewById(R.id.btnTime1);
        btnTime2 = (Button)v.findViewById(R.id.btnTime2);
        btnTime3 = (Button)v.findViewById(R.id.btnTime3);

        btnDistance1 = (Button)v.findViewById(R.id.btnDistance1);
        btnDistance2 = (Button)v.findViewById(R.id.btnDistance2);
        btnDistance3 = (Button)v.findViewById(R.id.btnDistance3);

        btnZone1 = (Button)v.findViewById(R.id.btnZone1);
        btnZone2 = (Button)v.findViewById(R.id.btnZone2);

        btnTag1 = (Button)v.findViewById(R.id.btnTag1);
        btnTag2 = (Button)v.findViewById(R.id.btnTag2);



        //1.for price
        btnPrice1.performClick();
        //btnPrice1.setBackgroundColor(Color.WHITE);
        btnPrice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonPrice(btnPrice1);
            }
        });
        btnPrice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonPrice(btnPrice2);
            }
        });
        btnPrice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonPrice(btnPrice3);

            }
        });
        btnPrice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonPrice(btnPrice4);
            }
        });

        //2.for time
        //btnTime1.performClick();
        btnTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonTime(btnTime1);
            }
        });
        btnTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonTime(btnTime2);
            }
        });
        btnTime3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonTime(btnTime3);
            }
        });

        //3.for distance
        //btnDistance1.performClick();
        btnDistance1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonDistance(btnDistance1);
            }
        });
        btnDistance2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonDistance(btnDistance2);
            }
        });
        btnDistance3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonDistance(btnDistance3);
            }
        });

        //4.for zone
        //btnZone1.performClick();
        btnZone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonZone(btnZone1);
            }
        });
        btnZone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonZone(btnZone2);
            }
        });


        //5.for tag
        //btnTag1.performClick();
        btnTag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonTag(btnTag1);
            }
        });
        btnTag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setButtonTag(btnTag2);
            }
        });


        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Yessss", Toast.LENGTH_SHORT).show();
                item.setIcon(R.drawable.filter_icon);
                viewFrame.setVisibility(View.GONE);
                Log.i("My dialog = ", "dismiss");
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Noooo", Toast.LENGTH_SHORT).show();
                item.setIcon(R.drawable.filter_icon);
                viewFrame.setVisibility(View.GONE);
                Log.i("My dialog = ", "dismiss");

            }
        });
        item.setIcon(R.drawable.close);
        viewFrame.setVisibility(View.VISIBLE);
    }



    //for CustomDialogClass function
    public void setButtonPrice(Button b)
    {
        /*btnPrice1.setBackgroundColor(Color.WHITE);
        btnPrice2.setBackgroundColor(Color.WHITE);
        btnPrice3.setBackgroundColor(Color.WHITE);
        btnPrice4.setBackgroundColor(Color.WHITE);*/
        //b.setBackgroundColor(Color.parseColor("#049285"));
        btnPrice1.setBackgroundResource(R.drawable.square_roundshape2);
        btnPrice2.setBackgroundResource(R.drawable.square_roundshape2);
        btnPrice3.setBackgroundResource(R.drawable.square_roundshape2);
        btnPrice4.setBackgroundResource(R.drawable.square_roundshape2);
        b.setBackgroundResource(R.drawable.square_roundshape);
    }
    public void setButtonTime(Button b)
    {
        /*btnTime1.setBackgroundColor(Color.WHITE);
        btnTime2.setBackgroundColor(Color.WHITE);
        btnTime3.setBackgroundColor(Color.WHITE);*/
        /*editor.putString("price",b.getId()+"").commit();
        Log.i("My pref = ", sp.getString("price", "null"));
        String s = sp.getString("price", "null");
        if(s.equals(btnTime1.getId()+""))
        {
            b.setBackgroundColor(Color.GREEN);
            Log.i("My if1", " "+s+" "+b.getId());
        }
        if(s.equals(btnTime2.getId()+""))
        {
            b.setBackgroundColor(Color.GREEN);
            Log.i("My if2", " "+s+" "+b.getId());
        }
        if(s.equals(btnTime3.getId()+""))
        {
            b.setBackgroundColor(Color.GREEN);
            Log.i("My if3", " "+s+" "+b.getId());
        }
        else
        {
            Log.i("My else", " "+s+" "+b.getId());

        }*/
        //b.setBackgroundColor(Color.parseColor("#049285"));
        btnTime1.setBackgroundResource(R.drawable.square_roundshape2);
        btnTime2.setBackgroundResource(R.drawable.square_roundshape2);
        btnTime3.setBackgroundResource(R.drawable.square_roundshape2);
        b.setBackgroundResource(R.drawable.square_roundshape);
    }

    public void setButtonDistance(Button b)
    {
        /*btnDistance1.setBackgroundColor(Color.WHITE);
        btnDistance2.setBackgroundColor(Color.WHITE);
        btnDistance3.setBackgroundColor(Color.WHITE);*/
        //b.setBackgroundColor(Color.parseColor("#049285"));

        btnDistance1.setBackgroundResource(R.drawable.square_roundshape2);
        btnDistance2.setBackgroundResource(R.drawable.square_roundshape2);
        btnDistance3.setBackgroundResource(R.drawable.square_roundshape2);
        b.setBackgroundResource(R.drawable.square_roundshape);
    }

    public void setButtonZone(Button b)
    {
        /*btnZone1.setBackgroundColor(Color.WHITE);
        btnZone2.setBackgroundColor(Color.WHITE);*/
        //b.setBackgroundColor(Color.parseColor("#049285"));

        btnZone1.setBackgroundResource(R.drawable.square_roundshape2);
        btnZone2.setBackgroundResource(R.drawable.square_roundshape2);
        b.setBackgroundResource(R.drawable.square_roundshape);
    }

    public void setButtonTag(Button b)
    {
        /*btnTag1.setBackgroundColor(Color.WHITE);
        btnTag2.setBackgroundColor(Color.WHITE);*/
        //b.setBackgroundColor(Color.parseColor("#049285"));
        //b.setBackground(R.drawable.square_roundshape);

        btnTag1.setBackgroundResource(R.drawable.square_roundshape2);
        btnTag2.setBackgroundResource(R.drawable.square_roundshape2);
        b.setBackgroundResource(R.drawable.square_roundshape);
        Drawable d = b.getBackground();
    }

    public void setData(View v, final MenuItem item)
    {

        Log.i("My item = ",item+"");  //Filter
        int id2 = R.drawable.close;
        int b = 1;
        //if(item.toString().equals("Filter"))
        if(id2==R.drawable.close)
        //if(id==)  //2131230825  //2131165301
        {
            //viewFrame.setVisibility(View.GONE);
            Log.i("My View ","Gone");
        }
            
        //CustomDialogClass start/////////////////////////////////

        //CustomDialogClass end/////////////////////////////////
    }
}
