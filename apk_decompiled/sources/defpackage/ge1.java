package defpackage;

import com.baji.protocol.model.ProtocolConstants;

/* JADX INFO: loaded from: classes.dex */
public class ge1 {
    private static final ge1 b = new ge1();
    private final af1 a = new af1(ProtocolConstants.MAX_FILE_SIZE);

    ge1() {
    }

    public static ge1 b() {
        return b;
    }

    public fe1 a(String str) {
        if (str == null) {
            return null;
        }
        return (fe1) this.a.c(str);
    }

    public void c(String str, fe1 fe1Var) {
        if (str == null) {
            return;
        }
        this.a.d(str, fe1Var);
    }
}
