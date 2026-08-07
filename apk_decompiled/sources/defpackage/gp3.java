package defpackage;

import android.content.Context;
import android.provider.Settings;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;

/* JADX INFO: loaded from: classes.dex */
abstract class gp3 {
    static String a(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    static String b(File file) throws Throwable {
        FileReader fileReader;
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader(file);
            try {
                try {
                    char[] cArr = new char[8192];
                    CharArrayWriter charArrayWriter = new CharArrayWriter();
                    while (true) {
                        int i = fileReader.read(cArr);
                        if (i <= 0) {
                            break;
                        }
                        charArrayWriter.write(cArr, 0, i);
                        th = th;
                        fileReader2 = fileReader;
                        if (fileReader2 != null) {
                            try {
                                fileReader2.close();
                            } catch (Exception e) {
                                c(e);
                            }
                        }
                        throw th;
                    }
                    String string = charArrayWriter.toString();
                    try {
                        fileReader.close();
                    } catch (Exception e2) {
                        c(e2);
                    }
                    return string;
                } catch (Exception e3) {
                    e = e3;
                    c(e);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e4) {
                            c(e4);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileReader2 = fileReader;
            }
        } catch (Exception e5) {
            e = e5;
            fileReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    static void c(Throwable th) {
    }
}
