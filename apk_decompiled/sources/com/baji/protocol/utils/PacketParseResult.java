package com.baji.protocol.utils;

import com.baji.protocol.model.PacketHeader;
import defpackage.p31;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class PacketParseResult {
    private final CommandHeader commandHeader;
    private final PacketHeader packetHeader;
    private final byte[] payload;

    public PacketParseResult(PacketHeader packetHeader, CommandHeader commandHeader, byte[] bArr) {
        p31.f(packetHeader, "packetHeader");
        p31.f(commandHeader, "commandHeader");
        p31.f(bArr, "payload");
        this.packetHeader = packetHeader;
        this.commandHeader = commandHeader;
        this.payload = bArr;
    }

    public static /* synthetic */ PacketParseResult copy$default(PacketParseResult packetParseResult, PacketHeader packetHeader, CommandHeader commandHeader, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            packetHeader = packetParseResult.packetHeader;
        }
        if ((i & 2) != 0) {
            commandHeader = packetParseResult.commandHeader;
        }
        if ((i & 4) != 0) {
            bArr = packetParseResult.payload;
        }
        return packetParseResult.copy(packetHeader, commandHeader, bArr);
    }

    public final PacketHeader component1() {
        return this.packetHeader;
    }

    public final CommandHeader component2() {
        return this.commandHeader;
    }

    public final byte[] component3() {
        return this.payload;
    }

    public final PacketParseResult copy(PacketHeader packetHeader, CommandHeader commandHeader, byte[] bArr) {
        p31.f(packetHeader, "packetHeader");
        p31.f(commandHeader, "commandHeader");
        p31.f(bArr, "payload");
        return new PacketParseResult(packetHeader, commandHeader, bArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PacketParseResult)) {
            return false;
        }
        PacketParseResult packetParseResult = (PacketParseResult) obj;
        return p31.a(this.packetHeader, packetParseResult.packetHeader) && p31.a(this.commandHeader, packetParseResult.commandHeader) && p31.a(this.payload, packetParseResult.payload);
    }

    public final CommandHeader getCommandHeader() {
        return this.commandHeader;
    }

    public final PacketHeader getPacketHeader() {
        return this.packetHeader;
    }

    public final byte[] getPayload() {
        return this.payload;
    }

    public int hashCode() {
        return (((this.packetHeader.hashCode() * 31) + this.commandHeader.hashCode()) * 31) + Arrays.hashCode(this.payload);
    }

    public String toString() {
        return "PacketParseResult(packetHeader=" + this.packetHeader + ", commandHeader=" + this.commandHeader + ", payload=" + Arrays.toString(this.payload) + ')';
    }
}
