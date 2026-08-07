package com.gyf.immersionbar.components;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import defpackage.q11;
import defpackage.r11;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class ImmersionFragment extends Fragment implements q11 {
    private r11 a = new r11(this);

    @Override // defpackage.q11
    public boolean b() {
        return true;
    }

    @Override // defpackage.q11
    public void e() {
    }

    @Override // defpackage.q11
    public void i() {
    }

    @Override // defpackage.q11
    public void j() {
    }

    @Override // defpackage.q11
    public void k() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.a.a(bundle);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.a.b(configuration);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a.c(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.a.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        this.a.e(z);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.a.f();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.a.g();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.a.h(z);
    }
}
