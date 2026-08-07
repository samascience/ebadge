package defpackage;

import android.content.Context;
import android.net.Uri;
import xfkj.fitpro.ui.activities.device.electronicBadgeDevice.model.VideoInfo;

/* JADX INFO: loaded from: classes4.dex */
public abstract class md3 {

    public static final class a extends md3 {
        public static final a a = new a();

        private a() {
            super(null);
        }
    }

    public static final class b extends md3 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(null);
            p31.f(str, "permission");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && p31.a(this.a, ((b) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "RequestPermission(permission=" + this.a + ")";
        }
    }

    public static final class c extends md3 {
        public static final c a = new c();

        private c() {
            super(null);
        }
    }

    public static final class d extends md3 {
        public static final d a = new d();

        private d() {
            super(null);
        }
    }

    public static final class e extends md3 {
        private final Uri a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Uri uri) {
            super(null);
            p31.f(uri, "uri");
            this.a = uri;
        }

        public final Uri a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof e) && p31.a(this.a, ((e) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "SetPreviewUri(uri=" + this.a + ")";
        }
    }

    public static final class f extends md3 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str) {
            super(null);
            p31.f(str, "message");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof f) && p31.a(this.a, ((f) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "ShowError(message=" + this.a + ")";
        }
    }

    public static final class g extends md3 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str) {
            super(null);
            p31.f(str, "errorMessage");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof g) && p31.a(this.a, ((g) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "ShowUploadErrorDialog(errorMessage=" + this.a + ")";
        }
    }

    public static final class h extends md3 {
        private final String a;
        private final int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, int i) {
            super(null);
            p31.f(str, "message");
            this.a = str;
            this.b = i;
        }

        public final String a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return p31.a(this.a, hVar.a) && this.b == hVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
        }

        public String toString() {
            return "ShowUploadProgress(message=" + this.a + ", progress=" + this.b + ")";
        }
    }

    public static final class i extends md3 {
        public static final i a = new i();

        private i() {
            super(null);
        }
    }

    public static final class j extends md3 {
        public static final j a = new j();

        private j() {
            super(null);
        }
    }

    public static final class k extends md3 {
        private final VideoInfo a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(VideoInfo videoInfo) {
            super(null);
            p31.f(videoInfo, "videoInfo");
            this.a = videoInfo;
        }

        public final VideoInfo a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof k) && p31.a(this.a, ((k) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "StartVideoCut(videoInfo=" + this.a + ")";
        }
    }

    public static final class l extends md3 {
        public static final l a = new l();

        private l() {
            super(null);
        }
    }

    public static final class m extends md3 {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(String str) {
            super(null);
            p31.f(str, "errorMessage");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof m) && p31.a(this.a, ((m) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "UploadFailed(errorMessage=" + this.a + ")";
        }
    }

    public static final class n extends md3 {
        private final int a;
        private final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(int i, String str) {
            super(null);
            p31.f(str, "message");
            this.a = i;
            this.b = str;
        }

        public final String a() {
            return this.b;
        }

        public final int b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof n)) {
                return false;
            }
            n nVar = (n) obj;
            return this.a == nVar.a && p31.a(this.b, nVar.b);
        }

        public int hashCode() {
            return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
        }

        public String toString() {
            return "UploadProgress(progress=" + this.a + ", message=" + this.b + ")";
        }
    }

    public static final class o extends md3 {
        public static final o a = new o();

        private o() {
            super(null);
        }
    }

    public static final class p extends md3 {
        private final Context a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(Context context) {
            super(null);
            p31.f(context, "context");
            this.a = context;
        }

        public final Context a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof p) && p31.a(this.a, ((p) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "UploadVideo(context=" + this.a + ")";
        }
    }

    public /* synthetic */ md3(y70 y70Var) {
        this();
    }

    private md3() {
    }
}
