package com.example.simondice

import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random


class MyViewModel() : ViewModel() {
    fun salidaLog() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)
            System.out.println("Holaaaaaa!")
        }
    }
}

//En vez de solo decir Hola por consola debería de parar la ejecución del código o por lo menos la de cuando se ilumine un botón
//Pero como mi código no está adaptado para el viewModel no lo conseguí hacer. Tuve problemas hasta hoy día 02/12/2020 para instanciar
//el "miModelo" por lo cual no podía trabajar con el, y mi código está pensado para no hacerlo. Tendría que rehacer practicamente toda
//la lógica del programa, por varios motivos, el resto de funciones se ejecutan a partir de una primera llamada avanzarJuego y
//trabajo directamente con las imágenes, no con botones, por lo que en los arrays guardo directamente una referencia a las imagenes,
//no un número aleatorio, por lo que esas funciones no se deberían hacer en el viewModel ya que trabajan con el frontend. (°ー°〃)

//El programa funcina muy bien y es muy bonito, lo único que le falta es que se pare con la corutina, pero el botón
//de jugar sirve tanto para empezar el juego como para reiniciarlo y no genera ningún tipo de problema o error, da igual que se
//haga cuando hemos fallado o a mitad de una ronda.

//Siento no utilizar bien las corutinas y el viewModel, espero que se valore el código y la lógica del juego  ~(>_<。)＼