package example.nutritionanalysis.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.network.models.NutritionData
import example.nutritionanalysis.R
import example.nutritionanalysis.databinding.FragmentMainBinding
import example.nutritionanalysis.viewmodels.NutritionViewModel


class MainFragment : Fragment() {
    private lateinit var nutritionViewModel: NutritionViewModel
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nutritionViewModel = ViewModelProvider(this).get(NutritionViewModel::class.java)

        NavHostFragment.create(R.navigation.nav_graph)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nutritionViewModel.nutritionDetails.observe(viewLifecycleOwner) { nutritionData ->
            binding.caloriesChangeData.text = nutritionData.calories.toString()
            binding.totalWeightChangeData.text = nutritionData.totalWeight.toString()

            kcalLabels(binding, nutritionData)
        }
        nutritionViewModel.getNutritionDetails()
    }

    //All the Kcal labels in one method
    private fun kcalLabels(binding: FragmentMainBinding, data: NutritionData) {
        binding.apply {
            //Energy label
            this.labelEnercCalorie.text = data.totalNutrientsKCal.ENERC_KCAL.label
            this.labelEnercQuantity.text = data.totalNutrientsKCal.ENERC_KCAL.quantity.toString()
            this.labelEnercUnit.text = data.totalNutrientsKCal.ENERC_KCAL.unit

            //Protein label
            this.labelProcntCalorie.text = data.totalNutrientsKCal.PROCNT_KCAL.label
            this.labelProcntQuantity.text = data.totalNutrientsKCal.PROCNT_KCAL.quantity.toString()
            this.labelProcntUnit.text = data.totalNutrientsKCal.PROCNT_KCAL.unit

            //Fat label
            this.labelFatCalorie.text = data.totalNutrientsKCal.FAT_KCAL.label
            this.labelFatQuantity.text = data.totalNutrientsKCal.FAT_KCAL.quantity.toString()
            this.labelFatUnit.text = data.totalNutrientsKCal.FAT_KCAL.unit

            //Carbohydrates label
            this.labelChocdfCalorie.text = data.totalNutrientsKCal.CHOCDF_KCAL.label
            this.labelChocdfQuantity.text = data.totalNutrientsKCal.CHOCDF_KCAL.quantity.toString()
            this.labelChocdfUnit.text = data.totalNutrientsKCal.CHOCDF_KCAL.unit
        }
    }
}