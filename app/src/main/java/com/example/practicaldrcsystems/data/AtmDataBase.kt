package com.example.practicaldrcsystems.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [WithdrawalModel::class], version = 1, exportSchema = false)
 abstract class AtmDataBase :RoomDatabase(){

    companion object{

     private var DBINSTANCE:AtmDataBase?=null

        fun getDb(context: Context):AtmDataBase{

            if (DBINSTANCE==null){

               synchronized(this){
                   DBINSTANCE= build(context)
               }
            }

            return DBINSTANCE!!
        }

        private fun build(context: Context):AtmDataBase{

            return Room.databaseBuilder(context.applicationContext,AtmDataBase::class.java,"atm_db").allowMainThreadQueries().build()
        }


    }


    abstract  fun atmDao():AtmDao
}