package defpackage;

import android.content.Context;
import android.net.Uri;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class y02 {
    public static InputStream a(Context context, Uri uri) {
        return w9.c().d(context.getContentResolver(), uri);
    }

    public static OutputStream b(Context context, Uri uri) {
        try {
            return context.getContentResolver().openOutputStream(uri);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
