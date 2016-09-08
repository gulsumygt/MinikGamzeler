package com.example.mtmi.minikgamzeler;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by glsmy on 28.08.2016.
 */
public class IntroManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context mContext;

    public IntroManager(Context context){
        this.mContext=context;
        pref = mContext.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public void setFirst(boolean isFirst){



        editor.putBoolean("check",isFirst);
        editor.commit();
    }

    public  boolean Check(){

        return pref.getBoolean("check",true);
    }
}
