package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.camera.core.m;
import androidx.camera.core.v;
import com.legend.mywatch.sdk.mywatchsdklib.android.bluetooth.CommandPool;
import com.legend.mywatch.sdk.realtimepreview.image.PreviewImageProcessor;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public class b62 {
    private static b62 r;
    private final m62 a;
    private final Handler b;
    private final ExecutorService c;
    private p52 d;
    private m e;
    private final Handler h;
    private Runnable i;
    private Runnable k;
    private boolean f = false;
    private boolean g = false;
    private int j = 0;
    private boolean l = false;
    private int m = 240;
    private int n = 296;
    private final List o = new ArrayList();
    private volatile boolean p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private volatile boolean f205q = false;

    class a implements p52 {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(int i, String str) {
            if (b62.this.d != null) {
                b62.this.d.onError(i, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(int i) {
            if (b62.this.d != null) {
                b62.this.d.c(i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k() {
            if (b62.this.d != null) {
                b62.this.d.b();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l() {
            if (b62.this.d != null) {
                b62.this.d.d();
            }
        }

        @Override // defpackage.p52
        public void b() {
            b62.this.b.post(new Runnable() { // from class: z52
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.k();
                }
            });
        }

        @Override // defpackage.p52
        public void c(final int i) {
            b62.this.b.post(new Runnable() { // from class: a62
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.j(i);
                }
            });
        }

        @Override // defpackage.p52
        public void d() {
            b62.this.b.post(new Runnable() { // from class: y52
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.l();
                }
            });
        }

        @Override // defpackage.p52
        public void onError(final int i, final String str) {
            b62.this.b.post(new Runnable() { // from class: x52
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.i(i, str);
                }
            });
        }
    }

    class b implements m.a {
        b() {
        }

        @Override // androidx.camera.core.m.a
        public void b(v vVar) {
            vVar.close();
        }
    }

    class c implements m.a {
        c() {
        }

        @Override // androidx.camera.core.m.a
        public void b(v vVar) {
            vVar.close();
        }
    }

    class d implements m.a {
        d() {
        }

        @Override // androidx.camera.core.m.a
        public void b(v vVar) {
            vVar.close();
        }
    }

    class e implements m.a {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean e(long j, Long l) {
            return l.longValue() < j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(int i, int i2, int i3, int i4, byte[] bArr, double d) {
            if (b62.this.d != null) {
                b62.this.d.a(i, i2, i3, i4, bArr, d);
            }
        }

        @Override // androidx.camera.core.m.a
        public void b(v vVar) throws Throwable {
            Bitmap bitmap = null;
            try {
                if (!b62.this.f) {
                    Log.d("PreviewManager", "Preview stopped, skipping image processing");
                    b62.this.p = false;
                    vVar.close();
                    return;
                }
                if (b62.this.p) {
                    b62.this.p = false;
                    vVar.close();
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jK = b62.this.a.k();
                if (jK > 0 && jCurrentTimeMillis - jK < 100) {
                    b62.this.p = false;
                    vVar.close();
                    return;
                }
                b62.this.p = true;
                try {
                    try {
                        Bitmap bitmapX = b62.this.x(vVar);
                        try {
                            if (bitmapX == null) {
                                Log.w("PreviewManager", "Failed to convert ImageProxy to Bitmap");
                                if (bitmapX != null && !bitmapX.isRecycled()) {
                                    bitmapX.recycle();
                                }
                                b62.this.p = false;
                                vVar.close();
                                return;
                            }
                            if (!b62.this.f) {
                                bitmapX.recycle();
                                b62.this.p = false;
                                vVar.close();
                                return;
                            }
                            byte[] bArrA = PreviewImageProcessor.a(bitmapX, b62.this.m, b62.this.n);
                            if (bArrA != null && bArrA.length != 0) {
                                if (!b62.this.f) {
                                    bitmapX.recycle();
                                    b62.this.p = false;
                                    vVar.close();
                                    return;
                                }
                                final int length = bArrA.length;
                                final int i = b62.this.m;
                                final int i2 = b62.this.n;
                                int iJ = b62.this.a.j();
                                boolean zB = b62.this.a.B(bArrA);
                                if (zB) {
                                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                                    synchronized (b62.this.o) {
                                        try {
                                            b62.this.o.add(Long.valueOf(jCurrentTimeMillis2));
                                            while (b62.this.o.size() > 30) {
                                                b62.this.o.remove(0);
                                            }
                                            final long j = jCurrentTimeMillis2 - 1000;
                                            b62.this.o.removeIf(new Predicate() { // from class: c62
                                                @Override // java.util.function.Predicate
                                                public final boolean test(Object obj) {
                                                    return b62.e.e(j, (Long) obj);
                                                }
                                            });
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    }
                                }
                                final double dQ = b62.this.q();
                                if (b62.this.d != null) {
                                    final byte[] bArr = new byte[bArrA.length];
                                    System.arraycopy(bArrA, 0, bArr, 0, bArrA.length);
                                    final int iJ2 = zB ? b62.this.a.j() : iJ + 1;
                                    b62.this.b.post(new Runnable() { // from class: d62
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.a.f(iJ2, length, i, i2, bArr, dQ);
                                        }
                                    });
                                }
                                if (!zB) {
                                    Log.d("PreviewManager", "Image data send skipped (rate limiting)");
                                }
                                if (!bitmapX.isRecycled()) {
                                    bitmapX.recycle();
                                }
                                b62.this.p = false;
                                vVar.close();
                                return;
                            }
                            Log.w("PreviewManager", "Failed to process image");
                            bitmapX.recycle();
                            b62.this.p = false;
                            vVar.close();
                        } catch (Exception e) {
                            e = e;
                            bitmap = bitmapX;
                            Log.e("PreviewManager", "Error processing image", e);
                            if (b62.this.f && b62.this.d != null) {
                                b62.this.d.onError(1004, "Image process failed: " + e.getMessage());
                            }
                            if (bitmap != null && !bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bitmap = bitmapX;
                            if (bitmap != null && !bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                            b62.this.p = false;
                            vVar.close();
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e3) {
                e = e3;
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    private b62() {
        m62 m62Var = new m62();
        this.a = m62Var;
        this.b = new Handler(Looper.getMainLooper());
        this.c = Executors.newSingleThreadExecutor();
        this.h = new Handler(Looper.getMainLooper());
        m62Var.E(new Runnable() { // from class: t52
            @Override // java.lang.Runnable
            public final void run() {
                this.a.C();
            }
        });
        m62Var.F(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A() {
        if (this.l) {
            Log.d("PreviewManager", "User manually stopped during retry, cancel retry");
            return;
        }
        if (this.a.C()) {
            Log.d("PreviewManager", "Retry start command sent, attempt: " + this.j);
            s();
            Runnable runnable = new Runnable() { // from class: w52
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.z();
                }
            };
            this.i = runnable;
            this.h.postDelayed(runnable, 5000L);
        } else {
            Log.e("PreviewManager", "Failed to send retry start command");
            this.a.y();
            this.f = false;
            this.j = 0;
            p52 p52Var = this.d;
            if (p52Var != null) {
                p52Var.onError(1005, "Failed to send retry start command");
            }
        }
        this.k = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        if (this.l) {
            Log.d("PreviewManager", "User manually stopped, skip retry");
            return;
        }
        if (this.a.p()) {
            Log.e("PreviewManager", "Start command timeout, retry count: " + this.j);
            int i = this.j;
            if (i >= 3) {
                Log.e("PreviewManager", "Start command timeout, max retries reached");
                this.a.y();
                this.f = false;
                this.j = 0;
                p52 p52Var = this.d;
                if (p52Var != null) {
                    p52Var.onError(1002, "Start command timeout");
                    return;
                }
                return;
            }
            this.j = i + 1;
            Log.d("PreviewManager", "Retrying start command, attempt: " + this.j);
            this.a.D();
            Runnable runnable = new Runnable() { // from class: v52
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.A();
                }
            };
            this.k = runnable;
            this.h.postDelayed(runnable, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (this.f205q) {
            this.f205q = false;
            p();
        }
    }

    private void G() {
        if (this.e == null) {
            Log.w("PreviewManager", "setupImageAnalysis() called but imageAnalysis is null");
            return;
        }
        if (this.g) {
            Log.d("PreviewManager", "setupImageAnalysis() already set up, skipping (idempotent)");
            return;
        }
        Log.d("PreviewManager", "setupImageAnalysis() setting up analyzer for image processing");
        this.e.n0(this.c, new e());
        this.g = true;
        Log.d("PreviewManager", "setupImageAnalysis() completed, analyzer is now active");
    }

    private void p() {
        Log.d("PreviewManager", "applyRemoteCaptureHardPauseAfterDeferredFrame: full frame completed, stopping preview stream");
        this.a.G(true);
        this.f = false;
        synchronized (this.o) {
            this.o.clear();
        }
        this.p = false;
        m mVar = this.e;
        if (mVar != null) {
            mVar.n0(this.c, new b());
        }
        this.g = false;
        s();
        r();
        this.j = 0;
        this.a.x(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double q() {
        synchronized (this.o) {
            try {
                if (this.o.size() < 2) {
                    return 0.0d;
                }
                long jLongValue = ((Long) this.o.get(0)).longValue();
                List list = this.o;
                long jLongValue2 = ((Long) list.get(list.size() - 1)).longValue() - jLongValue;
                if (jLongValue2 <= 0) {
                    return 0.0d;
                }
                return ((((double) this.o.size()) - 1.0d) * 1000.0d) / jLongValue2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void r() {
        Runnable runnable = this.k;
        if (runnable != null) {
            this.h.removeCallbacks(runnable);
            this.k = null;
        }
    }

    private void s() {
        Runnable runnable = this.i;
        if (runnable != null) {
            this.h.removeCallbacks(runnable);
            this.i = null;
        }
        r();
    }

    public static synchronized b62 t() {
        try {
            if (r == null) {
                r = new b62();
            }
        } catch (Throwable th) {
            throw th;
        }
        return r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap x(v vVar) {
        int iD;
        int i;
        if (vVar.q() != 35) {
            Log.w("PreviewManager", "Unsupported image format: " + vVar.q() + ", expected YUV_420_888");
            return null;
        }
        try {
            int width = vVar.getWidth();
            int height = vVar.getHeight();
            int i2 = 0;
            v.a aVar = vVar.r()[0];
            v.a aVar2 = vVar.r()[1];
            v.a aVar3 = vVar.r()[2];
            ByteBuffer byteBufferB = aVar.b();
            ByteBuffer byteBufferB2 = aVar2.b();
            ByteBuffer byteBufferB3 = aVar3.b();
            int iA = aVar.a();
            int iC = aVar.c();
            int iA2 = aVar2.a();
            int iC2 = aVar2.c();
            int i3 = width * height;
            byte[] bArr = new byte[(i3 / 2) + i3];
            byteBufferB.rewind();
            byte[] bArr2 = new byte[iA];
            int i4 = 0;
            int i5 = 0;
            while (i4 < height) {
                byteBufferB.position(i4 * iA);
                byteBufferB.get(bArr2, i2, Math.min(iA, byteBufferB.remaining()));
                for (int i6 = i2; i6 < width; i6++) {
                    int i7 = i6 * iC;
                    if (i7 < iA) {
                        bArr[i5] = bArr2[i7];
                        i5++;
                    } else {
                        bArr[i5] = 0;
                        i5++;
                    }
                }
                i4++;
                i2 = 0;
            }
            byteBufferB2.rewind();
            byteBufferB3.rewind();
            int i8 = width / 2;
            byte[] bArr3 = new byte[iA2];
            byte[] bArr4 = new byte[iA2];
            int i9 = 0;
            for (int i10 = height / 2; i9 < i10; i10 = i10) {
                int i11 = i9 * iA2;
                byteBufferB2.position(i11);
                byteBufferB3.position(i11);
                int iMin = Math.min(iA2, byteBufferB2.remaining());
                int iMin2 = Math.min(iA2, byteBufferB3.remaining());
                if (iMin > 0) {
                    i = 0;
                    byteBufferB2.get(bArr3, 0, iMin);
                } else {
                    i = 0;
                }
                if (iMin2 > 0) {
                    byteBufferB3.get(bArr4, i, iMin2);
                }
                for (int i12 = 0; i12 < i8; i12++) {
                    int i13 = i12 * iC2;
                    if (i13 >= iA2 || i13 >= iA2) {
                        int i14 = i3 + 1;
                        bArr[i3] = -128;
                        i3 += 2;
                        bArr[i14] = -128;
                    } else {
                        int i15 = i3 + 1;
                        bArr[i3] = bArr4[i13];
                        i3 += 2;
                        bArr[i15] = bArr3[i13];
                    }
                }
                i9++;
            }
            YuvImage yuvImage = new YuvImage(bArr, 17, width, height, null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, width, height), 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            if (bitmapDecodeByteArray == null || (iD = vVar.h0().d()) == 0) {
                return bitmapDecodeByteArray;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate(iD);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, true);
            bitmapDecodeByteArray.recycle();
            return bitmapCreateBitmap;
        } catch (Exception e2) {
            Log.e("PreviewManager", "Error converting ImageProxy to Bitmap", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z() {
        if (this.l) {
            Log.d("PreviewManager", "User manually stopped, skip retry");
            return;
        }
        if (this.a.p()) {
            Log.e("PreviewManager", "Start command timeout after retry, giving up");
            this.a.y();
            this.f = false;
            this.j = 0;
            p52 p52Var = this.d;
            if (p52Var != null) {
                p52Var.onError(1002, "Start command timeout after retry");
            }
        }
    }

    public void D() {
        if (!this.f) {
            Log.d("PreviewManager", "pausePreviewStreamForRemoteCapture: not previewing, skip");
        } else if (this.f205q) {
            Log.d("PreviewManager", "pausePreviewStreamForRemoteCapture: already armed, skip duplicate");
        } else {
            Log.d("PreviewManager", "pausePreviewStreamForRemoteCapture: armed, will stop after next full frame completes");
            this.f205q = true;
        }
    }

    public void E(m mVar) {
        if (!this.f) {
            Log.w("PreviewManager", "Preview is not in started state, cannot set imageAnalysis");
            return;
        }
        this.e = mVar;
        this.g = false;
        G();
        Log.d("PreviewManager", "ImageAnalysis set and started processing (device initiated), isAnalyzerSetup: " + this.g);
    }

    public void F(p52 p52Var) {
        this.d = p52Var;
    }

    public void H(m mVar) {
        if (this.f) {
            Log.w("PreviewManager", "Preview is already running");
            return;
        }
        this.f205q = false;
        this.e = mVar;
        this.g = false;
        this.j = 0;
        this.l = false;
        r();
        if (this.a.C()) {
            s();
            Runnable runnable = new Runnable() { // from class: u52
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.B();
                }
            };
            this.i = runnable;
            this.h.postDelayed(runnable, 5000L);
            this.f = true;
            return;
        }
        Log.e("PreviewManager", "Failed to send start command");
        p52 p52Var = this.d;
        if (p52Var != null) {
            p52Var.onError(1005, "Failed to send start command");
        }
    }

    public void I() {
        boolean z = !this.f && this.a.o();
        boolean z2 = this.f205q;
        if (!this.f && !z && !z2) {
            Log.w("PreviewManager", "Preview is not running");
            return;
        }
        this.f205q = false;
        this.a.G(false);
        this.l = true;
        this.f = false;
        synchronized (this.o) {
            this.o.clear();
        }
        this.p = false;
        m mVar = this.e;
        if (mVar != null) {
            mVar.n0(this.c, new d());
            this.e = null;
        }
        this.g = false;
        this.a.D();
        s();
        r();
        this.j = 0;
        Log.d("PreviewManager", "Preview stopped");
    }

    public m62 u() {
        return this.a;
    }

    public void v() {
        Log.d("PreviewManager", "Device sent end command, stopping preview");
        this.f205q = false;
        boolean z = this.f;
        this.f = false;
        synchronized (this.o) {
            this.o.clear();
        }
        this.p = false;
        m mVar = this.e;
        if (mVar != null) {
            mVar.n0(this.c, new c());
        }
        this.g = false;
        s();
        r();
        this.j = 0;
        this.l = false;
        if (!this.a.A((byte) 0)) {
            Log.w("PreviewManager", "Failed to send end response");
        }
        CommandPool.n(100);
        Log.d("PreviewManager", "Restored send space duration to 100ms (device end command)");
        boolean zO = this.a.o();
        this.a.y();
        p52 p52Var = this.d;
        if (p52Var != null && (z || zO)) {
            p52Var.d();
        }
        Log.d("PreviewManager", "Preview stopped by device");
    }

    public void w(byte b2, int i, int i2) {
        this.f205q = false;
        s();
        r();
        this.j = 0;
        if (b2 == 0) {
            this.m = i;
            this.n = i2;
            this.f = true;
            Log.d("PreviewManager", "Preview started, device screen: " + i + "x" + i2);
            if (this.e != null) {
                G();
                Log.d("PreviewManager", "Preview started, setupImageAnalysis() called, isAnalyzerSetup: " + this.g);
            } else {
                Log.d("PreviewManager", "Preview started but imageAnalysis is null, waiting for camera page");
            }
        } else {
            this.f = false;
            this.g = false;
        }
        this.a.m(b2, i, i2);
    }

    public boolean y() {
        return this.f;
    }
}
