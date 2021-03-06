package com.smarttoolfactory.composecolorsextended.demo

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.smarttoolfactory.composecolorsextended.M3ColorPicker

@Composable
fun M3ColorShadeSelectionDemo(onColorChange: (Color) -> Unit) {
    M3ColorPicker(onColorChange = onColorChange)
}
