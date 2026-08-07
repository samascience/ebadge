package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators$None;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.VirtualBeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.AttributePropertyWriter;
import com.fasterxml.jackson.databind.ser.std.RawSerializer;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.LRUMap;
import com.fasterxml.jackson.databind.util.NameTransformer;
import defpackage.a61;
import defpackage.a91;
import defpackage.ay;
import defpackage.b41;
import defpackage.b61;
import defpackage.bp2;
import defpackage.c61;
import defpackage.c71;
import defpackage.cu2;
import defpackage.d61;
import defpackage.d7;
import defpackage.e61;
import defpackage.f40;
import defpackage.f71;
import defpackage.g51;
import defpackage.g61;
import defpackage.h41;
import defpackage.h61;
import defpackage.i51;
import defpackage.j51;
import defpackage.j61;
import defpackage.k51;
import defpackage.k61;
import defpackage.k71;
import defpackage.lt1;
import defpackage.n51;
import defpackage.n63;
import defpackage.n71;
import defpackage.o71;
import defpackage.p51;
import defpackage.p71;
import defpackage.q61;
import defpackage.q71;
import defpackage.r51;
import defpackage.r71;
import defpackage.s51;
import defpackage.v51;
import defpackage.vy1;
import defpackage.w51;
import defpackage.w61;
import defpackage.w71;
import defpackage.x61;
import defpackage.x63;
import defpackage.x71;
import defpackage.y61;
import defpackage.y71;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class JacksonAnnotationIntrospector extends AnnotationIntrospector implements Serializable {
    private static final h41 _java7Helper = null;
    private static final long serialVersionUID = 1;
    protected transient LRUMap<Class<?>, Boolean> _annotationsInside = new LRUMap<>(48, 48);
    protected boolean _cfgConstructorPropertiesImpliesCreator = true;
    private static final Class<? extends Annotation>[] ANNOTATIONS_TO_INFER_SER = {JsonSerialize.class, y71.class, JsonFormat.class, JsonTypeInfo.class, y61.class, r71.class, n51.class, h61.class};
    private static final Class<? extends Annotation>[] ANNOTATIONS_TO_INFER_DESER = {r51.class, y71.class, JsonFormat.class, JsonTypeInfo.class, r71.class, n51.class, h61.class, j61.class};

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonSerialize.Inclusion.values().length];
            a = iArr;
            try {
                iArr[JsonSerialize.Inclusion.ALWAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonSerialize.Inclusion.NON_NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonSerialize.Inclusion.NON_DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[JsonSerialize.Inclusion.NON_EMPTY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[JsonSerialize.Inclusion.DEFAULT_INCLUSION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        try {
            h41.a();
        } catch (Throwable unused) {
        }
    }

    private JsonMappingException _databindException(String str) {
        return new JsonMappingException((Closeable) null, str);
    }

    private final Boolean _findSortAlpha(d7 d7Var) {
        x61 x61Var = (x61) _findAnnotation(d7Var, x61.class);
        if (x61Var == null || !x61Var.alphabetic()) {
            return null;
        }
        return Boolean.TRUE;
    }

    private boolean _primitiveAndWrapper(Class<?> cls, Class<?> cls2) {
        if (cls.isPrimitive()) {
            return cls == ay.b0(cls2);
        }
        return cls2.isPrimitive() && cls2 == ay.b0(cls);
    }

    private JsonInclude.Value _refinePropertyInclusion(d7 d7Var, JsonInclude.Value value) {
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(d7Var, JsonSerialize.class);
        if (jsonSerialize != null) {
            int i = a.a[jsonSerialize.include().ordinal()];
            if (i == 1) {
                return value.withValueInclusion(JsonInclude.Include.ALWAYS);
            }
            if (i == 2) {
                return value.withValueInclusion(JsonInclude.Include.NON_NULL);
            }
            if (i == 3) {
                return value.withValueInclusion(JsonInclude.Include.NON_DEFAULT);
            }
            if (i == 4) {
                return value.withValueInclusion(JsonInclude.Include.NON_EMPTY);
            }
        }
        return value;
    }

    private List<NamedType> findSubtypesCheckRepeatedNames(String str, k71.a[] aVarArr) {
        ArrayList arrayList = new ArrayList(aVarArr.length);
        HashSet hashSet = new HashSet();
        for (k71.a aVar : aVarArr) {
            String strName = aVar.name();
            if (!strName.isEmpty() && hashSet.contains(strName)) {
                throw new IllegalArgumentException("Annotated type [" + str + "] got repeated subtype name [" + strName + "]");
            }
            hashSet.add(strName);
            arrayList.add(new NamedType(aVar.value(), strName));
            for (String str2 : aVar.names()) {
                if (!str2.isEmpty() && hashSet.contains(str2)) {
                    throw new IllegalArgumentException("Annotated type [" + str + "] got repeated subtype name [" + str2 + "]");
                }
                hashSet.add(str2);
                arrayList.add(new NamedType(aVar.value(), str2));
            }
        }
        return arrayList;
    }

    protected Class<?> _classIfExplicit(Class<?> cls) {
        if (cls == null || ay.J(cls)) {
            return null;
        }
        return cls;
    }

    protected cu2 _constructNoTypeResolverBuilder() {
        return cu2.noTypeInfoBuilder();
    }

    protected cu2 _constructStdTypeResolverBuilder() {
        return new cu2();
    }

    protected BeanPropertyWriter _constructVirtualProperty(k51.a aVar, MapperConfig<?> mapperConfig, com.fasterxml.jackson.databind.introspect.a aVar2, JavaType javaType) {
        PropertyMetadata propertyMetadata = aVar.required() ? PropertyMetadata.STD_REQUIRED : PropertyMetadata.STD_OPTIONAL;
        String strValue = aVar.value();
        PropertyName propertyName_propertyName = _propertyName(aVar.propName(), aVar.propNamespace());
        if (!propertyName_propertyName.hasSimpleName()) {
            propertyName_propertyName = PropertyName.construct(strValue);
        }
        return AttributePropertyWriter.construct(strValue, bp2.A(mapperConfig, new VirtualAnnotatedMember(aVar2, aVar2.getRawType(), strValue, javaType), propertyName_propertyName, propertyMetadata, aVar.include()), aVar2.h(), javaType);
    }

    protected PropertyName _findConstructorName(d7 d7Var) {
        if (!(d7Var instanceof AnnotatedParameter)) {
            return null;
        }
        ((AnnotatedParameter) d7Var).getOwner();
        return null;
    }

    protected x63 _findTypeResolver(MapperConfig<?> mapperConfig, d7 d7Var, JavaType javaType) {
        x63 x63Var_constructStdTypeResolverBuilder;
        JsonTypeInfo jsonTypeInfo = (JsonTypeInfo) _findAnnotation(d7Var, JsonTypeInfo.class);
        q71 q71Var = (q71) _findAnnotation(d7Var, q71.class);
        if (q71Var != null) {
            if (jsonTypeInfo == null) {
                return null;
            }
            x63Var_constructStdTypeResolverBuilder = mapperConfig.typeResolverBuilderInstance(d7Var, q71Var.value());
        } else {
            if (jsonTypeInfo == null) {
                return null;
            }
            if (jsonTypeInfo.use() == JsonTypeInfo.Id.NONE) {
                return _constructNoTypeResolverBuilder();
            }
            x63Var_constructStdTypeResolverBuilder = _constructStdTypeResolverBuilder();
        }
        o71 o71Var = (o71) _findAnnotation(d7Var, o71.class);
        n63 n63VarTypeIdResolverInstance = o71Var != null ? mapperConfig.typeIdResolverInstance(d7Var, o71Var.value()) : null;
        if (n63VarTypeIdResolverInstance != null) {
            n63VarTypeIdResolverInstance.c(javaType);
        }
        x63 x63VarInit = x63Var_constructStdTypeResolverBuilder.init(jsonTypeInfo.use(), n63VarTypeIdResolverInstance);
        JsonTypeInfo.As asInclude = jsonTypeInfo.include();
        if (asInclude == JsonTypeInfo.As.EXTERNAL_PROPERTY && (d7Var instanceof com.fasterxml.jackson.databind.introspect.a)) {
            asInclude = JsonTypeInfo.As.PROPERTY;
        }
        x63 x63VarTypeProperty = x63VarInit.inclusion(asInclude).typeProperty(jsonTypeInfo.property());
        Class clsDefaultImpl = jsonTypeInfo.defaultImpl();
        if (clsDefaultImpl != JsonTypeInfo.a.class && !clsDefaultImpl.isAnnotation()) {
            x63VarTypeProperty = x63VarTypeProperty.defaultImpl(clsDefaultImpl);
        }
        return x63VarTypeProperty.typeIdVisibility(jsonTypeInfo.visible());
    }

    protected boolean _isIgnorable(d7 d7Var) {
        d61 d61Var = (d61) _findAnnotation(d7Var, d61.class);
        if (d61Var != null) {
            return d61Var.value();
        }
        return false;
    }

    protected PropertyName _propertyName(String str, String str2) {
        if (str.isEmpty()) {
            return PropertyName.USE_DEFAULT;
        }
        return (str2 == null || str2.isEmpty()) ? PropertyName.construct(str) : PropertyName.construct(str, str2);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public void findAndAddVirtualProperties(MapperConfig<?> mapperConfig, com.fasterxml.jackson.databind.introspect.a aVar, List<BeanPropertyWriter> list) {
        k51 k51Var = (k51) _findAnnotation(aVar, k51.class);
        if (k51Var == null) {
            return;
        }
        boolean zPrepend = k51Var.prepend();
        k51.a[] aVarArrAttrs = k51Var.attrs();
        int length = aVarArrAttrs.length;
        JavaType javaTypeConstructType = null;
        for (int i = 0; i < length; i++) {
            if (javaTypeConstructType == null) {
                javaTypeConstructType = mapperConfig.constructType(Object.class);
            }
            BeanPropertyWriter beanPropertyWriter_constructVirtualProperty = _constructVirtualProperty(aVarArrAttrs[i], mapperConfig, aVar, javaTypeConstructType);
            if (zPrepend) {
                list.add(i, beanPropertyWriter_constructVirtualProperty);
            } else {
                list.add(beanPropertyWriter_constructVirtualProperty);
            }
        }
        k51.b[] bVarArrProps = k51Var.props();
        int length2 = bVarArrProps.length;
        for (int i2 = 0; i2 < length2; i2++) {
            BeanPropertyWriter beanPropertyWriter_constructVirtualProperty2 = _constructVirtualProperty(bVarArrProps[i2], mapperConfig, aVar);
            if (zPrepend) {
                list.add(i2, beanPropertyWriter_constructVirtualProperty2);
            } else {
                list.add(beanPropertyWriter_constructVirtualProperty2);
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public VisibilityChecker findAutoDetectVisibility(com.fasterxml.jackson.databind.introspect.a aVar, VisibilityChecker visibilityChecker) {
        JsonAutoDetect jsonAutoDetect = (JsonAutoDetect) _findAnnotation(aVar, JsonAutoDetect.class);
        return jsonAutoDetect == null ? visibilityChecker : visibilityChecker.with(jsonAutoDetect);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public String findClassDescription(com.fasterxml.jackson.databind.introspect.a aVar) {
        p51 p51Var = (p51) _findAnnotation(aVar, p51.class);
        if (p51Var == null) {
            return null;
        }
        return p51Var.value();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findContentDeserializer(d7 d7Var) {
        Class clsContentUsing;
        r51 r51Var = (r51) _findAnnotation(d7Var, r51.class);
        if (r51Var == null || (clsContentUsing = r51Var.contentUsing()) == s51.a.class) {
            return null;
        }
        return clsContentUsing;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findContentSerializer(d7 d7Var) {
        Class clsContentUsing;
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(d7Var, JsonSerialize.class);
        if (jsonSerialize == null || (clsContentUsing = jsonSerialize.contentUsing()) == f71.a.class) {
            return null;
        }
        return clsContentUsing;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JsonCreator.Mode findCreatorAnnotation(MapperConfig<?> mapperConfig, d7 d7Var) {
        JsonCreator jsonCreator = (JsonCreator) _findAnnotation(d7Var, JsonCreator.class);
        if (jsonCreator != null) {
            return jsonCreator.mode();
        }
        if (!this._cfgConstructorPropertiesImpliesCreator || !mapperConfig.isEnabled(MapperFeature.INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES)) {
            return null;
        }
        boolean z = d7Var instanceof AnnotatedConstructor;
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public JsonCreator.Mode findCreatorBinding(d7 d7Var) {
        JsonCreator jsonCreator = (JsonCreator) _findAnnotation(d7Var, JsonCreator.class);
        if (jsonCreator == null) {
            return null;
        }
        return jsonCreator.mode();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Enum<?> findDefaultEnumValue(Class<Enum<?>> cls) {
        return ay.v(cls, v51.class);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findDeserializationContentConverter(AnnotatedMember annotatedMember) {
        r51 r51Var = (r51) _findAnnotation(annotatedMember, r51.class);
        if (r51Var == null) {
            return null;
        }
        return _classIfExplicit(r51Var.contentConverter(), f40.a.class);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public Class<?> findDeserializationContentType(d7 d7Var, JavaType javaType) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findDeserializationConverter(d7 d7Var) {
        r51 r51Var = (r51) _findAnnotation(d7Var, r51.class);
        if (r51Var == null) {
            return null;
        }
        return _classIfExplicit(r51Var.converter(), f40.a.class);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public Class<?> findDeserializationKeyType(d7 d7Var, JavaType javaType) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public Class<?> findDeserializationType(d7 d7Var, JavaType javaType) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findDeserializer(d7 d7Var) {
        Class clsUsing;
        r51 r51Var = (r51) _findAnnotation(d7Var, r51.class);
        if (r51Var == null || (clsUsing = r51Var.using()) == s51.a.class) {
            return null;
        }
        return clsUsing;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public void findEnumAliases(Class<?> cls, Enum<?>[] enumArr, String[][] strArr) {
        g51 g51Var;
        for (Field field : cls.getDeclaredFields()) {
            if (field.isEnumConstant() && (g51Var = (g51) field.getAnnotation(g51.class)) != null) {
                String[] strArrValue = g51Var.value();
                if (strArrValue.length != 0) {
                    String name = field.getName();
                    int length = enumArr.length;
                    for (int i = 0; i < length; i++) {
                        if (name.equals(enumArr[i].name())) {
                            strArr[i] = strArrValue;
                        }
                    }
                }
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public String findEnumValue(Enum<?> r3) {
        JsonProperty jsonProperty;
        String strValue;
        try {
            Field field = r3.getDeclaringClass().getField(r3.name());
            if (field != null && (jsonProperty = (JsonProperty) field.getAnnotation(JsonProperty.class)) != null && (strValue = jsonProperty.value()) != null && !strValue.isEmpty()) {
                return strValue;
            }
        } catch (NoSuchFieldException | SecurityException unused) {
        }
        return r3.name();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public String[] findEnumValues(Class<?> cls, Enum<?>[] enumArr, String[] strArr) {
        JsonProperty jsonProperty;
        HashMap map = null;
        for (Field field : cls.getDeclaredFields()) {
            if (field.isEnumConstant() && (jsonProperty = (JsonProperty) field.getAnnotation(JsonProperty.class)) != null) {
                String strValue = jsonProperty.value();
                if (!strValue.isEmpty()) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    map.put(field.getName(), strValue);
                }
            }
        }
        if (map != null) {
            int length = enumArr.length;
            for (int i = 0; i < length; i++) {
                String str = (String) map.get(enumArr[i].name());
                if (str != null) {
                    strArr[i] = str;
                }
            }
        }
        return strArr;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findFilterId(d7 d7Var) {
        w51 w51Var = (w51) _findAnnotation(d7Var, w51.class);
        if (w51Var == null) {
            return null;
        }
        String strValue = w51Var.value();
        if (strValue.isEmpty()) {
            return null;
        }
        return strValue;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JsonFormat.Value findFormat(d7 d7Var) {
        JsonFormat jsonFormat = (JsonFormat) _findAnnotation(d7Var, JsonFormat.class);
        if (jsonFormat == null) {
            return null;
        }
        return JsonFormat.Value.from(jsonFormat);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public String findImplicitPropertyName(AnnotatedMember annotatedMember) {
        PropertyName propertyName_findConstructorName = _findConstructorName(annotatedMember);
        if (propertyName_findConstructorName == null) {
            return null;
        }
        return propertyName_findConstructorName.getSimpleName();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JacksonInject.Value findInjectableValue(AnnotatedMember annotatedMember) {
        String name;
        JacksonInject jacksonInject = (JacksonInject) _findAnnotation(annotatedMember, JacksonInject.class);
        if (jacksonInject == null) {
            return null;
        }
        JacksonInject.Value valueFrom = JacksonInject.Value.from(jacksonInject);
        if (valueFrom.hasId()) {
            return valueFrom;
        }
        if (annotatedMember instanceof AnnotatedMethod) {
            AnnotatedMethod annotatedMethod = (AnnotatedMethod) annotatedMember;
            name = annotatedMethod.getParameterCount() == 0 ? annotatedMember.getRawType().getName() : annotatedMethod.getRawParameterType(0).getName();
        } else {
            name = annotatedMember.getRawType().getName();
        }
        return valueFrom.withId(name);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public Object findInjectableValueId(AnnotatedMember annotatedMember) {
        JacksonInject.Value valueFindInjectableValue = findInjectableValue(annotatedMember);
        if (valueFindInjectableValue == null) {
            return null;
        }
        return valueFindInjectableValue.getId();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findKeyDeserializer(d7 d7Var) {
        Class clsKeyUsing;
        r51 r51Var = (r51) _findAnnotation(d7Var, r51.class);
        if (r51Var == null || (clsKeyUsing = r51Var.keyUsing()) == a91.a.class) {
            return null;
        }
        return clsKeyUsing;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findKeySerializer(d7 d7Var) {
        Class clsKeyUsing;
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(d7Var, JsonSerialize.class);
        if (jsonSerialize == null || (clsKeyUsing = jsonSerialize.keyUsing()) == f71.a.class) {
            return null;
        }
        return clsKeyUsing;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Boolean findMergeInfo(d7 d7Var) {
        j61 j61Var = (j61) _findAnnotation(d7Var, j61.class);
        if (j61Var == null) {
            return null;
        }
        return j61Var.value().asBoolean();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public PropertyName findNameForDeserialization(d7 d7Var) {
        boolean z;
        JsonSetter jsonSetter = (JsonSetter) _findAnnotation(d7Var, JsonSetter.class);
        if (jsonSetter != null) {
            String strValue = jsonSetter.value();
            if (!strValue.isEmpty()) {
                return PropertyName.construct(strValue);
            }
            z = true;
        } else {
            z = false;
        }
        JsonProperty jsonProperty = (JsonProperty) _findAnnotation(d7Var, JsonProperty.class);
        if (jsonProperty != null) {
            String strNamespace = jsonProperty.namespace();
            return PropertyName.construct(jsonProperty.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
        }
        if (z || _hasOneOf(d7Var, ANNOTATIONS_TO_INFER_DESER)) {
            return PropertyName.USE_DEFAULT;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public PropertyName findNameForSerialization(d7 d7Var) {
        boolean z;
        a61 a61Var = (a61) _findAnnotation(d7Var, a61.class);
        if (a61Var != null) {
            String strValue = a61Var.value();
            if (!strValue.isEmpty()) {
                return PropertyName.construct(strValue);
            }
            z = true;
        } else {
            z = false;
        }
        JsonProperty jsonProperty = (JsonProperty) _findAnnotation(d7Var, JsonProperty.class);
        if (jsonProperty != null) {
            String strNamespace = jsonProperty.namespace();
            return PropertyName.construct(jsonProperty.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
        }
        if (z || _hasOneOf(d7Var, ANNOTATIONS_TO_INFER_SER)) {
            return PropertyName.USE_DEFAULT;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findNamingStrategy(com.fasterxml.jackson.databind.introspect.a aVar) {
        k61 k61Var = (k61) _findAnnotation(aVar, k61.class);
        if (k61Var == null) {
            return null;
        }
        return k61Var.value();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findNullSerializer(d7 d7Var) {
        Class clsNullsUsing;
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(d7Var, JsonSerialize.class);
        if (jsonSerialize == null || (clsNullsUsing = jsonSerialize.nullsUsing()) == f71.a.class) {
            return null;
        }
        return clsNullsUsing;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public lt1 findObjectIdInfo(d7 d7Var) {
        b61 b61Var = (b61) _findAnnotation(d7Var, b61.class);
        if (b61Var == null || b61Var.generator() == ObjectIdGenerators$None.class) {
            return null;
        }
        return new lt1(PropertyName.construct(b61Var.property()), b61Var.scope(), b61Var.generator(), b61Var.resolver());
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public lt1 findObjectReferenceInfo(d7 d7Var, lt1 lt1Var) {
        c61 c61Var = (c61) _findAnnotation(d7Var, c61.class);
        if (c61Var == null) {
            return lt1Var;
        }
        if (lt1Var == null) {
            lt1Var = lt1.a();
        }
        return lt1Var.g(c61Var.alwaysAsId());
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Class<?> findPOJOBuilder(com.fasterxml.jackson.databind.introspect.a aVar) {
        r51 r51Var = (r51) _findAnnotation(aVar, r51.class);
        if (r51Var == null) {
            return null;
        }
        return _classIfExplicit(r51Var.builder());
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public q61.a findPOJOBuilderConfig(com.fasterxml.jackson.databind.introspect.a aVar) {
        q61 q61Var = (q61) _findAnnotation(aVar, q61.class);
        if (q61Var == null) {
            return null;
        }
        return new q61.a(q61Var);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JsonProperty.Access findPropertyAccess(d7 d7Var) {
        JsonProperty jsonProperty = (JsonProperty) _findAnnotation(d7Var, JsonProperty.class);
        if (jsonProperty != null) {
            return jsonProperty.access();
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public List<PropertyName> findPropertyAliases(d7 d7Var) {
        g51 g51Var = (g51) _findAnnotation(d7Var, g51.class);
        if (g51Var == null) {
            return null;
        }
        String[] strArrValue = g51Var.value();
        int length = strArrValue.length;
        if (length == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(length);
        for (String str : strArrValue) {
            arrayList.add(PropertyName.construct(str));
        }
        return arrayList;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public x63 findPropertyContentTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        if (javaType.mo15getContentType() != null) {
            return _findTypeResolver(mapperConfig, annotatedMember, javaType);
        }
        throw new IllegalArgumentException("Must call method with a container or reference type (got " + javaType + ")");
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public String findPropertyDefaultValue(d7 d7Var) {
        JsonProperty jsonProperty = (JsonProperty) _findAnnotation(d7Var, JsonProperty.class);
        if (jsonProperty == null) {
            return null;
        }
        String strDefaultValue = jsonProperty.defaultValue();
        if (strDefaultValue.isEmpty()) {
            return null;
        }
        return strDefaultValue;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public String findPropertyDescription(d7 d7Var) {
        w61 w61Var = (w61) _findAnnotation(d7Var, w61.class);
        if (w61Var == null) {
            return null;
        }
        return w61Var.value();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JsonIgnoreProperties.Value findPropertyIgnoralByName(MapperConfig<?> mapperConfig, d7 d7Var) {
        JsonIgnoreProperties jsonIgnoreProperties = (JsonIgnoreProperties) _findAnnotation(d7Var, JsonIgnoreProperties.class);
        return jsonIgnoreProperties == null ? JsonIgnoreProperties.Value.empty() : JsonIgnoreProperties.Value.from(jsonIgnoreProperties);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public JsonIgnoreProperties.Value findPropertyIgnorals(d7 d7Var) {
        return findPropertyIgnoralByName(null, d7Var);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JsonInclude.Value findPropertyInclusion(d7 d7Var) {
        JsonInclude jsonInclude = (JsonInclude) _findAnnotation(d7Var, JsonInclude.class);
        JsonInclude.Value valueEmpty = jsonInclude == null ? JsonInclude.Value.empty() : JsonInclude.Value.from(jsonInclude);
        return valueEmpty.getValueInclusion() == JsonInclude.Include.USE_DEFAULTS ? _refinePropertyInclusion(d7Var, valueEmpty) : valueEmpty;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JsonIncludeProperties.Value findPropertyInclusionByName(MapperConfig<?> mapperConfig, d7 d7Var) {
        JsonIncludeProperties jsonIncludeProperties = (JsonIncludeProperties) _findAnnotation(d7Var, JsonIncludeProperties.class);
        return jsonIncludeProperties == null ? JsonIncludeProperties.Value.all() : JsonIncludeProperties.Value.from(jsonIncludeProperties);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Integer findPropertyIndex(d7 d7Var) {
        int iIndex;
        JsonProperty jsonProperty = (JsonProperty) _findAnnotation(d7Var, JsonProperty.class);
        if (jsonProperty == null || (iIndex = jsonProperty.index()) == -1) {
            return null;
        }
        return Integer.valueOf(iIndex);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public x63 findPropertyTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        if (javaType.isContainerType() || javaType.isReferenceType()) {
            return null;
        }
        return _findTypeResolver(mapperConfig, annotatedMember, javaType);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public AnnotationIntrospector.ReferenceProperty findReferenceType(AnnotatedMember annotatedMember) {
        h61 h61Var = (h61) _findAnnotation(annotatedMember, h61.class);
        if (h61Var != null) {
            return AnnotationIntrospector.ReferenceProperty.e(h61Var.value());
        }
        n51 n51Var = (n51) _findAnnotation(annotatedMember, n51.class);
        if (n51Var != null) {
            return AnnotationIntrospector.ReferenceProperty.a(n51Var.value());
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public PropertyName findRenameByField(MapperConfig<?> mapperConfig, AnnotatedField annotatedField, PropertyName propertyName) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public PropertyName findRootName(com.fasterxml.jackson.databind.introspect.a aVar) {
        c71 c71Var = (c71) _findAnnotation(aVar, c71.class);
        if (c71Var == null) {
            return null;
        }
        String strNamespace = c71Var.namespace();
        return PropertyName.construct(c71Var.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findSerializationContentConverter(AnnotatedMember annotatedMember) {
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(annotatedMember, JsonSerialize.class);
        if (jsonSerialize == null) {
            return null;
        }
        return _classIfExplicit(jsonSerialize.contentConverter(), f40.a.class);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public Class<?> findSerializationContentType(d7 d7Var, JavaType javaType) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findSerializationConverter(d7 d7Var) {
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(d7Var, JsonSerialize.class);
        if (jsonSerialize == null) {
            return null;
        }
        return _classIfExplicit(jsonSerialize.converter(), f40.a.class);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public Class<?> findSerializationKeyType(d7 d7Var, JavaType javaType) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public String[] findSerializationPropertyOrder(com.fasterxml.jackson.databind.introspect.a aVar) {
        x61 x61Var = (x61) _findAnnotation(aVar, x61.class);
        if (x61Var == null) {
            return null;
        }
        return x61Var.value();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Boolean findSerializationSortAlphabetically(d7 d7Var) {
        return _findSortAlpha(d7Var);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public Class<?> findSerializationType(d7 d7Var) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JsonSerialize.Typing findSerializationTyping(d7 d7Var) {
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(d7Var, JsonSerialize.class);
        if (jsonSerialize == null) {
            return null;
        }
        return jsonSerialize.typing();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findSerializer(d7 d7Var) {
        Class clsUsing;
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(d7Var, JsonSerialize.class);
        if (jsonSerialize != null && (clsUsing = jsonSerialize.using()) != f71.a.class) {
            return clsUsing;
        }
        y61 y61Var = (y61) _findAnnotation(d7Var, y61.class);
        if (y61Var == null || !y61Var.value()) {
            return null;
        }
        return new RawSerializer(d7Var.getRawType());
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JsonSetter.Value findSetterInfo(d7 d7Var) {
        return JsonSetter.Value.from((JsonSetter) _findAnnotation(d7Var, JsonSetter.class));
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public List<NamedType> findSubtypes(d7 d7Var) {
        k71 k71Var = (k71) _findAnnotation(d7Var, k71.class);
        if (k71Var == null) {
            return null;
        }
        k71.a[] aVarArrValue = k71Var.value();
        if (k71Var.failOnRepeatedNames()) {
            return findSubtypesCheckRepeatedNames(d7Var.getName(), aVarArrValue);
        }
        ArrayList arrayList = new ArrayList(aVarArrValue.length);
        for (k71.a aVar : aVarArrValue) {
            arrayList.add(new NamedType(aVar.value(), aVar.name()));
            for (String str : aVar.names()) {
                arrayList.add(new NamedType(aVar.value(), str));
            }
        }
        return arrayList;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public String findTypeName(com.fasterxml.jackson.databind.introspect.a aVar) {
        p71 p71Var = (p71) _findAnnotation(aVar, p71.class);
        if (p71Var == null) {
            return null;
        }
        return p71Var.value();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public x63 findTypeResolver(MapperConfig<?> mapperConfig, com.fasterxml.jackson.databind.introspect.a aVar, JavaType javaType) {
        return _findTypeResolver(mapperConfig, aVar, javaType);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public NameTransformer findUnwrappingNameTransformer(AnnotatedMember annotatedMember) {
        r71 r71Var = (r71) _findAnnotation(annotatedMember, r71.class);
        if (r71Var == null || !r71Var.enabled()) {
            return null;
        }
        return NameTransformer.simpleTransformer(r71Var.prefix(), r71Var.suffix());
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findValueInstantiator(com.fasterxml.jackson.databind.introspect.a aVar) {
        x71 x71Var = (x71) _findAnnotation(aVar, x71.class);
        if (x71Var == null) {
            return null;
        }
        return x71Var.value();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Class<?>[] findViews(d7 d7Var) {
        y71 y71Var = (y71) _findAnnotation(d7Var, y71.class);
        if (y71Var == null) {
            return null;
        }
        return y71Var.value();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Boolean hasAnyGetter(d7 d7Var) {
        i51 i51Var = (i51) _findAnnotation(d7Var, i51.class);
        if (i51Var == null) {
            return null;
        }
        return Boolean.valueOf(i51Var.enabled());
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public boolean hasAnyGetterAnnotation(AnnotatedMethod annotatedMethod) {
        return _hasAnnotation(annotatedMethod, i51.class);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Boolean hasAnySetter(d7 d7Var) {
        j51 j51Var = (j51) _findAnnotation(d7Var, j51.class);
        if (j51Var == null) {
            return null;
        }
        return Boolean.valueOf(j51Var.enabled());
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public boolean hasAnySetterAnnotation(AnnotatedMethod annotatedMethod) {
        return _hasAnnotation(annotatedMethod, j51.class);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Boolean hasAsKey(MapperConfig<?> mapperConfig, d7 d7Var) {
        g61 g61Var = (g61) _findAnnotation(d7Var, g61.class);
        if (g61Var == null) {
            return null;
        }
        return Boolean.valueOf(g61Var.value());
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Boolean hasAsValue(d7 d7Var) {
        w71 w71Var = (w71) _findAnnotation(d7Var, w71.class);
        if (w71Var == null) {
            return null;
        }
        return Boolean.valueOf(w71Var.value());
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public boolean hasAsValueAnnotation(AnnotatedMethod annotatedMethod) {
        w71 w71Var = (w71) _findAnnotation(annotatedMethod, w71.class);
        return w71Var != null && w71Var.value();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public boolean hasCreatorAnnotation(d7 d7Var) {
        JsonCreator jsonCreator = (JsonCreator) _findAnnotation(d7Var, JsonCreator.class);
        if (jsonCreator != null) {
            return jsonCreator.mode() != JsonCreator.Mode.DISABLED;
        }
        if (this._cfgConstructorPropertiesImpliesCreator) {
            boolean z = d7Var instanceof AnnotatedConstructor;
        }
        return false;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public boolean hasIgnoreMarker(AnnotatedMember annotatedMember) {
        return _isIgnorable(annotatedMember);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Boolean hasRequiredMarker(AnnotatedMember annotatedMember) {
        JsonProperty jsonProperty = (JsonProperty) _findAnnotation(annotatedMember, JsonProperty.class);
        if (jsonProperty != null) {
            return Boolean.valueOf(jsonProperty.required());
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public boolean isAnnotationBundle(Annotation annotation) {
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        Boolean boolValueOf = this._annotationsInside.get(clsAnnotationType);
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(clsAnnotationType.getAnnotation(b41.class) != null);
            this._annotationsInside.putIfAbsent(clsAnnotationType, boolValueOf);
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Boolean isIgnorableType(com.fasterxml.jackson.databind.introspect.a aVar) {
        e61 e61Var = (e61) _findAnnotation(aVar, e61.class);
        if (e61Var == null) {
            return null;
        }
        return Boolean.valueOf(e61Var.value());
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Boolean isTypeId(AnnotatedMember annotatedMember) {
        return Boolean.valueOf(_hasAnnotation(annotatedMember, n71.class));
    }

    protected Object readResolve() {
        if (this._annotationsInside == null) {
            this._annotationsInside = new LRUMap<>(48, 48);
        }
        return this;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JavaType refineDeserializationType(MapperConfig<?> mapperConfig, d7 d7Var, JavaType javaType) throws JsonMappingException {
        TypeFactory typeFactory = mapperConfig.getTypeFactory();
        r51 r51Var = (r51) _findAnnotation(d7Var, r51.class);
        Class<?> cls_classIfExplicit = r51Var == null ? null : _classIfExplicit(r51Var.as());
        if (cls_classIfExplicit != null && !javaType.hasRawClass(cls_classIfExplicit) && !_primitiveAndWrapper(javaType, cls_classIfExplicit)) {
            try {
                javaType = typeFactory.constructSpecializedType(javaType, cls_classIfExplicit);
            } catch (IllegalArgumentException e) {
                throw _databindException(e, String.format("Failed to narrow type %s with annotation (value %s), from '%s': %s", javaType, cls_classIfExplicit.getName(), d7Var.getName(), e.getMessage()));
            }
        }
        if (javaType.isMapLikeType()) {
            JavaType javaTypeMo16getKeyType = javaType.mo16getKeyType();
            Class<?> cls_classIfExplicit2 = r51Var == null ? null : _classIfExplicit(r51Var.keyAs());
            if (cls_classIfExplicit2 != null && !_primitiveAndWrapper(javaTypeMo16getKeyType, cls_classIfExplicit2)) {
                try {
                    javaType = ((MapLikeType) javaType).withKeyType(typeFactory.constructSpecializedType(javaTypeMo16getKeyType, cls_classIfExplicit2));
                } catch (IllegalArgumentException e2) {
                    throw _databindException(e2, String.format("Failed to narrow key type of %s with concrete-type annotation (value %s), from '%s': %s", javaType, cls_classIfExplicit2.getName(), d7Var.getName(), e2.getMessage()));
                }
            }
        }
        JavaType javaTypeMo15getContentType = javaType.mo15getContentType();
        if (javaTypeMo15getContentType == null) {
            return javaType;
        }
        Class<?> cls_classIfExplicit3 = r51Var != null ? _classIfExplicit(r51Var.contentAs()) : null;
        if (cls_classIfExplicit3 == null || _primitiveAndWrapper(javaTypeMo15getContentType, cls_classIfExplicit3)) {
            return javaType;
        }
        try {
            return javaType.withContentType(typeFactory.constructSpecializedType(javaTypeMo15getContentType, cls_classIfExplicit3));
        } catch (IllegalArgumentException e3) {
            throw _databindException(e3, String.format("Failed to narrow value type of %s with concrete-type annotation (value %s), from '%s': %s", javaType, cls_classIfExplicit3.getName(), d7Var.getName(), e3.getMessage()));
        }
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JavaType refineSerializationType(MapperConfig<?> mapperConfig, d7 d7Var, JavaType javaType) throws JsonMappingException {
        JavaType javaTypeWithStaticTyping;
        JavaType javaTypeWithStaticTyping2;
        TypeFactory typeFactory = mapperConfig.getTypeFactory();
        JsonSerialize jsonSerialize = (JsonSerialize) _findAnnotation(d7Var, JsonSerialize.class);
        Class<?> cls_classIfExplicit = jsonSerialize == null ? null : _classIfExplicit(jsonSerialize.as());
        if (cls_classIfExplicit != null) {
            if (javaType.hasRawClass(cls_classIfExplicit)) {
                javaType = javaType.withStaticTyping();
            } else {
                Class<?> rawClass = javaType.getRawClass();
                try {
                    if (cls_classIfExplicit.isAssignableFrom(rawClass)) {
                        javaType = typeFactory.constructGeneralizedType(javaType, cls_classIfExplicit);
                    } else if (rawClass.isAssignableFrom(cls_classIfExplicit)) {
                        javaType = typeFactory.constructSpecializedType(javaType, cls_classIfExplicit);
                    } else {
                        if (!_primitiveAndWrapper(rawClass, cls_classIfExplicit)) {
                            throw _databindException(String.format("Cannot refine serialization type %s into %s; types not related", javaType, cls_classIfExplicit.getName()));
                        }
                        javaType = javaType.withStaticTyping();
                    }
                } catch (IllegalArgumentException e) {
                    throw _databindException(e, String.format("Failed to widen type %s with annotation (value %s), from '%s': %s", javaType, cls_classIfExplicit.getName(), d7Var.getName(), e.getMessage()));
                }
            }
        }
        if (javaType.isMapLikeType()) {
            JavaType javaTypeMo16getKeyType = javaType.mo16getKeyType();
            Class<?> cls_classIfExplicit2 = jsonSerialize == null ? null : _classIfExplicit(jsonSerialize.keyAs());
            if (cls_classIfExplicit2 != null) {
                if (javaTypeMo16getKeyType.hasRawClass(cls_classIfExplicit2)) {
                    javaTypeWithStaticTyping2 = javaTypeMo16getKeyType.withStaticTyping();
                } else {
                    Class<?> rawClass2 = javaTypeMo16getKeyType.getRawClass();
                    try {
                        if (cls_classIfExplicit2.isAssignableFrom(rawClass2)) {
                            javaTypeWithStaticTyping2 = typeFactory.constructGeneralizedType(javaTypeMo16getKeyType, cls_classIfExplicit2);
                        } else if (rawClass2.isAssignableFrom(cls_classIfExplicit2)) {
                            javaTypeWithStaticTyping2 = typeFactory.constructSpecializedType(javaTypeMo16getKeyType, cls_classIfExplicit2);
                        } else {
                            if (!_primitiveAndWrapper(rawClass2, cls_classIfExplicit2)) {
                                throw _databindException(String.format("Cannot refine serialization key type %s into %s; types not related", javaTypeMo16getKeyType, cls_classIfExplicit2.getName()));
                            }
                            javaTypeWithStaticTyping2 = javaTypeMo16getKeyType.withStaticTyping();
                        }
                    } catch (IllegalArgumentException e2) {
                        throw _databindException(e2, String.format("Failed to widen key type of %s with concrete-type annotation (value %s), from '%s': %s", javaType, cls_classIfExplicit2.getName(), d7Var.getName(), e2.getMessage()));
                    }
                }
                javaType = ((MapLikeType) javaType).withKeyType(javaTypeWithStaticTyping2);
            }
        }
        JavaType javaTypeMo15getContentType = javaType.mo15getContentType();
        if (javaTypeMo15getContentType == null) {
            return javaType;
        }
        Class<?> cls_classIfExplicit3 = jsonSerialize != null ? _classIfExplicit(jsonSerialize.contentAs()) : null;
        if (cls_classIfExplicit3 == null) {
            return javaType;
        }
        if (javaTypeMo15getContentType.hasRawClass(cls_classIfExplicit3)) {
            javaTypeWithStaticTyping = javaTypeMo15getContentType.withStaticTyping();
        } else {
            Class<?> rawClass3 = javaTypeMo15getContentType.getRawClass();
            try {
                if (cls_classIfExplicit3.isAssignableFrom(rawClass3)) {
                    javaTypeWithStaticTyping = typeFactory.constructGeneralizedType(javaTypeMo15getContentType, cls_classIfExplicit3);
                } else if (rawClass3.isAssignableFrom(cls_classIfExplicit3)) {
                    javaTypeWithStaticTyping = typeFactory.constructSpecializedType(javaTypeMo15getContentType, cls_classIfExplicit3);
                } else {
                    if (!_primitiveAndWrapper(rawClass3, cls_classIfExplicit3)) {
                        throw _databindException(String.format("Cannot refine serialization content type %s into %s; types not related", javaTypeMo15getContentType, cls_classIfExplicit3.getName()));
                    }
                    javaTypeWithStaticTyping = javaTypeMo15getContentType.withStaticTyping();
                }
            } catch (IllegalArgumentException e3) {
                throw _databindException(e3, String.format("Internal error: failed to refine value type of %s with concrete-type annotation (value %s), from '%s': %s", javaType, cls_classIfExplicit3.getName(), d7Var.getName(), e3.getMessage()));
            }
        }
        return javaType.withContentType(javaTypeWithStaticTyping);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public AnnotatedMethod resolveSetterConflict(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, AnnotatedMethod annotatedMethod2) {
        Class<?> rawParameterType = annotatedMethod.getRawParameterType(0);
        Class<?> rawParameterType2 = annotatedMethod2.getRawParameterType(0);
        if (rawParameterType.isPrimitive()) {
            if (rawParameterType2.isPrimitive()) {
                return null;
            }
            return annotatedMethod;
        }
        if (rawParameterType2.isPrimitive()) {
            return annotatedMethod2;
        }
        if (rawParameterType == String.class) {
            if (rawParameterType2 != String.class) {
                return annotatedMethod;
            }
        } else if (rawParameterType2 == String.class) {
            return annotatedMethod2;
        }
        return null;
    }

    public JacksonAnnotationIntrospector setConstructorPropertiesImpliesCreator(boolean z) {
        this._cfgConstructorPropertiesImpliesCreator = z;
        return this;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Version version() {
        return vy1.a;
    }

    private JsonMappingException _databindException(Throwable th, String str) {
        return new JsonMappingException((Closeable) null, str, th);
    }

    protected Class<?> _classIfExplicit(Class<?> cls, Class<?> cls2) {
        Class<?> cls_classIfExplicit = _classIfExplicit(cls);
        if (cls_classIfExplicit == null || cls_classIfExplicit == cls2) {
            return null;
        }
        return cls_classIfExplicit;
    }

    private boolean _primitiveAndWrapper(JavaType javaType, Class<?> cls) {
        if (javaType.isPrimitive()) {
            return javaType.hasRawClass(ay.b0(cls));
        }
        return cls.isPrimitive() && cls == ay.b0(javaType.getRawClass());
    }

    protected BeanPropertyWriter _constructVirtualProperty(k51.b bVar, MapperConfig<?> mapperConfig, com.fasterxml.jackson.databind.introspect.a aVar) {
        PropertyMetadata propertyMetadata = bVar.required() ? PropertyMetadata.STD_REQUIRED : PropertyMetadata.STD_OPTIONAL;
        PropertyName propertyName_propertyName = _propertyName(bVar.name(), bVar.namespace());
        JavaType javaTypeConstructType = mapperConfig.constructType(bVar.type());
        bp2 bp2VarA = bp2.A(mapperConfig, new VirtualAnnotatedMember(aVar, aVar.getRawType(), propertyName_propertyName.getSimpleName(), javaTypeConstructType), propertyName_propertyName, propertyMetadata, bVar.include());
        Class clsValue = bVar.value();
        mapperConfig.getHandlerInstantiator();
        return ((VirtualBeanPropertyWriter) ay.l(clsValue, mapperConfig.canOverrideAccessModifiers())).withConfig(mapperConfig, aVar, bp2VarA, javaTypeConstructType);
    }
}
