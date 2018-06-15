package com.example.akshayparmar.thread1

import android.app.Service
import android.content.Intent
import android.nfc.Tag
import android.os.IBinder
import android.os.Message
import android.util.Log

class HelloService: Service(){

    val TAG = "MyService"

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        ShowLog("onCreate")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        ShowLog("onStartCommand")

        val runnable = Runnable {
            for (i in 1..10){
                ShowLog("Service doing Something."+i.toString())
                Thread.sleep(1000)
            }

            stopSelf()
        }

        val thread = Thread(runnable)
        thread.start()

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        ShowLog("onDestroy")
        super.onDestroy()
    }

    fun ShowLog(message: String){
        Log.d(TAG, message)
    }
}