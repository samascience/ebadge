package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Pair;
import android.util.Size;
import androidx.camera.core.CameraState;
import androidx.camera.core.impl.Timebase;
import androidx.lifecycle.LiveData;
import defpackage.as;
import defpackage.b52;
import defpackage.dh0;
import defpackage.iu;
import defpackage.pu;
import defpackage.qu;
import defpackage.re0;
import defpackage.rr;
import defpackage.sa1;
import defpackage.vt1;
import defpackage.w92;
import defpackage.xr;
import defpackage.zs;
import defpackage.zt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class d0 implements zt {
    private final String a;
    private final zs b;
    private final rr c;
    private h e;
    private final a h;
    private final w92 j;
    private final dh0 k;
    private final iu l;
    private final Object d = new Object();
    private a f = null;
    private a g = null;
    private List i = null;

    static class a extends androidx.lifecycle.i {
        private LiveData m;
        private final Object n;

        a(Object obj) {
            this.n = obj;
        }

        @Override // androidx.lifecycle.LiveData
        public Object f() {
            LiveData liveData = this.m;
            return liveData == null ? this.n : liveData.f();
        }

        void r(LiveData liveData) {
            LiveData liveData2 = this.m;
            if (liveData2 != null) {
                super.q(liveData2);
            }
            this.m = liveData;
            super.p(liveData, new vt1() { // from class: androidx.camera.camera2.internal.c0
                @Override // defpackage.vt1
                public final void b(Object obj) {
                    this.a.o(obj);
                }
            });
        }
    }

    public d0(String str, iu iuVar) {
        String str2 = (String) b52.g(str);
        this.a = str2;
        this.l = iuVar;
        zs zsVarC = iuVar.c(str2);
        this.b = zsVarC;
        this.c = new rr(this);
        w92 w92VarA = qu.a(str, zsVarC);
        this.j = w92VarA;
        this.k = new xr(str, w92VarA);
        this.h = new a(CameraState.a(CameraState.Type.CLOSED));
    }

    private void u() {
        v();
    }

    private void v() {
        String str;
        int iS = s();
        if (iS == 0) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED";
        } else if (iS == 1) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_FULL";
        } else if (iS == 2) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY";
        } else if (iS == 3) {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_3";
        } else if (iS != 4) {
            str = "Unknown value: " + iS;
        } else {
            str = "INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL";
        }
        androidx.camera.core.x.e("Camera2CameraInfo", "Device Level: " + str);
    }

    @Override // defpackage.yt
    public int a() {
        return k(0);
    }

    @Override // defpackage.zt
    public Set b() {
        return re0.a(this.b).c();
    }

    @Override // defpackage.zt
    public boolean c() {
        int[] iArr = (int[]) this.b.a(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
        if (iArr != null) {
            for (int i : iArr) {
                if (i == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // defpackage.zt
    public String d() {
        return this.a;
    }

    @Override // defpackage.yt
    public int f() {
        Integer num = (Integer) this.b.a(CameraCharacteristics.LENS_FACING);
        b52.b(num != null, "Unable to get the lens facing of the camera.");
        return sa1.a(num.intValue());
    }

    @Override // defpackage.zt
    public void g(Executor executor, as asVar) {
        synchronized (this.d) {
            try {
                h hVar = this.e;
                if (hVar != null) {
                    hVar.s(executor, asVar);
                    return;
                }
                if (this.i == null) {
                    this.i = new ArrayList();
                }
                this.i.add(new Pair(asVar, executor));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.zt
    public Timebase h() {
        Integer num = (Integer) this.b.a(CameraCharacteristics.SENSOR_INFO_TIMESTAMP_SOURCE);
        b52.g(num);
        return num.intValue() != 1 ? Timebase.UPTIME : Timebase.REALTIME;
    }

    @Override // defpackage.yt
    public String i() {
        return s() == 2 ? "androidx.camera.camera2.legacy" : "androidx.camera.camera2";
    }

    @Override // defpackage.zt
    public List j(int i) {
        Size[] sizeArrA = this.b.b().a(i);
        return sizeArrA != null ? Arrays.asList(sizeArrA) : Collections.emptyList();
    }

    @Override // defpackage.yt
    public int k(int i) {
        return pu.a(pu.b(i), r(), 1 == f());
    }

    @Override // defpackage.zt
    public dh0 l() {
        return this.k;
    }

    @Override // defpackage.zt
    public w92 m() {
        return this.j;
    }

    @Override // defpackage.zt
    public List n(int i) {
        Size[] sizeArrC = this.b.b().c(i);
        return sizeArrC != null ? Arrays.asList(sizeArrC) : Collections.emptyList();
    }

    @Override // defpackage.zt
    public void o(as asVar) {
        synchronized (this.d) {
            try {
                h hVar = this.e;
                if (hVar != null) {
                    hVar.X(asVar);
                    return;
                }
                List list = this.i;
                if (list == null) {
                    return;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((Pair) it.next()).first == asVar) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public rr p() {
        return this.c;
    }

    public zs q() {
        return this.b;
    }

    int r() {
        Integer num = (Integer) this.b.a(CameraCharacteristics.SENSOR_ORIENTATION);
        b52.g(num);
        return num.intValue();
    }

    int s() {
        Integer num = (Integer) this.b.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        b52.g(num);
        return num.intValue();
    }

    void t(h hVar) {
        synchronized (this.d) {
            try {
                this.e = hVar;
                a aVar = this.g;
                if (aVar != null) {
                    aVar.r(hVar.G().d());
                }
                a aVar2 = this.f;
                if (aVar2 != null) {
                    aVar2.r(this.e.E().c());
                }
                List<Pair> list = this.i;
                if (list != null) {
                    for (Pair pair : list) {
                        this.e.s((Executor) pair.second, (as) pair.first);
                    }
                    this.i = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        u();
    }

    void w(LiveData liveData) {
        this.h.r(liveData);
    }
}
