package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators$PropertyGenerator;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.InnerClassProperty;
import com.fasterxml.jackson.databind.deser.impl.ManagedReferenceProperty;
import com.fasterxml.jackson.databind.deser.impl.MergingSettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReferenceProperty;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdValueProperty;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.deser.impl.SetterlessProperty;
import com.fasterxml.jackson.databind.deser.impl.TypeWrappedDeserializer;
import com.fasterxml.jackson.databind.deser.impl.ValueInjector;
import com.fasterxml.jackson.databind.deser.impl.c;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.exc.IgnoredPropertyException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import com.fasterxml.jackson.databind.util.NameTransformer;
import defpackage.ag2;
import defpackage.ay;
import defpackage.f40;
import defpackage.gs1;
import defpackage.jn1;
import defpackage.kh;
import defpackage.lh;
import defpackage.lt1;
import defpackage.m63;
import defpackage.q33;
import defpackage.rj0;
import defpackage.s51;
import defpackage.v30;
import defpackage.x83;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class BeanDeserializerBase extends StdDeserializer<Object> implements v30, ag2, Serializable {
    protected static final PropertyName TEMP_PROPERTY_NAME = new PropertyName("#temporary-name");
    private static final long serialVersionUID = 1;
    protected SettableAnyProperty _anySetter;
    protected s51 _arrayDelegateDeserializer;
    protected final Map<String, SettableBeanProperty> _backRefs;
    protected final BeanPropertyMap _beanProperties;
    protected final JavaType _beanType;
    protected s51 _delegateDeserializer;
    protected rj0 _externalTypeIdHandler;
    protected final Set<String> _ignorableProps;
    protected final boolean _ignoreAllUnknown;
    protected final Set<String> _includableProps;
    protected final ValueInjector[] _injectables;
    protected final boolean _needViewProcesing;
    protected boolean _nonStandardCreation;
    protected final ObjectIdReader _objectIdReader;
    protected PropertyBasedCreator _propertyBasedCreator;
    protected final JsonFormat.Shape _serializationShape;
    protected transient HashMap<ClassKey, s51> _subDeserializers;
    protected x83 _unwrappedPropertyHandler;
    protected final ValueInstantiator _valueInstantiator;
    protected boolean _vanillaProcessing;

    protected BeanDeserializerBase(lh lhVar, kh khVar, BeanPropertyMap beanPropertyMap, Map<String, SettableBeanProperty> map, Set<String> set, boolean z, Set<String> set2, boolean z2) {
        super(khVar.A());
        this._beanType = khVar.A();
        ValueInstantiator valueInstantiatorV = lhVar.v();
        this._valueInstantiator = valueInstantiatorV;
        this._delegateDeserializer = null;
        this._arrayDelegateDeserializer = null;
        this._propertyBasedCreator = null;
        this._beanProperties = beanPropertyMap;
        this._backRefs = map;
        this._ignorableProps = set;
        this._ignoreAllUnknown = z;
        this._includableProps = set2;
        this._anySetter = lhVar.q();
        List listS = lhVar.s();
        ValueInjector[] valueInjectorArr = (listS == null || listS.isEmpty()) ? null : (ValueInjector[]) listS.toArray(new ValueInjector[listS.size()]);
        this._injectables = valueInjectorArr;
        ObjectIdReader objectIdReaderT = lhVar.t();
        this._objectIdReader = objectIdReaderT;
        this._nonStandardCreation = this._unwrappedPropertyHandler != null || valueInstantiatorV.canCreateUsingDelegate() || valueInstantiatorV.canCreateFromObjectWith() || !valueInstantiatorV.canCreateUsingDefault();
        this._serializationShape = khVar.g(null).getShape();
        this._needViewProcesing = z2;
        this._vanillaProcessing = !this._nonStandardCreation && valueInjectorArr == null && !z2 && objectIdReaderT == null;
    }

    private s51 _findDelegateDeserializer(DeserializationContext deserializationContext, JavaType javaType, AnnotatedWithParams annotatedWithParams) throws JsonMappingException {
        BeanProperty.Std std = new BeanProperty.Std(TEMP_PROPERTY_NAME, javaType, null, annotatedWithParams, PropertyMetadata.STD_OPTIONAL);
        m63 m63VarFindTypeDeserializer = (m63) javaType.getTypeHandler();
        if (m63VarFindTypeDeserializer == null) {
            m63VarFindTypeDeserializer = deserializationContext.getConfig().findTypeDeserializer(javaType);
        }
        s51 s51Var = (s51) javaType.getValueHandler();
        s51 s51VarFindDeserializer = s51Var == null ? findDeserializer(deserializationContext, javaType, std) : deserializationContext.handleSecondaryContextualization(s51Var, std, javaType);
        return m63VarFindTypeDeserializer != null ? new TypeWrappedDeserializer(m63VarFindTypeDeserializer.forProperty(std), s51VarFindDeserializer) : s51VarFindDeserializer;
    }

    private Throwable throwOrReturnThrowable(Throwable th, DeserializationContext deserializationContext) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        ay.h0(th);
        boolean z = deserializationContext == null || deserializationContext.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS);
        if (th instanceof IOException) {
            if (!z || !(th instanceof JacksonException)) {
                throw ((IOException) th);
            }
        } else if (!z) {
            ay.j0(th);
        }
        return th;
    }

    protected Object _convertObjectId(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, s51 s51Var) throws IOException {
        q33 q33VarBufferForInputBuffering = deserializationContext.bufferForInputBuffering(jsonParser);
        if (obj instanceof String) {
            q33VarBufferForInputBuffering.w1((String) obj);
        } else if (obj instanceof Long) {
            q33VarBufferForInputBuffering.a1(((Long) obj).longValue());
        } else if (obj instanceof Integer) {
            q33VarBufferForInputBuffering.Z0(((Integer) obj).intValue());
        } else {
            q33VarBufferForInputBuffering.f1(obj);
        }
        JsonParser jsonParserN1 = q33VarBufferForInputBuffering.N1();
        jsonParserN1.n1();
        return s51Var.deserialize(jsonParserN1, deserializationContext);
    }

    protected final s51 _delegateDeserializer() {
        s51 s51Var = this._delegateDeserializer;
        return s51Var == null ? this._arrayDelegateDeserializer : s51Var;
    }

    protected abstract Object _deserializeUsingPropertyBased(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException;

    protected NameTransformer _findPropertyUnwrapper(DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty) throws JsonMappingException {
        NameTransformer nameTransformerFindUnwrappingNameTransformer;
        AnnotatedMember member = settableBeanProperty.getMember();
        if (member == null || (nameTransformerFindUnwrappingNameTransformer = deserializationContext.getAnnotationIntrospector().findUnwrappingNameTransformer(member)) == null) {
            return null;
        }
        if (settableBeanProperty instanceof CreatorProperty) {
            deserializationContext.reportBadDefinition(getValueType(), String.format("Cannot define Creator property \"%s\" as `@JsonUnwrapped`: combination not yet supported", settableBeanProperty.getName()));
        }
        return nameTransformerFindUnwrappingNameTransformer;
    }

    protected s51 _findSubclassDeserializer(DeserializationContext deserializationContext, Object obj, q33 q33Var) throws IOException {
        s51 s51Var;
        synchronized (this) {
            HashMap<ClassKey, s51> map = this._subDeserializers;
            s51Var = map == null ? null : map.get(new ClassKey(obj.getClass()));
        }
        if (s51Var != null) {
            return s51Var;
        }
        s51 s51VarFindRootValueDeserializer = deserializationContext.findRootValueDeserializer(deserializationContext.constructType(obj.getClass()));
        if (s51VarFindRootValueDeserializer != null) {
            synchronized (this) {
                try {
                    if (this._subDeserializers == null) {
                        this._subDeserializers = new HashMap<>();
                    }
                    this._subDeserializers.put(new ClassKey(obj.getClass()), s51VarFindRootValueDeserializer);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return s51VarFindRootValueDeserializer;
    }

    protected BeanDeserializerBase _handleByNameInclusion(DeserializationContext deserializationContext, AnnotationIntrospector annotationIntrospector, BeanDeserializerBase beanDeserializerBase, AnnotatedMember annotatedMember) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        JsonIgnoreProperties.Value valueFindPropertyIgnoralByName = annotationIntrospector.findPropertyIgnoralByName(config, annotatedMember);
        if (valueFindPropertyIgnoralByName.getIgnoreUnknown() && !this._ignoreAllUnknown) {
            beanDeserializerBase = beanDeserializerBase.withIgnoreAllUnknown(true);
        }
        Set<String> setFindIgnoredForDeserialization = valueFindPropertyIgnoralByName.findIgnoredForDeserialization();
        Set<String> set = beanDeserializerBase._ignorableProps;
        if (setFindIgnoredForDeserialization.isEmpty()) {
            setFindIgnoredForDeserialization = set;
        } else if (set != null && !set.isEmpty()) {
            HashSet hashSet = new HashSet(set);
            hashSet.addAll(setFindIgnoredForDeserialization);
            setFindIgnoredForDeserialization = hashSet;
        }
        Set<String> set2 = beanDeserializerBase._includableProps;
        Set<String> setB = IgnorePropertiesUtil.b(set2, annotationIntrospector.findPropertyInclusionByName(config, annotatedMember).getIncluded());
        return (setFindIgnoredForDeserialization == set && setB == set2) ? beanDeserializerBase : beanDeserializerBase.withByNameInclusion(setFindIgnoredForDeserialization, setB);
    }

    protected Object _handleTypedObjectId(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, Object obj2) throws IOException {
        s51 deserializer = this._objectIdReader.getDeserializer();
        if (deserializer.handledType() != obj2.getClass()) {
            obj2 = _convertObjectId(jsonParser, deserializationContext, obj2, deserializer);
        }
        ObjectIdReader objectIdReader = this._objectIdReader;
        ObjectIdGenerator<?> objectIdGenerator = objectIdReader.generator;
        objectIdReader.getClass();
        deserializationContext.findObjectId(obj2, objectIdGenerator, null).b(obj);
        SettableBeanProperty settableBeanProperty = this._objectIdReader.idProperty;
        return settableBeanProperty != null ? settableBeanProperty.setAndReturn(obj, obj2) : obj;
    }

    protected void _replaceProperty(BeanPropertyMap beanPropertyMap, SettableBeanProperty[] settableBeanPropertyArr, SettableBeanProperty settableBeanProperty, SettableBeanProperty settableBeanProperty2) {
        beanPropertyMap.replace(settableBeanProperty, settableBeanProperty2);
        if (settableBeanPropertyArr != null) {
            int length = settableBeanPropertyArr.length;
            for (int i = 0; i < length; i++) {
                if (settableBeanPropertyArr[i] == settableBeanProperty) {
                    settableBeanPropertyArr[i] = settableBeanProperty2;
                    return;
                }
            }
        }
    }

    protected SettableBeanProperty _resolveInnerClassValuedProperty(DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty) {
        Class<?> rawClass;
        Class<?> clsE;
        s51 valueDeserializer = settableBeanProperty.getValueDeserializer();
        if ((valueDeserializer instanceof BeanDeserializerBase) && !((BeanDeserializerBase) valueDeserializer).getValueInstantiator().canCreateUsingDefault() && (clsE = ay.E((rawClass = settableBeanProperty.getType().getRawClass()))) != null && clsE == this._beanType.getRawClass()) {
            for (Constructor<?> constructor : rawClass.getConstructors()) {
                if (constructor.getParameterCount() == 1 && clsE.equals(constructor.getParameterTypes()[0])) {
                    if (deserializationContext.canOverrideAccessModifiers()) {
                        ay.g(constructor, deserializationContext.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                    }
                    return new InnerClassProperty(settableBeanProperty, constructor);
                }
            }
        }
        return settableBeanProperty;
    }

    protected SettableBeanProperty _resolveManagedReferenceProperty(DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty) throws JsonMappingException {
        String managedReferenceName = settableBeanProperty.getManagedReferenceName();
        if (managedReferenceName == null) {
            return settableBeanProperty;
        }
        SettableBeanProperty settableBeanPropertyFindBackReference = settableBeanProperty.getValueDeserializer().findBackReference(managedReferenceName);
        if (settableBeanPropertyFindBackReference == null) {
            return (SettableBeanProperty) deserializationContext.reportBadDefinition(this._beanType, String.format("Cannot handle managed/back reference %s: no back reference property found from type %s", ay.V(managedReferenceName), ay.G(settableBeanProperty.getType())));
        }
        JavaType javaType = this._beanType;
        JavaType type = settableBeanPropertyFindBackReference.getType();
        boolean zIsContainerType = settableBeanProperty.getType().isContainerType();
        if (!type.getRawClass().isAssignableFrom(javaType.getRawClass())) {
            deserializationContext.reportBadDefinition(this._beanType, String.format("Cannot handle managed/back reference %s: back reference type (%s) not compatible with managed type (%s)", ay.V(managedReferenceName), ay.G(type), javaType.getRawClass().getName()));
        }
        return new ManagedReferenceProperty(settableBeanProperty, managedReferenceName, settableBeanPropertyFindBackReference, zIsContainerType);
    }

    protected SettableBeanProperty _resolveMergeAndNullSettings(DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty, PropertyMetadata propertyMetadata) throws JsonMappingException {
        PropertyMetadata.a mergeInfo = propertyMetadata.getMergeInfo();
        if (mergeInfo != null) {
            s51 valueDeserializer = settableBeanProperty.getValueDeserializer();
            Boolean boolSupportsUpdate = valueDeserializer.supportsUpdate(deserializationContext.getConfig());
            if (boolSupportsUpdate == null) {
                if (mergeInfo.b) {
                    return settableBeanProperty;
                }
            } else if (!boolSupportsUpdate.booleanValue()) {
                if (!mergeInfo.b) {
                    deserializationContext.handleBadMerge(valueDeserializer);
                }
                return settableBeanProperty;
            }
            AnnotatedMember annotatedMember = mergeInfo.a;
            annotatedMember.fixAccess(deserializationContext.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            if (!(settableBeanProperty instanceof SetterlessProperty)) {
                settableBeanProperty = MergingSettableBeanProperty.construct(settableBeanProperty, annotatedMember);
            }
        }
        gs1 gs1VarFindValueNullProvider = findValueNullProvider(deserializationContext, settableBeanProperty, propertyMetadata);
        return gs1VarFindValueNullProvider != null ? settableBeanProperty.withNullProvider(gs1VarFindValueNullProvider) : settableBeanProperty;
    }

    protected SettableBeanProperty _resolvedObjectIdProperty(DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty) throws JsonMappingException {
        lt1 objectIdInfo = settableBeanProperty.getObjectIdInfo();
        s51 valueDeserializer = settableBeanProperty.getValueDeserializer();
        return (objectIdInfo == null && (valueDeserializer == null ? null : valueDeserializer.getObjectIdReader()) == null) ? settableBeanProperty : new ObjectIdReferenceProperty(settableBeanProperty, objectIdInfo);
    }

    protected abstract BeanDeserializerBase asArrayDeserializer();

    @Override // defpackage.v30
    public s51 createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        BeanPropertyMap beanPropertyMap;
        BeanPropertyMap beanPropertyMapWithCaseInsensitivity;
        lt1 lt1VarFindObjectIdInfo;
        ObjectIdGenerator<?> objectIdGeneratorObjectIdGeneratorInstance;
        SettableBeanProperty settableBeanProperty;
        JavaType javaType;
        ObjectIdReader objectIdReaderConstruct = this._objectIdReader;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        JsonFormat.Shape shape = null;
        AnnotatedMember member = StdDeserializer._neitherNull(beanProperty, annotationIntrospector) ? beanProperty.getMember() : null;
        if (member != null && (lt1VarFindObjectIdInfo = annotationIntrospector.findObjectIdInfo(member)) != null) {
            lt1 lt1VarFindObjectReferenceInfo = annotationIntrospector.findObjectReferenceInfo(member, lt1VarFindObjectIdInfo);
            Class<?> clsC = lt1VarFindObjectReferenceInfo.c();
            deserializationContext.objectIdResolverInstance(member, lt1VarFindObjectReferenceInfo);
            if (clsC == ObjectIdGenerators$PropertyGenerator.class) {
                PropertyName propertyNameD = lt1VarFindObjectReferenceInfo.d();
                SettableBeanProperty settableBeanPropertyFindProperty = findProperty(propertyNameD);
                if (settableBeanPropertyFindProperty == null) {
                    return (s51) deserializationContext.reportBadDefinition(this._beanType, String.format("Invalid Object Id definition for %s: cannot find property with name %s", ay.X(handledType()), ay.U(propertyNameD)));
                }
                JavaType type = settableBeanPropertyFindProperty.getType();
                objectIdGeneratorObjectIdGeneratorInstance = new PropertyBasedObjectIdGenerator(lt1VarFindObjectReferenceInfo.f());
                javaType = type;
                settableBeanProperty = settableBeanPropertyFindProperty;
            } else {
                JavaType javaType2 = deserializationContext.getTypeFactory().findTypeParameters(deserializationContext.constructType(clsC), ObjectIdGenerator.class)[0];
                objectIdGeneratorObjectIdGeneratorInstance = deserializationContext.objectIdGeneratorInstance(member, lt1VarFindObjectReferenceInfo);
                settableBeanProperty = null;
                javaType = javaType2;
            }
            objectIdReaderConstruct = ObjectIdReader.construct(javaType, lt1VarFindObjectReferenceInfo.d(), objectIdGeneratorObjectIdGeneratorInstance, deserializationContext.findRootValueDeserializer(javaType), settableBeanProperty, null);
        }
        BeanDeserializerBase beanDeserializerBaseWithObjectIdReader = (objectIdReaderConstruct == null || objectIdReaderConstruct == this._objectIdReader) ? this : withObjectIdReader(objectIdReaderConstruct);
        if (member != null) {
            beanDeserializerBaseWithObjectIdReader = _handleByNameInclusion(deserializationContext, annotationIntrospector, beanDeserializerBaseWithObjectIdReader, member);
        }
        JsonFormat.Value valueFindFormatOverrides = findFormatOverrides(deserializationContext, beanProperty, handledType());
        if (valueFindFormatOverrides != null) {
            shape = valueFindFormatOverrides.hasShape() ? valueFindFormatOverrides.getShape() : null;
            Boolean feature = valueFindFormatOverrides.getFeature(JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
            if (feature != null && (beanPropertyMapWithCaseInsensitivity = (beanPropertyMap = this._beanProperties).withCaseInsensitivity(feature.booleanValue())) != beanPropertyMap) {
                beanDeserializerBaseWithObjectIdReader = beanDeserializerBaseWithObjectIdReader.withBeanProperties(beanPropertyMapWithCaseInsensitivity);
            }
        }
        if (shape == null) {
            shape = this._serializationShape;
        }
        return shape == JsonFormat.Shape.ARRAY ? beanDeserializerBaseWithObjectIdReader.asArrayDeserializer() : beanDeserializerBaseWithObjectIdReader;
    }

    public Iterator<SettableBeanProperty> creatorProperties() {
        PropertyBasedCreator propertyBasedCreator = this._propertyBasedCreator;
        return propertyBasedCreator == null ? Collections.emptyList().iterator() : propertyBasedCreator.f().iterator();
    }

    @Deprecated
    public Object deserializeFromArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return _deserializeFromArray(jsonParser, deserializationContext);
    }

    public Object deserializeFromBoolean(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        s51 s51Var_delegateDeserializer = _delegateDeserializer();
        if (s51Var_delegateDeserializer == null || this._valueInstantiator.canCreateFromBoolean()) {
            return this._valueInstantiator.createFromBoolean(deserializationContext, jsonParser.D() == JsonToken.VALUE_TRUE);
        }
        Object objCreateUsingDelegate = this._valueInstantiator.createUsingDelegate(deserializationContext, s51Var_delegateDeserializer.deserialize(jsonParser, deserializationContext));
        if (this._injectables != null) {
            injectValues(deserializationContext, objCreateUsingDelegate);
        }
        return objCreateUsingDelegate;
    }

    public Object deserializeFromDouble(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonParser.NumberType numberTypeL0 = jsonParser.L0();
        if (numberTypeL0 == JsonParser.NumberType.DOUBLE || numberTypeL0 == JsonParser.NumberType.FLOAT) {
            s51 s51Var_delegateDeserializer = _delegateDeserializer();
            if (s51Var_delegateDeserializer == null || this._valueInstantiator.canCreateFromDouble()) {
                return this._valueInstantiator.createFromDouble(deserializationContext, jsonParser.G0());
            }
            Object objCreateUsingDelegate = this._valueInstantiator.createUsingDelegate(deserializationContext, s51Var_delegateDeserializer.deserialize(jsonParser, deserializationContext));
            if (this._injectables != null) {
                injectValues(deserializationContext, objCreateUsingDelegate);
            }
            return objCreateUsingDelegate;
        }
        if (numberTypeL0 != JsonParser.NumberType.BIG_DECIMAL) {
            return deserializationContext.handleMissingInstantiator(handledType(), getValueInstantiator(), jsonParser, "no suitable creator method found to deserialize from Number value (%s)", jsonParser.M0());
        }
        s51 s51Var_delegateDeserializer2 = _delegateDeserializer();
        if (s51Var_delegateDeserializer2 == null || this._valueInstantiator.canCreateFromBigDecimal()) {
            return this._valueInstantiator.createFromBigDecimal(deserializationContext, jsonParser.F0());
        }
        Object objCreateUsingDelegate2 = this._valueInstantiator.createUsingDelegate(deserializationContext, s51Var_delegateDeserializer2.deserialize(jsonParser, deserializationContext));
        if (this._injectables != null) {
            injectValues(deserializationContext, objCreateUsingDelegate2);
        }
        return objCreateUsingDelegate2;
    }

    public Object deserializeFromEmbedded(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._objectIdReader != null) {
            return deserializeFromObjectId(jsonParser, deserializationContext);
        }
        s51 s51Var_delegateDeserializer = _delegateDeserializer();
        if (s51Var_delegateDeserializer == null || this._valueInstantiator.canCreateFromString()) {
            Object objH0 = jsonParser.H0();
            return (objH0 == null || this._beanType.isTypeOrSuperTypeOf(objH0.getClass())) ? objH0 : deserializationContext.handleWeirdNativeValue(this._beanType, objH0, jsonParser);
        }
        Object objCreateUsingDelegate = this._valueInstantiator.createUsingDelegate(deserializationContext, s51Var_delegateDeserializer.deserialize(jsonParser, deserializationContext));
        if (this._injectables != null) {
            injectValues(deserializationContext, objCreateUsingDelegate);
        }
        return objCreateUsingDelegate;
    }

    public Object deserializeFromNumber(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._objectIdReader != null) {
            return deserializeFromObjectId(jsonParser, deserializationContext);
        }
        s51 s51Var_delegateDeserializer = _delegateDeserializer();
        JsonParser.NumberType numberTypeL0 = jsonParser.L0();
        if (numberTypeL0 == JsonParser.NumberType.INT) {
            if (s51Var_delegateDeserializer == null || this._valueInstantiator.canCreateFromInt()) {
                return this._valueInstantiator.createFromInt(deserializationContext, jsonParser.J0());
            }
            Object objCreateUsingDelegate = this._valueInstantiator.createUsingDelegate(deserializationContext, s51Var_delegateDeserializer.deserialize(jsonParser, deserializationContext));
            if (this._injectables != null) {
                injectValues(deserializationContext, objCreateUsingDelegate);
            }
            return objCreateUsingDelegate;
        }
        if (numberTypeL0 == JsonParser.NumberType.LONG) {
            if (s51Var_delegateDeserializer == null || this._valueInstantiator.canCreateFromInt()) {
                return this._valueInstantiator.createFromLong(deserializationContext, jsonParser.K0());
            }
            Object objCreateUsingDelegate2 = this._valueInstantiator.createUsingDelegate(deserializationContext, s51Var_delegateDeserializer.deserialize(jsonParser, deserializationContext));
            if (this._injectables != null) {
                injectValues(deserializationContext, objCreateUsingDelegate2);
            }
            return objCreateUsingDelegate2;
        }
        if (numberTypeL0 != JsonParser.NumberType.BIG_INTEGER) {
            return deserializationContext.handleMissingInstantiator(handledType(), getValueInstantiator(), jsonParser, "no suitable creator method found to deserialize from Number value (%s)", jsonParser.M0());
        }
        if (s51Var_delegateDeserializer == null || this._valueInstantiator.canCreateFromBigInteger()) {
            return this._valueInstantiator.createFromBigInteger(deserializationContext, jsonParser.e0());
        }
        Object objCreateUsingDelegate3 = this._valueInstantiator.createUsingDelegate(deserializationContext, s51Var_delegateDeserializer.deserialize(jsonParser, deserializationContext));
        if (this._injectables != null) {
            injectValues(deserializationContext, objCreateUsingDelegate3);
        }
        return objCreateUsingDelegate3;
    }

    public abstract Object deserializeFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException;

    protected Object deserializeFromObjectId(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object objectReference = this._objectIdReader.readObjectReference(jsonParser, deserializationContext);
        ObjectIdReader objectIdReader = this._objectIdReader;
        ObjectIdGenerator<?> objectIdGenerator = objectIdReader.generator;
        objectIdReader.getClass();
        c cVarFindObjectId = deserializationContext.findObjectId(objectReference, objectIdGenerator, null);
        Object objF = cVarFindObjectId.f();
        if (objF != null) {
            return objF;
        }
        throw new UnresolvedForwardReference(jsonParser, "Could not resolve Object Id [" + objectReference + "] (for " + this._beanType + ").", jsonParser.w0(), cVarFindObjectId);
    }

    protected Object deserializeFromObjectUsingNonDefault(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        s51 s51Var_delegateDeserializer = _delegateDeserializer();
        if (s51Var_delegateDeserializer != null) {
            Object objCreateUsingDelegate = this._valueInstantiator.createUsingDelegate(deserializationContext, s51Var_delegateDeserializer.deserialize(jsonParser, deserializationContext));
            if (this._injectables != null) {
                injectValues(deserializationContext, objCreateUsingDelegate);
            }
            return objCreateUsingDelegate;
        }
        if (this._propertyBasedCreator != null) {
            return _deserializeUsingPropertyBased(jsonParser, deserializationContext);
        }
        Class<?> rawClass = this._beanType.getRawClass();
        if (ay.Q(rawClass)) {
            return deserializationContext.handleMissingInstantiator(rawClass, null, jsonParser, "non-static inner classes like this can only by instantiated using default, no-argument constructor", new Object[0]);
        }
        return jn1.c(rawClass) ? deserializationContext.handleMissingInstantiator(rawClass, null, jsonParser, "cannot deserialize from Object value (no delegate- or property-based Creator): this appears to be a native image, in which case you may need to configure reflection for the class that is to be deserialized", new Object[0]) : deserializationContext.handleMissingInstantiator(rawClass, getValueInstantiator(), jsonParser, "cannot deserialize from Object value (no delegate- or property-based Creator)", new Object[0]);
    }

    public Object deserializeFromString(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._objectIdReader != null) {
            return deserializeFromObjectId(jsonParser, deserializationContext);
        }
        s51 s51Var_delegateDeserializer = _delegateDeserializer();
        if (s51Var_delegateDeserializer == null || this._valueInstantiator.canCreateFromString()) {
            return _deserializeFromString(jsonParser, deserializationContext);
        }
        Object objCreateUsingDelegate = this._valueInstantiator.createUsingDelegate(deserializationContext, s51Var_delegateDeserializer.deserialize(jsonParser, deserializationContext));
        if (this._injectables != null) {
            injectValues(deserializationContext, objCreateUsingDelegate);
        }
        return objCreateUsingDelegate;
    }

    protected Object deserializeWithObjectId(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return deserializeFromObject(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        Object objO0;
        if (this._objectIdReader != null) {
            if (jsonParser.u() && (objO0 = jsonParser.O0()) != null) {
                return _handleTypedObjectId(jsonParser, deserializationContext, m63Var.deserializeTypedFromObject(jsonParser, deserializationContext), objO0);
            }
            JsonToken jsonTokenD = jsonParser.D();
            if (jsonTokenD != null) {
                if (jsonTokenD.isScalarValue()) {
                    return deserializeFromObjectId(jsonParser, deserializationContext);
                }
                if (jsonTokenD == JsonToken.START_OBJECT) {
                    jsonTokenD = jsonParser.n1();
                }
                if (jsonTokenD == JsonToken.FIELD_NAME && this._objectIdReader.maySerializeAsObject() && this._objectIdReader.isValidReferencePropertyName(jsonParser.C(), jsonParser)) {
                    return deserializeFromObjectId(jsonParser, deserializationContext);
                }
            }
        }
        return m63Var.deserializeTypedFromObject(jsonParser, deserializationContext);
    }

    @Override // defpackage.s51
    public SettableBeanProperty findBackReference(String str) {
        Map<String, SettableBeanProperty> map = this._backRefs;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    protected s51 findConvertingDeserializer(DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty) throws JsonMappingException {
        Object objFindDeserializationConverter;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null || (objFindDeserializationConverter = annotationIntrospector.findDeserializationConverter(settableBeanProperty.getMember())) == null) {
            return null;
        }
        f40 f40VarConverterInstance = deserializationContext.converterInstance(settableBeanProperty.getMember(), objFindDeserializationConverter);
        JavaType javaTypeA = f40VarConverterInstance.a(deserializationContext.getTypeFactory());
        return new StdDelegatingDeserializer(f40VarConverterInstance, javaTypeA, deserializationContext.findNonContextualValueDeserializer(javaTypeA));
    }

    public SettableBeanProperty findProperty(PropertyName propertyName) {
        return findProperty(propertyName.getSimpleName());
    }

    @Deprecated
    public final Class<?> getBeanClass() {
        return this._beanType.getRawClass();
    }

    @Override // defpackage.s51
    public AccessPattern getEmptyAccessPattern() {
        return AccessPattern.DYNAMIC;
    }

    @Override // defpackage.s51
    public Object getEmptyValue(DeserializationContext deserializationContext) throws JsonMappingException {
        try {
            return this._valueInstantiator.createUsingDefault(deserializationContext);
        } catch (IOException e) {
            return ay.g0(deserializationContext, e);
        }
    }

    @Override // defpackage.s51
    public Collection<Object> getKnownPropertyNames() {
        ArrayList arrayList = new ArrayList();
        Iterator<SettableBeanProperty> it = this._beanProperties.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getName());
        }
        return arrayList;
    }

    @Override // defpackage.s51
    public AccessPattern getNullAccessPattern() {
        return AccessPattern.ALWAYS_NULL;
    }

    @Override // defpackage.s51
    public ObjectIdReader getObjectIdReader() {
        return this._objectIdReader;
    }

    public int getPropertyCount() {
        return this._beanProperties.size();
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public ValueInstantiator getValueInstantiator() {
        return this._valueInstantiator;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public JavaType getValueType() {
        return this._beanType;
    }

    protected void handleIgnoredProperty(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws IOException {
        if (deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES)) {
            throw IgnoredPropertyException.from(jsonParser, obj, str, getKnownPropertyNames());
        }
        jsonParser.v1();
    }

    protected Object handlePolymorphic(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, q33 q33Var) throws IOException {
        s51 s51Var_findSubclassDeserializer = _findSubclassDeserializer(deserializationContext, obj, q33Var);
        if (s51Var_findSubclassDeserializer == null) {
            if (q33Var != null) {
                obj = handleUnknownProperties(deserializationContext, obj, q33Var);
            }
            return jsonParser != null ? deserialize(jsonParser, deserializationContext, obj) : obj;
        }
        if (q33Var != null) {
            q33Var.S0();
            JsonParser jsonParserN1 = q33Var.N1();
            jsonParserN1.n1();
            obj = s51Var_findSubclassDeserializer.deserialize(jsonParserN1, deserializationContext, obj);
        }
        return jsonParser != null ? s51Var_findSubclassDeserializer.deserialize(jsonParser, deserializationContext, obj) : obj;
    }

    protected Object handleUnknownProperties(DeserializationContext deserializationContext, Object obj, q33 q33Var) throws IOException {
        q33Var.S0();
        JsonParser jsonParserN1 = q33Var.N1();
        while (jsonParserN1.n1() != JsonToken.END_OBJECT) {
            String strC = jsonParserN1.C();
            jsonParserN1.n1();
            handleUnknownProperty(jsonParserN1, deserializationContext, obj, strC);
        }
        return obj;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    protected void handleUnknownProperty(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws IOException {
        if (this._ignoreAllUnknown) {
            jsonParser.v1();
            return;
        }
        if (IgnorePropertiesUtil.c(str, this._ignorableProps, this._includableProps)) {
            handleIgnoredProperty(jsonParser, deserializationContext, obj, str);
        }
        super.handleUnknownProperty(jsonParser, deserializationContext, obj, str);
    }

    protected void handleUnknownVanilla(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws IOException {
        if (IgnorePropertiesUtil.c(str, this._ignorableProps, this._includableProps)) {
            handleIgnoredProperty(jsonParser, deserializationContext, obj, str);
            return;
        }
        SettableAnyProperty settableAnyProperty = this._anySetter;
        if (settableAnyProperty == null) {
            handleUnknownProperty(jsonParser, deserializationContext, obj, str);
            return;
        }
        try {
            settableAnyProperty.deserializeAndSet(jsonParser, deserializationContext, obj, str);
        } catch (Exception e) {
            wrapAndThrow(e, obj, str, deserializationContext);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, defpackage.s51
    public Class<?> handledType() {
        return this._beanType.getRawClass();
    }

    public boolean hasProperty(String str) {
        return this._beanProperties.find(str) != null;
    }

    public boolean hasViews() {
        return this._needViewProcesing;
    }

    protected void injectValues(DeserializationContext deserializationContext, Object obj) throws IOException {
        for (ValueInjector valueInjector : this._injectables) {
            valueInjector.inject(deserializationContext, obj);
        }
    }

    @Override // defpackage.s51
    public boolean isCachable() {
        return true;
    }

    public boolean isCaseInsensitive() {
        return this._beanProperties.isCaseInsensitive();
    }

    @Override // defpackage.s51
    public LogicalType logicalType() {
        return LogicalType.POJO;
    }

    public Iterator<SettableBeanProperty> properties() {
        BeanPropertyMap beanPropertyMap = this._beanProperties;
        if (beanPropertyMap != null) {
            return beanPropertyMap.iterator();
        }
        throw new IllegalStateException("Can only call after BeanDeserializer has been resolved");
    }

    public void replaceProperty(SettableBeanProperty settableBeanProperty, SettableBeanProperty settableBeanProperty2) {
        this._beanProperties.replace(settableBeanProperty, settableBeanProperty2);
    }

    @Override // defpackage.ag2
    public void resolve(DeserializationContext deserializationContext) throws JsonMappingException {
        SettableBeanProperty[] fromObjectArguments;
        s51 valueDeserializer;
        s51 s51VarUnwrappingDeserializer;
        boolean z = false;
        rj0.a aVarE = null;
        if (this._valueInstantiator.canCreateFromObjectWith()) {
            fromObjectArguments = this._valueInstantiator.getFromObjectArguments(deserializationContext.getConfig());
            if (this._ignorableProps != null || this._includableProps != null) {
                int length = fromObjectArguments.length;
                for (int i = 0; i < length; i++) {
                    if (IgnorePropertiesUtil.c(fromObjectArguments[i].getName(), this._ignorableProps, this._includableProps)) {
                        fromObjectArguments[i].markAsIgnorable();
                    }
                }
            }
        } else {
            fromObjectArguments = null;
        }
        for (SettableBeanProperty settableBeanProperty : this._beanProperties) {
            if (!settableBeanProperty.hasValueDeserializer()) {
                s51 s51VarFindConvertingDeserializer = findConvertingDeserializer(deserializationContext, settableBeanProperty);
                if (s51VarFindConvertingDeserializer == null) {
                    s51VarFindConvertingDeserializer = deserializationContext.findNonContextualValueDeserializer(settableBeanProperty.getType());
                }
                _replaceProperty(this._beanProperties, fromObjectArguments, settableBeanProperty, settableBeanProperty.withValueDeserializer(s51VarFindConvertingDeserializer));
            }
        }
        x83 x83Var = null;
        for (SettableBeanProperty settableBeanProperty2 : this._beanProperties) {
            SettableBeanProperty settableBeanProperty_resolveManagedReferenceProperty = _resolveManagedReferenceProperty(deserializationContext, settableBeanProperty2.withValueDeserializer(deserializationContext.handlePrimaryContextualization(settableBeanProperty2.getValueDeserializer(), settableBeanProperty2, settableBeanProperty2.getType())));
            if (!(settableBeanProperty_resolveManagedReferenceProperty instanceof ManagedReferenceProperty)) {
                settableBeanProperty_resolveManagedReferenceProperty = _resolvedObjectIdProperty(deserializationContext, settableBeanProperty_resolveManagedReferenceProperty);
            }
            NameTransformer nameTransformer_findPropertyUnwrapper = _findPropertyUnwrapper(deserializationContext, settableBeanProperty_resolveManagedReferenceProperty);
            if (nameTransformer_findPropertyUnwrapper == null || (s51VarUnwrappingDeserializer = (valueDeserializer = settableBeanProperty_resolveManagedReferenceProperty.getValueDeserializer()).unwrappingDeserializer(nameTransformer_findPropertyUnwrapper)) == valueDeserializer || s51VarUnwrappingDeserializer == null) {
                SettableBeanProperty settableBeanProperty_resolveInnerClassValuedProperty = _resolveInnerClassValuedProperty(deserializationContext, _resolveMergeAndNullSettings(deserializationContext, settableBeanProperty_resolveManagedReferenceProperty, settableBeanProperty_resolveManagedReferenceProperty.getMetadata()));
                if (settableBeanProperty_resolveInnerClassValuedProperty != settableBeanProperty2) {
                    _replaceProperty(this._beanProperties, fromObjectArguments, settableBeanProperty2, settableBeanProperty_resolveInnerClassValuedProperty);
                }
                if (settableBeanProperty_resolveInnerClassValuedProperty.hasValueTypeDeserializer()) {
                    m63 valueTypeDeserializer = settableBeanProperty_resolveInnerClassValuedProperty.getValueTypeDeserializer();
                    if (valueTypeDeserializer.getTypeInclusion() == JsonTypeInfo.As.EXTERNAL_PROPERTY) {
                        if (aVarE == null) {
                            aVarE = rj0.e(this._beanType);
                        }
                        aVarE.b(settableBeanProperty_resolveInnerClassValuedProperty, valueTypeDeserializer);
                        this._beanProperties.remove(settableBeanProperty_resolveInnerClassValuedProperty);
                    }
                }
            } else {
                SettableBeanProperty settableBeanPropertyWithValueDeserializer = settableBeanProperty_resolveManagedReferenceProperty.withValueDeserializer(s51VarUnwrappingDeserializer);
                if (x83Var == null) {
                    x83Var = new x83();
                }
                x83Var.a(settableBeanPropertyWithValueDeserializer);
                this._beanProperties.remove(settableBeanPropertyWithValueDeserializer);
            }
        }
        SettableAnyProperty settableAnyProperty = this._anySetter;
        if (settableAnyProperty != null && !settableAnyProperty.hasValueDeserializer()) {
            SettableAnyProperty settableAnyProperty2 = this._anySetter;
            this._anySetter = settableAnyProperty2.withValueDeserializer(findDeserializer(deserializationContext, settableAnyProperty2.getType(), this._anySetter.getProperty()));
        }
        if (this._valueInstantiator.canCreateUsingDelegate()) {
            JavaType delegateType = this._valueInstantiator.getDelegateType(deserializationContext.getConfig());
            if (delegateType == null) {
                JavaType javaType = this._beanType;
                deserializationContext.reportBadDefinition(javaType, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", ay.G(javaType), ay.h(this._valueInstantiator)));
            }
            this._delegateDeserializer = _findDelegateDeserializer(deserializationContext, delegateType, this._valueInstantiator.getDelegateCreator());
        }
        if (this._valueInstantiator.canCreateUsingArrayDelegate()) {
            JavaType arrayDelegateType = this._valueInstantiator.getArrayDelegateType(deserializationContext.getConfig());
            if (arrayDelegateType == null) {
                JavaType javaType2 = this._beanType;
                deserializationContext.reportBadDefinition(javaType2, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", ay.G(javaType2), ay.h(this._valueInstantiator)));
            }
            this._arrayDelegateDeserializer = _findDelegateDeserializer(deserializationContext, arrayDelegateType, this._valueInstantiator.getArrayDelegateCreator());
        }
        if (fromObjectArguments != null) {
            this._propertyBasedCreator = PropertyBasedCreator.b(deserializationContext, this._valueInstantiator, fromObjectArguments, this._beanProperties);
        }
        if (aVarE != null) {
            this._externalTypeIdHandler = aVarE.c(this._beanProperties);
            this._nonStandardCreation = true;
        }
        this._unwrappedPropertyHandler = x83Var;
        if (x83Var != null) {
            this._nonStandardCreation = true;
        }
        if (this._vanillaProcessing && !this._nonStandardCreation) {
            z = true;
        }
        this._vanillaProcessing = z;
    }

    @Override // defpackage.s51
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return Boolean.TRUE;
    }

    @Override // defpackage.s51
    public abstract s51 unwrappingDeserializer(NameTransformer nameTransformer);

    public BeanDeserializerBase withBeanProperties(BeanPropertyMap beanPropertyMap) {
        throw new UnsupportedOperationException("Class " + getClass().getName() + " does not override `withBeanProperties()`, needs to");
    }

    public abstract BeanDeserializerBase withByNameInclusion(Set<String> set, Set<String> set2);

    @Deprecated
    public BeanDeserializerBase withIgnorableProperties(Set<String> set) {
        return withByNameInclusion(set, this._includableProps);
    }

    public abstract BeanDeserializerBase withIgnoreAllUnknown(boolean z);

    public abstract BeanDeserializerBase withObjectIdReader(ObjectIdReader objectIdReader);

    public void wrapAndThrow(Throwable th, Object obj, String str, DeserializationContext deserializationContext) throws IOException {
        throw JsonMappingException.wrapWithPath(throwOrReturnThrowable(th, deserializationContext), obj, str);
    }

    protected Object wrapInstantiationProblem(Throwable th, DeserializationContext deserializationContext) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        ay.h0(th);
        if (th instanceof IOException) {
            throw ((IOException) th);
        }
        if (deserializationContext == null) {
            throw new IllegalArgumentException(th.getMessage(), th);
        }
        if (!deserializationContext.isEnabled(DeserializationFeature.WRAP_EXCEPTIONS)) {
            ay.j0(th);
        }
        return deserializationContext.handleInstantiationProblem(this._beanType.getRawClass(), null, th);
    }

    public SettableBeanProperty findProperty(String str) {
        PropertyBasedCreator propertyBasedCreator;
        BeanPropertyMap beanPropertyMap = this._beanProperties;
        SettableBeanProperty settableBeanPropertyFind = beanPropertyMap == null ? null : beanPropertyMap.find(str);
        return (settableBeanPropertyFind != null || (propertyBasedCreator = this._propertyBasedCreator) == null) ? settableBeanPropertyFind : propertyBasedCreator.e(str);
    }

    public SettableBeanProperty findProperty(int i) {
        PropertyBasedCreator propertyBasedCreator;
        BeanPropertyMap beanPropertyMap = this._beanProperties;
        SettableBeanProperty settableBeanPropertyFind = beanPropertyMap == null ? null : beanPropertyMap.find(i);
        return (settableBeanPropertyFind != null || (propertyBasedCreator = this._propertyBasedCreator) == null) ? settableBeanPropertyFind : propertyBasedCreator.d(i);
    }

    protected BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase) {
        this(beanDeserializerBase, beanDeserializerBase._ignoreAllUnknown);
    }

    protected BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, boolean z) {
        super(beanDeserializerBase._beanType);
        this._beanType = beanDeserializerBase._beanType;
        this._valueInstantiator = beanDeserializerBase._valueInstantiator;
        this._delegateDeserializer = beanDeserializerBase._delegateDeserializer;
        this._arrayDelegateDeserializer = beanDeserializerBase._arrayDelegateDeserializer;
        this._propertyBasedCreator = beanDeserializerBase._propertyBasedCreator;
        this._beanProperties = beanDeserializerBase._beanProperties;
        this._backRefs = beanDeserializerBase._backRefs;
        this._ignorableProps = beanDeserializerBase._ignorableProps;
        this._ignoreAllUnknown = z;
        this._includableProps = beanDeserializerBase._includableProps;
        this._anySetter = beanDeserializerBase._anySetter;
        this._injectables = beanDeserializerBase._injectables;
        this._objectIdReader = beanDeserializerBase._objectIdReader;
        this._nonStandardCreation = beanDeserializerBase._nonStandardCreation;
        this._unwrappedPropertyHandler = beanDeserializerBase._unwrappedPropertyHandler;
        this._needViewProcesing = beanDeserializerBase._needViewProcesing;
        this._serializationShape = beanDeserializerBase._serializationShape;
        this._vanillaProcessing = beanDeserializerBase._vanillaProcessing;
    }

    protected BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, NameTransformer nameTransformer) {
        super(beanDeserializerBase._beanType);
        this._beanType = beanDeserializerBase._beanType;
        this._valueInstantiator = beanDeserializerBase._valueInstantiator;
        this._delegateDeserializer = beanDeserializerBase._delegateDeserializer;
        this._arrayDelegateDeserializer = beanDeserializerBase._arrayDelegateDeserializer;
        this._propertyBasedCreator = beanDeserializerBase._propertyBasedCreator;
        this._backRefs = beanDeserializerBase._backRefs;
        this._ignorableProps = beanDeserializerBase._ignorableProps;
        this._ignoreAllUnknown = nameTransformer != null || beanDeserializerBase._ignoreAllUnknown;
        this._includableProps = beanDeserializerBase._includableProps;
        this._anySetter = beanDeserializerBase._anySetter;
        this._injectables = beanDeserializerBase._injectables;
        this._objectIdReader = beanDeserializerBase._objectIdReader;
        this._nonStandardCreation = beanDeserializerBase._nonStandardCreation;
        x83 x83VarC = beanDeserializerBase._unwrappedPropertyHandler;
        if (nameTransformer != null) {
            x83VarC = x83VarC != null ? x83VarC.c(nameTransformer) : x83VarC;
            this._beanProperties = beanDeserializerBase._beanProperties.renameAll(nameTransformer);
        } else {
            this._beanProperties = beanDeserializerBase._beanProperties;
        }
        this._unwrappedPropertyHandler = x83VarC;
        this._needViewProcesing = beanDeserializerBase._needViewProcesing;
        this._serializationShape = beanDeserializerBase._serializationShape;
        this._vanillaProcessing = false;
    }

    public BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, ObjectIdReader objectIdReader) {
        super(beanDeserializerBase._beanType);
        this._beanType = beanDeserializerBase._beanType;
        this._valueInstantiator = beanDeserializerBase._valueInstantiator;
        this._delegateDeserializer = beanDeserializerBase._delegateDeserializer;
        this._arrayDelegateDeserializer = beanDeserializerBase._arrayDelegateDeserializer;
        this._propertyBasedCreator = beanDeserializerBase._propertyBasedCreator;
        this._backRefs = beanDeserializerBase._backRefs;
        this._ignorableProps = beanDeserializerBase._ignorableProps;
        this._ignoreAllUnknown = beanDeserializerBase._ignoreAllUnknown;
        this._includableProps = beanDeserializerBase._includableProps;
        this._anySetter = beanDeserializerBase._anySetter;
        this._injectables = beanDeserializerBase._injectables;
        this._nonStandardCreation = beanDeserializerBase._nonStandardCreation;
        this._unwrappedPropertyHandler = beanDeserializerBase._unwrappedPropertyHandler;
        this._needViewProcesing = beanDeserializerBase._needViewProcesing;
        this._serializationShape = beanDeserializerBase._serializationShape;
        this._objectIdReader = objectIdReader;
        if (objectIdReader == null) {
            this._beanProperties = beanDeserializerBase._beanProperties;
            this._vanillaProcessing = beanDeserializerBase._vanillaProcessing;
        } else {
            this._beanProperties = beanDeserializerBase._beanProperties.withProperty(new ObjectIdValueProperty(objectIdReader, PropertyMetadata.STD_REQUIRED));
            this._vanillaProcessing = false;
        }
    }

    public BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, Set<String> set, Set<String> set2) {
        super(beanDeserializerBase._beanType);
        this._beanType = beanDeserializerBase._beanType;
        this._valueInstantiator = beanDeserializerBase._valueInstantiator;
        this._delegateDeserializer = beanDeserializerBase._delegateDeserializer;
        this._arrayDelegateDeserializer = beanDeserializerBase._arrayDelegateDeserializer;
        this._propertyBasedCreator = beanDeserializerBase._propertyBasedCreator;
        this._backRefs = beanDeserializerBase._backRefs;
        this._ignorableProps = set;
        this._ignoreAllUnknown = beanDeserializerBase._ignoreAllUnknown;
        this._includableProps = set2;
        this._anySetter = beanDeserializerBase._anySetter;
        this._injectables = beanDeserializerBase._injectables;
        this._nonStandardCreation = beanDeserializerBase._nonStandardCreation;
        this._unwrappedPropertyHandler = beanDeserializerBase._unwrappedPropertyHandler;
        this._needViewProcesing = beanDeserializerBase._needViewProcesing;
        this._serializationShape = beanDeserializerBase._serializationShape;
        this._vanillaProcessing = beanDeserializerBase._vanillaProcessing;
        this._objectIdReader = beanDeserializerBase._objectIdReader;
        this._beanProperties = beanDeserializerBase._beanProperties.withoutProperties(set, set2);
    }

    protected BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, BeanPropertyMap beanPropertyMap) {
        super(beanDeserializerBase._beanType);
        this._beanType = beanDeserializerBase._beanType;
        this._valueInstantiator = beanDeserializerBase._valueInstantiator;
        this._delegateDeserializer = beanDeserializerBase._delegateDeserializer;
        this._arrayDelegateDeserializer = beanDeserializerBase._arrayDelegateDeserializer;
        this._propertyBasedCreator = beanDeserializerBase._propertyBasedCreator;
        this._beanProperties = beanPropertyMap;
        this._backRefs = beanDeserializerBase._backRefs;
        this._ignorableProps = beanDeserializerBase._ignorableProps;
        this._ignoreAllUnknown = beanDeserializerBase._ignoreAllUnknown;
        this._includableProps = beanDeserializerBase._includableProps;
        this._anySetter = beanDeserializerBase._anySetter;
        this._injectables = beanDeserializerBase._injectables;
        this._objectIdReader = beanDeserializerBase._objectIdReader;
        this._nonStandardCreation = beanDeserializerBase._nonStandardCreation;
        this._unwrappedPropertyHandler = beanDeserializerBase._unwrappedPropertyHandler;
        this._needViewProcesing = beanDeserializerBase._needViewProcesing;
        this._serializationShape = beanDeserializerBase._serializationShape;
        this._vanillaProcessing = beanDeserializerBase._vanillaProcessing;
    }

    @Deprecated
    protected BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, Set<String> set) {
        this(beanDeserializerBase, set, beanDeserializerBase._includableProps);
    }
}
