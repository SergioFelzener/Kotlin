package br.senac.noteapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senac.noteapp.R

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
    }
}