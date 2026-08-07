package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import defpackage.a52;
import defpackage.wa1;
import defpackage.za1;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class LifecycleCallback {
    protected final za1 a;

    protected LifecycleCallback(za1 za1Var) {
        this.a = za1Var;
    }

    protected static za1 c(wa1 wa1Var) {
        throw null;
    }

    @Keep
    private static za1 getChimeraLifecycleFragmentImpl(wa1 wa1Var) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity b() {
        Activity activityG = this.a.g();
        a52.g(activityG);
        return activityG;
    }

    public void d(int i, int i2, Intent intent) {
    }

    public void e(Bundle bundle) {
    }

    public void f() {
    }

    public void g() {
    }

    public void h(Bundle bundle) {
    }

    public void i() {
    }

    public void j() {
    }
}
