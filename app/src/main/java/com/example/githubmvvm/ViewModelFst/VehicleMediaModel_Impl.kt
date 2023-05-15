package com.example.githubmvvm.ViewModelFst

import androidx.lifecycle.MutableLiveData
import com.example.githubmvvm.Network_Stuff.AnyCallBackRetorfit
import com.example.githubmvvm.Network_Stuff.CommanWebApiParams
import com.example.githubmvvm.Network_Stuff.OnFinishedListner
import com.mypcp.cannon_auction.Network_Stuff.ApiInterface
import com.mypcp.cannon_auction.Network_Stuff.ApiRetrofit

class VehicleMediaModel_Impl(finishedLIstner: OnFinishedListner) {

    private var onFinishedListner = finishedLIstner
    private var callRetrofit: AnyCallBackRetorfit
    private val apiInterface: ApiInterface

    //  var responseBody = MutableLiveData<Any>()

    private var responseBody: MutableLiveData<Any>? = null

    init {
        apiInterface = ApiRetrofit.getRetrofitInstance().create(ApiInterface::class.java)
        callRetrofit = AnyCallBackRetorfit()
    }

    fun getWebApiCalled_getResponse(
        strVehicleStatus: String,
        strStatus: String,
        strSearch: String
    ) {
        var hashMap = HashMap<String, String>()
        hashMap["VehicleStatus"] = strVehicleStatus
        hashMap["Status"] = strStatus
        hashMap["limit"] = "50"
        hashMap["offset"] = "0"
        hashMap["SearchText"] = strSearch

        hashMap = CommanWebApiParams().commanParams(hashMap)

        // val apiInterface: ApiInterface = ApiRetrofit.getRetrofitInstance().create(ApiInterface::class.java)
        val apiInterfaceCallBack =
            apiInterface.getAnyResponse(hashMap, "bid/bidder/vehiclelist", hashMap)
        callRetrofit.getAnyResponse(apiInterfaceCallBack, hashMap, onFinishedListner)
    }

    fun getWebApiCalled_getResponse(): MutableLiveData<Any> {

        var hashMap = HashMap<String, String>()

        hashMap["Status"] = "4"
        hashMap["limit"] = "50"
        hashMap["offset"] = "0"
        hashMap["SearchText"] = ""

        //  hashMap["VehicleStatus"]="3"

        hashMap = CommanWebApiParams().commanParamsHardCore(hashMap)

        // val apiInterfaceCallBack = apiInterface.getAnyResponse(hashMap,"bid/bidder/vehiclelist", hashMap)

        val apiInterfaceCallBack = apiInterface.getAnyResponse(hashMap, "bid/vehicles/bidapproved", hashMap)

        //  responseBody=vehicleMediaModel_.getWebApiCalled_getResponse();
        //  vehicleMediaModel_.getWebApiCalled_getResponse();
//        if (responseBody == null) {
//            d(LogCalls_Debug.TAG, "getWebApiCalled_getResponse null")
//            responseBody= callRetrofit.getAnyResponseliveData(apiInterfaceCallBack, hashMap,onFinishedListner)
//        } else {
//            d(LogCalls_Debug.TAG, "getWebApiCalled_getResponse ")
//            // Just call it, you already assigned before
//             callRetrofit.getAnyResponseliveData(apiInterfaceCallBack, hashMap,onFinishedListner)
//        }
        responseBody = callRetrofit.getAnyResponseliveData(apiInterfaceCallBack, hashMap, onFinishedListner)

        return responseBody as MutableLiveData<Any>
    }
}
