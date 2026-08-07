package defpackage;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class up2 implements vk1 {
    public static final String[] b = {"get", "orElse", "isPresent"};
    private final List a;

    public up2(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            this.a = Arrays.asList(b);
        } else {
            this.a = Arrays.asList(strArr);
        }
    }
}
