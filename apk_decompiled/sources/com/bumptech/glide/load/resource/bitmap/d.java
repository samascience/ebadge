package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import defpackage.li0;
import defpackage.oi;
import defpackage.qg2;
import defpackage.rx1;
import defpackage.ug2;
import defpackage.v9;
import defpackage.vf1;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class d implements ug2 {
    private final com.bumptech.glide.load.resource.bitmap.a a;
    private final v9 b;

    static class a implements com.bumptech.glide.load.resource.bitmap.a.b {
        private final RecyclableBufferedInputStream a;
        private final li0 b;

        a(RecyclableBufferedInputStream recyclableBufferedInputStream, li0 li0Var) {
            this.a = recyclableBufferedInputStream;
            this.b = li0Var;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.a.b
        public void a() {
            this.a.u();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.a.b
        public void b(oi oiVar, Bitmap bitmap) throws IOException {
            IOException iOExceptionN = this.b.n();
            if (iOExceptionN != null) {
                if (bitmap == null) {
                    throw iOExceptionN;
                }
                oiVar.c(bitmap);
                throw iOExceptionN;
            }
        }
    }

    public d(com.bumptech.glide.load.resource.bitmap.a aVar, v9 v9Var) {
        this.a = aVar;
        this.b = v9Var;
    }

    @Override // defpackage.ug2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public qg2 b(InputStream inputStream, int i, int i2, rx1 rx1Var) {
        boolean z;
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            z = true;
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.b);
        }
        li0 li0VarU = li0.u(recyclableBufferedInputStream);
        try {
            return this.a.g(new vf1(li0VarU), i, i2, rx1Var, new a(recyclableBufferedInputStream, li0VarU));
        } finally {
            li0VarU.w();
            if (z) {
                recyclableBufferedInputStream.w();
            }
        }
    }

    @Override // defpackage.ug2
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(InputStream inputStream, rx1 rx1Var) {
        return this.a.p(inputStream);
    }
}
