package com.bumptech.glide;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.o;
import defpackage.ah2;
import defpackage.ak0;
import defpackage.ec1;
import defpackage.fg0;
import defpackage.h42;
import defpackage.kh0;
import defpackage.m01;
import defpackage.q43;
import defpackage.qg2;
import defpackage.rk1;
import defpackage.sk1;
import defpackage.tk1;
import defpackage.ug2;
import defpackage.uk1;
import defpackage.vg2;
import defpackage.xg2;
import defpackage.yg2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Registry {
    private final tk1 a;
    private final kh0 b;
    private final vg2 c;
    private final yg2 d;
    private final com.bumptech.glide.load.data.b e;
    private final q43 f;
    private final m01 g;
    private final uk1 h = new uk1();
    private final ec1 i = new ec1();
    private final h42 j;

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(M m, List<rk1> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m);
        }

        public NoModelLoaderAvailableException(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        h42 h42VarE = ak0.e();
        this.j = h42VarE;
        this.a = new tk1(h42VarE);
        this.b = new kh0();
        this.c = new vg2();
        this.d = new yg2();
        this.e = new com.bumptech.glide.load.data.b();
        this.f = new q43();
        this.g = new m01();
        r(Arrays.asList("Gif", "Bitmap", "BitmapDrawable"));
    }

    private List f(Class cls, Class cls2, Class cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.c.d(cls, cls2)) {
            for (Class cls5 : this.f.b(cls4, cls3)) {
                arrayList.add(new com.bumptech.glide.load.engine.g(cls, cls4, cls5, this.c.b(cls, cls4), this.f.a(cls4, cls5), this.j));
            }
        }
        return arrayList;
    }

    public Registry a(Class cls, fg0 fg0Var) {
        this.b.a(cls, fg0Var);
        return this;
    }

    public Registry b(Class cls, xg2 xg2Var) {
        this.d.a(cls, xg2Var);
        return this;
    }

    public Registry c(Class cls, Class cls2, sk1 sk1Var) {
        this.a.a(cls, cls2, sk1Var);
        return this;
    }

    public Registry d(Class cls, Class cls2, ug2 ug2Var) {
        e("legacy_append", cls, cls2, ug2Var);
        return this;
    }

    public Registry e(String str, Class cls, Class cls2, ug2 ug2Var) {
        this.c.a(str, ug2Var, cls, cls2);
        return this;
    }

    public List g() {
        List listB = this.g.b();
        if (listB.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return listB;
    }

    public o h(Class cls, Class cls2, Class cls3) {
        o oVarA = this.i.a(cls, cls2, cls3);
        if (this.i.c(oVarA)) {
            return null;
        }
        if (oVarA == null) {
            List listF = f(cls, cls2, cls3);
            oVarA = listF.isEmpty() ? null : new o(cls, cls2, cls3, listF, this.j);
            this.i.d(cls, cls2, cls3, oVarA);
        }
        return oVarA;
    }

    public List i(Object obj) {
        return this.a.d(obj);
    }

    public List j(Class cls, Class cls2, Class cls3) {
        List listA = this.h.a(cls, cls2, cls3);
        if (listA == null) {
            listA = new ArrayList();
            Iterator it = this.a.c(cls).iterator();
            while (it.hasNext()) {
                for (Class cls4 : this.c.d((Class) it.next(), cls2)) {
                    if (!this.f.b(cls4, cls3).isEmpty() && !listA.contains(cls4)) {
                        listA.add(cls4);
                    }
                }
            }
            this.h.b(cls, cls2, cls3, Collections.unmodifiableList(listA));
        }
        return listA;
    }

    public xg2 k(qg2 qg2Var) {
        xg2 xg2VarB = this.d.b(qg2Var.p());
        if (xg2VarB != null) {
            return xg2VarB;
        }
        throw new NoResultEncoderAvailableException(qg2Var.p());
    }

    public com.bumptech.glide.load.data.a l(Object obj) {
        return this.e.a(obj);
    }

    public fg0 m(Object obj) {
        fg0 fg0VarB = this.b.b(obj.getClass());
        if (fg0VarB != null) {
            return fg0VarB;
        }
        throw new NoSourceEncoderAvailableException(obj.getClass());
    }

    public boolean n(qg2 qg2Var) {
        return this.d.b(qg2Var.p()) != null;
    }

    public Registry o(ImageHeaderParser imageHeaderParser) {
        this.g.a(imageHeaderParser);
        return this;
    }

    public Registry p(com.bumptech.glide.load.data.a.InterfaceC0060a interfaceC0060a) {
        this.e.b(interfaceC0060a);
        return this;
    }

    public Registry q(Class cls, Class cls2, ah2 ah2Var) {
        this.f.c(cls, cls2, ah2Var);
        return this;
    }

    public final Registry r(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        arrayList.add("legacy_append");
        this.c.e(arrayList);
        return this;
    }
}
