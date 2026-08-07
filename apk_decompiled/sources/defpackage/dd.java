package defpackage;

import android.location.Location;
import com.tencent.connect.common.Constants;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
final class dd extends sm0.b {
    private final long a;
    private final long b;
    private final Location c;
    private final File d;

    static final class b extends sm0.b.a {
        private Long a;
        private Long b;
        private Location c;
        private File d;

        b() {
        }

        @Override // sm0.b.a
        sm0.b c() {
            Long l = this.a;
            String str = Constants.STR_EMPTY;
            if (l == null) {
                str = Constants.STR_EMPTY + " fileSizeLimit";
            }
            if (this.b == null) {
                str = str + " durationLimitMillis";
            }
            if (this.d == null) {
                str = str + " file";
            }
            if (str.isEmpty()) {
                return new dd(this.a.longValue(), this.b.longValue(), this.c, this.d);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // sm0.b.a
        sm0.b.a d(File file) {
            if (file == null) {
                throw new NullPointerException("Null file");
            }
            this.d = file;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // fy1.b.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public sm0.b.a a(long j) {
            this.b = Long.valueOf(j);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // fy1.b.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public sm0.b.a b(long j) {
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

    @Override // sm0.b
    File d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        Location location;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof sm0.b)) {
            return false;
        }
        sm0.b bVar = (sm0.b) obj;
        return this.a == bVar.b() && this.b == bVar.a() && ((location = this.c) != null ? location.equals(bVar.c()) : bVar.c() == null) && this.d.equals(bVar.d());
    }

    public int hashCode() {
        long j = this.a;
        long j2 = this.b;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        Location location = this.c;
        return ((i ^ (location == null ? 0 : location.hashCode())) * 1000003) ^ this.d.hashCode();
    }

    public String toString() {
        return "FileOutputOptionsInternal{fileSizeLimit=" + this.a + ", durationLimitMillis=" + this.b + ", location=" + this.c + ", file=" + this.d + "}";
    }

    private dd(long j, long j2, Location location, File file) {
        this.a = j;
        this.b = j2;
        this.c = location;
        this.d = file;
    }
}
