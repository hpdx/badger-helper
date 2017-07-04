package me.leolin.badger.helper.impl;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import me.leolin.badger.helper.Badger;
import me.leolin.badger.helper.exception.ShortcutBadgeException;


public class ZTEHomeBadger extends Badger {

    private final Uri CONTENT_URI = Uri.parse("content://com.android.launcher3.cornermark.unreadbadge");

    @Override
    public void executeBadge(Context context, ComponentName componentName, int badgeCount)
            throws ShortcutBadgeException {
        Bundle extra = new Bundle();
        extra.putInt("app_badge_count", badgeCount);
        extra.putString("app_badge_component_name", componentName.flattenToString());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            context.getContentResolver().call(CONTENT_URI, "setAppUnreadCount", null, extra);
        }
    }

    @Override
    public List<String> getSupportLaunchers() {
        return new ArrayList<String>(0);
    }

} 

