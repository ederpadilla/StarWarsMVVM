package dev.eder.dogsmvvm.ui.characters.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.eder.dogsmvvm.ui.characters.model.StarWarsCharModel
import dev.eder.dogsmvvm.ui.characters.modelstructure.StarWarsCharacter
import dev.eder.dogsmvvm.ui.characters.viewstate.StarWarsCharacterViewState

class StarWarsCharsViewModel(model : StarWarsCharModel) : ViewModel() {

    val allChars =  MutableLiveData<List<StarWarsCharacterViewState>>()

    var error = ""

    init {
        /*model.getCharactersFromApi({ list: List<StarWarsCharacter> ->
            allChars.postValue(list.map {
                it.toViewState()
            })
        })*/
        model.getCharactersFromApi { list: List<StarWarsCharacter>?, s: String? ->
            if (s!=null){
                error = s
            }else{
            allChars.postValue(list?.map {
                it.toViewState()
            })
            }
        }
    }


    private fun StarWarsCharacter.toViewState(): StarWarsCharacterViewState {
        return StarWarsCharacterViewState(id = "${this.name}${this.created}",name = "${this.name}",films = "${this.films}" )
    }


    companion object {
        fun log(message : String){
            Log.e(StarWarsCharsViewModel::class.java.simpleName,message)
        }
    }
}



