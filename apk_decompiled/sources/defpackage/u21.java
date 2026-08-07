package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class u21 implements w21 {
    private InputStream a;

    public abstract InputStream a();

    @Override // defpackage.w21
    public void close() {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            } finally {
                this.a = null;
            }
        }
    }

    @Override // defpackage.w21
    public InputStream open() {
        InputStream inputStreamA = a();
        this.a = inputStreamA;
        return inputStreamA;
    }
}
