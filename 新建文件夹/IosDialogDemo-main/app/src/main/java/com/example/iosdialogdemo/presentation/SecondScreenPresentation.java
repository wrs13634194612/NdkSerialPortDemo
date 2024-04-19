package com.example.iosdialogdemo.presentation;


import android.app.Presentation;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.TextView;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.EventBus;
import com.example.iosdialogdemo.R;

public class SecondScreenPresentation extends Presentation {

    private static final String TAG = "Presentation";

    private TextView tvSearch;


    public SecondScreenPresentation(Context outerContext, Display display) {
        super(outerContext, display);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentation_search);
        init();
    }

    private void init() {
        initView();
        initEvent();
    }

    private void initView() {
        tvSearch = findViewById(R.id.tvSearch);
    }

    private void initEvent() {
        windowWidthAndHeightTest();
    }

    private void windowWidthAndHeightTest() {
        int height = getContext().getResources().getDisplayMetrics().heightPixels;
        int width = getContext().getResources().getDisplayMetrics().widthPixels;
        Log.d(TAG, "height_is" + height + "  width_is:" + width);
        System.out.println("SearchPresentation________height_is" + height + "  width_is:" + width);
    }

    @Override
    public void show() {
        super.show();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void dismiss() {
        EventBus.getDefault().unregister(this);
        super.dismiss();
    }

    @Subscribe
    public void onMapEvent(MapEvent mapEvent) {
        tvSearch.setText("onMapEvent:" + mapEvent.getCode());
    }
}
