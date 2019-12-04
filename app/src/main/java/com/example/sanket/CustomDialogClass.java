package com.example.sanket;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sanket.mycircularwhelllayout.R;

/**
 * Created by Ekta Bhatt on 29-11-2019.
 */
public class CustomDialogClass extends Dialog implements View.OnClickListener {
    public Activity c;
    public Dialog d;
    public Button yes, no;
    MyClickListener listener;
    MenuItem item;
    Button btnPrice1, btnPrice2, btnPrice3, btnPrice4;
    Button btnTime1, btnTime2, btnTime3;
    Button btnDistance1, btnDistance2, btnDistance3;
    Button btnZone1, btnZone2;
    Button btnTag1, btnTag2;
            ;
    public CustomDialogClass(Activity a, MyClickListener listener, MenuItem item) {
        super(a);
        this.c = a;
        this.listener = listener;
        this.item = item;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialoglayout);

        yes = (Button)findViewById(R.id.btnYes);
        no = (Button)findViewById(R.id.btnNo);

        btnPrice1 = (Button)findViewById(R.id.btnPrice1);
        btnPrice2 = (Button)findViewById(R.id.btnPrice2);
        btnPrice3 = (Button)findViewById(R.id.btnPrice3);
        btnPrice4 = (Button)findViewById(R.id.btnPrice4);

        btnTime1 = (Button)findViewById(R.id.btnTime1);
        btnTime2 = (Button)findViewById(R.id.btnTime2);
        btnTime3 = (Button)findViewById(R.id.btnTime3);

        btnDistance1 = (Button)findViewById(R.id.btnDistance1);
        btnDistance2 = (Button)findViewById(R.id.btnDistance2);
        btnDistance3 = (Button)findViewById(R.id.btnDistance3);

        btnZone1 = (Button)findViewById(R.id.btnZone1);
        btnZone2 = (Button)findViewById(R.id.btnZone2);

        btnTag1 = (Button)findViewById(R.id.btnTag1);
        btnTag2 = (Button)findViewById(R.id.btnTag2);



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
                Toast.makeText(c, "Yessss", Toast.LENGTH_SHORT).show();
                listener.myOnDialogClose(item);
                dismiss();
                Log.i("My dialog = ", "dismiss");
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, "Noooo", Toast.LENGTH_SHORT).show();
                listener.myOnDialogClose(item);
                dismiss();
                Log.i("My dialog = ", "dismiss");

            }
        });
        //listener.myOnDialogClose(item);

    }


    @Override
    public void onClick(View v) {
        //listener.myOnDialogClose(item);
        //dismiss();
    }
    public void setButtonPrice(Button b)
    {
        btnPrice1.setBackgroundColor(Color.WHITE);
        btnPrice2.setBackgroundColor(Color.WHITE);
        btnPrice3.setBackgroundColor(Color.WHITE);
        btnPrice4.setBackgroundColor(Color.WHITE);
        b.setBackgroundColor(Color.parseColor("#049285"));
    }
    public void setButtonTime(Button b)
    {
        btnTime1.setBackgroundColor(Color.WHITE);
        btnTime2.setBackgroundColor(Color.WHITE);
        btnTime3.setBackgroundColor(Color.WHITE);
        b.setBackgroundColor(Color.parseColor("#049285"));
    }

    public void setButtonDistance(Button b)
    {
        btnDistance1.setBackgroundColor(Color.WHITE);
        btnDistance2.setBackgroundColor(Color.WHITE);
        btnDistance3.setBackgroundColor(Color.WHITE);
        b.setBackgroundColor(Color.parseColor("#049285"));
    }

    public void setButtonZone(Button b)
    {
        btnZone1.setBackgroundColor(Color.WHITE);
        btnZone2.setBackgroundColor(Color.WHITE);
        b.setBackgroundColor(Color.parseColor("#049285"));
    }

    public void setButtonTag(Button b)
    {
        btnTag1.setBackgroundColor(Color.WHITE);
        btnTag2.setBackgroundColor(Color.WHITE);
        b.setBackgroundColor(Color.parseColor("#049285"));
    }

}
