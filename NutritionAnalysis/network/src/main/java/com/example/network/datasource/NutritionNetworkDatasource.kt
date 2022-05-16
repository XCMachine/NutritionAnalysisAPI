package com.example.network.datasource

import android.util.Log
import com.example.network.Retrofit
import com.example.network.models.NutritionData
import com.example.network.service.ServiceAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NutritionNetworkDatasource(
    private val serviceAPI: ServiceAPI = Retrofit().getInstance().create(ServiceAPI::class.java)
) {
    fun getNutritionData(
        callback: DataReadyCallback
    ) {
        val callNutritionData: Call<NutritionData> = serviceAPI.getNutrition()
        callNutritionData.enqueue(object : Callback<NutritionData> {
            override fun onResponse(call: Call<NutritionData>, response: Response<NutritionData>) {
                response.body()?.run {
                    callback.onDataReady(this)
                    Log.i(LOG, "Callback success: $response")
                }
            }

            override fun onFailure(call: Call<NutritionData>, t: Throwable) {
                Log.e(LOG, t.localizedMessage!!)
            }

        })
    }

    companion object {
        private const val LOG = "NutritionData"
    }
}

interface DataReadyCallback {
    fun onDataReady(data: NutritionData)
}