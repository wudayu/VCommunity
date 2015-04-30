package com.wudayu.vcommunity.generic;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by David on 4/29/15.
 */
public class DensityUtils {

    public static int getScreenWidth(Context context) {
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static int getActionBarHeight(Context context) {
        TypedArray actionbarSizeTypeArray = context.obtainStyledAttributes(new int[]{android.R.attr.actionBarSize});
        return (int) actionbarSizeTypeArray.getDimension(0, 0);
    }

}
