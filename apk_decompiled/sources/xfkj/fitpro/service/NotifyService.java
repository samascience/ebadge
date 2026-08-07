package xfkj.fitpro.service;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.view.View;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.legend.smartwatch.electronicbadge.android.R;
import com.seeker.luckychart.animation.ChartCoordinateportAnimator;
import com.tencent.connect.common.Constants;
import defpackage.as1;
import defpackage.d20;
import defpackage.fn2;
import defpackage.hg;
import defpackage.oc1;
import defpackage.pv2;
import defpackage.qm2;
import defpackage.rj2;
import defpackage.u73;
import defpackage.vi2;
import defpackage.wj;
import defpackage.zi2;
import defpackage.zm1;
import java.io.UnsupportedEncodingException;
import java.util.List;
import xfkj.fitpro.service.NotifyService;

/* JADX INFO: loaded from: classes4.dex */
public class NotifyService extends NotificationListenerService {
    private static String c = "";
    private static NotifyService d = null;
    private static long e = 0;
    private static int f = 50;
    private static long g = 0;
    private static int h = 50;
    private static long i = 0;
    private static int j = 50;
    private String a = Constants.STR_EMPTY;
    private wj b;

    public static NotifyService c() {
        return d;
    }

    public static String e(String str, int i2) {
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder(i2);
        for (int i3 = 0; i3 < charArray.length && i2 > 0; i3++) {
            String strValueOf = String.valueOf(charArray[i3]);
            if (strValueOf.getBytes().length > 1) {
                i2 -= 2;
                if (i2 < 0) {
                    break;
                }
            } else {
                i2--;
            }
            sb.append(strValueOf);
        }
        return sb.toString();
    }

    public static boolean f(Context context) {
        try {
            Intent intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
            intent.addFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e2) {
            try {
                Intent intent2 = new Intent();
                intent2.addFlags(268435456);
                intent2.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$NotificationAccessSettingsActivity"));
                intent2.putExtra(":settings:show_fragment", "NotificationAccessSettings");
                context.startActivity(intent2);
                return true;
            } catch (Exception e3) {
                e3.printStackTrace();
                e2.printStackTrace();
                return false;
            }
        }
    }

    private static boolean g() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - g <= h) {
            return true;
        }
        g = jCurrentTimeMillis;
        return false;
    }

    private static boolean h() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - i <= j) {
            return true;
        }
        i = jCurrentTimeMillis;
        return false;
    }

    private static boolean i() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - e <= f) {
            return true;
        }
        e = jCurrentTimeMillis;
        return false;
    }

    public static boolean j(Context context) {
        return as1.e(context).contains(context.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(vi2 vi2Var, Context context, View view) {
        vi2Var.cancel();
        if (j(context)) {
            return;
        }
        f(context);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void m(String str, String str2, int i2) {
        byte[] bArr;
        byte[] bytes;
        str.hashCode();
        int i3 = 1;
        String strD = "1";
        byte b = -1;
        switch (str.hashCode()) {
            case -2103713194:
                if (str.equals("com.whatsapp.w4b")) {
                    b = 0;
                }
                break;
            case -2099846372:
                if (str.equals("com.skype.raider")) {
                    b = 1;
                }
                break;
            case -1547699361:
                if (str.equals("com.whatsapp")) {
                    b = 2;
                }
                break;
            case -1521143749:
                if (str.equals("jp.naver.line.android")) {
                    b = 3;
                }
                break;
            case -973170826:
                if (str.equals("com.tencent.mm")) {
                    b = 4;
                }
                break;
            case -795078266:
                if (str.equals("app.mms")) {
                    b = 5;
                }
                break;
            case -662003450:
                if (str.equals("com.instagram.android")) {
                    b = 6;
                }
                break;
            case -84117604:
                if (str.equals("com.android.incallui_deldel")) {
                    b = 7;
                }
                break;
            case 10619783:
                if (str.equals("com.twitter.android")) {
                    b = 8;
                }
                break;
            case 361910168:
                if (str.equals("com.tencent.mobileqq")) {
                    b = 9;
                }
                break;
            case 714499313:
                if (str.equals("com.facebook.katana")) {
                    b = 10;
                }
                break;
            case 908140028:
                if (str.equals("com.facebook.orca")) {
                    b = AttrAndFunCode.SYS_INFO_ATTR_HIGH_AND_BASS;
                }
                break;
            case 1153658444:
                if (str.equals("com.linkedin.android")) {
                    b = AttrAndFunCode.SYS_INFO_ATTR_EQ_PRESET_VALUE;
                }
                break;
            case 1249065348:
                if (str.equals("com.kakao.talk")) {
                    b = AttrAndFunCode.SYS_INFO_ATTR_CURRENT_NOISE_MODE;
                }
                break;
        }
        switch (b) {
            case 0:
            case 2:
                if (i()) {
                    Log.i("NotifyService", "whatsApp data is fast!");
                    return;
                } else {
                    strD = rj2.d("WatsappState", "1");
                    bArr = new byte[]{8, 0, 0};
                    Log.i("NotifyService", "Watsapp!");
                }
                break;
            case 1:
                if (h()) {
                    Log.i("NotifyService", "Skype data is fast!");
                    return;
                } else {
                    strD = rj2.d("SkypeState", "1");
                    bArr = new byte[]{6, 0, 0};
                    Log.i("NotifyService", "Skype!");
                }
                break;
            case 3:
                if (g()) {
                    Log.i("NotifyService", "line data is fast!");
                    return;
                } else {
                    strD = rj2.d("LineState", "1");
                    bArr = new byte[]{7, 0, 0};
                    Log.i("NotifyService", "Line!");
                }
                break;
            case 4:
                Log.i("NotifyService", "微信信息!");
                bArr = new byte[]{3, 0, 0};
                strD = rj2.d("WECHATState", "1");
                break;
            case 5:
                strD = rj2.d("SMSState", "1");
                bArr = new byte[]{1, 0, 0};
                Log.i("NotifyService", "正在发送短信!");
                break;
            case 6:
                strD = rj2.d("INSTAGRAMState", "1");
                bArr = new byte[]{AttrAndFunCode.SYS_INFO_ATTR_FIXED_LEN_DATA_FUN, 0, 0};
                Log.i("NotifyService", "INSTAGRAM!");
                break;
            case 7:
                strD = zm1.I() ? "1" : rj2.d("CALLState", "1");
                if (i2 == 1) {
                    bArr = new byte[]{1, 0};
                } else if (i2 == 2) {
                    bArr = new byte[]{2, 0};
                } else {
                    bArr = i2 == 0 ? new byte[]{0, 0} : null;
                }
                Log.i("NotifyService", "电话信息!");
                i3 = 0;
                break;
            case 8:
                strD = rj2.d("TwitterState", "1");
                bArr = new byte[]{5, 0, 0};
                Log.i("NotifyService", "Twitter!");
                break;
            case 9:
                Log.i("NotifyService", "QQ信息!");
                strD = rj2.d("QQState", "1");
                bArr = new byte[]{2, 0, 0};
                break;
            case 10:
            case 11:
                strD = rj2.d("FaceBookState", "1");
                bArr = new byte[]{4, 0, 0};
                Log.i("NotifyService", "FaceBook!");
                break;
            case 12:
                strD = rj2.d("linkdedInState", "1");
                bArr = new byte[]{AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD_EQ_FREQ, 0, 0};
                Log.i("NotifyService", "LINKEDIN!");
                break;
            case 13:
                strD = rj2.d("KakaoTalkState", "1");
                bArr = new byte[]{9, 0, 0};
                Log.i("NotifyService", "KakaoTalkState!");
                break;
            default:
                bArr = null;
                break;
        }
        if (bArr == null || bArr.length <= 0 || str2 == Constants.STR_EMPTY || str2 == null) {
            return;
        }
        String strE = e(str2, ChartCoordinateportAnimator.FAST_ANIMATION_DURATION);
        hg.b("NotifyService", "开关状态 " + strD + "--ID : 内容：" + strE + "--包名：" + str);
        if (strD.equals("0") || strD == "0") {
            return;
        }
        try {
            bytes = strE.getBytes(Constants.ENC_UTF_8);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            bytes = null;
        }
        byte[] bArr2 = new byte[bArr.length + bytes.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(bytes, 0, bArr2, bArr.length, bytes.length);
        zi2.o(qm2.z(i3, bArr2), "发送(" + str + ")推送命令");
    }

    public static void n(final Context context) {
        if (j(context)) {
            return;
        }
        final vi2 vi2Var = new vi2(context);
        vi2Var.h(u73.b(R.string.read_notifi_permission));
        vi2Var.f(u73.b(R.string.is_open_notifi_permission));
        vi2Var.e(u73.b(R.string.cancel));
        vi2Var.g(u73.b(R.string.open));
        vi2Var.setCancelable(false);
        vi2Var.c().setOnClickListener(new View.OnClickListener() { // from class: cs1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotifyService.k(vi2Var, context, view);
            }
        });
        vi2Var.b().setOnClickListener(new View.OnClickListener() { // from class: ds1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                vi2Var.cancel();
            }
        });
        vi2Var.show();
    }

    public static void o(Context context) {
        PackageManager packageManager = context.getPackageManager();
        packageManager.setComponentEnabledSetting(new ComponentName(context, (Class<?>) NotifyService.class), 2, 1);
        packageManager.setComponentEnabledSetting(new ComponentName(context, (Class<?>) NotifyService.class), 1, 1);
    }

    public String d() {
        PackageManager packageManager = getPackageManager();
        Intent intent = new Intent();
        intent.setAction("android.provider.Telephony.SMS_DELIVER");
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 32);
        return (listQueryBroadcastReceivers == null || listQueryBroadcastReceivers.size() <= 0) ? Constants.STR_EMPTY : listQueryBroadcastReceivers.get(0).activityInfo.packageName;
    }

    @Override // android.app.Service
    public void onCreate() {
        hg.b("NotifyService", "----NotificationListenerService-------启动状态栏通知服务----");
        d = this;
        super.onCreate();
        fn2.d(this);
        this.b = wj.m();
        c = d();
        hg.b("-----------getSmsApps()-------", "----------smsapp---------" + c);
    }

    @Override // android.service.notification.NotificationListenerService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        d = null;
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        super.onNotificationPosted(statusBarNotification);
        String packageName = statusBarNotification.getPackageName();
        if (statusBarNotification.getPackageName().isEmpty()) {
            return;
        }
        Bundle bundle = statusBarNotification.getNotification().extras;
        String string = bundle.getString("android.title");
        CharSequence charSequence = bundle.getCharSequence("android.text");
        CharSequence charSequence2 = bundle.getCharSequence("android.subText");
        boolean zF = pv2.f(string);
        String str = Constants.STR_EMPTY;
        if (!zF) {
            str = Constants.STR_EMPTY + string + d20.l;
            Log.e("NotifyService", "notificationTitle:" + string);
        }
        if (!pv2.f(charSequence)) {
            str = str + charSequence.toString();
            Log.e("NotifyService", "notificationText:" + ((Object) charSequence));
        }
        if (!pv2.f(charSequence2)) {
            str = str + charSequence2.toString();
            Log.e("NotifyService", "notificationSubText:" + ((Object) charSequence2));
        }
        if (packageName.equals("com.android.incallui")) {
            this.a = str;
        }
        hg.b("NotifyService", "状态栏收到消息是 --ID :" + statusBarNotification.getId() + "--内容：" + str + "--包名：" + packageName);
        m(packageName, str, 0);
        oc1.b(this).d(new Intent("notify_posted"));
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification statusBarNotification) {
        super.onNotificationRemoved(statusBarNotification);
        if (statusBarNotification != null) {
            hg.b("NotifyService", "状态栏清除消息是   --ID :" + statusBarNotification.getId() + "--内容：-----" + ((Object) statusBarNotification.getNotification().tickerText) + "--包名：" + statusBarNotification.getPackageName());
        }
        oc1.b(this).d(new Intent("notify_removed"));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        return 1;
    }
}
