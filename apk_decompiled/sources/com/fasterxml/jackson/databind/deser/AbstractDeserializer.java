package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators$PropertyGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.deser.impl.c;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.type.LogicalType;
import defpackage.ay;
import defpackage.kh;
import defpackage.lh;
import defpackage.lt1;
import defpackage.m63;
import defpackage.s51;
import defpackage.v30;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AbstractDeserializer extends s51 implements v30, Serializable {
    private static final long serialVersionUID = 1;
    protected final boolean _acceptBoolean;
    protected final boolean _acceptDouble;
    protected final boolean _acceptInt;
    protected final boolean _acceptString;
    protected final Map<String, SettableBeanProperty> _backRefProperties;
    protected final JavaType _baseType;
    protected final ObjectIdReader _objectIdReader;
    protected transient Map<String, SettableBeanProperty> _properties;

    public AbstractDeserializer(lh lhVar, kh khVar, Map<String, SettableBeanProperty> map, Map<String, SettableBeanProperty> map2) {
        JavaType javaTypeA = khVar.A();
        this._baseType = javaTypeA;
        this._objectIdReader = lhVar.t();
        this._backRefProperties = map;
        this._properties = map2;
        Class<?> rawClass = javaTypeA.getRawClass();
        this._acceptString = rawClass.isAssignableFrom(String.class);
        boolean z = true;
        this._acceptBoolean = rawClass == Boolean.TYPE || rawClass.isAssignableFrom(Boolean.class);
        this._acceptInt = rawClass == Integer.TYPE || rawClass.isAssignableFrom(Integer.class);
        if (rawClass != Double.TYPE && !rawClass.isAssignableFrom(Double.class)) {
            z = false;
        }
        this._acceptDouble = z;
    }

    public static AbstractDeserializer constructForNonPOJO(kh khVar) {
        return new AbstractDeserializer(khVar);
    }

    protected Object _deserializeFromObjectId(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Object objectReference = this._objectIdReader.readObjectReference(jsonParser, deserializationContext);
        ObjectIdReader objectIdReader = this._objectIdReader;
        ObjectIdGenerator<?> objectIdGenerator = objectIdReader.generator;
        objectIdReader.getClass();
        c cVarFindObjectId = deserializationContext.findObjectId(objectReference, objectIdGenerator, null);
        Object objF = cVarFindObjectId.f();
        if (objF != null) {
            return objF;
        }
        throw new UnresolvedForwardReference(jsonParser, "Could not resolve Object Id [" + objectReference + "] -- unresolved forward-reference?", jsonParser.w0(), cVarFindObjectId);
    }

    protected Object _deserializeIfNatural(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        switch (jsonParser.V()) {
            case 6:
                if (this._acceptString) {
                    return jsonParser.S0();
                }
                return null;
            case 7:
                if (this._acceptInt) {
                    return Integer.valueOf(jsonParser.J0());
                }
                return null;
            case 8:
                if (this._acceptDouble) {
                    return Double.valueOf(jsonParser.G0());
                }
                return null;
            case 9:
                if (this._acceptBoolean) {
                    return Boolean.TRUE;
                }
                return null;
            case 10:
                if (this._acceptBoolean) {
                    return Boolean.FALSE;
                }
                return null;
            default:
                return null;
        }
    }

    @Override // defpackage.v30
    public s51 createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        AnnotatedMember member;
        lt1 lt1VarFindObjectIdInfo;
        ObjectIdGenerator<?> objectIdGeneratorObjectIdGeneratorInstance;
        SettableBeanProperty settableBeanProperty;
        JavaType javaType;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (beanProperty == null || annotationIntrospector == null || (member = beanProperty.getMember()) == null || (lt1VarFindObjectIdInfo = annotationIntrospector.findObjectIdInfo(member)) == null) {
            return this._properties == null ? this : new AbstractDeserializer(this, this._objectIdReader, (Map<String, SettableBeanProperty>) null);
        }
        deserializationContext.objectIdResolverInstance(member, lt1VarFindObjectIdInfo);
        lt1 lt1VarFindObjectReferenceInfo = annotationIntrospector.findObjectReferenceInfo(member, lt1VarFindObjectIdInfo);
        Class clsC = lt1VarFindObjectReferenceInfo.c();
        if (clsC == ObjectIdGenerators$PropertyGenerator.class) {
            PropertyName propertyNameD = lt1VarFindObjectReferenceInfo.d();
            Map<String, SettableBeanProperty> map = this._properties;
            SettableBeanProperty settableBeanProperty2 = map == null ? null : map.get(propertyNameD.getSimpleName());
            if (settableBeanProperty2 == null) {
                deserializationContext.reportBadDefinition(this._baseType, String.format("Invalid Object Id definition for %s: cannot find property with name %s", ay.X(handledType()), ay.U(propertyNameD)));
            }
            JavaType type = settableBeanProperty2.getType();
            objectIdGeneratorObjectIdGeneratorInstance = new PropertyBasedObjectIdGenerator(lt1VarFindObjectReferenceInfo.f());
            javaType = type;
            settableBeanProperty = settableBeanProperty2;
        } else {
            deserializationContext.objectIdResolverInstance(member, lt1VarFindObjectReferenceInfo);
            JavaType javaType2 = deserializationContext.getTypeFactory().findTypeParameters(deserializationContext.constructType((Class<?>) clsC), ObjectIdGenerator.class)[0];
            objectIdGeneratorObjectIdGeneratorInstance = deserializationContext.objectIdGeneratorInstance(member, lt1VarFindObjectReferenceInfo);
            settableBeanProperty = null;
            javaType = javaType2;
        }
        return new AbstractDeserializer(this, ObjectIdReader.construct(javaType, lt1VarFindObjectReferenceInfo.d(), objectIdGeneratorObjectIdGeneratorInstance, deserializationContext.findRootValueDeserializer(javaType), settableBeanProperty, null), (Map<String, SettableBeanProperty>) null);
    }

    @Override // defpackage.s51
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return deserializationContext.handleMissingInstantiator(this._baseType.getRawClass(), new ValueInstantiator.Base(this._baseType), jsonParser, "abstract types either need to be mapped to concrete types, have custom deserializer, or contain additional type information", new Object[0]);
    }

    @Override // defpackage.s51
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, m63 m63Var) throws IOException {
        JsonToken jsonTokenD;
        if (this._objectIdReader != null && (jsonTokenD = jsonParser.D()) != null) {
            if (jsonTokenD.isScalarValue()) {
                return _deserializeFromObjectId(jsonParser, deserializationContext);
            }
            if (jsonTokenD == JsonToken.START_OBJECT) {
                jsonTokenD = jsonParser.n1();
            }
            if (jsonTokenD == JsonToken.FIELD_NAME && this._objectIdReader.maySerializeAsObject() && this._objectIdReader.isValidReferencePropertyName(jsonParser.C(), jsonParser)) {
                return _deserializeFromObjectId(jsonParser, deserializationContext);
            }
        }
        Object obj_deserializeIfNatural = _deserializeIfNatural(jsonParser, deserializationContext);
        return obj_deserializeIfNatural != null ? obj_deserializeIfNatural : m63Var.deserializeTypedFromObject(jsonParser, deserializationContext);
    }

    @Override // defpackage.s51
    public SettableBeanProperty findBackReference(String str) {
        Map<String, SettableBeanProperty> map = this._backRefProperties;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // defpackage.s51
    public ObjectIdReader getObjectIdReader() {
        return this._objectIdReader;
    }

    @Override // defpackage.s51
    public Class<?> handledType() {
        return this._baseType.getRawClass();
    }

    @Override // defpackage.s51
    public boolean isCachable() {
        return true;
    }

    @Override // defpackage.s51
    public LogicalType logicalType() {
        return LogicalType.POJO;
    }

    @Override // defpackage.s51
    public Boolean supportsUpdate(DeserializationConfig deserializationConfig) {
        return null;
    }

    @Deprecated
    public AbstractDeserializer(lh lhVar, kh khVar, Map<String, SettableBeanProperty> map) {
        this(lhVar, khVar, map, null);
    }

    protected AbstractDeserializer(kh khVar) {
        JavaType javaTypeA = khVar.A();
        this._baseType = javaTypeA;
        this._objectIdReader = null;
        this._backRefProperties = null;
        Class<?> rawClass = javaTypeA.getRawClass();
        this._acceptString = rawClass.isAssignableFrom(String.class);
        boolean z = true;
        this._acceptBoolean = rawClass == Boolean.TYPE || rawClass.isAssignableFrom(Boolean.class);
        this._acceptInt = rawClass == Integer.TYPE || rawClass.isAssignableFrom(Integer.class);
        if (rawClass != Double.TYPE && !rawClass.isAssignableFrom(Double.class)) {
            z = false;
        }
        this._acceptDouble = z;
    }

    protected AbstractDeserializer(AbstractDeserializer abstractDeserializer, ObjectIdReader objectIdReader, Map<String, SettableBeanProperty> map) {
        this._baseType = abstractDeserializer._baseType;
        this._backRefProperties = abstractDeserializer._backRefProperties;
        this._acceptString = abstractDeserializer._acceptString;
        this._acceptBoolean = abstractDeserializer._acceptBoolean;
        this._acceptInt = abstractDeserializer._acceptInt;
        this._acceptDouble = abstractDeserializer._acceptDouble;
        this._objectIdReader = objectIdReader;
        this._properties = map;
    }
}
