package network.resources.models

data class NutritionData(
    val uri: String,
    val calories: Int,
    val totalWeight: Int,

    val healthLabels: List<HealthLabels>,

    val totalNutrientsKCal: TotalNutrientsKCal
) {
    data class HealthLabels(
        val LOW_SUGAR: Int,
        val VEGAN: Int,
        val VEGETARIAN: Int,
        val SPECIFIC_CARBS: Int,
        val MEDITERRANEAN: Int,
        val DASH: Int,
        val DAIRY_FREE: Int,
        val GLUTEN_FREE: Int,
        val WHEAT_FREE: Int,
        val EGG_FREE: Int,
        val MILK_FREE: Int,
        val PEANUT_FREE: Int,
        val TREE_NUT_FREE: Int,
        val SOY_FREE: Int,
        val FISH_FREE: Int,
        val SHELLFISH_FREE: Int,
        val PORK_FREE: Int,
        val RED_MEAT_FREE: Int,
        val CRUSTACEAN_FREE: Int,
        val CELERY_FREE: Int,
        val MUSTARD_FREE: Int,
        val SESAME_FREE: Int,
        val LUPINE_FREE: Int,
        val MOLLUSK_FREE: Int,
        val ALCOHOL_FREE: Int,
        val NO_OIL_ADDED: Int,
        val NO_SUGAR_ADDED: Int,
        val SULPHITE_FREE: Int,
        val FODMAP_FREE: Int,
        val KOSHER: Int
    )

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
