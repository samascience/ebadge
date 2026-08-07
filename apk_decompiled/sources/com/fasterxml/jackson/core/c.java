package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.InputDecorator;
import com.fasterxml.jackson.core.io.OutputDecorator;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    protected static final int f = JsonFactory.Feature.collectDefaults();
    protected static final int g = JsonParser.Feature.collectDefaults();
    protected static final int h = JsonGenerator.Feature.collectDefaults();
    protected int a;
    protected int b;
    protected int c;
    protected InputDecorator d;
    protected OutputDecorator e;

    protected c() {
        this.a = f;
        this.b = g;
        this.c = h;
        this.d = null;
        this.e = null;
    }

    protected c(JsonFactory jsonFactory) {
        this(jsonFactory._factoryFeatures, jsonFactory._parserFeatures, jsonFactory._generatorFeatures);
    }

    protected c(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }
}
