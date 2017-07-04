package com.anbetter.appbadger.demo;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import me.leolin.badger.helper.ShortcutBadger;

public class MainActivity extends AppCompatActivity {

    private  NotificationManager mNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String model = getModel();
        Log.i("MainActivity", "model = " + model);

        int badgeCount = 99;
        ShortcutBadger.applyCount(this, badgeCount);


//        // 小米手机，显示小红点
//        int badgeCount = 99;
//        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        Notification.Builder builder = new Notification.Builder(getApplicationContext())
//                .setContentTitle("小红点测试")
//                .setContentText("呵呵呵")
//                .setSmallIcon(R.mipmap.ic_launcher);
//        Notification notification = builder.build();
//        ShortcutBadger.applyNotification(getApplicationContext(), notification, badgeCount);
//        mNotificationManager.notify(1000, notification);
//
//        // 小米手机，清除小红点
//        mNotificationManager.cancelAll();

    }


    /**
     * 获取手机厂商和设备型号
     * @return
     */
    public String getModel() {
        return android.os.Build.MANUFACTURER + "|" // 手机厂商
                + android.os.Build.MODEL; // 型号;
    }

    @Override
    protected void onDestroy() {
        ShortcutBadger.removeCount(this);
        super.onDestroy();
    }

}
