package com.smarttoolfactory.composecolorsextended.demo

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smarttoolfactory.extendedcolors.GradientAngle
import com.smarttoolfactory.extendedcolors.GradientOffset
import com.smarttoolfactory.extendedcolors.MaterialColor.Blue400
import kotlin.math.roundToInt

/**
 * Demo for creating gradients for different type of pickers or sliders
 */
@Composable
fun GradientAngleDemo() {

    val canvasModifier = Modifier.size(300.dp)

    // Offsets for gradients based on selected angle
    var gradientOffset by remember {
        mutableStateOf(GradientOffset(GradientAngle.CW0))
    }

    var angleSelection by remember { mutableStateOf(0f) }
    var angleText by remember { mutableStateOf("0 Degrees") }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = angleText,
            color = Blue400,
            modifier = Modifier
                .padding(8.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Slider(
            modifier = Modifier.height(50.dp),
            value = angleSelection,
            onValueChange = {
                angleSelection = it

                gradientOffset = when (angleSelection.roundToInt()) {
                    0 -> {
                        angleText = "0 Degrees"
                        GradientOffset(GradientAngle.CW0)
                    }
                    1 -> {
                        angleText = "45 Degrees"
                        GradientOffset(GradientAngle.CW45)
                    }
                    2 -> {
                        angleText = "90 Degrees"
                        GradientOffset(GradientAngle.CW90)
                    }
                    3 -> {
                        angleText = "135 Degrees"
                        GradientOffset(GradientAngle.CW135)
                    }
                    4 -> {
                        angleText = "180 Degrees"
                        GradientOffset(GradientAngle.CW180)
                    }

                    5 -> {
                        angleText = "225 Degrees"
                        GradientOffset(GradientAngle.CW225)
                    }
                    6 -> {
                        angleText = "270 Degrees"
                        GradientOffset(GradientAngle.CW270)
                    }
                    else -> {
                        angleText = "315 Degrees"
                        GradientOffset(GradientAngle.CW315)
                    }
                }
            },
            steps = 6,
            valueRange = 0f..7f
        )

        CanvasWithTitle(
            modifier = canvasModifier,
            text = "Gradient Angle"
        ) {
            val redGreenGradient = Brush.linearGradient(
                colors = listOf(Color.Red, Color.Green, Color.Blue),
                start = gradientOffset.start,
                end = gradientOffset.end
            )
            drawRect(redGreenGradient)
        }

    }
}

@Composable
private fun CanvasWithTitle(
    modifier: Modifier = Modifier,
    text: String,
    onDraw: DrawScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .wrapContentWidth()
    ) {

        Text(
            text = text,
            color = Blue400,
            modifier = Modifier
                .padding(8.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Canvas(modifier = modifier, onDraw = onDraw)
    }
}