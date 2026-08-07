package com.legend.mywatch.sdk.mywatchsdklib.android.utils;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {
    private static final String a = System.getProperty("line.separator");

    public static File a(String str) {
        if (k.p(str)) {
            return null;
        }
        return new File(str);
    }

    public static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        return c(file.getAbsolutePath());
    }

    public static boolean c(String str) {
        File fileA = a(str);
        if (fileA == null) {
            return false;
        }
        if (fileA.exists()) {
            return true;
        }
        return d(str);
    }

    private static boolean d(String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = i.a().getContentResolver().openAssetFileDescriptor(Uri.parse(str), "r");
                if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                    return false;
                }
                try {
                    assetFileDescriptorOpenAssetFileDescriptor.close();
                    return true;
                } catch (IOException unused) {
                    return true;
                }
            } catch (FileNotFoundException unused2) {
            }
        }
        return false;
    }
}
