package com.example.fruityvice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fruityvice.model.Fruit
import com.example.fruityvice.model.Nutritions
import com.example.fruityvice.ui.theme.Brown70
import com.example.fruityvice.ui.theme.FruityviceTheme
import com.example.fruityvice.ui.theme.Green70
import com.example.fruityvice.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var listFruits by remember { mutableStateOf(emptyList<Fruit>()) }

            LaunchedEffect(viewModel.listFruits) {
                viewModel.listFruits.observe(this@MainActivity) { fruits ->
                    listFruits = fruits
                }
            }
            FruityviceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Box(
                                        modifier = Modifier.fillMaxWidth(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = "Fruits",
                                            fontWeight = FontWeight.Bold,
                                            style = TextStyle(
                                                fontSize = 24.sp,
                                                shadow = Shadow(
                                                    color = Color.Black,
                                                    offset = Offset(5.0f, 10.0f),
                                                    blurRadius = 3f
                                                )
                                            ),
                                            fontFamily = FontFamily.Serif,
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                },
                                colors = TopAppBarDefaults.topAppBarColors(
                                    containerColor = Brown70, titleContentColor = Color.White
                                )
                            )
                        }
                    ) {
                        Box(modifier = Modifier.padding(it)) {
                            ListFruits(fruits = listFruits)
                        }
                    }
                }
            }
        }
        viewModel.getFruits()
    }
}


@Composable
fun ListFruits(fruits: List<Fruit>) {
    LazyColumn {
        items(fruits) { fruit ->
            FruitItem(fruit = fruit)
        }
    }
}

@Composable
fun FruitItem(fruit: Fruit) {
    var isExpanded by remember { mutableStateOf(false) }
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .clickable { isExpanded = !isExpanded }
            .padding(bottom = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.fruits),
                    contentDescription = "Fruit image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(16.dp)),
                )
                Spacer(modifier = Modifier.width(24.dp))
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 8.dp),
                    text = fruit.name,
                    fontWeight = FontWeight.W700
                )
            }

            if (isExpanded)
                Surface(color = Color.White,
                    modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)) {
                    Column(Modifier.fillMaxWidth()) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Informations",
                            color = Green70,
                            fontWeight = FontWeight.W500
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        FruitInfo("Family:", fruit.family)
                        FruitInfo("Genus:", fruit.genus)
                        FruitInfo("Order:", fruit.order)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "Nutritions", color = Green70,
                            fontWeight = FontWeight.W500
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        FruitInfo("Calories:", fruit.nutritions.calories.toString())
                        FruitInfo("Fat:", fruit.nutritions.fat.toString())
                        FruitInfo("Sugar:", fruit.nutritions.sugar.toString())
                        FruitInfo("Carbohydrates:", fruit.nutritions.carbohydrates.toString())
                        FruitInfo("Protein:", fruit.nutritions.protein.toString())
                    }
                }
        }
    }
}

@Composable
fun FruitInfo(title: String, content: String) {
    Row {
        Text(text = title, fontWeight = FontWeight.W500, color = Brown70)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = content)
    }
}

@Preview
@Composable
fun FruitItemPreview() {
    FruityviceTheme {
        FruitItem(
            fruit = Fruit(
                name = "Banana",
                id = 2,
                family = "Musaceae",
                genus = "Musa",
                order = "Zingiberales",
                nutritions = Nutritions(
                    calories = 96,
                    fat = 0.2F,
                    sugar = 17.2F,
                    carbohydrates = 22.0F,
                    protein = 0.0F
                )
            )
        )
    }
}