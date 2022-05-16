package example.nutritionanalysis.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.network.models.NutritionData
import example.nutritionanalysis.repositories.NutritionRepository

class NutritionViewModel: ViewModel() {
    private val _nutritionDetails = MutableLiveData<NutritionData>()
    val nutritionDetails: LiveData<NutritionData> = _nutritionDetails

    fun getNutritionDetails() {
        NutritionRepository().getNutritionDetails(_nutritionDetails)
    }
}