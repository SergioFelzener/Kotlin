package br.senac.exfragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.strictmode.IntentReceiverLeakedViolation
import android.view.Menu
import android.view.MenuItem

class FragEstaticActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frag_estatic)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.defaut_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.openDinamicActivity) {
            val intent = Intent(this, FragDinamicActivity::class.java)
            startActivity(intent)
            return true


        } else if (item.itemId == R.id.exit) {
           finishAffinity()
            return true


        }



        return super.onOptionsItemSelected(item)
    }





}