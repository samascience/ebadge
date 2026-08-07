package defpackage;

import com.tencent.open.SocialConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import xfkj.fitpro.ui.activities.debug.model.LogType;

/* JADX INFO: loaded from: classes4.dex */
public final class d92 {
    private final long a;
    private final LogType b;
    private final long c;
    private final String d;
    private final String e;
    private final String f;

    public d92(long j, LogType logType, long j2, String str, String str2, String str3) {
        p31.f(logType, SocialConstants.PARAM_TYPE);
        p31.f(str, "content");
        this.a = j;
        this.b = logType;
        this.c = j2;
        this.d = str;
        this.e = str2;
        this.f = str3;
    }

    public final String a() {
        return this.d;
    }

    public final String b() {
        return this.e;
    }

    public final String c() {
        String str = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault()).format(new Date(this.c));
        p31.e(str, "format(...)");
        return str;
    }

    public final String d() {
        return this.f;
    }

    public final LogType e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d92)) {
            return false;
        }
        d92 d92Var = (d92) obj;
        return this.a == d92Var.a && this.b == d92Var.b && this.c == d92Var.c && p31.a(this.d, d92Var.d) && p31.a(this.e, d92Var.e) && p31.a(this.f, d92Var.f);
    }

    public int hashCode() {
        int iHashCode = ((((((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode()) * 31;
        String str = this.e;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ProtocolLogItem(id=" + this.a + ", type=" + this.b + ", timestamp=" + this.c + ", content=" + this.d + ", details=" + this.e + ", hexData=" + this.f + ")";
    }

    public /* synthetic */ d92(long j, LogType logType, long j2, String str, String str2, String str3, int i, y70 y70Var) {
        this(j, logType, j2, str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3);
    }
}
