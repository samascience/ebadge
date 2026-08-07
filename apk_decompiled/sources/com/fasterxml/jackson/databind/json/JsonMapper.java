package com.fasterxml.jackson.databind.json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import defpackage.tf1;
import defpackage.vy1;

/* JADX INFO: loaded from: classes.dex */
public class JsonMapper extends ObjectMapper {
    private static final long serialVersionUID = 1;

    public static class a extends tf1 {
        public a(JsonMapper jsonMapper) {
            super(jsonMapper);
        }
    }

    public JsonMapper() {
        this(new JsonFactory());
    }

    public static a builder() {
        return new a(new JsonMapper());
    }

    @Override // com.fasterxml.jackson.databind.ObjectMapper, defpackage.jt1
    public JsonFactory getFactory() {
        return this._jsonFactory;
    }

    public boolean isEnabled(JsonReadFeature jsonReadFeature) {
        return isEnabled(jsonReadFeature.mappedFeature());
    }

    public a rebuild() {
        return new a(copy());
    }

    @Override // com.fasterxml.jackson.databind.ObjectMapper
    public Version version() {
        return vy1.a;
    }

    public JsonMapper(JsonFactory jsonFactory) {
        super(jsonFactory);
    }

    public static a builder(JsonFactory jsonFactory) {
        return new a(new JsonMapper(jsonFactory));
    }

    @Override // com.fasterxml.jackson.databind.ObjectMapper
    public JsonMapper copy() {
        _checkInvalidCopy(JsonMapper.class);
        return new JsonMapper(this);
    }

    public boolean isEnabled(JsonWriteFeature jsonWriteFeature) {
        return isEnabled(jsonWriteFeature.mappedFeature());
    }

    protected JsonMapper(JsonMapper jsonMapper) {
        super(jsonMapper);
    }
}
