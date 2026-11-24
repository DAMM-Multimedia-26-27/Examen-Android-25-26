package ex.damm.examenandroid

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImagenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imagen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        val nombre = intent.extras?.getString("nombre") ?: "ERROR"
//        val res = intent.extras?.getInt("gato") ?: 0
        val nombre = intent.extras!!.getString("nombre")
        val res = intent.extras!!.getInt("gato")

        findViewById<TextView>(R.id.nombreImagen).text = nombre
        findViewById<ImageView>(R.id.iGrande).setImageDrawable(
            AppCompatResources.getDrawable(this, res))
    }
}