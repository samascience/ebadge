package defpackage;

import android.os.Build;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class j43 implements v92 {
    public static final List a = Arrays.asList("mi a1", "mi a2", "mi a2 lite", "redmi 4x", "redmi 5a", "redmi note 5", "redmi note 5 pro", "redmi 6 pro");

    static boolean f() {
        return a.contains(Build.MODEL.toLowerCase(Locale.US));
    }
}
