package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class y23 implements y50 {
    private final Uri a;
    private final a33 b;
    private InputStream c;

    static class a implements z23 {
        private static final String[] b = {"_data"};
        private final ContentResolver a;

        a(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // defpackage.z23
        public Cursor a(Uri uri) {
            return this.a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    static class b implements z23 {
        private static final String[] b = {"_data"};
        private final ContentResolver a;

        b(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // defpackage.z23
        public Cursor a(Uri uri) {
            return this.a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    y23(Uri uri, a33 a33Var) {
        this.a = uri;
        this.b = a33Var;
    }

    private static y23 c(Context context, Uri uri, z23 z23Var) {
        return new y23(uri, new a33(com.bumptech.glide.a.c(context).j().g(), z23Var, com.bumptech.glide.a.c(context).e(), context.getContentResolver()));
    }

    public static y23 f(Context context, Uri uri) {
        return c(context, uri, new a(context.getContentResolver()));
    }

    public static y23 g(Context context, Uri uri) {
        return c(context, uri, new b(context.getContentResolver()));
    }

    private InputStream h() throws Throwable {
        InputStream inputStreamD = this.b.d(this.a);
        int iA = inputStreamD != null ? this.b.a(this.a) : -1;
        return iA != -1 ? new fj0(inputStreamD, iA) : inputStreamD;
    }

    @Override // defpackage.y50
    public Class a() {
        return InputStream.class;
    }

    @Override // defpackage.y50
    public void b() {
        InputStream inputStream = this.c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // defpackage.y50
    public void cancel() {
    }

    @Override // defpackage.y50
    public DataSource d() {
        return DataSource.LOCAL;
    }

    @Override // defpackage.y50
    public void e(Priority priority, y50.a aVar) throws Throwable {
        try {
            InputStream inputStreamH = h();
            this.c = inputStreamH;
            aVar.f(inputStreamH);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e);
            }
            aVar.c(e);
        }
    }
}
