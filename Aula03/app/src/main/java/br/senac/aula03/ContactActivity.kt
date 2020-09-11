package br.senac.aula03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_contact.*

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        btnFinish.setOnClickListener() {
            var msg = """ 
                        | Nome : ${etNameContact.text}
                        | E-mail : ${etEmailContact.text}
                        | Phone : ${etTelContact.text}
                        | 
                        | Contact Prefer :
                      """.trimMargin("|")

            if (cbPrefEmail.isChecked) {
                msg += "\n E-mail"
            }

            if (cbPrefTel.isChecked) {
                msg += "\n Phone"
            }

            alert("Result", msg, this)

        }

    }
}