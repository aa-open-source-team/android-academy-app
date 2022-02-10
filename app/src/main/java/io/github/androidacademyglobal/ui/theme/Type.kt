package io.github.androidacademyglobal.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val AndroidAcademyTypography = Typography(
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = FONT_SIZE_REGULAR.sp,
        lineHeight = LINE_HEIGHT_REGULAR.sp,
        letterSpacing = LETTER_SPACING_REGULAR.sp
    ),
    bodySmall = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = FONT_SIZE_SMALL.sp,
        lineHeight = LINE_HEIGHT_SMALL.sp,
        letterSpacing = LETTER_SPACING_SMALL.sp
    ),
)
