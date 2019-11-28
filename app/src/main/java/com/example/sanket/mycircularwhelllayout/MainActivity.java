package com.example.sanket.mycircularwhelllayout;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.example.sanket.mycircularwhelllayout.Adapter.WheelImageAdapter;
import com.example.sanket.mycircularwhelllayout.Adapter.WheelTextAdapter;
import com.example.sanket.mycircularwhelllayout.Data.ImageData;
import com.example.sanket.mycircularwhelllayout.Data.MenuItemData;
//import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import github.hellocsl.cursorwheel.CursorWheelLayout;

public class MainActivity extends AppCompatActivity implements CursorWheelLayout.OnMenuSelectedListener{
    NavigationView nv;
    DrawerLayout d;
    ActionBarDrawerToggle a;
    MenuItem search;
    SearchView searchView;
    Button btnDelivery;

    CursorWheelLayout wheel_text, wheel_image;
    List<MenuItemData> lstText;
    List<ImageData> lstImage;
    FrameLayout fmCenter;
    FloatingActionMenu actionMenu, actionMenu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDelivery = (Button)findViewById(R.id.btnDelivery);

        initViews();
        loadData();
        wheel_text.setOnMenuSelectedListener(this);
        wheel_image.setOnMenuSelectedListener(this);

        btnDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Location", Toast.LENGTH_SHORT).show();
            }
        });




        getSupportActionBar().setDisplayShowTitleEnabled(false);

        d = (DrawerLayout)findViewById(R.id.d);
        a = new ActionBarDrawerToggle(this, d, R.string.Open,R.string.Close);
        //a = new ActionBarDrawerToggle(this, d, "open", "close");
        a.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.nav);
        nv =(NavigationView)findViewById(R.id.nav_view);
        NavigationMenuView nmv = (NavigationMenuView)nv.getChildAt(0);
        nv.setItemTextColor(null);
        nv.setItemTextAppearance(R.style.MenuTextStyle);


        nmv.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //menuItem.findItem(R.id.search).setVisible(false);

                switch (menuItem.getItemId())
                {
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "Navigation My Home", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.basket:
                        Toast.makeText(MainActivity.this, "Navigation My Basket", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.orders:
                        Toast.makeText(MainActivity.this, "Navigation My Orders", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.account:
                        Toast.makeText(MainActivity.this, "Navigation My Account", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return true;
                }
            }
        });


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
                Toast.makeText(MainActivity.this, "Text change = "+newText, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(a.onOptionsItemSelected(item))
        {
            //Toast.makeText(this, "true", Toast.LENGTH_SHORT).show();
            if(d.isDrawerOpen(GravityCompat.START))
            {
                d.closeDrawer(GravityCompat.START);
            }
            else
            {
                d.openDrawer(GravityCompat.START);
            }
            return true;
        }
        switch (item.getItemId())
        {
            case R.id.home:
                Toast.makeText(MainActivity.this, "Navigation My Home", Toast.LENGTH_SHORT).show();
            case R.id.basket:
                Toast.makeText(MainActivity.this, "Navigation My Basket", Toast.LENGTH_SHORT).show();
            case R.id.orders:
                Toast.makeText(MainActivity.this, "Navigation My Orders", Toast.LENGTH_SHORT).show();
            case R.id.account:
                Toast.makeText(MainActivity.this, "Navigation My Account", Toast.LENGTH_SHORT).show();
            default:
                return true;
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        d.closeDrawer(GravityCompat.START);
    }

    private void loadData() {
        lstText = new ArrayList<>();
        for(int i=0;i<9;i++)
        {
            lstText.add(new MenuItemData(""+i));
        }
        lstText.add(new MenuItemData("OFF"));
        WheelTextAdapter adapter = new WheelTextAdapter(getBaseContext(), lstText);
        wheel_text.setAdapter(adapter);

        lstImage = new ArrayList<>();
        //lstImage.add(new ImageData(R.drawable.anything_icon, "Anything"));
        lstImage.add(new ImageData(R.drawable.bein_etre, "Bein etre"));
        lstImage.add(new ImageData(R.drawable.bien_bio, "Bien bio"));
        lstImage.add(new ImageData(R.drawable.marche, "Marche"));
        lstImage.add(new ImageData(R.drawable.jai_faim, "Jai faim"));
        lstImage.add(new ImageData(R.drawable.chhouitte, "Chhouitte"));
        lstImage.add(new ImageData(R.drawable.coursier, "Courier"));

        WheelImageAdapter imageAdapter = new WheelImageAdapter(getBaseContext(), lstImage);
        wheel_image.setAdapter(imageAdapter);
        
        fmCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Anything", Toast.LENGTH_SHORT).show();
            }
        });

        wheel_image.setOnMenuItemClickListener(new CursorWheelLayout.OnMenuItemClickListener() {
            @Override
            public void onItemClick(View view, int pos) {
                //actionMenu.close(true);
                Log.i("My Menu = ","setOnMenuItemClickListener");
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void initViews()
    {
        wheel_text = (CursorWheelLayout)findViewById(R.id.wheel_text);
        wheel_image = (CursorWheelLayout)findViewById(R.id.wheel_image);
        fmCenter = (FrameLayout) findViewById(R.id.fmCenter);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onItemSelected(CursorWheelLayout parent, View view, int pos) {
        if(parent.getId()==R.id.wheel_text)
        {
            Toast.makeText(this, "Selected = "+lstText.get(pos).mTitel, Toast.LENGTH_SHORT).show();
        }
        else if(parent.getId()==R.id.wheel_image)
        {
            /*if(actionMenu.isOpen()==true)
            {
                actionMenu.close(true);
            }*/
            Toast.makeText(this, "Selected = "+lstImage.get(pos).imageDescription, Toast.LENGTH_SHORT).show();
            if(lstImage.get(pos).imageDescription=="Courier")
            {

                //Button btn = lstImage.get(pos).imageDescription;
                //Toast.makeText(this, "Courier", Toast.LENGTH_SHORT).show();
                ///////for subactionbutton = fab button ///////////
                SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
                final ImageView itemIcon1 = new ImageView(this);
                final ImageView itemIcon2 = new ImageView(this);
                final ImageView itemIcon3 = new ImageView(this);

                itemIcon1.setImageDrawable(getResources().getDrawable(R.drawable.bein_etre));
                itemIcon2.setImageDrawable(getResources().getDrawable(R.drawable.bien_bio));
                itemIcon3.setImageDrawable(getResources().getDrawable(R.drawable.chhouitte));

                //itemIcon1.getLayoutParams().width = 150;
                //itemIcon1.getLayoutParams().height = 150;
                SubActionButton button1 = itemBuilder.setContentView(itemIcon1).build();
                SubActionButton button2 = itemBuilder.setContentView(itemIcon2).build();
                SubActionButton button3 = itemBuilder.setContentView(itemIcon3).build();
                AppBarLayout.LayoutParams params=new AppBarLayout.LayoutParams(150,150);
                button1.setLayoutParams(params);
                button2.setLayoutParams(params);
                button3.setLayoutParams(params);


                //ImageView bt = (ImageView)findViewById(R.id.wheel_image);
                //FrameLayout btn1 = (FrameLayout)findViewById(R.id.fmCenter);
                ///
                actionMenu = new FloatingActionMenu.Builder(this)
                        .addSubActionView(button1)
                        .addSubActionView(button2)
                        .addSubActionView(button3)
                        .setRadius(180)
                        .setStartAngle(0)
                        .setEndAngle(180)
                        .attachTo(view)
                        .build();

                actionMenu.setStateChangeListener(new FloatingActionMenu.MenuStateChangeListener() {
                    @Override
                    public void onMenuOpened(FloatingActionMenu floatingActionMenu) {


                    }

                    @Override
                    public void onMenuClosed(FloatingActionMenu floatingActionMenu) {

                    }

                });

                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //serviceWillBeDismissed = true; // the order is important
                        actionMenu.close(true);
                        Toast.makeText(MainActivity.this, "button1", Toast.LENGTH_SHORT).show();
                    }
                });
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //serviceWillBeDismissed = true; // the order is important
                        actionMenu.close(true);
                        Toast.makeText(MainActivity.this, "button2", Toast.LENGTH_SHORT).show();
                    }
                });
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //serviceWillBeDismissed = true; // the order is important
                        actionMenu.close(true);
                        Toast.makeText(MainActivity.this, "button3", Toast.LENGTH_SHORT).show();
                    }
                });

                ///////////////////////////////////////////////////




            }
        }

    }

}
