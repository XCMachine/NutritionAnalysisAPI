package example.nutritionanalysis.repositories

import androidx.lifecycle.MutableLiveData
import com.example.network.datasource.NutritionNetworkDatasource
import com.example.network.models.NutritionData

class NutritionRepository(
    private val nutritionNetworkDatasource: NutritionNetworkDatasource = NutritionNetworkDatasource()
) {
    //In-memory cache
    private var latestNutritionDetails: NutritionData? = null

    /**
     * Make a condition, if there is cached data from the backend, the livedata to load the cached data,
     * if not to grab the latest data using a query from the datasource and store the latest information within the cache.
     */
    fun getNutritionDetails(
        mutableLiveData: MutableLiveData<NutritionData>
    ) {
        if (latestNutritionDetails != null) {
            mutableLiveData.value = latestNutritionDetails
        } else {
            nutritionNetworkDatasource.getNutritionData(object : NutritionNetworkDatasource.DataReadyCallback {
                override fun onDataReady(data: NutritionData) {
                    latestNutritionDetails = data
                    latestNutritionDetails.run {
                        mutableLiveData.value = this
                    }
                }
            })
        }
    }
}