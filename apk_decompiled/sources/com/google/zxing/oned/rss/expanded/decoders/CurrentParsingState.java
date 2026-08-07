package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes3.dex */
final class CurrentParsingState {
    private int a = 0;
    private State b = State.NUMERIC;

    private enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    CurrentParsingState() {
    }

    int a() {
        return this.a;
    }

    void b(int i) {
        this.a += i;
    }

    boolean c() {
        return this.b == State.ALPHA;
    }

    boolean d() {
        return this.b == State.ISO_IEC_646;
    }

    void e() {
        this.b = State.ALPHA;
    }

    void f() {
        this.b = State.ISO_IEC_646;
    }

    void g() {
        this.b = State.NUMERIC;
    }

    void h(int i) {
        this.a = i;
    }
}
