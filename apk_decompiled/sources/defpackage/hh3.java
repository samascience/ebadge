package defpackage;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class hh3 extends ng {
    long a;
    int b;
    int c;
    List d;
    byte[] e;
    byte f;
    boolean g = true;
    Exception h;

    public hh3(Exception exc) {
        this.h = exc;
    }

    public String toString() {
        return "WatchThemeConfigEvent{watchId=" + this.a + ", innerBgStyleIndex=" + this.b + ", timeStyleIndex=" + this.c + ", mixStyles=" + this.d + ", bgColor=" + Arrays.toString(this.e) + ", deviceTyp=" + ((int) this.f) + '}';
    }

    public hh3(long j, int i, int i2, List list, byte[] bArr, byte b) {
        this.a = j;
        this.b = i;
        this.c = i2;
        this.d = list;
        this.e = bArr;
        this.f = b;
    }
}
