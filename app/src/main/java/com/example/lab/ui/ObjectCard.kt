package com.example.lab.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import kotlin.random.Random

@Composable
fun ObjectCard(
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(),
        shape = MaterialTheme.shapes.large
    ) {
        Image(
           painter =  rememberAsyncImagePainter(
               model = "https://source.unsplash.com/random/300x200/?img=1"
           ),
           contentDescription = null,
           modifier = Modifier
               .clip(MaterialTheme.shapes.large)
               .fillMaxWidth()
               .aspectRatio(3f / 2f)
        )
        Column(
            Modifier.padding(16.dp)
        ){
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@PreviewDynamicColors
@Composable
fun ObjectCardPreview(){
    ObjectCard(title = "asd", description = "bhgjh")
}