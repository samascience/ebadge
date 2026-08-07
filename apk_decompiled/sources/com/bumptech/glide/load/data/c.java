package com.bumptech.glide.load.data;

import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import defpackage.v9;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class c implements com.bumptech.glide.load.data.a {
    private final RecyclableBufferedInputStream a;

    public static final class a implements com.bumptech.glide.load.data.a.InterfaceC0060a {
        private final v9 a;

        public a(v9 v9Var) {
            this.a = v9Var;
        }

        @Override // com.bumptech.glide.load.data.a.InterfaceC0060a
        public Class a() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.a.InterfaceC0060a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.bumptech.glide.load.data.a b(InputStream inputStream) {
            return new c(inputStream, this.a);
        }
    }

    public c(InputStream inputStream, v9 v9Var) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, v9Var);
        this.a = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(5242880);
    }

    @Override // com.bumptech.glide.load.data.a
    public void b() {
        this.a.w();
    }

    public void c() {
        this.a.u();
    }

    @Override // com.bumptech.glide.load.data.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public InputStream a() {
        this.a.reset();
        return this.a;
    }
}
