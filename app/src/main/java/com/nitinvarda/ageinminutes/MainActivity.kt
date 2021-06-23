package com.nitinvarda.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        selectDate.setOnClickListener {view ->
            datePicker(view)

        }
    }


    fun datePicker (view:View){
        var myCalendar  = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, day ->

            var selectedDatee = "$day/${month+1}/$year"
            selectedDate.text =selectedDatee


            val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)

            val theDate = sdf.parse(selectedDatee)

            val selectedDateInMilliseconds = theDate!!.time
            val selectedDateInSeconds = theDate!!.time / 1000
            val selectedDateInMinutes = theDate!!.time / 60000
            val selectedDateInHours = theDate!!.time / 3600000
            val selectedDateInDays = theDate!!.time / 86400000
            var selectedDateInMonths = theDate!!.time / 2592000000
            val selectedDateInYears = theDate!!.time / 31536000000


            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

            val currentDateInMilliseconds = currentDate!!.time
            val currentDateInSeconds = currentDate!!.time / 1000
            val currentDateInMinutes = currentDate!!.time / 60000
            val currentDateInHours = currentDate!!.time / 3600000
            val currentDateInDays = currentDate!!.time / 86400000
            val currentDateInMonths = currentDate!!.time / 2592000000
            val currentDateInYears = currentDate!!.time / 31536000000



            val differenceInMilliseconds = currentDateInMilliseconds - selectedDateInMilliseconds
            val differenceInSeconds = currentDateInSeconds - selectedDateInSeconds
            val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes
            val differenceInHours = currentDateInHours - selectedDateInHours
            val differenceInDays = currentDateInDays - selectedDateInDays
            val differenceInMonths = currentDateInMonths - selectedDateInMonths
            val differenceInYears = currentDateInYears - selectedDateInYears










            milliseconds.text = differenceInMilliseconds.toString()
            seconds.text = differenceInSeconds.toString()
            minutes.text  = differenceInMinutes.toString()
            hours.text = differenceInHours.toString()
            days.text = differenceInDays.toString()
            months.text = differenceInMonths.toString()
            years.text = differenceInYears.toString()



//            Toast.makeText(this,"Selected year $year",Toast.LENGTH_SHORT).show()

         },year,month,day)
        dpd.datePicker.maxDate = Date().time-86400000
        dpd.show()






    }
}