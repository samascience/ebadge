package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class su2 {
    private static final Lock c = new ReentrantLock();
    private static su2 d;
    private final Lock a = new ReentrantLock();
    private final SharedPreferences b;

    private su2(Context context) {
        this.b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static su2 b(Context context) {
        a52.g(context);
        c.lock();
        try {
            if (d == null) {
                d = new su2(context.getApplicationContext());
            }
            return d;
        } finally {
            c.unlock();
        }
    }

    private final void g(String str, String str2) {
        this.a.lock();
        try {
            this.b.edit().putString(str, str2).apply();
        } finally {
            this.a.unlock();
        }
    }

    private static String h(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    private final GoogleSignInAccount i(String str) {
        String strK;
        if (!TextUtils.isEmpty(str) && (strK = k(h("googleSignInAccount", str))) != null) {
            try {
                return GoogleSignInAccount.P0(strK);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private final GoogleSignInOptions j(String str) {
        String strK;
        if (!TextUtils.isEmpty(str) && (strK = k(h("googleSignInOptions", str))) != null) {
            try {
                return GoogleSignInOptions.O0(strK);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private final String k(String str) {
        this.a.lock();
        try {
            return this.b.getString(str, null);
        } finally {
            this.a.unlock();
        }
    }

    private final void m(String str) {
        this.a.lock();
        try {
            this.b.edit().remove(str).apply();
        } finally {
            this.a.unlock();
        }
    }

    public void a() {
        this.a.lock();
        try {
            this.b.edit().clear().apply();
        } finally {
            this.a.unlock();
        }
    }

    public GoogleSignInAccount c() {
        return i(k("defaultGoogleSignInAccount"));
    }

    public GoogleSignInOptions d() {
        return j(k("defaultGoogleSignInAccount"));
    }

    public String e() {
        return k("refreshToken");
    }

    public void f(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        a52.g(googleSignInAccount);
        a52.g(googleSignInOptions);
        g("defaultGoogleSignInAccount", googleSignInAccount.R0());
        a52.g(googleSignInAccount);
        a52.g(googleSignInOptions);
        String strR0 = googleSignInAccount.R0();
        g(h("googleSignInAccount", strR0), googleSignInAccount.S0());
        g(h("googleSignInOptions", strR0), googleSignInOptions.U0());
    }

    public final void l() {
        String strK = k("defaultGoogleSignInAccount");
        m("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strK)) {
            return;
        }
        m(h("googleSignInAccount", strK));
        m(h("googleSignInOptions", strK));
    }
}
