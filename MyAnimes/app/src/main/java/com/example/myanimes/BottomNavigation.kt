package com.example.myanimes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun BottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        contentColor = MaterialTheme.colorScheme.background,
        modifier = modifier) {
        NavigationBarItem(
            icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = null)
            },
            label = {
                Text(stringResource(id = R.string.home))
            },
            selected = true,
            onClick = {})
        NavigationBarItem(
            icon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = null)
            },
            label = {
                Text(stringResource(id = R.string.profile))
            },
            selected = false,
            onClick = {})
    }
}