package android_serialport_api;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.iosdialogdemo.utils.DataChangeUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android_serialport_api.serialport.Fields;

/**
 * 项目名称:OneCard
 * 创建人:kexiang
 * 创建时间:2018-11-12 13:42
 */

public class SerialPortUtils {
    private static final Object readLock=0x01;
    private SerialPort mSerialPort = null;
    private Handler mainHander;

    public SerialPortUtils(File device, int baudrate, int flags) throws SecurityException, IOException {
        mSerialPort = new SerialPort(device, baudrate, flags);
        mOutputStream = mSerialPort.getOutputStream();
        mInputStream = mSerialPort.getInputStream();
        mainHander = new Handler(Looper.getMainLooper());


    }

    public void openReciveMessage(int type) {
        this.type = type;
        /* Create a receiving thread */
//        mReadThread = new ReadThread();
//        mReadThread.start();
    }


    private SerialPortListener serialPortListener;
    private int type;

    public void setSerialPortListener(SerialPortListener serialPortListener) {
        this.serialPortListener = serialPortListener;
    }

    protected OutputStream mOutputStream;
    private InputStream mInputStream;
//    private ReadThread mReadThread;

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
                        synchronized (readLock) {
                            serialPortListener.onDataReceived(buffer, size, type);
                            final StringBuffer buffer1 = new StringBuffer();
                            for (int i = 0; i < size; i++) {
                                buffer1.append(DataChangeUtils.autoGenericCode(
                                        DataChangeUtils.change10To16(buffer[i] & 0xff), 2));
                            }
                            if (type == Fields.SERIAL_PORT_02) {
                                final String back = buffer1.toString();
                                if (back.length() > 4 && DataChangeUtils.change16To10(back.substring(2, 4)) * 2 <=
                                        back.length() - 4) {
                                    serialPortListener.onDataReceivedString(back, type);
                                    mainHander.post(new Runnable() {
                                        @Override
                                        public void run() {

                                        }
                                    });
                                }

                            } else if (type == Fields.SERIAL_SENSOR) {
                                final String back = buffer1.toString();
                                Log.i("SERIAL_SENSOR", back);
                            } else if (type == Fields.FLASH_LED) {
                                final String back = buffer1.toString();
                                Log.i("FLASH_LED", back);
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }


    public void onDestroy() {
//        mReadThread.interrupt();
        mSerialPort =null;
        mainHander = null;
        mOutputStream=null;
        mInputStream=null;
    }
}
