package com.example.sanket.mycircularwhelllayout.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sanket.mycircularwhelllayout.Data.ImageData;
import com.example.sanket.mycircularwhelllayout.Data.MenuItemData;
import com.example.sanket.mycircularwhelllayout.R;

import java.util.List;

import github.hellocsl.cursorwheel.CursorWheelLayout;
public class WheelImageAdapter extends CursorWheelLayout.CycleWheelAdapter {
    private Context context;
    private List<ImageData> menuItems;
    private LayoutInflater inflater;
    private int gravity;

    public WheelImageAdapter(Context context, List<ImageData> menuItems) {
        this.context = context;
        this.menuItems = menuItems;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return menuItems.size();
    }

    @Override
    public View getView(View parent, int position) {
        ImageData data = getItem(position);
        View root = inflater.inflate(R.layout.wheel_image_layout, null ,false);
        ImageView imageView = (ImageView)root.findViewById(R.id.wheel_menu_item_iv);
        TextView textView = (TextView)root.findViewById(R.id.myimageText);
        imageView.setImageResource(data.imageResource);
        textView.setText(data.imageDescription);
        return root;
    }

    @Override
    public ImageData getItem(int position) {
        return menuItems.get(position);
    }
}
