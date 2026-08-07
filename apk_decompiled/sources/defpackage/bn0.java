package defpackage;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class bn0 {
    private static final String a = "bn0";

    public static bj2 a(String str, int i) {
        return new bj2(str, i);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002c  */
    /* JADX WARN: Code duplicated, block: B:12:0x003a  */
    /* JADX WARN: Code duplicated, block: B:14:0x0045  */
    /* JADX WARN: Code duplicated, block: B:15:0x0048 A[PHI: r2
      0x0048: PHI (r2v10 ??) = (r2v13 ??), (r2v3 ??), (r2v14 ??) binds: [B:11:0x0038, B:13:0x0043, B:9:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:48:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.FileInputStream] */
    public static dj2 b(String str) throws Throwable {
        String[] strArrSplit;
        int length;
        ?? r2;
        String str2;
        ?? r3;
        FileInputStream fileInputStream;
        String str3;
        File file = new File(str);
        if (!file.exists()) {
            Log.e(a, "File doesn't exist!");
            return null;
        }
        if (file.getName().contains("res_")) {
            r2 = str3;
            strArrSplit = file.getName().split("_");
            length = strArrSplit.length;
            r2 = length;
            if (length >= 2) {
                r2 = 1;
                r3 = 1;
                if (strArrSplit[1].length() == 8) {
                    str2 = strArrSplit[1];
                } else {
                    r2 = str3;
                    str2 = null;
                    r3 = r2;
                }
            } else {
                r2 = str3;
                str2 = null;
                r3 = r2;
            }
        } else {
            str3 = "RES_";
            if (file.getName().contains("RES_")) {
                r2 = str3;
                strArrSplit = file.getName().split("_");
                length = strArrSplit.length;
                r2 = length;
                if (length >= 2) {
                    r2 = 1;
                    r3 = 1;
                    if (strArrSplit[1].length() == 8) {
                        str2 = strArrSplit[1];
                    } else {
                        r2 = str3;
                        str2 = null;
                        r3 = r2;
                    }
                } else {
                    r2 = str3;
                    str2 = null;
                    r3 = r2;
                }
            } else {
                r2 = str3;
                str2 = null;
                r3 = r2;
            }
        }
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    if (fileInputStream.getChannel().size() == 0) {
                        Log.d(a, "The FileInputStream has no content!");
                        try {
                            fileInputStream.close();
                        } catch (IOException unused) {
                        }
                        return null;
                    }
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    dj2 dj2Var = new dj2(bArr, str2);
                    try {
                        fileInputStream.close();
                        return dj2Var;
                    } catch (IOException unused2) {
                        return null;
                    }
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                if (r3 != 0) {
                    try {
                        r3.close();
                    } catch (IOException unused4) {
                        return null;
                    }
                }
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            r3 = 0;
            if (r3 != 0) {
                r3.close();
            }
            throw th;
        }
    }
}
