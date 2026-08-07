package com.google.android.gms.common.api;

import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import defpackage.a52;
import defpackage.qs3;
import defpackage.u9;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AvailabilityException extends Exception {
    private final u9 zaay;

    public AvailabilityException(u9 u9Var) {
        this.zaay = u9Var;
    }

    public ConnectionResult getConnectionResult(b bVar) {
        qs3 qs3VarK = bVar.k();
        a52.b(this.zaay.get(qs3VarK) != null, "The given API was not part of the availability request.");
        return (ConnectionResult) this.zaay.get(qs3VarK);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (qs3 qs3Var : this.zaay.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) this.zaay.get(qs3Var);
            if (connectionResult.J0()) {
                z = false;
            }
            String strC = qs3Var.c();
            String strValueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(strC).length() + 2 + strValueOf.length());
            sb.append(strC);
            sb.append(": ");
            sb.append(strValueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        if (z) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }

    public final u9 zaj() {
        return this.zaay;
    }
}
