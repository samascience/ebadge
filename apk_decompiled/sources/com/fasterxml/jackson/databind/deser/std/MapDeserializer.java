package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.c;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import defpackage.a91;
import defpackage.ag2;
import defpackage.e41;
import defpackage.gs1;
import defpackage.m63;
import defpackage.p9;
import defpackage.s51;
import defpackage.v30;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@e41
public class MapDeserializer extends ContainerDeserializerBase<Map<Object, Object>> implements v30, ag2 {
    private static final long serialVersionUID = 1;
    protected boolean _checkDupSquash;
    protected s51 _delegateDeserializer;
    protected final boolean _hasDefaultCreator;
    protected Set<String> _ignorableProperties;
    protected Set<String> _includableProperties;
    protected IgnorePropertiesUtil.Checker _inclusionChecker;
    protected final a91 _keyDeserializer;
    protected PropertyBasedCreator _propertyBasedCreator;
    protected boolean _standardStringKey;
    protected final s51 _valueDeserializer;
    protected final ValueInstantiator _valueInstantiator;
    protected final m63 _valueTypeDeserializer;

    static class a extends c.a {
        private final b c;
        public final Map d;
        public final Object e;

        a(b bVar, UnresolvedForwardReference unresolvedForwardReference, Class cls, Object obj) {
            super(unresolvedForwardReference, cls);
            this.d = new LinkedHashMap();
            this.c = bVar;
            this.e = obj;
        }
    }

    private static final class b {
        private final Class a;
        private Map b;
        private List c = new ArrayList();

        public b(Class cls, Map map) {
            this.a = cls;
            this.b = map;
        }

        public c.a a(UnresolvedForwardReference unresolvedForwardReference, Object obj) {
            a aVar = new a(this, unresolvedForwardReference, this.a, obj);
            this.c.add(aVar);
            return aVar;
        }

        public void b(Object obj, Object obj2) {
            if (this.c.isEmpty()) {
                this.b.put(obj, obj2);
            } else {
                List list = this.c;
                ((a) list.get(list.size() - 1)).d.put(obj, obj2);
            }
        }
    }

    public MapDeserializer(JavaType javaType, ValueInstantiator valueInstantiator, a91 a91Var, s51 s51Var, m63 m63Var) {
        super(javaType, (gs1) null, (Boolean) null);
        this._keyDeserializer = a91Var;
        this._valueDeserializer = s51Var;
        this._valueTypeDeserializer = m63Var;
        this._valueInstantiator = valueInstantiator;
        this._hasDefaultCreator = valueInstantiator.canCreateUsingDefault();
        this._delegateDeserializer = null;
        this._propertyBasedCreator = null;
        this._standardStringKey = _isStdKeyDeser(javaType, a91Var);
        this._inclusionChecker = null;
        this._checkDupSquash = javaType.mo15getContentType().hasRawClass(Object.class);
    }

    private void handleUnresolvedReference(DeserializationContext deserializationContext, b bVar, Object obj, UnresolvedForwardReference unresolvedForwardReference) throws JsonMappingException {
        if (bVar == null) {
            deserializationContext.reportInputMismatch(this, "Unresolved forward reference but no identity info: " + unresolvedForwardReference, new Object[0]);
        }
        unresolvedForwardReference.getRoid().a(bVar.a(unresolvedForwardReference, obj));
    }

    public Map<Object, Object> _deserializeUsingCreator(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String strC;
        Object objDeserialize;
        PropertyBasedCreator propertyBasedCreator = this._propertyBasedCreator;
        com.fasterxml.jackson.databind.deser.impl.b bVarG = propertyBasedCreator.g(jsonParser, deserializationContext, null);
        s51 s51Var = this._valueDeserializer;
        m63 m63Var = this._valueTypeDeserializer;
        if (jsonParser.j1()) {
            strC = jsonParser.l1();
        } else {
            strC = jsonParser.d1(JsonToken.FIELD_NAME) ? jsonParser.C() : null;
        }
        while (strC != null) {
            JsonToken jsonTokenN1 = jsonParser.n1();
            IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
            if (checker == null || !checker.shouldIgnore(strC)) {
                SettableBeanProperty settableBeanPropertyE = propertyBasedCreator.e(strC);
                if (settableBeanPropertyE == null) {
                    Object objDeserializeKey = this._keyDeserializer.deserializeKey(strC, deserializationContext);
                    try {
                        if (jsonTokenN1 != JsonToken.VALUE_NULL) {
                            objDeserialize = m63Var == null ? s51Var.deserialize(jsonParser, deserializationContext) : s51Var.deserializeWithType(jsonParser, deserializationContext, m63Var);
                        } else if (!this._skipNullValues) {
                            objDeserialize = this._nullProvider.getNullValue(deserializationContext);
                        }
                        bVarG.d(objDeserializeKey, objDeserialize);
                    } catch (Exception e) {
                        wrapAndThrow(deserializationContext, e, this._containerType.getRawClass(), strC);
                        return null;
                    }
                } else if (bVarG.b(settableBeanPropertyE, settableBeanPropertyE.deserialize(jsonParser, deserializationContext))) {
                    jsonParser.n1();
                    try {
                        return _readAndBind(jsonParser, deserializationContext, (Map) propertyBasedCreator.a(deserializationContext, bVarG));
                    } catch (Exception e2) {
                        return (Map) wrapAndThrow(deserializationContext, e2, this._containerType.getRawClass(), strC);
                    }
                }
            } else {
                jsonParser.v1();
            }
            strC = jsonParser.l1();
        }
        try {
            return (Map) propertyBasedCreator.a(deserializationContext, bVarG);
        } catch (Exception e3) {
            wrapAndThrow(deserializationContext, e3, this._containerType.getRawClass(), strC);
            return null;
        }
    }

    protected final boolean _isStdKeyDeser(JavaType javaType, a91 a91Var) {
        JavaType javaTypeMo16getKeyType;
        if (a91Var == null || (javaTypeMo16getKeyType = javaType.mo16getKeyType()) == null) {
            return true;
        }
        Class<?> rawClass = javaTypeMo16getKeyType.getRawClass();
        return (rawClass == String.class || rawClass == Object.class) && isDefaultKeyDeserializer(a91Var);
    }

    protected final Map<Object, Object> _readAndBind(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException {
        String strC;
        a91 a91Var;
        Object objDeserialize;
        a91 a91Var2 = this._keyDeserializer;
        s51 s51Var = this._valueDeserializer;
        m63 m63Var = this._valueTypeDeserializer;
        boolean z = s51Var.getObjectIdReader() != null;
        b bVar = z ? new b(this._containerType.mo15getContentType().getRawClass(), map) : null;
        if (jsonParser.j1()) {
            strC = jsonParser.l1();
        } else {
            JsonToken jsonTokenD = jsonParser.D();
            JsonToken jsonToken = JsonToken.FIELD_NAME;
            if (jsonTokenD != jsonToken) {
                if (jsonTokenD == JsonToken.END_OBJECT) {
                    return map;
                }
                deserializationContext.reportWrongTokenException(this, jsonToken, (String) null, new Object[0]);
            }
            strC = jsonParser.C();
        }
        String strL1 = strC;
        while (strL1 != null) {
            Object objDeserializeKey = a91Var2.deserializeKey(strL1, deserializationContext);
            JsonToken jsonTokenN1 = jsonParser.n1();
            IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
            if (checker == null || !checker.shouldIgnore(strL1)) {
                try {
                    if (jsonTokenN1 != JsonToken.VALUE_NULL) {
                        objDeserialize = m63Var == null ? s51Var.deserialize(jsonParser, deserializationContext) : s51Var.deserializeWithType(jsonParser, deserializationContext, m63Var);
                    } else if (!this._skipNullValues) {
                        objDeserialize = this._nullProvider.getNullValue(deserializationContext);
                    }
                    if (z) {
                        bVar.b(objDeserializeKey, objDeserialize);
                    } else {
                        Object objPut = map.put(objDeserializeKey, objDeserialize);
                        if (objPut != null) {
                            a91Var = a91Var2;
                            try {
                                _squashDups(deserializationContext, map, objDeserializeKey, objPut, objDeserialize);
                            } catch (UnresolvedForwardReference e) {
                                e = e;
                                handleUnresolvedReference(deserializationContext, bVar, objDeserializeKey, e);
                            } catch (Exception e2) {
                                e = e2;
                                wrapAndThrow(deserializationContext, e, map, strL1);
                            }
                        }
                        strL1 = jsonParser.l1();
                        a91Var2 = a91Var;
                    }
                } catch (UnresolvedForwardReference e3) {
                    e = e3;
                    a91Var = a91Var2;
                } catch (Exception e4) {
                    e = e4;
                    a91Var = a91Var2;
                }
            } else {
                jsonParser.v1();
            }
            a91Var = a91Var2;
            strL1 = jsonParser.l1();
            a91Var2 = a91Var;
        }
        return map;
    }

    protected final Map<Object, Object> _readAndBindStringKeyMap(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException {
        String strC;
        Object objDeserialize;
        s51 s51Var = this._valueDeserializer;
        m63 m63Var = this._valueTypeDeserializer;
        boolean z = s51Var.getObjectIdReader() != null;
        b bVar = z ? new b(this._containerType.mo15getContentType().getRawClass(), map) : null;
        if (jsonParser.j1()) {
            strC = jsonParser.l1();
        } else {
            JsonToken jsonTokenD = jsonParser.D();
            if (jsonTokenD == JsonToken.END_OBJECT) {
                return map;
            }
            JsonToken jsonToken = JsonToken.FIELD_NAME;
            if (jsonTokenD != jsonToken) {
                deserializationContext.reportWrongTokenException(this, jsonToken, (String) null, new Object[0]);
            }
            strC = jsonParser.C();
        }
        while (strC != null) {
            JsonToken jsonTokenN1 = jsonParser.n1();
            IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
            if (checker == null || !checker.shouldIgnore(strC)) {
                try {
                    if (jsonTokenN1 != JsonToken.VALUE_NULL) {
                        objDeserialize = m63Var == null ? s51Var.deserialize(jsonParser, deserializationContext) : s51Var.deserializeWithType(jsonParser, deserializationContext, m63Var);
                    } else if (!this._skipNullValues) {
                        objDeserialize = this._nullProvider.getNullValue(deserializationContext);
                    }
                    Object obj = objDeserialize;
                    if (z) {
                        bVar.b(strC, obj);
                    } else {
                        Object objPut = map.put(strC, obj);
                        if (objPut != null) {
                            _squashDups(deserializationContext, map, strC, objPut, obj);
                        }
                    }
                } catch (UnresolvedForwardReference e) {
                    handleUnresolvedReference(deserializationContext, bVar, strC, e);
                } catch (Exception e2) {
                    wrapAndThrow(deserializationContext, e2, map, strC);
                }
            } else {
                jsonParser.v1();
            }
            strC = jsonParser.l1();
        }
        return map;
    }

    protected final void _readAndUpdate(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException {
        String strC;
        Object objDeserialize;
        a91 a91Var = this._keyDeserializer;
        s51 s51Var = this._valueDeserializer;
        m63 m63Var = this._valueTypeDeserializer;
        if (jsonParser.j1()) {
            strC = jsonParser.l1();
        } else {
            JsonToken jsonTokenD = jsonParser.D();
            if (jsonTokenD == JsonToken.END_OBJECT) {
                return;
            }
            JsonToken jsonToken = JsonToken.FIELD_NAME;
            if (jsonTokenD != jsonToken) {
                deserializationContext.reportWrongTokenException(this, jsonToken, (String) null, new Object[0]);
            }
            strC = jsonParser.C();
        }
        while (strC != null) {
            Object objDeserializeKey = a91Var.deserializeKey(strC, deserializationContext);
            JsonToken jsonTokenN1 = jsonParser.n1();
            IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
            if (checker == null || !checker.shouldIgnore(strC)) {
                try {
                    if (jsonTokenN1 != JsonToken.VALUE_NULL) {
                        Object obj = map.get(objDeserializeKey);
                        if (obj != null) {
                            objDeserialize = m63Var == null ? s51Var.deserialize(jsonParser, deserializationContext, obj) : s51Var.deserializeWithType(jsonParser, deserializationContext, m63Var, obj);
                        } else {
                            objDeserialize = m63Var == null ? s51Var.deserialize(jsonParser, deserializationContext) : s51Var.deserializeWithType(jsonParser, deserializationContext, m63Var);
                        }
                        if (objDeserialize != obj) {
                            map.put(objDeserializeKey, objDeserialize);
                        }
                    } else if (!this._skipNullValues) {
                        map.put(objDeserializeKey, this._nullProvider.getNullValue(deserializationContext));
                    }
                } catch (Exception e) {
                    wrapAndThrow(deserializationContext, e, map, strC);
                }
            } else {
                jsonParser.v1();
            }
            strC = jsonParser.l1();
        }
    }

    protected final void _readAndUpdateStringKeyMap(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException {
        String strC;
        Object objDeserialize;
        s51 s51Var = this._valueDeserializer;
        m63 m63Var = this._valueTypeDeserializer;
        if (jsonParser.j1()) {
            strC = jsonParser.l1();
        } else {
            JsonToken jsonTokenD = jsonParser.D();
            if (jsonTokenD == JsonToken.END_OBJECT) {
                return;
            }
            JsonToken jsonToken = JsonToken.FIELD_NAME;
            if (jsonTokenD != jsonToken) {
                deserializationContext.reportWrongTokenException(this, jsonToken, (String) null, new Object[0]);
            }
            strC = jsonParser.C();
        }
        while (strC != null) {
            JsonToken jsonTokenN1 = jsonParser.n1();
            IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
            if (checker == null || !checker.shouldIgnore(strC)) {
                try {
                    if (jsonTokenN1 != JsonToken.VALUE_NULL) {
                        Object obj = map.get(strC);
                        if (obj != null) {
                            objDeserialize = m63Var == null ? s51Var.deserialize(jsonParser, deserializationContext, obj) : s51Var.deserializeWithType(jsonParser, deserializationContext, m63Var, obj);
                        } else {
                            objDeserialize = m63Var == null ? s51Var.deserialize(jsonParser, deserializationContext) : s51Var.deserializeWithType(jsonParser, deserializationContext, m63Var);
                        }
                        if (objDeserialize != obj) {
                            map.put(strC, objDeserialize);
                        }
                    } else if (!this._skipNullValues) {
                        map.put(strC, this._nullProvider.getNullValue(deserializationContext));
                    }
                } catch (Exception e) {
                    wrapAndThrow(deserializationContext, e, map, strC);
                }
            } else {
                jsonParser.v1();
            }
            strC = jsonParser.l1();
        }
    }

    protected void _squashDups(DeserializationContext deserializationContext, Map<Object, Object> map, Object obj, Object obj2, Object obj3) {
        if (this._checkDupSquash && deserializationContext.isEnabled(StreamReadCapability.DUPLICATE_PROPERTIES)) {
            if (obj2 instanceof List) {
                ((List) obj2).add(obj3);
                map.put(obj, obj2);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(obj2);
                arrayList.add(obj3);
                map.put(obj, arrayList);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00b3 A[PHI: r0
      0x00b3: PHI (r0v9 java.util.Set<java.lang.String>) = 
      (r0v8 java.util.Set<java.lang.String>)
      (r0v8 java.util.Set<java.lang.String>)
      (r0v10 java.util.Set<java.lang.String>)
      (r0v10 java.util.Set<java.lang.String>)
     binds: [B:17:0x003f, B:19:0x0045, B:32:0x0081, B:34:0x0087] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.v30
    public s51 createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        Set<String> set;
        Set<String> set2;
        AnnotatedMember member;
        Set<String> included;
        a91 a91VarFindKeyDeserializer = this._keyDeserializer;
        if (a91VarFindKeyDeserializer == null) {
            a91VarFindKeyDeserializer = deserializationContext.findKeyDeserializer(this._containerType.mo16getKeyType(), beanProperty);
        }
        a91 a91Var = a91VarFindKeyDeserializer;
        s51 s51VarFindConvertingContentDeserializer = this._valueDeserializer;
        if (beanProperty != null) {
            s51VarFindConvertingContentDeserializer = findConvertingContentDeserializer(deserializationContext, beanProperty, s51VarFindConvertingContentDeserializer);
        }
        JavaType javaTypeMo15getContentType = this._containerType.mo15getContentType();
        s51 s51VarFindContextualValueDeserializer = s51VarFindConvertingContentDeserializer == null ? deserializationContext.findContextualValueDeserializer(javaTypeMo15getContentType, beanProperty) : deserializationContext.handleSecondaryContextualization(s51VarFindConvertingContentDeserializer, beanProperty, javaTypeMo15getContentType);
        m63 m63VarForProperty = this._valueTypeDeserializer;
        if (m63VarForProperty != null) {
            m63VarForProperty = m63VarForProperty.forProperty(beanProperty);
        }
        m63 m63Var = m63VarForProperty;
        Set<String> hashSet = this._ignorableProperties;
        Set<String> set3 = this._includableProperties;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (!StdDeserializer._neitherNull(annotationIntrospector, beanProperty) || (member = beanProperty.getMember()) == null) {
            set = hashSet;
            set2 = set3;
        } else {
            DeserializationConfig config = deserializationContext.getConfig();
            JsonIgnoreProperties.Value valueFindPropertyIgnoralByName = annotationIntrospector.findPropertyIgnoralByName(config, member);
            if (valueFindPropertyIgnoralByName != null) {
                Set<String> setFindIgnoredForDeserialization = valueFindPropertyIgnoralByName.findIgnoredForDeserialization();
                if (!setFindIgnoredForDeserialization.isEmpty()) {
                    hashSet = hashSet == null ? new HashSet<>() : new HashSet(hashSet);
                    Iterator<String> it = setFindIgnoredForDeserialization.iterator();
                    while (it.hasNext()) {
                        hashSet.add(it.next());
                    }
                }
            }
            JsonIncludeProperties.Value valueFindPropertyInclusionByName = annotationIntrospector.findPropertyInclusionByName(config, member);
            if (valueFindPropertyInclusionByName == null || (included = valueFindPropertyInclusionByName.getIncluded()) == null) {
                set = hashSet;
                set2 = set3;
            } else {
                HashSet hashSet2 = new HashSet();
                if (set3 == null) {
                    hashSet2 = new HashSet(included);
                } else {
                    for (String str : included) {
                        if (set3.contains(str)) {
                            hashSet2.add(str);
                        }
                    }
                }
                set2 = hashSet2;
                set = hashSet;
            }
        }
        return withResolved(a91Var, m63Var, s51VarFindContextualValueDeserializer, findContentNullProvider(deserializationContext, beanProperty, s51VarFindContextualValueDeserializer), set, set2);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        return m63Var.deserializeTypedFromObject(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public s51 getContentDeserializer() {
        return this._valueDeserializer;
    }

    public final Class<?> getMapClass() {
        return this._containerType.getRawClass();
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public ValueInstantiator getValueInstantiator() {
        return this._valueInstantiator;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase, com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public JavaType getValueType() {
        return this._containerType;
    }

    @Override // defpackage.s51
    public boolean isCachable() {
        return this._valueDeserializer == null && this._keyDeserializer == null && this._valueTypeDeserializer == null && this._ignorableProperties == null && this._includableProperties == null;
    }

    @Override // defpackage.s51
    public LogicalType logicalType() {
        return LogicalType.Map;
    }

    @Override // defpackage.ag2
    public void resolve(DeserializationContext deserializationContext) throws JsonMappingException {
        if (this._valueInstantiator.canCreateUsingDelegate()) {
            JavaType delegateType = this._valueInstantiator.getDelegateType(deserializationContext.getConfig());
            if (delegateType == null) {
                JavaType javaType = this._containerType;
                deserializationContext.reportBadDefinition(javaType, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", javaType, this._valueInstantiator.getClass().getName()));
            }
            this._delegateDeserializer = findDeserializer(deserializationContext, delegateType, null);
        } else if (this._valueInstantiator.canCreateUsingArrayDelegate()) {
            JavaType arrayDelegateType = this._valueInstantiator.getArrayDelegateType(deserializationContext.getConfig());
            if (arrayDelegateType == null) {
                JavaType javaType2 = this._containerType;
                deserializationContext.reportBadDefinition(javaType2, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", javaType2, this._valueInstantiator.getClass().getName()));
            }
            this._delegateDeserializer = findDeserializer(deserializationContext, arrayDelegateType, null);
        }
        if (this._valueInstantiator.canCreateFromObjectWith()) {
            this._propertyBasedCreator = PropertyBasedCreator.c(deserializationContext, this._valueInstantiator, this._valueInstantiator.getFromObjectArguments(deserializationContext.getConfig()), deserializationContext.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
        }
        this._standardStringKey = _isStdKeyDeser(this._containerType, this._keyDeserializer);
    }

    @Deprecated
    public void setIgnorableProperties(String[] strArr) {
        HashSet hashSetA = (strArr == null || strArr.length == 0) ? null : p9.a(strArr);
        this._ignorableProperties = hashSetA;
        this._inclusionChecker = IgnorePropertiesUtil.a(hashSetA, this._includableProperties);
    }

    public void setIncludableProperties(Set<String> set) {
        this._includableProperties = set;
        this._inclusionChecker = IgnorePropertiesUtil.a(this._ignorableProperties, set);
    }

    protected MapDeserializer withResolved(a91 a91Var, m63 m63Var, s51 s51Var, gs1 gs1Var, Set<String> set) {
        return withResolved(a91Var, m63Var, s51Var, gs1Var, set, this._includableProperties);
    }

    protected MapDeserializer withResolved(a91 a91Var, m63 m63Var, s51 s51Var, gs1 gs1Var, Set<String> set, Set<String> set2) {
        return (this._keyDeserializer == a91Var && this._valueDeserializer == s51Var && this._valueTypeDeserializer == m63Var && this._nullProvider == gs1Var && this._ignorableProperties == set && this._includableProperties == set2) ? this : new MapDeserializer(this, a91Var, s51Var, m63Var, gs1Var, set, set2);
    }

    @Override // defpackage.s51
    public Map<Object, Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._propertyBasedCreator != null) {
            return _deserializeUsingCreator(jsonParser, deserializationContext);
        }
        s51 s51Var = this._delegateDeserializer;
        if (s51Var != null) {
            return (Map) this._valueInstantiator.createUsingDelegate(deserializationContext, s51Var.deserialize(jsonParser, deserializationContext));
        }
        if (!this._hasDefaultCreator) {
            return (Map) deserializationContext.handleMissingInstantiator(getMapClass(), getValueInstantiator(), jsonParser, "no default constructor found", new Object[0]);
        }
        int iV = jsonParser.V();
        if (iV != 1 && iV != 2) {
            if (iV == 3) {
                return _deserializeFromArray(jsonParser, deserializationContext);
            }
            if (iV != 5) {
                if (iV != 6) {
                    return (Map) deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
                }
                return _deserializeFromString(jsonParser, deserializationContext);
            }
        }
        Map<Object, Object> map = (Map) this._valueInstantiator.createUsingDefault(deserializationContext);
        if (this._standardStringKey) {
            return _readAndBindStringKeyMap(jsonParser, deserializationContext, map);
        }
        return _readAndBind(jsonParser, deserializationContext, map);
    }

    public void setIgnorableProperties(Set<String> set) {
        if (set == null || set.isEmpty()) {
            set = null;
        }
        this._ignorableProperties = set;
        this._inclusionChecker = IgnorePropertiesUtil.a(set, this._includableProperties);
    }

    protected MapDeserializer(MapDeserializer mapDeserializer) {
        super(mapDeserializer);
        this._keyDeserializer = mapDeserializer._keyDeserializer;
        this._valueDeserializer = mapDeserializer._valueDeserializer;
        this._valueTypeDeserializer = mapDeserializer._valueTypeDeserializer;
        this._valueInstantiator = mapDeserializer._valueInstantiator;
        this._propertyBasedCreator = mapDeserializer._propertyBasedCreator;
        this._delegateDeserializer = mapDeserializer._delegateDeserializer;
        this._hasDefaultCreator = mapDeserializer._hasDefaultCreator;
        this._ignorableProperties = mapDeserializer._ignorableProperties;
        this._includableProperties = mapDeserializer._includableProperties;
        this._inclusionChecker = mapDeserializer._inclusionChecker;
        this._standardStringKey = mapDeserializer._standardStringKey;
        this._checkDupSquash = mapDeserializer._checkDupSquash;
    }

    @Override // defpackage.s51
    public Map<Object, Object> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Map<Object, Object> map) throws IOException {
        jsonParser.s1(map);
        JsonToken jsonTokenD = jsonParser.D();
        if (jsonTokenD != JsonToken.START_OBJECT && jsonTokenD != JsonToken.FIELD_NAME) {
            return (Map) deserializationContext.handleUnexpectedToken(getMapClass(), jsonParser);
        }
        if (this._standardStringKey) {
            _readAndUpdateStringKeyMap(jsonParser, deserializationContext, map);
            return map;
        }
        _readAndUpdate(jsonParser, deserializationContext, map);
        return map;
    }

    protected MapDeserializer(MapDeserializer mapDeserializer, a91 a91Var, s51 s51Var, m63 m63Var, gs1 gs1Var, Set<String> set) {
        this(mapDeserializer, a91Var, s51Var, m63Var, gs1Var, set, null);
    }

    protected MapDeserializer(MapDeserializer mapDeserializer, a91 a91Var, s51 s51Var, m63 m63Var, gs1 gs1Var, Set<String> set, Set<String> set2) {
        super(mapDeserializer, gs1Var, mapDeserializer._unwrapSingle);
        this._keyDeserializer = a91Var;
        this._valueDeserializer = s51Var;
        this._valueTypeDeserializer = m63Var;
        this._valueInstantiator = mapDeserializer._valueInstantiator;
        this._propertyBasedCreator = mapDeserializer._propertyBasedCreator;
        this._delegateDeserializer = mapDeserializer._delegateDeserializer;
        this._hasDefaultCreator = mapDeserializer._hasDefaultCreator;
        this._ignorableProperties = set;
        this._includableProperties = set2;
        this._inclusionChecker = IgnorePropertiesUtil.a(set, set2);
        this._standardStringKey = _isStdKeyDeser(this._containerType, a91Var);
        this._checkDupSquash = mapDeserializer._checkDupSquash;
    }
}
