package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.cfg.JsonNodeFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ContainerNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.LogicalType;
import defpackage.m63;
import defpackage.na2;
import defpackage.s51;
import defpackage.v30;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseNodeDeserializer<T extends JsonNode> extends StdDeserializer<T> implements v30 {
    protected final boolean _mergeArrays;
    protected final boolean _mergeObjects;
    protected final Boolean _supportsUpdates;

    static final class a {
        private ContainerNode[] a;
        private int b;
        private int c;

        public ContainerNode a() {
            int i = this.b;
            if (i == 0) {
                return null;
            }
            ContainerNode[] containerNodeArr = this.a;
            int i2 = i - 1;
            this.b = i2;
            return containerNodeArr[i2];
        }

        public void b(ContainerNode containerNode) {
            int i = this.b;
            int i2 = this.c;
            if (i < i2) {
                ContainerNode[] containerNodeArr = this.a;
                this.b = i + 1;
                containerNodeArr[i] = containerNode;
                return;
            }
            if (this.a == null) {
                this.c = 10;
                this.a = new ContainerNode[10];
            } else {
                int iMin = i2 + Math.min(4000, Math.max(20, i2 >> 1));
                this.c = iMin;
                this.a = (ContainerNode[]) Arrays.copyOf(this.a, iMin);
            }
            ContainerNode[] containerNodeArr2 = this.a;
            int i3 = this.b;
            this.b = i3 + 1;
            containerNodeArr2[i3] = containerNode;
        }
    }

    public BaseNodeDeserializer(Class<T> cls, Boolean bool) {
        super((Class<?>) cls);
        this._supportsUpdates = bool;
        this._mergeArrays = true;
        this._mergeObjects = true;
    }

    private static boolean _shouldMerge(Boolean bool, Boolean bool2) {
        if (bool != null) {
            return bool.booleanValue();
        }
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        return true;
    }

    protected abstract s51 _createWithMerge(boolean z, boolean z2);

    protected final JsonNode _deserializeAnyScalar(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNodeFactory nodeFactory = deserializationContext.getNodeFactory();
        int iV = jsonParser.V();
        if (iV == 2) {
            return nodeFactory.objectNode();
        }
        switch (iV) {
            case 6:
                return nodeFactory.m56textNode(jsonParser.S0());
            case 7:
                return _fromInt(jsonParser, deserializationContext, nodeFactory);
            case 8:
                return _fromFloat(jsonParser, deserializationContext, nodeFactory);
            case 9:
                return nodeFactory.m48booleanNode(true);
            case 10:
                return nodeFactory.m48booleanNode(false);
            case 11:
                return nodeFactory.m49nullNode();
            case 12:
                return _fromEmbedded(jsonParser, deserializationContext);
            default:
                return (JsonNode) deserializationContext.handleUnexpectedToken(handledType(), jsonParser);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004a  */
    /* JADX WARN: Code duplicated, block: B:28:0x007e  */
    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0035. Please report as an issue. */
    protected final ContainerNode<?> _deserializeContainerNoRecursion(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory, a aVar, ContainerNode<?> containerNode) throws IOException {
        JsonNode jsonNodeM56textNode;
        JsonNode jsonNode;
        JsonNode jsonNodeReplace;
        int deserializationFeatures = deserializationContext.getDeserializationFeatures() & StdDeserializer.F_MASK_INT_COERCIONS;
        ContainerNode containerNodeObjectNode = containerNode;
        do {
            boolean z = true;
            if (!(containerNodeObjectNode instanceof ObjectNode)) {
                ArrayNode arrayNode = (ArrayNode) containerNodeObjectNode;
                while (true) {
                    JsonToken jsonTokenN1 = jsonParser.n1();
                    if (jsonTokenN1 == null) {
                        jsonTokenN1 = JsonToken.NOT_AVAILABLE;
                    }
                    switch (jsonTokenN1.id()) {
                        case 1:
                            aVar.b(containerNodeObjectNode);
                            containerNodeObjectNode = jsonNodeFactory.objectNode();
                            arrayNode.add(containerNodeObjectNode);
                            break;
                        case 2:
                        case 5:
                        default:
                            arrayNode.add(_deserializeRareScalar(jsonParser, deserializationContext));
                            break;
                        case 3:
                            aVar.b(containerNodeObjectNode);
                            containerNodeObjectNode = jsonNodeFactory.arrayNode();
                            arrayNode.add(containerNodeObjectNode);
                            break;
                        case 4:
                            containerNodeObjectNode = aVar.a();
                            break;
                        case 6:
                            arrayNode.add(jsonNodeFactory.m56textNode(jsonParser.S0()));
                            break;
                        case 7:
                            arrayNode.add(_fromInt(jsonParser, deserializationFeatures, jsonNodeFactory));
                            break;
                        case 8:
                            arrayNode.add(_fromFloat(jsonParser, deserializationContext, jsonNodeFactory));
                            break;
                        case 9:
                            arrayNode.add(jsonNodeFactory.m48booleanNode(true));
                            break;
                        case 10:
                            arrayNode.add(jsonNodeFactory.m48booleanNode(false));
                            break;
                        case 11:
                            arrayNode.add(jsonNodeFactory.m49nullNode());
                            break;
                    }
                }
            } else {
                ContainerNode containerNode2 = containerNodeObjectNode;
                ObjectNode objectNode = (ObjectNode) containerNodeObjectNode;
                String strL1 = jsonParser.l1();
                while (true) {
                    if (strL1 == null) {
                        containerNodeObjectNode = aVar.a();
                    } else {
                        JsonToken jsonTokenN2 = jsonParser.n1();
                        if (jsonTokenN2 == null) {
                            jsonTokenN2 = JsonToken.NOT_AVAILABLE;
                        }
                        int iId = jsonTokenN2.id();
                        if (iId == z) {
                            ObjectNode objectNode2 = objectNode;
                            ObjectNode objectNode3 = jsonNodeFactory.objectNode();
                            JsonNode jsonNodeReplace2 = objectNode2.replace(strL1, objectNode3);
                            if (jsonNodeReplace2 != null) {
                                _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, strL1, objectNode2, jsonNodeReplace2, objectNode3);
                            }
                            aVar.b(containerNode2);
                            objectNode = objectNode3;
                            containerNode2 = objectNode;
                        } else if (iId != 3) {
                            switch (iId) {
                                case 6:
                                    jsonNodeM56textNode = jsonNodeFactory.m56textNode(jsonParser.S0());
                                    jsonNode = jsonNodeM56textNode;
                                    jsonNodeReplace = objectNode.replace(strL1, jsonNode);
                                    if (jsonNodeReplace != null) {
                                        _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, strL1, objectNode, jsonNodeReplace, jsonNode);
                                    }
                                    break;
                                case 7:
                                    jsonNodeM56textNode = _fromInt(jsonParser, deserializationFeatures, jsonNodeFactory);
                                    jsonNode = jsonNodeM56textNode;
                                    jsonNodeReplace = objectNode.replace(strL1, jsonNode);
                                    if (jsonNodeReplace != null) {
                                        _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, strL1, objectNode, jsonNodeReplace, jsonNode);
                                    }
                                    break;
                                case 8:
                                    jsonNodeM56textNode = _fromFloat(jsonParser, deserializationContext, jsonNodeFactory);
                                    jsonNode = jsonNodeM56textNode;
                                    jsonNodeReplace = objectNode.replace(strL1, jsonNode);
                                    if (jsonNodeReplace != null) {
                                        _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, strL1, objectNode, jsonNodeReplace, jsonNode);
                                    }
                                    break;
                                case 9:
                                    jsonNodeM56textNode = jsonNodeFactory.m48booleanNode(z);
                                    jsonNode = jsonNodeM56textNode;
                                    jsonNodeReplace = objectNode.replace(strL1, jsonNode);
                                    if (jsonNodeReplace != null) {
                                        _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, strL1, objectNode, jsonNodeReplace, jsonNode);
                                    }
                                    break;
                                case 10:
                                    jsonNodeM56textNode = jsonNodeFactory.m48booleanNode(false);
                                    jsonNode = jsonNodeM56textNode;
                                    jsonNodeReplace = objectNode.replace(strL1, jsonNode);
                                    if (jsonNodeReplace != null) {
                                        _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, strL1, objectNode, jsonNodeReplace, jsonNode);
                                    }
                                    break;
                                case 11:
                                    if (deserializationContext.isEnabled(JsonNodeFeature.READ_NULL_PROPERTIES)) {
                                        jsonNodeM56textNode = jsonNodeFactory.m49nullNode();
                                        jsonNode = jsonNodeM56textNode;
                                        jsonNodeReplace = objectNode.replace(strL1, jsonNode);
                                        if (jsonNodeReplace != null) {
                                            _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, strL1, objectNode, jsonNodeReplace, jsonNode);
                                        }
                                    }
                                    break;
                                default:
                                    jsonNodeM56textNode = _deserializeRareScalar(jsonParser, deserializationContext);
                                    jsonNode = jsonNodeM56textNode;
                                    jsonNodeReplace = objectNode.replace(strL1, jsonNode);
                                    if (jsonNodeReplace != null) {
                                        _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, strL1, objectNode, jsonNodeReplace, jsonNode);
                                    }
                                    break;
                            }
                            objectNode = objectNode;
                        } else {
                            ObjectNode objectNode4 = objectNode;
                            ContainerNode containerNodeArrayNode = jsonNodeFactory.arrayNode();
                            JsonNode jsonNodeReplace3 = objectNode4.replace(strL1, containerNodeArrayNode);
                            if (jsonNodeReplace3 != null) {
                                _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, strL1, objectNode4, jsonNodeReplace3, containerNodeArrayNode);
                            }
                            aVar.b(containerNode2);
                            containerNodeObjectNode = containerNodeArrayNode;
                        }
                        strL1 = jsonParser.l1();
                        z = true;
                    }
                }
            }
        } while (containerNodeObjectNode != null);
        return containerNode;
    }

    protected final ObjectNode _deserializeObjectAtName(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory, a aVar) throws IOException {
        JsonNode jsonNode_deserializeContainerNoRecursion;
        ObjectNode objectNode = jsonNodeFactory.objectNode();
        String strC = jsonParser.C();
        while (strC != null) {
            JsonToken jsonTokenN1 = jsonParser.n1();
            if (jsonTokenN1 == null) {
                jsonTokenN1 = JsonToken.NOT_AVAILABLE;
            }
            int iId = jsonTokenN1.id();
            if (iId != 1) {
                jsonNode_deserializeContainerNoRecursion = iId != 3 ? _deserializeAnyScalar(jsonParser, deserializationContext) : _deserializeContainerNoRecursion(jsonParser, deserializationContext, jsonNodeFactory, aVar, jsonNodeFactory.arrayNode());
            } else {
                jsonNode_deserializeContainerNoRecursion = _deserializeContainerNoRecursion(jsonParser, deserializationContext, jsonNodeFactory, aVar, jsonNodeFactory.objectNode());
            }
            JsonNode jsonNode = jsonNode_deserializeContainerNoRecursion;
            JsonNode jsonNodeReplace = objectNode.replace(strC, jsonNode);
            if (jsonNodeReplace != null) {
                _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, strC, objectNode, jsonNodeReplace, jsonNode);
            }
            strC = jsonParser.l1();
        }
        return objectNode;
    }

    protected final JsonNode _deserializeRareScalar(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        int iV = jsonParser.V();
        if (iV == 2) {
            return deserializationContext.getNodeFactory().objectNode();
        }
        if (iV != 8) {
            return iV != 12 ? (JsonNode) deserializationContext.handleUnexpectedToken(handledType(), jsonParser) : _fromEmbedded(jsonParser, deserializationContext);
        }
        return _fromFloat(jsonParser, deserializationContext, deserializationContext.getNodeFactory());
    }

    protected final JsonNode _fromEmbedded(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNodeFactory nodeFactory = deserializationContext.getNodeFactory();
        Object objH0 = jsonParser.H0();
        if (objH0 == null) {
            return nodeFactory.m49nullNode();
        }
        if (objH0.getClass() == byte[].class) {
            return nodeFactory.m46binaryNode((byte[]) objH0);
        }
        if (objH0 instanceof na2) {
            return nodeFactory.rawValueNode((na2) objH0);
        }
        return objH0 instanceof JsonNode ? (JsonNode) objH0 : nodeFactory.pojoNode(objH0);
    }

    protected final JsonNode _fromFloat(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        JsonParser.NumberType numberTypeL0 = jsonParser.L0();
        if (numberTypeL0 == JsonParser.NumberType.BIG_DECIMAL) {
            return jsonNodeFactory.numberNode(jsonParser.F0());
        }
        if (deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
            return jsonParser.k1() ? jsonNodeFactory.m51numberNode(jsonParser.G0()) : jsonNodeFactory.numberNode(jsonParser.F0());
        }
        return numberTypeL0 == JsonParser.NumberType.FLOAT ? jsonNodeFactory.m52numberNode(jsonParser.I0()) : jsonNodeFactory.m51numberNode(jsonParser.G0());
    }

    protected final JsonNode _fromInt(JsonParser jsonParser, int i, JsonNodeFactory jsonNodeFactory) throws IOException {
        if (i != 0) {
            return DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(i) ? jsonNodeFactory.numberNode(jsonParser.e0()) : jsonNodeFactory.m54numberNode(jsonParser.K0());
        }
        JsonParser.NumberType numberTypeL0 = jsonParser.L0();
        if (numberTypeL0 == JsonParser.NumberType.INT) {
            return jsonNodeFactory.m53numberNode(jsonParser.J0());
        }
        return numberTypeL0 == JsonParser.NumberType.LONG ? jsonNodeFactory.m54numberNode(jsonParser.K0()) : jsonNodeFactory.numberNode(jsonParser.e0());
    }

    protected void _handleDuplicateField(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory, String str, ObjectNode objectNode, JsonNode jsonNode, JsonNode jsonNode2) throws IOException {
        if (deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY)) {
            deserializationContext.reportInputMismatch(JsonNode.class, "Duplicate field '%s' for `ObjectNode`: not allowed when `DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY` enabled", str);
        }
        if (deserializationContext.isEnabled(StreamReadCapability.DUPLICATE_PROPERTIES)) {
            if (jsonNode.isArray()) {
                ((ArrayNode) jsonNode).add(jsonNode2);
                objectNode.replace(str, jsonNode);
            } else {
                ArrayNode arrayNode = jsonNodeFactory.arrayNode();
                arrayNode.add(jsonNode);
                arrayNode.add(jsonNode2);
                objectNode.replace(str, arrayNode);
            }
        }
    }

    @Override // defpackage.v30
    public s51 createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        Boolean defaultMergeable = config.getDefaultMergeable(ArrayNode.class);
        Boolean defaultMergeable2 = config.getDefaultMergeable(ObjectNode.class);
        Boolean defaultMergeable3 = config.getDefaultMergeable(JsonNode.class);
        boolean z_shouldMerge = _shouldMerge(defaultMergeable, defaultMergeable3);
        boolean z_shouldMerge2 = _shouldMerge(defaultMergeable2, defaultMergeable3);
        return (z_shouldMerge == this._mergeArrays && z_shouldMerge2 == this._mergeObjects) ? this : _createWithMerge(z_shouldMerge, z_shouldMerge2);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        return m63Var.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    @Override // defpackage.s51
    public boolean isCachable() {
        return true;
    }

    @Override // defpackage.s51
    public LogicalType logicalType() {
        return LogicalType.Untyped;
    }

    @Override // defpackage.s51
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return this._supportsUpdates;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0061 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x0063  */
    /* JADX WARN: Code duplicated, block: B:34:0x006c  */
    /* JADX WARN: Code duplicated, block: B:36:0x006f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0072  */
    /* JADX WARN: Code duplicated, block: B:40:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007d  */
    /* JADX WARN: Code duplicated, block: B:45:0x0086  */
    /* JADX WARN: Code duplicated, block: B:46:0x008b  */
    /* JADX WARN: Code duplicated, block: B:47:0x0091  */
    /* JADX WARN: Code duplicated, block: B:48:0x0096  */
    /* JADX WARN: Code duplicated, block: B:49:0x009b  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c2 A[SYNTHETIC] */
    protected final JsonNode updateObject(JsonParser jsonParser, DeserializationContext deserializationContext, ObjectNode objectNode, a aVar) throws IOException {
        String strC;
        int iId;
        JsonNode jsonNode_deserializeContainerNoRecursion;
        if (jsonParser.j1()) {
            strC = jsonParser.l1();
        } else {
            if (!jsonParser.d1(JsonToken.FIELD_NAME)) {
                return (JsonNode) deserialize(jsonParser, deserializationContext);
            }
            strC = jsonParser.C();
        }
        JsonNodeFactory nodeFactory = deserializationContext.getNodeFactory();
        while (strC != null) {
            JsonToken jsonTokenN1 = jsonParser.n1();
            JsonNode jsonNode = objectNode.get(strC);
            if (jsonNode == null) {
                if (jsonTokenN1 == null) {
                    jsonTokenN1 = JsonToken.NOT_AVAILABLE;
                }
                iId = jsonTokenN1.id();
                if (iId == 1) {
                    jsonNode_deserializeContainerNoRecursion = _deserializeContainerNoRecursion(jsonParser, deserializationContext, nodeFactory, aVar, nodeFactory.objectNode());
                } else if (iId == 3) {
                    jsonNode_deserializeContainerNoRecursion = _deserializeContainerNoRecursion(jsonParser, deserializationContext, nodeFactory, aVar, nodeFactory.arrayNode());
                } else if (iId == 6) {
                    jsonNode_deserializeContainerNoRecursion = nodeFactory.m56textNode(jsonParser.S0());
                } else if (iId != 7) {
                    switch (iId) {
                        case 9:
                            jsonNode_deserializeContainerNoRecursion = nodeFactory.m48booleanNode(true);
                            break;
                        case 10:
                            jsonNode_deserializeContainerNoRecursion = nodeFactory.m48booleanNode(false);
                            break;
                        case 11:
                            if (deserializationContext.isEnabled(JsonNodeFeature.READ_NULL_PROPERTIES)) {
                                jsonNode_deserializeContainerNoRecursion = nodeFactory.m49nullNode();
                            }
                            break;
                        default:
                            jsonNode_deserializeContainerNoRecursion = _deserializeRareScalar(jsonParser, deserializationContext);
                            break;
                    }
                } else {
                    jsonNode_deserializeContainerNoRecursion = _fromInt(jsonParser, deserializationContext, nodeFactory);
                }
                objectNode.set(strC, jsonNode_deserializeContainerNoRecursion);
            } else if (jsonNode instanceof ObjectNode) {
                if (jsonTokenN1 == JsonToken.START_OBJECT && this._mergeObjects) {
                    JsonNode jsonNodeUpdateObject = updateObject(jsonParser, deserializationContext, (ObjectNode) jsonNode, aVar);
                    if (jsonNodeUpdateObject != jsonNode) {
                        objectNode.set(strC, jsonNodeUpdateObject);
                    }
                } else {
                    if (jsonTokenN1 == null) {
                        jsonTokenN1 = JsonToken.NOT_AVAILABLE;
                    }
                    iId = jsonTokenN1.id();
                    if (iId == 1) {
                        jsonNode_deserializeContainerNoRecursion = _deserializeContainerNoRecursion(jsonParser, deserializationContext, nodeFactory, aVar, nodeFactory.objectNode());
                    } else if (iId == 3) {
                        jsonNode_deserializeContainerNoRecursion = _deserializeContainerNoRecursion(jsonParser, deserializationContext, nodeFactory, aVar, nodeFactory.arrayNode());
                    } else if (iId == 6) {
                        jsonNode_deserializeContainerNoRecursion = nodeFactory.m56textNode(jsonParser.S0());
                    } else if (iId != 7) {
                        switch (iId) {
                            case 9:
                                jsonNode_deserializeContainerNoRecursion = nodeFactory.m48booleanNode(true);
                                break;
                            case 10:
                                jsonNode_deserializeContainerNoRecursion = nodeFactory.m48booleanNode(false);
                                break;
                            case 11:
                                if (deserializationContext.isEnabled(JsonNodeFeature.READ_NULL_PROPERTIES)) {
                                    jsonNode_deserializeContainerNoRecursion = nodeFactory.m49nullNode();
                                }
                                break;
                            default:
                                jsonNode_deserializeContainerNoRecursion = _deserializeRareScalar(jsonParser, deserializationContext);
                                break;
                        }
                    } else {
                        jsonNode_deserializeContainerNoRecursion = _fromInt(jsonParser, deserializationContext, nodeFactory);
                    }
                    objectNode.set(strC, jsonNode_deserializeContainerNoRecursion);
                }
            } else if ((jsonNode instanceof ArrayNode) && jsonTokenN1 == JsonToken.START_ARRAY && this._mergeArrays) {
                _deserializeContainerNoRecursion(jsonParser, deserializationContext, nodeFactory, aVar, (ArrayNode) jsonNode);
            } else {
                if (jsonTokenN1 == null) {
                    jsonTokenN1 = JsonToken.NOT_AVAILABLE;
                }
                iId = jsonTokenN1.id();
                if (iId == 1) {
                    jsonNode_deserializeContainerNoRecursion = _deserializeContainerNoRecursion(jsonParser, deserializationContext, nodeFactory, aVar, nodeFactory.objectNode());
                } else if (iId == 3) {
                    jsonNode_deserializeContainerNoRecursion = _deserializeContainerNoRecursion(jsonParser, deserializationContext, nodeFactory, aVar, nodeFactory.arrayNode());
                } else if (iId == 6) {
                    jsonNode_deserializeContainerNoRecursion = nodeFactory.m56textNode(jsonParser.S0());
                } else if (iId != 7) {
                    switch (iId) {
                        case 9:
                            jsonNode_deserializeContainerNoRecursion = nodeFactory.m48booleanNode(true);
                            break;
                        case 10:
                            jsonNode_deserializeContainerNoRecursion = nodeFactory.m48booleanNode(false);
                            break;
                        case 11:
                            if (deserializationContext.isEnabled(JsonNodeFeature.READ_NULL_PROPERTIES)) {
                                jsonNode_deserializeContainerNoRecursion = nodeFactory.m49nullNode();
                            }
                            break;
                        default:
                            jsonNode_deserializeContainerNoRecursion = _deserializeRareScalar(jsonParser, deserializationContext);
                            break;
                    }
                } else {
                    jsonNode_deserializeContainerNoRecursion = _fromInt(jsonParser, deserializationContext, nodeFactory);
                }
                objectNode.set(strC, jsonNode_deserializeContainerNoRecursion);
            }
            strC = jsonParser.l1();
        }
        return objectNode;
    }

    protected BaseNodeDeserializer(BaseNodeDeserializer<?> baseNodeDeserializer, boolean z, boolean z2) {
        super(baseNodeDeserializer);
        this._supportsUpdates = baseNodeDeserializer._supportsUpdates;
        this._mergeArrays = z;
        this._mergeObjects = z2;
    }

    protected final JsonNode _fromInt(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        JsonParser.NumberType numberTypeL0;
        int deserializationFeatures = deserializationContext.getDeserializationFeatures();
        if ((StdDeserializer.F_MASK_INT_COERCIONS & deserializationFeatures) != 0) {
            if (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(deserializationFeatures)) {
                numberTypeL0 = JsonParser.NumberType.BIG_INTEGER;
            } else if (DeserializationFeature.USE_LONG_FOR_INTS.enabledIn(deserializationFeatures)) {
                numberTypeL0 = JsonParser.NumberType.LONG;
            } else {
                numberTypeL0 = jsonParser.L0();
            }
        } else {
            numberTypeL0 = jsonParser.L0();
        }
        if (numberTypeL0 == JsonParser.NumberType.INT) {
            return jsonNodeFactory.m53numberNode(jsonParser.J0());
        }
        if (numberTypeL0 == JsonParser.NumberType.LONG) {
            return jsonNodeFactory.m54numberNode(jsonParser.K0());
        }
        return jsonNodeFactory.numberNode(jsonParser.e0());
    }
}
