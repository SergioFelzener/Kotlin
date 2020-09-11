package br.senac.exintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_imp_main.*

class ImpMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imp_main)

      btnDetail.setOnClickListener{
          val i = Intent("br.senac.exintents.DETAIL")
          startActivity(i)
      }
    }
}