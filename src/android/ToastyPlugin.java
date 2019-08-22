package com.stanleyidesis.cordova.plugin;
// The native Toast API
import android.widget.Toast;
// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class ToastyPlugin extends CordovaPlugin {

  private static final String DURATION_LONG = "long";
  boolean doubleBackToExitPressedOnce = false;
  
  @Override
  public boolean execute(String action, JSONArray args,final CallbackContext callbackContext) {

      Toast.makeText(this, "Holi", Toast.LENGTH_SHORT).show();
      return true;
  }

  

}
