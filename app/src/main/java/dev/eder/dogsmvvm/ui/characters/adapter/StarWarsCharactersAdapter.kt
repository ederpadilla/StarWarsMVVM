package dev.eder.dogsmvvm.ui.characters.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import dev.eder.dogsmvvm.R
import dev.eder.dogsmvvm.ui.characters.viewstate.StarWarsCharacterViewState

class StarWarsCharactersAdapter : ListAdapter<StarWarsCharacterViewState, StarWarsCharactersAdapter.CharacterHolder>(DIFF_CALLBACK) {

    private var listener: OnCharacterClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_item, parent, false)
        return CharacterHolder(itemView)
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        val character = getItem(position)
        holder.mTvName.text = character.name
    }


    inner class CharacterHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        val mTvName: TextView
        val mTvMovies : TextView

        init {
            mTvName = itemView.findViewById(R.id.mTvName)
            mTvMovies = itemView.findViewById(R.id.mTvMovies)

            itemView.setOnClickListener {
                val position = adapterPosition
                if (listener != null && position != androidx.recyclerview.widget.RecyclerView.NO_POSITION) {
                    listener!!.onCharacterClick(getItem(position))
                }
            }
        }
    }

    interface OnCharacterClickListener {
        fun onCharacterClick(note: StarWarsCharacterViewState)
    }

    fun setOnItemClickListener(listener: OnCharacterClickListener) {
        this.listener = listener
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<StarWarsCharacterViewState>() {

            override fun areItemsTheSame(oldItem: StarWarsCharacterViewState, newItem: StarWarsCharacterViewState) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: StarWarsCharacterViewState, newItem: StarWarsCharacterViewState) =
                oldItem== newItem

        }

    }

}