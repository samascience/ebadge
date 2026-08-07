package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.g;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.databind.util.NameTransformer;
import defpackage.an2;
import defpackage.ay;
import defpackage.d71;
import defpackage.e41;
import defpackage.f71;
import defpackage.l7;
import defpackage.p61;
import defpackage.tk2;
import defpackage.vm2;
import defpackage.z63;
import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@e41
public class BeanPropertyWriter extends PropertyWriter implements Serializable {
    public static final Object MARKER_FOR_EMPTY = JsonInclude.Include.NON_EMPTY;
    private static final long serialVersionUID = 1;
    protected transient Method _accessorMethod;
    protected final JavaType _cfgSerializationType;
    protected final transient l7 _contextAnnotations;
    protected final JavaType _declaredType;
    protected transient com.fasterxml.jackson.databind.ser.impl.a _dynamicSerializers;
    protected transient Field _field;
    protected final Class<?>[] _includeInViews;
    protected transient HashMap<Object, Object> _internalSettings;
    protected final AnnotatedMember _member;
    protected final SerializedString _name;
    protected JavaType _nonTrivialBaseType;
    protected f71 _nullSerializer;
    protected f71 _serializer;
    protected final boolean _suppressNulls;
    protected final Object _suppressableValue;
    protected z63 _typeSerializer;
    protected final PropertyName _wrapperName;

    public BeanPropertyWriter(g gVar, AnnotatedMember annotatedMember, l7 l7Var, JavaType javaType, f71 f71Var, z63 z63Var, JavaType javaType2, boolean z, Object obj, Class<?>[] clsArr) {
        super(gVar);
        this._member = annotatedMember;
        this._contextAnnotations = l7Var;
        this._name = new SerializedString(gVar.getName());
        this._wrapperName = gVar.getWrapperName();
        this._declaredType = javaType;
        this._serializer = f71Var;
        this._dynamicSerializers = f71Var == null ? com.fasterxml.jackson.databind.ser.impl.a.c() : null;
        this._typeSerializer = z63Var;
        this._cfgSerializationType = javaType2;
        if (annotatedMember instanceof AnnotatedField) {
            this._accessorMethod = null;
            this._field = (Field) annotatedMember.getMember();
        } else if (annotatedMember instanceof AnnotatedMethod) {
            this._accessorMethod = (Method) annotatedMember.getMember();
            this._field = null;
        } else {
            this._accessorMethod = null;
            this._field = null;
        }
        this._suppressNulls = z;
        this._suppressableValue = obj;
        this._nullSerializer = null;
        this._includeInViews = clsArr;
    }

    protected void _depositSchemaProperty(ObjectNode objectNode, JsonNode jsonNode) {
        objectNode.set(getName(), jsonNode);
    }

    protected f71 _findAndAddDynamic(com.fasterxml.jackson.databind.ser.impl.a aVar, Class<?> cls, an2 an2Var) throws JsonMappingException {
        JavaType javaType = this._nonTrivialBaseType;
        com.fasterxml.jackson.databind.ser.impl.a.d dVarF = javaType != null ? aVar.f(an2Var.constructSpecializedType(javaType, cls), an2Var, this) : aVar.g(cls, an2Var, this);
        com.fasterxml.jackson.databind.ser.impl.a aVar2 = dVarF.b;
        if (aVar != aVar2) {
            this._dynamicSerializers = aVar2;
        }
        return dVarF.a;
    }

    protected boolean _handleSelfReference(Object obj, JsonGenerator jsonGenerator, an2 an2Var, f71 f71Var) throws IOException {
        if (f71Var.usesObjectId()) {
            return false;
        }
        if (an2Var.isEnabled(SerializationFeature.FAIL_ON_SELF_REFERENCES)) {
            if (!(f71Var instanceof BeanSerializerBase)) {
                return false;
            }
            an2Var.reportBadDefinition(getType(), "Direct self-reference leading to cycle");
            return false;
        }
        if (!an2Var.isEnabled(SerializationFeature.WRITE_SELF_REFERENCES_AS_NULL)) {
            return false;
        }
        if (this._nullSerializer == null) {
            return true;
        }
        if (!jsonGenerator.g0().i()) {
            jsonGenerator.U0(this._name);
        }
        this._nullSerializer.serialize(null, jsonGenerator, an2Var);
        return true;
    }

    protected BeanPropertyWriter _new(PropertyName propertyName) {
        return new BeanPropertyWriter(this, propertyName);
    }

    public void assignNullSerializer(f71 f71Var) {
        f71 f71Var2 = this._nullSerializer;
        if (f71Var2 != null && f71Var2 != f71Var) {
            throw new IllegalStateException(String.format("Cannot override _nullSerializer: had a %s, trying to set to %s", ay.h(this._nullSerializer), ay.h(f71Var)));
        }
        this._nullSerializer = f71Var;
    }

    public void assignSerializer(f71 f71Var) {
        f71 f71Var2 = this._serializer;
        if (f71Var2 != null && f71Var2 != f71Var) {
            throw new IllegalStateException(String.format("Cannot override _serializer: had a %s, trying to set to %s", ay.h(this._serializer), ay.h(f71Var)));
        }
        this._serializer = f71Var;
    }

    public void assignTypeSerializer(z63 z63Var) {
        this._typeSerializer = z63Var;
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter, com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public void depositSchemaProperty(p61 p61Var, an2 an2Var) throws JsonMappingException {
        if (p61Var != null) {
            if (isRequired()) {
                p61Var.n(this);
            } else {
                p61Var.g(this);
            }
        }
    }

    public void fixAccess(SerializationConfig serializationConfig) {
        this._member.fixAccess(serializationConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public final Object get(Object obj) throws Exception {
        Method method = this._accessorMethod;
        return method == null ? this._field.get(obj) : method.invoke(obj, null);
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter, com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        AnnotatedMember annotatedMember = this._member;
        if (annotatedMember == null) {
            return null;
        }
        return (A) annotatedMember.getAnnotation(cls);
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter, com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public <A extends Annotation> A getContextAnnotation(Class<A> cls) {
        l7 l7Var = this._contextAnnotations;
        if (l7Var == null) {
            return null;
        }
        return (A) l7Var.get(cls);
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter, com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public PropertyName getFullName() {
        return new PropertyName(this._name.getValue());
    }

    @Deprecated
    public Type getGenericPropertyType() {
        Method method = this._accessorMethod;
        if (method != null) {
            return method.getGenericReturnType();
        }
        Field field = this._field;
        if (field != null) {
            return field.getGenericType();
        }
        return null;
    }

    public Object getInternalSetting(Object obj) {
        HashMap<Object, Object> map = this._internalSettings;
        if (map == null) {
            return null;
        }
        return map.get(obj);
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter, com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public AnnotatedMember getMember() {
        return this._member;
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter, com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty, defpackage.in1
    public String getName() {
        return this._name.getValue();
    }

    @Deprecated
    public Class<?> getPropertyType() {
        Method method = this._accessorMethod;
        if (method != null) {
            return method.getReturnType();
        }
        Field field = this._field;
        if (field != null) {
            return field.getType();
        }
        return null;
    }

    @Deprecated
    public Class<?> getRawSerializationType() {
        JavaType javaType = this._cfgSerializationType;
        if (javaType == null) {
            return null;
        }
        return javaType.getRawClass();
    }

    public JavaType getSerializationType() {
        return this._cfgSerializationType;
    }

    public vm2 getSerializedName() {
        return this._name;
    }

    public f71 getSerializer() {
        return this._serializer;
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter, com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public JavaType getType() {
        return this._declaredType;
    }

    public z63 getTypeSerializer() {
        return this._typeSerializer;
    }

    public Class<?>[] getViews() {
        return this._includeInViews;
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter, com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public PropertyName getWrapperName() {
        return this._wrapperName;
    }

    public boolean hasNullSerializer() {
        return this._nullSerializer != null;
    }

    public boolean hasSerializer() {
        return this._serializer != null;
    }

    public boolean isUnwrapping() {
        return false;
    }

    Object readResolve() {
        AnnotatedMember annotatedMember = this._member;
        if (annotatedMember instanceof AnnotatedField) {
            this._accessorMethod = null;
            this._field = (Field) annotatedMember.getMember();
        } else if (annotatedMember instanceof AnnotatedMethod) {
            this._accessorMethod = (Method) annotatedMember.getMember();
            this._field = null;
        }
        if (this._serializer == null) {
            this._dynamicSerializers = com.fasterxml.jackson.databind.ser.impl.a.c();
        }
        return this;
    }

    public Object removeInternalSetting(Object obj) {
        HashMap<Object, Object> map = this._internalSettings;
        if (map == null) {
            return null;
        }
        Object objRemove = map.remove(obj);
        if (this._internalSettings.size() == 0) {
            this._internalSettings = null;
        }
        return objRemove;
    }

    public BeanPropertyWriter rename(NameTransformer nameTransformer) {
        String strTransform = nameTransformer.transform(this._name.getValue());
        return strTransform.equals(this._name.toString()) ? this : _new(PropertyName.construct(strTransform));
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter
    public void serializeAsElement(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws Exception {
        Method method = this._accessorMethod;
        Object objInvoke = method == null ? this._field.get(obj) : method.invoke(obj, null);
        if (objInvoke == null) {
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
            Class<?> cls = objInvoke.getClass();
            com.fasterxml.jackson.databind.ser.impl.a aVar = this._dynamicSerializers;
            f71 f71VarK = aVar.k(cls);
            f71Var_findAndAddDynamic = f71VarK == null ? _findAndAddDynamic(aVar, cls, an2Var) : f71VarK;
        }
        Object obj2 = this._suppressableValue;
        if (obj2 != null) {
            if (MARKER_FOR_EMPTY == obj2) {
                if (f71Var_findAndAddDynamic.isEmpty(an2Var, objInvoke)) {
                    serializeAsPlaceholder(obj, jsonGenerator, an2Var);
                    return;
                }
            } else if (obj2.equals(objInvoke)) {
                serializeAsPlaceholder(obj, jsonGenerator, an2Var);
                return;
            }
        }
        if (objInvoke == obj && _handleSelfReference(obj, jsonGenerator, an2Var, f71Var_findAndAddDynamic)) {
            return;
        }
        z63 z63Var = this._typeSerializer;
        if (z63Var == null) {
            f71Var_findAndAddDynamic.serialize(objInvoke, jsonGenerator, an2Var);
        } else {
            f71Var_findAndAddDynamic.serializeWithType(objInvoke, jsonGenerator, an2Var, z63Var);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter
    public void serializeAsField(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws Exception {
        Method method = this._accessorMethod;
        Object objInvoke = method == null ? this._field.get(obj) : method.invoke(obj, null);
        if (objInvoke == null) {
            Object obj2 = this._suppressableValue;
            if ((obj2 == null || !an2Var.includeFilterSuppressNulls(obj2)) && this._nullSerializer != null) {
                jsonGenerator.U0(this._name);
                this._nullSerializer.serialize(null, jsonGenerator, an2Var);
                return;
            }
            return;
        }
        f71 f71Var_findAndAddDynamic = this._serializer;
        if (f71Var_findAndAddDynamic == null) {
            Class<?> cls = objInvoke.getClass();
            com.fasterxml.jackson.databind.ser.impl.a aVar = this._dynamicSerializers;
            f71 f71VarK = aVar.k(cls);
            f71Var_findAndAddDynamic = f71VarK == null ? _findAndAddDynamic(aVar, cls, an2Var) : f71VarK;
        }
        Object obj3 = this._suppressableValue;
        if (obj3 != null) {
            if (MARKER_FOR_EMPTY == obj3) {
                if (f71Var_findAndAddDynamic.isEmpty(an2Var, objInvoke)) {
                    return;
                }
            } else if (obj3.equals(objInvoke)) {
                return;
            }
        }
        if (objInvoke == obj && _handleSelfReference(obj, jsonGenerator, an2Var, f71Var_findAndAddDynamic)) {
            return;
        }
        jsonGenerator.U0(this._name);
        z63 z63Var = this._typeSerializer;
        if (z63Var == null) {
            f71Var_findAndAddDynamic.serialize(objInvoke, jsonGenerator, an2Var);
        } else {
            f71Var_findAndAddDynamic.serializeWithType(objInvoke, jsonGenerator, an2Var, z63Var);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter
    public void serializeAsOmittedField(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws Exception {
        if (jsonGenerator.C()) {
            return;
        }
        jsonGenerator.i1(this._name.getValue());
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter
    public void serializeAsPlaceholder(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws Exception {
        f71 f71Var = this._nullSerializer;
        if (f71Var != null) {
            f71Var.serialize(null, jsonGenerator, an2Var);
        } else {
            jsonGenerator.W0();
        }
    }

    public Object setInternalSetting(Object obj, Object obj2) {
        if (this._internalSettings == null) {
            this._internalSettings = new HashMap<>();
        }
        return this._internalSettings.put(obj, obj2);
    }

    public void setNonTrivialBaseType(JavaType javaType) {
        this._nonTrivialBaseType = javaType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("property '");
        sb.append(getName());
        sb.append("' (");
        if (this._accessorMethod != null) {
            sb.append("via method ");
            sb.append(this._accessorMethod.getDeclaringClass().getName());
            sb.append("#");
            sb.append(this._accessorMethod.getName());
        } else if (this._field != null) {
            sb.append("field \"");
            sb.append(this._field.getDeclaringClass().getName());
            sb.append("#");
            sb.append(this._field.getName());
        } else {
            sb.append("virtual");
        }
        if (this._serializer == null) {
            sb.append(", no static serializer");
        } else {
            sb.append(", static serializer of type " + this._serializer.getClass().getName());
        }
        sb.append(')');
        return sb.toString();
    }

    public BeanPropertyWriter unwrappingWriter(NameTransformer nameTransformer) {
        return new UnwrappingBeanPropertyWriter(this, nameTransformer);
    }

    public boolean willSuppressNulls() {
        return this._suppressNulls;
    }

    public boolean wouldConflictWithName(PropertyName propertyName) {
        PropertyName propertyName2 = this._wrapperName;
        if (propertyName2 != null) {
            return propertyName2.equals(propertyName);
        }
        return propertyName.hasSimpleName(this._name.getValue()) && !propertyName.hasNamespace();
    }

    @Override // com.fasterxml.jackson.databind.ser.PropertyWriter
    @Deprecated
    public void depositSchemaProperty(ObjectNode objectNode, an2 an2Var) throws JsonMappingException {
        JsonNode jsonNodeA;
        JavaType serializationType = getSerializationType();
        Type type = serializationType == null ? getType() : serializationType.getRawClass();
        Object serializer = getSerializer();
        if (serializer == null) {
            serializer = an2Var.findValueSerializer(getType(), this);
        }
        boolean z = !isRequired();
        if (serializer instanceof tk2) {
            jsonNodeA = ((tk2) serializer).getSchema(an2Var, type, z);
        } else {
            jsonNodeA = d71.a();
        }
        _depositSchemaProperty(objectNode, jsonNodeA);
    }

    @Deprecated
    public BeanPropertyWriter(g gVar, AnnotatedMember annotatedMember, l7 l7Var, JavaType javaType, f71 f71Var, z63 z63Var, JavaType javaType2, boolean z, Object obj) {
        this(gVar, annotatedMember, l7Var, javaType, f71Var, z63Var, javaType2, z, obj, null);
    }

    protected BeanPropertyWriter() {
        super(PropertyMetadata.STD_REQUIRED_OR_OPTIONAL);
        this._member = null;
        this._contextAnnotations = null;
        this._name = null;
        this._wrapperName = null;
        this._includeInViews = null;
        this._declaredType = null;
        this._serializer = null;
        this._dynamicSerializers = null;
        this._typeSerializer = null;
        this._cfgSerializationType = null;
        this._accessorMethod = null;
        this._field = null;
        this._suppressNulls = false;
        this._suppressableValue = null;
        this._nullSerializer = null;
    }

    protected BeanPropertyWriter(BeanPropertyWriter beanPropertyWriter) {
        this(beanPropertyWriter, beanPropertyWriter._name);
    }

    protected BeanPropertyWriter(BeanPropertyWriter beanPropertyWriter, PropertyName propertyName) {
        super(beanPropertyWriter);
        this._name = new SerializedString(propertyName.getSimpleName());
        this._wrapperName = beanPropertyWriter._wrapperName;
        this._contextAnnotations = beanPropertyWriter._contextAnnotations;
        this._declaredType = beanPropertyWriter._declaredType;
        this._member = beanPropertyWriter._member;
        this._accessorMethod = beanPropertyWriter._accessorMethod;
        this._field = beanPropertyWriter._field;
        this._serializer = beanPropertyWriter._serializer;
        this._nullSerializer = beanPropertyWriter._nullSerializer;
        if (beanPropertyWriter._internalSettings != null) {
            this._internalSettings = new HashMap<>(beanPropertyWriter._internalSettings);
        }
        this._cfgSerializationType = beanPropertyWriter._cfgSerializationType;
        this._dynamicSerializers = beanPropertyWriter._dynamicSerializers;
        this._suppressNulls = beanPropertyWriter._suppressNulls;
        this._suppressableValue = beanPropertyWriter._suppressableValue;
        this._includeInViews = beanPropertyWriter._includeInViews;
        this._typeSerializer = beanPropertyWriter._typeSerializer;
        this._nonTrivialBaseType = beanPropertyWriter._nonTrivialBaseType;
    }

    protected BeanPropertyWriter(BeanPropertyWriter beanPropertyWriter, SerializedString serializedString) {
        super(beanPropertyWriter);
        this._name = serializedString;
        this._wrapperName = beanPropertyWriter._wrapperName;
        this._member = beanPropertyWriter._member;
        this._contextAnnotations = beanPropertyWriter._contextAnnotations;
        this._declaredType = beanPropertyWriter._declaredType;
        this._accessorMethod = beanPropertyWriter._accessorMethod;
        this._field = beanPropertyWriter._field;
        this._serializer = beanPropertyWriter._serializer;
        this._nullSerializer = beanPropertyWriter._nullSerializer;
        if (beanPropertyWriter._internalSettings != null) {
            this._internalSettings = new HashMap<>(beanPropertyWriter._internalSettings);
        }
        this._cfgSerializationType = beanPropertyWriter._cfgSerializationType;
        this._dynamicSerializers = beanPropertyWriter._dynamicSerializers;
        this._suppressNulls = beanPropertyWriter._suppressNulls;
        this._suppressableValue = beanPropertyWriter._suppressableValue;
        this._includeInViews = beanPropertyWriter._includeInViews;
        this._typeSerializer = beanPropertyWriter._typeSerializer;
        this._nonTrivialBaseType = beanPropertyWriter._nonTrivialBaseType;
    }
}
