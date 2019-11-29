package com.example.sanket;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
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
    public CustomDialogClass(Activity a) {
        super(a);
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialoglayout);

        yes = (Button)findViewById(R.id.btnYes);
        no = (Button)findViewById(R.id.btnNo);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, "Yessss", Toast.LENGTH_SHORT).show();
                dismiss();

                /*MenuInflater mi = getMenuInflater();
                MenuItem item2 = menu.findItem(R.id.filter);
                int id = item.getItemId();
                //Log.i("My state = ",""+id);
                //Drawable myDrawable = getActionBar().getDrawable(R.drawable.filter_icon);
                item.setIcon(R.drawable.filter_icon);*/




                Log.i("My dialog = ", "dismiss");
                /*MenuInflater mi = getMenuInflater();
                mi.inflate(R.menu.search_menu, menu);*/
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, "Noooo", Toast.LENGTH_SHORT).show();
                dismiss();
                Log.i("My dialog = ", "dismiss");

            }
        });
    }


    @Override
    public void onClick(View v) {

    }


}
