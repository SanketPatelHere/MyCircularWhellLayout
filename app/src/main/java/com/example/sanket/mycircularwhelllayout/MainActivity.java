package com.example.sanket.mycircularwhelllayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sanket.mycircularwhelllayout.Adapter.WheelImageAdapter;
import com.example.sanket.mycircularwhelllayout.Adapter.WheelTextAdapter;
import com.example.sanket.mycircularwhelllayout.Data.ImageData;
import com.example.sanket.mycircularwhelllayout.Data.MenuItemData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import github.hellocsl.cursorwheel.CursorWheelLayout;

public class MainActivity extends AppCompatActivity implements CursorWheelLayout.OnMenuSelectedListener{
    CursorWheelLayout wheel_text, wheel_image;
    List<MenuItemData> lstText;
    List<ImageData> lstImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        loadData();
        wheel_text.setOnMenuSelectedListener(this);
        wheel_image.setOnMenuSelectedListener(this);

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
        lstImage.add(new ImageData(R.drawable.bein_etre, "Bein_etre"));
        lstImage.add(new ImageData(R.drawable.bien_bio, "Bien_bio"));
        lstImage.add(new ImageData(R.drawable.marche, "Marche"));
        lstImage.add(new ImageData(R.drawable.jai_faim, "Jai_faim"));
        lstImage.add(new ImageData(R.drawable.chhouitte, "Chhouitte"));

        WheelImageAdapter imageAdapter = new WheelImageAdapter(getBaseContext(), lstImage);
        wheel_image.setAdapter(imageAdapter);

    }

    private void initViews()
    {
        wheel_text = (CursorWheelLayout)findViewById(R.id.wheel_text);
        wheel_image = (CursorWheelLayout)findViewById(R.id.wheel_image);
    }

    @Override
    public void onItemSelected(CursorWheelLayout parent, View view, int pos) {
        if(parent.getId()==R.id.wheel_text)
        {
            Toast.makeText(this, "Selected = "+lstText.get(pos).mTitel, Toast.LENGTH_SHORT).show();
        }
        else if(parent.getId()==R.id.wheel_image)
        {
            Toast.makeText(this, "Selected = "+lstImage.get(pos).imageDescription, Toast.LENGTH_SHORT).show();
        }

    }
}
