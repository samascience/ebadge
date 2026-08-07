package defpackage;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;

/* JADX INFO: loaded from: classes.dex */
public class dy1 extends cy1 {
    dy1(int i, Surface surface) {
        this(new OutputConfiguration(i, surface));
    }

    static dy1 l(OutputConfiguration outputConfiguration) {
        return new dy1(outputConfiguration);
    }

    @Override // defpackage.ay1, zx1.a
    public /* bridge */ /* synthetic */ Surface a() {
        return super.a();
    }

    @Override // defpackage.ey1, zx1.a
    public void b(long j) {
        if (j == -1) {
            return;
        }
        ((OutputConfiguration) i()).setStreamUseCase(j);
    }

    @Override // defpackage.by1, zx1.a
    public /* bridge */ /* synthetic */ void c(Surface surface) {
        super.c(surface);
    }

    @Override // defpackage.cy1, defpackage.by1, zx1.a
    public void d(long j) {
        ((OutputConfiguration) i()).setDynamicRangeProfile(j);
    }

    @Override // defpackage.cy1, defpackage.by1, zx1.a
    public /* bridge */ /* synthetic */ String e() {
        return super.e();
    }

    @Override // defpackage.ey1
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // defpackage.by1, zx1.a
    public /* bridge */ /* synthetic */ void f() {
        super.f();
    }

    @Override // defpackage.cy1, defpackage.by1, zx1.a
    public /* bridge */ /* synthetic */ void g(String str) {
        super.g(str);
    }

    @Override // defpackage.ey1, zx1.a
    public void h(int i) {
        ((OutputConfiguration) i()).setMirrorMode(i);
    }

    @Override // defpackage.ey1
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // defpackage.cy1, defpackage.by1, defpackage.ay1, zx1.a
    public Object i() {
        b52.a(this.a instanceof OutputConfiguration);
        return this.a;
    }

    dy1(Object obj) {
        super(obj);
    }
}
