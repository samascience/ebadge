package com.baji.protocol.model;

import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import defpackage.vh0;
import kotlin.enums.a;

/* JADX INFO: loaded from: classes.dex */
public enum FileTransferCommand {
    TRANSFER_START((byte) 0),
    TRANSFER_STOP((byte) 1),
    TRANSFER_ACK((byte) 2),
    TRANSFER_NACK((byte) 3),
    NEXT_CHUNK_REQUEST((byte) 4),
    RETRY_REQUEST((byte) 5),
    TRANSFER_COMPLETE((byte) 6),
    FILE_DATA((byte) 10),
    STATUS(AttrAndFunCode.SYS_INFO_ATTR_HIGH_AND_BASS),
    RECEIVED_CHECKSUM(AttrAndFunCode.SYS_INFO_ATTR_EQ_PRESET_VALUE),
    TOTAL_TRANSFERRED(AttrAndFunCode.SYS_INFO_ATTR_CURRENT_NOISE_MODE),
    VERIFICATION_RESULT(AttrAndFunCode.SYS_INFO_ATTR_ALL_NOISE_MODE);

    private static final /* synthetic */ vh0 $ENTRIES = a.a(values());
    private final byte value;

    FileTransferCommand(byte b) {
        this.value = b;
    }

    public static vh0 getEntries() {
        return $ENTRIES;
    }

    public final byte getValue() {
        return this.value;
    }
}
