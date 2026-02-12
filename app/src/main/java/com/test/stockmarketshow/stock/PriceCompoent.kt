package com.test.stockmarketshow.stock

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun PriceText(price: Double) {

    val animated by animateFloatAsState(
        targetValue = price.toFloat(),
        animationSpec = tween(500)
    )

    Text(
        text = String.format("%.2f", animated),
        color = Color.Green,
        fontWeight = FontWeight.Bold
    )
}
