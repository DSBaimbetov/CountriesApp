package com.example.mvvmexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.example.mvvmexample.databinding.MainDialogBinding

abstract class BaseDialogFragment : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = DataBindingUtil.inflate<MainDialogBinding>(
        layoutInflater,
        R.layout.main_dialog,
        null,
        false
    ).run {
        requireDialog().window?.setBackgroundDrawableResource(android.R.color.transparent)
        buildView()
        root
    }

    abstract fun MainDialogBinding.buildView()
}