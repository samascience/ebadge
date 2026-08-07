package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.luck.picture.lib.PictureExternalPreviewActivity;
import com.luck.picture.lib.R$anim;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class v22 {
    private final WeakReference a;
    private final WeakReference b;

    private v22(Activity activity) {
        this(activity, null);
    }

    public static v22 a(Activity activity) {
        return new v22(activity);
    }

    public static List e(Intent intent) {
        ArrayList parcelableArrayListExtra;
        return (intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra("extra_result_media")) == null) ? new ArrayList() : parcelableArrayListExtra;
    }

    public static List f(Bundle bundle) {
        if (bundle != null) {
            return bundle.getParcelableArrayList("selectList");
        }
        return null;
    }

    public static Intent h(List list) {
        return new Intent().putParcelableArrayListExtra("extra_result_media", (ArrayList) list);
    }

    public static void i(Bundle bundle, List list) {
        bundle.putParcelableArrayList("selectList", (ArrayList) list);
    }

    public void b(int i, List list, int i2) {
        if (wc0.a()) {
            return;
        }
        if (c() == null) {
            throw new NullPointerException("Starting the PictureSelector Activity cannot be empty ");
        }
        Intent intent = new Intent(c(), (Class<?>) PictureExternalPreviewActivity.class);
        intent.putParcelableArrayListExtra("previewSelectList", (ArrayList) list);
        intent.putExtra("position", i);
        c().startActivity(intent);
        Activity activityC = c();
        if (i2 == 0) {
            i2 = R$anim.picture_anim_enter;
        }
        activityC.overridePendingTransition(i2, R$anim.picture_anim_fade_in);
    }

    Activity c() {
        return (Activity) this.a.get();
    }

    Fragment d() {
        WeakReference weakReference = this.b;
        if (weakReference != null) {
            return (Fragment) weakReference.get();
        }
        return null;
    }

    public bz2 g(int i) {
        return new bz2(this, i);
    }

    private v22(Activity activity, Fragment fragment) {
        this.a = new WeakReference(activity);
        this.b = new WeakReference(fragment);
    }
}
