package androidx.activity;

import android.content.res.Resources;
import defpackage.ar0;
import defpackage.p31;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
final class SystemBarStyle$Companion$auto$1 extends Lambda implements ar0 {
    public static final SystemBarStyle$Companion$auto$1 INSTANCE = new SystemBarStyle$Companion$auto$1();

    SystemBarStyle$Companion$auto$1() {
        super(1);
    }

    @Override // defpackage.ar0
    public final Boolean invoke(Resources resources) {
        p31.f(resources, "resources");
        return Boolean.valueOf((resources.getConfiguration().uiMode & 48) == 32);
    }
}
