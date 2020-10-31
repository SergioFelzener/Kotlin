package br.senac.noteapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.senac.noteapp.business.Note

@Database(entities = arrayOf(Note::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun noteDao (): NoteDao
}