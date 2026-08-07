package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import defpackage.an2;
import defpackage.jt1;
import defpackage.z53;
import defpackage.z63;
import java.io.IOException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseJsonNode extends JsonNode implements Serializable {
    private static final long serialVersionUID = 1;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonNode.OverwriteMode.values().length];
            a = iArr;
            try {
                iArr[JsonNode.OverwriteMode.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonNode.OverwriteMode.NULLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonNode.OverwriteMode.SCALARS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[JsonNode.OverwriteMode.ALL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    protected BaseJsonNode() {
    }

    protected JsonPointer _jsonPointerIfValid(String str) {
        if (str.isEmpty() || str.charAt(0) == '/') {
            return JsonPointer.compile(str);
        }
        return null;
    }

    protected <T> T _reportWrongNodeOperation(String str, Object... objArr) {
        throw new UnsupportedOperationException(String.format(str, objArr));
    }

    protected <T> T _reportWrongNodeType(String str, Object... objArr) {
        throw new UnsupportedOperationException(String.format(str, objArr));
    }

    protected ArrayNode _withArray(JsonPointer jsonPointer, JsonPointer jsonPointer2, JsonNode.OverwriteMode overwriteMode, boolean z) {
        return null;
    }

    protected ObjectNode _withObject(JsonPointer jsonPointer, JsonPointer jsonPointer2, JsonNode.OverwriteMode overwriteMode, boolean z) {
        return null;
    }

    protected boolean _withXxxMayReplace(JsonNode jsonNode, JsonNode.OverwriteMode overwriteMode) {
        int i = a.a[overwriteMode.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i == 2) {
            return jsonNode.isNull();
        }
        if (i != 3) {
            return true;
        }
        return !jsonNode.isContainerNode();
    }

    protected void _withXxxVerifyReplace(JsonPointer jsonPointer, JsonPointer jsonPointer2, JsonNode.OverwriteMode overwriteMode, boolean z, JsonNode jsonNode) {
        if (_withXxxMayReplace(jsonNode, overwriteMode)) {
            return;
        }
        _reportWrongNodeType("Cannot replace `JsonNode` of type `%s` for property \"%s\" in JSON Pointer \"%s\" (mode `OverwriteMode.%s`)", jsonNode.getClass().getName(), jsonPointer2.getMatchingProperty(), jsonPointer, overwriteMode);
    }

    public abstract JsonToken asToken();

    public final JsonNode findPath(String str) {
        JsonNode jsonNodeFindValue = findValue(str);
        return jsonNodeFindValue == null ? MissingNode.getInstance() : jsonNodeFindValue;
    }

    public abstract int hashCode();

    @Override // com.fasterxml.jackson.core.d
    public JsonParser.NumberType numberType() {
        return null;
    }

    public JsonNode required(String str) {
        return (JsonNode) _reportRequiredViolation("Node of type `%s` has no fields", getClass().getSimpleName());
    }

    @Override // com.fasterxml.jackson.databind.a
    public abstract void serialize(JsonGenerator jsonGenerator, an2 an2Var) throws IOException;

    @Override // com.fasterxml.jackson.databind.a
    public abstract void serializeWithType(JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException;

    public String toPrettyString() {
        return com.fasterxml.jackson.databind.node.a.c(this);
    }

    public String toString() {
        return com.fasterxml.jackson.databind.node.a.d(this);
    }

    public JsonParser traverse() {
        return new z53(this);
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public ArrayNode withArray(JsonPointer jsonPointer, JsonNode.OverwriteMode overwriteMode, boolean z) {
        if (jsonPointer.matches()) {
            if (this instanceof ArrayNode) {
                return (ArrayNode) this;
            }
            _reportWrongNodeType("Can only call `withArray()` with empty JSON Pointer on `ArrayNode`, not `%s`", getClass().getName());
        }
        ArrayNode arrayNode_withArray = _withArray(jsonPointer, jsonPointer, overwriteMode, z);
        if (arrayNode_withArray == null) {
            _reportWrongNodeType("Cannot replace context node (of type `%s`) using `withArray()` with  JSON Pointer '%s'", getClass().getName(), jsonPointer);
        }
        return arrayNode_withArray;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public ObjectNode withObject(JsonPointer jsonPointer, JsonNode.OverwriteMode overwriteMode, boolean z) {
        if (jsonPointer.matches()) {
            if (this instanceof ObjectNode) {
                return (ObjectNode) this;
            }
            _reportWrongNodeType("Can only call `withObject()` with empty JSON Pointer on `ObjectNode`, not `%s`", getClass().getName());
        }
        ObjectNode objectNode_withObject = _withObject(jsonPointer, jsonPointer, overwriteMode, z);
        if (objectNode_withObject == null) {
            _reportWrongNodeType("Cannot replace context node (of type `%s`) using `withObject()` with  JSON Pointer '%s'", getClass().getName(), jsonPointer);
        }
        return objectNode_withObject;
    }

    Object writeReplace() {
        return NodeSerialization.from(this);
    }

    public JsonParser traverse(jt1 jt1Var) {
        return new z53(this, jt1Var);
    }

    public JsonNode required(int i) {
        return (JsonNode) _reportRequiredViolation("Node of type `%s` has no indexed values", getClass().getSimpleName());
    }
}
