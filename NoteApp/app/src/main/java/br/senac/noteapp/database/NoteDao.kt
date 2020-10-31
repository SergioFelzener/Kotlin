package br.senac.noteapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.senac.noteapp.business.Note


@Dao
interface NoteDao {


    @Insert
    fun insert(note: Note)

    @Query(value = "select * from Note")
    fun getNotes(): List<Note>

}