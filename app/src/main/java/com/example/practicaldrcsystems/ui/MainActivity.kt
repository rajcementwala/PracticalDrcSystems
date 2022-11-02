package com.example.practicaldrcsystems.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import com.example.practicaldrcsystems.R
import com.example.practicaldrcsystems.data.AtmDataBase
import com.example.practicaldrcsystems.databinding.ActivityMainBinding
import com.example.practicaldrcsystems.viewmodles.TransactionViewModel

class MainActivity : AppCompatActivity() {
    lateinit var db:AtmDataBase
    lateinit var vm:TransactionViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        db= AtmDataBase.getDb(this)
        binding.lifecycleOwner=this
        vm=ViewModelProvider(this).get(TransactionViewModel::class.java)
        vm.db=db
        binding.viewModel=vm

    }
}