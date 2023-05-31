package com.example.githubmvvm.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.githubmvvm.LogCalls_Debug
import com.example.githubmvvm.LogCalls_Debug.TAG
import com.example.githubmvvm.LogCalls_Debug.d
import com.example.githubmvvm.MainActivity
import com.example.githubmvvm.ViewModelFst.BidsRegisteredResponse
import com.example.githubmvvm.ViewModelFst.Vehicle
import com.example.githubmvvm.ViewModel_stuff.FirstViewModel
import com.example.githubmvvm.databinding.SecondFragmentBinding
import com.google.gson.Gson

class SecondFragment : Fragment() {
    private lateinit var viewModel: FirstViewModel
    var binding: SecondFragmentBinding? = null
    private var view: View? = null

    private var abc:String=   " "

    private var b:String=   " "
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SecondFragmentBinding.inflate(inflater, container, false)

        // Intializing widgtes
        view = binding!!.root

        // View Model with factory
        val factory = FirstViewModel.Factory(activity)
        viewModel = ViewModelProvider(requireActivity(), factory).get(FirstViewModel::class.java)

        binding!!.helloTextView.text = String.format("%d", viewModel.a)

        // click listener
        binding!!.submitButton.setOnClickListener { view: View? ->
            // cal view model method
            // viewModel.addPlus()
            binding!!.helloTextView.text = String.format("%d", viewModel.a)
            // viewModel.callApi();
            viewModel.setInput("")
        }

        // click listener

        // click listener
        binding!!.btnNext.setOnClickListener { view ->
            //  viewModel.userClicksOnButton()
            viewModel.userClicksOnButton(true)
        }

        return view
    }
  //  ./gradlew sonar

    fun repeatcode1(){
        LogCalls_Debug.d(TAG, "")
    }

    fun repeatcode2(){
        LogCalls_Debug.d(TAG,"")
        Log.d(TAG,"")
        val condition=true
        if (condition){
            LogCalls_Debug.d(TAG,"do nothing")
        }
        else{
            LogCalls_Debug.d(TAG,"do nothing")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.navigateToDetails.observe(viewLifecycleOwner, object : Observer<Boolean> {
//            override fun onChanged(value: Boolean) {
//                //  (activity as MainActivity?)!!.getFragment(FirstFragment())
//                viewModel.navigateToDetails.removeObserver(this)
//                d(LogCalls_Debug.TAG, " SecondFragment observeOnce ")
//            }
//        })

        // Live data observe

//        //Live data observe
//        viewModel.getNavigateToDetails().observe(getViewLifecycleOwner(), strCount -> {
//            if (strCount){
//                ((MainActivity) getActivity()).getFragment(new SecondFragment());
//            }
//        });

        viewModel.navigateWithEvent.observe(viewLifecycleOwner, {
            it.getContentIfNotHandled()?.let { // Only proceed if the event has never been handled
                (activity as MainActivity?)!!.getFragment(FirstFragment())
            }
            d(LogCalls_Debug.TAG, " navigateWithEvent ")
        })

        // Live data observe
        viewModel.strCount.observe(viewLifecycleOwner) { strCount: String? ->
            binding!!.nameTextView.text = strCount
        }
//        viewModel.responseBody.observe(viewLifecycleOwner) { objectReturn: Any? ->
//            val gson = Gson()
//            val jsonObject1 = gson.toJsonTree(objectReturn).asJsonObject
//            val response1 = gson.fromJson(jsonObject1, BidsRegisteredResponse::class.java)
//            binding!!.helloTextView.text = response1.toString() + ""
//            d(LogCalls_Debug.TAG + " SecondFragment Response 123", response1.toString())
//        }

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
        viewModel.postalCode1.observe(viewLifecycleOwner) { objectReturn: Any? ->
            val gson = Gson()
            val jsonObject1 = gson.toJsonTree(objectReturn).asJsonObject
            val response1 = gson.fromJson(
                jsonObject1,
                BidsRegisteredResponse::class.java
            )
            binding!!.helloTextView.text = response1.toString() + ""
            d(
                TAG + " SecondFragment  postalCode1",
                response1.toString()
            )
        }

        viewModel.getNewPremiumUsers().observe(viewLifecycleOwner, {
            d(LogCalls_Debug.TAG + " bidsTransformResponse ", "" + it.size)
            for (a in it.indices) {
                LogCalls_Debug.d(TAG, it[a].BidderID + " " + it[a].DealerTitle + " " + it[a].VIN)
            }
        })

//        viewModel.bidsTransformResponse.observe(viewLifecycleOwner, object : Observer<List<Vehicle?>?> {
//            fun onChanged(vehicles: List<Vehicle?>) {
//                    d(TAG + " FirstFragment Response bidsTransformResponse", "" + vehicles.size)
//                }
//            })

//        //Live data observe
//        viewModel.getNavigateToDetails().observe(getViewLifecycleOwner(), strCount -> {
//            if (strCount){
//                ((MainActivity) getActivity()).getFragment(new SecondFragment());
//            }
//        });

//        LiveData<Boolean> lD_NavDetail = viewModel.getNavigateToDetails();
//
//
//        observeOnce(lD_NavDetail, getViewLifecycleOwner(), it -> {
//           if ((Boolean) it){
//               ((MainActivity) getActivity()).getFragment(new SecondFragment());
//               LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG ,"observeOnce");
//           }
//       });
    }
}
