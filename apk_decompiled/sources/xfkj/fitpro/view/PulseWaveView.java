package xfkj.fitpro.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import defpackage.ga2;
import defpackage.p31;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
public final class PulseWaveView extends View {
    private final Paint a;
    private final Paint b;
    private float c;
    private float d;
    private float e;
    private final int f;
    private final a g;
    private boolean h;

    public static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PulseWaveView.this.c += (PulseWaveView.this.d - PulseWaveView.this.c) * 0.1f;
            PulseWaveView.this.e += 2.0f;
            if (PulseWaveView.this.e > PulseWaveView.this.getWidth() / 2.0f) {
                PulseWaveView pulseWaveView = PulseWaveView.this;
                pulseWaveView.e = pulseWaveView.getWidth() * 0.15f;
            }
            PulseWaveView.this.invalidate();
            PulseWaveView.this.postDelayed(this, 16L);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PulseWaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p31.f(context, "context");
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#0D73FD"));
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setAntiAlias(true);
        this.a = paint;
        Paint paint2 = new Paint();
        paint2.setColor(Color.parseColor("#0D73FD"));
        paint2.setStyle(style);
        paint2.setAntiAlias(true);
        this.b = paint2;
        this.f = Opcodes.FCMPG;
        this.g = new a();
    }

    public final void f(float f) {
        this.d = ga2.f(f, 0.0f, 1.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        p31.f(canvas, "canvas");
        super.onDraw(canvas);
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        float width2 = getWidth() * 0.15f;
        this.b.setAlpha(ga2.g((int) (this.f * (1.0f - ((this.e - width2) / ((getWidth() / 2.0f) - width2)))), 0, 255));
        canvas.drawCircle(width, height, this.e, this.b);
        float width3 = width2 + (getWidth() * 0.2f * this.c);
        this.a.setAlpha(255);
        canvas.drawCircle(width, height, width3, this.a);
        this.a.setColor(-1);
        canvas.drawCircle(width, height, getWidth() * 0.03f, this.a);
        this.a.setColor(Color.parseColor("#0D73FD"));
    }

    public final void setWaveAnimationRunning(boolean z) {
        if (this.h == z) {
            return;
        }
        this.h = z;
        removeCallbacks(this.g);
        if (z) {
            this.e = getWidth() * 0.15f;
            post(this.g);
        }
    }
}
