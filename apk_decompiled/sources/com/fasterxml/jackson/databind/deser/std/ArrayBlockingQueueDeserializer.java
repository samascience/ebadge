package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import defpackage.gs1;
import defpackage.m63;
import defpackage.s51;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class ArrayBlockingQueueDeserializer extends CollectionDeserializer {
    private static final long serialVersionUID = 1;

    public ArrayBlockingQueueDeserializer(JavaType javaType, s51 s51Var, m63 m63Var, ValueInstantiator valueInstantiator) {
        super(javaType, s51Var, m63Var, valueInstantiator);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.CollectionDeserializer
    protected Collection<Object> _deserializeFromArray(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<Object> collection) throws IOException {
        if (collection == null) {
            collection = new ArrayList<>();
        }
        Collection<Object> collection_deserializeFromArray = super._deserializeFromArray(jsonParser, deserializationContext, collection);
        return collection_deserializeFromArray.isEmpty() ? new ArrayBlockingQueue(1, false) : new ArrayBlockingQueue(collection_deserializeFromArray.size(), false, collection_deserializeFromArray);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.CollectionDeserializer
    protected Collection<Object> createDefaultInstance(DeserializationContext deserializationContext) throws IOException {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.CollectionDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        return m63Var.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    protected ArrayBlockingQueueDeserializer(JavaType javaType, s51 s51Var, m63 m63Var, ValueInstantiator valueInstantiator, s51 s51Var2, gs1 gs1Var, Boolean bool) {
        super(javaType, s51Var, m63Var, valueInstantiator, s51Var2, gs1Var, bool);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.databind.deser.std.CollectionDeserializer
    public ArrayBlockingQueueDeserializer withResolved(s51 s51Var, s51 s51Var2, m63 m63Var, gs1 gs1Var, Boolean bool) {
        return new ArrayBlockingQueueDeserializer(this._containerType, s51Var2, m63Var, this._valueInstantiator, s51Var, gs1Var, bool);
    }

    protected ArrayBlockingQueueDeserializer(ArrayBlockingQueueDeserializer arrayBlockingQueueDeserializer) {
        super(arrayBlockingQueueDeserializer);
    }
}
