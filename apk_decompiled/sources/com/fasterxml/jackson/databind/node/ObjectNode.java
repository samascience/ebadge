package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.JsonNodeFeature;
import defpackage.an2;
import defpackage.na2;
import defpackage.z63;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ObjectNode extends ContainerNode<ObjectNode> implements Serializable {
    private static final long serialVersionUID = 1;
    protected final Map<String, JsonNode> _children;

    public ObjectNode(JsonNodeFactory jsonNodeFactory) {
        super(jsonNodeFactory);
        this._children = new LinkedHashMap();
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    protected JsonNode _at(JsonPointer jsonPointer) {
        return get(jsonPointer.getMatchingProperty());
    }

    protected boolean _childrenEqual(ObjectNode objectNode) {
        return this._children.equals(objectNode._children);
    }

    protected ObjectNode _put(String str, JsonNode jsonNode) {
        this._children.put(str, jsonNode);
        return this;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode
    protected ArrayNode _withArray(JsonPointer jsonPointer, JsonPointer jsonPointer2, JsonNode.OverwriteMode overwriteMode, boolean z) {
        if (jsonPointer2.matches()) {
            return null;
        }
        JsonNode jsonNode_at = _at(jsonPointer2);
        if (jsonNode_at != null && (jsonNode_at instanceof BaseJsonNode)) {
            ArrayNode arrayNode_withArray = ((BaseJsonNode) jsonNode_at)._withArray(jsonPointer, jsonPointer2.tail(), overwriteMode, z);
            if (arrayNode_withArray != null) {
                return arrayNode_withArray;
            }
            _withXxxVerifyReplace(jsonPointer, jsonPointer2, overwriteMode, z, jsonNode_at);
        }
        return _withArrayAddTailProperty(jsonPointer2, z);
    }

    protected ArrayNode _withArrayAddTailProperty(JsonPointer jsonPointer, boolean z) {
        String matchingProperty = jsonPointer.getMatchingProperty();
        JsonPointer jsonPointerTail = jsonPointer.tail();
        if (jsonPointerTail.matches()) {
            return putArray(matchingProperty);
        }
        return (z && jsonPointerTail.mayMatchElement()) ? putArray(matchingProperty)._withArrayAddTailElement(jsonPointerTail, z) : putObject(matchingProperty)._withArrayAddTailProperty(jsonPointerTail, z);
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode, com.fasterxml.jackson.databind.node.BaseJsonNode
    protected ObjectNode _withObject(JsonPointer jsonPointer, JsonPointer jsonPointer2, JsonNode.OverwriteMode overwriteMode, boolean z) {
        if (jsonPointer2.matches()) {
            return this;
        }
        JsonNode jsonNode_at = _at(jsonPointer2);
        if (jsonNode_at != null && (jsonNode_at instanceof BaseJsonNode)) {
            ObjectNode objectNode_withObject = ((BaseJsonNode) jsonNode_at)._withObject(jsonPointer, jsonPointer2.tail(), overwriteMode, z);
            if (objectNode_withObject != null) {
                return objectNode_withObject;
            }
            _withXxxVerifyReplace(jsonPointer, jsonPointer2, overwriteMode, z, jsonNode_at);
        }
        return _withObjectAddTailProperty(jsonPointer2, z);
    }

    protected ObjectNode _withObjectAddTailProperty(JsonPointer jsonPointer, boolean z) {
        String matchingProperty = jsonPointer.getMatchingProperty();
        JsonPointer jsonPointerTail = jsonPointer.tail();
        if (jsonPointerTail.matches()) {
            return putObject(matchingProperty);
        }
        return (z && jsonPointerTail.mayMatchElement()) ? putArray(matchingProperty)._withObjectAddTailElement(jsonPointerTail, z) : putObject(matchingProperty)._withObjectAddTailProperty(jsonPointerTail, z);
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode, com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.core.d
    public JsonToken asToken() {
        return JsonToken.START_OBJECT;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public Iterator<JsonNode> elements() {
        return this._children.values().iterator();
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public boolean equals(Comparator<JsonNode> comparator, JsonNode jsonNode) {
        if (!(jsonNode instanceof ObjectNode)) {
            return false;
        }
        Map<String, JsonNode> map = this._children;
        Map<String, JsonNode> map2 = ((ObjectNode) jsonNode)._children;
        if (map2.size() != map.size()) {
            return false;
        }
        for (Map.Entry<String, JsonNode> entry : map.entrySet()) {
            JsonNode jsonNode2 = map2.get(entry.getKey());
            if (jsonNode2 == null || !entry.getValue().equals(comparator, jsonNode2)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public Iterator<String> fieldNames() {
        return this._children.keySet().iterator();
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public Iterator<Map.Entry<String, JsonNode>> fields() {
        return this._children.entrySet().iterator();
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public List<JsonNode> findParents(String str, List<JsonNode> list) {
        for (Map.Entry<String, JsonNode> entry : this._children.entrySet()) {
            if (str.equals(entry.getKey())) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(this);
            } else {
                list = entry.getValue().findParents(str, list);
            }
        }
        return list;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public JsonNode findValue(String str) {
        for (Map.Entry<String, JsonNode> entry : this._children.entrySet()) {
            if (str.equals(entry.getKey())) {
                return entry.getValue();
            }
            JsonNode jsonNodeFindValue = entry.getValue().findValue(str);
            if (jsonNodeFindValue != null) {
                return jsonNodeFindValue;
            }
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public List<JsonNode> findValues(String str, List<JsonNode> list) {
        for (Map.Entry<String, JsonNode> entry : this._children.entrySet()) {
            if (str.equals(entry.getKey())) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(entry.getValue());
            } else {
                list = entry.getValue().findValues(str, list);
            }
        }
        return list;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public List<String> findValuesAsText(String str, List<String> list) {
        for (Map.Entry<String, JsonNode> entry : this._children.entrySet()) {
            if (str.equals(entry.getKey())) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(entry.getValue().asText());
            } else {
                list = entry.getValue().findValuesAsText(str, list);
            }
        }
        return list;
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode, com.fasterxml.jackson.databind.JsonNode
    public JsonNode get(int i) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public JsonNodeType getNodeType() {
        return JsonNodeType.OBJECT;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode
    public int hashCode() {
        return this._children.hashCode();
    }

    @Override // com.fasterxml.jackson.databind.a.AbstractC0067a
    public boolean isEmpty(an2 an2Var) {
        return this._children.isEmpty();
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public final boolean isObject() {
        return true;
    }

    @Deprecated
    public JsonNode put(String str, JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = m38nullNode();
        }
        return this._children.put(str, jsonNode);
    }

    @Deprecated
    public JsonNode putAll(Map<String, ? extends JsonNode> map) {
        return setAll(map);
    }

    public ArrayNode putArray(String str) {
        ArrayNode arrayNode = arrayNode();
        _put(str, arrayNode);
        return arrayNode;
    }

    public JsonNode putIfAbsent(String str, JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = m38nullNode();
        }
        return this._children.putIfAbsent(str, jsonNode);
    }

    public ObjectNode putNull(String str) {
        this._children.put(str, m38nullNode());
        return this;
    }

    public ObjectNode putObject(String str) {
        ObjectNode objectNode = objectNode();
        _put(str, objectNode);
        return objectNode;
    }

    public ObjectNode putPOJO(String str, Object obj) {
        return _put(str, pojoNode(obj));
    }

    public ObjectNode putRawValue(String str, na2 na2Var) {
        return _put(str, rawValueNode(na2Var));
    }

    public JsonNode remove(String str) {
        return this._children.remove(str);
    }

    public JsonNode replace(String str, JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = m38nullNode();
        }
        return this._children.put(str, jsonNode);
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode
    public JsonNode required(String str) {
        JsonNode jsonNode = this._children.get(str);
        return jsonNode != null ? jsonNode : (JsonNode) _reportRequiredViolation("No value for property '%s' of `ObjectNode`", str);
    }

    public ObjectNode retain(Collection<String> collection) {
        this._children.keySet().retainAll(collection);
        return this;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.databind.a
    public void serialize(JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        if (an2Var != null) {
            boolean zIsEnabled = an2Var.isEnabled(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS);
            boolean z = !zIsEnabled;
            boolean zIsEnabled2 = an2Var.isEnabled(JsonNodeFeature.WRITE_NULL_PROPERTIES);
            boolean z2 = !zIsEnabled2;
            if (!zIsEnabled || !zIsEnabled2) {
                jsonGenerator.t1(this);
                serializeFilteredContents(jsonGenerator, an2Var, z, z2);
                jsonGenerator.S0();
                return;
            }
        }
        jsonGenerator.t1(this);
        for (Map.Entry<String, JsonNode> entry : this._children.entrySet()) {
            JsonNode value = entry.getValue();
            jsonGenerator.V0(entry.getKey());
            value.serialize(jsonGenerator, an2Var);
        }
        jsonGenerator.S0();
    }

    protected void serializeFilteredContents(JsonGenerator jsonGenerator, an2 an2Var, boolean z, boolean z2) throws IOException {
        for (Map.Entry<String, JsonNode> entry : this._children.entrySet()) {
            BaseJsonNode baseJsonNode = (BaseJsonNode) entry.getValue();
            if (!z || !baseJsonNode.isArray() || !baseJsonNode.isEmpty(an2Var)) {
                if (!z2 || !baseJsonNode.isNull()) {
                    jsonGenerator.V0(entry.getKey());
                    baseJsonNode.serialize(jsonGenerator, an2Var);
                }
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.databind.a
    public void serializeWithType(JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        boolean z;
        boolean z2;
        if (an2Var != null) {
            z = !an2Var.isEnabled(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS);
            z2 = !an2Var.isEnabled(JsonNodeFeature.WRITE_NULL_PROPERTIES);
        } else {
            z = false;
            z2 = false;
        }
        WritableTypeId writableTypeIdG = z63Var.g(jsonGenerator, z63Var.d(this, JsonToken.START_OBJECT));
        if (z || z2) {
            serializeFilteredContents(jsonGenerator, an2Var, z, z2);
        } else {
            for (Map.Entry<String, JsonNode> entry : this._children.entrySet()) {
                JsonNode value = entry.getValue();
                jsonGenerator.V0(entry.getKey());
                value.serialize(jsonGenerator, an2Var);
            }
        }
        z63Var.h(jsonGenerator, writableTypeIdG);
    }

    public <T extends JsonNode> T set(String str, JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = m38nullNode();
        }
        this._children.put(str, jsonNode);
        return this;
    }

    public <T extends JsonNode> T setAll(Map<String, ? extends JsonNode> map) {
        for (Map.Entry<String, ? extends JsonNode> entry : map.entrySet()) {
            JsonNode value = entry.getValue();
            if (value == null) {
                value = m38nullNode();
            }
            this._children.put(entry.getKey(), value);
        }
        return this;
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode, com.fasterxml.jackson.databind.JsonNode
    public int size() {
        return this._children.size();
    }

    public <T extends JsonNode> T without(String str) {
        this._children.remove(str);
        return this;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public ObjectNode deepCopy() {
        ObjectNode objectNode = new ObjectNode(this._nodeFactory);
        for (Map.Entry<String, JsonNode> entry : this._children.entrySet()) {
            objectNode._children.put(entry.getKey(), entry.getValue().deepCopy());
        }
        return objectNode;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public ObjectNode findParent(String str) {
        for (Map.Entry<String, JsonNode> entry : this._children.entrySet()) {
            if (str.equals(entry.getKey())) {
                return this;
            }
            JsonNode jsonNodeFindParent = entry.getValue().findParent(str);
            if (jsonNodeFindParent != null) {
                return (ObjectNode) jsonNodeFindParent;
            }
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public boolean isEmpty() {
        return this._children.isEmpty();
    }

    @Deprecated
    public JsonNode putAll(ObjectNode objectNode) {
        return setAll(objectNode);
    }

    public ObjectNode remove(Collection<String> collection) {
        this._children.keySet().removeAll(collection);
        return this;
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode
    public ObjectNode removeAll() {
        this._children.clear();
        return this;
    }

    public ObjectNode retain(String... strArr) {
        return retain(Arrays.asList(strArr));
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    @Deprecated
    public ObjectNode with(String str) {
        JsonPointer jsonPointer_jsonPointerIfValid = _jsonPointerIfValid(str);
        if (jsonPointer_jsonPointerIfValid != null) {
            return withObject(jsonPointer_jsonPointerIfValid);
        }
        JsonNode jsonNode = this._children.get(str);
        if (jsonNode == null) {
            ObjectNode objectNode = objectNode();
            this._children.put(str, objectNode);
            return objectNode;
        }
        if (jsonNode instanceof ObjectNode) {
            return (ObjectNode) jsonNode;
        }
        throw new UnsupportedOperationException("Property '" + str + "' has value that is not of type `ObjectNode` (but `" + jsonNode.getClass().getName() + "`)");
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public ArrayNode withArray(String str) {
        JsonPointer jsonPointer_jsonPointerIfValid = _jsonPointerIfValid(str);
        if (jsonPointer_jsonPointerIfValid != null) {
            return withArray(jsonPointer_jsonPointerIfValid);
        }
        JsonNode jsonNode = this._children.get(str);
        if (jsonNode == null) {
            ArrayNode arrayNode = arrayNode();
            this._children.put(str, arrayNode);
            return arrayNode;
        }
        if (jsonNode instanceof ArrayNode) {
            return (ArrayNode) jsonNode;
        }
        throw new UnsupportedOperationException("Property '" + str + "' has value that is not of type `ArrayNode` (but `" + jsonNode.getClass().getName() + "`)");
    }

    public <T extends JsonNode> T without(Collection<String> collection) {
        this._children.keySet().removeAll(collection);
        return this;
    }

    public ObjectNode(JsonNodeFactory jsonNodeFactory, Map<String, JsonNode> map) {
        super(jsonNodeFactory);
        this._children = map;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public JsonNode path(int i) {
        return MissingNode.getInstance();
    }

    public ObjectNode put(String str, short s) {
        return _put(str, m44numberNode(s));
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode, com.fasterxml.jackson.databind.JsonNode
    public JsonNode get(String str) {
        return this._children.get(str);
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public JsonNode path(String str) {
        JsonNode jsonNode = this._children.get(str);
        return jsonNode != null ? jsonNode : MissingNode.getInstance();
    }

    public ObjectNode put(String str, Short sh) {
        JsonNode jsonNodeNumberNode;
        if (sh == null) {
            jsonNodeNumberNode = m38nullNode();
        } else {
            jsonNodeNumberNode = m44numberNode(sh.shortValue());
        }
        return _put(str, jsonNodeNumberNode);
    }

    public <T extends JsonNode> T setAll(ObjectNode objectNode) {
        this._children.putAll(objectNode._children);
        return this;
    }

    public ObjectNode put(String str, int i) {
        return _put(str, m42numberNode(i));
    }

    public ObjectNode put(String str, Integer num) {
        JsonNode jsonNodeNumberNode;
        if (num == null) {
            jsonNodeNumberNode = m38nullNode();
        } else {
            jsonNodeNumberNode = m42numberNode(num.intValue());
        }
        return _put(str, jsonNodeNumberNode);
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof ObjectNode)) {
            return _childrenEqual((ObjectNode) obj);
        }
        return false;
    }

    public ObjectNode put(String str, long j) {
        return _put(str, m43numberNode(j));
    }

    public ObjectNode put(String str, Long l) {
        JsonNode jsonNodeNumberNode;
        if (l == null) {
            jsonNodeNumberNode = m38nullNode();
        } else {
            jsonNodeNumberNode = m43numberNode(l.longValue());
        }
        return _put(str, jsonNodeNumberNode);
    }

    public ObjectNode put(String str, float f) {
        return _put(str, m41numberNode(f));
    }

    public ObjectNode put(String str, Float f) {
        JsonNode jsonNodeNumberNode;
        if (f == null) {
            jsonNodeNumberNode = m38nullNode();
        } else {
            jsonNodeNumberNode = m41numberNode(f.floatValue());
        }
        return _put(str, jsonNodeNumberNode);
    }

    public ObjectNode put(String str, double d) {
        return _put(str, m40numberNode(d));
    }

    public ObjectNode put(String str, Double d) {
        JsonNode jsonNodeNumberNode;
        if (d == null) {
            jsonNodeNumberNode = m38nullNode();
        } else {
            jsonNodeNumberNode = m40numberNode(d.doubleValue());
        }
        return _put(str, jsonNodeNumberNode);
    }

    public ObjectNode put(String str, BigDecimal bigDecimal) {
        ValueNode valueNodeNumberNode;
        if (bigDecimal == null) {
            valueNodeNumberNode = m38nullNode();
        } else {
            valueNodeNumberNode = numberNode(bigDecimal);
        }
        return _put(str, valueNodeNumberNode);
    }

    public ObjectNode put(String str, BigInteger bigInteger) {
        ValueNode valueNodeNumberNode;
        if (bigInteger == null) {
            valueNodeNumberNode = m38nullNode();
        } else {
            valueNodeNumberNode = numberNode(bigInteger);
        }
        return _put(str, valueNodeNumberNode);
    }

    public ObjectNode put(String str, String str2) {
        JsonNode jsonNodeTextNode;
        if (str2 == null) {
            jsonNodeTextNode = m38nullNode();
        } else {
            jsonNodeTextNode = m45textNode(str2);
        }
        return _put(str, jsonNodeTextNode);
    }

    public ObjectNode put(String str, boolean z) {
        return _put(str, m37booleanNode(z));
    }

    public ObjectNode put(String str, Boolean bool) {
        JsonNode jsonNodeBooleanNode;
        if (bool == null) {
            jsonNodeBooleanNode = m38nullNode();
        } else {
            jsonNodeBooleanNode = m37booleanNode(bool.booleanValue());
        }
        return _put(str, jsonNodeBooleanNode);
    }

    public ObjectNode put(String str, byte[] bArr) {
        JsonNode jsonNodeBinaryNode;
        if (bArr == null) {
            jsonNodeBinaryNode = m38nullNode();
        } else {
            jsonNodeBinaryNode = m35binaryNode(bArr);
        }
        return _put(str, jsonNodeBinaryNode);
    }
}
