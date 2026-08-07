package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import defpackage.ag2;
import defpackage.m63;
import defpackage.s51;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class StdNodeBasedDeserializer<T> extends StdDeserializer<T> implements ag2 {
    private static final long serialVersionUID = 1;
    protected s51 _treeDeserializer;

    protected StdNodeBasedDeserializer(JavaType javaType) {
        super(javaType);
    }

    public abstract T convert(JsonNode jsonNode, DeserializationContext deserializationContext) throws IOException;

    @Override // defpackage.s51
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return convert((JsonNode) this._treeDeserializer.deserialize(jsonParser, deserializationContext), deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        return convert((JsonNode) this._treeDeserializer.deserializeWithType(jsonParser, deserializationContext, m63Var), deserializationContext);
    }

    @Override // defpackage.ag2
    public void resolve(DeserializationContext deserializationContext) throws JsonMappingException {
        this._treeDeserializer = deserializationContext.findRootValueDeserializer(deserializationContext.constructType(JsonNode.class));
    }

    protected StdNodeBasedDeserializer(Class<T> cls) {
        super((Class<?>) cls);
    }

    protected StdNodeBasedDeserializer(StdNodeBasedDeserializer<?> stdNodeBasedDeserializer) {
        super(stdNodeBasedDeserializer);
        this._treeDeserializer = stdNodeBasedDeserializer._treeDeserializer;
    }
}
