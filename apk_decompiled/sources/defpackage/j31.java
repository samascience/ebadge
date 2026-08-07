package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j31 {
    public static Intent a(Context context, File file) {
        if (file == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        Uri uriH = FileProvider.h(context.getApplicationContext(), "com.onmicro.omtoolbox.fileprovider", file);
        intent.addFlags(1);
        intent.setDataAndType(uriH, "application/vnd.android.package-archive");
        return intent;
    }
}
