package br.senac.noteapp.business

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Note(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var title: String,
    var description: String,
    var user: String
)