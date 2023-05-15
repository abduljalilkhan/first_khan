package com.example.githubmvvm.Network_Stuff

import androidx.lifecycle.MutableLiveData
import com.example.githubmvvm.LogCalls_Debug
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnyCallBackRetorfit {

    val responseBody: MutableLiveData<Any> = MutableLiveData()

    fun getAnyResponse(
        apiInterfaceCallBack: Call<Any>,
        hashMap: HashMap<String, String>,
        finishedListner: OnFinishedListner
    ) {

        LogCalls_Debug.d(LogCalls_Debug.TAG, hashMap.toString())

        // val apiInterface: ApiInterface = ApiRetrofit.getRetrofitInstance().create(ApiInterface::class.java)
        // val apiInterfaceCallBack = apiInterface.getAnyResponse(hashMap,"bid/vehicles/uploadedvehiclemedia",hashMap)

        apiInterfaceCallBack.enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                LogCalls_Debug.d(LogCalls_Debug.TAG, response.body().toString())

                if (response.isSuccessful) {
                    finishedListner.onSuccess(response.body())
                    LogCalls_Debug.d(
                        LogCalls_Debug.TAG,
                        "isSuccessful" + response.body().toString()
                    )
                } else {
                    LogCalls_Debug.d(LogCalls_Debug.TAG, "Error" + response.body().toString())
                    finishedListner.onError()
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                finishedListner.onFailure(t)
                apiInterfaceCallBack.clone().enqueue(this)
                LogCalls_Debug.d(LogCalls_Debug.TAG, t.message)
            }
        })
    }

    fun getAnyResponse(
        apiInterfaceCallBack: Call<Any>,
        hashMap: MutableMap<String, RequestBody>,
        finishedListner: OnFinishedListner
    ) {

        LogCalls_Debug.d(LogCalls_Debug.TAG, hashMap.toString())

        // val apiInterface: ApiInterface = ApiRetrofit.getRetrofitInstance().create(ApiInterface::class.java)
        // val apiInterfaceCallBack = apiInterface.getAnyResponse("bid/vehicles/uploadedvehiclemedia",hashMap)

        apiInterfaceCallBack.enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                LogCalls_Debug.d(LogCalls_Debug.TAG, response.body().toString())

                if (response.isSuccessful) {
                    finishedListner.onSuccess(response.body())
                    LogCalls_Debug.d(
                        LogCalls_Debug.TAG,
                        "isSuccessful" + response.body().toString()
                    )
                } else {
                    LogCalls_Debug.d(LogCalls_Debug.TAG, "Error" + response.body().toString())
                    finishedListner.onError()
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                finishedListner.onFailure(t)
                apiInterfaceCallBack.clone().enqueue(this)
                LogCalls_Debug.d(LogCalls_Debug.TAG, t.message)
            }
        })
    }

    // JsonElement {"total":0.0,"success":0.0,"vehicles":[],"message":"No Vehicle Found","fucntion":"vehiclelist"}
// val myjsonString = "{\"phonetype\":\"N95\",\"cat\":\"WP\"}"
    fun getAnyResponseliveData(
        apiInterfaceCallBack: Call<Any>,
        hashMap: HashMap<String, String>,
        finishedListner: OnFinishedListner
    ): MutableLiveData<Any> {

        // val responseBody = MutableLiveData<Any>()

        LogCalls_Debug.d(LogCalls_Debug.TAG, hashMap.toString())

        apiInterfaceCallBack.enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                LogCalls_Debug.d(LogCalls_Debug.TAG, response.body().toString())

                if (response.isSuccessful) {

                    // responseBody.value="null"
                    // responseBody.value = response.body()

                    responseBody.postValue(response.body())
                    LogCalls_Debug.d(
                        LogCalls_Debug.TAG,
                        "isSuccessful" + response.body().toString())
                    finishedListner.onSuccess(response.body())
                } else {
                    LogCalls_Debug.d(LogCalls_Debug.TAG, "Error" + response.body().toString())

                    responseBody.value = "null"

                    finishedListner.onError()
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {

                responseBody.value = "null"

                apiInterfaceCallBack.clone().enqueue(this)
                LogCalls_Debug.d(LogCalls_Debug.TAG, t.message)

                finishedListner.onFailure(t)
            }
        })
        return responseBody
    }
}
