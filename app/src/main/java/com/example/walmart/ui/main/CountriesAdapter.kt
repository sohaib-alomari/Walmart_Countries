package com.example.walmart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.walmart.data.model.Countries

class CountriesAdapter(private val countries: List<Countries>) : RecyclerView.Adapter<CountriesAdapter.CountryViewHolder>() {

    class CountryViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val name: TextView = view.findViewById(R.id.name)
        private val region: TextView = view.findViewById(R.id.region)
        private val code: TextView = view.findViewById(R.id.code)
        private val capital: TextView = view.findViewById(R.id.capital)

        fun bind(countries: Countries) {
            name.text = countries.name + " , "
            region.text = countries.region
            code.text = countries.code
            capital.text = countries.capital
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountriesAdapter.CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_countries, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountriesAdapter.CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount() = countries.size
}