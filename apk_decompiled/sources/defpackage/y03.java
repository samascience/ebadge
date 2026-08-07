package defpackage;

import java.util.Arrays;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class y03 {
    public static final String b(long j) {
        String str;
        if (j <= -999500000) {
            str = ((j - ((long) 500000000)) / ((long) 1000000000)) + " s ";
        } else if (j <= -999500) {
            str = ((j - ((long) 500000)) / ((long) 1000000)) + " ms";
        } else if (j <= 0) {
            str = ((j - ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j < 999500) {
            str = ((j + ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j < 999500000) {
            str = ((j + ((long) 500000)) / ((long) 1000000)) + " ms";
        } else {
            str = ((j + ((long) 500000000)) / ((long) 1000000000)) + " s ";
        }
        lv2 lv2Var = lv2.a;
        String str2 = String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
        p31.e(str2, "format(format, *args)");
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(t03 t03Var, a13 a13Var, String str) {
        Logger loggerA = b13.h.a();
        StringBuilder sb = new StringBuilder();
        sb.append(a13Var.f());
        sb.append(' ');
        lv2 lv2Var = lv2.a;
        String str2 = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        p31.e(str2, "format(format, *args)");
        sb.append(str2);
        sb.append(": ");
        sb.append(t03Var.b());
        loggerA.fine(sb.toString());
    }
}
