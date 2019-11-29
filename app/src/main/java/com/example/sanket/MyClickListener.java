package com.example.sanket;

import android.view.View;

/**
 * Created by Ekta Bhatt on 29-11-2019.
 */
public interface MyClickListener {
    public void myOnClick(int position);
    public void myOnClick(View v, int position);
    public void myOnLongClick(View v, int position);
}
