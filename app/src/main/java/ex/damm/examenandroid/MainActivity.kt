package ex.damm.examenandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import utils.randint

class MainActivity : AppCompatActivity() {
    var gato = 1 // Esto es una pista
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.bLanzarDado).setOnClickListener {
            val intent = Intent(this, LanzarDadoActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.bConcatenarCadenas).setOnClickListener {
            val intent = Intent(this, ConcatenarActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        gato = randint(1, 4)
        val foto = findViewById<ImageView>(R.id.iFoto)

//        foto.setImageDrawable(AppCompatResources.getDrawable(this,
//            when (gato) {
//                1 -> R.drawable.gatt1
//                2 -> R.drawable.gatt2
//                3 -> R.drawable.gatt3
//                4 -> R.drawable.gatt4
//                else -> R.drawable.gatt1
//            }
//        ))
        val res = when (gato) {
                1 -> R.drawable.gatt1
                2 -> R.drawable.gatt2
                3 -> R.drawable.gatt3
                4 -> R.drawable.gatt4
                else -> R.drawable.gatt1
        }

        foto.setImageDrawable(AppCompatResources.getDrawable(this, res))

        foto.setOnClickListener {
            val intent = Intent(this, ImagenActivity::class.java)
            intent.putExtra("nombre",
                findViewById<EditText>(R.id.editNombre).text.toString())
            intent.putExtra("gato", res)
            startActivity(intent)
        }

        super.onResume()
    }
}