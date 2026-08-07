package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import defpackage.a52;
import defpackage.wa1;
import defpackage.za1;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class v0 extends w0 {
    private final SparseArray f;

    private class a implements com.google.android.gms.common.api.c.InterfaceC0078c {
        public final int c;
        public final com.google.android.gms.common.api.c d;
        public final com.google.android.gms.common.api.c.InterfaceC0078c e;

        public a(int i, com.google.android.gms.common.api.c cVar, com.google.android.gms.common.api.c.InterfaceC0078c interfaceC0078c) {
            this.c = i;
            this.d = cVar;
            this.e = interfaceC0078c;
            cVar.r(this);
        }

        @Override // com.google.android.gms.common.api.c.InterfaceC0078c
        public final void d(ConnectionResult connectionResult) {
            String strValueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 27);
            sb.append("beginFailureResolution for ");
            sb.append(strValueOf);
            Log.d("AutoManageHelper", sb.toString());
            v0.this.m(connectionResult, this.c);
        }
    }

    private v0(za1 za1Var) {
        super(za1Var);
        this.f = new SparseArray();
        this.a.c("AutoManageHelper", this);
    }

    public static v0 p(wa1 wa1Var) {
        za1 za1VarC = LifecycleCallback.c(wa1Var);
        v0 v0Var = (v0) za1VarC.f("AutoManageHelper", v0.class);
        return v0Var != null ? v0Var : new v0(za1VarC);
    }

    private final a s(int i) {
        if (this.f.size() <= i) {
            return null;
        }
        SparseArray sparseArray = this.f;
        return (a) sparseArray.get(sparseArray.keyAt(i));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.f.size(); i++) {
            a aVarS = s(i);
            if (aVarS != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(aVarS.c);
                printWriter.println(":");
                aVarS.d.i(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.w0, com.google.android.gms.common.api.internal.LifecycleCallback
    public void i() {
        super.i();
        boolean z = this.b;
        String strValueOf = String.valueOf(this.f);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 14);
        sb.append("onStart ");
        sb.append(z);
        sb.append(" ");
        sb.append(strValueOf);
        Log.d("AutoManageHelper", sb.toString());
        if (this.c.get() == null) {
            for (int i = 0; i < this.f.size(); i++) {
                a aVarS = s(i);
                if (aVarS != null) {
                    aVarS.d.f();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.w0, com.google.android.gms.common.api.internal.LifecycleCallback
    public void j() {
        super.j();
        for (int i = 0; i < this.f.size(); i++) {
            a aVarS = s(i);
            if (aVarS != null) {
                aVarS.d.h();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.w0
    protected final void l(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        a aVar = (a) this.f.get(i);
        if (aVar != null) {
            q(i);
            com.google.android.gms.common.api.c.InterfaceC0078c interfaceC0078c = aVar.e;
            if (interfaceC0078c != null) {
                interfaceC0078c.d(connectionResult);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.w0
    protected final void n() {
        for (int i = 0; i < this.f.size(); i++) {
            a aVarS = s(i);
            if (aVarS != null) {
                aVarS.d.f();
            }
        }
    }

    public final void q(int i) {
        a aVar = (a) this.f.get(i);
        this.f.remove(i);
        if (aVar != null) {
            aVar.d.s(aVar);
            aVar.d.h();
        }
    }

    public final void r(int i, com.google.android.gms.common.api.c cVar, com.google.android.gms.common.api.c.InterfaceC0078c interfaceC0078c) {
        a52.h(cVar, "GoogleApiClient instance cannot be null");
        boolean z = this.f.indexOfKey(i) < 0;
        StringBuilder sb = new StringBuilder(54);
        sb.append("Already managing a GoogleApiClient with id ");
        sb.append(i);
        a52.j(z, sb.toString());
        x0 x0Var = (x0) this.c.get();
        boolean z2 = this.b;
        String strValueOf = String.valueOf(x0Var);
        StringBuilder sb2 = new StringBuilder(strValueOf.length() + 49);
        sb2.append("starting AutoManage for client ");
        sb2.append(i);
        sb2.append(" ");
        sb2.append(z2);
        sb2.append(" ");
        sb2.append(strValueOf);
        Log.d("AutoManageHelper", sb2.toString());
        this.f.put(i, new a(i, cVar, interfaceC0078c));
        if (this.b && x0Var == null) {
            String strValueOf2 = String.valueOf(cVar);
            StringBuilder sb3 = new StringBuilder(strValueOf2.length() + 11);
            sb3.append("connecting ");
            sb3.append(strValueOf2);
            Log.d("AutoManageHelper", sb3.toString());
            cVar.f();
        }
    }
}
