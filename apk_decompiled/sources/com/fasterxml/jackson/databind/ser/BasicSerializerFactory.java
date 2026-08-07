package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer;
import com.fasterxml.jackson.databind.ser.impl.IndexedStringListSerializer;
import com.fasterxml.jackson.databind.ser.impl.IteratorSerializer;
import com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer;
import com.fasterxml.jackson.databind.ser.impl.StringArraySerializer;
import com.fasterxml.jackson.databind.ser.impl.StringCollectionSerializer;
import com.fasterxml.jackson.databind.ser.std.AtomicReferenceSerializer;
import com.fasterxml.jackson.databind.ser.std.BooleanSerializer;
import com.fasterxml.jackson.databind.ser.std.ByteBufferSerializer;
import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import com.fasterxml.jackson.databind.ser.std.CollectionSerializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.databind.ser.std.EnumSerializer;
import com.fasterxml.jackson.databind.ser.std.EnumSetSerializer;
import com.fasterxml.jackson.databind.ser.std.InetAddressSerializer;
import com.fasterxml.jackson.databind.ser.std.InetSocketAddressSerializer;
import com.fasterxml.jackson.databind.ser.std.IterableSerializer;
import com.fasterxml.jackson.databind.ser.std.JsonValueSerializer;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializer;
import com.fasterxml.jackson.databind.ser.std.NumberSerializers;
import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;
import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;
import com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import com.fasterxml.jackson.databind.ser.std.StdJdkSerializers;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.fasterxml.jackson.databind.ser.std.TimeZoneSerializer;
import com.fasterxml.jackson.databind.ser.std.ToEmptyObjectSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.databind.ser.std.TokenBufferSerializer;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import defpackage.ah;
import defpackage.an2;
import defpackage.ay;
import defpackage.bn2;
import defpackage.d7;
import defpackage.e43;
import defpackage.f40;
import defpackage.f71;
import defpackage.kh;
import defpackage.oh;
import defpackage.p9;
import defpackage.ph;
import defpackage.q33;
import defpackage.x63;
import defpackage.z63;
import defpackage.zm2;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class BasicSerializerFactory extends zm2 implements Serializable {
    protected static final HashMap<String, f71> _concrete;
    protected static final HashMap<String, Class<? extends f71>> _concreteLazy;
    protected final SerializerFactoryConfig _factoryConfig;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[JsonInclude.Include.values().length];
            b = iArr;
            try {
                iArr[JsonInclude.Include.NON_DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[JsonInclude.Include.NON_ABSENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[JsonInclude.Include.NON_EMPTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[JsonInclude.Include.CUSTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[JsonInclude.Include.NON_NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[JsonInclude.Include.USE_DEFAULTS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[JsonFormat.Shape.values().length];
            a = iArr2;
            try {
                iArr2[JsonFormat.Shape.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[JsonFormat.Shape.OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[JsonFormat.Shape.ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    static {
        HashMap<String, Class<? extends f71>> map = new HashMap<>();
        HashMap<String, f71> map2 = new HashMap<>();
        map2.put(String.class.getName(), new StringSerializer());
        ToStringSerializer toStringSerializer = ToStringSerializer.instance;
        map2.put(StringBuffer.class.getName(), toStringSerializer);
        map2.put(StringBuilder.class.getName(), toStringSerializer);
        map2.put(Character.class.getName(), toStringSerializer);
        map2.put(Character.TYPE.getName(), toStringSerializer);
        NumberSerializers.a(map2);
        map2.put(Boolean.TYPE.getName(), new BooleanSerializer(true));
        map2.put(Boolean.class.getName(), new BooleanSerializer(false));
        map2.put(BigInteger.class.getName(), new NumberSerializer(BigInteger.class));
        map2.put(BigDecimal.class.getName(), new NumberSerializer(BigDecimal.class));
        map2.put(Calendar.class.getName(), CalendarSerializer.instance);
        map2.put(Date.class.getName(), DateSerializer.instance);
        for (Map.Entry entry : StdJdkSerializers.a()) {
            Object value = entry.getValue();
            if (value instanceof f71) {
                map2.put(((Class) entry.getKey()).getName(), (f71) value);
            } else {
                map.put(((Class) entry.getKey()).getName(), (Class) value);
            }
        }
        map.put(q33.class.getName(), TokenBufferSerializer.class);
        _concrete = map2;
        _concreteLazy = map;
    }

    protected BasicSerializerFactory(SerializerFactoryConfig serializerFactoryConfig) {
        this._factoryConfig = serializerFactoryConfig == null ? new SerializerFactoryConfig() : serializerFactoryConfig;
    }

    protected MapSerializer _checkMapContentInclusion(an2 an2Var, kh khVar, MapSerializer mapSerializer) throws JsonMappingException {
        JavaType contentType = mapSerializer.getContentType();
        JsonInclude.Value value_findInclusionWithContent = _findInclusionWithContent(an2Var, khVar, contentType, Map.class);
        JsonInclude.Include contentInclusion = value_findInclusionWithContent == null ? JsonInclude.Include.USE_DEFAULTS : value_findInclusionWithContent.getContentInclusion();
        Object objB = null;
        boolean zIncludeFilterSuppressNulls = true;
        if (contentInclusion == JsonInclude.Include.USE_DEFAULTS || contentInclusion == JsonInclude.Include.ALWAYS) {
            return !an2Var.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES) ? mapSerializer.withContentInclusion(null, true) : mapSerializer;
        }
        int i = a.b[contentInclusion.ordinal()];
        if (i == 1) {
            objB = ph.b(contentType);
            if (objB != null && objB.getClass().isArray()) {
                objB = p9.b(objB);
            }
        } else if (i != 2) {
            if (i == 3) {
                objB = MapSerializer.MARKER_FOR_EMPTY;
            } else if (i == 4 && (objB = an2Var.includeFilterInstance(null, value_findInclusionWithContent.getContentFilter())) != null) {
                zIncludeFilterSuppressNulls = an2Var.includeFilterSuppressNulls(objB);
            }
        } else if (contentType.isReferenceType()) {
            objB = MapSerializer.MARKER_FOR_EMPTY;
        }
        return mapSerializer.withContentInclusion(objB, zIncludeFilterSuppressNulls);
    }

    protected f71 _findContentSerializer(an2 an2Var, d7 d7Var) throws JsonMappingException {
        Object objFindContentSerializer = an2Var.getAnnotationIntrospector().findContentSerializer(d7Var);
        if (objFindContentSerializer != null) {
            return an2Var.serializerInstance(d7Var, objFindContentSerializer);
        }
        return null;
    }

    protected JsonInclude.Value _findInclusionWithContent(an2 an2Var, kh khVar, JavaType javaType, Class<?> cls) throws JsonMappingException {
        SerializationConfig config = an2Var.getConfig();
        JsonInclude.Value defaultPropertyInclusion = config.getDefaultPropertyInclusion(cls, khVar.p(config.getDefaultPropertyInclusion()));
        JsonInclude.Value defaultPropertyInclusion2 = config.getDefaultPropertyInclusion(javaType.getRawClass(), null);
        if (defaultPropertyInclusion2 == null) {
            return defaultPropertyInclusion;
        }
        int i = a.b[defaultPropertyInclusion2.getValueInclusion().ordinal()];
        if (i != 4) {
            return i != 6 ? defaultPropertyInclusion.withContentInclusion(defaultPropertyInclusion2.getValueInclusion()) : defaultPropertyInclusion;
        }
        return defaultPropertyInclusion.withContentFilter(defaultPropertyInclusion2.getContentFilter());
    }

    protected f71 _findKeySerializer(an2 an2Var, d7 d7Var) throws JsonMappingException {
        Object objFindKeySerializer = an2Var.getAnnotationIntrospector().findKeySerializer(d7Var);
        if (objFindKeySerializer != null) {
            return an2Var.serializerInstance(d7Var, objFindKeySerializer);
        }
        return null;
    }

    protected f71 buildArraySerializer(an2 an2Var, ArrayType arrayType, kh khVar, boolean z, z63 z63Var, f71 f71Var) throws JsonMappingException {
        SerializationConfig config = an2Var.getConfig();
        Iterator<bn2> it = customSerializers().iterator();
        f71 f71VarA = null;
        while (it.hasNext() && (f71VarA = it.next().findArraySerializer(config, arrayType, khVar, z63Var, f71Var)) == null) {
        }
        if (f71VarA == null) {
            Class<?> rawClass = arrayType.getRawClass();
            if (f71Var == null || ay.O(f71Var)) {
                f71VarA = String[].class == rawClass ? StringArraySerializer.instance : StdArraySerializers.a(rawClass);
            }
            if (f71VarA == null) {
                f71VarA = new ObjectArraySerializer(arrayType.mo15getContentType(), z, z63Var, f71Var);
            }
        }
        if (this._factoryConfig.hasSerializerModifiers()) {
            Iterator<oh> it2 = this._factoryConfig.serializerModifiers().iterator();
            if (it2.hasNext()) {
                e43.a(it2.next());
                throw null;
            }
        }
        return f71VarA;
    }

    protected f71 buildAtomicReferenceSerializer(an2 an2Var, ReferenceType referenceType, kh khVar, boolean z, z63 z63Var, f71 f71Var) throws JsonMappingException {
        boolean zIncludeFilterSuppressNulls;
        JavaType referencedType = referenceType.getReferencedType();
        JsonInclude.Value value_findInclusionWithContent = _findInclusionWithContent(an2Var, khVar, referencedType, AtomicReference.class);
        JsonInclude.Include contentInclusion = value_findInclusionWithContent == null ? JsonInclude.Include.USE_DEFAULTS : value_findInclusionWithContent.getContentInclusion();
        Object objB = null;
        if (contentInclusion == JsonInclude.Include.USE_DEFAULTS || contentInclusion == JsonInclude.Include.ALWAYS) {
            zIncludeFilterSuppressNulls = false;
        } else {
            int i = a.b[contentInclusion.ordinal()];
            zIncludeFilterSuppressNulls = true;
            if (i == 1) {
                objB = ph.b(referencedType);
                if (objB != null && objB.getClass().isArray()) {
                    objB = p9.b(objB);
                }
            } else if (i != 2) {
                if (i == 3) {
                    objB = MapSerializer.MARKER_FOR_EMPTY;
                } else if (i == 4 && (objB = an2Var.includeFilterInstance(null, value_findInclusionWithContent.getContentFilter())) != null) {
                    zIncludeFilterSuppressNulls = an2Var.includeFilterSuppressNulls(objB);
                }
            } else if (referencedType.isReferenceType()) {
                objB = MapSerializer.MARKER_FOR_EMPTY;
            }
        }
        return new AtomicReferenceSerializer(referenceType, z, z63Var, f71Var).withContentInclusion(objB, zIncludeFilterSuppressNulls);
    }

    protected f71 buildCollectionSerializer(an2 an2Var, CollectionType collectionType, kh khVar, boolean z, z63 z63Var, f71 f71Var) throws JsonMappingException {
        f71 f71VarBuildIndexedListSerializer;
        SerializationConfig config = an2Var.getConfig();
        Iterator<bn2> it = customSerializers().iterator();
        f71 f71VarFindSerializerByAnnotations = null;
        while (it.hasNext() && (f71VarFindSerializerByAnnotations = it.next().findCollectionSerializer(config, collectionType, khVar, z63Var, f71Var)) == null) {
        }
        if (f71VarFindSerializerByAnnotations == null && (f71VarFindSerializerByAnnotations = findSerializerByAnnotations(an2Var, collectionType, khVar)) == null) {
            if (khVar.g(null).getShape() == JsonFormat.Shape.OBJECT) {
                return null;
            }
            Class<?> rawClass = collectionType.getRawClass();
            if (EnumSet.class.isAssignableFrom(rawClass)) {
                JavaType javaTypeMo15getContentType = collectionType.mo15getContentType();
                if (!javaTypeMo15getContentType.isEnumImplType()) {
                    javaTypeMo15getContentType = null;
                }
                f71VarFindSerializerByAnnotations = buildEnumSetSerializer(javaTypeMo15getContentType);
            } else {
                Class<?> rawClass2 = collectionType.mo15getContentType().getRawClass();
                if (isIndexedList(rawClass)) {
                    if (rawClass2 != String.class) {
                        f71VarBuildIndexedListSerializer = buildIndexedListSerializer(collectionType.mo15getContentType(), z, z63Var, f71Var);
                    } else if (ay.O(f71Var)) {
                        f71VarBuildIndexedListSerializer = IndexedStringListSerializer.instance;
                    }
                    f71VarFindSerializerByAnnotations = f71VarBuildIndexedListSerializer;
                } else if (rawClass2 == String.class && ay.O(f71Var)) {
                    f71VarBuildIndexedListSerializer = StringCollectionSerializer.instance;
                    f71VarFindSerializerByAnnotations = f71VarBuildIndexedListSerializer;
                }
                if (f71VarFindSerializerByAnnotations == null) {
                    f71VarFindSerializerByAnnotations = buildCollectionSerializer(collectionType.mo15getContentType(), z, z63Var, f71Var);
                }
            }
        }
        if (this._factoryConfig.hasSerializerModifiers()) {
            Iterator<oh> it2 = this._factoryConfig.serializerModifiers().iterator();
            if (it2.hasNext()) {
                e43.a(it2.next());
                throw null;
            }
        }
        return f71VarFindSerializerByAnnotations;
    }

    protected f71 buildContainerSerializer(an2 an2Var, JavaType javaType, kh khVar, boolean z) throws JsonMappingException {
        SerializationConfig config = an2Var.getConfig();
        boolean z2 = (z || !javaType.useStaticType() || (javaType.isContainerType() && javaType.mo15getContentType().isJavaLangObject())) ? z : true;
        z63 z63VarCreateTypeSerializer = createTypeSerializer(config, javaType.mo15getContentType());
        if (z63VarCreateTypeSerializer != null) {
            z2 = false;
        }
        boolean z3 = z2;
        f71 f71Var_findContentSerializer = _findContentSerializer(an2Var, khVar.t());
        if (javaType.isMapLikeType()) {
            MapLikeType mapLikeType = (MapLikeType) javaType;
            f71 f71Var_findKeySerializer = _findKeySerializer(an2Var, khVar.t());
            if (mapLikeType instanceof MapType) {
                return buildMapSerializer(an2Var, (MapType) mapLikeType, khVar, z3, f71Var_findKeySerializer, z63VarCreateTypeSerializer, f71Var_findContentSerializer);
            }
            Iterator<bn2> it = customSerializers().iterator();
            f71 f71VarFindSerializerByAnnotations = null;
            while (it.hasNext() && (f71VarFindSerializerByAnnotations = it.next().findMapLikeSerializer(config, mapLikeType, khVar, f71Var_findKeySerializer, z63VarCreateTypeSerializer, f71Var_findContentSerializer)) == null) {
            }
            if (f71VarFindSerializerByAnnotations == null) {
                f71VarFindSerializerByAnnotations = findSerializerByAnnotations(an2Var, javaType, khVar);
            }
            if (f71VarFindSerializerByAnnotations != null && this._factoryConfig.hasSerializerModifiers()) {
                Iterator<oh> it2 = this._factoryConfig.serializerModifiers().iterator();
                if (it2.hasNext()) {
                    e43.a(it2.next());
                    throw null;
                }
            }
            return f71VarFindSerializerByAnnotations;
        }
        if (!javaType.isCollectionLikeType()) {
            if (javaType.isArrayType()) {
                return buildArraySerializer(an2Var, (ArrayType) javaType, khVar, z3, z63VarCreateTypeSerializer, f71Var_findContentSerializer);
            }
            return null;
        }
        CollectionLikeType collectionLikeType = (CollectionLikeType) javaType;
        if (collectionLikeType instanceof CollectionType) {
            return buildCollectionSerializer(an2Var, (CollectionType) collectionLikeType, khVar, z3, z63VarCreateTypeSerializer, f71Var_findContentSerializer);
        }
        Iterator<bn2> it3 = customSerializers().iterator();
        f71 f71VarFindSerializerByAnnotations2 = null;
        while (it3.hasNext() && (f71VarFindSerializerByAnnotations2 = it3.next().findCollectionLikeSerializer(config, collectionLikeType, khVar, z63VarCreateTypeSerializer, f71Var_findContentSerializer)) == null) {
        }
        if (f71VarFindSerializerByAnnotations2 == null) {
            f71VarFindSerializerByAnnotations2 = findSerializerByAnnotations(an2Var, javaType, khVar);
        }
        if (f71VarFindSerializerByAnnotations2 != null && this._factoryConfig.hasSerializerModifiers()) {
            Iterator<oh> it4 = this._factoryConfig.serializerModifiers().iterator();
            if (it4.hasNext()) {
                e43.a(it4.next());
                throw null;
            }
        }
        return f71VarFindSerializerByAnnotations2;
    }

    protected f71 buildEnumSerializer(SerializationConfig serializationConfig, JavaType javaType, kh khVar) throws JsonMappingException {
        JsonFormat.Value valueG = khVar.g(null);
        if (valueG.getShape() == JsonFormat.Shape.OBJECT) {
            ((ah) khVar).O("declaringClass");
            return null;
        }
        EnumSerializer enumSerializerConstruct = EnumSerializer.construct(javaType.getRawClass(), serializationConfig, khVar, valueG);
        if (this._factoryConfig.hasSerializerModifiers()) {
            Iterator<oh> it = this._factoryConfig.serializerModifiers().iterator();
            if (it.hasNext()) {
                e43.a(it.next());
                throw null;
            }
        }
        return enumSerializerConstruct;
    }

    public f71 buildEnumSetSerializer(JavaType javaType) {
        return new EnumSetSerializer(javaType);
    }

    public ContainerSerializer<?> buildIndexedListSerializer(JavaType javaType, boolean z, z63 z63Var, f71 f71Var) {
        return new IndexedListSerializer(javaType, z, z63Var, f71Var);
    }

    protected f71 buildIterableSerializer(SerializationConfig serializationConfig, JavaType javaType, kh khVar, boolean z, JavaType javaType2) throws JsonMappingException {
        return new IterableSerializer(javaType2, z, createTypeSerializer(serializationConfig, javaType2));
    }

    protected f71 buildIteratorSerializer(SerializationConfig serializationConfig, JavaType javaType, kh khVar, boolean z, JavaType javaType2) throws JsonMappingException {
        return new IteratorSerializer(javaType2, z, createTypeSerializer(serializationConfig, javaType2));
    }

    protected f71 buildMapEntrySerializer(an2 an2Var, JavaType javaType, kh khVar, boolean z, JavaType javaType2, JavaType javaType3) throws JsonMappingException {
        Object objB = null;
        if (JsonFormat.Value.merge(khVar.g(null), an2Var.getDefaultPropertyFormat(Map.Entry.class)).getShape() == JsonFormat.Shape.OBJECT) {
            return null;
        }
        MapEntrySerializer mapEntrySerializer = new MapEntrySerializer(javaType3, javaType2, javaType3, z, createTypeSerializer(an2Var.getConfig(), javaType3), null);
        JavaType contentType = mapEntrySerializer.getContentType();
        JsonInclude.Value value_findInclusionWithContent = _findInclusionWithContent(an2Var, khVar, contentType, Map.Entry.class);
        JsonInclude.Include contentInclusion = value_findInclusionWithContent == null ? JsonInclude.Include.USE_DEFAULTS : value_findInclusionWithContent.getContentInclusion();
        if (contentInclusion == JsonInclude.Include.USE_DEFAULTS || contentInclusion == JsonInclude.Include.ALWAYS) {
            return mapEntrySerializer;
        }
        int i = a.b[contentInclusion.ordinal()];
        boolean zIncludeFilterSuppressNulls = true;
        if (i == 1) {
            objB = ph.b(contentType);
            if (objB != null && objB.getClass().isArray()) {
                objB = p9.b(objB);
            }
        } else if (i != 2) {
            if (i == 3) {
                objB = MapSerializer.MARKER_FOR_EMPTY;
            } else if (i == 4 && (objB = an2Var.includeFilterInstance(null, value_findInclusionWithContent.getContentFilter())) != null) {
                zIncludeFilterSuppressNulls = an2Var.includeFilterSuppressNulls(objB);
            }
        } else if (contentType.isReferenceType()) {
            objB = MapSerializer.MARKER_FOR_EMPTY;
        }
        return mapEntrySerializer.withContentInclusion(objB, zIncludeFilterSuppressNulls);
    }

    protected f71 buildMapSerializer(an2 an2Var, MapType mapType, kh khVar, boolean z, f71 f71Var, z63 z63Var, f71 f71Var2) throws JsonMappingException {
        if (khVar.g(null).getShape() == JsonFormat.Shape.OBJECT) {
            return null;
        }
        SerializationConfig config = an2Var.getConfig();
        Iterator<bn2> it = customSerializers().iterator();
        f71 f71VarFindSerializerByAnnotations = null;
        while (it.hasNext() && (f71VarFindSerializerByAnnotations = it.next().findMapSerializer(config, mapType, khVar, f71Var, z63Var, f71Var2)) == null) {
        }
        if (f71VarFindSerializerByAnnotations == null && (f71VarFindSerializerByAnnotations = findSerializerByAnnotations(an2Var, mapType, khVar)) == null) {
            Object objFindFilterId = findFilterId(config, khVar);
            JsonIgnoreProperties.Value defaultPropertyIgnorals = config.getDefaultPropertyIgnorals(Map.class, khVar.t());
            Set<String> setFindIgnoredForSerialization = defaultPropertyIgnorals == null ? null : defaultPropertyIgnorals.findIgnoredForSerialization();
            JsonIncludeProperties.Value defaultPropertyInclusions = config.getDefaultPropertyInclusions(Map.class, khVar.t());
            f71VarFindSerializerByAnnotations = _checkMapContentInclusion(an2Var, khVar, MapSerializer.construct(setFindIgnoredForSerialization, defaultPropertyInclusions == null ? null : defaultPropertyInclusions.getIncluded(), mapType, z, z63Var, f71Var, f71Var2, objFindFilterId));
        }
        if (this._factoryConfig.hasSerializerModifiers()) {
            Iterator<oh> it2 = this._factoryConfig.serializerModifiers().iterator();
            if (it2.hasNext()) {
                e43.a(it2.next());
                throw null;
            }
        }
        return f71VarFindSerializerByAnnotations;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x007f A[PHI: r2
      0x007f: PHI (r2v4 f71) = (r2v3 f71), (r2v6 f71) binds: [B:13:0x003a, B:16:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.zm2
    public f71 createKeySerializer(an2 an2Var, JavaType javaType, f71 f71Var) throws JsonMappingException {
        f71 f71VarFindSerializer;
        SerializationConfig config = an2Var.getConfig();
        kh khVarIntrospect = config.introspect(javaType);
        if (this._factoryConfig.hasKeySerializers()) {
            Iterator<bn2> it = this._factoryConfig.keySerializers().iterator();
            f71VarFindSerializer = null;
            while (it.hasNext() && (f71VarFindSerializer = it.next().findSerializer(config, javaType, khVarIntrospect)) == null) {
            }
        } else {
            f71VarFindSerializer = null;
        }
        if (f71VarFindSerializer == null) {
            f71 f71Var_findKeySerializer = _findKeySerializer(an2Var, khVarIntrospect.t());
            if (f71Var_findKeySerializer != null) {
                f71Var = f71Var_findKeySerializer;
            } else if (f71Var == null) {
                f71Var_findKeySerializer = StdKeySerializers.b(config, javaType.getRawClass(), false);
                if (f71Var_findKeySerializer == null) {
                    AnnotatedMember annotatedMemberI = khVarIntrospect.i();
                    if (annotatedMemberI == null) {
                        annotatedMemberI = khVarIntrospect.j();
                    }
                    if (annotatedMemberI != null) {
                        f71 f71VarCreateKeySerializer = createKeySerializer(an2Var, annotatedMemberI.getType(), f71Var);
                        if (config.canOverrideAccessModifiers()) {
                            ay.g(annotatedMemberI.getMember(), config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                        }
                        f71Var = new JsonValueSerializer(annotatedMemberI, null, f71VarCreateKeySerializer);
                    } else {
                        f71Var = StdKeySerializers.a(config, javaType.getRawClass());
                    }
                } else {
                    f71Var = f71Var_findKeySerializer;
                }
            }
        } else {
            f71Var = f71VarFindSerializer;
        }
        if (this._factoryConfig.hasSerializerModifiers()) {
            Iterator<oh> it2 = this._factoryConfig.serializerModifiers().iterator();
            if (it2.hasNext()) {
                e43.a(it2.next());
                throw null;
            }
        }
        return f71Var;
    }

    @Override // defpackage.zm2
    public abstract f71 createSerializer(an2 an2Var, JavaType javaType) throws JsonMappingException;

    @Override // defpackage.zm2
    public z63 createTypeSerializer(SerializationConfig serializationConfig, JavaType javaType) {
        Collection collectionCollectAndResolveSubtypesByClass;
        com.fasterxml.jackson.databind.introspect.a aVarT = serializationConfig.introspectClassAnnotations(javaType.getRawClass()).t();
        x63 x63VarFindTypeResolver = serializationConfig.getAnnotationIntrospector().findTypeResolver(serializationConfig, aVarT, javaType);
        if (x63VarFindTypeResolver == null) {
            x63VarFindTypeResolver = serializationConfig.getDefaultTyper(javaType);
            collectionCollectAndResolveSubtypesByClass = null;
        } else {
            collectionCollectAndResolveSubtypesByClass = serializationConfig.getSubtypeResolver().collectAndResolveSubtypesByClass(serializationConfig, aVarT);
        }
        if (x63VarFindTypeResolver == null) {
            return null;
        }
        return x63VarFindTypeResolver.buildTypeSerializer(serializationConfig, javaType, collectionCollectAndResolveSubtypesByClass);
    }

    protected abstract Iterable<bn2> customSerializers();

    protected f40 findConverter(an2 an2Var, d7 d7Var) throws JsonMappingException {
        Object objFindSerializationConverter = an2Var.getAnnotationIntrospector().findSerializationConverter(d7Var);
        if (objFindSerializationConverter == null) {
            return null;
        }
        return an2Var.converterInstance(d7Var, objFindSerializationConverter);
    }

    protected f71 findConvertingSerializer(an2 an2Var, d7 d7Var, f71 f71Var) throws JsonMappingException {
        f40 f40VarFindConverter = findConverter(an2Var, d7Var);
        return f40VarFindConverter == null ? f71Var : new StdDelegatingSerializer(f40VarFindConverter, f40VarFindConverter.b(an2Var.getTypeFactory()), f71Var);
    }

    protected Object findFilterId(SerializationConfig serializationConfig, kh khVar) {
        return serializationConfig.getAnnotationIntrospector().findFilterId(khVar.t());
    }

    protected f71 findOptionalStdSerializer(an2 an2Var, JavaType javaType, kh khVar, boolean z) throws JsonMappingException {
        return OptionalHandlerFactory.instance.findSerializer(an2Var.getConfig(), javaType, khVar);
    }

    public f71 findReferenceSerializer(an2 an2Var, ReferenceType referenceType, kh khVar, boolean z) throws JsonMappingException {
        JavaType javaTypeMo15getContentType = referenceType.mo15getContentType();
        z63 z63VarCreateTypeSerializer = (z63) javaTypeMo15getContentType.getTypeHandler();
        SerializationConfig config = an2Var.getConfig();
        if (z63VarCreateTypeSerializer == null) {
            z63VarCreateTypeSerializer = createTypeSerializer(config, javaTypeMo15getContentType);
        }
        z63 z63Var = z63VarCreateTypeSerializer;
        f71 f71Var = (f71) javaTypeMo15getContentType.getValueHandler();
        Iterator<bn2> it = customSerializers().iterator();
        while (it.hasNext()) {
            f71 f71VarFindReferenceSerializer = it.next().findReferenceSerializer(config, referenceType, khVar, z63Var, f71Var);
            if (f71VarFindReferenceSerializer != null) {
                return f71VarFindReferenceSerializer;
            }
        }
        if (referenceType.isTypeOrSubTypeOf(AtomicReference.class)) {
            return buildAtomicReferenceSerializer(an2Var, referenceType, khVar, z, z63Var, f71Var);
        }
        return null;
    }

    protected final f71 findSerializerByAddonType(SerializationConfig serializationConfig, JavaType javaType, kh khVar, boolean z) throws JsonMappingException {
        Class<?> rawClass = javaType.getRawClass();
        if (Iterator.class.isAssignableFrom(rawClass)) {
            JavaType[] javaTypeArrFindTypeParameters = serializationConfig.getTypeFactory().findTypeParameters(javaType, Iterator.class);
            return buildIteratorSerializer(serializationConfig, javaType, khVar, z, (javaTypeArrFindTypeParameters == null || javaTypeArrFindTypeParameters.length != 1) ? TypeFactory.unknownType() : javaTypeArrFindTypeParameters[0]);
        }
        if (Iterable.class.isAssignableFrom(rawClass)) {
            JavaType[] javaTypeArrFindTypeParameters2 = serializationConfig.getTypeFactory().findTypeParameters(javaType, Iterable.class);
            return buildIterableSerializer(serializationConfig, javaType, khVar, z, (javaTypeArrFindTypeParameters2 == null || javaTypeArrFindTypeParameters2.length != 1) ? TypeFactory.unknownType() : javaTypeArrFindTypeParameters2[0]);
        }
        if (CharSequence.class.isAssignableFrom(rawClass)) {
            return ToStringSerializer.instance;
        }
        return null;
    }

    protected final f71 findSerializerByAnnotations(an2 an2Var, JavaType javaType, kh khVar) throws JsonMappingException {
        if (com.fasterxml.jackson.databind.a.class.isAssignableFrom(javaType.getRawClass())) {
            return SerializableSerializer.instance;
        }
        AnnotatedMember annotatedMemberJ = khVar.j();
        if (annotatedMemberJ == null) {
            return null;
        }
        if (an2Var.canOverrideAccessModifiers()) {
            ay.g(annotatedMemberJ.getMember(), an2Var.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        JavaType type = annotatedMemberJ.getType();
        f71 f71VarFindSerializerFromAnnotation = findSerializerFromAnnotation(an2Var, annotatedMemberJ);
        if (f71VarFindSerializerFromAnnotation == null) {
            f71VarFindSerializerFromAnnotation = (f71) type.getValueHandler();
        }
        z63 z63VarCreateTypeSerializer = (z63) type.getTypeHandler();
        if (z63VarCreateTypeSerializer == null) {
            z63VarCreateTypeSerializer = createTypeSerializer(an2Var.getConfig(), type);
        }
        return new JsonValueSerializer(annotatedMemberJ, z63VarCreateTypeSerializer, f71VarFindSerializerFromAnnotation);
    }

    protected final f71 findSerializerByLookup(JavaType javaType, SerializationConfig serializationConfig, kh khVar, boolean z) {
        Class<? extends f71> cls;
        String name = javaType.getRawClass().getName();
        f71 f71Var = _concrete.get(name);
        return (f71Var != null || (cls = _concreteLazy.get(name)) == null) ? f71Var : (f71) ay.l(cls, false);
    }

    protected final f71 findSerializerByPrimaryType(an2 an2Var, JavaType javaType, kh khVar, boolean z) throws JsonMappingException {
        if (javaType.isEnumType()) {
            return buildEnumSerializer(an2Var.getConfig(), javaType, khVar);
        }
        Class<?> rawClass = javaType.getRawClass();
        f71 f71VarFindOptionalStdSerializer = findOptionalStdSerializer(an2Var, javaType, khVar, z);
        if (f71VarFindOptionalStdSerializer != null) {
            return f71VarFindOptionalStdSerializer;
        }
        if (Calendar.class.isAssignableFrom(rawClass)) {
            return CalendarSerializer.instance;
        }
        if (Date.class.isAssignableFrom(rawClass)) {
            return DateSerializer.instance;
        }
        if (Map.Entry.class.isAssignableFrom(rawClass)) {
            JavaType javaTypeFindSuperType = javaType.findSuperType(Map.Entry.class);
            return buildMapEntrySerializer(an2Var, javaType, khVar, z, javaTypeFindSuperType.containedTypeOrUnknown(0), javaTypeFindSuperType.containedTypeOrUnknown(1));
        }
        if (ByteBuffer.class.isAssignableFrom(rawClass)) {
            return new ByteBufferSerializer();
        }
        if (InetAddress.class.isAssignableFrom(rawClass)) {
            return new InetAddressSerializer();
        }
        if (InetSocketAddress.class.isAssignableFrom(rawClass)) {
            return new InetSocketAddressSerializer();
        }
        if (TimeZone.class.isAssignableFrom(rawClass)) {
            return new TimeZoneSerializer();
        }
        if (Charset.class.isAssignableFrom(rawClass)) {
            return ToStringSerializer.instance;
        }
        if (!Number.class.isAssignableFrom(rawClass)) {
            if (ClassLoader.class.isAssignableFrom(rawClass)) {
                return new ToEmptyObjectSerializer(javaType);
            }
            return null;
        }
        int i = a.a[khVar.g(null).getShape().ordinal()];
        if (i == 1) {
            return ToStringSerializer.instance;
        }
        if (i == 2 || i == 3) {
            return null;
        }
        return NumberSerializer.instance;
    }

    protected f71 findSerializerFromAnnotation(an2 an2Var, d7 d7Var) throws JsonMappingException {
        Object objFindSerializer = an2Var.getAnnotationIntrospector().findSerializer(d7Var);
        if (objFindSerializer == null) {
            return null;
        }
        return findConvertingSerializer(an2Var, d7Var, an2Var.serializerInstance(d7Var, objFindSerializer));
    }

    public SerializerFactoryConfig getFactoryConfig() {
        return this._factoryConfig;
    }

    protected boolean isIndexedList(Class<?> cls) {
        return RandomAccess.class.isAssignableFrom(cls);
    }

    protected boolean usesStaticTyping(SerializationConfig serializationConfig, kh khVar, z63 z63Var) {
        if (z63Var != null) {
            return false;
        }
        JsonSerialize.Typing typingFindSerializationTyping = serializationConfig.getAnnotationIntrospector().findSerializationTyping(khVar.t());
        if (typingFindSerializationTyping == null || typingFindSerializationTyping == JsonSerialize.Typing.DEFAULT_TYPING) {
            return serializationConfig.isEnabled(MapperFeature.USE_STATIC_TYPING);
        }
        return typingFindSerializationTyping == JsonSerialize.Typing.STATIC;
    }

    @Override // defpackage.zm2
    public final zm2 withAdditionalKeySerializers(bn2 bn2Var) {
        return withConfig(this._factoryConfig.withAdditionalKeySerializers(bn2Var));
    }

    @Override // defpackage.zm2
    public final zm2 withAdditionalSerializers(bn2 bn2Var) {
        return withConfig(this._factoryConfig.withAdditionalSerializers(bn2Var));
    }

    public abstract zm2 withConfig(SerializerFactoryConfig serializerFactoryConfig);

    public final zm2 withSerializerModifier(oh ohVar) {
        return withConfig(this._factoryConfig.withSerializerModifier(ohVar));
    }

    @Deprecated
    public f71 createKeySerializer(SerializationConfig serializationConfig, JavaType javaType, f71 f71Var) {
        f71 f71VarFindSerializer;
        kh khVarIntrospect = serializationConfig.introspect(javaType);
        if (this._factoryConfig.hasKeySerializers()) {
            Iterator<bn2> it = this._factoryConfig.keySerializers().iterator();
            f71VarFindSerializer = null;
            while (it.hasNext() && (f71VarFindSerializer = it.next().findSerializer(serializationConfig, javaType, khVarIntrospect)) == null) {
            }
        } else {
            f71VarFindSerializer = null;
        }
        if (f71VarFindSerializer != null) {
            f71Var = f71VarFindSerializer;
        } else if (f71Var == null && (f71Var = StdKeySerializers.b(serializationConfig, javaType.getRawClass(), false)) == null) {
            f71Var = StdKeySerializers.a(serializationConfig, javaType.getRawClass());
        }
        if (this._factoryConfig.hasSerializerModifiers()) {
            Iterator<oh> it2 = this._factoryConfig.serializerModifiers().iterator();
            if (it2.hasNext()) {
                e43.a(it2.next());
                throw null;
            }
        }
        return f71Var;
    }

    public ContainerSerializer<?> buildCollectionSerializer(JavaType javaType, boolean z, z63 z63Var, f71 f71Var) {
        return new CollectionSerializer(javaType, z, z63Var, f71Var);
    }
}
