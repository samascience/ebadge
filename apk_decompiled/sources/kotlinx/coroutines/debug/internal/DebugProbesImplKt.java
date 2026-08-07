package kotlinx.coroutines.debug.internal;

import com.fasterxml.jackson.core.JsonFactory;
import defpackage.p31;

/* JADX INFO: loaded from: classes4.dex */
public final class DebugProbesImplKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String repr(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\"') {
                sb.append("\\\"");
            } else if (cCharAt == '\\') {
                sb.append("\\\\");
            } else if (cCharAt == '\b') {
                sb.append("\\b");
            } else if (cCharAt == '\n') {
                sb.append("\\n");
            } else if (cCharAt == '\r') {
                sb.append("\\r");
            } else if (cCharAt == '\t') {
                sb.append("\\t");
            } else {
                sb.append(cCharAt);
            }
        }
        sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        String string = sb.toString();
        p31.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
