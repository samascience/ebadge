package com.baji.protocol.model;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.p31;
import defpackage.y70;

/* JADX INFO: loaded from: classes.dex */
public final class PacketHeader implements Parcelable {
    public static final Parcelable.Creator<PacketHeader> CREATOR = new Creator();
    private final short dataLength;
    private final byte startMarker;

    public static final class Creator implements Parcelable.Creator<PacketHeader> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PacketHeader createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            return new PacketHeader(parcel.readByte(), (short) parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PacketHeader[] newArray(int i) {
            return new PacketHeader[i];
        }
    }

    public PacketHeader(byte b, short s) {
        this.startMarker = b;
        this.dataLength = s;
    }

    public static /* synthetic */ PacketHeader copy$default(PacketHeader packetHeader, byte b, short s, int i, Object obj) {
        if ((i & 1) != 0) {
            b = packetHeader.startMarker;
        }
        if ((i & 2) != 0) {
            s = packetHeader.dataLength;
        }
        return packetHeader.copy(b, s);
    }

    public final byte component1() {
        return this.startMarker;
    }

    public final short component2() {
        return this.dataLength;
    }

    public final PacketHeader copy(byte b, short s) {
        return new PacketHeader(b, s);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PacketHeader)) {
            return false;
        }
        PacketHeader packetHeader = (PacketHeader) obj;
        return this.startMarker == packetHeader.startMarker && this.dataLength == packetHeader.dataLength;
    }

    public final short getDataLength() {
        return this.dataLength;
    }

    public final byte getStartMarker() {
        return this.startMarker;
    }

    public int hashCode() {
        return (Byte.hashCode(this.startMarker) * 31) + Short.hashCode(this.dataLength);
    }

    public String toString() {
        return "PacketHeader(startMarker=" + ((int) this.startMarker) + ", dataLength=" + ((int) this.dataLength) + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        parcel.writeByte(this.startMarker);
        parcel.writeInt(this.dataLength);
    }

    public /* synthetic */ PacketHeader(byte b, short s, int i, y70 y70Var) {
        this((i & 1) != 0 ? ProtocolConstants.PACKET_START_MARKER : b, s);
    }
}
