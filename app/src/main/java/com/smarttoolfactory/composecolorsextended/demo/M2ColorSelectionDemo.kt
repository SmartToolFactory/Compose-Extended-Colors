package com.smarttoolfactory.composecolorsextended.demo

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.smarttoolfactory.composecolorsextended.M2ListColorPicker

@Composable
fun M2ColorSelectionDemo(onColorChange: (Color) -> Unit) {
    M2ListColorPicker(onColorChange = onColorChange)
}
