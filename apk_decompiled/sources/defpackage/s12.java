package defpackage;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s12 {
    public static void a(Closeable closeable) {
        if (closeable instanceof Closeable) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void b(String str, String str2) throws Throwable {
        FileChannel fileChannel;
        if (str.equalsIgnoreCase(str2)) {
            return;
        }
        FileChannel channel = null;
        try {
            FileChannel channel2 = new FileInputStream(str).getChannel();
            try {
                channel = new FileOutputStream(str2).getChannel();
                channel2.transferTo(0L, channel2.size(), channel);
                a(channel2);
                a(channel);
            } catch (Exception e) {
                e = e;
                FileChannel fileChannel2 = channel;
                channel = channel2;
                fileChannel = fileChannel2;
                try {
                    e.printStackTrace();
                    a(channel);
                    a(fileChannel);
                } catch (Throwable th) {
                    th = th;
                    a(channel);
                    a(fileChannel);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                FileChannel fileChannel3 = channel;
                channel = channel2;
                fileChannel = fileChannel3;
                a(channel);
                a(fileChannel);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileChannel = null;
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
        }
    }

    public static File c(Context context, int i, String str, String str2, String str3) {
        return e(context, i, str, str2, str3);
    }

    public static String d(Context context, String str, String str2, String str3) {
        String strC = a22.c(str2);
        if (a22.n(str2)) {
            String str4 = n(context) + File.separator;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = y60.d("VID_") + strC;
                }
                return str4 + str3;
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "VID_" + str.toUpperCase() + strC;
            }
            return str4 + str3;
        }
        if (a22.k(str2)) {
            String str5 = h(context) + File.separator;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = y60.d("AUD_") + strC;
                }
                return str5 + str3;
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "AUD_" + str.toUpperCase() + strC;
            }
            return str5 + str3;
        }
        String str6 = k(context) + File.separator;
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str3)) {
                str3 = y60.d("IMG_") + strC;
            }
            return str6 + str3;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "IMG_" + str.toUpperCase() + strC;
        }
        return str6 + str3;
    }

    private static File e(Context context, int i, String str, String str2, String str3) {
        return f(context, i, str, str2, str3);
    }

    private static File f(Context context, int i, String str, String str2, String str3) {
        File file;
        File file2;
        Context applicationContext = context.getApplicationContext();
        Log.i("PictureFileUtils", "=== 创建相机输出文件 ===");
        Log.i("PictureFileUtils", "chooseMode: " + i);
        Log.i("PictureFileUtils", "fileName: " + str);
        Log.i("PictureFileUtils", "format: " + str2);
        Log.i("PictureFileUtils", "outCameraDirectory: " + str3);
        if (TextUtils.isEmpty(str3)) {
            Log.i("PictureFileUtils", "使用默认沙盒目录");
            File fileM = m(applicationContext, i);
            StringBuilder sb = new StringBuilder();
            sb.append("rootDir: ");
            sb.append(fileM != null ? fileM.getAbsolutePath() : "null");
            Log.i("PictureFileUtils", sb.toString());
            if (fileM == null) {
                Log.e("PictureFileUtils", "无法获取根目录，使用缓存目录");
                fileM = applicationContext.getCacheDir();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(fileM.getAbsolutePath());
            String str4 = File.separator;
            sb2.append(str4);
            sb2.append("Camera");
            sb2.append(str4);
            file = new File(sb2.toString());
            Log.i("PictureFileUtils", "folderDir: " + file.getAbsolutePath());
            if (!fileM.exists()) {
                Log.i("PictureFileUtils", "创建rootDir: " + fileM.mkdirs());
            }
        } else {
            Log.i("PictureFileUtils", "使用自定义路径: " + str3);
            file = new File(str3);
            File parentFile = file.getParentFile();
            Objects.requireNonNull(parentFile);
            if (!parentFile.exists()) {
                Log.i("PictureFileUtils", "创建父目录: " + file.getParentFile().mkdirs());
            }
        }
        if (!file.exists()) {
            Log.i("PictureFileUtils", "创建folderDir: " + file.mkdirs() + ", 路径: " + file.getAbsolutePath());
        }
        boolean zIsEmpty = TextUtils.isEmpty(str);
        if (i == 2) {
            if (zIsEmpty) {
                str = y60.d("VID_") + ".mp4";
            }
            file2 = new File(file, str);
        } else if (i != 3) {
            if (TextUtils.isEmpty(str2)) {
                str2 = ".jpeg";
            }
            if (zIsEmpty) {
                str = y60.d("IMG_") + str2;
            }
            file2 = new File(file, str);
        } else {
            if (zIsEmpty) {
                str = y60.d("AUD_") + ".amr";
            }
            file2 = new File(file, str);
        }
        Log.i("PictureFileUtils", "最终文件路径: " + file2.getAbsolutePath());
        Log.i("PictureFileUtils", "=== 创建完成 ===");
        return file2;
    }

    public static String g(long j, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("precision shouldn't be less than zero!");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteSize shouldn't be less than zero!");
        }
        if (j < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            return String.format("%." + i + "fB", Double.valueOf(j));
        }
        if (j < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            return String.format("%." + i + "fKB", Double.valueOf(j / 1024.0d));
        }
        if (j < 1073741824) {
            return String.format("%." + i + "fMB", Double.valueOf(j / 1048576.0d));
        }
        return String.format("%." + i + "fGB", Double.valueOf(j / 1.073741824E9d));
    }

    public static String h(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        return externalFilesDir == null ? Constants.STR_EMPTY : externalFilesDir.getPath();
    }

    public static String i() {
        try {
            return "%" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/Camera";
        } catch (Exception e) {
            e.printStackTrace();
            return Constants.STR_EMPTY;
        }
    }

    public static String j(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                    cursorQuery.close();
                    return string;
                }
                if (cursorQuery == null) {
                    return Constants.STR_EMPTY;
                }
                cursorQuery.close();
                return Constants.STR_EMPTY;
            } catch (IllegalArgumentException e) {
                Log.i("PictureFileUtils", String.format(Locale.getDefault(), "getDataColumn: _data - [%s]", e.getMessage()));
                if (cursorQuery == null) {
                    return Constants.STR_EMPTY;
                }
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public static String k(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        return externalFilesDir == null ? Constants.STR_EMPTY : externalFilesDir.getPath();
    }

    public static String l(Context context, Uri uri) {
        Context applicationContext = context.getApplicationContext();
        Uri uri2 = null;
        if (!DocumentsContract.isDocumentUri(applicationContext, uri)) {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                return r(uri) ? uri.getLastPathSegment() : j(applicationContext, uri, null, null);
            }
            return "file".equalsIgnoreCase(uri.getScheme()) ? uri.getPath() : Constants.STR_EMPTY;
        }
        if (!p(uri)) {
            if (o(uri)) {
                return j(applicationContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), db3.c(DocumentsContract.getDocumentId(uri))), null, null);
            }
            if (!s(uri)) {
                return Constants.STR_EMPTY;
            }
            String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
            String str = strArrSplit[0];
            if ("image".equals(str)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return j(applicationContext, uri2, "_id=?", new String[]{strArrSplit[1]});
        }
        String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
        if (!"primary".equalsIgnoreCase(strArrSplit2[0])) {
            return Constants.STR_EMPTY;
        }
        if (ol2.a()) {
            return applicationContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES) + WatchConstant.FAT_FS_ROOT + strArrSplit2[1];
        }
        return Environment.getExternalStorageDirectory() + WatchConstant.FAT_FS_ROOT + strArrSplit2[1];
    }

    private static File m(Context context, int i) {
        File externalFilesDir;
        Log.i("PictureFileUtils", "获取根目录，type: " + i);
        if (i == 2) {
            externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
            StringBuilder sb = new StringBuilder();
            sb.append("视频目录(外部): ");
            sb.append(externalFilesDir != null ? externalFilesDir.getAbsolutePath() : "null");
            Log.i("PictureFileUtils", sb.toString());
            if (externalFilesDir == null) {
                externalFilesDir = new File(context.getFilesDir(), "Movies");
                Log.i("PictureFileUtils", "使用内部存储: " + externalFilesDir.getAbsolutePath());
            }
        } else if (i != 3) {
            externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("图片目录(外部): ");
            sb2.append(externalFilesDir != null ? externalFilesDir.getAbsolutePath() : "null");
            Log.i("PictureFileUtils", sb2.toString());
            if (externalFilesDir == null) {
                externalFilesDir = new File(context.getFilesDir(), "Pictures");
                Log.i("PictureFileUtils", "使用内部存储: " + externalFilesDir.getAbsolutePath());
            }
        } else {
            externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("音频目录(外部): ");
            sb3.append(externalFilesDir != null ? externalFilesDir.getAbsolutePath() : "null");
            Log.i("PictureFileUtils", sb3.toString());
            if (externalFilesDir == null) {
                externalFilesDir = new File(context.getFilesDir(), "Music");
                Log.i("PictureFileUtils", "使用内部存储: " + externalFilesDir.getAbsolutePath());
            }
        }
        if (!externalFilesDir.exists()) {
            Log.i("PictureFileUtils", "创建根目录: " + externalFilesDir.mkdirs());
        }
        return externalFilesDir;
    }

    public static String n(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        return externalFilesDir == null ? Constants.STR_EMPTY : externalFilesDir.getPath();
    }

    public static boolean o(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean p(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean q(String str) {
        return TextUtils.isEmpty(str) || new File(str).exists();
    }

    public static boolean r(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean s(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static Uri t(Context context, File file) {
        return FileProvider.h(context, context.getPackageName() + ".luckProvider", file);
    }

    public static String u(String str) {
        return str.substring(0, str.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR)) + "_" + y60.c() + str.substring(str.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR));
    }

    public static boolean v(InputStream inputStream, OutputStream outputStream) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            try {
                bufferedOutputStream = new BufferedOutputStream(outputStream);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = bufferedInputStream2.read(bArr);
                        if (i == -1) {
                            outputStream.flush();
                            a(bufferedInputStream2);
                            a(bufferedOutputStream);
                            return true;
                        }
                        outputStream.write(bArr, 0, i);
                    }
                } catch (Exception e) {
                    e = e;
                    bufferedInputStream = bufferedInputStream2;
                    try {
                        e.printStackTrace();
                        a(bufferedInputStream);
                        a(bufferedOutputStream);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        a(bufferedInputStream);
                        a(bufferedOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = bufferedInputStream2;
                    a(bufferedInputStream);
                    a(bufferedOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                bufferedOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
        }
    }
}
