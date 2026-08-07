package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private final AssetManager a;
    private final Executor b;
    private final e.c c;
    private final File e;
    private final String f;
    private final String g;
    private final String h;
    private c[] j;
    private byte[] k;
    private boolean i = false;
    private final byte[] d = d();

    public b(AssetManager assetManager, Executor executor, e.c cVar, String str, String str2, String str3, File file) {
        this.a = assetManager;
        this.b = executor;
        this.c = cVar;
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.e = file;
    }

    private b b(c[] cVarArr, byte[] bArr) {
        try {
            InputStream inputStreamH = h(this.a, this.h);
            if (inputStreamH == null) {
                if (inputStreamH != null) {
                    inputStreamH.close();
                }
                return null;
            }
            try {
                this.j = g.q(inputStreamH, g.o(inputStreamH, g.b), bArr, cVarArr);
                inputStreamH.close();
                return this;
            } catch (Throwable th) {
                try {
                    inputStreamH.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (FileNotFoundException e) {
            this.c.b(9, e);
        } catch (IOException e2) {
            this.c.b(7, e2);
        } catch (IllegalStateException e3) {
            this.j = null;
            this.c.b(8, e3);
        }
    }

    private void c() {
        if (!this.i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    private static byte[] d() {
        int i = Build.VERSION.SDK_INT;
        if (i > 34) {
            return null;
        }
        switch (i) {
            case 26:
                return i.d;
            case 27:
                return i.c;
            case 28:
            case 29:
            case 30:
                return i.b;
            case 31:
            case 32:
            case 33:
            case 34:
                return i.a;
            default:
                return null;
        }
    }

    private InputStream f(AssetManager assetManager) {
        try {
            return h(assetManager, this.g);
        } catch (FileNotFoundException e) {
            this.c.b(6, e);
            return null;
        } catch (IOException e2) {
            this.c.b(7, e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(int i, Object obj) {
        this.c.b(i, obj);
    }

    private InputStream h(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            if (message != null && message.contains("compressed")) {
                this.c.a(5, null);
            }
            return null;
        }
    }

    private c[] j(InputStream inputStream) {
        try {
            try {
                try {
                    try {
                        c[] cVarArrW = g.w(inputStream, g.o(inputStream, g.a), this.f);
                        try {
                            return cVarArrW;
                        } catch (IOException e) {
                            return cVarArrW;
                        }
                    } catch (IOException e2) {
                        this.c.b(7, e2);
                        return null;
                    }
                } catch (IllegalStateException e3) {
                    this.c.b(8, e3);
                    inputStream.close();
                    return null;
                }
            } catch (IOException e4) {
                this.c.b(7, e4);
                inputStream.close();
                return null;
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e5) {
                this.c.b(7, e5);
            }
        }
    }

    private static boolean k() {
        int i = Build.VERSION.SDK_INT;
        if (i > 34) {
            return false;
        }
        switch (i) {
            case 31:
            case 32:
            case 33:
            case 34:
                return true;
            default:
                return false;
        }
    }

    private void l(final int i, final Object obj) {
        this.b.execute(new Runnable() { // from class: sa0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.g(i, obj);
            }
        });
    }

    public boolean e() {
        if (this.d == null) {
            l(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.e.exists()) {
            try {
                this.e.createNewFile();
            } catch (IOException unused) {
                l(4, null);
                return false;
            }
        } else if (!this.e.canWrite()) {
            l(4, null);
            return false;
        }
        this.i = true;
        return true;
    }

    public b i() {
        b bVarB;
        c();
        if (this.d == null) {
            return this;
        }
        InputStream inputStreamF = f(this.a);
        if (inputStreamF != null) {
            this.j = j(inputStreamF);
        }
        c[] cVarArr = this.j;
        return (cVarArr == null || !k() || (bVarB = b(cVarArr, this.d)) == null) ? this : bVarB;
    }

    public b m() {
        c[] cVarArr = this.j;
        byte[] bArr = this.d;
        if (cVarArr != null && bArr != null) {
            c();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    g.E(byteArrayOutputStream, bArr);
                    if (!g.B(byteArrayOutputStream, bArr, cVarArr)) {
                        this.c.b(5, null);
                        this.j = null;
                        byteArrayOutputStream.close();
                        return this;
                    }
                    this.k = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    this.j = null;
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                this.c.b(7, e);
            } catch (IllegalStateException e2) {
                this.c.b(8, e2);
            }
        }
        return this;
    }

    public boolean n() {
        byte[] bArr = this.k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.e);
                    try {
                        d.l(byteArrayInputStream, fileOutputStream);
                        l(1, null);
                        fileOutputStream.close();
                        byteArrayInputStream.close();
                        this.k = null;
                        this.j = null;
                        return true;
                    } catch (Throwable th) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                this.k = null;
                this.j = null;
                throw th5;
            }
        } catch (FileNotFoundException e) {
            l(6, e);
            this.k = null;
            this.j = null;
            return false;
        } catch (IOException e2) {
            l(7, e2);
            this.k = null;
            this.j = null;
            return false;
        }
    }
}
