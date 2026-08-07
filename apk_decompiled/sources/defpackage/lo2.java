package defpackage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import com.blankj.utilcode.util.a;
import com.blankj.utilcode.util.o;
import java.util.Calendar;

/* JADX INFO: loaded from: classes4.dex */
public abstract class lo2 {
    public static void a(Bitmap bitmap) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(o.a().getContentResolver(), bitmap, "IMG" + Calendar.getInstance().getTime(), (String) null));
        intent.setType("image/*");
        intent.putExtra("android.intent.extra.STREAM", uri);
        a.n(Intent.createChooser(intent, "Qrcode"));
    }
}
