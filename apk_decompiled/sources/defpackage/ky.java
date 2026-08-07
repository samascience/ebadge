package defpackage;

import android.accounts.Account;
import android.view.View;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ky {
    private final Account a;
    private final Set b;
    private final Set c;
    private final Map d;
    private final int e;
    private final View f;
    private final String g;
    private final String h;
    private final xo2 i;
    private Integer j;

    public static final class a {
        private Account a;
        private y9 b;
        private Map c;
        private View e;
        private String f;
        private String g;
        private int d = 0;
        private xo2 h = xo2.i;

        public final a a(Collection collection) {
            if (this.b == null) {
                this.b = new y9();
            }
            this.b.addAll(collection);
            return this;
        }

        public final ky b() {
            return new ky(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }

        public final a c(Account account) {
            this.a = account;
            return this;
        }

        public final a d(String str) {
            this.g = str;
            return this;
        }

        public final a e(String str) {
            this.f = str;
            return this;
        }
    }

    public ky(Account account, Set set, Map map, int i, View view, String str, String str2, xo2 xo2Var) {
        this.a = account;
        Set setUnmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.b = setUnmodifiableSet;
        map = map == null ? Collections.EMPTY_MAP : map;
        this.d = map;
        this.f = view;
        this.e = i;
        this.g = str;
        this.h = str2;
        this.i = xo2Var;
        HashSet hashSet = new HashSet(setUnmodifiableSet);
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            e43.a(it.next());
            throw null;
        }
        this.c = Collections.unmodifiableSet(hashSet);
    }

    public final Account a() {
        return this.a;
    }

    public final String b() {
        Account account = this.a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    public final Account c() {
        Account account = this.a;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    public final Set d() {
        return this.c;
    }

    public final Set e(com.google.android.gms.common.api.a aVar) {
        e43.a(this.d.get(aVar));
        return this.b;
    }

    public final Integer f() {
        return this.j;
    }

    public final Map g() {
        return this.d;
    }

    public final String h() {
        return this.h;
    }

    public final String i() {
        return this.g;
    }

    public final Set j() {
        return this.b;
    }

    public final xo2 k() {
        return this.i;
    }

    public final void l(Integer num) {
        this.j = num;
    }
}
