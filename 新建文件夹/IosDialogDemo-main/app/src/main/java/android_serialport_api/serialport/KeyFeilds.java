package android_serialport_api.serialport;

/**
 * 项目名称:OneCard
 * 创建人:kexiang
 * 创建时间:2018-11-20 9:50
 *
 *  * add for lkj
 F4  244  0xF4
 F3  243  0xF3
 F2  242  0xF2
 F1  241  0xF1
 取消 49  0x31
 上   16  0x10
 下   17  0x11
 确定 48  0x30
 .    11  0x0B
 0    1   0x01
 菜单 35  0x23
 1    2   0x02
 2    3   0x03
 3    4   0x04
 ......
 9    10 0x0A
 */

public class KeyFeilds {

    public static final int KEY0 = 1;
    public static final int KEY1 = 2;
    public static final int KEY2 = 3;
    public static final int KEY3 = 4;
    public static final int KEY4 = 5;
    public static final int KEY5 = 6;
    public static final int KEY6 = 7;
    public static final int KEY7 = 8;
    public static final int KEY8 = 9;
    public static final int KEY9 = 10;
    public static final int KEYF1 = 0xF1;
    public static final int KEYF2 = 0xF2;
    public static final int KEYF3 = 0xF3;
    public static final int KEYF4 = 0xF4;
    public static final int UPIN = 16;
    public static final int DOWNIN = 17;
    public static final int ESCIN = 0x31;
    public static final int ENTERIN = 0x30; //48
    public static final int POINTIN = 0x0B;
    public static final int ADDIN = 0x20;
    public static final int KEYMENU = 0x23;
}