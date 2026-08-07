package okio.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.jieli.jl_rcsp.constant.WatchConstant;
import defpackage.ar0;
import defpackage.d63;
import defpackage.hm0;
import defpackage.hu1;
import defpackage.hz1;
import defpackage.k83;
import defpackage.lm0;
import defpackage.o00;
import defpackage.or0;
import defpackage.p31;
import defpackage.so;
import defpackage.ty;
import defpackage.ul3;
import defpackage.vl3;
import defpackage.xm0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import kotlin.collections.j;
import kotlin.collections.u;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.i;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ZipFilesKt {

    public static final class a implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return o00.a(((ul3) obj).a(), ((ul3) obj2).a());
        }
    }

    private static final Map a(List list) {
        hz1 hz1VarE = hz1.a.e(hz1.b, WatchConstant.FAT_FS_ROOT, false, 1, null);
        Map mapH = u.h(d63.a(hz1VarE, new ul3(hz1VarE, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null)));
        for (ul3 ul3Var : j.U(list, new a())) {
            if (((ul3) mapH.put(ul3Var.a(), ul3Var)) == null) {
                while (true) {
                    hz1 hz1VarH = ul3Var.a().h();
                    if (hz1VarH == null) {
                        break;
                    }
                    ul3 ul3Var2 = (ul3) mapH.get(hz1VarH);
                    if (ul3Var2 != null) {
                        ul3Var2.b().add(ul3Var.a());
                        break;
                    }
                    ul3 ul3Var3 = new ul3(hz1VarH, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null);
                    mapH.put(hz1VarH, ul3Var3);
                    ul3Var3.b().add(ul3Var.a());
                    ul3Var = ul3Var3;
                }
            }
        }
        return mapH;
    }

    private static final Long b(int i, int i2) {
        if (i2 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        gregorianCalendar.set(((i >> 9) & 127) + 1980, ((i >> 5) & 15) - 1, i & 31, (i2 >> 11) & 31, (i2 >> 5) & 63, (i2 & 31) << 1);
        return Long.valueOf(gregorianCalendar.getTime().getTime());
    }

    private static final String c(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        String string = Integer.toString(i, kotlin.text.a.a(16));
        p31.e(string, "toString(this, checkRadix(radix))");
        sb.append(string);
        return sb.toString();
    }

    public static final vl3 d(hz1 hz1Var, xm0 xm0Var, ar0 ar0Var) throws IOException {
        p31.f(hz1Var, "zipPath");
        p31.f(xm0Var, "fileSystem");
        p31.f(ar0Var, "predicate");
        hm0 hm0VarE = xm0Var.e(hz1Var);
        try {
            long size = hm0VarE.size() - ((long) 22);
            if (size < 0) {
                throw new IOException("not a zip: size=" + hm0VarE.size());
            }
            long jMax = Math.max(size - PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH, 0L);
            do {
                so soVarB = hu1.b(hm0VarE.g0(size));
                try {
                    if (soVarB.o0() == 101010256) {
                        okio.internal.a aVarF = f(soVarB);
                        String strS = soVarB.s(aVarF.b());
                        soVarB.close();
                        long j = size - ((long) 20);
                        if (j > 0) {
                            so soVarB2 = hu1.b(hm0VarE.g0(j));
                            try {
                                if (soVarB2.o0() == 117853008) {
                                    int iO0 = soVarB2.o0();
                                    long jZ0 = soVarB2.z0();
                                    if (soVarB2.o0() != 1 || iO0 != 0) {
                                        throw new IOException("unsupported zip: spanned");
                                    }
                                    so soVarB3 = hu1.b(hm0VarE.g0(jZ0));
                                    try {
                                        int iO1 = soVarB3.o0();
                                        if (iO1 != 101075792) {
                                            throw new IOException("bad zip: expected " + c(101075792) + " but was " + c(iO1));
                                        }
                                        aVarF = j(soVarB3, aVarF);
                                        k83 k83Var = k83.a;
                                        ty.a(soVarB3, null);
                                    } catch (Throwable th) {
                                        try {
                                            throw th;
                                        } catch (Throwable th2) {
                                            ty.a(soVarB3, th);
                                            throw th2;
                                        }
                                    }
                                    try {
                                        throw th;
                                    } catch (Throwable th3) {
                                        ty.a(hm0VarE, th);
                                        throw th3;
                                    }
                                }
                                k83 k83Var2 = k83.a;
                                ty.a(soVarB2, null);
                            } catch (Throwable th4) {
                                try {
                                    throw th4;
                                } catch (Throwable th5) {
                                    ty.a(soVarB2, th4);
                                    throw th5;
                                }
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        so soVarB4 = hu1.b(hm0VarE.g0(aVarF.a()));
                        try {
                            long jC = aVarF.c();
                            for (long j2 = 0; j2 < jC; j2++) {
                                ul3 ul3VarE = e(soVarB4);
                                if (ul3VarE.d() >= aVarF.a()) {
                                    throw new IOException("bad zip: local file header offset >= central directory offset");
                                }
                                if (((Boolean) ar0Var.invoke(ul3VarE)).booleanValue()) {
                                    arrayList.add(ul3VarE);
                                }
                            }
                            k83 k83Var3 = k83.a;
                            ty.a(soVarB4, null);
                            vl3 vl3Var = new vl3(hz1Var, xm0Var, a(arrayList), strS);
                            ty.a(hm0VarE, null);
                            return vl3Var;
                        } catch (Throwable th6) {
                            try {
                                throw th6;
                            } catch (Throwable th7) {
                                ty.a(soVarB4, th6);
                                throw th7;
                            }
                        }
                    }
                    soVarB.close();
                    size--;
                } catch (Throwable th8) {
                    soVarB.close();
                    throw th8;
                }
            } while (size >= jMax);
            throw new IOException("not a zip: end of central directory signature not found");
        } catch (Throwable th9) {
            throw th9;
        }
    }

    public static final ul3 e(final so soVar) throws IOException {
        p31.f(soVar, "<this>");
        int iO0 = soVar.o0();
        if (iO0 != 33639248) {
            throw new IOException("bad zip: expected " + c(33639248) + " but was " + c(iO0));
        }
        soVar.a(4L);
        short sX0 = soVar.x0();
        int i = sX0 & 65535;
        if ((sX0 & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + c(i));
        }
        int iX0 = soVar.x0() & 65535;
        Long lB = b(soVar.x0() & 65535, soVar.x0() & 65535);
        long jO0 = ((long) soVar.o0()) & 4294967295L;
        final Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.element = ((long) soVar.o0()) & 4294967295L;
        final Ref$LongRef ref$LongRef2 = new Ref$LongRef();
        ref$LongRef2.element = ((long) soVar.o0()) & 4294967295L;
        int iX1 = soVar.x0() & 65535;
        int iX2 = soVar.x0() & 65535;
        int iX3 = soVar.x0() & 65535;
        soVar.a(8L);
        final Ref$LongRef ref$LongRef3 = new Ref$LongRef();
        ref$LongRef3.element = ((long) soVar.o0()) & 4294967295L;
        String strS = soVar.s(iX1);
        if (i.L(strS, (char) 0, false, 2, null)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        long j = ref$LongRef2.element == 4294967295L ? 8 : 0L;
        long j2 = ref$LongRef.element == 4294967295L ? j + ((long) 8) : j;
        if (ref$LongRef3.element == 4294967295L) {
            j2 += (long) 8;
        }
        final long j3 = j2;
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        g(soVar, iX2, new or0() { // from class: okio.internal.ZipFilesKt$readEntry$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // defpackage.or0
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws IOException {
                invoke(((Number) obj).intValue(), ((Number) obj2).longValue());
                return k83.a;
            }

            public final void invoke(int i2, long j4) throws IOException {
                if (i2 == 1) {
                    Ref$BooleanRef ref$BooleanRef2 = ref$BooleanRef;
                    if (ref$BooleanRef2.element) {
                        throw new IOException("bad zip: zip64 extra repeated");
                    }
                    ref$BooleanRef2.element = true;
                    if (j4 < j3) {
                        throw new IOException("bad zip: zip64 extra too short");
                    }
                    Ref$LongRef ref$LongRef4 = ref$LongRef2;
                    long jZ0 = ref$LongRef4.element;
                    if (jZ0 == 4294967295L) {
                        jZ0 = soVar.z0();
                    }
                    ref$LongRef4.element = jZ0;
                    Ref$LongRef ref$LongRef5 = ref$LongRef;
                    ref$LongRef5.element = ref$LongRef5.element == 4294967295L ? soVar.z0() : 0L;
                    Ref$LongRef ref$LongRef6 = ref$LongRef3;
                    ref$LongRef6.element = ref$LongRef6.element == 4294967295L ? soVar.z0() : 0L;
                }
            }
        });
        if (j3 <= 0 || ref$BooleanRef.element) {
            return new ul3(hz1.a.e(hz1.b, WatchConstant.FAT_FS_ROOT, false, 1, null).l(strS), i.u(strS, WatchConstant.FAT_FS_ROOT, false, 2, null), soVar.s(iX3), jO0, ref$LongRef.element, ref$LongRef2.element, iX0, lB, ref$LongRef3.element);
        }
        throw new IOException("bad zip: zip64 extra required but absent");
    }

    private static final okio.internal.a f(so soVar) throws IOException {
        int iX0 = soVar.x0() & 65535;
        int iX1 = soVar.x0() & 65535;
        long jX0 = soVar.x0() & 65535;
        if (jX0 != (soVar.x0() & 65535) || iX0 != 0 || iX1 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        soVar.a(4L);
        return new okio.internal.a(jX0, 4294967295L & ((long) soVar.o0()), soVar.x0() & 65535);
    }

    private static final void g(so soVar, int i, or0 or0Var) throws IOException {
        long j = i;
        while (j != 0) {
            if (j < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int iX0 = soVar.x0() & 65535;
            long jX0 = ((long) soVar.x0()) & 65535;
            long j2 = j - ((long) 4);
            if (j2 < jX0) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            soVar.B0(jX0);
            long size = soVar.b().size();
            or0Var.invoke(Integer.valueOf(iX0), Long.valueOf(jX0));
            long size2 = (soVar.b().size() + jX0) - size;
            if (size2 < 0) {
                throw new IOException("unsupported zip: too many bytes processed for " + iX0);
            }
            if (size2 > 0) {
                soVar.b().a(size2);
            }
            j = j2 - jX0;
        }
    }

    public static final lm0 h(so soVar, lm0 lm0Var) throws IOException {
        p31.f(soVar, "<this>");
        p31.f(lm0Var, "basicMetadata");
        lm0 lm0VarI = i(soVar, lm0Var);
        p31.c(lm0VarI);
        return lm0VarI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final lm0 i(final so soVar, lm0 lm0Var) throws IOException {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = lm0Var != null ? lm0Var.a() : 0;
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        int iO0 = soVar.o0();
        if (iO0 != 67324752) {
            throw new IOException("bad zip: expected " + c(67324752) + " but was " + c(iO0));
        }
        soVar.a(2L);
        short sX0 = soVar.x0();
        int i = sX0 & 65535;
        if ((sX0 & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + c(i));
        }
        soVar.a(18L);
        long jX0 = ((long) soVar.x0()) & 65535;
        int iX0 = soVar.x0() & 65535;
        soVar.a(jX0);
        if (lm0Var == null) {
            soVar.a(iX0);
            return null;
        }
        g(soVar, iX0, new or0() { // from class: okio.internal.ZipFilesKt$readOrSkipLocalHeader$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // defpackage.or0
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws IOException {
                invoke(((Number) obj).intValue(), ((Number) obj2).longValue());
                return k83.a;
            }

            /* JADX WARN: Type inference failed for: r0v13, types: [T, java.lang.Long] */
            /* JADX WARN: Type inference failed for: r10v11, types: [T, java.lang.Long] */
            /* JADX WARN: Type inference failed for: r11v3, types: [T, java.lang.Long] */
            public final void invoke(int i2, long j) throws IOException {
                if (i2 == 21589) {
                    if (j < 1) {
                        throw new IOException("bad zip: extended timestamp extra too short");
                    }
                    byte b = soVar.readByte();
                    boolean z = (b & 1) == 1;
                    boolean z2 = (b & 2) == 2;
                    boolean z3 = (b & 4) == 4;
                    so soVar2 = soVar;
                    long j2 = z ? 5L : 1L;
                    if (z2) {
                        j2 += 4;
                    }
                    if (z3) {
                        j2 += 4;
                    }
                    if (j < j2) {
                        throw new IOException("bad zip: extended timestamp extra too short");
                    }
                    if (z) {
                        ref$ObjectRef.element = Long.valueOf(((long) soVar2.o0()) * 1000);
                    }
                    if (z2) {
                        ref$ObjectRef2.element = Long.valueOf(((long) soVar.o0()) * 1000);
                    }
                    if (z3) {
                        ref$ObjectRef3.element = Long.valueOf(((long) soVar.o0()) * 1000);
                    }
                }
            }
        });
        return new lm0(lm0Var.e(), lm0Var.d(), null, lm0Var.b(), (Long) ref$ObjectRef3.element, (Long) ref$ObjectRef.element, (Long) ref$ObjectRef2.element, null, 128, null);
    }

    private static final okio.internal.a j(so soVar, okio.internal.a aVar) throws IOException {
        soVar.a(12L);
        int iO0 = soVar.o0();
        int iO1 = soVar.o0();
        long jZ0 = soVar.z0();
        if (jZ0 != soVar.z0() || iO0 != 0 || iO1 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        soVar.a(8L);
        return new okio.internal.a(jZ0, soVar.z0(), aVar.b());
    }
}
