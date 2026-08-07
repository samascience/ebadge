package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import defpackage.b52;
import defpackage.gv2;
import defpackage.n13;
import defpackage.yr;
import defpackage.zs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class r2 {
    public static final Config.a a = Config.a.a("camera2.streamSpec.streamUseCase", Long.TYPE);
    private static final Map b;
    private static final Map c;

    static {
        HashMap map = new HashMap();
        b = map;
        HashMap map2 = new HashMap();
        c = map2;
        if (Build.VERSION.SDK_INT >= 33) {
            HashSet hashSet = new HashSet();
            UseCaseConfigFactory.CaptureType captureType = UseCaseConfigFactory.CaptureType.PREVIEW;
            hashSet.add(captureType);
            UseCaseConfigFactory.CaptureType captureType2 = UseCaseConfigFactory.CaptureType.METERING_REPEATING;
            hashSet.add(captureType2);
            map.put(4L, hashSet);
            HashSet hashSet2 = new HashSet();
            hashSet2.add(captureType);
            hashSet2.add(captureType2);
            hashSet2.add(UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS);
            map.put(1L, hashSet2);
            HashSet hashSet3 = new HashSet();
            UseCaseConfigFactory.CaptureType captureType3 = UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE;
            hashSet3.add(captureType3);
            map.put(2L, hashSet3);
            HashSet hashSet4 = new HashSet();
            UseCaseConfigFactory.CaptureType captureType4 = UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE;
            hashSet4.add(captureType4);
            map.put(3L, hashSet4);
            HashSet hashSet5 = new HashSet();
            hashSet5.add(captureType);
            hashSet5.add(captureType3);
            hashSet5.add(captureType4);
            map2.put(4L, hashSet5);
            HashSet hashSet6 = new HashSet();
            hashSet6.add(captureType);
            hashSet6.add(captureType4);
            map2.put(3L, hashSet6);
        }
    }

    public static boolean a(Map map, Map map2, List list) {
        for (int i = 0; i < list.size(); i++) {
            long jF = ((SurfaceConfig) list.get(i)).f();
            if (map.containsKey(Integer.valueOf(i))) {
                androidx.camera.core.impl.a aVar = (androidx.camera.core.impl.a) map.get(Integer.valueOf(i));
                if (!g(aVar.b().size() == 1 ? (UseCaseConfigFactory.CaptureType) aVar.b().get(0) : UseCaseConfigFactory.CaptureType.STREAM_SHARING, jF, aVar.b())) {
                    return false;
                }
            } else {
                if (!map2.containsKey(Integer.valueOf(i))) {
                    throw new AssertionError("SurfaceConfig does not map to any use case");
                }
                androidx.camera.core.impl.d0 d0Var = (androidx.camera.core.impl.d0) map2.get(Integer.valueOf(i));
                if (!g(d0Var.F(), jF, d0Var.F() == UseCaseConfigFactory.CaptureType.STREAM_SHARING ? ((gv2) d0Var).Y() : Collections.emptyList())) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean b(Set set, Set set2) {
        Iterator it = set2.iterator();
        while (it.hasNext()) {
            if (!set.contains((Long) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(zs zsVar, List list) {
        long[] jArr;
        if (Build.VERSION.SDK_INT < 33 || (jArr = (long[]) zsVar.a(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES)) == null || jArr.length == 0) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (long j : jArr) {
            hashSet.add(Long.valueOf(j));
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!hashSet.contains(Long.valueOf(((SurfaceConfig) it.next()).f()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(List list, List list2) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            androidx.camera.core.impl.a aVar = (androidx.camera.core.impl.a) it.next();
            if (j(aVar.e(), (UseCaseConfigFactory.CaptureType) aVar.b().get(0))) {
                return true;
            }
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            androidx.camera.core.impl.d0 d0Var = (androidx.camera.core.impl.d0) it2.next();
            if (j(d0Var, d0Var.F())) {
                return true;
            }
        }
        return false;
    }

    public static yr e(androidx.camera.core.impl.d0 d0Var) {
        androidx.camera.core.impl.t tVarC0 = androidx.camera.core.impl.t.c0();
        Config.a aVar = yr.K;
        if (d0Var.b(aVar)) {
            tVarC0.x(aVar, (Long) d0Var.a(aVar));
        }
        Config.a aVar2 = androidx.camera.core.impl.d0.D;
        if (d0Var.b(aVar2)) {
            tVarC0.x(aVar2, (Boolean) d0Var.a(aVar2));
        }
        Config.a aVar3 = androidx.camera.core.impl.p.J;
        if (d0Var.b(aVar3)) {
            tVarC0.x(aVar3, (Integer) d0Var.a(aVar3));
        }
        Config.a aVar4 = androidx.camera.core.impl.q.l;
        if (d0Var.b(aVar4)) {
            tVarC0.x(aVar4, (Integer) d0Var.a(aVar4));
        }
        return new yr(tVarC0);
    }

    private static Config f(Config config, long j) {
        Config.a aVar = a;
        if (config.b(aVar) && ((Long) config.a(aVar)).longValue() == j) {
            return null;
        }
        androidx.camera.core.impl.t tVarD0 = androidx.camera.core.impl.t.d0(config);
        tVarD0.x(aVar, Long.valueOf(j));
        return new yr(tVarD0);
    }

    private static boolean g(UseCaseConfigFactory.CaptureType captureType, long j, List list) {
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        if (captureType != UseCaseConfigFactory.CaptureType.STREAM_SHARING) {
            Map map = b;
            return map.containsKey(Long.valueOf(j)) && ((Set) map.get(Long.valueOf(j))).contains(captureType);
        }
        Map map2 = c;
        if (!map2.containsKey(Long.valueOf(j))) {
            return false;
        }
        Set set = (Set) map2.get(Long.valueOf(j));
        if (list.size() != set.size()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!set.contains((UseCaseConfigFactory.CaptureType) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(zs zsVar) {
        long[] jArr;
        return (Build.VERSION.SDK_INT < 33 || (jArr = (long[]) zsVar.a(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES)) == null || jArr.length == 0) ? false : true;
    }

    private static boolean i(List list, List list2, Set set) {
        boolean z;
        boolean z2;
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        if (it.hasNext()) {
            androidx.camera.core.impl.a aVar = (androidx.camera.core.impl.a) it.next();
            Config configE = aVar.e();
            Config.a aVar2 = yr.K;
            if (configE.b(aVar2) && ((Long) aVar.e().a(aVar2)).longValue() != 0) {
                z = true;
                z2 = false;
            } else {
                z2 = true;
                z = false;
            }
        } else {
            z = false;
            z2 = false;
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            androidx.camera.core.impl.d0 d0Var = (androidx.camera.core.impl.d0) it2.next();
            Config.a aVar3 = yr.K;
            if (d0Var.b(aVar3)) {
                Long l = (Long) d0Var.a(aVar3);
                if (l.longValue() != 0) {
                    if (z2) {
                        o();
                    }
                    hashSet.add(l);
                    z = true;
                } else if (z) {
                    o();
                }
            } else if (z) {
                o();
            }
            z2 = true;
        }
        return !z2 && b(set, hashSet);
    }

    private static boolean j(Config config, UseCaseConfigFactory.CaptureType captureType) {
        if (((Boolean) config.f(androidx.camera.core.impl.d0.D, Boolean.FALSE)).booleanValue()) {
            return false;
        }
        Config.a aVar = androidx.camera.core.impl.p.J;
        return config.b(aVar) && n13.b(captureType, ((Integer) config.a(aVar)).intValue()) == 5;
    }

    public static boolean k(zs zsVar, List list, Map map, Map map2) {
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        ArrayList<androidx.camera.core.impl.d0> arrayList = new ArrayList(map.keySet());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b52.g(((androidx.camera.core.impl.a) it.next()).e());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            b52.g(((androidx.camera.core.impl.x) b52.g((androidx.camera.core.impl.x) map.get((androidx.camera.core.impl.d0) it2.next()))).d());
        }
        long[] jArr = (long[]) zsVar.a(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES);
        if (jArr != null && jArr.length != 0) {
            HashSet hashSet = new HashSet();
            for (long j : jArr) {
                hashSet.add(Long.valueOf(j));
            }
            if (i(list, arrayList, hashSet)) {
                Iterator it3 = list.iterator();
                while (it3.hasNext()) {
                    androidx.camera.core.impl.a aVar = (androidx.camera.core.impl.a) it3.next();
                    Config configE = aVar.e();
                    Config configF = f(configE, ((Long) configE.a(yr.K)).longValue());
                    if (configF != null) {
                        map2.put(aVar, aVar.i(configF));
                    }
                }
                for (androidx.camera.core.impl.d0 d0Var : arrayList) {
                    androidx.camera.core.impl.x xVar = (androidx.camera.core.impl.x) map.get(d0Var);
                    Config configD = xVar.d();
                    Config configF2 = f(configD, ((Long) configD.a(yr.K)).longValue());
                    if (configF2 != null) {
                        map.put(d0Var, xVar.f().d(configF2).a());
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void l(Map map, Map map2, Map map3, Map map4, List list) {
        for (int i = 0; i < list.size(); i++) {
            long jF = ((SurfaceConfig) list.get(i)).f();
            if (map3.containsKey(Integer.valueOf(i))) {
                androidx.camera.core.impl.a aVar = (androidx.camera.core.impl.a) map3.get(Integer.valueOf(i));
                Config configF = f(aVar.e(), jF);
                if (configF != null) {
                    map2.put(aVar, aVar.i(configF));
                }
            } else {
                if (!map4.containsKey(Integer.valueOf(i))) {
                    throw new AssertionError("SurfaceConfig does not map to any use case");
                }
                androidx.camera.core.impl.d0 d0Var = (androidx.camera.core.impl.d0) map4.get(Integer.valueOf(i));
                androidx.camera.core.impl.x xVar = (androidx.camera.core.impl.x) map.get(d0Var);
                Config configF2 = f(xVar.d(), jF);
                if (configF2 != null) {
                    map.put(d0Var, xVar.f().d(configF2).a());
                }
            }
        }
    }

    public static void m(Collection collection, Collection collection2, Map map) {
        ArrayList arrayList = new ArrayList(collection2);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            SessionConfig sessionConfig = (SessionConfig) it.next();
            Config configE = sessionConfig.e();
            Config.a aVar = a;
            if (configE.b(aVar) && sessionConfig.m().size() != 1) {
                androidx.camera.core.x.c("StreamUseCaseUtil", String.format("SessionConfig has stream use case but also contains %d surfaces, abort populateSurfaceToStreamUseCaseMapping().", Integer.valueOf(sessionConfig.m().size())));
                return;
            }
            if (sessionConfig.e().b(aVar)) {
                Iterator it2 = collection.iterator();
                int i = 0;
                while (it2.hasNext()) {
                    SessionConfig sessionConfig2 = (SessionConfig) it2.next();
                    if (((androidx.camera.core.impl.d0) arrayList.get(i)).F() == UseCaseConfigFactory.CaptureType.METERING_REPEATING) {
                        b52.j(!sessionConfig2.m().isEmpty(), "MeteringRepeating should contain a surface");
                        map.put((DeferrableSurface) sessionConfig2.m().get(0), 1L);
                    } else {
                        Config configE2 = sessionConfig2.e();
                        Config.a aVar2 = a;
                        if (configE2.b(aVar2) && !sessionConfig2.m().isEmpty()) {
                            map.put((DeferrableSurface) sessionConfig2.m().get(0), (Long) sessionConfig2.e().a(aVar2));
                        }
                    }
                    i++;
                }
                return;
            }
        }
    }

    public static boolean n(s2.b bVar) {
        return bVar.a() == 0 && bVar.b() == 8;
    }

    private static void o() {
        throw new IllegalArgumentException("Either all use cases must have non-default stream use case assigned or none should have it");
    }
}
