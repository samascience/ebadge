package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.type.LogicalType;
import defpackage.e41;
import defpackage.m63;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@e41
final class UntypedObjectDeserializerNR extends StdDeserializer<Object> {
    private static final long serialVersionUID = 1;
    protected final boolean _nonMerging;
    protected static final Object[] NO_OBJECTS = new Object[0];
    public static final UntypedObjectDeserializerNR std = new UntypedObjectDeserializerNR();

    public UntypedObjectDeserializerNR() {
        this(false);
    }

    private Object _deserializeAnyScalar(JsonParser jsonParser, DeserializationContext deserializationContext, int i) throws IOException {
        switch (i) {
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
                return deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
        }
    }

    private Object _deserializeNR(JsonParser jsonParser, DeserializationContext deserializationContext, a aVar) throws IOException {
        Object objS0;
        Object objS1;
        boolean zHasSomeOfFeatures = deserializationContext.hasSomeOfFeatures(StdDeserializer.F_MASK_INT_COERCIONS);
        boolean zIsEnabled = deserializationContext.isEnabled(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY);
        a aVarJ = aVar;
        while (true) {
            if (aVarJ.m()) {
                String strL1 = jsonParser.l1();
                while (true) {
                    if (strL1 == null) {
                        if (aVarJ != aVar) {
                            aVarJ = aVarJ.j();
                            break;
                        }
                        return aVarJ.l();
                    }
                    JsonToken jsonTokenN1 = jsonParser.n1();
                    if (jsonTokenN1 == null) {
                        jsonTokenN1 = JsonToken.NOT_AVAILABLE;
                    }
                    int iId = jsonTokenN1.id();
                    if (iId == 1) {
                        aVarJ = aVarJ.f(strL1);
                    } else {
                        if (iId == 3) {
                            aVarJ = aVarJ.d(strL1);
                            break;
                        }
                        switch (iId) {
                            case 6:
                                objS0 = jsonParser.S0();
                                break;
                            case 7:
                                objS0 = !zHasSomeOfFeatures ? jsonParser.M0() : _coerceIntegral(jsonParser, deserializationContext);
                                break;
                            case 8:
                                objS0 = !deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS) ? jsonParser.M0() : jsonParser.F0();
                                break;
                            case 9:
                                objS0 = Boolean.TRUE;
                                break;
                            case 10:
                                objS0 = Boolean.FALSE;
                                break;
                            case 11:
                                objS0 = null;
                                break;
                            case 12:
                                objS0 = jsonParser.H0();
                                break;
                            default:
                                return deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
                        }
                        aVarJ.o(strL1, objS0);
                    }
                    strL1 = jsonParser.l1();
                }
            } else {
                while (true) {
                    JsonToken jsonTokenN2 = jsonParser.n1();
                    if (jsonTokenN2 == null) {
                        jsonTokenN2 = JsonToken.NOT_AVAILABLE;
                    }
                    switch (jsonTokenN2.id()) {
                        case 1:
                            aVarJ = aVarJ.e();
                            continue;
                            break;
                        case 2:
                        case 5:
                        default:
                            return deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
                        case 3:
                            aVarJ = aVarJ.c();
                            continue;
                            break;
                        case 4:
                            if (aVarJ != aVar) {
                                aVarJ = aVarJ.i(zIsEnabled);
                                continue;
                                break;
                            }
                            return aVarJ.k(zIsEnabled);
                        case 6:
                            objS1 = jsonParser.S0();
                            break;
                        case 7:
                            objS1 = !zHasSomeOfFeatures ? jsonParser.M0() : _coerceIntegral(jsonParser, deserializationContext);
                            break;
                        case 8:
                            objS1 = !deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS) ? jsonParser.M0() : jsonParser.F0();
                            break;
                        case 9:
                            objS1 = Boolean.TRUE;
                            break;
                        case 10:
                            objS1 = Boolean.FALSE;
                            break;
                        case 11:
                            objS1 = null;
                            break;
                        case 12:
                            objS1 = jsonParser.H0();
                            break;
                    }
                    aVarJ.b(objS1);
                }
            }
        }
    }

    private Object _deserializeObjectAtName(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object obj_deserializeNR;
        a aVarS = a.s(deserializationContext.isEnabled(StreamReadCapability.DUPLICATE_PROPERTIES));
        String strC = jsonParser.C();
        while (strC != null) {
            JsonToken jsonTokenN1 = jsonParser.n1();
            if (jsonTokenN1 == null) {
                jsonTokenN1 = JsonToken.NOT_AVAILABLE;
            }
            int iId = jsonTokenN1.id();
            if (iId == 1) {
                obj_deserializeNR = _deserializeNR(jsonParser, deserializationContext, aVarS.e());
            } else {
                if (iId == 2) {
                    return aVarS.l();
                }
                obj_deserializeNR = iId != 3 ? _deserializeAnyScalar(jsonParser, deserializationContext, jsonTokenN1.id()) : _deserializeNR(jsonParser, deserializationContext, aVarS.c());
            }
            aVarS.o(strC, obj_deserializeNR);
            strC = jsonParser.l1();
        }
        return aVarS.l();
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

    public static UntypedObjectDeserializerNR instance(boolean z) {
        return z ? new UntypedObjectDeserializerNR(true) : std;
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
                return _deserializeNR(jsonParser, deserializationContext, a.s(deserializationContext.isEnabled(StreamReadCapability.DUPLICATE_PROPERTIES)));
            case 2:
                return a.h();
            case 3:
                return _deserializeNR(jsonParser, deserializationContext, a.r());
            case 4:
            default:
                return deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
            case 5:
                return _deserializeObjectAtName(jsonParser, deserializationContext);
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
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        int iV = jsonParser.V();
        return (iV == 1 || iV == 3 || iV == 5) ? m63Var.deserializeTypedFromAny(jsonParser, deserializationContext) : _deserializeAnyScalar(jsonParser, deserializationContext, jsonParser.V());
    }

    @Override // defpackage.s51
    public LogicalType logicalType() {
        return LogicalType.Untyped;
    }

    @Override // defpackage.s51
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        if (this._nonMerging) {
            return Boolean.FALSE;
        }
        return null;
    }

    protected UntypedObjectDeserializerNR(boolean z) {
        super((Class<?>) Object.class);
        this._nonMerging = z;
    }

    private static final class a {
        private final a a;
        private a b;
        private boolean c;
        private boolean d;
        private String e;
        private Map f;
        private List g;

        private a(a aVar) {
            this.a = aVar;
            this.c = false;
            this.d = false;
        }

        private void a(String str, Object obj) {
            Map map = this.f;
            if (map == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                this.f = linkedHashMap;
                linkedHashMap.put(str, obj);
                return;
            }
            Object objPut = map.put(str, obj);
            if (objPut != null) {
                if (objPut instanceof List) {
                    ((List) objPut).add(obj);
                    this.f.put(str, objPut);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(objPut);
                    arrayList.add(obj);
                    this.f.put(str, arrayList);
                }
            }
        }

        public static List g() {
            return new ArrayList(2);
        }

        public static Map h() {
            return new LinkedHashMap(2);
        }

        private a p() {
            this.c = false;
            return this;
        }

        private a q(boolean z) {
            this.c = true;
            this.d = z;
            return this;
        }

        public static a r() {
            return new a(null);
        }

        public static a s(boolean z) {
            return new a(null, true, z);
        }

        public void b(Object obj) {
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(obj);
        }

        public a c() {
            a aVar = this.b;
            return aVar == null ? new a(this) : aVar.p();
        }

        public a d(String str) {
            this.e = str;
            a aVar = this.b;
            return aVar == null ? new a(this) : aVar.p();
        }

        public a e() {
            a aVar = this.b;
            return aVar == null ? new a(this, true, this.d) : aVar.q(this.d);
        }

        public a f(String str) {
            this.e = str;
            a aVar = this.b;
            return aVar == null ? new a(this, true, this.d) : aVar.q(this.d);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public a i(boolean z) {
            Object objG;
            List list = this.g;
            Object array = list;
            if (list == null) {
                objG = z ? UntypedObjectDeserializerNR.NO_OBJECTS : g();
            } else {
                if (z) {
                    array = list.toArray(UntypedObjectDeserializerNR.NO_OBJECTS);
                }
                this.g = null;
                objG = array;
            }
            if (this.a.m()) {
                return this.a.n(objG);
            }
            this.a.b(objG);
            return this.a;
        }

        public a j() {
            Object linkedHashMap = this.f;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
            } else {
                this.f = null;
            }
            if (this.a.m()) {
                return this.a.n(linkedHashMap);
            }
            this.a.b(linkedHashMap);
            return this.a;
        }

        public Object k(boolean z) {
            List list = this.g;
            if (list == null) {
                return z ? UntypedObjectDeserializerNR.NO_OBJECTS : g();
            }
            return z ? list.toArray(UntypedObjectDeserializerNR.NO_OBJECTS) : list;
        }

        public Object l() {
            Map map = this.f;
            return map == null ? h() : map;
        }

        public boolean m() {
            return this.c;
        }

        public a n(Object obj) {
            String str = this.e;
            Objects.requireNonNull(str);
            this.e = null;
            if (this.d) {
                a(str, obj);
                return this;
            }
            if (this.f == null) {
                this.f = new LinkedHashMap();
            }
            this.f.put(str, obj);
            return this;
        }

        public void o(String str, Object obj) {
            if (this.d) {
                a(str, obj);
                return;
            }
            if (this.f == null) {
                this.f = new LinkedHashMap();
            }
            this.f.put(str, obj);
        }

        private a(a aVar, boolean z, boolean z2) {
            this.a = aVar;
            this.c = z;
            this.d = z2;
        }
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
