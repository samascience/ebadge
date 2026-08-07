package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public final class SetRetainInstanceUsageViolation extends RetainInstanceUsageViolation {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetRetainInstanceUsageViolation(Fragment fragment) {
        super(fragment, "Attempting to set retain instance for fragment " + fragment);
        p31.f(fragment, "fragment");
    }
}
