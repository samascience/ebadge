package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.luck.picture.lib.entity.LocalMedia;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class gi1 {
    public static Bundle a(String str, String[] strArr, int i, int i2) {
        Bundle bundle = new Bundle();
        int i3 = Build.VERSION.SDK_INT;
        bundle.putString("android:query-arg-sql-selection", str);
        bundle.putStringArray("android:query-arg-sql-selection-args", strArr);
        bundle.putString("android:query-arg-sql-sort-order", "_id DESC");
        if (i3 >= 30) {
            bundle.putString("android:query-arg-sql-limit", i + " offset " + i2);
        }
        return bundle;
    }

    public static void b(Context context, String str) {
        try {
            if (a22.h(str)) {
                context.getContentResolver().delete(Uri.parse(str), null, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void c(Context context, Uri uri) {
        if (uri != null) {
            try {
                context.getContentResolver().delete(uri, null, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static qh1 d(Context context, String str) {
        qh1 qh1Var = new qh1();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                if (a22.h(str)) {
                    mediaMetadataRetriever.setDataSource(context, Uri.parse(str));
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                qh1Var.d(db3.c(mediaMetadataRetriever.extractMetadata(9)));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return qh1Var;
        } finally {
            try {
                mediaMetadataRetriever.release();
            } catch (IOException unused) {
            }
        }
    }

    public static long e(Context context) {
        Cursor cursorQuery;
        Cursor cursor = null;
        try {
            try {
                String[] strArr = {s12.i() + "%"};
                if (ol2.b()) {
                    cursorQuery = context.getApplicationContext().getContentResolver().query(MediaStore.Files.getContentUri("external"), null, a("_data like ?", strArr, 1, 0), null);
                } else {
                    cursorQuery = context.getApplicationContext().getContentResolver().query(MediaStore.Files.getContentUri("external"), null, "_data like ?", strArr, "_id DESC limit 1 offset 0");
                }
                cursor = cursorQuery;
                if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                    long j = cursor.getLong(cursor.getColumnIndex("bucket_id"));
                    cursor.close();
                    return j;
                }
                if (cursor == null) {
                    return -1L;
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursor == null) {
                    return -1L;
                }
            }
            cursor.close();
            return -1L;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x008d  */
    public static int f(Context context) {
        Cursor cursorQuery;
        Cursor cursor = null;
        try {
            try {
                String[] strArr = {s12.i() + "%"};
                if (ol2.b()) {
                    cursorQuery = context.getApplicationContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, a("_data like ?", strArr, 1, 0), null);
                } else {
                    cursorQuery = context.getApplicationContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, "_data like ?", strArr, "_id DESC limit 1 offset 0");
                }
                cursor = cursorQuery;
                if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return -1;
                }
                int i = y60.a(cursor.getLong(cursor.getColumnIndex("date_added"))) <= 1 ? cursor.getInt(cursor.getColumnIndex("_id")) : -1;
                cursor.close();
                return i;
            } catch (Exception e) {
                e.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                return -1;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (cursor != null) {
            cursor.close();
        }
        throw th;
    }

    public static qh1 g(Context context, String str) {
        qh1 qh1Var = new qh1();
        try {
            dj0 dj0Var = a22.h(str) ? new dj0(y02.a(context, Uri.parse(str))) : new dj0(str);
            qh1Var.f(dj0Var.o("ImageWidth", 1));
            qh1Var.e(dj0Var.o("ImageLength", 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return qh1Var;
    }

    public static qh1 h(Context context, String str) {
        int iA;
        int iA2;
        qh1 qh1Var = new qh1();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                if (a22.h(str)) {
                    mediaMetadataRetriever.setDataSource(context, Uri.parse(str));
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                String strExtractMetadata = mediaMetadataRetriever.extractMetadata(24);
                if (TextUtils.equals("90", strExtractMetadata) || TextUtils.equals("270", strExtractMetadata)) {
                    iA = db3.a(mediaMetadataRetriever.extractMetadata(18));
                    iA2 = db3.a(mediaMetadataRetriever.extractMetadata(19));
                } else {
                    iA2 = db3.a(mediaMetadataRetriever.extractMetadata(18));
                    iA = db3.a(mediaMetadataRetriever.extractMetadata(19));
                }
                qh1Var.f(iA2);
                qh1Var.e(iA);
                qh1Var.d(db3.c(mediaMetadataRetriever.extractMetadata(9)));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return qh1Var;
        } finally {
            try {
                mediaMetadataRetriever.release();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean i(int i, int i2) {
        return i > 0 && i2 > 0 && i2 > i * 3;
    }

    public static boolean j(LocalMedia localMedia) {
        int iU = localMedia.u();
        int iL = localMedia.l();
        return iU > 0 && iL > 0 && iL > iU * 3;
    }

    public static void k(Context context, int i) {
        try {
            context.getApplicationContext().getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{Long.toString(i)});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
