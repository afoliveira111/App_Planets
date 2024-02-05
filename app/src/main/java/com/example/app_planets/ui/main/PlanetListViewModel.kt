package com.example.app_planets.ui.main

import androidx.lifecycle.ViewModel

class PlanetListViewModel : ViewModel() {

    fun loadData(): State {
        return State.Content(
            listOf(
                PlanetData("Terra", "Descricao Terra"),
                PlanetData("Jupiter", "Descricao Jupiter"),
                PlanetData("Mercúrio", "Descricao Mercúrio")
            )
        )
    }
}

sealed class State {
    data class Content(val list: List<PlanetData>) : State()
    object Loading : State()

    object Error : State()
}