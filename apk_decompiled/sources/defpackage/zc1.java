package defpackage;

import com.arthenica.ffmpegkit.Level;

/* JADX INFO: loaded from: classes.dex */
public class zc1 {
    private final long a;
    private final Level b;
    private final String c;

    public zc1(long j, Level level, String str) {
        this.a = j;
        this.b = level;
        this.c = str;
    }

    public String a() {
        return this.c;
    }

    public String toString() {
        return "Log{sessionId=" + this.a + ", level=" + this.b + ", message='" + this.c + "'}";
    }
}
