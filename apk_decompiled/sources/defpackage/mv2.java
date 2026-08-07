package defpackage;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class mv2 extends jg {
    private final Appendable a;

    public mv2() {
        this(new StringBuilder());
    }

    public static String k(nm2 nm2Var) {
        return l(nm2Var);
    }

    public static String l(nm2 nm2Var) {
        return new mv2().e(nm2Var).toString();
    }

    @Override // defpackage.jg
    protected void c(char c) {
        try {
            this.a.append(c);
        } catch (IOException e) {
            throw new RuntimeException("Could not write description", e);
        }
    }

    @Override // defpackage.jg
    protected void d(String str) {
        try {
            this.a.append(str);
        } catch (IOException e) {
            throw new RuntimeException("Could not write description", e);
        }
    }

    public String toString() {
        return this.a.toString();
    }

    public mv2(Appendable appendable) {
        this.a = appendable;
    }
}
