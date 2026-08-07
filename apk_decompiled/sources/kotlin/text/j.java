package kotlin.text;

import defpackage.ar0;
import defpackage.p31;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class j {
    public static void a(Appendable appendable, Object obj, ar0 ar0Var) throws IOException {
        p31.f(appendable, "<this>");
        if (ar0Var != null) {
            appendable.append((CharSequence) ar0Var.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            appendable.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            appendable.append(((Character) obj).charValue());
        } else {
            appendable.append(obj.toString());
        }
    }
}
