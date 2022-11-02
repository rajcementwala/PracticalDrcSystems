package com.example.practicaldrcsystems.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy


@Dao
abstract class AtmDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract  fun  withdrawAmout(model: WithdrawalModel):Long

}