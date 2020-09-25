package br.senac.exfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_frag_dinamic.*

class FragDinamicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frag_dinamic)

        btnFrag01.setOnClickListener {
            val frag1 = FragmentTest01()

            supportFragmentManager.beginTransaction().replace(R.id.fragContainer, frag1).commit()


        }

        btnFrag02.setOnClickListener {
            val frag2 = FragmentTest02()

            supportFragmentManager.beginTransaction().replace(R.id.fragContainer, frag2).commit()
        }
    }
}