package com.gyf.immersionbar;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes3.dex */
public final class SupportRequestBarManagerFragment extends Fragment {
    private j a;

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        j jVar = this.a;
        if (jVar != null) {
            jVar.c(getResources().getConfiguration());
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j jVar = this.a;
        if (jVar != null) {
            jVar.d(configuration);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        j jVar = this.a;
        if (jVar != null) {
            jVar.e();
            this.a = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        j jVar = this.a;
        if (jVar != null) {
            jVar.f();
        }
    }

    public h v(Object obj) {
        if (this.a == null) {
            this.a = new j(obj);
        }
        return this.a.b();
    }
}
