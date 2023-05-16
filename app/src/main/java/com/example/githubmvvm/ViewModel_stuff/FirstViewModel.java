package com.example.githubmvvm.ViewModel_stuff;

import android.content.Context;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.githubmvvm.LogCalls_Debug;
import com.example.githubmvvm.Utils.EventLiveData;
import com.example.githubmvvm.ViewModelFst.BidsRegisteredResponse;
import com.example.githubmvvm.ViewModelFst.Vehicle;
import com.example.githubmvvm.ViewModelFst.VehicleMediaModel_Impl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.example.githubmvvm.Network_Stuff.OnFinishedListner;

import java.util.List;

public class FirstViewModel extends ViewModel {
    public int a = 0;

    VehicleMediaModel_Impl vehicleMediaModel_;
    public MutableLiveData<Object> responseBody;

    public MutableLiveData<String> strCount = new MutableLiveData<>();


    ///navigation data
    private final MutableLiveData<EventLiveData<Boolean>> _navigateWithEvent = new MutableLiveData<>();
    public LiveData<EventLiveData<Boolean>> navigateWithEvent = _navigateWithEvent;

    ///bids registered data
    public MutableLiveData<List<BidsRegisteredResponse>> bidsData = new MutableLiveData<>();
    public LiveData<List<BidsRegisteredResponse>> _bidsData = bidsData;


    private final MutableLiveData<String> addressInput = new MutableLiveData();


    public final LiveData<Object> postalCode1 = Transformations.switchMap(addressInput, address ->
            vehicleMediaModel_.getWebApiCalled_getResponse());


    LiveData<String> userName = Transformations.map(_bidsData, user ->
            user.get(0).getSuccess() + " " + user.get(0).getSuccess()
    );

    public LiveData<List<Vehicle>> getNewPremiumUsers() {
        return Transformations.map(vehicleMediaModel_.getWebApiCalled_getResponse(),
                // This is an expensive call being made on the main thread and may cause
                // noticeable jank in the UI!
                users -> getREsponse(users));
    }
//    public LiveData<List<Vehicle>> bidsTransformResponse = Transformations.map(postalCode1, user -> {
//
//                return getREsponse(postalCode1);
//            });


    private List<Vehicle> getREsponse(Object object) {
        Gson gson = new Gson();
        JsonObject jsonObject1 = gson.toJsonTree(object).getAsJsonObject();
        BidsRegisteredResponse response1 = gson.fromJson(jsonObject1, BidsRegisteredResponse.class);
        return response1.getVehicles();
    }

    public void userClicksOnButton(Boolean str) {
        _navigateWithEvent.setValue(new EventLiveData(str));   // Trigger the event by setting a new Event as a new value

    }


    public FirstViewModel(Context mApplication) {
        vehicleMediaModel_ = new VehicleMediaModel_Impl(new OnFinishedListner() {
            @Override
            public void onSuccess(@Nullable Object body) {
                //responseBody.setValue(body);
            }

            @Override
            public void onError() {
                // responseBody.setValue(null);

            }

            @Override
            public void onFailure(@NonNull Throwable t) {
                //  responseBody.setValue("null");
            }
        });
        MediatorLiveData<String> mediatorLiveData1 = new MediatorLiveData<>();

    }

    public void addPlus() {
        a++;
        strCount.setValue(a + "");
    }

    public void callApi() {

        //  responseBody=vehicleMediaModel_.getWebApiCalled_getResponse();
        //  vehicleMediaModel_.getWebApiCalled_getResponse();

        if (responseBody == null) {
            LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG, "callApi null");
            responseBody = vehicleMediaModel_.getWebApiCalled_getResponse();
        } else {
            LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG, "callApi");
            // Just call it, you already assigned before
            vehicleMediaModel_.getWebApiCalled_getResponse();
        }


//        Gson gson = new Gson();
//        JsonObject jsonObject1 = gson.toJsonTree(responseBody).getAsJsonObject();
//        BidsRegisteredResponse response1 = gson.fromJson(jsonObject1, BidsRegisteredResponse.class);
       // bidResponse = response1;
    }

    public MutableLiveData<Object> getApiResponse() {
        return responseBody;
    }



    public void setInput(String address) {
        addressInput.setValue(address);
    }




    public static class Factory extends ViewModelProvider.NewInstanceFactory {
        @NonNull
        private final Context mApplication;

        public Factory(Context application) {
            mApplication = application;
        }

        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new FirstViewModel(mApplication);
        }

    }

}
