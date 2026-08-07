package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class cn0 {
    public static void a(Closeable closeable) {
        if (closeable instanceof Closeable) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean b(Context context, String str, String str2) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        FileOutputStream fileOutputStream = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = si.a(options.outWidth, options.outHeight);
            options.inJustDecodeBounds = false;
            Bitmap bitmapG = si.g(BitmapFactory.decodeFile(str, options));
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    bitmapG.compress(bitmapG.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
                    bitmapG.recycle();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(str2);
                    try {
                        fileOutputStream2.write(byteArrayOutputStream.toByteArray());
                        fileOutputStream2.flush();
                        g(context, str);
                        a(fileOutputStream2);
                        a(byteArrayOutputStream);
                        return true;
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        a(fileOutputStream);
                        a(byteArrayOutputStream);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        a(fileOutputStream);
                        a(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
        }
    }

    public static File c(Context context, int i, String str, String str2, String str3) {
        return d(context, i, str, str2, str3);
    }

    private static File d(Context context, int i, String str, String str2, String str3) {
        return e(context, i, str, str2, str3);
    }

    private static File e(Context context, int i, String str, String str2, String str3) {
        File file;
        File fileH;
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(str3)) {
            if (TextUtils.equals("mounted", Environment.getExternalStorageState())) {
                fileH = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                StringBuilder sb = new StringBuilder();
                sb.append(fileH.getAbsolutePath());
                String str4 = File.separator;
                sb.append(str4);
                sb.append("Camera");
                sb.append(str4);
                file = new File(sb.toString());
            } else {
                fileH = h(applicationContext, i);
                file = new File(fileH.getAbsolutePath() + File.separator);
            }
            if (!fileH.exists()) {
                fileH.mkdirs();
            }
        } else {
            File file2 = new File(str3);
            File parentFile = file2.getParentFile();
            Objects.requireNonNull(parentFile);
            if (!parentFile.exists()) {
                file2.getParentFile().mkdirs();
            }
            file = file2;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        boolean zIsEmpty = TextUtils.isEmpty(str);
        if (i == 2) {
            if (zIsEmpty) {
                str = y60.d("VID_") + ".mp4";
            }
            return new File(file, str);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = ".jpeg";
        }
        if (zIsEmpty) {
            str = y60.d("IMG_") + str2;
        }
        return new File(file, str);
    }

    public static File f(Context context, boolean z) {
        File file = new File(context.getExternalFilesDir(Constants.STR_EMPTY).getAbsolutePath(), ".TemporaryCamera");
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        sb.append(z ? ".mp4" : ".jpeg");
        return new File(file.getAbsolutePath(), sb.toString());
    }

    public static void g(Context context, String str) {
        try {
            if (i(str)) {
                context.getContentResolver().delete(Uri.parse(str), null, null);
            } else {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static File h(Context context, int i) {
        return i == 2 ? context.getExternalFilesDir(Environment.DIRECTORY_MOVIES) : context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    }

    public static boolean i(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("content://");
    }

    public static boolean j(InputStream inputStream, OutputStream outputStream) throws Throwable {
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
