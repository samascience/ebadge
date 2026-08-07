package defpackage;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* JADX INFO: loaded from: classes.dex */
public final class yj3 {
    private final g a;

    private static class a extends g {
        protected final Window a;
        private final zr2 b;

        a(Window window, zr2 zr2Var) {
            this.a = window;
            this.b = zr2Var;
        }

        private void f(int i) {
            if (i == 1) {
                g(4);
            } else if (i == 2) {
                g(2);
            } else {
                if (i != 8) {
                    return;
                }
                this.b.a();
            }
        }

        private void i(int i) {
            if (i == 1) {
                j(4);
                k(1024);
            } else if (i == 2) {
                j(2);
            } else {
                if (i != 8) {
                    return;
                }
                this.b.b();
            }
        }

        @Override // yj3.g
        void a(int i) {
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    f(i2);
                }
            }
        }

        @Override // yj3.g
        void e(int i) {
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    i(i2);
                }
            }
        }

        protected void g(int i) {
            View decorView = this.a.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }

        protected void h(int i) {
            this.a.addFlags(i);
        }

        protected void j(int i) {
            View decorView = this.a.getDecorView();
            decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
        }

        protected void k(int i) {
            this.a.clearFlags(i);
        }
    }

    private static class b extends a {
        b(Window window, zr2 zr2Var) {
            super(window, zr2Var);
        }

        @Override // yj3.g
        public boolean b() {
            return (this.a.getDecorView().getSystemUiVisibility() & 8192) != 0;
        }

        @Override // yj3.g
        public void d(boolean z) {
            if (!z) {
                j(8192);
                return;
            }
            k(67108864);
            h(Integer.MIN_VALUE);
            g(8192);
        }
    }

    private static class c extends b {
        c(Window window, zr2 zr2Var) {
            super(window, zr2Var);
        }

        @Override // yj3.g
        public void c(boolean z) {
            if (!z) {
                j(16);
                return;
            }
            k(134217728);
            h(Integer.MIN_VALUE);
            g(16);
        }
    }

    private static class e extends d {
        e(Window window, yj3 yj3Var, zr2 zr2Var) {
            super(window, yj3Var, zr2Var);
        }

        e(WindowInsetsController windowInsetsController, yj3 yj3Var, zr2 zr2Var) {
            super(windowInsetsController, yj3Var, zr2Var);
        }
    }

    private static class f extends e {
        f(Window window, yj3 yj3Var, zr2 zr2Var) {
            super(window, yj3Var, zr2Var);
        }

        @Override // yj3.d, yj3.g
        public boolean b() {
            return (this.b.getSystemBarsAppearance() & 8) != 0;
        }

        f(WindowInsetsController windowInsetsController, yj3 yj3Var, zr2 zr2Var) {
            super(windowInsetsController, yj3Var, zr2Var);
        }
    }

    private static class g {
        g() {
        }

        abstract void a(int i);

        public abstract boolean b();

        public abstract void c(boolean z);

        public abstract void d(boolean z);

        abstract void e(int i);
    }

    private yj3(WindowInsetsController windowInsetsController) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.a = new f(windowInsetsController, this, new zr2(windowInsetsController));
        } else {
            this.a = new d(windowInsetsController, this, new zr2(windowInsetsController));
        }
    }

    public static yj3 f(WindowInsetsController windowInsetsController) {
        return new yj3(windowInsetsController);
    }

    public void a(int i) {
        this.a.a(i);
    }

    public boolean b() {
        return this.a.b();
    }

    public void c(boolean z) {
        this.a.c(z);
    }

    public void d(boolean z) {
        this.a.d(z);
    }

    public void e(int i) {
        this.a.e(i);
    }

    private static class d extends g {
        final yj3 a;
        final WindowInsetsController b;
        final zr2 c;
        private final ap2 d;
        protected Window e;

        d(Window window, yj3 yj3Var, zr2 zr2Var) {
            this(window.getInsetsController(), yj3Var, zr2Var);
            this.e = window;
        }

        @Override // yj3.g
        void a(int i) {
            if ((i & 8) != 0) {
                this.c.a();
            }
            this.b.hide(i & (-9));
        }

        @Override // yj3.g
        public boolean b() {
            this.b.setSystemBarsAppearance(0, 0);
            return (this.b.getSystemBarsAppearance() & 8) != 0;
        }

        @Override // yj3.g
        public void c(boolean z) {
            if (z) {
                if (this.e != null) {
                    f(16);
                }
                this.b.setSystemBarsAppearance(16, 16);
            } else {
                if (this.e != null) {
                    g(16);
                }
                this.b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // yj3.g
        public void d(boolean z) {
            if (z) {
                if (this.e != null) {
                    f(8192);
                }
                this.b.setSystemBarsAppearance(8, 8);
            } else {
                if (this.e != null) {
                    g(8192);
                }
                this.b.setSystemBarsAppearance(0, 8);
            }
        }

        @Override // yj3.g
        void e(int i) {
            if ((i & 8) != 0) {
                this.c.b();
            }
            this.b.show(i & (-9));
        }

        protected void f(int i) {
            View decorView = this.e.getDecorView();
            decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
        }

        protected void g(int i) {
            View decorView = this.e.getDecorView();
            decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
        }

        d(WindowInsetsController windowInsetsController, yj3 yj3Var, zr2 zr2Var) {
            this.d = new ap2();
            this.b = windowInsetsController;
            this.a = yj3Var;
            this.c = zr2Var;
        }
    }

    public yj3(Window window, View view) {
        zr2 zr2Var = new zr2(view);
        int i = Build.VERSION.SDK_INT;
        if (i >= 35) {
            this.a = new f(window, this, zr2Var);
        } else if (i >= 30) {
            this.a = new d(window, this, zr2Var);
        } else {
            this.a = new c(window, zr2Var);
        }
    }
}
