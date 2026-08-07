package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.deser.impl.BeanAsArrayBuilderDeserializer;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.b;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import com.fasterxml.jackson.databind.util.NameTransformer;
import defpackage.kh;
import defpackage.lh;
import defpackage.q33;
import defpackage.rj0;
import defpackage.s51;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class BuilderBasedDeserializer extends BeanDeserializerBase {
    private static final long serialVersionUID = 1;
    protected final AnnotatedMethod _buildMethod;
    protected final JavaType _targetType;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CoercionAction.values().length];
            a = iArr;
            try {
                iArr[CoercionAction.AsEmpty.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CoercionAction.AsNull.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CoercionAction.TryConvert.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public BuilderBasedDeserializer(lh lhVar, kh khVar, JavaType javaType, BeanPropertyMap beanPropertyMap, Map<String, SettableBeanProperty> map, Set<String> set, boolean z, boolean z2) {
        this(lhVar, khVar, javaType, beanPropertyMap, map, set, z, null, z2);
    }

    private final Object vanillaDeserialize(JsonParser jsonParser, DeserializationContext deserializationContext, JsonToken jsonToken) throws IOException {
        Object objCreateUsingDefault = this._valueInstantiator.createUsingDefault(deserializationContext);
        while (jsonParser.D() == JsonToken.FIELD_NAME) {
            String strC = jsonParser.C();
            jsonParser.n1();
            SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strC);
            if (settableBeanPropertyFind != null) {
                try {
                    objCreateUsingDefault = settableBeanPropertyFind.deserializeSetAndReturn(jsonParser, deserializationContext, objCreateUsingDefault);
                } catch (Exception e) {
                    wrapAndThrow(e, objCreateUsingDefault, strC, deserializationContext);
                }
            } else {
                handleUnknownVanilla(jsonParser, deserializationContext, objCreateUsingDefault, strC);
            }
            jsonParser.n1();
        }
        return objCreateUsingDefault;
    }

    protected final Object _deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        Class<?> activeView;
        if (this._injectables != null) {
            injectValues(deserializationContext, obj);
        }
        if (this._unwrappedPropertyHandler != null) {
            if (jsonParser.d1(JsonToken.START_OBJECT)) {
                jsonParser.n1();
            }
            q33 q33VarBufferForInputBuffering = deserializationContext.bufferForInputBuffering(jsonParser);
            q33VarBufferForInputBuffering.s1();
            return deserializeWithUnwrapped(jsonParser, deserializationContext, obj, q33VarBufferForInputBuffering);
        }
        if (this._externalTypeIdHandler != null) {
            return deserializeWithExternalTypeId(jsonParser, deserializationContext, obj);
        }
        if (this._needViewProcesing && (activeView = deserializationContext.getActiveView()) != null) {
            return deserializeWithView(jsonParser, deserializationContext, obj, activeView);
        }
        JsonToken jsonTokenD = jsonParser.D();
        if (jsonTokenD == JsonToken.START_OBJECT) {
            jsonTokenD = jsonParser.n1();
        }
        while (jsonTokenD == JsonToken.FIELD_NAME) {
            String strC = jsonParser.C();
            jsonParser.n1();
            SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strC);
            if (settableBeanPropertyFind != null) {
                try {
                    obj = settableBeanPropertyFind.deserializeSetAndReturn(jsonParser, deserializationContext, obj);
                } catch (Exception e) {
                    wrapAndThrow(e, obj, strC, deserializationContext);
                }
            } else {
                handleUnknownVanilla(jsonParser, deserializationContext, obj, strC);
            }
            jsonTokenD = jsonParser.n1();
        }
        return obj;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    protected Object _deserializeFromArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        s51 s51Var = this._arrayDelegateDeserializer;
        if (s51Var != null || (s51Var = this._delegateDeserializer) != null) {
            Object objCreateUsingArrayDelegate = this._valueInstantiator.createUsingArrayDelegate(deserializationContext, s51Var.deserialize(jsonParser, deserializationContext));
            if (this._injectables != null) {
                injectValues(deserializationContext, objCreateUsingArrayDelegate);
            }
            return finishBuild(deserializationContext, objCreateUsingArrayDelegate);
        }
        CoercionAction coercionAction_findCoercionFromEmptyArray = _findCoercionFromEmptyArray(deserializationContext);
        boolean zIsEnabled = deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS);
        if (zIsEnabled || coercionAction_findCoercionFromEmptyArray != CoercionAction.Fail) {
            JsonToken jsonTokenN1 = jsonParser.n1();
            JsonToken jsonToken = JsonToken.END_ARRAY;
            if (jsonTokenN1 == jsonToken) {
                int i = a.a[coercionAction_findCoercionFromEmptyArray.ordinal()];
                if (i != 1) {
                    return (i == 2 || i == 3) ? getNullValue(deserializationContext) : deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), JsonToken.START_ARRAY, jsonParser, (String) null, new Object[0]);
                }
                return getEmptyValue(deserializationContext);
            }
            if (zIsEnabled) {
                Object objDeserialize = deserialize(jsonParser, deserializationContext);
                if (jsonParser.n1() != jsonToken) {
                    handleMissingEndArrayForSingle(jsonParser, deserializationContext);
                }
                return objDeserialize;
            }
        }
        return deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    protected Object _deserializeUsingPropertyBased(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object objWrapInstantiationProblem;
        PropertyBasedCreator propertyBasedCreator = this._propertyBasedCreator;
        b bVarG = propertyBasedCreator.g(jsonParser, deserializationContext, this._objectIdReader);
        Class<?> activeView = this._needViewProcesing ? deserializationContext.getActiveView() : null;
        JsonToken jsonTokenD = jsonParser.D();
        q33 q33VarBufferForInputBuffering = null;
        while (jsonTokenD == JsonToken.FIELD_NAME) {
            String strC = jsonParser.C();
            jsonParser.n1();
            SettableBeanProperty settableBeanPropertyE = propertyBasedCreator.e(strC);
            if (!bVarG.i(strC) || settableBeanPropertyE != null) {
                if (settableBeanPropertyE == null) {
                    SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strC);
                    if (settableBeanPropertyFind != null) {
                        bVarG.e(settableBeanPropertyFind, settableBeanPropertyFind.deserialize(jsonParser, deserializationContext));
                    } else if (IgnorePropertiesUtil.c(strC, this._ignorableProps, this._includableProps)) {
                        handleIgnoredProperty(jsonParser, deserializationContext, handledType(), strC);
                    } else {
                        SettableAnyProperty settableAnyProperty = this._anySetter;
                        if (settableAnyProperty != null) {
                            bVarG.c(settableAnyProperty, strC, settableAnyProperty.deserialize(jsonParser, deserializationContext));
                        } else {
                            if (q33VarBufferForInputBuffering == null) {
                                q33VarBufferForInputBuffering = deserializationContext.bufferForInputBuffering(jsonParser);
                            }
                            q33VarBufferForInputBuffering.V0(strC);
                            q33VarBufferForInputBuffering.R1(jsonParser);
                        }
                    }
                } else if (activeView != null && !settableBeanPropertyE.visibleInView(activeView)) {
                    jsonParser.v1();
                } else if (bVarG.b(settableBeanPropertyE, settableBeanPropertyE.deserialize(jsonParser, deserializationContext))) {
                    jsonParser.n1();
                    try {
                        Object objA = propertyBasedCreator.a(deserializationContext, bVarG);
                        if (objA.getClass() != this._beanType.getRawClass()) {
                            return handlePolymorphic(jsonParser, deserializationContext, objA, q33VarBufferForInputBuffering);
                        }
                        if (q33VarBufferForInputBuffering != null) {
                            objA = handleUnknownProperties(deserializationContext, objA, q33VarBufferForInputBuffering);
                        }
                        return _deserialize(jsonParser, deserializationContext, objA);
                    } catch (Exception e) {
                        wrapAndThrow(e, this._beanType.getRawClass(), strC, deserializationContext);
                    }
                } else {
                    continue;
                }
            }
            jsonTokenD = jsonParser.n1();
        }
        try {
            objWrapInstantiationProblem = propertyBasedCreator.a(deserializationContext, bVarG);
        } catch (Exception e2) {
            objWrapInstantiationProblem = wrapInstantiationProblem(e2, deserializationContext);
        }
        if (q33VarBufferForInputBuffering != null) {
            return objWrapInstantiationProblem.getClass() != this._beanType.getRawClass() ? handlePolymorphic(null, deserializationContext, objWrapInstantiationProblem, q33VarBufferForInputBuffering) : handleUnknownProperties(deserializationContext, objWrapInstantiationProblem, q33VarBufferForInputBuffering);
        }
        return objWrapInstantiationProblem;
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    protected BeanDeserializerBase asArrayDeserializer() {
        return new BeanAsArrayBuilderDeserializer(this, this._targetType, this._beanProperties.getPropertiesInInsertionOrder(), this._buildMethod);
    }

    @Override // defpackage.s51
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (jsonParser.j1()) {
            return this._vanillaProcessing ? finishBuild(deserializationContext, vanillaDeserialize(jsonParser, deserializationContext, jsonParser.n1())) : finishBuild(deserializationContext, deserializeFromObject(jsonParser, deserializationContext));
        }
        switch (jsonParser.V()) {
            case 2:
            case 5:
                return finishBuild(deserializationContext, deserializeFromObject(jsonParser, deserializationContext));
            case 3:
                return _deserializeFromArray(jsonParser, deserializationContext);
            case 4:
            case 11:
            default:
                return deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
            case 6:
                return finishBuild(deserializationContext, deserializeFromString(jsonParser, deserializationContext));
            case 7:
                return finishBuild(deserializationContext, deserializeFromNumber(jsonParser, deserializationContext));
            case 8:
                return finishBuild(deserializationContext, deserializeFromDouble(jsonParser, deserializationContext));
            case 9:
            case 10:
                return finishBuild(deserializationContext, deserializeFromBoolean(jsonParser, deserializationContext));
            case 12:
                return jsonParser.H0();
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public Object deserializeFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Class<?> activeView;
        if (this._nonStandardCreation) {
            if (this._unwrappedPropertyHandler != null) {
                return deserializeWithUnwrapped(jsonParser, deserializationContext);
            }
            return this._externalTypeIdHandler != null ? deserializeWithExternalTypeId(jsonParser, deserializationContext) : deserializeFromObjectUsingNonDefault(jsonParser, deserializationContext);
        }
        Object objCreateUsingDefault = this._valueInstantiator.createUsingDefault(deserializationContext);
        if (this._injectables != null) {
            injectValues(deserializationContext, objCreateUsingDefault);
        }
        if (this._needViewProcesing && (activeView = deserializationContext.getActiveView()) != null) {
            return deserializeWithView(jsonParser, deserializationContext, objCreateUsingDefault, activeView);
        }
        while (jsonParser.D() == JsonToken.FIELD_NAME) {
            String strC = jsonParser.C();
            jsonParser.n1();
            SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strC);
            if (settableBeanPropertyFind != null) {
                try {
                    objCreateUsingDefault = settableBeanPropertyFind.deserializeSetAndReturn(jsonParser, deserializationContext, objCreateUsingDefault);
                } catch (Exception e) {
                    wrapAndThrow(e, objCreateUsingDefault, strC, deserializationContext);
                }
            } else {
                handleUnknownVanilla(jsonParser, deserializationContext, objCreateUsingDefault, strC);
            }
            jsonParser.n1();
        }
        return objCreateUsingDefault;
    }

    protected Object deserializeUsingPropertyBasedWithExternalTypeId(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JavaType javaType = this._targetType;
        return deserializationContext.reportBadDefinition(javaType, String.format("Deserialization (of %s) with Builder, External type id, @JsonCreator not yet implemented", javaType));
    }

    protected Object deserializeUsingPropertyBasedWithUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        PropertyBasedCreator propertyBasedCreator = this._propertyBasedCreator;
        b bVarG = propertyBasedCreator.g(jsonParser, deserializationContext, this._objectIdReader);
        q33 q33VarBufferForInputBuffering = deserializationContext.bufferForInputBuffering(jsonParser);
        q33VarBufferForInputBuffering.s1();
        JsonToken jsonTokenD = jsonParser.D();
        while (jsonTokenD == JsonToken.FIELD_NAME) {
            String strC = jsonParser.C();
            jsonParser.n1();
            SettableBeanProperty settableBeanPropertyE = propertyBasedCreator.e(strC);
            if (!bVarG.i(strC) || settableBeanPropertyE != null) {
                if (settableBeanPropertyE == null) {
                    SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strC);
                    if (settableBeanPropertyFind != null) {
                        bVarG.e(settableBeanPropertyFind, settableBeanPropertyFind.deserialize(jsonParser, deserializationContext));
                    } else if (IgnorePropertiesUtil.c(strC, this._ignorableProps, this._includableProps)) {
                        handleIgnoredProperty(jsonParser, deserializationContext, handledType(), strC);
                    } else {
                        q33VarBufferForInputBuffering.V0(strC);
                        q33VarBufferForInputBuffering.R1(jsonParser);
                        SettableAnyProperty settableAnyProperty = this._anySetter;
                        if (settableAnyProperty != null) {
                            bVarG.c(settableAnyProperty, strC, settableAnyProperty.deserialize(jsonParser, deserializationContext));
                        }
                    }
                } else if (bVarG.b(settableBeanPropertyE, settableBeanPropertyE.deserialize(jsonParser, deserializationContext))) {
                    jsonParser.n1();
                    try {
                        Object objA = propertyBasedCreator.a(deserializationContext, bVarG);
                        return objA.getClass() != this._beanType.getRawClass() ? handlePolymorphic(jsonParser, deserializationContext, objA, q33VarBufferForInputBuffering) : deserializeWithUnwrapped(jsonParser, deserializationContext, objA, q33VarBufferForInputBuffering);
                    } catch (Exception e) {
                        wrapAndThrow(e, this._beanType.getRawClass(), strC, deserializationContext);
                    }
                } else {
                    continue;
                }
            }
            jsonTokenD = jsonParser.n1();
        }
        q33VarBufferForInputBuffering.S0();
        try {
            return this._unwrappedPropertyHandler.b(jsonParser, deserializationContext, propertyBasedCreator.a(deserializationContext, bVarG), q33VarBufferForInputBuffering);
        } catch (Exception e2) {
            return wrapInstantiationProblem(e2, deserializationContext);
        }
    }

    protected Object deserializeWithExternalTypeId(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return this._propertyBasedCreator != null ? deserializeUsingPropertyBasedWithExternalTypeId(jsonParser, deserializationContext) : deserializeWithExternalTypeId(jsonParser, deserializationContext, this._valueInstantiator.createUsingDefault(deserializationContext));
    }

    protected Object deserializeWithUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        s51 s51Var = this._delegateDeserializer;
        if (s51Var != null) {
            return this._valueInstantiator.createUsingDelegate(deserializationContext, s51Var.deserialize(jsonParser, deserializationContext));
        }
        if (this._propertyBasedCreator != null) {
            return deserializeUsingPropertyBasedWithUnwrapped(jsonParser, deserializationContext);
        }
        q33 q33VarBufferForInputBuffering = deserializationContext.bufferForInputBuffering(jsonParser);
        q33VarBufferForInputBuffering.s1();
        Object objCreateUsingDefault = this._valueInstantiator.createUsingDefault(deserializationContext);
        if (this._injectables != null) {
            injectValues(deserializationContext, objCreateUsingDefault);
        }
        Class<?> activeView = this._needViewProcesing ? deserializationContext.getActiveView() : null;
        while (jsonParser.D() == JsonToken.FIELD_NAME) {
            String strC = jsonParser.C();
            jsonParser.n1();
            SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strC);
            if (settableBeanPropertyFind != null) {
                if (activeView == null || settableBeanPropertyFind.visibleInView(activeView)) {
                    try {
                        objCreateUsingDefault = settableBeanPropertyFind.deserializeSetAndReturn(jsonParser, deserializationContext, objCreateUsingDefault);
                    } catch (Exception e) {
                        wrapAndThrow(e, objCreateUsingDefault, strC, deserializationContext);
                    }
                } else {
                    jsonParser.v1();
                }
            } else if (IgnorePropertiesUtil.c(strC, this._ignorableProps, this._includableProps)) {
                handleIgnoredProperty(jsonParser, deserializationContext, objCreateUsingDefault, strC);
            } else {
                q33VarBufferForInputBuffering.V0(strC);
                q33VarBufferForInputBuffering.R1(jsonParser);
                SettableAnyProperty settableAnyProperty = this._anySetter;
                if (settableAnyProperty != null) {
                    try {
                        settableAnyProperty.deserializeAndSet(jsonParser, deserializationContext, objCreateUsingDefault, strC);
                    } catch (Exception e2) {
                        wrapAndThrow(e2, objCreateUsingDefault, strC, deserializationContext);
                    }
                }
            }
            jsonParser.n1();
        }
        q33VarBufferForInputBuffering.S0();
        return this._unwrappedPropertyHandler.b(jsonParser, deserializationContext, objCreateUsingDefault, q33VarBufferForInputBuffering);
    }

    protected final Object deserializeWithView(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, Class<?> cls) throws IOException {
        JsonToken jsonTokenD = jsonParser.D();
        while (jsonTokenD == JsonToken.FIELD_NAME) {
            String strC = jsonParser.C();
            jsonParser.n1();
            SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strC);
            if (settableBeanPropertyFind == null) {
                handleUnknownVanilla(jsonParser, deserializationContext, obj, strC);
            } else if (settableBeanPropertyFind.visibleInView(cls)) {
                try {
                    obj = settableBeanPropertyFind.deserializeSetAndReturn(jsonParser, deserializationContext, obj);
                } catch (Exception e) {
                    wrapAndThrow(e, obj, strC, deserializationContext);
                }
            } else {
                jsonParser.v1();
            }
            jsonTokenD = jsonParser.n1();
        }
        return obj;
    }

    protected Object finishBuild(DeserializationContext deserializationContext, Object obj) throws IOException {
        AnnotatedMethod annotatedMethod = this._buildMethod;
        if (annotatedMethod == null) {
            return obj;
        }
        try {
            return annotatedMethod.getMember().invoke(obj, null);
        } catch (Exception e) {
            return wrapInstantiationProblem(e, deserializationContext);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase, defpackage.s51
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return Boolean.FALSE;
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase, defpackage.s51
    public s51 unwrappingDeserializer(NameTransformer nameTransformer) {
        return new BuilderBasedDeserializer(this, nameTransformer);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase withBeanProperties(BeanPropertyMap beanPropertyMap) {
        return new BuilderBasedDeserializer(this, beanPropertyMap);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase withByNameInclusion(Set<String> set, Set<String> set2) {
        return new BuilderBasedDeserializer(this, set, set2);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase withIgnoreAllUnknown(boolean z) {
        return new BuilderBasedDeserializer(this, z);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase withObjectIdReader(ObjectIdReader objectIdReader) {
        return new BuilderBasedDeserializer(this, objectIdReader);
    }

    public BuilderBasedDeserializer(lh lhVar, kh khVar, JavaType javaType, BeanPropertyMap beanPropertyMap, Map<String, SettableBeanProperty> map, Set<String> set, boolean z, Set<String> set2, boolean z2) {
        super(lhVar, khVar, beanPropertyMap, map, set, z, set2, z2);
        this._targetType = javaType;
        this._buildMethod = lhVar.r();
        if (this._objectIdReader == null) {
            return;
        }
        throw new IllegalArgumentException("Cannot use Object Id with Builder-based deserialization (type " + khVar.A() + ")");
    }

    protected Object deserializeWithExternalTypeId(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        Class<?> activeView = this._needViewProcesing ? deserializationContext.getActiveView() : null;
        rj0 rj0VarJ = this._externalTypeIdHandler.j();
        JsonToken jsonTokenD = jsonParser.D();
        while (jsonTokenD == JsonToken.FIELD_NAME) {
            String strC = jsonParser.C();
            JsonToken jsonTokenN1 = jsonParser.n1();
            SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strC);
            if (settableBeanPropertyFind != null) {
                if (jsonTokenN1.isScalarValue()) {
                    rj0VarJ.i(jsonParser, deserializationContext, strC, obj);
                }
                if (activeView != null && !settableBeanPropertyFind.visibleInView(activeView)) {
                    jsonParser.v1();
                } else {
                    try {
                        obj = settableBeanPropertyFind.deserializeSetAndReturn(jsonParser, deserializationContext, obj);
                    } catch (Exception e) {
                        wrapAndThrow(e, obj, strC, deserializationContext);
                    }
                }
            } else if (IgnorePropertiesUtil.c(strC, this._ignorableProps, this._includableProps)) {
                handleIgnoredProperty(jsonParser, deserializationContext, obj, strC);
            } else if (!rj0VarJ.h(jsonParser, deserializationContext, strC, obj)) {
                SettableAnyProperty settableAnyProperty = this._anySetter;
                if (settableAnyProperty != null) {
                    try {
                        settableAnyProperty.deserializeAndSet(jsonParser, deserializationContext, obj, strC);
                    } catch (Exception e2) {
                        wrapAndThrow(e2, obj, strC, deserializationContext);
                    }
                } else {
                    handleUnknownProperty(jsonParser, deserializationContext, obj, strC);
                }
            }
            jsonTokenD = jsonParser.n1();
        }
        return rj0VarJ.g(jsonParser, deserializationContext, obj);
    }

    @Deprecated
    public BuilderBasedDeserializer(lh lhVar, kh khVar, BeanPropertyMap beanPropertyMap, Map<String, SettableBeanProperty> map, Set<String> set, boolean z, boolean z2) {
        this(lhVar, khVar, khVar.A(), beanPropertyMap, map, set, z, z2);
    }

    protected BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer) {
        this(builderBasedDeserializer, builderBasedDeserializer._ignoreAllUnknown);
    }

    protected BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, boolean z) {
        super(builderBasedDeserializer, z);
        this._buildMethod = builderBasedDeserializer._buildMethod;
        this._targetType = builderBasedDeserializer._targetType;
    }

    protected BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, NameTransformer nameTransformer) {
        super(builderBasedDeserializer, nameTransformer);
        this._buildMethod = builderBasedDeserializer._buildMethod;
        this._targetType = builderBasedDeserializer._targetType;
    }

    @Override // defpackage.s51
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        JavaType javaType = this._targetType;
        Class<?> clsHandledType = handledType();
        Class<?> cls = obj.getClass();
        if (clsHandledType.isAssignableFrom(cls)) {
            return deserializationContext.reportBadDefinition(javaType, String.format("Deserialization of %s by passing existing Builder (%s) instance not supported", javaType, clsHandledType.getName()));
        }
        return deserializationContext.reportBadDefinition(javaType, String.format("Deserialization of %s by passing existing instance (of %s) not supported", javaType, cls.getName()));
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, ObjectIdReader objectIdReader) {
        super(builderBasedDeserializer, objectIdReader);
        this._buildMethod = builderBasedDeserializer._buildMethod;
        this._targetType = builderBasedDeserializer._targetType;
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, Set<String> set) {
        this(builderBasedDeserializer, set, builderBasedDeserializer._includableProps);
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, Set<String> set, Set<String> set2) {
        super(builderBasedDeserializer, set, set2);
        this._buildMethod = builderBasedDeserializer._buildMethod;
        this._targetType = builderBasedDeserializer._targetType;
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, BeanPropertyMap beanPropertyMap) {
        super(builderBasedDeserializer, beanPropertyMap);
        this._buildMethod = builderBasedDeserializer._buildMethod;
        this._targetType = builderBasedDeserializer._targetType;
    }

    protected Object deserializeWithUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, q33 q33Var) throws IOException {
        Class<?> activeView = this._needViewProcesing ? deserializationContext.getActiveView() : null;
        JsonToken jsonTokenD = jsonParser.D();
        while (jsonTokenD == JsonToken.FIELD_NAME) {
            String strC = jsonParser.C();
            SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strC);
            jsonParser.n1();
            if (settableBeanPropertyFind != null) {
                if (activeView != null && !settableBeanPropertyFind.visibleInView(activeView)) {
                    jsonParser.v1();
                } else {
                    try {
                        obj = settableBeanPropertyFind.deserializeSetAndReturn(jsonParser, deserializationContext, obj);
                    } catch (Exception e) {
                        wrapAndThrow(e, obj, strC, deserializationContext);
                    }
                }
            } else if (IgnorePropertiesUtil.c(strC, this._ignorableProps, this._includableProps)) {
                handleIgnoredProperty(jsonParser, deserializationContext, obj, strC);
            } else {
                q33Var.V0(strC);
                q33Var.R1(jsonParser);
                SettableAnyProperty settableAnyProperty = this._anySetter;
                if (settableAnyProperty != null) {
                    settableAnyProperty.deserializeAndSet(jsonParser, deserializationContext, obj, strC);
                }
            }
            jsonTokenD = jsonParser.n1();
        }
        q33Var.S0();
        return this._unwrappedPropertyHandler.b(jsonParser, deserializationContext, obj, q33Var);
    }
}
