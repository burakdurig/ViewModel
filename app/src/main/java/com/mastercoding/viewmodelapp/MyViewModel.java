package com.mastercoding.viewmodelapp;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    //int counter = 0;
    // above is without live data, below is with live data
    private MutableLiveData<Integer> counter = new MutableLiveData<>();

    // this will hep to redude chance of memory leaks.

    // since we got rid of the onclick listeners in the main we are going to add the View view as an input.
    // this would require a creation of a data variable within the xml.
    public void increaseCounter(View view){
        //counter++;
        // above is part of non live data
        int currentValue = counter.getValue() != null ? counter.getValue():0;
        // if the above counter.getValue() does not equal null, then set it to 0.
        // the above is to prevent non-null exemptions. or the above will initialize
        // if not already initialized

        //the getvalue and setValue are part of the livedata.

        counter.setValue(currentValue+1);
    }

    public LiveData<Integer> getCounter(){
        return counter;

        // replace the int return type to LiveData<Integer>
    }

}
