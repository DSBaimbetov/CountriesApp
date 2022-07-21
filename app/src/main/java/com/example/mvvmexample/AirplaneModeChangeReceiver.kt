package com.example.mvvmexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class AirplaneModeChangeReceiver: BroadcastReceiver() {
    //эта функция будет выполнена, когда пользователь изменит свой режим полета
    override fun onReceive(context: Context?, intent: Intent?) {

        // если getBooleanExtra содержит нулевое значение,
        // он будет непосредственно возвращен обратно
        when(intent!!.getBooleanExtra("state", false)) {
            true -> Toast.makeText(context, "Режим полета включен", Toast.LENGTH_LONG).show()
            false -> Toast.makeText(context, "Режим полета выключен", Toast.LENGTH_LONG).show()
        }
    }
}