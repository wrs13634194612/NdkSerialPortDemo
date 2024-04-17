package android_serialport_api.bean;


/**
 * 项目名称:1189MinaDemo-master
 * 创建人:kexiang
 * 创建时间:2018-12-12 10:10
 */

public class OneCardDataFeilds {

    public final static int TITLE_LENGTH = 10;
    /**
     * TCP包协议版本
     */
    public final static String TCP_VERSIONS = "AA";

    /**
     * 加密类型
     * 0x00:不加密
     * 0x01:加密
     */
    public final static String PASSWOTD_TYEP_NET = "00";
    /**
     * 加密类型
     * 0x00:不加密
     * 0x01:加密
     */
    public final static String PASSWOTD_TYEP_ENC = "01";

    /**
     * 保留
     */
    public final static String WAIT = "0000000000";
    /**
     * 中继子网ID
     * 终端数据报文头长度
     */
    public final static String NET = "00";

    /**
     * 数据包协议版本
     */
    public final static String DATE_VERSIONS = "AA";


}
