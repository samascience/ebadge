package no.nordicsemi.android.support.v18.scanner;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes4.dex */
public final class ScanResult implements Parcelable {
    public static final Parcelable.Creator<ScanResult> CREATOR = new a();
    private final BluetoothDevice a;
    private n b;
    private final int c;
    private final long d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ScanResult createFromParcel(Parcel parcel) {
            return new ScanResult(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ScanResult[] newArray(int i) {
            return new ScanResult[i];
        }
    }

    /* synthetic */ ScanResult(Parcel parcel, a aVar) {
        this(parcel);
    }

    public BluetoothDevice a() {
        return this.a;
    }

    public int b() {
        return this.c;
    }

    public n c() {
        return this.b;
    }

    public long d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ScanResult.class != obj.getClass()) {
            return false;
        }
        ScanResult scanResult = (ScanResult) obj;
        return k.b(this.a, scanResult.a) && this.c == scanResult.c && k.b(this.b, scanResult.b) && this.d == scanResult.d && this.e == scanResult.e && this.f == scanResult.f && this.g == scanResult.g && this.h == scanResult.h && this.i == scanResult.i && this.j == scanResult.j;
    }

    public int hashCode() {
        return k.c(this.a, Integer.valueOf(this.c), this.b, Long.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(this.i), Integer.valueOf(this.j));
    }

    public String toString() {
        return "ScanResult{device=" + this.a + ", scanRecord=" + k.d(this.b) + ", rssi=" + this.c + ", timestampNanos=" + this.d + ", eventType=" + this.e + ", primaryPhy=" + this.f + ", secondaryPhy=" + this.g + ", advertisingSid=" + this.h + ", txPower=" + this.i + ", periodicAdvertisingInterval=" + this.j + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        this.a.writeToParcel(parcel, i);
        if (this.b != null) {
            parcel.writeInt(1);
            parcel.writeByteArray(this.b.b());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.c);
        parcel.writeLong(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
    }

    public ScanResult(BluetoothDevice bluetoothDevice, int i, int i2, int i3, int i4, int i5, int i6, int i7, n nVar, long j) {
        this.a = bluetoothDevice;
        this.e = i;
        this.f = i2;
        this.g = i3;
        this.h = i4;
        this.i = i5;
        this.c = i6;
        this.j = i7;
        this.b = nVar;
        this.d = j;
    }

    private ScanResult(Parcel parcel) {
        this.a = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
        if (parcel.readInt() == 1) {
            this.b = n.h(parcel.createByteArray());
        }
        this.c = parcel.readInt();
        this.d = parcel.readLong();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
    }
}
