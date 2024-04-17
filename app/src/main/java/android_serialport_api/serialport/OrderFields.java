package android_serialport_api.serialport;


/**
 * 项目名称:OneCard
 * 创建人:kexiang
 * 创建时间:2018-11-13 11:07
 */

public class OrderFields {
    /**
     * 1.1.3	读卡器主动上报物理卡号
     */
    public static final String M1_UP_PHY = "01";
    /**
     * 1.1.3	上位机读扇区数据
     */
    public static final String M1_02 = "02";
    /**
     * 1.1.3	上位机读扇区数据,成功
     */
    public static final String M1_02_SUCCESS = "01";
    /**
     * 1.1.3	上位机读扇区数据,读快数据错误
     */
    public static final String M1_02_FAILD = "00";

    /**
     * 1.1.3	上位机写卡操作
     */
    public static final String M1_WRITE = "03";
    /**
     * 1.1.3	上位机写卡操作,写卡错误
     */
    public static final String  M1_WRITE_FAILD = "00";
    /**
     * 1.1.3	上位机写卡操作,写卡成功
     */
    public static final String  M1_WRITE_SUCCESS= "01";
    /**
     * 1.1.3	上位机写卡操作,不是用一张卡
     */
    public static final String M1_WRITE_CARD = "02";

    /**
     * 1.1.4	读卡器发送按键值
     */
    public static final String M1_KEY = "05";
    /**
     * 1.1.6	上位机下发读卡参数
     */
    public static String M1_CARD_READ = "08";

    /**
     * 1：消费
     */
    public static String JC = "11";

    /**
     * 1：消费
     */
    public static String M1_ERROR = "11";
    /**
     * 1.1.4	读IC卡号
     */
    public static String M1_CARD_PHY = "04";

    /**
     * 被动摄像头传感器应答
     */
    public static String SENSOR_PASSIVE = "10";

    /**
     * 补光灯应答
     */
    public static String FLASH_LED = "11";
    /**
     * 主动请求传感器应答
     */
    public static String SENSOR_ACTIVE = "12";
}
