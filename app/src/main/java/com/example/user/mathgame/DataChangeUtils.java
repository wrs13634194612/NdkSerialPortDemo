package com.example.user.mathgame;



        import android.text.TextUtils;

        import android_serialport_api.bean.OneCardDataFeilds;


/**
 * 项目名称:HandhelPcSocket
 * 创建人:kexiang
 * 创建时间:2018-09-11 15:45
 */

public class DataChangeUtils {

    /**
     * 获取金额M1卡新卡结构金额交换
     *
     * @return
     */
    public static int moneyRead(String money) {

        return Integer.parseInt(money.substring(4, 6) + money.substring(2, 4) + money.substring(0, 2), 16);
    }

    /**
     * 写卡内容
     *
     * @return
     */
    public static String moneyWrite(String money) {

        return money.substring(4, 6) + money.substring(2, 4) + money.substring(0, 2);
    }

    /**
     * 2进制转16进制
     *
     * @return
     */
    public static String change2To16(String numbers2) {
        return Integer.toHexString(Integer.valueOf(numbers2, 2));
    }

    /**
     * 16进制转2进制
     *
     * @return
     */
    public static String change16To2(String numbers16) {
        return Integer.toBinaryString(Integer.valueOf(numbers16, 16));
    }


    /**
     * 10进制转16进制
     *
     * @return
     */
    public static String change10To16(int numbers10) {
        return Integer.toHexString(numbers10);
    }

    /**
     * 10进制转16进制
     *
     * @return
     */
    public static String change10To16(String numbers10) {
        return Integer.toHexString(Integer.parseInt(numbers10));
    }

    /**
     * 10进制转2进制
     *
     * @return
     */
    public static String change10To2(int numbers10) {
        return Integer.toBinaryString(numbers10);
    }


    /**
     * 16进制转10进制
     *
     * @return
     */
    public static int change16To10(String numbers16) {
        return Integer.valueOf(numbers16, 16);
    }

    /**
     * 2进制转10进制
     *
     * @return
     */
    public static int change2To10(String numbers2) {
        return change16To10(change2To16(numbers2));
    }


    /**
     * 保留num的位数
     * 0 代表前面补充0
     * num 代表长度为4
     * d 代表参数为正数型
     *
     * @param code
     * @param num
     * @return
     */
    public static String autoGenericCode(String code, int num) {


        if (code.length() != num) {
            StringBuilder builder = new StringBuilder();
            for (int i = code.length(); i < num; i++) {
                builder.append(0);
            }
            builder.append(code);
            return builder.toString();
        }
        else {
            return code;
        }

    }

    /**
     * 转化十六进制编码为字符串
     *
     * @param s 16进制字符串
     * @return
     */

    public static String toStringFrom16(String s) {
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(
                        i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "GBK");// UTF-16le:Not
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

    /**
     * 累加和
     *
     * @param cusum
     * @return
     */
    public static String CUSUM(String cusum) {
        int cusunLength = cusum.length() / 2;
        int temp = 0;
        for (int i = 0; i < cusunLength; i++) {
            temp = temp + Integer.valueOf(cusum.substring(i * 2, i * 2 + 2), 16);
        }
        String tempCusum = Integer.toHexString(temp);
        if (tempCusum.length() > 2) {

            return tempCusum.substring(tempCusum.length() - 2, tempCusum.length());
        }
        else if (tempCusum.length() == 1) {
            return "0" + tempCusum;
        }
        else if (tempCusum.length() == 0) {
            return "00";
        }
        else {
            return tempCusum;
        }

    }

    public static byte[] getPcSendByte(String send) {
        int[] sendInt = new int[send.length() / 2];
        for (int i = 0; i < sendInt.length; i++) {
            sendInt[i] = DataChangeUtils.change16To10(send.substring(i * 2, i * 2 + 2));
        }
        return DMPutils.itob(sendInt);
    }

    /**
     * 校验
     *
     * @param hex
     * @return
     */
    public static String createHex(String hex) {
        hex = hex.substring(0, hex.length() - 2);
        int hexSize = hex.length() / 2;
        String[] hexTemp = new String[hexSize];

        int sum10 = 0;
        for (int i = 0; i < hexSize; i++) {
            hexTemp[i] = hex.substring(i * 2, (1 + i) * 2);
            sum10 = sum10 + Integer.parseInt(hexTemp[i], 16);
        }

        String hexBack = Integer.toHexString(sum10);
        String back = hexBack.substring(hexBack.length() - 2, hexBack.length());

//        LogUtils.toE("createHex", "createHex:" + back);

        return back.toUpperCase();

    }

    //判断是否在消费组里面
    public static boolean groupIn(String group, String groupLocal) {
        if (group.equals("00") || TextUtils.isEmpty(groupLocal)) {
            return false;
        }
        else if (groupLocal.equals("0000000000000000")) {
            return false;
        }
        boolean temp = true;
        for (int i = 0; i < 8; i++) {
            if (group.equals(groupLocal.substring(i * 2, (i + 1) * 2))) {
                temp = false;
                break;
            }
        }
        return temp;
    }

    public static String getMoneyFM(int money) {

        String temp = DataChangeUtils.autoGenericCode(DataChangeUtils.change10To2(money), 24);
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < temp.length(); i++) {
            buffer.append(temp.charAt(i) == '1' ? '0' : '1');
        }
        return DataChangeUtils.change2To16(buffer.toString());
    }


    /**
     * order 协议标示
     * orderContent 协议内容
     * deviceId 设备号
     */
    public static String getSendData(String order, String orderContent, String deviceId) {

        int contentLength = orderContent.length() / 2;
        String dataPackgeAndJYLength = DataChangeUtils.autoGenericCode(
                DataChangeUtils.change10To16(contentLength + 8)
                , 4
        );
        String dataPackgeLength = DataChangeUtils.autoGenericCode(
                DataChangeUtils.change10To16(contentLength + 5), 2
        );

        //TCP包头 累加和校验
        String tcpJYData = OneCardDataFeilds.TCP_VERSIONS + dataPackgeAndJYLength +
                OneCardDataFeilds.PASSWOTD_TYEP_NET + OneCardDataFeilds.WAIT;
        tcpJYData = tcpJYData + DataChangeUtils.CUSUM(tcpJYData);

        //从中继子网ID至命令数据的累加和校验最低字节
        String jyTailData = OneCardDataFeilds.NET + order + deviceId + orderContent;
        jyTailData = jyTailData + DataChangeUtils.CUSUM(jyTailData);

        //命令数据累加和校验
        String jyContent = OneCardDataFeilds.DATE_VERSIONS + dataPackgeLength + jyTailData;
        jyContent = jyContent + DataChangeUtils.CUSUM(jyContent);


        return (tcpJYData + jyContent).toUpperCase();
    }

    public static String loseBackString(String value) {
        StringBuffer sbu = new StringBuffer();
        for (int i = 0; i < value.length(); i++) {
            sbu.append("0").append(value.substring(i, i + 1));
        }
        return sbu.toString();
    }
}
