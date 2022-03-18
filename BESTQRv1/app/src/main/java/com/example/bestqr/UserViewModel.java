package com.example.bestqr;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bestqr.Database;
import com.example.bestqr.Profile;
import com.example.bestqr.QRCODE;

import java.util.ArrayList;

public class UserViewModel extends ViewModel {

    private Profile user_profile;
    private MutableLiveData<String> mText;
    private Database db;

    public UserViewModel(){
        mText = new MutableLiveData<>();
        mText.setValue("Test");

    }

    /** Sets the main user profile
     * @param profile
     *      a profile object, containing info on a user
     */
    public void setUserProfile(Profile profile){
        user_profile = profile;
    }

    /** Gets the main user profile
     * @return profile
     *      a profile object, containing info on a user
     */
    public Profile getUserProfile(){
        return user_profile;
    }

}