package com.example.mvvmexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.mvvmexample.Network.Model
import com.example.mvvmexample.databinding.FragmentCountryBinding

class CountryFragment : Fragment() {
    private lateinit var binding: FragmentCountryBinding
    private val args: CountryFragmentArgs by navArgs()
    private lateinit var country: Model

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCountryBinding.inflate(inflater, container, false)

        country = args.model

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.countryText.text = country.name
        binding.countryFlag.load(country.img)
    }
}