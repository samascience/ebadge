package androidx.lifecycle;

import android.os.Bundle;
import defpackage.ja1;
import defpackage.ne3;
import defpackage.p31;
import defpackage.wj2;
import defpackage.yq0;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandlesProvider implements androidx.savedstate.a.c {
    private final androidx.savedstate.a a;
    private boolean b;
    private Bundle c;
    private final ja1 d;

    public SavedStateHandlesProvider(androidx.savedstate.a aVar, final ne3 ne3Var) {
        p31.f(aVar, "savedStateRegistry");
        p31.f(ne3Var, "viewModelStoreOwner");
        this.a = aVar;
        this.d = kotlin.a.a(new yq0() { // from class: androidx.lifecycle.SavedStateHandlesProvider$viewModel$2
            {
                super(0);
            }

            @Override // defpackage.yq0
            public final wj2 invoke() {
                return SavedStateHandleSupport.e(ne3Var);
            }
        });
    }

    private final wj2 c() {
        return (wj2) this.d.getValue();
    }

    @Override // androidx.savedstate.a.c
    public Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : c().f().entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleA = ((l) entry.getValue()).c().a();
            if (!p31.a(bundleA, Bundle.EMPTY)) {
                bundle.putBundle(str, bundleA);
            }
        }
        this.b = false;
        return bundle;
    }

    public final Bundle b(String str) {
        p31.f(str, "key");
        d();
        Bundle bundle = this.c;
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.c;
        if (bundle4 != null && bundle4.isEmpty()) {
            this.c = null;
        }
        return bundle2;
    }

    public final void d() {
        if (this.b) {
            return;
        }
        Bundle bundleB = this.a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleB != null) {
            bundle.putAll(bundleB);
        }
        this.c = bundle;
        this.b = true;
        c();
    }
}
