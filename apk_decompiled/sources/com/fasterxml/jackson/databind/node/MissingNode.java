package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.tencent.connect.common.Constants;
import defpackage.an2;
import defpackage.z63;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class MissingNode extends ValueNode {
    private static final MissingNode instance = new MissingNode();
    private static final long serialVersionUID = 1;

    protected MissingNode() {
    }

    public static MissingNode getInstance() {
        return instance;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public String asText(String str) {
        return str;
    }

    @Override // com.fasterxml.jackson.databind.node.ValueNode, com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.core.d
    public JsonToken asToken() {
        return JsonToken.NOT_AVAILABLE;
    }

    @Override // com.fasterxml.jackson.databind.node.ValueNode, com.fasterxml.jackson.databind.JsonNode
    public <T extends JsonNode> T deepCopy() {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public JsonNodeType getNodeType() {
        return JsonNodeType.MISSING;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode
    public int hashCode() {
        return JsonNodeType.MISSING.ordinal();
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public boolean isMissingNode() {
        return true;
    }

    protected Object readResolve() {
        return instance;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public JsonNode require() {
        return (JsonNode) _reportRequiredViolation("require() called on `MissingNode`", new Object[0]);
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public JsonNode requireNonNull() {
        return (JsonNode) _reportRequiredViolation("requireNonNull() called on `MissingNode`", new Object[0]);
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.databind.a
    public final void serialize(JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        jsonGenerator.W0();
    }

    @Override // com.fasterxml.jackson.databind.node.ValueNode, com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.databind.a
    public void serializeWithType(JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        jsonGenerator.W0();
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode
    public String toPrettyString() {
        return Constants.STR_EMPTY;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode
    public String toString() {
        return Constants.STR_EMPTY;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public String asText() {
        return Constants.STR_EMPTY;
    }
}
