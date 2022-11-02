package com.example.practicaldrcsystems.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "withdrawalTable")
 data class WithdrawalModel (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "transaction_id")
    val transactionId:Int=0 ,

    @ColumnInfo(name = "transaction_amount")
    val amount:Int ,

    @ColumnInfo(name = "transaction_note_count")
    val notesCount:Int

)