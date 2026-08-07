package defpackage;

import com.tencent.connect.common.Constants;
import java.net.ProtocolException;
import kotlin.text.i;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes4.dex */
public final class zt2 {
    public static final a d = new a(null);
    public final Protocol a;
    public final int b;
    public final String c;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final zt2 a(String str) throws ProtocolException {
            Protocol protocol;
            int i;
            String strSubstring;
            p31.f(str, "statusLine");
            if (i.G(str, "HTTP/1.", false, 2, null)) {
                i = 9;
                if (str.length() < 9 || str.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                int iCharAt = str.charAt(7) - '0';
                if (iCharAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else {
                    if (iCharAt != 1) {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                    protocol = Protocol.HTTP_1_1;
                }
            } else {
                if (!i.G(str, "ICY ", false, 2, null)) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                protocol = Protocol.HTTP_1_0;
                i = 4;
            }
            int i2 = i + 3;
            if (str.length() < i2) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            try {
                String strSubstring2 = str.substring(i, i2);
                p31.e(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                int i3 = Integer.parseInt(strSubstring2);
                if (str.length() <= i2) {
                    strSubstring = Constants.STR_EMPTY;
                } else {
                    if (str.charAt(i2) != ' ') {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                    strSubstring = str.substring(i + 4);
                    p31.e(strSubstring, "this as java.lang.String).substring(startIndex)");
                }
                return new zt2(protocol, i3, strSubstring);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        }

        private a() {
        }
    }

    public zt2(Protocol protocol, int i, String str) {
        p31.f(protocol, "protocol");
        p31.f(str, "message");
        this.a = protocol;
        this.b = i;
        this.c = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.a == Protocol.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.b);
        sb.append(' ');
        sb.append(this.c);
        String string = sb.toString();
        p31.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
