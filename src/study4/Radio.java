package study4;

/**
 * Created by yuanziyang on 2018/1/27.
 */
public class Radio {
    void openRadio(Battery battery) {
        battery.electricityAmount = battery.electricityAmount - 10;
    }
}

