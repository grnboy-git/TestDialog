package me.grnboy.pt_bladesdk;

import android.content.Context;
import android.os.Build;
import android.webkit.WebView;

public class BladeWebView extends WebView {

    public BladeWebView(Context context) {
        super(context);

        clearCache(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setUseWideViewPort(true);

        if (Build.VERSION.SDK_INT >= 11)  {
            setLayerType(WebView.LAYER_TYPE_SOFTWARE,null);
        }

    }
}
