package defpackage;

import java.io.EOFException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public interface m21 {
    byte a();

    boolean b();

    public static class a implements m21 {
        protected final InputStream a;
        protected final byte[] b;
        protected final int c;
        protected int d;
        protected int e;

        public a(InputStream inputStream, byte[] bArr) {
            this.a = inputStream;
            this.b = bArr;
            this.c = 0;
            this.e = 0;
            this.d = 0;
        }

        @Override // defpackage.m21
        public byte a() throws EOFException {
            if (this.e < this.d || b()) {
                byte[] bArr = this.b;
                int i = this.e;
                this.e = i + 1;
                return bArr[i];
            }
            throw new EOFException("Failed auto-detect: could not read more than " + this.e + " bytes (max buffer size: " + this.b.length + ")");
        }

        @Override // defpackage.m21
        public boolean b() {
            int i;
            int i2 = this.e;
            if (i2 < this.d) {
                return true;
            }
            InputStream inputStream = this.a;
            if (inputStream == null) {
                return false;
            }
            byte[] bArr = this.b;
            int length = bArr.length - i2;
            if (length < 1 || (i = inputStream.read(bArr, i2, length)) <= 0) {
                return false;
            }
            this.d += i;
            return true;
        }

        public void c() {
            this.e = this.c;
        }

        public a(byte[] bArr, int i, int i2) {
            this.a = null;
            this.b = bArr;
            this.e = i;
            this.c = i;
            this.d = i + i2;
        }
    }
}
