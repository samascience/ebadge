package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static final d[] h = a();
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final c f;
    private final int g;

    static final class b {
        private final int a;
        private final int b;

        int a() {
            return this.a;
        }

        int b() {
            return this.b;
        }

        private b(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    private d(int i, int i2, int i3, int i4, int i5, c cVar) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = cVar;
        int iB = cVar.b();
        int iA = 0;
        for (b bVar : cVar.a()) {
            iA += bVar.a() * (bVar.b() + iB);
        }
        this.g = iA;
    }

    private static d[] a() {
        int i = 1;
        int i2 = 5;
        d dVar = new d(1, 10, 10, 8, 8, new c(i2, new b(i, 3)));
        d dVar2 = new d(2, 12, 12, 10, 10, new c(7, new b(i, i2)));
        d dVar3 = new d(3, 14, 14, 12, 12, new c(10, new b(i, 8)));
        int i3 = 12;
        d dVar4 = new d(4, 16, 16, 14, 14, new c(i3, new b(i, i3)));
        int i4 = 18;
        d dVar5 = new d(5, 18, 18, 16, 16, new c(14, new b(i, i4)));
        d dVar6 = new d(6, 20, 20, 18, 18, new c(i4, new b(i, 22)));
        d dVar7 = new d(7, 22, 22, 20, 20, new c(20, new b(i, 30)));
        int i5 = 36;
        d dVar8 = new d(8, 24, 24, 22, 22, new c(24, new b(i, i5)));
        d dVar9 = new d(9, 26, 26, 24, 24, new c(28, new b(i, 44)));
        d dVar10 = new d(10, 32, 32, 14, 14, new c(i5, new b(i, 62)));
        int i6 = 42;
        int i7 = 56;
        int i8 = 2;
        int i9 = 4;
        return new d[]{dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, dVar8, dVar9, dVar10, new d(11, 36, 36, 16, 16, new c(i6, new b(i, 86))), new d(12, 40, 40, 18, 18, new c(48, new b(i, 114))), new d(13, 44, 44, 20, 20, new c(i7, new b(i, Opcodes.D2F))), new d(14, 48, 48, 22, 22, new c(68, new b(i, Opcodes.FRETURN))), new d(15, 52, 52, 24, 24, new c(i6, new b(i8, 102))), new d(16, 64, 64, 14, 14, new c(i7, new b(i8, Opcodes.F2L))), new d(17, 72, 72, 16, 16, new c(36, new b(i9, 92))), new d(18, 80, 80, 18, 18, new c(48, new b(i9, 114))), new d(19, 88, 88, 20, 20, new c(i7, new b(i9, Opcodes.D2F))), new d(20, 96, 96, 22, 22, new c(68, new b(i9, Opcodes.FRETURN))), new d(21, 104, 104, 24, 24, new c(i7, new b(6, Opcodes.L2I))), new d(22, 120, 120, 18, 18, new c(68, new b(6, Opcodes.DRETURN))), new d(23, Opcodes.IINC, Opcodes.IINC, 20, 20, new c(62, new b(8, 163))), new d(24, Opcodes.D2F, Opcodes.D2F, 22, 22, new c(62, new b(8, 156), new b(i8, 155))), new d(25, 8, 18, 6, 16, new c(7, new b(1, 5))), new d(26, 8, 32, 6, 14, new c(11, new b(1, 10))), new d(27, 12, 26, 10, 24, new c(14, new b(1, 16))), new d(28, 12, 36, 10, 16, new c(18, new b(1, 22))), new d(29, 16, 36, 14, 16, new c(24, new b(1, 32))), new d(30, 16, 48, 14, 22, new c(28, new b(1, 49)))};
    }

    public static d h(int i, int i2) throws FormatException {
        if ((i & 1) != 0 || (i2 & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        for (d dVar : h) {
            if (dVar.b == i && dVar.c == i2) {
                return dVar;
            }
        }
        throw FormatException.getFormatInstance();
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.d;
    }

    c d() {
        return this.f;
    }

    public int e() {
        return this.c;
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return this.g;
    }

    public int i() {
        return this.a;
    }

    public String toString() {
        return String.valueOf(this.a);
    }

    static final class c {
        private final int a;
        private final b[] b;

        b[] a() {
            return this.b;
        }

        int b() {
            return this.a;
        }

        private c(int i, b bVar) {
            this.a = i;
            this.b = new b[]{bVar};
        }

        private c(int i, b bVar, b bVar2) {
            this.a = i;
            this.b = new b[]{bVar, bVar2};
        }
    }
}
