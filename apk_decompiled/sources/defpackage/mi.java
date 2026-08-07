package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.connect.common.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class mi extends AsyncTask {
    private final Context a;
    private Uri b;
    private final Uri c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final li h;

    public mi(Context context, Uri uri, Uri uri2, int i, int i2, int i3, int i4, li liVar) {
        this.a = context;
        this.b = uri;
        this.c = uri2;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = liVar;
    }

    private boolean a(Bitmap bitmap, BitmapFactory.Options options) {
        if ((bitmap != null ? bitmap.getByteCount() : 0) <= 104857600) {
            return false;
        }
        options.inSampleSize *= 2;
        return true;
    }

    private void b(Uri uri, Uri uri2) throws Throwable {
        InputStream inputStreamA;
        Log.d("BitmapWorkerTask", "copyFile");
        if (uri2 == null) {
            throw new NullPointerException("Output Uri is null - cannot copy image");
        }
        FileOutputStream fileOutputStream = null;
        try {
            inputStreamA = y02.a(this.a, uri);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(uri2.getPath());
                try {
                    if (inputStreamA == null) {
                        throw new NullPointerException("InputStream for given input Uri is null");
                    }
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStreamA.read(bArr);
                        if (i <= 0) {
                            ni.c(fileOutputStream2);
                            ni.c(inputStreamA);
                            this.b = this.c;
                            return;
                        }
                        fileOutputStream2.write(bArr, 0, i);
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    ni.c(fileOutputStream);
                    ni.c(inputStreamA);
                    this.b = this.c;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamA = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v9 */
    private void d(Uri uri, Uri uri2) throws Throwable {
        BufferedInputStream bufferedInputStream;
        Log.d("BitmapWorkerTask", "downloadFile");
        if (uri2 == 0) {
            throw new NullPointerException("Output Uri is null - cannot download image");
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                URL url = new URL(uri.toString());
                byte[] bArr = new byte[1024];
                bufferedInputStream = new BufferedInputStream(url.openStream());
                try {
                    uri2 = y02.b(this.a, uri2);
                    if (uri2 != 0) {
                        try {
                            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(uri2);
                            while (true) {
                                try {
                                    int i = bufferedInputStream.read(bArr);
                                    if (i <= -1) {
                                        break;
                                    } else {
                                        bufferedOutputStream2.write(bArr, 0, i);
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    e.printStackTrace();
                                    uri2 = uri2;
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    this.b = this.c;
                                    ni.c(bufferedOutputStream);
                                    ni.c(bufferedInputStream);
                                    ni.c(uri2);
                                    throw th;
                                }
                            }
                            bufferedOutputStream2.flush();
                            bufferedOutputStream = bufferedOutputStream2;
                            uri2 = uri2;
                        } catch (Exception e2) {
                            e = e2;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    uri2 = 0;
                } catch (Throwable th2) {
                    th = th2;
                    uri2 = 0;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e4) {
            e = e4;
            uri2 = 0;
            bufferedInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            uri2 = 0;
            bufferedInputStream = null;
        }
        this.b = this.c;
        ni.c(bufferedOutputStream);
        ni.c(bufferedInputStream);
        ni.c(uri2);
    }

    private String e() {
        return q30.a(this.a, "android.permission.READ_EXTERNAL_STORAGE") == 0 ? s12.l(this.a, this.b) : Constants.STR_EMPTY;
    }

    private void g() {
        String scheme = this.b.getScheme();
        Log.d("BitmapWorkerTask", "Uri scheme: " + scheme);
        if ("http".equals(scheme) || "https".equals(scheme)) {
            try {
                d(this.b, this.c);
                return;
            } catch (IOException | NullPointerException e) {
                Log.e("BitmapWorkerTask", "Downloading failed", e);
                throw e;
            }
        }
        if ("content".equals(scheme)) {
            String strE = e();
            if (!TextUtils.isEmpty(strE) && new File(strE).exists()) {
                this.b = ol2.a() ? this.b : Uri.fromFile(new File(strE));
                return;
            }
            try {
                b(this.b, this.c);
                return;
            } catch (IOException | NullPointerException e2) {
                Log.e("BitmapWorkerTask", "Copying failed", e2);
                throw e2;
            }
        }
        if ("file".equals(scheme)) {
            return;
        }
        Log.e("BitmapWorkerTask", "Invalid Uri scheme " + scheme);
        throw new IllegalArgumentException("Invalid Uri scheme" + scheme);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public a doInBackground(Void... voidArr) {
        if (this.b == null) {
            return new a(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            g();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            int i = options.outWidth;
            if (i == 0 && options.outHeight == 0) {
                int i2 = this.f;
                int i3 = this.g;
                options.inSampleSize = ni.a(i2, i3, i2, i3);
            } else {
                options.inSampleSize = ni.a(i, options.outHeight, this.d, this.e);
            }
            boolean z = false;
            options.inJustDecodeBounds = false;
            Bitmap bitmapDecodeStream = null;
            while (!z) {
                try {
                    bitmapDecodeStream = BitmapFactory.decodeStream(y02.a(this.a, this.b), null, options);
                    if (options.outWidth != -1 && options.outHeight != -1) {
                        if (!a(bitmapDecodeStream, options)) {
                            z = true;
                        }
                    }
                    return new a(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.b + "]"));
                } catch (Exception e) {
                    Log.e("BitmapWorkerTask", "doInBackground: ImageDecoder.createSource: ", e);
                    return new a(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.b + "]", e));
                } catch (OutOfMemoryError e2) {
                    Log.e("BitmapWorkerTask", "doInBackground: BitmapFactory.decodeFileDescriptor: ", e2);
                    options.inSampleSize *= 2;
                }
            }
            if (bitmapDecodeStream == null) {
                return new a(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.b + "]"));
            }
            int iG = ni.g(this.a, this.b);
            int iE = ni.e(iG);
            int iF = ni.f(iG);
            cj0 cj0Var = new cj0(iG, iE, iF);
            Matrix matrix = new Matrix();
            if (iE != 0) {
                matrix.preRotate(iE);
            }
            if (iF != 1) {
                matrix.postScale(iF, 1.0f);
            }
            return !matrix.isIdentity() ? new a(ni.h(bitmapDecodeStream, matrix), cj0Var) : new a(bitmapDecodeStream, cj0Var);
        } catch (IOException | NullPointerException e3) {
            return new a(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(a aVar) {
        Exception exc = aVar.c;
        if (exc != null) {
            this.h.b(exc);
            return;
        }
        String string = this.b.toString();
        li liVar = this.h;
        Bitmap bitmap = aVar.a;
        cj0 cj0Var = aVar.b;
        if (!a22.h(string)) {
            string = this.b.getPath();
        }
        Uri uri = this.c;
        liVar.a(bitmap, cj0Var, string, uri == null ? null : uri.getPath());
    }

    public static class a {
        Bitmap a;
        cj0 b;
        Exception c;

        public a(Bitmap bitmap, cj0 cj0Var) {
            this.a = bitmap;
            this.b = cj0Var;
        }

        public a(Exception exc) {
            this.c = exc;
        }
    }
}
