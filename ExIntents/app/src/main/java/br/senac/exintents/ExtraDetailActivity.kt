package br.senac.exintents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_extra_main.*

class ExtraDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extra_main)

        val name = intent.getStringExtra("nameClient")

        etName.setText(name + " Get To Main")

    }
}