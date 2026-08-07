package defpackage;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class hi implements xg2 {
    public static final px1 b = px1.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final px1 c = px1.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    private final v9 a;

    public hi(v9 v9Var) {
        this.a = v9Var;
    }

    private Bitmap.CompressFormat d(Bitmap bitmap, rx1 rx1Var) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) rx1Var.a(c);
        if (compressFormat != null) {
            return compressFormat;
        }
        return bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    @Override // defpackage.xg2
    public EncodeStrategy b(rx1 rx1Var) {
        return EncodeStrategy.TRANSFORMED;
    }

    @Override // defpackage.fg0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(qg2 qg2Var, File file, rx1 rx1Var) {
        boolean z;
        Bitmap bitmap = (Bitmap) qg2Var.get();
        Bitmap.CompressFormat compressFormatD = d(bitmap, rx1Var);
        pu0.c("encode: [%dx%d] %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), compressFormatD);
        try {
            long jB = cd1.b();
            int iIntValue = ((Integer) rx1Var.a(b)).intValue();
            OutputStream qoVar = null;
            try {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        qoVar = this.a != null ? new qo(fileOutputStream, this.a) : fileOutputStream;
                        bitmap.compress(compressFormatD, iIntValue, qoVar);
                        qoVar.close();
                        try {
                            qoVar.close();
                        } catch (IOException unused) {
                        }
                        z = true;
                    } catch (IOException e) {
                        e = e;
                        qoVar = fileOutputStream;
                        if (Log.isLoggable("BitmapEncoder", 3)) {
                            Log.d("BitmapEncoder", "Failed to encode Bitmap", e);
                        }
                        if (qoVar != null) {
                            try {
                                qoVar.close();
                            } catch (IOException unused2) {
                            }
                        }
                        z = false;
                    } catch (Throwable th) {
                        th = th;
                        qoVar = fileOutputStream;
                        if (qoVar != null) {
                            try {
                                qoVar.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e2) {
                e = e2;
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
                Log.v("BitmapEncoder", "Compressed with type: " + compressFormatD + " of size " + na3.g(bitmap) + " in " + cd1.a(jB) + ", options format: " + rx1Var.a(c) + ", hasAlpha: " + bitmap.hasAlpha());
            }
            pu0.d();
            return z;
        } catch (Throwable th3) {
            pu0.d();
            throw th3;
        }
    }
}
