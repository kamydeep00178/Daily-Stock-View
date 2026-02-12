package com.test.stockmarketshow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.test.stockmarketshow.data.StockViewModel
import com.test.stockmarketshow.stock.StockScreen
import com.test.stockmarketshow.ui.theme.StockMarketShowTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StockMarketShowTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding -> // obtain ViewModel inside Compose using hiltViewModel()
                    val viewModel: StockViewModel = hiltViewModel()
                    StockScreen(modifier = Modifier.padding(innerPadding), viewModel = viewModel)
                }
            }
        }
    }
}
