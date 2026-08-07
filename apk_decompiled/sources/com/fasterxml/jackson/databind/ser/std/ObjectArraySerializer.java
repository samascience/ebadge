package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.impl.a;
import defpackage.an2;
import defpackage.e41;
import defpackage.f71;
import defpackage.w30;
import defpackage.y51;
import defpackage.z63;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@e41
public class ObjectArraySerializer extends ArraySerializerBase<Object[]> implements w30 {
    protected a _dynamicSerializers;
    protected f71 _elementSerializer;
    protected final JavaType _elementType;
    protected final boolean _staticTyping;
    protected final z63 _valueTypeSerializer;

    public ObjectArraySerializer(JavaType javaType, boolean z, z63 z63Var, f71 f71Var) {
        super(Object[].class);
        this._elementType = javaType;
        this._staticTyping = z;
        this._valueTypeSerializer = z63Var;
        this._dynamicSerializers = a.c();
        this._elementSerializer = f71Var;
    }

    protected final f71 _findAndAddDynamic(a aVar, Class<?> cls, an2 an2Var) throws JsonMappingException {
        a.d dVarI = aVar.i(cls, an2Var, this._property);
        a aVar2 = dVarI.b;
        if (aVar != aVar2) {
            this._dynamicSerializers = aVar2;
        }
        return dVarI.a;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
    public f71 _withResolved(BeanProperty beanProperty, Boolean bool) {
        return new ObjectArraySerializer(this, beanProperty, this._valueTypeSerializer, this._elementSerializer, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public ContainerSerializer<?> _withValueTypeSerializer(z63 z63Var) {
        return new ObjectArraySerializer(this._elementType, this._staticTyping, z63Var, this._elementSerializer);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        y51Var.i(javaType);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0020  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase, defpackage.w30
    public f71 createContextual(an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        f71 f71VarSerializerInstance;
        JavaType javaType;
        Object objFindContentSerializer;
        z63 z63VarA = this._valueTypeSerializer;
        if (z63VarA != null) {
            z63VarA = z63VarA.a(beanProperty);
        }
        if (beanProperty != null) {
            AnnotatedMember member = beanProperty.getMember();
            AnnotationIntrospector annotationIntrospector = an2Var.getAnnotationIntrospector();
            if (member == null || (objFindContentSerializer = annotationIntrospector.findContentSerializer(member)) == null) {
                f71VarSerializerInstance = null;
            } else {
                f71VarSerializerInstance = an2Var.serializerInstance(member, objFindContentSerializer);
            }
        } else {
            f71VarSerializerInstance = null;
        }
        JsonFormat.Value valueFindFormatOverrides = findFormatOverrides(an2Var, beanProperty, handledType());
        Boolean feature = valueFindFormatOverrides != null ? valueFindFormatOverrides.getFeature(JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : null;
        if (f71VarSerializerInstance == null) {
            f71VarSerializerInstance = this._elementSerializer;
        }
        f71 f71VarFindContextualConvertingSerializer = findContextualConvertingSerializer(an2Var, beanProperty, f71VarSerializerInstance);
        if (f71VarFindContextualConvertingSerializer == null && (javaType = this._elementType) != null && this._staticTyping && !javaType.isJavaLangObject()) {
            f71VarFindContextualConvertingSerializer = an2Var.findContentValueSerializer(this._elementType, beanProperty);
        }
        return withResolved(beanProperty, z63VarA, f71VarFindContextualConvertingSerializer, feature);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public f71 getContentSerializer() {
        return this._elementSerializer;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public JavaType getContentType() {
        return this._elementType;
    }

    public void serializeContentsUsing(Object[] objArr, JsonGenerator jsonGenerator, an2 an2Var, f71 f71Var) throws IOException {
        int length = objArr.length;
        z63 z63Var = this._valueTypeSerializer;
        Object obj = null;
        for (int i = 0; i < length; i++) {
            try {
                obj = objArr[i];
                if (obj == null) {
                    an2Var.defaultSerializeNull(jsonGenerator);
                } else if (z63Var == null) {
                    f71Var.serialize(obj, jsonGenerator, an2Var);
                } else {
                    f71Var.serializeWithType(obj, jsonGenerator, an2Var, z63Var);
                }
            } catch (Exception e) {
                wrapAndThrow(an2Var, e, obj, i);
                return;
            }
        }
    }

    public void serializeTypedContents(Object[] objArr, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        int length = objArr.length;
        z63 z63Var = this._valueTypeSerializer;
        int i = 0;
        Object obj = null;
        try {
            a aVar = this._dynamicSerializers;
            while (i < length) {
                obj = objArr[i];
                if (obj == null) {
                    an2Var.defaultSerializeNull(jsonGenerator);
                } else {
                    Class<?> cls = obj.getClass();
                    f71 f71VarK = aVar.k(cls);
                    if (f71VarK == null) {
                        f71VarK = _findAndAddDynamic(aVar, cls, an2Var);
                    }
                    f71VarK.serializeWithType(obj, jsonGenerator, an2Var, z63Var);
                }
                i++;
            }
        } catch (Exception e) {
            wrapAndThrow(an2Var, e, obj, i);
        }
    }

    public ObjectArraySerializer withResolved(BeanProperty beanProperty, z63 z63Var, f71 f71Var, Boolean bool) {
        return (this._property == beanProperty && f71Var == this._elementSerializer && this._valueTypeSerializer == z63Var && Objects.equals(this._unwrapSingle, bool)) ? this : new ObjectArraySerializer(this, beanProperty, z63Var, f71Var, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public boolean hasSingleElement(Object[] objArr) {
        return objArr.length == 1;
    }

    @Override // defpackage.f71
    public boolean isEmpty(an2 an2Var, Object[] objArr) {
        return objArr.length == 0;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public final void serialize(Object[] objArr, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        int length = objArr.length;
        if (length == 1 && ((this._unwrapSingle == null && an2Var.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            serializeContents(objArr, jsonGenerator, an2Var);
            return;
        }
        jsonGenerator.r1(objArr, length);
        serializeContents(objArr, jsonGenerator, an2Var);
        jsonGenerator.R0();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.ArraySerializerBase
    public void serializeContents(Object[] objArr, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        int length = objArr.length;
        if (length == 0) {
            return;
        }
        f71 f71Var = this._elementSerializer;
        if (f71Var != null) {
            serializeContentsUsing(objArr, jsonGenerator, an2Var, f71Var);
            return;
        }
        if (this._valueTypeSerializer != null) {
            serializeTypedContents(objArr, jsonGenerator, an2Var);
            return;
        }
        int i = 0;
        Object obj = null;
        try {
            a aVar = this._dynamicSerializers;
            while (i < length) {
                obj = objArr[i];
                if (obj == null) {
                    an2Var.defaultSerializeNull(jsonGenerator);
                } else {
                    Class<?> cls = obj.getClass();
                    f71 f71VarK = aVar.k(cls);
                    if (f71VarK == null) {
                        f71VarK = this._elementType.hasGenericTypes() ? _findAndAddDynamic(aVar, an2Var.constructSpecializedType(this._elementType, cls), an2Var) : _findAndAddDynamic(aVar, cls, an2Var);
                    }
                    f71VarK.serialize(obj, jsonGenerator, an2Var);
                }
                i++;
            }
        } catch (Exception e) {
            wrapAndThrow(an2Var, e, obj, i);
        }
    }

    protected final f71 _findAndAddDynamic(a aVar, JavaType javaType, an2 an2Var) throws JsonMappingException {
        a.d dVarH = aVar.h(javaType, an2Var, this._property);
        a aVar2 = dVarH.b;
        if (aVar != aVar2) {
            this._dynamicSerializers = aVar2;
        }
        return dVarH.a;
    }

    public ObjectArraySerializer(ObjectArraySerializer objectArraySerializer, z63 z63Var) {
        super(objectArraySerializer);
        this._elementType = objectArraySerializer._elementType;
        this._valueTypeSerializer = z63Var;
        this._staticTyping = objectArraySerializer._staticTyping;
        this._dynamicSerializers = objectArraySerializer._dynamicSerializers;
        this._elementSerializer = objectArraySerializer._elementSerializer;
    }

    public ObjectArraySerializer(ObjectArraySerializer objectArraySerializer, BeanProperty beanProperty, z63 z63Var, f71 f71Var, Boolean bool) {
        super(objectArraySerializer, beanProperty, bool);
        this._elementType = objectArraySerializer._elementType;
        this._valueTypeSerializer = z63Var;
        this._staticTyping = objectArraySerializer._staticTyping;
        this._dynamicSerializers = a.c();
        this._elementSerializer = f71Var;
    }
}
