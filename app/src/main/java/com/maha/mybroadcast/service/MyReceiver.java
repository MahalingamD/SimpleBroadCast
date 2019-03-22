package com.maha.mybroadcast.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

   public static final String TAG = MyReceiver.class.getSimpleName();

   @Override
   public void onReceive( Context context, Intent intent ) {
      Toast.makeText( context, "Broadcast start", Toast.LENGTH_SHORT ).show();
      Log.e( TAG, "onReceive: ");
   }

}
