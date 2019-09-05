package com.example.mvvm_intership;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NumberViewModel extends ViewModel {
    private MutableLiveData<Integer> number;
    private Integer num=0;
    public MutableLiveData<Integer> getNumber(){
        if (number==null){
            number=new MutableLiveData<Integer>();
        }
        return number;
    }

    public void increment(){
        number.setValue(++num);
    }

    public void decremetn(){
        number.setValue(--num);
    }

}
