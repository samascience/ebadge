package defpackage;

import com.tencent.open.SocialConstants;
import java.util.List;
import okhttp3.internal.http2.ErrorCode;

/* JADX INFO: loaded from: classes4.dex */
public interface j92 {
    public static final a a = a.a;
    public static final j92 b = new a.C0133a();

    public static final class a {
        static final /* synthetic */ a a = new a();

        /* JADX INFO: renamed from: j92$a$a, reason: collision with other inner class name */
        private static final class C0133a implements j92 {
            @Override // defpackage.j92
            public boolean a(int i, List list) {
                p31.f(list, "requestHeaders");
                return true;
            }

            @Override // defpackage.j92
            public boolean b(int i, List list, boolean z) {
                p31.f(list, "responseHeaders");
                return true;
            }

            @Override // defpackage.j92
            public boolean c(int i, so soVar, int i2, boolean z) {
                p31.f(soVar, SocialConstants.PARAM_SOURCE);
                soVar.a(i2);
                return true;
            }

            @Override // defpackage.j92
            public void d(int i, ErrorCode errorCode) {
                p31.f(errorCode, "errorCode");
            }
        }

        private a() {
        }
    }

    boolean a(int i, List list);

    boolean b(int i, List list, boolean z);

    boolean c(int i, so soVar, int i2, boolean z);

    void d(int i, ErrorCode errorCode);
}
