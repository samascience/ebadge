package xfkj.fitpro.utils;

import android.content.Context;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.p31;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class JpegRulesChecker {
    public static final JpegRulesChecker a = new JpegRulesChecker();

    public static final class a {
        private final int a;
        private final boolean b;
        private final int c;
        private final int d;
        private final int e;
        private final int f;
        private final int g;
        private final int h;
        private final int i;
        private final boolean j;
        private final boolean k;
        private final boolean[] l;

        public a(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z2, boolean z3, boolean[] zArr) {
            p31.f(zArr, "passedRules");
            this.a = i;
            this.b = z;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
            this.h = i7;
            this.i = i8;
            this.j = z2;
            this.k = z3;
            this.l = zArr;
        }

        public final boolean a() {
            return this.b;
        }

        public final int b() {
            return this.i;
        }

        public final int c() {
            return this.a;
        }

        public final int d() {
            return this.g;
        }

        public final int e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e && this.f == aVar.f && this.g == aVar.g && this.h == aVar.h && this.i == aVar.i && this.j == aVar.j && this.k == aVar.k && p31.a(this.l, aVar.l);
        }

        public final int f() {
            return this.f;
        }

        public final int g() {
            return this.e;
        }

        public final boolean[] h() {
            return this.l;
        }

        public int hashCode() {
            return (((((((((((((((((((((Integer.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + Integer.hashCode(this.i)) * 31) + Boolean.hashCode(this.j)) * 31) + Boolean.hashCode(this.k)) * 31) + Arrays.hashCode(this.l);
        }

        public final int i() {
            return this.h;
        }

        public final int j() {
            return this.c;
        }

        public String toString() {
            return "CheckResult(code=" + this.a + ", allPassed=" + this.b + ", width=" + this.c + ", height=" + this.d + ", mcuW=" + this.e + ", mcuH=" + this.f + ", dqtCount=" + this.g + ", restartCount=" + this.h + ", badFfCount=" + this.i + ", isProgressive=" + this.j + ", isJfif=" + this.k + ", passedRules=" + Arrays.toString(this.l) + ")";
        }
    }

    static {
        System.loadLibrary("bmp-lib");
    }

    private JpegRulesChecker() {
    }

    private final String a(Context context, a aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getString(R.string.jpeg_check_failed_header));
        if (aVar.j() > 0 && aVar.e() > 0) {
            sb.append('\n');
            sb.append(context.getString(R.string.jpeg_check_image_info, Integer.valueOf(aVar.j()), Integer.valueOf(aVar.e())));
        }
        if (!aVar.h()[0]) {
            sb.append('\n');
            sb.append((char) 8226);
            sb.append(' ');
            sb.append(context.getString(R.string.jpeg_rule_baseline_failed));
        }
        if (!aVar.h()[1]) {
            sb.append('\n');
            sb.append((char) 8226);
            sb.append(' ');
            sb.append(context.getString(R.string.jpeg_rule_jfif_failed));
        }
        if (!aVar.h()[2]) {
            sb.append('\n');
            sb.append((char) 8226);
            sb.append(' ');
            sb.append(context.getString(R.string.jpeg_rule_mcu_failed, Integer.valueOf(aVar.j()), Integer.valueOf(aVar.e()), Integer.valueOf(aVar.g()), Integer.valueOf(aVar.f())));
        }
        if (!aVar.h()[3]) {
            sb.append('\n');
            sb.append((char) 8226);
            sb.append(' ');
            sb.append(context.getString(R.string.jpeg_rule_dqt_failed, Integer.valueOf(aVar.d())));
        }
        if (!aVar.h()[4]) {
            sb.append('\n');
            sb.append((char) 8226);
            sb.append(' ');
            sb.append(context.getString(R.string.jpeg_rule_restart_failed, Integer.valueOf(aVar.i())));
        }
        if (!aVar.h()[5]) {
            sb.append('\n');
            sb.append((char) 8226);
            sb.append(' ');
            sb.append(context.getString(R.string.jpeg_rule_extra_ff_failed, Integer.valueOf(aVar.b())));
        }
        String string = sb.toString();
        p31.e(string, "toString(...)");
        return string;
    }

    private static final native long[] nativeCheckFromFile(String str);

    public final a b(String str) {
        p31.f(str, "path");
        long[] jArrNativeCheckFromFile = nativeCheckFromFile(str);
        if (jArrNativeCheckFromFile.length != 17) {
            throw new IllegalArgumentException(("Unexpected native result size: " + jArrNativeCheckFromFile.length).toString());
        }
        int i = (int) jArrNativeCheckFromFile[0];
        boolean z = jArrNativeCheckFromFile[1] == 1;
        int i2 = (int) jArrNativeCheckFromFile[2];
        int i3 = (int) jArrNativeCheckFromFile[3];
        int i4 = (int) jArrNativeCheckFromFile[4];
        int i5 = (int) jArrNativeCheckFromFile[5];
        int i6 = (int) jArrNativeCheckFromFile[6];
        int i7 = (int) jArrNativeCheckFromFile[7];
        int i8 = (int) jArrNativeCheckFromFile[8];
        boolean z2 = jArrNativeCheckFromFile[9] == 1;
        boolean z3 = jArrNativeCheckFromFile[10] == 1;
        boolean[] zArr = new boolean[6];
        for (int i9 = 0; i9 < 6; i9++) {
            zArr[i9] = jArrNativeCheckFromFile[i9 + 11] == 1;
        }
        return new a(i, z, i2, i3, i4, i5, i6, i7, i8, z2, z3, zArr);
    }

    public final String c(Context context, a aVar) {
        p31.f(context, "context");
        p31.f(aVar, "result");
        int iC = aVar.c();
        if (iC == -3) {
            return context.getString(R.string.jpeg_check_file_read_failed);
        }
        if (iC == -2) {
            return context.getString(R.string.jpeg_check_invalid_jpeg);
        }
        if (iC == -1) {
            return context.getString(R.string.jpeg_check_invalid_param);
        }
        if (iC != 0) {
            return context.getString(R.string.jpeg_check_unknown_error, Integer.valueOf(aVar.c()));
        }
        if (aVar.a()) {
            return null;
        }
        return a(context, aVar);
    }

    public final String d(Context context, String str) {
        p31.f(context, "context");
        p31.f(str, "path");
        return c(context, b(str));
    }
}
