package com.smarttoolfactory.composecolorsextended

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smarttoolfactory.extendedcolors.ColorSwatch
import com.smarttoolfactory.extendedcolors.util.colorToHex

@Composable
fun MaterialColorPicker(onColorChange: (Color) -> Unit) {

    var headerIndex by remember { mutableStateOf(0) }
    var selectedColorIndex by remember { mutableStateOf(-1) }

    Row(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
        ) {
            itemsIndexed(ColorSwatch.HeaderColors) { index: Int, item: Color ->
                Header(
                    modifier = Modifier
                        .padding(horizontal = 2.dp)
                        .clip(CircleShape)
                        .size(60.dp)
                        .clickable {
                            headerIndex = index
                        }, color = item
                )
            }
        }

        val colorSwatch: LinkedHashMap<Int, Color> = ColorSwatch.primaryColorSwatches[headerIndex]

        val keys: MutableList<Int> = colorSwatch.keys.toMutableList()
        val colors: MutableList<Color> = colorSwatch.values.toMutableList()

        val result: Result<LinkedHashMap<Int, Color>> =
            runCatching { ColorSwatch.accentColorSwatches[headerIndex] }

        if (result.isSuccess) {
            result.getOrNull()?.let { accentColorSwatch: LinkedHashMap<Int, Color> ->
                val accentKeys = accentColorSwatch.keys.toList()
                val accentColors = accentColorSwatch.values.toList()
                keys.addAll(accentKeys)
                colors.addAll(accentColors)
            }
        }
        Divider(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .background(Color.LightGray)
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp)
        ) {
            itemsIndexed(colors) { index: Int, item: Color ->
                Column {
                    if (index == 0 || index == 10) {
                        Text(
                            modifier = Modifier.padding(8.dp),
                            text = if (index == 0) "Primary" else "Accent",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    ColorRowWithInfo(
                        modifier =
                        Modifier
                            .graphicsLayer {
                                scaleY = if (selectedColorIndex == index) 1.03f else 1f
                                scaleX = if (selectedColorIndex == index) 1.03f else 1f
                            }
                            .shadow(2.dp, RoundedCornerShape(4.dp))
                            .fillMaxWidth()
                            .clickable {
                                selectedColorIndex = index
                                onColorChange(item)
                            },
                        title = keys[index].toString(),
                        color = item,
                        textColor = if (index < 5 || index > 9) Color.Black else Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun Header(modifier: Modifier, color: Color) {
    Box(
        modifier = modifier
            .background(color)
    )
}

@Composable
fun ColorRowWithInfo(
    modifier: Modifier,
    title: String,
    color: Color,
    textColor: Color
) {
    Row(
        modifier
            .background(color)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, color = textColor, fontSize = 22.sp)
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = colorToHex(color),
            color = textColor,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
    }
}