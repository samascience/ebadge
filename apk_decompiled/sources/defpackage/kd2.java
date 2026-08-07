package defpackage;

import com.tencent.open.SocialConstants;

/* JADX INFO: loaded from: classes4.dex */
public final class kd2 extends fh2 {
    private final String a;
    private final long b;
    private final so c;

    public kd2(String str, long j, so soVar) {
        p31.f(soVar, SocialConstants.PARAM_SOURCE);
        this.a = str;
        this.b = j;
        this.c = soVar;
    }

    @Override // defpackage.fh2
    public long contentLength() {
        return this.b;
    }

    @Override // defpackage.fh2
    public fi1 contentType() {
        String str = this.a;
        if (str != null) {
            return fi1.e.b(str);
        }
        return null;
    }

    @Override // defpackage.fh2
    public so source() {
        return this.c;
    }
}
