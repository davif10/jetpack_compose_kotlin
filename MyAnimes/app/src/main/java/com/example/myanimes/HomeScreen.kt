package com.example.myanimes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(modifier: Modifier = Modifier){
    Column(
        modifier.verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.characters) {
            CharacterRow(charactersData = DataSource().listCharacters(), Modifier.padding(horizontal = 8.dp))
        }
        HomeSection(title = R.string.animes_world) {
            WorldAnime(worldData = DataSource().listWorld())
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

