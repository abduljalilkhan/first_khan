package com.example.githubmvvm.ViewModel_stuff

import android.content.Context
import androidx.lifecycle.*
import com.example.githubmvvm.LogCalls_Debug
import com.example.githubmvvm.LogCalls_Debug.d
import com.example.githubmvvm.Network_Stuff.OnFinishedListner
import com.example.githubmvvm.Utils.EventLiveData
import com.example.githubmvvm.ViewModelFst.BidsRegisteredResponse
import com.example.githubmvvm.ViewModelFst.VehicleMediaModel_Impl

class FirstViewModel_Kotlin(mApplication: Context?) : ViewModel() {

    var a = 0

    var vehicleMediaModel_: VehicleMediaModel_Impl? = null

    var responseBody: MutableLiveData<Any>? = null
    var responseBodyLiveData: LiveData<Any>? = responseBody

    var strCount = MutableLiveData<String>()

    private val navigateToNext = MutableLiveData<Boolean>()
    private val _navigateToNext: LiveData<Boolean> = navigateToNext

    private val mediatorLiveData = MediatorLiveData<String>()
    private val stringMediatorLiveData = MediatorLiveData<String>()

    private val _navigateWithEvent = MutableLiveData<EventLiveData<Boolean?>>()
    var navigateWithEvent: LiveData<EventLiveData<Boolean?>> = _navigateWithEvent

    var bidsData = MutableLiveData<List<BidsRegisteredResponse>>()
    var _bidsData: LiveData<List<BidsRegisteredResponse>> = bidsData

    private val addressInput: MutableLiveData<String?> = MutableLiveData()

    val postalCode = addressInput.switchMap { address: String? -> vehicleMediaModel_!!.getWebApiCalled_getResponse() }

    val postalCode1: LiveData<Any> = addressInput.switchMap { address: String? -> vehicleMediaModel_!!.getWebApiCalled_getResponse() }

    var userName = _bidsData.map { user: List<BidsRegisteredResponse> ->
        user[0].success.toString() + " " + user[0].success
    }

    fun userClicksOnButton(str: Boolean?) {

        _navigateWithEvent.value = EventLiveData(str) // Trigger the event by setting a new Event as a new value
    }

    fun FirstViewModel(mApplication: Context?) {
        vehicleMediaModel_ = VehicleMediaModel_Impl(object : OnFinishedListner {
            override fun onSuccess(body: Any?) {
                // responseBody.setValue(body);
            }

            override fun onError() {
                // responseBody.setValue(null);
            }

            override fun onFailure(t: Throwable) {
                //  responseBody.setValue("null");
            }
        })
        val mediatorLiveData1 = MediatorLiveData<String>()
    }

    fun addPlus() {
        a++
        strCount.value = a.toString() + ""
    }

    fun callApi() {
        //  responseBody=vehicleMediaModel_.getWebApiCalled_getResponse();
        //  vehicleMediaModel_.getWebApiCalled_getResponse();
        if (responseBody == null) {
            d(LogCalls_Debug.TAG, "callApi null")
            responseBody = vehicleMediaModel_!!.getWebApiCalled_getResponse()
        } else {
            d(LogCalls_Debug.TAG, "callApi")
            // Just call it, you already assigned before
            vehicleMediaModel_!!.getWebApiCalled_getResponse()
        }
    }

    fun getApiResponse(): MutableLiveData<Any>? {
        return responseBody
    }

    fun getNavigateToDetails(): LiveData<Boolean>? {
        return _navigateToNext
    }

    fun userClicksOnButton() {
        navigateToNext.value = true
    }

    class Factory(private val mApplication: Context) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return FirstViewModel(mApplication) as T
        }
    }
}
