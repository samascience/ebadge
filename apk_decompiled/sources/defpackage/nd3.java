package defpackage;

import android.net.Uri;
import lombok.eclipse.Eclipse;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
public final class nd3 {
    private final Uri a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final String e;
    private final long f;
    private final long g;
    private final String h;
    private final boolean i;
    private final String j;
    private final long k;
    private final long l;
    private final boolean m;
    private final boolean n;
    private final String o;
    private final boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f362q;
    private final Long r;
    private final boolean s;
    private final String t;
    private final Long u;
    private final boolean v;

    public nd3(Uri uri, boolean z, boolean z2, boolean z3, String str, long j, long j2, String str2, boolean z4, String str3, long j3, long j4, boolean z5, boolean z6, String str4, boolean z7, boolean z8, Long l, boolean z9, String str5, Long l2, boolean z10) {
        this.a = uri;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = str;
        this.f = j;
        this.g = j2;
        this.h = str2;
        this.i = z4;
        this.j = str3;
        this.k = j3;
        this.l = j4;
        this.m = z5;
        this.n = z6;
        this.o = str4;
        this.p = z7;
        this.f362q = z8;
        this.r = l;
        this.s = z9;
        this.t = str5;
        this.u = l2;
        this.v = z10;
    }

    public final nd3 a(Uri uri, boolean z, boolean z2, boolean z3, String str, long j, long j2, String str2, boolean z4, String str3, long j3, long j4, boolean z5, boolean z6, String str4, boolean z7, boolean z8, Long l, boolean z9, String str5, Long l2, boolean z10) {
        return new nd3(uri, z, z2, z3, str, j, j2, str2, z4, str3, j3, j4, z5, z6, str4, z7, z8, l, z9, str5, l2, z10);
    }

    public final String c() {
        return this.o;
    }

    public final Long d() {
        return this.r;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof nd3)) {
            return false;
        }
        nd3 nd3Var = (nd3) obj;
        return p31.a(this.a, nd3Var.a) && this.b == nd3Var.b && this.c == nd3Var.c && this.d == nd3Var.d && p31.a(this.e, nd3Var.e) && this.f == nd3Var.f && this.g == nd3Var.g && p31.a(this.h, nd3Var.h) && this.i == nd3Var.i && p31.a(this.j, nd3Var.j) && this.k == nd3Var.k && this.l == nd3Var.l && this.m == nd3Var.m && this.n == nd3Var.n && p31.a(this.o, nd3Var.o) && this.p == nd3Var.p && this.f362q == nd3Var.f362q && p31.a(this.r, nd3Var.r) && this.s == nd3Var.s && p31.a(this.t, nd3Var.t) && p31.a(this.u, nd3Var.u) && this.v == nd3Var.v;
    }

    public final boolean f() {
        return this.b;
    }

    public final Uri g() {
        return this.a;
    }

    public final Long h() {
        return this.u;
    }

    public int hashCode() {
        Uri uri = this.a;
        int iHashCode = (((((((uri == null ? 0 : uri.hashCode()) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31;
        String str = this.e;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31;
        String str2 = this.h;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.i)) * 31;
        String str3 = this.j;
        int iHashCode4 = (((((((((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + Long.hashCode(this.k)) * 31) + Long.hashCode(this.l)) * 31) + Boolean.hashCode(this.m)) * 31) + Boolean.hashCode(this.n)) * 31;
        String str4 = this.o;
        int iHashCode5 = (((((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + Boolean.hashCode(this.p)) * 31) + Boolean.hashCode(this.f362q)) * 31;
        Long l = this.r;
        int iHashCode6 = (((iHashCode5 + (l == null ? 0 : l.hashCode())) * 31) + Boolean.hashCode(this.s)) * 31;
        String str5 = this.t;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Long l2 = this.u;
        return ((iHashCode7 + (l2 != null ? l2.hashCode() : 0)) * 31) + Boolean.hashCode(this.v);
    }

    public final boolean i() {
        return this.d;
    }

    public final String j() {
        return this.t;
    }

    public final String k() {
        return this.h;
    }

    public final boolean l() {
        return this.n;
    }

    public final boolean m() {
        return this.c;
    }

    public final boolean n() {
        return this.s;
    }

    public final boolean o() {
        return this.v;
    }

    public final boolean p() {
        return this.m;
    }

    public String toString() {
        return "VideoPushUiState(previewUri=" + this.a + ", hasPreview=" + this.b + ", isLoading=" + this.c + ", uploadSuccess=" + this.d + ", errorMessage=" + this.e + ", videoDuration=" + this.f + ", videoSize=" + this.g + ", videoPath=" + this.h + ", isVideoTrimmed=" + this.i + ", trimmedVideoPath=" + this.j + ", trimStartTime=" + this.k + ", trimEndTime=" + this.l + ", isVideoConverted=" + this.m + ", isGifConverted=" + this.n + ", convertedVideoPath=" + this.o + ", hasStoragePermission=" + this.p + ", hasCameraPermission=" + this.f362q + ", deviceFreeStorageBytes=" + this.r + ", isLoadingDeviceStorage=" + this.s + ", uploadVideoFilePath=" + this.t + ", trimmedVideoSizeBytes=" + this.u + ", isTrimmedVideoExceedsDeviceStorage=" + this.v + ")";
    }

    public /* synthetic */ nd3(Uri uri, boolean z, boolean z2, boolean z3, String str, long j, long j2, String str2, boolean z4, String str3, long j3, long j4, boolean z5, boolean z6, String str4, boolean z7, boolean z8, Long l, boolean z9, String str5, Long l2, boolean z10, int i, y70 y70Var) {
        this((i & 1) != 0 ? null : uri, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? null : str, (i & 32) != 0 ? 0L : j, (i & 64) != 0 ? 0L : j2, (i & 128) != 0 ? null : str2, (i & 256) != 0 ? false : z4, (i & 512) != 0 ? null : str3, (i & 1024) != 0 ? 0L : j3, (i & 2048) == 0 ? j4 : 0L, (i & 4096) != 0 ? false : z5, (i & 8192) != 0 ? false : z6, (i & 16384) != 0 ? null : str4, (i & 32768) != 0 ? false : z7, (i & 65536) != 0 ? false : z8, (i & Opcodes.ACC_DEPRECATED) != 0 ? null : l, (i & Opcodes.ASM4) != 0 ? false : z9, (i & Opcodes.ASM8) != 0 ? null : str5, (i & Eclipse.HasTypeAnnotations) != 0 ? null : l2, (i & 2097152) != 0 ? false : z10);
    }
}
