package com.baji.protocol.model;

import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import defpackage.vh0;
import defpackage.y70;
import kotlin.enums.a;

/* JADX INFO: loaded from: classes.dex */
public enum ErrorCode {
    SUCCESS((byte) 0),
    INVALID_PACKET((byte) 1),
    UNSUPPORTED_COMMAND((byte) 2),
    INVALID_PARAMETER((byte) 3),
    FILE_NOT_FOUND((byte) 4),
    FILE_TOO_LARGE((byte) 5),
    INSUFFICIENT_STORAGE((byte) 6),
    TRANSFER_TIMEOUT((byte) 7),
    CHECKSUM_MISMATCH((byte) 8),
    DEVICE_BUSY((byte) 9),
    FILE_SIZE_MISMATCH((byte) 10),
    VERIFICATION_FAILED(AttrAndFunCode.SYS_INFO_ATTR_HIGH_AND_BASS),
    INVALID_PAYLOAD(AttrAndFunCode.SYS_INFO_ATTR_EQ_PRESET_VALUE),
    UNKNOWN_ERROR((byte) -1);

    private final byte value;
    private static final /* synthetic */ vh0 $ENTRIES = a.a(values());
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(y70 y70Var) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:10:0x001b  */
        /* JADX WARN: Code duplicated, block: B:14:? A[RETURN, SYNTHETIC] */
        public final ErrorCode fromValue(int i) {
            for (ErrorCode errorCode : ErrorCode.values()) {
                if ((errorCode.getValue() & 255) == (i & 255)) {
                    if (errorCode == null) {
                        return ErrorCode.UNKNOWN_ERROR;
                    }
                    return errorCode;
                }
            }
            errorCode = null;
            if (errorCode == null) {
                return ErrorCode.UNKNOWN_ERROR;
            }
            return errorCode;
        }

        private Companion() {
        }
    }

    ErrorCode(byte b) {
        this.value = b;
    }

    public static vh0 getEntries() {
        return $ENTRIES;
    }

    public final byte getValue() {
        return this.value;
    }
}
