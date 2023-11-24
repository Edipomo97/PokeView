package com.example.pokeview.ui.theme.listas


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pokeview.ui.theme.PokeViewTheme


class PokemonListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeViewTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PokemonList()
                }
            }
        }
    }
}

@Composable
fun PokemonList() {

    val viewModel = PokemonListViewModel()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Lista de Pokemones")
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding)
        ) {
            items(viewModel.pokemonList) { pokemon ->
                PokemonCell(pokemon)
            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun PokemonListDefaultPreview() {
    PokeViewTheme {
        PokemonList()
    }
}