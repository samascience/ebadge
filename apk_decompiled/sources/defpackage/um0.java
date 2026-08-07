package defpackage;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public abstract class um0 {
    private static String a(Context context, Uri uri, String str, String[] strArr) {
        uri.getAuthority();
        String path = uri.getPath();
        Log.d("FilePathUtil", "path = " + path);
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Log.d("FilePathUtil", "sdPath = " + absolutePath);
        if (path != null && !path.startsWith(absolutePath)) {
            if (path.startsWith("/root" + absolutePath)) {
                path = path.substring(5);
            } else {
                int iIndexOf = path.indexOf(File.separator, 1);
                Log.d("FilePathUtil", "sepIndex = " + iIndexOf);
                if (iIndexOf == -1) {
                    path = null;
                } else {
                    path = absolutePath + path.substring(iIndexOf);
                }
            }
        }
        Log.d("FilePathUtil", "path = " + path);
        if (path == null || !new File(path).exists()) {
            ContentResolver contentResolver = context.getContentResolver();
            String[] strArr2 = {"_data"};
            Cursor cursorQuery = contentResolver.query(uri, strArr2, str, strArr, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                try {
                    int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow(strArr2[0]);
                    if (columnIndexOrThrow != -1) {
                        path = cursorQuery.getString(columnIndexOrThrow);
                    }
                    Log.i("FilePathUtil", "getMediaPathFromUri query " + path);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    return null;
                } finally {
                    cursorQuery.close();
                }
            }
        }
        return path;
    }

    public static String b(Context context, Uri uri) {
        String path;
        String str;
        Uri uri2;
        Log.d("FilePathUtil", "uri.getScheme() = " + uri.getScheme());
        Log.d("FilePathUtil", "uri.getEncodedPath() = " + uri.getEncodedPath());
        Log.d("FilePathUtil", "uri.getPath() = " + uri.getPath());
        if (DocumentsContract.isDocumentUri(context, uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            String[] strArrSplit = documentId.split(":");
            if (strArrSplit.length == 2) {
                str = strArrSplit[0];
                path = strArrSplit[1];
            } else {
                path = null;
                str = null;
            }
            String authority = uri.getAuthority();
            authority.hashCode();
            switch (authority) {
                case "com.android.providers.downloads.documents":
                    if (!"raw".equals(str)) {
                        path = a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
                        break;
                    }
                    break;
                case "com.android.externalstorage.documents":
                    if (!"primary".equals(str)) {
                        path = null;
                        break;
                    } else {
                        path = Environment.getExternalStorageDirectory() + File.separator + path;
                        break;
                    }
                    break;
                case "com.android.providers.media.documents":
                    str.hashCode();
                    switch (str) {
                        case "audio":
                            uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                            break;
                        case "image":
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                            break;
                        case "video":
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                            break;
                        default:
                            uri2 = null;
                            break;
                    }
                    if (uri2 == null) {
                        path = null;
                        break;
                    } else {
                        path = a(context, uri2, "_id=?", new String[]{path});
                        break;
                    }
                    break;
                default:
                    path = null;
                    break;
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            path = a(context, uri, null, null);
        } else {
            path = "file".equalsIgnoreCase(uri.getScheme()) ? uri.getPath() : null;
        }
        if (path != null && new File(path).exists()) {
            return path;
        }
        return null;
    }
}
