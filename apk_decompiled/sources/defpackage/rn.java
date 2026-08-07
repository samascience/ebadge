package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class rn {
    private static final String d = "rn";
    private oc1 a;
    private Intent b;
    private String c;

    private void c() {
        if (this.b == null) {
            Log.d(d, "intent is not created");
        }
        if (this.b == null) {
            if (!TextUtils.isEmpty(this.c)) {
                this.b = new Intent(this.c);
            }
            Log.d(d, "intent created with action");
        }
    }

    public static rn e(Context context) {
        rn rnVar = new rn();
        rnVar.a = oc1.b(context.getApplicationContext());
        return rnVar;
    }

    public rn a(String str) {
        this.c = str;
        return this;
    }

    public void b() {
        String str;
        c();
        Intent intent = this.b;
        if (intent == null || (str = this.c) == null) {
            return;
        }
        intent.setAction(str);
        oc1 oc1Var = this.a;
        if (oc1Var != null) {
            oc1Var.d(this.b);
        }
    }

    public rn d(Bundle bundle) {
        c();
        Intent intent = this.b;
        if (intent == null) {
            Log.e(d, "intent create failed");
            return this;
        }
        intent.putExtras(bundle);
        return this;
    }
}
