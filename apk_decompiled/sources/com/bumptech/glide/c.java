package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.h;
import defpackage.ef3;
import defpackage.f11;
import defpackage.lt0;
import defpackage.of2;
import defpackage.v9;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c extends ContextWrapper {
    static final g k = new lt0();
    private final v9 a;
    private final Registry b;
    private final f11 c;
    private final a.InterfaceC0057a d;
    private final List e;
    private final Map f;
    private final h g;
    private final d h;
    private final int i;
    private of2 j;

    public c(Context context, v9 v9Var, Registry registry, f11 f11Var, a.InterfaceC0057a interfaceC0057a, Map map, List list, h hVar, d dVar, int i) {
        super(context.getApplicationContext());
        this.a = v9Var;
        this.b = registry;
        this.c = f11Var;
        this.d = interfaceC0057a;
        this.e = list;
        this.f = map;
        this.g = hVar;
        this.h = dVar;
        this.i = i;
    }

    public ef3 a(ImageView imageView, Class cls) {
        return this.c.a(imageView, cls);
    }

    public v9 b() {
        return this.a;
    }

    public List c() {
        return this.e;
    }

    public synchronized of2 d() {
        try {
            if (this.j == null) {
                this.j = (of2) this.d.a().N();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.j;
    }

    public g e(Class cls) {
        g gVar = (g) this.f.get(cls);
        if (gVar == null) {
            for (Map.Entry entry : this.f.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    gVar = (g) entry.getValue();
                }
            }
        }
        return gVar == null ? k : gVar;
    }

    public h f() {
        return this.g;
    }

    public d g() {
        return this.h;
    }

    public int h() {
        return this.i;
    }

    public Registry i() {
        return this.b;
    }
}
