package br.senac.exintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ex_main.*

class ExMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex_main)

        btnDetail.setOnClickListener {
            val i = Intent(this, DetailActivity::class.java )
            startActivity(i)

        }


    }
}