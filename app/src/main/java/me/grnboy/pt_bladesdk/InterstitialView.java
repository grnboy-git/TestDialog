package me.grnboy.pt_bladesdk;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class InterstitialView extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        View dialogRootView;

        // タイトルを非表示に設定
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        // フルスクリーン設定
        getDialog().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        // 背景を透明にする
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        if (config.orientation == Configuration.ORIENTATION_PORTRAIT) {
            dialogRootView = inflater.inflate(R.layout.fragment_interstitial_view, container, false);
        } else {
            dialogRootView = inflater.inflate(R.layout.fragment_interstitial_landscape, container, false);

        }
        // OK button listener
        dialogRootView.findViewById(R.id.positive_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        // Close button listener
        dialogRootView.findViewById(R.id.close_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return dialogRootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Configuration config = getResources().getConfiguration();

        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Dialog dialog = getDialog();

            WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();

            DisplayMetrics metrics = getResources().getDisplayMetrics();
            int dialogWidth = (int) (metrics.widthPixels * 0.8);  // 画面サイズの0.8倍の大きさに指定
            int dialogHeight = (int) (metrics.heightPixels * 0.8);  // 画面サイズの0.8倍の大きさに指定

            lp.width = dialogWidth;
            lp.height = dialogHeight;
            dialog.getWindow().setAttributes(lp);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);

        View view;
        Dialog dialog = getDialog();
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        DisplayMetrics metrics = getResources().getDisplayMetrics();

        LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {

            LinearLayout mainlayout = new LinearLayout(getActivity().getApplicationContext());
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
            lp.ad





//            TextView title = new TextView(getActivity().getApplicationContext());
//            LinearLayout sublayout = new LinearLayout(getActivity().getApplicationContext());
//            BladeWebView webView = new BladeWebView(getActivity().getApplicationContext());
//            Button close_button = new Button(getActivity().getApplicationContext());


//            view = inflater.inflate(R.layout.fragment_interstitial_view, null);
////            int dialogWidth = (int) (metrics.widthPixels * 0.8);  // 画面サイズの0.8倍の大きさに指定
////            int dialogHeight = (int) (metrics.heightPixels * 0.8);  // 画面サイズの0.8倍の大きさに指定
//            lp.width = RelativeLayout.LayoutParams.WRAP_CONTENT;
//            lp.height = RelativeLayout.LayoutParams.WRAP_CONTENT;

        } else {
//            view = inflater.inflate(R.layout.fragment_interstitial_landscape, null);
//            int dialogWidth = (int) (metrics.widthPixels * 0.8);  // 画面サイズの0.8倍の大きさに指定
//            int dialogHeight = (int) (metrics.heightPixels * 0.8);  // 画面サイズの0.8倍の大きさに指定
//            lp.width = dialogWidth;
//            lp.height = dialogHeight;


        }

        dialog.getWindow().setAttributes(lp);

        ViewGroup rootView = (ViewGroup) getView();
        rootView.removeAllViews();
        rootView.addView(view);

    }
}
