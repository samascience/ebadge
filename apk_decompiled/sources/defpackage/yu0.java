package defpackage;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public class yu0 implements jh2 {
    private Status a;
    private GoogleSignInAccount b;

    public yu0(GoogleSignInAccount googleSignInAccount, Status status) {
        this.b = googleSignInAccount;
        this.a = status;
    }

    public GoogleSignInAccount a() {
        return this.b;
    }

    @Override // defpackage.jh2
    public Status n() {
        return this.a;
    }
}
