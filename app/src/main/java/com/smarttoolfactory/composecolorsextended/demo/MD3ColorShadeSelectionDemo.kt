package com.smarttoolfactory.composecolorsextended.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smarttoolfactory.composecolorsextended.ColorDisplay
import com.smarttoolfactory.composecolorsextended.ColorDisplayWithTitle
import com.smarttoolfactory.extendedcolors.ColorSwatch
import com.smarttoolfactory.extendedcolors.MaterialColor.Red500
import com.smarttoolfactory.extendedcolors.util.colorToHSL
import com.smarttoolfactory.extendedcolors.util.colorToHex
import com.smarttoolfactory.extendedcolors.util.getColorTonesList
import com.smarttoolfactory.extendedcolors.util.material3ToneRange

@Composable
fun MD3ColorShadeSelectionDemo(onColorChange: (Color) -> Unit) {
    M3ColorPicker(onColorChange = onColorChange)
}

@Composable
fun M3ColorPicker(onColorChange: (Color) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = .8f)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var colorSwatchIndex by remember { mutableStateOf(0) }
        var color by remember { mutableStateOf(Red500) }
        var md3Tones by remember { mutableStateOf(getColorTonesList(color)) }

        val colorSelectionIndex =
            remember { ColorSelectionIndex(mainSelection = 0, subSelection = 5) }

        val colorSwatch: LinkedHashMap<Int, Color> =
            remember(colorSwatchIndex) { ColorSwatch.primaryColorSwatches[colorSwatchIndex] }

        val keys: MutableList<Int> = colorSwatch.keys.toMutableList()
        val colors: MutableList<Color> = colorSwatch.values.toMutableList()


        LazyVerticalGrid(
            columns = GridCells.Fixed(6),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            itemsIndexed(ColorSwatch.primaryHeaderColors) { index: Int, item: Color ->
                ColorDisplay(
                    modifier = Modifier

                        .clip(RoundedCornerShape(8.dp))
                        .aspectRatio(1f)
                        .clickable {
                            color = item
                            onColorChange(item)
                            colorSwatchIndex = index
                            colorSelectionIndex.mainSelection = 0
                            colorSelectionIndex.subSelection = index
                            md3Tones = getColorTonesList(item)
                        }, color = item
                )
            }
        }

        Text(
            text = "Material Design2 Shade",
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(8),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            itemsIndexed(colors) { index: Int, item: Color ->
                ColorDisplayWithTitle(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .aspectRatio(1f)
                        .clickable {
                            color = item
                            colorSelectionIndex.mainSelection = 1
                            colorSelectionIndex.subSelection = index
                            onColorChange(item)
                            md3Tones = getColorTonesList(item)
                        },
                    selected = (colorSelectionIndex.mainSelection == 0 && index == 5)
                            || (colorSelectionIndex.mainSelection == 1
                            && colorSelectionIndex.subSelection == index),
                    color = item,
                    textColor = if (index < 5) Color.Black else Color.White,
                    title = keys[index].toString(),
                )
            }
        }

        Text(
            text = "Material Design3 Tonal Palette",
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(8),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            itemsIndexed(md3Tones) { index: Int, item: Color ->
                ColorDisplayWithTitle(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(8.dp))
                        .aspectRatio(1f)
                        .clickable {
                            colorSelectionIndex.mainSelection = 2
                            colorSelectionIndex.subSelection = index
                            color = item
                            onColorChange(item)
                        },
                    color = item,
                    selected = (colorSelectionIndex.mainSelection == 2
                            && colorSelectionIndex.subSelection == index),
                    textColor = if (index < 6) Color.White else Color.Black,
                    title = material3ToneRange[index].toString()
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
        val lightness = colorToHSL(color)[2]
        val textColor = if (lightness < .6f) Color.White else Color.Black
        Box(
            modifier = Modifier
                .padding(8.dp)
                .background(color = color, RoundedCornerShape(50))
                .padding(horizontal = 20.dp, vertical = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = colorToHex(color = color),
                fontSize = 24.sp,
                color = textColor
            )
        }

    }
}

data class ColorSelectionIndex(var mainSelection: Int = 0, var subSelection: Int = 0)