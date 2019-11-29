package com.example.sanket;

import android.view.MenuItem;
import android.view.View;

/**
 * Created by Ekta Bhatt on 29-11-2019.
 */
public interface MyClickListener {
    public void myOnClick(int position);
    public void myOnClick(View v, int position);
    public void myOnLongClick(View v, int position);

    //for menu button image change
    public void myOnDialogClose(MenuItem item);
}
