package com.baji.protocol.model;

import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import defpackage.vh0;
import kotlin.enums.a;

/* JADX INFO: loaded from: classes.dex */
public enum MediaManagementCommand {
    MEDIA_LIST_REQUEST((byte) 0),
    MEDIA_LIST_RESPONSE((byte) 1),
    MEDIA_DELETE((byte) 2),
    MEDIA_INFO_REQUEST((byte) 3),
    MEDIA_INFO_RESPONSE((byte) 4),
    MEDIA_PREVIEW_REQUEST((byte) 5),
    MEDIA_PREVIEW_RESPONSE((byte) 6),
    MEDIA_PREVIEW_PUSH_REQUEST((byte) 7),
    MEDIA_PREVIEW_PUSH_RESPONSE((byte) 8),
    MEDIA_BACKGROUND_REQUEST((byte) 9),
    MEDIA_BACKGROUND_RESPONSE((byte) 10),
    MEDIA_BACKGROUND_PUSH_REQUEST(AttrAndFunCode.SYS_INFO_ATTR_HIGH_AND_BASS),
    MEDIA_BACKGROUND_PUSH_RESPONSE(AttrAndFunCode.SYS_INFO_ATTR_EQ_PRESET_VALUE),
    MEDIA_ID_REQUEST(AttrAndFunCode.SYS_INFO_ATTR_CURRENT_NOISE_MODE),
    MEDIA_ID_RESPONSE(AttrAndFunCode.SYS_INFO_ATTR_ALL_NOISE_MODE),
    MEDIA_BATCH_PREVIEW_INFO_REQUEST(AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS),
    MEDIA_BATCH_PREVIEW_INFO_RESPONSE(AttrAndFunCode.SYS_INFO_ATTR_FIXED_LEN_DATA_FUN),
    MEDIA_BATCH_PREVIEW_DATA_REQUEST(AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD_EQ_FREQ),
    MEDIA_BATCH_PREVIEW_DATA_RESPONSE(AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD_EQ_GAIN);

    private static final /* synthetic */ vh0 $ENTRIES = a.a(values());
    private final byte value;

    MediaManagementCommand(byte b) {
        this.value = b;
    }

    public static vh0 getEntries() {
        return $ENTRIES;
    }

    public final byte getValue() {
        return this.value;
    }
}
