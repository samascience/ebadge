package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators$PropertyGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TokenStreamFactory;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.g;
import com.fasterxml.jackson.databind.ser.impl.FilteredBeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.ser.impl.UnsupportedTypeSerializer;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import com.fasterxml.jackson.databind.ser.std.ToEmptyObjectSerializer;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import defpackage.an2;
import defpackage.ay;
import defpackage.bn2;
import defpackage.cg2;
import defpackage.e43;
import defpackage.f40;
import defpackage.f71;
import defpackage.jn1;
import defpackage.kh;
import defpackage.lt1;
import defpackage.m7;
import defpackage.mt1;
import defpackage.oh;
import defpackage.ph;
import defpackage.t60;
import defpackage.x63;
import defpackage.z63;
import defpackage.zm2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class BeanSerializerFactory extends BasicSerializerFactory implements Serializable {
    public static final BeanSerializerFactory instance = new BeanSerializerFactory(null);
    private static final long serialVersionUID = 1;

    protected BeanSerializerFactory(SerializerFactoryConfig serializerFactoryConfig) {
        super(serializerFactoryConfig);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected BeanPropertyWriter _constructWriter(an2 an2Var, g gVar, b bVar, boolean z, AnnotatedMember annotatedMember) throws JsonMappingException {
        PropertyName fullName = gVar.getFullName();
        JavaType type = annotatedMember.getType();
        BeanProperty std = new BeanProperty.Std(fullName, type, gVar.getWrapperName(), annotatedMember, gVar.getMetadata());
        f71 f71VarFindSerializerFromAnnotation = findSerializerFromAnnotation(an2Var, annotatedMember);
        if (f71VarFindSerializerFromAnnotation instanceof cg2) {
            ((cg2) f71VarFindSerializerFromAnnotation).resolve(an2Var);
        }
        return bVar.c(an2Var, gVar, type, an2Var.handlePrimaryContextualization(f71VarFindSerializerFromAnnotation, std), findPropertyTypeSerializer(type, an2Var.getConfig(), annotatedMember), (type.isContainerType() || type.isReferenceType()) ? findPropertyContentTypeSerializer(type, an2Var.getConfig(), annotatedMember) : null, annotatedMember, z);
    }

    protected f71 _createSerializer2(an2 an2Var, JavaType javaType, kh khVar, boolean z) throws JsonMappingException {
        f71 f71VarFindSerializerByAnnotations;
        SerializationConfig config = an2Var.getConfig();
        if (javaType.isContainerType()) {
            if (!z) {
                z = usesStaticTyping(config, khVar, null);
            }
            f71VarFindSerializerByAnnotations = buildContainerSerializer(an2Var, javaType, khVar, z);
            if (f71VarFindSerializerByAnnotations != null) {
                return f71VarFindSerializerByAnnotations;
            }
        } else {
            if (javaType.isReferenceType()) {
                f71VarFindSerializerByAnnotations = findReferenceSerializer(an2Var, (ReferenceType) javaType, khVar, z);
            } else {
                Iterator<bn2> it = customSerializers().iterator();
                f71 f71VarFindSerializer = null;
                while (it.hasNext() && (f71VarFindSerializer = it.next().findSerializer(config, javaType, khVar)) == null) {
                }
                f71VarFindSerializerByAnnotations = f71VarFindSerializer;
            }
            if (f71VarFindSerializerByAnnotations == null) {
                f71VarFindSerializerByAnnotations = findSerializerByAnnotations(an2Var, javaType, khVar);
            }
        }
        if (f71VarFindSerializerByAnnotations == null && (f71VarFindSerializerByAnnotations = findSerializerByLookup(javaType, config, khVar, z)) == null && (f71VarFindSerializerByAnnotations = findSerializerByPrimaryType(an2Var, javaType, khVar, z)) == null && (f71VarFindSerializerByAnnotations = findBeanOrAddOnSerializer(an2Var, javaType, khVar, z)) == null) {
            f71VarFindSerializerByAnnotations = an2Var.getUnknownTypeSerializer(khVar.r());
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

    protected f71 _findUnsupportedTypeSerializer(an2 an2Var, JavaType javaType, kh khVar) throws JsonMappingException {
        String strA = ph.a(javaType);
        if (strA == null || an2Var.getConfig().findMixInClassFor(javaType.getRawClass()) != null) {
            return null;
        }
        return new UnsupportedTypeSerializer(javaType, strA);
    }

    protected boolean _isUnserializableJacksonType(an2 an2Var, JavaType javaType) {
        Class<?> rawClass = javaType.getRawClass();
        return ObjectMapper.class.isAssignableFrom(rawClass) || ObjectReader.class.isAssignableFrom(rawClass) || ObjectWriter.class.isAssignableFrom(rawClass) || t60.class.isAssignableFrom(rawClass) || TokenStreamFactory.class.isAssignableFrom(rawClass) || JsonParser.class.isAssignableFrom(rawClass) || JsonGenerator.class.isAssignableFrom(rawClass);
    }

    protected f71 constructBeanOrAddOnSerializer(an2 an2Var, JavaType javaType, kh khVar, boolean z) throws JsonMappingException {
        if (khVar.r() == Object.class) {
            return an2Var.getUnknownTypeSerializer(Object.class);
        }
        f71 f71Var_findUnsupportedTypeSerializer = _findUnsupportedTypeSerializer(an2Var, javaType, khVar);
        if (f71Var_findUnsupportedTypeSerializer != null) {
            return f71Var_findUnsupportedTypeSerializer;
        }
        if (_isUnserializableJacksonType(an2Var, javaType)) {
            return new ToEmptyObjectSerializer(javaType);
        }
        SerializationConfig config = an2Var.getConfig();
        a aVarConstructBeanSerializerBuilder = constructBeanSerializerBuilder(khVar);
        aVarConstructBeanSerializerBuilder.j(config);
        List<BeanPropertyWriter> listFindBeanProperties = findBeanProperties(an2Var, khVar, aVarConstructBeanSerializerBuilder);
        List<BeanPropertyWriter> arrayList = listFindBeanProperties == null ? new ArrayList<>() : removeOverlappingTypeIds(an2Var, khVar, aVarConstructBeanSerializerBuilder, listFindBeanProperties);
        an2Var.getAnnotationIntrospector().findAndAddVirtualProperties(config, khVar.t(), arrayList);
        if (this._factoryConfig.hasSerializerModifiers()) {
            Iterator<oh> it = this._factoryConfig.serializerModifiers().iterator();
            if (it.hasNext()) {
                e43.a(it.next());
                throw null;
            }
        }
        List<BeanPropertyWriter> listFilterBeanProperties = filterBeanProperties(config, khVar, filterUnwantedJDKProperties(config, khVar, arrayList));
        if (this._factoryConfig.hasSerializerModifiers()) {
            Iterator<oh> it2 = this._factoryConfig.serializerModifiers().iterator();
            if (it2.hasNext()) {
                e43.a(it2.next());
                throw null;
            }
        }
        aVarConstructBeanSerializerBuilder.m(constructObjectIdHandler(an2Var, khVar, listFilterBeanProperties));
        aVarConstructBeanSerializerBuilder.n(listFilterBeanProperties);
        aVarConstructBeanSerializerBuilder.k(findFilterId(config, khVar));
        AnnotatedMember annotatedMemberA = khVar.a();
        if (annotatedMemberA != null) {
            JavaType type = annotatedMemberA.getType();
            JavaType javaTypeMo15getContentType = type.mo15getContentType();
            z63 z63VarCreateTypeSerializer = createTypeSerializer(config, javaTypeMo15getContentType);
            f71 f71VarFindSerializerFromAnnotation = findSerializerFromAnnotation(an2Var, annotatedMemberA);
            if (f71VarFindSerializerFromAnnotation == null) {
                f71VarFindSerializerFromAnnotation = MapSerializer.construct((Set<String>) null, type, config.isEnabled(MapperFeature.USE_STATIC_TYPING), z63VarCreateTypeSerializer, (f71) null, (f71) null, (Object) null);
            }
            aVarConstructBeanSerializerBuilder.i(new m7(new BeanProperty.Std(PropertyName.construct(annotatedMemberA.getName()), javaTypeMo15getContentType, null, annotatedMemberA, PropertyMetadata.STD_OPTIONAL), annotatedMemberA, f71VarFindSerializerFromAnnotation));
        }
        processViews(config, aVarConstructBeanSerializerBuilder);
        if (this._factoryConfig.hasSerializerModifiers()) {
            Iterator<oh> it3 = this._factoryConfig.serializerModifiers().iterator();
            if (it3.hasNext()) {
                e43.a(it3.next());
                throw null;
            }
        }
        try {
            f71 f71VarA = aVarConstructBeanSerializerBuilder.a();
            if (f71VarA == null) {
                if (javaType.isRecordType() && !jn1.c(javaType.getRawClass())) {
                    return aVarConstructBeanSerializerBuilder.b();
                }
                f71VarA = findSerializerByAddonType(config, javaType, khVar, z);
                if (f71VarA == null && khVar.B()) {
                    return aVarConstructBeanSerializerBuilder.b();
                }
            }
            return f71VarA;
        } catch (RuntimeException e) {
            return (f71) an2Var.reportBadTypeDefinition(khVar, "Failed to construct BeanSerializer for %s: (%s) %s", khVar.A(), e.getClass().getName(), e.getMessage());
        }
    }

    @Deprecated
    protected f71 constructBeanSerializer(an2 an2Var, kh khVar) throws JsonMappingException {
        return constructBeanOrAddOnSerializer(an2Var, khVar.A(), khVar, an2Var.isEnabled(MapperFeature.USE_STATIC_TYPING));
    }

    protected a constructBeanSerializerBuilder(kh khVar) {
        return new a(khVar);
    }

    protected BeanPropertyWriter constructFilteredBeanWriter(BeanPropertyWriter beanPropertyWriter, Class<?>[] clsArr) {
        return FilteredBeanPropertyWriter.a(beanPropertyWriter, clsArr);
    }

    protected mt1 constructObjectIdHandler(an2 an2Var, kh khVar, List<BeanPropertyWriter> list) throws JsonMappingException {
        lt1 lt1VarZ = khVar.z();
        if (lt1VarZ == null) {
            return null;
        }
        Class clsC = lt1VarZ.c();
        if (clsC != ObjectIdGenerators$PropertyGenerator.class) {
            return mt1.a(an2Var.getTypeFactory().findTypeParameters(an2Var.constructType(clsC), ObjectIdGenerator.class)[0], lt1VarZ.d(), an2Var.objectIdGeneratorInstance(khVar.t(), lt1VarZ), lt1VarZ.b());
        }
        String simpleName = lt1VarZ.d().getSimpleName();
        int size = list.size();
        for (int i = 0; i != size; i++) {
            BeanPropertyWriter beanPropertyWriter = list.get(i);
            if (simpleName.equals(beanPropertyWriter.getName())) {
                if (i > 0) {
                    list.remove(i);
                    list.add(0, beanPropertyWriter);
                }
                return mt1.a(beanPropertyWriter.getType(), null, new PropertyBasedObjectIdGenerator(lt1VarZ, beanPropertyWriter), lt1VarZ.b());
            }
        }
        throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", ay.G(khVar.A()), ay.V(simpleName)));
    }

    protected b constructPropertyBuilder(SerializationConfig serializationConfig, kh khVar) {
        return new b(serializationConfig, khVar);
    }

    @Override // com.fasterxml.jackson.databind.ser.BasicSerializerFactory, defpackage.zm2
    public f71 createSerializer(an2 an2Var, JavaType javaType) throws JsonMappingException {
        JavaType javaTypeRefineSerializationType;
        SerializationConfig config = an2Var.getConfig();
        kh khVarIntrospect = config.introspect(javaType);
        f71 f71VarFindSerializerFromAnnotation = findSerializerFromAnnotation(an2Var, khVarIntrospect.t());
        if (f71VarFindSerializerFromAnnotation != null) {
            return f71VarFindSerializerFromAnnotation;
        }
        AnnotationIntrospector annotationIntrospector = config.getAnnotationIntrospector();
        boolean z = false;
        if (annotationIntrospector == null) {
            javaTypeRefineSerializationType = javaType;
        } else {
            try {
                javaTypeRefineSerializationType = annotationIntrospector.refineSerializationType(config, khVarIntrospect.t(), javaType);
            } catch (JsonMappingException e) {
                return (f71) an2Var.reportBadTypeDefinition(khVarIntrospect, e.getMessage(), new Object[0]);
            }
        }
        if (javaTypeRefineSerializationType != javaType) {
            if (!javaTypeRefineSerializationType.hasRawClass(javaType.getRawClass())) {
                khVarIntrospect = config.introspect(javaTypeRefineSerializationType);
            }
            z = true;
        }
        f40 f40VarQ = khVarIntrospect.q();
        if (f40VarQ == null) {
            return _createSerializer2(an2Var, javaTypeRefineSerializationType, khVarIntrospect, z);
        }
        JavaType javaTypeB = f40VarQ.b(an2Var.getTypeFactory());
        if (!javaTypeB.hasRawClass(javaTypeRefineSerializationType.getRawClass())) {
            khVarIntrospect = config.introspect(javaTypeB);
            f71VarFindSerializerFromAnnotation = findSerializerFromAnnotation(an2Var, khVarIntrospect.t());
        }
        if (f71VarFindSerializerFromAnnotation == null && !javaTypeB.isJavaLangObject()) {
            f71VarFindSerializerFromAnnotation = _createSerializer2(an2Var, javaTypeB, khVarIntrospect, true);
        }
        return new StdDelegatingSerializer(f40VarQ, javaTypeB, f71VarFindSerializerFromAnnotation);
    }

    @Override // com.fasterxml.jackson.databind.ser.BasicSerializerFactory
    protected Iterable<bn2> customSerializers() {
        return this._factoryConfig.serializers();
    }

    protected List<BeanPropertyWriter> filterBeanProperties(SerializationConfig serializationConfig, kh khVar, List<BeanPropertyWriter> list) {
        JsonIgnoreProperties.Value defaultPropertyIgnorals = serializationConfig.getDefaultPropertyIgnorals(khVar.r(), khVar.t());
        Set<String> setFindIgnoredForSerialization = defaultPropertyIgnorals != null ? defaultPropertyIgnorals.findIgnoredForSerialization() : null;
        JsonIncludeProperties.Value defaultPropertyInclusions = serializationConfig.getDefaultPropertyInclusions(khVar.r(), khVar.t());
        Set<String> included = defaultPropertyInclusions != null ? defaultPropertyInclusions.getIncluded() : null;
        if (included != null || (setFindIgnoredForSerialization != null && !setFindIgnoredForSerialization.isEmpty())) {
            Iterator<BeanPropertyWriter> it = list.iterator();
            while (it.hasNext()) {
                if (IgnorePropertiesUtil.c(it.next().getName(), setFindIgnoredForSerialization, included)) {
                    it.remove();
                }
            }
        }
        return list;
    }

    protected List<BeanPropertyWriter> filterUnwantedJDKProperties(SerializationConfig serializationConfig, kh khVar, List<BeanPropertyWriter> list) {
        if (khVar.A().isTypeOrSubTypeOf(CharSequence.class) && list.size() == 1) {
            AnnotatedMember member = list.get(0).getMember();
            if ((member instanceof AnnotatedMethod) && "isEmpty".equals(member.getName()) && member.getDeclaringClass() == CharSequence.class) {
                list.remove(0);
            }
        }
        return list;
    }

    public f71 findBeanOrAddOnSerializer(an2 an2Var, JavaType javaType, kh khVar, boolean z) throws JsonMappingException {
        if (isPotentialBeanType(javaType.getRawClass()) || ay.L(javaType.getRawClass())) {
            return constructBeanOrAddOnSerializer(an2Var, javaType, khVar, z);
        }
        return null;
    }

    protected List<BeanPropertyWriter> findBeanProperties(an2 an2Var, kh khVar, a aVar) throws JsonMappingException {
        List listO = khVar.o();
        SerializationConfig config = an2Var.getConfig();
        removeIgnorableTypes(config, khVar, listO);
        if (config.isEnabled(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS)) {
            removeSetterlessGetters(config, khVar, listO);
        }
        if (listO.isEmpty()) {
            return null;
        }
        boolean zUsesStaticTyping = usesStaticTyping(config, khVar, null);
        b bVarConstructPropertyBuilder = constructPropertyBuilder(config, khVar);
        ArrayList arrayList = new ArrayList(listO.size());
        for (g gVar : listO) {
            AnnotatedMember annotatedMemberH = gVar.h();
            if (!gVar.y()) {
                AnnotationIntrospector.ReferenceProperty referencePropertyF = gVar.f();
                if (referencePropertyF == null || !referencePropertyF.c()) {
                    if (annotatedMemberH instanceof AnnotatedMethod) {
                        arrayList.add(_constructWriter(an2Var, gVar, bVarConstructPropertyBuilder, zUsesStaticTyping, (AnnotatedMethod) annotatedMemberH));
                    } else {
                        arrayList.add(_constructWriter(an2Var, gVar, bVarConstructPropertyBuilder, zUsesStaticTyping, (AnnotatedField) annotatedMemberH));
                    }
                }
            } else if (annotatedMemberH != null) {
                aVar.o(annotatedMemberH);
            }
        }
        return arrayList;
    }

    @Deprecated
    public f71 findBeanSerializer(an2 an2Var, JavaType javaType, kh khVar) throws JsonMappingException {
        return findBeanOrAddOnSerializer(an2Var, javaType, khVar, an2Var.isEnabled(MapperFeature.USE_STATIC_TYPING));
    }

    public z63 findPropertyContentTypeSerializer(JavaType javaType, SerializationConfig serializationConfig, AnnotatedMember annotatedMember) throws JsonMappingException {
        JavaType javaTypeMo15getContentType = javaType.mo15getContentType();
        x63 x63VarFindPropertyContentTypeResolver = serializationConfig.getAnnotationIntrospector().findPropertyContentTypeResolver(serializationConfig, annotatedMember, javaType);
        return x63VarFindPropertyContentTypeResolver == null ? createTypeSerializer(serializationConfig, javaTypeMo15getContentType) : x63VarFindPropertyContentTypeResolver.buildTypeSerializer(serializationConfig, javaTypeMo15getContentType, serializationConfig.getSubtypeResolver().collectAndResolveSubtypesByClass(serializationConfig, annotatedMember, javaTypeMo15getContentType));
    }

    public z63 findPropertyTypeSerializer(JavaType javaType, SerializationConfig serializationConfig, AnnotatedMember annotatedMember) throws JsonMappingException {
        x63 x63VarFindPropertyTypeResolver = serializationConfig.getAnnotationIntrospector().findPropertyTypeResolver(serializationConfig, annotatedMember, javaType);
        return x63VarFindPropertyTypeResolver == null ? createTypeSerializer(serializationConfig, javaType) : x63VarFindPropertyTypeResolver.buildTypeSerializer(serializationConfig, javaType, serializationConfig.getSubtypeResolver().collectAndResolveSubtypesByClass(serializationConfig, annotatedMember, javaType));
    }

    protected boolean isPotentialBeanType(Class<?> cls) {
        return ay.f(cls) == null && !ay.S(cls);
    }

    protected void processViews(SerializationConfig serializationConfig, a aVar) {
        List listG = aVar.g();
        boolean zIsEnabled = serializationConfig.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION);
        int size = listG.size();
        BeanPropertyWriter[] beanPropertyWriterArr = new BeanPropertyWriter[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            BeanPropertyWriter beanPropertyWriter = (BeanPropertyWriter) listG.get(i2);
            Class<?>[] views = beanPropertyWriter.getViews();
            if (views != null && views.length != 0) {
                i++;
                beanPropertyWriterArr[i2] = constructFilteredBeanWriter(beanPropertyWriter, views);
            } else if (zIsEnabled) {
                beanPropertyWriterArr[i2] = beanPropertyWriter;
            }
        }
        if (zIsEnabled && i == 0) {
            return;
        }
        aVar.l(beanPropertyWriterArr);
    }

    protected void removeIgnorableTypes(SerializationConfig serializationConfig, kh khVar, List<g> list) {
        AnnotationIntrospector annotationIntrospector = serializationConfig.getAnnotationIntrospector();
        HashMap map = new HashMap();
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (next.h() == null) {
                it.remove();
            } else {
                Class clsQ = next.q();
                Boolean isIgnoredType = (Boolean) map.get(clsQ);
                if (isIgnoredType == null) {
                    isIgnoredType = serializationConfig.getConfigOverride(clsQ).getIsIgnoredType();
                    if (isIgnoredType == null && (isIgnoredType = annotationIntrospector.isIgnorableType(serializationConfig.introspectClassAnnotations((Class<?>) clsQ).t())) == null) {
                        isIgnoredType = Boolean.FALSE;
                    }
                    map.put(clsQ, isIgnoredType);
                }
                if (isIgnoredType.booleanValue()) {
                    it.remove();
                }
            }
        }
    }

    protected List<BeanPropertyWriter> removeOverlappingTypeIds(an2 an2Var, kh khVar, a aVar, List<BeanPropertyWriter> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            BeanPropertyWriter beanPropertyWriter = list.get(i);
            z63 typeSerializer = beanPropertyWriter.getTypeSerializer();
            if (typeSerializer != null && typeSerializer.c() == JsonTypeInfo.As.EXTERNAL_PROPERTY) {
                PropertyName propertyNameConstruct = PropertyName.construct(typeSerializer.b());
                for (BeanPropertyWriter beanPropertyWriter2 : list) {
                    if (beanPropertyWriter2 != beanPropertyWriter && beanPropertyWriter2.wouldConflictWithName(propertyNameConstruct)) {
                        beanPropertyWriter.assignTypeSerializer(null);
                        break;
                    }
                }
            }
        }
        return list;
    }

    protected void removeSetterlessGetters(SerializationConfig serializationConfig, kh khVar, List<g> list) {
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (!next.a() && !next.w()) {
                it.remove();
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.BasicSerializerFactory
    public zm2 withConfig(SerializerFactoryConfig serializerFactoryConfig) {
        if (this._factoryConfig == serializerFactoryConfig) {
            return this;
        }
        if (getClass() == BeanSerializerFactory.class) {
            return new BeanSerializerFactory(serializerFactoryConfig);
        }
        throw new IllegalStateException("Subtype of BeanSerializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalSerializers': cannot instantiate subtype with additional serializer definitions");
    }
}
