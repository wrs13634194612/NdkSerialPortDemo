package com.example.iosdialogdemo.utils;

import android.content.Context;


import com.example.iosdialogdemo.R;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Timer;
import java.util.TimerTask;

import android_serialport_api.SerialPortKeyAndCard;
import android_serialport_api.SerialPortListener;
import android_serialport_api.serialport.Fields;
import android_serialport_api.serialport.SerialPortSendData;

/**
 * Created by heshuai on 2018-12-29.
 *
 * 串口键盘监听
 */
public class EntityKeyBoardUtils {

//    private final static EntityKeyBoardUtils INSTANCE = new EntityKeyBoardUtils();
//
//    public static EntityKeyBoardUtils getInstance(){
//        return INSTANCE;
//    }

    public static SerialPortKeyAndCard mSerialPortUtils;
    private SerialPortListener mSerialPortListener;
    private Timer timer=new Timer();
    public EntityKeyBoardUtils(Context context, SerialPortListener serialPortListener){
        mSerialPortListener=serialPortListener;
        initSerialPort(context);
//        timerGetSerialStatus();
    }

    public void initSerialPort(Context context) {
        try {
//            String path = "/dev/ttyHSL3"; //键盘串口的地址
//            String path = "/dev/ttyS0"; //键盘串口的地址
            String path = "/dev/ttyS3"; //键盘串口的地址
            int baudrate = 38400;
            /* Open the serial port */
            mSerialPortUtils = new SerialPortKeyAndCard(
                    new File(path), baudrate, 0

            );
            mSerialPortUtils.openReciveMessage(Fields.SERIAL_PORT_02);
            mSerialPortUtils.setSerialPortListenerKeyBoard(mSerialPortListener);//设置回调监听
        } catch (SecurityException e) {
            mSerialPortListener.displayError(R.string.error_security);
        } catch (IOException e) {
            mSerialPortListener.displayError(R.string.error_unknown);
        } catch (InvalidParameterException e) {
            mSerialPortListener.displayError(R.string.error_configuration);
        }
    }

    public void destory(){
        if(mSerialPortUtils!=null){
            timer.cancel();
            timer=null;
            mSerialPortUtils.onDestroy();
            mSerialPortUtils=null;
        }
    }

    //发送命令
    public void writeData(String order, String content){ //0101 红外/可见补光灯亮 0000 红外/可见补光灯灭  OrderFields.FLASH_LED
        if(mSerialPortUtils!=null){
            SerialPortSendData sendData = new SerialPortSendData();
            sendData.setDataOrder(order);
            sendData.setDataContent(content);

            LogUtils.toI("应答", "发送：" + sendData.getSendData());
            try{
                mSerialPortUtils.getmOutputStream().write(DataChangeUtils.getPcSendByte(sendData.getSendData()));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void timerGetSerialStatus(){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                writeData("12","00");
            }
        },2000,2000);
    }
}
