package com.example.composecalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecalculator.ui.theme.Green

@Composable
fun ResultsButton(
    symbol: String,
    modifier: Modifier,
    textStyle: TextStyle = TextStyle(),
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp))
            .clickable {
                onClick()
            }
            .then(modifier)
            .background(Green)
    ){
        Text(
            text = symbol,
            style = textStyle,
            fontSize = 20.sp,
            color = Color.White
        )
    }
}