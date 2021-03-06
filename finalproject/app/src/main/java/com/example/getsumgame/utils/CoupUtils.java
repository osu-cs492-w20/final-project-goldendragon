package com.example.getsumgame.utils;


import android.util.Log;

import com.example.getsumgame.models.CoupResult;
import com.google.gson.Gson;

import java.util.ArrayList;

public class CoupUtils {
    private static final String TAG = CoupUtils.class.getName();

    public static final String site = "https://chicken-coop.fr";
    private static final String path = "/rest/games/";
    public static final String queryTemplate = site + path + "???";

    public static String getQuery(String string){
        return site + path + string;
    }

    public static CoupResult parseJson(String json){
        // No Result Will be a returned null
        if(json.contains("No result")){
            Log.d(TAG, "No Result!");
            return null;
        }

        Gson gson = new Gson();
        try {
            CoupResult result = gson.fromJson(json, CoupResult.class);
            if (result != null && result.result != null) {
                return result;
            }
        }catch(IllegalStateException e){
            Log.e(TAG, e.toString());
        }
        Log.e(TAG, "Could not parse JSON String");
        Log.e(TAG, json);
        Log.e(TAG, "Try Again later!");
        return null;
    }
}
