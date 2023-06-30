package com.example.dateandtimepicker

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var btnDatePicker : Button //date
    lateinit var btnTimePicker : Button
    lateinit var txtDate : EditText
    lateinit var txtTime : EditText
    private var mYear : Int = 0
    private var mMonth : Int =0
    private var mDay : Int =0
    private var mHour : Int =0
    private var mMinute : Int=0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker = findViewById(R.id.btn_date)
        btnTimePicker = findViewById(R.id.btn_time)
        txtDate = findViewById(R.id.in_date)
        txtTime = findViewById(R.id.in_time)
        btnDatePicker.setOnClickListener{
            val c = Calendar.getInstance()
            mYear = c[Calendar.YEAR]
            mMonth = c[Calendar.MONTH]
            mDay = c[Calendar.DAY_OF_MONTH]
            val datePickerDialog = DatePickerDialog(
                this,
                {
                        view,year,monthOfYear,dayOfMonth->txtDate.setText(
                    dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year
                )
                },
                mYear,mMonth,mDay
            )
            datePickerDialog.show()
        }

        btnTimePicker.setOnClickListener{
            val c = Calendar.getInstance()
            mHour = c[Calendar.HOUR_OF_DAY]
            mMinute = c[Calendar.MINUTE]
            val timePickerDialog = TimePickerDialog(
                this,
                {
                        view,hourOfDay,minute->
                    var hourOfDay = hourOfDay
                    val AM_PM =
                        if(hourOfDay < 12){
                            "AM"
                        }
                        else{
                            "PM"
                        }
                    if(AM_PM == "PM") hourOfDay -= 12
                    if(hourOfDay == 0) hourOfDay += 12
                    if(minute<10)
                        txtTime.setText("$hourOfDay:0$minute $AM_PM")
                    else
                        txtTime.setText("$hourOfDay:$minute $AM_PM")
                },mHour,mMinute,true
            )
            timePickerDialog.show()
        }
    }
}