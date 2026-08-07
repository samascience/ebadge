package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators$PropertyGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.impl.FieldProperty;
import com.fasterxml.jackson.databind.deser.impl.MethodProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.deser.impl.SetterlessProperty;
import com.fasterxml.jackson.databind.deser.impl.UnsupportedTypeDeserializer;
import com.fasterxml.jackson.databind.deser.std.ThrowableDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.g;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import defpackage.a91;
import defpackage.ay;
import defpackage.bi0;
import defpackage.bp2;
import defpackage.bw2;
import defpackage.e43;
import defpackage.kh;
import defpackage.lh;
import defpackage.lt1;
import defpackage.m63;
import defpackage.mh;
import defpackage.ph;
import defpackage.q61;
import defpackage.r1;
import defpackage.s51;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class BeanDeserializerFactory extends BasicDeserializerFactory implements Serializable {
    private static final Class<?>[] INIT_CAUSE_PARAMS = {Throwable.class};
    public static final BeanDeserializerFactory instance = new BeanDeserializerFactory(new DeserializerFactoryConfig());
    private static final long serialVersionUID = 1;

    public BeanDeserializerFactory(DeserializerFactoryConfig deserializerFactoryConfig) {
        super(deserializerFactoryConfig);
    }

    private boolean _isSetterlessType(Class<?> cls) {
        return Collection.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls);
    }

    protected s51 _findUnsupportedTypeDeserializer(DeserializationContext deserializationContext, JavaType javaType, kh khVar) throws JsonMappingException {
        String strA = ph.a(javaType);
        if (strA == null || deserializationContext.getConfig().findMixInClassFor(javaType.getRawClass()) != null) {
            return null;
        }
        return new UnsupportedTypeDeserializer(javaType, strA);
    }

    protected void _validateSubType(DeserializationContext deserializationContext, JavaType javaType, kh khVar) throws JsonMappingException {
        bw2.a().b(deserializationContext, javaType, khVar);
    }

    protected void addBackReferenceProperties(DeserializationContext deserializationContext, kh khVar, lh lhVar) throws JsonMappingException {
        List<g> listC = khVar.c();
        if (listC != null) {
            for (g gVar : listC) {
                lhVar.e(gVar.e(), constructSettableProperty(deserializationContext, khVar, gVar, gVar.p()));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:73:0x016c  */
    protected void addBeanProps(DeserializationContext deserializationContext, kh khVar, lh lhVar) throws JsonMappingException {
        Set<String> setEmptySet;
        Set<String> set;
        SettableBeanProperty settableBeanPropertyConstructSetterlessProperty;
        CreatorProperty creatorProperty;
        SettableBeanProperty settableBeanProperty = null;
        SettableBeanProperty[] fromObjectArguments = !khVar.A().isAbstract() ? lhVar.v().getFromObjectArguments(deserializationContext.getConfig()) : null;
        boolean z = fromObjectArguments != null;
        JsonIgnoreProperties.Value defaultPropertyIgnorals = deserializationContext.getConfig().getDefaultPropertyIgnorals(khVar.r(), khVar.t());
        if (defaultPropertyIgnorals != null) {
            lhVar.y(defaultPropertyIgnorals.getIgnoreUnknown());
            setEmptySet = defaultPropertyIgnorals.findIgnoredForDeserialization();
            Iterator<String> it = setEmptySet.iterator();
            while (it.hasNext()) {
                lhVar.g(it.next());
            }
        } else {
            setEmptySet = Collections.emptySet();
        }
        Set<String> set2 = setEmptySet;
        JsonIncludeProperties.Value defaultPropertyInclusions = deserializationContext.getConfig().getDefaultPropertyInclusions(khVar.r(), khVar.t());
        if (defaultPropertyInclusions != null) {
            Set<String> included = defaultPropertyInclusions.getIncluded();
            if (included != null) {
                Iterator<String> it2 = included.iterator();
                while (it2.hasNext()) {
                    lhVar.h(it2.next());
                }
            }
            set = included;
        } else {
            set = null;
        }
        AnnotatedMember annotatedMemberB = khVar.b();
        if (annotatedMemberB != null) {
            lhVar.x(constructAnySetter(deserializationContext, khVar, annotatedMemberB));
        } else {
            Set setY = khVar.y();
            if (setY != null) {
                Iterator it3 = setY.iterator();
                while (it3.hasNext()) {
                    lhVar.g((String) it3.next());
                }
            }
        }
        boolean z2 = deserializationContext.isEnabled(MapperFeature.USE_GETTERS_AS_SETTERS) && deserializationContext.isEnabled(MapperFeature.AUTO_DETECT_GETTERS);
        List<g> listFilterBeanProps = filterBeanProps(deserializationContext, khVar, lhVar, khVar.o(), set2, set);
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<mh> it4 = this._factoryConfig.deserializerModifiers().iterator();
            if (it4.hasNext()) {
                e43.a(it4.next());
                deserializationContext.getConfig();
                throw null;
            }
        }
        for (g gVar : listFilterBeanProps) {
            if (gVar.v()) {
                settableBeanPropertyConstructSetterlessProperty = constructSettableProperty(deserializationContext, khVar, gVar, gVar.r().getParameterType(0));
            } else if (gVar.t()) {
                settableBeanPropertyConstructSetterlessProperty = constructSettableProperty(deserializationContext, khVar, gVar, gVar.k().getType());
            } else {
                AnnotatedMethod annotatedMethodL = gVar.l();
                if (annotatedMethodL == null) {
                    settableBeanPropertyConstructSetterlessProperty = settableBeanProperty;
                } else if (z2 && _isSetterlessType(annotatedMethodL.getRawType())) {
                    if (lhVar.w(gVar.getName())) {
                        settableBeanPropertyConstructSetterlessProperty = settableBeanProperty;
                    } else {
                        settableBeanPropertyConstructSetterlessProperty = constructSetterlessProperty(deserializationContext, khVar, gVar);
                    }
                } else if (gVar.s() || gVar.getMetadata().getMergeInfo() == null) {
                    settableBeanPropertyConstructSetterlessProperty = settableBeanProperty;
                } else {
                    settableBeanPropertyConstructSetterlessProperty = constructSetterlessProperty(deserializationContext, khVar, gVar);
                }
            }
            if (z && gVar.s()) {
                String name = gVar.getName();
                int length = fromObjectArguments.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        creatorProperty = null;
                        break;
                    }
                    SettableBeanProperty settableBeanProperty2 = fromObjectArguments[i];
                    if (name.equals(settableBeanProperty2.getName()) && (settableBeanProperty2 instanceof CreatorProperty)) {
                        creatorProperty = (CreatorProperty) settableBeanProperty2;
                        break;
                    }
                    i++;
                }
                if (creatorProperty == null) {
                    ArrayList arrayList = new ArrayList();
                    for (SettableBeanProperty settableBeanProperty3 : fromObjectArguments) {
                        arrayList.add(settableBeanProperty3.getName());
                    }
                    deserializationContext.reportBadPropertyDefinition(khVar, gVar, "Could not find creator property with name %s (known Creator properties: %s)", ay.V(name), arrayList);
                } else {
                    if (settableBeanPropertyConstructSetterlessProperty != null) {
                        creatorProperty.setFallbackSetter(settableBeanPropertyConstructSetterlessProperty);
                    }
                    Class<?>[] clsArrG = gVar.g();
                    if (clsArrG == null) {
                        clsArrG = khVar.e();
                    }
                    creatorProperty.setViews(clsArrG);
                    lhVar.f(creatorProperty);
                }
            } else if (settableBeanPropertyConstructSetterlessProperty != null) {
                Class<?>[] clsArrG2 = gVar.g();
                if (clsArrG2 == null) {
                    clsArrG2 = khVar.e();
                }
                settableBeanPropertyConstructSetterlessProperty.setViews(clsArrG2);
                lhVar.k(settableBeanPropertyConstructSetterlessProperty);
            }
            settableBeanProperty = null;
        }
    }

    protected void addInjectables(DeserializationContext deserializationContext, kh khVar, lh lhVar) throws JsonMappingException {
        Map mapH = khVar.h();
        if (mapH != null) {
            for (Map.Entry entry : mapH.entrySet()) {
                AnnotatedMember annotatedMember = (AnnotatedMember) entry.getValue();
                lhVar.i(PropertyName.construct(annotatedMember.getName()), annotatedMember.getType(), khVar.s(), annotatedMember, entry.getKey());
            }
        }
    }

    protected void addObjectIdReader(DeserializationContext deserializationContext, kh khVar, lh lhVar) throws JsonMappingException {
        SettableBeanProperty settableBeanPropertyP;
        ObjectIdGenerator<?> objectIdGeneratorObjectIdGeneratorInstance;
        JavaType javaType;
        lt1 lt1VarZ = khVar.z();
        if (lt1VarZ == null) {
            return;
        }
        Class clsC = lt1VarZ.c();
        deserializationContext.objectIdResolverInstance(khVar.t(), lt1VarZ);
        if (clsC == ObjectIdGenerators$PropertyGenerator.class) {
            PropertyName propertyNameD = lt1VarZ.d();
            settableBeanPropertyP = lhVar.p(propertyNameD);
            if (settableBeanPropertyP == null) {
                throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", ay.G(khVar.A()), ay.U(propertyNameD)));
            }
            JavaType type = settableBeanPropertyP.getType();
            javaType = type;
            objectIdGeneratorObjectIdGeneratorInstance = new PropertyBasedObjectIdGenerator(lt1VarZ.f());
        } else {
            JavaType javaType2 = deserializationContext.getTypeFactory().findTypeParameters(deserializationContext.constructType((Class<?>) clsC), ObjectIdGenerator.class)[0];
            settableBeanPropertyP = null;
            objectIdGeneratorObjectIdGeneratorInstance = deserializationContext.objectIdGeneratorInstance(khVar.t(), lt1VarZ);
            javaType = javaType2;
        }
        SettableBeanProperty settableBeanProperty = settableBeanPropertyP;
        lhVar.z(ObjectIdReader.construct(javaType, lt1VarZ.d(), objectIdGeneratorObjectIdGeneratorInstance, deserializationContext.findRootValueDeserializer(javaType), settableBeanProperty, null));
    }

    @Deprecated
    protected void addReferenceProperties(DeserializationContext deserializationContext, kh khVar, lh lhVar) throws JsonMappingException {
        addBackReferenceProperties(deserializationContext, khVar, lhVar);
    }

    public s51 buildBeanDeserializer(DeserializationContext deserializationContext, JavaType javaType, kh khVar) throws JsonMappingException {
        try {
            ValueInstantiator valueInstantiatorFindValueInstantiator = findValueInstantiator(deserializationContext, khVar);
            lh lhVarConstructBeanDeserializerBuilder = constructBeanDeserializerBuilder(deserializationContext, khVar);
            lhVarConstructBeanDeserializerBuilder.B(valueInstantiatorFindValueInstantiator);
            addBeanProps(deserializationContext, khVar, lhVarConstructBeanDeserializerBuilder);
            addObjectIdReader(deserializationContext, khVar, lhVarConstructBeanDeserializerBuilder);
            addBackReferenceProperties(deserializationContext, khVar, lhVarConstructBeanDeserializerBuilder);
            addInjectables(deserializationContext, khVar, lhVarConstructBeanDeserializerBuilder);
            deserializationContext.getConfig();
            if (this._factoryConfig.hasDeserializerModifiers()) {
                Iterator<mh> it = this._factoryConfig.deserializerModifiers().iterator();
                if (it.hasNext()) {
                    e43.a(it.next());
                    throw null;
                }
            }
            s51 s51VarL = (!javaType.isAbstract() || valueInstantiatorFindValueInstantiator.canInstantiate()) ? lhVarConstructBeanDeserializerBuilder.l() : lhVarConstructBeanDeserializerBuilder.m();
            if (this._factoryConfig.hasDeserializerModifiers()) {
                Iterator<mh> it2 = this._factoryConfig.deserializerModifiers().iterator();
                if (it2.hasNext()) {
                    e43.a(it2.next());
                    throw null;
                }
            }
            return s51VarL;
        } catch (IllegalArgumentException e) {
            throw InvalidDefinitionException.from(deserializationContext.getParser(), ay.o(e), khVar, (g) null).withCause(e);
        } catch (NoClassDefFoundError e2) {
            return new bi0(e2);
        }
    }

    protected s51 buildBuilderBasedDeserializer(DeserializationContext deserializationContext, JavaType javaType, kh khVar) throws JsonMappingException {
        try {
            ValueInstantiator valueInstantiatorFindValueInstantiator = findValueInstantiator(deserializationContext, khVar);
            DeserializationConfig config = deserializationContext.getConfig();
            lh lhVarConstructBeanDeserializerBuilder = constructBeanDeserializerBuilder(deserializationContext, khVar);
            lhVarConstructBeanDeserializerBuilder.B(valueInstantiatorFindValueInstantiator);
            addBeanProps(deserializationContext, khVar, lhVarConstructBeanDeserializerBuilder);
            addObjectIdReader(deserializationContext, khVar, lhVarConstructBeanDeserializerBuilder);
            addBackReferenceProperties(deserializationContext, khVar, lhVarConstructBeanDeserializerBuilder);
            addInjectables(deserializationContext, khVar, lhVarConstructBeanDeserializerBuilder);
            q61.a aVarN = khVar.n();
            String str = aVarN == null ? "build" : aVarN.a;
            AnnotatedMethod annotatedMethodL = khVar.l(str, null);
            if (annotatedMethodL != null && config.canOverrideAccessModifiers()) {
                ay.g(annotatedMethodL.getMember(), config.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            }
            lhVarConstructBeanDeserializerBuilder.A(annotatedMethodL, aVarN);
            if (this._factoryConfig.hasDeserializerModifiers()) {
                Iterator<mh> it = this._factoryConfig.deserializerModifiers().iterator();
                if (it.hasNext()) {
                    e43.a(it.next());
                    throw null;
                }
            }
            s51 s51VarN = lhVarConstructBeanDeserializerBuilder.n(javaType, str);
            if (this._factoryConfig.hasDeserializerModifiers()) {
                Iterator<mh> it2 = this._factoryConfig.deserializerModifiers().iterator();
                if (it2.hasNext()) {
                    e43.a(it2.next());
                    throw null;
                }
            }
            return s51VarN;
        } catch (IllegalArgumentException e) {
            throw InvalidDefinitionException.from(deserializationContext.getParser(), ay.o(e), khVar, (g) null);
        } catch (NoClassDefFoundError e2) {
            return new bi0(e2);
        }
    }

    public s51 buildThrowableDeserializer(DeserializationContext deserializationContext, JavaType javaType, kh khVar) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        lh lhVarConstructBeanDeserializerBuilder = constructBeanDeserializerBuilder(deserializationContext, khVar);
        lhVarConstructBeanDeserializerBuilder.B(findValueInstantiator(deserializationContext, khVar));
        addBeanProps(deserializationContext, khVar, lhVarConstructBeanDeserializerBuilder);
        Iterator itU = lhVarConstructBeanDeserializerBuilder.u();
        while (itU.hasNext()) {
            if ("setCause".equals(((SettableBeanProperty) itU.next()).getMember().getName())) {
                itU.remove();
                break;
            }
        }
        AnnotatedMethod annotatedMethodL = khVar.l("initCause", INIT_CAUSE_PARAMS);
        if (annotatedMethodL != null) {
            PropertyNamingStrategy propertyNamingStrategy = config.getPropertyNamingStrategy();
            SettableBeanProperty settableBeanPropertyConstructSettableProperty = constructSettableProperty(deserializationContext, khVar, bp2.z(deserializationContext.getConfig(), annotatedMethodL, new PropertyName(propertyNamingStrategy != null ? propertyNamingStrategy.nameForSetterMethod(config, annotatedMethodL, "cause") : "cause")), annotatedMethodL.getParameterType(0));
            if (settableBeanPropertyConstructSettableProperty != null) {
                lhVarConstructBeanDeserializerBuilder.j(settableBeanPropertyConstructSettableProperty, true);
            }
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<mh> it = this._factoryConfig.deserializerModifiers().iterator();
            if (it.hasNext()) {
                e43.a(it.next());
                throw null;
            }
        }
        s51 s51VarL = lhVarConstructBeanDeserializerBuilder.l();
        if (s51VarL instanceof BeanDeserializer) {
            s51VarL = ThrowableDeserializer.construct(deserializationContext, (BeanDeserializer) s51VarL);
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<mh> it2 = this._factoryConfig.deserializerModifiers().iterator();
            if (it2.hasNext()) {
                e43.a(it2.next());
                throw null;
            }
        }
        return s51VarL;
    }

    protected SettableAnyProperty constructAnySetter(DeserializationContext deserializationContext, kh khVar, AnnotatedMember annotatedMember) throws JsonMappingException {
        JavaType javaTypeMo16getKeyType;
        JavaType javaTypeResolveMemberAndTypeAnnotations;
        BeanProperty.Std std;
        boolean z = annotatedMember instanceof AnnotatedField;
        if (annotatedMember instanceof AnnotatedMethod) {
            AnnotatedMethod annotatedMethod = (AnnotatedMethod) annotatedMember;
            javaTypeMo16getKeyType = annotatedMethod.getParameterType(0);
            javaTypeResolveMemberAndTypeAnnotations = resolveMemberAndTypeAnnotations(deserializationContext, annotatedMember, annotatedMethod.getParameterType(1));
            std = new BeanProperty.Std(PropertyName.construct(annotatedMember.getName()), javaTypeResolveMemberAndTypeAnnotations, null, annotatedMember, PropertyMetadata.STD_OPTIONAL);
        } else {
            if (!z) {
                return (SettableAnyProperty) deserializationContext.reportBadDefinition(khVar.A(), String.format("Unrecognized mutator type for any-setter: %s", ay.X(annotatedMember.getClass())));
            }
            JavaType type = ((AnnotatedField) annotatedMember).getType();
            if (!type.isMapLikeType()) {
                if (!type.hasRawClass(JsonNode.class) && !type.hasRawClass(ObjectNode.class)) {
                    return (SettableAnyProperty) deserializationContext.reportBadDefinition(khVar.A(), String.format("Unsupported type for any-setter: %s -- only support `Map`s, `JsonNode` and `ObjectNode` ", ay.G(type)));
                }
                JavaType javaTypeResolveMemberAndTypeAnnotations2 = resolveMemberAndTypeAnnotations(deserializationContext, annotatedMember, type);
                JavaType javaTypeConstructType = deserializationContext.constructType(JsonNode.class);
                return SettableAnyProperty.constructForJsonNodeField(deserializationContext, new BeanProperty.Std(PropertyName.construct(annotatedMember.getName()), javaTypeResolveMemberAndTypeAnnotations2, null, annotatedMember, PropertyMetadata.STD_OPTIONAL), annotatedMember, javaTypeConstructType, deserializationContext.findRootValueDeserializer(javaTypeConstructType));
            }
            JavaType javaTypeResolveMemberAndTypeAnnotations3 = resolveMemberAndTypeAnnotations(deserializationContext, annotatedMember, type);
            javaTypeMo16getKeyType = javaTypeResolveMemberAndTypeAnnotations3.mo16getKeyType();
            JavaType javaTypeMo15getContentType = javaTypeResolveMemberAndTypeAnnotations3.mo15getContentType();
            BeanProperty.Std std2 = new BeanProperty.Std(PropertyName.construct(annotatedMember.getName()), javaTypeResolveMemberAndTypeAnnotations3, null, annotatedMember, PropertyMetadata.STD_OPTIONAL);
            javaTypeResolveMemberAndTypeAnnotations = javaTypeMo15getContentType;
            std = std2;
        }
        a91 a91VarFindKeyDeserializerFromAnnotation = findKeyDeserializerFromAnnotation(deserializationContext, annotatedMember);
        if (a91VarFindKeyDeserializerFromAnnotation == null) {
            a91VarFindKeyDeserializerFromAnnotation = (a91) javaTypeMo16getKeyType.getValueHandler();
        }
        if (a91VarFindKeyDeserializerFromAnnotation == null) {
            a91VarFindKeyDeserializerFromAnnotation = deserializationContext.findKeyDeserializer(javaTypeMo16getKeyType, std);
        }
        a91 a91Var = a91VarFindKeyDeserializerFromAnnotation;
        s51 s51VarFindContentDeserializerFromAnnotation = findContentDeserializerFromAnnotation(deserializationContext, annotatedMember);
        if (s51VarFindContentDeserializerFromAnnotation == null) {
            s51VarFindContentDeserializerFromAnnotation = (s51) javaTypeResolveMemberAndTypeAnnotations.getValueHandler();
        }
        if (s51VarFindContentDeserializerFromAnnotation != null) {
            s51VarFindContentDeserializerFromAnnotation = deserializationContext.handlePrimaryContextualization(s51VarFindContentDeserializerFromAnnotation, std, javaTypeResolveMemberAndTypeAnnotations);
        }
        s51 s51Var = s51VarFindContentDeserializerFromAnnotation;
        m63 m63Var = (m63) javaTypeResolveMemberAndTypeAnnotations.getTypeHandler();
        return z ? SettableAnyProperty.constructForMapField(deserializationContext, std, annotatedMember, javaTypeResolveMemberAndTypeAnnotations, a91Var, s51Var, m63Var) : SettableAnyProperty.constructForMethod(deserializationContext, std, annotatedMember, javaTypeResolveMemberAndTypeAnnotations, a91Var, s51Var, m63Var);
    }

    protected lh constructBeanDeserializerBuilder(DeserializationContext deserializationContext, kh khVar) {
        return new lh(khVar, deserializationContext);
    }

    protected SettableBeanProperty constructSettableProperty(DeserializationContext deserializationContext, kh khVar, g gVar, JavaType javaType) throws JsonMappingException {
        AnnotatedMember annotatedMemberN = gVar.n();
        if (annotatedMemberN == null) {
            deserializationContext.reportBadPropertyDefinition(khVar, gVar, "No non-constructor mutator available", new Object[0]);
        }
        JavaType javaTypeResolveMemberAndTypeAnnotations = resolveMemberAndTypeAnnotations(deserializationContext, annotatedMemberN, javaType);
        m63 m63Var = (m63) javaTypeResolveMemberAndTypeAnnotations.getTypeHandler();
        SettableBeanProperty methodProperty = annotatedMemberN instanceof AnnotatedMethod ? new MethodProperty(gVar, javaTypeResolveMemberAndTypeAnnotations, m63Var, khVar.s(), (AnnotatedMethod) annotatedMemberN) : new FieldProperty(gVar, javaTypeResolveMemberAndTypeAnnotations, m63Var, khVar.s(), (AnnotatedField) annotatedMemberN);
        s51 s51VarFindDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, annotatedMemberN);
        if (s51VarFindDeserializerFromAnnotation == null) {
            s51VarFindDeserializerFromAnnotation = (s51) javaTypeResolveMemberAndTypeAnnotations.getValueHandler();
        }
        if (s51VarFindDeserializerFromAnnotation != null) {
            methodProperty = methodProperty.withValueDeserializer(deserializationContext.handlePrimaryContextualization(s51VarFindDeserializerFromAnnotation, methodProperty, javaTypeResolveMemberAndTypeAnnotations));
        }
        AnnotationIntrospector.ReferenceProperty referencePropertyF = gVar.f();
        if (referencePropertyF != null && referencePropertyF.d()) {
            methodProperty.setManagedReferenceName(referencePropertyF.b());
        }
        lt1 lt1VarD = gVar.d();
        if (lt1VarD != null) {
            methodProperty.setObjectIdInfo(lt1VarD);
        }
        return methodProperty;
    }

    protected SettableBeanProperty constructSetterlessProperty(DeserializationContext deserializationContext, kh khVar, g gVar) throws JsonMappingException {
        AnnotatedMethod annotatedMethodL = gVar.l();
        JavaType javaTypeResolveMemberAndTypeAnnotations = resolveMemberAndTypeAnnotations(deserializationContext, annotatedMethodL, annotatedMethodL.getType());
        SetterlessProperty setterlessProperty = new SetterlessProperty(gVar, javaTypeResolveMemberAndTypeAnnotations, (m63) javaTypeResolveMemberAndTypeAnnotations.getTypeHandler(), khVar.s(), annotatedMethodL);
        s51 s51VarFindDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, annotatedMethodL);
        if (s51VarFindDeserializerFromAnnotation == null) {
            s51VarFindDeserializerFromAnnotation = (s51) javaTypeResolveMemberAndTypeAnnotations.getValueHandler();
        }
        return s51VarFindDeserializerFromAnnotation != null ? setterlessProperty.withValueDeserializer(deserializationContext.handlePrimaryContextualization(s51VarFindDeserializerFromAnnotation, setterlessProperty, javaTypeResolveMemberAndTypeAnnotations)) : setterlessProperty;
    }

    @Override // com.fasterxml.jackson.databind.deser.a
    public s51 createBeanDeserializer(DeserializationContext deserializationContext, JavaType javaType, kh khVar) throws JsonMappingException {
        JavaType javaTypeMaterializeAbstractType;
        DeserializationConfig config = deserializationContext.getConfig();
        s51 s51Var_findCustomBeanDeserializer = _findCustomBeanDeserializer(javaType, config, khVar);
        if (s51Var_findCustomBeanDeserializer != null) {
            if (this._factoryConfig.hasDeserializerModifiers()) {
                Iterator<mh> it = this._factoryConfig.deserializerModifiers().iterator();
                if (it.hasNext()) {
                    e43.a(it.next());
                    deserializationContext.getConfig();
                    throw null;
                }
            }
            return s51Var_findCustomBeanDeserializer;
        }
        if (javaType.isThrowable()) {
            return buildThrowableDeserializer(deserializationContext, javaType, khVar);
        }
        if (javaType.isAbstract() && !javaType.isPrimitive() && !javaType.isEnumType() && (javaTypeMaterializeAbstractType = materializeAbstractType(deserializationContext, javaType, khVar)) != null) {
            return buildBeanDeserializer(deserializationContext, javaTypeMaterializeAbstractType, config.introspect(javaTypeMaterializeAbstractType));
        }
        s51 s51VarFindStdDeserializer = findStdDeserializer(deserializationContext, javaType, khVar);
        if (s51VarFindStdDeserializer != null) {
            return s51VarFindStdDeserializer;
        }
        if (!isPotentialBeanType(javaType.getRawClass())) {
            return null;
        }
        _validateSubType(deserializationContext, javaType, khVar);
        s51 s51Var_findUnsupportedTypeDeserializer = _findUnsupportedTypeDeserializer(deserializationContext, javaType, khVar);
        return s51Var_findUnsupportedTypeDeserializer != null ? s51Var_findUnsupportedTypeDeserializer : buildBeanDeserializer(deserializationContext, javaType, khVar);
    }

    @Override // com.fasterxml.jackson.databind.deser.a
    public s51 createBuilderBasedDeserializer(DeserializationContext deserializationContext, JavaType javaType, kh khVar, Class<?> cls) throws JsonMappingException {
        return buildBuilderBasedDeserializer(deserializationContext, javaType, deserializationContext.getConfig().introspectForBuilder(deserializationContext.isEnabled(MapperFeature.INFER_BUILDER_TYPE_BINDINGS) ? deserializationContext.getTypeFactory().constructParametricType(cls, javaType.getBindings()) : deserializationContext.constructType(cls), khVar));
    }

    @Deprecated
    protected List<g> filterBeanProps(DeserializationContext deserializationContext, kh khVar, lh lhVar, List<g> list, Set<String> set) throws JsonMappingException {
        return filterBeanProps(deserializationContext, khVar, lhVar, list, set, null);
    }

    protected s51 findStdDeserializer(DeserializationContext deserializationContext, JavaType javaType, kh khVar) throws JsonMappingException {
        s51 s51VarFindDefaultDeserializer = findDefaultDeserializer(deserializationContext, javaType, khVar);
        if (s51VarFindDefaultDeserializer != null && this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<mh> it = this._factoryConfig.deserializerModifiers().iterator();
            if (it.hasNext()) {
                e43.a(it.next());
                deserializationContext.getConfig();
                throw null;
            }
        }
        return s51VarFindDefaultDeserializer;
    }

    protected boolean isIgnorableType(DeserializationConfig deserializationConfig, g gVar, Class<?> cls, Map<Class<?>, Boolean> map) {
        Boolean isIgnoredType;
        Boolean bool = map.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        if (cls == String.class || cls.isPrimitive()) {
            isIgnoredType = Boolean.FALSE;
        } else {
            isIgnoredType = deserializationConfig.getConfigOverride(cls).getIsIgnoredType();
            if (isIgnoredType == null) {
                isIgnoredType = deserializationConfig.getAnnotationIntrospector().isIgnorableType(deserializationConfig.introspectClassAnnotations(cls).t());
                if (isIgnoredType == null) {
                    isIgnoredType = Boolean.FALSE;
                }
            }
        }
        map.put(cls, isIgnoredType);
        return isIgnoredType.booleanValue();
    }

    protected boolean isPotentialBeanType(Class<?> cls) {
        String strF = ay.f(cls);
        if (strF != null) {
            throw new IllegalArgumentException("Cannot deserialize Class " + cls.getName() + " (of type " + strF + ") as a Bean");
        }
        if (ay.S(cls)) {
            throw new IllegalArgumentException("Cannot deserialize Proxy class " + cls.getName() + " as a Bean");
        }
        String strP = ay.P(cls, true);
        if (strP == null) {
            return true;
        }
        throw new IllegalArgumentException("Cannot deserialize Class " + cls.getName() + " (of type " + strP + ") as a Bean");
    }

    protected JavaType materializeAbstractType(DeserializationContext deserializationContext, JavaType javaType, kh khVar) throws JsonMappingException {
        Iterator<r1> it = this._factoryConfig.abstractTypeResolvers().iterator();
        while (it.hasNext()) {
            JavaType javaTypeResolveAbstractType = it.next().resolveAbstractType(deserializationContext.getConfig(), khVar);
            if (javaTypeResolveAbstractType != null) {
                return javaTypeResolveAbstractType;
            }
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.BasicDeserializerFactory
    public a withConfig(DeserializerFactoryConfig deserializerFactoryConfig) {
        if (this._factoryConfig == deserializerFactoryConfig) {
            return this;
        }
        ay.n0(BeanDeserializerFactory.class, this, "withConfig");
        return new BeanDeserializerFactory(deserializerFactoryConfig);
    }

    protected List<g> filterBeanProps(DeserializationContext deserializationContext, kh khVar, lh lhVar, List<g> list, Set<String> set, Set<String> set2) {
        Class clsQ;
        ArrayList arrayList = new ArrayList(Math.max(4, list.size()));
        HashMap map = new HashMap();
        for (g gVar : list) {
            String name = gVar.getName();
            if (!IgnorePropertiesUtil.c(name, set, set2)) {
                if (gVar.s() || (clsQ = gVar.q()) == null || !isIgnorableType(deserializationContext.getConfig(), gVar, clsQ, map)) {
                    arrayList.add(gVar);
                } else {
                    lhVar.g(name);
                }
            }
        }
        return arrayList;
    }
}
