package com.example.paginglocal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paginglocal.databinding.ActivityMainBinding
import com.example.paginglocal.ui.MainListAdapter
import com.example.paginglocal.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = this.javaClass.name + " mori"
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: MainListAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupViewModel()
        setupListAdapter()
        observeViewModel()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)
    }

    private fun setupListAdapter() {
        listAdapter = MainListAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = listAdapter
        }
    }

    private fun observeViewModel() {
        viewModel.cardPagedList?.observe(this, {
            Log.d(TAG, "LiveData changed!")
            listAdapter.submitList(it)
        })
    }
}