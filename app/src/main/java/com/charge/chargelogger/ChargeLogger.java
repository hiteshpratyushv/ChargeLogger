package com.charge.chargelogger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.Date;

public class ChargeLogger extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent){
        Date currentTime;
        String action = intent.getAction();
        try {
            OutputStreamWriter out = new OutputStreamWriter(context.openFileOutput("save.txt", Context.MODE_APPEND));
            if(action.equals(Intent.ACTION_POWER_CONNECTED))
            {
                currentTime=Calendar.getInstance().getTime();
                out.append("Charger Connected : "+currentTime.toString()+"\n");
            }
            else if(action.equals(Intent.ACTION_POWER_DISCONNECTED))
            {
                currentTime=Calendar.getInstance().getTime();
                out.append("Charger Disconnected : "+currentTime.toString()+"\n");
            }
            out.close();
        }
        catch (Exception e)
        {
            Toast.makeText(context,"File Not Open",Toast.LENGTH_SHORT).show();
        }
    }
}
