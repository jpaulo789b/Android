package com.example.myapplication.util;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class MenuItemDecoration  extends RecyclerView.ItemDecoration {


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        outRect.bottom = 16;
        outRect.left = 8;
        outRect.right= 8;
        outRect.top= 8;
    }
}