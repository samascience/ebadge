package defpackage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.u;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
class y41 implements uw1 {

    static abstract class a {
        a() {
        }

        static a c(xy1 xy1Var, u.g gVar) {
            return new id(xy1Var, gVar);
        }

        abstract u.g a();

        abstract xy1 b();
    }

    y41() {
    }

    private static Uri b(File file, File file2) throws ImageCaptureException {
        if (file2.exists()) {
            file2.delete();
        }
        if (file.renameTo(file2)) {
            return Uri.fromFile(file2);
        }
        throw new ImageCaptureException(1, "Failed to overwrite the file: " + file2.getAbsolutePath(), null);
    }

    private static Uri c(File file, u.g gVar) throws Throwable {
        ContentResolver contentResolverA = gVar.a();
        Objects.requireNonNull(contentResolverA);
        ContentValues contentValues = gVar.b() != null ? new ContentValues(gVar.b()) : new ContentValues();
        l(contentValues, 1);
        Uri uri = null;
        try {
            try {
                Uri uriInsert = contentResolverA.insert(gVar.f(), contentValues);
                try {
                    if (uriInsert == null) {
                        throw new ImageCaptureException(1, "Failed to insert a MediaStore URI.", null);
                    }
                    e(file, uriInsert, contentResolverA);
                    n(uriInsert, contentResolverA, 0);
                    return uriInsert;
                } catch (IOException e) {
                    e = e;
                    uri = uriInsert;
                    throw new ImageCaptureException(1, "Failed to write to MediaStore URI: " + uri, e);
                } catch (SecurityException e2) {
                    e = e2;
                    uri = uriInsert;
                    throw new ImageCaptureException(1, "Failed to write to MediaStore URI: " + uri, e);
                } catch (Throwable th) {
                    th = th;
                    uri = uriInsert;
                    if (uri != null) {
                        n(uri, contentResolverA, 0);
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
        } catch (SecurityException e4) {
            e = e4;
        }
    }

    private static void d(File file, OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i <= 0) {
                    fileInputStream.close();
                    return;
                }
                outputStream.write(bArr, 0, i);
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static void e(File file, Uri uri, ContentResolver contentResolver) throws IOException {
        OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uri);
        try {
            if (outputStreamOpenOutputStream != null) {
                d(file, outputStreamOpenOutputStream);
                outputStreamOpenOutputStream.close();
            } else {
                throw new FileNotFoundException(uri + " cannot be resolved.");
            }
        } catch (Throwable th) {
            if (outputStreamOpenOutputStream != null) {
                try {
                    outputStreamOpenOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private static File f(u.g gVar) throws ImageCaptureException {
        try {
            File fileC = gVar.c();
            if (fileC == null) {
                return File.createTempFile("CameraX", ".tmp");
            }
            return new File(fileC.getParent(), "CameraX" + UUID.randomUUID().toString() + g(fileC));
        } catch (IOException e) {
            throw new ImageCaptureException(1, "Failed to create temp file.", e);
        }
    }

    private static String g(File file) {
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf >= 0 ? name.substring(iLastIndexOf) : Constants.STR_EMPTY;
    }

    private static boolean h(u.g gVar) {
        return gVar.c() != null;
    }

    private static boolean i(u.g gVar) {
        return (gVar.f() == null || gVar.a() == null || gVar.b() == null) ? false : true;
    }

    private static boolean j(u.g gVar) {
        return gVar.e() != null;
    }

    static Uri k(File file, u.g gVar) {
        Uri uriB = null;
        try {
            try {
                if (i(gVar)) {
                    uriB = c(file, gVar);
                } else if (j(gVar)) {
                    OutputStream outputStreamE = gVar.e();
                    Objects.requireNonNull(outputStreamE);
                    d(file, outputStreamE);
                } else if (h(gVar)) {
                    File fileC = gVar.c();
                    Objects.requireNonNull(fileC);
                    uriB = b(file, fileC);
                }
                file.delete();
                return uriB;
            } catch (IOException unused) {
                throw new ImageCaptureException(1, "Failed to write to OutputStream.", null);
            }
        } catch (Throwable th) {
            file.delete();
            throw th;
        }
    }

    private static void l(ContentValues contentValues, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("is_pending", Integer.valueOf(i));
        }
    }

    private static void m(File file, bj0 bj0Var, u.g gVar, int i) throws Throwable {
        try {
            bj0 bj0VarH = bj0.h(file);
            bj0Var.g(bj0VarH);
            if (bj0VarH.s() == 0 && i != 0) {
                bj0VarH.z(i);
            }
            u.d dVarD = gVar.d();
            if (dVarD.b()) {
                bj0VarH.l();
            }
            if (dVarD.c()) {
                bj0VarH.m();
            }
            if (dVarD.a() != null) {
                bj0VarH.b(dVarD.a());
            }
            bj0VarH.A();
        } catch (IOException e) {
            throw new ImageCaptureException(1, "Failed to update Exif data", e);
        }
    }

    private static void n(Uri uri, ContentResolver contentResolver, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            l(contentValues, i);
            contentResolver.update(uri, contentValues, null, null);
        }
    }

    private static void o(File file, byte[] bArr) throws ImageCaptureException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr, 0, new q31().b(bArr));
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            throw new ImageCaptureException(1, "Failed to write to temp file", e);
        }
    }

    @Override // defpackage.uw1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public u.h apply(a aVar) throws Throwable {
        xy1 xy1VarB = aVar.b();
        u.g gVarA = aVar.a();
        File fileF = f(gVarA);
        o(fileF, (byte[]) xy1VarB.c());
        bj0 bj0VarD = xy1VarB.d();
        Objects.requireNonNull(bj0VarD);
        m(fileF, bj0VarD, gVarA, xy1VarB.f());
        return new u.h(k(fileF, gVarA));
    }
}
