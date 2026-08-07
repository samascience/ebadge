package com.blankj.utilcode.util;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {
    /* JADX WARN: Code duplicated, block: B:32:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.InputStream] */
    private static File a(Uri uri) throws Throwable {
        Throwable th;
        InputStream inputStreamOpenInputStream;
        Log.d("UriUtils", "copyUri2Cache() called");
        try {
            try {
                inputStreamOpenInputStream = o.a().getContentResolver().openInputStream(uri);
                try {
                    File file = new File(o.a().getCacheDir(), Constants.STR_EMPTY + System.currentTimeMillis());
                    q.S(file.getAbsolutePath(), inputStreamOpenInputStream);
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return file;
                } catch (FileNotFoundException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (uri != 0) {
                    try {
                        uri.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            inputStreamOpenInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            uri = 0;
            if (uri != 0) {
                uri.close();
            }
            throw th;
        }
    }

    public static Uri b(File file) {
        if (!q.C(file)) {
            return null;
        }
        return FileProvider.h(o.a(), o.a().getPackageName() + ".utilcode.fileprovider", file);
    }

    private static File c(Uri uri, String str) {
        return d(uri, null, null, str);
    }

    private static File d(Uri uri, String str, String[] strArr, String str2) {
        if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
            if (!TextUtils.isEmpty(uri.getLastPathSegment())) {
                return new File(uri.getLastPathSegment());
            }
        } else if ("com.tencent.mtt.fileprovider".equals(uri.getAuthority())) {
            String path = uri.getPath();
            if (!TextUtils.isEmpty(path)) {
                return new File(Environment.getExternalStorageDirectory(), path.substring(10, path.length()));
            }
        } else if ("com.huawei.hidisk.fileprovider".equals(uri.getAuthority())) {
            String path2 = uri.getPath();
            if (!TextUtils.isEmpty(path2)) {
                return new File(path2.replace("/root", Constants.STR_EMPTY));
            }
        }
        Cursor cursorQuery = o.a().getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
        try {
            if (cursorQuery == null) {
                Log.d("UriUtils", uri.toString() + " parse failed(cursor is null). -> " + str2);
                return null;
            }
            if (!cursorQuery.moveToFirst()) {
                Log.d("UriUtils", uri.toString() + " parse failed(moveToFirst return false). -> " + str2);
                return null;
            }
            int columnIndex = cursorQuery.getColumnIndex("_data");
            if (columnIndex > -1) {
                return new File(cursorQuery.getString(columnIndex));
            }
            Log.d("UriUtils", uri.toString() + " parse failed(columnIndex: " + columnIndex + " is wrong). -> " + str2);
            return null;
        } catch (Exception unused) {
            Log.d("UriUtils", uri.toString() + " parse failed. -> " + str2);
            return null;
        } finally {
            cursorQuery.close();
        }
    }

    public static File e(Uri uri) {
        if (uri == null) {
            return null;
        }
        File fileF = f(uri);
        return fileF != null ? fileF : a(uri);
    }

    private static File f(Uri uri) {
        Uri uri2;
        String str;
        File file;
        Log.d("UriUtils", uri.toString());
        String authority = uri.getAuthority();
        String scheme = uri.getScheme();
        String path = uri.getPath();
        int i = 0;
        if (path != null) {
            String[] strArr = {"/external/", "/external_path/"};
            for (int i2 = 0; i2 < 2; i2++) {
                String str2 = strArr[i2];
                if (path.startsWith(str2)) {
                    File file2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + path.replace(str2, WatchConstant.FAT_FS_ROOT));
                    if (file2.exists()) {
                        Log.d("UriUtils", uri.toString() + " -> " + str2);
                        return file2;
                    }
                }
            }
            if (path.startsWith("/files_path/")) {
                file = new File(o.a().getFilesDir().getAbsolutePath() + path.replace("/files_path/", WatchConstant.FAT_FS_ROOT));
            } else if (path.startsWith("/cache_path/")) {
                file = new File(o.a().getCacheDir().getAbsolutePath() + path.replace("/cache_path/", WatchConstant.FAT_FS_ROOT));
            } else if (path.startsWith("/external_files_path/")) {
                file = new File(o.a().getExternalFilesDir(null).getAbsolutePath() + path.replace("/external_files_path/", WatchConstant.FAT_FS_ROOT));
            } else if (path.startsWith("/external_cache_path/")) {
                file = new File(o.a().getExternalCacheDir().getAbsolutePath() + path.replace("/external_cache_path/", WatchConstant.FAT_FS_ROOT));
            } else {
                file = null;
            }
            if (file != null && file.exists()) {
                Log.d("UriUtils", uri.toString() + " -> " + path);
                return file;
            }
        }
        if ("file".equals(scheme)) {
            if (path != null) {
                return new File(path);
            }
            Log.d("UriUtils", uri.toString() + " parse failed. -> 0");
            return null;
        }
        if (!DocumentsContract.isDocumentUri(o.a(), uri)) {
            if ("content".equals(scheme)) {
                return c(uri, "2");
            }
            Log.d("UriUtils", uri.toString() + " parse failed. -> 3");
            return null;
        }
        if ("com.android.externalstorage.documents".equals(authority)) {
            String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
            String str3 = strArrSplit[0];
            if ("primary".equalsIgnoreCase(str3)) {
                return new File(Environment.getExternalStorageDirectory() + WatchConstant.FAT_FS_ROOT + strArrSplit[1]);
            }
            StorageManager storageManager = (StorageManager) o.a().getSystemService("storage");
            try {
                Class<?> cls = Class.forName("android.os.storage.StorageVolume");
                Method method = storageManager.getClass().getMethod("getVolumeList", null);
                Method method2 = cls.getMethod("getUuid", null);
                Method method3 = cls.getMethod("getState", null);
                Method method4 = cls.getMethod("getPath", null);
                Method method5 = cls.getMethod("isPrimary", null);
                Method method6 = cls.getMethod("isEmulated", null);
                Object objInvoke = method.invoke(storageManager, null);
                int length = Array.getLength(objInvoke);
                while (i < length) {
                    Object obj = Array.get(objInvoke, i);
                    Object obj2 = objInvoke;
                    if ("mounted".equals(method3.invoke(obj, null)) || "mounted_ro".equals(method3.invoke(obj, null))) {
                        if ((!((Boolean) method5.invoke(obj, null)).booleanValue() || !((Boolean) method6.invoke(obj, null)).booleanValue()) && (str = (String) method2.invoke(obj, null)) != null && str.equals(str3)) {
                            return new File(method4.invoke(obj, null) + WatchConstant.FAT_FS_ROOT + strArrSplit[1]);
                        }
                    }
                    i++;
                    objInvoke = obj2;
                }
            } catch (Exception e) {
                Log.d("UriUtils", uri.toString() + " parse failed. " + e.toString() + " -> 1_0");
            }
            Log.d("UriUtils", uri.toString() + " parse failed. -> 1_0");
            return null;
        }
        if (!"com.android.providers.downloads.documents".equals(authority)) {
            if (!"com.android.providers.media.documents".equals(authority)) {
                if ("content".equals(scheme)) {
                    return c(uri, "1_3");
                }
                Log.d("UriUtils", uri.toString() + " parse failed. -> 1_4");
                return null;
            }
            String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
            String str4 = strArrSplit2[0];
            if ("image".equals(str4)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str4)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else {
                if (!"audio".equals(str4)) {
                    Log.d("UriUtils", uri.toString() + " parse failed. -> 1_2");
                    return null;
                }
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return d(uri2, "_id=?", new String[]{strArrSplit2[1]}, "1_2");
        }
        String documentId = DocumentsContract.getDocumentId(uri);
        if (TextUtils.isEmpty(documentId)) {
            Log.d("UriUtils", uri.toString() + " parse failed(id is null). -> 1_1");
            return null;
        }
        if (documentId.startsWith("raw:")) {
            return new File(documentId.substring(4));
        }
        if (documentId.startsWith("msf:")) {
            documentId = documentId.split(":")[1];
        }
        try {
            long j = Long.parseLong(documentId);
            String[] strArr2 = {"content://downloads/public_downloads", "content://downloads/all_downloads", "content://downloads/my_downloads"};
            while (i < 3) {
                try {
                    File fileC = c(ContentUris.withAppendedId(Uri.parse(strArr2[i]), j), "1_1");
                    if (fileC != null) {
                        return fileC;
                    }
                    i++;
                } catch (Exception unused) {
                }
            }
            Log.d("UriUtils", uri.toString() + " parse failed. -> 1_1");
        } catch (Exception unused2) {
        }
        return null;
    }
}
