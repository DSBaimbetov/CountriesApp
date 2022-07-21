package com.example.mvvmexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.mvvmexample.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_welcome, container, false)

        binding.startB.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_welcomeFragment2_to_mainFragment
            )
        )

        return binding.root
    }
}