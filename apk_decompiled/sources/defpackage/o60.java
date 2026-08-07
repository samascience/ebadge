package defpackage;

import android.graphics.Color;
import android.graphics.Paint;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public abstract class o60 extends we2 {
    protected hx b;
    protected Paint c;
    protected Paint d;
    protected Paint e;
    protected Paint f;

    public o60(hx hxVar, ue3 ue3Var) {
        super(ue3Var);
        this.b = hxVar;
        Paint paint = new Paint(1);
        this.c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.e = new Paint(4);
        Paint paint2 = new Paint(1);
        this.f = paint2;
        paint2.setColor(Color.rgb(63, 63, 63));
        this.f.setTextAlign(Paint.Align.CENTER);
        this.f.setTextSize(ta3.c(9.0f));
        Paint paint3 = new Paint(1);
        this.d = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(2.0f);
        this.d.setColor(Color.rgb(255, Opcodes.NEW, 115));
    }

    public abstract void a();
}
