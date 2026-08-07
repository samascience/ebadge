package defpackage;

import android.content.ContentResolver;
import android.provider.Settings;

/* JADX INFO: loaded from: classes3.dex */
public class a7 {
    public float a(ContentResolver contentResolver) {
        return Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
    }
}
