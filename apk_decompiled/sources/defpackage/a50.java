package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.soundcloud.android.crop.CropImageActivity;

/* JADX INFO: loaded from: classes.dex */
public class a50 {
    private Intent a;

    private a50(Uri uri, Uri uri2) {
        Intent intent = new Intent();
        this.a = intent;
        intent.setData(uri);
        this.a.putExtra("output", uri2);
    }

    public static a50 c(Uri uri, Uri uri2) {
        return new a50(uri, uri2);
    }

    public a50 a() {
        this.a.putExtra("aspect_x", 1);
        this.a.putExtra("aspect_y", 1);
        return this;
    }

    public Intent b(Context context) {
        this.a.setClass(context, CropImageActivity.class);
        return this.a;
    }

    public void d(Activity activity) {
        e(activity, 6709);
    }

    public void e(Activity activity, int i) {
        activity.startActivityForResult(b(activity), i);
    }
}
