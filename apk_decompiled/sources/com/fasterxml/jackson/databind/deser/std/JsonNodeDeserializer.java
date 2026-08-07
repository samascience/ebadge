package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.LogicalType;
import defpackage.m63;
import defpackage.s51;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class JsonNodeDeserializer extends BaseNodeDeserializer<JsonNode> {
    private static final JsonNodeDeserializer instance = new JsonNodeDeserializer();

    static final class ArrayDeserializer extends BaseNodeDeserializer<ArrayNode> {
        protected static final ArrayDeserializer _instance = new ArrayDeserializer();
        private static final long serialVersionUID = 1;

        protected ArrayDeserializer() {
            super(ArrayNode.class, Boolean.TRUE);
        }

        public static ArrayDeserializer getInstance() {
            return _instance;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer
        protected s51 _createWithMerge(boolean z, boolean z2) {
            return new ArrayDeserializer(this, z, z2);
        }

        protected ArrayDeserializer(ArrayDeserializer arrayDeserializer, boolean z, boolean z2) {
            super(arrayDeserializer, z, z2);
        }

        @Override // defpackage.s51
        public ArrayNode deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            if (jsonParser.i1()) {
                JsonNodeFactory nodeFactory = deserializationContext.getNodeFactory();
                ArrayNode arrayNode = nodeFactory.arrayNode();
                _deserializeContainerNoRecursion(jsonParser, deserializationContext, nodeFactory, new BaseNodeDeserializer.a(), arrayNode);
                return arrayNode;
            }
            return (ArrayNode) deserializationContext.handleUnexpectedToken(ArrayNode.class, jsonParser);
        }

        @Override // defpackage.s51
        public ArrayNode deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, ArrayNode arrayNode) throws IOException {
            if (jsonParser.i1()) {
                _deserializeContainerNoRecursion(jsonParser, deserializationContext, deserializationContext.getNodeFactory(), new BaseNodeDeserializer.a(), arrayNode);
                return arrayNode;
            }
            return (ArrayNode) deserializationContext.handleUnexpectedToken(ArrayNode.class, jsonParser);
        }
    }

    static final class ObjectDeserializer extends BaseNodeDeserializer<ObjectNode> {
        protected static final ObjectDeserializer _instance = new ObjectDeserializer();
        private static final long serialVersionUID = 1;

        protected ObjectDeserializer() {
            super(ObjectNode.class, Boolean.TRUE);
        }

        public static ObjectDeserializer getInstance() {
            return _instance;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer
        protected s51 _createWithMerge(boolean z, boolean z2) {
            return new ObjectDeserializer(this, z, z2);
        }

        protected ObjectDeserializer(ObjectDeserializer objectDeserializer, boolean z, boolean z2) {
            super(objectDeserializer, z, z2);
        }

        @Override // defpackage.s51
        public ObjectNode deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            JsonNodeFactory nodeFactory = deserializationContext.getNodeFactory();
            if (jsonParser.j1()) {
                ObjectNode objectNode = nodeFactory.objectNode();
                _deserializeContainerNoRecursion(jsonParser, deserializationContext, nodeFactory, new BaseNodeDeserializer.a(), objectNode);
                return objectNode;
            }
            if (jsonParser.d1(JsonToken.FIELD_NAME)) {
                return _deserializeObjectAtName(jsonParser, deserializationContext, nodeFactory, new BaseNodeDeserializer.a());
            }
            if (jsonParser.d1(JsonToken.END_OBJECT)) {
                return nodeFactory.objectNode();
            }
            return (ObjectNode) deserializationContext.handleUnexpectedToken(ObjectNode.class, jsonParser);
        }

        @Override // defpackage.s51
        public ObjectNode deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, ObjectNode objectNode) throws IOException {
            if (!jsonParser.j1() && !jsonParser.d1(JsonToken.FIELD_NAME)) {
                return (ObjectNode) deserializationContext.handleUnexpectedToken(ObjectNode.class, jsonParser);
            }
            return (ObjectNode) updateObject(jsonParser, deserializationContext, objectNode, new BaseNodeDeserializer.a());
        }
    }

    protected JsonNodeDeserializer() {
        super(JsonNode.class, null);
    }

    public static s51 getDeserializer(Class<?> cls) {
        if (cls == ObjectNode.class) {
            return ObjectDeserializer.getInstance();
        }
        return cls == ArrayNode.class ? ArrayDeserializer.getInstance() : instance;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer
    protected s51 _createWithMerge(boolean z, boolean z2) {
        return new JsonNodeDeserializer(this, z, z2);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer, defpackage.v30
    public /* bridge */ /* synthetic */ s51 createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        return super.createContextual(deserializationContext, beanProperty);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public /* bridge */ /* synthetic */ Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        return super.deserializeWithType(jsonParser, deserializationContext, m63Var);
    }

    @Override // defpackage.s51, defpackage.gs1
    public Object getAbsentValue(DeserializationContext deserializationContext) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer, defpackage.s51
    public /* bridge */ /* synthetic */ boolean isCachable() {
        return super.isCachable();
    }

    @Override // com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer, defpackage.s51
    public /* bridge */ /* synthetic */ LogicalType logicalType() {
        return super.logicalType();
    }

    @Override // com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer, defpackage.s51
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return this._supportsUpdates;
    }

    protected JsonNodeDeserializer(JsonNodeDeserializer jsonNodeDeserializer, boolean z, boolean z2) {
        super(jsonNodeDeserializer, z, z2);
    }

    @Override // defpackage.s51
    public JsonNode deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        BaseNodeDeserializer.a aVar = new BaseNodeDeserializer.a();
        JsonNodeFactory nodeFactory = deserializationContext.getNodeFactory();
        int iV = jsonParser.V();
        if (iV == 1) {
            return _deserializeContainerNoRecursion(jsonParser, deserializationContext, nodeFactory, aVar, nodeFactory.objectNode());
        }
        if (iV == 2) {
            return nodeFactory.objectNode();
        }
        if (iV != 3) {
            return iV != 5 ? _deserializeAnyScalar(jsonParser, deserializationContext) : _deserializeObjectAtName(jsonParser, deserializationContext, nodeFactory, aVar);
        }
        return _deserializeContainerNoRecursion(jsonParser, deserializationContext, nodeFactory, aVar, nodeFactory.arrayNode());
    }

    @Override // defpackage.s51, defpackage.gs1
    public JsonNode getNullValue(DeserializationContext deserializationContext) {
        return deserializationContext.getNodeFactory().m49nullNode();
    }
}
