package com.tencent.open.a;

import com.tencent.connect.common.Constants;
import defpackage.eh2;
import defpackage.fh2;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private eh2 a;
    private String b = null;
    private int c;
    private int d;
    private int e;

    b(eh2 eh2Var, int i) {
        this.a = eh2Var;
        this.d = i;
        this.c = eh2Var.C();
        fh2 fh2VarN = this.a.n();
        if (fh2VarN != null) {
            this.e = (int) fh2VarN.contentLength();
        } else {
            this.e = 0;
        }
    }

    public String a() throws IOException {
        if (this.b == null) {
            fh2 fh2VarN = this.a.n();
            if (fh2VarN != null) {
                this.b = fh2VarN.string();
            }
            if (this.b == null) {
                this.b = Constants.STR_EMPTY;
            }
        }
        return this.b;
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.c;
    }
}
