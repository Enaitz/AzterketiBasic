package com.enaitzdam.examenuf1.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alumnes")
data class Alumne (
    @PrimaryKey
    @ColumnInfo(name="Nom")
    val nom:String,
    @ColumnInfo(name="Edat")
    val edat:Int,
    @ColumnInfo(name="Adreca")
    val adreca: String,
    @ColumnInfo(name="Historial")
    val historial: String
    )

