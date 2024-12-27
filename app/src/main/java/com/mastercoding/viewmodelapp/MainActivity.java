package com.mastercoding.viewmodelapp;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.mastercoding.viewmodelapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    MyViewModel viewModel;
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);

        viewModel = new ViewModelProvider(this)
                .get(MyViewModel.class);

        mainBinding.setMyviewmodel(viewModel);



        //We can get rid of the below on click listners since we are using databinding.
//        mainBinding.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewModel.increaseCounter();
//                //mainBinding.textView2.setText(""+viewModel.getCounter());
//                // if the above is not used or commented out the counter will never display
//                // to resolve this we need live data
//            }
//        });
        // without the empty string, "", the application will fail because the viewmodel is int
        // and you can't set a string type to int
        //mainBinding.textView2.setText(""+viewModel.getCounter());
        // the above also needs to be commented out or otherwise you get failures.

        // Observing the LiveData
        viewModel.getCounter().observe(this,
                new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer counter) {
                        // update the UI when the LiveData changes
                        mainBinding.textView2.setText(""+counter);
                    }
                });
    }
}