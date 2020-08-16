package com.mani.mydialogdemo

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import org.w3c.dom.Text
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val tvAlert = findViewById<TextView>(R.id.tvAlert)
        val tvInput = findViewById<TextView>(R.id.tvInput)
        val tvDate = findViewById<TextView>(R.id.tvDate)
        val tvTime = findViewById<TextView>(R.id.tvTime)
        val tvCustom = findViewById<TextView>(R.id.tvCustom)
        val tvToast = findViewById<TextView>(R.id.tvToast)

        tvAlert.setOnClickListener(this)
        tvInput.setOnClickListener(this)
        tvDate.setOnClickListener(this)
        tvTime.setOnClickListener(this)
        tvCustom.setOnClickListener(this)
        tvToast.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when(v!!.id)
        {
            R.id.tvAlert ->{

                openAlertDailog()

            }

            R.id.tvInput ->{

                openInputDialog()
            }
            R.id.tvDate ->{

                openDateDialog()
            }
            R.id.tvTime ->{

                openTimeDailog()
            }
            R.id.tvCustom ->{

                openCustomDialog()
            }
            R.id.tvToast->{

                Toast.makeText(this,"This is Toast Message",Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun openCustomDialog() {

        val mDailog = Dialog(this)
        mDailog.setContentView(R.layout.my_custom_dialog)

        val etUserName = mDailog.findViewById<EditText>(R.id.etUserName)
        val etPassword = mDailog.findViewById<EditText>(R.id.etPassword)
        val btnLogin = mDailog.findViewById<Button>(R.id.btnLogin)
        val btnCancel = mDailog.findViewById<Button>(R.id.btnCancel)

        btnLogin.setOnClickListener {

            val userName = etUserName!!.text.toString()
            val password = etPassword!!.text.toString()

                // Perform Logic

            mDailog.dismiss()
        }

        btnCancel.setOnClickListener {

            mDailog.dismiss()
        }

        mDailog.show()

    }

    private fun openTimeDailog() {

        val mCalendar = Calendar.getInstance()
        val mHour = mCalendar.get(Calendar.HOUR)
        val mMinute = mCalendar.get(Calendar.MINUTE)

        // 12 Hours Format  ==== >false
        // 24 Hours Format  ==== >true

        val timePicker = TimePickerDialog(this,TimePickerDialog.OnTimeSetListener{view, hourOfDay, minute ->  },mHour,mMinute,true)
        timePicker.show()

    }

    private fun openDateDialog() {

        val mCalendar = Calendar.getInstance()
        val mYear = mCalendar.get(Calendar.YEAR)
        val mMonth = mCalendar.get(Calendar.MONTH)
        val mDate = mCalendar.get(Calendar.DATE)

        val datePicker = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->


            val yearData = year
            val monthData = month+1
            val dayData = dayOfMonth


            val currentSelectedDate = dayData.toString()+"/"+monthData.toString()+"/"+yearData.toString()

            Toast.makeText(this,currentSelectedDate,Toast.LENGTH_SHORT).show()


        },mYear,mMonth,mDate)
        datePicker.show()

    }

    private fun openInputDialog() {

        val  builder = AlertDialog.Builder(this)
        builder.setIcon(R.mipmap.ic_launcher)
        builder.setTitle("Input Dialog")
        val etUserName = EditText(this)
        builder.setView(etUserName)
        builder.setCancelable(false)

        builder.setPositiveButton("OK",{ dialogInterface: DialogInterface, i: Int ->

            // Perform Ur Action

            val userName = etUserName!!.text.toString()
            Toast.makeText(this,""+userName,Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()

        }
        )
        builder.setNegativeButton("CANCEL",{ dialogInterface: DialogInterface, i: Int ->

            dialogInterface.dismiss()

        })



        builder.show()


    }

    private fun openAlertDailog() {

        val  builder = AlertDialog.Builder(this)
        builder.setIcon(R.mipmap.ic_launcher)
        builder.setTitle("No Internet Connection")
        builder.setCancelable(false)
        builder.setMessage("Do You Want to Connect with Internet")
        builder.setPositiveButton("OK",{ dialogInterface: DialogInterface, i: Int ->

            // Perform Ur Action

            Toast.makeText(this,"Check with Internet Connection",Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()

        }
        )
        builder.setNegativeButton("CANCEL",{ dialogInterface: DialogInterface, i: Int ->

            dialogInterface.dismiss()

        })

        builder.show()

    }
}