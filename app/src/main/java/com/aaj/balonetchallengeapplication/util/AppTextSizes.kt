package com.aaj.balonetchallengeapplication.util

enum class AppTextSizes {
    VERY_SMALL, SMALL, NORMAL, LARGE, VERY_LARGE
}

fun AppTextSizes.getDiff(): Int {
    return when (this) {
        AppTextSizes.VERY_SMALL -> -4
        AppTextSizes.SMALL -> 0
        AppTextSizes.NORMAL -> 4
        AppTextSizes.LARGE -> 8
        AppTextSizes.VERY_LARGE -> 10
    }
}