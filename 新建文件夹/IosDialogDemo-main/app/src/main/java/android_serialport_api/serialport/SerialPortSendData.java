package android_serialport_api.serialport;


import com.example.iosdialogdemo.utils.DataChangeUtils;

/**
 * 项目名称:OneCard
 * 创建人:kexiang
 * 创建时间:2018-11-12 14:33
 * 1.1.1	主动发起方数据包格式
 */

public class SerialPortSendData {
    private String dataBT = Fields.HEAD_ONE;
    public int dataLength = -1;
    private String dataOrder;
    private String dataContent;
    private String dataCRC;
    private String content;

    public SerialPortSendData(String content) {
        try{
            this.content = content;
            dataBT = content.substring(0, 2);
            dataLength = DataChangeUtils.change16To10(content.substring(2, 4)) * 2;
            if(dataLength >=6&&content.length()>6){
                dataOrder = content.substring(4, 6);
                dataContent = content.substring(6, dataLength + 2);
                dataCRC = content.substring(content.length() - 2, content.length());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public SerialPortSendData() {
    }

    public String getDataBT() {
        return dataBT;
    }

    public String getDataOrder() {
        return dataOrder;
    }

    public String getDataContent() {
        return dataContent;
    }

    public String getDataContentStatus() {
        return dataContent.substring(0, 2);
    }

    public String getDataContentNotStatus() {
        return dataContent.substring(2, dataContent.length());
    }

    public String dataOrderAndContent;

    public String getDataCRC() {
        return dataCRC;
    }

    public String getDataOrderAndContent() {
        return dataOrder + dataContent;
    }

    public int getDataLength() {
        return getDataOrderAndContent().length() / 2 + 1;
    }

    public String getContent() {
        return content;
    }

    public String getSendData() {
        String send = dataBT + DataChangeUtils.autoGenericCode(
                DataChangeUtils.change10To16(getDataLength()), 2
        ) + getDataOrderAndContent();
        return (send + DataChangeUtils.CUSUM(getDataOrderAndContent())).toUpperCase();
    }

    public void setDataBT(String dataBT) {
        this.dataBT = dataBT;
    }

    public void setDataLength(int dataLength) {
        this.dataLength = dataLength;
    }

    public void setDataOrder(String dataOrder) {
        this.dataOrder = dataOrder;
    }

    public void setDataContent(String dataContent) {
        this.dataContent = dataContent;
    }


    public byte[] getPcSendByte() {
        return DataChangeUtils.getPcSendByte(getSendData());
    }

}
