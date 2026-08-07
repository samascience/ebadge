package com.baji.protocol.utils;

import defpackage.p31;

/* JADX INFO: loaded from: classes.dex */
public final class PacketValidationResult {
    private final PacketValidationError errorCode;
    private final String errorMessage;
    private final boolean isValid;

    public PacketValidationResult(boolean z, PacketValidationError packetValidationError, String str) {
        p31.f(packetValidationError, "errorCode");
        p31.f(str, "errorMessage");
        this.isValid = z;
        this.errorCode = packetValidationError;
        this.errorMessage = str;
    }

    public static /* synthetic */ PacketValidationResult copy$default(PacketValidationResult packetValidationResult, boolean z, PacketValidationError packetValidationError, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = packetValidationResult.isValid;
        }
        if ((i & 2) != 0) {
            packetValidationError = packetValidationResult.errorCode;
        }
        if ((i & 4) != 0) {
            str = packetValidationResult.errorMessage;
        }
        return packetValidationResult.copy(z, packetValidationError, str);
    }

    public final boolean component1() {
        return this.isValid;
    }

    public final PacketValidationError component2() {
        return this.errorCode;
    }

    public final String component3() {
        return this.errorMessage;
    }

    public final PacketValidationResult copy(boolean z, PacketValidationError packetValidationError, String str) {
        p31.f(packetValidationError, "errorCode");
        p31.f(str, "errorMessage");
        return new PacketValidationResult(z, packetValidationError, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PacketValidationResult)) {
            return false;
        }
        PacketValidationResult packetValidationResult = (PacketValidationResult) obj;
        return this.isValid == packetValidationResult.isValid && this.errorCode == packetValidationResult.errorCode && p31.a(this.errorMessage, packetValidationResult.errorMessage);
    }

    public final PacketValidationError getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.isValid) * 31) + this.errorCode.hashCode()) * 31) + this.errorMessage.hashCode();
    }

    public final boolean isValid() {
        return this.isValid;
    }

    public String toString() {
        return "PacketValidationResult(isValid=" + this.isValid + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ')';
    }
}
