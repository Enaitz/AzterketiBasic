package com.enaitzdam.examenuf1.model

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface AlumneDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAlumne(alumne: Alumne):Long

    @Query("SELECT * FROM Alumnes ORDER BY Nom DESC")
    fun getAlumnes(): Flow<List<Alumne>>

    @Query("SELECT * FROM Alumnes WHERE Nom = :nom")
    fun getAlumneNom(nom: String): Flow<List<Alumne>>

    @Update
    fun updateAlumne(alumne: Alumne):Int

    @Delete
    fun deleteAlumne(alumne: Alumne):Int
}