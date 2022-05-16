package com.example.network.models

data class NutritionData(
    val uri: String,
    val calories: Int,
    val totalWeight: Int,

    val healthLabels: List<String>,

    val totalNutrientsKCal: TotalNutrientsKCal
) {
    data class TotalNutrientsKCal(
        val ENERC_KCAL: EnercKcal,
        val PROCNT_KCAL: ProcntKcal,
        val FAT_KCAL: FatKcal,
        val CHOCDF_KCAL: ChocdfKcal
    )

    data class EnercKcal(
        val label: String,
        val quantity: Int,
        val unit: String
    )

    data class ProcntKcal(
        val label: String,
        val quantity: Int,
        val unit: String
    )

    data class FatKcal(
        val label: String,
        val quantity: Int,
        val unit: String
    )

    data class ChocdfKcal(
        val label: String,
        val quantity: Int,
        val unit: String
    )
}