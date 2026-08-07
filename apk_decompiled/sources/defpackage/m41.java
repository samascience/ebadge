package defpackage;

import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.FileUtils;

/* JADX INFO: loaded from: classes.dex */
public class m41 implements it2 {
    @Override // defpackage.it2
    public String a(StackTraceElement stackTraceElement) {
        return Constants.STR_EMPTY;
    }

    @Override // defpackage.it2
    public String b(StackTraceElement stackTraceElement, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append(stackTraceElement.getClassName());
        sb.append(FileUtils.FILE_EXTENSION_SEPARATOR);
        sb.append(stackTraceElement.getMethodName());
        if (stackTraceElement.isNativeMethod()) {
            sb.append(d());
        } else if (stackTraceElement.getFileName() == null || stackTraceElement.getFileName().length() <= 0) {
            sb.append(e());
        } else {
            sb.append("(");
            sb.append(stackTraceElement.getFileName());
            if (stackTraceElement.getLineNumber() >= 0) {
                sb.append(":");
                sb.append(stackTraceElement.getLineNumber());
            }
            sb.append(")");
        }
        if (z2) {
            sb.append(c(stackTraceElement));
        }
        return sb.toString();
    }

    @Override // defpackage.it2
    public String c(StackTraceElement stackTraceElement) {
        StringBuilder sb = new StringBuilder();
        String className = stackTraceElement.getClassName();
        Class clsA = mi0.b.a(className);
        if (clsA != null) {
            sb.append(b1.m(b1.l(clsA), b1.q(mi0.a, clsA, b1.n(className))));
        }
        return sb.toString();
    }

    public String d() {
        return "(Native Method)";
    }

    public String e() {
        return "(Unknown Source)";
    }
}
