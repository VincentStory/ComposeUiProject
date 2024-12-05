package com.vincent.compose.ui.view;


import android.app.Activity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.github.gzuliyujiang.wheelpicker.OptionPicker;

/**
 * @author wangwenbo
 * @date 2024/12/4
 */

public class MyOptionPicker extends OptionPicker {
    public MyOptionPicker(@NonNull Activity activity) {
        super(activity);
    }

    public MyOptionPicker(@NonNull Activity activity, int themeResId) {
        super(activity, themeResId);
    }

    @Nullable
    @Override
    protected View createTopLineView() {
        return null;
    }
}
