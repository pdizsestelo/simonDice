package com.example.simondice


import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

// para no usar findViewById
import kotlinx.android.synthetic.main.activity_main.*

// para observar LiveDatas
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView
    var nPinchazos = 0;
    val secuencia: MutableList<Int> = mutableListOf()
    val secuenciaPinchada: MutableList<Int> = mutableListOf()
    public val miModelo by viewModels<MyViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val miModelo by viewModels<MyViewModel>()


        val areaTexto: TextView = findViewById(R.id.textView)//Area de texto
        areaTexto.setText("Pulsa el boton para empezar")

        val botonJugar: Button = findViewById(R.id.botonJugar)//Boton
        botonJugar.setOnClickListener {
            areaTexto.setText("Repite la secuencia")

            nPinchazos = 0;
            secuencia.clear()
            secuenciaPinchada.clear()

            avanzarJuego()
            areaTexto.setText(secuencia.toString())
        }

        //VERDE: 2131165335
        //ROJO: 2131165333
        //AMARILLO: 2131165329
        //AZUL: 2131165331

        val imagenVerde: ImageView = findViewById(R.id.imgVerde)//Boton
        imagenVerde.setOnClickListener {
            confirmar(2131165335);
        }

        val imagenRojo: ImageView = findViewById(R.id.imgRojo)//Boton
        imagenRojo.setOnClickListener {
            confirmar(2131165333);
        }

        val imagenAmarillo: ImageView = findViewById(R.id.imgAmarillo)//Boton
        imagenAmarillo.setOnClickListener {
            confirmar(2131165329);
        }

        val imagenAzul: ImageView = findViewById(R.id.imgAzul)//Boton
        imagenAzul.setOnClickListener {
            confirmar(2131165331);
        }



    }

    private fun imagenesEstandar(){//Hace que todas las imagenes estén pordefecto

        //Llamar aquí a a la corutina que pare el programa 1 segundo
        miModelo.salidaLog()

        diceImage = findViewById(R.id.imgVerde)
        diceImage.setImageResource(R.drawable.simonverde)
        diceImage = findViewById(R.id.imgRojo)
        diceImage.setImageResource(R.drawable.simonrojo)
        diceImage = findViewById(R.id.imgAmarillo)
        diceImage.setImageResource(R.drawable.simonamarillo)
        diceImage = findViewById(R.id.imgAzul)
        diceImage.setImageResource(R.drawable.simonazul)
    }

    private fun avanzarJuego() {
        val randomInt = Random().nextInt(4) + 1

        val drawableResource = when (randomInt) {
            1 -> R.drawable.simonverdesaturado
            2 -> R.drawable.simonrojosaturado
            3 -> R.drawable.simonamarillosaturado
            else -> R.drawable.simonazulsaturado
        }
        secuencia.add(drawableResource)

        mostrarSecuencia();
    }

    private fun confirmar(imagenPulsada: Int) {
        nPinchazos++
        secuenciaPinchada.add(imagenPulsada)
        if (nPinchazos == secuencia.size){
            val areaTexto: TextView = findViewById(R.id.textView)

            if (secuencia.equals(secuenciaPinchada)){
                secuenciaPinchada.clear()
                areaTexto.setText("A ver si puedes con un color mas")
                avanzarJuego()
            }
            else{
                areaTexto.setText("Menudo fracaso, solo hiciste "+nPinchazos)
                secuencia.clear()
                secuenciaPinchada.clear()
            }
            nPinchazos = 0;
        }


    }

    private fun mostrarSecuencia(){//hay que hacer lo del retraso...
        var j = 0;
        while (j < secuencia.size){
            imagenesEstandar()
            if (secuencia.get(j) == R.drawable.simonverdesaturado){
                diceImage = findViewById(R.id.imgVerde)
                diceImage.setImageResource(secuencia.get(j))
            }
            else if (secuencia.get(j) == R.drawable.simonrojosaturado){
                diceImage = findViewById(R.id.imgRojo)
                diceImage.setImageResource(secuencia.get(j))
            }
            else if (secuencia.get(j) == R.drawable.simonamarillosaturado){
                diceImage = findViewById(R.id.imgAmarillo)
                diceImage.setImageResource(secuencia.get(j))
            }
            else{
                diceImage = findViewById(R.id.imgAzul)
                diceImage.setImageResource(secuencia.get(j))
            }

            
            j++;
        }
    }


}
