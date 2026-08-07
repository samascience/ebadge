package androidx.work;

import android.net.Network;
import defpackage.e82;
import defpackage.ep0;
import defpackage.fl3;
import defpackage.w03;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class WorkerParameters {
    private UUID a;
    private b b;
    private Set c;
    private a d;
    private int e;
    private Executor f;
    private w03 g;
    private fl3 h;
    private e82 i;
    private ep0 j;

    public static class a {
        public List a = Collections.emptyList();
        public List b = Collections.emptyList();
        public Network c;
    }

    public WorkerParameters(UUID uuid, b bVar, Collection collection, a aVar, int i, Executor executor, w03 w03Var, fl3 fl3Var, e82 e82Var, ep0 ep0Var) {
        this.a = uuid;
        this.b = bVar;
        this.c = new HashSet(collection);
        this.d = aVar;
        this.e = i;
        this.f = executor;
        this.g = w03Var;
        this.h = fl3Var;
        this.i = e82Var;
        this.j = ep0Var;
    }

    public Executor a() {
        return this.f;
    }

    public ep0 b() {
        return this.j;
    }

    public UUID c() {
        return this.a;
    }

    public b d() {
        return this.b;
    }

    public fl3 e() {
        return this.h;
    }
}
