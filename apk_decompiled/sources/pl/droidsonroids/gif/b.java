package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.widget.MediaController;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class b extends Drawable implements Animatable, MediaController.MediaPlayerControl {
    final ScheduledThreadPoolExecutor a;
    volatile boolean b;
    long c;
    private final Rect d;
    protected final Paint e;
    final Bitmap f;
    final GifInfoHandle g;
    final ConcurrentLinkedQueue h;
    private ColorStateList i;
    private PorterDuffColorFilter j;
    private PorterDuff.Mode k;
    final boolean l;
    final f m;
    private final i n;
    private final Rect o;
    ScheduledFuture p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f370q;
    private int r;

    class a extends j {
        a(b bVar) {
            super(bVar);
        }

        @Override // pl.droidsonroids.gif.j
        public void a() {
            if (b.this.g.v()) {
                b.this.start();
            }
        }
    }

    /* JADX INFO: renamed from: pl.droidsonroids.gif.b$b, reason: collision with other inner class name */
    class C0164b extends j {
        final /* synthetic */ int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0164b(b bVar, int i) {
            super(bVar);
            this.b = i;
        }

        @Override // pl.droidsonroids.gif.j
        public void a() {
            b bVar = b.this;
            bVar.g.z(this.b, bVar.f);
            this.a.m.sendEmptyMessageAtTime(-1, 0L);
        }
    }

    public b(Resources resources, int i) {
        this(resources.openRawResourceFd(i));
        float fB = d.b(resources, i);
        this.r = (int) (this.g.g() * fB);
        this.f370q = (int) (this.g.n() * fB);
    }

    private void a() {
        ScheduledFuture scheduledFuture = this.p;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.m.removeMessages(-1);
    }

    private void g() {
        if (this.l && this.b) {
            long j = this.c;
            if (j != Long.MIN_VALUE) {
                long jMax = Math.max(0L, j - SystemClock.uptimeMillis());
                this.c = Long.MIN_VALUE;
                this.a.remove(this.n);
                this.p = this.a.schedule(this.n, jMax, TimeUnit.MILLISECONDS);
            }
        }
    }

    private void i() {
        this.b = false;
        this.m.removeMessages(-1);
        this.g.t();
    }

    private PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public int b() {
        return this.g.c();
    }

    public int c() {
        int iD = this.g.d();
        return (iD == 0 || iD < this.g.h()) ? iD : iD - 1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return d() > 1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return d() > 1;
    }

    public int d() {
        return this.g.l();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        if (this.j == null || this.e.getColorFilter() != null) {
            z = false;
        } else {
            this.e.setColorFilter(this.j);
            z = true;
        }
        canvas.drawBitmap(this.f, this.o, this.d, this.e);
        if (z) {
            this.e.setColorFilter(null);
        }
    }

    public boolean e() {
        return this.g.p();
    }

    public void f() {
        this.a.execute(new a(this));
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.e.getAlpha();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 100;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.e.getColorFilter();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.g.e();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return this.g.f();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f370q;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return (!this.g.o() || this.e.getAlpha() < 255) ? -2 : -1;
    }

    public void h(int i) {
        this.g.A(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        g();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.b;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        return super.isStateful() || ((colorStateList = this.i) != null && colorStateList.isStateful());
    }

    void j(long j) {
        if (this.l) {
            this.c = 0L;
            this.m.sendEmptyMessageAtTime(-1, 0L);
        } else {
            a();
            this.p = this.a.schedule(this.n, Math.max(j, 0L), TimeUnit.MILLISECONDS);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.d.set(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.i;
        if (colorStateList == null || (mode = this.k) == null) {
            return false;
        }
        this.j = k(colorStateList, mode);
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        stop();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Position is not positive");
        }
        this.a.execute(new C0164b(this, i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.e.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.e.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.e.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.e.setFilterBitmap(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.i = colorStateList;
        this.j = k(colorStateList, this.k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.k = mode;
        this.j = k(this.i, mode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (!this.l) {
            if (z) {
                if (z2) {
                    f();
                }
                if (visible) {
                    start();
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable, android.widget.MediaController.MediaPlayerControl
    public void start() {
        synchronized (this) {
            try {
                if (this.b) {
                    return;
                }
                this.b = true;
                j(this.g.w());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        synchronized (this) {
            try {
                if (this.b) {
                    this.b = false;
                    a();
                    this.g.y();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, error: %d", Integer.valueOf(this.g.n()), Integer.valueOf(this.g.g()), Integer.valueOf(this.g.l()), Integer.valueOf(this.g.j()));
    }

    public b(AssetFileDescriptor assetFileDescriptor) {
        this(new GifInfoHandle(assetFileDescriptor), null, null, true);
    }

    public b(ContentResolver contentResolver, Uri uri) {
        this(GifInfoHandle.r(contentResolver, uri), null, null, true);
    }

    b(GifInfoHandle gifInfoHandle, b bVar, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z) {
        this.b = true;
        this.c = Long.MIN_VALUE;
        this.d = new Rect();
        this.e = new Paint(6);
        this.h = new ConcurrentLinkedQueue();
        i iVar = new i(this);
        this.n = iVar;
        this.l = z;
        this.a = scheduledThreadPoolExecutor == null ? c.a() : scheduledThreadPoolExecutor;
        this.g = gifInfoHandle;
        Bitmap bitmap = null;
        if (bVar != null) {
            synchronized (bVar.g) {
                try {
                    if (!bVar.g.p() && bVar.g.g() >= gifInfoHandle.g() && bVar.g.n() >= gifInfoHandle.n()) {
                        bVar.i();
                        bitmap = bVar.f;
                        bitmap.eraseColor(0);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (bitmap == null) {
            this.f = Bitmap.createBitmap(gifInfoHandle.n(), gifInfoHandle.g(), Bitmap.Config.ARGB_8888);
        } else {
            this.f = bitmap;
        }
        this.f.setHasAlpha(!gifInfoHandle.o());
        this.o = new Rect(0, 0, gifInfoHandle.n(), gifInfoHandle.g());
        this.m = new f(this);
        iVar.a();
        this.f370q = gifInfoHandle.n();
        this.r = gifInfoHandle.g();
    }
}
