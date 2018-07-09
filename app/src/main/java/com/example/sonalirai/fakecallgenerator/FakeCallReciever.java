package com.example.sonalirai.fakecallgenerator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Sonali Rai on 7/9/2018.
 */

class FakeCallReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String name=intent.getStringExtra("Name");
        String number=intent.getStringExtra("Number");
        Intent intentObj = new Intent(context.getApplicationContext(),FakeRingingActivity.class);
        intentObj.putExtra("Name", name);
        intentObj.putExtra("Number", number);
        context.startActivity(intentObj);
    }
}
