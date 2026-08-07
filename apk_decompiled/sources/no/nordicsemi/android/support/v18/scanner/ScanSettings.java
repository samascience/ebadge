package no.nordicsemi.android.support.v18.scanner;

import android.os.Parcel;
import android.os.Parcelable;
import com.baji.protocol.model.ProtocolConstants;

/* JADX INFO: loaded from: classes4.dex */
public final class ScanSettings implements Parcelable {
    public static final Parcelable.Creator<ScanSettings> CREATOR = new a();
    private final long a;
    private final long b;
    private final int c;
    private final int d;
    private final long e;
    private final int f;
    private final int g;
    private final boolean h;
    private final boolean i;
    private boolean j;
    private final long k;
    private final long l;
    private final boolean m;
    private final int n;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ScanSettings createFromParcel(Parcel parcel) {
            return new ScanSettings(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ScanSettings[] newArray(int i) {
            return new ScanSettings[i];
        }
    }

    public static final class b {
        private int a = 0;
        private int b = 1;
        private long c = 0;
        private int d = 1;
        private int e = 3;
        private boolean f = true;
        private int g = 255;
        private boolean h = true;
        private boolean i = true;
        private boolean j = true;
        private long k = ProtocolConstants.CONNECTION_TIMEOUT_MS;
        private long l = ProtocolConstants.CONNECTION_TIMEOUT_MS;
        private long m = 0;
        private long n = 0;

        private boolean b(int i) {
            return i == 1 || i == 2 || i == 4 || i == 6;
        }

        private void n() {
            int i = this.a;
            if (i == 1) {
                this.n = 2000L;
                this.m = 3000L;
            } else if (i != 2) {
                this.n = 500L;
                this.m = 4500L;
            } else {
                this.n = 0L;
                this.m = 0L;
            }
        }

        public ScanSettings a() {
            if (this.m == 0 && this.n == 0) {
                n();
            }
            return new ScanSettings(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.n, this.m, null);
        }

        public b c(int i) {
            if (b(i)) {
                this.b = i;
                return this;
            }
            throw new IllegalArgumentException("invalid callback type - " + i);
        }

        public b d(boolean z) {
            this.f = z;
            return this;
        }

        public b e(int i) {
            if (i >= 1 && i <= 2) {
                this.d = i;
                return this;
            }
            throw new IllegalArgumentException("invalid matchMode " + i);
        }

        public b f(long j, long j2) {
            if (j <= 0 || j2 <= 0) {
                throw new IllegalArgumentException("maxDeviceAgeMillis and taskIntervalMillis must be > 0");
            }
            this.k = j;
            this.l = j2;
            return this;
        }

        public b g(int i) {
            if (i >= 1 && i <= 3) {
                this.e = i;
                return this;
            }
            throw new IllegalArgumentException("invalid numOfMatches " + i);
        }

        public b h(int i) {
            this.g = i;
            return this;
        }

        public b i(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("reportDelay must be > 0");
            }
            this.c = j;
            return this;
        }

        public b j(int i) {
            if (i >= -1 && i <= 2) {
                this.a = i;
                return this;
            }
            throw new IllegalArgumentException("invalid scan mode " + i);
        }

        public b k(boolean z) {
            this.i = z;
            return this;
        }

        public b l(boolean z) {
            this.j = z;
            return this;
        }

        public b m(boolean z) {
            this.h = z;
            return this;
        }
    }

    /* synthetic */ ScanSettings(int i, int i2, long j, int i3, int i4, boolean z, int i5, boolean z2, boolean z3, boolean z4, long j2, long j3, long j4, long j5, a aVar) {
        this(i, i2, j, i3, i4, z, i5, z2, z3, z4, j2, j3, j4, j5);
    }

    void a() {
        this.j = false;
    }

    public int b() {
        return this.d;
    }

    public boolean c() {
        return this.m;
    }

    public long d() {
        return this.k;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.l;
    }

    public int f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    public int h() {
        return this.n;
    }

    public long i() {
        return this.e;
    }

    public int j() {
        return this.c;
    }

    public boolean k() {
        return this.i;
    }

    public boolean l() {
        return this.j;
    }

    public boolean m() {
        return this.h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeLong(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.m ? 1 : 0);
        parcel.writeInt(this.n);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeLong(this.k);
        parcel.writeLong(this.l);
        parcel.writeLong(this.a);
        parcel.writeLong(this.b);
    }

    /* synthetic */ ScanSettings(Parcel parcel, a aVar) {
        this(parcel);
    }

    private ScanSettings(int i, int i2, long j, int i3, int i4, boolean z, int i5, boolean z2, boolean z3, boolean z4, long j2, long j3, long j4, long j5) {
        this.c = i;
        this.d = i2;
        this.e = j;
        this.g = i4;
        this.f = i3;
        this.m = z;
        this.n = i5;
        this.h = z2;
        this.i = z3;
        this.j = z4;
        this.k = 1000000 * j2;
        this.l = j3;
        this.a = j4;
        this.b = j5;
    }

    private ScanSettings(Parcel parcel) {
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readLong();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.m = parcel.readInt() != 0;
        this.n = parcel.readInt();
        this.h = parcel.readInt() == 1;
        this.i = parcel.readInt() == 1;
        this.k = parcel.readLong();
        this.l = parcel.readLong();
        this.a = parcel.readLong();
        this.b = parcel.readLong();
    }
}
