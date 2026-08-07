package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ContainerNode;
import com.tencent.connect.common.Constants;
import defpackage.na2;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContainerNode<T extends ContainerNode<T>> extends BaseJsonNode {
    private static final long serialVersionUID = 1;
    protected final JsonNodeFactory _nodeFactory;

    protected ContainerNode(JsonNodeFactory jsonNodeFactory) {
        this._nodeFactory = jsonNodeFactory;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode
    protected abstract ObjectNode _withObject(JsonPointer jsonPointer, JsonPointer jsonPointer2, JsonNode.OverwriteMode overwriteMode, boolean z);

    public final ArrayNode arrayNode() {
        return this._nodeFactory.arrayNode();
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public String asText() {
        return Constants.STR_EMPTY;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.core.d
    public abstract JsonToken asToken();

    @Override // com.fasterxml.jackson.databind.JsonNode
    public abstract JsonNode get(int i);

    @Override // com.fasterxml.jackson.databind.JsonNode
    public abstract JsonNode get(String str);

    public JsonNode missingNode() {
        return this._nodeFactory.missingNode();
    }

    public final ObjectNode objectNode() {
        return this._nodeFactory.objectNode();
    }

    public final ValueNode pojoNode(Object obj) {
        return this._nodeFactory.pojoNode(obj);
    }

    public final ValueNode rawValueNode(na2 na2Var) {
        return this._nodeFactory.rawValueNode(na2Var);
    }

    public abstract T removeAll();

    @Override // com.fasterxml.jackson.databind.JsonNode
    public abstract int size();

    public final ArrayNode arrayNode(int i) {
        return this._nodeFactory.arrayNode(i);
    }

    /* JADX INFO: renamed from: booleanNode, reason: merged with bridge method [inline-methods] */
    public final BooleanNode m37booleanNode(boolean z) {
        return this._nodeFactory.m48booleanNode(z);
    }

    /* JADX INFO: renamed from: nullNode, reason: merged with bridge method [inline-methods] */
    public final NullNode m38nullNode() {
        return this._nodeFactory.m49nullNode();
    }

    /* JADX INFO: renamed from: textNode, reason: merged with bridge method [inline-methods] */
    public final TextNode m45textNode(String str) {
        return this._nodeFactory.m56textNode(str);
    }

    protected ContainerNode() {
        this._nodeFactory = null;
    }

    /* JADX INFO: renamed from: binaryNode, reason: merged with bridge method [inline-methods] */
    public final BinaryNode m35binaryNode(byte[] bArr) {
        return this._nodeFactory.m46binaryNode(bArr);
    }

    /* JADX INFO: renamed from: binaryNode, reason: merged with bridge method [inline-methods] */
    public final BinaryNode m36binaryNode(byte[] bArr, int i, int i2) {
        return this._nodeFactory.m47binaryNode(bArr, i, i2);
    }

    /* JADX INFO: renamed from: numberNode, reason: merged with bridge method [inline-methods] */
    public final NumericNode m39numberNode(byte b) {
        return this._nodeFactory.m50numberNode(b);
    }

    /* JADX INFO: renamed from: numberNode, reason: merged with bridge method [inline-methods] */
    public final NumericNode m44numberNode(short s) {
        return this._nodeFactory.m55numberNode(s);
    }

    /* JADX INFO: renamed from: numberNode, reason: merged with bridge method [inline-methods] */
    public final NumericNode m42numberNode(int i) {
        return this._nodeFactory.m53numberNode(i);
    }

    /* JADX INFO: renamed from: numberNode, reason: merged with bridge method [inline-methods] */
    public final NumericNode m43numberNode(long j) {
        return this._nodeFactory.m54numberNode(j);
    }

    /* JADX INFO: renamed from: numberNode, reason: merged with bridge method [inline-methods] */
    public final NumericNode m41numberNode(float f) {
        return this._nodeFactory.m52numberNode(f);
    }

    /* JADX INFO: renamed from: numberNode, reason: merged with bridge method [inline-methods] */
    public final NumericNode m40numberNode(double d) {
        return this._nodeFactory.m51numberNode(d);
    }

    public final ValueNode numberNode(BigInteger bigInteger) {
        return this._nodeFactory.numberNode(bigInteger);
    }

    public final ValueNode numberNode(BigDecimal bigDecimal) {
        return this._nodeFactory.numberNode(bigDecimal);
    }

    public final ValueNode numberNode(Byte b) {
        return this._nodeFactory.numberNode(b);
    }

    public final ValueNode numberNode(Short sh) {
        return this._nodeFactory.numberNode(sh);
    }

    public final ValueNode numberNode(Integer num) {
        return this._nodeFactory.numberNode(num);
    }

    public final ValueNode numberNode(Long l) {
        return this._nodeFactory.numberNode(l);
    }

    public final ValueNode numberNode(Float f) {
        return this._nodeFactory.numberNode(f);
    }

    public final ValueNode numberNode(Double d) {
        return this._nodeFactory.numberNode(d);
    }
}
