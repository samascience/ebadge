package okhttp3;

import defpackage.yq0;
import java.security.cert.Certificate;
import java.util.List;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
final class Handshake$Companion$get$1 extends Lambda implements yq0 {
    final /* synthetic */ List<Certificate> $peerCertificatesCopy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    Handshake$Companion$get$1(List<? extends Certificate> list) {
        super(0);
        this.$peerCertificatesCopy = list;
    }

    @Override // defpackage.yq0
    public final List<Certificate> invoke() {
        return this.$peerCertificatesCopy;
    }
}
