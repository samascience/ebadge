package defpackage;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import androidx.camera.core.x;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class jy1 {
    public static boolean a(File file) {
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return false;
        }
        return parentFile.exists() ? parentFile.isDirectory() : parentFile.mkdirs();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x004d  */
    public static String b(ContentResolver contentResolver, Uri uri, String str) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        try {
            cursorQuery = contentResolver.query(uri, new String[]{str}, null, null, null);
            if (cursorQuery == null) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            }
            try {
                try {
                    int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow(str);
                    cursorQuery.moveToFirst();
                    String string = cursorQuery.getString(columnIndexOrThrow);
                    cursorQuery.close();
                    return string;
                } catch (RuntimeException e) {
                    e = e;
                    x.c("OutputUtil", String.format("Failed in getting absolute path for Uri %s with Exception %s", uri.toString(), e.toString()));
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (RuntimeException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
