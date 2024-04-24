package com.example.iosdialogdemo.utils;

import java.io.UnsupportedEncodingException;

/**
 * 项目名称:OneCard
 * 创建人:kexiang
 * 创建时间:2018-11-15 14:36
 */

public class DMPutils {
    public static final int[] CHANGE_BG = {
            0X5A, 0XA5, 0X07, 0X82,
            0X00, 0X84, 0X5A, 0X01,
            0X00, 0X00};
    public static final int[] CHANGE_TEXT = {
            0X5A, 0XA5, 0X0F, 0X82};

    public static final int[] AD_PAY_MONEY = {0X2D, 0X20};
    public static final int AD_PAY_MONEY_LENGTH = 12;
    public static final int[] AD_PAY_MONEY_TITLE = {0X2D, 0X00};
    public static final int AD_PAY_MONEY_TITLE_LENGTH = 24;
    public static final int[] AD_X05_TITLE = {0X28, 0X00};
    public static final int AD_X05_TITLE_LENGTH = 10;


    /**
     * 6	6二维码显示背景.bmp
     */
    public static final String DMP_06 = "06";
    /**
     * 12	12输入金额背景.bmp
     */
    public static final int DMP_0C = 0X0C;
    /**
     * 1	1待机界面背景.bmp
     */
    public static final int DMP_01 = 0X01;
    public static final int[] DMP_01_1200 = {0X12, 0X00};
    public static final int[] DMP_01_1000 = {0X10, 0X20};
    public static final int[] DMP_01_1300 = {0X13, 0X00};
    public static final int[] DMP_01_1020 = {0X10, 0X20};
    public static final int[] DMP_01_1040 = {0X10, 0X40};
    public static final int[] DMP_01_1060 = {0X10, 0X60};
    public static final int[] DMP_01_1080 = {0X10, 0X80};
    public static final int[] DMP_01_10A0 = {0X10, 0XA0};
    public static final int[] DMP_01_10C0 = {0X10, 0XC0};
    public static final int[] DMP_01_1100 = {0X11, 0X00};
    public static final int[] DMP_01_1120 = {0X11, 0X20};
    /**
     * 5	5单独刷卡.bmp
     */
    public static final int DMP_05 = 0X05;
    public static final int[] DMP_05_2800 = {0X28, 0X00};

    /**
     * 14	14消费成功背景.bmp
     */
    public static final int DMP_14 = 0X0E;

    /**
     * 14	14消费成功背景.bmp
     */
    public static final int[] DMP_14_5000 = {0X50, 0X00};
    public static final int DMP_14_5000_Length = 24;
    /**
     * 14	14消费成功背景.bmp
     */
    public static final int[] DMP_14_5020 = {0X50, 0X20};
    public static final int DMP_14_5020_Length = 24;

    /**
     * 14	14消费成功背景.bmp
     */
    public static final int[] DMP_14_5040 = {0X50, 0X40};
    public static final int DMP_14_5040_Length = 24;


    /**
     * 14	14消费成功背景.bmp
     */
    public static final int[] DMP_14_5060 = {0X50, 0X60};
    public static final int DMP_14_5060_Length = 24;


    /**
     * 14	14消费成功背景.bmp
     */
    public static final int[] DMP_14_5080 = {0X50, 0X80};
    public static final int DMP_14_5080_Length = 12;

    /**
     * 9	9交易失败背景.bmp
     */
    public static final int DMP_09 = 0X09;

    /**
     * 9	9交易失败背景.bmp
     */
    public static final int[] DMP_09_2B00 = {0X2B, 0X00};
    public static final int DMP_09_2B00_Length = 24;
    /**
     * 9	9交易失败背景.bmp
     */
    public static final int[] DMP_09_2B20 = {0X2B, 0X20};
    public static final int DMP_09_2B20_Length = 24;

    /**
     * 9	9交易失败背景.bmp
     */
    public static final int[] DMP_09_2B40 = {0X2B, 0X40};
    public static final int DMP_09_2B40_Length = 24;

    /**
     * 9	9交易失败背景.bmp
     */
    public static final int[] DMP_09_2B60 = {0X2B, 0X60};
    public static final int DMP_09_2B60_Length = 10;

    public static final int DMP_02 = 0X02;
    public static final int DMP_02_Length = 24;
    /**
     * 2	2显示主界面.bmp
     */
    public static final int[] DMP_02_2000 = {0X20, 0X00};
    /**
     * 2	2显示主界面.bmp
     */
    public static final int[] DMP_02_2020 = {0X20, 0X20};
    /**
     * 2	2显示主界面.bmp
     */
    public static final int[] DMP_02_2040 = {0X20, 0X40};
    /**
     * 2	2显示主界面.bmp
     */
    public static final int[] DMP_02_2060 = {0X20, 0X60};


    /**
     * 3	设置界面
     */
    public static final int DMP_03 = 0X03;
    public static final int[] DMP_03_2200 = {0X22, 0X00};
    public static final int[] DMP_03_2220 = {0X22, 0X20};
    public static final int[] DMP_03_2240 = {0X22, 0X40};
    public static final int[] DMP_03_2260 = {0X22, 0X60};
    public static final int[] DMP_03_2280 = {0X22, 0X80};
    public static final int[] DMP_03_22A0 = {0X22, 0XA0};

    /**
     * 3	设置主界面
     */
    public static final int DMP_13 = 0X0D;
    public static final int[] DMP_13_4000 = {0X40, 0X00};
    public static final int[] DMP_13_4040 = {0X40, 0X40};
    public static final int[] DMP_13_4080 = {0X40, 0X80};
    public static final int[] DMP_13_40C0 = {0X40, 0XC0};
    public static final int[] DMP_13_4100 = {0X41, 0X00};
    public static final int[] DMP_13_4140 = {0X41, 0X40};
    public static final int[] DMP_13_4180 = {0X41, 0X80};
    public static final int[] DMP_13_41C0 = {0X41, 0XC0};
    public static final int[] DMP_13_4200 = {0X42, 0X00};


    public static final int DMP_12 = 0X0C;
    public static final int[] DMP_12_2D00 = {0X2D, 0X00};
    public static final int[] DMP_12_2D20 = {0X2D, 0X20};
    /**
     * 切换当前屏幕显示图片内容
     *
     * @param order:欲显示图片的编号
     * @return
     */
    public static int[] changeBG(int order) {
        CHANGE_BG[CHANGE_BG.length - 1] = order;
        return CHANGE_BG;
    }

    /**
     * 切换当前屏幕显示图片内容
     *
     * @param order:欲显示图片的编号
     * @return
     */
    public static byte[] changeBGToByte(int order) {
        CHANGE_BG[CHANGE_BG.length - 1] = order;

//        return itob(CHANGE_BG);
        return jmTtyHSL0(itob(CHANGE_BG));
    }

    public static byte[] jmTtyHSL0(byte[] bytes) {
//        byte[] bytesTemp = new byte[bytes.length * 4];
//        for (int i = 0; i < bytesTemp.length; i++) {
//            if (i % 4 == 0) {
//                bytesTemp[i] = bytes[i / 4];
//            }
//            else {
//                bytesTemp[i] = 31;
//            }
//        }
        return bytes;
    }


    public static int[] getChangeText(int[] order, int textLength) {
        int titleLength = CHANGE_TEXT.length;
        int orderLength = order.length;
        int[] back = new int[titleLength + orderLength];
        back[0] = CHANGE_TEXT[0];
        back[1] = CHANGE_TEXT[1];
        back[2] = 3 + textLength;
        back[3] = CHANGE_TEXT[3];

        for (int i = titleLength; i < back.length; i++) {
            back[i] = order[i - titleLength];
        }

        return back;
    }


    public static byte[] getChangeText(int[] order, String text, int textTotal) {

        try {
            byte[] bytes = text.getBytes("GBK");
//            return getChangeText(order, getChangeTextTotal(bytes, textTotal));
            return jmTtyHSL0(getChangeText(order, getChangeTextTotal(bytes, textTotal)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static byte[] getChangeText(int[] order, byte[] bytes) {


        int bytesLength = bytes.length;
        byte[] title = itob(getChangeText(order, bytesLength));
        int titleLength = title.length;
        byte[] back = new byte[titleLength + bytesLength];
        for (int i = 0; i < back.length; i++) {
            if (i < titleLength) {
                back[i] = title[i];
            }
            else {
                back[i] = bytes[i - titleLength];
            }


        }

        return back;
    }

    public static byte[] getChangeTextTotal(byte[] bytes, int textTotal) {
        if (bytes.length == textTotal) {
            return bytes;
        }
        else {
            byte[] back = new byte[textTotal];
            for (int i = 0; i < back.length; i++) {
                if (i < bytes.length) {
                    back[i] = bytes[i];
                }
                else {
                    back[i] = 0X20;
                }
            }

            return back;
        }

    }

//    /**
//     * 在屏幕上显示GBK编码字符
//     *
//     * @param text:显示字符
//     * @return
//     */
//    public static String displayGBK(String text) {
//

//    }

    public static byte[] itob(int[] intarr) {
        int bytelength = intarr.length;//长度
        byte[] bt = new byte[bytelength];//开辟数组
        for (int j = 0; j < intarr.length; j++) {
            bt[j] = (byte) (intarr[j] & 0b1111_1111);
        }
        return bt;
    }

    public static String toGBK(String source) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        byte[] bytes = source.getBytes("GBK");
        for (byte b : bytes) {
            sb.append(Integer.toHexString((b & 0xff)).toUpperCase());
        }

        return sb.toString();
    }
}
