package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.JsonNode;
import defpackage.an2;
import defpackage.na2;
import defpackage.z63;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ArrayNode extends ContainerNode<ArrayNode> implements Serializable {
    private static final long serialVersionUID = 1;
    private final List<JsonNode> _children;

    public ArrayNode(JsonNodeFactory jsonNodeFactory) {
        super(jsonNodeFactory);
        this._children = new ArrayList();
    }

    protected ArrayNode _add(JsonNode jsonNode) {
        this._children.add(jsonNode);
        return this;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    protected JsonNode _at(JsonPointer jsonPointer) {
        return get(jsonPointer.getMatchingIndex());
    }

    protected boolean _childrenEqual(ArrayNode arrayNode) {
        return this._children.equals(arrayNode._children);
    }

    protected ArrayNode _insert(int i, JsonNode jsonNode) {
        if (i < 0) {
            this._children.add(0, jsonNode);
        } else if (i >= this._children.size()) {
            this._children.add(jsonNode);
        } else {
            this._children.add(i, jsonNode);
        }
        return this;
    }

    protected ArrayNode _set(int i, JsonNode jsonNode) {
        if (i >= 0 && i < this._children.size()) {
            this._children.set(i, jsonNode);
            return this;
        }
        throw new IndexOutOfBoundsException("Illegal index " + i + ", array size " + size());
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode
    protected ArrayNode _withArray(JsonPointer jsonPointer, JsonPointer jsonPointer2, JsonNode.OverwriteMode overwriteMode, boolean z) {
        if (jsonPointer2.matches()) {
            return this;
        }
        JsonNode jsonNode_at = _at(jsonPointer2);
        if (jsonNode_at != null && (jsonNode_at instanceof BaseJsonNode)) {
            ArrayNode arrayNode_withArray = ((BaseJsonNode) jsonNode_at)._withArray(jsonPointer, jsonPointer2.tail(), overwriteMode, z);
            if (arrayNode_withArray != null) {
                return arrayNode_withArray;
            }
            _withXxxVerifyReplace(jsonPointer, jsonPointer2, overwriteMode, z, jsonNode_at);
        }
        return _withArrayAddTailElement(jsonPointer2, z);
    }

    protected ArrayNode _withArrayAddTailElement(JsonPointer jsonPointer, boolean z) {
        int matchingIndex = jsonPointer.getMatchingIndex();
        if (matchingIndex < 0) {
            return null;
        }
        JsonPointer jsonPointerTail = jsonPointer.tail();
        if (jsonPointerTail.matches()) {
            ArrayNode arrayNode = arrayNode();
            _withXxxSetArrayElement(matchingIndex, arrayNode);
            return arrayNode;
        }
        if (z && jsonPointerTail.mayMatchElement()) {
            ArrayNode arrayNode2 = arrayNode();
            _withXxxSetArrayElement(matchingIndex, arrayNode2);
            return arrayNode2._withArrayAddTailElement(jsonPointerTail, z);
        }
        ArrayNode arrayNode3 = arrayNode();
        _withXxxSetArrayElement(matchingIndex, arrayNode3);
        return arrayNode3._withArrayAddTailElement(jsonPointerTail, z);
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode, com.fasterxml.jackson.databind.node.BaseJsonNode
    protected ObjectNode _withObject(JsonPointer jsonPointer, JsonPointer jsonPointer2, JsonNode.OverwriteMode overwriteMode, boolean z) {
        if (jsonPointer2.matches()) {
            return null;
        }
        JsonNode jsonNode_at = _at(jsonPointer2);
        if (jsonNode_at != null && (jsonNode_at instanceof BaseJsonNode)) {
            ObjectNode objectNode_withObject = ((BaseJsonNode) jsonNode_at)._withObject(jsonPointer, jsonPointer2.tail(), overwriteMode, z);
            if (objectNode_withObject != null) {
                return objectNode_withObject;
            }
            _withXxxVerifyReplace(jsonPointer, jsonPointer2, overwriteMode, z, jsonNode_at);
        }
        return _withObjectAddTailElement(jsonPointer2, z);
    }

    protected ObjectNode _withObjectAddTailElement(JsonPointer jsonPointer, boolean z) {
        int matchingIndex = jsonPointer.getMatchingIndex();
        if (matchingIndex < 0) {
            return null;
        }
        JsonPointer jsonPointerTail = jsonPointer.tail();
        if (jsonPointerTail.matches()) {
            ObjectNode objectNode = objectNode();
            _withXxxSetArrayElement(matchingIndex, objectNode);
            return objectNode;
        }
        if (z && jsonPointerTail.mayMatchElement()) {
            ArrayNode arrayNode = arrayNode();
            _withXxxSetArrayElement(matchingIndex, arrayNode);
            return arrayNode._withObjectAddTailElement(jsonPointerTail, z);
        }
        ObjectNode objectNode2 = objectNode();
        _withXxxSetArrayElement(matchingIndex, objectNode2);
        return objectNode2._withObjectAddTailProperty(jsonPointerTail, z);
    }

    protected void _withXxxSetArrayElement(int i, JsonNode jsonNode) {
        if (i >= size()) {
            int maxElementIndexForInsert = this._nodeFactory.getMaxElementIndexForInsert();
            if (i > maxElementIndexForInsert) {
                _reportWrongNodeOperation("Too big Array index (%d; max %d) to use for insert with `JsonPointer`", Integer.valueOf(i), Integer.valueOf(maxElementIndexForInsert));
            }
            while (i >= size()) {
                addNull();
            }
        }
        set(i, jsonNode);
    }

    public ArrayNode add(JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = m38nullNode();
        }
        _add(jsonNode);
        return this;
    }

    public ArrayNode addAll(ArrayNode arrayNode) {
        this._children.addAll(arrayNode._children);
        return this;
    }

    public ArrayNode addArray() {
        ArrayNode arrayNode = arrayNode();
        _add(arrayNode);
        return arrayNode;
    }

    public ArrayNode addNull() {
        return _add(m38nullNode());
    }

    public ObjectNode addObject() {
        ObjectNode objectNode = objectNode();
        _add(objectNode);
        return objectNode;
    }

    public ArrayNode addPOJO(Object obj) {
        return _add(obj == null ? m38nullNode() : pojoNode(obj));
    }

    public ArrayNode addRawValue(na2 na2Var) {
        return _add(na2Var == null ? m38nullNode() : rawValueNode(na2Var));
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode, com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.core.d
    public JsonToken asToken() {
        return JsonToken.START_ARRAY;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public Iterator<JsonNode> elements() {
        return this._children.iterator();
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public boolean equals(Comparator<JsonNode> comparator, JsonNode jsonNode) {
        if (!(jsonNode instanceof ArrayNode)) {
            return false;
        }
        ArrayNode arrayNode = (ArrayNode) jsonNode;
        int size = this._children.size();
        if (arrayNode.size() != size) {
            return false;
        }
        List<JsonNode> list = this._children;
        List<JsonNode> list2 = arrayNode._children;
        for (int i = 0; i < size; i++) {
            if (!list.get(i).equals(comparator, list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public List<JsonNode> findParents(String str, List<JsonNode> list) {
        Iterator<JsonNode> it = this._children.iterator();
        while (it.hasNext()) {
            list = it.next().findParents(str, list);
        }
        return list;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public JsonNode findValue(String str) {
        Iterator<JsonNode> it = this._children.iterator();
        while (it.hasNext()) {
            JsonNode jsonNodeFindValue = it.next().findValue(str);
            if (jsonNodeFindValue != null) {
                return jsonNodeFindValue;
            }
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public List<JsonNode> findValues(String str, List<JsonNode> list) {
        Iterator<JsonNode> it = this._children.iterator();
        while (it.hasNext()) {
            list = it.next().findValues(str, list);
        }
        return list;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public List<String> findValuesAsText(String str, List<String> list) {
        Iterator<JsonNode> it = this._children.iterator();
        while (it.hasNext()) {
            list = it.next().findValuesAsText(str, list);
        }
        return list;
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode, com.fasterxml.jackson.databind.JsonNode
    public JsonNode get(String str) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public JsonNodeType getNodeType() {
        return JsonNodeType.ARRAY;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode
    public int hashCode() {
        return this._children.hashCode();
    }

    public ArrayNode insert(int i, JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = m38nullNode();
        }
        _insert(i, jsonNode);
        return this;
    }

    public ArrayNode insertArray(int i) {
        ArrayNode arrayNode = arrayNode();
        _insert(i, arrayNode);
        return arrayNode;
    }

    public ArrayNode insertNull(int i) {
        return _insert(i, m38nullNode());
    }

    public ObjectNode insertObject(int i) {
        ObjectNode objectNode = objectNode();
        _insert(i, objectNode);
        return objectNode;
    }

    public ArrayNode insertPOJO(int i, Object obj) {
        return _insert(i, obj == null ? m38nullNode() : pojoNode(obj));
    }

    public ArrayNode insertRawValue(int i, na2 na2Var) {
        return _insert(i, na2Var == null ? m38nullNode() : rawValueNode(na2Var));
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public boolean isArray() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.a.AbstractC0067a
    public boolean isEmpty(an2 an2Var) {
        return this._children.isEmpty();
    }

    public JsonNode remove(int i) {
        if (i < 0 || i >= this._children.size()) {
            return null;
        }
        return this._children.remove(i);
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode
    public JsonNode required(int i) {
        return (i < 0 || i >= this._children.size()) ? (JsonNode) _reportRequiredViolation("No value at index #%d [0, %d) of `ArrayNode`", Integer.valueOf(i), Integer.valueOf(this._children.size())) : this._children.get(i);
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.databind.a
    public void serialize(JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        List<JsonNode> list = this._children;
        int size = list.size();
        jsonGenerator.r1(this, size);
        for (int i = 0; i < size; i++) {
            list.get(i).serialize(jsonGenerator, an2Var);
        }
        jsonGenerator.R0();
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, com.fasterxml.jackson.databind.a
    public void serializeWithType(JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        WritableTypeId writableTypeIdG = z63Var.g(jsonGenerator, z63Var.d(this, JsonToken.START_ARRAY));
        Iterator<JsonNode> it = this._children.iterator();
        while (it.hasNext()) {
            ((BaseJsonNode) it.next()).serialize(jsonGenerator, an2Var);
        }
        z63Var.h(jsonGenerator, writableTypeIdG);
    }

    public JsonNode set(int i, JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = m38nullNode();
        }
        if (i >= 0 && i < this._children.size()) {
            return this._children.set(i, jsonNode);
        }
        throw new IndexOutOfBoundsException("Illegal index " + i + ", array size " + size());
    }

    public ArrayNode setNull(int i) {
        return _set(i, m38nullNode());
    }

    public ArrayNode setPOJO(int i, Object obj) {
        return _set(i, obj == null ? m38nullNode() : pojoNode(obj));
    }

    public ArrayNode setRawValue(int i, na2 na2Var) {
        return _set(i, na2Var == null ? m38nullNode() : rawValueNode(na2Var));
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode, com.fasterxml.jackson.databind.JsonNode
    public int size() {
        return this._children.size();
    }

    public ArrayNode addAll(Collection<? extends JsonNode> collection) {
        Iterator<? extends JsonNode> it = collection.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
        return this;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public ArrayNode deepCopy() {
        ArrayNode arrayNode = new ArrayNode(this._nodeFactory);
        Iterator<JsonNode> it = this._children.iterator();
        while (it.hasNext()) {
            arrayNode._children.add(it.next().deepCopy());
        }
        return arrayNode;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public ObjectNode findParent(String str) {
        Iterator<JsonNode> it = this._children.iterator();
        while (it.hasNext()) {
            JsonNode jsonNodeFindParent = it.next().findParent(str);
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

    @Override // com.fasterxml.jackson.databind.node.ContainerNode
    public ArrayNode removeAll() {
        this._children.clear();
        return this;
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    @Deprecated
    public ObjectNode with(String str) {
        JsonPointer jsonPointer_jsonPointerIfValid = _jsonPointerIfValid(str);
        return jsonPointer_jsonPointerIfValid != null ? withObject(jsonPointer_jsonPointerIfValid) : (ObjectNode) super.with(str);
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public ArrayNode withArray(String str) {
        JsonPointer jsonPointer_jsonPointerIfValid = _jsonPointerIfValid(str);
        return jsonPointer_jsonPointerIfValid != null ? withArray(jsonPointer_jsonPointerIfValid) : (ArrayNode) super.withArray(str);
    }

    public ArrayNode(JsonNodeFactory jsonNodeFactory, int i) {
        super(jsonNodeFactory);
        this._children = new ArrayList(i);
    }

    public ArrayNode add(short s) {
        return _add(m44numberNode(s));
    }

    public ArrayNode insert(int i, short s) {
        return _insert(i, m44numberNode(s));
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public JsonNode path(String str) {
        return MissingNode.getInstance();
    }

    public ArrayNode add(Short sh) {
        return _add(sh == null ? m38nullNode() : m44numberNode(sh.shortValue()));
    }

    @Override // com.fasterxml.jackson.databind.node.ContainerNode, com.fasterxml.jackson.databind.JsonNode
    public JsonNode get(int i) {
        if (i < 0 || i >= this._children.size()) {
            return null;
        }
        return this._children.get(i);
    }

    public ArrayNode insert(int i, Short sh) {
        return _insert(i, sh == null ? m38nullNode() : m44numberNode(sh.shortValue()));
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public JsonNode path(int i) {
        if (i >= 0 && i < this._children.size()) {
            return this._children.get(i);
        }
        return MissingNode.getInstance();
    }

    public ArrayNode(JsonNodeFactory jsonNodeFactory, List<JsonNode> list) {
        super(jsonNodeFactory);
        this._children = list;
    }

    public ArrayNode add(int i) {
        return _add(m42numberNode(i));
    }

    public ArrayNode insert(int i, int i2) {
        return _insert(i, m42numberNode(i2));
    }

    public ArrayNode set(int i, short s) {
        return _set(i, m44numberNode(s));
    }

    public ArrayNode add(Integer num) {
        return _add(num == null ? m38nullNode() : m42numberNode(num.intValue()));
    }

    public ArrayNode insert(int i, Integer num) {
        return _insert(i, num == null ? m38nullNode() : m42numberNode(num.intValue()));
    }

    public ArrayNode set(int i, Short sh) {
        return _set(i, sh == null ? m38nullNode() : m44numberNode(sh.shortValue()));
    }

    public ArrayNode add(long j) {
        return _add(m43numberNode(j));
    }

    public ArrayNode insert(int i, long j) {
        return _insert(i, m43numberNode(j));
    }

    public ArrayNode set(int i, int i2) {
        return _set(i, m42numberNode(i2));
    }

    public ArrayNode add(Long l) {
        return _add(l == null ? m38nullNode() : m43numberNode(l.longValue()));
    }

    @Override // com.fasterxml.jackson.databind.JsonNode
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof ArrayNode)) {
            return this._children.equals(((ArrayNode) obj)._children);
        }
        return false;
    }

    public ArrayNode insert(int i, Long l) {
        return _insert(i, l == null ? m38nullNode() : m43numberNode(l.longValue()));
    }

    public ArrayNode set(int i, Integer num) {
        return _set(i, num == null ? m38nullNode() : m42numberNode(num.intValue()));
    }

    public ArrayNode add(float f) {
        return _add(m41numberNode(f));
    }

    public ArrayNode insert(int i, float f) {
        return _insert(i, m41numberNode(f));
    }

    public ArrayNode set(int i, long j) {
        return _set(i, m43numberNode(j));
    }

    public ArrayNode add(Float f) {
        return _add(f == null ? m38nullNode() : m41numberNode(f.floatValue()));
    }

    public ArrayNode insert(int i, Float f) {
        return _insert(i, f == null ? m38nullNode() : m41numberNode(f.floatValue()));
    }

    public ArrayNode set(int i, Long l) {
        return _set(i, l == null ? m38nullNode() : m43numberNode(l.longValue()));
    }

    public ArrayNode add(double d) {
        return _add(m40numberNode(d));
    }

    public ArrayNode insert(int i, double d) {
        return _insert(i, m40numberNode(d));
    }

    public ArrayNode set(int i, float f) {
        return _set(i, m41numberNode(f));
    }

    public ArrayNode add(Double d) {
        return _add(d == null ? m38nullNode() : m40numberNode(d.doubleValue()));
    }

    public ArrayNode insert(int i, Double d) {
        return _insert(i, d == null ? m38nullNode() : m40numberNode(d.doubleValue()));
    }

    public ArrayNode set(int i, Float f) {
        return _set(i, f == null ? m38nullNode() : m41numberNode(f.floatValue()));
    }

    public ArrayNode add(BigDecimal bigDecimal) {
        return _add(bigDecimal == null ? m38nullNode() : numberNode(bigDecimal));
    }

    public ArrayNode insert(int i, BigDecimal bigDecimal) {
        return _insert(i, bigDecimal == null ? m38nullNode() : numberNode(bigDecimal));
    }

    public ArrayNode set(int i, double d) {
        return _set(i, m40numberNode(d));
    }

    public ArrayNode add(BigInteger bigInteger) {
        return _add(bigInteger == null ? m38nullNode() : numberNode(bigInteger));
    }

    public ArrayNode insert(int i, BigInteger bigInteger) {
        return _insert(i, bigInteger == null ? m38nullNode() : numberNode(bigInteger));
    }

    public ArrayNode set(int i, Double d) {
        return _set(i, d == null ? m38nullNode() : m40numberNode(d.doubleValue()));
    }

    public ArrayNode add(String str) {
        return _add(str == null ? m38nullNode() : m45textNode(str));
    }

    public ArrayNode insert(int i, String str) {
        return _insert(i, str == null ? m38nullNode() : m45textNode(str));
    }

    public ArrayNode set(int i, BigDecimal bigDecimal) {
        return _set(i, bigDecimal == null ? m38nullNode() : numberNode(bigDecimal));
    }

    public ArrayNode add(boolean z) {
        return _add(m37booleanNode(z));
    }

    public ArrayNode insert(int i, boolean z) {
        return _insert(i, m37booleanNode(z));
    }

    public ArrayNode set(int i, BigInteger bigInteger) {
        return _set(i, bigInteger == null ? m38nullNode() : numberNode(bigInteger));
    }

    public ArrayNode add(Boolean bool) {
        return _add(bool == null ? m38nullNode() : m37booleanNode(bool.booleanValue()));
    }

    public ArrayNode insert(int i, Boolean bool) {
        if (bool == null) {
            return insertNull(i);
        }
        return _insert(i, m37booleanNode(bool.booleanValue()));
    }

    public ArrayNode set(int i, String str) {
        return _set(i, str == null ? m38nullNode() : m45textNode(str));
    }

    public ArrayNode add(byte[] bArr) {
        return _add(bArr == null ? m38nullNode() : m35binaryNode(bArr));
    }

    public ArrayNode set(int i, boolean z) {
        return _set(i, m37booleanNode(z));
    }

    public ArrayNode insert(int i, byte[] bArr) {
        if (bArr == null) {
            return insertNull(i);
        }
        return _insert(i, m35binaryNode(bArr));
    }

    public ArrayNode set(int i, Boolean bool) {
        return _set(i, bool == null ? m38nullNode() : m37booleanNode(bool.booleanValue()));
    }

    public ArrayNode set(int i, byte[] bArr) {
        return _set(i, bArr == null ? m38nullNode() : m35binaryNode(bArr));
    }
}
