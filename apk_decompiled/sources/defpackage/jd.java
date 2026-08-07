package defpackage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.location.Location;
import android.net.Uri;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
final class jd extends bi1.b {
    private final long a;
    private final long b;
    private final Location c;
    private final ContentResolver d;
    private final Uri e;
    private final ContentValues f;

    static final class b extends bi1.b.a {
        private Long a;
        private Long b;
        private Location c;
        private ContentResolver d;
        private Uri e;
        private ContentValues f;

        b() {
        }

        @Override // bi1.b.a
        bi1.b c() {
            Long l = this.a;
            String str = Constants.STR_EMPTY;
            if (l == null) {
                str = Constants.STR_EMPTY + " fileSizeLimit";
            }
            if (this.b == null) {
                str = str + " durationLimitMillis";
            }
            if (this.d == null) {
                str = str + " contentResolver";
            }
            if (this.e == null) {
                str = str + " collectionUri";
            }
            if (this.f == null) {
                str = str + " contentValues";
            }
            if (str.isEmpty()) {
                return new jd(this.a.longValue(), this.b.longValue(), this.c, this.d, this.e, this.f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // bi1.b.a
        bi1.b.a d(Uri uri) {
            if (uri == null) {
                throw new NullPointerException("Null collectionUri");
            }
            this.e = uri;
            return this;
        }

        @Override // bi1.b.a
        bi1.b.a e(ContentResolver contentResolver) {
            if (contentResolver == null) {
                throw new NullPointerException("Null contentResolver");
            }
            this.d = contentResolver;
            return this;
        }

        @Override // bi1.b.a
        bi1.b.a f(ContentValues contentValues) {
            if (contentValues == null) {
                throw new NullPointerException("Null contentValues");
            }
            this.f = contentValues;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // fy1.b.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public bi1.b.a a(long j) {
            this.b = Long.valueOf(j);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // fy1.b.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public bi1.b.a b(long j) {
            this.a = Long.valueOf(j);
            return this;
        }
    }

    @Override // fy1.b
    long a() {
        return this.b;
    }

    @Override // fy1.b
    long b() {
        return this.a;
    }

    @Override // fy1.b
    Location c() {
        return this.c;
    }

    @Override // bi1.b
    Uri d() {
        return this.e;
    }

    @Override // bi1.b
    ContentResolver e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        Location location;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bi1.b)) {
            return false;
        }
        bi1.b bVar = (bi1.b) obj;
        return this.a == bVar.b() && this.b == bVar.a() && ((location = this.c) != null ? location.equals(bVar.c()) : bVar.c() == null) && this.d.equals(bVar.e()) && this.e.equals(bVar.d()) && this.f.equals(bVar.f());
    }

    @Override // bi1.b
    ContentValues f() {
        return this.f;
    }

    public int hashCode() {
        long j = this.a;
        long j2 = this.b;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        Location location = this.c;
        return ((((((i ^ (location == null ? 0 : location.hashCode())) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode();
    }

    public String toString() {
        return "MediaStoreOutputOptionsInternal{fileSizeLimit=" + this.a + ", durationLimitMillis=" + this.b + ", location=" + this.c + ", contentResolver=" + this.d + ", collectionUri=" + this.e + ", contentValues=" + this.f + "}";
    }

    private jd(long j, long j2, Location location, ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
        this.a = j;
        this.b = j2;
        this.c = location;
        this.d = contentResolver;
        this.e = uri;
        this.f = contentValues;
    }
}
