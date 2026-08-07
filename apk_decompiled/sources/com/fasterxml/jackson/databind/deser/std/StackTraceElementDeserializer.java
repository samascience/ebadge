package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import defpackage.e43;
import defpackage.s51;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class StackTraceElementDeserializer extends StdScalarDeserializer<StackTraceElement> {
    private static final long serialVersionUID = 1;
    protected final s51 _adapterDeserializer;

    public static final class a {
    }

    @Deprecated
    public StackTraceElementDeserializer() {
        this(null);
    }

    public static s51 construct(DeserializationContext deserializationContext) throws JsonMappingException {
        return deserializationContext == null ? new StackTraceElementDeserializer() : new StackTraceElementDeserializer(deserializationContext.findNonContextualValueDeserializer(deserializationContext.constructType(a.class)));
    }

    protected StackTraceElement constructValue(DeserializationContext deserializationContext, a aVar) {
        throw null;
    }

    protected StackTraceElementDeserializer(s51 s51Var) {
        super((Class<?>) StackTraceElement.class);
        this._adapterDeserializer = s51Var;
    }

    @Deprecated
    protected StackTraceElement constructValue(DeserializationContext deserializationContext, String str, String str2, String str3, int i, String str4, String str5) {
        return constructValue(deserializationContext, str, str2, str3, i, str4, str5, null);
    }

    @Override // defpackage.s51
    public StackTraceElement deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken jsonTokenD = jsonParser.D();
        if (jsonTokenD == JsonToken.START_OBJECT || jsonTokenD == JsonToken.FIELD_NAME) {
            s51 s51Var = this._adapterDeserializer;
            if (s51Var == null) {
                e43.a(deserializationContext.readValue(jsonParser, a.class));
            } else {
                e43.a(s51Var.deserialize(jsonParser, deserializationContext));
            }
            return constructValue(deserializationContext, null);
        }
        if (jsonTokenD != JsonToken.START_ARRAY || !deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            return (StackTraceElement) deserializationContext.handleUnexpectedToken(this._valueClass, jsonParser);
        }
        jsonParser.n1();
        StackTraceElement stackTraceElementDeserialize = deserialize(jsonParser, deserializationContext);
        if (jsonParser.n1() != JsonToken.END_ARRAY) {
            handleMissingEndArrayForSingle(jsonParser, deserializationContext);
        }
        return stackTraceElementDeserialize;
    }

    protected StackTraceElement constructValue(DeserializationContext deserializationContext, String str, String str2, String str3, int i, String str4, String str5, String str6) {
        return new StackTraceElement(str, str2, str3, i);
    }
}
