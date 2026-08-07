package defpackage;

import androidx.work.b;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class s21 {
    private static final String a = fd1.f("InputMerger");

    public static s21 a(String str) {
        try {
            return (s21) Class.forName(str).newInstance();
        } catch (Exception e) {
            fd1.c().b(a, "Trouble instantiating + " + str, e);
            return null;
        }
    }

    public abstract b b(List list);
}
