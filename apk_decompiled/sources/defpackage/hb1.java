package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class hb1 extends kb1 {
    protected jb1 i;
    protected Paint j;
    protected WeakReference k;
    protected Canvas l;
    protected Bitmap.Config m;
    protected Path n;
    protected Path o;
    private float[] p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected Path f345q;
    private HashMap r;
    private float[] s;

    public hb1(jb1 jb1Var, hx hxVar, ue3 ue3Var) {
        super(hxVar, ue3Var);
        this.m = Bitmap.Config.ARGB_8888;
        this.n = new Path();
        this.o = new Path();
        this.p = new float[4];
        this.f345q = new Path();
        this.r = new HashMap();
        this.s = new float[2];
        this.i = jb1Var;
        Paint paint = new Paint(1);
        this.j = paint;
        paint.setStyle(Paint.Style.FILL);
        this.j.setColor(-1);
    }

    @Override // defpackage.o60
    public void a() {
    }

    public void b() {
        Canvas canvas = this.l;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.l = null;
        }
        WeakReference weakReference = this.k;
        if (weakReference != null) {
            Bitmap bitmap = (Bitmap) weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.k.clear();
            this.k = null;
        }
    }
}
