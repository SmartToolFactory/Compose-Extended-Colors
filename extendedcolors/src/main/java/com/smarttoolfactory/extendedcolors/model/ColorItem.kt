package com.smarttoolfactory.extendedcolors.model

import androidx.compose.ui.graphics.Color
import com.smarttoolfactory.extendedcolors.util.*

/**
 * Data class that wraps [Color] and contains extend information about this color such
 * as HSL, HSV, RGB, HEX counterparts.
 */
data class ColorItem(var color: Color) {
    val hexARGB
        get() = colorToHexAlpha(color)

    val hex
        get() = colorToHex(color)

    val hsvArray
        get() = colorToHSV(color)

    val hslArray
        get() = colorToHSL(color)

    val rgb
        get() = colorToARGBArray(color)

    val alpha:Float
        get() = color.alpha

    val red: Int
        get() = color.red.fractionToRGBRange()

    val green: Int
        get() = color.green.fractionToRGBRange()

    val blue: Int
        get() = color.blue.fractionToRGBRange()

    var label: String = Unspecified

    companion object {
        const val Unspecified = "?????"
    }
}