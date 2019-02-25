package dev.eder.dogsmvvm.client;

import dev.eder.dogsmvvm.ui.characters.modelstructure.StarWarsCharactersResponse;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Client {

    @GET(ClientEndPoints.getCharacters)
    Call<StarWarsCharactersResponse> getCharacters();

}
