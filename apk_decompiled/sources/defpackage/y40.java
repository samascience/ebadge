package defpackage;

import java.nio.charset.Charset;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class y40 {
    public static final y40 a = new y40();

    private y40() {
    }

    public static final String a(String str, String str2, Charset charset) {
        p31.f(str, "username");
        p31.f(str2, "password");
        p31.f(charset, "charset");
        return "Basic " + ByteString.Companion.c(str + ':' + str2, charset).base64();
    }
}
