package br.senac.exintents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_url.*

class UrlActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_url)

        btnOpenUrl.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("http://sp.senac.br"))
            startActivity(i)
        }
    }
}