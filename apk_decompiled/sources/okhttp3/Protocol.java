package okhttp3;

import defpackage.p31;
import defpackage.y70;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");

    public static final a Companion = new a(null);
    private final String protocol;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final Protocol a(String str) throws IOException {
            p31.f(str, "protocol");
            Protocol protocol = Protocol.HTTP_1_0;
            if (!p31.a(str, protocol.protocol)) {
                protocol = Protocol.HTTP_1_1;
                if (!p31.a(str, protocol.protocol)) {
                    protocol = Protocol.H2_PRIOR_KNOWLEDGE;
                    if (!p31.a(str, protocol.protocol)) {
                        protocol = Protocol.HTTP_2;
                        if (!p31.a(str, protocol.protocol)) {
                            protocol = Protocol.SPDY_3;
                            if (!p31.a(str, protocol.protocol)) {
                                protocol = Protocol.QUIC;
                                if (!p31.a(str, protocol.protocol)) {
                                    throw new IOException("Unexpected protocol: " + str);
                                }
                            }
                        }
                    }
                }
            }
            return protocol;
        }

        private a() {
        }
    }

    Protocol(String str) {
        this.protocol = str;
    }

    public static final Protocol get(String str) throws IOException {
        return Companion.a(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
