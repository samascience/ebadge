package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class k92 implements rk1 {
    private final Context a;
    private final rk1 b;
    private final rk1 c;
    private final Class d;

    private static abstract class a implements sk1 {
        private final Context a;
        private final Class b;

        a(Context context, Class cls) {
            this.a = context;
            this.b = cls;
        }

        @Override // defpackage.sk1
        public final rk1 b(zl1 zl1Var) {
            return new k92(this.a, zl1Var.d(File.class, this.b), zl1Var.d(Uri.class, this.b), this.b);
        }
    }

    public static final class b extends a {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    public static final class c extends a {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    private static final class d implements y50 {
        private static final String[] k = {"_data"};
        private final Context a;
        private final rk1 b;
        private final rk1 c;
        private final Uri d;
        private final int e;
        private final int f;
        private final rx1 g;
        private final Class h;
        private volatile boolean i;
        private volatile y50 j;

        d(Context context, rk1 rk1Var, rk1 rk1Var2, Uri uri, int i, int i2, rx1 rx1Var, Class cls) {
            this.a = context.getApplicationContext();
            this.b = rk1Var;
            this.c = rk1Var2;
            this.d = uri;
            this.e = i;
            this.f = i2;
            this.g = rx1Var;
            this.h = cls;
        }

        private rk1.a c() {
            if (Environment.isExternalStorageLegacy()) {
                return this.b.b(h(this.d), this.e, this.f, this.g);
            }
            return this.c.b(g() ? MediaStore.setRequireOriginal(this.d) : this.d, this.e, this.f, this.g);
        }

        private y50 f() {
            rk1.a aVarC = c();
            if (aVarC != null) {
                return aVarC.c;
            }
            return null;
        }

        private boolean g() {
            return this.a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        private File h(Uri uri) {
            Cursor cursor = null;
            try {
                Cursor cursorQuery = this.a.getContentResolver().query(uri, k, null, null, null);
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                if (!TextUtils.isEmpty(string)) {
                    File file = new File(string);
                    cursorQuery.close();
                    return file;
                }
                throw new FileNotFoundException("File path was empty in media store for: " + uri);
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }

        @Override // defpackage.y50
        public Class a() {
            return this.h;
        }

        @Override // defpackage.y50
        public void b() {
            y50 y50Var = this.j;
            if (y50Var != null) {
                y50Var.b();
            }
        }

        @Override // defpackage.y50
        public void cancel() {
            this.i = true;
            y50 y50Var = this.j;
            if (y50Var != null) {
                y50Var.cancel();
            }
        }

        @Override // defpackage.y50
        public DataSource d() {
            return DataSource.LOCAL;
        }

        @Override // defpackage.y50
        public void e(Priority priority, y50.a aVar) {
            try {
                y50 y50VarF = f();
                if (y50VarF == null) {
                    aVar.c(new IllegalArgumentException("Failed to build fetcher for: " + this.d));
                    return;
                }
                this.j = y50VarF;
                if (this.i) {
                    cancel();
                } else {
                    y50VarF.e(priority, aVar);
                }
            } catch (FileNotFoundException e) {
                aVar.c(e);
            }
        }
    }

    k92(Context context, rk1 rk1Var, rk1 rk1Var2, Class cls) {
        this.a = context.getApplicationContext();
        this.b = rk1Var;
        this.c = rk1Var2;
        this.d = cls;
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public rk1.a b(Uri uri, int i, int i2, rx1 rx1Var) {
        return new rk1.a(new nt1(uri), new d(this.a, this.b, this.c, uri, i, i2, rx1Var, this.d));
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && ci1.b(uri);
    }
}
