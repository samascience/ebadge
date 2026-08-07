package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import pl.droidsonroids.relinker.MissingLibraryException;

/* JADX INFO: loaded from: classes4.dex */
public class j8 implements uc2.a {

    private static class a {
        public ZipFile a;
        public ZipEntry b;

        public a(ZipFile zipFile, ZipEntry zipEntry) {
            this.a = zipFile;
            this.b = zipEntry;
        }
    }

    private void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private long c(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                outputStream.flush();
                return j;
            }
            outputStream.write(bArr, 0, i);
            j += (long) i;
        }
    }

    private a d(Context context, String[] strArr, String str, vc2 vc2Var) {
        ZipFile zipFile = null;
        for (String str2 : e(context)) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i = i2;
                }
            }
            if (zipFile != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 1;
                    if (i3 >= 5) {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                            break;
                        }
                    }
                    for (String str3 : strArr) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("lib");
                        char c = File.separatorChar;
                        sb.append(c);
                        sb.append(str3);
                        sb.append(c);
                        sb.append(str);
                        String string = sb.toString();
                        vc2Var.i("Looking for %s in APK %s...", string, str2);
                        ZipEntry entry = zipFile.getEntry(string);
                        if (entry != null) {
                            return new a(zipFile, entry);
                        }
                    }
                    i3 = i4;
                }
            }
        }
        return null;
    }

    private String[] e(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }

    @Override // uc2.a
    public void a(Context context, String[] strArr, String str, File file, vc2 vc2Var) throws Throwable {
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        a aVar = null;
        Closeable closeable = null;
        try {
            a aVarD = d(context, strArr, str, vc2Var);
            try {
                if (aVarD == null) {
                    throw new MissingLibraryException(str);
                }
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (i >= 5) {
                        vc2Var.h("FATAL! Couldn't extract the library from the APK!");
                        try {
                            ZipFile zipFile = aVarD.a;
                            if (zipFile != null) {
                                zipFile.close();
                                return;
                            }
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    vc2Var.i("Found %s! Extracting...", str);
                    try {
                        if (file.exists() || file.createNewFile()) {
                            try {
                                inputStream = aVarD.a.getInputStream(aVarD.b);
                                try {
                                    fileOutputStream = new FileOutputStream(file);
                                    try {
                                        long jC = c(inputStream, fileOutputStream);
                                        fileOutputStream.getFD().sync();
                                        if (jC == file.length()) {
                                            b(inputStream);
                                            b(fileOutputStream);
                                            file.setReadable(true, false);
                                            file.setExecutable(true, false);
                                            file.setWritable(true);
                                            try {
                                                ZipFile zipFile2 = aVarD.a;
                                                if (zipFile2 != null) {
                                                    zipFile2.close();
                                                    return;
                                                }
                                                return;
                                            } catch (IOException unused2) {
                                                return;
                                            }
                                        }
                                        b(inputStream);
                                        b(fileOutputStream);
                                    } catch (FileNotFoundException unused3) {
                                        b(inputStream);
                                    } catch (IOException unused4) {
                                        b(inputStream);
                                    } catch (Throwable th) {
                                        th = th;
                                        closeable = inputStream;
                                        b(closeable);
                                        b(fileOutputStream);
                                        throw th;
                                    }
                                } catch (FileNotFoundException unused5) {
                                    fileOutputStream = null;
                                } catch (IOException unused6) {
                                    fileOutputStream = null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileOutputStream = null;
                                }
                            } catch (FileNotFoundException unused7) {
                                inputStream = null;
                                fileOutputStream = null;
                            } catch (IOException unused8) {
                                inputStream = null;
                                fileOutputStream = null;
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream = null;
                            }
                        }
                    } catch (IOException unused9) {
                    }
                    i = i2;
                }
            } catch (Throwable th4) {
                th = th4;
                aVar = aVarD;
                if (aVar != null) {
                    try {
                        ZipFile zipFile3 = aVar.a;
                        if (zipFile3 != null) {
                            zipFile3.close();
                        }
                    } catch (IOException unused10) {
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
