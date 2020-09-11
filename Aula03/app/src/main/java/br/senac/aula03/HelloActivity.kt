package br.senac.aula03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hello.*

class HelloActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        btnHello.setOnClickListener {

            var pronoum = "";

            when (rgPronoums.checkedRadioButtonId) {
                R.id.rbShe -> pronoum = getString(R.string.she)
                R.id.rbHe -> pronoum = getString(R.string.he)
                R.id.rbNone -> pronoum = getString(R.string.neutral)

            }

            val msg = getString(R.string.hello) + " "  + etName.text +  "\n"  +  getString(R.string.msg) + "\n" + pronoum + "\n" + getString(R.string.finish)
            alert(getString(R.string.done), msg, this)

        }


    }
}