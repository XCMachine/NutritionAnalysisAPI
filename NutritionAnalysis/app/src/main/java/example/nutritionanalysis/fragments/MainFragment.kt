package example.nutritionanalysis.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import example.nutritionanalysis.R
import example.nutritionanalysis.databinding.FragmentMainBinding
import example.nutritionanalysis.viewmodels.NutritionViewModel


class MainFragment : Fragment() {
    private lateinit var nutritionViewModel: NutritionViewModel
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nutritionViewModel = ViewModelProvider(this).get(NutritionViewModel::class.java)

        findNavController().setGraph(R.navigation.nav_graph)
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

        nutritionViewModel.nutritionDetails.observe(viewLifecycleOwner) {
            binding.caloriesChangeData.text = it.calories.toString()
            binding.totalWeightTv.text = it.totalWeight.toString()
        }
        nutritionViewModel.getNutritionDetails()
    }
}