package com.example.githubmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.githubmvvm.Fragment.SecondFragment;
import com.example.githubmvvm.ViewModel_stuff.FirstViewModel;
import com.example.githubmvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private Object object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //View binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //View Model with factory
        FirstViewModel.Factory factory = new FirstViewModel.Factory(getApplicationContext());
        FirstViewModel viewModel = new ViewModelProvider(this, factory).get(FirstViewModel.class);

       // viewModel.callApi();

        binding.helloTextView.setText(String.format("%d", viewModel.a));

        //Live data observe
        viewModel.strCount.observe(this, strCount -> {
            binding.nameTextView.setText(strCount);
        });

        //click listener
        binding.submitButton.setOnClickListener(view -> {
            //cal view model method
            viewModel.addPlus();

            binding.helloTextView.setText(String.format("%d", viewModel.a));

            viewModel.callApi();

        });

        //click listener
        binding.btnNext.setOnClickListener(view -> {
            getFragment(new SecondFragment());

        });


//        viewModel.getApiResponse().observe(this, objectReturn -> {
//            object = objectReturn;
//            LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG , "observe");
//            if (object == null) {
//                LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG + " jsonSender ", "object==null" + "");
//            }
//
//            if (object.equals(null)) {
//                LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG, " object.equals(null) ");
//            }
//
//            if (object.equals("null")) {
//                LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG + " jsonSender ", "object.equals(\"null\")" + "");
//            }
//
//
//            String strPUsh = "{\"phonetype\":\"N95\",\"cat\":\"WP\"}";
//            try {
//
//                String gson = new Gson().toJson(object);
//                String jsonSender = new Gson().toJson(object, new TypeToken<Object>() {
//                }.getType());
//
//             //  LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG + " jsonSender ", jsonSender + "");
//
//                String str = (String.valueOf(object));
//                JSONObject jsonObject = new JSONObject(jsonSender);
//                if (jsonObject.has("Nojson")) {
//                    LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG + " Nojson ", jsonObject + "");
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//
//            Gson gson = new Gson();
//            JsonElement jsonElement = gson.toJsonTree(object);
//
//           // LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG + " JsonElement ", jsonElement + "");
//
//            JsonObject jsonObject = jsonElement.getAsJsonObject();
//           // LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG + " jsonObject ", jsonObject + "");
//
//            BidsRegisteredResponse response = gson.fromJson(jsonObject, BidsRegisteredResponse.class);
//
//          //  LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG + " Response", response + "");
//            //  LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG +" Response", response.getVehicles().get(0).getName());
//
//            JsonObject jsonObject1 = gson.toJsonTree(object).getAsJsonObject();
//            BidsRegisteredResponse response1 = gson.fromJson(jsonObject1, BidsRegisteredResponse.class);
//
//            binding.helloTextView.setText(response + "");
//            LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG + " Response MainActivity123", String.valueOf(response1));
//        });




    }

    public void getFragment(Fragment fragment) {

        try {

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLay_Fragment, fragment, "CURRENT_TAG");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        } catch (Exception nu) {
            Log.d("Json", "run: Drawr" + nu.getMessage());
            //log.d("Null pointer", "Fragment");
        }

    }
}
