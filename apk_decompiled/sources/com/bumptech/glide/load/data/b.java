package com.bumptech.glide.load.data;

import defpackage.z42;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final com.bumptech.glide.load.data.a.InterfaceC0060a b = new a();
    private final Map a = new HashMap();

    class a implements com.bumptech.glide.load.data.a.InterfaceC0060a {
        a() {
        }

        @Override // com.bumptech.glide.load.data.a.InterfaceC0060a
        public Class a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // com.bumptech.glide.load.data.a.InterfaceC0060a
        public com.bumptech.glide.load.data.a b(Object obj) {
            return new C0061b(obj);
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.data.b$b, reason: collision with other inner class name */
    private static final class C0061b implements com.bumptech.glide.load.data.a {
        private final Object a;

        C0061b(Object obj) {
            this.a = obj;
        }

        @Override // com.bumptech.glide.load.data.a
        public Object a() {
            return this.a;
        }

        @Override // com.bumptech.glide.load.data.a
        public void b() {
        }
    }

    public synchronized com.bumptech.glide.load.data.a a(Object obj) {
        com.bumptech.glide.load.data.a.InterfaceC0060a interfaceC0060a;
        try {
            z42.d(obj);
            interfaceC0060a = (com.bumptech.glide.load.data.a.InterfaceC0060a) this.a.get(obj.getClass());
            if (interfaceC0060a == null) {
                for (com.bumptech.glide.load.data.a.InterfaceC0060a interfaceC0060a2 : this.a.values()) {
                    if (interfaceC0060a2.a().isAssignableFrom(obj.getClass())) {
                        interfaceC0060a = interfaceC0060a2;
                        break;
                    }
                }
            }
            if (interfaceC0060a == null) {
                interfaceC0060a = b;
            }
        } catch (Throwable th) {
            throw th;
        }
        return interfaceC0060a.b(obj);
    }

    public synchronized void b(com.bumptech.glide.load.data.a.InterfaceC0060a interfaceC0060a) {
        this.a.put(interfaceC0060a.a(), interfaceC0060a);
    }
}
