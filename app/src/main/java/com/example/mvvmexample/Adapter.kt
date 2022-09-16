package com.example.mvvmexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mvvmexample.Network.Model

class Adapter : RecyclerView.Adapter<RecyclerViewHolder>() {

    private var countries = mutableListOf<Model>()

    fun setCountryList(countries: List<Model>) {
        this.countries = countries.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_country,
            parent, false
        )

        return RecyclerViewHolder(view)
    }

    // Вызывается RecyclerView для отображения данных в указанной позиции.
    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val country = countries[position]

        holder.apply {
            countryName.text = country.name
            capitalName.text = country.capital
            imageView.load(country.img)
        }

        holder.countries = country
    }

    override fun getItemCount() = countries.size
}

class RecyclerViewHolder(itemView: View, var countries: Model? = null) :
    RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.findViewById(R.id.imageview)
    val countryName: TextView = itemView.findViewById(R.id.countryName)
    val capitalName: TextView = itemView.findViewById(R.id.capitalName)

    init {
        itemView.setOnClickListener {
            countries?.let { countries ->
                val directions =
                    MainFragmentDirections.actionMainFragmentToCountryFragment(countries)
                itemView.findNavController().navigate(directions)
            }
        }
    }
}