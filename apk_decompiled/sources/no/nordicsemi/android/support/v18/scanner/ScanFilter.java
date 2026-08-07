package no.nordicsemi.android.support.v18.scanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes4.dex */
public final class ScanFilter implements Parcelable {
    private final String a;
    private final String b;
    private final ParcelUuid c;
    private final ParcelUuid d;
    private final ParcelUuid e;
    private final byte[] f;
    private final byte[] g;
    private final int h;
    private final byte[] i;
    private final byte[] j;
    private static final ScanFilter k = new b().a();
    public static final Parcelable.Creator<ScanFilter> CREATOR = new a();

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ScanFilter createFromParcel(Parcel parcel) {
            b bVar = new b();
            if (parcel.readInt() == 1) {
                bVar.c(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                bVar.b(parcel.readString());
            }
            if (parcel.readInt() == 1) {
                ParcelUuid parcelUuid = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                bVar.h(parcelUuid);
                if (parcel.readInt() == 1) {
                    bVar.i(parcelUuid, (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader()));
                }
            }
            if (parcel.readInt() == 1) {
                ParcelUuid parcelUuid2 = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                if (parcel.readInt() == 1) {
                    byte[] bArr = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr);
                    if (parcel.readInt() == 0) {
                        bVar.f(parcelUuid2, bArr);
                    } else {
                        byte[] bArr2 = new byte[parcel.readInt()];
                        parcel.readByteArray(bArr2);
                        bVar.g(parcelUuid2, bArr, bArr2);
                    }
                }
            }
            int i = parcel.readInt();
            if (parcel.readInt() == 1) {
                byte[] bArr3 = new byte[parcel.readInt()];
                parcel.readByteArray(bArr3);
                if (parcel.readInt() == 0) {
                    bVar.d(i, bArr3);
                } else {
                    byte[] bArr4 = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr4);
                    bVar.e(i, bArr3, bArr4);
                }
            }
            return bVar.a();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ScanFilter[] newArray(int i) {
            return new ScanFilter[i];
        }
    }

    public static final class b {
        private String a;
        private String b;
        private ParcelUuid c;
        private ParcelUuid d;
        private ParcelUuid e;
        private byte[] f;
        private byte[] g;
        private int h = -1;
        private byte[] i;
        private byte[] j;

        public ScanFilter a() {
            return new ScanFilter(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, null);
        }

        public b b(String str) {
            if (str == null || BluetoothAdapter.checkBluetoothAddress(str)) {
                this.b = str;
                return this;
            }
            throw new IllegalArgumentException("invalid device address " + str);
        }

        public b c(String str) {
            this.a = str;
            return this;
        }

        public b d(int i, byte[] bArr) {
            if (bArr != null && i < 0) {
                throw new IllegalArgumentException("invalid manufacture id");
            }
            this.h = i;
            this.i = bArr;
            this.j = null;
            return this;
        }

        public b e(int i, byte[] bArr, byte[] bArr2) {
            if (bArr != null && i < 0) {
                throw new IllegalArgumentException("invalid manufacture id");
            }
            if (bArr2 != null) {
                if (bArr == null) {
                    throw new IllegalArgumentException("manufacturerData is null while manufacturerDataMask is not null");
                }
                if (bArr.length != bArr2.length) {
                    throw new IllegalArgumentException("size mismatch for manufacturerData and manufacturerDataMask");
                }
            }
            this.h = i;
            this.i = bArr;
            this.j = bArr2;
            return this;
        }

        public b f(ParcelUuid parcelUuid, byte[] bArr) {
            if (parcelUuid == null) {
                throw new IllegalArgumentException("serviceDataUuid is null!");
            }
            this.e = parcelUuid;
            this.f = bArr;
            this.g = null;
            return this;
        }

        public b g(ParcelUuid parcelUuid, byte[] bArr, byte[] bArr2) {
            if (parcelUuid == null) {
                throw new IllegalArgumentException("serviceDataUuid is null");
            }
            if (bArr2 != null) {
                if (bArr == null) {
                    throw new IllegalArgumentException("serviceData is null while serviceDataMask is not null");
                }
                if (bArr.length != bArr2.length) {
                    throw new IllegalArgumentException("size mismatch for service data and service data mask");
                }
            }
            this.e = parcelUuid;
            this.f = bArr;
            this.g = bArr2;
            return this;
        }

        public b h(ParcelUuid parcelUuid) {
            this.c = parcelUuid;
            this.d = null;
            return this;
        }

        public b i(ParcelUuid parcelUuid, ParcelUuid parcelUuid2) {
            if (parcelUuid2 != null && parcelUuid == null) {
                throw new IllegalArgumentException("uuid is null while uuidMask is not null!");
            }
            this.c = parcelUuid;
            this.d = parcelUuid2;
            return this;
        }
    }

    /* synthetic */ ScanFilter(String str, String str2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, a aVar) {
        this(str, str2, parcelUuid, parcelUuid2, parcelUuid3, bArr, bArr2, i, bArr3, bArr4);
    }

    private boolean l(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            return bArr3 != null;
        }
        if (bArr3 == null || bArr3.length < bArr.length) {
            return false;
        }
        if (bArr2 == null) {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr3[i] != bArr[i]) {
                    return false;
                }
            }
            return true;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr2[i2];
            if ((bArr3[i2] & b2) != (b2 & bArr[i2])) {
                return false;
            }
        }
        return true;
    }

    private static boolean m(UUID uuid, UUID uuid2, UUID uuid3) {
        if (uuid2 == null) {
            return uuid.equals(uuid3);
        }
        if ((uuid.getLeastSignificantBits() & uuid2.getLeastSignificantBits()) != (uuid3.getLeastSignificantBits() & uuid2.getLeastSignificantBits())) {
            return false;
        }
        return (uuid.getMostSignificantBits() & uuid2.getMostSignificantBits()) == (uuid2.getMostSignificantBits() & uuid3.getMostSignificantBits());
    }

    private static boolean n(ParcelUuid parcelUuid, ParcelUuid parcelUuid2, List list) {
        if (parcelUuid == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (m(parcelUuid.getUuid(), parcelUuid2 == null ? null : parcelUuid2.getUuid(), ((ParcelUuid) it.next()).getUuid())) {
                return true;
            }
        }
        return false;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public byte[] c() {
        return this.i;
    }

    public byte[] d() {
        return this.j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ScanFilter.class != obj.getClass()) {
            return false;
        }
        ScanFilter scanFilter = (ScanFilter) obj;
        return k.b(this.a, scanFilter.a) && k.b(this.b, scanFilter.b) && this.h == scanFilter.h && k.a(this.i, scanFilter.i) && k.a(this.j, scanFilter.j) && k.b(this.e, scanFilter.e) && k.a(this.f, scanFilter.f) && k.a(this.g, scanFilter.g) && k.b(this.c, scanFilter.c) && k.b(this.d, scanFilter.d);
    }

    public byte[] f() {
        return this.f;
    }

    public byte[] g() {
        return this.g;
    }

    public ParcelUuid h() {
        return this.e;
    }

    public int hashCode() {
        return k.c(this.a, this.b, Integer.valueOf(this.h), Integer.valueOf(Arrays.hashCode(this.i)), Integer.valueOf(Arrays.hashCode(this.j)), this.e, Integer.valueOf(Arrays.hashCode(this.f)), Integer.valueOf(Arrays.hashCode(this.g)), this.c, this.d);
    }

    public ParcelUuid i() {
        return this.c;
    }

    public ParcelUuid j() {
        return this.d;
    }

    public boolean k(ScanResult scanResult) {
        if (scanResult == null) {
            return false;
        }
        BluetoothDevice bluetoothDeviceA = scanResult.a();
        String str = this.b;
        if (str != null && !str.equals(bluetoothDeviceA.getAddress())) {
            return false;
        }
        n nVarC = scanResult.c();
        if (nVarC == null && (this.a != null || this.c != null || this.i != null || this.f != null)) {
            return false;
        }
        String str2 = this.a;
        if (str2 != null && !str2.equals(nVarC.c())) {
            return false;
        }
        ParcelUuid parcelUuid = this.c;
        if (parcelUuid != null && !n(parcelUuid, this.d, nVarC.g())) {
            return false;
        }
        ParcelUuid parcelUuid2 = this.e;
        if (parcelUuid2 != null && nVarC != null && !l(this.f, this.g, nVarC.f(parcelUuid2))) {
            return false;
        }
        int i = this.h;
        return i < 0 || nVarC == null || l(this.i, this.j, nVarC.e(i));
    }

    public String toString() {
        return "BluetoothLeScanFilter [deviceName=" + this.a + ", deviceAddress=" + this.b + ", mUuid=" + this.c + ", uuidMask=" + this.d + ", serviceDataUuid=" + k.d(this.e) + ", serviceData=" + Arrays.toString(this.f) + ", serviceDataMask=" + Arrays.toString(this.g) + ", manufacturerId=" + this.h + ", manufacturerData=" + Arrays.toString(this.i) + ", manufacturerDataMask=" + Arrays.toString(this.j) + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a == null ? 0 : 1);
        String str = this.a;
        if (str != null) {
            parcel.writeString(str);
        }
        parcel.writeInt(this.b == null ? 0 : 1);
        String str2 = this.b;
        if (str2 != null) {
            parcel.writeString(str2);
        }
        parcel.writeInt(this.c == null ? 0 : 1);
        ParcelUuid parcelUuid = this.c;
        if (parcelUuid != null) {
            parcel.writeParcelable(parcelUuid, i);
            parcel.writeInt(this.d == null ? 0 : 1);
            ParcelUuid parcelUuid2 = this.d;
            if (parcelUuid2 != null) {
                parcel.writeParcelable(parcelUuid2, i);
            }
        }
        parcel.writeInt(this.e == null ? 0 : 1);
        ParcelUuid parcelUuid3 = this.e;
        if (parcelUuid3 != null) {
            parcel.writeParcelable(parcelUuid3, i);
            parcel.writeInt(this.f == null ? 0 : 1);
            byte[] bArr = this.f;
            if (bArr != null) {
                parcel.writeInt(bArr.length);
                parcel.writeByteArray(this.f);
                parcel.writeInt(this.g == null ? 0 : 1);
                byte[] bArr2 = this.g;
                if (bArr2 != null) {
                    parcel.writeInt(bArr2.length);
                    parcel.writeByteArray(this.g);
                }
            }
        }
        parcel.writeInt(this.h);
        parcel.writeInt(this.i == null ? 0 : 1);
        byte[] bArr3 = this.i;
        if (bArr3 != null) {
            parcel.writeInt(bArr3.length);
            parcel.writeByteArray(this.i);
            parcel.writeInt(this.j == null ? 0 : 1);
            byte[] bArr4 = this.j;
            if (bArr4 != null) {
                parcel.writeInt(bArr4.length);
                parcel.writeByteArray(this.j);
            }
        }
    }

    private ScanFilter(String str, String str2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4) {
        this.a = str;
        this.c = parcelUuid;
        this.d = parcelUuid2;
        this.b = str2;
        this.e = parcelUuid3;
        this.f = bArr;
        this.g = bArr2;
        this.h = i;
        this.i = bArr3;
        this.j = bArr4;
    }
}
