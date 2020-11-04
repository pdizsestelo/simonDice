package com.example.simondice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView
    var rondas = 1;
    val secuencia: MutableList<Int> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val areaTexto: TextView = findViewById(R.id.textView)//Area de texto
        areaTexto.setText("Hola fulanito")

        val botonJugar: Button = findViewById(R.id.botonJugar)//Boton
        botonJugar.setOnClickListener {
            empezarJuego()
            areaTexto.setText(secuencia.toString())
        }

        val imagenVerde: ImageView = findViewById(R.id.imgVerde)//Boton
        imagenVerde.setOnClickListener {
            val text = getString(R.string.saludoToast)
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
        }



    }

    private fun imagenesEstandar(){//Hace que todas las imagenes estén pordefecto
        diceImage = findViewById(R.id.imgVerde)
        diceImage.setImageResource(R.drawable.simonverde)
        diceImage = findViewById(R.id.imgRojo)
        diceImage.setImageResource(R.drawable.simonrojo)
        diceImage = findViewById(R.id.imgAmarillo)
        diceImage.setImageResource(R.drawable.simonamarillo)
        diceImage = findViewById(R.id.imgAzul)
        diceImage.setImageResource(R.drawable.simonazul)
    }

    private fun empezarJuego() {
        //No está muy claro, pero aquí iniciaría lo básico y en jugar (que se ejecuta al pulsar un color) compruebe cuantas veces lleva pulsado y así y sea donde se hace mas o menos todo
    }

    private fun jugar() {
        var i = 0;
        while (i < rondas){
            val randomInt = Random().nextInt(4) + 1
            val drawableResource = when (randomInt) {
                1 -> R.drawable.simonverdesaturado
                2 -> R.drawable.simonrojosaturado
                3 -> R.drawable.simonamarillosaturado
                else -> R.drawable.simonazulsaturado
            }

            secuencia.add(drawableResource)

            /////////////////////
//            var tamaño = secuencia.size;
//            var text = tamaño.toString()
//            val duration = Toast.LENGTH_SHORT
//            val toast = Toast.makeText(applicationContext, text, duration)
//            toast.show()
            /////////////////////

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


            i++;
        }


    }


}
