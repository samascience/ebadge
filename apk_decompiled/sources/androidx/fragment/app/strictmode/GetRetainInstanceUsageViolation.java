package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public final class GetRetainInstanceUsageViolation extends RetainInstanceUsageViolation {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetRetainInstanceUsageViolation(Fragment fragment) {
        super(fragment, "Attempting to get retain instance for fragment " + fragment);
        p31.f(fragment, "fragment");
    }
}
