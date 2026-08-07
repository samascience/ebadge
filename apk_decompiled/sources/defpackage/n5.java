package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class n5 extends Drawable {
    private Paint a = new Paint(1);
    private int b;
    private int c;
    private int d;

    public static class a {
        private int a = 25;
        private int b = -1;
        private int c = -3421237;

        public n5 d() {
            return new n5(this);
        }

        public int e() {
            return this.c;
        }

        public int f() {
            return this.b;
        }

        public int g() {
            return this.a;
        }

        public a h(int i) {
            this.c = i;
            return this;
        }

        public a i(int i) {
            this.b = i;
            return this;
        }

        public a j(int i) {
            this.a = i;
            return this;
        }
    }

    public n5() {
        a aVar = new a();
        this.b = aVar.a;
        this.c = aVar.b;
        this.d = aVar.c;
        b();
    }

    private void a(Canvas canvas, Rect rect, Paint paint, int i, int i2) {
        rect.offset(i, i2);
        canvas.drawRect(rect, paint);
    }

    private void b() {
        int i = this.b;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i * 2, i * 2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        int i2 = this.b;
        Rect rect = new Rect(0, 0, i2, i2);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.c);
        a(canvas, rect, paint, 0, 0);
        int i3 = this.b;
        a(canvas, rect, paint, i3, i3);
        paint.setColor(this.d);
        a(canvas, rect, paint, -this.b, 0);
        int i4 = this.b;
        a(canvas, rect, paint, i4, -i4);
        Paint paint2 = this.a;
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        paint2.setShader(new BitmapShader(bitmapCreateBitmap, tileMode, tileMode));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawPaint(this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }

    public n5(a aVar) {
        this.b = aVar.a;
        this.c = aVar.b;
        this.d = aVar.c;
        b();
    }
}
