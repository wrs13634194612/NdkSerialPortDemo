package com.example.user.mathgame;



        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

     /*   import com.yqsh.sdk.demo.utils.DWpShwoView;
        import com.yqsh.sdk.demo.utils.DataChangeUtils;
        import com.yqsh.sdk.demo.utils.DateUtils;
        import com.yqsh.sdk.demo.utils.EntityKeyBoardUtils;
        import com.yqsh.sdk.demo.utils.NetWorkUtil;
        import com.yqsh.sdk.demo.utils.SerialPortScreenUtils;*/

        import java.util.Timer;
        import java.util.TimerTask;

        import android_serialport_api.SerialPortListener;
        import android_serialport_api.SerialPortScreenUtils;
        import android_serialport_api.serialport.KeyFeilds;
        import android_serialport_api.serialport.OrderFields;
        import android_serialport_api.serialport.SerialPortSendData;
/*        import android_serialport_api.SerialPortListener;
        import android_serialport_api.serialport.KeyFeilds;
        import android_serialport_api.serialport.OrderFields;
        import android_serialport_api.serialport.SerialPortSendData;*/


public class MainActivity extends AppCompatActivity  implements SerialPortListener {

    private static final String TAG = "MainActivity";


    //串口屏幕操作
    private SerialPortScreenUtils serialPortScreenUtils;
    private DWpShwoView dWpShwoView;

    //实体键盘操作
    protected EntityKeyBoardUtils entityKeyBoardUtils;
    private Button btn;
    private Timer standbyTimer;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        //初始化串口键盘
        initEntityKeyBoard();

        //初始化串口屏幕
        initSerialPortScreenUtil();

    }

    private void initView(){
        btn=findViewById(R.id.btn);
        tv = findViewById(R.id.tv);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //列展示 (多菜单展示)
                stopStandby();
                dWpShwoView.dwpShowSetHome("1","2","3","4","5","6","","","");
            }
        });

    }

    private void initEntityKeyBoard(){
        entityKeyBoardUtils=new EntityKeyBoardUtils(getApplicationContext(),this);
    }

    private void initSerialPortScreenUtil(){
        serialPortScreenUtils=new SerialPortScreenUtils(this,this);
        try{
            if(serialPortScreenUtils.mSerialPortUtils!=null){
                dWpShwoView=new DWpShwoView(serialPortScreenUtils.mSerialPortUtils.getmOutputStream());
                //主页
                setStandby();
                //一直开启红外
//                entityKeyBoardUtils.writeData("12","01");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //设置主页显示
    private void setStandby(){
        if(standbyTimer!=null){
            standbyTimer.cancel();
        }
        standbyTimer = new Timer();
        standbyTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                dWpShwoView.dwpSetStandby("","人脸识别消费机", NetWorkUtil.isConn(MainActivity.this)?"1":"0","","自由模式", "史蒂夫","0.00","","", DateUtils.getNyr(),DateUtils.getBarTime());
            }
        },0,1000);//延时1s执行
    }



    @Override
    public void displayError(int res) {
        Log.i("displayError",getString(res));
    }

    @Override
    public void onDataReceived(byte[] buffer, int size, int type) {

    }

    @Override
    public void onDataReceivedString(String back, int type) {

    }

    @Override
    public void onDataReceivedObjectMainThread(SerialPortSendData backBean, int type) {
        //收到按键通知
        if(backBean.getDataOrder().equals(OrderFields.M1_KEY)){
            Log.i("keyBack",""+ DataChangeUtils.change16To10(backBean.getDataContent()));
            tv.setText("接受到:  " + DataChangeUtils.change16To10(backBean.getDataContent()));
            keyBack(DataChangeUtils.change16To10(backBean.getDataContent()));

        }

    }

    public synchronized void keyBack(int key) {
        //停止主页
        stopStandby();
        try {
            switch (key) {
                case KeyFeilds.KEY0:
                    Log.i("key","KeyFeilds.KEY0");

                    dWpShwoView.dwpShowInputMoney("0");
                    break;
                case KeyFeilds.KEY1:
                    Log.i("key","KeyFeilds.KEY1");
                    dWpShwoView.dwpShowInputMoney("1");
                    break;
                case KeyFeilds.KEY2:
                    Log.i("key","KeyFeilds.KEY2");
                    dWpShwoView.dwpShowInputMoney("2");
                    break;
                case KeyFeilds.KEY3:
                    Log.i("key","KeyFeilds.KEY3");
                    dWpShwoView.dwpShowInputMoney("3");
                    break;
                case KeyFeilds.KEY4:
                    Log.i("key","KeyFeilds.KEY4");
                    dWpShwoView.dwpShowInputMoney("4");
                    break;
                case KeyFeilds.KEY5:
                    Log.i("key","KeyFeilds.KEY5");
                    dWpShwoView.dwpShowInputMoney("5");
                    break;
                case KeyFeilds.KEY6:
                    Log.i("key","KeyFeilds.KEY6");
                    dWpShwoView.dwpShowInputMoney("6");
                    break;
                case KeyFeilds.KEY7:
                    Log.i("key","KeyFeilds.KEY7");
                    dWpShwoView.dwpShowInputMoney("7");
                    break;
                case KeyFeilds.KEY8:
                    Log.i("key","KeyFeilds.KEY8");
                    dWpShwoView.dwpShowInputMoney("8");
                    break;
                case KeyFeilds.KEY9:
                    Log.i("key","KeyFeilds.KEY9");
                    dWpShwoView.dwpShowInputMoney("9");
                    break;
                case KeyFeilds.POINTIN:
                    Log.i("key","KeyFeilds.POINTIN");
                    break;
                case KeyFeilds.KEYF1:
                    Log.i("key","KeyFeilds.KEYF1");
                    break;
                case KeyFeilds.KEYF2:
                    Log.i("key","KeyFeilds.KEYF2");
                    break;
                case KeyFeilds.KEYF3:
                    Log.i("key","KeyFeilds.KEYF3");
                    break;
                case KeyFeilds.KEYF4:
                    Log.i("key","KeyFeilds.KEYF4");
                    break;
                case KeyFeilds.ESCIN:
                    //清除
                    Log.i("key","KeyFeilds.ESCIN");
                    break;
                case KeyFeilds.ENTERIN:
                    //确定
                    Log.i("key","KeyFeilds.ENTERIN");
                    break;
                case KeyFeilds.KEYMENU:
                    //菜单
                    break;
                case KeyFeilds.UPIN:
                    break;
                case KeyFeilds.ADDIN:
                    break;
                case KeyFeilds.DOWNIN:
                    Log.i("key","KeyFeilds.DOWNIN");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //串口屏幕函数
    private void dwpFun(){
        //列展示 (多菜单展示)
        dWpShwoView.dwpShowSetHome("1","2","3","4","5","6","","","");
        //显示消费金额
        dWpShwoView.dwpShowInputMoney("1.00");
        //显示保存成功
        dWpShwoView.dwpShowSaveSuccess();
        //显示请刷脸支付
        dWpShwoView.dwpSetBrushFace("1.00");
        //显示消费失败
        dWpShwoView.dwpPayFaild("支付失败");
        //显示消费成功
        dWpShwoView.dwpPaySuccess("姓名:",
                "学号:",
                "消费金额:",
                "消费时间:");
    }

    private void stopStandby(){
        if(standbyTimer!=null){
            standbyTimer.cancel();
        }
    }
}