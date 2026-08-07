package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import defpackage.as;
import defpackage.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class s1 {
    static CameraCaptureSession.CaptureCallback a(as asVar) {
        if (asVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        b(asVar, arrayList);
        return arrayList.size() == 1 ? (CameraCaptureSession.CaptureCallback) arrayList.get(0) : e0.a(arrayList);
    }

    static void b(as asVar, List list) {
        if (asVar instanceof bs.a) {
            Iterator it = ((bs.a) asVar).e().iterator();
            while (it.hasNext()) {
                b((as) it.next(), list);
            }
        } else if (asVar instanceof r1) {
            list.add(((r1) asVar).f());
        } else {
            list.add(new q1(asVar));
        }
    }
}
