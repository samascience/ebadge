package defpackage;

import android.content.Context;
import android.util.Log;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class vc2 {
    protected final Set a;
    protected final uc2.b b;
    protected final uc2.a c;
    protected boolean d;
    protected boolean e;

    class a implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        a(Context context, String str, String str2, uc2.c cVar) {
            this.a = context;
            this.b = str;
            this.c = str2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
        
            throw null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() throws java.lang.Throwable {
            /*
                r5 = this;
                r0 = 0
                vc2 r1 = defpackage.vc2.this     // Catch: pl.droidsonroids.relinker.MissingLibraryException -> Ld java.lang.UnsatisfiedLinkError -> Le
                android.content.Context r2 = r5.a     // Catch: pl.droidsonroids.relinker.MissingLibraryException -> Ld java.lang.UnsatisfiedLinkError -> Le
                java.lang.String r3 = r5.b     // Catch: pl.droidsonroids.relinker.MissingLibraryException -> Ld java.lang.UnsatisfiedLinkError -> Le
                java.lang.String r4 = r5.c     // Catch: pl.droidsonroids.relinker.MissingLibraryException -> Ld java.lang.UnsatisfiedLinkError -> Le
                defpackage.vc2.a(r1, r2, r3, r4)     // Catch: pl.droidsonroids.relinker.MissingLibraryException -> Ld java.lang.UnsatisfiedLinkError -> Le
                throw r0
            Ld:
                throw r0
            Le:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: vc2.a.run():void");
        }
    }

    class b implements FilenameFilter {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.a);
        }
    }

    protected vc2() {
        this(new pz2(), new j8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Context context, String str, String str2) throws Throwable {
        if (this.a.contains(str) && !this.d) {
            i("%s already loaded previously!", str);
            return;
        }
        try {
            this.b.loadLibrary(str);
            this.a.add(str);
            i("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e) {
            i("Loading the library normally failed: %s", Log.getStackTraceString(e));
            i("%s (%s) was not loaded normally, re-linking...", str, str2);
            File fileD = d(context, str, str2);
            if (!fileD.exists() || this.d) {
                if (this.d) {
                    i("Forcing a re-link of %s (%s)...", str, str2);
                }
                b(context, str, str2);
                this.c.a(context, this.b.c(), this.b.a(str), fileD, this);
            }
            try {
                if (this.e) {
                    of0 of0Var = null;
                    try {
                        of0 of0Var2 = new of0(fileD);
                        try {
                            List listW = of0Var2.w();
                            of0Var2.close();
                            Iterator it = listW.iterator();
                            while (it.hasNext()) {
                                e(context, this.b.b((String) it.next()));
                            }
                        } catch (Throwable th) {
                            th = th;
                            of0Var = of0Var2;
                            of0Var.close();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (IOException unused) {
            }
            this.b.d(fileD.getAbsolutePath());
            this.a.add(str);
            i("%s (%s) was re-linked!", str, str2);
        }
    }

    protected void b(Context context, String str, String str2) {
        File fileC = c(context);
        File fileD = d(context, str, str2);
        File[] fileArrListFiles = fileC.listFiles(new b(this.b.a(str)));
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (this.d || !file.getAbsolutePath().equals(fileD.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    protected File c(Context context) {
        return context.getDir("lib", 0);
    }

    protected File d(Context context, String str, String str2) {
        String strA = this.b.a(str);
        if (g23.a(str2)) {
            return new File(c(context), strA);
        }
        return new File(c(context), strA + FileUtils.FILE_EXTENSION_SEPARATOR + str2);
    }

    public void e(Context context, String str) {
        f(context, str, null, null);
    }

    public void f(Context context, String str, String str2, uc2.c cVar) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if (g23.a(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        i("Beginning load of %s...", str);
        if (cVar == null) {
            g(context, str, str2);
        } else {
            new Thread(new a(context, str, str2, cVar)).start();
        }
    }

    public void h(String str) {
    }

    public void i(String str, Object... objArr) {
        h(String.format(Locale.US, str, objArr));
    }

    protected vc2(uc2.b bVar, uc2.a aVar) {
        this.a = new HashSet();
        if (bVar == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
        this.b = bVar;
        this.c = aVar;
    }
}
