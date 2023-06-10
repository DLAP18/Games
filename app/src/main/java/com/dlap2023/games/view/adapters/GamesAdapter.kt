package com.dlap2023.games.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dlap2023.games.databinding.GameElementBinding
import com.dlap2023.games.model.Game

class GamesAdapter(private var context: Context, private var games: ArrayList<Game>, private val clickListener: (Game) -> Unit): RecyclerView.Adapter<GamesAdapter.ViewHolder>() {
    class ViewHolder(view: GameElementBinding): RecyclerView.ViewHolder(view.root){
        val ivThumbnail = view.ivThumbnail
        val tvTitle = view.tvTitle
        val tvDeveloper = view.tvDeveloper
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GameElementBinding.inflate(LayoutInflater.from(context))
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = games[position].title

        Glide.with(context)
            .load(games[position].thumbnail)
            .into(holder.ivThumbnail)

        //holder.tvDeveloper.text = "EA Sports"

        holder.itemView.setOnClickListener{
            //Para programar los eventos click al elemento completo del ViewHolder
            clickListener(games[position])
        }
    }
}