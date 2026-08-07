package defpackage;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: loaded from: classes.dex */
public final class r21 {
    private final b a;

    private static final class a implements b {
        final InputContentInfo a;

        a(Object obj) {
            this.a = (InputContentInfo) obj;
        }

        @Override // r21.b
        public Uri a() {
            return this.a.getContentUri();
        }

        @Override // r21.b
        public void b() {
            this.a.requestPermission();
        }

        @Override // r21.b
        public Uri c() {
            return this.a.getLinkUri();
        }

        @Override // r21.b
        public Object d() {
            return this.a;
        }

        @Override // r21.b
        public ClipDescription getDescription() {
            return this.a.getDescription();
        }
    }

    private interface b {
        Uri a();

        void b();

        Uri c();

        Object d();

        ClipDescription getDescription();
    }

    private r21(b bVar) {
        this.a = bVar;
    }

    public static r21 f(Object obj) {
        if (obj == null) {
            return null;
        }
        return new r21(new a(obj));
    }

    public Uri a() {
        return this.a.a();
    }

    public ClipDescription b() {
        return this.a.getDescription();
    }

    public Uri c() {
        return this.a.c();
    }

    public void d() {
        this.a.b();
    }

    public Object e() {
        return this.a.d();
    }
}
