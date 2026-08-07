package com.bumptech.glide.load.engine;

import android.util.Log;
import defpackage.ah2;
import defpackage.h42;
import defpackage.qg2;
import defpackage.rx1;
import defpackage.ug2;
import defpackage.z42;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g {
    private final Class a;
    private final List b;
    private final ah2 c;
    private final h42 d;
    private final String e;

    interface a {
        qg2 a(qg2 qg2Var);
    }

    public g(Class cls, Class cls2, Class cls3, List list, ah2 ah2Var, h42 h42Var) {
        this.a = cls;
        this.b = list;
        this.c = ah2Var;
        this.d = h42Var;
        this.e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private qg2 b(com.bumptech.glide.load.data.a aVar, int i, int i2, rx1 rx1Var) {
        List list = (List) z42.d(this.d.b());
        try {
            return c(aVar, i, i2, rx1Var, list);
        } finally {
            this.d.a(list);
        }
    }

    private qg2 c(com.bumptech.glide.load.data.a aVar, int i, int i2, rx1 rx1Var, List list) throws GlideException {
        int size = this.b.size();
        qg2 qg2VarB = null;
        for (int i3 = 0; i3 < size; i3++) {
            ug2 ug2Var = (ug2) this.b.get(i3);
            try {
                if (ug2Var.a(aVar.a(), rx1Var)) {
                    qg2VarB = ug2Var.b(aVar.a(), i, i2, rx1Var);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + ug2Var, e);
                }
                list.add(e);
            }
            if (qg2VarB != null) {
                break;
            }
        }
        if (qg2VarB != null) {
            return qg2VarB;
        }
        throw new GlideException(this.e, new ArrayList(list));
    }

    public qg2 a(com.bumptech.glide.load.data.a aVar, int i, int i2, rx1 rx1Var, a aVar2) {
        return this.c.a(aVar2.a(b(aVar, i, i2, rx1Var)), rx1Var);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.a + ", decoders=" + this.b + ", transcoder=" + this.c + '}';
    }
}
