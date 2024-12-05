package com.vincent.compose.ui.view

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.vincent.compose.R
import kotlin.math.cos
import kotlin.math.sin


@Composable
fun LoadingDialog(onDismiss: () -> Unit) {

    Dialog(onDismissRequest = onDismiss) {
        Box(
            modifier = Modifier
                .width(244.dp)
                .background(Color.White, shape = MaterialTheme.shapes.medium)
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                RotatingCircleDots()
//                Spacer(modifier = Modifier.height(34.dp))
                Text("正在开通", fontSize = 16.sp, color = colorResource(R.color.color_1a1a1a))


            }
        }
    }
}


@Composable
fun RotatingCircleDots() {
    val numberOfDots = 12  // 小圆点的数量
    val radius = 50f // 圆形的半径
    val dotSize = 2f  // 小圆点的大小

    // 使用无限旋转的动画
    val infiniteTransition = rememberInfiniteTransition(label = "")

    // 旋转的角度
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,  // 转一圈的时间
                easing = LinearEasing
            )
        ), label = ""
    )

    Box(
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(100.dp)) {
            val angleStep = 360f / numberOfDots // 每个小圆点的角度间隔

            // 绘制小圆点
            for (i in 0 until numberOfDots) {
                val angle = angleStep * i + rotation // 根据旋转角度调整位置
                val x =
                    (size.width / 2) + (radius * cos(Math.toRadians(angle.toDouble()))).toFloat()
                val y =
                    (size.height / 2) + (radius * sin(Math.toRadians(angle.toDouble()))).toFloat()

                drawCircle(
                    color = Color(0xFF8A8A8A),
                    radius = dotSize * i/2,
                    center = androidx.compose.ui.geometry.Offset(x, y)
                )
            }
        }
    }
}