package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import defpackage.a91;
import defpackage.ay;
import defpackage.d7;
import defpackage.f71;
import defpackage.lt1;
import defpackage.q61;
import defpackage.s51;
import defpackage.x63;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AnnotationIntrospectorPair extends AnnotationIntrospector implements Serializable {
    private static final long serialVersionUID = 1;
    protected final AnnotationIntrospector _primary;
    protected final AnnotationIntrospector _secondary;

    public AnnotationIntrospectorPair(AnnotationIntrospector annotationIntrospector, AnnotationIntrospector annotationIntrospector2) {
        this._primary = annotationIntrospector;
        this._secondary = annotationIntrospector2;
    }

    public static AnnotationIntrospector create(AnnotationIntrospector annotationIntrospector, AnnotationIntrospector annotationIntrospector2) {
        if (annotationIntrospector == null) {
            return annotationIntrospector2;
        }
        return annotationIntrospector2 == null ? annotationIntrospector : new AnnotationIntrospectorPair(annotationIntrospector, annotationIntrospector2);
    }

    protected Object _explicitClassOrOb(Object obj, Class<?> cls) {
        if (obj == null || obj == cls) {
            return null;
        }
        if ((obj instanceof Class) && ay.J((Class) obj)) {
            return null;
        }
        return obj;
    }

    protected boolean _isExplicitClassOrOb(Object obj, Class<?> cls) {
        if (obj == null || obj == cls) {
            return false;
        }
        if (obj instanceof Class) {
            return !ay.J((Class) obj);
        }
        return true;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Collection<AnnotationIntrospector> allIntrospectors() {
        return allIntrospectors(new ArrayList());
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public void findAndAddVirtualProperties(MapperConfig<?> mapperConfig, a aVar, List<BeanPropertyWriter> list) {
        this._primary.findAndAddVirtualProperties(mapperConfig, aVar, list);
        this._secondary.findAndAddVirtualProperties(mapperConfig, aVar, list);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public VisibilityChecker findAutoDetectVisibility(a aVar, VisibilityChecker visibilityChecker) {
        return this._primary.findAutoDetectVisibility(aVar, this._secondary.findAutoDetectVisibility(aVar, visibilityChecker));
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public String findClassDescription(a aVar) {
        String strFindClassDescription = this._primary.findClassDescription(aVar);
        return (strFindClassDescription == null || strFindClassDescription.isEmpty()) ? this._secondary.findClassDescription(aVar) : strFindClassDescription;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findContentDeserializer(d7 d7Var) {
        Object objFindContentDeserializer = this._primary.findContentDeserializer(d7Var);
        return _isExplicitClassOrOb(objFindContentDeserializer, s51.a.class) ? objFindContentDeserializer : _explicitClassOrOb(this._secondary.findContentDeserializer(d7Var), s51.a.class);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findContentSerializer(d7 d7Var) {
        Object objFindContentSerializer = this._primary.findContentSerializer(d7Var);
        return _isExplicitClassOrOb(objFindContentSerializer, f71.a.class) ? objFindContentSerializer : _explicitClassOrOb(this._secondary.findContentSerializer(d7Var), f71.a.class);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JsonCreator.Mode findCreatorAnnotation(MapperConfig<?> mapperConfig, d7 d7Var) {
        JsonCreator.Mode modeFindCreatorAnnotation = this._primary.findCreatorAnnotation(mapperConfig, d7Var);
        return modeFindCreatorAnnotation == null ? this._secondary.findCreatorAnnotation(mapperConfig, d7Var) : modeFindCreatorAnnotation;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public JsonCreator.Mode findCreatorBinding(d7 d7Var) {
        JsonCreator.Mode modeFindCreatorBinding = this._primary.findCreatorBinding(d7Var);
        return modeFindCreatorBinding != null ? modeFindCreatorBinding : this._secondary.findCreatorBinding(d7Var);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Enum<?> findDefaultEnumValue(Class<Enum<?>> cls) {
        Enum<?> enumFindDefaultEnumValue = this._primary.findDefaultEnumValue(cls);
        return enumFindDefaultEnumValue == null ? this._secondary.findDefaultEnumValue(cls) : enumFindDefaultEnumValue;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findDeserializationContentConverter(AnnotatedMember annotatedMember) {
        Object objFindDeserializationContentConverter = this._primary.findDeserializationContentConverter(annotatedMember);
        return objFindDeserializationContentConverter == null ? this._secondary.findDeserializationContentConverter(annotatedMember) : objFindDeserializationContentConverter;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public Class<?> findDeserializationContentType(d7 d7Var, JavaType javaType) {
        Class<?> clsFindDeserializationContentType = this._primary.findDeserializationContentType(d7Var, javaType);
        return clsFindDeserializationContentType == null ? this._secondary.findDeserializationContentType(d7Var, javaType) : clsFindDeserializationContentType;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findDeserializationConverter(d7 d7Var) {
        Object objFindDeserializationConverter = this._primary.findDeserializationConverter(d7Var);
        return objFindDeserializationConverter == null ? this._secondary.findDeserializationConverter(d7Var) : objFindDeserializationConverter;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public Class<?> findDeserializationKeyType(d7 d7Var, JavaType javaType) {
        Class<?> clsFindDeserializationKeyType = this._primary.findDeserializationKeyType(d7Var, javaType);
        return clsFindDeserializationKeyType == null ? this._secondary.findDeserializationKeyType(d7Var, javaType) : clsFindDeserializationKeyType;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public Class<?> findDeserializationType(d7 d7Var, JavaType javaType) {
        Class<?> clsFindDeserializationType = this._primary.findDeserializationType(d7Var, javaType);
        return clsFindDeserializationType != null ? clsFindDeserializationType : this._secondary.findDeserializationType(d7Var, javaType);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findDeserializer(d7 d7Var) {
        Object objFindDeserializer = this._primary.findDeserializer(d7Var);
        return _isExplicitClassOrOb(objFindDeserializer, s51.a.class) ? objFindDeserializer : _explicitClassOrOb(this._secondary.findDeserializer(d7Var), s51.a.class);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public void findEnumAliases(Class<?> cls, Enum<?>[] enumArr, String[][] strArr) {
        this._secondary.findEnumAliases(cls, enumArr, strArr);
        this._primary.findEnumAliases(cls, enumArr, strArr);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public String findEnumValue(Enum<?> r2) {
        String strFindEnumValue = this._primary.findEnumValue(r2);
        return strFindEnumValue == null ? this._secondary.findEnumValue(r2) : strFindEnumValue;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public String[] findEnumValues(Class<?> cls, Enum<?>[] enumArr, String[] strArr) {
        return this._primary.findEnumValues(cls, enumArr, this._secondary.findEnumValues(cls, enumArr, strArr));
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findFilterId(d7 d7Var) {
        Object objFindFilterId = this._primary.findFilterId(d7Var);
        return objFindFilterId == null ? this._secondary.findFilterId(d7Var) : objFindFilterId;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JsonFormat.Value findFormat(d7 d7Var) {
        JsonFormat.Value valueFindFormat = this._primary.findFormat(d7Var);
        JsonFormat.Value valueFindFormat2 = this._secondary.findFormat(d7Var);
        return valueFindFormat2 == null ? valueFindFormat : valueFindFormat2.withOverrides(valueFindFormat);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public Boolean findIgnoreUnknownProperties(a aVar) {
        Boolean boolFindIgnoreUnknownProperties = this._primary.findIgnoreUnknownProperties(aVar);
        return boolFindIgnoreUnknownProperties == null ? this._secondary.findIgnoreUnknownProperties(aVar) : boolFindIgnoreUnknownProperties;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public String findImplicitPropertyName(AnnotatedMember annotatedMember) {
        String strFindImplicitPropertyName = this._primary.findImplicitPropertyName(annotatedMember);
        return strFindImplicitPropertyName == null ? this._secondary.findImplicitPropertyName(annotatedMember) : strFindImplicitPropertyName;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JacksonInject.Value findInjectableValue(AnnotatedMember annotatedMember) {
        JacksonInject.Value valueFindInjectableValue;
        JacksonInject.Value valueFindInjectableValue2 = this._primary.findInjectableValue(annotatedMember);
        if ((valueFindInjectableValue2 != null && valueFindInjectableValue2.getUseInput() != null) || (valueFindInjectableValue = this._secondary.findInjectableValue(annotatedMember)) == null) {
            return valueFindInjectableValue2;
        }
        if (valueFindInjectableValue2 != null) {
            valueFindInjectableValue = valueFindInjectableValue2.withUseInput(valueFindInjectableValue.getUseInput());
        }
        return valueFindInjectableValue;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public Object findInjectableValueId(AnnotatedMember annotatedMember) {
        Object objFindInjectableValueId = this._primary.findInjectableValueId(annotatedMember);
        return objFindInjectableValueId == null ? this._secondary.findInjectableValueId(annotatedMember) : objFindInjectableValueId;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findKeyDeserializer(d7 d7Var) {
        Object objFindKeyDeserializer = this._primary.findKeyDeserializer(d7Var);
        return _isExplicitClassOrOb(objFindKeyDeserializer, a91.a.class) ? objFindKeyDeserializer : _explicitClassOrOb(this._secondary.findKeyDeserializer(d7Var), a91.a.class);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findKeySerializer(d7 d7Var) {
        Object objFindKeySerializer = this._primary.findKeySerializer(d7Var);
        return _isExplicitClassOrOb(objFindKeySerializer, f71.a.class) ? objFindKeySerializer : _explicitClassOrOb(this._secondary.findKeySerializer(d7Var), f71.a.class);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Boolean findMergeInfo(d7 d7Var) {
        Boolean boolFindMergeInfo = this._primary.findMergeInfo(d7Var);
        return boolFindMergeInfo == null ? this._secondary.findMergeInfo(d7Var) : boolFindMergeInfo;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public PropertyName findNameForDeserialization(d7 d7Var) {
        PropertyName propertyNameFindNameForDeserialization;
        PropertyName propertyNameFindNameForDeserialization2 = this._primary.findNameForDeserialization(d7Var);
        if (propertyNameFindNameForDeserialization2 == null) {
            return this._secondary.findNameForDeserialization(d7Var);
        }
        return (propertyNameFindNameForDeserialization2 != PropertyName.USE_DEFAULT || (propertyNameFindNameForDeserialization = this._secondary.findNameForDeserialization(d7Var)) == null) ? propertyNameFindNameForDeserialization2 : propertyNameFindNameForDeserialization;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public PropertyName findNameForSerialization(d7 d7Var) {
        PropertyName propertyNameFindNameForSerialization;
        PropertyName propertyNameFindNameForSerialization2 = this._primary.findNameForSerialization(d7Var);
        if (propertyNameFindNameForSerialization2 == null) {
            return this._secondary.findNameForSerialization(d7Var);
        }
        return (propertyNameFindNameForSerialization2 != PropertyName.USE_DEFAULT || (propertyNameFindNameForSerialization = this._secondary.findNameForSerialization(d7Var)) == null) ? propertyNameFindNameForSerialization2 : propertyNameFindNameForSerialization;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findNamingStrategy(a aVar) {
        Object objFindNamingStrategy = this._primary.findNamingStrategy(aVar);
        return objFindNamingStrategy == null ? this._secondary.findNamingStrategy(aVar) : objFindNamingStrategy;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findNullSerializer(d7 d7Var) {
        Object objFindNullSerializer = this._primary.findNullSerializer(d7Var);
        return _isExplicitClassOrOb(objFindNullSerializer, f71.a.class) ? objFindNullSerializer : _explicitClassOrOb(this._secondary.findNullSerializer(d7Var), f71.a.class);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public lt1 findObjectIdInfo(d7 d7Var) {
        lt1 lt1VarFindObjectIdInfo = this._primary.findObjectIdInfo(d7Var);
        return lt1VarFindObjectIdInfo == null ? this._secondary.findObjectIdInfo(d7Var) : lt1VarFindObjectIdInfo;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public lt1 findObjectReferenceInfo(d7 d7Var, lt1 lt1Var) {
        return this._primary.findObjectReferenceInfo(d7Var, this._secondary.findObjectReferenceInfo(d7Var, lt1Var));
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Class<?> findPOJOBuilder(a aVar) {
        Class<?> clsFindPOJOBuilder = this._primary.findPOJOBuilder(aVar);
        return clsFindPOJOBuilder == null ? this._secondary.findPOJOBuilder(aVar) : clsFindPOJOBuilder;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public q61.a findPOJOBuilderConfig(a aVar) {
        q61.a aVarFindPOJOBuilderConfig = this._primary.findPOJOBuilderConfig(aVar);
        return aVarFindPOJOBuilderConfig == null ? this._secondary.findPOJOBuilderConfig(aVar) : aVarFindPOJOBuilderConfig;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public String[] findPropertiesToIgnore(d7 d7Var, boolean z) {
        String[] strArrFindPropertiesToIgnore = this._primary.findPropertiesToIgnore(d7Var, z);
        return strArrFindPropertiesToIgnore == null ? this._secondary.findPropertiesToIgnore(d7Var, z) : strArrFindPropertiesToIgnore;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JsonProperty.Access findPropertyAccess(d7 d7Var) {
        JsonProperty.Access accessFindPropertyAccess = this._primary.findPropertyAccess(d7Var);
        if (accessFindPropertyAccess != null && accessFindPropertyAccess != JsonProperty.Access.AUTO) {
            return accessFindPropertyAccess;
        }
        JsonProperty.Access accessFindPropertyAccess2 = this._secondary.findPropertyAccess(d7Var);
        return accessFindPropertyAccess2 != null ? accessFindPropertyAccess2 : JsonProperty.Access.AUTO;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public List<PropertyName> findPropertyAliases(d7 d7Var) {
        List<PropertyName> listFindPropertyAliases = this._primary.findPropertyAliases(d7Var);
        return listFindPropertyAliases == null ? this._secondary.findPropertyAliases(d7Var) : listFindPropertyAliases;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public x63 findPropertyContentTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        x63 x63VarFindPropertyContentTypeResolver = this._primary.findPropertyContentTypeResolver(mapperConfig, annotatedMember, javaType);
        return x63VarFindPropertyContentTypeResolver == null ? this._secondary.findPropertyContentTypeResolver(mapperConfig, annotatedMember, javaType) : x63VarFindPropertyContentTypeResolver;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public String findPropertyDefaultValue(d7 d7Var) {
        String strFindPropertyDefaultValue = this._primary.findPropertyDefaultValue(d7Var);
        return (strFindPropertyDefaultValue == null || strFindPropertyDefaultValue.isEmpty()) ? this._secondary.findPropertyDefaultValue(d7Var) : strFindPropertyDefaultValue;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public String findPropertyDescription(d7 d7Var) {
        String strFindPropertyDescription = this._primary.findPropertyDescription(d7Var);
        return strFindPropertyDescription == null ? this._secondary.findPropertyDescription(d7Var) : strFindPropertyDescription;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JsonIgnoreProperties.Value findPropertyIgnoralByName(MapperConfig<?> mapperConfig, d7 d7Var) {
        JsonIgnoreProperties.Value valueFindPropertyIgnoralByName = this._secondary.findPropertyIgnoralByName(mapperConfig, d7Var);
        JsonIgnoreProperties.Value valueFindPropertyIgnoralByName2 = this._primary.findPropertyIgnoralByName(mapperConfig, d7Var);
        return valueFindPropertyIgnoralByName == null ? valueFindPropertyIgnoralByName2 : valueFindPropertyIgnoralByName.withOverrides(valueFindPropertyIgnoralByName2);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public JsonIgnoreProperties.Value findPropertyIgnorals(d7 d7Var) {
        JsonIgnoreProperties.Value valueFindPropertyIgnorals = this._secondary.findPropertyIgnorals(d7Var);
        JsonIgnoreProperties.Value valueFindPropertyIgnorals2 = this._primary.findPropertyIgnorals(d7Var);
        return valueFindPropertyIgnorals == null ? valueFindPropertyIgnorals2 : valueFindPropertyIgnorals.withOverrides(valueFindPropertyIgnorals2);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JsonInclude.Value findPropertyInclusion(d7 d7Var) {
        JsonInclude.Value valueFindPropertyInclusion = this._secondary.findPropertyInclusion(d7Var);
        JsonInclude.Value valueFindPropertyInclusion2 = this._primary.findPropertyInclusion(d7Var);
        return valueFindPropertyInclusion == null ? valueFindPropertyInclusion2 : valueFindPropertyInclusion.withOverrides(valueFindPropertyInclusion2);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JsonIncludeProperties.Value findPropertyInclusionByName(MapperConfig<?> mapperConfig, d7 d7Var) {
        JsonIncludeProperties.Value valueFindPropertyInclusionByName = this._secondary.findPropertyInclusionByName(mapperConfig, d7Var);
        JsonIncludeProperties.Value valueFindPropertyInclusionByName2 = this._primary.findPropertyInclusionByName(mapperConfig, d7Var);
        return valueFindPropertyInclusionByName == null ? valueFindPropertyInclusionByName2 : valueFindPropertyInclusionByName.withOverrides(valueFindPropertyInclusionByName2);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Integer findPropertyIndex(d7 d7Var) {
        Integer numFindPropertyIndex = this._primary.findPropertyIndex(d7Var);
        return numFindPropertyIndex == null ? this._secondary.findPropertyIndex(d7Var) : numFindPropertyIndex;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public x63 findPropertyTypeResolver(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        x63 x63VarFindPropertyTypeResolver = this._primary.findPropertyTypeResolver(mapperConfig, annotatedMember, javaType);
        return x63VarFindPropertyTypeResolver == null ? this._secondary.findPropertyTypeResolver(mapperConfig, annotatedMember, javaType) : x63VarFindPropertyTypeResolver;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public AnnotationIntrospector.ReferenceProperty findReferenceType(AnnotatedMember annotatedMember) {
        AnnotationIntrospector.ReferenceProperty referencePropertyFindReferenceType = this._primary.findReferenceType(annotatedMember);
        return referencePropertyFindReferenceType == null ? this._secondary.findReferenceType(annotatedMember) : referencePropertyFindReferenceType;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public PropertyName findRenameByField(MapperConfig<?> mapperConfig, AnnotatedField annotatedField, PropertyName propertyName) {
        PropertyName propertyNameFindRenameByField = this._secondary.findRenameByField(mapperConfig, annotatedField, propertyName);
        return propertyNameFindRenameByField == null ? this._primary.findRenameByField(mapperConfig, annotatedField, propertyName) : propertyNameFindRenameByField;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public PropertyName findRootName(a aVar) {
        PropertyName propertyNameFindRootName;
        PropertyName propertyNameFindRootName2 = this._primary.findRootName(aVar);
        if (propertyNameFindRootName2 == null) {
            return this._secondary.findRootName(aVar);
        }
        return (propertyNameFindRootName2.hasSimpleName() || (propertyNameFindRootName = this._secondary.findRootName(aVar)) == null) ? propertyNameFindRootName2 : propertyNameFindRootName;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findSerializationContentConverter(AnnotatedMember annotatedMember) {
        Object objFindSerializationContentConverter = this._primary.findSerializationContentConverter(annotatedMember);
        return objFindSerializationContentConverter == null ? this._secondary.findSerializationContentConverter(annotatedMember) : objFindSerializationContentConverter;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public Class<?> findSerializationContentType(d7 d7Var, JavaType javaType) {
        Class<?> clsFindSerializationContentType = this._primary.findSerializationContentType(d7Var, javaType);
        return clsFindSerializationContentType == null ? this._secondary.findSerializationContentType(d7Var, javaType) : clsFindSerializationContentType;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findSerializationConverter(d7 d7Var) {
        Object objFindSerializationConverter = this._primary.findSerializationConverter(d7Var);
        return objFindSerializationConverter == null ? this._secondary.findSerializationConverter(d7Var) : objFindSerializationConverter;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public JsonInclude.Include findSerializationInclusion(d7 d7Var, JsonInclude.Include include) {
        return this._primary.findSerializationInclusion(d7Var, this._secondary.findSerializationInclusion(d7Var, include));
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public JsonInclude.Include findSerializationInclusionForContent(d7 d7Var, JsonInclude.Include include) {
        return this._primary.findSerializationInclusionForContent(d7Var, this._secondary.findSerializationInclusionForContent(d7Var, include));
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public Class<?> findSerializationKeyType(d7 d7Var, JavaType javaType) {
        Class<?> clsFindSerializationKeyType = this._primary.findSerializationKeyType(d7Var, javaType);
        return clsFindSerializationKeyType == null ? this._secondary.findSerializationKeyType(d7Var, javaType) : clsFindSerializationKeyType;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public String[] findSerializationPropertyOrder(a aVar) {
        String[] strArrFindSerializationPropertyOrder = this._primary.findSerializationPropertyOrder(aVar);
        return strArrFindSerializationPropertyOrder == null ? this._secondary.findSerializationPropertyOrder(aVar) : strArrFindSerializationPropertyOrder;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Boolean findSerializationSortAlphabetically(d7 d7Var) {
        Boolean boolFindSerializationSortAlphabetically = this._primary.findSerializationSortAlphabetically(d7Var);
        return boolFindSerializationSortAlphabetically == null ? this._secondary.findSerializationSortAlphabetically(d7Var) : boolFindSerializationSortAlphabetically;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public Class<?> findSerializationType(d7 d7Var) {
        Class<?> clsFindSerializationType = this._primary.findSerializationType(d7Var);
        return clsFindSerializationType == null ? this._secondary.findSerializationType(d7Var) : clsFindSerializationType;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JsonSerialize.Typing findSerializationTyping(d7 d7Var) {
        JsonSerialize.Typing typingFindSerializationTyping = this._primary.findSerializationTyping(d7Var);
        return typingFindSerializationTyping == null ? this._secondary.findSerializationTyping(d7Var) : typingFindSerializationTyping;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findSerializer(d7 d7Var) {
        Object objFindSerializer = this._primary.findSerializer(d7Var);
        return _isExplicitClassOrOb(objFindSerializer, f71.a.class) ? objFindSerializer : _explicitClassOrOb(this._secondary.findSerializer(d7Var), f71.a.class);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JsonSetter.Value findSetterInfo(d7 d7Var) {
        JsonSetter.Value valueFindSetterInfo = this._secondary.findSetterInfo(d7Var);
        JsonSetter.Value valueFindSetterInfo2 = this._primary.findSetterInfo(d7Var);
        return valueFindSetterInfo == null ? valueFindSetterInfo2 : valueFindSetterInfo.withOverrides(valueFindSetterInfo2);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public List<NamedType> findSubtypes(d7 d7Var) {
        List<NamedType> listFindSubtypes = this._primary.findSubtypes(d7Var);
        List<NamedType> listFindSubtypes2 = this._secondary.findSubtypes(d7Var);
        if (listFindSubtypes == null || listFindSubtypes.isEmpty()) {
            return listFindSubtypes2;
        }
        if (listFindSubtypes2 == null || listFindSubtypes2.isEmpty()) {
            return listFindSubtypes;
        }
        ArrayList arrayList = new ArrayList(listFindSubtypes.size() + listFindSubtypes2.size());
        arrayList.addAll(listFindSubtypes);
        arrayList.addAll(listFindSubtypes2);
        return arrayList;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public String findTypeName(a aVar) {
        String strFindTypeName = this._primary.findTypeName(aVar);
        return (strFindTypeName == null || strFindTypeName.isEmpty()) ? this._secondary.findTypeName(aVar) : strFindTypeName;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public x63 findTypeResolver(MapperConfig<?> mapperConfig, a aVar, JavaType javaType) {
        x63 x63VarFindTypeResolver = this._primary.findTypeResolver(mapperConfig, aVar, javaType);
        return x63VarFindTypeResolver == null ? this._secondary.findTypeResolver(mapperConfig, aVar, javaType) : x63VarFindTypeResolver;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public NameTransformer findUnwrappingNameTransformer(AnnotatedMember annotatedMember) {
        NameTransformer nameTransformerFindUnwrappingNameTransformer = this._primary.findUnwrappingNameTransformer(annotatedMember);
        return nameTransformerFindUnwrappingNameTransformer == null ? this._secondary.findUnwrappingNameTransformer(annotatedMember) : nameTransformerFindUnwrappingNameTransformer;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Object findValueInstantiator(a aVar) {
        Object objFindValueInstantiator = this._primary.findValueInstantiator(aVar);
        return objFindValueInstantiator == null ? this._secondary.findValueInstantiator(aVar) : objFindValueInstantiator;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Class<?>[] findViews(d7 d7Var) {
        Class<?>[] clsArrFindViews = this._primary.findViews(d7Var);
        return clsArrFindViews == null ? this._secondary.findViews(d7Var) : clsArrFindViews;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public PropertyName findWrapperName(d7 d7Var) {
        PropertyName propertyNameFindWrapperName;
        PropertyName propertyNameFindWrapperName2 = this._primary.findWrapperName(d7Var);
        if (propertyNameFindWrapperName2 == null) {
            return this._secondary.findWrapperName(d7Var);
        }
        return (propertyNameFindWrapperName2 != PropertyName.USE_DEFAULT || (propertyNameFindWrapperName = this._secondary.findWrapperName(d7Var)) == null) ? propertyNameFindWrapperName2 : propertyNameFindWrapperName;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Boolean hasAnyGetter(d7 d7Var) {
        Boolean boolHasAnyGetter = this._primary.hasAnyGetter(d7Var);
        return boolHasAnyGetter == null ? this._secondary.hasAnyGetter(d7Var) : boolHasAnyGetter;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public boolean hasAnyGetterAnnotation(AnnotatedMethod annotatedMethod) {
        return this._primary.hasAnyGetterAnnotation(annotatedMethod) || this._secondary.hasAnyGetterAnnotation(annotatedMethod);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Boolean hasAnySetter(d7 d7Var) {
        Boolean boolHasAnySetter = this._primary.hasAnySetter(d7Var);
        return boolHasAnySetter == null ? this._secondary.hasAnySetter(d7Var) : boolHasAnySetter;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public boolean hasAnySetterAnnotation(AnnotatedMethod annotatedMethod) {
        return this._primary.hasAnySetterAnnotation(annotatedMethod) || this._secondary.hasAnySetterAnnotation(annotatedMethod);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Boolean hasAsKey(MapperConfig<?> mapperConfig, d7 d7Var) {
        Boolean boolHasAsKey = this._primary.hasAsKey(mapperConfig, d7Var);
        return boolHasAsKey == null ? this._secondary.hasAsKey(mapperConfig, d7Var) : boolHasAsKey;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Boolean hasAsValue(d7 d7Var) {
        Boolean boolHasAsValue = this._primary.hasAsValue(d7Var);
        return boolHasAsValue == null ? this._secondary.hasAsValue(d7Var) : boolHasAsValue;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public boolean hasAsValueAnnotation(AnnotatedMethod annotatedMethod) {
        return this._primary.hasAsValueAnnotation(annotatedMethod) || this._secondary.hasAsValueAnnotation(annotatedMethod);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    @Deprecated
    public boolean hasCreatorAnnotation(d7 d7Var) {
        return this._primary.hasCreatorAnnotation(d7Var) || this._secondary.hasCreatorAnnotation(d7Var);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public boolean hasIgnoreMarker(AnnotatedMember annotatedMember) {
        return this._primary.hasIgnoreMarker(annotatedMember) || this._secondary.hasIgnoreMarker(annotatedMember);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Boolean hasRequiredMarker(AnnotatedMember annotatedMember) {
        Boolean boolHasRequiredMarker = this._primary.hasRequiredMarker(annotatedMember);
        return boolHasRequiredMarker == null ? this._secondary.hasRequiredMarker(annotatedMember) : boolHasRequiredMarker;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public boolean isAnnotationBundle(Annotation annotation) {
        return this._primary.isAnnotationBundle(annotation) || this._secondary.isAnnotationBundle(annotation);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Boolean isIgnorableType(a aVar) {
        Boolean boolIsIgnorableType = this._primary.isIgnorableType(aVar);
        return boolIsIgnorableType == null ? this._secondary.isIgnorableType(aVar) : boolIsIgnorableType;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Boolean isTypeId(AnnotatedMember annotatedMember) {
        Boolean boolIsTypeId = this._primary.isTypeId(annotatedMember);
        return boolIsTypeId == null ? this._secondary.isTypeId(annotatedMember) : boolIsTypeId;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JavaType refineDeserializationType(MapperConfig<?> mapperConfig, d7 d7Var, JavaType javaType) throws JsonMappingException {
        return this._primary.refineDeserializationType(mapperConfig, d7Var, this._secondary.refineDeserializationType(mapperConfig, d7Var, javaType));
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public JavaType refineSerializationType(MapperConfig<?> mapperConfig, d7 d7Var, JavaType javaType) throws JsonMappingException {
        return this._primary.refineSerializationType(mapperConfig, d7Var, this._secondary.refineSerializationType(mapperConfig, d7Var, javaType));
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public AnnotatedMethod resolveSetterConflict(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, AnnotatedMethod annotatedMethod2) {
        AnnotatedMethod annotatedMethodResolveSetterConflict = this._primary.resolveSetterConflict(mapperConfig, annotatedMethod, annotatedMethod2);
        return annotatedMethodResolveSetterConflict == null ? this._secondary.resolveSetterConflict(mapperConfig, annotatedMethod, annotatedMethod2) : annotatedMethodResolveSetterConflict;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Version version() {
        return this._primary.version();
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public Collection<AnnotationIntrospector> allIntrospectors(Collection<AnnotationIntrospector> collection) {
        this._primary.allIntrospectors(collection);
        this._secondary.allIntrospectors(collection);
        return collection;
    }
}
