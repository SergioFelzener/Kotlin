package br.senac.exintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_extra_main.*

class ExtraMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extra_main)

        btnSendInfoText.setOnClickListener {
            val i = Intent(this, ExtraDetailActivity::class.java)

            i.putExtra("nameClient", etName.text.toString())



            startActivity(i)
        }
    }
}