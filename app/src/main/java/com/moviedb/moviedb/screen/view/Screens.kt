package com.moviedb.moviedb.screen.view

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.moviedb.moviedb.screen.viewmodel.MovieViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MovieListScreen(navController: NavController, movieViewModel: MovieViewModel) {
    val movies = movieViewModel.movies.value

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Movies",
                    maxLines = 1,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        )
    }) {

    }

    Column(modifier = Modifier.padding(16.dp)) {
        movies.forEach { movie ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable {
                        navController.navigate("details/${movie.id}")
                    }
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = movie.title, style = MaterialTheme.typography.bodyLarge)
                    Card {
                        Text(text = movie.genre, style = MaterialTheme.typography.labelSmall)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MovieDetailScreen(Id: Int, movieViewModel: MovieViewModel) {
    val item = movieViewModel.movies.value.firstOrNull { it.id == Id }

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Details",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        )
    }) {
        item?.let {
            Column(modifier = Modifier.padding(16.dp)) {
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = it.title, style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = it.genre, style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = it.description,
                    style = MaterialTheme.typography.bodyLarge,
                    overflow = TextOverflow.Ellipsis
                )
            }
        } ?: run {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Item not found", textAlign = TextAlign.Center)
            }

        }
    }
}