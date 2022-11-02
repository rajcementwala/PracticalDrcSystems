package com.example.practicaldrcsystems.viewmodles

import android.app.Application
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practicaldrcsystems.data.AtmDataBase
import com.example.practicaldrcsystems.data.NoteModel
import com.example.practicaldrcsystems.data.WithdrawalModel

class TransactionViewModel(application: Application): AndroidViewModel(application) {

    var atmAmount =MutableLiveData(24550)

    private val notesList = mutableListOf<NoteModel>()
    var amountTOWithdraw=MutableLiveData<String>("")
    var availableNotes=MutableLiveData<String>()

    lateinit var db:AtmDataBase



    init {

        notesList.add(NoteModel(2000,5))
        notesList.add(NoteModel(500,7))
        notesList.add(NoteModel(200,15))
        notesList.add(NoteModel(50,35))
        notesList.add(NoteModel(20,315))
        availableNotes.value=recountNotes().toString();
    }

    fun withdrawAmount(){



        if (validateTransaction()){
            val notes=getNotes(amountTOWithdraw.value!!.toInt())
            if (notes==0){
                var a=StringBuffer()
                a.append("Please enter amount in mutiple of")


                notesList.forEach {

                    if (it.avalableNote>0){
                        a.append( " ${it.amount}")

                    }
                }
                Toast.makeText(getApplication(),a.toString(),Toast.LENGTH_LONG).show()
                return
            }

            val modle:WithdrawalModel=WithdrawalModel(amount = amountTOWithdraw.value!!.toInt(), notesCount = notes)
            db.atmDao().withdrawAmout(modle)
            atmAmount.value= atmAmount.value!!-amountTOWithdraw.value!!.toInt()

            amountTOWithdraw.value=""

            availableNotes.value=(availableNotes.value!!.toInt()-notes).toString()



            Log.e("asas",amountTOWithdraw.value!!)

        }

    }

    fun recountNotes():Int{
        var  c=0
        notesList.forEach {

            c+=it.avalableNote
        }
        return c

    }


    fun getNotes(amount:Int):Int{




        var notesCount=0
        var amount1=amount

        for (note in notesList){
         //   notesCount += (amount / note.amount)

             var isAvailable =true
            if (note.amount<=amount1){
                while (isAvailable){
                    amount1-=note.amount
                    notesCount++
                    note.avalableNote--

                    if (amount1<note.amount||note.avalableNote<1){
                        isAvailable=false
                    }

                }
            }




            if (amount1 == 0)
                break
        }
        if (amount1!=0)
            return 0

        Log.e("notes count","$notesCount")
        return notesCount



    }



    fun validateTransaction():Boolean{


        if (amountTOWithdraw.value!!.isNullOrEmpty()) {

            showaleret("Please enter amount")

            return false
        } else {
            val withdrawalAmount = amountTOWithdraw.value!!.toInt()
            if (withdrawalAmount > amountTOWithdraw.value!!.toInt() || withdrawalAmount <= 0) {
                showaleret("Insufficient balance")
                return false
            } else if (withdrawalAmount % 10 != 0) {
                showaleret("Please enter valid amount")
                return false
            }
            return true
        }
    }

    fun showaleret(msg:String){

        Toast.makeText(getApplication(),msg,Toast.LENGTH_SHORT).show()
    }


}