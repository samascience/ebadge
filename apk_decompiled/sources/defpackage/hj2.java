package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes3.dex */
public abstract class hj2 {
    public static boolean a(Context context, String str, boolean z) {
        return context.getSharedPreferences("OMToolbox", 0).getBoolean(str, z);
    }

    public static int b(Context context, String str, int i) {
        return context.getSharedPreferences("OMToolbox", 0).getInt(str, i);
    }

    public static String c(Context context, String str) {
        return d(context, str, Constants.STR_EMPTY);
    }

    public static String d(Context context, String str, String str2) {
        return context.getSharedPreferences("OMToolbox", 0).getString(str, str2);
    }

    public static boolean e(Context context, String str, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("OMToolbox", 0).edit();
        editorEdit.putBoolean(str, z);
        return editorEdit.commit();
    }

    public static boolean f(Context context, String str, int i) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("OMToolbox", 0).edit();
        editorEdit.putInt(str, i);
        return editorEdit.commit();
    }

    public static boolean g(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("OMToolbox", 0).edit();
        editorEdit.putString(str, str2);
        return editorEdit.commit();
    }
}
