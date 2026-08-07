package defpackage;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.collections.d;

/* JADX INFO: loaded from: classes4.dex */
public interface qc0 {
    public static final a a = a.a;
    public static final qc0 b = new a.C0165a();

    public static final class a {
        static final /* synthetic */ a a = new a();

        /* JADX INFO: renamed from: qc0$a$a, reason: collision with other inner class name */
        private static final class C0165a implements qc0 {
            @Override // defpackage.qc0
            public List a(String str) throws UnknownHostException {
                p31.f(str, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(str);
                    p31.e(allByName, "getAllByName(hostname)");
                    return d.D(allByName);
                } catch (NullPointerException e) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                    unknownHostException.initCause(e);
                    throw unknownHostException;
                }
            }
        }

        private a() {
        }
    }

    List a(String str);
}
