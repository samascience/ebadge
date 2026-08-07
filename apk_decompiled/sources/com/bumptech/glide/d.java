package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private final Map a;

    static final class a {
        private final Map a = new HashMap();

        a() {
        }

        d b() {
            return new d(this);
        }
    }

    d(a aVar) {
        this.a = Collections.unmodifiableMap(new HashMap(aVar.a));
    }

    public boolean a(Class cls) {
        return this.a.containsKey(cls);
    }
}
