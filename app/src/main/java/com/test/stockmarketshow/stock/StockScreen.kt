package com.test.stockmarketshow.stock

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.test.stockmarketshow.data.Stock
import com.test.stockmarketshow.data.StockViewModel

@Composable
fun StockScreen( modifier: Modifier = Modifier,viewModel: StockViewModel) {

    val stocks by viewModel.stocks.collectAsState()

    LazyColumn(modifier = modifier.fillMaxSize()) {
        stickyHeader {
            Text(
                text = "Stock Market",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp),
                fontWeight = FontWeight.Bold
            )
        }
        items(
            items = stocks,
            key = { it.id }      // MOST IMPORTANT for diffing
        ) { stock ->

            StockItem(stock)
        }
    }
}

@Composable
fun StockItem(stock: Stock) {

    val price = rememberUpdatedState(stock.price)

    Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {

        Text(text = stock.name, modifier = Modifier.padding(end = 8.dp))
        PriceText(price.value)

    }
}

