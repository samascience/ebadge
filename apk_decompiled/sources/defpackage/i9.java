package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class i9 extends j50 {
    private final double[] a;
    a[] b;
    private boolean c = true;

    private static class a {
        private static double[] s = new double[91];
        double[] a;
        double b;
        double c;
        double d;
        double e;
        double f;
        double g;
        double h;
        double i;
        double j;
        double k;
        double l;
        double m;
        double n;
        double o;
        double p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        boolean f347q;
        boolean r;

        a(int i, double d, double d2, double d3, double d4, double d5, double d6) {
            this.r = false;
            this.f347q = i == 1;
            this.c = d;
            this.d = d2;
            this.i = 1.0d / (d2 - d);
            if (3 == i) {
                this.r = true;
            }
            double d7 = d5 - d3;
            double d8 = d6 - d4;
            if (!this.r && Math.abs(d7) >= 0.001d && Math.abs(d8) >= 0.001d) {
                this.a = new double[101];
                boolean z = this.f347q;
                this.j = d7 * ((double) (z ? -1 : 1));
                this.k = d8 * ((double) (z ? 1 : -1));
                this.l = z ? d5 : d3;
                this.m = z ? d4 : d6;
                a(d3, d4, d5, d6);
                this.n = this.b * this.i;
                return;
            }
            this.r = true;
            this.e = d3;
            this.f = d5;
            this.g = d4;
            this.h = d6;
            double dHypot = Math.hypot(d8, d7);
            this.b = dHypot;
            this.n = dHypot * this.i;
            double d9 = this.d;
            double d10 = this.c;
            this.l = d7 / (d9 - d10);
            this.m = d8 / (d9 - d10);
        }

        private void a(double d, double d2, double d3, double d4) {
            double dHypot;
            double d5 = d3 - d;
            double d6 = d2 - d4;
            int i = 0;
            double d7 = 0.0d;
            double d8 = 0.0d;
            double d9 = 0.0d;
            while (true) {
                double[] dArr = s;
                if (i >= dArr.length) {
                    break;
                }
                double d10 = d7;
                double radians = Math.toRadians((((double) i) * 90.0d) / ((double) (dArr.length - 1)));
                double dSin = Math.sin(radians) * d5;
                double dCos = Math.cos(radians) * d6;
                if (i > 0) {
                    dHypot = Math.hypot(dSin - d8, dCos - d9) + d10;
                    s[i] = dHypot;
                } else {
                    dHypot = d10;
                }
                i++;
                d9 = dCos;
                d7 = dHypot;
                d8 = dSin;
            }
            double d11 = d7;
            this.b = d11;
            int i2 = 0;
            while (true) {
                double[] dArr2 = s;
                if (i2 >= dArr2.length) {
                    break;
                }
                dArr2[i2] = dArr2[i2] / d11;
                i2++;
            }
            int i3 = 0;
            while (true) {
                double[] dArr3 = this.a;
                if (i3 >= dArr3.length) {
                    return;
                }
                double length = ((double) i3) / ((double) (dArr3.length - 1));
                int iBinarySearch = Arrays.binarySearch(s, length);
                if (iBinarySearch >= 0) {
                    this.a[i3] = ((double) iBinarySearch) / ((double) (s.length - 1));
                } else if (iBinarySearch == -1) {
                    this.a[i3] = 0.0d;
                } else {
                    int i4 = -iBinarySearch;
                    int i5 = i4 - 2;
                    double[] dArr4 = s;
                    double d12 = dArr4[i5];
                    this.a[i3] = (((double) i5) + ((length - d12) / (dArr4[i4 - 1] - d12))) / ((double) (dArr4.length - 1));
                }
                i3++;
            }
        }

        double b() {
            double d = this.j * this.p;
            double dHypot = this.n / Math.hypot(d, (-this.k) * this.o);
            if (this.f347q) {
                d = -d;
            }
            return d * dHypot;
        }

        double c() {
            double d = this.j * this.p;
            double d2 = (-this.k) * this.o;
            double dHypot = this.n / Math.hypot(d, d2);
            return this.f347q ? (-d2) * dHypot : d2 * dHypot;
        }

        public double d(double d) {
            return this.l;
        }

        public double e(double d) {
            return this.m;
        }

        public double f(double d) {
            double d2 = (d - this.c) * this.i;
            double d3 = this.e;
            return d3 + (d2 * (this.f - d3));
        }

        public double g(double d) {
            double d2 = (d - this.c) * this.i;
            double d3 = this.g;
            return d3 + (d2 * (this.h - d3));
        }

        double h() {
            return this.l + (this.j * this.o);
        }

        double i() {
            return this.m + (this.k * this.p);
        }

        double j(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.a;
            double length = d * ((double) (dArr.length - 1));
            int i = (int) length;
            double d2 = length - ((double) i);
            double d3 = dArr[i];
            return d3 + (d2 * (dArr[i + 1] - d3));
        }

        void k(double d) {
            double dJ = j((this.f347q ? this.d - d : d - this.c) * this.i) * 1.5707963267948966d;
            this.o = Math.sin(dJ);
            this.p = Math.cos(dJ);
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x002f  */
    public i9(int[] iArr, double[] dArr, double[][] dArr2) {
        this.a = dArr;
        this.b = new a[dArr.length - 1];
        int i = 1;
        int i2 = 1;
        int i3 = 0;
        while (true) {
            a[] aVarArr = this.b;
            if (i3 >= aVarArr.length) {
                return;
            }
            int i4 = iArr[i3];
            if (i4 == 0) {
                i2 = 3;
            } else if (i4 == 1) {
                i = 1;
                i2 = i;
            } else {
                if (i4 != 2) {
                    if (i4 == 3) {
                        if (i != 1) {
                            i = 1;
                        }
                        i2 = i;
                    }
                }
                i = 2;
                i2 = i;
            }
            double d = dArr[i3];
            int i5 = i3 + 1;
            double d2 = dArr[i5];
            double[] dArr3 = dArr2[i3];
            double d3 = dArr3[0];
            double d4 = dArr3[1];
            double[] dArr4 = dArr2[i5];
            aVarArr[i3] = new a(i2, d, d2, d3, d4, dArr4[0], dArr4[1]);
            i3 = i5;
        }
    }

    @Override // defpackage.j50
    public double c(double d, int i) {
        double dG;
        double dE;
        double dI;
        double dC;
        double dG2;
        double dE2;
        int i2 = 0;
        if (this.c) {
            a[] aVarArr = this.b;
            a aVar = aVarArr[0];
            double d2 = aVar.c;
            if (d < d2) {
                double d3 = d - d2;
                if (aVar.r) {
                    if (i == 0) {
                        dG2 = aVar.f(d2);
                        dE2 = this.b[0].d(d2);
                    } else {
                        dG2 = aVar.g(d2);
                        dE2 = this.b[0].e(d2);
                    }
                    return dG2 + (d3 * dE2);
                }
                aVar.k(d2);
                if (i == 0) {
                    dI = this.b[0].h();
                    dC = this.b[0].b();
                } else {
                    dI = this.b[0].i();
                    dC = this.b[0].c();
                }
                return dI + (d3 * dC);
            }
            if (d > aVarArr[aVarArr.length - 1].d) {
                double d4 = aVarArr[aVarArr.length - 1].d;
                double d5 = d - d4;
                int length = aVarArr.length - 1;
                if (i == 0) {
                    dG = aVarArr[length].f(d4);
                    dE = this.b[length].d(d4);
                } else {
                    dG = aVarArr[length].g(d4);
                    dE = this.b[length].e(d4);
                }
                return dG + (d5 * dE);
            }
        } else {
            a[] aVarArr2 = this.b;
            double d6 = aVarArr2[0].c;
            if (d < d6) {
                d = d6;
            } else if (d > aVarArr2[aVarArr2.length - 1].d) {
                d = aVarArr2[aVarArr2.length - 1].d;
            }
        }
        while (true) {
            a[] aVarArr3 = this.b;
            if (i2 >= aVarArr3.length) {
                return Double.NaN;
            }
            a aVar2 = aVarArr3[i2];
            if (d <= aVar2.d) {
                if (aVar2.r) {
                    return i == 0 ? aVar2.f(d) : aVar2.g(d);
                }
                aVar2.k(d);
                return i == 0 ? this.b[i2].h() : this.b[i2].i();
            }
            i2++;
        }
    }

    @Override // defpackage.j50
    public void d(double d, double[] dArr) {
        if (this.c) {
            a[] aVarArr = this.b;
            a aVar = aVarArr[0];
            double d2 = aVar.c;
            if (d < d2) {
                double d3 = d - d2;
                if (aVar.r) {
                    dArr[0] = aVar.f(d2) + (this.b[0].d(d2) * d3);
                    dArr[1] = this.b[0].g(d2) + (d3 * this.b[0].e(d2));
                    return;
                } else {
                    aVar.k(d2);
                    dArr[0] = this.b[0].h() + (this.b[0].b() * d3);
                    dArr[1] = this.b[0].i() + (d3 * this.b[0].c());
                    return;
                }
            }
            if (d > aVarArr[aVarArr.length - 1].d) {
                double d4 = aVarArr[aVarArr.length - 1].d;
                double d5 = d - d4;
                int length = aVarArr.length - 1;
                a aVar2 = aVarArr[length];
                if (aVar2.r) {
                    dArr[0] = aVar2.f(d4) + (this.b[length].d(d4) * d5);
                    dArr[1] = this.b[length].g(d4) + (d5 * this.b[length].e(d4));
                    return;
                } else {
                    aVar2.k(d);
                    dArr[0] = this.b[length].h() + (this.b[length].b() * d5);
                    dArr[1] = this.b[length].i() + (d5 * this.b[length].c());
                    return;
                }
            }
        } else {
            a[] aVarArr2 = this.b;
            double d6 = aVarArr2[0].c;
            if (d < d6) {
                d = d6;
            }
            if (d > aVarArr2[aVarArr2.length - 1].d) {
                d = aVarArr2[aVarArr2.length - 1].d;
            }
        }
        int i = 0;
        while (true) {
            a[] aVarArr3 = this.b;
            if (i >= aVarArr3.length) {
                return;
            }
            a aVar3 = aVarArr3[i];
            if (d <= aVar3.d) {
                if (aVar3.r) {
                    dArr[0] = aVar3.f(d);
                    dArr[1] = this.b[i].g(d);
                    return;
                } else {
                    aVar3.k(d);
                    dArr[0] = this.b[i].h();
                    dArr[1] = this.b[i].i();
                    return;
                }
            }
            i++;
        }
    }

    @Override // defpackage.j50
    public void e(double d, float[] fArr) {
        if (this.c) {
            a[] aVarArr = this.b;
            a aVar = aVarArr[0];
            double d2 = aVar.c;
            if (d < d2) {
                double d3 = d - d2;
                if (aVar.r) {
                    fArr[0] = (float) (aVar.f(d2) + (this.b[0].d(d2) * d3));
                    fArr[1] = (float) (this.b[0].g(d2) + (d3 * this.b[0].e(d2)));
                    return;
                } else {
                    aVar.k(d2);
                    fArr[0] = (float) (this.b[0].h() + (this.b[0].b() * d3));
                    fArr[1] = (float) (this.b[0].i() + (d3 * this.b[0].c()));
                    return;
                }
            }
            if (d > aVarArr[aVarArr.length - 1].d) {
                double d4 = aVarArr[aVarArr.length - 1].d;
                double d5 = d - d4;
                int length = aVarArr.length - 1;
                a aVar2 = aVarArr[length];
                if (aVar2.r) {
                    fArr[0] = (float) (aVar2.f(d4) + (this.b[length].d(d4) * d5));
                    fArr[1] = (float) (this.b[length].g(d4) + (d5 * this.b[length].e(d4)));
                    return;
                } else {
                    aVar2.k(d);
                    fArr[0] = (float) this.b[length].h();
                    fArr[1] = (float) this.b[length].i();
                    return;
                }
            }
        } else {
            a[] aVarArr2 = this.b;
            double d6 = aVarArr2[0].c;
            if (d < d6) {
                d = d6;
            } else if (d > aVarArr2[aVarArr2.length - 1].d) {
                d = aVarArr2[aVarArr2.length - 1].d;
            }
        }
        int i = 0;
        while (true) {
            a[] aVarArr3 = this.b;
            if (i >= aVarArr3.length) {
                return;
            }
            a aVar3 = aVarArr3[i];
            if (d <= aVar3.d) {
                if (aVar3.r) {
                    fArr[0] = (float) aVar3.f(d);
                    fArr[1] = (float) this.b[i].g(d);
                    return;
                } else {
                    aVar3.k(d);
                    fArr[0] = (float) this.b[i].h();
                    fArr[1] = (float) this.b[i].i();
                    return;
                }
            }
            i++;
        }
    }

    @Override // defpackage.j50
    public double f(double d, int i) {
        a[] aVarArr = this.b;
        int i2 = 0;
        double d2 = aVarArr[0].c;
        if (d < d2) {
            d = d2;
        }
        if (d > aVarArr[aVarArr.length - 1].d) {
            d = aVarArr[aVarArr.length - 1].d;
        }
        while (true) {
            a[] aVarArr2 = this.b;
            if (i2 >= aVarArr2.length) {
                return Double.NaN;
            }
            a aVar = aVarArr2[i2];
            if (d <= aVar.d) {
                if (aVar.r) {
                    return i == 0 ? aVar.d(d) : aVar.e(d);
                }
                aVar.k(d);
                return i == 0 ? this.b[i2].b() : this.b[i2].c();
            }
            i2++;
        }
    }

    @Override // defpackage.j50
    public void g(double d, double[] dArr) {
        a[] aVarArr = this.b;
        double d2 = aVarArr[0].c;
        if (d < d2) {
            d = d2;
        } else if (d > aVarArr[aVarArr.length - 1].d) {
            d = aVarArr[aVarArr.length - 1].d;
        }
        int i = 0;
        while (true) {
            a[] aVarArr2 = this.b;
            if (i >= aVarArr2.length) {
                return;
            }
            a aVar = aVarArr2[i];
            if (d <= aVar.d) {
                if (aVar.r) {
                    dArr[0] = aVar.d(d);
                    dArr[1] = this.b[i].e(d);
                    return;
                } else {
                    aVar.k(d);
                    dArr[0] = this.b[i].b();
                    dArr[1] = this.b[i].c();
                    return;
                }
            }
            i++;
        }
    }

    @Override // defpackage.j50
    public double[] h() {
        return this.a;
    }
}
