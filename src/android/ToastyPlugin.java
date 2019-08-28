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
 
  @Override
  public boolean execute(String action, JSONArray args,final CallbackContext callbackContext) {
     
    if (!action.equals("show")) {
      callbackContext.error("\"" + action + "\" is not a recognized action.");
      return false;
    }else{
      
      Toast toast1 = Toast.makeText(cordova.getActivity(), "Call BackPressedPlugin !",Toast.LENGTH_SHORT);
      toast1.show();
      
      String message;
      String duration;
      try {
        JSONObject options = args.getJSONObject(0);
        message = options.getString("message");
        duration = options.getString("duration");
      } catch (JSONException e) {
        callbackContext.error("Error encountered: " + e.getMessage());
        return false;
      }
      
      callToast(message);
      
      PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
      callbackContext.sendPluginResult(pluginResult);
      return true;
    }
	
	}
	
	public void callToast(String valor){
  
    Toast toast1 = Toast.makeText(cordova.getActivity(), "Callll BackPressedPlugin !",Toast.LENGTH_SHORT);
      toast1.show();
  
	}
     
  }
