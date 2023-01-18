package com.enaitzdam.examenuf1.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters



@Database(
    entities = [Alumne::class],
    version = 1,
    exportSchema = true
)

abstract class AlumneDatabase : RoomDatabase() {

    abstract fun alumneDao(): AlumneDao

    companion object {

        @Volatile
        private var INSTANCE: AlumneDatabase? = null

        fun getDatabase(context: Context): AlumneDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null) {
                synchronized(this) {
                    // Pass the database to the INSTANCE
                    INSTANCE = buildDatabase(context)
                }
            }
            // Return database.
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): AlumneDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AlumneDatabase::class.java,
                "alumnes_database"
            ).createFromAsset("database/alumnes_database.db")
                .build()
        }
    }
}