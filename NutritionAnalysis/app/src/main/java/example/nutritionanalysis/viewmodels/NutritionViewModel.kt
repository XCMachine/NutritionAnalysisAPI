package example.nutritionanalysis.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.network.datasource.DataReadyCallback
import com.example.network.datasource.NutritionNetworkDatasource
import com.example.network.models.NutritionData

class NutritionViewModel: ViewModel() {
    private val _nutritionDetails = MutableLiveData<NutritionData>()
    val nutritionDetails: LiveData<NutritionData> = _nutritionDetails

    fun getNutritionDetails() {
        NutritionNetworkDatasource().getNutritionData(object : DataReadyCallback {
            override fun onDataReady(data: NutritionData) {
                _nutritionDetails.value = data
            }
        })
    }
}