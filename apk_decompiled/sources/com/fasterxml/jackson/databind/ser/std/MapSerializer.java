package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import com.tencent.connect.common.Constants;
import defpackage.an2;
import defpackage.ay;
import defpackage.e41;
import defpackage.f71;
import defpackage.i82;
import defpackage.p9;
import defpackage.ph;
import defpackage.w30;
import defpackage.y51;
import defpackage.z63;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@e41
public class MapSerializer extends ContainerSerializer<Map<?, ?>> implements w30 {
    private static final long serialVersionUID = 1;
    protected com.fasterxml.jackson.databind.ser.impl.a _dynamicValueSerializers;
    protected final Object _filterId;
    protected final Set<String> _ignoredEntries;
    protected final Set<String> _includedEntries;
    protected final IgnorePropertiesUtil.Checker _inclusionChecker;
    protected f71 _keySerializer;
    protected final JavaType _keyType;
    protected final BeanProperty _property;
    protected final boolean _sortKeys;
    protected final boolean _suppressNulls;
    protected final Object _suppressableValue;
    protected f71 _valueSerializer;
    protected final JavaType _valueType;
    protected final boolean _valueTypeIsStatic;
    protected final z63 _valueTypeSerializer;
    protected static final JavaType UNSPECIFIED_TYPE = TypeFactory.unknownType();
    public static final Object MARKER_FOR_EMPTY = JsonInclude.Include.NON_EMPTY;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonInclude.Include.values().length];
            a = iArr;
            try {
                iArr[JsonInclude.Include.NON_DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonInclude.Include.NON_ABSENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonInclude.Include.NON_EMPTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[JsonInclude.Include.CUSTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[JsonInclude.Include.NON_NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[JsonInclude.Include.ALWAYS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    protected MapSerializer(Set<String> set, Set<String> set2, JavaType javaType, JavaType javaType2, boolean z, z63 z63Var, f71 f71Var, f71 f71Var2) {
        super(Map.class, false);
        set = (set == null || set.isEmpty()) ? null : set;
        this._ignoredEntries = set;
        this._includedEntries = set2;
        this._keyType = javaType;
        this._valueType = javaType2;
        this._valueTypeIsStatic = z;
        this._valueTypeSerializer = z63Var;
        this._keySerializer = f71Var;
        this._valueSerializer = f71Var2;
        this._dynamicValueSerializers = com.fasterxml.jackson.databind.ser.impl.a.c();
        this._property = null;
        this._filterId = null;
        this._sortKeys = false;
        this._suppressableValue = null;
        this._suppressNulls = false;
        this._inclusionChecker = IgnorePropertiesUtil.a(set, set2);
    }

    private final f71 _findSerializer(an2 an2Var, Object obj) throws JsonMappingException {
        Class<?> cls = obj.getClass();
        f71 f71VarK = this._dynamicValueSerializers.k(cls);
        if (f71VarK != null) {
            return f71VarK;
        }
        return this._valueType.hasGenericTypes() ? _findAndAddDynamic(this._dynamicValueSerializers, an2Var.constructSpecializedType(this._valueType, cls), an2Var) : _findAndAddDynamic(this._dynamicValueSerializers, cls, an2Var);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    /* JADX WARN: Code duplicated, block: B:25:? A[RETURN, SYNTHETIC] */
    public static MapSerializer construct(Set<String> set, Set<String> set2, JavaType javaType, boolean z, z63 z63Var, f71 f71Var, f71 f71Var2, Object obj) {
        JavaType javaTypeUnknownType;
        JavaType javaType2;
        boolean z2;
        MapSerializer mapSerializer;
        if (javaType == null) {
            javaType2 = UNSPECIFIED_TYPE;
            javaTypeUnknownType = javaType2;
        } else {
            JavaType javaTypeMo16getKeyType = javaType.mo16getKeyType();
            javaTypeUnknownType = javaType.hasRawClass(Properties.class) ? TypeFactory.unknownType() : javaType.mo15getContentType();
            javaType2 = javaTypeMo16getKeyType;
        }
        boolean z3 = false;
        if (z) {
            if (javaTypeUnknownType.getRawClass() != Object.class) {
                z2 = z;
            }
            mapSerializer = new MapSerializer(set, set2, javaType2, javaTypeUnknownType, z2, z63Var, f71Var, f71Var2);
            if (obj != null) {
                return mapSerializer.withFilterId(obj);
            }
            return mapSerializer;
        }
        if (javaTypeUnknownType != null && javaTypeUnknownType.isFinal()) {
            z3 = true;
        }
        z2 = z3;
        mapSerializer = new MapSerializer(set, set2, javaType2, javaTypeUnknownType, z2, z63Var, f71Var, f71Var2);
        if (obj != null) {
            return mapSerializer.withFilterId(obj);
        }
        return mapSerializer;
    }

    protected void _ensureOverride(String str) {
        ay.n0(MapSerializer.class, this, str);
    }

    protected final f71 _findAndAddDynamic(com.fasterxml.jackson.databind.ser.impl.a aVar, Class<?> cls, an2 an2Var) throws JsonMappingException {
        com.fasterxml.jackson.databind.ser.impl.a.d dVarI = aVar.i(cls, an2Var, this._property);
        com.fasterxml.jackson.databind.ser.impl.a aVar2 = dVarI.b;
        if (aVar != aVar2) {
            this._dynamicValueSerializers = aVar2;
        }
        return dVarI.a;
    }

    protected boolean _hasNullKey(Map<?, ?> map) {
        return (map instanceof HashMap) && map.containsKey(null);
    }

    protected Map<?, ?> _orderEntries(Map<?, ?> map, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        if (map instanceof SortedMap) {
            return map;
        }
        if (!_hasNullKey(map)) {
            return new TreeMap(map);
        }
        TreeMap treeMap = new TreeMap();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                _writeNullKeyedEntry(jsonGenerator, an2Var, entry.getValue());
            } else {
                treeMap.put(key, entry.getValue());
            }
        }
        return treeMap;
    }

    protected void _writeNullKeyedEntry(JsonGenerator jsonGenerator, an2 an2Var, Object obj) throws IOException {
        f71 f71Var_findSerializer;
        f71 f71VarFindNullKeySerializer = an2Var.findNullKeySerializer(this._keyType, this._property);
        if (obj != null) {
            f71Var_findSerializer = this._valueSerializer;
            if (f71Var_findSerializer == null) {
                f71Var_findSerializer = _findSerializer(an2Var, obj);
            }
            Object obj2 = this._suppressableValue;
            if (obj2 == MARKER_FOR_EMPTY) {
                if (f71Var_findSerializer.isEmpty(an2Var, obj)) {
                    return;
                }
            } else if (obj2 != null && obj2.equals(obj)) {
                return;
            }
        } else if (this._suppressNulls) {
            return;
        } else {
            f71Var_findSerializer = an2Var.getDefaultNullValueSerializer();
        }
        try {
            f71VarFindNullKeySerializer.serialize(null, jsonGenerator, an2Var);
            f71Var_findSerializer.serialize(obj, jsonGenerator, an2Var);
        } catch (Exception e) {
            wrapAndThrow(an2Var, e, obj, Constants.STR_EMPTY);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        y51Var.l(javaType);
    }

    @Override // defpackage.w30
    public f71 createContextual(an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        f71 f71VarSerializerInstance;
        f71 f71VarSerializerInstance2;
        Set<String> set;
        Set<String> set2;
        boolean zEquals;
        JsonInclude.Include contentInclusion;
        Object objFindFilterId;
        Boolean feature;
        AnnotationIntrospector annotationIntrospector = an2Var.getAnnotationIntrospector();
        Object objB = null;
        AnnotatedMember member = beanProperty == null ? null : beanProperty.getMember();
        if (StdSerializer._neitherNull(member, annotationIntrospector)) {
            Object objFindKeySerializer = annotationIntrospector.findKeySerializer(member);
            f71VarSerializerInstance = objFindKeySerializer != null ? an2Var.serializerInstance(member, objFindKeySerializer) : null;
            Object objFindContentSerializer = annotationIntrospector.findContentSerializer(member);
            f71VarSerializerInstance2 = objFindContentSerializer != null ? an2Var.serializerInstance(member, objFindContentSerializer) : null;
        } else {
            f71VarSerializerInstance = null;
            f71VarSerializerInstance2 = null;
        }
        if (f71VarSerializerInstance2 == null) {
            f71VarSerializerInstance2 = this._valueSerializer;
        }
        f71 f71VarFindContextualConvertingSerializer = findContextualConvertingSerializer(an2Var, beanProperty, f71VarSerializerInstance2);
        if (f71VarFindContextualConvertingSerializer == null && this._valueTypeIsStatic && !this._valueType.isJavaLangObject()) {
            f71VarFindContextualConvertingSerializer = an2Var.findContentValueSerializer(this._valueType, beanProperty);
        }
        f71 f71Var = f71VarFindContextualConvertingSerializer;
        if (f71VarSerializerInstance == null) {
            f71VarSerializerInstance = this._keySerializer;
        }
        f71 f71VarFindKeySerializer = f71VarSerializerInstance == null ? an2Var.findKeySerializer(this._keyType, beanProperty) : an2Var.handleSecondaryContextualization(f71VarSerializerInstance, beanProperty);
        Set<String> hashSet = this._ignoredEntries;
        Set<String> hashSet2 = this._includedEntries;
        boolean zIncludeFilterSuppressNulls = false;
        if (StdSerializer._neitherNull(member, annotationIntrospector)) {
            SerializationConfig config = an2Var.getConfig();
            Set<String> setFindIgnoredForSerialization = annotationIntrospector.findPropertyIgnoralByName(config, member).findIgnoredForSerialization();
            if (StdSerializer._nonEmpty(setFindIgnoredForSerialization)) {
                hashSet = hashSet == null ? new HashSet<>() : new HashSet(hashSet);
                Iterator<String> it = setFindIgnoredForSerialization.iterator();
                while (it.hasNext()) {
                    hashSet.add(it.next());
                }
            }
            Set<String> included = annotationIntrospector.findPropertyInclusionByName(config, member).getIncluded();
            if (included != null) {
                hashSet2 = hashSet2 == null ? new HashSet<>() : new HashSet(hashSet2);
                Iterator<String> it2 = included.iterator();
                while (it2.hasNext()) {
                    hashSet2.add(it2.next());
                }
            }
            zEquals = Boolean.TRUE.equals(annotationIntrospector.findSerializationSortAlphabetically(member));
            set = hashSet;
            set2 = hashSet2;
        } else {
            set = hashSet;
            set2 = hashSet2;
            zEquals = false;
        }
        JsonFormat.Value valueFindFormatOverrides = findFormatOverrides(an2Var, beanProperty, Map.class);
        MapSerializer mapSerializerWithResolved = withResolved(beanProperty, f71VarFindKeySerializer, f71Var, set, set2, (valueFindFormatOverrides == null || (feature = valueFindFormatOverrides.getFeature(JsonFormat.Feature.WRITE_SORTED_MAP_ENTRIES)) == null) ? zEquals : feature.booleanValue());
        if (member != null && (objFindFilterId = annotationIntrospector.findFilterId(member)) != null) {
            mapSerializerWithResolved = mapSerializerWithResolved.withFilterId(objFindFilterId);
        }
        JsonInclude.Value valueFindIncludeOverrides = findIncludeOverrides(an2Var, beanProperty, Map.class);
        if (valueFindIncludeOverrides == null || (contentInclusion = valueFindIncludeOverrides.getContentInclusion()) == JsonInclude.Include.USE_DEFAULTS) {
            return mapSerializerWithResolved;
        }
        int i = a.a[contentInclusion.ordinal()];
        if (i == 1) {
            objB = ph.b(this._valueType);
            if (objB != null && objB.getClass().isArray()) {
                objB = p9.b(objB);
            }
        } else if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    objB = an2Var.includeFilterInstance(null, valueFindIncludeOverrides.getContentFilter());
                    if (objB != null) {
                        zIncludeFilterSuppressNulls = an2Var.includeFilterSuppressNulls(objB);
                    }
                } else if (i == 5) {
                }
                return mapSerializerWithResolved.withContentInclusion(objB, zIncludeFilterSuppressNulls);
            }
            objB = MARKER_FOR_EMPTY;
        } else if (this._valueType.isReferenceType()) {
            objB = MARKER_FOR_EMPTY;
        }
        zIncludeFilterSuppressNulls = true;
        return mapSerializerWithResolved.withContentInclusion(objB, zIncludeFilterSuppressNulls);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public f71 getContentSerializer() {
        return this._valueSerializer;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public JavaType getContentType() {
        return this._valueType;
    }

    public f71 getKeySerializer() {
        return this._keySerializer;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
    public JsonNode getSchema(an2 an2Var, Type type) {
        return createSchemaNode("object", true);
    }

    public void serializeFields(Map<?, ?> map, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        Object obj = null;
        if (this._valueTypeSerializer != null) {
            serializeTypedFields(map, jsonGenerator, an2Var, null);
            return;
        }
        f71 f71Var = this._keySerializer;
        try {
            Object key = null;
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                try {
                    Object value = entry.getValue();
                    key = entry.getKey();
                    if (key == null) {
                        an2Var.findNullKeySerializer(this._keyType, this._property).serialize(null, jsonGenerator, an2Var);
                    } else {
                        IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
                        if (checker == null || !checker.shouldIgnore(key)) {
                            f71Var.serialize(key, jsonGenerator, an2Var);
                        }
                    }
                    if (value == null) {
                        an2Var.defaultSerializeNull(jsonGenerator);
                    } else {
                        f71 f71Var_findSerializer = this._valueSerializer;
                        if (f71Var_findSerializer == null) {
                            f71Var_findSerializer = _findSerializer(an2Var, value);
                        }
                        f71Var_findSerializer.serialize(value, jsonGenerator, an2Var);
                    }
                } catch (Exception e) {
                    e = e;
                    obj = key;
                    wrapAndThrow(an2Var, e, map, String.valueOf(obj));
                    return;
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void serializeFieldsUsing(Map<?, ?> map, JsonGenerator jsonGenerator, an2 an2Var, f71 f71Var) throws IOException {
        f71 f71Var2 = this._keySerializer;
        z63 z63Var = this._valueTypeSerializer;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
            if (checker == null || !checker.shouldIgnore(key)) {
                if (key == null) {
                    an2Var.findNullKeySerializer(this._keyType, this._property).serialize(null, jsonGenerator, an2Var);
                } else {
                    f71Var2.serialize(key, jsonGenerator, an2Var);
                }
                Object value = entry.getValue();
                if (value == null) {
                    an2Var.defaultSerializeNull(jsonGenerator);
                } else if (z63Var == null) {
                    try {
                        f71Var.serialize(value, jsonGenerator, an2Var);
                    } catch (Exception e) {
                        wrapAndThrow(an2Var, e, map, String.valueOf(key));
                    }
                } else {
                    f71Var.serializeWithType(value, jsonGenerator, an2Var, z63Var);
                }
            }
        }
    }

    public void serializeFilteredAnyProperties(an2 an2Var, JsonGenerator jsonGenerator, Object obj, Map<?, ?> map, i82 i82Var, Object obj2) throws IOException {
        f71 defaultNullValueSerializer;
        MapProperty mapProperty = new MapProperty(this._valueTypeSerializer, this._property);
        boolean z = MARKER_FOR_EMPTY == obj2;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
            if (checker == null || !checker.shouldIgnore(key)) {
                f71 f71VarFindNullKeySerializer = key == null ? an2Var.findNullKeySerializer(this._keyType, this._property) : this._keySerializer;
                Object value = entry.getValue();
                if (value != null) {
                    defaultNullValueSerializer = this._valueSerializer;
                    if (defaultNullValueSerializer == null) {
                        defaultNullValueSerializer = _findSerializer(an2Var, value);
                    }
                    if (z) {
                        if (!defaultNullValueSerializer.isEmpty(an2Var, value)) {
                            mapProperty.reset(key, value, f71VarFindNullKeySerializer, defaultNullValueSerializer);
                            i82Var.serializeAsField(obj, jsonGenerator, an2Var, mapProperty);
                        }
                    } else if (obj2 == null || !obj2.equals(value)) {
                        mapProperty.reset(key, value, f71VarFindNullKeySerializer, defaultNullValueSerializer);
                        i82Var.serializeAsField(obj, jsonGenerator, an2Var, mapProperty);
                    }
                } else if (!this._suppressNulls) {
                    defaultNullValueSerializer = an2Var.getDefaultNullValueSerializer();
                    mapProperty.reset(key, value, f71VarFindNullKeySerializer, defaultNullValueSerializer);
                    try {
                        i82Var.serializeAsField(obj, jsonGenerator, an2Var, mapProperty);
                    } catch (Exception e) {
                        wrapAndThrow(an2Var, e, map, String.valueOf(key));
                    }
                }
            }
        }
    }

    public void serializeFilteredFields(Map<?, ?> map, JsonGenerator jsonGenerator, an2 an2Var, i82 i82Var, Object obj) throws IOException {
        f71 defaultNullValueSerializer;
        MapProperty mapProperty = new MapProperty(this._valueTypeSerializer, this._property);
        boolean z = MARKER_FOR_EMPTY == obj;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
            if (checker == null || !checker.shouldIgnore(key)) {
                f71 f71VarFindNullKeySerializer = key == null ? an2Var.findNullKeySerializer(this._keyType, this._property) : this._keySerializer;
                Object value = entry.getValue();
                if (value != null) {
                    defaultNullValueSerializer = this._valueSerializer;
                    if (defaultNullValueSerializer == null) {
                        defaultNullValueSerializer = _findSerializer(an2Var, value);
                    }
                    if (z) {
                        if (!defaultNullValueSerializer.isEmpty(an2Var, value)) {
                            mapProperty.reset(key, value, f71VarFindNullKeySerializer, defaultNullValueSerializer);
                            i82Var.serializeAsField(map, jsonGenerator, an2Var, mapProperty);
                        }
                    } else if (obj == null || !obj.equals(value)) {
                        mapProperty.reset(key, value, f71VarFindNullKeySerializer, defaultNullValueSerializer);
                        i82Var.serializeAsField(map, jsonGenerator, an2Var, mapProperty);
                    }
                } else if (!this._suppressNulls) {
                    defaultNullValueSerializer = an2Var.getDefaultNullValueSerializer();
                    mapProperty.reset(key, value, f71VarFindNullKeySerializer, defaultNullValueSerializer);
                    try {
                        i82Var.serializeAsField(map, jsonGenerator, an2Var, mapProperty);
                    } catch (Exception e) {
                        wrapAndThrow(an2Var, e, map, String.valueOf(key));
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0069 A[EXC_TOP_SPLITTER, PHI: r5
      0x0069: PHI (r5v3 f71) = (r5v2 f71), (r5v5 f71), (r5v5 f71), (r5v5 f71) binds: [B:27:0x004a, B:33:0x005d, B:35:0x0060, B:37:0x0066] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public void serializeOptionalFields(Map<?, ?> map, JsonGenerator jsonGenerator, an2 an2Var, Object obj) throws IOException {
        f71 f71VarFindNullKeySerializer;
        f71 defaultNullValueSerializer;
        if (this._valueTypeSerializer != null) {
            serializeTypedFields(map, jsonGenerator, an2Var, obj);
            return;
        }
        boolean z = MARKER_FOR_EMPTY == obj;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                f71VarFindNullKeySerializer = an2Var.findNullKeySerializer(this._keyType, this._property);
            } else {
                IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
                if (checker == null || !checker.shouldIgnore(key)) {
                    f71VarFindNullKeySerializer = this._keySerializer;
                }
            }
            Object value = entry.getValue();
            if (value != null) {
                defaultNullValueSerializer = this._valueSerializer;
                if (defaultNullValueSerializer == null) {
                    defaultNullValueSerializer = _findSerializer(an2Var, value);
                }
                if (z) {
                    if (!defaultNullValueSerializer.isEmpty(an2Var, value)) {
                        f71VarFindNullKeySerializer.serialize(key, jsonGenerator, an2Var);
                        defaultNullValueSerializer.serialize(value, jsonGenerator, an2Var);
                    }
                } else if (obj == null || !obj.equals(value)) {
                    f71VarFindNullKeySerializer.serialize(key, jsonGenerator, an2Var);
                    defaultNullValueSerializer.serialize(value, jsonGenerator, an2Var);
                }
            } else if (!this._suppressNulls) {
                defaultNullValueSerializer = an2Var.getDefaultNullValueSerializer();
                try {
                    f71VarFindNullKeySerializer.serialize(key, jsonGenerator, an2Var);
                    defaultNullValueSerializer.serialize(value, jsonGenerator, an2Var);
                } catch (Exception e) {
                    wrapAndThrow(an2Var, e, map, String.valueOf(key));
                }
            }
        }
    }

    public void serializeTypedFields(Map<?, ?> map, JsonGenerator jsonGenerator, an2 an2Var, Object obj) throws IOException {
        f71 f71VarFindNullKeySerializer;
        f71 defaultNullValueSerializer;
        boolean z = MARKER_FOR_EMPTY == obj;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                f71VarFindNullKeySerializer = an2Var.findNullKeySerializer(this._keyType, this._property);
            } else {
                IgnorePropertiesUtil.Checker checker = this._inclusionChecker;
                if (checker == null || !checker.shouldIgnore(key)) {
                    f71VarFindNullKeySerializer = this._keySerializer;
                }
            }
            Object value = entry.getValue();
            if (value != null) {
                defaultNullValueSerializer = this._valueSerializer;
                if (defaultNullValueSerializer == null) {
                    defaultNullValueSerializer = _findSerializer(an2Var, value);
                }
                if (z) {
                    if (!defaultNullValueSerializer.isEmpty(an2Var, value)) {
                        f71VarFindNullKeySerializer.serialize(key, jsonGenerator, an2Var);
                        defaultNullValueSerializer.serializeWithType(value, jsonGenerator, an2Var, this._valueTypeSerializer);
                    }
                } else if (obj == null || !obj.equals(value)) {
                    f71VarFindNullKeySerializer.serialize(key, jsonGenerator, an2Var);
                    defaultNullValueSerializer.serializeWithType(value, jsonGenerator, an2Var, this._valueTypeSerializer);
                }
            } else if (!this._suppressNulls) {
                defaultNullValueSerializer = an2Var.getDefaultNullValueSerializer();
                f71VarFindNullKeySerializer.serialize(key, jsonGenerator, an2Var);
                try {
                    defaultNullValueSerializer.serializeWithType(value, jsonGenerator, an2Var, this._valueTypeSerializer);
                } catch (Exception e) {
                    wrapAndThrow(an2Var, e, map, String.valueOf(key));
                }
            }
        }
    }

    public void serializeWithoutTypeInfo(Map<?, ?> map, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        i82 i82VarFindPropertyFilter;
        if (map.isEmpty()) {
            return;
        }
        if (this._sortKeys || an2Var.isEnabled(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)) {
            map = _orderEntries(map, jsonGenerator, an2Var);
        }
        Map<?, ?> map2 = map;
        Object obj = this._filterId;
        if (obj != null && (i82VarFindPropertyFilter = findPropertyFilter(an2Var, obj, map2)) != null) {
            serializeFilteredFields(map2, jsonGenerator, an2Var, i82VarFindPropertyFilter, this._suppressableValue);
            return;
        }
        Object obj2 = this._suppressableValue;
        if (obj2 != null || this._suppressNulls) {
            serializeOptionalFields(map2, jsonGenerator, an2Var, obj2);
            return;
        }
        f71 f71Var = this._valueSerializer;
        if (f71Var != null) {
            serializeFieldsUsing(map2, jsonGenerator, an2Var, f71Var);
        } else {
            serializeFields(map2, jsonGenerator, an2Var);
        }
    }

    public MapSerializer withContentInclusion(Object obj, boolean z) {
        if (obj == this._suppressableValue && z == this._suppressNulls) {
            return this;
        }
        _ensureOverride("withContentInclusion");
        return new MapSerializer(this, this._valueTypeSerializer, obj, z);
    }

    public MapSerializer withResolved(BeanProperty beanProperty, f71 f71Var, f71 f71Var2, Set<String> set, Set<String> set2, boolean z) {
        _ensureOverride("withResolved");
        MapSerializer mapSerializer = new MapSerializer(this, beanProperty, f71Var, f71Var2, set, set2);
        return z != mapSerializer._sortKeys ? new MapSerializer(mapSerializer, this._filterId, z) : mapSerializer;
    }

    @Deprecated
    protected void _ensureOverride() {
        _ensureOverride("N/A");
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public MapSerializer _withValueTypeSerializer(z63 z63Var) {
        if (this._valueTypeSerializer == z63Var) {
            return this;
        }
        _ensureOverride("_withValueTypeSerializer");
        return new MapSerializer(this, z63Var, this._suppressableValue, this._suppressNulls);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public boolean hasSingleElement(Map<?, ?> map) {
        return map.size() == 1;
    }

    @Override // defpackage.f71
    public boolean isEmpty(an2 an2Var, Map<?, ?> map) {
        if (map.isEmpty()) {
            return true;
        }
        Object obj = this._suppressableValue;
        if (obj == null && !this._suppressNulls) {
            return false;
        }
        f71 f71Var = this._valueSerializer;
        boolean z = MARKER_FOR_EMPTY == obj;
        if (f71Var != null) {
            for (Object obj2 : map.values()) {
                if (obj2 == null) {
                    if (!this._suppressNulls) {
                        return false;
                    }
                } else if (z) {
                    if (!f71Var.isEmpty(an2Var, obj2)) {
                        return false;
                    }
                } else if (obj == null || !obj.equals(map)) {
                    return false;
                }
            }
            return true;
        }
        for (Object obj3 : map.values()) {
            if (obj3 != null) {
                try {
                    f71 f71Var_findSerializer = _findSerializer(an2Var, obj3);
                    if (z) {
                        if (!f71Var_findSerializer.isEmpty(an2Var, obj3)) {
                            return false;
                        }
                    } else if (obj == null || !obj.equals(map)) {
                        return false;
                    }
                } catch (DatabindException unused) {
                }
            } else if (!this._suppressNulls) {
                return false;
            }
        }
        return true;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(Map<?, ?> map, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        jsonGenerator.t1(map);
        serializeWithoutTypeInfo(map, jsonGenerator, an2Var);
        jsonGenerator.S0();
    }

    @Override // defpackage.f71
    public void serializeWithType(Map<?, ?> map, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        jsonGenerator.y0(map);
        WritableTypeId writableTypeIdG = z63Var.g(jsonGenerator, z63Var.d(map, JsonToken.START_OBJECT));
        serializeWithoutTypeInfo(map, jsonGenerator, an2Var);
        z63Var.h(jsonGenerator, writableTypeIdG);
    }

    @Override // defpackage.f71
    public MapSerializer withFilterId(Object obj) {
        if (this._filterId == obj) {
            return this;
        }
        _ensureOverride("withFilterId");
        return new MapSerializer(this, obj, this._sortKeys);
    }

    @Deprecated
    public MapSerializer withContentInclusion(Object obj) {
        return new MapSerializer(this, this._valueTypeSerializer, obj, this._suppressNulls);
    }

    protected final f71 _findAndAddDynamic(com.fasterxml.jackson.databind.ser.impl.a aVar, JavaType javaType, an2 an2Var) throws JsonMappingException {
        com.fasterxml.jackson.databind.ser.impl.a.d dVarH = aVar.h(javaType, an2Var, this._property);
        com.fasterxml.jackson.databind.ser.impl.a aVar2 = dVarH.b;
        if (aVar != aVar2) {
            this._dynamicValueSerializers = aVar2;
        }
        return dVarH.a;
    }

    public MapSerializer withResolved(BeanProperty beanProperty, f71 f71Var, f71 f71Var2, Set<String> set, boolean z) {
        return withResolved(beanProperty, f71Var, f71Var2, set, null, z);
    }

    public static MapSerializer construct(Set<String> set, JavaType javaType, boolean z, z63 z63Var, f71 f71Var, f71 f71Var2, Object obj) {
        return construct(set, null, javaType, z, z63Var, f71Var, f71Var2, obj);
    }

    @Deprecated
    public static MapSerializer construct(String[] strArr, JavaType javaType, boolean z, z63 z63Var, f71 f71Var, f71 f71Var2, Object obj) {
        return construct(p9.a(strArr), javaType, z, z63Var, f71Var, f71Var2, obj);
    }

    @Deprecated
    protected MapSerializer(Set<String> set, JavaType javaType, JavaType javaType2, boolean z, z63 z63Var, f71 f71Var, f71 f71Var2) {
        this(set, null, javaType, javaType2, z, z63Var, f71Var, f71Var2);
    }

    protected MapSerializer(MapSerializer mapSerializer, BeanProperty beanProperty, f71 f71Var, f71 f71Var2, Set<String> set, Set<String> set2) {
        super(Map.class, false);
        set = (set == null || set.isEmpty()) ? null : set;
        this._ignoredEntries = set;
        this._includedEntries = set2;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = mapSerializer._valueTypeSerializer;
        this._keySerializer = f71Var;
        this._valueSerializer = f71Var2;
        this._dynamicValueSerializers = com.fasterxml.jackson.databind.ser.impl.a.c();
        this._property = beanProperty;
        this._filterId = mapSerializer._filterId;
        this._sortKeys = mapSerializer._sortKeys;
        this._suppressableValue = mapSerializer._suppressableValue;
        this._suppressNulls = mapSerializer._suppressNulls;
        this._inclusionChecker = IgnorePropertiesUtil.a(set, set2);
    }

    @Deprecated
    protected MapSerializer(MapSerializer mapSerializer, BeanProperty beanProperty, f71 f71Var, f71 f71Var2, Set<String> set) {
        this(mapSerializer, beanProperty, f71Var, f71Var2, set, null);
    }

    protected MapSerializer(MapSerializer mapSerializer, z63 z63Var, Object obj, boolean z) {
        super(Map.class, false);
        this._ignoredEntries = mapSerializer._ignoredEntries;
        this._includedEntries = mapSerializer._includedEntries;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = z63Var;
        this._keySerializer = mapSerializer._keySerializer;
        this._valueSerializer = mapSerializer._valueSerializer;
        this._dynamicValueSerializers = mapSerializer._dynamicValueSerializers;
        this._property = mapSerializer._property;
        this._filterId = mapSerializer._filterId;
        this._sortKeys = mapSerializer._sortKeys;
        this._suppressableValue = obj;
        this._suppressNulls = z;
        this._inclusionChecker = mapSerializer._inclusionChecker;
    }

    protected MapSerializer(MapSerializer mapSerializer, Object obj, boolean z) {
        super(Map.class, false);
        this._ignoredEntries = mapSerializer._ignoredEntries;
        this._includedEntries = mapSerializer._includedEntries;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = mapSerializer._valueTypeSerializer;
        this._keySerializer = mapSerializer._keySerializer;
        this._valueSerializer = mapSerializer._valueSerializer;
        this._dynamicValueSerializers = com.fasterxml.jackson.databind.ser.impl.a.c();
        this._property = mapSerializer._property;
        this._filterId = obj;
        this._sortKeys = z;
        this._suppressableValue = mapSerializer._suppressableValue;
        this._suppressNulls = mapSerializer._suppressNulls;
        this._inclusionChecker = mapSerializer._inclusionChecker;
    }

    @Deprecated
    protected MapSerializer(MapSerializer mapSerializer, z63 z63Var, Object obj) {
        this(mapSerializer, z63Var, obj, false);
    }
}
