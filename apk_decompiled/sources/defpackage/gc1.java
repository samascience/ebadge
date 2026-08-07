package defpackage;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
class gc1 extends fc1 {
    static boolean c = false;
    private final db1 a;
    private final c b;

    public static class a extends im1 implements androidx.loader.content.b.a {
        private final int l;
        private final Bundle m;
        private final androidx.loader.content.b n;
        private db1 o;
        private b p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private androidx.loader.content.b f336q;

        a(int i, Bundle bundle, androidx.loader.content.b bVar, androidx.loader.content.b bVar2) {
            this.l = i;
            this.m = bundle;
            this.n = bVar;
            this.f336q = bVar2;
            bVar.q(i, this);
        }

        @Override // androidx.loader.content.b.a
        public void a(androidx.loader.content.b bVar, Object obj) {
            if (gc1.c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                o(obj);
                return;
            }
            if (gc1.c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            m(obj);
        }

        @Override // androidx.lifecycle.LiveData
        protected void k() {
            if (gc1.c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.n.t();
        }

        @Override // androidx.lifecycle.LiveData
        protected void l() {
            if (gc1.c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.n.u();
        }

        @Override // androidx.lifecycle.LiveData
        public void n(vt1 vt1Var) {
            super.n(vt1Var);
            this.o = null;
            this.p = null;
        }

        @Override // defpackage.im1, androidx.lifecycle.LiveData
        public void o(Object obj) {
            super.o(obj);
            androidx.loader.content.b bVar = this.f336q;
            if (bVar != null) {
                bVar.r();
                this.f336q = null;
            }
        }

        androidx.loader.content.b p(boolean z) {
            if (gc1.c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.n.b();
            this.n.a();
            b bVar = this.p;
            if (bVar != null) {
                n(bVar);
                if (z) {
                    bVar.d();
                }
            }
            this.n.v(this);
            if ((bVar == null || bVar.c()) && !z) {
                return this.n;
            }
            this.n.r();
            return this.f336q;
        }

        public void q(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.l);
            printWriter.print(" mArgs=");
            printWriter.println(this.m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.n);
            this.n.g(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.p != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.p);
                this.p.a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(r().d(f()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(h());
        }

        androidx.loader.content.b r() {
            return this.n;
        }

        void s() {
            db1 db1Var = this.o;
            b bVar = this.p;
            if (db1Var == null || bVar == null) {
                return;
            }
            super.n(bVar);
            i(db1Var, bVar);
        }

        androidx.loader.content.b t(db1 db1Var, fc1.a aVar) {
            b bVar = new b(this.n, aVar);
            i(db1Var, bVar);
            vt1 vt1Var = this.p;
            if (vt1Var != null) {
                n(vt1Var);
            }
            this.o = db1Var;
            this.p = bVar;
            return this.n;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.l);
            sb.append(" : ");
            k70.a(this.n, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    static class b implements vt1 {
        private final androidx.loader.content.b a;
        private final fc1.a b;
        private boolean c = false;

        b(androidx.loader.content.b bVar, fc1.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.c);
        }

        @Override // defpackage.vt1
        public void b(Object obj) {
            if (gc1.c) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.a + ": " + this.a.d(obj));
            }
            this.b.a(this.a, obj);
            this.c = true;
        }

        boolean c() {
            return this.c;
        }

        void d() {
            if (this.c) {
                if (gc1.c) {
                    Log.v("LoaderManager", "  Resetting: " + this.a);
                }
                this.b.b(this.a);
            }
        }

        public String toString() {
            return this.b.toString();
        }
    }

    static class c extends o {
        private static final q.b f = new a();
        private ns2 d = new ns2();
        private boolean e = false;

        static class a implements q.b {
            a() {
            }

            @Override // androidx.lifecycle.q.b
            public o a(Class cls) {
                return new c();
            }
        }

        c() {
        }

        static c i(r rVar) {
            return (c) new q(rVar, f).a(c.class);
        }

        @Override // androidx.lifecycle.o
        protected void d() {
            super.d();
            int iH = this.d.h();
            for (int i = 0; i < iH; i++) {
                ((a) this.d.i(i)).p(true);
            }
            this.d.b();
        }

        public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.d.h() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.d.h(); i++) {
                    a aVar = (a) this.d.i(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.d.f(i));
                    printWriter.print(": ");
                    printWriter.println(aVar.toString());
                    aVar.q(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void h() {
            this.e = false;
        }

        a j(int i) {
            return (a) this.d.d(i);
        }

        boolean k() {
            return this.e;
        }

        void l() {
            int iH = this.d.h();
            for (int i = 0; i < iH; i++) {
                ((a) this.d.i(i)).s();
            }
        }

        void m(int i, a aVar) {
            this.d.g(i, aVar);
        }

        void n() {
            this.e = true;
        }
    }

    gc1(db1 db1Var, r rVar) {
        this.a = db1Var;
        this.b = c.i(rVar);
    }

    private androidx.loader.content.b e(int i, Bundle bundle, fc1.a aVar, androidx.loader.content.b bVar) {
        try {
            this.b.n();
            androidx.loader.content.b bVarOnCreateLoader = aVar.onCreateLoader(i, bundle);
            if (bVarOnCreateLoader == null) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            }
            if (bVarOnCreateLoader.getClass().isMemberClass() && !Modifier.isStatic(bVarOnCreateLoader.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + bVarOnCreateLoader);
            }
            a aVar2 = new a(i, bundle, bVarOnCreateLoader, bVar);
            if (c) {
                Log.v("LoaderManager", "  Created new loader " + aVar2);
            }
            this.b.m(i, aVar2);
            this.b.h();
            return aVar2.t(this.a, aVar);
        } catch (Throwable th) {
            this.b.h();
            throw th;
        }
    }

    @Override // defpackage.fc1
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.b.f(str, fileDescriptor, printWriter, strArr);
    }

    @Override // defpackage.fc1
    public androidx.loader.content.b c(int i, Bundle bundle, fc1.a aVar) {
        if (this.b.k()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        a aVarJ = this.b.j(i);
        if (c) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (aVarJ == null) {
            return e(i, bundle, aVar, null);
        }
        if (c) {
            Log.v("LoaderManager", "  Re-using existing loader " + aVarJ);
        }
        return aVarJ.t(this.a, aVar);
    }

    @Override // defpackage.fc1
    public void d() {
        this.b.l();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        k70.a(this.a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
