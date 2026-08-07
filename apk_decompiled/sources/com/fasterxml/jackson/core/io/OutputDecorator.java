package com.fasterxml.jackson.core.io;

import defpackage.oy0;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public abstract class OutputDecorator implements Serializable {
    public abstract OutputStream decorate(oy0 oy0Var, OutputStream outputStream) throws IOException;

    public abstract Writer decorate(oy0 oy0Var, Writer writer) throws IOException;
}
