package xfkj.fitpro.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import com.tencent.connect.common.Constants;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class NotificationClickReceiver extends BroadcastReceiver {
    public static Intent a(Context context, String str) {
        String strB = b(context, str);
        if (c(strB)) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setClassName(str, strB);
        return intent.addFlags(268435456);
    }

    public static String b(Context context, String str) {
        if (c(str)) {
            return Constants.STR_EMPTY;
        }
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        return (listQueryIntentActivities == null || listQueryIntentActivities.size() == 0) ? Constants.STR_EMPTY : listQueryIntentActivities.get(0).activityInfo.name;
    }

    public static boolean c(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void d(Context context, String str) {
        if (c(str)) {
            return;
        }
        Intent intentA = a(context, str);
        if (intentA == null) {
            Log.e("AppUtils", "Didn't exist launcher activity.");
        } else {
            context.startActivity(intentA);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("CLICK_NOTIFICATION")) {
            d(context, context.getPackageName());
        }
    }
}
