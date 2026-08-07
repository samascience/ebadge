package defpackage;

import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ni0 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String string = sb.toString();
        p31.e(string, "toString(...)");
        return string;
    }
}
