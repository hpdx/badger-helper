# badger-helper
Android在桌面图标上显示角标

## 使用：
在build.gradle文件里，添加以下依赖：
```
 allprojects {
    repositories {
        jcenter()

        maven {
            url 'https://dl.bintray.com/hpdx/maven/'
        }
    }
 }

compile 'com.anbetter:badger-helper:1.0.0'
```

1、在app icon上显示角标（未读消息数）
```
   int badgeCount = 99;
   ShortcutBadger.applyCount(this, badgeCount);
```

2、消掉app icon上显示的角标
```
  ShortcutBadger.removeCount(this); // context
```

小米手机（app icon上显示的角标，未读消息数是跟着通知消息算的）

1、在app icon上显示角标（未读消息数）
```
        int badgeCount = 99;
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(getApplicationContext())
                .setContentTitle("小红点测试")
                .setContentText("呵呵呵")
                .setSmallIcon(R.mipmap.ic_launcher);
        Notification notification = builder.build();
        ShortcutBadger.applyNotification(getApplicationContext(), notification, badgeCount);
        mNotificationManager.notify(1000, notification);

```

2、消掉app icon上显示的角标

```
mNotificationManager.cancelAll();
```

## 目前已测试的手机机型及角标支持情况（使用公司提供的测试机，亲测结果如下），欢迎大家补充和完善该库

### 1、支持的厂商及设备型号

    HUAWEI|EVA-AL00
    HUAWEI|HUAWEI VNS-TL00

    samsung|SM-A9100 (GALAXY A9)
    samsung|SM-N9006
    samsung|SM-G9300
    samsung|SM-N9200 (GALAXY Note5)
    samsung|GT-I9500 (S4)

    Xiaomi|MI 5
    Xiaomi|MI 4LTE
    Xiaomi|2014813（红米）
    Xiaomi|MI MAX
    Xiaomi|Mi-4c

    HTC|HTC E9w


### 2、不支持的厂商及设备型号

    Meitu|MP1512(不支持)
    Meizu|m1 metal (不支持)
    Coolpad|Coolpad Y803-9 (不支持)
    LeMobile|Le X620 (不支持)
    smartisan|SM801 (不支持)

    OPPO角标提醒目前只针对内部软件还有微信、QQ开放，在手机设置-->通知与状态栏-->通知管理里设置-->app-->允许通知
    （微信：在桌面图标上显示角标，其它app无该选项）
    OPPO|OPPO R9s (不支持)
    OPPO|OPPO A37m (不支持)

    LGE|Nexus 5X (不支持，Google官方的手机，Android原生系统launcher就是不支持角标的)


## thanks
核心代码都来自这个库，我只做了部分调整，自己维护了一个版本。
[https://github.com/leolin310148/ShortcutBadger](https://github.com/leolin310148/ShortcutBadger)