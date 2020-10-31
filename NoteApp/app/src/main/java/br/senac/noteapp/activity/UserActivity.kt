package br.senac.noteapp.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senac.noteapp.R
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val sharedPrefs = getSharedPreferences("User", Context.MODE_PRIVATE)
        etUser.setText(sharedPrefs.getString("username", ""))

        btnSave.setOnClickListener{

            val editor = sharedPrefs.edit()

            editor.putString("username", etUser.text.toString())
            editor.commit()

        }
    }
}