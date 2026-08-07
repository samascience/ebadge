package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonGenerator;
import defpackage.hp0;

/* JADX INFO: loaded from: classes.dex */
public enum JsonWriteFeature implements hp0 {
    QUOTE_FIELD_NAMES(true, JsonGenerator.Feature.QUOTE_FIELD_NAMES),
    WRITE_NAN_AS_STRINGS(true, JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS),
    WRITE_NUMBERS_AS_STRINGS(false, JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS),
    ESCAPE_NON_ASCII(false, JsonGenerator.Feature.ESCAPE_NON_ASCII),
    WRITE_HEX_UPPER_CASE(true, JsonGenerator.Feature.WRITE_HEX_UPPER_CASE);

    private final boolean _defaultState;
    private final JsonGenerator.Feature _mappedFeature;
    private final int _mask = 1 << ordinal();

    JsonWriteFeature(boolean z, JsonGenerator.Feature feature) {
        this._defaultState = z;
        this._mappedFeature = feature;
    }

    public static int collectDefaults() {
        int mask = 0;
        for (JsonWriteFeature jsonWriteFeature : values()) {
            if (jsonWriteFeature.enabledByDefault()) {
                mask |= jsonWriteFeature.getMask();
            }
        }
        return mask;
    }

    @Override // defpackage.c41
    public boolean enabledByDefault() {
        return this._defaultState;
    }

    @Override // defpackage.c41
    public boolean enabledIn(int i) {
        return (i & this._mask) != 0;
    }

    @Override // defpackage.hp0, defpackage.c41
    public int getMask() {
        return this._mask;
    }

    public JsonGenerator.Feature mappedFeature() {
        return this._mappedFeature;
    }
}
