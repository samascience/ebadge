package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.tencent.connect.common.Constants;
import defpackage.an2;
import defpackage.e41;
import defpackage.f71;
import defpackage.p9;
import defpackage.ph;
import defpackage.w30;
import defpackage.z63;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@e41
public class MapEntrySerializer extends ContainerSerializer<Map.Entry<?, ?>> implements w30 {
    public static final Object MARKER_FOR_EMPTY = JsonInclude.Include.NON_EMPTY;
    protected com.fasterxml.jackson.databind.ser.impl.a _dynamicValueSerializers;
    protected final JavaType _entryType;
    protected f71 _keySerializer;
    protected final JavaType _keyType;
    protected final BeanProperty _property;
    protected final boolean _suppressNulls;
    protected final Object _suppressableValue;
    protected f71 _valueSerializer;
    protected final JavaType _valueType;
    protected final boolean _valueTypeIsStatic;
    protected final z63 _valueTypeSerializer;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonInclude.Include.values().length];
            a = iArr;
            try {
                iArr[JsonInclude.Include.NON_DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonInclude.Include.NON_ABSENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonInclude.Include.NON_EMPTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[JsonInclude.Include.CUSTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[JsonInclude.Include.NON_NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[JsonInclude.Include.ALWAYS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public MapEntrySerializer(JavaType javaType, JavaType javaType2, JavaType javaType3, boolean z, z63 z63Var, BeanProperty beanProperty) {
        super(javaType);
        this._entryType = javaType;
        this._keyType = javaType2;
        this._valueType = javaType3;
        this._valueTypeIsStatic = z;
        this._valueTypeSerializer = z63Var;
        this._property = beanProperty;
        this._dynamicValueSerializers = com.fasterxml.jackson.databind.ser.impl.a.c();
        this._suppressableValue = null;
        this._suppressNulls = false;
    }

    protected final f71 _findAndAddDynamic(com.fasterxml.jackson.databind.ser.impl.a aVar, Class<?> cls, an2 an2Var) throws JsonMappingException {
        com.fasterxml.jackson.databind.ser.impl.a.d dVarI = aVar.i(cls, an2Var, this._property);
        com.fasterxml.jackson.databind.ser.impl.a aVar2 = dVarI.b;
        if (aVar != aVar2) {
            this._dynamicValueSerializers = aVar2;
        }
        return dVarI.a;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public ContainerSerializer<?> _withValueTypeSerializer(z63 z63Var) {
        return new MapEntrySerializer(this, this._property, z63Var, this._keySerializer, this._valueSerializer, this._suppressableValue, this._suppressNulls);
    }

    @Override // defpackage.w30
    public f71 createContextual(an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        f71 f71VarSerializerInstance;
        f71 f71VarSerializerInstance2;
        Object obj;
        boolean z;
        JsonInclude.Value valueFindPropertyInclusion;
        JsonInclude.Include contentInclusion;
        boolean zIncludeFilterSuppressNulls;
        AnnotationIntrospector annotationIntrospector = an2Var.getAnnotationIntrospector();
        Object objB = null;
        AnnotatedMember member = beanProperty == null ? null : beanProperty.getMember();
        if (member == null || annotationIntrospector == null) {
            f71VarSerializerInstance = null;
            f71VarSerializerInstance2 = null;
        } else {
            Object objFindKeySerializer = annotationIntrospector.findKeySerializer(member);
            f71VarSerializerInstance2 = objFindKeySerializer != null ? an2Var.serializerInstance(member, objFindKeySerializer) : null;
            Object objFindContentSerializer = annotationIntrospector.findContentSerializer(member);
            f71VarSerializerInstance = objFindContentSerializer != null ? an2Var.serializerInstance(member, objFindContentSerializer) : null;
        }
        if (f71VarSerializerInstance == null) {
            f71VarSerializerInstance = this._valueSerializer;
        }
        f71 f71VarFindContextualConvertingSerializer = findContextualConvertingSerializer(an2Var, beanProperty, f71VarSerializerInstance);
        if (f71VarFindContextualConvertingSerializer == null && this._valueTypeIsStatic && !this._valueType.isJavaLangObject()) {
            f71VarFindContextualConvertingSerializer = an2Var.findContentValueSerializer(this._valueType, beanProperty);
        }
        f71 f71Var = f71VarFindContextualConvertingSerializer;
        if (f71VarSerializerInstance2 == null) {
            f71VarSerializerInstance2 = this._keySerializer;
        }
        f71 f71VarFindKeySerializer = f71VarSerializerInstance2 == null ? an2Var.findKeySerializer(this._keyType, beanProperty) : an2Var.handleSecondaryContextualization(f71VarSerializerInstance2, beanProperty);
        Object obj2 = this._suppressableValue;
        boolean z2 = this._suppressNulls;
        if (beanProperty == null || (valueFindPropertyInclusion = beanProperty.findPropertyInclusion(an2Var.getConfig(), null)) == null || (contentInclusion = valueFindPropertyInclusion.getContentInclusion()) == JsonInclude.Include.USE_DEFAULTS) {
            obj = obj2;
        } else {
            int i = a.a[contentInclusion.ordinal()];
            z2 = true;
            if (i == 1) {
                objB = ph.b(this._valueType);
                if (objB != null && objB.getClass().isArray()) {
                    objB = p9.b(objB);
                }
            } else if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        objB = an2Var.includeFilterInstance(null, valueFindPropertyInclusion.getContentFilter());
                        if (objB != null) {
                            zIncludeFilterSuppressNulls = an2Var.includeFilterSuppressNulls(objB);
                            z = zIncludeFilterSuppressNulls;
                            obj = objB;
                        }
                    } else if (i != 5) {
                        zIncludeFilterSuppressNulls = false;
                        z = zIncludeFilterSuppressNulls;
                        obj = objB;
                    }
                    return withResolved(beanProperty, f71VarFindKeySerializer, f71Var, obj, z);
                }
                objB = MARKER_FOR_EMPTY;
            } else if (this._valueType.isReferenceType()) {
                objB = MARKER_FOR_EMPTY;
            }
            obj = objB;
        }
        z = z2;
        return withResolved(beanProperty, f71VarFindKeySerializer, f71Var, obj, z);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public f71 getContentSerializer() {
        return this._valueSerializer;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public JavaType getContentType() {
        return this._valueType;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public boolean hasSingleElement(Map.Entry<?, ?> entry) {
        return true;
    }

    protected void serializeDynamic(Map.Entry<?, ?> entry, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        f71 f71Var_findAndAddDynamic;
        z63 z63Var = this._valueTypeSerializer;
        Object key = entry.getKey();
        f71 f71VarFindNullKeySerializer = key == null ? an2Var.findNullKeySerializer(this._keyType, this._property) : this._keySerializer;
        Object value = entry.getValue();
        if (value != null) {
            f71Var_findAndAddDynamic = this._valueSerializer;
            if (f71Var_findAndAddDynamic == null) {
                Class<?> cls = value.getClass();
                f71 f71VarK = this._dynamicValueSerializers.k(cls);
                if (f71VarK == null) {
                    f71Var_findAndAddDynamic = this._valueType.hasGenericTypes() ? _findAndAddDynamic(this._dynamicValueSerializers, an2Var.constructSpecializedType(this._valueType, cls), an2Var) : _findAndAddDynamic(this._dynamicValueSerializers, cls, an2Var);
                } else {
                    f71Var_findAndAddDynamic = f71VarK;
                }
            }
            Object obj = this._suppressableValue;
            if (obj != null && ((obj == MARKER_FOR_EMPTY && f71Var_findAndAddDynamic.isEmpty(an2Var, value)) || this._suppressableValue.equals(value))) {
                return;
            }
        } else if (this._suppressNulls) {
            return;
        } else {
            f71Var_findAndAddDynamic = an2Var.getDefaultNullValueSerializer();
        }
        f71VarFindNullKeySerializer.serialize(key, jsonGenerator, an2Var);
        try {
            if (z63Var == null) {
                f71Var_findAndAddDynamic.serialize(value, jsonGenerator, an2Var);
            } else {
                f71Var_findAndAddDynamic.serializeWithType(value, jsonGenerator, an2Var, z63Var);
            }
        } catch (Exception e) {
            wrapAndThrow(an2Var, e, entry, Constants.STR_EMPTY + key);
        }
    }

    public MapEntrySerializer withContentInclusion(Object obj, boolean z) {
        return (this._suppressableValue == obj && this._suppressNulls == z) ? this : new MapEntrySerializer(this, this._property, this._valueTypeSerializer, this._keySerializer, this._valueSerializer, obj, z);
    }

    public MapEntrySerializer withResolved(BeanProperty beanProperty, f71 f71Var, f71 f71Var2, Object obj, boolean z) {
        return new MapEntrySerializer(this, beanProperty, this._valueTypeSerializer, f71Var, f71Var2, obj, z);
    }

    @Override // defpackage.f71
    public boolean isEmpty(an2 an2Var, Map.Entry<?, ?> entry) {
        Object value = entry.getValue();
        if (value == null) {
            return this._suppressNulls;
        }
        if (this._suppressableValue == null) {
            return false;
        }
        f71 f71Var_findAndAddDynamic = this._valueSerializer;
        if (f71Var_findAndAddDynamic == null) {
            Class<?> cls = value.getClass();
            f71 f71VarK = this._dynamicValueSerializers.k(cls);
            if (f71VarK == null) {
                try {
                    f71Var_findAndAddDynamic = _findAndAddDynamic(this._dynamicValueSerializers, cls, an2Var);
                } catch (JsonMappingException unused) {
                    return false;
                }
            } else {
                f71Var_findAndAddDynamic = f71VarK;
            }
        }
        Object obj = this._suppressableValue;
        return obj == MARKER_FOR_EMPTY ? f71Var_findAndAddDynamic.isEmpty(an2Var, value) : obj.equals(value);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(Map.Entry<?, ?> entry, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        jsonGenerator.t1(entry);
        serializeDynamic(entry, jsonGenerator, an2Var);
        jsonGenerator.S0();
    }

    @Override // defpackage.f71
    public void serializeWithType(Map.Entry<?, ?> entry, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        jsonGenerator.y0(entry);
        WritableTypeId writableTypeIdG = z63Var.g(jsonGenerator, z63Var.d(entry, JsonToken.START_OBJECT));
        serializeDynamic(entry, jsonGenerator, an2Var);
        z63Var.h(jsonGenerator, writableTypeIdG);
    }

    protected final f71 _findAndAddDynamic(com.fasterxml.jackson.databind.ser.impl.a aVar, JavaType javaType, an2 an2Var) throws JsonMappingException {
        com.fasterxml.jackson.databind.ser.impl.a.d dVarH = aVar.h(javaType, an2Var, this._property);
        com.fasterxml.jackson.databind.ser.impl.a aVar2 = dVarH.b;
        if (aVar != aVar2) {
            this._dynamicValueSerializers = aVar2;
        }
        return dVarH.a;
    }

    @Deprecated
    protected MapEntrySerializer(MapEntrySerializer mapEntrySerializer, BeanProperty beanProperty, z63 z63Var, f71 f71Var, f71 f71Var2) {
        this(mapEntrySerializer, beanProperty, z63Var, f71Var, f71Var2, mapEntrySerializer._suppressableValue, mapEntrySerializer._suppressNulls);
    }

    protected MapEntrySerializer(MapEntrySerializer mapEntrySerializer, BeanProperty beanProperty, z63 z63Var, f71 f71Var, f71 f71Var2, Object obj, boolean z) {
        super(Map.class, false);
        this._entryType = mapEntrySerializer._entryType;
        this._keyType = mapEntrySerializer._keyType;
        this._valueType = mapEntrySerializer._valueType;
        this._valueTypeIsStatic = mapEntrySerializer._valueTypeIsStatic;
        this._valueTypeSerializer = mapEntrySerializer._valueTypeSerializer;
        this._keySerializer = f71Var;
        this._valueSerializer = f71Var2;
        this._dynamicValueSerializers = com.fasterxml.jackson.databind.ser.impl.a.c();
        this._property = mapEntrySerializer._property;
        this._suppressableValue = obj;
        this._suppressNulls = z;
    }
}
