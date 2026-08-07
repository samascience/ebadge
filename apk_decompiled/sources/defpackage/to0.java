package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
abstract class to0 {
    static final af1 a = new af1(16);
    private static final ExecutorService b = gf2.a("fonts-androidx", 10, 10000);
    static final Object c = new Object();
    static final ap2 d = new ap2();

    class a implements Callable {
        final /* synthetic */ String a;
        final /* synthetic */ Context b;
        final /* synthetic */ po0 c;
        final /* synthetic */ int d;

        a(String str, Context context, po0 po0Var, int i) {
            this.a = str;
            this.b = context;
            this.c = po0Var;
            this.d = i;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            return to0.c(this.a, this.b, g73.a(new Object[]{this.c}), this.d);
        }
    }

    class b implements q20 {
        final /* synthetic */ hq a;

        b(hq hqVar) {
            this.a = hqVar;
        }

        @Override // defpackage.q20
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.a.b(eVar);
        }
    }

    class c implements Callable {
        final /* synthetic */ String a;
        final /* synthetic */ Context b;
        final /* synthetic */ List c;
        final /* synthetic */ int d;

        c(String str, Context context, List list, int i) {
            this.a = str;
            this.b = context;
            this.c = list;
            this.d = i;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return to0.c(this.a, this.b, this.c, this.d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    class d implements q20 {
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        @Override // defpackage.q20
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            synchronized (to0.c) {
                try {
                    ap2 ap2Var = to0.d;
                    ArrayList arrayList = (ArrayList) ap2Var.get(this.a);
                    if (arrayList == null) {
                        return;
                    }
                    ap2Var.remove(this.a);
                    for (int i = 0; i < arrayList.size(); i++) {
                        ((q20) arrayList.get(i)).accept(eVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static String a(List list, int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(((po0) list.get(i2)).d());
            sb.append("-");
            sb.append(i);
            if (i2 < list.size() - 1) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    private static int b(wo0.a aVar) {
        int i = 1;
        if (aVar.e() != 0) {
            return aVar.e() != 1 ? -3 : -2;
        }
        wo0.b[] bVarArrC = aVar.c();
        if (bVarArrC != null && bVarArrC.length != 0) {
            i = 0;
            for (wo0.b bVar : bVarArrC) {
                int iB = bVar.b();
                if (iB != 0) {
                    if (iB < 0) {
                        return -3;
                    }
                    return iB;
                }
            }
        }
        return i;
    }

    static e c(String str, Context context, List list, int i) {
        l43.a("getFontSync");
        try {
            af1 af1Var = a;
            Typeface typeface = (Typeface) af1Var.c(str);
            if (typeface != null) {
                e eVar = new e(typeface);
                l43.b();
                return eVar;
            }
            try {
                wo0.a aVarE = oo0.e(context, list, null);
                int iB = b(aVarE);
                if (iB != 0) {
                    e eVar2 = new e(iB);
                    l43.b();
                    return eVar2;
                }
                Typeface typefaceB = (!aVarE.f() || Build.VERSION.SDK_INT < 29) ? h73.b(context, null, aVarE.c(), i) : h73.c(context, null, aVarE.d(), i);
                if (typefaceB == null) {
                    e eVar3 = new e(-3);
                    l43.b();
                    return eVar3;
                }
                af1Var.d(str, typefaceB);
                e eVar4 = new e(typefaceB);
                l43.b();
                return eVar4;
            } catch (PackageManager.NameNotFoundException unused) {
                e eVar5 = new e(-1);
                l43.b();
                return eVar5;
            }
        } catch (Throwable th) {
            l43.b();
            throw th;
        }
    }

    static Typeface d(Context context, List list, int i, Executor executor, hq hqVar) {
        String strA = a(list, i);
        Typeface typeface = (Typeface) a.c(strA);
        if (typeface != null) {
            hqVar.b(new e(typeface));
            return typeface;
        }
        b bVar = new b(hqVar);
        synchronized (c) {
            try {
                ap2 ap2Var = d;
                ArrayList arrayList = (ArrayList) ap2Var.get(strA);
                if (arrayList != null) {
                    arrayList.add(bVar);
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(bVar);
                ap2Var.put(strA, arrayList2);
                c cVar = new c(strA, context, list, i);
                if (executor == null) {
                    executor = b;
                }
                gf2.c(executor, cVar, new d(strA));
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static Typeface e(Context context, po0 po0Var, hq hqVar, int i, int i2) {
        String strA = a(g73.a(new Object[]{po0Var}), i);
        Typeface typeface = (Typeface) a.c(strA);
        if (typeface != null) {
            hqVar.b(new e(typeface));
            return typeface;
        }
        if (i2 == -1) {
            e eVarC = c(strA, context, g73.a(new Object[]{po0Var}), i);
            hqVar.b(eVarC);
            return eVarC.a;
        }
        try {
            e eVar = (e) gf2.d(b, new a(strA, context, po0Var, i), i2);
            hqVar.b(eVar);
            return eVar.a;
        } catch (InterruptedException unused) {
            hqVar.b(new e(-3));
            return null;
        }
    }

    static final class e {
        final Typeface a;
        final int b;

        e(int i) {
            this.a = null;
            this.b = i;
        }

        boolean a() {
            return this.b == 0;
        }

        e(Typeface typeface) {
            this.a = typeface;
            this.b = 0;
        }
    }
}
