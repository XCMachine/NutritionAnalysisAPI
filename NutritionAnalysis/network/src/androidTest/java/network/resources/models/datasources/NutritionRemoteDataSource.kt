package network.resources.models.datasources

import android.util.Log
import network.Retrofit
import network.api.ServiceAPI
import network.resources.models.NutritionData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NutritionRemoteDataSource(
    private val serviceAPI: ServiceAPI = Retrofit().getNutritionInstance().create(ServiceAPI::class.java)
) {
    fun getNutritionData(
        callback: DataReadyCallback
    ) {
        val callNutritionData: Call<NutritionData> = serviceAPI.getNutritionDataSource()
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