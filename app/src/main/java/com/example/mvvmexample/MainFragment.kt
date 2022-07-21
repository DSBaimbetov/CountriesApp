package com.example.mvvmexample

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmexample.Network.MainRepository
import com.example.mvvmexample.Network.RetrofitService
import com.example.mvvmexample.databinding.FragmentMainBinding
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val retrofitService = RetrofitService.getInstance()

        viewModel = ViewModelProvider(this,
            MyViewModelFactory(
                MainRepository(retrofitService)))[
                MainViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_main, container, false)

        val adapter = Adapter()
        binding.recyclerview.adapter = adapter

        viewModel.countryList.observe(viewLifecycleOwner) {
            adapter.setCountryList(it)
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {

            val snackbar = Snackbar.make(
                requireView(),
                "Не удалось получить данные или не подключен интернет",
                Snackbar.LENGTH_LONG
            )
            snackbar.setBackgroundTint(Color.BLUE)
            snackbar.show()
        }
        viewModel.getAllCountries()

        // Inflate the layout for this fragment
        return binding.root
    }
}