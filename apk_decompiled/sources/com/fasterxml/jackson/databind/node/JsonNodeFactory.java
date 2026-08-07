package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.databind.JsonNode;
import defpackage.m70;
import defpackage.na2;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes.dex */
public class JsonNodeFactory implements Serializable {
    protected static final int MAX_ELEMENT_INDEX_FOR_INSERT = 9999;
    private static final JsonNodeFactory decimalsAsIs;
    private static final JsonNodeFactory decimalsNormalized;
    public static final JsonNodeFactory instance;
    private static final long serialVersionUID = 1;
    private final boolean _cfgBigDecimalExact;

    static {
        JsonNodeFactory jsonNodeFactory = new JsonNodeFactory(false);
        decimalsNormalized = jsonNodeFactory;
        decimalsAsIs = new JsonNodeFactory(true);
        instance = jsonNodeFactory;
    }

    public JsonNodeFactory(boolean z) {
        this._cfgBigDecimalExact = z;
    }

    public static JsonNodeFactory withExactBigDecimals(boolean z) {
        return z ? decimalsAsIs : decimalsNormalized;
    }

    protected boolean _inIntRange(long j) {
        return ((long) ((int) j)) == j;
    }

    public ArrayNode arrayNode() {
        return new ArrayNode(this);
    }

    public int getMaxElementIndexForInsert() {
        return MAX_ELEMENT_INDEX_FOR_INSERT;
    }

    public JsonNode missingNode() {
        return MissingNode.getInstance();
    }

    public ObjectNode objectNode() {
        return new ObjectNode(this);
    }

    public ValueNode pojoNode(Object obj) {
        return new POJONode(obj);
    }

    public ValueNode rawValueNode(na2 na2Var) {
        return new POJONode(na2Var);
    }

    public ArrayNode arrayNode(int i) {
        return new ArrayNode(this, i);
    }

    /* JADX INFO: renamed from: booleanNode, reason: merged with bridge method [inline-methods] */
    public BooleanNode m48booleanNode(boolean z) {
        return z ? BooleanNode.getTrue() : BooleanNode.getFalse();
    }

    /* JADX INFO: renamed from: nullNode, reason: merged with bridge method [inline-methods] */
    public NullNode m49nullNode() {
        return NullNode.getInstance();
    }

    /* JADX INFO: renamed from: textNode, reason: merged with bridge method [inline-methods] */
    public TextNode m56textNode(String str) {
        return TextNode.valueOf(str);
    }

    protected JsonNodeFactory() {
        this(false);
    }

    /* JADX INFO: renamed from: binaryNode, reason: merged with bridge method [inline-methods] */
    public BinaryNode m46binaryNode(byte[] bArr) {
        return BinaryNode.valueOf(bArr);
    }

    /* JADX INFO: renamed from: binaryNode, reason: merged with bridge method [inline-methods] */
    public BinaryNode m47binaryNode(byte[] bArr, int i, int i2) {
        return BinaryNode.valueOf(bArr, i, i2);
    }

    /* JADX INFO: renamed from: numberNode, reason: merged with bridge method [inline-methods] */
    public NumericNode m50numberNode(byte b) {
        return IntNode.valueOf(b);
    }

    public ValueNode numberNode(Byte b) {
        return b == null ? m49nullNode() : IntNode.valueOf(b.intValue());
    }

    /* JADX INFO: renamed from: numberNode, reason: merged with bridge method [inline-methods] */
    public NumericNode m55numberNode(short s) {
        return ShortNode.valueOf(s);
    }

    public ValueNode numberNode(Short sh) {
        return sh == null ? m49nullNode() : ShortNode.valueOf(sh.shortValue());
    }

    /* JADX INFO: renamed from: numberNode, reason: merged with bridge method [inline-methods] */
    public NumericNode m53numberNode(int i) {
        return IntNode.valueOf(i);
    }

    public ValueNode numberNode(Integer num) {
        return num == null ? m49nullNode() : IntNode.valueOf(num.intValue());
    }

    /* JADX INFO: renamed from: numberNode, reason: merged with bridge method [inline-methods] */
    public NumericNode m54numberNode(long j) {
        return LongNode.valueOf(j);
    }

    public ValueNode numberNode(Long l) {
        if (l == null) {
            return m49nullNode();
        }
        return LongNode.valueOf(l.longValue());
    }

    public ValueNode numberNode(BigInteger bigInteger) {
        if (bigInteger == null) {
            return m49nullNode();
        }
        return BigIntegerNode.valueOf(bigInteger);
    }

    /* JADX INFO: renamed from: numberNode, reason: merged with bridge method [inline-methods] */
    public NumericNode m52numberNode(float f) {
        return FloatNode.valueOf(f);
    }

    public ValueNode numberNode(Float f) {
        return f == null ? m49nullNode() : FloatNode.valueOf(f.floatValue());
    }

    /* JADX INFO: renamed from: numberNode, reason: merged with bridge method [inline-methods] */
    public NumericNode m51numberNode(double d) {
        return DoubleNode.valueOf(d);
    }

    public ValueNode numberNode(Double d) {
        return d == null ? m49nullNode() : DoubleNode.valueOf(d.doubleValue());
    }

    public ValueNode numberNode(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return m49nullNode();
        }
        if (this._cfgBigDecimalExact) {
            return DecimalNode.valueOf(bigDecimal);
        }
        if (bigDecimal.signum() == 0) {
            return DecimalNode.ZERO;
        }
        try {
            bigDecimal = m70.a(bigDecimal);
        } catch (ArithmeticException unused) {
        }
        return DecimalNode.valueOf(bigDecimal);
    }
}
