package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import defpackage.ag2;
import defpackage.ay;
import defpackage.e41;
import defpackage.it1;
import defpackage.m63;
import defpackage.s51;
import defpackage.v30;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@e41
public class UntypedObjectDeserializer extends StdDeserializer<Object> implements ag2, v30 {
    protected static final Object[] NO_OBJECTS = new Object[0];
    private static final long serialVersionUID = 1;
    protected s51 _listDeserializer;
    protected JavaType _listType;
    protected s51 _mapDeserializer;
    protected JavaType _mapType;
    protected final boolean _nonMerging;
    protected s51 _numberDeserializer;
    protected s51 _stringDeserializer;

    @e41
    @Deprecated
    public static class Vanilla extends StdDeserializer<Object> {
        private static final long serialVersionUID = 1;
        public static final Vanilla std = new Vanilla();
        protected final boolean _nonMerging;

        public Vanilla() {
            this(false);
        }

        private void _squashDups(Map<String, Object> map, String str, Object obj, Object obj2) {
            if (obj instanceof List) {
                ((List) obj).add(obj2);
                map.put(str, obj);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(obj);
                arrayList.add(obj2);
                map.put(str, arrayList);
            }
        }

        public static Vanilla instance(boolean z) {
            return z ? new Vanilla(true) : std;
        }

        protected Object _mapObjectWithDups(JsonParser jsonParser, DeserializationContext deserializationContext, Map<String, Object> map, String str, Object obj, Object obj2, String str2) throws IOException {
            boolean zIsEnabled = deserializationContext.isEnabled(StreamReadCapability.DUPLICATE_PROPERTIES);
            if (zIsEnabled) {
                _squashDups(map, str, obj, obj2);
            }
            while (str2 != null) {
                jsonParser.n1();
                Object objDeserialize = deserialize(jsonParser, deserializationContext);
                Object objPut = map.put(str2, objDeserialize);
                if (objPut != null && zIsEnabled) {
                    _squashDups(map, str2, objPut, objDeserialize);
                }
                str2 = jsonParser.l1();
            }
            return map;
        }

        @Override // defpackage.s51
        public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            switch (jsonParser.V()) {
                case 1:
                    if (jsonParser.n1() == JsonToken.END_OBJECT) {
                        return new LinkedHashMap(2);
                    }
                    break;
                case 2:
                    return new LinkedHashMap(2);
                case 3:
                    if (jsonParser.n1() == JsonToken.END_ARRAY) {
                        return deserializationContext.isEnabled(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY) ? UntypedObjectDeserializer.NO_OBJECTS : new ArrayList(2);
                    }
                    return deserializationContext.isEnabled(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY) ? mapArrayToArray(jsonParser, deserializationContext) : mapArray(jsonParser, deserializationContext);
                case 4:
                default:
                    return deserializationContext.handleUnexpectedToken(Object.class, jsonParser);
                case 5:
                    break;
                case 6:
                    return jsonParser.S0();
                case 7:
                    return deserializationContext.hasSomeOfFeatures(StdDeserializer.F_MASK_INT_COERCIONS) ? _coerceIntegral(jsonParser, deserializationContext) : jsonParser.M0();
                case 8:
                    return deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS) ? jsonParser.F0() : jsonParser.M0();
                case 9:
                    return Boolean.TRUE;
                case 10:
                    return Boolean.FALSE;
                case 11:
                    return null;
                case 12:
                    return jsonParser.H0();
            }
            return mapObject(jsonParser, deserializationContext);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
        public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
            int iV = jsonParser.V();
            if (iV != 1 && iV != 3) {
                switch (iV) {
                    case 5:
                        break;
                    case 6:
                        return jsonParser.S0();
                    case 7:
                        return deserializationContext.isEnabled(DeserializationFeature.USE_BIG_INTEGER_FOR_INTS) ? jsonParser.e0() : jsonParser.M0();
                    case 8:
                        return deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS) ? jsonParser.F0() : jsonParser.M0();
                    case 9:
                        return Boolean.TRUE;
                    case 10:
                        return Boolean.FALSE;
                    case 11:
                        return null;
                    case 12:
                        return jsonParser.H0();
                    default:
                        return deserializationContext.handleUnexpectedToken(Object.class, jsonParser);
                }
            }
            return m63Var.deserializeTypedFromAny(jsonParser, deserializationContext);
        }

        @Override // defpackage.s51
        public LogicalType logicalType() {
            return LogicalType.Untyped;
        }

        protected Object mapArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            Object objDeserialize = deserialize(jsonParser, deserializationContext);
            if (jsonParser.n1() == JsonToken.END_ARRAY) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(objDeserialize);
                return arrayList;
            }
            it1 it1VarLeaseObjectBuffer = deserializationContext.leaseObjectBuffer();
            Object[] objArrI = it1VarLeaseObjectBuffer.i();
            objArrI[0] = objDeserialize;
            int i = 1;
            int i2 = 1;
            while (true) {
                Object objDeserialize2 = deserialize(jsonParser, deserializationContext);
                i++;
                if (i2 >= objArrI.length) {
                    objArrI = it1VarLeaseObjectBuffer.c(objArrI);
                    i2 = 0;
                }
                int i3 = i2 + 1;
                objArrI[i2] = objDeserialize2;
                if (jsonParser.n1() == JsonToken.END_ARRAY) {
                    ArrayList arrayList2 = new ArrayList(i);
                    it1VarLeaseObjectBuffer.e(objArrI, i3, arrayList2);
                    deserializationContext.returnObjectBuffer(it1VarLeaseObjectBuffer);
                    return arrayList2;
                }
                i2 = i3;
            }
        }

        protected Object[] mapArrayToArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            it1 it1VarLeaseObjectBuffer = deserializationContext.leaseObjectBuffer();
            Object[] objArrI = it1VarLeaseObjectBuffer.i();
            int i = 0;
            while (true) {
                Object objDeserialize = deserialize(jsonParser, deserializationContext);
                if (i >= objArrI.length) {
                    objArrI = it1VarLeaseObjectBuffer.c(objArrI);
                    i = 0;
                }
                int i2 = i + 1;
                objArrI[i] = objDeserialize;
                if (jsonParser.n1() == JsonToken.END_ARRAY) {
                    Object[] objArrF = it1VarLeaseObjectBuffer.f(objArrI, i2);
                    deserializationContext.returnObjectBuffer(it1VarLeaseObjectBuffer);
                    return objArrF;
                }
                i = i2;
            }
        }

        protected Object mapObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            String strC = jsonParser.C();
            jsonParser.n1();
            Object objDeserialize = deserialize(jsonParser, deserializationContext);
            String strL1 = jsonParser.l1();
            if (strL1 == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap(2);
                linkedHashMap.put(strC, objDeserialize);
                return linkedHashMap;
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put(strC, objDeserialize);
            String strL2 = strL1;
            do {
                jsonParser.n1();
                Object objDeserialize2 = deserialize(jsonParser, deserializationContext);
                Object objPut = linkedHashMap2.put(strL2, objDeserialize2);
                if (objPut != null) {
                    return _mapObjectWithDups(jsonParser, deserializationContext, linkedHashMap2, strL2, objPut, objDeserialize2, jsonParser.l1());
                }
                strL2 = jsonParser.l1();
            } while (strL2 != null);
            return linkedHashMap2;
        }

        @Override // defpackage.s51
        public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
            if (this._nonMerging) {
                return Boolean.FALSE;
            }
            return null;
        }

        protected Vanilla(boolean z) {
            super((Class<?>) Object.class);
            this._nonMerging = z;
        }

        @Override // defpackage.s51
        public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
            Object objDeserialize;
            if (this._nonMerging) {
                return deserialize(jsonParser, deserializationContext);
            }
            int iV = jsonParser.V();
            if (iV != 1) {
                if (iV != 2) {
                    if (iV == 3) {
                        if (jsonParser.n1() == JsonToken.END_ARRAY) {
                            return obj;
                        }
                        if (obj instanceof Collection) {
                            Collection collection = (Collection) obj;
                            do {
                                collection.add(deserialize(jsonParser, deserializationContext));
                            } while (jsonParser.n1() != JsonToken.END_ARRAY);
                        }
                        return deserialize(jsonParser, deserializationContext);
                    }
                    if (iV != 4) {
                        if (iV == 5) {
                        }
                        return deserialize(jsonParser, deserializationContext);
                    }
                }
                return obj;
            }
            if (jsonParser.n1() == JsonToken.END_OBJECT) {
                return obj;
            }
            if (obj instanceof Map) {
                Map map = (Map) obj;
                String strC = jsonParser.C();
                do {
                    jsonParser.n1();
                    Object obj2 = map.get(strC);
                    if (obj2 != null) {
                        objDeserialize = deserialize(jsonParser, deserializationContext, obj2);
                    } else {
                        objDeserialize = deserialize(jsonParser, deserializationContext);
                    }
                    if (objDeserialize != obj2) {
                        map.put(strC, objDeserialize);
                    }
                    strC = jsonParser.l1();
                } while (strC != null);
                return obj;
            }
            return deserialize(jsonParser, deserializationContext);
        }
    }

    @Deprecated
    public UntypedObjectDeserializer() {
        this((JavaType) null, (JavaType) null);
    }

    private void _squashDups(Map<String, Object> map, String str, Object obj, Object obj2) {
        if (obj instanceof List) {
            ((List) obj).add(obj2);
            map.put(str, obj);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(obj);
            arrayList.add(obj2);
            map.put(str, arrayList);
        }
    }

    protected s51 _clearIfStdImpl(s51 s51Var) {
        if (ay.O(s51Var)) {
            return null;
        }
        return s51Var;
    }

    protected s51 _findCustomDeser(DeserializationContext deserializationContext, JavaType javaType) throws JsonMappingException {
        return deserializationContext.findNonContextualValueDeserializer(javaType);
    }

    protected Object _mapObjectWithDups(JsonParser jsonParser, DeserializationContext deserializationContext, Map<String, Object> map, String str, Object obj, Object obj2, String str2) throws IOException {
        boolean zIsEnabled = deserializationContext.isEnabled(StreamReadCapability.DUPLICATE_PROPERTIES);
        if (zIsEnabled) {
            _squashDups(map, str, obj, obj2);
        }
        while (str2 != null) {
            jsonParser.n1();
            Object objDeserialize = deserialize(jsonParser, deserializationContext);
            Object objPut = map.put(str2, objDeserialize);
            if (objPut != null && zIsEnabled) {
                _squashDups(map, str, objPut, objDeserialize);
            }
            str2 = jsonParser.l1();
        }
        return map;
    }

    @Override // defpackage.v30
    public s51 createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        boolean z = beanProperty == null && Boolean.FALSE.equals(deserializationContext.getConfig().getDefaultMergeable(Object.class));
        if (this._stringDeserializer == null && this._numberDeserializer == null && this._mapDeserializer == null && this._listDeserializer == null && getClass() == UntypedObjectDeserializer.class) {
            return UntypedObjectDeserializerNR.instance(z);
        }
        return z != this._nonMerging ? new UntypedObjectDeserializer(this, z) : this;
    }

    @Override // defpackage.s51
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        switch (jsonParser.V()) {
            case 1:
            case 2:
            case 5:
                s51 s51Var = this._mapDeserializer;
                return s51Var != null ? s51Var.deserialize(jsonParser, deserializationContext) : mapObject(jsonParser, deserializationContext);
            case 3:
                if (deserializationContext.isEnabled(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                    return mapArrayToArray(jsonParser, deserializationContext);
                }
                s51 s51Var2 = this._listDeserializer;
                return s51Var2 != null ? s51Var2.deserialize(jsonParser, deserializationContext) : mapArray(jsonParser, deserializationContext);
            case 4:
            default:
                return deserializationContext.handleUnexpectedToken(Object.class, jsonParser);
            case 6:
                s51 s51Var3 = this._stringDeserializer;
                return s51Var3 != null ? s51Var3.deserialize(jsonParser, deserializationContext) : jsonParser.S0();
            case 7:
                s51 s51Var4 = this._numberDeserializer;
                if (s51Var4 != null) {
                    return s51Var4.deserialize(jsonParser, deserializationContext);
                }
                return deserializationContext.hasSomeOfFeatures(StdDeserializer.F_MASK_INT_COERCIONS) ? _coerceIntegral(jsonParser, deserializationContext) : jsonParser.M0();
            case 8:
                s51 s51Var5 = this._numberDeserializer;
                if (s51Var5 != null) {
                    return s51Var5.deserialize(jsonParser, deserializationContext);
                }
                return deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS) ? jsonParser.F0() : jsonParser.M0();
            case 9:
                return Boolean.TRUE;
            case 10:
                return Boolean.FALSE;
            case 11:
                return null;
            case 12:
                return jsonParser.H0();
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        int iV = jsonParser.V();
        if (iV != 1 && iV != 3) {
            switch (iV) {
                case 5:
                    break;
                case 6:
                    s51 s51Var = this._stringDeserializer;
                    return s51Var != null ? s51Var.deserialize(jsonParser, deserializationContext) : jsonParser.S0();
                case 7:
                    s51 s51Var2 = this._numberDeserializer;
                    if (s51Var2 != null) {
                        return s51Var2.deserialize(jsonParser, deserializationContext);
                    }
                    return deserializationContext.hasSomeOfFeatures(StdDeserializer.F_MASK_INT_COERCIONS) ? _coerceIntegral(jsonParser, deserializationContext) : jsonParser.M0();
                case 8:
                    s51 s51Var3 = this._numberDeserializer;
                    if (s51Var3 != null) {
                        return s51Var3.deserialize(jsonParser, deserializationContext);
                    }
                    return deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS) ? jsonParser.F0() : jsonParser.M0();
                case 9:
                    return Boolean.TRUE;
                case 10:
                    return Boolean.FALSE;
                case 11:
                    return null;
                case 12:
                    return jsonParser.H0();
                default:
                    return deserializationContext.handleUnexpectedToken(Object.class, jsonParser);
            }
        }
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

    protected Object mapArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken jsonTokenN1 = jsonParser.n1();
        JsonToken jsonToken = JsonToken.END_ARRAY;
        int i = 2;
        if (jsonTokenN1 == jsonToken) {
            return new ArrayList(2);
        }
        Object objDeserialize = deserialize(jsonParser, deserializationContext);
        if (jsonParser.n1() == jsonToken) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(objDeserialize);
            return arrayList;
        }
        Object objDeserialize2 = deserialize(jsonParser, deserializationContext);
        if (jsonParser.n1() == jsonToken) {
            ArrayList arrayList2 = new ArrayList(2);
            arrayList2.add(objDeserialize);
            arrayList2.add(objDeserialize2);
            return arrayList2;
        }
        it1 it1VarLeaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        Object[] objArrI = it1VarLeaseObjectBuffer.i();
        objArrI[0] = objDeserialize;
        objArrI[1] = objDeserialize2;
        int i2 = 2;
        while (true) {
            Object objDeserialize3 = deserialize(jsonParser, deserializationContext);
            i++;
            if (i2 >= objArrI.length) {
                objArrI = it1VarLeaseObjectBuffer.c(objArrI);
                i2 = 0;
            }
            int i3 = i2 + 1;
            objArrI[i2] = objDeserialize3;
            if (jsonParser.n1() == JsonToken.END_ARRAY) {
                ArrayList arrayList3 = new ArrayList(i);
                it1VarLeaseObjectBuffer.e(objArrI, i3, arrayList3);
                deserializationContext.returnObjectBuffer(it1VarLeaseObjectBuffer);
                return arrayList3;
            }
            i2 = i3;
        }
    }

    protected Object[] mapArrayToArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.n1() == JsonToken.END_ARRAY) {
            return NO_OBJECTS;
        }
        it1 it1VarLeaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        Object[] objArrI = it1VarLeaseObjectBuffer.i();
        int i = 0;
        while (true) {
            Object objDeserialize = deserialize(jsonParser, deserializationContext);
            if (i >= objArrI.length) {
                objArrI = it1VarLeaseObjectBuffer.c(objArrI);
                i = 0;
            }
            int i2 = i + 1;
            objArrI[i] = objDeserialize;
            if (jsonParser.n1() == JsonToken.END_ARRAY) {
                Object[] objArrF = it1VarLeaseObjectBuffer.f(objArrI, i2);
                deserializationContext.returnObjectBuffer(it1VarLeaseObjectBuffer);
                return objArrF;
            }
            i = i2;
        }
    }

    protected Object mapObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String strC;
        JsonToken jsonTokenD = jsonParser.D();
        if (jsonTokenD == JsonToken.START_OBJECT) {
            strC = jsonParser.l1();
        } else if (jsonTokenD == JsonToken.FIELD_NAME) {
            strC = jsonParser.C();
        } else {
            if (jsonTokenD != JsonToken.END_OBJECT) {
                return deserializationContext.handleUnexpectedToken(handledType(), jsonParser);
            }
            strC = null;
        }
        String str = strC;
        if (str == null) {
            return new LinkedHashMap(2);
        }
        jsonParser.n1();
        Object objDeserialize = deserialize(jsonParser, deserializationContext);
        String strL1 = jsonParser.l1();
        if (strL1 == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(2);
            linkedHashMap.put(str, objDeserialize);
            return linkedHashMap;
        }
        jsonParser.n1();
        Object objDeserialize2 = deserialize(jsonParser, deserializationContext);
        String strL2 = jsonParser.l1();
        if (strL2 == null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(4);
            linkedHashMap2.put(str, objDeserialize);
            return linkedHashMap2.put(strL1, objDeserialize2) != null ? _mapObjectWithDups(jsonParser, deserializationContext, linkedHashMap2, str, objDeserialize, objDeserialize2, strL2) : linkedHashMap2;
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        linkedHashMap3.put(str, objDeserialize);
        if (linkedHashMap3.put(strL1, objDeserialize2) != null) {
            return _mapObjectWithDups(jsonParser, deserializationContext, linkedHashMap3, str, objDeserialize, objDeserialize2, strL2);
        }
        do {
            jsonParser.n1();
            Object objDeserialize3 = deserialize(jsonParser, deserializationContext);
            Object objPut = linkedHashMap3.put(strL2, objDeserialize3);
            if (objPut != null) {
                return _mapObjectWithDups(jsonParser, deserializationContext, linkedHashMap3, strL2, objPut, objDeserialize3, jsonParser.l1());
            }
            strL2 = jsonParser.l1();
        } while (strL2 != null);
        return linkedHashMap3;
    }

    @Override // defpackage.ag2
    public void resolve(DeserializationContext deserializationContext) throws JsonMappingException {
        JavaType javaTypeConstructType = deserializationContext.constructType(Object.class);
        JavaType javaTypeConstructType2 = deserializationContext.constructType(String.class);
        TypeFactory typeFactory = deserializationContext.getTypeFactory();
        JavaType javaType = this._listType;
        if (javaType == null) {
            this._listDeserializer = _clearIfStdImpl(_findCustomDeser(deserializationContext, typeFactory.constructCollectionType(List.class, javaTypeConstructType)));
        } else {
            this._listDeserializer = _findCustomDeser(deserializationContext, javaType);
        }
        JavaType javaType2 = this._mapType;
        if (javaType2 == null) {
            this._mapDeserializer = _clearIfStdImpl(_findCustomDeser(deserializationContext, typeFactory.constructMapType(Map.class, javaTypeConstructType2, javaTypeConstructType)));
        } else {
            this._mapDeserializer = _findCustomDeser(deserializationContext, javaType2);
        }
        this._stringDeserializer = _clearIfStdImpl(_findCustomDeser(deserializationContext, javaTypeConstructType2));
        this._numberDeserializer = _clearIfStdImpl(_findCustomDeser(deserializationContext, typeFactory.constructType(Number.class)));
        JavaType javaTypeUnknownType = TypeFactory.unknownType();
        this._mapDeserializer = deserializationContext.handleSecondaryContextualization(this._mapDeserializer, null, javaTypeUnknownType);
        this._listDeserializer = deserializationContext.handleSecondaryContextualization(this._listDeserializer, null, javaTypeUnknownType);
        this._stringDeserializer = deserializationContext.handleSecondaryContextualization(this._stringDeserializer, null, javaTypeUnknownType);
        this._numberDeserializer = deserializationContext.handleSecondaryContextualization(this._numberDeserializer, null, javaTypeUnknownType);
    }

    @Override // defpackage.s51
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return null;
    }

    public UntypedObjectDeserializer(JavaType javaType, JavaType javaType2) {
        super((Class<?>) Object.class);
        this._listType = javaType;
        this._mapType = javaType2;
        this._nonMerging = false;
    }

    public UntypedObjectDeserializer(UntypedObjectDeserializer untypedObjectDeserializer, s51 s51Var, s51 s51Var2, s51 s51Var3, s51 s51Var4) {
        super((Class<?>) Object.class);
        this._mapDeserializer = s51Var;
        this._listDeserializer = s51Var2;
        this._stringDeserializer = s51Var3;
        this._numberDeserializer = s51Var4;
        this._listType = untypedObjectDeserializer._listType;
        this._mapType = untypedObjectDeserializer._mapType;
        this._nonMerging = untypedObjectDeserializer._nonMerging;
    }

    protected UntypedObjectDeserializer(UntypedObjectDeserializer untypedObjectDeserializer, boolean z) {
        super((Class<?>) Object.class);
        this._mapDeserializer = untypedObjectDeserializer._mapDeserializer;
        this._listDeserializer = untypedObjectDeserializer._listDeserializer;
        this._stringDeserializer = untypedObjectDeserializer._stringDeserializer;
        this._numberDeserializer = untypedObjectDeserializer._numberDeserializer;
        this._listType = untypedObjectDeserializer._listType;
        this._mapType = untypedObjectDeserializer._mapType;
        this._nonMerging = z;
    }

    protected Object mapArray(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<Object> collection) throws IOException {
        while (jsonParser.n1() != JsonToken.END_ARRAY) {
            collection.add(deserialize(jsonParser, deserializationContext));
        }
        return collection;
    }

    @Override // defpackage.s51
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        if (this._nonMerging) {
            return deserialize(jsonParser, deserializationContext);
        }
        switch (jsonParser.V()) {
            case 1:
            case 2:
            case 5:
                s51 s51Var = this._mapDeserializer;
                if (s51Var != null) {
                    return s51Var.deserialize(jsonParser, deserializationContext, obj);
                }
                if (obj instanceof Map) {
                    return mapObject(jsonParser, deserializationContext, (Map) obj);
                }
                return mapObject(jsonParser, deserializationContext);
            case 3:
                s51 s51Var2 = this._listDeserializer;
                if (s51Var2 != null) {
                    return s51Var2.deserialize(jsonParser, deserializationContext, obj);
                }
                if (obj instanceof Collection) {
                    return mapArray(jsonParser, deserializationContext, (Collection) obj);
                }
                if (deserializationContext.isEnabled(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                    return mapArrayToArray(jsonParser, deserializationContext);
                }
                return mapArray(jsonParser, deserializationContext);
            case 4:
            default:
                return deserialize(jsonParser, deserializationContext);
            case 6:
                s51 s51Var3 = this._stringDeserializer;
                if (s51Var3 != null) {
                    return s51Var3.deserialize(jsonParser, deserializationContext, obj);
                }
                return jsonParser.S0();
            case 7:
                s51 s51Var4 = this._numberDeserializer;
                if (s51Var4 != null) {
                    return s51Var4.deserialize(jsonParser, deserializationContext, obj);
                }
                if (deserializationContext.hasSomeOfFeatures(StdDeserializer.F_MASK_INT_COERCIONS)) {
                    return _coerceIntegral(jsonParser, deserializationContext);
                }
                return jsonParser.M0();
            case 8:
                s51 s51Var5 = this._numberDeserializer;
                if (s51Var5 != null) {
                    return s51Var5.deserialize(jsonParser, deserializationContext, obj);
                }
                if (deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                    return jsonParser.F0();
                }
                return jsonParser.M0();
            case 9:
                return Boolean.TRUE;
            case 10:
                return Boolean.FALSE;
            case 11:
                return null;
            case 12:
                return jsonParser.H0();
        }
    }

    protected Object mapObject(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException {
        Object objDeserialize;
        JsonToken jsonTokenD = jsonParser.D();
        if (jsonTokenD == JsonToken.START_OBJECT) {
            jsonTokenD = jsonParser.n1();
        }
        if (jsonTokenD == JsonToken.END_OBJECT) {
            return map;
        }
        String strC = jsonParser.C();
        do {
            jsonParser.n1();
            Object obj = map.get(strC);
            if (obj != null) {
                objDeserialize = deserialize(jsonParser, deserializationContext, obj);
            } else {
                objDeserialize = deserialize(jsonParser, deserializationContext);
            }
            if (objDeserialize != obj) {
                map.put(strC, objDeserialize);
            }
            strC = jsonParser.l1();
        } while (strC != null);
        return map;
    }
}
