package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators$PropertyGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.tencent.connect.common.Constants;
import defpackage.an2;
import defpackage.ay;
import defpackage.cg2;
import defpackage.e71;
import defpackage.f40;
import defpackage.f71;
import defpackage.i82;
import defpackage.jl3;
import defpackage.lt1;
import defpackage.m7;
import defpackage.mt1;
import defpackage.p9;
import defpackage.tk2;
import defpackage.w30;
import defpackage.y51;
import defpackage.z63;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class BeanSerializerBase extends StdSerializer<Object> implements w30, cg2, tk2 {
    protected static final PropertyName NAME_FOR_OBJECT_REF = new PropertyName("#object-ref");
    protected static final BeanPropertyWriter[] NO_PROPS = new BeanPropertyWriter[0];
    protected final m7 _anyGetterWriter;
    protected final JavaType _beanType;
    protected final BeanPropertyWriter[] _filteredProps;
    protected final mt1 _objectIdWriter;
    protected final Object _propertyFilterId;
    protected final BeanPropertyWriter[] _props;
    protected final JsonFormat.Shape _serializationShape;
    protected final AnnotatedMember _typeId;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonFormat.Shape.values().length];
            a = iArr;
            try {
                iArr[JsonFormat.Shape.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonFormat.Shape.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonFormat.Shape.NUMBER_INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    protected BeanSerializerBase(JavaType javaType, com.fasterxml.jackson.databind.ser.a aVar, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        super(javaType);
        this._beanType = javaType;
        this._props = beanPropertyWriterArr;
        this._filteredProps = beanPropertyWriterArr2;
        if (aVar == null) {
            this._typeId = null;
            this._anyGetterWriter = null;
            this._propertyFilterId = null;
            this._objectIdWriter = null;
            this._serializationShape = null;
            return;
        }
        this._typeId = aVar.h();
        this._anyGetterWriter = aVar.c();
        this._propertyFilterId = aVar.e();
        this._objectIdWriter = aVar.f();
        this._serializationShape = aVar.d().g(null).getShape();
    }

    private static final BeanPropertyWriter[] rename(BeanPropertyWriter[] beanPropertyWriterArr, NameTransformer nameTransformer) {
        if (beanPropertyWriterArr == null || beanPropertyWriterArr.length == 0 || nameTransformer == null || nameTransformer == NameTransformer.NOP) {
            return beanPropertyWriterArr;
        }
        int length = beanPropertyWriterArr.length;
        BeanPropertyWriter[] beanPropertyWriterArr2 = new BeanPropertyWriter[length];
        for (int i = 0; i < length; i++) {
            BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
            if (beanPropertyWriter != null) {
                beanPropertyWriterArr2[i] = beanPropertyWriter.rename(nameTransformer);
            }
        }
        return beanPropertyWriterArr2;
    }

    @Deprecated
    protected final String _customTypeId(Object obj) {
        Object value = this._typeId.getValue(obj);
        if (value == null) {
            return Constants.STR_EMPTY;
        }
        return value instanceof String ? (String) value : value.toString();
    }

    protected void _serializeObjectId(Object obj, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var, jl3 jl3Var) throws IOException {
        mt1 mt1Var = this._objectIdWriter;
        WritableTypeId writableTypeId_typeIdDef = _typeIdDef(z63Var, obj, JsonToken.START_OBJECT);
        z63Var.g(jsonGenerator, writableTypeId_typeIdDef);
        jsonGenerator.y0(obj);
        jl3Var.b(jsonGenerator, an2Var, mt1Var);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, jsonGenerator, an2Var);
        } else {
            serializeFields(obj, jsonGenerator, an2Var);
        }
        z63Var.h(jsonGenerator, writableTypeId_typeIdDef);
    }

    protected final void _serializeWithObjectId(Object obj, JsonGenerator jsonGenerator, an2 an2Var, boolean z) throws IOException {
        mt1 mt1Var = this._objectIdWriter;
        jl3 jl3VarFindObjectId = an2Var.findObjectId(obj, mt1Var.c);
        if (jl3VarFindObjectId.c(jsonGenerator, an2Var, mt1Var)) {
            return;
        }
        Object objA = jl3VarFindObjectId.a(obj);
        if (mt1Var.e) {
            mt1Var.d.serialize(objA, jsonGenerator, an2Var);
            return;
        }
        if (z) {
            jsonGenerator.t1(obj);
        }
        jl3VarFindObjectId.b(jsonGenerator, an2Var, mt1Var);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, jsonGenerator, an2Var);
        } else {
            serializeFields(obj, jsonGenerator, an2Var);
        }
        if (z) {
            jsonGenerator.S0();
        }
    }

    protected final WritableTypeId _typeIdDef(z63 z63Var, Object obj, JsonToken jsonToken) {
        AnnotatedMember annotatedMember = this._typeId;
        if (annotatedMember == null) {
            return z63Var.d(obj, jsonToken);
        }
        Object value = annotatedMember.getValue(obj);
        if (value == null) {
            value = Constants.STR_EMPTY;
        }
        return z63Var.e(obj, jsonToken, value);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        if (y51Var == null) {
            return;
        }
        y51Var.j(javaType);
    }

    protected abstract BeanSerializerBase asArraySerializer();

    @Override // defpackage.w30
    public f71 createContextual(an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.Shape shape;
        Object objFindFilterId;
        Set<String> included;
        Set<String> setFindIgnoredForSerialization;
        int i;
        BeanSerializerBase beanSerializerBaseWithFilterId;
        mt1 mt1VarC;
        BeanPropertyWriter beanPropertyWriter;
        Object obj;
        lt1 lt1VarFindObjectReferenceInfo;
        AnnotationIntrospector annotationIntrospector = an2Var.getAnnotationIntrospector();
        BeanPropertyWriter[] beanPropertyWriterArr = null;
        AnnotatedMember member = (beanProperty == null || annotationIntrospector == null) ? null : beanProperty.getMember();
        SerializationConfig config = an2Var.getConfig();
        JsonFormat.Value valueFindFormatOverrides = findFormatOverrides(an2Var, beanProperty, this._handledType);
        if (valueFindFormatOverrides == null || !valueFindFormatOverrides.hasShape()) {
            shape = null;
        } else {
            shape = valueFindFormatOverrides.getShape();
            if (shape != JsonFormat.Shape.ANY && shape != this._serializationShape) {
                if (this._beanType.isEnumType()) {
                    int i2 = a.a[shape.ordinal()];
                    if (i2 == 1 || i2 == 2 || i2 == 3) {
                        return an2Var.handlePrimaryContextualization(EnumSerializer.construct(this._beanType.getRawClass(), an2Var.getConfig(), config.introspectClassAnnotations(this._beanType), valueFindFormatOverrides), beanProperty);
                    }
                } else if (shape == JsonFormat.Shape.NATURAL && ((!this._beanType.isMapLikeType() || !Map.class.isAssignableFrom(this._handledType)) && Map.Entry.class.isAssignableFrom(this._handledType))) {
                    JavaType javaTypeFindSuperType = this._beanType.findSuperType(Map.Entry.class);
                    return an2Var.handlePrimaryContextualization(new MapEntrySerializer(this._beanType, javaTypeFindSuperType.containedTypeOrUnknown(0), javaTypeFindSuperType.containedTypeOrUnknown(1), false, null, beanProperty), beanProperty);
                }
            }
        }
        mt1 mt1VarA = this._objectIdWriter;
        if (member != null) {
            setFindIgnoredForSerialization = annotationIntrospector.findPropertyIgnoralByName(config, member).findIgnoredForSerialization();
            included = annotationIntrospector.findPropertyInclusionByName(config, member).getIncluded();
            lt1 lt1VarFindObjectIdInfo = annotationIntrospector.findObjectIdInfo(member);
            if (lt1VarFindObjectIdInfo == null) {
                if (mt1VarA != null && (lt1VarFindObjectReferenceInfo = annotationIntrospector.findObjectReferenceInfo(member, null)) != null) {
                    mt1VarA = this._objectIdWriter.b(lt1VarFindObjectReferenceInfo.b());
                }
                i = 0;
            } else {
                lt1 lt1VarFindObjectReferenceInfo2 = annotationIntrospector.findObjectReferenceInfo(member, lt1VarFindObjectIdInfo);
                Class clsC = lt1VarFindObjectReferenceInfo2.c();
                JavaType javaType = an2Var.getTypeFactory().findTypeParameters(an2Var.constructType(clsC), ObjectIdGenerator.class)[0];
                if (clsC == ObjectIdGenerators$PropertyGenerator.class) {
                    String simpleName = lt1VarFindObjectReferenceInfo2.d().getSimpleName();
                    int length = this._props.length;
                    i = 0;
                    while (true) {
                        if (i == length) {
                            an2Var.reportBadDefinition(this._beanType, String.format("Invalid Object Id definition for %s: cannot find property with name %s", ay.X(handledType()), ay.V(simpleName)));
                        }
                        beanPropertyWriter = this._props[i];
                        if (simpleName.equals(beanPropertyWriter.getName())) {
                            break;
                        }
                        i++;
                    }
                    mt1VarA = mt1.a(beanPropertyWriter.getType(), null, new PropertyBasedObjectIdGenerator(lt1VarFindObjectReferenceInfo2, beanPropertyWriter), lt1VarFindObjectReferenceInfo2.b());
                } else {
                    mt1VarA = mt1.a(javaType, lt1VarFindObjectReferenceInfo2.d(), an2Var.objectIdGeneratorInstance(member, lt1VarFindObjectReferenceInfo2), lt1VarFindObjectReferenceInfo2.b());
                    i = 0;
                }
            }
            objFindFilterId = annotationIntrospector.findFilterId(member);
            if (objFindFilterId == null || ((obj = this._propertyFilterId) != null && objFindFilterId.equals(obj))) {
                objFindFilterId = null;
            }
        } else {
            objFindFilterId = null;
            included = null;
            setFindIgnoredForSerialization = null;
            i = 0;
        }
        if (i > 0) {
            BeanPropertyWriter[] beanPropertyWriterArr2 = this._props;
            BeanPropertyWriter[] beanPropertyWriterArr3 = (BeanPropertyWriter[]) Arrays.copyOf(beanPropertyWriterArr2, beanPropertyWriterArr2.length);
            BeanPropertyWriter beanPropertyWriter2 = beanPropertyWriterArr3[i];
            System.arraycopy(beanPropertyWriterArr3, 0, beanPropertyWriterArr3, 1, i);
            beanPropertyWriterArr3[0] = beanPropertyWriter2;
            BeanPropertyWriter[] beanPropertyWriterArr4 = this._filteredProps;
            if (beanPropertyWriterArr4 != null) {
                beanPropertyWriterArr = (BeanPropertyWriter[]) Arrays.copyOf(beanPropertyWriterArr4, beanPropertyWriterArr4.length);
                BeanPropertyWriter beanPropertyWriter3 = beanPropertyWriterArr[i];
                System.arraycopy(beanPropertyWriterArr, 0, beanPropertyWriterArr, 1, i);
                beanPropertyWriterArr[0] = beanPropertyWriter3;
            }
            beanSerializerBaseWithFilterId = withProperties(beanPropertyWriterArr3, beanPropertyWriterArr);
        } else {
            beanSerializerBaseWithFilterId = this;
        }
        if (mt1VarA != null && (mt1VarC = mt1VarA.c(an2Var.findValueSerializer(mt1VarA.a, beanProperty))) != this._objectIdWriter) {
            beanSerializerBaseWithFilterId = beanSerializerBaseWithFilterId.withObjectIdWriter(mt1VarC);
        }
        if ((setFindIgnoredForSerialization != null && !setFindIgnoredForSerialization.isEmpty()) || included != null) {
            beanSerializerBaseWithFilterId = beanSerializerBaseWithFilterId.withByNameInclusion(setFindIgnoredForSerialization, included);
        }
        if (objFindFilterId != null) {
            beanSerializerBaseWithFilterId = beanSerializerBaseWithFilterId.withFilterId(objFindFilterId);
        }
        if (shape == null) {
            shape = this._serializationShape;
        }
        return shape == JsonFormat.Shape.ARRAY ? beanSerializerBaseWithFilterId.asArraySerializer() : beanSerializerBaseWithFilterId;
    }

    protected f71 findConvertingSerializer(an2 an2Var, BeanPropertyWriter beanPropertyWriter) throws JsonMappingException {
        AnnotatedMember member;
        Object objFindSerializationConverter;
        AnnotationIntrospector annotationIntrospector = an2Var.getAnnotationIntrospector();
        if (annotationIntrospector == null || (member = beanPropertyWriter.getMember()) == null || (objFindSerializationConverter = annotationIntrospector.findSerializationConverter(member)) == null) {
            return null;
        }
        f40 f40VarConverterInstance = an2Var.converterInstance(beanPropertyWriter.getMember(), objFindSerializationConverter);
        JavaType javaTypeB = f40VarConverterInstance.b(an2Var.getTypeFactory());
        return new StdDelegatingSerializer(f40VarConverterInstance, javaTypeB, javaTypeB.isJavaLangObject() ? null : an2Var.findValueSerializer(javaTypeB, beanPropertyWriter));
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.tk2
    @Deprecated
    public JsonNode getSchema(an2 an2Var, Type type) throws JsonMappingException {
        String strId;
        ObjectNode objectNodeCreateSchemaNode = createSchemaNode("object", true);
        e71 e71Var = (e71) this._handledType.getAnnotation(e71.class);
        if (e71Var != null && (strId = e71Var.id()) != null && !strId.isEmpty()) {
            objectNodeCreateSchemaNode.put("id", strId);
        }
        ObjectNode objectNode = objectNodeCreateSchemaNode.objectNode();
        Object obj = this._propertyFilterId;
        i82 i82VarFindPropertyFilter = obj != null ? findPropertyFilter(an2Var, obj, null) : null;
        int i = 0;
        while (true) {
            BeanPropertyWriter[] beanPropertyWriterArr = this._props;
            if (i >= beanPropertyWriterArr.length) {
                objectNodeCreateSchemaNode.set("properties", objectNode);
                return objectNodeCreateSchemaNode;
            }
            BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
            if (i82VarFindPropertyFilter == null) {
                beanPropertyWriter.depositSchemaProperty(objectNode, an2Var);
            } else {
                i82VarFindPropertyFilter.depositSchemaProperty(beanPropertyWriter, objectNode, an2Var);
            }
            i++;
        }
    }

    @Override // defpackage.f71
    public Iterator<PropertyWriter> properties() {
        return Arrays.asList(this._props).iterator();
    }

    /* JADX WARN: Code duplicated, block: B:45:0x008c  */
    @Override // defpackage.cg2
    public void resolve(an2 an2Var) throws JsonMappingException {
        BeanPropertyWriter beanPropertyWriter;
        z63 z63Var;
        f71 f71VarFindNullValueSerializer;
        BeanPropertyWriter beanPropertyWriter2;
        BeanPropertyWriter[] beanPropertyWriterArr = this._filteredProps;
        int length = beanPropertyWriterArr == null ? 0 : beanPropertyWriterArr.length;
        int length2 = this._props.length;
        for (int i = 0; i < length2; i++) {
            BeanPropertyWriter beanPropertyWriter3 = this._props[i];
            if (!beanPropertyWriter3.willSuppressNulls() && !beanPropertyWriter3.hasNullSerializer() && (f71VarFindNullValueSerializer = an2Var.findNullValueSerializer(beanPropertyWriter3)) != null) {
                beanPropertyWriter3.assignNullSerializer(f71VarFindNullValueSerializer);
                if (i < length && (beanPropertyWriter2 = this._filteredProps[i]) != null) {
                    beanPropertyWriter2.assignNullSerializer(f71VarFindNullValueSerializer);
                }
            }
            if (!beanPropertyWriter3.hasSerializer()) {
                f71 f71VarFindConvertingSerializer = findConvertingSerializer(an2Var, beanPropertyWriter3);
                if (f71VarFindConvertingSerializer == null) {
                    JavaType serializationType = beanPropertyWriter3.getSerializationType();
                    if (serializationType == null) {
                        serializationType = beanPropertyWriter3.getType();
                        if (!serializationType.isFinal()) {
                            if (serializationType.isContainerType() || serializationType.containedTypeCount() > 0) {
                                beanPropertyWriter3.setNonTrivialBaseType(serializationType);
                            }
                        }
                    }
                    f71 f71VarFindValueSerializer = an2Var.findValueSerializer(serializationType, beanPropertyWriter3);
                    f71VarFindConvertingSerializer = (serializationType.isContainerType() && (z63Var = (z63) serializationType.mo15getContentType().getTypeHandler()) != null && (f71VarFindValueSerializer instanceof ContainerSerializer)) ? ((ContainerSerializer) f71VarFindValueSerializer).withValueTypeSerializer(z63Var) : f71VarFindValueSerializer;
                    if (i < length) {
                        beanPropertyWriter3.assignSerializer(f71VarFindConvertingSerializer);
                    } else {
                        beanPropertyWriter3.assignSerializer(f71VarFindConvertingSerializer);
                    }
                } else if (i < length || (beanPropertyWriter = this._filteredProps[i]) == null) {
                    beanPropertyWriter3.assignSerializer(f71VarFindConvertingSerializer);
                } else {
                    beanPropertyWriter.assignSerializer(f71VarFindConvertingSerializer);
                }
            }
        }
        m7 m7Var = this._anyGetterWriter;
        if (m7Var != null) {
            m7Var.d(an2Var);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public abstract void serialize(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException;

    protected void serializeFields(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        BeanPropertyWriter[] beanPropertyWriterArr = (this._filteredProps == null || an2Var.getActiveView() == null) ? this._props : this._filteredProps;
        int i = 0;
        try {
            int length = beanPropertyWriterArr.length;
            while (i < length) {
                BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
                if (beanPropertyWriter != null) {
                    beanPropertyWriter.serializeAsField(obj, jsonGenerator, an2Var);
                }
                i++;
            }
            m7 m7Var = this._anyGetterWriter;
            if (m7Var != null) {
                m7Var.c(obj, jsonGenerator, an2Var);
            }
        } catch (Exception e) {
            wrapAndThrow(an2Var, e, obj, i != beanPropertyWriterArr.length ? beanPropertyWriterArr[i].getName() : "[anySetter]");
        } catch (StackOverflowError e2) {
            JsonMappingException jsonMappingException = new JsonMappingException(jsonGenerator, "Infinite recursion (StackOverflowError)", e2);
            jsonMappingException.prependPath(obj, i != beanPropertyWriterArr.length ? beanPropertyWriterArr[i].getName() : "[anySetter]");
            throw jsonMappingException;
        }
    }

    protected void serializeFieldsFiltered(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        BeanPropertyWriter[] beanPropertyWriterArr = (this._filteredProps == null || an2Var.getActiveView() == null) ? this._props : this._filteredProps;
        i82 i82VarFindPropertyFilter = findPropertyFilter(an2Var, this._propertyFilterId, obj);
        if (i82VarFindPropertyFilter == null) {
            serializeFields(obj, jsonGenerator, an2Var);
            return;
        }
        int i = 0;
        try {
            int length = beanPropertyWriterArr.length;
            while (i < length) {
                BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
                if (beanPropertyWriter != null) {
                    i82VarFindPropertyFilter.serializeAsField(obj, jsonGenerator, an2Var, beanPropertyWriter);
                }
                i++;
            }
            m7 m7Var = this._anyGetterWriter;
            if (m7Var != null) {
                m7Var.b(obj, jsonGenerator, an2Var, i82VarFindPropertyFilter);
            }
        } catch (Exception e) {
            wrapAndThrow(an2Var, e, obj, i != beanPropertyWriterArr.length ? beanPropertyWriterArr[i].getName() : "[anySetter]");
        } catch (StackOverflowError e2) {
            JsonMappingException jsonMappingException = new JsonMappingException(jsonGenerator, "Infinite recursion (StackOverflowError)", e2);
            jsonMappingException.prependPath(obj, i != beanPropertyWriterArr.length ? beanPropertyWriterArr[i].getName() : "[anySetter]");
            throw jsonMappingException;
        }
    }

    @Override // defpackage.f71
    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        if (this._objectIdWriter != null) {
            _serializeWithObjectId(obj, jsonGenerator, an2Var, z63Var);
            return;
        }
        WritableTypeId writableTypeId_typeIdDef = _typeIdDef(z63Var, obj, JsonToken.START_OBJECT);
        z63Var.g(jsonGenerator, writableTypeId_typeIdDef);
        jsonGenerator.y0(obj);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, jsonGenerator, an2Var);
        } else {
            serializeFields(obj, jsonGenerator, an2Var);
        }
        z63Var.h(jsonGenerator, writableTypeId_typeIdDef);
    }

    @Override // defpackage.f71
    public boolean usesObjectId() {
        return this._objectIdWriter != null;
    }

    protected abstract BeanSerializerBase withByNameInclusion(Set<String> set, Set<String> set2);

    @Override // defpackage.f71
    public abstract BeanSerializerBase withFilterId(Object obj);

    @Deprecated
    protected BeanSerializerBase withIgnorals(Set<String> set) {
        return withByNameInclusion(set, null);
    }

    public abstract BeanSerializerBase withObjectIdWriter(mt1 mt1Var);

    protected abstract BeanSerializerBase withProperties(BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2);

    @Deprecated
    protected BeanSerializerBase withIgnorals(String[] strArr) {
        return withIgnorals(p9.a(strArr));
    }

    protected final void _serializeWithObjectId(Object obj, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        mt1 mt1Var = this._objectIdWriter;
        jl3 jl3VarFindObjectId = an2Var.findObjectId(obj, mt1Var.c);
        if (jl3VarFindObjectId.c(jsonGenerator, an2Var, mt1Var)) {
            return;
        }
        Object objA = jl3VarFindObjectId.a(obj);
        if (mt1Var.e) {
            mt1Var.d.serialize(objA, jsonGenerator, an2Var);
        } else {
            _serializeObjectId(obj, jsonGenerator, an2Var, z63Var, jl3VarFindObjectId);
        }
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        super(beanSerializerBase._handledType);
        this._beanType = beanSerializerBase._beanType;
        this._props = beanPropertyWriterArr;
        this._filteredProps = beanPropertyWriterArr2;
        this._typeId = beanSerializerBase._typeId;
        this._anyGetterWriter = beanSerializerBase._anyGetterWriter;
        this._objectIdWriter = beanSerializerBase._objectIdWriter;
        this._propertyFilterId = beanSerializerBase._propertyFilterId;
        this._serializationShape = beanSerializerBase._serializationShape;
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, mt1 mt1Var) {
        this(beanSerializerBase, mt1Var, beanSerializerBase._propertyFilterId);
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, mt1 mt1Var, Object obj) {
        super(beanSerializerBase._handledType);
        this._beanType = beanSerializerBase._beanType;
        this._props = beanSerializerBase._props;
        this._filteredProps = beanSerializerBase._filteredProps;
        this._typeId = beanSerializerBase._typeId;
        this._anyGetterWriter = beanSerializerBase._anyGetterWriter;
        this._objectIdWriter = mt1Var;
        this._propertyFilterId = obj;
        this._serializationShape = beanSerializerBase._serializationShape;
    }

    @Deprecated
    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, String[] strArr) {
        this(beanSerializerBase, p9.a(strArr), (Set<String>) null);
    }

    @Deprecated
    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, Set<String> set) {
        this(beanSerializerBase, set, (Set<String>) null);
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, Set<String> set, Set<String> set2) {
        super(beanSerializerBase._handledType);
        this._beanType = beanSerializerBase._beanType;
        BeanPropertyWriter[] beanPropertyWriterArr = beanSerializerBase._props;
        BeanPropertyWriter[] beanPropertyWriterArr2 = beanSerializerBase._filteredProps;
        int length = beanPropertyWriterArr.length;
        ArrayList arrayList = new ArrayList(length);
        ArrayList arrayList2 = beanPropertyWriterArr2 == null ? null : new ArrayList(length);
        for (int i = 0; i < length; i++) {
            BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
            if (!IgnorePropertiesUtil.c(beanPropertyWriter.getName(), set, set2)) {
                arrayList.add(beanPropertyWriter);
                if (beanPropertyWriterArr2 != null) {
                    arrayList2.add(beanPropertyWriterArr2[i]);
                }
            }
        }
        this._props = (BeanPropertyWriter[]) arrayList.toArray(new BeanPropertyWriter[arrayList.size()]);
        this._filteredProps = arrayList2 != null ? (BeanPropertyWriter[]) arrayList2.toArray(new BeanPropertyWriter[arrayList2.size()]) : null;
        this._typeId = beanSerializerBase._typeId;
        this._anyGetterWriter = beanSerializerBase._anyGetterWriter;
        this._objectIdWriter = beanSerializerBase._objectIdWriter;
        this._propertyFilterId = beanSerializerBase._propertyFilterId;
        this._serializationShape = beanSerializerBase._serializationShape;
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase) {
        this(beanSerializerBase, beanSerializerBase._props, beanSerializerBase._filteredProps);
    }

    protected BeanSerializerBase(BeanSerializerBase beanSerializerBase, NameTransformer nameTransformer) {
        this(beanSerializerBase, rename(beanSerializerBase._props, nameTransformer), rename(beanSerializerBase._filteredProps, nameTransformer));
    }
}
