package com.example.sanket.mycircularwhelllayout.Adapter;
import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import com.example.sanket.mycircularwhelllayout.Data.MenuItemData;
import com.example.sanket.mycircularwhelllayout.R;

import java.lang.reflect.TypeVariable;
import java.util.List;
import github.hellocsl.cursorwheel.CursorWheelLayout;
public class WheelTextAdapter extends CursorWheelLayout.CycleWheelAdapter {
    private Context context;
    private List<MenuItemData> menuItems;
    private LayoutInflater inflater;
    private int gravity;

    public WheelTextAdapter(Context context, List<MenuItemData> menuItems) {
        this.context = context;
        this.menuItems = menuItems;
        gravity = Gravity.CENTER;
        inflater = LayoutInflater.from(context);
    }

    public WheelTextAdapter(Context context, List<MenuItemData> menuItems, int gravity) {
        this.context = context;
        this.menuItems = menuItems;
        this.gravity = gravity;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
      return menuItems.size() ;
    }

    @Override
    public View getView(View parent, int position) {
        MenuItemData itemData = getItem(position);
        View root = inflater.inflate(R.layout.wheel_text_layout, null ,false);
        TextView textView = (TextView)root.findViewById(R.id.wheel_menu_item_tv);
        textView.setVisibility(View.VISIBLE);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        textView.setText(itemData.mTitel);
        if(textView.getLayoutParams() instanceof FrameLayout.LayoutParams)
        {
            ((FrameLayout.LayoutParams)textView.getLayoutParams()).gravity = gravity;
        }
        if(position==4)
        {
            textView.setTextColor(ActivityCompat.getColor(context, R.color.red));
        }
        return root;
    }

    @Override
    public MenuItemData getItem(int position) {
        return menuItems.get(position);
    }
}
