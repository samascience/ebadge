package xfkj.fitpro.view.sleep.sleepcharts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.blankj.utilcode.util.d;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import defpackage.bn1;
import defpackage.e33;
import defpackage.fz;
import defpackage.nz;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.objectweb.asm.Opcodes;
import xfkj.fitpro.R$styleable;
import xfkj.fitpro.model.SleepChartValueBean;
import xfkj.fitpro.utils.SleepUtils$SleepType;

/* JADX INFO: loaded from: classes4.dex */
public class SleepChartView extends View {
    private boolean A0;
    private Date B0;
    private boolean C0;
    private boolean D0;
    float E0;
    private Paint F;
    float F0;
    private Paint G;
    private Paint H;
    private Paint I;
    private Paint J;
    private int K;
    private Paint L;
    private int M;
    float N;
    private float O;
    private final String P;
    private final String Q;
    private final String R;
    private final String S;
    private Paint T;
    private Paint U;
    private Paint V;
    private int W;
    private final boolean a;
    private int a0;
    private final boolean b;
    private float b0;
    private final boolean c;
    private float c0;
    private final boolean d;
    private float d0;
    private final boolean e;
    private Path e0;
    private final boolean f;
    private int f0;
    private final boolean g;
    private float g0;
    private final boolean h;
    private float h0;
    private final float i;
    private float i0;
    private final float j;
    private float j0;
    private float k;
    private float k0;
    private List l;
    private Paint l0;
    private float m;
    private final int m0;
    private float n;
    private final int n0;
    private float o;
    private final int o0;
    private int p;
    private final int p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f443q;
    private final int[] q0;
    private float r;
    private final int[] r0;
    private float s;
    private final int[] s0;
    private float t;
    private final int[] t0;
    private float u;
    private int u0;
    private float v;
    private int v0;
    private float w;
    private boolean w0;
    private float x;
    private boolean x0;
    private float y;
    private boolean y0;
    private float z;
    private boolean z0;

    class a {
        private float a;
        private float b;
        private float c;
        private float d;
        private float e;
        private float f;
        private int g;

        public a(float f, float f2, float f3, float f4, float f5, float f6, int i) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
            this.e = f5;
            this.f = f6;
            this.g = i;
        }
    }

    public SleepChartView(Context context) {
        this(context, null);
    }

    private void a() {
        if (this.D0) {
            float f = this.s;
            this.x = f / 8.0f;
            this.y = (f / 4.0f) / 2.0f;
        } else {
            float f2 = this.s;
            this.x = f2 / 6.0f;
            this.y = (f2 / 3.0f) / 2.0f;
        }
    }

    private float b(int i) {
        float f;
        float f2;
        float f3;
        if (this.D0) {
            f = i;
            f2 = this.v + (this.x * f);
            f3 = this.y;
        } else {
            if (i == -1) {
                return this.v;
            }
            f = i;
            f2 = this.v + (this.x * f);
            f3 = this.y;
        }
        return f2 + (f * f3);
    }

    private void c(Canvas canvas, String str, String str2, float f) {
        if (Math.abs(this.b0 - f) < 50.0f) {
            canvas.drawText(str2, f, (this.c0 - this.d0) - 25.0f, this.V);
            if (str == null) {
                return;
            }
            canvas.drawText(str, f, (this.c0 - this.d0) - 53.0f, this.V);
            return;
        }
        if (Math.abs(this.b0 - f) > 110.0f) {
            canvas.drawText(str2, f, this.c0 - 10.0f, this.V);
            if (str == null) {
                return;
            }
            canvas.drawText(str, f, this.c0 - 38.0f, this.V);
            return;
        }
        canvas.drawText(str2, f, (((this.d0 + 15.0f) * (Math.abs(this.b0 - f) - 50.0f)) / 60.0f) + ((this.c0 - this.d0) - 25.0f), this.V);
        if (str == null) {
            return;
        }
        canvas.drawText(str, f, (((this.d0 + 15.0f) * (Math.abs(this.b0 - f) - 50.0f)) / 60.0f) + ((this.c0 - this.d0) - 53.0f), this.V);
    }

    private void d(Canvas canvas, List list, List list2, Path path) {
        if (fz.a(list)) {
            return;
        }
        a aVar = (a) list.get(0);
        path.moveTo(aVar.a, aVar.b);
        path.cubicTo(aVar.a, aVar.b, aVar.c, aVar.d, aVar.e, aVar.f);
        for (int i = 1; i < list.size(); i++) {
            e(path, (a) list.get(i), 1);
        }
        for (int size = list2.size() - 1; size >= 0; size--) {
            e(path, (a) list2.get(size), 2);
        }
        path.close();
        canvas.drawPath(path, this.J);
    }

    private void e(Path path, a aVar, int i) {
        if (i == 1) {
            path.lineTo(aVar.a, aVar.b);
            path.cubicTo(aVar.a, aVar.b, aVar.c, aVar.d, aVar.e, aVar.f);
        } else {
            path.lineTo(aVar.e, aVar.f);
            path.cubicTo(aVar.e, aVar.f, aVar.c, aVar.d, aVar.a, aVar.b);
        }
    }

    /* JADX WARN: Code duplicated, block: B:205:0x0bdc  */
    private void f(Canvas canvas, boolean z) {
        float f;
        int i;
        ArrayList arrayList;
        ArrayList arrayList2;
        Path path;
        Canvas canvas2;
        float f2;
        List<SleepChartValueBean> list;
        List<SleepChartValueBean> list2;
        SleepChartValueBean sleepChartValueBean;
        Path path2;
        float f3;
        float f4;
        int i2;
        Path path3;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        boolean z2;
        int i3;
        ArrayList arrayList6;
        Canvas canvas3;
        Canvas canvas4;
        SleepUtils$SleepType sleepUtils$SleepType;
        int i4;
        Canvas canvas5 = canvas;
        boolean z3 = true;
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        Path path4 = new Path();
        List<SleepChartValueBean> filteredDataList = getFilteredDataList();
        int i5 = 0;
        while (i5 < filteredDataList.size()) {
            SleepChartValueBean sleepChartValueBean2 = filteredDataList.get(i5);
            float timeLong = (float) (((double) this.r) * ((((double) sleepChartValueBean2.getTimeLong()) * 1.0d) / ((double) this.o)));
            int elementLevel = sleepChartValueBean2.getElementLevel(this.D0);
            if (elementLevel == -1) {
                i = i5;
                list2 = filteredDataList;
                canvas2 = canvas5;
                z2 = z3;
                arrayList = arrayList7;
                arrayList2 = arrayList8;
                path = path4;
            } else {
                this.F.setShader(null);
                this.G.setShader(null);
                int status = sleepChartValueBean2.getStatus();
                boolean z4 = filteredDataList.indexOf(sleepChartValueBean2) == filteredDataList.size() + (-1) ? z3 : false;
                if (i5 == 0) {
                    Path path5 = new Path();
                    float fAbs = (Math.abs(e33.j(this.B0, sleepChartValueBean2.getStartDate(), 60000)) / this.o) * this.r;
                    this.O = fAbs;
                    float strokeWidth = fAbs + this.F.getStrokeWidth();
                    float fB = b(elementLevel);
                    float f5 = strokeWidth + timeLong;
                    float f6 = this.x + fB;
                    RectF rectF = new RectF(strokeWidth, fB, f5, f6);
                    float f7 = this.N;
                    path5.addRoundRect(rectF, f7, f7, Path.Direction.CCW);
                    float f8 = this.E0;
                    path = path4;
                    f = timeLong;
                    ArrayList arrayList9 = arrayList8;
                    int i6 = i5;
                    List<SleepChartValueBean> list3 = filteredDataList;
                    arrayList7.add(new a(strokeWidth - f8, (fB - f8) + this.F0, strokeWidth - f8, fB - f8, (strokeWidth - f8) + this.t, fB - f8, elementLevel));
                    if (z4) {
                        float f9 = this.E0;
                        float f10 = this.F0;
                        arrayList7.add(new a((f5 - f9) - f10, fB - f9, f5 - f9, fB - f9, f5 - f9, (fB - f9) - f10, elementLevel));
                        i3 = elementLevel;
                    } else {
                        i3 = elementLevel;
                        if (list3.get(i6 + 1).getElementLevel(this.D0) > i3) {
                            float f11 = this.E0;
                            float f12 = this.F0;
                            arrayList7.add(new a((f5 + f11) - f12, fB - f11, f5 + f11, fB - f11, f5 + f11, (fB - f11) + f12, i3));
                        } else {
                            float f13 = this.E0;
                            float f14 = this.F0;
                            arrayList7.add(new a((f5 - f13) - f14, fB - f13, f5 - f13, fB - f13, f5 - f13, (fB - f13) - f14, i3));
                        }
                    }
                    float f15 = this.E0;
                    float f16 = this.F0;
                    arrayList9.add(new a(strokeWidth - f15, (f6 + f15) - f16, strokeWidth - f15, f6 + f15, (strokeWidth - f15) + f16, f6 + f15, i3));
                    if (z4) {
                        float f17 = this.E0;
                        float f18 = this.F0;
                        arrayList = arrayList7;
                        arrayList6 = arrayList9;
                        arrayList6.add(new a((f5 + f17) - f18, f6 + f17, f5 + f17, f6 + f17, f5 + f17, (f6 + f17) - f18, i3));
                    } else {
                        arrayList = arrayList7;
                        arrayList6 = arrayList9;
                        if (list3.get(i6 + 1).getElementLevel(this.D0) > i3) {
                            float f19 = this.E0;
                            float f20 = this.F0;
                            list3 = list3;
                            arrayList6.add(new a((f5 - f19) - f20, f6 + f19, f5 - f19, f6 + f19, f5 - f19, (f6 + f19) - f20, i3));
                        } else {
                            list3 = list3;
                            float f21 = this.E0;
                            float f22 = this.F0;
                            arrayList6.add(new a((f5 + f21) - f22, f6 + f21, f5 + f21, f6 + f21, f5 + f21, (f6 + f21) - f22, i3));
                        }
                    }
                    this.u0 = this.n0;
                    this.v0 = this.p0;
                    SleepUtils$SleepType sleepUtils$SleepType2 = SleepUtils$SleepType.WAKE_UP;
                    if (sleepUtils$SleepType2.getSleepType() == status) {
                        this.F.setShader(new LinearGradient(strokeWidth, fB, strokeWidth, f6, this.q0, new float[]{0.0f, 0.7f, 1.0f}, Shader.TileMode.CLAMP));
                        this.v0 = this.q0[2];
                    }
                    SleepUtils$SleepType sleepUtils$SleepType3 = SleepUtils$SleepType.EYE_MOVEMENT;
                    if (sleepUtils$SleepType3.getSleepType() == status) {
                        this.F.setShader(new LinearGradient(strokeWidth, fB, strokeWidth, f6, this.r0, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
                        this.u0 = this.r0[2];
                    }
                    SleepUtils$SleepType sleepUtils$SleepType4 = SleepUtils$SleepType.LIGHT;
                    if (sleepUtils$SleepType4.getSleepType() == status) {
                        this.F.setShader(new LinearGradient(strokeWidth, fB, strokeWidth, f6, this.s0, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
                        this.u0 = this.s0[2];
                    }
                    SleepUtils$SleepType sleepUtils$SleepType5 = SleepUtils$SleepType.DEEP;
                    if (sleepUtils$SleepType5.getSleepType() == status) {
                        this.F.setShader(new LinearGradient(strokeWidth, f6, strokeWidth, fB, this.t0, new float[]{0.0f, 0.7f, 1.0f}, Shader.TileMode.CLAMP));
                        this.u0 = this.t0[2];
                    }
                    if (z) {
                        canvas3 = canvas;
                        canvas3.drawPath(path5, this.F);
                    } else {
                        canvas3 = canvas;
                    }
                    int i7 = i6 + 1;
                    List<SleepChartValueBean> list4 = list3;
                    SleepChartValueBean sleepChartValueBean3 = i7 < list3.size() ? list4.get(i7) : null;
                    if (sleepChartValueBean3 != null) {
                        int elementLevel2 = sleepChartValueBean3.getElementLevel(this.D0);
                        if (elementLevel2 == -1) {
                            list2 = list4;
                            canvas2 = canvas3;
                            arrayList2 = arrayList6;
                            i = i6;
                            z2 = true;
                        } else {
                            Path path6 = new Path();
                            arrayList2 = arrayList6;
                            Path path7 = new Path();
                            float fB2 = b(elementLevel2);
                            list2 = list4;
                            float f23 = fB2 + this.x;
                            if (elementLevel2 < i3) {
                                i = i6;
                                path7.moveTo(f5 - this.N, fB);
                                path7.lineTo(f5, fB);
                                path7.lineTo(f5, this.N + fB);
                                path6.moveTo(f5, this.N + fB);
                                path6.lineTo(f5, f23 - this.N);
                                int i8 = this.u0;
                                if (status == sleepUtils$SleepType2.getSleepType()) {
                                    i4 = this.q0[2];
                                } else if (status == sleepUtils$SleepType3.getSleepType()) {
                                    i4 = this.r0[2];
                                } else if (status == sleepUtils$SleepType4.getSleepType()) {
                                    i4 = this.s0[2];
                                } else {
                                    i4 = status == sleepUtils$SleepType5.getSleepType() ? this.t0[2] : i8;
                                }
                                sleepUtils$SleepType = sleepUtils$SleepType5;
                                if (sleepChartValueBean3.getStatus() == sleepUtils$SleepType2.getSleepType()) {
                                    int i9 = this.q0[2];
                                    this.G.setShader(new LinearGradient(f5, fB, f5, f23, new int[]{i4, i9, i9}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
                                }
                                if (sleepChartValueBean3.getStatus() == sleepUtils$SleepType3.getSleepType()) {
                                    int i10 = this.r0[2];
                                    this.G.setShader(new LinearGradient(f5, fB, f5, f23, new int[]{i4, i10, i10}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
                                }
                                if (sleepChartValueBean3.getStatus() == sleepUtils$SleepType4.getSleepType()) {
                                    int i11 = this.s0[2];
                                    this.G.setShader(new LinearGradient(f5, fB, f5, f23, new int[]{i4, i11, i11}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
                                }
                            } else {
                                sleepUtils$SleepType = sleepUtils$SleepType5;
                                i = i6;
                            }
                            if (elementLevel2 > i3) {
                                path7.moveTo(f5 - this.N, f6);
                                path7.lineTo(f5, f6 - this.N);
                                path7.lineTo(f5, f6);
                                path6.moveTo(f5, f6 - this.N);
                                path6.lineTo(f5, fB2 + this.N);
                                int i12 = this.v0;
                                if (status == sleepUtils$SleepType2.getSleepType()) {
                                    i12 = this.q0[2];
                                } else if (status == sleepUtils$SleepType3.getSleepType()) {
                                    i12 = this.r0[2];
                                } else if (status == sleepUtils$SleepType4.getSleepType()) {
                                    i12 = this.s0[2];
                                } else if (status == sleepUtils$SleepType.getSleepType()) {
                                    i12 = this.t0[2];
                                }
                                if (sleepChartValueBean3.getStatus() == sleepUtils$SleepType3.getSleepType()) {
                                    int i13 = this.r0[2];
                                    this.G.setShader(new LinearGradient(f5, f6 - this.N, f5, fB2, new int[]{i12, i13, i13}, new float[]{0.0f, 0.6f, 1.0f}, Shader.TileMode.CLAMP));
                                }
                                if (sleepChartValueBean3.getStatus() == sleepUtils$SleepType4.getSleepType()) {
                                    int i14 = this.s0[2];
                                    this.G.setShader(new LinearGradient(f5, f6 - this.N, f5, fB2, new int[]{i12, i14, i14}, new float[]{0.0f, 0.6f, 1.0f}, Shader.TileMode.CLAMP));
                                }
                                if (sleepChartValueBean3.getStatus() == sleepUtils$SleepType.getSleepType()) {
                                    int i15 = this.t0[2];
                                    this.G.setShader(new LinearGradient(f5, f6 - this.N, f5, fB2, new int[]{i12, i15, i15}, new float[]{0.0f, 0.6f, 1.0f}, Shader.TileMode.CLAMP));
                                }
                            }
                            path7.close();
                            if (z) {
                                canvas4 = canvas;
                                canvas4.drawPath(path6, this.G);
                            } else {
                                canvas4 = canvas;
                            }
                            if (f > this.N * 2.0f && z) {
                                canvas4.drawPath(path7, this.F);
                            }
                        }
                    } else {
                        list2 = list4;
                        canvas4 = canvas3;
                        arrayList2 = arrayList6;
                        i = i6;
                    }
                    canvas2 = canvas4;
                    this.O += f;
                    z2 = true;
                } else {
                    f = timeLong;
                    i = i5;
                    List<SleepChartValueBean> list5 = filteredDataList;
                    arrayList = arrayList7;
                    arrayList2 = arrayList8;
                    path = path4;
                    Path path8 = new Path();
                    float strokeWidth2 = this.O + this.F.getStrokeWidth();
                    float fB3 = b(elementLevel);
                    float f24 = strokeWidth2 + f;
                    float f25 = fB3 + this.x;
                    RectF rectF2 = new RectF(strokeWidth2, fB3, f24, f25);
                    float f26 = this.N;
                    path8.addRoundRect(rectF2, f26, f26, Path.Direction.CCW);
                    this.u0 = this.n0;
                    this.v0 = this.p0;
                    SleepUtils$SleepType sleepUtils$SleepType6 = SleepUtils$SleepType.WAKE_UP;
                    if (sleepUtils$SleepType6.getSleepType() == status) {
                        this.F.setShader(new LinearGradient(strokeWidth2, fB3, strokeWidth2, f25, this.q0, new float[]{0.0f, 0.7f, 1.0f}, Shader.TileMode.CLAMP));
                        this.v0 = this.q0[2];
                    }
                    SleepUtils$SleepType sleepUtils$SleepType7 = SleepUtils$SleepType.EYE_MOVEMENT;
                    if (sleepUtils$SleepType7.getSleepType() == status) {
                        this.F.setShader(new LinearGradient(strokeWidth2, fB3, strokeWidth2, f25, this.r0, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
                        this.u0 = this.r0[2];
                    }
                    SleepUtils$SleepType sleepUtils$SleepType8 = SleepUtils$SleepType.LIGHT;
                    if (sleepUtils$SleepType8.getSleepType() == status) {
                        int[] iArr = this.s0;
                        this.F.setShader(new LinearGradient(strokeWidth2, fB3, strokeWidth2, f25, iArr, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
                        this.u0 = iArr[2];
                    }
                    SleepUtils$SleepType sleepUtils$SleepType9 = SleepUtils$SleepType.DEEP;
                    if (sleepUtils$SleepType9.getSleepType() == status) {
                        this.F.setShader(new LinearGradient(strokeWidth2, f25, strokeWidth2, fB3, this.t0, new float[]{0.0f, 0.7f, 1.0f}, Shader.TileMode.CLAMP));
                        this.u0 = this.t0[2];
                    }
                    if (z) {
                        canvas5.drawPath(path8, this.F);
                    }
                    if (i > 0) {
                        int elementLevel3 = list5.get(i - 1).getElementLevel(this.D0);
                        if (elementLevel3 == -1) {
                            list2 = list5;
                            canvas2 = canvas5;
                        } else {
                            Path path9 = new Path();
                            if (elementLevel > elementLevel3) {
                                float f27 = this.E0;
                                float f28 = this.F0;
                                f4 = f25;
                                list = list5;
                                arrayList.add(new a(strokeWidth2 + f27, (fB3 - f27) - f28, strokeWidth2 + f27, fB3 - f27, strokeWidth2 + f27 + f28, fB3 - f27, elementLevel));
                                if (z4) {
                                    float f29 = this.E0;
                                    float f30 = this.F0;
                                    f3 = strokeWidth2;
                                    arrayList5 = arrayList;
                                    arrayList5.add(new a((f24 + f29) - f30, fB3 - f29, f24 + f29, fB3 - f29, f24 + f29, (fB3 - f29) + f30, elementLevel));
                                } else {
                                    f3 = strokeWidth2;
                                    arrayList5 = arrayList;
                                    if (list.get(i + 1).getElementLevel(this.D0) > elementLevel) {
                                        float f31 = this.E0;
                                        float f32 = this.F0;
                                        arrayList5.add(new a((f24 + f31) - f32, fB3 - f31, f24 + f31, fB3 - f31, f24 + f31, (fB3 - f31) + f32, elementLevel));
                                    } else {
                                        float f33 = this.E0;
                                        float f34 = this.F0;
                                        arrayList5.add(new a((f24 - f33) - f34, fB3 - f33, f24 - f33, fB3 - f33, f24 - f33, (fB3 - f33) - f34, elementLevel));
                                    }
                                }
                                float f35 = this.E0;
                                float f36 = this.F0;
                                arrayList2.add(new a(f3 - f35, (f4 + f35) - f36, f3 - f35, f4 + f35, (f3 - f35) + f36, f4 + f35, elementLevel));
                                if (z4) {
                                    float f37 = this.E0;
                                    float f38 = this.F0;
                                    arrayList = arrayList5;
                                    arrayList2 = arrayList2;
                                    arrayList2.add(new a((f24 + f37) - f38, f4 + f37, f24 + f37, f4 + f37, f24 + f37, (f4 + f37) - f38, elementLevel));
                                } else {
                                    arrayList = arrayList5;
                                    arrayList2 = arrayList2;
                                    if (list.get(i + 1).getElementLevel(this.D0) > elementLevel) {
                                        float f39 = this.E0;
                                        float f40 = this.F0;
                                        arrayList2.add(new a((f24 - f39) - f40, f4 + f39, f24 - f39, f4 + f39, f24 - f39, (f4 + f39) - f40, elementLevel));
                                    } else {
                                        float f41 = this.E0;
                                        float f42 = this.F0;
                                        arrayList2.add(new a((f24 + f41) - f42, f4 + f41, f24 + f41, f4 + f41, f24 + f41, (f4 + f41) - f42, elementLevel));
                                    }
                                }
                                path2 = path9;
                                path2.moveTo(f3 + this.N, fB3);
                                float f43 = f3 + 1.0f;
                                path2.lineTo(f43, fB3 - this.N);
                                path2.lineTo(f43, this.N + fB3);
                                i2 = elementLevel3;
                            } else {
                                path2 = path9;
                                f3 = strokeWidth2;
                                f4 = f25;
                                arrayList2 = arrayList2;
                                list = list5;
                                i2 = elementLevel3;
                            }
                            if (elementLevel < i2) {
                                float f44 = this.E0;
                                float f45 = this.F0;
                                Path path10 = path2;
                                ArrayList arrayList10 = arrayList;
                                arrayList10.add(new a(f3 - f44, (fB3 - f44) + f45, f3 - f44, fB3 - f44, (f3 - f44) + f45, fB3 - f44, elementLevel));
                                if (z4) {
                                    float f46 = this.E0;
                                    float f47 = this.F0;
                                    arrayList3 = arrayList2;
                                    arrayList4 = arrayList10;
                                    arrayList4.add(new a((f24 + f46) - f47, fB3 - f46, f24 + f46, fB3 - f46, f24 + f46, (fB3 - f46) + f47, elementLevel));
                                } else {
                                    arrayList3 = arrayList2;
                                    arrayList4 = arrayList10;
                                    if (list.get(i + 1).getElementLevel(this.D0) < elementLevel) {
                                        float f48 = this.E0;
                                        float f49 = this.F0;
                                        arrayList4.add(new a((f24 - f48) - f49, fB3 - f48, f24 - f48, fB3 - f48, f24 - f48, (fB3 - f48) - f49, elementLevel));
                                    } else {
                                        float f50 = this.E0;
                                        float f51 = this.F0;
                                        arrayList4.add(new a((f24 + f50) - f51, fB3 - f50, f24 + f50, fB3 - f50, f24 + f50, (fB3 - f50) + f51, elementLevel));
                                    }
                                }
                                float f52 = this.E0;
                                float f53 = this.F0;
                                ArrayList arrayList11 = arrayList3;
                                arrayList11.add(new a(f3 + f52, f4 + f52 + f53, f3 + f52, f4 + f52, f3 + f52 + f53, f4 + f52, elementLevel));
                                if (z4) {
                                    float f54 = this.E0;
                                    float f55 = this.F0;
                                    arrayList = arrayList4;
                                    arrayList2 = arrayList11;
                                    arrayList2.add(new a((f24 + f54) - f55, f4 + f54, f24 + f54, f4 + f54, f24 + f54, (f4 + f54) - f55, elementLevel));
                                } else {
                                    arrayList = arrayList4;
                                    arrayList2 = arrayList11;
                                    if (list.get(i + 1).getElementLevel(this.D0) < elementLevel) {
                                        float f56 = this.E0;
                                        float f57 = this.F0;
                                        arrayList2.add(new a((f24 - f56) - f57, f4 + f56, f24 - f56, f4 + f56, f24 - f56, (f4 + f56) - f57, elementLevel));
                                    } else {
                                        float f58 = this.E0;
                                        float f59 = this.F0;
                                        arrayList2.add(new a((f24 - f58) - f59, f4 + f58, f24 - f58, f4 + f58, f24 - f58, f4 + f58 + f59, elementLevel));
                                    }
                                }
                                f2 = f4;
                                path3 = path10;
                                path3.moveTo(f3 + this.N, f2);
                                float f60 = f3 + 1.0f;
                                path3.lineTo(f60, f2 - this.N);
                                path3.lineTo(f60, this.N + f2);
                            } else {
                                path3 = path2;
                                f2 = f4;
                            }
                            path3.close();
                            if (f <= this.N * 2.0f || !z) {
                                canvas2 = canvas;
                            } else {
                                canvas2 = canvas;
                                canvas2.drawPath(path3, this.F);
                            }
                        }
                        z2 = true;
                    } else {
                        canvas2 = canvas5;
                        f2 = f25;
                        arrayList2 = arrayList2;
                        list = list5;
                    }
                    i = i;
                    if (i >= list.size() - 1 || (sleepChartValueBean = list.get(i + 1)) == null) {
                        i = i;
                        arrayList2 = arrayList2;
                        list2 = list;
                    } else {
                        int elementLevel4 = sleepChartValueBean.getElementLevel(this.D0);
                        if (elementLevel4 == -1) {
                            i = i;
                            arrayList2 = arrayList2;
                            list2 = list;
                            z2 = true;
                        } else {
                            Path path11 = new Path();
                            Path path12 = new Path();
                            float fB4 = b(elementLevel4);
                            float f61 = this.x + fB4;
                            if (elementLevel4 < elementLevel) {
                                path12.moveTo(f24 - this.N, fB3);
                                float f62 = f24 - 1.0f;
                                list2 = list;
                                path12.lineTo(f62, fB3 - this.N);
                                path12.lineTo(f62, this.N + fB3);
                                path11.moveTo(f24, this.N + fB3);
                                path11.lineTo(f24, f61 - this.N);
                                if (sleepChartValueBean.getStatus() == sleepUtils$SleepType6.getSleepType()) {
                                    int i16 = this.u0;
                                    int[] iArr2 = this.q0;
                                    this.G.setShader(new LinearGradient(f24, fB3, f24, f61, new int[]{i16, iArr2[1], iArr2[2]}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
                                }
                                if (sleepChartValueBean.getStatus() == sleepUtils$SleepType7.getSleepType()) {
                                    int i17 = this.u0;
                                    int[] iArr3 = this.r0;
                                    this.G.setShader(new LinearGradient(f24, fB3, f24, f61, new int[]{i17, iArr3[1], iArr3[2]}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
                                }
                                if (sleepChartValueBean.getStatus() == sleepUtils$SleepType8.getSleepType()) {
                                    this.G.setShader(new LinearGradient(f24, fB3, f24, f61, this.s0, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
                                }
                                if (sleepChartValueBean.getStatus() == sleepUtils$SleepType9.getSleepType()) {
                                    int i18 = this.u0;
                                    int[] iArr4 = this.t0;
                                    this.G.setShader(new LinearGradient(f24, f2 - this.N, f24, fB4, new int[]{i18, iArr4[1], iArr4[2]}, new float[]{0.0f, 0.6f, 1.0f}, Shader.TileMode.CLAMP));
                                }
                            } else {
                                i = i;
                                arrayList2 = arrayList2;
                                list2 = list;
                            }
                            if (elementLevel4 > elementLevel) {
                                path12.moveTo(f24 - this.N, f2);
                                float f63 = f24 - 1.0f;
                                path12.lineTo(f63, f2 - this.N);
                                path12.lineTo(f63, f2 + this.N);
                                path11.moveTo(f24, f2 - this.N);
                                path11.lineTo(f24, this.N + fB4);
                                if (sleepChartValueBean.getStatus() == sleepUtils$SleepType8.getSleepType()) {
                                    int i19 = this.v0;
                                    int[] iArr5 = this.s0;
                                    this.G.setShader(new LinearGradient(f24, f2 - this.N, f24, fB4, new int[]{i19, iArr5[1], iArr5[2]}, new float[]{0.0f, 0.6f, 1.0f}, Shader.TileMode.CLAMP));
                                }
                                if (sleepChartValueBean.getStatus() == sleepUtils$SleepType9.getSleepType()) {
                                    int i20 = this.u0;
                                    int[] iArr6 = this.t0;
                                    this.G.setShader(new LinearGradient(f24, f2 - this.N, f24, fB4, new int[]{i20, iArr6[1], iArr6[2]}, new float[]{0.0f, 0.6f, 1.0f}, Shader.TileMode.CLAMP));
                                }
                                if (sleepChartValueBean.getStatus() == sleepUtils$SleepType7.getSleepType()) {
                                    int i21 = this.u0;
                                    int[] iArr7 = this.r0;
                                    this.G.setShader(new LinearGradient(f24, f2 - this.N, f24, fB4, new int[]{i21, iArr7[1], iArr7[2]}, new float[]{0.0f, 0.6f, 1.0f}, Shader.TileMode.CLAMP));
                                }
                            }
                            if (z) {
                                path12.close();
                                canvas2.drawPath(path11, this.G);
                                if (f > this.N * 2.0f) {
                                    canvas2.drawPath(path12, this.F);
                                }
                            }
                        }
                    }
                    this.O += f;
                    z2 = true;
                }
            }
            i5 = i + 1;
            z3 = z2;
            canvas5 = canvas2;
            arrayList8 = arrayList2;
            path4 = path;
            filteredDataList = list2;
            arrayList7 = arrayList;
        }
        Canvas canvas6 = canvas5;
        ArrayList arrayList12 = arrayList7;
        ArrayList arrayList13 = arrayList8;
        Path path13 = path4;
        if (z) {
            return;
        }
        d(canvas6, arrayList12, arrayList13, path13);
    }

    private void g(Canvas canvas) {
        if (this.f) {
            canvas.drawColor(Color.parseColor("#f2f2f2"));
            canvas.drawCircle(this.b0, this.c0, this.d0, this.U);
            j(canvas);
        } else {
            canvas.drawColor(-1);
        }
        if (this.e) {
            l(canvas);
        }
    }

    private List<SleepChartValueBean> getFilteredDataList() {
        ArrayList arrayList = new ArrayList();
        if (this.h && !this.C0) {
            for (SleepChartValueBean sleepChartValueBean : this.l) {
                if (sleepChartValueBean.getStatus() != SleepUtils$SleepType.WAKE_UP.getSleepType()) {
                    arrayList.add(sleepChartValueBean);
                }
            }
        } else {
            if (this.D0) {
                return this.l;
            }
            for (SleepChartValueBean sleepChartValueBean2 : this.l) {
                if (sleepChartValueBean2.getStatus() != SleepUtils$SleepType.EYE_MOVEMENT.getSleepType()) {
                    arrayList.add(sleepChartValueBean2);
                }
            }
        }
        return arrayList;
    }

    private void h(Canvas canvas) {
        if (this.d) {
            if (!this.D0) {
                Path path = new Path();
                float height = (getHeight() * 2) / 3;
                path.moveTo(this.t, height);
                path.lineTo(getWidth() - d.c(2.0f), height);
                canvas.drawPath(path, this.H);
                Path path2 = new Path();
                float height2 = getHeight() / 3;
                path2.moveTo(this.t, height2);
                path2.lineTo(getWidth() - d.c(2.0f), height2);
                canvas.drawPath(path2, this.H);
                return;
            }
            Path path3 = new Path();
            float height3 = (getHeight() * 3) / 4;
            path3.moveTo(this.t, height3);
            path3.lineTo(getWidth() - d.c(2.0f), height3);
            canvas.drawPath(path3, this.H);
            Path path4 = new Path();
            float height4 = getHeight() / 2;
            path4.moveTo(this.t, height4);
            path4.lineTo(getWidth() - d.c(2.0f), height4);
            canvas.drawPath(path4, this.H);
            Path path5 = new Path();
            float height5 = getHeight() / 4;
            path5.moveTo(this.t, height5);
            path5.lineTo(getWidth() - d.c(2.0f), height5);
            canvas.drawPath(path5, this.H);
        }
    }

    private void i(Canvas canvas) {
        if (this.z0) {
            Path path = new Path();
            path.moveTo(this.b0, this.s - this.d0);
            path.lineTo(this.b0, 0.0f);
            canvas.drawPath(path, this.L);
        }
    }

    private void j(Canvas canvas) {
        this.e0.reset();
        this.e0.moveTo(0.0f, this.c0);
        this.e0.lineTo((this.b0 - this.d0) - 60.0f, this.c0);
        Path path = this.e0;
        float f = this.b0;
        float f2 = this.d0;
        float f3 = this.c0;
        path.cubicTo(f - f2, f3, (f - f2) - 5.0f, (f3 - f2) - 10.0f, f, (f3 - f2) - 10.0f);
        Path path2 = this.e0;
        float f4 = this.b0;
        float f5 = this.d0;
        float f6 = this.c0;
        path2.cubicTo(f4 + f5 + 5.0f, (f6 - f5) - 10.0f, f4 + f5, f6, f4 + f5 + 60.0f, f6);
        this.e0.lineTo(this.f0, this.c0);
        this.e0.lineTo(this.f0, 0.0f);
        this.e0.lineTo(0.0f, 0.0f);
        this.e0.close();
        canvas.drawPath(this.e0, this.T);
    }

    private void k(Canvas canvas) {
        if (this.A0) {
            String strC = e33.c(bn1.q(this.B0, (int) ((this.b0 / this.r) * this.o)), new SimpleDateFormat(DateFormatUtils.HH_MM_24));
            float fMeasureText = this.I.measureText(strC);
            float textSize = this.I.getTextSize();
            float f = this.k * 10.0f;
            float f2 = this.b0;
            float f3 = this.d0;
            float f4 = f * 2.0f;
            float f5 = (f2 - f3) - f4;
            float f6 = ((this.s / 2.0f) - f3) - f4;
            float f7 = f5 + fMeasureText + f4;
            float f8 = f6 + textSize;
            float f9 = f4 + f8;
            RectF rectF = new RectF(f5, f6, f7, f9);
            float f10 = this.k;
            canvas.drawRoundRect(rectF, f10 * 30.0f, f10 * 30.0f, this.l0);
            canvas.drawText(strC, f5 + (((f7 - f5) - fMeasureText) / 2.0f), f8 + (((f9 - f6) - textSize) / 4.0f), this.I);
        }
    }

    private void l(Canvas canvas) {
        c(canvas, null, "23:00", this.g0);
        c(canvas, null, "01:00", this.h0);
        c(canvas, null, "03:00", this.i0);
        c(canvas, null, "05:00", this.j0);
        c(canvas, null, "07:00", this.k0);
    }

    private void m(Canvas canvas) {
        if (this.w0) {
            Path path = new Path();
            path.moveTo(getWidth(), getHeight() - d.c(1.0f));
            path.lineTo(0.0f, getHeight() - d.c(1.0f));
            canvas.drawPath(path, this.H);
        }
    }

    private void n(Canvas canvas) {
        if (this.x0) {
            Path path = new Path();
            path.moveTo(this.t, 0.0f);
            path.lineTo(this.t, getHeight());
            canvas.drawPath(path, this.H);
        }
    }

    private void o(Canvas canvas) {
        if (this.c) {
            Rect rect = new Rect();
            canvas.drawText("Awake", this.z, d.c(10.0f), this.I);
            if (!this.D0) {
                this.I.getTextBounds("Light", 0, 5, rect);
                canvas.drawText("Light", this.z, (getHeight() / 3) + rect.height() + 10, this.I);
                this.I.getTextBounds("Deep", 0, 4, rect);
                canvas.drawText("Deep", this.z, ((getHeight() * 2) / 3) + rect.height() + 10, this.I);
                return;
            }
            this.I.getTextBounds("REM", 0, 3, rect);
            canvas.drawText("REM", this.z, (getHeight() / 4) + rect.height() + 10, this.I);
            this.I.getTextBounds("Light", 0, 5, rect);
            canvas.drawText("Light", this.z, (getHeight() / 2) + rect.height() + 10, this.I);
            this.I.getTextBounds("Deep", 0, 4, rect);
            canvas.drawText("Deep", this.z, ((getHeight() * 3) / 4) + rect.height() + 10, this.I);
        }
    }

    private void p() {
        Paint paint = new Paint();
        this.T = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.T.setAntiAlias(true);
        this.T.setStrokeWidth(d.c(this.W) * this.k);
        this.T.setColor(this.a0);
        Paint paint2 = new Paint();
        this.U = paint2;
        paint2.setStyle(style);
        this.T.setAntiAlias(true);
        this.U.setStrokeWidth(this.k * 1.0f);
        this.U.setColor(-1);
        Paint paint3 = new Paint();
        this.V = paint3;
        paint3.setAntiAlias(true);
        this.V.setTextSize(d.g(10.0f) * this.k);
        this.V.setTextAlign(Paint.Align.CENTER);
        this.V.setColor(-10066330);
    }

    private List q(List list) {
        if (list != null) {
            if (list.size() > 1) {
                ArrayList arrayList = new ArrayList();
                SleepChartValueBean sleepChartValueBean = (SleepChartValueBean) list.get(0);
                for (int i = 1; i < list.size(); i++) {
                    SleepChartValueBean sleepChartValueBean2 = (SleepChartValueBean) list.get(i);
                    if (sleepChartValueBean.getStatus() == sleepChartValueBean2.getStatus()) {
                        sleepChartValueBean.setTimeLong(sleepChartValueBean.getTimeLong() + sleepChartValueBean2.getTimeLong());
                    } else {
                        arrayList.add(sleepChartValueBean);
                        sleepChartValueBean = sleepChartValueBean2;
                    }
                }
                arrayList.add(sleepChartValueBean);
                return arrayList;
            }
        }
        return list;
    }

    private float r(float f, float f2) {
        return f * f2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        g(canvas);
        if (this.a) {
            f(canvas, false);
        }
        f(canvas, true);
        m(canvas);
        n(canvas);
        o(canvas);
        h(canvas);
        k(canvas);
        i(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = (int) this.m;
        }
        if (mode2 != 1073741824) {
            size2 = ((int) (this.n / 3.0f)) + 40;
        }
        setMeasuredDimension(size, size2);
        this.f0 = size;
        this.b0 = size / 2;
        float f = this.d0;
        this.c0 = size2 - (f * 2.0f);
        this.g0 = f * 3.0f;
        this.h0 = ((size / 2) + (f * 3.0f)) / 2.0f;
        this.i0 = size / 2;
        this.j0 = ((size - (f * 3.0f)) + (size / 2)) / 2.0f;
        this.k0 = size - (f * 3.0f);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.p = i;
        this.f443q = i2;
        this.r = (i - this.t) - this.u;
        this.s = (i2 - this.v) - this.w;
        if (!this.h || this.C0) {
            a();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.b) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            if (motionEvent.getX() < this.d0 || motionEvent.getX() > this.f0 - this.d0) {
                return super.onTouchEvent(motionEvent);
            }
            this.b0 = motionEvent.getX();
            invalidate();
            return true;
        }
        if (action != 2 || motionEvent.getX() >= this.f0 - this.d0 || motionEvent.getX() <= this.d0) {
            return true;
        }
        this.b0 = motionEvent.getX();
        invalidate();
        return true;
    }

    public void setData(List<SleepChartValueBean> list) {
        if (list == null || list.isEmpty()) {
            this.l = new ArrayList();
            this.B0 = bn1.a(e33.e());
        } else {
            this.l = q(list);
            if (this.g) {
                this.B0 = list.get(0).getStartDate();
                if (fz.c(list) > 1) {
                    this.o = Math.abs(e33.j(list.get(list.size() - 1).getStartDate(), this.B0, 60000));
                }
            } else {
                Date dateA = bn1.a(list.get(0).getStartDate());
                this.B0 = dateA;
                this.o = Math.abs(e33.j(bn1.r(dateA), this.B0, 60000));
            }
        }
        SleepChartValueBean.setOffsetOfLight(0);
        if (this.h) {
            this.C0 = false;
            Iterator<SleepChartValueBean> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().getStatus() == SleepUtils$SleepType.WAKE_UP.getSleepType()) {
                    this.C0 = true;
                    break;
                }
            }
            if (this.C0) {
                a();
            } else {
                SleepChartValueBean.setOffsetOfLight(1);
                float f = this.i;
                float f2 = this.k;
                this.x = f * f2;
                this.y = this.j * f2;
            }
        }
        postInvalidate();
    }

    public void setShowEyeMovement(boolean z) {
        this.D0 = z;
        a();
        invalidate();
    }

    public SleepChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SleepChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = new ArrayList();
        this.o = 600.0f;
        this.p = 0;
        this.f443q = 0;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = 10.0f;
        this.u = 10.0f;
        this.w = 15.0f;
        this.z = 20.0f;
        this.F = new Paint();
        this.G = new Paint();
        this.H = new Paint();
        this.I = new Paint(1);
        this.J = new Paint(1);
        this.K = Color.parseColor("#8f867d");
        this.L = new Paint();
        this.M = Color.parseColor("#8f867d");
        this.N = d.c(2.0f);
        this.P = "Awake";
        this.Q = "REM";
        this.R = "Light";
        this.S = "Deep";
        this.e0 = new Path();
        int iA = nz.a(R.color.somnolence_sleep_background);
        this.m0 = iA;
        int iA2 = nz.a(R.color.sober_sleep_background);
        this.n0 = iA2;
        int iA3 = nz.a(R.color.eye_movement_sleep_background);
        this.o0 = iA3;
        int iA4 = nz.a(R.color.deep_sleep_background);
        this.p0 = iA4;
        this.q0 = new int[]{iA2, iA2, iA2};
        this.r0 = new int[]{iA3, iA3, iA3};
        this.s0 = new int[]{iA, iA, iA};
        this.t0 = new int[]{iA4, iA4, iA4};
        this.u0 = iA;
        this.v0 = iA4;
        this.C0 = true;
        this.D0 = true;
        this.E0 = 5.0f;
        this.F0 = 10.0f;
        this.m = getResources().getDisplayMetrics().widthPixels;
        this.n = getResources().getDisplayMetrics().heightPixels;
        this.B0 = bn1.a(e33.e());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SleepChartStyle);
        this.k = typedArrayObtainStyledAttributes.getFloat(18, 1.0f);
        this.W = typedArrayObtainStyledAttributes.getDimensionPixelOffset(16, 1);
        this.a0 = typedArrayObtainStyledAttributes.getColor(15, -1);
        float dimension = typedArrayObtainStyledAttributes.getDimension(20, 30.0f);
        this.d0 = typedArrayObtainStyledAttributes.getDimension(0, 30.0f);
        this.a = typedArrayObtainStyledAttributes.getBoolean(19, true);
        this.b = typedArrayObtainStyledAttributes.getBoolean(14, true);
        this.w0 = typedArrayObtainStyledAttributes.getBoolean(10, true);
        this.x0 = typedArrayObtainStyledAttributes.getBoolean(12, true);
        this.y0 = typedArrayObtainStyledAttributes.getBoolean(6, true);
        this.z0 = typedArrayObtainStyledAttributes.getBoolean(5, true);
        this.A0 = typedArrayObtainStyledAttributes.getBoolean(8, true);
        this.c = typedArrayObtainStyledAttributes.getBoolean(13, true);
        this.d = typedArrayObtainStyledAttributes.getBoolean(7, true);
        this.e = typedArrayObtainStyledAttributes.getBoolean(11, true);
        this.f = typedArrayObtainStyledAttributes.getBoolean(9, true);
        this.g = typedArrayObtainStyledAttributes.getBoolean(3, false);
        this.h = typedArrayObtainStyledAttributes.getBoolean(4, false);
        this.v = typedArrayObtainStyledAttributes.getDimension(17, 60.0f);
        this.i = typedArrayObtainStyledAttributes.getDimension(1, 20.0f);
        this.j = typedArrayObtainStyledAttributes.getDimension(2, 30.0f);
        float f = this.k;
        float f2 = dimension * f;
        this.d0 *= f;
        this.F.setStyle(Paint.Style.FILL_AND_STROKE);
        this.F.setStrokeWidth(this.k * 5.0f);
        this.F.setAntiAlias(true);
        Paint paint = this.G;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.G.setStrokeWidth(this.k * 5.0f);
        this.G.setAntiAlias(true);
        this.G.setColor(Opcodes.V_PREVIEW);
        this.J.setStyle(style);
        this.J.setStrokeWidth(this.k * 15.0f);
        this.J.setAntiAlias(true);
        this.J.setColor(Color.parseColor("#60a8acaf"));
        this.H.setStyle(style);
        this.H.setStrokeWidth(this.k * 1.0f);
        this.H.setAntiAlias(true);
        this.H.setColor(this.K);
        this.I.setColor(-16777216);
        this.I.setTextSize(f2);
        this.I.setColor(Color.parseColor("#9EA888"));
        this.L.setStyle(style);
        this.L.setStrokeWidth(this.k * 1.0f);
        this.L.setAntiAlias(true);
        this.L.setColor(this.M);
        this.L.setPathEffect(new DashPathEffect(new float[]{12.0f, 10.0f}, 0.0f));
        Paint paint2 = new Paint();
        this.l0 = paint2;
        paint2.setColor(-1);
        this.l0.setAntiAlias(true);
        this.l0.setShadowLayer(10.0f, 0.0f, 0.0f, -7829368);
        p();
        this.t = r(this.t, this.k);
        this.u = r(this.u, this.k);
        this.v = r(this.v, this.k);
        this.w = r(this.w, this.k);
        this.x = r(this.x, this.k);
        this.y = r(this.y, this.k);
        this.z = r(this.z, this.k);
        this.N *= this.k;
        this.O = this.t;
    }
}
