package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import defpackage.k52;
import java.io.IOException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class MinimalPrettyPrinter implements k52, Serializable {
    private static final long serialVersionUID = 1;
    protected String _rootValueSeparator;
    protected Separators _separators;

    public MinimalPrettyPrinter() {
        this(k52.B.toString());
    }

    @Override // defpackage.k52
    public void beforeArrayValues(JsonGenerator jsonGenerator) throws IOException {
    }

    @Override // defpackage.k52
    public void beforeObjectEntries(JsonGenerator jsonGenerator) throws IOException {
    }

    public void setRootValueSeparator(String str) {
        this._rootValueSeparator = str;
    }

    public MinimalPrettyPrinter setSeparators(Separators separators) {
        this._separators = separators;
        return this;
    }

    @Override // defpackage.k52
    public void writeArrayValueSeparator(JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.j1(this._separators.getArrayValueSeparator());
    }

    @Override // defpackage.k52
    public void writeEndArray(JsonGenerator jsonGenerator, int i) throws IOException {
        jsonGenerator.j1(']');
    }

    @Override // defpackage.k52
    public void writeEndObject(JsonGenerator jsonGenerator, int i) throws IOException {
        jsonGenerator.j1('}');
    }

    @Override // defpackage.k52
    public void writeObjectEntrySeparator(JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.j1(this._separators.getObjectEntrySeparator());
    }

    @Override // defpackage.k52
    public void writeObjectFieldValueSeparator(JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.j1(this._separators.getObjectFieldValueSeparator());
    }

    @Override // defpackage.k52
    public void writeRootValueSeparator(JsonGenerator jsonGenerator) throws IOException {
        String str = this._rootValueSeparator;
        if (str != null) {
            jsonGenerator.l1(str);
        }
    }

    @Override // defpackage.k52
    public void writeStartArray(JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.j1('[');
    }

    @Override // defpackage.k52
    public void writeStartObject(JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.j1('{');
    }

    public MinimalPrettyPrinter(String str) {
        this._rootValueSeparator = str;
        this._separators = k52.A;
    }
}
