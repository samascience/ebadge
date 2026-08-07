package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;
import java.util.List;
import kotlin.collections.j;

/* JADX INFO: loaded from: classes4.dex */
public final class s22 {
    private final Bitmap a;
    private final Uri b;
    private final Bitmap c;
    private final List d;
    private final boolean e;
    private final String f;
    private final List g;
    private final aw2 h;
    private final aw2 i;
    private final Long j;
    private final boolean k;
    private final String l;
    private final Long m;
    private final boolean n;

    public s22(Bitmap bitmap, Uri uri, Bitmap bitmap2, List list, boolean z, String str, List list2, aw2 aw2Var, aw2 aw2Var2, Long l, boolean z2, String str2, Long l2, boolean z3) {
        p31.f(list, "styleGroups");
        p31.f(list2, "selectedStyles");
        this.a = bitmap;
        this.b = uri;
        this.c = bitmap2;
        this.d = list;
        this.e = z;
        this.f = str;
        this.g = list2;
        this.h = aw2Var;
        this.i = aw2Var2;
        this.j = l;
        this.k = z2;
        this.l = str2;
        this.m = l2;
        this.n = z3;
    }

    public final s22 a(Bitmap bitmap, Uri uri, Bitmap bitmap2, List list, boolean z, String str, List list2, aw2 aw2Var, aw2 aw2Var2, Long l, boolean z2, String str2, Long l2, boolean z3) {
        p31.f(list, "styleGroups");
        p31.f(list2, "selectedStyles");
        return new s22(bitmap, uri, bitmap2, list, z, str, list2, aw2Var, aw2Var2, l, z2, str2, l2, z3);
    }

    public final Long c() {
        return this.j;
    }

    public final String d() {
        return this.f;
    }

    public final Bitmap e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s22)) {
            return false;
        }
        s22 s22Var = (s22) obj;
        return p31.a(this.a, s22Var.a) && p31.a(this.b, s22Var.b) && p31.a(this.c, s22Var.c) && p31.a(this.d, s22Var.d) && this.e == s22Var.e && p31.a(this.f, s22Var.f) && p31.a(this.g, s22Var.g) && p31.a(this.h, s22Var.h) && p31.a(this.i, s22Var.i) && p31.a(this.j, s22Var.j) && this.k == s22Var.k && p31.a(this.l, s22Var.l) && p31.a(this.m, s22Var.m) && this.n == s22Var.n;
    }

    public final Uri f() {
        return this.b;
    }

    public final aw2 g() {
        return this.h;
    }

    public final Long h() {
        return this.m;
    }

    public int hashCode() {
        Bitmap bitmap = this.a;
        int iHashCode = (bitmap == null ? 0 : bitmap.hashCode()) * 31;
        Uri uri = this.b;
        int iHashCode2 = (iHashCode + (uri == null ? 0 : uri.hashCode())) * 31;
        Bitmap bitmap2 = this.c;
        int iHashCode3 = (((((iHashCode2 + (bitmap2 == null ? 0 : bitmap2.hashCode())) * 31) + this.d.hashCode()) * 31) + Boolean.hashCode(this.e)) * 31;
        String str = this.f;
        int iHashCode4 = (((iHashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.g.hashCode()) * 31;
        aw2 aw2Var = this.h;
        int iHashCode5 = (iHashCode4 + (aw2Var == null ? 0 : aw2Var.hashCode())) * 31;
        aw2 aw2Var2 = this.i;
        int iHashCode6 = (iHashCode5 + (aw2Var2 == null ? 0 : aw2Var2.hashCode())) * 31;
        Long l = this.j;
        int iHashCode7 = (((iHashCode6 + (l == null ? 0 : l.hashCode())) * 31) + Boolean.hashCode(this.k)) * 31;
        String str2 = this.l;
        int iHashCode8 = (iHashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l2 = this.m;
        return ((iHashCode8 + (l2 != null ? l2.hashCode() : 0)) * 31) + Boolean.hashCode(this.n);
    }

    public final aw2 i() {
        return this.i;
    }

    public final List j() {
        return this.g;
    }

    public final List k() {
        return this.d;
    }

    public final String l() {
        return this.l;
    }

    public final boolean m() {
        return this.n;
    }

    public final boolean n() {
        return this.e;
    }

    public final boolean o() {
        return this.k;
    }

    public String toString() {
        return "PicturePushUiState(previewImage=" + this.a + ", previewImageUri=" + this.b + ", compositePreviewImage=" + this.c + ", styleGroups=" + this.d + ", isLoading=" + this.e + ", errorMessage=" + this.f + ", selectedStyles=" + this.g + ", selectedBorderStyle=" + this.h + ", selectedStickerStyle=" + this.i + ", deviceFreeStorageBytes=" + this.j + ", isLoadingDeviceStorage=" + this.k + ", uploadImageFilePath=" + this.l + ", selectedImageSizeBytes=" + this.m + ", isImageExceedsDeviceStorage=" + this.n + ")";
    }

    public /* synthetic */ s22(Bitmap bitmap, Uri uri, Bitmap bitmap2, List list, boolean z, String str, List list2, aw2 aw2Var, aw2 aw2Var2, Long l, boolean z2, String str2, Long l2, boolean z3, int i, y70 y70Var) {
        this((i & 1) != 0 ? null : bitmap, (i & 2) != 0 ? null : uri, (i & 4) != 0 ? null : bitmap2, (i & 8) != 0 ? j.j() : list, (i & 16) != 0 ? false : z, (i & 32) != 0 ? null : str, (i & 64) != 0 ? j.j() : list2, (i & 128) != 0 ? null : aw2Var, (i & 256) != 0 ? null : aw2Var2, (i & 512) != 0 ? null : l, (i & 1024) != 0 ? false : z2, (i & 2048) != 0 ? null : str2, (i & 4096) == 0 ? l2 : null, (i & 8192) == 0 ? z3 : false);
    }
}
