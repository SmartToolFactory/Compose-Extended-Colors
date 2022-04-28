package com.smarttoolfactory.composecolorsextended

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.smarttoolfactory.composecolorsextended.demo.MaterialColorSelectionDemo
import com.smarttoolfactory.composecolorsextended.demo.PrimaryColorSelectionDemo
import com.smarttoolfactory.composecolorsextended.ui.theme.ComposeColorsExtendedTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeColorsExtendedTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        HomeContent()
                    }
                }
            }
        }
    }
}

@ExperimentalPagerApi
@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun HomeContent() {

    val pagerState: PagerState = rememberPagerState(initialPage = 0)
    var backgroundColor by remember { mutableStateOf(Color(0xff03a9f4)) }
    var contentColor by remember { mutableStateOf(Color.White) }

    val systemUiController = rememberSystemUiController()

    systemUiController.setStatusBarColor(
        color = backgroundColor
    )

    val coroutineScope = rememberCoroutineScope()

    ScrollableTabRow(
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        edgePadding = 8.dp,
        // Our selected tab is our current page
        selectedTabIndex = pagerState.currentPage,
        // Override the indicator, using the provided pagerTabIndicatorOffset modifier
        indicator = {}
    ) {
        // Add tabs for all of our pages
        tabList.forEachIndexed { index, title ->
            Tab(
                text = { Text(title) },
                selected = pagerState.currentPage == index,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }

    HorizontalPager(
        state = pagerState,
        count = tabList.size
    ) { page: Int ->

        when (page) {
            0 -> PrimaryColorSelectionDemo {
                backgroundColor = it
            }
            else -> MaterialColorSelectionDemo {
                backgroundColor = it
            }
        }
    }
}

internal val tabList =
    listOf(
        "MD2 Primary Colors",
        "MD2 Material Colors",
        "MD3 Shades",
        "Color Names",
        "Gradient Angles",
        "Color Conversions",
    )