package com.example.lab.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.InputChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewDynamicColors

@Composable
fun LogIn() {
    Column() {
        InputChip(selected = true, onClick = { /*TODO*/ }, label = { /*TODO*/ })
        Text(text = "logihvn")
    }
}

@Composable
@PreviewDynamicColors
fun LogInPreview() {
    LogIn()
}