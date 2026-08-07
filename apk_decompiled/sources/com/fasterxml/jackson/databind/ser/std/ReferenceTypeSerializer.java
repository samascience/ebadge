package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.util.NameTransformer;
import defpackage.an2;
import defpackage.f71;
import defpackage.p9;
import defpackage.ph;
import defpackage.w30;
import defpackage.y51;
import defpackage.z63;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class ReferenceTypeSerializer<T> extends StdSerializer<T> implements w30 {
    public static final Object MARKER_FOR_EMPTY = JsonInclude.Include.NON_EMPTY;
    private static final long serialVersionUID = 1;
    protected transient com.fasterxml.jackson.databind.ser.impl.a _dynamicSerializers;
    protected final BeanProperty _property;
    protected final JavaType _referredType;
    protected final boolean _suppressNulls;
    protected final Object _suppressableValue;
    protected final NameTransformer _unwrapper;
    protected final f71 _valueSerializer;
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

    public ReferenceTypeSerializer(ReferenceType referenceType, boolean z, z63 z63Var, f71 f71Var) {
        super(referenceType);
        this._referredType = referenceType.getReferencedType();
        this._property = null;
        this._valueTypeSerializer = z63Var;
        this._valueSerializer = f71Var;
        this._unwrapper = null;
        this._suppressableValue = null;
        this._suppressNulls = false;
        this._dynamicSerializers = com.fasterxml.jackson.databind.ser.impl.a.c();
    }

    private final f71 _findCachedSerializer(an2 an2Var, Class<?> cls) throws JsonMappingException {
        f71 f71VarK = this._dynamicSerializers.k(cls);
        if (f71VarK != null) {
            return f71VarK;
        }
        f71 f71VarFindPrimaryPropertySerializer = this._referredType.hasGenericTypes() ? an2Var.findPrimaryPropertySerializer(an2Var.constructSpecializedType(this._referredType, cls), this._property) : an2Var.findPrimaryPropertySerializer(cls, this._property);
        NameTransformer nameTransformer = this._unwrapper;
        if (nameTransformer != null) {
            f71VarFindPrimaryPropertySerializer = f71VarFindPrimaryPropertySerializer.unwrappingSerializer(nameTransformer);
        }
        f71 f71Var = f71VarFindPrimaryPropertySerializer;
        this._dynamicSerializers = this._dynamicSerializers.j(cls, f71Var);
        return f71Var;
    }

    private final f71 _findSerializer(an2 an2Var, JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        return an2Var.findPrimaryPropertySerializer(javaType, beanProperty);
    }

    protected abstract Object _getReferenced(T t);

    protected abstract Object _getReferencedIfPresent(T t);

    protected abstract boolean _isValuePresent(T t);

    protected boolean _useStatic(an2 an2Var, BeanProperty beanProperty, JavaType javaType) {
        if (javaType.isJavaLangObject()) {
            return false;
        }
        if (javaType.isFinal() || javaType.useStaticType()) {
            return true;
        }
        AnnotationIntrospector annotationIntrospector = an2Var.getAnnotationIntrospector();
        if (annotationIntrospector != null && beanProperty != null && beanProperty.getMember() != null) {
            JsonSerialize.Typing typingFindSerializationTyping = annotationIntrospector.findSerializationTyping(beanProperty.getMember());
            if (typingFindSerializationTyping == JsonSerialize.Typing.STATIC) {
                return true;
            }
            if (typingFindSerializationTyping == JsonSerialize.Typing.DYNAMIC) {
                return false;
            }
        }
        return an2Var.isEnabled(MapperFeature.USE_STATIC_TYPING);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void acceptJsonFormatVisitor(y51 y51Var, JavaType javaType) throws JsonMappingException {
        f71 f71Var_findSerializer = this._valueSerializer;
        if (f71Var_findSerializer == null) {
            f71Var_findSerializer = _findSerializer(y51Var.b(), this._referredType, this._property);
            NameTransformer nameTransformer = this._unwrapper;
            if (nameTransformer != null) {
                f71Var_findSerializer = f71Var_findSerializer.unwrappingSerializer(nameTransformer);
            }
        }
        f71Var_findSerializer.acceptJsonFormatVisitor(y51Var, this._referredType);
    }

    @Override // defpackage.w30
    public f71 createContextual(an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        JsonInclude.Value valueFindPropertyInclusion;
        JsonInclude.Include contentInclusion;
        Object objB;
        z63 z63VarA = this._valueTypeSerializer;
        if (z63VarA != null) {
            z63VarA = z63VarA.a(beanProperty);
        }
        f71 f71VarFindAnnotatedContentSerializer = findAnnotatedContentSerializer(an2Var, beanProperty);
        if (f71VarFindAnnotatedContentSerializer == null) {
            f71VarFindAnnotatedContentSerializer = this._valueSerializer;
            if (f71VarFindAnnotatedContentSerializer != null) {
                f71VarFindAnnotatedContentSerializer = an2Var.handlePrimaryContextualization(f71VarFindAnnotatedContentSerializer, beanProperty);
            } else if (_useStatic(an2Var, beanProperty, this._referredType)) {
                f71VarFindAnnotatedContentSerializer = _findSerializer(an2Var, this._referredType, beanProperty);
            }
        }
        ReferenceTypeSerializer<T> referenceTypeSerializerWithResolved = (this._property == beanProperty && this._valueTypeSerializer == z63VarA && this._valueSerializer == f71VarFindAnnotatedContentSerializer) ? this : withResolved(beanProperty, z63VarA, f71VarFindAnnotatedContentSerializer, this._unwrapper);
        if (beanProperty == null || (valueFindPropertyInclusion = beanProperty.findPropertyInclusion(an2Var.getConfig(), handledType())) == null || (contentInclusion = valueFindPropertyInclusion.getContentInclusion()) == JsonInclude.Include.USE_DEFAULTS) {
            return referenceTypeSerializerWithResolved;
        }
        int i = a.a[contentInclusion.ordinal()];
        boolean zIncludeFilterSuppressNulls = true;
        if (i != 1) {
            objB = null;
            if (i != 2) {
                if (i == 3) {
                    objB = MARKER_FOR_EMPTY;
                } else if (i == 4) {
                    objB = an2Var.includeFilterInstance(null, valueFindPropertyInclusion.getContentFilter());
                    if (objB != null) {
                        zIncludeFilterSuppressNulls = an2Var.includeFilterSuppressNulls(objB);
                    }
                } else if (i != 5) {
                    zIncludeFilterSuppressNulls = false;
                }
            } else if (this._referredType.isReferenceType()) {
                objB = MARKER_FOR_EMPTY;
            }
        } else {
            objB = ph.b(this._referredType);
            if (objB != null && objB.getClass().isArray()) {
                objB = p9.b(objB);
            }
        }
        return (this._suppressableValue == objB && this._suppressNulls == zIncludeFilterSuppressNulls) ? referenceTypeSerializerWithResolved : referenceTypeSerializerWithResolved.withContentInclusion(objB, zIncludeFilterSuppressNulls);
    }

    public JavaType getReferredType() {
        return this._referredType;
    }

    @Override // defpackage.f71
    public boolean isEmpty(an2 an2Var, T t) {
        if (!_isValuePresent(t)) {
            return true;
        }
        Object obj_getReferenced = _getReferenced(t);
        if (obj_getReferenced == null) {
            return this._suppressNulls;
        }
        if (this._suppressableValue == null) {
            return false;
        }
        f71 f71Var_findCachedSerializer = this._valueSerializer;
        if (f71Var_findCachedSerializer == null) {
            try {
                f71Var_findCachedSerializer = _findCachedSerializer(an2Var, obj_getReferenced.getClass());
            } catch (JsonMappingException e) {
                throw new RuntimeJsonMappingException(e);
            }
        }
        Object obj = this._suppressableValue;
        return obj == MARKER_FOR_EMPTY ? f71Var_findCachedSerializer.isEmpty(an2Var, obj_getReferenced) : obj.equals(obj_getReferenced);
    }

    @Override // defpackage.f71
    public boolean isUnwrappingSerializer() {
        return this._unwrapper != null;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(T t, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        Object obj_getReferencedIfPresent = _getReferencedIfPresent(t);
        if (obj_getReferencedIfPresent == null) {
            if (this._unwrapper == null) {
                an2Var.defaultSerializeNull(jsonGenerator);
                return;
            }
            return;
        }
        f71 f71Var_findCachedSerializer = this._valueSerializer;
        if (f71Var_findCachedSerializer == null) {
            f71Var_findCachedSerializer = _findCachedSerializer(an2Var, obj_getReferencedIfPresent.getClass());
        }
        z63 z63Var = this._valueTypeSerializer;
        if (z63Var != null) {
            f71Var_findCachedSerializer.serializeWithType(obj_getReferencedIfPresent, jsonGenerator, an2Var, z63Var);
        } else {
            f71Var_findCachedSerializer.serialize(obj_getReferencedIfPresent, jsonGenerator, an2Var);
        }
    }

    @Override // defpackage.f71
    public void serializeWithType(T t, JsonGenerator jsonGenerator, an2 an2Var, z63 z63Var) throws IOException {
        Object obj_getReferencedIfPresent = _getReferencedIfPresent(t);
        if (obj_getReferencedIfPresent == null) {
            if (this._unwrapper == null) {
                an2Var.defaultSerializeNull(jsonGenerator);
            }
        } else {
            f71 f71Var_findCachedSerializer = this._valueSerializer;
            if (f71Var_findCachedSerializer == null) {
                f71Var_findCachedSerializer = _findCachedSerializer(an2Var, obj_getReferencedIfPresent.getClass());
            }
            f71Var_findCachedSerializer.serializeWithType(obj_getReferencedIfPresent, jsonGenerator, an2Var, z63Var);
        }
    }

    @Override // defpackage.f71
    public f71 unwrappingSerializer(NameTransformer nameTransformer) {
        f71 f71VarUnwrappingSerializer = this._valueSerializer;
        if (f71VarUnwrappingSerializer != null && (f71VarUnwrappingSerializer = f71VarUnwrappingSerializer.unwrappingSerializer(nameTransformer)) == this._valueSerializer) {
            return this;
        }
        NameTransformer nameTransformer2 = this._unwrapper;
        if (nameTransformer2 != null) {
            nameTransformer = NameTransformer.chainedTransformer(nameTransformer, nameTransformer2);
        }
        return (this._valueSerializer == f71VarUnwrappingSerializer && this._unwrapper == nameTransformer) ? this : withResolved(this._property, this._valueTypeSerializer, f71VarUnwrappingSerializer, nameTransformer);
    }

    public abstract ReferenceTypeSerializer<T> withContentInclusion(Object obj, boolean z);

    protected abstract ReferenceTypeSerializer<T> withResolved(BeanProperty beanProperty, z63 z63Var, f71 f71Var, NameTransformer nameTransformer);

    protected ReferenceTypeSerializer(ReferenceTypeSerializer<?> referenceTypeSerializer, BeanProperty beanProperty, z63 z63Var, f71 f71Var, NameTransformer nameTransformer, Object obj, boolean z) {
        super(referenceTypeSerializer);
        this._referredType = referenceTypeSerializer._referredType;
        this._dynamicSerializers = com.fasterxml.jackson.databind.ser.impl.a.c();
        this._property = beanProperty;
        this._valueTypeSerializer = z63Var;
        this._valueSerializer = f71Var;
        this._unwrapper = nameTransformer;
        this._suppressableValue = obj;
        this._suppressNulls = z;
    }
}
