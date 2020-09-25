package br.senac.navigationviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var toggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)


        // certeza que nao vai ser nulo
        //drawerLayout.addDrawerListener(toggle!!)
        //toggle!!.syncState()


        //usando ElvisLet! se a variavel for nula não entra na condição pula essa parte do codigo

        toggle?.let {
            drawerLayout.addDrawerListener(it)
            it.syncState()
        }
    }
}