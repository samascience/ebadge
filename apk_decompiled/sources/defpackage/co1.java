package defpackage;

import android.content.Context;
import com.airbnb.lottie.network.FileExtension;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
class co1 {
    private final Context a;
    private final String b;

    co1(Context context, String str) {
        this.a = context.getApplicationContext();
        this.b = str;
    }

    private static String b(String str, FileExtension fileExtension, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", Constants.STR_EMPTY));
        sb.append(z ? fileExtension.extension : fileExtension.tempExtension());
        return sb.toString();
    }

    private File c(String str) {
        File file = new File(this.a.getCacheDir(), b(str, FileExtension.Json, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(this.a.getCacheDir(), b(str, FileExtension.Zip, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    az1 a() {
        try {
            File fileC = c(this.b);
            if (fileC == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileC);
            FileExtension fileExtension = fileC.getAbsolutePath().endsWith(".zip") ? FileExtension.Zip : FileExtension.Json;
            o91.b("Cache hit for " + this.b + " at " + fileC.getAbsolutePath());
            return new az1(fileExtension, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    void d(FileExtension fileExtension) {
        File file = new File(this.a.getCacheDir(), b(this.b, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", Constants.STR_EMPTY));
        boolean zRenameTo = file.renameTo(file2);
        o91.b("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        o91.d("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + FileUtils.FILE_EXTENSION_SEPARATOR);
    }

    File e(InputStream inputStream, FileExtension fileExtension) throws IOException {
        File file = new File(this.a.getCacheDir(), b(this.b, fileExtension, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        inputStream.close();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            inputStream.close();
            throw th2;
        }
    }
}
