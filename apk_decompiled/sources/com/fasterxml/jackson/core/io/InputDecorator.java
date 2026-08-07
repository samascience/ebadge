package com.fasterxml.jackson.core.io;

import defpackage.oy0;
import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class InputDecorator implements Serializable {
    private static final long serialVersionUID = 1;

    public DataInput decorate(oy0 oy0Var, DataInput dataInput) throws IOException {
        throw new UnsupportedOperationException();
    }

    public abstract InputStream decorate(oy0 oy0Var, InputStream inputStream) throws IOException;

    public abstract InputStream decorate(oy0 oy0Var, byte[] bArr, int i, int i2) throws IOException;

    public abstract Reader decorate(oy0 oy0Var, Reader reader) throws IOException;
}
