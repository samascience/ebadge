package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.impl.SurfaceConfig;
import com.tenmeter.smlibrary.utils.FileUtils;
import defpackage.b52;
import defpackage.dy2;
import defpackage.ie0;
import defpackage.ir2;
import defpackage.iu;
import defpackage.k03;
import defpackage.m00;
import defpackage.nu;
import defpackage.qd3;
import defpackage.ra;
import defpackage.tv0;
import defpackage.uf2;
import defpackage.wj0;
import defpackage.xu;
import defpackage.xw2;
import defpackage.zs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class s2 {
    private final String i;
    private final d j;
    private final zs k;
    private final wj0 l;
    private final int m;
    private boolean n;
    private boolean o;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f152q;
    private boolean r;
    private boolean s;
    dy2 t;
    private final c2 v;
    private final d2 y;
    private final List a = new ArrayList();
    private final List b = new ArrayList();
    private final List c = new ArrayList();
    private final List d = new ArrayList();
    private final Map e = new HashMap();
    private final List f = new ArrayList();
    private final List g = new ArrayList();
    private final List h = new ArrayList();
    List u = new ArrayList();
    private final k03 w = new k03();
    private final uf2 x = new uf2();

    static class a {
        static Size[] a(StreamConfigurationMap streamConfigurationMap, int i) {
            return streamConfigurationMap.getHighResolutionOutputSizes(i);
        }
    }

    static abstract class b {
        b() {
        }

        static b e(int i, int i2, boolean z, boolean z2) {
            return new c(i, i2, z, z2);
        }

        abstract int a();

        abstract int b();

        abstract boolean c();

        abstract boolean d();
    }

    s2(Context context, String str, iu iuVar, d dVar) throws CameraUnavailableException {
        this.n = false;
        this.o = false;
        this.p = false;
        this.f152q = false;
        this.r = false;
        this.s = false;
        String str2 = (String) b52.g(str);
        this.i = str2;
        this.j = (d) b52.g(dVar);
        this.l = new wj0();
        this.v = c2.c(context);
        try {
            zs zsVarC = iuVar.c(str2);
            this.k = zsVarC;
            Integer num = (Integer) zsVarC.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            this.m = num != null ? num.intValue() : 2;
            int[] iArr = (int[]) zsVarC.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
            if (iArr != null) {
                for (int i : iArr) {
                    if (i == 3) {
                        this.n = true;
                    } else if (i == 6) {
                        this.o = true;
                    } else if (Build.VERSION.SDK_INT >= 31 && i == 16) {
                        this.r = true;
                    }
                }
            }
            d2 d2Var = new d2(this.k);
            this.y = d2Var;
            k();
            if (this.r) {
                n();
            }
            boolean zHasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.camera.concurrent");
            this.p = zHasSystemFeature;
            if (zHasSystemFeature) {
                h();
            }
            if (d2Var.d()) {
                g();
                if (J()) {
                    m();
                }
            }
            boolean zH = r2.h(this.k);
            this.f152q = zH;
            if (zH) {
                j();
            }
            boolean zA = qd3.a(this.k);
            this.s = zA;
            if (zA) {
                i();
            }
            l();
            b();
        } catch (CameraAccessExceptionCompat e) {
            throw xu.a(e);
        }
    }

    private List B(b bVar) {
        if (this.e.containsKey(bVar)) {
            return (List) this.e.get(bVar);
        }
        List arrayList = new ArrayList();
        if (bVar.b() == 8) {
            int iA = bVar.a();
            if (iA == 1) {
                arrayList = this.c;
            } else if (iA != 2) {
                arrayList.addAll(bVar.c() ? this.d : this.a);
            } else {
                arrayList.addAll(this.b);
                arrayList.addAll(this.a);
            }
        } else if (bVar.b() == 10 && bVar.a() == 0) {
            if (bVar.d()) {
                arrayList.addAll(this.g);
            } else {
                arrayList.addAll(this.f);
            }
        }
        this.e.put(bVar, arrayList);
        return arrayList;
    }

    private Pair C(int i, List list, List list2, List list3, List list4, int i2, Map map, Map map2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            androidx.camera.core.impl.a aVar = (androidx.camera.core.impl.a) it.next();
            arrayList.add(aVar.g());
            if (map != null) {
                map.put(Integer.valueOf(arrayList.size() - 1), aVar);
            }
        }
        for (int i3 = 0; i3 < list2.size(); i3++) {
            Size size = (Size) list2.get(i3);
            androidx.camera.core.impl.d0 d0Var = (androidx.camera.core.impl.d0) list3.get(((Integer) list4.get(i3)).intValue());
            int iP = d0Var.p();
            arrayList.add(SurfaceConfig.h(i, iP, size, F(iP)));
            if (map2 != null) {
                map2.put(Integer.valueOf(arrayList.size() - 1), d0Var);
            }
            i2 = E(i2, d0Var.p(), size);
        }
        return new Pair(arrayList, Integer.valueOf(i2));
    }

    private Range D(List list, List list2, List list3) {
        Iterator it = list.iterator();
        Range rangeG = null;
        while (it.hasNext()) {
            rangeG = G(((androidx.camera.core.impl.a) it.next()).h(), rangeG);
        }
        Iterator it2 = list3.iterator();
        while (it2.hasNext()) {
            rangeG = G(((androidx.camera.core.impl.d0) list2.get(((Integer) it2.next()).intValue())).J(null), rangeG);
        }
        return rangeG;
    }

    private int E(int i, int i2, Size size) {
        return Math.min(i, q(this.k, i2, size));
    }

    private Range G(Range range, Range range2) {
        if (range2 == null) {
            return range;
        }
        if (range != null) {
            try {
                return range2.intersect(range);
            } catch (IllegalArgumentException unused) {
            }
        }
        return range2;
    }

    private static List H(List list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int iN = ((androidx.camera.core.impl.d0) it.next()).N(0);
            if (!arrayList2.contains(Integer.valueOf(iN))) {
                arrayList2.add(Integer.valueOf(iN));
            }
        }
        Collections.sort(arrayList2);
        Collections.reverse(arrayList2);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            int iIntValue = ((Integer) it2.next()).intValue();
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                androidx.camera.core.impl.d0 d0Var = (androidx.camera.core.impl.d0) it3.next();
                if (iIntValue == d0Var.N(0)) {
                    arrayList.add(Integer.valueOf(list.indexOf(d0Var)));
                }
            }
        }
        return arrayList;
    }

    private static boolean I(List list, Map map) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((androidx.camera.core.impl.a) it.next()).d() == 4101) {
                return true;
            }
        }
        Iterator it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            if (((androidx.camera.core.impl.d0) it2.next()).p() == 4101) {
                return true;
            }
        }
        return false;
    }

    private boolean J() {
        int[] iArrB = this.k.b().b();
        if (iArrB == null) {
            return false;
        }
        for (int i : iArrB) {
            if (i == 4101) {
                return true;
            }
        }
        return false;
    }

    private boolean K(b bVar, List list, Map map) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((androidx.camera.core.impl.a) it.next()).g());
        }
        m00 m00Var = new m00();
        for (androidx.camera.core.impl.d0 d0Var : map.keySet()) {
            List list2 = (List) map.get(d0Var);
            b52.b((list2 == null || list2.isEmpty()) ? false : true, "No available output size is found for " + d0Var + FileUtils.FILE_EXTENSION_SEPARATOR);
            Size size = (Size) Collections.min(list2, m00Var);
            int iP = d0Var.p();
            arrayList.add(SurfaceConfig.h(bVar.a(), iP, size, F(iP)));
        }
        return c(bVar, arrayList);
    }

    private void L() {
        this.v.g();
        if (this.t == null) {
            l();
        } else {
            this.t = dy2.a(this.t.b(), this.t.j(), this.v.f(), this.t.h(), this.t.f(), this.t.d(), this.t.l());
        }
    }

    private void N(Map map, int i) {
        Size sizeR = r(this.k.b().d(), i, true);
        if (sizeR != null) {
            map.put(Integer.valueOf(i), sizeR);
        }
    }

    private void O(Map map, Size size, int i) {
        if (this.p) {
            Size sizeR = r(this.k.b().d(), i, false);
            Integer numValueOf = Integer.valueOf(i);
            if (sizeR != null) {
                size = (Size) Collections.min(Arrays.asList(size, sizeR), new m00());
            }
            map.put(numValueOf, size);
        }
    }

    private void P(Map map, int i) {
        StreamConfigurationMap streamConfigurationMap;
        if (Build.VERSION.SDK_INT < 31 || !this.r || (streamConfigurationMap = (StreamConfigurationMap) this.k.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP_MAXIMUM_RESOLUTION)) == null) {
            return;
        }
        map.put(Integer.valueOf(i), r(streamConfigurationMap, i, true));
    }

    private void b() {
    }

    private static Range d(Range range, Range range2, Range range3) {
        double dV = v(range2.intersect(range));
        double dV2 = v(range3.intersect(range));
        double dV3 = dV2 / ((double) v(range3));
        double dV4 = dV / ((double) v(range2));
        if (dV2 > dV) {
            if (dV3 >= 0.5d || dV3 >= dV4) {
                return range3;
            }
        } else if (dV2 == dV) {
            if (dV3 > dV4) {
                return range3;
            }
            if (dV3 == dV4 && ((Integer) range3.getLower()).intValue() > ((Integer) range2.getLower()).intValue()) {
                return range3;
            }
        } else if (dV4 < 0.5d && dV3 > dV4) {
            return range3;
        }
        return range2;
    }

    private b e(int i, Map map, boolean z, boolean z2) {
        int iZ = z(map);
        if (i == 0 || iZ != 10) {
            return b.e(i, iZ, z, z2);
        }
        throw new IllegalArgumentException(String.format("Camera device id is %s. 10 bit dynamic range is not currently supported in %s camera mode.", this.i, nu.a(i)));
    }

    private Map f(Map map, b bVar, Range range) {
        HashMap map2 = new HashMap();
        for (androidx.camera.core.impl.d0 d0Var : map.keySet()) {
            ArrayList arrayList = new ArrayList();
            HashMap map3 = new HashMap();
            for (Size size : (List) map.get(d0Var)) {
                int iP = d0Var.p();
                SurfaceConfig.ConfigSize configSizeC = SurfaceConfig.h(bVar.a(), iP, size, F(iP)).c();
                int iQ = range != null ? q(this.k, iP, size) : Integer.MAX_VALUE;
                Set hashSet = (Set) map3.get(configSizeC);
                if (hashSet == null) {
                    hashSet = new HashSet();
                    map3.put(configSizeC, hashSet);
                }
                if (!hashSet.contains(Integer.valueOf(iQ))) {
                    arrayList.add(size);
                    hashSet.add(Integer.valueOf(iQ));
                }
            }
            map2.put(d0Var, arrayList);
        }
        return map2;
    }

    private void g() {
        this.f.addAll(tv0.b());
    }

    private void h() {
        this.c.addAll(tv0.d());
    }

    private void i() {
        if (Build.VERSION.SDK_INT >= 33) {
            this.d.addAll(tv0.i());
        }
    }

    private void j() {
        if (Build.VERSION.SDK_INT >= 33) {
            this.h.addAll(tv0.k());
        }
    }

    private void k() {
        this.a.addAll(tv0.a(this.m, this.n, this.o));
        this.a.addAll(this.l.a(this.i, this.m));
    }

    private void l() {
        this.t = dy2.a(ir2.c, new HashMap(), this.v.f(), new HashMap(), w(), new HashMap(), new HashMap());
    }

    private void m() {
        this.g.addAll(tv0.l());
    }

    private void n() {
        this.b.addAll(tv0.m());
    }

    private List o(List list) {
        Iterator it = list.iterator();
        int size = 1;
        while (it.hasNext()) {
            size *= ((List) it.next()).size();
        }
        if (size == 0) {
            throw new IllegalArgumentException("Failed to find supported resolutions.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            arrayList.add(new ArrayList());
        }
        int size2 = size / ((List) list.get(0)).size();
        int i2 = size;
        for (int i3 = 0; i3 < list.size(); i3++) {
            List list2 = (List) list.get(i3);
            for (int i4 = 0; i4 < size; i4++) {
                ((List) arrayList.get(i4)).add((Size) list2.get((i4 % i2) / size2));
            }
            if (i3 < list.size() - 1) {
                i2 = size2;
                size2 /= ((List) list.get(i3 + 1)).size();
            }
        }
        return arrayList;
    }

    private Range p(Range range, int i) {
        if (range != null) {
            Range rangeD = androidx.camera.core.impl.x.a;
            if (!range.equals(rangeD)) {
                Range[] rangeArr = (Range[]) this.k.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
                if (rangeArr == null) {
                    return rangeD;
                }
                Range range2 = new Range(Integer.valueOf(Math.min(((Integer) range.getLower()).intValue(), i)), Integer.valueOf(Math.min(((Integer) range.getUpper()).intValue(), i)));
                int iV = 0;
                for (Range range3 : rangeArr) {
                    if (i >= ((Integer) range3.getLower()).intValue()) {
                        if (rangeD.equals(androidx.camera.core.impl.x.a)) {
                            rangeD = range3;
                        }
                        if (range3.equals(range2)) {
                            return range3;
                        }
                        try {
                            int iV2 = v(range3.intersect(range2));
                            if (iV == 0) {
                                iV = iV2;
                            } else {
                                if (iV2 >= iV) {
                                    rangeD = d(range2, rangeD, range3);
                                    iV = v(range2.intersect(rangeD));
                                }
                                range3 = rangeD;
                            }
                        } catch (IllegalArgumentException unused) {
                            if (iV != 0 || (u(range3, range2) >= u(rangeD, range2) && (u(range3, range2) != u(rangeD, range2) || (((Integer) range3.getLower()).intValue() <= ((Integer) rangeD.getUpper()).intValue() && v(range3) >= v(rangeD))))) {
                            }
                        }
                        rangeD = range3;
                    }
                }
                return rangeD;
            }
        }
        return androidx.camera.core.impl.x.a;
    }

    static int q(zs zsVar, int i, Size size) {
        try {
            return (int) (1.0E9d / ((StreamConfigurationMap) zsVar.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputMinFrameDuration(i, size));
        } catch (Exception unused) {
            return 0;
        }
    }

    private Size r(StreamConfigurationMap streamConfigurationMap, int i, boolean z) {
        Size[] sizeArrA;
        Size[] outputSizes = i == 34 ? streamConfigurationMap.getOutputSizes(SurfaceTexture.class) : streamConfigurationMap.getOutputSizes(i);
        if (outputSizes == null || outputSizes.length == 0) {
            return null;
        }
        m00 m00Var = new m00();
        Size size = (Size) Collections.max(Arrays.asList(outputSizes), m00Var);
        Size size2 = ir2.a;
        if (z && (sizeArrA = a.a(streamConfigurationMap, i)) != null && sizeArrA.length > 0) {
            size2 = (Size) Collections.max(Arrays.asList(sizeArrA), m00Var);
        }
        return (Size) Collections.max(Arrays.asList(size, size2), m00Var);
    }

    private int s(List list) {
        Iterator it = list.iterator();
        int iE = Integer.MAX_VALUE;
        while (it.hasNext()) {
            androidx.camera.core.impl.a aVar = (androidx.camera.core.impl.a) it.next();
            iE = E(iE, aVar.d(), aVar.f());
        }
        return iE;
    }

    private static int u(Range range, Range range2) {
        b52.j((range.contains((Integer) range2.getUpper()) || range.contains((Integer) range2.getLower())) ? false : true, "Ranges must not intersect");
        return ((Integer) range.getLower()).intValue() > ((Integer) range2.getUpper()).intValue() ? ((Integer) range.getLower()).intValue() - ((Integer) range2.getUpper()).intValue() : ((Integer) range2.getLower()).intValue() - ((Integer) range.getUpper()).intValue();
    }

    private static int v(Range range) {
        return (((Integer) range.getUpper()).intValue() - ((Integer) range.getLower()).intValue()) + 1;
    }

    private Size w() {
        try {
            int i = Integer.parseInt(this.i);
            CamcorderProfile camcorderProfileA = this.j.b(i, 1) ? this.j.a(i, 1) : null;
            return camcorderProfileA != null ? new Size(camcorderProfileA.videoFrameWidth, camcorderProfileA.videoFrameHeight) : x(i);
        } catch (NumberFormatException unused) {
            return y();
        }
    }

    private Size x(int i) {
        CamcorderProfile camcorderProfileA;
        Size size = ir2.d;
        if (this.j.b(i, 10)) {
            camcorderProfileA = this.j.a(i, 10);
        } else if (this.j.b(i, 8)) {
            camcorderProfileA = this.j.a(i, 8);
        } else if (this.j.b(i, 12)) {
            camcorderProfileA = this.j.a(i, 12);
        } else if (this.j.b(i, 6)) {
            camcorderProfileA = this.j.a(i, 6);
        } else if (this.j.b(i, 5)) {
            camcorderProfileA = this.j.a(i, 5);
        } else {
            camcorderProfileA = this.j.b(i, 4) ? this.j.a(i, 4) : null;
        }
        return camcorderProfileA != null ? new Size(camcorderProfileA.videoFrameWidth, camcorderProfileA.videoFrameHeight) : size;
    }

    private Size y() {
        Size[] outputSizes = this.k.b().d().getOutputSizes(MediaRecorder.class);
        if (outputSizes == null) {
            return ir2.d;
        }
        Arrays.sort(outputSizes, new m00(true));
        for (Size size : outputSizes) {
            int width = size.getWidth();
            Size size2 = ir2.f;
            if (width <= size2.getWidth() && size.getHeight() <= size2.getHeight()) {
                return size;
            }
        }
        return ir2.d;
    }

    private static int z(Map map) {
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            if (((ie0) it.next()).a() == 10) {
                return 10;
            }
        }
        return 8;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    Pair A(int i, List list, Map map, boolean z) {
        Map map2;
        HashMap map3;
        HashMap map4;
        Range range;
        List list2;
        Map map5;
        int i2;
        String str;
        String str2;
        Map map6;
        List list3;
        String str3;
        String str4;
        Map map7;
        Map map8;
        List list4;
        List list5;
        HashMap map9;
        int i3;
        int i4;
        int i5;
        String str5;
        L();
        List arrayList = new ArrayList(map.keySet());
        List listH = H(arrayList);
        Map mapG = this.y.g(list, arrayList, listH);
        b bVarE = e(i, mapG, z, I(list, map));
        boolean zK = K(bVarE, list, map);
        String str6 = ".  May be attempting to bind too many use cases. Existing surfaces: ";
        String str7 = " New configs: ";
        String str8 = "No supported surface combination is found for camera device - Id : ";
        if (!zK) {
            throw new IllegalArgumentException("No supported surface combination is found for camera device - Id : " + this.i + ".  May be attempting to bind too many use cases. Existing surfaces: " + list + " New configs: " + arrayList);
        }
        Range rangeD = D(list, arrayList, listH);
        Map mapF = f(map, bVarE, rangeD);
        List arrayList2 = new ArrayList();
        Iterator it = listH.iterator();
        while (it.hasNext()) {
            androidx.camera.core.impl.d0 d0Var = (androidx.camera.core.impl.d0) arrayList.get(((Integer) it.next()).intValue());
            arrayList2.add(a((List) mapF.get(d0Var), d0Var.p()));
        }
        List listO = o(arrayList2);
        HashMap map10 = new HashMap();
        HashMap map11 = new HashMap();
        Map map12 = new HashMap();
        Map map13 = new HashMap();
        boolean zD = r2.d(list, arrayList);
        int iS = s(list);
        Map map14 = map13;
        if (!this.f152q || zD) {
            map2 = map12;
            map3 = map11;
            map4 = map10;
            range = rangeD;
            list2 = listH;
            map5 = mapG;
            i2 = iS;
            str = "No supported surface combination is found for camera device - Id : ";
            str2 = " New configs: ";
            map6 = map14;
            list3 = null;
        } else {
            Iterator it2 = listO.iterator();
            List listT = null;
            while (true) {
                if (!it2.hasNext()) {
                    map3 = map11;
                    map4 = map10;
                    range = rangeD;
                    list2 = listH;
                    map5 = mapG;
                    i2 = iS;
                    str = str8;
                    str2 = str7;
                    str5 = str6;
                    map6 = map14;
                    map2 = map12;
                    break;
                }
                Map map15 = map14;
                Map map16 = map12;
                map3 = map11;
                map4 = map10;
                map5 = mapG;
                Range range2 = rangeD;
                List list6 = listH;
                range = range2;
                str = str8;
                int i6 = iS;
                i2 = iS;
                str2 = str7;
                list2 = listH;
                str5 = str6;
                listT = t(bVarE, (List) C(i, list, (List) it2.next(), arrayList, list6, i6, map16, map15).first);
                map2 = map16;
                map6 = map15;
                if (listT != null && !r2.a(map2, map6, listT)) {
                    listT = null;
                }
                if (listT != null) {
                    if (r2.c(this.k, listT)) {
                        break;
                    }
                    listT = null;
                }
                map2.clear();
                map6.clear();
                map14 = map6;
                map12 = map2;
                str6 = str5;
                str8 = str;
                str7 = str2;
                mapG = map5;
                map11 = map3;
                map10 = map4;
                rangeD = range;
                iS = i2;
                listH = list2;
            }
            if (listT == null && !zK) {
                throw new IllegalArgumentException(str + this.i + str5 + list + str2 + arrayList);
            }
            list3 = listT;
        }
        Iterator it3 = listO.iterator();
        int i7 = Integer.MAX_VALUE;
        int iIntValue = Integer.MAX_VALUE;
        boolean z2 = false;
        boolean z3 = false;
        List list7 = null;
        List list8 = null;
        while (true) {
            if (!it3.hasNext()) {
                str3 = str;
                str4 = str2;
                map7 = map6;
                map8 = map2;
                list4 = list7;
                list5 = list8;
                break;
            }
            List list9 = (List) it3.next();
            int i8 = i7;
            int i9 = iIntValue;
            str4 = str2;
            map7 = map6;
            str3 = str;
            map8 = map2;
            Pair pairC = C(i, list, list9, arrayList, list2, i2, null, null);
            List list10 = (List) pairC.first;
            iIntValue = ((Integer) pairC.second).intValue();
            int i10 = i2;
            boolean z4 = range == null || i10 <= iIntValue || iIntValue >= ((Integer) range.getLower()).intValue();
            if (z2 || !c(bVarE, list10)) {
                i3 = i9;
                i4 = Integer.MAX_VALUE;
            } else {
                i3 = i9;
                i4 = Integer.MAX_VALUE;
                if (i3 == Integer.MAX_VALUE || i3 < iIntValue) {
                    i3 = iIntValue;
                    list7 = list9;
                }
                if (z4) {
                    if (z3) {
                        list5 = list8;
                        list4 = list9;
                        i7 = i8;
                        break;
                    }
                    z2 = true;
                    i3 = iIntValue;
                    list7 = list9;
                }
            }
            if (list3 == null || z3 || t(bVarE, list10) == null) {
                i5 = i8;
            } else {
                i5 = i8;
                if (i5 == i4 || i5 < iIntValue) {
                    i5 = iIntValue;
                    list8 = list9;
                }
                if (!z4) {
                    continue;
                } else {
                    if (z2) {
                        i7 = iIntValue;
                        iIntValue = i3;
                        list4 = list7;
                        list5 = list9;
                        break;
                    }
                    z3 = true;
                    i5 = iIntValue;
                    list8 = list9;
                }
            }
            i2 = i10;
            iIntValue = i3;
            map2 = map8;
            map6 = map7;
            str = str3;
            str2 = str4;
            i7 = i5;
        }
        if (list4 == null) {
            throw new IllegalArgumentException(str3 + this.i + " and Hardware level: " + this.m + ". May be the specified resolution is too large and not supported. Existing surfaces: " + list + str4 + arrayList);
        }
        Range rangeP = range != null ? p(range, iIntValue) : null;
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            androidx.camera.core.impl.d0 d0Var2 = (androidx.camera.core.impl.d0) it4.next();
            List list11 = list2;
            Map map17 = map5;
            Iterator it5 = it4;
            androidx.camera.core.impl.x.a aVarD = androidx.camera.core.impl.x.a((Size) list4.get(list11.indexOf(Integer.valueOf(arrayList.indexOf(d0Var2))))).b((ie0) b52.g((ie0) map17.get(d0Var2))).d(r2.e(d0Var2));
            if (rangeP != null) {
                aVarD.c(rangeP);
            }
            map3.put(d0Var2, aVarD.a());
            it4 = it5;
            list2 = list11;
            map5 = map17;
        }
        HashMap map18 = map3;
        if (list3 == null || iIntValue != i7 || list4.size() != list5.size()) {
            map9 = map4;
            break;
        }
        int i11 = 0;
        while (true) {
            if (i11 >= list4.size()) {
                map9 = map4;
                if (!r2.k(this.k, list, map18, map9)) {
                    r2.l(map18, map9, map8, map7, list3);
                    break;
                }
                break;
            }
            if (!((Size) list4.get(i11)).equals(list5.get(i11))) {
                map9 = map4;
                break;
            }
            i11++;
        }
        return new Pair(map18, map9);
    }

    dy2 F(int i) {
        if (!this.u.contains(Integer.valueOf(i))) {
            O(this.t.j(), ir2.e, i);
            O(this.t.h(), ir2.g, i);
            N(this.t.d(), i);
            P(this.t.l(), i);
            this.u.add(Integer.valueOf(i));
        }
        return this.t;
    }

    SurfaceConfig M(int i, int i2, Size size) {
        return SurfaceConfig.h(i, i2, size, F(i2));
    }

    List a(List list, int i) {
        Rational rational;
        int iA = this.w.a(this.i, this.k);
        if (iA == 0) {
            rational = ra.a;
        } else if (iA == 1) {
            rational = ra.c;
        } else if (iA != 2) {
            rational = null;
        } else {
            Size sizeC = F(256).c(256);
            rational = new Rational(sizeC.getWidth(), sizeC.getHeight());
        }
        if (rational != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Size size = (Size) it.next();
                if (ra.a(size, rational)) {
                    arrayList.add(size);
                } else {
                    arrayList2.add(size);
                }
            }
            arrayList2.addAll(0, arrayList);
            list = arrayList2;
        }
        return this.x.a(SurfaceConfig.e(i), list);
    }

    boolean c(b bVar, List list) {
        Iterator it = B(bVar).iterator();
        boolean z = false;
        while (it.hasNext()) {
            z = ((xw2) it.next()).d(list) != null;
            if (z) {
                break;
            }
        }
        return z;
    }

    List t(b bVar, List list) {
        if (!r2.n(bVar)) {
            return null;
        }
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            List listD = ((xw2) it.next()).d(list);
            if (listD != null) {
                return listD;
            }
        }
        return null;
    }
}
