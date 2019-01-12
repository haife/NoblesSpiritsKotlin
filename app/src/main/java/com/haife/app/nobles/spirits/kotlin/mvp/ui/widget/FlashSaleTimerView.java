package com.haife.app.nobles.spirits.kotlin.mvp.ui.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haife.app.nobles.spirits.kotlin.R;
import com.haife.app.nobles.spirits.kotlin.mvp.inter.FlashSaleCountDownEndListener;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author haife
 * @email penghaifeng94@gmail.com
 * @since 2019/1/9
 * TODO: 商品倒计时控件
 */

public class FlashSaleTimerView extends LinearLayout {
    private TextView tv_day_decade;
    private TextView tv_day_unit;
    private TextView tv_hour_decade;
    private TextView tv_hour_unit;
    private TextView tv_min_decade;
    private TextView tv_min_unit;
    private TextView tv_sec_decade;
    private TextView tv_sec_unit;
    private int day_decade;
    private int day_unit;
    private int hour_decade;
    private int hour_unit;
    private int min_decade;
    private int min_unit;
    private int sec_decade;
    private int sec_unit;
    private Timer timer;
    private FlashSaleCountDownEndListener mCountDownEndListener;
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            countDown();
        }
    };

    public FlashSaleTimerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.flash_sale_time_count_down, this);
        tv_day_decade = view.findViewById(R.id.tv_day_decade);
        tv_day_unit = view.findViewById(R.id.tv_day_unit);
        tv_hour_decade = view.findViewById(R.id.tv_hour_decade);
        tv_hour_unit = view.findViewById(R.id.tv_hour_unit);
        tv_min_decade = view.findViewById(R.id.tv_min_decade);
        tv_min_unit = view.findViewById(R.id.tv_min_unit);
        tv_sec_decade = view.findViewById(R.id.tv_sec_decade);
        tv_sec_unit = view.findViewById(R.id.tv_sec_unit);
    }


    public void start() {
        if (timer == null) {
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.sendEmptyMessage(0);
                }
            }, 0, 1000);
        }
    }

    public void setCountDownEndListener(FlashSaleCountDownEndListener countDownEndListener) {
        mCountDownEndListener = countDownEndListener;
    }


    public void stop() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (mCountDownEndListener != null) {
            mCountDownEndListener.onCountTimeEnd();

        }

    }


    public void setTime(int day, int hour, int min, int sec) {

        if (hour >= 60 || min >= 60 || sec >= 60 || hour < 0 || min < 0
                || sec < 0) {
            throw new RuntimeException("时间格式错误,请检查你的代码");
        }
        day_decade = day / 10;
        day_unit = day - day_decade * 10;

        hour_decade = hour / 10;
        hour_unit = hour - hour_decade * 10;

        min_decade = min / 10;
        min_unit = min - min_decade * 10;

        sec_decade = sec / 10;
        sec_unit = sec - sec_decade * 10;

        tv_day_decade.setText(day_decade + "");
        tv_day_unit.setText(day_unit + "");
        tv_hour_decade.setText(hour_decade + "");
        tv_hour_unit.setText(hour_unit + "");
        tv_min_decade.setText(min_decade + "");
        tv_min_unit.setText(min_unit + "");
        tv_sec_decade.setText(sec_decade + "");
        tv_sec_unit.setText(sec_unit + "");
    }


    private void countDown() {
        if (isCarry4Unit(tv_sec_unit)) {
            if (isCarry4Decade(tv_sec_decade)) {
                if (isCarry4Unit(tv_min_unit)) {
                    if (isCarry4Decade(tv_min_decade)) {
                        if (isCarry4Unit(tv_hour_unit)) {
                            if (isCarry4Decade(tv_hour_decade)) {
                                if (isCarry4Unit(tv_day_unit)) {
                                    if (isCarry4Decade(tv_day_decade)) {
                                        stop();
                                        setTime(0, 0, 0, 0);//重置为0
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
    }


    private boolean isCarry4Decade(TextView tv) {

        int time = Integer.valueOf(tv.getText().toString());
        time = time - 1;
        if (time < 0) {
            time = 5;
            tv.setText(time + "");
            return true;
        } else {
            tv.setText(time + "");
            return false;
        }
    }


    private boolean isCarry4Unit(TextView tv) {

        int time = Integer.valueOf(tv.getText().toString());
        time = time - 1;
        if (time < 0) {
            time = 9;
            tv.setText(time + "");
            return true;
        } else {
            tv.setText(time + "");
            return false;
        }
    }



    /**
     * 将时间搓传化
     * @param mss
     * @return
     */
    public void formatTimerDuring(long mss, FlashSaleTimerView count_down_tv) {
        long days = (mss / (60 * 60 * 24));
        long hours = (mss % (60 * 60 * 24)) / (60 * 60);
        long minutes = (mss % (60 * 60)) / (60);
        long seconds = (mss % (60));
        int da = (int) days;
        int hour = (int) hours;
        int minute = (int) minutes;
        int second = (int) seconds;
        count_down_tv.setTime(da, hour, minute, second);
        count_down_tv.start();

    }

}
