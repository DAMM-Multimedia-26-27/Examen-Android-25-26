package ex.damm.examenandroid

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import utils.randint

class LanzarDadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lanzar_dado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val texto = findViewById<TextView>(R.id.resDado)

        findViewById<Button>(R.id.bD6).setOnClickListener {
            val num = randint(1, 6)
            texto.text = num.toString()
        }

        findViewById<Button>(R.id.bD10).setOnClickListener {
            val num = randint(1, 10)
            texto.text = num.toString()
        }

        findViewById<Button>(R.id.bD12).setOnClickListener {
            val num = randint(1, 12)
            texto.text = num.toString()
        }

        findViewById<Button>(R.id.bD20).setOnClickListener {
            val num = randint(1, 20)
            texto.text = num.toString()
        }

        findViewById<Button>(R.id.bDN).setOnClickListener {
            val max = findViewById<EditText>(R.id.editCaras)
                .text.toString().toInt()
            val num = randint(1, max)
            texto.text = num.toString()
        }
    }

}