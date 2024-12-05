package com.vincent.compose.ui.page

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.vincent.compose.ui.view.BottomSheetDialog
import com.vincent.compose.ui.view.DatePickerDialog
import com.vincent.compose.ui.view.LoadingDialog
import com.github.gzuliyujiang.wheelpicker.DatimePicker
import com.github.gzuliyujiang.wheelpicker.annotation.DateMode
import com.github.gzuliyujiang.wheelpicker.annotation.TimeMode
import com.github.gzuliyujiang.wheelpicker.entity.DatimeEntity
import com.github.gzuliyujiang.wheelpicker.impl.UnitDateFormatter
import com.vincent.compose.ui.view.MyDatePicker
import com.vincent.compose.ui.view.MyOptionPicker

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Column {
        GradientTextExample()
    }
}

fun onYearMonthDayTime(context: AppCompatActivity) {
    val picker = DatimePicker(context)
    val wheelLayout = picker.wheelLayout
    picker.setOnDatimePickedListener { year, month, day, hour, minute, second ->
        var text = "$year-$month-$day $hour:$minute:$second"
        text += if (wheelLayout.timeWheelLayout.isAnteMeridiem) " 上午" else " 下午"
//        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show()
    }
    wheelLayout.setDateMode(DateMode.YEAR_MONTH_DAY)
    wheelLayout.setTimeMode(TimeMode.HOUR_24_NO_SECOND)
    wheelLayout.setRange(DatimeEntity.now(), DatimeEntity.yearOnFuture(10))
    wheelLayout.setDateLabel("年", "月", "日")
    wheelLayout.setTimeLabel("时", "分", "秒")
    picker.show()
}

fun onYearMonthDay(context: AppCompatActivity) {
    val picker = MyDatePicker(context)
    //picker.setBodyWidth(240);
    val wheelLayout = picker.wheelLayout
    wheelLayout.setVisibleItemCount(2)
    wheelLayout.setDateMode(DateMode.YEAR_MONTH_DAY)
    wheelLayout.setDateFormatter(UnitDateFormatter())
    wheelLayout.setCurtainEnabled(true)
    wheelLayout.setCurtainColor(0xFFF2F2F6.toInt())
    wheelLayout.setIndicatorEnabled(false)
    wheelLayout.setTextColor(0xFFA3A3A3.toInt())
    wheelLayout.setSelectedTextColor(0xFF18191D.toInt())
    picker.setOnDatePickedListener { year, month, day -> Log.d("","$year,$month,$day")}
    picker.wheelLayout.setResetWhenLinkage(false)
    picker.show()
}


fun onDialogStyle(context: AppCompatActivity) {
    val picker = MyOptionPicker(context)
    val wheelLayout = picker.wheelLayout
    wheelLayout.setVisibleItemCount(2)
    wheelLayout.setIndicatorEnabled(false)

    picker.setData(
        "永久",
        "自定义",
    )
    picker.setOnOptionPickedListener { position, item ->
        Log.d("","$item")
    }
    picker.show()
}

@Composable
fun GradientTextExample() {
    // 创建渐变色刷
    val gradientBrush = Brush.linearGradient(
        colors = listOf(Color.Cyan, Color.Magenta, Color.Yellow)
    )
    val context = LocalContext.current


    var showBottomSheet by remember { mutableStateOf(false) }
    var showLoadingDialog by remember { mutableStateOf(false) }


    // 创建一个包含渐变色文本的布局
    Column {
        Text(
            text = "渐变色文本",
            style = TextStyle(
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                brush = gradientBrush // 应用渐变色
            )
        )
        Button(onClick = { showBottomSheet = true }) {
            Text("显示底部弹出对话框")
        }
        Button(onClick = { showLoadingDialog = true }) {
            Text("显示Loading框")
        }

        Button(onClick = {
//            val testDialog = TestDialog()
            if (context is AppCompatActivity) {
//                testDialog.show(context.supportFragmentManager, testDialog.tag)
                onYearMonthDayTime(context)
            }
        }) {
            Text("显示非compose的弹窗")
        }

        Button(onClick = {
//            val testDialog = TestDialog()
            if (context is AppCompatActivity) {
//                testDialog.show(context.supportFragmentManager, testDialog.tag)
                onYearMonthDay(context)
            }
        }) {
            Text("显示非compose的弹窗")
        }
        Button(onClick = {
//            val testDialog = TestDialog()
            if (context is AppCompatActivity) {
                onDialogStyle(context)
            }
        }) {
            Text("显示条件选择弹窗")
        }
        DatePickerDialog()
    }

    if (showBottomSheet) {
        BottomSheetDialog(onDismiss = {
            showBottomSheet = false
        })
    }
    if (showLoadingDialog) {
        LoadingDialog(onDismiss = {
            showLoadingDialog = false
        })
    }
}