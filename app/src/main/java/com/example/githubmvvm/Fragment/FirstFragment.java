package com.example.githubmvvm.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.githubmvvm.LogCalls_Debug;
import com.example.githubmvvm.MainActivity;
import com.example.githubmvvm.Utils.EventLiveData;
import com.example.githubmvvm.Utils.LiveDataUtil;
import com.example.githubmvvm.Utils.LiveDataUtils;
import com.example.githubmvvm.ViewModelFst.BidsRegisteredResponse;
import com.example.githubmvvm.ViewModelFst.Vehicle;
import com.example.githubmvvm.ViewModel_Stuff.FirstViewModel;
import com.example.githubmvvm.databinding.FirstFragmentBinding;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import kotlin.jvm.internal.Intrinsics;

public class FirstFragment extends Fragment {

    FirstFragmentBinding binding;
    private View view;
    private View view1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FirstFragmentBinding.inflate(inflater, container, false);

        //Intializing widgtes
        view = binding.getRoot();


        //View Model with factory
        FirstViewModel.Factory factory = new FirstViewModel.Factory(getActivity());
        FirstViewModel viewModel = new ViewModelProvider(requireActivity(), factory).get(FirstViewModel.class);

         //viewModel.callApi();

        binding.helloTextView.setText(String.format("%d", viewModel.a));


        //click listener
        binding.submitButton.setOnClickListener(view -> {
            //cal view model method
            viewModel.addPlus();

            binding.helloTextView.setText(String.format("%d", viewModel.a));

            //viewModel.callApi();
            viewModel.setInput("");

        });

        //click listener
        binding.btnNext.setOnClickListener(view -> {

          //  ((MainActivity) getActivity()).getFragment(new SecondFragment());

        });



//        //Live data observe
//        viewModel.getNavigateToDetails().observe(getViewLifecycleOwner(), strCount -> {
//            if (strCount){
//                ((MainActivity) getActivity()).getFragment(new SecondFragment());
//            }
//        });


        viewModel.navigateWithEvent.observe(getViewLifecycleOwner(), new Observer<EventLiveData<Boolean>>() {
            @Override
            public void onChanged(EventLiveData<Boolean> booleanEventLiveData) {

            }
        });

                //Live data observe
        viewModel.strCount.observe(getViewLifecycleOwner(), strCount -> {
            binding.nameTextView.setText(strCount);
        });

//        viewModel.responseBody.observe(getViewLifecycleOwner(), objectReturn -> {
//
//            Gson gson = new Gson();
//
//            JsonObject jsonObject1 = gson.toJsonTree(objectReturn).getAsJsonObject();
//            BidsRegisteredResponse response1 = gson.fromJson(jsonObject1, BidsRegisteredResponse.class);
//
//            binding.helloTextView.setText(response1 + "");
//            LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG + " FirstFragment Response 123", String.valueOf(response1));
//        });

        viewModel.postalCode1.observe(getViewLifecycleOwner(), objectReturn -> {

            Gson gson = new Gson();

            JsonObject jsonObject1 = gson.toJsonTree(objectReturn).getAsJsonObject();
            BidsRegisteredResponse response1 = gson.fromJson(jsonObject1, BidsRegisteredResponse.class);

            binding.helloTextView.setText(response1 + "");
            LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG + " FirstFragment Response postalCode1", String.valueOf(response1));
        });

//        viewModel.bidsTransformResponse.observe(getViewLifecycleOwner(), new Observer<List<Vehicle>>() {
//            @Override
//            public void onChanged(List<Vehicle> vehicles) {
//                LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG + " FirstFragment Response bidsTransformResponse", ""+vehicles.size());
//            }
//        });
        return view;
    }

    private void repeatcode1() {
        LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG, "");
    }

    public void repeatcode2(){
        LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG,"");
        LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG,"");
        Boolean condition=true;
        if (condition){
            LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG,"do nothing");
        }
        else{
            LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG,"do nothing");
        }
    }

}
