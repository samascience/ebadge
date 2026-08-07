package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import defpackage.g52;
import defpackage.q30;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private Context a;
    private SharedPreferences c;
    private SharedPreferences.Editor d;
    private boolean e;
    private String f;
    private int g;
    private PreferenceScreen i;
    private InterfaceC0030c j;
    private a k;
    private b l;
    private long b = 0;
    private int h = 0;

    public interface a {
        void l(Preference preference);
    }

    public interface b {
        void m(PreferenceScreen preferenceScreen);
    }

    /* JADX INFO: renamed from: androidx.preference.c$c, reason: collision with other inner class name */
    public interface InterfaceC0030c {
        boolean n(Preference preference);
    }

    public static abstract class d {
    }

    public c(Context context) {
        this.a = context;
        m(b(context));
    }

    private static String b(Context context) {
        return context.getPackageName() + "_preferences";
    }

    public Preference a(CharSequence charSequence) {
        PreferenceScreen preferenceScreen = this.i;
        if (preferenceScreen == null) {
            return null;
        }
        return preferenceScreen.s0(charSequence);
    }

    SharedPreferences.Editor c() {
        if (!this.e) {
            return i().edit();
        }
        if (this.d == null) {
            this.d = i().edit();
        }
        return this.d;
    }

    public b d() {
        return this.l;
    }

    public InterfaceC0030c e() {
        return this.j;
    }

    public d f() {
        return null;
    }

    public g52 g() {
        return null;
    }

    public PreferenceScreen h() {
        return this.i;
    }

    public SharedPreferences i() {
        g();
        if (this.c == null) {
            this.c = (this.h != 1 ? this.a : q30.b(this.a)).getSharedPreferences(this.f, this.g);
        }
        return this.c;
    }

    public void j(a aVar) {
        this.k = aVar;
    }

    public void k(b bVar) {
        this.l = bVar;
    }

    public void l(InterfaceC0030c interfaceC0030c) {
        this.j = interfaceC0030c;
    }

    public void m(String str) {
        this.f = str;
        this.c = null;
    }

    boolean n() {
        return !this.e;
    }

    public void o(Preference preference) {
        a aVar = this.k;
        if (aVar != null) {
            aVar.l(preference);
        }
    }
}
