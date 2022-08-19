package com.example.mvvmexample

import android.content.Context
import android.view.View
import androidx.navigation.NavController
import com.example.mvvmexample.MainFragmentDirections.Companion.actionMainFragmentToInfoDialogFragment

class MainFragmentBindingAdapter(
    private val navController: NavController,
    private val context: Context
) {

    fun click(view: View) = navController.navigate(context.run {
        when (view.id) {
            R.id.info_about_country -> actionMainFragmentToInfoDialogFragment(
                DialogDto(
                    textToInfo = R.string.info,
                    text = R.string.lorem
                )
            )
            else -> actionMainFragmentToInfoDialogFragment(
                DialogDto(
                    textToInfo = R.string.null_string,
                    text = R.string.null_string
                )
            )
        }
    }
    )
}