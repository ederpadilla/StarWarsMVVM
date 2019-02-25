package dev.eder.dogsmvvm.ui.characters.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import dev.eder.dogsmvvm.R
import dev.eder.dogsmvvm.ui.characters.adapter.StarWarsCharactersAdapter
import dev.eder.dogsmvvm.ui.characters.model.StarWarsCharModel
import dev.eder.dogsmvvm.ui.characters.viewmodel.StarWarsCharsViewModel
import dev.eder.dogsmvvm.ui.characters.viewstate.StarWarsCharacterViewState
import kotlinx.android.synthetic.main.activity_starwars_chars.*

class StarWarsCharactersActivity : AppCompatActivity() {

    private val adapter = StarWarsCharactersAdapter()

    private lateinit var starWarsViewModel: StarWarsCharsViewModel

    val starWarsModel = StarWarsCharModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starwars_chars)
        setUpRecyclerView(mStarWarsCharsRecycler)
        starWarsViewModel = ViewModelProviders.of(this, mainViewModelfactory).get(StarWarsCharsViewModel::class.java)
        starWarsViewModel.allChars.observe(this, Observer {
            if (it != null) {
                StarWarsCharsViewModel.log("it != null")
                adapter.submitList(it)
            } else {

                StarWarsCharsViewModel.log("3lse")
                println("Error ${starWarsViewModel.error}")
            }
        })
    }

    private val mainViewModelfactory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return StarWarsCharsViewModel(starWarsModel) as T
        }
    }

    private fun setUpRecyclerView(recyclerView : RecyclerView) {
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(characterClickListener)
    }

    val characterClickListener = object : StarWarsCharactersAdapter.OnCharacterClickListener {
        override fun onCharacterClick(note: StarWarsCharacterViewState) {

        }
    }
}
