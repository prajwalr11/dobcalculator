package com.intresting.dobcalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
   private var datee: TextView?=null
    private var ageminn:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val but: Button = findViewById(R.id.butdate)

        datee=findViewById(R.id.selectedate)
        ageminn=findViewById(R.id.agemin)
        but.setOnClickListener {
            click()

        }
    }
    fun click(){

       val mycalender= Calendar.getInstance()
        val year=mycalender.get(Calendar.YEAR)
        val month=mycalender.get(Calendar.MONTH)
        val day=mycalender.get(Calendar.DAY_OF_MONTH)
        val dpd=DatePickerDialog(this,DatePickerDialog.OnDateSetListener{ view, year, month, dayOfMonth ->
            Toast.makeText(this,"Year is $year Month is ${month+1},Date is $dayOfMonth" +
                    "",Toast.LENGTH_SHORT).show()

            val selec="$dayOfMonth/${month+1}/$year"
            datee?.text=selec

            val sdf=SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
            val thedate=sdf.parse(selec)
            val minu=thedate.time/60000
            val current=sdf.parse(sdf.format(System.currentTimeMillis()))
            val curmin=current.time/60000
            val diff=curmin-minu
            ageminn?.text=diff.toString()



        },
            year,
            month,
            day
        )
        dpd.datePicker.maxDate=System.currentTimeMillis()-8640000
dpd.show()
    }
}