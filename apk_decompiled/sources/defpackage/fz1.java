package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class fz1 {
    private String a;
    private String b;
    private int c;
    private int d;
    private List e = new ArrayList();

    public fz1(String str, String str2, int i) {
        this.a = str;
        this.b = str2;
        this.d = i;
        this.c = str2.length() / 2;
        a(str2);
    }

    private void a(String str) {
        int i = this.d - 3;
        ArrayList arrayList = null;
        while (true) {
            int i2 = 0;
            do {
                if (i2 == 0) {
                    arrayList = new ArrayList();
                }
                int i3 = i * 2;
                if (str.length() <= i3) {
                    arrayList.add(str);
                    this.e.add(arrayList);
                    return;
                } else {
                    String strSubstring = str.substring(0, i3);
                    str = str.substring(i3, str.length());
                    arrayList.add(strSubstring);
                    i2++;
                }
            } while (arrayList.size() != 16);
            this.e.add(arrayList);
        }
    }

    public String b() {
        return this.a;
    }

    public List c() {
        return this.e;
    }

    public String d() {
        return this.b;
    }

    public int e() {
        return this.c;
    }
}
