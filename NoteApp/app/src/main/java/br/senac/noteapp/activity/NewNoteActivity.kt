package br.senac.noteapp.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import br.senac.noteapp.R
import br.senac.noteapp.business.Note
import br.senac.noteapp.business.NotesSingleton
import br.senac.noteapp.database.AppDatabase
import kotlinx.android.synthetic.main.activity_new_note.*
import kotlinx.android.synthetic.main.activity_user.*


class NewNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)

        val sharedPrefs = getSharedPreferences("User", Context.MODE_PRIVATE)

        btnSend.setOnClickListener {

            val username = sharedPrefs.getString("username", "")

            username?.let {
                val note = Note(title = etTitle.text.toString(), description = etDesc.text.toString(), user = it)

                // nao vai ser mais singleton vamos inserir na DB
                // NotesSingleton.listNotes.add(note)
                Thread {
                    insertNote(note)
                    finish()
                }.start()

            }
        }

    }

    fun insertNote(note: Note) {

        val database = Room.databaseBuilder(this, AppDatabase::class.java, "AppDb").build()

        database.noteDao().insert(note)
    }
}