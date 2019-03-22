package com.maha.mybroadcast;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.maha.mybroadcast.service.MyReceiver;

public class MainActivity extends AppCompatActivity {

   Button mButton;
   MyReceiver receiver;
   IntentFilter filter;

   @Override
   protected void onCreate( Bundle savedInstanceState ) {
      super.onCreate( savedInstanceState );
      setContentView( R.layout.activity_main );

      init();

      receiver = new MyReceiver();
      filter = new IntentFilter( "com.example.CUSTOM_INTENT" );
   }

   private void init() {
      mButton = findViewById( R.id.Broad_cast_Button );

      mButton.setOnClickListener( new View.OnClickListener() {
         @Override
         public void onClick( View view ) {

            if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ) {
               //IntentFilter filter = new IntentFilter( "com.example.CUSTOM_INTENT" );
               Intent intent = new Intent();
               intent.setAction( "com.example.CUSTOM_INTENT" );
               getApplicationContext().sendBroadcast( intent );

            } else {
               Intent intent = new Intent();
               intent.setAction( "com.example.CUSTOM_INTENT" );
               MainActivity.this.sendBroadcast( intent );
            }

         }
      } );
   }

   @Override
   protected void onPause() {
      super.onPause();
      unregisterReceiver( receiver );
   }

   @Override
   protected void onResume() {
      super.onResume();
      registerReceiver( receiver, filter );
   }
}
