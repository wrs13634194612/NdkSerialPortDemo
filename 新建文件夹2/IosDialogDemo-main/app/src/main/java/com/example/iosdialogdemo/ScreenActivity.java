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
import android_serialport_api.serialport.KeyFeilds;
import android_serialport_api.serialport.OrderFields;

public class ScreenActivity extends FragmentActivity implements View.OnClickListener ,SerialPortListener  {

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

    public synchronized void keyBack(int key) {
        try {
            switch (key) {
                case KeyFeilds.KEY0:
                    Log.e("key","KeyFeilds.KEY0");

                    break;
                case KeyFeilds.KEY1:
                    Log.e("key","KeyFeilds.KEY1");
                    break;
                case KeyFeilds.KEY2:
                    Log.e("key","KeyFeilds.KEY2");
                    break;
                case KeyFeilds.KEY3:
                    Log.e("key","KeyFeilds.KEY3");
                    break;
                case KeyFeilds.KEY4:
                    Log.e("key","KeyFeilds.KEY4");
                    break;
                case KeyFeilds.KEY5:
                    Log.e("key","KeyFeilds.KEY5");
                    break;
                case KeyFeilds.KEY6:
                    Log.e("key","KeyFeilds.KEY6");
                    break;
                case KeyFeilds.KEY7:
                    Log.e("key","KeyFeilds.KEY7");
                    break;
                case KeyFeilds.KEY8:
                    Log.e("key","KeyFeilds.KEY8");
                    break;
                case KeyFeilds.KEY9:
                    Log.e("key","KeyFeilds.KEY9");
                    break;
                case KeyFeilds.POINTIN:
                    Log.e("key","KeyFeilds.POINTIN");
                    break;
                case KeyFeilds.KEYF1:
                    Log.e("key","KeyFeilds.KEYF1");
                    break;
                case KeyFeilds.KEYF2:
                    Log.e("key","KeyFeilds.KEYF2");
                    break;
                case KeyFeilds.KEYF3:
                    Log.e("key","KeyFeilds.KEYF3");
                    break;
                case KeyFeilds.KEYF4:
                    Log.e("key","KeyFeilds.KEYF4");
                    break;
                case KeyFeilds.ESCIN:
                    //清除
                    Log.e("key","KeyFeilds.ESCIN");
                    break;
                case KeyFeilds.ENTERIN:
                    //确定
                    Log.e("key","KeyFeilds.ENTERIN");
                    break;
                case KeyFeilds.KEYMENU:
                    //菜单
                    break;
                case KeyFeilds.UPIN:
                    break;
                case KeyFeilds.ADDIN:
                    break;
                case KeyFeilds.DOWNIN:
                    Log.e("key","KeyFeilds.DOWNIN");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void displayError(int res) {
        Log.e("displayError", getString(res));
    }

    @Override
    public void onDataReceived(byte[] buffer, int size, int type) {
    }

    @Override
    public void onDataReceivedString(String back, int type) {
    }

    @Override
    public void onDataReceivedObjectMainThread(int backBean, int type) {
        // //收到按键通知  keyBack(DataChangeUtils.change16To10(backBean.getDataContent()));
        Log.e("key", "KeyFeilds.KEY0" + backBean + type);
        /*if (backBean.getDataOrder().equals(OrderFields.M1_KEY)) {
            Log.i("keyBack",""+ DataChangeUtils.change16To10(backBean.getDataContent()));
            keyBack(DataChangeUtils.change16To10(backBean.getDataContent()));
        }else if (backBean.getDataOrder().equals(OrderFields.M1_WRITE_SUCCESS)){

        }*/
    }
}
