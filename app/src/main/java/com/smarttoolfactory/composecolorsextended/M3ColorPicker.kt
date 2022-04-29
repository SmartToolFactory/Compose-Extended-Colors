package com.smarttoolfactory.composecolorsextended

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smarttoolfactory.extendedcolors.ColorSwatch
import com.smarttoolfactory.extendedcolors.MaterialColor
import com.smarttoolfactory.extendedcolors.parser.rememberColorParser
import com.smarttoolfactory.extendedcolors.util.colorToHSL
import com.smarttoolfactory.extendedcolors.util.colorToHex
import com.smarttoolfactory.extendedcolors.util.getColorTonesList
import com.smarttoolfactory.extendedcolors.util.material3ToneRange
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.mapLatest

@Composable
fun M3ColorPicker(onColorChange: (Color) -> Unit) {

    val clipboardManager = LocalClipboardManager.current
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = .8f)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val colorNameParser = rememberColorParser()

        var colorSwatchIndex by remember { mutableStateOf(0) }
        var color by remember { mutableStateOf(MaterialColor.Red500) }
        var md3Tones by remember { mutableStateOf(getColorTonesList(color)) }

        val colorSelectionIndex =
            remember { ColorSelectionIndex(mainSelection = 0, subSelection = 0) }

        val colorSwatch: LinkedHashMap<Int, Color> =
            remember(colorSwatchIndex) { ColorSwatch.primaryColorSwatches[colorSwatchIndex] }

        val keys: MutableList<Int> = colorSwatch.keys.toMutableList()
        val colors: MutableList<Color> = colorSwatch.values.toMutableList()

        var colorName by remember { mutableStateOf("") }

        LaunchedEffect(key1 = colorNameParser) {

            snapshotFlow { color }
                .distinctUntilChanged()
                .mapLatest { color: Color ->
                    colorNameParser.parseColorName(color)
                }
                .flowOn(Dispatchers.Default)
                .collect { name: String ->
                    colorName = name
                }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(6),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            itemsIndexed(ColorSwatch.primaryHeaderColors) { index: Int, item: Color ->

                ColorDisplayWithIcon(
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
                        },
                    selected = (colorSelectionIndex.mainSelection == 0 &&
                            colorSelectionIndex.subSelection == index) || (
                            colorSelectionIndex.mainSelection == 1 &&
                                    colorSelectionIndex.subSelection == 5 &&
                                    index == colorSwatchIndex
                            ),
                    backgroundColor = item
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
                    backgroundColor = item,
                    contentColor = if (index < 5) Color.Black else Color.White,
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
                    backgroundColor = item,
                    selected = (colorSelectionIndex.mainSelection == 2
                            && colorSelectionIndex.subSelection == index),
                    contentColor = if (index < 6) Color.White else Color.Black,
                    title = material3ToneRange[index].toString()
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
        val lightness = colorToHSL(color)[2]
        val textColor = if (lightness < .6f) Color.White else Color.Black


        Text(
            text = colorName,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )


        Row(
            modifier = Modifier
                .padding(8.dp)
                .background(color = color, RoundedCornerShape(50))
                .padding(horizontal = 20.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            val hexText = colorToHex(color = color)
            Text(
                text = hexText,
                fontSize = 24.sp,
                color = textColor
            )
            Spacer(modifier = Modifier.width(20.dp))
            IconButton(onClick = {
                Toast.makeText(context, "Copied $hexText", Toast.LENGTH_SHORT).show()
                clipboardManager.setText(AnnotatedString(hexText))
            }) {
                Icon(
                    tint = textColor,
                    painter = painterResource(id = R.drawable.ic_baseline_content_copy_24),
                    contentDescription = "clipboard"
                )
            }
        }

    }
}

@Composable
fun ColorDisplayWithTitle(
    modifier: Modifier,
    title: String = "",
    selected: Boolean,
    contentColor: Color = Color.Unspecified,
    backgroundColor: Color
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = modifier
                .background(backgroundColor)
        )

        Text(text = title, color = contentColor, fontSize = 16.sp)

        if (selected) {
            Icon(
                modifier = modifier
                    .background(contentColor.copy(alpha = .5f))
                    .padding(4.dp),
                imageVector = Icons.Default.Check,
                contentDescription = "check",
                tint = Color.Green
            )
        }
    }
}

@Composable
fun ColorDisplayWithIcon(
    modifier: Modifier,
    selected: Boolean,
    contentColor: Color = Color.Unspecified,
    backgroundColor: Color
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = modifier
                .background(backgroundColor)
        )

        if (selected) {
            Icon(
                modifier = modifier
                    .background(contentColor.copy(alpha = .5f))
                    .padding(4.dp),
                imageVector = Icons.Default.Check,
                contentDescription = "check",
                tint = Color.Green
            )
        }
    }
}

data class ColorSelectionIndex(var mainSelection: Int = 0, var subSelection: Int = 0)