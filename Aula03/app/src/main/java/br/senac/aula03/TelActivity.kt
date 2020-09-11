package br.senac.aula03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_tel.*

class TelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tel)

        val itens = arrayOf("Selecione", "Cel", "Res", "Com", "Outro")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, itens )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spTel.adapter = adapter

        btnDone.setOnClickListener {
            if (!etName.text.isEmpty() && !etTel.text.isEmpty() && spTel.selectedItemPosition != 0 ){

                val msg = """ Name: ${etName.text}
                            |
                            | Phone: ${etTel.text}
                            | 
                            | Phone Type : ${spTel.selectedItem}
                          """.trimMargin("|")
                alert("Done", msg, this)

            } else {
                alert("Error", "Have Empty Infos", this)
            }
        }

    }
}