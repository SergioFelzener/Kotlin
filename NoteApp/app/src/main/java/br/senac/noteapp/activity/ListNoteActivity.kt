package br.senac.noteapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.senac.noteapp.R
import br.senac.noteapp.business.NotesSingleton
import kotlinx.android.synthetic.main.activity_list_note.*
import kotlinx.android.synthetic.main.note_card.view.*

class ListNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_note)

        fab.setOnClickListener{
            val intent = Intent(this, NewNoteActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        refreshNotes()
    }

    fun refreshNotes() {
        containerFab.removeAllViews()

        for (note in NotesSingleton.listNotes) {
            val card = layoutInflater.inflate(R.layout.note_card, containerFab, false)

            card.txtTitle.text = note.title
            card.txtDesc.text = note.description

            card.setOnClickListener{
                Toast.makeText(this, note.title, Toast.LENGTH_LONG).show()
            }

            containerFab.addView(card)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.user_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.user){
            val intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
        }


        return super.onOptionsItemSelected(item)
    }
}