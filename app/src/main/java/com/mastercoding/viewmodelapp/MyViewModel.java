package com.mastercoding.viewmodelapp;

import android.view.View;

import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    int counter = 0;

    public void increaseCounter(){
        counter++;
    }

    public int getCounter(){
        return counter;
    }

}
