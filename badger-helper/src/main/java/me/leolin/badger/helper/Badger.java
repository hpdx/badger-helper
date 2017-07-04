package me.leolin.badger.helper;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import java.util.List;

import me.leolin.badger.helper.exception.ShortcutBadgeException;

public abstract class Badger {

    /**
     * Called when user attempts to update notification count
     *
     * @param context       Caller context
     * @param componentName Component containing package and class name of calling application's
     *                      launcher activity
     * @param badgeCount    Desired notification count
     * @throws ShortcutBadgeException
     */
    public abstract void executeBadge(Context context, ComponentName componentName, int badgeCount) throws ShortcutBadgeException;

    /**
     * Called to let {@link ShortcutBadger} knows which launchers are supported by this badger. It should return a
     *
     * @return List containing supported launchers package names
     */
    public abstract List<String> getSupportLaunchers();

    public boolean canResolveBroadcast(Context context, Intent intent) {
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> receivers = packageManager.queryBroadcastReceivers(intent, 0);
        return receivers != null && receivers.size() > 0;
    }

}
