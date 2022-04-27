package com.smarttoolfactory.extendedcolors

import androidx.compose.ui.graphics.Color


object MaterialColor {

    val HeaderColors by lazy {

        println("🌈 Colors")
        listOf(
            Red500,
            Pink500,
            Purple500,
            DeepPurple500,
            Indigo500,
            Blue500,
            LightBlue500,
            Cyan500,
            Teal500,
            Green500,
            LightGreen500,
            Lime500,
            Yellow500,
            Amber500,
            Orange500,
            DeepOrange500,
            Brown500,
            Grey500
        )
    }

    /*
        Red
     */
    // Primary Colors
    val Red50 = Color(0xffFFEBEE)
    val Red100 = Color(0xffFFCDD2)
    val Red200 = Color(0xffEF9A9A)
    val Red300 = Color(0xffE57373)
    val Red400 = Color(0xffEF5350)
    val Red500 = Color(0xffF44336)
    val Red600 = Color(0xffE53935)
    val Red700 = Color(0xffD32F2F)
    val Red800 = Color(0xffC62828)
    val Red900 = Color(0xffB71C1C)

    // Accent Colors
    val RedA100 = Color(0xffFF8A80)
    val RedA200 = Color(0xffFF5252)
    val RedA400 = Color(0xffFF1744)
    val RedA700 = Color(0xffD50000)

    /*
        Pink
     */
    // Primary Colors
    val Pink50 = Color(0xffFCE4EC)
    val Pink100 = Color(0xffF8BBD0)
    val Pink200 = Color(0xffF48FB1)
    val Pink300 = Color(0xffF06292)
    val Pink400 = Color(0xffEC407A)
    val Pink500 = Color(0xffE91E63)
    val Pink600 = Color(0xffD81B60)
    val Pink700 = Color(0xffC2185B)
    val Pink800 = Color(0xffAD1457)
    val Pink900 = Color(0xff880E4F)

    // Accent Colors
    val PinkA100 = Color(0xffFF80AB)
    val PinkA200 = Color(0xffFF4081)
    val PinkA400 = Color(0xffF50057)
    val PinkA700 = Color(0xffC51162)

    /*
        Purple
     */
    // Primary Colors
    val Purple50 = Color(0xffF3E5F5)
    val Purple100 = Color(0xffE1BEE7)
    val Purple200 = Color(0xffCE93D8)
    val Purple300 = Color(0xffBA68C8)
    val Purple400 = Color(0xffAB47BC)
    val Purple500 = Color(0xff9C27B0)
    val Purple600 = Color(0xff8E24AA)
    val Purple700 = Color(0xff7B1FA2)
    val Purple800 = Color(0xff6A1B9A)
    val Purple900 = Color(0xff4A148C)

    // Accent Colors
    val PurpleA100 = Color(0xffEA80FC)
    val PurpleA200 = Color(0xffE040FB)
    val PurpleA400 = Color(0xffD500F9)
    val PurpleA700 = Color(0xffAA00FF)

    /*
        DeepPurple
     */
    // Primary Colors
    val DeepPurple50 = Color(0xffEDE7F6)
    val DeepPurple100 = Color(0xffD1C4E9)
    val DeepPurple200 = Color(0xffB39DDB)
    val DeepPurple300 = Color(0xff9575CD)
    val DeepPurple400 = Color(0xff7E57C2)
    val DeepPurple500 = Color(0xff673AB7)
    val DeepPurple600 = Color(0xff5E35B1)
    val DeepPurple700 = Color(0xff512DA8)
    val DeepPurple800 = Color(0xff4527A0)
    val DeepPurple900 = Color(0xff311B92)

    // Accent Colors
    val DeepPurpleA100 = Color(0xffB388FF)
    val DeepPurpleA200 = Color(0xff7C4DFF)
    val DeepPurpleA400 = Color(0xff651FFF)
    val DeepPurpleA700 = Color(0xff6200EA)

    /*
        Indigo
     */
    // Primary Colors
    val Indigo50 = Color(0xffE8EAF6)
    val Indigo100 = Color(0xffC5CAE9)
    val Indigo200 = Color(0xff9FA8DA)
    val Indigo300 = Color(0xff7986CB)
    val Indigo400 = Color(0xff5C6BC0)
    val Indigo500 = Color(0xff3F51B5)
    val Indigo600 = Color(0xff3949AB)
    val Indigo700 = Color(0xff303F9F)
    val Indigo800 = Color(0xff283593)
    val Indigo900 = Color(0xff1A237E)

    // Accent Colors
    val IndigoA100 = Color(0xff8C9EFF)
    val IndigoA200 = Color(0xff536DFE)
    val IndigoA400 = Color(0xff3D5AFE)
    val IndigoA700 = Color(0xff304FFE)

    /*
        Blue
     */
    // Primary Colors
    val Blue50 = Color(0xffE8EAF6)
    val Blue100 = Color(0xffC5CAE9)
    val Blue200 = Color(0xff9FA8DA)
    val Blue300 = Color(0xff7986CB)
    val Blue400 = Color(0xff42A5F5)
    val Blue500 = Color(0xff2196F3)
    val Blue600 = Color(0xff3949AB)
    val Blue700 = Color(0xff303F9F)
    val Blue800 = Color(0xff283593)
    val Blue900 = Color(0xff1A237E)

    // Accent Colors
    val BlueA100 = Color(0xff8C9EFF)
    val BlueA200 = Color(0xff536DFE)
    val BlueA400 = Color(0xff3D5AFE)
    val BlueA700 = Color(0xff304FFE)

    /*
        LightBlue
     */
    // Primary Colors
    val LightBlue50 = Color(0xffE1F5FE)
    val LightBlue100 = Color(0xffB3E5FC)
    val LightBlue200 = Color(0xff81D4FA)
    val LightBlue300 = Color(0xff4FC3F7)
    val LightBlue400 = Color(0xff29B6F6)
    val LightBlue500 = Color(0xff03A9F4)
    val LightBlue600 = Color(0xff039BE5)
    val LightBlue700 = Color(0xff0288D1)
    val LightBlue800 = Color(0xff0277BD)
    val LightBlue900 = Color(0xff01579B)

    // Accent Colors
    val LightBlueA100 = Color(0xff80D8FF)
    val LightBlueA200 = Color(0xff40C4FF)
    val LightBlueA400 = Color(0xff00B0FF)
    val LightBlueA700 = Color(0xff0091EA)

    /*
        Cyan
     */
    // Primary Colors
    val Cyan50 = Color(0xffE0F7FA)
    val Cyan100 = Color(0xffB2EBF2)
    val Cyan200 = Color(0xff80DEEA)
    val Cyan300 = Color(0xff4DD0E1)
    val Cyan400 = Color(0xff26C6DA)
    val Cyan500 = Color(0xff00BCD4)
    val Cyan600 = Color(0xff00ACC1)
    val Cyan700 = Color(0xff0097A7)
    val Cyan800 = Color(0xff00838F)
    val Cyan900 = Color(0xff006064)

    // Accent Colors
    val CyanA100 = Color(0xff84FFFF)
    val CyanA200 = Color(0xff18FFFF)
    val CyanA400 = Color(0xff00E5FF)
    val CyanA700 = Color(0xff00B8D4)

    /*
        Teal
     */
    // Primary Colors
    val Teal50 = Color(0xffE0F2F1)
    val Teal100 = Color(0xffB2DFDB)
    val Teal200 = Color(0xff80CBC4)
    val Teal300 = Color(0xff4DB6AC)
    val Teal400 = Color(0xff26A69A)
    val Teal500 = Color(0xff009688)
    val Teal600 = Color(0xff00897B)
    val Teal700 = Color(0xff00796B)
    val Teal800 = Color(0xff00695C)
    val Teal900 = Color(0xff004D40)

    // Accent Colors
    val TealA100 = Color(0xff84FFFF)
    val TealA200 = Color(0xff18FFFF)
    val TealA400 = Color(0xff00E5FF)
    val TealA700 = Color(0xff00B8D4)

    /*
        Green
     */
    // Primary Colors
    val Green50 = Color(0xffE8F5E9)
    val Green100 = Color(0xffC8E6C9)
    val Green200 = Color(0xffA5D6A7)
    val Green300 = Color(0xff81C784)
    val Green400 = Color(0xff66BB6A)
    val Green500 = Color(0xff4CAF50)
    val Green600 = Color(0xff43A047)
    val Green700 = Color(0xff388E3C)
    val Green800 = Color(0xff558B2F)
    val Green900 = Color(0xff1B5E20)

    // Accent Colors
    val GreenA100 = Color(0xffB9F6CA)
    val GreenA200 = Color(0xff69F0AE)
    val GreenA400 = Color(0xff00E676)
    val GreenA700 = Color(0xff00C853)

    /*
        LightGreen
     */
    // Primary Colors
    val LightGreen50 = Color(0xffF1F8E9)
    val LightGreen100 = Color(0xffDCEDC8)
    val LightGreen200 = Color(0xffC5E1A5)
    val LightGreen300 = Color(0xffAED581)
    val LightGreen400 = Color(0xff9CCC65)
    val LightGreen500 = Color(0xff8BC34A)
    val LightGreen600 = Color(0xff7CB342)
    val LightGreen700 = Color(0xff689F38)
    val LightGreen800 = Color(0xff558B2F)
    val LightGreen900 = Color(0xff33691E)

    // Accent Colors
    val LightGreenA100 = Color(0xffCCFF90)
    val LightGreenA200 = Color(0xffB2FF59)
    val LightGreenA400 = Color(0xff558B2F)
    val LightGreenA700 = Color(0xff33691E)

    /*
        Lime
     */
    // Primary Colors
    val Lime50 = Color(0xffF9FBE7)
    val Lime100 = Color(0xffF0F4C3)
    val Lime200 = Color(0xffE6EE9C)
    val Lime300 = Color(0xffDCE775)
    val Lime400 = Color(0xffD4E157)
    val Lime500 = Color(0xffCDDC39)
    val Lime600 = Color(0xffC0CA33)
    val Lime700 = Color(0xffAFB42B)
    val Lime800 = Color(0xff9E9D24)
    val Lime900 = Color(0xff827717)

    // Accent Colors
    val LimeA100 = Color(0xffF4FF81)
    val LimeA200 = Color(0xffEEFF41)
    val LimeA400 = Color(0xffC6FF00)
    val LimeA700 = Color(0xffAEEA00)

    /*
        Yellow
     */
    // Primary Colors
    val Yellow50 = Color(0xffF9FBE7)
    val Yellow100 = Color(0xffF0F4C3)
    val Yellow200 = Color(0xffE6EE9C)
    val Yellow300 = Color(0xffDCE775)
    val Yellow400 = Color(0xffFFEE58)
    val Yellow500 = Color(0xffFFEB3B)
    val Yellow600 = Color(0xffC0CA33)
    val Yellow700 = Color(0xffAFB42B)
    val Yellow800 = Color(0xff9E9D24)
    val Yellow900 = Color(0xff827717)

    // Accent Colors
    val YellowA100 = Color(0xffF4FF81)
    val YellowA200 = Color(0xffEEFF41)
    val YellowA400 = Color(0xffC6FF00)
    val YellowA700 = Color(0xffAEEA00)

    /*
        Amber
     */
    // Primary Colors
    val Amber50 = Color(0xffFFF8E1)
    val Amber100 = Color(0xffFFF8E1)
    val Amber200 = Color(0xffFFE082)
    val Amber300 = Color(0xffFFD54F)
    val Amber400 = Color(0xffFFCA28)
    val Amber500 = Color(0xffFFC107)
    val Amber600 = Color(0xffFFB300)
    val Amber700 = Color(0xffFFA000)
    val Amber800 = Color(0xffFF8F00)
    val Amber900 = Color(0xffFF6F00)

    // Accent Colors
    val AmberA100 = Color(0xffFFE57F)
    val AmberA200 = Color(0xffFFD740)
    val AmberA400 = Color(0xffFF8F00)
    val AmberA700 = Color(0xffFF6F00)

    /*
        Orange
     */
    // Primary Colors
    val Orange50 = Color(0xffFFF3E0)
    val Orange100 = Color(0xffFFE0B2)
    val Orange200 = Color(0xffFFCC80)
    val Orange300 = Color(0xffFFB74D)
    val Orange400 = Color(0xffFFA726)
    val Orange500 = Color(0xffFF9800)
    val Orange600 = Color(0xffFB8C00)
    val Orange700 = Color(0xffF57C00)
    val Orange800 = Color(0xffEF6C00)
    val Orange900 = Color(0xffE65100)

    // Accent Colors
    val OrangeA100 = Color(0xffFFD180)
    val OrangeA200 = Color(0xffFFAB40)
    val OrangeA400 = Color(0xffFF9100)
    val OrangeA700 = Color(0xffFF6D00)

    /*
        DeepOrange
     */
    // Primary Colors
    val DeepOrange50 = Color(0xffFBE9E7)
    val DeepOrange100 = Color(0xffFFCCBC)
    val DeepOrange200 = Color(0xffFFAB91)
    val DeepOrange300 = Color(0xffFF8A65)
    val DeepOrange400 = Color(0xffFF7043)
    val DeepOrange500 = Color(0xffFF5722)
    val DeepOrange600 = Color(0xffF4511E)
    val DeepOrange700 = Color(0xffE64A19)
    val DeepOrange800 = Color(0xffD84315)
    val DeepOrange900 = Color(0xffBF360C)

    // Accent Colors
    val DeepOrangeA100 = Color(0xffFF9E80)
    val DeepOrangeA200 = Color(0xffFF6E40)
    val DeepOrangeA400 = Color(0xffFF3D00)
    val DeepOrangeA700 = Color(0xffDD2C00)

    /*
        Brown
     */
    // Primary Colors
    val Brown50 = Color(0xffEFEBE9)
    val Brown100 = Color(0xffD7CCC8)
    val Brown200 = Color(0xffBCAAA4)
    val Brown300 = Color(0xffA1887F)
    val Brown400 = Color(0xff8D6E63)
    val Brown500 = Color(0xff795548)
    val Brown600 = Color(0xff6D4C41)
    val Brown700 = Color(0xff5D4037)
    val Brown800 = Color(0xff4E342E)
    val Brown900 = Color(0xff3E2723)

    /*
        Grey
     */
    // Primary Colors
    val Grey50 = Color(0xffFAFAFA)
    val Grey100 = Color(0xffF5F5F5)
    val Grey200 = Color(0xffEEEEEE)
    val Grey300 = Color(0xffE0E0E0)
    val Grey400 = Color(0xffBDBDBD)
    val Grey500 = Color(0xff9E9E9E)
    val Grey600 = Color(0xff757575)
    val Grey700 = Color(0xff616161)
    val Grey800 = Color(0xff424242)
    val Grey900 = Color(0xff212121)

    /*
        BlueGrey
     */
    // Primary Colors
    val BlueGrey50 = Color(0xffECEFF1)
    val BlueGrey100 = Color(0xffCFD8DC)
    val BlueGrey200 = Color(0xffB0BEC5)
    val BlueGrey300 = Color(0xff90A4AE)
    val BlueGrey400 = Color(0xff78909C)
    val BlueGrey500 = Color(0xff607D8B)
    val BlueGrey600 = Color(0xff546E7A)
    val BlueGrey700 = Color(0xff455A64)
    val BlueGrey800 = Color(0xff37474F)
    val BlueGrey900 = Color(0xff263238)
}
