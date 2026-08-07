package defpackage;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class x20 {
    private final f a;

    public static final class a {
        private final c a;

        public a(ClipData clipData, int i) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.a = new b(clipData, i);
            } else {
                this.a = new d(clipData, i);
            }
        }

        public x20 a() {
            return this.a.a();
        }

        public a b(Bundle bundle) {
            this.a.setExtras(bundle);
            return this;
        }

        public a c(int i) {
            this.a.setFlags(i);
            return this;
        }

        public a d(Uri uri) {
            this.a.b(uri);
            return this;
        }
    }

    private static final class b implements c {
        private final ContentInfo.Builder a;

        b(ClipData clipData, int i) {
            this.a = a30.a(clipData, i);
        }

        @Override // x20.c
        public x20 a() {
            return new x20(new e(this.a.build()));
        }

        @Override // x20.c
        public void b(Uri uri) {
            this.a.setLinkUri(uri);
        }

        @Override // x20.c
        public void setExtras(Bundle bundle) {
            this.a.setExtras(bundle);
        }

        @Override // x20.c
        public void setFlags(int i) {
            this.a.setFlags(i);
        }
    }

    private interface c {
        x20 a();

        void b(Uri uri);

        void setExtras(Bundle bundle);

        void setFlags(int i);
    }

    private static final class d implements c {
        ClipData a;
        int b;
        int c;
        Uri d;
        Bundle e;

        d(ClipData clipData, int i) {
            this.a = clipData;
            this.b = i;
        }

        @Override // x20.c
        public x20 a() {
            return new x20(new g(this));
        }

        @Override // x20.c
        public void b(Uri uri) {
            this.d = uri;
        }

        @Override // x20.c
        public void setExtras(Bundle bundle) {
            this.e = bundle;
        }

        @Override // x20.c
        public void setFlags(int i) {
            this.c = i;
        }
    }

    private static final class e implements f {
        private final ContentInfo a;

        e(ContentInfo contentInfo) {
            this.a = w20.a(b52.g(contentInfo));
        }

        @Override // x20.f
        public ClipData a() {
            return this.a.getClip();
        }

        @Override // x20.f
        public ContentInfo b() {
            return this.a;
        }

        @Override // x20.f
        public int c() {
            return this.a.getSource();
        }

        @Override // x20.f
        public int getFlags() {
            return this.a.getFlags();
        }

        public String toString() {
            return "ContentInfoCompat{" + this.a + "}";
        }
    }

    private interface f {
        ClipData a();

        ContentInfo b();

        int c();

        int getFlags();
    }

    private static final class g implements f {
        private final ClipData a;
        private final int b;
        private final int c;
        private final Uri d;
        private final Bundle e;

        g(d dVar) {
            this.a = (ClipData) b52.g(dVar.a);
            this.b = b52.c(dVar.b, 0, 5, SocialConstants.PARAM_SOURCE);
            this.c = b52.f(dVar.c, 1);
            this.d = dVar.d;
            this.e = dVar.e;
        }

        @Override // x20.f
        public ClipData a() {
            return this.a;
        }

        @Override // x20.f
        public ContentInfo b() {
            return null;
        }

        @Override // x20.f
        public int c() {
            return this.b;
        }

        @Override // x20.f
        public int getFlags() {
            return this.c;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.a.getDescription());
            sb.append(", source=");
            sb.append(x20.e(this.b));
            sb.append(", flags=");
            sb.append(x20.a(this.c));
            Uri uri = this.d;
            String str2 = Constants.STR_EMPTY;
            if (uri == null) {
                str = Constants.STR_EMPTY;
            } else {
                str = ", hasLinkUri(" + this.d.toString().length() + ")";
            }
            sb.append(str);
            if (this.e != null) {
                str2 = ", hasExtras";
            }
            sb.append(str2);
            sb.append("}");
            return sb.toString();
        }
    }

    x20(f fVar) {
        this.a = fVar;
    }

    static String a(int i) {
        return (i & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i);
    }

    static String e(int i) {
        if (i == 0) {
            return "SOURCE_APP";
        }
        if (i == 1) {
            return "SOURCE_CLIPBOARD";
        }
        if (i == 2) {
            return "SOURCE_INPUT_METHOD";
        }
        if (i == 3) {
            return "SOURCE_DRAG_AND_DROP";
        }
        if (i != 4) {
            return i != 5 ? String.valueOf(i) : "SOURCE_PROCESS_TEXT";
        }
        return "SOURCE_AUTOFILL";
    }

    public static x20 g(ContentInfo contentInfo) {
        return new x20(new e(contentInfo));
    }

    public ClipData b() {
        return this.a.a();
    }

    public int c() {
        return this.a.getFlags();
    }

    public int d() {
        return this.a.c();
    }

    public ContentInfo f() {
        ContentInfo contentInfoB = this.a.b();
        Objects.requireNonNull(contentInfoB);
        return w20.a(contentInfoB);
    }

    public String toString() {
        return this.a.toString();
    }
}
