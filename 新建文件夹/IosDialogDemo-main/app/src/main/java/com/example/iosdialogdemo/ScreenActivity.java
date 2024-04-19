package com.example.iosdialogdemo;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.FragmentActivity;

import com.example.iosdialogdemo.presentation.MapEvent;
import com.example.iosdialogdemo.presentation.PresentationPresenter;
import com.example.iosdialogdemo.utils.DWpShwoView;
import com.example.iosdialogdemo.utils.DataChangeUtils;
import com.example.iosdialogdemo.utils.DateUtils;
import com.example.iosdialogdemo.utils.EntityKeyBoardUtils;
import com.example.iosdialogdemo.utils.NetWorkUtil;
import com.example.iosdialogdemo.utils.SerialPortScreenUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.Timer;
import java.util.TimerTask;

import android_serialport_api.SerialPortListener;
import android_serialport_api.serialport.OrderFields;
import android_serialport_api.serialport.SerialPortSendData;

public class ScreenActivity extends FragmentActivity implements View.OnClickListener,SerialPortListener {

    private PresentationPresenter presentationPresenter;
    private Button btn_send_data, btn_first, btn_two_screen;
    protected EntityKeyBoardUtils entityKeyBoardUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        init();
    }

    private void init() {
        initView();
        initEvent();
        //初始化串口键盘
        initEntityKeyBoard();
    }

    private void initView() {
        btn_two_screen = findViewById(R.id.btn_two_screen);
        btn_send_data = findViewById(R.id.btn_send_data);
        btn_first = findViewById(R.id.btn_first);
    }

    private void initEvent() {
        presentationPresenter = new PresentationPresenter();
        btn_two_screen.setOnClickListener(this);
        btn_send_data.setOnClickListener(this);
        btn_first.setOnClickListener(this);

    }

    private void initEntityKeyBoard() {
        entityKeyBoardUtils = new EntityKeyBoardUtils(getApplicationContext(), this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_two_screen:
                presentationPresenter.openSearchPresentation(ScreenActivity.this);
                break;
            case R.id.btn_send_data:
                MapEvent mapEvent = new MapEvent();
                mapEvent.setCode(MapEvent.ZOOM_IN);
                EventBus.getDefault().post(mapEvent);
                break;
            case R.id.btn_first:
                Intent intent = new Intent(ScreenActivity.this, FirstActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void displayError(int res) {
        Log.i("displayError", getString(res));
    }

    @Override
    public void onDataReceived(byte[] buffer, int size, int type) {
    }

    @Override
    public void onDataReceivedString(String back, int type) {
    }

    @Override
    public void onDataReceivedObjectMainThread(SerialPortSendData backBean, int type) {
        //收到按键通知
        Log.i("key", "KeyFeilds.KEY0" + backBean + type);
        if (backBean.getDataOrder().equals(OrderFields.M1_KEY)) {
            Log.i("keyBack", "" + DataChangeUtils.change16To10(backBean.getDataContent()));
        }
    }

}
