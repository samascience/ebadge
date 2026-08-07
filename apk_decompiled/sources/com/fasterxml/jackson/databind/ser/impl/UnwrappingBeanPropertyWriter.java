package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import defpackage.an2;
import defpackage.f71;
import defpackage.p61;
import defpackage.y51;
import defpackage.z63;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class UnwrappingBeanPropertyWriter extends BeanPropertyWriter implements Serializable {
    private static final long serialVersionUID = 1;
    protected final NameTransformer _nameTransformer;

    class a extends y51.a {
        a(an2 an2Var, p61 p61Var) {
            super(an2Var);
        }

        @Override // defpackage.y51
        public p61 j(JavaType javaType) {
            return null;
        }
    }

    public UnwrappingBeanPropertyWriter(BeanPropertyWriter beanPropertyWriter, NameTransformer nameTransformer) {
        super(beanPropertyWriter);
        this._nameTransformer = nameTransformer;
    }

    @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
    protected void _depositSchemaProperty(ObjectNode objectNode, JsonNode jsonNode) {
        JsonNode jsonNode2 = jsonNode.get("properties");
        if (jsonNode2 != null) {
            Iterator<Map.Entry<String, JsonNode>> itFields = jsonNode2.fields();
            while (itFields.hasNext()) {
                Map.Entry<String, JsonNode> next = itFields.next();
                String key = next.getKey();
                NameTransformer nameTransformer = this._nameTransformer;
                if (nameTransformer != null) {
                    key = nameTransformer.transform(key);
                }
                objectNode.set(key, next.getValue());
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
    protected f71 _findAndAddDynamic(com.fasterxml.jackson.databind.ser.impl.a aVar, Class<?> cls, an2 an2Var) throws JsonMappingException {
        JavaType javaType = this._nonTrivialBaseType;
        f71 f71VarFindValueSerializer = javaType != null ? an2Var.findValueSerializer(an2Var.constructSpecializedType(javaType, cls), this) : an2Var.findValueSerializer(cls, this);
        NameTransformer nameTransformerChainedTransformer = this._nameTransformer;
        if (f71VarFindValueSerializer.isUnwrappingSerializer() && (f71VarFindValueSerializer instanceof UnwrappingBeanSerializer)) {
            nameTransformerChainedTransformer = NameTransformer.chainedTransformer(nameTransformerChainedTransformer, ((UnwrappingBeanSerializer) f71VarFindValueSerializer)._nameTransformer);
        }
        f71 f71VarUnwrappingSerializer = f71VarFindValueSerializer.unwrappingSerializer(nameTransformerChainedTransformer);
        this._dynamicSerializers = this._dynamicSerializers.j(cls, f71VarUnwrappingSerializer);
        return f71VarUnwrappingSerializer;
    }

    protected UnwrappingBeanPropertyWriter _new(NameTransformer nameTransformer, SerializedString serializedString) {
        return new UnwrappingBeanPropertyWriter(this, nameTransformer, serializedString);
    }

    @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
    public void assignSerializer(f71 f71Var) {
        if (f71Var != null) {
            NameTransformer nameTransformerChainedTransformer = this._nameTransformer;
            if (f71Var.isUnwrappingSerializer() && (f71Var instanceof UnwrappingBeanSerializer)) {
                nameTransformerChainedTransformer = NameTransformer.chainedTransformer(nameTransformerChainedTransformer, ((UnwrappingBeanSerializer) f71Var)._nameTransformer);
            }
            f71Var = f71Var.unwrappingSerializer(nameTransformerChainedTransformer);
        }
        super.assignSerializer(f71Var);
    }

    @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter, com.fasterxml.jackson.databind.ser.PropertyWriter, com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public void depositSchemaProperty(p61 p61Var, an2 an2Var) throws JsonMappingException {
        f71 f71VarUnwrappingSerializer = an2Var.findValueSerializer(getType(), this).unwrappingSerializer(this._nameTransformer);
        if (f71VarUnwrappingSerializer.isUnwrappingSerializer()) {
            f71VarUnwrappingSerializer.acceptJsonFormatVisitor(new a(an2Var, p61Var), getType());
        } else {
            super.depositSchemaProperty(p61Var, an2Var);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
    public boolean isUnwrapping() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter, com.fasterxml.jackson.databind.ser.PropertyWriter
    public void serializeAsField(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws Exception {
        Object obj2 = get(obj);
        if (obj2 == null) {
            return;
        }
        f71 f71Var_findAndAddDynamic = this._serializer;
        if (f71Var_findAndAddDynamic == null) {
            Class<?> cls = obj2.getClass();
            com.fasterxml.jackson.databind.ser.impl.a aVar = this._dynamicSerializers;
            f71 f71VarK = aVar.k(cls);
            f71Var_findAndAddDynamic = f71VarK == null ? _findAndAddDynamic(aVar, cls, an2Var) : f71VarK;
        }
        Object obj3 = this._suppressableValue;
        if (obj3 != null) {
            if (BeanPropertyWriter.MARKER_FOR_EMPTY == obj3) {
                if (f71Var_findAndAddDynamic.isEmpty(an2Var, obj2)) {
                    return;
                }
            } else if (obj3.equals(obj2)) {
                return;
            }
        }
        if (obj2 == obj && _handleSelfReference(obj, jsonGenerator, an2Var, f71Var_findAndAddDynamic)) {
            return;
        }
        if (!f71Var_findAndAddDynamic.isUnwrappingSerializer()) {
            jsonGenerator.U0(this._name);
        }
        z63 z63Var = this._typeSerializer;
        if (z63Var == null) {
            f71Var_findAndAddDynamic.serialize(obj2, jsonGenerator, an2Var);
        } else {
            f71Var_findAndAddDynamic.serializeWithType(obj2, jsonGenerator, an2Var, z63Var);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
    public UnwrappingBeanPropertyWriter rename(NameTransformer nameTransformer) {
        return _new(NameTransformer.chainedTransformer(nameTransformer, this._nameTransformer), new SerializedString(nameTransformer.transform(this._name.getValue())));
    }

    protected UnwrappingBeanPropertyWriter(UnwrappingBeanPropertyWriter unwrappingBeanPropertyWriter, NameTransformer nameTransformer, SerializedString serializedString) {
        super(unwrappingBeanPropertyWriter, serializedString);
        this._nameTransformer = nameTransformer;
    }
}
