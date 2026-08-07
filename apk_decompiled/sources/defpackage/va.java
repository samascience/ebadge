package defpackage;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class va implements y50 {
    private final String a;
    private final AssetManager b;
    private Object c;

    public va(AssetManager assetManager, String str) {
        this.b = assetManager;
        this.a = str;
    }

    @Override // defpackage.y50
    public void b() {
        Object obj = this.c;
        if (obj == null) {
            return;
        }
        try {
            c(obj);
        } catch (IOException unused) {
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
    public void e(Priority priority, y50.a aVar) {
        try {
            Object objF = f(this.b, this.a);
            this.c = objF;
            aVar.f(objF);
        } catch (IOException e) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e);
            }
            aVar.c(e);
        }
    }

    protected abstract Object f(AssetManager assetManager, String str);
}
