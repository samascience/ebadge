package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.deser.impl.BeanAsArrayDeserializer;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator;
import com.fasterxml.jackson.databind.deser.impl.c;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import com.fasterxml.jackson.databind.util.NameTransformer;
import defpackage.ay;
import defpackage.kh;
import defpackage.lh;
import defpackage.q33;
import defpackage.rj0;
import defpackage.s51;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class BeanDeserializer extends BeanDeserializerBase implements Serializable {
    private static final long serialVersionUID = 1;
    private volatile transient NameTransformer _currentlyTransforming;
    protected transient Exception _nullFromCreator;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[CoercionAction.values().length];
            b = iArr;
            try {
                iArr[CoercionAction.AsEmpty.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[CoercionAction.AsNull.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[CoercionAction.TryConvert.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[JsonToken.values().length];
            a = iArr2;
            try {
                iArr2[JsonToken.VALUE_STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[JsonToken.VALUE_EMBEDDED_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[JsonToken.VALUE_TRUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[JsonToken.VALUE_FALSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[JsonToken.VALUE_NULL.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[JsonToken.START_ARRAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[JsonToken.FIELD_NAME.ordinal()] = 9;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[JsonToken.END_OBJECT.ordinal()] = 10;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    static class b extends c.a {
        private final DeserializationContext c;
        private final SettableBeanProperty d;
        private Object e;

        b(DeserializationContext deserializationContext, UnresolvedForwardReference unresolvedForwardReference, JavaType javaType, com.fasterxml.jackson.databind.deser.impl.b bVar, SettableBeanProperty settableBeanProperty) {
            super(unresolvedForwardReference, javaType);
            this.c = deserializationContext;
            this.d = settableBeanProperty;
        }

        public void c(Object obj) {
            this.e = obj;
        }
    }

    @Deprecated
    public BeanDeserializer(lh lhVar, kh khVar, BeanPropertyMap beanPropertyMap, Map<String, SettableBeanProperty> map, HashSet<String> hashSet, boolean z, boolean z2) {
        super(lhVar, khVar, beanPropertyMap, map, hashSet, z, null, z2);
    }

    private b handleUnresolvedReference(DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty, com.fasterxml.jackson.databind.deser.impl.b bVar, UnresolvedForwardReference unresolvedForwardReference) throws JsonMappingException {
        b bVar2 = new b(deserializationContext, unresolvedForwardReference, settableBeanProperty.getType(), bVar, settableBeanProperty);
        unresolvedForwardReference.getRoid().a(bVar2);
        return bVar2;
    }

    private final Object vanillaDeserialize(JsonParser jsonParser, DeserializationContext deserializationContext, JsonToken jsonToken) throws IOException {
        Object objCreateUsingDefault = this._valueInstantiator.createUsingDefault(deserializationContext);
        jsonParser.s1(objCreateUsingDefault);
        if (jsonParser.e1(5)) {
            String strC = jsonParser.C();
            do {
                jsonParser.n1();
                SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strC);
                if (settableBeanPropertyFind != null) {
                    try {
                        settableBeanPropertyFind.deserializeAndSet(jsonParser, deserializationContext, objCreateUsingDefault);
                    } catch (Exception e) {
                        wrapAndThrow(e, objCreateUsingDefault, strC, deserializationContext);
                    }
                } else {
                    handleUnknownVanilla(jsonParser, deserializationContext, objCreateUsingDefault, strC);
                }
                strC = jsonParser.l1();
            } while (strC != null);
        }
        return objCreateUsingDefault;
    }

    protected Exception _creatorReturnedNullException() {
        if (this._nullFromCreator == null) {
            this._nullFromCreator = new NullPointerException("JSON Creator returned null");
        }
        return this._nullFromCreator;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    protected Object _deserializeFromArray(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        s51 s51Var = this._arrayDelegateDeserializer;
        if (s51Var != null || (s51Var = this._delegateDeserializer) != null) {
            Object objCreateUsingArrayDelegate = this._valueInstantiator.createUsingArrayDelegate(deserializationContext, s51Var.deserialize(jsonParser, deserializationContext));
            if (this._injectables != null) {
                injectValues(deserializationContext, objCreateUsingArrayDelegate);
            }
            return objCreateUsingArrayDelegate;
        }
        CoercionAction coercionAction_findCoercionFromEmptyArray = _findCoercionFromEmptyArray(deserializationContext);
        boolean zIsEnabled = deserializationContext.isEnabled(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS);
        if (zIsEnabled || coercionAction_findCoercionFromEmptyArray != CoercionAction.Fail) {
            JsonToken jsonTokenN1 = jsonParser.n1();
            JsonToken jsonToken = JsonToken.END_ARRAY;
            if (jsonTokenN1 == jsonToken) {
                int i = a.b[coercionAction_findCoercionFromEmptyArray.ordinal()];
                if (i != 1) {
                    return (i == 2 || i == 3) ? getNullValue(deserializationContext) : deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), JsonToken.START_ARRAY, jsonParser, (String) null, new Object[0]);
                }
                return getEmptyValue(deserializationContext);
            }
            if (zIsEnabled) {
                JsonToken jsonToken2 = JsonToken.START_ARRAY;
                if (jsonTokenN1 == jsonToken2) {
                    JavaType valueType = getValueType(deserializationContext);
                    return deserializationContext.handleUnexpectedToken(valueType, jsonToken2, jsonParser, "Cannot deserialize value of type %s from deeply-nested Array: only single wrapper allowed with `%s`", ay.G(valueType), "DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS");
                }
                Object objDeserialize = deserialize(jsonParser, deserializationContext);
                if (jsonParser.n1() != jsonToken) {
                    handleMissingEndArrayForSingle(jsonParser, deserializationContext);
                }
                return objDeserialize;
            }
        }
        return deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
    }

    protected final Object _deserializeOther(JsonParser jsonParser, DeserializationContext deserializationContext, JsonToken jsonToken) throws IOException {
        if (jsonToken != null) {
            switch (a.a[jsonToken.ordinal()]) {
                case 1:
                    return deserializeFromString(jsonParser, deserializationContext);
                case 2:
                    return deserializeFromNumber(jsonParser, deserializationContext);
                case 3:
                    return deserializeFromDouble(jsonParser, deserializationContext);
                case 4:
                    return deserializeFromEmbedded(jsonParser, deserializationContext);
                case 5:
                case 6:
                    return deserializeFromBoolean(jsonParser, deserializationContext);
                case 7:
                    return deserializeFromNull(jsonParser, deserializationContext);
                case 8:
                    return _deserializeFromArray(jsonParser, deserializationContext);
                case 9:
                case 10:
                    if (this._vanillaProcessing) {
                        return vanillaDeserialize(jsonParser, deserializationContext, jsonToken);
                    }
                    return this._objectIdReader != null ? deserializeWithObjectId(jsonParser, deserializationContext) : deserializeFromObject(jsonParser, deserializationContext);
            }
        }
        return deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    protected Object _deserializeUsingPropertyBased(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object objA;
        Object objWrapInstantiationProblem;
        PropertyBasedCreator propertyBasedCreator = this._propertyBasedCreator;
        com.fasterxml.jackson.databind.deser.impl.b bVarG = propertyBasedCreator.g(jsonParser, deserializationContext, this._objectIdReader);
        Class<?> activeView = this._needViewProcesing ? deserializationContext.getActiveView() : null;
        JsonToken jsonTokenD = jsonParser.D();
        ArrayList arrayList = null;
        q33 q33VarBufferForInputBuffering = null;
        while (jsonTokenD == JsonToken.FIELD_NAME) {
            String strC = jsonParser.C();
            jsonParser.n1();
            SettableBeanProperty settableBeanPropertyE = propertyBasedCreator.e(strC);
            if (!bVarG.i(strC) || settableBeanPropertyE != null) {
                if (settableBeanPropertyE == null) {
                    SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strC);
                    if (settableBeanPropertyFind != null) {
                        try {
                            bVarG.e(settableBeanPropertyFind, _deserializeWithErrorWrapping(jsonParser, deserializationContext, settableBeanPropertyFind));
                        } catch (UnresolvedForwardReference e) {
                            b bVarHandleUnresolvedReference = handleUnresolvedReference(deserializationContext, settableBeanPropertyFind, bVarG, e);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(bVarHandleUnresolvedReference);
                        }
                    } else if (IgnorePropertiesUtil.c(strC, this._ignorableProps, this._includableProps)) {
                        handleIgnoredProperty(jsonParser, deserializationContext, handledType(), strC);
                    } else {
                        SettableAnyProperty settableAnyProperty = this._anySetter;
                        if (settableAnyProperty != null) {
                            try {
                                bVarG.c(settableAnyProperty, strC, settableAnyProperty.deserialize(jsonParser, deserializationContext));
                            } catch (Exception e2) {
                                wrapAndThrow(e2, this._beanType.getRawClass(), strC, deserializationContext);
                            }
                        } else if (this._ignoreAllUnknown) {
                            jsonParser.v1();
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
                } else if (bVarG.b(settableBeanPropertyE, _deserializeWithErrorWrapping(jsonParser, deserializationContext, settableBeanPropertyE))) {
                    jsonParser.n1();
                    try {
                        objWrapInstantiationProblem = propertyBasedCreator.a(deserializationContext, bVarG);
                    } catch (Exception e3) {
                        objWrapInstantiationProblem = wrapInstantiationProblem(e3, deserializationContext);
                    }
                    if (objWrapInstantiationProblem == null) {
                        return deserializationContext.handleInstantiationProblem(handledType(), null, _creatorReturnedNullException());
                    }
                    jsonParser.s1(objWrapInstantiationProblem);
                    if (objWrapInstantiationProblem.getClass() != this._beanType.getRawClass()) {
                        return handlePolymorphic(jsonParser, deserializationContext, objWrapInstantiationProblem, q33VarBufferForInputBuffering);
                    }
                    if (q33VarBufferForInputBuffering != null) {
                        objWrapInstantiationProblem = handleUnknownProperties(deserializationContext, objWrapInstantiationProblem, q33VarBufferForInputBuffering);
                    }
                    return deserialize(jsonParser, deserializationContext, objWrapInstantiationProblem);
                }
            }
            jsonTokenD = jsonParser.n1();
        }
        try {
            objA = propertyBasedCreator.a(deserializationContext, bVarG);
        } catch (Exception e4) {
            wrapInstantiationProblem(e4, deserializationContext);
            objA = null;
        }
        if (this._injectables != null) {
            injectValues(deserializationContext, objA);
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).c(objA);
            }
        }
        if (q33VarBufferForInputBuffering != null) {
            return objA.getClass() != this._beanType.getRawClass() ? handlePolymorphic(null, deserializationContext, objA, q33VarBufferForInputBuffering) : handleUnknownProperties(deserializationContext, objA, q33VarBufferForInputBuffering);
        }
        return objA;
    }

    protected final Object _deserializeWithErrorWrapping(JsonParser jsonParser, DeserializationContext deserializationContext, SettableBeanProperty settableBeanProperty) throws IOException {
        try {
            return settableBeanProperty.deserialize(jsonParser, deserializationContext);
        } catch (Exception e) {
            wrapAndThrow(e, this._beanType.getRawClass(), settableBeanProperty.getName(), deserializationContext);
            return null;
        }
    }

    protected Object _deserializeWithExternalTypeId(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, rj0 rj0Var) throws IOException {
        Class<?> activeView = this._needViewProcesing ? deserializationContext.getActiveView() : null;
        JsonToken jsonTokenD = jsonParser.D();
        while (jsonTokenD == JsonToken.FIELD_NAME) {
            String strC = jsonParser.C();
            JsonToken jsonTokenN1 = jsonParser.n1();
            SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strC);
            if (settableBeanPropertyFind != null) {
                if (jsonTokenN1.isScalarValue()) {
                    rj0Var.i(jsonParser, deserializationContext, strC, obj);
                }
                if (activeView == null || settableBeanPropertyFind.visibleInView(activeView)) {
                    try {
                        settableBeanPropertyFind.deserializeAndSet(jsonParser, deserializationContext, obj);
                    } catch (Exception e) {
                        wrapAndThrow(e, obj, strC, deserializationContext);
                    }
                } else {
                    jsonParser.v1();
                }
            } else if (IgnorePropertiesUtil.c(strC, this._ignorableProps, this._includableProps)) {
                handleIgnoredProperty(jsonParser, deserializationContext, obj, strC);
            } else if (!rj0Var.h(jsonParser, deserializationContext, strC, obj)) {
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
        return rj0Var.g(jsonParser, deserializationContext, obj);
    }

    @Deprecated
    protected Object _missingToken(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        throw deserializationContext.endOfInputException(handledType());
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    protected BeanDeserializerBase asArrayDeserializer() {
        return new BeanAsArrayDeserializer(this, this._beanProperties.getPropertiesInInsertionOrder());
    }

    @Override // defpackage.s51
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (!jsonParser.j1()) {
            return _deserializeOther(jsonParser, deserializationContext, jsonParser.D());
        }
        if (this._vanillaProcessing) {
            return vanillaDeserialize(jsonParser, deserializationContext, jsonParser.n1());
        }
        jsonParser.n1();
        return this._objectIdReader != null ? deserializeWithObjectId(jsonParser, deserializationContext) : deserializeFromObject(jsonParser, deserializationContext);
    }

    protected Object deserializeFromNull(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (!jsonParser.r1()) {
            return deserializationContext.handleUnexpectedToken(getValueType(deserializationContext), jsonParser);
        }
        q33 q33VarBufferForInputBuffering = deserializationContext.bufferForInputBuffering(jsonParser);
        q33VarBufferForInputBuffering.S0();
        JsonParser jsonParserP1 = q33VarBufferForInputBuffering.P1(jsonParser);
        jsonParserP1.n1();
        Object objVanillaDeserialize = this._vanillaProcessing ? vanillaDeserialize(jsonParserP1, deserializationContext, JsonToken.END_OBJECT) : deserializeFromObject(jsonParserP1, deserializationContext);
        jsonParserP1.close();
        return objVanillaDeserialize;
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public Object deserializeFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Class<?> activeView;
        Object objO0;
        ObjectIdReader objectIdReader = this._objectIdReader;
        if (objectIdReader != null && objectIdReader.maySerializeAsObject() && jsonParser.e1(5) && this._objectIdReader.isValidReferencePropertyName(jsonParser.C(), jsonParser)) {
            return deserializeFromObjectId(jsonParser, deserializationContext);
        }
        if (this._nonStandardCreation) {
            if (this._unwrappedPropertyHandler != null) {
                return deserializeWithUnwrapped(jsonParser, deserializationContext);
            }
            return this._externalTypeIdHandler != null ? deserializeWithExternalTypeId(jsonParser, deserializationContext) : deserializeFromObjectUsingNonDefault(jsonParser, deserializationContext);
        }
        Object objCreateUsingDefault = this._valueInstantiator.createUsingDefault(deserializationContext);
        jsonParser.s1(objCreateUsingDefault);
        if (jsonParser.u() && (objO0 = jsonParser.O0()) != null) {
            _handleTypedObjectId(jsonParser, deserializationContext, objCreateUsingDefault, objO0);
        }
        if (this._injectables != null) {
            injectValues(deserializationContext, objCreateUsingDefault);
        }
        if (this._needViewProcesing && (activeView = deserializationContext.getActiveView()) != null) {
            return deserializeWithView(jsonParser, deserializationContext, objCreateUsingDefault, activeView);
        }
        if (jsonParser.e1(5)) {
            String strC = jsonParser.C();
            do {
                jsonParser.n1();
                SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strC);
                if (settableBeanPropertyFind != null) {
                    try {
                        settableBeanPropertyFind.deserializeAndSet(jsonParser, deserializationContext, objCreateUsingDefault);
                    } catch (Exception e) {
                        wrapAndThrow(e, objCreateUsingDefault, strC, deserializationContext);
                    }
                } else {
                    handleUnknownVanilla(jsonParser, deserializationContext, objCreateUsingDefault, strC);
                }
                strC = jsonParser.l1();
            } while (strC != null);
        }
        return objCreateUsingDefault;
    }

    protected Object deserializeUsingPropertyBasedWithExternalTypeId(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        rj0 rj0VarJ = this._externalTypeIdHandler.j();
        PropertyBasedCreator propertyBasedCreator = this._propertyBasedCreator;
        com.fasterxml.jackson.databind.deser.impl.b bVarG = propertyBasedCreator.g(jsonParser, deserializationContext, this._objectIdReader);
        Class<?> activeView = this._needViewProcesing ? deserializationContext.getActiveView() : null;
        JsonToken jsonTokenD = jsonParser.D();
        while (jsonTokenD == JsonToken.FIELD_NAME) {
            String strC = jsonParser.C();
            JsonToken jsonTokenN1 = jsonParser.n1();
            SettableBeanProperty settableBeanPropertyE = propertyBasedCreator.e(strC);
            if (!bVarG.i(strC) || settableBeanPropertyE != null) {
                if (settableBeanPropertyE == null) {
                    SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strC);
                    if (settableBeanPropertyFind != null) {
                        if (jsonTokenN1.isScalarValue()) {
                            rj0VarJ.i(jsonParser, deserializationContext, strC, null);
                        }
                        if (activeView == null || settableBeanPropertyFind.visibleInView(activeView)) {
                            bVarG.e(settableBeanPropertyFind, settableBeanPropertyFind.deserialize(jsonParser, deserializationContext));
                        } else {
                            jsonParser.v1();
                        }
                    } else if (!rj0VarJ.h(jsonParser, deserializationContext, strC, null)) {
                        if (IgnorePropertiesUtil.c(strC, this._ignorableProps, this._includableProps)) {
                            handleIgnoredProperty(jsonParser, deserializationContext, handledType(), strC);
                        } else {
                            SettableAnyProperty settableAnyProperty = this._anySetter;
                            if (settableAnyProperty != null) {
                                bVarG.c(settableAnyProperty, strC, settableAnyProperty.deserialize(jsonParser, deserializationContext));
                            } else {
                                handleUnknownProperty(jsonParser, deserializationContext, this._valueClass, strC);
                            }
                        }
                    }
                } else if (!rj0VarJ.h(jsonParser, deserializationContext, strC, null) && bVarG.b(settableBeanPropertyE, _deserializeWithErrorWrapping(jsonParser, deserializationContext, settableBeanPropertyE))) {
                    jsonParser.n1();
                    try {
                        Object objA = propertyBasedCreator.a(deserializationContext, bVarG);
                        if (objA.getClass() == this._beanType.getRawClass()) {
                            return _deserializeWithExternalTypeId(jsonParser, deserializationContext, objA, rj0VarJ);
                        }
                        JavaType javaType = this._beanType;
                        return deserializationContext.reportBadDefinition(javaType, String.format("Cannot create polymorphic instances with external type ids (%s -> %s)", javaType, objA.getClass()));
                    } catch (Exception e) {
                        wrapAndThrow(e, this._beanType.getRawClass(), strC, deserializationContext);
                    }
                }
            }
            jsonTokenD = jsonParser.n1();
        }
        try {
            return rj0VarJ.f(jsonParser, deserializationContext, bVarG, propertyBasedCreator);
        } catch (Exception e2) {
            return wrapInstantiationProblem(e2, deserializationContext);
        }
    }

    protected Object deserializeUsingPropertyBasedWithUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object objWrapInstantiationProblem;
        PropertyBasedCreator propertyBasedCreator = this._propertyBasedCreator;
        com.fasterxml.jackson.databind.deser.impl.b bVarG = propertyBasedCreator.g(jsonParser, deserializationContext, this._objectIdReader);
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
                        bVarG.e(settableBeanPropertyFind, _deserializeWithErrorWrapping(jsonParser, deserializationContext, settableBeanPropertyFind));
                    } else if (IgnorePropertiesUtil.c(strC, this._ignorableProps, this._includableProps)) {
                        handleIgnoredProperty(jsonParser, deserializationContext, handledType(), strC);
                    } else if (this._anySetter == null) {
                        q33VarBufferForInputBuffering.V0(strC);
                        q33VarBufferForInputBuffering.R1(jsonParser);
                    } else {
                        q33 q33VarBufferAsCopyOfValue = deserializationContext.bufferAsCopyOfValue(jsonParser);
                        q33VarBufferForInputBuffering.V0(strC);
                        q33VarBufferForInputBuffering.M1(q33VarBufferAsCopyOfValue);
                        try {
                            SettableAnyProperty settableAnyProperty = this._anySetter;
                            bVarG.c(settableAnyProperty, strC, settableAnyProperty.deserialize(q33VarBufferAsCopyOfValue.Q1(), deserializationContext));
                        } catch (Exception e) {
                            wrapAndThrow(e, this._beanType.getRawClass(), strC, deserializationContext);
                        }
                    }
                } else if (bVarG.b(settableBeanPropertyE, _deserializeWithErrorWrapping(jsonParser, deserializationContext, settableBeanPropertyE))) {
                    JsonToken jsonTokenN1 = jsonParser.n1();
                    try {
                        objWrapInstantiationProblem = propertyBasedCreator.a(deserializationContext, bVarG);
                    } catch (Exception e2) {
                        objWrapInstantiationProblem = wrapInstantiationProblem(e2, deserializationContext);
                    }
                    jsonParser.s1(objWrapInstantiationProblem);
                    while (jsonTokenN1 == JsonToken.FIELD_NAME) {
                        q33VarBufferForInputBuffering.R1(jsonParser);
                        jsonTokenN1 = jsonParser.n1();
                    }
                    JsonToken jsonToken = JsonToken.END_OBJECT;
                    if (jsonTokenN1 != jsonToken) {
                        deserializationContext.reportWrongTokenException(this, jsonToken, "Attempted to unwrap '%s' value", handledType().getName());
                    }
                    q33VarBufferForInputBuffering.S0();
                    if (objWrapInstantiationProblem.getClass() == this._beanType.getRawClass()) {
                        return this._unwrappedPropertyHandler.b(jsonParser, deserializationContext, objWrapInstantiationProblem, q33VarBufferForInputBuffering);
                    }
                    deserializationContext.reportInputMismatch(settableBeanPropertyE, "Cannot create polymorphic instances with unwrapped values", new Object[0]);
                    return null;
                }
            }
            jsonTokenD = jsonParser.n1();
        }
        try {
            return this._unwrappedPropertyHandler.b(jsonParser, deserializationContext, propertyBasedCreator.a(deserializationContext, bVarG), q33VarBufferForInputBuffering);
        } catch (Exception e3) {
            wrapInstantiationProblem(e3, deserializationContext);
            return null;
        }
    }

    protected Object deserializeWithExternalTypeId(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (this._propertyBasedCreator != null) {
            return deserializeUsingPropertyBasedWithExternalTypeId(jsonParser, deserializationContext);
        }
        s51 s51Var = this._delegateDeserializer;
        return s51Var != null ? this._valueInstantiator.createUsingDelegate(deserializationContext, s51Var.deserialize(jsonParser, deserializationContext)) : deserializeWithExternalTypeId(jsonParser, deserializationContext, this._valueInstantiator.createUsingDefault(deserializationContext));
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
        jsonParser.s1(objCreateUsingDefault);
        if (this._injectables != null) {
            injectValues(deserializationContext, objCreateUsingDefault);
        }
        Class<?> activeView = this._needViewProcesing ? deserializationContext.getActiveView() : null;
        String strC = jsonParser.e1(5) ? jsonParser.C() : null;
        while (strC != null) {
            jsonParser.n1();
            SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strC);
            if (settableBeanPropertyFind != null) {
                if (activeView == null || settableBeanPropertyFind.visibleInView(activeView)) {
                    try {
                        settableBeanPropertyFind.deserializeAndSet(jsonParser, deserializationContext, objCreateUsingDefault);
                    } catch (Exception e) {
                        wrapAndThrow(e, objCreateUsingDefault, strC, deserializationContext);
                    }
                } else {
                    jsonParser.v1();
                }
            } else if (IgnorePropertiesUtil.c(strC, this._ignorableProps, this._includableProps)) {
                handleIgnoredProperty(jsonParser, deserializationContext, objCreateUsingDefault, strC);
            } else if (this._anySetter == null) {
                q33VarBufferForInputBuffering.V0(strC);
                q33VarBufferForInputBuffering.R1(jsonParser);
            } else {
                q33 q33VarBufferAsCopyOfValue = deserializationContext.bufferAsCopyOfValue(jsonParser);
                q33VarBufferForInputBuffering.V0(strC);
                q33VarBufferForInputBuffering.M1(q33VarBufferAsCopyOfValue);
                try {
                    this._anySetter.deserializeAndSet(q33VarBufferAsCopyOfValue.Q1(), deserializationContext, objCreateUsingDefault, strC);
                } catch (Exception e2) {
                    wrapAndThrow(e2, objCreateUsingDefault, strC, deserializationContext);
                }
            }
            strC = jsonParser.l1();
        }
        q33VarBufferForInputBuffering.S0();
        this._unwrappedPropertyHandler.b(jsonParser, deserializationContext, objCreateUsingDefault, q33VarBufferForInputBuffering);
        return objCreateUsingDefault;
    }

    protected final Object deserializeWithView(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, Class<?> cls) throws IOException {
        if (jsonParser.e1(5)) {
            String strC = jsonParser.C();
            do {
                jsonParser.n1();
                SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strC);
                if (settableBeanPropertyFind == null) {
                    handleUnknownVanilla(jsonParser, deserializationContext, obj, strC);
                } else if (settableBeanPropertyFind.visibleInView(cls)) {
                    try {
                        settableBeanPropertyFind.deserializeAndSet(jsonParser, deserializationContext, obj);
                    } catch (Exception e) {
                        wrapAndThrow(e, obj, strC, deserializationContext);
                    }
                } else {
                    jsonParser.v1();
                }
                strC = jsonParser.l1();
            } while (strC != null);
        }
        return obj;
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase, defpackage.s51
    public s51 unwrappingDeserializer(NameTransformer nameTransformer) {
        if (getClass() != BeanDeserializer.class || this._currentlyTransforming == nameTransformer) {
            return this;
        }
        this._currentlyTransforming = nameTransformer;
        try {
            return new BeanDeserializer(this, nameTransformer);
        } finally {
            this._currentlyTransforming = null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase withBeanProperties(BeanPropertyMap beanPropertyMap) {
        return new BeanDeserializer(this, beanPropertyMap);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public /* bridge */ /* synthetic */ BeanDeserializerBase withByNameInclusion(Set set, Set set2) {
        return withByNameInclusion((Set<String>) set, (Set<String>) set2);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase withIgnoreAllUnknown(boolean z) {
        return new BeanDeserializer(this, z);
    }

    public BeanDeserializer(lh lhVar, kh khVar, BeanPropertyMap beanPropertyMap, Map<String, SettableBeanProperty> map, HashSet<String> hashSet, boolean z, Set<String> set, boolean z2) {
        super(lhVar, khVar, beanPropertyMap, map, hashSet, z, set, z2);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializer withByNameInclusion(Set<String> set, Set<String> set2) {
        return new BeanDeserializer(this, set, set2);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializer withObjectIdReader(ObjectIdReader objectIdReader) {
        return new BeanDeserializer(this, objectIdReader);
    }

    protected BeanDeserializer(BeanDeserializerBase beanDeserializerBase) {
        super(beanDeserializerBase, beanDeserializerBase._ignoreAllUnknown);
    }

    protected BeanDeserializer(BeanDeserializerBase beanDeserializerBase, boolean z) {
        super(beanDeserializerBase, z);
    }

    protected BeanDeserializer(BeanDeserializerBase beanDeserializerBase, NameTransformer nameTransformer) {
        super(beanDeserializerBase, nameTransformer);
    }

    public BeanDeserializer(BeanDeserializerBase beanDeserializerBase, ObjectIdReader objectIdReader) {
        super(beanDeserializerBase, objectIdReader);
    }

    @Deprecated
    public BeanDeserializer(BeanDeserializerBase beanDeserializerBase, Set<String> set) {
        super(beanDeserializerBase, set);
    }

    public BeanDeserializer(BeanDeserializerBase beanDeserializerBase, Set<String> set, Set<String> set2) {
        super(beanDeserializerBase, set, set2);
    }

    protected Object deserializeWithExternalTypeId(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        return _deserializeWithExternalTypeId(jsonParser, deserializationContext, obj, this._externalTypeIdHandler.j());
    }

    public BeanDeserializer(BeanDeserializerBase beanDeserializerBase, BeanPropertyMap beanPropertyMap) {
        super(beanDeserializerBase, beanPropertyMap);
    }

    @Override // defpackage.s51
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        String strC;
        Class<?> activeView;
        jsonParser.s1(obj);
        if (this._injectables != null) {
            injectValues(deserializationContext, obj);
        }
        if (this._unwrappedPropertyHandler != null) {
            return deserializeWithUnwrapped(jsonParser, deserializationContext, obj);
        }
        if (this._externalTypeIdHandler != null) {
            return deserializeWithExternalTypeId(jsonParser, deserializationContext, obj);
        }
        if (jsonParser.j1()) {
            strC = jsonParser.l1();
            if (strC == null) {
                return obj;
            }
        } else {
            if (jsonParser.e1(5)) {
                strC = jsonParser.C();
            }
            return obj;
        }
        if (this._needViewProcesing && (activeView = deserializationContext.getActiveView()) != null) {
            return deserializeWithView(jsonParser, deserializationContext, obj, activeView);
        }
        do {
            jsonParser.n1();
            SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strC);
            if (settableBeanPropertyFind != null) {
                try {
                    settableBeanPropertyFind.deserializeAndSet(jsonParser, deserializationContext, obj);
                } catch (Exception e) {
                    wrapAndThrow(e, obj, strC, deserializationContext);
                }
            } else {
                handleUnknownVanilla(jsonParser, deserializationContext, obj, strC);
            }
            strC = jsonParser.l1();
        } while (strC != null);
        return obj;
    }

    protected Object deserializeWithUnwrapped(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        JsonToken jsonTokenD = jsonParser.D();
        if (jsonTokenD == JsonToken.START_OBJECT) {
            jsonTokenD = jsonParser.n1();
        }
        q33 q33VarBufferForInputBuffering = deserializationContext.bufferForInputBuffering(jsonParser);
        q33VarBufferForInputBuffering.s1();
        Class<?> activeView = this._needViewProcesing ? deserializationContext.getActiveView() : null;
        while (jsonTokenD == JsonToken.FIELD_NAME) {
            String strC = jsonParser.C();
            SettableBeanProperty settableBeanPropertyFind = this._beanProperties.find(strC);
            jsonParser.n1();
            if (settableBeanPropertyFind != null) {
                if (activeView != null && !settableBeanPropertyFind.visibleInView(activeView)) {
                    jsonParser.v1();
                } else {
                    try {
                        settableBeanPropertyFind.deserializeAndSet(jsonParser, deserializationContext, obj);
                    } catch (Exception e) {
                        wrapAndThrow(e, obj, strC, deserializationContext);
                    }
                }
            } else if (IgnorePropertiesUtil.c(strC, this._ignorableProps, this._includableProps)) {
                handleIgnoredProperty(jsonParser, deserializationContext, obj, strC);
            } else if (this._anySetter == null) {
                q33VarBufferForInputBuffering.V0(strC);
                q33VarBufferForInputBuffering.R1(jsonParser);
            } else {
                q33 q33VarBufferAsCopyOfValue = deserializationContext.bufferAsCopyOfValue(jsonParser);
                q33VarBufferForInputBuffering.V0(strC);
                q33VarBufferForInputBuffering.M1(q33VarBufferAsCopyOfValue);
                try {
                    this._anySetter.deserializeAndSet(q33VarBufferAsCopyOfValue.Q1(), deserializationContext, obj, strC);
                } catch (Exception e2) {
                    wrapAndThrow(e2, obj, strC, deserializationContext);
                }
            }
            jsonTokenD = jsonParser.n1();
        }
        q33VarBufferForInputBuffering.S0();
        this._unwrappedPropertyHandler.b(jsonParser, deserializationContext, obj, q33VarBufferForInputBuffering);
        return obj;
    }
}
