package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public class hz extends BitmapDrawable {
    private Paint a;
    private Paint b;

    public hz(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
        this.a = new Paint(1);
        this.b = new Paint(1);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int iWidth = getBounds().width();
        int iHeight = getBounds().height();
        float f = iWidth * 0.5f;
        float f2 = iHeight * 0.5f;
        float fMin = Math.min(iWidth, iHeight) * 0.5f;
        this.a.setShader(new SweepGradient(f, f2, new int[]{Opcodes.V_PREVIEW, -65281, -16776961, -16711681, -16711936, -256, Opcodes.V_PREVIEW}, new float[]{0.0f, 0.166f, 0.333f, 0.499f, 0.666f, 0.833f, 0.999f}));
        this.b.setShader(new RadialGradient(f, f2, fMin, -1, 16777215, Shader.TileMode.CLAMP));
        canvas.drawCircle(f, f2, fMin, this.a);
        canvas.drawCircle(f, f2, fMin, this.b);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.a.setAlpha(i);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }
}
