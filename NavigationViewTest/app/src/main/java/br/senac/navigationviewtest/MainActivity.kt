package br.senac.navigationviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
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

        navView.setNavigationItemSelectedListener {
            drawerLayout.closeDrawers()

            if (it.itemId == R.id.products) {
                val fragment01 = Fragment01()
                supportFragmentManager.beginTransaction().replace(R.id.fragContainer, fragment01).commit()

                true

            } else if (it.itemId == R.id.cart) {
                val fragment02 = Fragment02()
                supportFragmentManager.beginTransaction().replace(R.id.fragContainer, fragment02).commit()

                true
            }

            false
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        toggle?.let {
            return it.onOptionsItemSelected(item)
        }


        return super.onOptionsItemSelected(item)
    }


}