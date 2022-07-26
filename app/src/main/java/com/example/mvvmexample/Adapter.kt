package com.example.mvvmexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexample.Network.Model
import com.squareup.picasso.Picasso

class Adapter: RecyclerView.Adapter<RecyclerViewHolder>() {

    private var countries = mutableListOf<Model>()

    fun setCountryList(countries: List<Model>) {
        this.countries = countries.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view: View
            = LayoutInflater.from(parent.context).inflate(R.layout.adapter_country,
                parent, false)

        return RecyclerViewHolder(view)
    }

    // Вызывается RecyclerView для отображения данных в указанной позиции.
    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val country = countries[position]
        holder.countryName.text = country.name
        holder.capitalName.text = country.capital

        Picasso
            .get()
            .load(country.img)
            .into(holder.imageView)

        when(countries[position]){
            countries[0] -> holder.itemView.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_spainFragment)
            )
            countries[1] -> holder.itemView.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_portugalFragment)
            )
            countries[2] -> holder.itemView.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_russiaFragment)
            )
        }
    }

    override fun getItemCount() = countries.size
}

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.findViewById(R.id.imageview)
    val countryName: TextView =  itemView.findViewById(R.id.countryName)
    val capitalName: TextView = itemView.findViewById(R.id.capitalName)
}