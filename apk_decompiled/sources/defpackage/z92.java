package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.oned.rss.expanded.decoders.j;
import com.jieli.jl_rcsp.constant.Command;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public final class z92 extends p1 {
    private static final int[] k = {7, 5, 4, 3, 1};
    private static final int[] l = {4, 20, 52, 104, 204};
    private static final int[] m = {0, 348, 1388, 2948, 3988};
    private static final int[][] n = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] o = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, Opcodes.GETFIELD, 118, Opcodes.D2L, 7, 21, 63}, new int[]{Opcodes.ANEWARRAY, Opcodes.I2B, 13, 39, 117, Opcodes.F2L, 209, 205}, new int[]{193, 157, 49, Opcodes.I2S, 19, 57, Opcodes.LOOKUPSWITCH, 91}, new int[]{62, Opcodes.INVOKEDYNAMIC, Opcodes.L2I, Opcodes.MULTIANEWARRAY, Opcodes.RET, 85, 44, Opcodes.IINC}, new int[]{Opcodes.INVOKEINTERFACE, 133, Opcodes.NEWARRAY, Opcodes.D2I, 4, 12, 36, 108}, new int[]{113, 128, Opcodes.LRETURN, 97, 80, 29, 87, 50}, new int[]{Opcodes.FCMPG, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, Opcodes.L2D, 203, Opcodes.NEW, Opcodes.F2I, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, Opcodes.LOR, Opcodes.ARETURN, 106, 107, 110, 119, Opcodes.I2C}, new int[]{16, 48, Opcodes.D2F, 10, 30, 90, 59, Opcodes.RETURN}, new int[]{109, 116, Opcodes.L2F, 200, Opcodes.GETSTATIC, 112, 125, 164}, new int[]{70, Command.CMD_RECEIVE_SPEECH_CANCEL, Command.CMD_NOTIFY_DEVICE_APP_INFO, 202, Opcodes.INVOKESTATIC, 130, Opcodes.PUTSTATIC, 115}, new int[]{Opcodes.I2F, Opcodes.ATHROW, Opcodes.DCMPL, 31, 93, 68, 204, Opcodes.ARRAYLENGTH}, new int[]{Opcodes.LCMP, 22, 66, Opcodes.IFNULL, Opcodes.IRETURN, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, Opcodes.FCMPL, 25, 75, 14, 42, 126, Opcodes.GOTO}, new int[]{79, 26, 78, 23, 69, 207, Opcodes.IFNONNULL, Opcodes.DRETURN}, new int[]{103, 98, 83, 38, 114, Opcodes.LXOR, Opcodes.INVOKEVIRTUAL, 124}, new int[]{161, 61, Opcodes.INVOKESPECIAL, 127, Opcodes.TABLESWITCH, 88, 53, Opcodes.IF_ICMPEQ}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, Opcodes.I2D, 194, 160, 58, Opcodes.FRETURN, 100, 89}};
    private static final int[][] p = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    private final List g = new ArrayList(11);
    private final List h = new ArrayList();
    private final int[] i = new int[2];
    private boolean j;

    private static boolean A(mn0 mn0Var, boolean z, boolean z2) {
        return (mn0Var.c() == 0 && z && z2) ? false : true;
    }

    private static boolean B(Iterable iterable, Iterable iterable2) {
        Iterator it = iterable2.iterator();
        while (it.hasNext()) {
            lj0 lj0Var = (lj0) it.next();
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                kj0 kj0Var = (kj0) it2.next();
                Iterator it3 = lj0Var.a().iterator();
                while (true) {
                    if (it3.hasNext()) {
                        if (kj0Var.equals((kj0) it3.next())) {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    private static boolean C(List list) {
        for (int[] iArr : p) {
            if (list.size() <= iArr.length) {
                for (int i = 0; i < list.size(); i++) {
                    if (((kj0) list.get(i)).b().c() == iArr[i]) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    private mn0 D(uh uhVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (z) {
            int i5 = this.i[0] - 1;
            while (i5 >= 0 && !uhVar.c(i5)) {
                i5--;
            }
            int i6 = i5 + 1;
            int[] iArr = this.i;
            i4 = iArr[0] - i6;
            i2 = iArr[1];
            i3 = i6;
        } else {
            int[] iArr2 = this.i;
            int i7 = iArr2[0];
            int iF = uhVar.f(iArr2[1] + 1);
            i2 = iF;
            i3 = i7;
            i4 = iF - this.i[1];
        }
        int[] iArrJ = j();
        System.arraycopy(iArrJ, 0, iArrJ, 1, iArrJ.length - 1);
        iArrJ[0] = i4;
        try {
            return new mn0(p1.q(iArrJ, n), new int[]{i3, i2}, i3, i2, i);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private static void E(List list, List list2) {
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            lj0 lj0Var = (lj0) it.next();
            if (lj0Var.a().size() != list.size()) {
                Iterator it2 = lj0Var.a().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        it.remove();
                        break;
                    }
                    kj0 kj0Var = (kj0) it2.next();
                    Iterator it3 = list.iterator();
                    do {
                        if (!it3.hasNext()) {
                            break;
                        }
                    } while (!kj0Var.equals((kj0) it3.next()));
                }
            }
        }
    }

    private static void G(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length / 2; i++) {
            int i2 = iArr[i];
            int i3 = (length - i) - 1;
            iArr[i] = iArr[i3];
            iArr[i3] = i2;
        }
    }

    private void H(int i, boolean z) {
        boolean zC = false;
        int i2 = 0;
        boolean zC2 = false;
        while (i2 < this.h.size()) {
            lj0 lj0Var = (lj0) this.h.get(i2);
            if (lj0Var.b() > i) {
                zC = lj0Var.c(this.g);
                break;
            } else {
                zC2 = lj0Var.c(this.g);
                i2++;
            }
        }
        if (zC || zC2 || B(this.g, this.h)) {
            return;
        }
        this.h.add(i2, new lj0(this.g, i, z));
        E(this.g, this.h);
    }

    /* JADX WARN: Code duplicated, block: B:53:0x0080 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x0082  */
    /* JADX WARN: Code duplicated, block: B:55:0x008e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0095  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:71:? A[RETURN, SYNTHETIC] */
    private void r(int i) throws NotFoundException {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int iD = dh1.d(m());
        int iD2 = dh1.d(k());
        boolean z5 = true;
        if (iD > 13) {
            z2 = true;
            z = false;
        } else if (iD < 4) {
            z = true;
            z2 = false;
        } else {
            z = false;
            z2 = false;
        }
        if (iD2 > 13) {
            z4 = true;
            z3 = false;
        } else if (iD2 < 4) {
            z3 = true;
            z4 = false;
        } else {
            z3 = false;
            z4 = false;
        }
        int i2 = (iD + iD2) - i;
        boolean z6 = (iD & 1) == 1;
        boolean z7 = (iD2 & 1) == 0;
        if (i2 != 1) {
            if (i2 == -1) {
                if (z6) {
                    if (z7) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                } else {
                    if (!z7) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    z3 = true;
                }
            } else {
                if (i2 != 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (z6) {
                    if (!z7) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    if (iD < iD2) {
                        z4 = true;
                    } else {
                        z3 = true;
                        z2 = true;
                    }
                } else if (z7) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            if (z5) {
                if (!z2) {
                    throw NotFoundException.getNotFoundInstance();
                }
                p1.o(m(), n());
            }
            if (z2) {
                p1.h(m(), n());
            }
            if (z3) {
                if (!z4) {
                    throw NotFoundException.getNotFoundInstance();
                }
                p1.o(k(), n());
            }
            if (z4) {
                p1.h(k(), l());
            }
        }
        if (z6) {
            if (z7) {
                throw NotFoundException.getNotFoundInstance();
            }
            z2 = true;
        } else {
            if (!z7) {
                throw NotFoundException.getNotFoundInstance();
            }
            z4 = true;
        }
        z5 = z;
        if (z5) {
            if (!z2) {
                throw NotFoundException.getNotFoundInstance();
            }
            p1.o(m(), n());
        }
        if (z2) {
            p1.h(m(), n());
        }
        if (z3) {
            if (!z4) {
                throw NotFoundException.getNotFoundInstance();
            }
            p1.o(k(), n());
        }
        if (z4) {
            p1.h(k(), l());
        }
    }

    private boolean s() {
        kj0 kj0Var = (kj0) this.g.get(0);
        x50 x50VarC = kj0Var.c();
        x50 x50VarD = kj0Var.d();
        if (x50VarD == null) {
            return false;
        }
        int iA = x50VarD.a();
        int i = 2;
        for (int i2 = 1; i2 < this.g.size(); i2++) {
            kj0 kj0Var2 = (kj0) this.g.get(i2);
            iA += kj0Var2.c().a();
            int i3 = i + 1;
            x50 x50VarD2 = kj0Var2.d();
            if (x50VarD2 != null) {
                iA += x50VarD2.a();
                i += 2;
            } else {
                i = i3;
            }
        }
        return ((i + (-4)) * 211) + (iA % 211) == x50VarC.b();
    }

    private List t(List list, int i) throws NotFoundException {
        while (i < this.h.size()) {
            lj0 lj0Var = (lj0) this.h.get(i);
            this.g.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.g.addAll(((lj0) it.next()).a());
            }
            this.g.addAll(lj0Var.a());
            if (C(this.g)) {
                if (s()) {
                    return this.g;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(lj0Var);
                try {
                    return t(arrayList, i + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private List u(boolean z) {
        List listT = null;
        if (this.h.size() > 25) {
            this.h.clear();
            return null;
        }
        this.g.clear();
        if (z) {
            Collections.reverse(this.h);
        }
        try {
            listT = t(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z) {
            Collections.reverse(this.h);
        }
        return listT;
    }

    static kh2 v(List list) {
        String strD = j.a(vh.a(list)).d();
        nh2[] nh2VarArrA = ((kj0) list.get(0)).b().a();
        nh2[] nh2VarArrA2 = ((kj0) list.get(list.size() - 1)).b().a();
        return new kh2(strD, null, new nh2[]{nh2VarArrA[0], nh2VarArrA[1], nh2VarArrA2[0], nh2VarArrA2[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    private void y(uh uhVar, List list, int i) throws NotFoundException {
        int[] iArrJ = j();
        iArrJ[0] = 0;
        iArrJ[1] = 0;
        iArrJ[2] = 0;
        iArrJ[3] = 0;
        int iG = uhVar.g();
        if (i < 0) {
            i = list.isEmpty() ? 0 : ((kj0) list.get(list.size() - 1)).b().b()[1];
        }
        boolean z = list.size() % 2 != 0;
        if (this.j) {
            z = !z;
        }
        boolean z2 = false;
        while (i < iG) {
            boolean zC = uhVar.c(i);
            boolean z3 = !zC;
            if (zC) {
                z2 = z3;
                break;
            } else {
                i++;
                z2 = z3;
            }
        }
        int i2 = 0;
        boolean z4 = z2;
        int i3 = i;
        while (i < iG) {
            if (uhVar.c(i) ^ z4) {
                iArrJ[i2] = iArrJ[i2] + 1;
            } else {
                if (i2 == 3) {
                    if (z) {
                        G(iArrJ);
                    }
                    if (p1.p(iArrJ)) {
                        int[] iArr = this.i;
                        iArr[0] = i3;
                        iArr[1] = i;
                        return;
                    }
                    if (z) {
                        G(iArrJ);
                    }
                    i3 += iArrJ[0] + iArrJ[1];
                    iArrJ[0] = iArrJ[2];
                    iArrJ[1] = iArrJ[3];
                    iArrJ[2] = 0;
                    iArrJ[3] = 0;
                    i2--;
                } else {
                    i2++;
                }
                iArrJ[i2] = 1;
                z4 = !z4;
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int z(uh uhVar, int i) {
        return uhVar.c(i) ? uhVar.e(uhVar.f(i)) : uhVar.f(uhVar.e(i));
    }

    kj0 F(uh uhVar, List list, int i) throws NotFoundException {
        mn0 mn0VarD;
        x50 x50VarW;
        boolean z = list.size() % 2 == 0;
        if (this.j) {
            z = !z;
        }
        int iZ = -1;
        boolean z2 = true;
        do {
            y(uhVar, list, iZ);
            mn0VarD = D(uhVar, i, z);
            if (mn0VarD == null) {
                iZ = z(uhVar, this.i[0]);
            } else {
                z2 = false;
            }
        } while (z2);
        x50 x50VarW2 = w(uhVar, mn0VarD, z, true);
        if (!list.isEmpty() && ((kj0) list.get(list.size() - 1)).f()) {
            throw NotFoundException.getNotFoundInstance();
        }
        try {
            x50VarW = w(uhVar, mn0VarD, z, false);
        } catch (NotFoundException unused) {
            x50VarW = null;
        }
        return new kj0(x50VarW2, x50VarW, mn0VarD, true);
    }

    @Override // defpackage.nw1, defpackage.cd2
    public void b() {
        this.g.clear();
        this.h.clear();
    }

    @Override // defpackage.nw1
    public kh2 c(int i, uh uhVar, Map map) {
        this.g.clear();
        this.j = false;
        try {
            return v(x(i, uhVar));
        } catch (NotFoundException unused) {
            this.g.clear();
            this.j = true;
            return v(x(i, uhVar));
        }
    }

    x50 w(uh uhVar, mn0 mn0Var, boolean z, boolean z2) throws NotFoundException {
        int[] iArrI = i();
        iArrI[0] = 0;
        iArrI[1] = 0;
        iArrI[2] = 0;
        iArrI[3] = 0;
        iArrI[4] = 0;
        iArrI[5] = 0;
        iArrI[6] = 0;
        iArrI[7] = 0;
        if (z2) {
            nw1.g(uhVar, mn0Var.b()[0], iArrI);
        } else {
            nw1.f(uhVar, mn0Var.b()[1], iArrI);
            int i = 0;
            for (int length = iArrI.length - 1; i < length; length--) {
                int i2 = iArrI[i];
                iArrI[i] = iArrI[length];
                iArrI[length] = i2;
                i++;
            }
        }
        float fD = dh1.d(iArrI) / 17.0f;
        float f = (mn0Var.b()[1] - mn0Var.b()[0]) / 15.0f;
        if (Math.abs(fD - f) / f > 0.3f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int[] iArrM = m();
        int[] iArrK = k();
        float[] fArrN = n();
        float[] fArrL = l();
        for (int i3 = 0; i3 < iArrI.length; i3++) {
            float f2 = (iArrI[i3] * 1.0f) / fD;
            int i4 = (int) (0.5f + f2);
            if (i4 <= 0) {
                if (f2 < 0.3f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i4 = 1;
            } else if (i4 > 8) {
                if (f2 > 8.7f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i4 = 8;
            }
            int i5 = i3 / 2;
            if ((i3 & 1) == 0) {
                iArrM[i5] = i4;
                fArrN[i5] = f2 - i4;
            } else {
                iArrK[i5] = i4;
                fArrL[i5] = f2 - i4;
            }
        }
        r(17);
        int iC = (((mn0Var.c() * 4) + (z ? 0 : 2)) + (!z2 ? 1 : 0)) - 1;
        int i6 = 0;
        int i7 = 0;
        for (int length2 = iArrM.length - 1; length2 >= 0; length2--) {
            if (A(mn0Var, z, z2)) {
                i6 += iArrM[length2] * o[iC][length2 * 2];
            }
            i7 += iArrM[length2];
        }
        int i8 = 0;
        for (int length3 = iArrK.length - 1; length3 >= 0; length3--) {
            if (A(mn0Var, z, z2)) {
                i8 += iArrK[length3] * o[iC][(length3 * 2) + 1];
            }
        }
        int i9 = i6 + i8;
        if ((i7 & 1) != 0 || i7 > 13 || i7 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i10 = (13 - i7) / 2;
        int i11 = k[i10];
        return new x50((aa2.b(iArrM, i11, true) * l[i10]) + aa2.b(iArrK, 9 - i11, false) + m[i10], i9);
    }

    List x(int i, uh uhVar) throws NotFoundException {
        while (true) {
            try {
                this.g.add(F(uhVar, this.g, i));
            } catch (NotFoundException e) {
                if (this.g.isEmpty()) {
                    throw e;
                }
                if (s()) {
                    return this.g;
                }
                boolean zIsEmpty = this.h.isEmpty();
                H(i, false);
                if (!zIsEmpty) {
                    List listU = u(false);
                    if (listU != null) {
                        return listU;
                    }
                    List listU2 = u(true);
                    if (listU2 != null) {
                        return listU2;
                    }
                }
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }
}
