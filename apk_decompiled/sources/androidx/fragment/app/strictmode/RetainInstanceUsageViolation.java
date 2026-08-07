package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import defpackage.p31;
import defpackage.y70;

/* JADX INFO: loaded from: classes.dex */
public abstract class RetainInstanceUsageViolation extends Violation {
    public /* synthetic */ RetainInstanceUsageViolation(Fragment fragment, String str, int i, y70 y70Var) {
        this(fragment, (i & 2) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetainInstanceUsageViolation(Fragment fragment, String str) {
        super(fragment, str);
        p31.f(fragment, "fragment");
    }
}
