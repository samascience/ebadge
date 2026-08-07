package defpackage;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class rc1 implements y50 {
    private final Uri a;
    private final ContentResolver b;
    private Object c;

    public rc1(ContentResolver contentResolver, Uri uri) {
        this.b = contentResolver;
        this.a = uri;
    }

    @Override // defpackage.y50
    public void b() {
        Object obj = this.c;
        if (obj != null) {
            try {
                c(obj);
            } catch (IOException unused) {
            }
        }
    }

    protected abstract void c(Object obj);

    @Override // defpackage.y50
    public void cancel() {
    }

    @Override // defpackage.y50
    public DataSource d() {
        return DataSource.LOCAL;
    }

    @Override // defpackage.y50
    public final void e(Priority priority, y50.a aVar) {
        try {
            Object objF = f(this.a, this.b);
            this.c = objF;
            aVar.f(objF);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e);
            }
            aVar.c(e);
        }
    }

    protected abstract Object f(Uri uri, ContentResolver contentResolver);
}
