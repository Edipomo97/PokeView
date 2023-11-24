package com.example.pokeview.ui.theme.listas

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pokeview.data.PokemonAPI
import com.example.pokeview.model.Pokemon




class PokemonListViewModel: ViewModel() {

    var pokemonList: List<Pokemon> by mutableStateOf(listOf())

    init {
        loadData()
    }

    private fun loadData() {

        PokemonAPI.loadPokemon({ pokemon ->
            pokemonList = pokemon
        }, {
            println("Error")
        })
    }

}