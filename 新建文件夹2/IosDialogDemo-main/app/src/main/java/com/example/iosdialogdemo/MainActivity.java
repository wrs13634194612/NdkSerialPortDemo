package com.example.iosdialogdemo;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.iosdialogdemo.utils.DWpShwoView;
import com.example.iosdialogdemo.utils.DataChangeUtils;
import com.example.iosdialogdemo.utils.DateUtils;
import com.example.iosdialogdemo.utils.EntityKeyBoardUtils;
import com.example.iosdialogdemo.utils.NetWorkUtil;
import com.example.iosdialogdemo.utils.SerialPortScreenUtils;

import java.util.Timer;
import java.util.TimerTask;

import android_serialport_api.SerialPortListener;
import android_serialport_api.serialport.KeyFeilds;
import android_serialport_api.serialport.OrderFields;


public class MainActivity extends AppCompatActivity implements SerialPortListener {
    private static final String TAG = "MainActivity";
    //实体键盘操作
    protected EntityKeyBoardUtils entityKeyBoardUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化串口键盘
        initEntityKeyBoard();
    }

    private void initEntityKeyBoard() {
        entityKeyBoardUtils = new EntityKeyBoardUtils(getApplicationContext(), this);
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
    public void onDataReceivedObjectMainThread(int backBean, int type) {
        //收到按键通知
        Log.e("key", "KeyFeilds.KEY0" + backBean + type);
       /* if (backBean.getDataOrder().equals(OrderFields.M1_KEY)) {
            Log.i("keyBack", "" + DataChangeUtils.change16To10(backBean.getDataContent()));
        }*/
    }
}