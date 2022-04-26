package com.example.taskroadcast;

import static com.example.taskroadcast.LocationScreen.getBatteryPercentage;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyService extends Service {
    int tempOriginal ;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        createNotificationChannel();

        Intent intent1 = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent1,0);

        int bateryper = getBatteryPercentage(this);

        int temp = 0;
        String type;

        LocationScreen locationScreen = new LocationScreen();
        for (int i = 0; i < 29; i++) {
            temp = locationScreen.thermalTemp(i);
            if (temp != (0)) {
                type = locationScreen.thermalType(i);
                if (type != null) {
                    Log.d("ThermalValues "+type, String.valueOf(temp));

                    tempOriginal = temp;

                }
            }
        }

        Notification notification = new NotificationCompat.Builder(this,"ChannelId")
                .setContentTitle("Notification ")
                .setContentText("Battery Percentage = " + bateryper
                        + "\n" + "Temperature = " +tempOriginal)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent).build();

        startForeground(1,notification);
        return START_STICKY;

    }

    private void createNotificationChannel() {
        // if os is oreo or above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel("ChannelId",
                    "ForegroundNotification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(notificationChannel);
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        stopForeground(true);
        stopSelf();

        super.onDestroy();
    }
}
