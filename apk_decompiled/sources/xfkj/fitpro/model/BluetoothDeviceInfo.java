package xfkj.fitpro.model;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.p31;
import defpackage.y70;
import no.nordicsemi.android.support.v18.scanner.ScanResult;

/* JADX INFO: loaded from: classes4.dex */
public final class BluetoothDeviceInfo implements Parcelable {
    private final String address;
    private final boolean isConnected;
    private final boolean isConnecting;
    private final long lastSeenTime;
    private final String name;
    private final int rssi;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<BluetoothDeviceInfo> CREATOR = new Creator();

    public static final class Companion {
        public /* synthetic */ Companion(y70 y70Var) {
            this();
        }

        public static /* synthetic */ BluetoothDeviceInfo fromBluetoothDevice$default(Companion companion, BluetoothDevice bluetoothDevice, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.fromBluetoothDevice(bluetoothDevice, i);
        }

        @SuppressLint({"MissingPermission"})
        public final BluetoothDeviceInfo fromBluetoothDevice(BluetoothDevice bluetoothDevice, int i) {
            p31.f(bluetoothDevice, "device");
            String address = bluetoothDevice.getAddress();
            p31.e(address, "getAddress(...)");
            String name = bluetoothDevice.getName();
            if (name == null) {
                name = "未知设备";
            }
            return new BluetoothDeviceInfo(address, name, i, false, false, System.currentTimeMillis(), 24, null);
        }

        @SuppressLint({"MissingPermission"})
        public final BluetoothDeviceInfo fromScanResult(ScanResult scanResult) {
            p31.f(scanResult, "scanResult");
            String address = scanResult.a().getAddress();
            p31.e(address, "getAddress(...)");
            String name = scanResult.a().getName();
            if (name == null) {
                name = "未知设备";
            }
            return new BluetoothDeviceInfo(address, name, scanResult.b(), false, false, System.currentTimeMillis(), 24, null);
        }

        private Companion() {
        }
    }

    public static final class Creator implements Parcelable.Creator<BluetoothDeviceInfo> {
        @Override // android.os.Parcelable.Creator
        public final BluetoothDeviceInfo createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            return new BluetoothDeviceInfo(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final BluetoothDeviceInfo[] newArray(int i) {
            return new BluetoothDeviceInfo[i];
        }
    }

    public BluetoothDeviceInfo(String str, String str2, int i, boolean z, boolean z2, long j) {
        p31.f(str, "address");
        this.address = str;
        this.name = str2;
        this.rssi = i;
        this.isConnected = z;
        this.isConnecting = z2;
        this.lastSeenTime = j;
    }

    public static /* synthetic */ BluetoothDeviceInfo copy$default(BluetoothDeviceInfo bluetoothDeviceInfo, String str, String str2, int i, boolean z, boolean z2, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bluetoothDeviceInfo.address;
        }
        if ((i2 & 2) != 0) {
            str2 = bluetoothDeviceInfo.name;
        }
        String str3 = str2;
        if ((i2 & 4) != 0) {
            i = bluetoothDeviceInfo.rssi;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            z = bluetoothDeviceInfo.isConnected;
        }
        boolean z3 = z;
        if ((i2 & 16) != 0) {
            z2 = bluetoothDeviceInfo.isConnecting;
        }
        boolean z4 = z2;
        if ((i2 & 32) != 0) {
            j = bluetoothDeviceInfo.lastSeenTime;
        }
        return bluetoothDeviceInfo.copy(str, str3, i3, z3, z4, j);
    }

    public final String component1() {
        return this.address;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.rssi;
    }

    public final boolean component4() {
        return this.isConnected;
    }

    public final boolean component5() {
        return this.isConnecting;
    }

    public final long component6() {
        return this.lastSeenTime;
    }

    public final BluetoothDeviceInfo copy(String str, String str2, int i, boolean z, boolean z2, long j) {
        p31.f(str, "address");
        return new BluetoothDeviceInfo(str, str2, i, z, z2, j);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BluetoothDeviceInfo)) {
            return false;
        }
        BluetoothDeviceInfo bluetoothDeviceInfo = (BluetoothDeviceInfo) obj;
        return p31.a(this.address, bluetoothDeviceInfo.address) && p31.a(this.name, bluetoothDeviceInfo.name) && this.rssi == bluetoothDeviceInfo.rssi && this.isConnected == bluetoothDeviceInfo.isConnected && this.isConnecting == bluetoothDeviceInfo.isConnecting && this.lastSeenTime == bluetoothDeviceInfo.lastSeenTime;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getDisplayName() {
        String str = this.name;
        return str == null ? "未知设备" : str;
    }

    public final long getLastSeenTime() {
        return this.lastSeenTime;
    }

    public final String getName() {
        return this.name;
    }

    public final int getRssi() {
        return this.rssi;
    }

    public final String getRssiDescription() {
        int i = this.rssi;
        if (i >= -50) {
            return "信号很强";
        }
        if (i >= -70) {
            return "信号良好";
        }
        return i >= -85 ? "信号一般" : "信号较弱";
    }

    public int hashCode() {
        int iHashCode = this.address.hashCode() * 31;
        String str = this.name;
        return ((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.rssi)) * 31) + Boolean.hashCode(this.isConnected)) * 31) + Boolean.hashCode(this.isConnecting)) * 31) + Long.hashCode(this.lastSeenTime);
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public final boolean isConnecting() {
        return this.isConnecting;
    }

    public final boolean isValidDevice() {
        return this.rssi > -100;
    }

    public String toString() {
        return "BluetoothDeviceInfo(address=" + this.address + ", name=" + this.name + ", rssi=" + this.rssi + ", isConnected=" + this.isConnected + ", isConnecting=" + this.isConnecting + ", lastSeenTime=" + this.lastSeenTime + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeString(this.address);
        parcel.writeString(this.name);
        parcel.writeInt(this.rssi);
        parcel.writeInt(this.isConnected ? 1 : 0);
        parcel.writeInt(this.isConnecting ? 1 : 0);
        parcel.writeLong(this.lastSeenTime);
    }

    public /* synthetic */ BluetoothDeviceInfo(String str, String str2, int i, boolean z, boolean z2, long j, int i2, y70 y70Var) {
        this(str, str2, i, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? System.currentTimeMillis() : j);
    }
}
