package com.soundcloud.android.crop;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
abstract class a {

    /* JADX INFO: renamed from: com.soundcloud.android.crop.a$a, reason: collision with other inner class name */
    private static class RunnableC0103a extends d.a implements Runnable {
        private final d a;
        private final ProgressDialog b;
        private final Runnable c;
        private final Handler d;
        private final Runnable e = new RunnableC0104a();

        /* JADX INFO: renamed from: com.soundcloud.android.crop.a$a$a, reason: collision with other inner class name */
        class RunnableC0104a implements Runnable {
            RunnableC0104a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                RunnableC0103a.this.a.b(RunnableC0103a.this);
                if (RunnableC0103a.this.b.getWindow() != null) {
                    RunnableC0103a.this.b.dismiss();
                }
            }
        }

        public RunnableC0103a(d dVar, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
            this.a = dVar;
            this.b = progressDialog;
            this.c = runnable;
            dVar.a(this);
            this.d = handler;
        }

        @Override // com.soundcloud.android.crop.d.b
        public void a(d dVar) {
            this.b.show();
        }

        @Override // com.soundcloud.android.crop.d.b
        public void c(d dVar) {
            this.e.run();
            this.d.removeCallbacks(this.e);
        }

        @Override // com.soundcloud.android.crop.d.b
        public void d(d dVar) {
            this.b.hide();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.c.run();
            } finally {
                this.d.post(this.e);
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    public static boolean b(File file, File file2) {
        if (file != null && file2 != null) {
            try {
                ExifInterface exifInterface = new ExifInterface(file.getAbsolutePath());
                ExifInterface exifInterface2 = new ExifInterface(file2.getAbsolutePath());
                exifInterface2.setAttribute("Orientation", exifInterface.getAttribute("Orientation"));
                exifInterface2.saveAttributes();
                return true;
            } catch (IOException e) {
                c.a("Error copying Exif data", e);
            }
        }
        return false;
    }

    public static int c(File file) {
        if (file == null) {
            return 0;
        }
        try {
            int attributeInt = new ExifInterface(file.getAbsolutePath()).getAttributeInt("Orientation", 0);
            if (attributeInt == 3) {
                return Opcodes.GETFIELD;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e) {
            c.a("Error getting Exif data", e);
            return 0;
        }
    }

    public static File d(Context context, ContentResolver contentResolver, Uri uri) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        if (uri == null) {
            return null;
        }
        if ("file".equals(uri.getScheme())) {
            return new File(uri.getPath());
        }
        if ("content".equals(uri.getScheme())) {
            try {
                try {
                    cursorQuery = contentResolver.query(uri, new String[]{"_data", "_display_name"}, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                int columnIndex = uri.toString().startsWith("content://com.google.android.gallery3d") ? cursorQuery.getColumnIndex("_display_name") : cursorQuery.getColumnIndex("_data");
                                if (columnIndex != -1) {
                                    String string = cursorQuery.getString(columnIndex);
                                    if (!TextUtils.isEmpty(string)) {
                                        File file = new File(string);
                                        cursorQuery.close();
                                        return file;
                                    }
                                }
                            }
                        } catch (IllegalArgumentException unused) {
                            cursor = cursorQuery;
                            File fileE = e(context, contentResolver, uri);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return fileE;
                        } catch (SecurityException unused2) {
                            if (cursorQuery != null) {
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IllegalArgumentException unused3) {
            } catch (SecurityException unused4) {
                cursorQuery = null;
            }
        }
        return null;
    }

    private static File e(Context context, ContentResolver contentResolver, Uri uri) throws Throwable {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (uri == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(contentResolver.openFileDescriptor(uri, "r").getFileDescriptor());
            try {
                String strF = f(context);
                fileOutputStream = new FileOutputStream(strF);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            File file = new File(strF);
                            a(fileInputStream);
                            a(fileOutputStream);
                            return file;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                } catch (IOException unused) {
                    a(fileInputStream);
                    a(fileOutputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    a(fileInputStream2);
                    a(fileOutputStream);
                    throw th;
                }
            } catch (IOException unused2) {
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (IOException unused3) {
            fileOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    private static String f(Context context) {
        return File.createTempFile("image", "tmp", context.getCacheDir()).getAbsolutePath();
    }

    public static void g(d dVar, String str, String str2, Runnable runnable, Handler handler) {
        new Thread(new RunnableC0103a(dVar, runnable, ProgressDialog.show(dVar, str, str2, true, false), handler)).start();
    }
}
