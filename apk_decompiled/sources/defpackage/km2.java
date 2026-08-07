package defpackage;

import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public final class km2 extends Writer {
    private final w13 a;

    public km2(io ioVar) {
        this.a = new w13(ioVar);
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    public String n() {
        String strL = this.a.l();
        this.a.x();
        return strL;
    }

    @Override // java.io.Writer
    public void write(char[] cArr) {
        this.a.c(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        this.a.c(cArr, i, i2);
    }

    @Override // java.io.Writer
    public void write(int i) {
        this.a.a((char) i);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) {
        write(c);
        return this;
    }

    @Override // java.io.Writer
    public void write(String str) {
        this.a.b(str, 0, str.length());
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        String string = charSequence.toString();
        this.a.b(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
        this.a.b(str, i, i2);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i, int i2) {
        String string = charSequence.subSequence(i, i2).toString();
        this.a.b(string, 0, string.length());
        return this;
    }
}
