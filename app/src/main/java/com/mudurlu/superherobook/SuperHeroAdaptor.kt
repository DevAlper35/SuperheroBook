package com.mudurlu.superherobook

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mudurlu.superherobook.databinding.RecyclerRowBinding

class SuperHeroAdaptor(val superHeroListesi: ArrayList<SuperHero>) : RecyclerView.Adapter<SuperHeroAdaptor.SuperHeroViewHolder>() {

    class SuperHeroViewHolder (val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SuperHeroViewHolder(binding)
    }

    override fun getItemCount(): Int {
        // kaç item olacak
        return superHeroListesi.size
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, pos: Int) {
        holder.binding.textViewRecycler.text = superHeroListesi[pos].kahraman

        holder.itemView.setOnClickListener {
            val veri = Intent(holder.itemView.context, TanitimActivity:: class.java)
            veri.putExtra("veri",superHeroListesi[pos])
            holder.itemView.context.startActivity(veri)
        }
    }
}