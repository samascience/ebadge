package com.baji.protocol.utils;

/* JADX INFO: loaded from: classes.dex */
public final class CommandHeader {
    private final byte commandId;
    private final byte moduleId;
    private final byte productId;
    private final byte protocolVersion;

    public CommandHeader(byte b, byte b2, byte b3, byte b4) {
        this.productId = b;
        this.protocolVersion = b2;
        this.moduleId = b3;
        this.commandId = b4;
    }

    public static /* synthetic */ CommandHeader copy$default(CommandHeader commandHeader, byte b, byte b2, byte b3, byte b4, int i, Object obj) {
        if ((i & 1) != 0) {
            b = commandHeader.productId;
        }
        if ((i & 2) != 0) {
            b2 = commandHeader.protocolVersion;
        }
        if ((i & 4) != 0) {
            b3 = commandHeader.moduleId;
        }
        if ((i & 8) != 0) {
            b4 = commandHeader.commandId;
        }
        return commandHeader.copy(b, b2, b3, b4);
    }

    public final byte component1() {
        return this.productId;
    }

    public final byte component2() {
        return this.protocolVersion;
    }

    public final byte component3() {
        return this.moduleId;
    }

    public final byte component4() {
        return this.commandId;
    }

    public final CommandHeader copy(byte b, byte b2, byte b3, byte b4) {
        return new CommandHeader(b, b2, b3, b4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommandHeader)) {
            return false;
        }
        CommandHeader commandHeader = (CommandHeader) obj;
        return this.productId == commandHeader.productId && this.protocolVersion == commandHeader.protocolVersion && this.moduleId == commandHeader.moduleId && this.commandId == commandHeader.commandId;
    }

    public final byte getCommandId() {
        return this.commandId;
    }

    public final byte getModuleId() {
        return this.moduleId;
    }

    public final byte getProductId() {
        return this.productId;
    }

    public final byte getProtocolVersion() {
        return this.protocolVersion;
    }

    public int hashCode() {
        return (((((Byte.hashCode(this.productId) * 31) + Byte.hashCode(this.protocolVersion)) * 31) + Byte.hashCode(this.moduleId)) * 31) + Byte.hashCode(this.commandId);
    }

    public String toString() {
        return "CommandHeader(productId=" + ((int) this.productId) + ", protocolVersion=" + ((int) this.protocolVersion) + ", moduleId=" + ((int) this.moduleId) + ", commandId=" + ((int) this.commandId) + ')';
    }
}
