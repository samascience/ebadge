package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

/* JADX INFO: loaded from: classes3.dex */
public abstract class cz2 {
    public static Intent a(String str, boolean z) {
        Uri uri;
        try {
            if (Build.VERSION.SDK_INT >= 35) {
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.setType(str);
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", z);
                intent.addCategory("android.intent.category.OPENABLE");
                return intent;
            }
            if (str.startsWith("image/")) {
                uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if (str.startsWith("video/")) {
                uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else {
                uri = str.startsWith("audio/") ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : null;
            }
            if (uri != null) {
                Intent intent2 = new Intent("android.intent.action.PICK", uri);
                intent2.setType(str);
                intent2.putExtra("android.intent.extra.ALLOW_MULTIPLE", z);
                return intent2;
            }
            Intent intent3 = new Intent("android.intent.action.GET_CONTENT");
            intent3.setType(str);
            intent3.putExtra("android.intent.extra.ALLOW_MULTIPLE", z);
            intent3.addCategory("android.intent.category.OPENABLE");
            return intent3;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
