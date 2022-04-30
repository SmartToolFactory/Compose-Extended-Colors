package com.smarttoolfactory.composecolorsextended

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
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
import com.smarttoolfactory.composecolorsextended.demo.ColorModelConversionDemo
import com.smarttoolfactory.composecolorsextended.demo.GradientAngleDemo
import com.smarttoolfactory.composecolorsextended.demo.M2ColorSelectionDemo
import com.smarttoolfactory.composecolorsextended.demo.M3ColorShadeSelectionDemo
import com.smarttoolfactory.composecolorsextended.ui.theme.ComposeColorsExtendedTheme
import com.smarttoolfactory.extendedcolors.util.colorToHSL
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeColorsExtendedTheme {

                Modifier.offset()
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
    val systemUiController = rememberSystemUiController()

    val pagerState: PagerState = rememberPagerState(initialPage = 0)
    var backgroundColor by remember { mutableStateOf(Color(0xffF44336)) }
    val lightness = colorToHSL(backgroundColor)[2]
    val contentColor = if (lightness < .6f) Color.White else Color.Black

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
            0 -> M2ColorSelectionDemo {
                backgroundColor = it
            }
            1 -> M3ColorShadeSelectionDemo {
                backgroundColor = it
            }
            2 -> GradientAngleDemo()
            else -> ColorModelConversionDemo()
        }
    }
}

internal val tabList =
    listOf(
        "Material Design2",
        "Material You/3",
        "Gradient Angles",
        "Model Conversion",
    )