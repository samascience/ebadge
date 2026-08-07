package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import defpackage.f71;
import defpackage.kh;
import defpackage.m7;
import defpackage.mt1;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final BeanPropertyWriter[] i = new BeanPropertyWriter[0];
    protected final kh a;
    protected SerializationConfig b;
    protected List c = Collections.emptyList();
    protected BeanPropertyWriter[] d;
    protected m7 e;
    protected Object f;
    protected AnnotatedMember g;
    protected mt1 h;

    public a(kh khVar) {
        this.a = khVar;
    }

    public f71 a() {
        BeanPropertyWriter[] beanPropertyWriterArr;
        if (this.g != null && this.b.isEnabled(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            this.g.fixAccess(this.b.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        m7 m7Var = this.e;
        if (m7Var != null) {
            m7Var.a(this.b);
        }
        List list = this.c;
        if (list == null || list.isEmpty()) {
            if (this.e == null && this.h == null) {
                return null;
            }
            beanPropertyWriterArr = i;
        } else {
            List list2 = this.c;
            beanPropertyWriterArr = (BeanPropertyWriter[]) list2.toArray(new BeanPropertyWriter[list2.size()]);
            if (this.b.isEnabled(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                for (BeanPropertyWriter beanPropertyWriter : beanPropertyWriterArr) {
                    beanPropertyWriter.fixAccess(this.b);
                }
            }
        }
        BeanPropertyWriter[] beanPropertyWriterArr2 = this.d;
        if (beanPropertyWriterArr2 == null || beanPropertyWriterArr2.length == this.c.size()) {
            return new BeanSerializer(this.a.A(), this, beanPropertyWriterArr, this.d);
        }
        throw new IllegalStateException(String.format("Mismatch between `properties` size (%d), `filteredProperties` (%s): should have as many (or `null` for latter)", Integer.valueOf(this.c.size()), Integer.valueOf(this.d.length)));
    }

    public BeanSerializer b() {
        return BeanSerializer.createDummy(this.a.A(), this);
    }

    public m7 c() {
        return this.e;
    }

    public kh d() {
        return this.a;
    }

    public Object e() {
        return this.f;
    }

    public mt1 f() {
        return this.h;
    }

    public List g() {
        return this.c;
    }

    public AnnotatedMember h() {
        return this.g;
    }

    public void i(m7 m7Var) {
        this.e = m7Var;
    }

    protected void j(SerializationConfig serializationConfig) {
        this.b = serializationConfig;
    }

    public void k(Object obj) {
        this.f = obj;
    }

    public void l(BeanPropertyWriter[] beanPropertyWriterArr) {
        if (beanPropertyWriterArr != null && beanPropertyWriterArr.length != this.c.size()) {
            throw new IllegalArgumentException(String.format("Trying to set %d filtered properties; must match length of non-filtered `properties` (%d)", Integer.valueOf(beanPropertyWriterArr.length), Integer.valueOf(this.c.size())));
        }
        this.d = beanPropertyWriterArr;
    }

    public void m(mt1 mt1Var) {
        this.h = mt1Var;
    }

    public void n(List list) {
        this.c = list;
    }

    public void o(AnnotatedMember annotatedMember) {
        if (this.g == null) {
            this.g = annotatedMember;
            return;
        }
        throw new IllegalArgumentException("Multiple type ids specified with " + this.g + " and " + annotatedMember);
    }
}
