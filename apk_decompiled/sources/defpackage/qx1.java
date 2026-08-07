package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.collections.d;
import kotlin.collections.j;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class qx1 extends kotlin.collections.a implements RandomAccess {
    public static final a c = new a(null);
    private final ByteString[] a;
    private final int[] b;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private final void a(long j, fo foVar, int i, List list, int i2, int i3, List list2) {
            int i4;
            int i5;
            int i6;
            int i7 = i;
            if (i2 >= i3) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            for (int i8 = i2; i8 < i3; i8++) {
                if (((ByteString) list.get(i8)).size() < i7) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
            ByteString byteString = (ByteString) list.get(i2);
            ByteString byteString2 = (ByteString) list.get(i3 - 1);
            int i9 = -1;
            if (i7 == byteString.size()) {
                int iIntValue = ((Number) list2.get(i2)).intValue();
                int i10 = i2 + 1;
                ByteString byteString3 = (ByteString) list.get(i10);
                i4 = i10;
                i5 = iIntValue;
                byteString = byteString3;
            } else {
                i4 = i2;
                i5 = -1;
            }
            if (byteString.getByte(i7) == byteString2.getByte(i7)) {
                int iMin = Math.min(byteString.size(), byteString2.size());
                int i11 = 0;
                for (int i12 = i7; i12 < iMin && byteString.getByte(i12) == byteString2.getByte(i12); i12++) {
                    i11++;
                }
                long jC = j + c(foVar) + ((long) 2) + ((long) i11) + 1;
                foVar.F(-i11);
                foVar.F(i5);
                int i13 = i11 + i7;
                while (i7 < i13) {
                    foVar.F(byteString.getByte(i7) & 255);
                    i7++;
                }
                if (i4 + 1 == i3) {
                    if (i13 != ((ByteString) list.get(i4)).size()) {
                        throw new IllegalStateException("Check failed.");
                    }
                    foVar.F(((Number) list2.get(i4)).intValue());
                    return;
                } else {
                    fo foVar2 = new fo();
                    foVar.F(((int) (c(foVar2) + jC)) * (-1));
                    a(jC, foVar2, i13, list, i4, i3, list2);
                    foVar.L(foVar2);
                    return;
                }
            }
            int i14 = 1;
            for (int i15 = i4 + 1; i15 < i3; i15++) {
                if (((ByteString) list.get(i15 - 1)).getByte(i7) != ((ByteString) list.get(i15)).getByte(i7)) {
                    i14++;
                }
            }
            long jC2 = j + c(foVar) + ((long) 2) + ((long) (i14 * 2));
            foVar.F(i14);
            foVar.F(i5);
            for (int i16 = i4; i16 < i3; i16++) {
                byte b = ((ByteString) list.get(i16)).getByte(i7);
                if (i16 == i4 || b != ((ByteString) list.get(i16 - 1)).getByte(i7)) {
                    foVar.F(b & 255);
                }
            }
            fo foVar3 = new fo();
            while (i4 < i3) {
                byte b2 = ((ByteString) list.get(i4)).getByte(i7);
                int i17 = i4 + 1;
                int i18 = i17;
                while (true) {
                    if (i18 >= i3) {
                        i6 = i3;
                        break;
                    } else {
                        if (b2 != ((ByteString) list.get(i18)).getByte(i7)) {
                            i6 = i18;
                            break;
                        }
                        i18++;
                    }
                }
                if (i17 == i6 && i7 + 1 == ((ByteString) list.get(i4)).size()) {
                    foVar.F(((Number) list2.get(i4)).intValue());
                } else {
                    foVar.F(((int) (jC2 + c(foVar3))) * i9);
                    a(jC2, foVar3, i7 + 1, list, i4, i6, list2);
                }
                foVar3 = foVar3;
                i4 = i6;
                i9 = -1;
            }
            foVar.L(foVar3);
        }

        static /* synthetic */ void b(a aVar, long j, fo foVar, int i, List list, int i2, int i3, List list2, int i4, Object obj) {
            aVar.a((i4 & 1) != 0 ? 0L : j, foVar, (i4 & 4) != 0 ? 0 : i, list, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? list.size() : i3, list2);
        }

        private final long c(fo foVar) {
            return foVar.size() / ((long) 4);
        }

        public final qx1 d(ByteString... byteStringArr) {
            p31.f(byteStringArr, "byteStrings");
            y70 y70Var = null;
            int i = 0;
            if (byteStringArr.length == 0) {
                return new qx1(new ByteString[0], new int[]{0, -1}, y70Var);
            }
            List listE = d.E(byteStringArr);
            j.u(listE);
            ArrayList arrayList = new ArrayList(byteStringArr.length);
            for (ByteString byteString : byteStringArr) {
                arrayList.add(-1);
            }
            Integer[] numArr = (Integer[]) arrayList.toArray(new Integer[0]);
            List listO = j.o(Arrays.copyOf(numArr, numArr.length));
            int length = byteStringArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                listO.set(j.i(listE, byteStringArr[i2], 0, 0, 6, null), Integer.valueOf(i3));
                i2++;
                i3++;
            }
            if (((ByteString) listE.get(0)).size() <= 0) {
                throw new IllegalArgumentException("the empty byte string is not a supported option");
            }
            int i4 = 0;
            while (i4 < listE.size()) {
                ByteString byteString2 = (ByteString) listE.get(i4);
                int i5 = i4 + 1;
                int i6 = i5;
                while (i6 < listE.size()) {
                    ByteString byteString3 = (ByteString) listE.get(i6);
                    if (!byteString3.startsWith(byteString2)) {
                        break;
                    }
                    if (byteString3.size() == byteString2.size()) {
                        throw new IllegalArgumentException(("duplicate option: " + byteString3).toString());
                    }
                    if (((Number) listO.get(i6)).intValue() > ((Number) listO.get(i4)).intValue()) {
                        listE.remove(i6);
                        listO.remove(i6);
                    } else {
                        i6++;
                    }
                }
                i4 = i5;
            }
            fo foVar = new fo();
            b(this, 0L, foVar, 0, listE, 0, 0, listO, 53, null);
            int[] iArr = new int[(int) c(foVar)];
            while (!foVar.H()) {
                iArr[i] = foVar.readInt();
                i++;
            }
            Object[] objArrCopyOf = Arrays.copyOf(byteStringArr, byteStringArr.length);
            p31.e(objArrCopyOf, "copyOf(this, size)");
            return new qx1((ByteString[]) objArrCopyOf, iArr, y70Var);
        }

        private a() {
        }
    }

    public /* synthetic */ qx1(ByteString[] byteStringArr, int[] iArr, y70 y70Var) {
        this(byteStringArr, iArr);
    }

    public /* bridge */ boolean c(ByteString byteString) {
        return super.contains(byteString);
    }

    @Override // defpackage.x0, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return c((ByteString) obj);
        }
        return false;
    }

    @Override // kotlin.collections.a, java.util.List
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ByteString get(int i) {
        return this.a[i];
    }

    public final ByteString[] e() {
        return this.a;
    }

    public final int[] f() {
        return this.b;
    }

    public /* bridge */ int g(ByteString byteString) {
        return super.indexOf(byteString);
    }

    @Override // defpackage.x0
    public int getSize() {
        return this.a.length;
    }

    public /* bridge */ int h(ByteString byteString) {
        return super.lastIndexOf(byteString);
    }

    @Override // kotlin.collections.a, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return g((ByteString) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.a, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return h((ByteString) obj);
        }
        return -1;
    }

    private qx1(ByteString[] byteStringArr, int[] iArr) {
        this.a = byteStringArr;
        this.b = iArr;
    }
}
