package com.example.user.mathgame;

import android.util.Log;

import java.io.IOException;
import java.io.OutputStream;

        import android.util.Log;

        import java.io.IOException;
        import java.io.OutputStream;

/**
 * 项目名称:OneCard
 * 创建人:kexiang
 * 创建时间:2018-12-20 9:24
 */

public class DWpShwoView {
    private OutputStream mOutputStream;

    public DWpShwoView(OutputStream mOutputStream) {
        this.mOutputStream = mOutputStream;
    }

    private int[] logo = new int[]{
            0X18, 0X1A
    };


    /**
     * 启动轮播广告
     */
    public void startRunningLogo() {
        Log.i("startRunningLogo", "startRunningLogo");
        try {
            mOutputStream.write(DMPutils.changeBGToByte(logo[0]));
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("startRunningLogo", "startRunningLogo11");
        }
    }

    /**
     * 定值模式下输入金额点击确定显示界面
     *
     * @throws IOException
     */
    public void dwpShowPayMoneyWait(String money)   {
        //迪文屏幕切换

        try {
            mOutputStream.write(DMPutils.changeBGToByte(DMPutils.DMP_05));
            mOutputStream.write(DMPutils.getChangeText(
                    DMPutils.AD_X05_TITLE,
                    money,
                    DMPutils.AD_X05_TITLE_LENGTH)
            );

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void dwpShowInputMoney(String money)   {
        //切换到金额显示迪文屏
        try {
            mOutputStream.write(DMPutils.changeBGToByte(DMPutils.DMP_0C));
            //显示输入的金额
            mOutputStream.write(DMPutils.getChangeText(DMPutils.AD_PAY_MONEY, "￥" + money,
                    DMPutils.AD_PAY_MONEY_LENGTH));
            mOutputStream.write(DMPutils.getChangeText(DMPutils.AD_PAY_MONEY_TITLE, "交易金额",
                    DMPutils.AD_PAY_MONEY_TITLE_LENGTH));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void dwpShowStatus(String status) {
        //切换到金额显示迪文屏
        try {
            mOutputStream.write(DMPutils.changeBGToByte(DMPutils.DMP_0C));
            //显示输入的金额
            mOutputStream.write(DMPutils.getChangeText(DMPutils.AD_PAY_MONEY, "",
                    DMPutils.AD_PAY_MONEY_LENGTH));
            mOutputStream.write(DMPutils.getChangeText(DMPutils.AD_PAY_MONEY_TITLE, status,
                    DMPutils.AD_PAY_MONEY_TITLE_LENGTH));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void dwpPaySuccess(
            String dwp01, String dwp02, String dwp03, String dwp04
    ) {
        try {
            if (mOutputStream != null) {


                mOutputStream.write(DMPutils.changeBGToByte(DMPutils.DMP_14));

                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_14_5000,
                        dwp01,
                        DMPutils.DMP_14_5000_Length
                ));
                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_14_5020,
                        dwp02,
                        DMPutils.DMP_14_5020_Length
                ));


                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_14_5040,
                        dwp03,
                        DMPutils.DMP_14_5040_Length
                ));
                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_14_5060,
                        dwp04,
                        DMPutils.DMP_14_5060_Length
                ));

                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_14_5080,
                        "支付成功",
                        DMPutils.DMP_14_5080_Length
                ));


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dwpPayFaild(String faild) {
        try {
            if (mOutputStream != null) {


                mOutputStream.write(DMPutils.changeBGToByte(DMPutils.DMP_09));



                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_09_2B00,
                        "",
                        DMPutils.DMP_09_2B00_Length
                ));
                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_09_2B20,
                        faild,
                        DMPutils.DMP_09_2B20_Length
                ));
                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_09_2B40,
                        "",
                        DMPutils.DMP_09_2B40_Length
                ));

                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_09_2B60,
                        "支付失败",
                        DMPutils.DMP_09_2B60_Length
                ));


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dwpOrderFaild(String faild) {
        try {
            if (mOutputStream != null) {


                mOutputStream.write(DMPutils.changeBGToByte(DMPutils.DMP_09));


                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_09_2B00,
                        "",
                        DMPutils.DMP_09_2B00_Length
                ));
                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_09_2B20,
                        faild,
                        DMPutils.DMP_09_2B20_Length
                ));
                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_09_2B40,
                        "",
                        DMPutils.DMP_09_2B40_Length
                ));

                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_09_2B60,
                        "取餐失败",
                        DMPutils.DMP_09_2B60_Length
                ));


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 放开后显示金额
     *
     * @param dwp2000
     * @param dwp2020
     * @param dwp2040
     * @param dwp2060
     */
    public void dwpShowDownInputMoney(String dwp2000, String dwp2020, String dwp2040, String dwp2060) {
        try {
            if (mOutputStream != null) {


                mOutputStream.write(DMPutils.changeBGToByte(DMPutils.DMP_02));


                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_02_2000,
                        dwp2000,
                        DMPutils.DMP_02_Length
                ));

                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_02_2020,
                        dwp2020,
                        DMPutils.DMP_02_Length
                ));

                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_02_2040,
                        dwp2040,
                        DMPutils.DMP_02_Length
                ));

                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_02_2060,
                        dwp2060,
                        DMPutils.DMP_02_Length
                ));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void dwpShowSetHome(String... params) {
        try {
            if (mOutputStream != null) {

                mOutputStream.write(DMPutils.changeBGToByte(DMPutils.DMP_03));

                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_03_2200,
                        params.length>0?params[0]:"",
                        DMPutils.DMP_02_Length
                ));

                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_03_2220,
                        params.length>1?params[1]:"",
                        DMPutils.DMP_02_Length
                ));

                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_03_2240,
                        params.length>2?params[2]:"",
                        DMPutils.DMP_02_Length
                ));

                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_03_2260,
                        params.length>3?params[3]:"",
                        DMPutils.DMP_02_Length
                ));

                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_03_2280,
                        params.length>4?params[4]:"",
                        DMPutils.DMP_02_Length
                ));

                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_03_22A0,
                        params.length>5?params[5]:"",
                        DMPutils.DMP_02_Length
                ));

//

//                mOutputStream.write(DMPutils.changeBGToByte(DMPutils.DMP_13));
//
//                mOutputStream.write(DMPutils.getChangeText(
//                        DMPutils.DMP_13_4000,
//                        dwp4000,
//                        DMPutils.DMP_02_Length
//                ));
//
//                mOutputStream.write(DMPutils.getChangeText(
//                        DMPutils.DMP_13_4040,
//                        dwp4040,
//                        DMPutils.DMP_02_Length
//                ));
//
//                mOutputStream.write(DMPutils.getChangeText(
//                        DMPutils.DMP_13_4080,
//                        dwp4080,
//                        DMPutils.DMP_02_Length
//                ));
//
//                mOutputStream.write(DMPutils.getChangeText(
//                        DMPutils.DMP_13_40C0,
//                        dwp40C0,
//                        DMPutils.DMP_02_Length
//                ));
//
//                mOutputStream.write(DMPutils.getChangeText(
//                        DMPutils.DMP_13_4100,
//                        dwp4100,
//                        DMPutils.DMP_02_Length
//                ));
//
//                mOutputStream.write(DMPutils.getChangeText(
//                        DMPutils.DMP_13_4140,
//                        dwp4140,
//                        DMPutils.DMP_02_Length
//                ));
//
//                mOutputStream.write(DMPutils.getChangeText(
//                        DMPutils.DMP_13_4180,
//                        dwp4180,
//                        DMPutils.DMP_02_Length
//                ));
//
//                mOutputStream.write(DMPutils.getChangeText(
//                        DMPutils.DMP_13_41C0,
//                        dwp41C0,
//                        DMPutils.DMP_02_Length
//                ));
//
//                mOutputStream.write(DMPutils.getChangeText(
//                        DMPutils.DMP_13_4200,
//                        dwp4200,
//                        DMPutils.DMP_02_Length
//                ));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dwpShowSaveSuccess() {
        try {
            if (mOutputStream != null) {
                mOutputStream.write(DMPutils.changeBGToByte(DMPutils.DMP_03));
                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_03_22A0,
                        "                   成功",
                        DMPutils.DMP_02_Length
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dwpShowSaveFail() {
        try {
            if (mOutputStream != null) {
                mOutputStream.write(DMPutils.changeBGToByte(DMPutils.DMP_03));
                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_03_22A0,
                        "                   失败",
                        DMPutils.DMP_02_Length
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    public static final int[] DMP_01_1200 = {0X12, 0X00};
//    public static final int[] DMP_01_1220 = {0X12, 0X20};
//    public static final int[] DMP_01_1300 = {0X13, 0X00};
//    public static final int[] DMP_01_1020 = {0X10, 0X20};
//    public static final int[] DMP_01_1040 = {0X10, 0X40};
//    public static final int[] DMP_01_1060 = {0X10, 0X60};
//    public static final int[] DMP_01_1080 = {0X10, 0X80};
//    public static final int[] DMP_01_10A0 = {0X10, 0XA0};
//    public static final int[] DMP_01_10C0 = {0X10, 0XC0};
//    public static final int[] DMP_01_1100 = {0X11, 0X00};
//    public static final int[] DMP_01_1120 = {0X11, 0X20};
    //设置待机界面
    public void dwpSetStandby(String dwp1200, String dwp1000, String dwp1300, String dwp1020, String dwp1040, String dwp1060, String dwp1080,
                              String dwp10A0, String dwp10C0, String dwp1100, String dwp1120){
        if(mOutputStream!=null){
            try{
                mOutputStream.write(DMPutils.changeBGToByte(DMPutils.DMP_01));


                mOutputStream.write(HEX.hexToBytes("5AA5058212000003"));

                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_01_1000,
                        dwp1000,
                        16
                ));


                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_01_1020,
                        dwp1020,
                        12
                ));

                //连接状态
                if(dwp1300.equals("1")){
                    Log.i("dwp1300","1");
                    mOutputStream.write(HEX.hexToBytes("5AA5058213000003"));
                } else {
                    Log.i("dwp1300","0");
                    mOutputStream.write(HEX.hexToBytes("5AA5058213000002"));
                }

                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_01_1040,
                        dwp1040,
                        12
                ));

                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_01_1060,
                        dwp1060,
                        12
                ));

                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_01_1080,
                        dwp1080,
                        14
                ));

                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_01_10A0,
                        dwp10A0,
                        12
                ));

                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_01_10C0,
                        dwp10C0,
                        12
                ));

                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_01_1100,
                        dwp1100,
                        24
                ));

                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_01_1120,
                        dwp1120,
                        12
                ));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void dwpSetBrushFace(String dwp2800){
        if(mOutputStream!=null) {
            try {
                mOutputStream.write(DMPutils.changeBGToByte(DMPutils.DMP_05));
                mOutputStream.write(DMPutils.getChangeText(
                        DMPutils.DMP_05_2800,
                        dwp2800,
                        10
                ));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void destroy() {
        mOutputStream = null;
    }
}
