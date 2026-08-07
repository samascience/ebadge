package defpackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes4.dex */
public class wp {
    private File a;
    private boolean b;

    public boolean a(String str, String str2, int i) {
        if (!ym0.c(str)) {
            return false;
        }
        String str3 = str + str2;
        if (i == 1) {
            str3 = str3 + ".txt";
        } else if (i == 2) {
            str3 = str3 + ".bmp";
        }
        File file = new File(str3);
        this.a = file;
        return ym0.d(file);
    }

    public boolean b() {
        return this.b;
    }

    public void c(String str) {
        if (ym0.i(this.a)) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.a, true);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, Charset.forName("gbk"));
                outputStreamWriter.write(d33.a() + ": " + str);
                outputStreamWriter.write("\n");
                outputStreamWriter.flush();
                outputStreamWriter.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void d(boolean z) {
        this.b = z;
    }
}
