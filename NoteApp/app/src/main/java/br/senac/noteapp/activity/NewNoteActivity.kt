package br.senac.noteapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senac.noteapp.R
import br.senac.noteapp.business.Note
import br.senac.noteapp.business.NotesSingleton
import kotlinx.android.synthetic.main.activity_new_note.*


class NewNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)

        btnSend.setOnClickListener {
            val note = Note(etTitle.text.toString(), etDesc.text.toString())
            NotesSingleton.listNotes.add(note)
            finish()
        }
    }
}