package android_serialport_api;



        import android.content.Context;


        import com.example.user.mathgame.R;

        import java.io.File;
        import java.io.IOException;
        import java.security.InvalidParameterException;

        import android_serialport_api.serialport.Fields;
  /*      import android_serialport_api.SerialPortListener;
        import android_serialport_api.SerialPortUtils;
        import android_serialport_api.serialport.Fields;*/

/**
 * Created by heshuai on 2018-12-29.
 *
 * 串口键盘监听
 */
public class SerialPortScreenUtils {

//    private final static EntityKeyBoardUtils INSTANCE = new EntityKeyBoardUtils();
//
//    public static EntityKeyBoardUtils getInstance(){
//        return INSTANCE;
//    }

    public SerialPortUtils mSerialPortUtils;
    private SerialPortListener mSerialPortListener;
    public SerialPortScreenUtils(Context context, SerialPortListener serialPortListener){
        mSerialPortListener=serialPortListener;
        initSerialPort(context);
    }

    public void initSerialPort(Context context) {
        try {

//            String path = "/dev/ttyHSL2";
//            String path = "/dev/ttyS1";
            String path = "/dev/ttyS5";
            int baudrate = 115200;
            /* Open the serial port */
            mSerialPortUtils = new SerialPortUtils(new File(path), baudrate, 0);
            mSerialPortUtils.openReciveMessage(Fields.SERIAL_PORT_01);
        } catch (SecurityException e) {
            mSerialPortListener.displayError(R.string.error_security);
        } catch (IOException e) {
            mSerialPortListener.displayError(R.string.error_unknown);
        } catch (InvalidParameterException e) {
            mSerialPortListener.displayError(R.string.error_configuration);
        }
    }

    public void destory(){
        mSerialPortUtils.onDestroy();
    }
}
