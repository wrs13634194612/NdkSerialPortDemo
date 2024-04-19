package android_serialport_api;

/**
 * 项目名称:OneCard
 * 创建人:kexiang
 * 创建时间:2018-11-12 13:07
 */

public interface SerialPortListener extends SerialPortBaseListener {
    void displayError(int res);

    void onDataReceived(final byte[] buffer, final int size, int type);

    void onDataReceivedString(String back, int type);

}
