package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
abstract class vh {
    static uh a(List list) {
        int size = list.size() << 1;
        int i = size - 1;
        if (((kj0) list.get(list.size() - 1)).d() == null) {
            i = size - 2;
        }
        uh uhVar = new uh(i * 12);
        int i2 = 0;
        int iB = ((kj0) list.get(0)).d().b();
        for (int i3 = 11; i3 >= 0; i3--) {
            if (((1 << i3) & iB) != 0) {
                uhVar.k(i2);
            }
            i2++;
        }
        for (int i4 = 1; i4 < list.size(); i4++) {
            kj0 kj0Var = (kj0) list.get(i4);
            int iB2 = kj0Var.c().b();
            for (int i5 = 11; i5 >= 0; i5--) {
                if (((1 << i5) & iB2) != 0) {
                    uhVar.k(i2);
                }
                i2++;
            }
            if (kj0Var.d() != null) {
                int iB3 = kj0Var.d().b();
                for (int i6 = 11; i6 >= 0; i6--) {
                    if (((1 << i6) & iB3) != 0) {
                        uhVar.k(i2);
                    }
                    i2++;
                }
            }
        }
        return uhVar;
    }
}
