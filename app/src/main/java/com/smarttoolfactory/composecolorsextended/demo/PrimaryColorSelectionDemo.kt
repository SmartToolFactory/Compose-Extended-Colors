package com.smarttoolfactory.composecolorsextended.demo

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.smarttoolfactory.composecolorsextended.MaterialColorPicker

@Composable
fun PrimaryColorSelectionDemo(onColorChange: (Color) -> Unit) {
    MaterialColorPicker(onColorChange = onColorChange)
}

