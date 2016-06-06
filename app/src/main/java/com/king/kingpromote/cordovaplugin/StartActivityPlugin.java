package com.king.kingpromote.cordovaplugin;

import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by king.zhou on 2016/5/31.
 */
public class StartActivityPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("startActivityJs".equals(action)) {
            String activityName = args.getString(0);
            try {
                openActivity(activityName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            callbackContext.success("success");
            return true;
        }
        callbackContext.error("error");
        return false;
    }

    private void openActivity(String activityName) throws ClassNotFoundException {
        Intent intent = new Intent(cordova.getActivity(), Class.forName("com.king.kingpromote.activity."+activityName));
        cordova.getActivity().startActivity(intent);
    }
}
