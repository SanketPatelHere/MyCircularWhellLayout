package com.example.sanket;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sanket.mycircularwhelllayout.R;

/**
 * Created by Ekta Bhatt on 05-12-2019.
 */
public class CustomDialogClass2 extends Dialog implements View.OnClickListener {
    public Activity c;
    public Dialog d;
    MyClickListener listener;
    MenuItem item;
    public CustomDialogClass2(Activity a, MyClickListener listener, MenuItem item) {
        super(a);
        this.c = a;
        this.listener = listener;
        this.item = item;
    }
    public CustomDialogClass2(@NonNull Context context) {
        super(context);
    }

    public CustomDialogClass2(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomDialogClass2(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.lv_triangle);
    }
    @Override
    public void onClick(View v) {

    }
}
