package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import defpackage.ay;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class JsonNode extends com.fasterxml.jackson.databind.a.AbstractC0067a implements com.fasterxml.jackson.core.d, Iterable {

    public enum OverwriteMode {
        NONE,
        NULLS,
        SCALARS,
        ALL
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonNodeType.values().length];
            a = iArr;
            try {
                iArr[JsonNodeType.ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonNodeType.OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonNodeType.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    protected JsonNode() {
    }

    protected abstract JsonNode _at(JsonPointer jsonPointer);

    protected <T> T _reportRequiredViolation(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected <T extends JsonNode> T _this() {
        return this;
    }

    public boolean asBoolean(boolean z) {
        return z;
    }

    public double asDouble(double d) {
        return d;
    }

    public int asInt(int i) {
        return i;
    }

    public long asLong(long j) {
        return j;
    }

    public abstract String asText();

    public String asText(String str) {
        String strAsText = asText();
        return strAsText == null ? str : strAsText;
    }

    public BigInteger bigIntegerValue() {
        return BigInteger.ZERO;
    }

    public byte[] binaryValue() throws IOException {
        return null;
    }

    public boolean booleanValue() {
        return false;
    }

    public boolean canConvertToExactIntegral() {
        return isIntegralNumber();
    }

    public boolean canConvertToInt() {
        return false;
    }

    public boolean canConvertToLong() {
        return false;
    }

    public BigDecimal decimalValue() {
        return BigDecimal.ZERO;
    }

    public abstract <T extends JsonNode> T deepCopy();

    public double doubleValue() {
        return 0.0d;
    }

    public Iterator<JsonNode> elements() {
        return ay.n();
    }

    public abstract boolean equals(Object obj);

    public boolean equals(Comparator<JsonNode> comparator, JsonNode jsonNode) {
        return comparator.compare(this, jsonNode) == 0;
    }

    public Iterator<String> fieldNames() {
        return ay.n();
    }

    public Iterator<Map.Entry<String, JsonNode>> fields() {
        return ay.n();
    }

    public abstract JsonNode findParent(String str);

    public final List<JsonNode> findParents(String str) {
        List<JsonNode> listFindParents = findParents(str, null);
        return listFindParents == null ? Collections.emptyList() : listFindParents;
    }

    public abstract List<JsonNode> findParents(String str, List<JsonNode> list);

    public abstract JsonNode findValue(String str);

    public final List<JsonNode> findValues(String str) {
        List<JsonNode> listFindValues = findValues(str, null);
        return listFindValues == null ? Collections.emptyList() : listFindValues;
    }

    public abstract List<JsonNode> findValues(String str, List<JsonNode> list);

    public final List<String> findValuesAsText(String str) {
        List<String> listFindValuesAsText = findValuesAsText(str, null);
        return listFindValuesAsText == null ? Collections.emptyList() : listFindValuesAsText;
    }

    public abstract List<String> findValuesAsText(String str, List<String> list);

    public float floatValue() {
        return 0.0f;
    }

    @Override // 
    public abstract JsonNode get(int i);

    @Override // 
    public JsonNode get(String str) {
        return null;
    }

    public abstract JsonNodeType getNodeType();

    public boolean has(String str) {
        return get(str) != null;
    }

    public boolean hasNonNull(String str) {
        JsonNode jsonNode = get(str);
        return (jsonNode == null || jsonNode.isNull()) ? false : true;
    }

    public int intValue() {
        return 0;
    }

    public boolean isArray() {
        return false;
    }

    public boolean isBigDecimal() {
        return false;
    }

    public boolean isBigInteger() {
        return false;
    }

    public final boolean isBinary() {
        return getNodeType() == JsonNodeType.BINARY;
    }

    public final boolean isBoolean() {
        return getNodeType() == JsonNodeType.BOOLEAN;
    }

    public final boolean isContainerNode() {
        JsonNodeType nodeType = getNodeType();
        return nodeType == JsonNodeType.OBJECT || nodeType == JsonNodeType.ARRAY;
    }

    public boolean isDouble() {
        return false;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFloat() {
        return false;
    }

    public boolean isFloatingPointNumber() {
        return false;
    }

    public boolean isInt() {
        return false;
    }

    public boolean isIntegralNumber() {
        return false;
    }

    public boolean isLong() {
        return false;
    }

    public boolean isMissingNode() {
        return false;
    }

    public final boolean isNull() {
        return getNodeType() == JsonNodeType.NULL;
    }

    public final boolean isNumber() {
        return getNodeType() == JsonNodeType.NUMBER;
    }

    public boolean isObject() {
        return false;
    }

    public final boolean isPojo() {
        return getNodeType() == JsonNodeType.POJO;
    }

    public boolean isShort() {
        return false;
    }

    public final boolean isTextual() {
        return getNodeType() == JsonNodeType.STRING;
    }

    public final boolean isValueNode() {
        int i = a.a[getNodeType().ordinal()];
        return (i == 1 || i == 2 || i == 3) ? false : true;
    }

    @Override // java.lang.Iterable
    public final Iterator<JsonNode> iterator() {
        return elements();
    }

    public long longValue() {
        return 0L;
    }

    public Number numberValue() {
        return null;
    }

    @Override // 
    public abstract JsonNode path(int i);

    @Override // 
    public abstract JsonNode path(String str);

    public <T extends JsonNode> T require() throws IllegalArgumentException {
        return (T) _this();
    }

    public <T extends JsonNode> T requireNonNull() throws IllegalArgumentException {
        return (T) _this();
    }

    public JsonNode requiredAt(String str) throws IllegalArgumentException {
        return requiredAt(JsonPointer.compile(str));
    }

    public short shortValue() {
        return (short) 0;
    }

    public int size() {
        return 0;
    }

    public String textValue() {
        return null;
    }

    @Deprecated
    public <T extends JsonNode> T with(String str) {
        throw new UnsupportedOperationException("`JsonNode` not of type `ObjectNode` (but " + getClass().getName() + "), cannot call `with(String)` on it");
    }

    public <T extends JsonNode> T withArray(String str) {
        throw new UnsupportedOperationException("`JsonNode` not of type `ObjectNode` (but `" + getClass().getName() + ")`, cannot call `withArray()` on it");
    }

    public abstract ArrayNode withArray(JsonPointer jsonPointer, OverwriteMode overwriteMode, boolean z);

    public abstract ObjectNode withObject(JsonPointer jsonPointer, OverwriteMode overwriteMode, boolean z);

    public final ObjectNode withObject(String str) {
        return withObject(JsonPointer.compile(str));
    }

    public boolean asBoolean() {
        return asBoolean(false);
    }

    public double asDouble() {
        return asDouble(0.0d);
    }

    public int asInt() {
        return asInt(0);
    }

    public long asLong() {
        return asLong(0L);
    }

    public boolean has(int i) {
        return get(i) != null;
    }

    public final JsonNode requiredAt(JsonPointer jsonPointer) throws IllegalArgumentException {
        JsonNode jsonNode_at = this;
        for (JsonPointer jsonPointerTail = jsonPointer; !jsonPointerTail.matches(); jsonPointerTail = jsonPointerTail.tail()) {
            jsonNode_at = jsonNode_at._at(jsonPointerTail);
            if (jsonNode_at == null) {
                _reportRequiredViolation("No node at '%s' (unmatched part: '%s')", jsonPointer, jsonPointerTail);
            }
        }
        return jsonNode_at;
    }

    public final ObjectNode withObject(String str, OverwriteMode overwriteMode, boolean z) {
        return withObject(JsonPointer.compile(str), overwriteMode, z);
    }

    public final JsonNode at(JsonPointer jsonPointer) {
        if (jsonPointer.matches()) {
            return this;
        }
        JsonNode jsonNode_at = _at(jsonPointer);
        if (jsonNode_at == null) {
            return MissingNode.getInstance();
        }
        return jsonNode_at.at(jsonPointer.tail());
    }

    public boolean hasNonNull(int i) {
        JsonNode jsonNode = get(i);
        return (jsonNode == null || jsonNode.isNull()) ? false : true;
    }

    public ArrayNode withArray(String str, OverwriteMode overwriteMode, boolean z) {
        return withArray(JsonPointer.compile(str), overwriteMode, z);
    }

    public final ObjectNode withObject(JsonPointer jsonPointer) {
        return withObject(jsonPointer, OverwriteMode.NULLS, true);
    }

    public final ArrayNode withArray(JsonPointer jsonPointer) {
        return withArray(jsonPointer, OverwriteMode.NULLS, true);
    }

    public final JsonNode at(String str) {
        return at(JsonPointer.compile(str));
    }
}
