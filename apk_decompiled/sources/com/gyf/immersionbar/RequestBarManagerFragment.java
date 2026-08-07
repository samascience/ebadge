package com.gyf.immersionbar;

import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public final class RequestBarManagerFragment extends Fragment {
    private j a;

    public h a(Object obj) {
        if (this.a == null) {
            this.a = new j(obj);
        }
        return this.a.b();
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        j jVar = this.a;
        if (jVar != null) {
            jVar.c(getResources().getConfiguration());
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j jVar = this.a;
        if (jVar != null) {
            jVar.d(configuration);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        j jVar = this.a;
        if (jVar != null) {
            jVar.e();
            this.a = null;
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        j jVar = this.a;
        if (jVar != null) {
            jVar.f();
        }
    }
}
