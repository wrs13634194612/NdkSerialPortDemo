package com.example.iosdialogdemo;

import static java.util.Collections.reverse;

import android.os.Bundle;
import android.util.Log;

import com.example.iosdialogdemo.utils.DataChangeUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.example.iosdialogdemo.utils.DataConversion;
import com.example.iosdialogdemo.utils.MyFunc;
import com.example.iosdialogdemo.utils.HexUtil;

import com.example.iosdialogdemo.utils.DataChangeUtils;

import java.util.Arrays;

public class TwoActivity extends AppCompatActivity {
    private String code1 = "ECD8FCF6";
    private String code2 = "7CC411F7";

    private String code3 = "01ECD8FCF600000000";
    private String code4 = "017CC411F700000000";

    private String code5 = "550b0100ecd8fcf600000000b7";

    private String code6 = "5503053035";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        /*
         *  0 - 1  两位byte 代表读卡和卡离开的字段
         * 2-9 代表卡号
         *10-17 代表校验码
         * EC D8 FC F6   4143765740
         * 7C C4 11 F7   4145136764
         * * */
        /*
         String code3 = DataChangeUtils.createHex(code1);
         String byteArrToHex = MyFunc.ByteArrToHex(null);
        Log.e("TAG", ""+code5);
        需要做什么呢 ？
        30   48
        十六进制转十进制可以了、
        接下来是拆分数组  然后 调换位置
        00 7C C4 11 F7 00 00 00 00
        调换可以了  接下来  就是转十进制
        */
        ///  bytesToHex(  hexTobytes(code1));

        String str = code6.substring(6, 8);



        int str8 =   DataChangeUtils.change16To10(code6.substring(6, 8));
        Log.e("Array : ", str+str8); // print array


        long a = DataConversion.hexToDec("30");


        byte[] b = DataConversion.decodeHexString(code1);

        int[] array = {7, 8, 9, 10, 11};
        Log.e("Array : ", Arrays.toString(array)); // print array

        // Call function to get reversed array
        int[] reversedArray = reverse(array);
        byte[] reversedArray2 = reverse2(b);


        Log.e("Reversed array : ", Arrays.toString(reversedArray));

        Log.e("Reversed array_two : ", Arrays.toString(b));


        Log.e("Reversed array_two : ", Arrays.toString(reversedArray2));


        String coede6 = DataConversion.encodeHexString(reversedArray2);


        long codessss = DataConversion.hexToDec(coede6);

        //      Log.e("TAG", "" + a +"====="+coede6+"==???==="+codessss+"------------"+str);  // F6FCD8EC


        SerialPortSendData(code5);
        SerialPortSendData(code6);


    }


    public void SerialPortSendData(String content) {
        try {
            String dataBT = content.substring(0, 2);
            int dataLength = DataChangeUtils.change16To10(content.substring(2, 4)) * 2;
            if (dataLength >= 6 && content.length() > 6) {
                String dataOrder = content.substring(4, 6);
                String dataContent = content.substring(6, dataLength + 2);
                String dataCRC = content.substring(content.length() - 2, content.length());
                Log.e("TAG", "===================start==================");
                Log.e("TAG", "" + dataBT + "=====" + dataOrder + "==???===" + dataContent + "------------" + dataCRC);  // F6FCD8EC
                Log.e("TAG", "==================end=====================");
                if (dataOrder.equals("01")){
                    Log.e("TAG", "刷卡");
                }else if(dataOrder.equals("05")){
                    Log.e("TAG", "键盘");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int[] reverse(int[] array) {
        int[] newArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {

            newArray[array.length - 1 - i] = array[i];
        }

        return newArray;
    }

    static byte[] reverse2(byte[] array) {
        byte[] newArray = new byte[array.length];

        for (int i = 0; i < array.length; i++) {
            newArray[array.length - 1 - i] = array[i];
        }

        return newArray;
    }


}
