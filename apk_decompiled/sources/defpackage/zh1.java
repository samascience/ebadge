package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes.dex */
public final class zh1 implements rk1 {
    private final Context a;

    public static final class a implements sk1 {
        private final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return new zh1(this.a);
        }
    }

    private static class b implements y50 {
        private static final String[] c = {"_data"};
        private final Context a;
        private final Uri b;

        b(Context context, Uri uri) {
            this.a = context;
            this.b = uri;
        }

        @Override // defpackage.y50
        public Class a() {
            return File.class;
        }

        @Override // defpackage.y50
        public void b() {
        }

        @Override // defpackage.y50
        public void cancel() {
        }

        @Override // defpackage.y50
        public DataSource d() {
            return DataSource.LOCAL;
        }

        @Override // defpackage.y50
        public void e(Priority priority, y50.a aVar) {
            Cursor cursorQuery = this.a.getContentResolver().query(this.b, c, null, null, null);
            String string = null;
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                    cursorQuery.close();
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
            if (!TextUtils.isEmpty(string)) {
                aVar.f(new File(string));
                return;
            }
            aVar.c(new FileNotFoundException("Failed to find file path for: " + this.b));
        }
    }

    public zh1(Context context) {
        this.a = context;
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public rk1.a b(Uri uri, int i, int i2, rx1 rx1Var) {
        return new rk1.a(new nt1(uri), new b(this.a, uri));
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return ci1.b(uri);
    }
}
