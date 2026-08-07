package defpackage;

import com.tencent.connect.common.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class bj2 {
    private int a;
    private final String b;
    private final ArrayList c = new ArrayList();
    private final int d;

    public bj2(String str, int i) {
        this.b = str;
        this.d = i;
        a(str);
    }

    private void a(String str) {
        String strTrim;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(str)));
            String strSubstring = Constants.STR_EMPTY;
            loop0: while (true) {
                boolean z = false;
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break loop0;
                    }
                    strTrim = line.trim();
                    int i = Integer.parseInt(strTrim.substring(1, 3), 16);
                    if (!strTrim.substring(7, 9).equals("04")) {
                        if (!strTrim.substring(7, 9).equals("05") && !strTrim.substring(7, 9).equals("01")) {
                            if (!z) {
                                strSubstring = strSubstring + strTrim.substring(3, 7);
                                z = true;
                            }
                            stringBuffer.append(strTrim.substring(9, (i * 2) + 9));
                        }
                        this.c.add(new fz1(strSubstring, stringBuffer.toString(), this.d));
                        break loop0;
                    }
                    break;
                }
                if (stringBuffer.length() > 0) {
                    this.c.add(new fz1(strSubstring, stringBuffer.toString(), this.d));
                }
                strSubstring = strTrim.substring(9, 13);
                stringBuffer = new StringBuffer();
            }
        } catch (FileNotFoundException unused) {
            this.a = 100;
        } catch (IOException unused2) {
            this.a = 101;
        }
        this.a = 200;
    }

    public long b() {
        Iterator it = this.c.iterator();
        long jE = 0;
        while (it.hasNext()) {
            jE += (long) ((fz1) it.next()).e();
        }
        return jE;
    }

    public ArrayList c() {
        return this.c;
    }

    public String d() {
        return this.b;
    }
}
