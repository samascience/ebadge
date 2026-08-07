package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import defpackage.b52;
import defpackage.n73;
import defpackage.o43;
import defpackage.po0;
import defpackage.wo0;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class i extends e.c {
    private static final a k = new a();

    public static class a {
        public Typeface a(Context context, wo0.b bVar) {
            return wo0.a(context, null, new wo0.b[]{bVar});
        }

        public wo0.a b(Context context, po0 po0Var) {
            return wo0.b(context, null, po0Var);
        }

        public void c(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b implements e.h {
        private final Context a;
        private final po0 b;
        private final a c;
        private final Object d = new Object();
        private Handler e;
        private Executor f;
        private ThreadPoolExecutor g;
        e.i h;
        private ContentObserver i;
        private Runnable j;

        b(Context context, po0 po0Var, a aVar) {
            b52.h(context, "Context cannot be null");
            b52.h(po0Var, "FontRequest cannot be null");
            this.a = context.getApplicationContext();
            this.b = po0Var;
            this.c = aVar;
        }

        private void b() {
            synchronized (this.d) {
                try {
                    this.h = null;
                    ContentObserver contentObserver = this.i;
                    if (contentObserver != null) {
                        this.c.c(this.a, contentObserver);
                        this.i = null;
                    }
                    Handler handler = this.e;
                    if (handler != null) {
                        handler.removeCallbacks(this.j);
                    }
                    this.e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f = null;
                    this.g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private wo0.b e() {
            try {
                wo0.a aVarB = this.c.b(this.a, this.b);
                if (aVarB.e() == 0) {
                    wo0.b[] bVarArrC = aVarB.c();
                    if (bVarArrC == null || bVarArrC.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return bVarArrC[0];
                }
                throw new RuntimeException("fetchFonts failed (" + aVarB.e() + ")");
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException("provider not found", e);
            }
        }

        @Override // androidx.emoji2.text.e.h
        public void a(e.i iVar) {
            b52.h(iVar, "LoaderCallback cannot be null");
            synchronized (this.d) {
                this.h = iVar;
            }
            d();
        }

        void c() {
            synchronized (this.d) {
                try {
                    if (this.h == null) {
                        return;
                    }
                    try {
                        wo0.b bVarE = e();
                        int iB = bVarE.b();
                        if (iB == 2) {
                            synchronized (this.d) {
                            }
                        }
                        if (iB != 0) {
                            throw new RuntimeException("fetchFonts result is not OK. (" + iB + ")");
                        }
                        try {
                            o43.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            Typeface typefaceA = this.c.a(this.a, bVarE);
                            ByteBuffer byteBufferE = n73.e(this.a, null, bVarE.d());
                            if (byteBufferE == null || typefaceA == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            l lVarB = l.b(typefaceA, byteBufferE);
                            o43.b();
                            synchronized (this.d) {
                                try {
                                    e.i iVar = this.h;
                                    if (iVar != null) {
                                        iVar.b(lVarB);
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            b();
                        } catch (Throwable th2) {
                            o43.b();
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        synchronized (this.d) {
                            try {
                                e.i iVar2 = this.h;
                                if (iVar2 != null) {
                                    iVar2.a(th3);
                                }
                                b();
                            } catch (Throwable th4) {
                                throw th4;
                            }
                        }
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            }
        }

        void d() {
            synchronized (this.d) {
                try {
                    if (this.h == null) {
                        return;
                    }
                    if (this.f == null) {
                        ThreadPoolExecutor threadPoolExecutorB = androidx.emoji2.text.b.b("emojiCompat");
                        this.g = threadPoolExecutorB;
                        this.f = threadPoolExecutorB;
                    }
                    this.f.execute(new Runnable() { // from class: androidx.emoji2.text.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.c();
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void f(Executor executor) {
            synchronized (this.d) {
                this.f = executor;
            }
        }
    }

    public i(Context context, po0 po0Var) {
        super(new b(context, po0Var, k));
    }

    public i c(Executor executor) {
        ((b) a()).f(executor);
        return this;
    }
}
