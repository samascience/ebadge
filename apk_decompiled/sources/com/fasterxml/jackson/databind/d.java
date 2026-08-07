package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import defpackage.f71;
import defpackage.z63;
import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: loaded from: classes.dex */
public class d implements Closeable, Flushable {
    protected final DefaultSerializerProvider a;
    protected final SerializationConfig b;
    protected final JsonGenerator c;
    protected final f71 d;
    protected final z63 e;
    protected final boolean f;
    protected final boolean g;
    protected final boolean h;
    protected com.fasterxml.jackson.databind.ser.impl.a i;
    protected boolean j;
    protected boolean k;

    public d(DefaultSerializerProvider defaultSerializerProvider, JsonGenerator jsonGenerator, boolean z, ObjectWriter.Prefetch prefetch) {
        this.a = defaultSerializerProvider;
        this.c = jsonGenerator;
        this.f = z;
        this.d = prefetch.getValueSerializer();
        this.e = prefetch.getTypeSerializer();
        SerializationConfig config = defaultSerializerProvider.getConfig();
        this.b = config;
        this.g = config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE);
        this.h = config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE);
        this.i = com.fasterxml.jackson.databind.ser.impl.a.d();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.k) {
            return;
        }
        this.k = true;
        if (this.j) {
            this.j = false;
            this.c.R0();
        }
        if (this.f) {
            this.c.close();
        }
    }

    @Override // java.io.Flushable
    public void flush() {
        if (this.k) {
            return;
        }
        this.c.flush();
    }

    public d n(boolean z) {
        if (z) {
            this.c.p1();
            this.j = true;
        }
        return this;
    }
}
