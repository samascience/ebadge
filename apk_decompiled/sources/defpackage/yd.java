package defpackage;

import android.graphics.DashPathEffect;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class yd extends b10 {
    protected yx0 g;
    public int n;
    protected List y;
    private int h = -7829368;
    private float i = 1.0f;
    private int j = -7829368;
    private float k = 1.0f;
    public float[] l = new float[0];
    public float[] m = new float[0];
    private int o = 6;
    protected float p = 1.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected boolean f446q = false;
    protected boolean r = false;
    protected boolean s = true;
    protected boolean t = true;
    protected boolean u = true;
    protected boolean v = false;
    private DashPathEffect w = null;
    private DashPathEffect x = null;
    protected boolean z = false;
    protected boolean A = true;
    protected float B = 0.0f;
    protected float C = 0.0f;
    protected boolean D = false;
    protected boolean E = false;
    public float F = 0.0f;
    public float G = 0.0f;
    public float H = 0.0f;
    private int I = 2;
    private int J = 25;

    public yd() {
        this.e = ta3.c(10.0f);
        this.b = ta3.c(5.0f);
        this.c = ta3.c(5.0f);
        this.y = new ArrayList();
    }

    public String d(int i) {
        return (i < 0 || i >= this.l.length) ? Constants.STR_EMPTY : f().a(this.l[i], this);
    }

    public String e() {
        String str = Constants.STR_EMPTY;
        for (int i = 0; i < this.l.length; i++) {
            String strD = d(i);
            if (strD != null && str.length() < strD.length()) {
                str = strD;
            }
        }
        return str;
    }

    public yx0 f() {
        yx0 yx0Var = this.g;
        if (yx0Var == null || ((yx0Var instanceof u70) && ((u70) yx0Var).b() != this.n)) {
            this.g = new u70(this.n);
        }
        return this.g;
    }

    public boolean g() {
        return this.u;
    }

    public void h(float f) {
        this.C = f;
    }

    public void i(float f) {
        this.B = f;
    }
}
