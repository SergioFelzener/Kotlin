package br.senac.noteapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.preference.PreferenceManager
import androidx.room.Room
import br.senac.noteapp.R
import br.senac.noteapp.business.Note
import br.senac.noteapp.business.NotesSingleton
import br.senac.noteapp.database.AppDatabase
import kotlinx.android.synthetic.main.activity_list_note.*
import kotlinx.android.synthetic.main.note_card.view.*

class ListNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //mudando thema e ativando cores do tema
        setTheme(R.style.AppTheme)

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

    fun refreshNotes(){

        Thread {
            val database = Room.databaseBuilder(this, AppDatabase::class.java, "AppDb").build()
            val notes = database.noteDao().getNotes()
            runOnUiThread {
                refreshInterface(notes)
            }
        }.start()

    }

    fun refreshInterface(notes: List<Note>) {
        containerFab.removeAllViews()

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val color = prefs.getInt("noteColor", R.color.colorNotesDefault)


        for (note in notes) {
            val card = layoutInflater.inflate(R.layout.note_card, containerFab, false)

            card.txtTitle.text = note.title
            card.txtDesc.text = note.description
            card.txtUser.text = note.user

            card.setBackgroundColor(color)

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
        } else if (item.itemId == R.id.config){
            val intent = Intent(this, ConfigActivity::class.java)
            startActivity(intent)
        }


        return super.onOptionsItemSelected(item)
    }
}