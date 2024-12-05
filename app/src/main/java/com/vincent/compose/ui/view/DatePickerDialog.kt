package com.vincent.compose.ui.view


import android.os.Bundle
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import java.util.*

/**
 * @author wangwenbo
 * @date 2024/12/4
 *
 */


@Composable
fun DatePickerDialog() {
    // State to hold the selected date
    val selectedDate = remember { mutableStateOf("") }
    val context = LocalContext.current

    // Function to show the date picker dialog

    fun ShowDatePickerDialog(){
        val calendar = Calendar.getInstance()
        val datePickerDialog = android.app.DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                // Set the selected date in the format "yyyy-MM-dd"
                selectedDate.value = "$year-${month + 1}-$dayOfMonth"
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    // UI with a Button to show DatePicker and Text to display the selected date
    Column {
        Button(onClick = { ShowDatePickerDialog() }) {
            Text("Select Date")
        }
        Text("Selected Date: ${selectedDate.value}")
    }
}
