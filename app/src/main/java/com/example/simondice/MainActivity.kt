package com.example.simondice


import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
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

        val miModelo by viewModels<MyViewModel>()

        /*miModelo.ronda.observe(
            this,
            Observer(fun(nuevaRonda: MutableList<Int>) {
                textRonda.text = nuevaRonda.toString()
                // ejemplo de obtener el ultimo elemento
                if (nuevaRonda.lastIndex > 0)
                    Log.d(TAG_LOG, "Último elemento: " + nuevaRonda.get(nuevaRonda.lastIndex).toString())
            })
        )

        miModelo.msjBoton.observe(this, Observer {
                nuevoMsg -> comienzo.text = nuevoMsg
        })
*/

        val areaTexto: TextView = findViewById(R.id.textView)//Area de texto
        areaTexto.setText("Pulsa el boton para empezar")

        val botonJugar: Button = findViewById(R.id.botonJugar)//Boton
        botonJugar.setOnClickListener {
            areaTexto.setText("Repite la secuencia")
            avanzarJuego()
            //areaTexto.setText(secuencia.toString())
        }

        //VERDE: 2131099754
        //ROJO: 2131099752
        //AMARILLO: 2131099748
        //AZUL: 2131099750

        val imagenVerde: ImageView = findViewById(R.id.imgVerde)//Boton
        imagenVerde.setOnClickListener {
            confirmar(2131099754);
        }

        val imagenRojo: ImageView = findViewById(R.id.imgRojo)//Boton
        imagenRojo.setOnClickListener {
            confirmar(2131099752);
        }

        val imagenAmarillo: ImageView = findViewById(R.id.imgAmarillo)//Boton
        imagenAmarillo.setOnClickListener {
            confirmar(2131099748);
        }

        val imagenAzul: ImageView = findViewById(R.id.imgAzul)//Boton
        imagenAzul.setOnClickListener {
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
