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
    var i = 0;
    var nPinchazos = 0;
    val secuencia: MutableList<Int> = mutableListOf()
    val secuenciaPinchada: MutableList<Int> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val areaTexto: TextView = findViewById(R.id.textView)//Area de texto
        areaTexto.setText("Hola fulanito")

        val botonJugar: Button = findViewById(R.id.botonJugar)//Boton
        botonJugar.setOnClickListener {
            avanzarJuego()
            areaTexto.setText("")
            areaTexto.setText(secuencia.toString())
        }

        //VERDE: 2131099754
        //ROJO: 2131099752
        //AMARILLO: 2131099748
        //AZUL: 2131099750

        val imagenVerde: ImageView = findViewById(R.id.imgVerde)//Boton
        imagenVerde.setOnClickListener {
            val text = getString(R.string.saludoToast)
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
            confirmar(2131099754);
        }

        val imagenRojo: ImageView = findViewById(R.id.imgRojo)//Boton
        imagenRojo.setOnClickListener {
            val text = getString(R.string.saludoToast)
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
            confirmar(2131099752);
        }

        val imagenAmarillo: ImageView = findViewById(R.id.imgAmarillo)//Boton
        imagenAmarillo.setOnClickListener {
            val text = getString(R.string.saludoToast)
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
            confirmar(2131099748);
        }

        val imagenAzul: ImageView = findViewById(R.id.imgAzul)//Boton
        imagenAzul.setOnClickListener {
            val text = getString(R.string.saludoToast)
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
            confirmar(2131099750);
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

    private fun confirmar(imagenPulsada: Int) {//Hay que ver bien t.odo en general, por que al comprobar varias imagenes da fallo, hay que hacer lo del retraso.. y en general ir poniendo bien la app
        nPinchazos++
        secuenciaPinchada.add(imagenPulsada)
        if (nPinchazos == secuencia.size){
            nPinchazos = 0;
            val areaTexto: TextView = findViewById(R.id.textView)

            if (secuencia.equals(secuenciaPinchada)){
                areaTexto.setText("A ver si puedes con un color mas")
                avanzarJuego()//No estoy muy seguro de que pueda hacerlo llamando esta función en vez de pulsar el boton
            }
            else{
                areaTexto.setText("Menudo fracaso")
                secuencia.clear()
                secuenciaPinchada.clear()
            }
        }


    }

    private fun mostrarSecuencia(){
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
