package com.example.simondice

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object MisCorutinas {
    fun salidaLog() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)
            System.out.println("Adiooooooos!")
        }
    }
}

//No entendí bien lo de las corrutinas y creo que esto nunca se llega a ejecutar