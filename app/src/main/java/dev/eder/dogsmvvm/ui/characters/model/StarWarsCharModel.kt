package dev.eder.dogsmvvm.ui.characters.model

import dev.eder.dogsmvvm.client.Client
import dev.eder.dogsmvvm.client.ServiceGenerator
import dev.eder.dogsmvvm.ui.characters.modelstructure.StarWarsCharacter
import dev.eder.dogsmvvm.ui.characters.modelstructure.StarWarsCharactersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StarWarsCharModel {

    fun getCharactersFromApi(callback : (List<StarWarsCharacter>?,String?) -> Unit) {
        val service = ServiceGenerator.createService(Client::class.java)
        service.characters.enqueue(object : Callback<StarWarsCharactersResponse?> {
            override fun onFailure(call: Call<StarWarsCharactersResponse?>, t: Throwable) {
                callback.invoke(null,t.message.toString())
            }

            override fun onResponse(call: Call<StarWarsCharactersResponse?>, response: Response<StarWarsCharactersResponse?>) {
                val resultStarWars = response.body()?.results?.filterNotNull() ?: emptyList()
                callback.invoke(resultStarWars,null)
            }
        })

    }
}