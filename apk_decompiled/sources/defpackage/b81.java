package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.luck.picture.lib.PicturePreviewActivity;
import com.luck.picture.lib.PictureSelectorPreviewWeChatStyleActivity;
import com.luck.picture.lib.PictureVideoPlayActivity;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b81 {
    public static void a(Context context, boolean z, Bundle bundle, int i) {
        if (wc0.a()) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, z ? PictureSelectorPreviewWeChatStyleActivity.class : PicturePreviewActivity.class);
        intent.putExtras(bundle);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
        } else {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static void b(Context context, Bundle bundle, int i) {
        if (wc0.a()) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, PictureVideoPlayActivity.class);
        intent.putExtras(bundle);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
        } else {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }
}
