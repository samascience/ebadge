package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.g;
import defpackage.an2;
import defpackage.f71;
import defpackage.l7;
import defpackage.z63;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class VirtualBeanPropertyWriter extends BeanPropertyWriter implements Serializable {
    private static final long serialVersionUID = 1;

    protected VirtualBeanPropertyWriter(g gVar, l7 l7Var, JavaType javaType) {
        this(gVar, l7Var, javaType, null, null, null, gVar.c());
    }

    protected static boolean _suppressNulls(JsonInclude.Value value) {
        JsonInclude.Include valueInclusion;
        return (value == null || (valueInclusion = value.getValueInclusion()) == JsonInclude.Include.ALWAYS || valueInclusion == JsonInclude.Include.USE_DEFAULTS) ? false : true;
    }

    protected static Object _suppressableValue(JsonInclude.Value value) {
        if (value == null) {
            return Boolean.FALSE;
        }
        JsonInclude.Include valueInclusion = value.getValueInclusion();
        if (valueInclusion == JsonInclude.Include.ALWAYS || valueInclusion == JsonInclude.Include.NON_NULL || valueInclusion == JsonInclude.Include.USE_DEFAULTS) {
            return null;
        }
        return BeanPropertyWriter.MARKER_FOR_EMPTY;
    }

    @Override // com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase
    public boolean isVirtual() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter, com.fasterxml.jackson.databind.ser.PropertyWriter
    public void serializeAsElement(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws Exception {
        Object objValue = value(obj, jsonGenerator, an2Var);
        if (objValue == null) {
            f71 f71Var = this._nullSerializer;
            if (f71Var != null) {
                f71Var.serialize(null, jsonGenerator, an2Var);
                return;
            } else {
                jsonGenerator.W0();
                return;
            }
        }
        f71 f71Var_findAndAddDynamic = this._serializer;
        if (f71Var_findAndAddDynamic == null) {
            Class<?> cls = objValue.getClass();
            com.fasterxml.jackson.databind.ser.impl.a aVar = this._dynamicSerializers;
            f71 f71VarK = aVar.k(cls);
            f71Var_findAndAddDynamic = f71VarK == null ? _findAndAddDynamic(aVar, cls, an2Var) : f71VarK;
        }
        Object obj2 = this._suppressableValue;
        if (obj2 != null) {
            if (BeanPropertyWriter.MARKER_FOR_EMPTY == obj2) {
                if (f71Var_findAndAddDynamic.isEmpty(an2Var, objValue)) {
                    serializeAsPlaceholder(obj, jsonGenerator, an2Var);
                    return;
                }
            } else if (obj2.equals(objValue)) {
                serializeAsPlaceholder(obj, jsonGenerator, an2Var);
                return;
            }
        }
        if (objValue == obj && _handleSelfReference(obj, jsonGenerator, an2Var, f71Var_findAndAddDynamic)) {
            return;
        }
        z63 z63Var = this._typeSerializer;
        if (z63Var == null) {
            f71Var_findAndAddDynamic.serialize(objValue, jsonGenerator, an2Var);
        } else {
            f71Var_findAndAddDynamic.serializeWithType(objValue, jsonGenerator, an2Var, z63Var);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter, com.fasterxml.jackson.databind.ser.PropertyWriter
    public void serializeAsField(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws Exception {
        Object objValue = value(obj, jsonGenerator, an2Var);
        if (objValue == null) {
            if (this._nullSerializer != null) {
                jsonGenerator.U0(this._name);
                this._nullSerializer.serialize(null, jsonGenerator, an2Var);
                return;
            }
            return;
        }
        f71 f71Var_findAndAddDynamic = this._serializer;
        if (f71Var_findAndAddDynamic == null) {
            Class<?> cls = objValue.getClass();
            com.fasterxml.jackson.databind.ser.impl.a aVar = this._dynamicSerializers;
            f71 f71VarK = aVar.k(cls);
            f71Var_findAndAddDynamic = f71VarK == null ? _findAndAddDynamic(aVar, cls, an2Var) : f71VarK;
        }
        Object obj2 = this._suppressableValue;
        if (obj2 != null) {
            if (BeanPropertyWriter.MARKER_FOR_EMPTY == obj2) {
                if (f71Var_findAndAddDynamic.isEmpty(an2Var, objValue)) {
                    return;
                }
            } else if (obj2.equals(objValue)) {
                return;
            }
        }
        if (objValue == obj && _handleSelfReference(obj, jsonGenerator, an2Var, f71Var_findAndAddDynamic)) {
            return;
        }
        jsonGenerator.U0(this._name);
        z63 z63Var = this._typeSerializer;
        if (z63Var == null) {
            f71Var_findAndAddDynamic.serialize(objValue, jsonGenerator, an2Var);
        } else {
            f71Var_findAndAddDynamic.serializeWithType(objValue, jsonGenerator, an2Var, z63Var);
        }
    }

    protected abstract Object value(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws Exception;

    public abstract VirtualBeanPropertyWriter withConfig(MapperConfig<?> mapperConfig, com.fasterxml.jackson.databind.introspect.a aVar, g gVar, JavaType javaType);

    protected VirtualBeanPropertyWriter() {
    }

    protected VirtualBeanPropertyWriter(g gVar, l7 l7Var, JavaType javaType, f71 f71Var, z63 z63Var, JavaType javaType2, JsonInclude.Value value, Class<?>[] clsArr) {
        super(gVar, gVar.o(), l7Var, javaType, f71Var, z63Var, javaType2, _suppressNulls(value), _suppressableValue(value), clsArr);
    }

    @Deprecated
    protected VirtualBeanPropertyWriter(g gVar, l7 l7Var, JavaType javaType, f71 f71Var, z63 z63Var, JavaType javaType2, JsonInclude.Value value) {
        this(gVar, l7Var, javaType, f71Var, z63Var, javaType2, value, null);
    }

    protected VirtualBeanPropertyWriter(VirtualBeanPropertyWriter virtualBeanPropertyWriter) {
        super(virtualBeanPropertyWriter);
    }

    protected VirtualBeanPropertyWriter(VirtualBeanPropertyWriter virtualBeanPropertyWriter, PropertyName propertyName) {
        super(virtualBeanPropertyWriter, propertyName);
    }
}
