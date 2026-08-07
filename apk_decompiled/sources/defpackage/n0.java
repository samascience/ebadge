package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes4.dex */
public abstract class n0 {
    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return Constants.STR_EMPTY;
        }
    }
}
