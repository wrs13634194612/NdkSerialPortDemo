package com.example.iosdialogdemo;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.example.iosdialogdemo.presentation.MapEvent;
import com.example.iosdialogdemo.presentation.PresentationPresenter;
import com.example.iosdialogdemo.utils.DataChangeUtils;
import com.example.iosdialogdemo.utils.EntityKeyBoardUtils;

import org.greenrobot.eventbus.EventBus;

import android_serialport_api.SerialPortListener;
import android_serialport_api.serialport.OrderFields;


public class FirstActivity extends FragmentActivity implements View.OnClickListener {


    private TextView tvShowPresentation;

    private PresentationPresenter presentationPresenter;

    private FrameLayout fmActivityContent;

    private Button btn_first_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        init();
    }

    private void init() {
        initView();
        initEvent();
    }

    private void initView() {
        btn_first_data = findViewById(R.id.btn_first_data);
        //  initPage();
    }

    private void initEvent() {
        btn_first_data.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_first_data:
                MapEvent mapEvent = new MapEvent();
                mapEvent.setCode(MapEvent.TO_SEARCH);
                EventBus.getDefault().post(mapEvent);
                break;

            default:
                break;
        }
    }


}
