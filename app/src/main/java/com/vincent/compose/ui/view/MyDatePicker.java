/*
 * Copyright (c) 2016-present 贵州纳雍穿青人李裕江<1032694760@qq.com>
 *
 * The software is licensed under the Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *     http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR
 * PURPOSE.
 * See the Mulan PSL v2 for more details.
 */

package com.vincent.compose.ui.view;

import android.app.Activity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.github.gzuliyujiang.wheelpicker.DatePicker;
import com.vincent.compose.R;

/**
 * 日期选择器
 *
 * @author 贵州山野羡民（1032694760@qq.com）
 * @since 2021/6/5 18:17
 */
@SuppressWarnings("unused")
public class MyDatePicker extends DatePicker {


    public MyDatePicker(@NonNull Activity activity) {
        super(activity);
    }

    public MyDatePicker(@NonNull Activity activity, int themeResId) {
        super(activity, themeResId);
    }

    @Nullable
    @Override
    protected View createHeaderView() {
        return View.inflate(activity, R.layout.my_header_view, null);
    }

    @Nullable
    @Override
    protected View createFooterView() {
        return View.inflate(activity, R.layout.my_dialog_footer, null);
    }

    //createTopLineView

    @Nullable
    @Override
    protected View createTopLineView() {
        return null;
    }
}
