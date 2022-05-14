package network.api

import network.resources.models.NutritionData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceAPI {
    @GET("api/nutrition-data")
    fun getNutritionDataSource(
        @Query("app_id") app_id: String = "c515cd0d",
        @Query("app_key") app_key: String = KEY,
        @Query("nutrition-type") nutrition_type: String = "cooking",
        @Query("ingr") ingr: String = "foodId"
    ): Call<NutritionData>

    companion object {
        private const val KEY = "26a39f9de8f760bd9d2090b0800ba4f3"
    }
}