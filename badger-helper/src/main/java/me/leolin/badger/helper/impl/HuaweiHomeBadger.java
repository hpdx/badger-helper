package me.leolin.badger.helper.impl;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

import me.leolin.badger.helper.Badger;
import me.leolin.badger.helper.exception.ShortcutBadgeException;


/**
 * @author Jason Ling
 */
public class HuaweiHomeBadger extends Badger {

    private final Uri CONTENT_URI = Uri.parse("content://com.huawei.android.launcher.settings/badge/");

    @Override
    public void executeBadge(Context context, ComponentName componentName, int badgeCount) throws ShortcutBadgeException {
        Bundle localBundle = new Bundle();
        localBundle.putString("package", context.getPackageName());
        localBundle.putString("class", componentName.getClassName());
        localBundle.putInt("badgenumber", badgeCount);
        context.getContentResolver().call(CONTENT_URI, "change_badge", null, localBundle);
    }

    @Override
    public List<String> getSupportLaunchers() {
        return Arrays.asList("com.huawei.android.launcher");
    }

}
