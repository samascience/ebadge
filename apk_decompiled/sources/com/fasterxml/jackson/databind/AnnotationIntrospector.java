package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import defpackage.d7;
import defpackage.lt1;
import defpackage.q61;
import defpackage.x63;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class AnnotationIntrospector implements Serializable {

    public static class ReferenceProperty {
        private final Type a;
        private final String b;

        public enum Type {
            MANAGED_REFERENCE,
            BACK_REFERENCE
        }

        public ReferenceProperty(Type type, String str) {
            this.a = type;
            this.b = str;
        }

        public static ReferenceProperty a(String str) {
            return new ReferenceProperty(Type.BACK_REFERENCE, str);
        }

        public static ReferenceProperty e(String str) {
            return new ReferenceProperty(Type.MANAGED_REFERENCE, str);
        }

        public String b() {
            return this.b;
        }

        public boolean c() {
            return this.a == Type.BACK_REFERENCE;
        }

        public boolean d() {
            return this.a == Type.MANAGED_REFERENCE;
        }
    }

    public static AnnotationIntrospector nopInstance() {
        return NopAnnotationIntrospector.instance;
    }

    public static AnnotationIntrospector pair(AnnotationIntrospector annotationIntrospector, AnnotationIntrospector annotationIntrospector2) {
        return new AnnotationIntrospectorPair(annotationIntrospector, annotationIntrospector2);
    }

    protected <A extends Annotation> A _findAnnotation(d7 d7Var, Class<A> cls) {
        return (A) d7Var.getAnnotation(cls);
    }

    protected boolean _hasAnnotation(d7 d7Var, Class<? extends Annotation> cls) {
        return d7Var.hasAnnotation(cls);
    }

    protected boolean _hasOneOf(d7 d7Var, Class<? extends Annotation>[] clsArr) {
        return d7Var.hasOneOf(clsArr);
    }

    public Collection<AnnotationIntrospector> allIntrospectors() {
        return Collections.singletonList(this);
    }

    public void findAndAddVirtualProperties(MapperConfig<?> mapperConfig, com.fasterxml.jackson.databind.introspect.a aVar, List<BeanPropertyWriter> list) {
    }

    public VisibilityChecker findAutoDetectVisibility(com.fasterxml.jackson.databind.introspect.a aVar, VisibilityChecker visibilityChecker) {
        return visibilityChecker;
    }

    public String findClassDescription(com.fasterxml.jackson.databind.introspect.a aVar) {
        return null;
    }

    public Object findContentDeserializer(d7 d7Var) {
        return null;
    }

    public Object findContentSerializer(d7 d7Var) {
        return null;
    }

    public JsonCreator.Mode findCreatorAnnotation(MapperConfig<?> mapperConfig, d7 d7Var) {
        if (!hasCreatorAnnotation(d7Var)) {
            return null;
        }
        JsonCreator.Mode modeFindCreatorBinding = findCreatorBinding(d7Var);
        return modeFindCreatorBinding == null ? JsonCreator.Mode.DEFAULT : modeFindCreatorBinding;
    }

    @Deprecated
    public JsonCreator.Mode findCreatorBinding(d7 d7Var) {
        return null;
    }

    public Enum<?> findDefaultEnumValue(Class<Enum<?>> cls) {
        return null;
    }

    public Object findDeserializationContentConverter(AnnotatedMember annotatedMember) {
        return null;
    }

    @Deprecated
    public Class<?> findDeserializationContentType(d7 d7Var, JavaType javaType) {
        return null;
    }

    public Object findDeserializationConverter(d7 d7Var) {
        return null;
    }

    @Deprecated
    public Class<?> findDeserializationKeyType(d7 d7Var, JavaType javaType) {
        return null;
    }

    @Deprecated
    public Class<?> findDeserializationType(d7 d7Var, JavaType javaType) {
        return null;
    }

    public Object findDeserializer(d7 d7Var) {
        return null;
    }

    public void findEnumAliases(Class<?> cls, Enum<?>[] enumArr, String[][] strArr) {
    }

    @Deprecated
    public String findEnumValue(Enum<?> r1) {
        return r1.name();
    }

    public String[] findEnumValues(Class<?> cls, Enum<?>[] enumArr, String[] strArr) {
        return strArr;
    }

    public Object findFilterId(d7 d7Var) {
        return null;
    }

    public JsonFormat.Value findFormat(d7 d7Var) {
        return JsonFormat.Value.empty();
    }

    @Deprecated
    public Boolean findIgnoreUnknownProperties(com.fasterxml.jackson.databind.introspect.a aVar) {
        return null;
    }

    public String findImplicitPropertyName(AnnotatedMember annotatedMember) {
        return null;
    }

    public JacksonInject.Value findInjectableValue(AnnotatedMember annotatedMember) {
        Object objFindInjectableValueId = findInjectableValueId(annotatedMember);
        if (objFindInjectableValueId != null) {
            return JacksonInject.Value.forId(objFindInjectableValueId);
        }
        return null;
    }

    @Deprecated
    public Object findInjectableValueId(AnnotatedMember annotatedMember) {
        return null;
    }

    public Object findKeyDeserializer(d7 d7Var) {
        return null;
    }

    public Object findKeySerializer(d7 d7Var) {
        return null;
    }

    public Boolean findMergeInfo(d7 d7Var) {
        return null;
    }

    public PropertyName findNameForDeserialization(d7 d7Var) {
        return null;
    }

    public PropertyName findNameForSerialization(d7 d7Var) {
        return null;
    }

    public Object findNamingStrategy(com.fasterxml.jackson.databind.introspect.a aVar) {
        return null;
    }

    public Object findNullSerializer(d7 d7Var) {
        return null;
    }

    public lt1 findObjectIdInfo(d7 d7Var) {
        return null;
    }

    public lt1 findObjectReferenceInfo(d7 d7Var, lt1 lt1Var) {
        return lt1Var;
    }

    public Class<?> findPOJOBuilder(com.fasterxml.jackson.databind.introspect.a aVar) {
        return null;
    }

    public q61.a findPOJOBuilderConfig(com.fasterxml.jackson.databind.introspect.a aVar) {
        return null;
    }

    @Deprecated
    public String[] findPropertiesToIgnore(d7 d7Var, boolean z) {
        return null;
    }

    public JsonProperty.Access findPropertyAccess(d7 d7Var) {
        return null;
    }

    public List<PropertyName> findPropertyAliases(d7 d7Var) {
        return null;
    }

    public x63 findPropertyContentTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        return null;
    }

    public String findPropertyDefaultValue(d7 d7Var) {
        return null;
    }

    public String findPropertyDescription(d7 d7Var) {
        return null;
    }

    public JsonIgnoreProperties.Value findPropertyIgnoralByName(MapperConfig<?> mapperConfig, d7 d7Var) {
        return findPropertyIgnorals(d7Var);
    }

    @Deprecated
    public JsonIgnoreProperties.Value findPropertyIgnorals(d7 d7Var) {
        return JsonIgnoreProperties.Value.empty();
    }

    public JsonInclude.Value findPropertyInclusion(d7 d7Var) {
        return JsonInclude.Value.empty();
    }

    public JsonIncludeProperties.Value findPropertyInclusionByName(MapperConfig<?> mapperConfig, d7 d7Var) {
        return JsonIncludeProperties.Value.all();
    }

    public Integer findPropertyIndex(d7 d7Var) {
        return null;
    }

    public x63 findPropertyTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        return null;
    }

    public ReferenceProperty findReferenceType(AnnotatedMember annotatedMember) {
        return null;
    }

    public PropertyName findRenameByField(MapperConfig<?> mapperConfig, AnnotatedField annotatedField, PropertyName propertyName) {
        return null;
    }

    public PropertyName findRootName(com.fasterxml.jackson.databind.introspect.a aVar) {
        return null;
    }

    public Object findSerializationContentConverter(AnnotatedMember annotatedMember) {
        return null;
    }

    @Deprecated
    public Class<?> findSerializationContentType(d7 d7Var, JavaType javaType) {
        return null;
    }

    public Object findSerializationConverter(d7 d7Var) {
        return null;
    }

    @Deprecated
    public JsonInclude.Include findSerializationInclusion(d7 d7Var, JsonInclude.Include include) {
        return include;
    }

    @Deprecated
    public JsonInclude.Include findSerializationInclusionForContent(d7 d7Var, JsonInclude.Include include) {
        return include;
    }

    @Deprecated
    public Class<?> findSerializationKeyType(d7 d7Var, JavaType javaType) {
        return null;
    }

    public String[] findSerializationPropertyOrder(com.fasterxml.jackson.databind.introspect.a aVar) {
        return null;
    }

    public Boolean findSerializationSortAlphabetically(d7 d7Var) {
        return null;
    }

    @Deprecated
    public Class<?> findSerializationType(d7 d7Var) {
        return null;
    }

    public JsonSerialize.Typing findSerializationTyping(d7 d7Var) {
        return null;
    }

    public Object findSerializer(d7 d7Var) {
        return null;
    }

    public JsonSetter.Value findSetterInfo(d7 d7Var) {
        return JsonSetter.Value.empty();
    }

    public List<NamedType> findSubtypes(d7 d7Var) {
        return null;
    }

    public String findTypeName(com.fasterxml.jackson.databind.introspect.a aVar) {
        return null;
    }

    public x63 findTypeResolver(MapperConfig<?> mapperConfig, com.fasterxml.jackson.databind.introspect.a aVar, JavaType javaType) {
        return null;
    }

    public NameTransformer findUnwrappingNameTransformer(AnnotatedMember annotatedMember) {
        return null;
    }

    public Object findValueInstantiator(com.fasterxml.jackson.databind.introspect.a aVar) {
        return null;
    }

    public Class<?>[] findViews(d7 d7Var) {
        return null;
    }

    public PropertyName findWrapperName(d7 d7Var) {
        return null;
    }

    public Boolean hasAnyGetter(d7 d7Var) {
        if ((d7Var instanceof AnnotatedMethod) && hasAnyGetterAnnotation((AnnotatedMethod) d7Var)) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Deprecated
    public boolean hasAnyGetterAnnotation(AnnotatedMethod annotatedMethod) {
        return false;
    }

    public Boolean hasAnySetter(d7 d7Var) {
        return null;
    }

    @Deprecated
    public boolean hasAnySetterAnnotation(AnnotatedMethod annotatedMethod) {
        return false;
    }

    public Boolean hasAsKey(MapperConfig<?> mapperConfig, d7 d7Var) {
        return null;
    }

    public Boolean hasAsValue(d7 d7Var) {
        if ((d7Var instanceof AnnotatedMethod) && hasAsValueAnnotation((AnnotatedMethod) d7Var)) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Deprecated
    public boolean hasAsValueAnnotation(AnnotatedMethod annotatedMethod) {
        return false;
    }

    @Deprecated
    public boolean hasCreatorAnnotation(d7 d7Var) {
        return false;
    }

    public boolean hasIgnoreMarker(AnnotatedMember annotatedMember) {
        return false;
    }

    public Boolean hasRequiredMarker(AnnotatedMember annotatedMember) {
        return null;
    }

    public boolean isAnnotationBundle(Annotation annotation) {
        return false;
    }

    public Boolean isIgnorableType(com.fasterxml.jackson.databind.introspect.a aVar) {
        return null;
    }

    public Boolean isTypeId(AnnotatedMember annotatedMember) {
        return null;
    }

    public JavaType refineDeserializationType(MapperConfig<?> mapperConfig, d7 d7Var, JavaType javaType) throws JsonMappingException {
        return javaType;
    }

    public JavaType refineSerializationType(MapperConfig<?> mapperConfig, d7 d7Var, JavaType javaType) throws JsonMappingException {
        return javaType;
    }

    public AnnotatedMethod resolveSetterConflict(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, AnnotatedMethod annotatedMethod2) {
        return null;
    }

    public abstract Version version();

    public Collection<AnnotationIntrospector> allIntrospectors(Collection<AnnotationIntrospector> collection) {
        collection.add(this);
        return collection;
    }
}
