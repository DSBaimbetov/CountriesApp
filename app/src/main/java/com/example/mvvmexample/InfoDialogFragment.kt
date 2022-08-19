package com.example.mvvmexample

import androidx.navigation.fragment.navArgs
import com.example.mvvmexample.databinding.MainDialogBinding

class InfoDialogFragment: BaseDialogFragment() {
    private val arguments by navArgs<InfoDialogFragmentArgs>()

    override fun MainDialogBinding.buildView() {
        viewArgs = arguments.dialogParams

    }
}