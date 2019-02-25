package dev.eder.dogsmvvm.ui.characters.modelstructure

data class StarWarsCharacter(
	val films: List<String?>? = null,
	val homeworld: String? = null,
	val gender: String? = null,
	val skinColor: String? = null,
	val edited: String? = null,
	val created: String? = null,
	val mass: String? = null,
	val vehicles: List<String?>? = null,
	val url: String? = null,
	val hairColor: String? = null,
	val birthYear: String? = null,
	val eyeColor: String? = null,
	val species: List<String?>? = null,
	val starships: List<String?>? = null,
	val name: String? = null,
	val height: String? = null
)
