package com.example.wheelsapp.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wheelsapp.MainActivity2;

public class ProfileViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<String> mTextEmail;

    public ProfileViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(MainActivity2.getUser().getName()+" "+MainActivity2.getUser().getLastName());

        mTextEmail = new MutableLiveData<>();
        mTextEmail.setValue(MainActivity2.getUser().getEmail());
    }


    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<String> getTextEmail() {
        return mTextEmail;
    }
}