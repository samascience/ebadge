package defpackage;

import android.content.Context;
import android.os.Build;
import com.baidu.location.f;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
public class to3 {
    public static String f;
    public static String g;
    public static String h;
    public static String i;
    public String a;
    public String b;
    public String c;
    public String d;
    private boolean e;

    private static class a {
        public static final to3 a = new to3();
    }

    private to3() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        if (f.b() != null) {
            d(f.b());
        }
    }

    public static to3 a() {
        return a.a;
    }

    public String b(boolean z) {
        return c(z, null);
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:55:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:58:0x010b  */
    public String c(boolean z, String str) {
        String strSubstring;
        String str2;
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&sdk=");
        stringBuffer.append(9.293f);
        if (z) {
            if (fq3.d.equals("all")) {
                stringBuffer.append("&addr=allj2");
            }
            if (fq3.g) {
                stringBuffer.append("&adtp=n2");
            }
            if (fq3.f || fq3.i || fq3.j || fq3.h) {
                stringBuffer.append("&sema=");
                if (fq3.f) {
                    stringBuffer.append("aptag|");
                }
                if (fq3.h) {
                    stringBuffer.append("aptagd2|");
                }
                if (fq3.i) {
                    stringBuffer.append("poiregion|");
                }
                if (fq3.j) {
                    stringBuffer.append("regular");
                }
            }
        }
        if (z) {
            if (str == null) {
                str = "&coor=gcj02";
            } else {
                stringBuffer.append("&coor=");
            }
            stringBuffer.append(str);
            String strP0 = mp3.p0();
            if (strP0 != null) {
                stringBuffer.append(strP0);
            }
        }
        if (this.c != null) {
            stringBuffer.append("&cu=");
            stringBuffer.append(this.c);
            String str3 = this.a;
            str2 = (str3 == null || str3.equals("NULL") || this.c.contains(new StringBuffer(this.a).reverse().toString())) ? "&im=" : "&Aim=";
            if (this.b != null) {
                stringBuffer.append("&snd=");
                stringBuffer.append(this.b);
            }
            if (this.d != null) {
                stringBuffer.append("&Aid=");
                stringBuffer.append(this.d);
            }
            stringBuffer.append("&fw=");
            stringBuffer.append(f.a());
            stringBuffer.append("&lt=1");
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
            stringBuffer.append("&resid=");
            stringBuffer.append(Constants.VIA_REPORT_TYPE_SET_AVATAR);
            stringBuffer.append("&os=A");
            stringBuffer.append(Build.VERSION.SDK_INT);
            if (z) {
                stringBuffer.append("&sv=");
                strSubstring = Build.VERSION.RELEASE;
                if (strSubstring != null && strSubstring.length() > 6) {
                    strSubstring = strSubstring.substring(0, 6);
                }
                stringBuffer.append(strSubstring);
            }
            return stringBuffer.toString();
        }
        stringBuffer.append(str2);
        stringBuffer.append(this.a);
        if (this.b != null) {
            stringBuffer.append("&snd=");
            stringBuffer.append(this.b);
        }
        if (this.d != null) {
            stringBuffer.append("&Aid=");
            stringBuffer.append(this.d);
        }
        stringBuffer.append("&fw=");
        stringBuffer.append(f.a());
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&resid=");
        stringBuffer.append(Constants.VIA_REPORT_TYPE_SET_AVATAR);
        stringBuffer.append("&os=A");
        stringBuffer.append(Build.VERSION.SDK_INT);
        if (z) {
            stringBuffer.append("&sv=");
            strSubstring = Build.VERSION.RELEASE;
            if (strSubstring != null) {
                strSubstring = strSubstring.substring(0, 6);
            }
            stringBuffer.append(strSubstring);
        }
        return stringBuffer.toString();
    }

    public void d(Context context) {
        if (context == null || this.e) {
            return;
        }
        try {
            this.c = p91.w(context).v();
        } catch (Exception unused) {
            this.c = null;
        }
        try {
            f = context.getPackageName();
        } catch (Exception unused2) {
            f = null;
        }
        fq3.l = Constants.STR_EMPTY + this.c;
        this.e = true;
    }

    public void e(String str, String str2) {
        g = str;
        f = str2;
    }

    public String f() {
        String str;
        StringBuffer stringBuffer = new StringBuffer(200);
        if (this.c != null) {
            stringBuffer.append("&cu=");
            str = this.c;
        } else {
            stringBuffer.append("&im=");
            str = this.a;
        }
        stringBuffer.append(str);
        try {
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
        } catch (Exception unused) {
        }
        stringBuffer.append("&pack=");
        try {
            stringBuffer.append(f);
        } catch (Exception unused2) {
        }
        stringBuffer.append("&sdk=");
        stringBuffer.append(9.293f);
        return stringBuffer.toString();
    }
}
