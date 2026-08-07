package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.Random;
import q.rorbin.badgeview.QBadgeView;

/* JADX INFO: loaded from: classes4.dex */
public class ke extends ValueAnimator {
    private c[][] a;
    private WeakReference b;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QBadgeView qBadgeView = (QBadgeView) ke.this.b.get();
            if (qBadgeView == null || !qBadgeView.isShown()) {
                ke.this.cancel();
            } else {
                qBadgeView.invalidate();
            }
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QBadgeView qBadgeView = (QBadgeView) ke.this.b.get();
            if (qBadgeView != null) {
                qBadgeView.p();
            }
        }
    }

    private class c {
        Random a;
        float b;
        float c;
        float d;
        int e;
        int f;
        Paint g;

        public c() {
            Paint paint = new Paint();
            this.g = paint;
            paint.setAntiAlias(true);
            this.g.setStyle(Paint.Style.FILL);
            this.a = new Random();
        }

        public void a(float f, Canvas canvas) {
            this.g.setColor(this.e);
            this.b += this.a.nextInt(this.f) * 0.1f * (this.a.nextFloat() - 0.5f);
            float fNextInt = this.c + (this.a.nextInt(this.f) * 0.1f * (this.a.nextFloat() - 0.5f));
            this.c = fNextInt;
            float f2 = this.b;
            float f3 = this.d;
            canvas.drawCircle(f2, fNextInt, f3 - (f * f3), this.g);
        }
    }

    public ke(Bitmap bitmap, PointF pointF, QBadgeView qBadgeView) {
        this.b = new WeakReference(qBadgeView);
        setFloatValues(0.0f, 1.0f);
        setDuration(500L);
        this.a = c(bitmap, pointF);
        addUpdateListener(new a());
        addListener(new b());
    }

    private c[][] c(Bitmap bitmap, PointF pointF) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float fMin = Math.min(width, height) / 6.0f;
        float width2 = pointF.x - (bitmap.getWidth() / 2.0f);
        float height2 = pointF.y - (bitmap.getHeight() / 2.0f);
        c[][] cVarArr = (c[][]) Array.newInstance((Class<?>) c.class, (int) (height / fMin), (int) (width / fMin));
        for (int i = 0; i < cVarArr.length; i++) {
            for (int i2 = 0; i2 < cVarArr[i].length; i2++) {
                c cVar = new c();
                float f = i2 * fMin;
                float f2 = i * fMin;
                cVar.e = bitmap.getPixel((int) f, (int) f2);
                cVar.b = f + width2;
                cVar.c = f2 + height2;
                cVar.d = fMin;
                cVar.f = Math.max(width, height);
                cVarArr[i][i2] = cVar;
            }
        }
        bitmap.recycle();
        return cVarArr;
    }

    public void b(Canvas canvas) {
        for (int i = 0; i < this.a.length; i++) {
            int i2 = 0;
            while (true) {
                c[] cVarArr = this.a[i];
                if (i2 < cVarArr.length) {
                    cVarArr[i2].a(Float.parseFloat(getAnimatedValue().toString()), canvas);
                    i2++;
                }
            }
        }
    }
}
