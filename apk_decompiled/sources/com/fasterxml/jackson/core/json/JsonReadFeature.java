package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonParser;
import defpackage.hp0;

/* JADX INFO: loaded from: classes.dex */
public enum JsonReadFeature implements hp0 {
    ALLOW_JAVA_COMMENTS(false, JsonParser.Feature.ALLOW_COMMENTS),
    ALLOW_YAML_COMMENTS(false, JsonParser.Feature.ALLOW_YAML_COMMENTS),
    ALLOW_SINGLE_QUOTES(false, JsonParser.Feature.ALLOW_SINGLE_QUOTES),
    ALLOW_UNQUOTED_FIELD_NAMES(false, JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES),
    ALLOW_UNESCAPED_CONTROL_CHARS(false, JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS),
    ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false, JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER),
    ALLOW_LEADING_ZEROS_FOR_NUMBERS(false, JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS),
    ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS(false, JsonParser.Feature.ALLOW_LEADING_PLUS_SIGN_FOR_NUMBERS),
    ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS(false, JsonParser.Feature.ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS),
    ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS(false, JsonParser.Feature.ALLOW_TRAILING_DECIMAL_POINT_FOR_NUMBERS),
    ALLOW_NON_NUMERIC_NUMBERS(false, JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS),
    ALLOW_MISSING_VALUES(false, JsonParser.Feature.ALLOW_MISSING_VALUES),
    ALLOW_TRAILING_COMMA(false, JsonParser.Feature.ALLOW_TRAILING_COMMA);

    private final boolean _defaultState;
    private final JsonParser.Feature _mappedFeature;
    private final int _mask = 1 << ordinal();

    JsonReadFeature(boolean z, JsonParser.Feature feature) {
        this._defaultState = z;
        this._mappedFeature = feature;
    }

    public static int collectDefaults() {
        int mask = 0;
        for (JsonReadFeature jsonReadFeature : values()) {
            if (jsonReadFeature.enabledByDefault()) {
                mask |= jsonReadFeature.getMask();
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

    public JsonParser.Feature mappedFeature() {
        return this._mappedFeature;
    }
}
