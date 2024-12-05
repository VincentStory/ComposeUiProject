package com.vincent.compose.ui.page;


import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.github.gzuliyujiang.wheelpicker.DatePicker;
import com.github.gzuliyujiang.wheelpicker.annotation.DateMode;
import com.github.gzuliyujiang.wheelpicker.contract.OnDatePickedListener;
import com.github.gzuliyujiang.wheelpicker.entity.DateEntity;
import com.github.gzuliyujiang.wheelpicker.impl.UnitDateFormatter;
import com.github.gzuliyujiang.wheelpicker.widget.DateWheelLayout;

/**
 * @author wangwenbo
 * @date 2024/12/4
 */

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public void onYearMonthDay() {
        DatePicker picker = new DatePicker(this);
        //picker.setBodyWidth(240);
        DateWheelLayout wheelLayout = picker.getWheelLayout();
        wheelLayout.setDateMode(DateMode.YEAR_MONTH_DAY);
        //wheelLayout.setDateLabel("年", "月", "日");
        wheelLayout.setDateFormatter(new UnitDateFormatter());
        //wheelLayout.setRange(DateEntity.target(2021, 1, 1), DateEntity.target(2050, 12, 31), DateEntity.today());
        wheelLayout.setRange(DateEntity.today(), DateEntity.monthOnFuture(3));
        wheelLayout.setCurtainEnabled(true);
        wheelLayout.setCurtainColor(0xFFCC0000);
        wheelLayout.setIndicatorEnabled(true);
        wheelLayout.setIndicatorColor(0xFFFF0000);
//        wheelLayout.setIndicatorSize(view.getResources().getDisplayMetrics().density * 2);
        wheelLayout.setTextColor(0xCCCC0000);
        wheelLayout.setTextSize(14 * getResources().getDisplayMetrics().scaledDensity);
        //注：建议通过`setStyle`定制样式设置文字加大，若通过`setSelectedTextSize`设置，该解决方案会导致选择器展示时跳动一下
        //wheelLayout.setSelectedTextSize(16 * getResources().getDisplayMetrics().scaledDensity);
        wheelLayout.setSelectedTextColor(0xFFFF0000);
        //wheelLayout.getYearLabelView().setTextColor(0xFF999999);
        //wheelLayout.getMonthLabelView().setTextColor(0xFF999999);
        picker.setOnDatePickedListener(new OnDatePickedListener() {
            @Override
            public void onDatePicked(int year, int month, int day) {

            }
        });

        picker.getWheelLayout().setResetWhenLinkage(false);
        picker.show();
    }
}
