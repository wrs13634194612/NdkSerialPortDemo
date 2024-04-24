package android_serialport_api;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;


import com.example.iosdialogdemo.utils.DataChangeUtils;
import com.example.iosdialogdemo.utils.DataConversion;
import com.example.iosdialogdemo.utils.LogUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import android_serialport_api.serialport.OrderFields;

/**
 * 项目名称:OneCard
 * 创建人:kexiang
 * 创建时间:2018-12-14 10:43
 */

public class SerialPortKeyAndCard implements Serializable {
    public static final String TAG = "chuankou";
    public static String TAG1 = "lkj";
    private static final Object readLock=0x01;
    private SerialPort mSerialPort = null;
    private Handler mainHander;
    private OutputStream mOutputStream;
    private InputStream mInputStream;
    private ReadThread mReadThread;
    private SerialPortBaseListener serialPortListenerBaseActivity;
    private SerialPortBaseListener serialPortListenerKeyBoard;
    private Application application;
    private int type = -1;
    private int cutMoney = 0;
    private String phyCardNo = "";

    public SerialPortKeyAndCard(File device, int baudrate, int flags)
            throws SecurityException, IOException {
        mSerialPort = new SerialPort(device, baudrate, flags);//正在打开串口
        mOutputStream = mSerialPort.getOutputStream();
        mInputStream = mSerialPort.getInputStream();
        mainHander = new Handler(Looper.getMainLooper());
        /* Create a receiving thread */
        mReadThread = new ReadThread();//通过mInputStream读取 串口返回的信息
        mReadThread.start();
    }


    public void setCutMoney(int money) {
        LogUtils.toE("setCutMoney", money);
        cutMoney = money;

    }

    public String getPhyCardNo() {
        return phyCardNo;
    }

    public void setPhyCardNo(String phyCardNo) {
        this.phyCardNo = phyCardNo;
    }

    public void openReciveMessage(int type) {
        this.type = type;
    }


    public void setSerialPortListenerBaseActivity(SerialPortBaseListener serialPortListenerBaseActivity) {
        this.serialPortListenerBaseActivity = serialPortListenerBaseActivity;
    }


    public void setSerialPortListenerKeyBoard(SerialPortBaseListener serialPortListenerKeyBoard) {
        this.serialPortListenerKeyBoard = serialPortListenerKeyBoard;
    }

    public OutputStream getmOutputStream() {
        return mOutputStream;
    }

    private class ReadThread extends Thread {
        @Override
        public void run() {
            super.run();
            while (!isInterrupted()) {
                int size;
                try {
                    byte[] buffer = new byte[64];
                    if (mInputStream == null) return;
                    size = mInputStream.read(buffer);
                    if (size > 0) {
                        Log.e(TAG, "=================start====================");
                        final StringBuffer buffer1 = new StringBuffer();

                        for (int i = 0; i < size; i++) {
                            buffer1.append(
                                    DataChangeUtils.autoGenericCode(
                                            DataChangeUtils.change10To16(buffer[i] & 0xff), 2
                                    )
                            );
                        }
                        Log.e(TAG1, "run: 1 --->buffer1 : " + buffer1);
                        synchronized (readLock) {
                            String back = buffer1.toString().toUpperCase();
                            try {
                                postMainThread(back);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        /*synchronized (readLock) {
                            String back = buffer1.toString().toUpperCase();
                            try {
                                String dataBT = back.substring(0, 2);
                                int dataLength = DataChangeUtils.change16To10(back.substring(2, 4)) * 2;
                                if (dataLength >= 6 && back.length() > 6) {
                                    String dataOrder = back.substring(4, 6);
                                    String dataContent = back.substring(6, dataLength + 2);
                                    String dataCRC = back.substring(back.length() - 2, back.length());
                                    Log.i("TAG", "===================start==================");
                                    Log.i("TAG", "" + dataBT + "=====" + dataOrder + "==???===" + dataContent + "------------" + dataCRC);  // F6FCD8EC
                                    Log.i("TAG", "==================end=====================");
                                    if (dataOrder.equals("05")){
                                        Log.i("TAG", "键盘:"+back);
                                        serialPortListenerKeyBoard.onDataReceivedObjectMainThread(back, type);
                                    }else if(dataOrder.equals("01")){
                                        Log.i("TAG", "刷卡:"+back);
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }*/
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private void postMainThread(final String back) {
        mainHander.post(new Runnable() {
            @Override
            public void run() {
                try {
                    String dataBT = back.substring(0, 2);
                    int dataLength = DataChangeUtils.change16To10(back.substring(2, 4)) * 2;
                    if (dataLength >= 6 && back.length() > 6) {
                        String dataOrder = back.substring(4, 6);
                        String dataContent = back.substring(6, dataLength + 2);
                        String dataCRC = back.substring(back.length() - 2, back.length());
                        Log.i("TAG", "===================start==================");
                        Log.i("TAG", "" + dataBT + "=====" + dataOrder + "==???===" + dataContent + "------------" + dataCRC);  // F6FCD8EC
                        Log.i("TAG", "==================end=====================");
                        if (dataOrder.equals("01")){
                            Log.i("TAG", "刷卡");
                            long codessss = DataConversion.hexToDec(DataConversion.encodeHexString(DataConversion.reverse2(DataConversion.decodeHexString(back.substring(8, 16)))));
                            Log.e("TAG", "==================end====================="+codessss);
                        }else if (dataOrder.equals("05")){
                            int keycode =   DataChangeUtils.change16To10(back.substring(6, 8));
                            Log.e("TAG", "==================end====================="+keycode);
                            serialPortListenerKeyBoard.onDataReceivedObjectMainThread(keycode, type);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
    }


  /*  private void postMainThread(final String data) {


        mainHander.post(new Runnable() {
            @Override
            public void run() {
                SerialPortSendData pcSendData =
                        new SerialPortSendData(data);
                try {
                    keyAndCard(pcSendData);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
    }*/

 /*   private void keyAndCard(SerialPortSendData back) throws IOException {
        if(back!=null && back.getDataOrder()!=null){
            if (back.getDataOrder().equals(OrderFields.M1_KEY)||
                    back.getDataOrder().equals(OrderFields.SENSOR_ACTIVE)||
                    back.getDataOrder().equals(OrderFields.FLASH_LED)||
                    back.getDataOrder().equals(OrderFields.M1_UP_PHY)) {
                if (serialPortListenerKeyBoard != null) {
                    Log.i(TAG, "keyAndCard: ");
                    serialPortListenerKeyBoard.onDataReceivedObjectMainThread(back, type);
                }
            }
        }
    }*/


    private boolean readAndWriteStatus = true;

    public void startReadAndWrite() {
        readAndWriteStatus = true;
    }

    public void stopReadAndWrite() {
        readAndWriteStatus = false;
    }

    public void onDestroy() {
        mReadThread.interrupt();
        mainHander = null;
        mSerialPort = null;
        application = null;
    }
}