package dev.eder.dogsmvvm.ui.characters.modelstructure

data class StarWarsCharactersResponse(
	val next: String? = null,
	val previous: Any? = null,
	val count: Int? = null,
	val results: List<StarWarsCharacter?>? = null
)
