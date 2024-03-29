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
import android.os.Handler;

public class ToastyPlugin extends CordovaPlugin {

  private static final String DURATION_LONG = "long";
  private boolean bandera = false;
	
  @Override
  public boolean execute(String action, JSONArray args,final CallbackContext callbackContext) {
     
    if (!action.equals("show")) {
      callbackContext.error("\"" + action + "\" is not a recognized action.");
      return false;
    }else{
      
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
      
      callToast(message,true);
      
      PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
      callbackContext.sendPluginResult(pluginResult);
      return true;
    }
}
	
  public void callToast(String valor, boolean recibido){
	 
	if(bandera){
	  Toast toast1 = Toast.makeText(cordova.getActivity(), "Presionaste 2 veces",Toast.LENGTH_SHORT);
      	toast1.show();  
	}  
	  
	  
	bandera = recibido;
	Toast toast1 = Toast.makeText(cordova.getActivity(), valor,Toast.LENGTH_SHORT);
      	toast1.show(); 
	
	  
	new Handler().postDelayed(new Runnable() {
		@Override
            public void run() {
                bandera = false;
            }
        }, 5000);  
	  
  	
  }
	
 
     
}
