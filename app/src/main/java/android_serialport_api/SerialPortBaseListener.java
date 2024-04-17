package android_serialport_api;


import android_serialport_api.serialport.SerialPortSendData;

/**
 * 项目名称:OneCard
 * 创建人:kexiang
 * 创建时间:2018-11-12 13:07
 */

public interface SerialPortBaseListener {

    void onDataReceivedObjectMainThread(SerialPortSendData backBean, int type);

}
