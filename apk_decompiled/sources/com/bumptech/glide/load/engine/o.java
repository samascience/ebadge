package com.bumptech.glide.load.engine;

import defpackage.h42;
import defpackage.qg2;
import defpackage.rx1;
import defpackage.z42;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class o {
    private final Class a;
    private final h42 b;
    private final List c;
    private final String d;

    public o(Class cls, Class cls2, Class cls3, List list, h42 h42Var) {
        this.a = cls;
        this.b = h42Var;
        this.c = (List) z42.c(list);
        this.d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private qg2 b(com.bumptech.glide.load.data.a aVar, rx1 rx1Var, int i, int i2, g.a aVar2, List list) throws GlideException {
        int size = this.c.size();
        qg2 qg2VarA = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                qg2VarA = ((g) this.c.get(i3)).a(aVar, i, i2, rx1Var, aVar2);
            } catch (GlideException e) {
                list.add(e);
            }
            if (qg2VarA != null) {
                break;
            }
        }
        if (qg2VarA != null) {
            return qg2VarA;
        }
        throw new GlideException(this.d, new ArrayList(list));
    }

    public qg2 a(com.bumptech.glide.load.data.a aVar, rx1 rx1Var, int i, int i2, g.a aVar2) {
        List list = (List) z42.d(this.b.b());
        try {
            return b(aVar, rx1Var, i, i2, aVar2, list);
        } finally {
            this.b.a(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.c.toArray()) + '}';
    }
}
