package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.tencent.connect.common.Constants;
import defpackage.d70;
import defpackage.sw0;
import defpackage.ye0;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final int[] h = {0, 4, 8};
    private static SparseIntArray i = new SparseIntArray();
    private static SparseIntArray j = new SparseIntArray();
    private boolean a;
    public String b;
    public String c = Constants.STR_EMPTY;
    public int d = 0;
    private HashMap e = new HashMap();
    private boolean f = true;
    private HashMap g = new HashMap();

    public static class a {
        int a;
        String b;
        public final d c = new d();
        public final c d = new c();
        public final C0016b e = new C0016b();
        public final e f = new e();
        public HashMap g = new HashMap();
        C0015a h;

        /* JADX INFO: renamed from: androidx.constraintlayout.widget.b$a$a, reason: collision with other inner class name */
        static class C0015a {
            int[] a = new int[10];
            int[] b = new int[10];
            int c = 0;
            int[] d = new int[10];
            float[] e = new float[10];
            int f = 0;
            int[] g = new int[5];
            String[] h = new String[5];
            int i = 0;
            int[] j = new int[4];
            boolean[] k = new boolean[4];
            int l = 0;

            C0015a() {
            }

            void a(int i, float f) {
                int i2 = this.f;
                int[] iArr = this.d;
                if (i2 >= iArr.length) {
                    this.d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.e;
                    this.e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.d;
                int i3 = this.f;
                iArr2[i3] = i;
                float[] fArr2 = this.e;
                this.f = i3 + 1;
                fArr2[i3] = f;
            }

            void b(int i, int i2) {
                int i3 = this.c;
                int[] iArr = this.a;
                if (i3 >= iArr.length) {
                    this.a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.b;
                    this.b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.a;
                int i4 = this.c;
                iArr3[i4] = i;
                int[] iArr4 = this.b;
                this.c = i4 + 1;
                iArr4[i4] = i2;
            }

            void c(int i, String str) {
                int i2 = this.i;
                int[] iArr = this.g;
                if (i2 >= iArr.length) {
                    this.g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.h;
                    this.h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.g;
                int i3 = this.i;
                iArr2[i3] = i;
                String[] strArr2 = this.h;
                this.i = i3 + 1;
                strArr2[i3] = str;
            }

            void d(int i, boolean z) {
                int i2 = this.l;
                int[] iArr = this.j;
                if (i2 >= iArr.length) {
                    this.j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.k;
                    this.k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.j;
                int i3 = this.l;
                iArr2[i3] = i;
                boolean[] zArr2 = this.k;
                this.l = i3 + 1;
                zArr2[i3] = z;
            }

            void e(a aVar) {
                for (int i = 0; i < this.c; i++) {
                    b.N(aVar, this.a[i], this.b[i]);
                }
                for (int i2 = 0; i2 < this.f; i2++) {
                    b.M(aVar, this.d[i2], this.e[i2]);
                }
                for (int i3 = 0; i3 < this.i; i3++) {
                    b.O(aVar, this.g[i3], this.h[i3]);
                }
                for (int i4 = 0; i4 < this.l; i4++) {
                    b.P(aVar, this.j[i4], this.k[i4]);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(int i, ConstraintLayout.b bVar) {
            this.a = i;
            C0016b c0016b = this.e;
            c0016b.j = bVar.e;
            c0016b.k = bVar.f;
            c0016b.l = bVar.g;
            c0016b.m = bVar.h;
            c0016b.n = bVar.i;
            c0016b.o = bVar.j;
            c0016b.p = bVar.k;
            c0016b.f187q = bVar.l;
            c0016b.r = bVar.m;
            c0016b.s = bVar.n;
            c0016b.t = bVar.o;
            c0016b.u = bVar.s;
            c0016b.v = bVar.t;
            c0016b.w = bVar.u;
            c0016b.x = bVar.v;
            c0016b.y = bVar.G;
            c0016b.z = bVar.H;
            c0016b.A = bVar.I;
            c0016b.B = bVar.p;
            c0016b.C = bVar.f186q;
            c0016b.D = bVar.r;
            c0016b.E = bVar.X;
            c0016b.F = bVar.Y;
            c0016b.G = bVar.Z;
            c0016b.h = bVar.c;
            c0016b.f = bVar.a;
            c0016b.g = bVar.b;
            c0016b.d = ((ViewGroup.MarginLayoutParams) bVar).width;
            c0016b.e = ((ViewGroup.MarginLayoutParams) bVar).height;
            c0016b.H = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            c0016b.I = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
            c0016b.J = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            c0016b.K = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
            c0016b.N = bVar.D;
            c0016b.V = bVar.M;
            c0016b.W = bVar.L;
            c0016b.Y = bVar.O;
            c0016b.X = bVar.N;
            c0016b.n0 = bVar.a0;
            c0016b.o0 = bVar.b0;
            c0016b.Z = bVar.P;
            c0016b.a0 = bVar.Q;
            c0016b.b0 = bVar.T;
            c0016b.c0 = bVar.U;
            c0016b.d0 = bVar.R;
            c0016b.e0 = bVar.S;
            c0016b.f0 = bVar.V;
            c0016b.g0 = bVar.W;
            c0016b.m0 = bVar.c0;
            c0016b.P = bVar.x;
            c0016b.R = bVar.z;
            c0016b.O = bVar.w;
            c0016b.Q = bVar.y;
            c0016b.T = bVar.A;
            c0016b.S = bVar.B;
            c0016b.U = bVar.C;
            c0016b.q0 = bVar.d0;
            c0016b.L = bVar.getMarginEnd();
            this.e.M = bVar.getMarginStart();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(int i, Constraints.a aVar) {
            g(i, aVar);
            this.c.d = aVar.x0;
            e eVar = this.f;
            eVar.b = aVar.A0;
            eVar.c = aVar.B0;
            eVar.d = aVar.C0;
            eVar.e = aVar.D0;
            eVar.f = aVar.E0;
            eVar.g = aVar.F0;
            eVar.h = aVar.G0;
            eVar.j = aVar.H0;
            eVar.k = aVar.I0;
            eVar.l = aVar.J0;
            eVar.n = aVar.z0;
            eVar.m = aVar.y0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(ConstraintHelper constraintHelper, int i, Constraints.a aVar) {
            h(i, aVar);
            if (constraintHelper instanceof Barrier) {
                C0016b c0016b = this.e;
                c0016b.j0 = 1;
                Barrier barrier = (Barrier) constraintHelper;
                c0016b.h0 = barrier.getType();
                this.e.k0 = barrier.getReferencedIds();
                this.e.i0 = barrier.getMargin();
            }
        }

        public void d(a aVar) {
            C0015a c0015a = this.h;
            if (c0015a != null) {
                c0015a.e(aVar);
            }
        }

        public void e(ConstraintLayout.b bVar) {
            C0016b c0016b = this.e;
            bVar.e = c0016b.j;
            bVar.f = c0016b.k;
            bVar.g = c0016b.l;
            bVar.h = c0016b.m;
            bVar.i = c0016b.n;
            bVar.j = c0016b.o;
            bVar.k = c0016b.p;
            bVar.l = c0016b.f187q;
            bVar.m = c0016b.r;
            bVar.n = c0016b.s;
            bVar.o = c0016b.t;
            bVar.s = c0016b.u;
            bVar.t = c0016b.v;
            bVar.u = c0016b.w;
            bVar.v = c0016b.x;
            ((ViewGroup.MarginLayoutParams) bVar).leftMargin = c0016b.H;
            ((ViewGroup.MarginLayoutParams) bVar).rightMargin = c0016b.I;
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = c0016b.J;
            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = c0016b.K;
            bVar.A = c0016b.T;
            bVar.B = c0016b.S;
            bVar.x = c0016b.P;
            bVar.z = c0016b.R;
            bVar.G = c0016b.y;
            bVar.H = c0016b.z;
            bVar.p = c0016b.B;
            bVar.f186q = c0016b.C;
            bVar.r = c0016b.D;
            bVar.I = c0016b.A;
            bVar.X = c0016b.E;
            bVar.Y = c0016b.F;
            bVar.M = c0016b.V;
            bVar.L = c0016b.W;
            bVar.O = c0016b.Y;
            bVar.N = c0016b.X;
            bVar.a0 = c0016b.n0;
            bVar.b0 = c0016b.o0;
            bVar.P = c0016b.Z;
            bVar.Q = c0016b.a0;
            bVar.T = c0016b.b0;
            bVar.U = c0016b.c0;
            bVar.R = c0016b.d0;
            bVar.S = c0016b.e0;
            bVar.V = c0016b.f0;
            bVar.W = c0016b.g0;
            bVar.Z = c0016b.G;
            bVar.c = c0016b.h;
            bVar.a = c0016b.f;
            bVar.b = c0016b.g;
            ((ViewGroup.MarginLayoutParams) bVar).width = c0016b.d;
            ((ViewGroup.MarginLayoutParams) bVar).height = c0016b.e;
            String str = c0016b.m0;
            if (str != null) {
                bVar.c0 = str;
            }
            bVar.d0 = c0016b.q0;
            bVar.setMarginStart(c0016b.M);
            bVar.setMarginEnd(this.e.L);
            bVar.c();
        }

        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.e.a(this.e);
            aVar.d.a(this.d);
            aVar.c.a(this.c);
            aVar.f.a(this.f);
            aVar.a = this.a;
            aVar.h = this.h;
            return aVar;
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.b$b, reason: collision with other inner class name */
    public static class C0016b {
        private static SparseIntArray r0;
        public int d;
        public int e;
        public int[] k0;
        public String l0;
        public String m0;
        public boolean a = false;
        public boolean b = false;
        public boolean c = false;
        public int f = -1;
        public int g = -1;
        public float h = -1.0f;
        public boolean i = true;
        public int j = -1;
        public int k = -1;
        public int l = -1;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f187q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = -1;
        public int v = -1;
        public int w = -1;
        public int x = -1;
        public float y = 0.5f;
        public float z = 0.5f;
        public String A = null;
        public int B = -1;
        public int C = 0;
        public float D = 0.0f;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = 0;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public int T = Integer.MIN_VALUE;
        public int U = Integer.MIN_VALUE;
        public float V = -1.0f;
        public float W = -1.0f;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;
        public int a0 = 0;
        public int b0 = 0;
        public int c0 = 0;
        public int d0 = 0;
        public int e0 = 0;
        public float f0 = 1.0f;
        public float g0 = 1.0f;
        public int h0 = -1;
        public int i0 = 0;
        public int j0 = -1;
        public boolean n0 = false;
        public boolean o0 = false;
        public boolean p0 = true;
        public int q0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            r0 = sparseIntArray;
            sparseIntArray.append(R$styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            r0.append(R$styleable.Layout_layout_constraintLeft_toRightOf, 25);
            r0.append(R$styleable.Layout_layout_constraintRight_toLeftOf, 28);
            r0.append(R$styleable.Layout_layout_constraintRight_toRightOf, 29);
            r0.append(R$styleable.Layout_layout_constraintTop_toTopOf, 35);
            r0.append(R$styleable.Layout_layout_constraintTop_toBottomOf, 34);
            r0.append(R$styleable.Layout_layout_constraintBottom_toTopOf, 4);
            r0.append(R$styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            r0.append(R$styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            r0.append(R$styleable.Layout_layout_editor_absoluteX, 6);
            r0.append(R$styleable.Layout_layout_editor_absoluteY, 7);
            r0.append(R$styleable.Layout_layout_constraintGuide_begin, 17);
            r0.append(R$styleable.Layout_layout_constraintGuide_end, 18);
            r0.append(R$styleable.Layout_layout_constraintGuide_percent, 19);
            r0.append(R$styleable.Layout_guidelineUseRtl, 90);
            r0.append(R$styleable.Layout_android_orientation, 26);
            r0.append(R$styleable.Layout_layout_constraintStart_toEndOf, 31);
            r0.append(R$styleable.Layout_layout_constraintStart_toStartOf, 32);
            r0.append(R$styleable.Layout_layout_constraintEnd_toStartOf, 10);
            r0.append(R$styleable.Layout_layout_constraintEnd_toEndOf, 9);
            r0.append(R$styleable.Layout_layout_goneMarginLeft, 13);
            r0.append(R$styleable.Layout_layout_goneMarginTop, 16);
            r0.append(R$styleable.Layout_layout_goneMarginRight, 14);
            r0.append(R$styleable.Layout_layout_goneMarginBottom, 11);
            r0.append(R$styleable.Layout_layout_goneMarginStart, 15);
            r0.append(R$styleable.Layout_layout_goneMarginEnd, 12);
            r0.append(R$styleable.Layout_layout_constraintVertical_weight, 38);
            r0.append(R$styleable.Layout_layout_constraintHorizontal_weight, 37);
            r0.append(R$styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            r0.append(R$styleable.Layout_layout_constraintVertical_chainStyle, 40);
            r0.append(R$styleable.Layout_layout_constraintHorizontal_bias, 20);
            r0.append(R$styleable.Layout_layout_constraintVertical_bias, 36);
            r0.append(R$styleable.Layout_layout_constraintDimensionRatio, 5);
            r0.append(R$styleable.Layout_layout_constraintLeft_creator, 91);
            r0.append(R$styleable.Layout_layout_constraintTop_creator, 91);
            r0.append(R$styleable.Layout_layout_constraintRight_creator, 91);
            r0.append(R$styleable.Layout_layout_constraintBottom_creator, 91);
            r0.append(R$styleable.Layout_layout_constraintBaseline_creator, 91);
            r0.append(R$styleable.Layout_android_layout_marginLeft, 23);
            r0.append(R$styleable.Layout_android_layout_marginRight, 27);
            r0.append(R$styleable.Layout_android_layout_marginStart, 30);
            r0.append(R$styleable.Layout_android_layout_marginEnd, 8);
            r0.append(R$styleable.Layout_android_layout_marginTop, 33);
            r0.append(R$styleable.Layout_android_layout_marginBottom, 2);
            r0.append(R$styleable.Layout_android_layout_width, 22);
            r0.append(R$styleable.Layout_android_layout_height, 21);
            r0.append(R$styleable.Layout_layout_constraintWidth, 41);
            r0.append(R$styleable.Layout_layout_constraintHeight, 42);
            r0.append(R$styleable.Layout_layout_constrainedWidth, 41);
            r0.append(R$styleable.Layout_layout_constrainedHeight, 42);
            r0.append(R$styleable.Layout_layout_wrapBehaviorInParent, 76);
            r0.append(R$styleable.Layout_layout_constraintCircle, 61);
            r0.append(R$styleable.Layout_layout_constraintCircleRadius, 62);
            r0.append(R$styleable.Layout_layout_constraintCircleAngle, 63);
            r0.append(R$styleable.Layout_layout_constraintWidth_percent, 69);
            r0.append(R$styleable.Layout_layout_constraintHeight_percent, 70);
            r0.append(R$styleable.Layout_chainUseRtl, 71);
            r0.append(R$styleable.Layout_barrierDirection, 72);
            r0.append(R$styleable.Layout_barrierMargin, 73);
            r0.append(R$styleable.Layout_constraint_referenced_ids, 74);
            r0.append(R$styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        public void a(C0016b c0016b) {
            this.a = c0016b.a;
            this.d = c0016b.d;
            this.b = c0016b.b;
            this.e = c0016b.e;
            this.f = c0016b.f;
            this.g = c0016b.g;
            this.h = c0016b.h;
            this.i = c0016b.i;
            this.j = c0016b.j;
            this.k = c0016b.k;
            this.l = c0016b.l;
            this.m = c0016b.m;
            this.n = c0016b.n;
            this.o = c0016b.o;
            this.p = c0016b.p;
            this.f187q = c0016b.f187q;
            this.r = c0016b.r;
            this.s = c0016b.s;
            this.t = c0016b.t;
            this.u = c0016b.u;
            this.v = c0016b.v;
            this.w = c0016b.w;
            this.x = c0016b.x;
            this.y = c0016b.y;
            this.z = c0016b.z;
            this.A = c0016b.A;
            this.B = c0016b.B;
            this.C = c0016b.C;
            this.D = c0016b.D;
            this.E = c0016b.E;
            this.F = c0016b.F;
            this.G = c0016b.G;
            this.H = c0016b.H;
            this.I = c0016b.I;
            this.J = c0016b.J;
            this.K = c0016b.K;
            this.L = c0016b.L;
            this.M = c0016b.M;
            this.N = c0016b.N;
            this.O = c0016b.O;
            this.P = c0016b.P;
            this.Q = c0016b.Q;
            this.R = c0016b.R;
            this.S = c0016b.S;
            this.T = c0016b.T;
            this.U = c0016b.U;
            this.V = c0016b.V;
            this.W = c0016b.W;
            this.X = c0016b.X;
            this.Y = c0016b.Y;
            this.Z = c0016b.Z;
            this.a0 = c0016b.a0;
            this.b0 = c0016b.b0;
            this.c0 = c0016b.c0;
            this.d0 = c0016b.d0;
            this.e0 = c0016b.e0;
            this.f0 = c0016b.f0;
            this.g0 = c0016b.g0;
            this.h0 = c0016b.h0;
            this.i0 = c0016b.i0;
            this.j0 = c0016b.j0;
            this.m0 = c0016b.m0;
            int[] iArr = c0016b.k0;
            if (iArr == null || c0016b.l0 != null) {
                this.k0 = null;
            } else {
                this.k0 = Arrays.copyOf(iArr, iArr.length);
            }
            this.l0 = c0016b.l0;
            this.n0 = c0016b.n0;
            this.o0 = c0016b.o0;
            this.p0 = c0016b.p0;
            this.q0 = c0016b.q0;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Layout);
            this.b = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                int i2 = r0.get(index);
                switch (i2) {
                    case 1:
                        this.r = b.E(typedArrayObtainStyledAttributes, index, this.r);
                        break;
                    case 2:
                        this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        break;
                    case 3:
                        this.f187q = b.E(typedArrayObtainStyledAttributes, index, this.f187q);
                        break;
                    case 4:
                        this.p = b.E(typedArrayObtainStyledAttributes, index, this.p);
                        break;
                    case 5:
                        this.A = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.E = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.E);
                        break;
                    case 7:
                        this.F = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.F);
                        break;
                    case 8:
                        this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L);
                        break;
                    case 9:
                        this.x = b.E(typedArrayObtainStyledAttributes, index, this.x);
                        break;
                    case 10:
                        this.w = b.E(typedArrayObtainStyledAttributes, index, this.w);
                        break;
                    case 11:
                        this.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    case 12:
                        this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.S);
                        break;
                    case 13:
                        this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case 14:
                        this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case 15:
                        this.T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.T);
                        break;
                    case 16:
                        this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case 17:
                        this.f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f);
                        break;
                    case 18:
                        this.g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.g);
                        break;
                    case 19:
                        this.h = typedArrayObtainStyledAttributes.getFloat(index, this.h);
                        break;
                    case 20:
                        this.y = typedArrayObtainStyledAttributes.getFloat(index, this.y);
                        break;
                    case 21:
                        this.e = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.e);
                        break;
                    case 22:
                        this.d = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.d);
                        break;
                    case 23:
                        this.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 24:
                        this.j = b.E(typedArrayObtainStyledAttributes, index, this.j);
                        break;
                    case 25:
                        this.k = b.E(typedArrayObtainStyledAttributes, index, this.k);
                        break;
                    case 26:
                        this.G = typedArrayObtainStyledAttributes.getInt(index, this.G);
                        break;
                    case 27:
                        this.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 28:
                        this.l = b.E(typedArrayObtainStyledAttributes, index, this.l);
                        break;
                    case 29:
                        this.m = b.E(typedArrayObtainStyledAttributes, index, this.m);
                        break;
                    case 30:
                        this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        break;
                    case 31:
                        this.u = b.E(typedArrayObtainStyledAttributes, index, this.u);
                        break;
                    case 32:
                        this.v = b.E(typedArrayObtainStyledAttributes, index, this.v);
                        break;
                    case 33:
                        this.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case 34:
                        this.o = b.E(typedArrayObtainStyledAttributes, index, this.o);
                        break;
                    case 35:
                        this.n = b.E(typedArrayObtainStyledAttributes, index, this.n);
                        break;
                    case 36:
                        this.z = typedArrayObtainStyledAttributes.getFloat(index, this.z);
                        break;
                    case 37:
                        this.W = typedArrayObtainStyledAttributes.getFloat(index, this.W);
                        break;
                    case 38:
                        this.V = typedArrayObtainStyledAttributes.getFloat(index, this.V);
                        break;
                    case 39:
                        this.X = typedArrayObtainStyledAttributes.getInt(index, this.X);
                        break;
                    case 40:
                        this.Y = typedArrayObtainStyledAttributes.getInt(index, this.Y);
                        break;
                    case 41:
                        b.F(this, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        b.F(this, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i2) {
                            case 61:
                                this.B = b.E(typedArrayObtainStyledAttributes, index, this.B);
                                break;
                            case 62:
                                this.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            case 63:
                                this.D = typedArrayObtainStyledAttributes.getFloat(index, this.D);
                                break;
                            default:
                                switch (i2) {
                                    case 69:
                                        this.f0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.g0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        break;
                                    case 72:
                                        this.h0 = typedArrayObtainStyledAttributes.getInt(index, this.h0);
                                        break;
                                    case 73:
                                        this.i0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.i0);
                                        break;
                                    case 74:
                                        this.l0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.p0 = typedArrayObtainStyledAttributes.getBoolean(index, this.p0);
                                        break;
                                    case 76:
                                        this.q0 = typedArrayObtainStyledAttributes.getInt(index, this.q0);
                                        break;
                                    case 77:
                                        this.s = b.E(typedArrayObtainStyledAttributes, index, this.s);
                                        break;
                                    case 78:
                                        this.t = b.E(typedArrayObtainStyledAttributes, index, this.t);
                                        break;
                                    case 79:
                                        this.U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.U);
                                        break;
                                    case 80:
                                        this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                                        break;
                                    case 81:
                                        this.Z = typedArrayObtainStyledAttributes.getInt(index, this.Z);
                                        break;
                                    case 82:
                                        this.a0 = typedArrayObtainStyledAttributes.getInt(index, this.a0);
                                        break;
                                    case 83:
                                        this.c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.c0);
                                        break;
                                    case 84:
                                        this.b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.b0);
                                        break;
                                    case 85:
                                        this.e0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.e0);
                                        break;
                                    case 86:
                                        this.d0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.d0);
                                        break;
                                    case 87:
                                        this.n0 = typedArrayObtainStyledAttributes.getBoolean(index, this.n0);
                                        break;
                                    case 88:
                                        this.o0 = typedArrayObtainStyledAttributes.getBoolean(index, this.o0);
                                        break;
                                    case 89:
                                        this.m0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 90:
                                        this.i = typedArrayObtainStyledAttributes.getBoolean(index, this.i);
                                        break;
                                    case 91:
                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + r0.get(index));
                                        break;
                                    default:
                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + r0.get(index));
                                        break;
                                }
                                break;
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class c {
        private static SparseIntArray o;
        public boolean a = false;
        public int b = -1;
        public int c = 0;
        public String d = null;
        public int e = -1;
        public int f = 0;
        public float g = Float.NaN;
        public int h = -1;
        public float i = Float.NaN;
        public float j = Float.NaN;
        public int k = -1;
        public String l = null;
        public int m = -3;
        public int n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            o = sparseIntArray;
            sparseIntArray.append(R$styleable.Motion_motionPathRotate, 1);
            o.append(R$styleable.Motion_pathMotionArc, 2);
            o.append(R$styleable.Motion_transitionEasing, 3);
            o.append(R$styleable.Motion_drawPath, 4);
            o.append(R$styleable.Motion_animateRelativeTo, 5);
            o.append(R$styleable.Motion_animateCircleAngleTo, 6);
            o.append(R$styleable.Motion_motionStagger, 7);
            o.append(R$styleable.Motion_quantizeMotionSteps, 8);
            o.append(R$styleable.Motion_quantizeMotionPhase, 9);
            o.append(R$styleable.Motion_quantizeMotionInterpolator, 10);
        }

        public void a(c cVar) {
            this.a = cVar.a;
            this.b = cVar.b;
            this.d = cVar.d;
            this.e = cVar.e;
            this.f = cVar.f;
            this.i = cVar.i;
            this.g = cVar.g;
            this.h = cVar.h;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Motion);
            this.a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                switch (o.get(index)) {
                    case 1:
                        this.i = typedArrayObtainStyledAttributes.getFloat(index, this.i);
                        break;
                    case 2:
                        this.e = typedArrayObtainStyledAttributes.getInt(index, this.e);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            this.d = typedArrayObtainStyledAttributes.getString(index);
                        } else {
                            this.d = ye0.c[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        }
                        break;
                    case 4:
                        this.f = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.b = b.E(typedArrayObtainStyledAttributes, index, this.b);
                        break;
                    case 6:
                        this.c = typedArrayObtainStyledAttributes.getInteger(index, this.c);
                        break;
                    case 7:
                        this.g = typedArrayObtainStyledAttributes.getFloat(index, this.g);
                        break;
                    case 8:
                        this.k = typedArrayObtainStyledAttributes.getInteger(index, this.k);
                        break;
                    case 9:
                        this.j = typedArrayObtainStyledAttributes.getFloat(index, this.j);
                        break;
                    case 10:
                        int i2 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i2 == 1) {
                            int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            this.n = resourceId;
                            if (resourceId != -1) {
                                this.m = -2;
                            }
                        } else if (i2 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            this.l = string;
                            if (string.indexOf(WatchConstant.FAT_FS_ROOT) > 0) {
                                this.n = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                this.m = -2;
                            } else {
                                this.m = -1;
                            }
                        } else {
                            this.m = typedArrayObtainStyledAttributes.getInteger(index, this.n);
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class d {
        public boolean a = false;
        public int b = 0;
        public int c = 0;
        public float d = 1.0f;
        public float e = Float.NaN;

        public void a(d dVar) {
            this.a = dVar.a;
            this.b = dVar.b;
            this.d = dVar.d;
            this.e = dVar.e;
            this.c = dVar.c;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PropertySet);
            this.a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R$styleable.PropertySet_android_alpha) {
                    this.d = typedArrayObtainStyledAttributes.getFloat(index, this.d);
                } else if (index == R$styleable.PropertySet_android_visibility) {
                    this.b = typedArrayObtainStyledAttributes.getInt(index, this.b);
                    this.b = b.h[this.b];
                } else if (index == R$styleable.PropertySet_visibilityMode) {
                    this.c = typedArrayObtainStyledAttributes.getInt(index, this.c);
                } else if (index == R$styleable.PropertySet_motionProgress) {
                    this.e = typedArrayObtainStyledAttributes.getFloat(index, this.e);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class e {
        private static SparseIntArray o;
        public boolean a = false;
        public float b = 0.0f;
        public float c = 0.0f;
        public float d = 0.0f;
        public float e = 1.0f;
        public float f = 1.0f;
        public float g = Float.NaN;
        public float h = Float.NaN;
        public int i = -1;
        public float j = 0.0f;
        public float k = 0.0f;
        public float l = 0.0f;
        public boolean m = false;
        public float n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            o = sparseIntArray;
            sparseIntArray.append(R$styleable.Transform_android_rotation, 1);
            o.append(R$styleable.Transform_android_rotationX, 2);
            o.append(R$styleable.Transform_android_rotationY, 3);
            o.append(R$styleable.Transform_android_scaleX, 4);
            o.append(R$styleable.Transform_android_scaleY, 5);
            o.append(R$styleable.Transform_android_transformPivotX, 6);
            o.append(R$styleable.Transform_android_transformPivotY, 7);
            o.append(R$styleable.Transform_android_translationX, 8);
            o.append(R$styleable.Transform_android_translationY, 9);
            o.append(R$styleable.Transform_android_translationZ, 10);
            o.append(R$styleable.Transform_android_elevation, 11);
            o.append(R$styleable.Transform_transformPivotTarget, 12);
        }

        public void a(e eVar) {
            this.a = eVar.a;
            this.b = eVar.b;
            this.c = eVar.c;
            this.d = eVar.d;
            this.e = eVar.e;
            this.f = eVar.f;
            this.g = eVar.g;
            this.h = eVar.h;
            this.i = eVar.i;
            this.j = eVar.j;
            this.k = eVar.k;
            this.l = eVar.l;
            this.m = eVar.m;
            this.n = eVar.n;
        }

        void b(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Transform);
            this.a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                switch (o.get(index)) {
                    case 1:
                        this.b = typedArrayObtainStyledAttributes.getFloat(index, this.b);
                        break;
                    case 2:
                        this.c = typedArrayObtainStyledAttributes.getFloat(index, this.c);
                        break;
                    case 3:
                        this.d = typedArrayObtainStyledAttributes.getFloat(index, this.d);
                        break;
                    case 4:
                        this.e = typedArrayObtainStyledAttributes.getFloat(index, this.e);
                        break;
                    case 5:
                        this.f = typedArrayObtainStyledAttributes.getFloat(index, this.f);
                        break;
                    case 6:
                        this.g = typedArrayObtainStyledAttributes.getDimension(index, this.g);
                        break;
                    case 7:
                        this.h = typedArrayObtainStyledAttributes.getDimension(index, this.h);
                        break;
                    case 8:
                        this.j = typedArrayObtainStyledAttributes.getDimension(index, this.j);
                        break;
                    case 9:
                        this.k = typedArrayObtainStyledAttributes.getDimension(index, this.k);
                        break;
                    case 10:
                        this.l = typedArrayObtainStyledAttributes.getDimension(index, this.l);
                        break;
                    case 11:
                        this.m = true;
                        this.n = typedArrayObtainStyledAttributes.getDimension(index, this.n);
                        break;
                    case 12:
                        this.i = b.E(typedArrayObtainStyledAttributes, index, this.i);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static {
        i.append(R$styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        i.append(R$styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        i.append(R$styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        i.append(R$styleable.Constraint_layout_constraintRight_toRightOf, 30);
        i.append(R$styleable.Constraint_layout_constraintTop_toTopOf, 36);
        i.append(R$styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        i.append(R$styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        i.append(R$styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        i.append(R$styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        i.append(R$styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        i.append(R$styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        i.append(R$styleable.Constraint_layout_editor_absoluteX, 6);
        i.append(R$styleable.Constraint_layout_editor_absoluteY, 7);
        i.append(R$styleable.Constraint_layout_constraintGuide_begin, 17);
        i.append(R$styleable.Constraint_layout_constraintGuide_end, 18);
        i.append(R$styleable.Constraint_layout_constraintGuide_percent, 19);
        i.append(R$styleable.Constraint_guidelineUseRtl, 99);
        i.append(R$styleable.Constraint_android_orientation, 27);
        i.append(R$styleable.Constraint_layout_constraintStart_toEndOf, 32);
        i.append(R$styleable.Constraint_layout_constraintStart_toStartOf, 33);
        i.append(R$styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        i.append(R$styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        i.append(R$styleable.Constraint_layout_goneMarginLeft, 13);
        i.append(R$styleable.Constraint_layout_goneMarginTop, 16);
        i.append(R$styleable.Constraint_layout_goneMarginRight, 14);
        i.append(R$styleable.Constraint_layout_goneMarginBottom, 11);
        i.append(R$styleable.Constraint_layout_goneMarginStart, 15);
        i.append(R$styleable.Constraint_layout_goneMarginEnd, 12);
        i.append(R$styleable.Constraint_layout_constraintVertical_weight, 40);
        i.append(R$styleable.Constraint_layout_constraintHorizontal_weight, 39);
        i.append(R$styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        i.append(R$styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        i.append(R$styleable.Constraint_layout_constraintHorizontal_bias, 20);
        i.append(R$styleable.Constraint_layout_constraintVertical_bias, 37);
        i.append(R$styleable.Constraint_layout_constraintDimensionRatio, 5);
        i.append(R$styleable.Constraint_layout_constraintLeft_creator, 87);
        i.append(R$styleable.Constraint_layout_constraintTop_creator, 87);
        i.append(R$styleable.Constraint_layout_constraintRight_creator, 87);
        i.append(R$styleable.Constraint_layout_constraintBottom_creator, 87);
        i.append(R$styleable.Constraint_layout_constraintBaseline_creator, 87);
        i.append(R$styleable.Constraint_android_layout_marginLeft, 24);
        i.append(R$styleable.Constraint_android_layout_marginRight, 28);
        i.append(R$styleable.Constraint_android_layout_marginStart, 31);
        i.append(R$styleable.Constraint_android_layout_marginEnd, 8);
        i.append(R$styleable.Constraint_android_layout_marginTop, 34);
        i.append(R$styleable.Constraint_android_layout_marginBottom, 2);
        i.append(R$styleable.Constraint_android_layout_width, 23);
        i.append(R$styleable.Constraint_android_layout_height, 21);
        i.append(R$styleable.Constraint_layout_constraintWidth, 95);
        i.append(R$styleable.Constraint_layout_constraintHeight, 96);
        i.append(R$styleable.Constraint_android_visibility, 22);
        i.append(R$styleable.Constraint_android_alpha, 43);
        i.append(R$styleable.Constraint_android_elevation, 44);
        i.append(R$styleable.Constraint_android_rotationX, 45);
        i.append(R$styleable.Constraint_android_rotationY, 46);
        i.append(R$styleable.Constraint_android_rotation, 60);
        i.append(R$styleable.Constraint_android_scaleX, 47);
        i.append(R$styleable.Constraint_android_scaleY, 48);
        i.append(R$styleable.Constraint_android_transformPivotX, 49);
        i.append(R$styleable.Constraint_android_transformPivotY, 50);
        i.append(R$styleable.Constraint_android_translationX, 51);
        i.append(R$styleable.Constraint_android_translationY, 52);
        i.append(R$styleable.Constraint_android_translationZ, 53);
        i.append(R$styleable.Constraint_layout_constraintWidth_default, 54);
        i.append(R$styleable.Constraint_layout_constraintHeight_default, 55);
        i.append(R$styleable.Constraint_layout_constraintWidth_max, 56);
        i.append(R$styleable.Constraint_layout_constraintHeight_max, 57);
        i.append(R$styleable.Constraint_layout_constraintWidth_min, 58);
        i.append(R$styleable.Constraint_layout_constraintHeight_min, 59);
        i.append(R$styleable.Constraint_layout_constraintCircle, 61);
        i.append(R$styleable.Constraint_layout_constraintCircleRadius, 62);
        i.append(R$styleable.Constraint_layout_constraintCircleAngle, 63);
        i.append(R$styleable.Constraint_animateRelativeTo, 64);
        i.append(R$styleable.Constraint_transitionEasing, 65);
        i.append(R$styleable.Constraint_drawPath, 66);
        i.append(R$styleable.Constraint_transitionPathRotate, 67);
        i.append(R$styleable.Constraint_motionStagger, 79);
        i.append(R$styleable.Constraint_android_id, 38);
        i.append(R$styleable.Constraint_motionProgress, 68);
        i.append(R$styleable.Constraint_layout_constraintWidth_percent, 69);
        i.append(R$styleable.Constraint_layout_constraintHeight_percent, 70);
        i.append(R$styleable.Constraint_layout_wrapBehaviorInParent, 97);
        i.append(R$styleable.Constraint_chainUseRtl, 71);
        i.append(R$styleable.Constraint_barrierDirection, 72);
        i.append(R$styleable.Constraint_barrierMargin, 73);
        i.append(R$styleable.Constraint_constraint_referenced_ids, 74);
        i.append(R$styleable.Constraint_barrierAllowsGoneWidgets, 75);
        i.append(R$styleable.Constraint_pathMotionArc, 76);
        i.append(R$styleable.Constraint_layout_constraintTag, 77);
        i.append(R$styleable.Constraint_visibilityMode, 78);
        i.append(R$styleable.Constraint_layout_constrainedWidth, 80);
        i.append(R$styleable.Constraint_layout_constrainedHeight, 81);
        i.append(R$styleable.Constraint_polarRelativeTo, 82);
        i.append(R$styleable.Constraint_transformPivotTarget, 83);
        i.append(R$styleable.Constraint_quantizeMotionSteps, 84);
        i.append(R$styleable.Constraint_quantizeMotionPhase, 85);
        i.append(R$styleable.Constraint_quantizeMotionInterpolator, 86);
        SparseIntArray sparseIntArray = j;
        int i2 = R$styleable.ConstraintOverride_layout_editor_absoluteY;
        sparseIntArray.append(i2, 6);
        j.append(i2, 7);
        j.append(R$styleable.ConstraintOverride_android_orientation, 27);
        j.append(R$styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        j.append(R$styleable.ConstraintOverride_layout_goneMarginTop, 16);
        j.append(R$styleable.ConstraintOverride_layout_goneMarginRight, 14);
        j.append(R$styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        j.append(R$styleable.ConstraintOverride_layout_goneMarginStart, 15);
        j.append(R$styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        j.append(R$styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        j.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        j.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        j.append(R$styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        j.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        j.append(R$styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        j.append(R$styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        j.append(R$styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        j.append(R$styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        j.append(R$styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        j.append(R$styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        j.append(R$styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        j.append(R$styleable.ConstraintOverride_android_layout_marginLeft, 24);
        j.append(R$styleable.ConstraintOverride_android_layout_marginRight, 28);
        j.append(R$styleable.ConstraintOverride_android_layout_marginStart, 31);
        j.append(R$styleable.ConstraintOverride_android_layout_marginEnd, 8);
        j.append(R$styleable.ConstraintOverride_android_layout_marginTop, 34);
        j.append(R$styleable.ConstraintOverride_android_layout_marginBottom, 2);
        j.append(R$styleable.ConstraintOverride_android_layout_width, 23);
        j.append(R$styleable.ConstraintOverride_android_layout_height, 21);
        j.append(R$styleable.ConstraintOverride_layout_constraintWidth, 95);
        j.append(R$styleable.ConstraintOverride_layout_constraintHeight, 96);
        j.append(R$styleable.ConstraintOverride_android_visibility, 22);
        j.append(R$styleable.ConstraintOverride_android_alpha, 43);
        j.append(R$styleable.ConstraintOverride_android_elevation, 44);
        j.append(R$styleable.ConstraintOverride_android_rotationX, 45);
        j.append(R$styleable.ConstraintOverride_android_rotationY, 46);
        j.append(R$styleable.ConstraintOverride_android_rotation, 60);
        j.append(R$styleable.ConstraintOverride_android_scaleX, 47);
        j.append(R$styleable.ConstraintOverride_android_scaleY, 48);
        j.append(R$styleable.ConstraintOverride_android_transformPivotX, 49);
        j.append(R$styleable.ConstraintOverride_android_transformPivotY, 50);
        j.append(R$styleable.ConstraintOverride_android_translationX, 51);
        j.append(R$styleable.ConstraintOverride_android_translationY, 52);
        j.append(R$styleable.ConstraintOverride_android_translationZ, 53);
        j.append(R$styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        j.append(R$styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        j.append(R$styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        j.append(R$styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        j.append(R$styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        j.append(R$styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        j.append(R$styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        j.append(R$styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        j.append(R$styleable.ConstraintOverride_animateRelativeTo, 64);
        j.append(R$styleable.ConstraintOverride_transitionEasing, 65);
        j.append(R$styleable.ConstraintOverride_drawPath, 66);
        j.append(R$styleable.ConstraintOverride_transitionPathRotate, 67);
        j.append(R$styleable.ConstraintOverride_motionStagger, 79);
        j.append(R$styleable.ConstraintOverride_android_id, 38);
        j.append(R$styleable.ConstraintOverride_motionTarget, 98);
        j.append(R$styleable.ConstraintOverride_motionProgress, 68);
        j.append(R$styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        j.append(R$styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        j.append(R$styleable.ConstraintOverride_chainUseRtl, 71);
        j.append(R$styleable.ConstraintOverride_barrierDirection, 72);
        j.append(R$styleable.ConstraintOverride_barrierMargin, 73);
        j.append(R$styleable.ConstraintOverride_constraint_referenced_ids, 74);
        j.append(R$styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        j.append(R$styleable.ConstraintOverride_pathMotionArc, 76);
        j.append(R$styleable.ConstraintOverride_layout_constraintTag, 77);
        j.append(R$styleable.ConstraintOverride_visibilityMode, 78);
        j.append(R$styleable.ConstraintOverride_layout_constrainedWidth, 80);
        j.append(R$styleable.ConstraintOverride_layout_constrainedHeight, 81);
        j.append(R$styleable.ConstraintOverride_polarRelativeTo, 82);
        j.append(R$styleable.ConstraintOverride_transformPivotTarget, 83);
        j.append(R$styleable.ConstraintOverride_quantizeMotionSteps, 84);
        j.append(R$styleable.ConstraintOverride_quantizeMotionPhase, 85);
        j.append(R$styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        j.append(R$styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int E(TypedArray typedArray, int i2, int i3) {
        int resourceId = typedArray.getResourceId(i2, i3);
        return resourceId == -1 ? typedArray.getInt(i2, -1) : resourceId;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0033  */
    /* JADX WARN: Code duplicated, block: B:23:0x0037  */
    /* JADX WARN: Code duplicated, block: B:24:0x003c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0041  */
    /* JADX WARN: Code duplicated, block: B:27:0x0045  */
    /* JADX WARN: Code duplicated, block: B:29:0x0049  */
    /* JADX WARN: Code duplicated, block: B:30:0x004e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0053  */
    /* JADX WARN: Code duplicated, block: B:33:0x0057  */
    /* JADX WARN: Code duplicated, block: B:35:0x005b  */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:44:? A[RETURN, SYNTHETIC] */
    static void F(Object obj, TypedArray typedArray, int i2, int i3) {
        int dimensionPixelSize;
        boolean z;
        a.C0015a c0015a;
        C0016b c0016b;
        ConstraintLayout.b bVar;
        if (obj == null) {
            return;
        }
        int i4 = typedArray.peekValue(i2).type;
        if (i4 == 3) {
            G(obj, typedArray.getString(i2), i3);
            return;
        }
        int i5 = 0;
        if (i4 != 5) {
            dimensionPixelSize = typedArray.getInt(i2, 0);
            if (dimensionPixelSize == -4) {
                z = true;
                i5 = -2;
            } else if (dimensionPixelSize == -3 || (dimensionPixelSize != -2 && dimensionPixelSize != -1)) {
                z = false;
            }
            if (obj instanceof ConstraintLayout.b) {
                bVar = (ConstraintLayout.b) obj;
                if (i3 == 0) {
                    ((ViewGroup.MarginLayoutParams) bVar).width = i5;
                    bVar.a0 = z;
                    return;
                } else {
                    ((ViewGroup.MarginLayoutParams) bVar).height = i5;
                    bVar.b0 = z;
                    return;
                }
            }
            if (obj instanceof C0016b) {
                c0016b = (C0016b) obj;
                if (i3 == 0) {
                    c0016b.d = i5;
                    c0016b.n0 = z;
                    return;
                } else {
                    c0016b.e = i5;
                    c0016b.o0 = z;
                    return;
                }
            }
            if (obj instanceof a.C0015a) {
                c0015a = (a.C0015a) obj;
                if (i3 == 0) {
                    c0015a.b(23, i5);
                    c0015a.d(80, z);
                } else {
                    c0015a.b(21, i5);
                    c0015a.d(81, z);
                }
            }
        }
        dimensionPixelSize = typedArray.getDimensionPixelSize(i2, 0);
        i5 = dimensionPixelSize;
        z = false;
        if (obj instanceof ConstraintLayout.b) {
            bVar = (ConstraintLayout.b) obj;
            if (i3 == 0) {
                ((ViewGroup.MarginLayoutParams) bVar).width = i5;
                bVar.a0 = z;
                return;
            } else {
                ((ViewGroup.MarginLayoutParams) bVar).height = i5;
                bVar.b0 = z;
                return;
            }
        }
        if (obj instanceof C0016b) {
            c0016b = (C0016b) obj;
            if (i3 == 0) {
                c0016b.d = i5;
                c0016b.n0 = z;
                return;
            } else {
                c0016b.e = i5;
                c0016b.o0 = z;
                return;
            }
        }
        if (obj instanceof a.C0015a) {
            c0015a = (a.C0015a) obj;
            if (i3 == 0) {
                c0015a.b(23, i5);
                c0015a.d(80, z);
            } else {
                c0015a.b(21, i5);
                c0015a.d(81, z);
            }
        }
    }

    static void G(Object obj, String str, int i2) {
        if (str == null) {
            return;
        }
        int iIndexOf = str.indexOf(61);
        int length = str.length();
        if (iIndexOf <= 0 || iIndexOf >= length - 1) {
            return;
        }
        String strSubstring = str.substring(0, iIndexOf);
        String strSubstring2 = str.substring(iIndexOf + 1);
        if (strSubstring2.length() > 0) {
            String strTrim = strSubstring.trim();
            String strTrim2 = strSubstring2.trim();
            if ("ratio".equalsIgnoreCase(strTrim)) {
                if (obj instanceof ConstraintLayout.b) {
                    ConstraintLayout.b bVar = (ConstraintLayout.b) obj;
                    if (i2 == 0) {
                        ((ViewGroup.MarginLayoutParams) bVar).width = 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) bVar).height = 0;
                    }
                    H(bVar, strTrim2);
                    return;
                }
                if (obj instanceof C0016b) {
                    ((C0016b) obj).A = strTrim2;
                    return;
                } else {
                    if (obj instanceof a.C0015a) {
                        ((a.C0015a) obj).c(5, strTrim2);
                        return;
                    }
                    return;
                }
            }
            try {
                if ("weight".equalsIgnoreCase(strTrim)) {
                    float f = Float.parseFloat(strTrim2);
                    if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar2 = (ConstraintLayout.b) obj;
                        if (i2 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar2).width = 0;
                            bVar2.L = f;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar2).height = 0;
                            bVar2.M = f;
                        }
                    } else if (obj instanceof C0016b) {
                        C0016b c0016b = (C0016b) obj;
                        if (i2 == 0) {
                            c0016b.d = 0;
                            c0016b.W = f;
                        } else {
                            c0016b.e = 0;
                            c0016b.V = f;
                        }
                    } else if (obj instanceof a.C0015a) {
                        a.C0015a c0015a = (a.C0015a) obj;
                        if (i2 == 0) {
                            c0015a.b(23, 0);
                            c0015a.a(39, f);
                        } else {
                            c0015a.b(21, 0);
                            c0015a.a(40, f);
                        }
                    }
                } else {
                    if (!"parent".equalsIgnoreCase(strTrim)) {
                        return;
                    }
                    float fMax = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(strTrim2)));
                    if (obj instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar3 = (ConstraintLayout.b) obj;
                        if (i2 == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar3).width = 0;
                            bVar3.V = fMax;
                            bVar3.P = 2;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar3).height = 0;
                            bVar3.W = fMax;
                            bVar3.Q = 2;
                        }
                    } else if (obj instanceof C0016b) {
                        C0016b c0016b2 = (C0016b) obj;
                        if (i2 == 0) {
                            c0016b2.d = 0;
                            c0016b2.f0 = fMax;
                            c0016b2.Z = 2;
                        } else {
                            c0016b2.e = 0;
                            c0016b2.g0 = fMax;
                            c0016b2.a0 = 2;
                        }
                    } else if (obj instanceof a.C0015a) {
                        a.C0015a c0015a2 = (a.C0015a) obj;
                        if (i2 == 0) {
                            c0015a2.b(23, 0);
                            c0015a2.b(54, 2);
                        } else {
                            c0015a2.b(21, 0);
                            c0015a2.b(55, 2);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    static void H(ConstraintLayout.b bVar, String str) {
        float fAbs = Float.NaN;
        int i2 = -1;
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            int i3 = 0;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                if (strSubstring.equalsIgnoreCase("W")) {
                    i2 = 0;
                } else if (strSubstring.equalsIgnoreCase("H")) {
                    i2 = 1;
                }
                i3 = iIndexOf + 1;
            }
            int iIndexOf2 = str.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = str.substring(i3);
                    if (strSubstring2.length() > 0) {
                        fAbs = Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = str.substring(i3, iIndexOf2);
                    String strSubstring4 = str.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f = Float.parseFloat(strSubstring3);
                        float f2 = Float.parseFloat(strSubstring4);
                        if (f > 0.0f && f2 > 0.0f) {
                            fAbs = i2 == 1 ? Math.abs(f2 / f) : Math.abs(f / f2);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        bVar.I = str;
        bVar.J = fAbs;
        bVar.K = i2;
    }

    private void I(Context context, a aVar, TypedArray typedArray, boolean z) {
        if (z) {
            J(context, aVar, typedArray);
            return;
        }
        int indexCount = typedArray.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            if (index != R$styleable.Constraint_android_id && R$styleable.Constraint_android_layout_marginStart != index && R$styleable.Constraint_android_layout_marginEnd != index) {
                aVar.d.a = true;
                aVar.e.b = true;
                aVar.c.a = true;
                aVar.f.a = true;
            }
            switch (i.get(index)) {
                case 1:
                    C0016b c0016b = aVar.e;
                    c0016b.r = E(typedArray, index, c0016b.r);
                    break;
                case 2:
                    C0016b c0016b2 = aVar.e;
                    c0016b2.K = typedArray.getDimensionPixelSize(index, c0016b2.K);
                    break;
                case 3:
                    C0016b c0016b3 = aVar.e;
                    c0016b3.f187q = E(typedArray, index, c0016b3.f187q);
                    break;
                case 4:
                    C0016b c0016b4 = aVar.e;
                    c0016b4.p = E(typedArray, index, c0016b4.p);
                    break;
                case 5:
                    aVar.e.A = typedArray.getString(index);
                    break;
                case 6:
                    C0016b c0016b5 = aVar.e;
                    c0016b5.E = typedArray.getDimensionPixelOffset(index, c0016b5.E);
                    break;
                case 7:
                    C0016b c0016b6 = aVar.e;
                    c0016b6.F = typedArray.getDimensionPixelOffset(index, c0016b6.F);
                    break;
                case 8:
                    C0016b c0016b7 = aVar.e;
                    c0016b7.L = typedArray.getDimensionPixelSize(index, c0016b7.L);
                    break;
                case 9:
                    C0016b c0016b8 = aVar.e;
                    c0016b8.x = E(typedArray, index, c0016b8.x);
                    break;
                case 10:
                    C0016b c0016b9 = aVar.e;
                    c0016b9.w = E(typedArray, index, c0016b9.w);
                    break;
                case 11:
                    C0016b c0016b10 = aVar.e;
                    c0016b10.R = typedArray.getDimensionPixelSize(index, c0016b10.R);
                    break;
                case 12:
                    C0016b c0016b11 = aVar.e;
                    c0016b11.S = typedArray.getDimensionPixelSize(index, c0016b11.S);
                    break;
                case 13:
                    C0016b c0016b12 = aVar.e;
                    c0016b12.O = typedArray.getDimensionPixelSize(index, c0016b12.O);
                    break;
                case 14:
                    C0016b c0016b13 = aVar.e;
                    c0016b13.Q = typedArray.getDimensionPixelSize(index, c0016b13.Q);
                    break;
                case 15:
                    C0016b c0016b14 = aVar.e;
                    c0016b14.T = typedArray.getDimensionPixelSize(index, c0016b14.T);
                    break;
                case 16:
                    C0016b c0016b15 = aVar.e;
                    c0016b15.P = typedArray.getDimensionPixelSize(index, c0016b15.P);
                    break;
                case 17:
                    C0016b c0016b16 = aVar.e;
                    c0016b16.f = typedArray.getDimensionPixelOffset(index, c0016b16.f);
                    break;
                case 18:
                    C0016b c0016b17 = aVar.e;
                    c0016b17.g = typedArray.getDimensionPixelOffset(index, c0016b17.g);
                    break;
                case 19:
                    C0016b c0016b18 = aVar.e;
                    c0016b18.h = typedArray.getFloat(index, c0016b18.h);
                    break;
                case 20:
                    C0016b c0016b19 = aVar.e;
                    c0016b19.y = typedArray.getFloat(index, c0016b19.y);
                    break;
                case 21:
                    C0016b c0016b20 = aVar.e;
                    c0016b20.e = typedArray.getLayoutDimension(index, c0016b20.e);
                    break;
                case 22:
                    d dVar = aVar.c;
                    dVar.b = typedArray.getInt(index, dVar.b);
                    d dVar2 = aVar.c;
                    dVar2.b = h[dVar2.b];
                    break;
                case 23:
                    C0016b c0016b21 = aVar.e;
                    c0016b21.d = typedArray.getLayoutDimension(index, c0016b21.d);
                    break;
                case 24:
                    C0016b c0016b22 = aVar.e;
                    c0016b22.H = typedArray.getDimensionPixelSize(index, c0016b22.H);
                    break;
                case 25:
                    C0016b c0016b23 = aVar.e;
                    c0016b23.j = E(typedArray, index, c0016b23.j);
                    break;
                case 26:
                    C0016b c0016b24 = aVar.e;
                    c0016b24.k = E(typedArray, index, c0016b24.k);
                    break;
                case 27:
                    C0016b c0016b25 = aVar.e;
                    c0016b25.G = typedArray.getInt(index, c0016b25.G);
                    break;
                case 28:
                    C0016b c0016b26 = aVar.e;
                    c0016b26.I = typedArray.getDimensionPixelSize(index, c0016b26.I);
                    break;
                case 29:
                    C0016b c0016b27 = aVar.e;
                    c0016b27.l = E(typedArray, index, c0016b27.l);
                    break;
                case 30:
                    C0016b c0016b28 = aVar.e;
                    c0016b28.m = E(typedArray, index, c0016b28.m);
                    break;
                case 31:
                    C0016b c0016b29 = aVar.e;
                    c0016b29.M = typedArray.getDimensionPixelSize(index, c0016b29.M);
                    break;
                case 32:
                    C0016b c0016b30 = aVar.e;
                    c0016b30.u = E(typedArray, index, c0016b30.u);
                    break;
                case 33:
                    C0016b c0016b31 = aVar.e;
                    c0016b31.v = E(typedArray, index, c0016b31.v);
                    break;
                case 34:
                    C0016b c0016b32 = aVar.e;
                    c0016b32.J = typedArray.getDimensionPixelSize(index, c0016b32.J);
                    break;
                case 35:
                    C0016b c0016b33 = aVar.e;
                    c0016b33.o = E(typedArray, index, c0016b33.o);
                    break;
                case 36:
                    C0016b c0016b34 = aVar.e;
                    c0016b34.n = E(typedArray, index, c0016b34.n);
                    break;
                case 37:
                    C0016b c0016b35 = aVar.e;
                    c0016b35.z = typedArray.getFloat(index, c0016b35.z);
                    break;
                case 38:
                    aVar.a = typedArray.getResourceId(index, aVar.a);
                    break;
                case 39:
                    C0016b c0016b36 = aVar.e;
                    c0016b36.W = typedArray.getFloat(index, c0016b36.W);
                    break;
                case 40:
                    C0016b c0016b37 = aVar.e;
                    c0016b37.V = typedArray.getFloat(index, c0016b37.V);
                    break;
                case 41:
                    C0016b c0016b38 = aVar.e;
                    c0016b38.X = typedArray.getInt(index, c0016b38.X);
                    break;
                case 42:
                    C0016b c0016b39 = aVar.e;
                    c0016b39.Y = typedArray.getInt(index, c0016b39.Y);
                    break;
                case 43:
                    d dVar3 = aVar.c;
                    dVar3.d = typedArray.getFloat(index, dVar3.d);
                    break;
                case 44:
                    e eVar = aVar.f;
                    eVar.m = true;
                    eVar.n = typedArray.getDimension(index, eVar.n);
                    break;
                case 45:
                    e eVar2 = aVar.f;
                    eVar2.c = typedArray.getFloat(index, eVar2.c);
                    break;
                case 46:
                    e eVar3 = aVar.f;
                    eVar3.d = typedArray.getFloat(index, eVar3.d);
                    break;
                case 47:
                    e eVar4 = aVar.f;
                    eVar4.e = typedArray.getFloat(index, eVar4.e);
                    break;
                case 48:
                    e eVar5 = aVar.f;
                    eVar5.f = typedArray.getFloat(index, eVar5.f);
                    break;
                case 49:
                    e eVar6 = aVar.f;
                    eVar6.g = typedArray.getDimension(index, eVar6.g);
                    break;
                case 50:
                    e eVar7 = aVar.f;
                    eVar7.h = typedArray.getDimension(index, eVar7.h);
                    break;
                case 51:
                    e eVar8 = aVar.f;
                    eVar8.j = typedArray.getDimension(index, eVar8.j);
                    break;
                case 52:
                    e eVar9 = aVar.f;
                    eVar9.k = typedArray.getDimension(index, eVar9.k);
                    break;
                case 53:
                    e eVar10 = aVar.f;
                    eVar10.l = typedArray.getDimension(index, eVar10.l);
                    break;
                case 54:
                    C0016b c0016b40 = aVar.e;
                    c0016b40.Z = typedArray.getInt(index, c0016b40.Z);
                    break;
                case 55:
                    C0016b c0016b41 = aVar.e;
                    c0016b41.a0 = typedArray.getInt(index, c0016b41.a0);
                    break;
                case 56:
                    C0016b c0016b42 = aVar.e;
                    c0016b42.b0 = typedArray.getDimensionPixelSize(index, c0016b42.b0);
                    break;
                case 57:
                    C0016b c0016b43 = aVar.e;
                    c0016b43.c0 = typedArray.getDimensionPixelSize(index, c0016b43.c0);
                    break;
                case 58:
                    C0016b c0016b44 = aVar.e;
                    c0016b44.d0 = typedArray.getDimensionPixelSize(index, c0016b44.d0);
                    break;
                case 59:
                    C0016b c0016b45 = aVar.e;
                    c0016b45.e0 = typedArray.getDimensionPixelSize(index, c0016b45.e0);
                    break;
                case 60:
                    e eVar11 = aVar.f;
                    eVar11.b = typedArray.getFloat(index, eVar11.b);
                    break;
                case 61:
                    C0016b c0016b46 = aVar.e;
                    c0016b46.B = E(typedArray, index, c0016b46.B);
                    break;
                case 62:
                    C0016b c0016b47 = aVar.e;
                    c0016b47.C = typedArray.getDimensionPixelSize(index, c0016b47.C);
                    break;
                case 63:
                    C0016b c0016b48 = aVar.e;
                    c0016b48.D = typedArray.getFloat(index, c0016b48.D);
                    break;
                case 64:
                    c cVar = aVar.d;
                    cVar.b = E(typedArray, index, cVar.b);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        aVar.d.d = typedArray.getString(index);
                    } else {
                        aVar.d.d = ye0.c[typedArray.getInteger(index, 0)];
                    }
                    break;
                case 66:
                    aVar.d.f = typedArray.getInt(index, 0);
                    break;
                case 67:
                    c cVar2 = aVar.d;
                    cVar2.i = typedArray.getFloat(index, cVar2.i);
                    break;
                case 68:
                    d dVar4 = aVar.c;
                    dVar4.e = typedArray.getFloat(index, dVar4.e);
                    break;
                case 69:
                    aVar.e.f0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.e.g0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    C0016b c0016b49 = aVar.e;
                    c0016b49.h0 = typedArray.getInt(index, c0016b49.h0);
                    break;
                case 73:
                    C0016b c0016b50 = aVar.e;
                    c0016b50.i0 = typedArray.getDimensionPixelSize(index, c0016b50.i0);
                    break;
                case 74:
                    aVar.e.l0 = typedArray.getString(index);
                    break;
                case 75:
                    C0016b c0016b51 = aVar.e;
                    c0016b51.p0 = typedArray.getBoolean(index, c0016b51.p0);
                    break;
                case 76:
                    c cVar3 = aVar.d;
                    cVar3.e = typedArray.getInt(index, cVar3.e);
                    break;
                case 77:
                    aVar.e.m0 = typedArray.getString(index);
                    break;
                case 78:
                    d dVar5 = aVar.c;
                    dVar5.c = typedArray.getInt(index, dVar5.c);
                    break;
                case 79:
                    c cVar4 = aVar.d;
                    cVar4.g = typedArray.getFloat(index, cVar4.g);
                    break;
                case 80:
                    C0016b c0016b52 = aVar.e;
                    c0016b52.n0 = typedArray.getBoolean(index, c0016b52.n0);
                    break;
                case 81:
                    C0016b c0016b53 = aVar.e;
                    c0016b53.o0 = typedArray.getBoolean(index, c0016b53.o0);
                    break;
                case 82:
                    c cVar5 = aVar.d;
                    cVar5.c = typedArray.getInteger(index, cVar5.c);
                    break;
                case 83:
                    e eVar12 = aVar.f;
                    eVar12.i = E(typedArray, index, eVar12.i);
                    break;
                case 84:
                    c cVar6 = aVar.d;
                    cVar6.k = typedArray.getInteger(index, cVar6.k);
                    break;
                case 85:
                    c cVar7 = aVar.d;
                    cVar7.j = typedArray.getFloat(index, cVar7.j);
                    break;
                case 86:
                    int i3 = typedArray.peekValue(index).type;
                    if (i3 == 1) {
                        aVar.d.n = typedArray.getResourceId(index, -1);
                        c cVar8 = aVar.d;
                        if (cVar8.n != -1) {
                            cVar8.m = -2;
                        }
                    } else if (i3 == 3) {
                        aVar.d.l = typedArray.getString(index);
                        if (aVar.d.l.indexOf(WatchConstant.FAT_FS_ROOT) > 0) {
                            aVar.d.n = typedArray.getResourceId(index, -1);
                            aVar.d.m = -2;
                        } else {
                            aVar.d.m = -1;
                        }
                    } else {
                        c cVar9 = aVar.d;
                        cVar9.m = typedArray.getInteger(index, cVar9.n);
                    }
                    break;
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + i.get(index));
                    break;
                case 88:
                case 89:
                case 90:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + i.get(index));
                    break;
                case 91:
                    C0016b c0016b54 = aVar.e;
                    c0016b54.s = E(typedArray, index, c0016b54.s);
                    break;
                case 92:
                    C0016b c0016b55 = aVar.e;
                    c0016b55.t = E(typedArray, index, c0016b55.t);
                    break;
                case 93:
                    C0016b c0016b56 = aVar.e;
                    c0016b56.N = typedArray.getDimensionPixelSize(index, c0016b56.N);
                    break;
                case 94:
                    C0016b c0016b57 = aVar.e;
                    c0016b57.U = typedArray.getDimensionPixelSize(index, c0016b57.U);
                    break;
                case 95:
                    F(aVar.e, typedArray, index, 0);
                    break;
                case 96:
                    F(aVar.e, typedArray, index, 1);
                    break;
                case 97:
                    C0016b c0016b58 = aVar.e;
                    c0016b58.q0 = typedArray.getInt(index, c0016b58.q0);
                    break;
            }
        }
        C0016b c0016b59 = aVar.e;
        if (c0016b59.l0 != null) {
            c0016b59.k0 = null;
        }
    }

    private static void J(Context context, a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        a.C0015a c0015a = new a.C0015a();
        aVar.h = c0015a;
        aVar.d.a = false;
        aVar.e.b = false;
        aVar.c.a = false;
        aVar.f.a = false;
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            switch (j.get(index)) {
                case 2:
                    c0015a.b(2, typedArray.getDimensionPixelSize(index, aVar.e.K));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case 29:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + i.get(index));
                    break;
                case 5:
                    c0015a.c(5, typedArray.getString(index));
                    break;
                case 6:
                    c0015a.b(6, typedArray.getDimensionPixelOffset(index, aVar.e.E));
                    break;
                case 7:
                    c0015a.b(7, typedArray.getDimensionPixelOffset(index, aVar.e.F));
                    break;
                case 8:
                    c0015a.b(8, typedArray.getDimensionPixelSize(index, aVar.e.L));
                    break;
                case 11:
                    c0015a.b(11, typedArray.getDimensionPixelSize(index, aVar.e.R));
                    break;
                case 12:
                    c0015a.b(12, typedArray.getDimensionPixelSize(index, aVar.e.S));
                    break;
                case 13:
                    c0015a.b(13, typedArray.getDimensionPixelSize(index, aVar.e.O));
                    break;
                case 14:
                    c0015a.b(14, typedArray.getDimensionPixelSize(index, aVar.e.Q));
                    break;
                case 15:
                    c0015a.b(15, typedArray.getDimensionPixelSize(index, aVar.e.T));
                    break;
                case 16:
                    c0015a.b(16, typedArray.getDimensionPixelSize(index, aVar.e.P));
                    break;
                case 17:
                    c0015a.b(17, typedArray.getDimensionPixelOffset(index, aVar.e.f));
                    break;
                case 18:
                    c0015a.b(18, typedArray.getDimensionPixelOffset(index, aVar.e.g));
                    break;
                case 19:
                    c0015a.a(19, typedArray.getFloat(index, aVar.e.h));
                    break;
                case 20:
                    c0015a.a(20, typedArray.getFloat(index, aVar.e.y));
                    break;
                case 21:
                    c0015a.b(21, typedArray.getLayoutDimension(index, aVar.e.e));
                    break;
                case 22:
                    c0015a.b(22, h[typedArray.getInt(index, aVar.c.b)]);
                    break;
                case 23:
                    c0015a.b(23, typedArray.getLayoutDimension(index, aVar.e.d));
                    break;
                case 24:
                    c0015a.b(24, typedArray.getDimensionPixelSize(index, aVar.e.H));
                    break;
                case 27:
                    c0015a.b(27, typedArray.getInt(index, aVar.e.G));
                    break;
                case 28:
                    c0015a.b(28, typedArray.getDimensionPixelSize(index, aVar.e.I));
                    break;
                case 31:
                    c0015a.b(31, typedArray.getDimensionPixelSize(index, aVar.e.M));
                    break;
                case 34:
                    c0015a.b(34, typedArray.getDimensionPixelSize(index, aVar.e.J));
                    break;
                case 37:
                    c0015a.a(37, typedArray.getFloat(index, aVar.e.z));
                    break;
                case 38:
                    int resourceId = typedArray.getResourceId(index, aVar.a);
                    aVar.a = resourceId;
                    c0015a.b(38, resourceId);
                    break;
                case 39:
                    c0015a.a(39, typedArray.getFloat(index, aVar.e.W));
                    break;
                case 40:
                    c0015a.a(40, typedArray.getFloat(index, aVar.e.V));
                    break;
                case 41:
                    c0015a.b(41, typedArray.getInt(index, aVar.e.X));
                    break;
                case 42:
                    c0015a.b(42, typedArray.getInt(index, aVar.e.Y));
                    break;
                case 43:
                    c0015a.a(43, typedArray.getFloat(index, aVar.c.d));
                    break;
                case 44:
                    c0015a.d(44, true);
                    c0015a.a(44, typedArray.getDimension(index, aVar.f.n));
                    break;
                case 45:
                    c0015a.a(45, typedArray.getFloat(index, aVar.f.c));
                    break;
                case 46:
                    c0015a.a(46, typedArray.getFloat(index, aVar.f.d));
                    break;
                case 47:
                    c0015a.a(47, typedArray.getFloat(index, aVar.f.e));
                    break;
                case 48:
                    c0015a.a(48, typedArray.getFloat(index, aVar.f.f));
                    break;
                case 49:
                    c0015a.a(49, typedArray.getDimension(index, aVar.f.g));
                    break;
                case 50:
                    c0015a.a(50, typedArray.getDimension(index, aVar.f.h));
                    break;
                case 51:
                    c0015a.a(51, typedArray.getDimension(index, aVar.f.j));
                    break;
                case 52:
                    c0015a.a(52, typedArray.getDimension(index, aVar.f.k));
                    break;
                case 53:
                    c0015a.a(53, typedArray.getDimension(index, aVar.f.l));
                    break;
                case 54:
                    c0015a.b(54, typedArray.getInt(index, aVar.e.Z));
                    break;
                case 55:
                    c0015a.b(55, typedArray.getInt(index, aVar.e.a0));
                    break;
                case 56:
                    c0015a.b(56, typedArray.getDimensionPixelSize(index, aVar.e.b0));
                    break;
                case 57:
                    c0015a.b(57, typedArray.getDimensionPixelSize(index, aVar.e.c0));
                    break;
                case 58:
                    c0015a.b(58, typedArray.getDimensionPixelSize(index, aVar.e.d0));
                    break;
                case 59:
                    c0015a.b(59, typedArray.getDimensionPixelSize(index, aVar.e.e0));
                    break;
                case 60:
                    c0015a.a(60, typedArray.getFloat(index, aVar.f.b));
                    break;
                case 62:
                    c0015a.b(62, typedArray.getDimensionPixelSize(index, aVar.e.C));
                    break;
                case 63:
                    c0015a.a(63, typedArray.getFloat(index, aVar.e.D));
                    break;
                case 64:
                    c0015a.b(64, E(typedArray, index, aVar.d.b));
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        c0015a.c(65, typedArray.getString(index));
                    } else {
                        c0015a.c(65, ye0.c[typedArray.getInteger(index, 0)]);
                    }
                    break;
                case 66:
                    c0015a.b(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    c0015a.a(67, typedArray.getFloat(index, aVar.d.i));
                    break;
                case 68:
                    c0015a.a(68, typedArray.getFloat(index, aVar.c.e));
                    break;
                case 69:
                    c0015a.a(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    c0015a.a(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    c0015a.b(72, typedArray.getInt(index, aVar.e.h0));
                    break;
                case 73:
                    c0015a.b(73, typedArray.getDimensionPixelSize(index, aVar.e.i0));
                    break;
                case 74:
                    c0015a.c(74, typedArray.getString(index));
                    break;
                case 75:
                    c0015a.d(75, typedArray.getBoolean(index, aVar.e.p0));
                    break;
                case 76:
                    c0015a.b(76, typedArray.getInt(index, aVar.d.e));
                    break;
                case 77:
                    c0015a.c(77, typedArray.getString(index));
                    break;
                case 78:
                    c0015a.b(78, typedArray.getInt(index, aVar.c.c));
                    break;
                case 79:
                    c0015a.a(79, typedArray.getFloat(index, aVar.d.g));
                    break;
                case 80:
                    c0015a.d(80, typedArray.getBoolean(index, aVar.e.n0));
                    break;
                case 81:
                    c0015a.d(81, typedArray.getBoolean(index, aVar.e.o0));
                    break;
                case 82:
                    c0015a.b(82, typedArray.getInteger(index, aVar.d.c));
                    break;
                case 83:
                    c0015a.b(83, E(typedArray, index, aVar.f.i));
                    break;
                case 84:
                    c0015a.b(84, typedArray.getInteger(index, aVar.d.k));
                    break;
                case 85:
                    c0015a.a(85, typedArray.getFloat(index, aVar.d.j));
                    break;
                case 86:
                    int i3 = typedArray.peekValue(index).type;
                    if (i3 == 1) {
                        aVar.d.n = typedArray.getResourceId(index, -1);
                        c0015a.b(89, aVar.d.n);
                        c cVar = aVar.d;
                        if (cVar.n != -1) {
                            cVar.m = -2;
                            c0015a.b(88, -2);
                        }
                    } else if (i3 == 3) {
                        aVar.d.l = typedArray.getString(index);
                        c0015a.c(90, aVar.d.l);
                        if (aVar.d.l.indexOf(WatchConstant.FAT_FS_ROOT) > 0) {
                            aVar.d.n = typedArray.getResourceId(index, -1);
                            c0015a.b(89, aVar.d.n);
                            aVar.d.m = -2;
                            c0015a.b(88, -2);
                        } else {
                            aVar.d.m = -1;
                            c0015a.b(88, -1);
                        }
                    } else {
                        c cVar2 = aVar.d;
                        cVar2.m = typedArray.getInteger(index, cVar2.n);
                        c0015a.b(88, aVar.d.m);
                    }
                    break;
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + i.get(index));
                    break;
                case 93:
                    c0015a.b(93, typedArray.getDimensionPixelSize(index, aVar.e.N));
                    break;
                case 94:
                    c0015a.b(94, typedArray.getDimensionPixelSize(index, aVar.e.U));
                    break;
                case 95:
                    F(c0015a, typedArray, index, 0);
                    break;
                case 96:
                    F(c0015a, typedArray, index, 1);
                    break;
                case 97:
                    c0015a.b(97, typedArray.getInt(index, aVar.e.q0));
                    break;
                case 98:
                    if (MotionLayout.h1) {
                        int resourceId2 = typedArray.getResourceId(index, aVar.a);
                        aVar.a = resourceId2;
                        if (resourceId2 == -1) {
                            aVar.b = typedArray.getString(index);
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        aVar.b = typedArray.getString(index);
                    } else {
                        aVar.a = typedArray.getResourceId(index, aVar.a);
                    }
                    break;
                case 99:
                    c0015a.d(99, typedArray.getBoolean(index, aVar.e.i));
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void M(a aVar, int i2, float f) {
        if (i2 == 19) {
            aVar.e.h = f;
        }
        if (i2 == 20) {
            aVar.e.y = f;
            return;
        }
        if (i2 == 37) {
            aVar.e.z = f;
            return;
        }
        if (i2 == 60) {
            aVar.f.b = f;
            return;
        }
        if (i2 == 63) {
            aVar.e.D = f;
            return;
        }
        if (i2 == 79) {
            aVar.d.g = f;
            return;
        }
        if (i2 == 85) {
            aVar.d.j = f;
            return;
        }
        if (i2 != 87) {
            if (i2 == 39) {
                aVar.e.W = f;
                return;
            }
            if (i2 == 40) {
                aVar.e.V = f;
                return;
            }
            switch (i2) {
                case 43:
                    aVar.c.d = f;
                    break;
                case 44:
                    e eVar = aVar.f;
                    eVar.n = f;
                    eVar.m = true;
                    break;
                case 45:
                    aVar.f.c = f;
                    break;
                case 46:
                    aVar.f.d = f;
                    break;
                case 47:
                    aVar.f.e = f;
                    break;
                case 48:
                    aVar.f.f = f;
                    break;
                case 49:
                    aVar.f.g = f;
                    break;
                case 50:
                    aVar.f.h = f;
                    break;
                case 51:
                    aVar.f.j = f;
                    break;
                case 52:
                    aVar.f.k = f;
                    break;
                case 53:
                    aVar.f.l = f;
                    break;
                default:
                    switch (i2) {
                        case 67:
                            aVar.d.i = f;
                            break;
                        case 68:
                            aVar.c.e = f;
                            break;
                        case 69:
                            aVar.e.f0 = f;
                            break;
                        case 70:
                            aVar.e.g0 = f;
                            break;
                        default:
                            Log.w("ConstraintSet", "Unknown attribute 0x");
                            break;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void N(a aVar, int i2, int i3) {
        if (i2 == 6) {
            aVar.e.E = i3;
        }
        if (i2 == 7) {
            aVar.e.F = i3;
            return;
        }
        if (i2 == 8) {
            aVar.e.L = i3;
            return;
        }
        if (i2 == 27) {
            aVar.e.G = i3;
            return;
        }
        if (i2 == 28) {
            aVar.e.I = i3;
            return;
        }
        if (i2 == 41) {
            aVar.e.X = i3;
            return;
        }
        if (i2 == 42) {
            aVar.e.Y = i3;
            return;
        }
        if (i2 == 61) {
            aVar.e.B = i3;
            return;
        }
        if (i2 == 62) {
            aVar.e.C = i3;
            return;
        }
        if (i2 == 72) {
            aVar.e.h0 = i3;
            return;
        }
        if (i2 == 73) {
            aVar.e.i0 = i3;
            return;
        }
        switch (i2) {
            case 2:
                aVar.e.K = i3;
                break;
            case 11:
                aVar.e.R = i3;
                break;
            case 12:
                aVar.e.S = i3;
                break;
            case 13:
                aVar.e.O = i3;
                break;
            case 14:
                aVar.e.Q = i3;
                break;
            case 15:
                aVar.e.T = i3;
                break;
            case 16:
                aVar.e.P = i3;
                break;
            case 17:
                aVar.e.f = i3;
                break;
            case 18:
                aVar.e.g = i3;
                break;
            case 31:
                aVar.e.M = i3;
                break;
            case 34:
                aVar.e.J = i3;
                break;
            case 38:
                aVar.a = i3;
                break;
            case 64:
                aVar.d.b = i3;
                break;
            case 66:
                aVar.d.f = i3;
                break;
            case 76:
                aVar.d.e = i3;
                break;
            case 78:
                aVar.c.c = i3;
                break;
            case 93:
                aVar.e.N = i3;
                break;
            case 94:
                aVar.e.U = i3;
                break;
            case 97:
                aVar.e.q0 = i3;
                break;
            default:
                switch (i2) {
                    case 21:
                        aVar.e.e = i3;
                        break;
                    case 22:
                        aVar.c.b = i3;
                        break;
                    case 23:
                        aVar.e.d = i3;
                        break;
                    case 24:
                        aVar.e.H = i3;
                        break;
                    default:
                        switch (i2) {
                            case 54:
                                aVar.e.Z = i3;
                                break;
                            case 55:
                                aVar.e.a0 = i3;
                                break;
                            case 56:
                                aVar.e.b0 = i3;
                                break;
                            case 57:
                                aVar.e.c0 = i3;
                                break;
                            case 58:
                                aVar.e.d0 = i3;
                                break;
                            case 59:
                                aVar.e.e0 = i3;
                                break;
                            default:
                                switch (i2) {
                                    case 82:
                                        aVar.d.c = i3;
                                        break;
                                    case 83:
                                        aVar.f.i = i3;
                                        break;
                                    case 84:
                                        aVar.d.k = i3;
                                        break;
                                    default:
                                        switch (i2) {
                                            case 87:
                                                break;
                                            case 88:
                                                aVar.d.m = i3;
                                                break;
                                            case 89:
                                                aVar.d.n = i3;
                                                break;
                                            default:
                                                Log.w("ConstraintSet", "Unknown attribute 0x");
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void O(a aVar, int i2, String str) {
        if (i2 == 5) {
            aVar.e.A = str;
            return;
        }
        if (i2 == 65) {
            aVar.d.d = str;
            return;
        }
        if (i2 == 74) {
            C0016b c0016b = aVar.e;
            c0016b.l0 = str;
            c0016b.k0 = null;
        } else if (i2 == 77) {
            aVar.e.m0 = str;
        } else if (i2 != 87) {
            if (i2 != 90) {
                Log.w("ConstraintSet", "Unknown attribute 0x");
            } else {
                aVar.d.l = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void P(a aVar, int i2, boolean z) {
        if (i2 == 44) {
            aVar.f.m = z;
            return;
        }
        if (i2 == 75) {
            aVar.e.p0 = z;
            return;
        }
        if (i2 != 87) {
            if (i2 == 80) {
                aVar.e.n0 = z;
            } else if (i2 != 81) {
                Log.w("ConstraintSet", "Unknown attribute 0x");
            } else {
                aVar.e.o0 = z;
            }
        }
    }

    public static a m(Context context, XmlPullParser xmlPullParser) {
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSetAsAttributeSet, R$styleable.ConstraintOverride);
        J(context, aVar, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    private int[] s(View view, String str) {
        int iIntValue;
        Object objG;
        String[] strArrSplit = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < strArrSplit.length) {
            String strTrim = strArrSplit[i2].trim();
            try {
                iIntValue = R$id.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (objG = ((ConstraintLayout) view.getParent()).g(0, strTrim)) != null && (objG instanceof Integer)) {
                iIntValue = ((Integer) objG).intValue();
            }
            iArr[i3] = iIntValue;
            i2++;
            i3++;
        }
        return i3 != strArrSplit.length ? Arrays.copyOf(iArr, i3) : iArr;
    }

    private a t(Context context, AttributeSet attributeSet, boolean z) {
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z ? R$styleable.ConstraintOverride : R$styleable.Constraint);
        I(context, aVar, typedArrayObtainStyledAttributes, z);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    private a u(int i2) {
        if (!this.g.containsKey(Integer.valueOf(i2))) {
            this.g.put(Integer.valueOf(i2), new a());
        }
        return (a) this.g.get(Integer.valueOf(i2));
    }

    public int A(int i2) {
        return u(i2).c.c;
    }

    public int B(int i2) {
        return u(i2).e.d;
    }

    public void C(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a aVarT = t(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        aVarT.e.a = true;
                    }
                    this.g.put(Integer.valueOf(aVarT.a), aVarT);
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void D(Context context, XmlPullParser xmlPullParser) {
        try {
            int eventType = xmlPullParser.getEventType();
            a aVarT = null;
            while (eventType != 1) {
                if (eventType == 0) {
                    xmlPullParser.getName();
                } else if (eventType == 2) {
                    switch (xmlPullParser.getName()) {
                        case "Constraint":
                            aVarT = t(context, Xml.asAttributeSet(xmlPullParser), false);
                            break;
                        case "ConstraintOverride":
                            aVarT = t(context, Xml.asAttributeSet(xmlPullParser), true);
                            break;
                        case "Guideline":
                            aVarT = t(context, Xml.asAttributeSet(xmlPullParser), false);
                            C0016b c0016b = aVarT.e;
                            c0016b.a = true;
                            c0016b.b = true;
                            break;
                        case "Barrier":
                            aVarT = t(context, Xml.asAttributeSet(xmlPullParser), false);
                            aVarT.e.j0 = 1;
                            break;
                        case "PropertySet":
                            if (aVarT == null) {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                            aVarT.c.b(context, Xml.asAttributeSet(xmlPullParser));
                            break;
                            break;
                        case "Transform":
                            if (aVarT == null) {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                            aVarT.f.b(context, Xml.asAttributeSet(xmlPullParser));
                            break;
                            break;
                        case "Layout":
                            if (aVarT == null) {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                            aVarT.e.b(context, Xml.asAttributeSet(xmlPullParser));
                            break;
                            break;
                        case "Motion":
                            if (aVarT == null) {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                            aVarT.d.b(context, Xml.asAttributeSet(xmlPullParser));
                            break;
                            break;
                        case "CustomAttribute":
                        case "CustomMethod":
                            if (aVarT == null) {
                                throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                            }
                            ConstraintAttribute.h(context, xmlPullParser, aVarT.g);
                            break;
                            break;
                    }
                } else if (eventType == 3) {
                    String lowerCase = xmlPullParser.getName().toLowerCase(Locale.ROOT);
                    switch (lowerCase.hashCode()) {
                        case -2075718416:
                            if (lowerCase.equals("guideline")) {
                            }
                            break;
                        case -190376483:
                            if (lowerCase.equals("constraint")) {
                            }
                            break;
                        case 426575017:
                            if (lowerCase.equals("constraintoverride")) {
                            }
                            break;
                        case 2146106725:
                            if (lowerCase.equals("constraintset")) {
                            }
                            break;
                    }
                    if (r4 == 0) {
                        return;
                    }
                    if (r4 == 1 || r4 == 2 || r4 == 3) {
                        this.g.put(Integer.valueOf(aVarT.a), aVarT);
                        aVarT = null;
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    public void K(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.g.containsKey(Integer.valueOf(id))) {
                this.g.put(Integer.valueOf(id), new a());
            }
            a aVar = (a) this.g.get(Integer.valueOf(id));
            if (aVar != null) {
                if (!aVar.e.b) {
                    aVar.g(id, bVar);
                    if (childAt instanceof ConstraintHelper) {
                        aVar.e.k0 = ((ConstraintHelper) childAt).getReferencedIds();
                        if (childAt instanceof Barrier) {
                            Barrier barrier = (Barrier) childAt;
                            aVar.e.p0 = barrier.getAllowsGoneWidget();
                            aVar.e.h0 = barrier.getType();
                            aVar.e.i0 = barrier.getMargin();
                        }
                    }
                    aVar.e.b = true;
                }
                d dVar = aVar.c;
                if (!dVar.a) {
                    dVar.b = childAt.getVisibility();
                    aVar.c.d = childAt.getAlpha();
                    aVar.c.a = true;
                }
                e eVar = aVar.f;
                if (!eVar.a) {
                    eVar.a = true;
                    eVar.b = childAt.getRotation();
                    aVar.f.c = childAt.getRotationX();
                    aVar.f.d = childAt.getRotationY();
                    aVar.f.e = childAt.getScaleX();
                    aVar.f.f = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (pivotX != 0.0d || pivotY != 0.0d) {
                        e eVar2 = aVar.f;
                        eVar2.g = pivotX;
                        eVar2.h = pivotY;
                    }
                    aVar.f.j = childAt.getTranslationX();
                    aVar.f.k = childAt.getTranslationY();
                    aVar.f.l = childAt.getTranslationZ();
                    e eVar3 = aVar.f;
                    if (eVar3.m) {
                        eVar3.n = childAt.getElevation();
                    }
                }
            }
        }
    }

    public void L(b bVar) {
        for (Integer num : bVar.g.keySet()) {
            num.intValue();
            a aVar = (a) bVar.g.get(num);
            if (!this.g.containsKey(num)) {
                this.g.put(num, new a());
            }
            a aVar2 = (a) this.g.get(num);
            if (aVar2 != null) {
                C0016b c0016b = aVar2.e;
                if (!c0016b.b) {
                    c0016b.a(aVar.e);
                }
                d dVar = aVar2.c;
                if (!dVar.a) {
                    dVar.a(aVar.c);
                }
                e eVar = aVar2.f;
                if (!eVar.a) {
                    eVar.a(aVar.f);
                }
                c cVar = aVar2.d;
                if (!cVar.a) {
                    cVar.a(aVar.d);
                }
                for (String str : aVar.g.keySet()) {
                    if (!aVar2.g.containsKey(str)) {
                        aVar2.g.put(str, (ConstraintAttribute) aVar.g.get(str));
                    }
                }
            }
        }
    }

    public void Q(boolean z) {
        this.f = z;
    }

    public void R(boolean z) {
        this.a = z;
    }

    public void g(ConstraintLayout constraintLayout) {
        a aVar;
        int childCount = constraintLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (!this.g.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + d70.d(childAt));
            } else {
                if (this.f && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (this.g.containsKey(Integer.valueOf(id)) && (aVar = (a) this.g.get(Integer.valueOf(id))) != null) {
                    ConstraintAttribute.i(childAt, aVar.g);
                }
            }
        }
    }

    public void h(b bVar) {
        for (a aVar : bVar.g.values()) {
            if (aVar.h != null) {
                if (aVar.b != null) {
                    Iterator it = this.g.keySet().iterator();
                    while (it.hasNext()) {
                        a aVarV = v(((Integer) it.next()).intValue());
                        String str = aVarV.e.m0;
                        if (str != null && aVar.b.matches(str)) {
                            aVar.h.e(aVarV);
                            aVarV.g.putAll((HashMap) aVar.g.clone());
                        }
                    }
                } else {
                    aVar.h.e(v(aVar.a));
                }
            }
        }
    }

    public void i(ConstraintLayout constraintLayout) {
        k(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void j(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout.b bVar, SparseArray sparseArray) {
        a aVar;
        int id = constraintHelper.getId();
        if (this.g.containsKey(Integer.valueOf(id)) && (aVar = (a) this.g.get(Integer.valueOf(id))) != null && (constraintWidget instanceof sw0)) {
            constraintHelper.o(aVar, (sw0) constraintWidget, bVar, sparseArray);
        }
    }

    void k(ConstraintLayout constraintLayout, boolean z) {
        int childCount = constraintLayout.getChildCount();
        HashSet<Integer> hashSet = new HashSet(this.g.keySet());
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (!this.g.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + d70.d(childAt));
            } else {
                if (this.f && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (this.g.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        a aVar = (a) this.g.get(Integer.valueOf(id));
                        if (aVar != null) {
                            if (childAt instanceof Barrier) {
                                aVar.e.j0 = 1;
                                Barrier barrier = (Barrier) childAt;
                                barrier.setId(id);
                                barrier.setType(aVar.e.h0);
                                barrier.setMargin(aVar.e.i0);
                                barrier.setAllowsGoneWidget(aVar.e.p0);
                                C0016b c0016b = aVar.e;
                                int[] iArr = c0016b.k0;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str = c0016b.l0;
                                    if (str != null) {
                                        c0016b.k0 = s(barrier, str);
                                        barrier.setReferencedIds(aVar.e.k0);
                                    }
                                }
                            }
                            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
                            bVar.c();
                            aVar.e(bVar);
                            if (z) {
                                ConstraintAttribute.i(childAt, aVar.g);
                            }
                            childAt.setLayoutParams(bVar);
                            d dVar = aVar.c;
                            if (dVar.c == 0) {
                                childAt.setVisibility(dVar.b);
                            }
                            childAt.setAlpha(aVar.c.d);
                            childAt.setRotation(aVar.f.b);
                            childAt.setRotationX(aVar.f.c);
                            childAt.setRotationY(aVar.f.d);
                            childAt.setScaleX(aVar.f.e);
                            childAt.setScaleY(aVar.f.f);
                            e eVar = aVar.f;
                            if (eVar.i != -1) {
                                View viewFindViewById = ((View) childAt.getParent()).findViewById(aVar.f.i);
                                if (viewFindViewById != null) {
                                    float top = (viewFindViewById.getTop() + viewFindViewById.getBottom()) / 2.0f;
                                    float left = (viewFindViewById.getLeft() + viewFindViewById.getRight()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        float left2 = left - childAt.getLeft();
                                        float top2 = top - childAt.getTop();
                                        childAt.setPivotX(left2);
                                        childAt.setPivotY(top2);
                                    }
                                }
                            } else {
                                if (!Float.isNaN(eVar.g)) {
                                    childAt.setPivotX(aVar.f.g);
                                }
                                if (!Float.isNaN(aVar.f.h)) {
                                    childAt.setPivotY(aVar.f.h);
                                }
                            }
                            childAt.setTranslationX(aVar.f.j);
                            childAt.setTranslationY(aVar.f.k);
                            childAt.setTranslationZ(aVar.f.l);
                            e eVar2 = aVar.f;
                            if (eVar2.m) {
                                childAt.setElevation(eVar2.n);
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        for (Integer num : hashSet) {
            a aVar2 = (a) this.g.get(num);
            if (aVar2 != null) {
                if (aVar2.e.j0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    C0016b c0016b2 = aVar2.e;
                    int[] iArr2 = c0016b2.k0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = c0016b2.l0;
                        if (str2 != null) {
                            c0016b2.k0 = s(barrier2, str2);
                            barrier2.setReferencedIds(aVar2.e.k0);
                        }
                    }
                    barrier2.setType(aVar2.e.h0);
                    barrier2.setMargin(aVar2.e.i0);
                    ConstraintLayout.b bVarE = constraintLayout.generateDefaultLayoutParams();
                    barrier2.v();
                    aVar2.e(bVarE);
                    constraintLayout.addView(barrier2, bVarE);
                }
                if (aVar2.e.a) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.b bVarE2 = constraintLayout.generateDefaultLayoutParams();
                    aVar2.e(bVarE2);
                    constraintLayout.addView(guideline, bVarE2);
                }
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = constraintLayout.getChildAt(i3);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).i(constraintLayout);
            }
        }
    }

    public void l(int i2, ConstraintLayout.b bVar) {
        a aVar;
        if (!this.g.containsKey(Integer.valueOf(i2)) || (aVar = (a) this.g.get(Integer.valueOf(i2))) == null) {
            return;
        }
        aVar.e(bVar);
    }

    public void n(Context context, int i2) {
        o((ConstraintLayout) LayoutInflater.from(context).inflate(i2, (ViewGroup) null));
    }

    public void o(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.g.clear();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.g.containsKey(Integer.valueOf(id))) {
                this.g.put(Integer.valueOf(id), new a());
            }
            a aVar = (a) this.g.get(Integer.valueOf(id));
            if (aVar != null) {
                aVar.g = ConstraintAttribute.a(this.e, childAt);
                aVar.g(id, bVar);
                aVar.c.b = childAt.getVisibility();
                aVar.c.d = childAt.getAlpha();
                aVar.f.b = childAt.getRotation();
                aVar.f.c = childAt.getRotationX();
                aVar.f.d = childAt.getRotationY();
                aVar.f.e = childAt.getScaleX();
                aVar.f.f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    e eVar = aVar.f;
                    eVar.g = pivotX;
                    eVar.h = pivotY;
                }
                aVar.f.j = childAt.getTranslationX();
                aVar.f.k = childAt.getTranslationY();
                aVar.f.l = childAt.getTranslationZ();
                e eVar2 = aVar.f;
                if (eVar2.m) {
                    eVar2.n = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    aVar.e.p0 = barrier.getAllowsGoneWidget();
                    aVar.e.k0 = barrier.getReferencedIds();
                    aVar.e.h0 = barrier.getType();
                    aVar.e.i0 = barrier.getMargin();
                }
            }
        }
    }

    public void p(b bVar) {
        this.g.clear();
        for (Integer num : bVar.g.keySet()) {
            a aVar = (a) bVar.g.get(num);
            if (aVar != null) {
                this.g.put(num, aVar.clone());
            }
        }
    }

    public void q(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.g.clear();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraints.getChildAt(i2);
            Constraints.a aVar = (Constraints.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.g.containsKey(Integer.valueOf(id))) {
                this.g.put(Integer.valueOf(id), new a());
            }
            a aVar2 = (a) this.g.get(Integer.valueOf(id));
            if (aVar2 != null) {
                if (childAt instanceof ConstraintHelper) {
                    aVar2.i((ConstraintHelper) childAt, id, aVar);
                }
                aVar2.h(id, aVar);
            }
        }
    }

    public void r(int i2, int i3, int i4, float f) {
        C0016b c0016b = u(i2).e;
        c0016b.B = i3;
        c0016b.C = i4;
        c0016b.D = f;
    }

    public a v(int i2) {
        if (this.g.containsKey(Integer.valueOf(i2))) {
            return (a) this.g.get(Integer.valueOf(i2));
        }
        return null;
    }

    public int w(int i2) {
        return u(i2).e.e;
    }

    public int[] x() {
        Integer[] numArr = (Integer[]) this.g.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = numArr[i2].intValue();
        }
        return iArr;
    }

    public a y(int i2) {
        return u(i2);
    }

    public int z(int i2) {
        return u(i2).c.b;
    }
}
