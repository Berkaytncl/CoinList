package com.berkaytuncel.coinlist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.berkaytuncel.coinlist.R
import com.berkaytuncel.coinlist.adapter.CoinRecyclerAdapter
import com.berkaytuncel.coinlist.databinding.ActivityMainBinding
import com.berkaytuncel.coinlist.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var coinAdapter: CoinRecyclerAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.state.observe(this) {
            if (!it.isLoading) {
                binding.progressBar.visibility = View.GONE
                if (it.error.isNotBlank()) {
                    binding.errorText.text = it.error
                    binding.errorText.visibility = View.VISIBLE
                } else {
                    binding.recyclerView.visibility = View.VISIBLE
                    coinAdapter = CoinRecyclerAdapter(it.coins)
                    binding.recyclerView.adapter = coinAdapter
                }
            }
        }
    }
}