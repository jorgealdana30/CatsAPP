package com.jorgealdana.catsapp.blocs.viewmodels.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jorgealdana.catsapp.BuildConfig
import com.jorgealdana.catsapp.R
import com.jorgealdana.catsapp.databinding.ItemCatListBinding
import com.jorgealdana.catsapp.models.Cat

class CatListAdapter(private val context: Context, private val cats: List<Cat>) :
    RecyclerView.Adapter<CatListAdapter.ViewHolder>() {


    class ViewHolder(view: ItemCatListBinding) : RecyclerView.ViewHolder(view.root) {
        val breedName = view.breedName
        val origin = view.countryOrigin
        val intelligence = view.intelligence
        val image = view.catPhoto
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemCatListBinding.inflate(LayoutInflater.from(context), parent, false))

    override fun getItemCount(): Int = cats.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = cats[position]
        holder.breedName.text =
            String.format("%s %s", context.getString(R.string.breed_name), item.breedName)
        holder.origin.text =
            String.format("%s %s", context.getString(R.string.country_origin), item.origin)
        holder.intelligence.text =
            String.format("%s %s", context.getString(R.string.intelligence), item.intelligence.toString())

        Glide.with(context)
            .load(BuildConfig.BASE_IMAGE_URL + item.imageUrl + ".jpg")
            .override(800, 800).fitCenter().into(holder.image)
    }
}