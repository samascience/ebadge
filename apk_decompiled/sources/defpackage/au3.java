package defpackage;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class au3 extends a.AbstractC0075a {
    au3() {
    }

    @Override // com.google.android.gms.common.api.a.e
    public final /* synthetic */ List a(Object obj) {
        GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
        return googleSignInOptions == null ? Collections.emptyList() : googleSignInOptions.H0();
    }

    @Override // com.google.android.gms.common.api.a.AbstractC0075a
    public final /* synthetic */ a.f c(Context context, Looper looper, ky kyVar, Object obj, c.b bVar, c.InterfaceC0078c interfaceC0078c) {
        return new eu3(context, looper, kyVar, (GoogleSignInOptions) obj, bVar, interfaceC0078c);
    }
}
