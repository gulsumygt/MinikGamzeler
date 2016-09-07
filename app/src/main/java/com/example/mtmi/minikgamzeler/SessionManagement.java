package com.example.mtmi.minikgamzeler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by glsmy on 30.08.2016.
 */
public class SessionManagement {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context mContext;
    int PRIVATE_MODE=0;

    private  static final String PREF_NAME="MinikGamzelerPref";
    private static final String IS_LOGIN="isLoggedIn";
    public static final String KEY_NAME="name";
    public static final String KEY_EMAIL="email";

    public SessionManagement(Context context){
        this.mContext=context;
        pref=mContext.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor=pref.edit();
    }

    public void createLoginSession(String name,String email){
        editor.putBoolean(IS_LOGIN,true);
        editor.putString(KEY_NAME,name);
        editor.putString(KEY_EMAIL,email);

        editor.apply();
    }

    public HashMap<String,String> gerUserDetail(){
        HashMap<String,String> user =new HashMap<String, String>();
        user.put(KEY_NAME,pref.getString(KEY_NAME,null));
        user.put(KEY_EMAIL,pref.getString(KEY_EMAIL,null));
        return  user;
    }

    public void checkLogin(){
        if(!this.isloggedIn()){
            Intent intent=new Intent(mContext,LoginActivity.class);

            // Closing all the Activities
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        }
        else{
            Intent intent=new Intent(mContext,MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        }
    }

    public void logoutUser(){
        //clear all data from sharedpreferences
        editor.clear();
        editor.apply();

        //after logout redirect user MainActivity

        Intent intent=new Intent(mContext,LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);

    }
    public boolean isloggedIn(){
        return pref.getBoolean(IS_LOGIN,false);
    }
}
