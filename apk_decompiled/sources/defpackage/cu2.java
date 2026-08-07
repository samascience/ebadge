package defpackage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsDeductionTypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsExternalTypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsWrapperTypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public class cu2 implements x63 {
    protected n63 _customIdResolver;
    protected Class<?> _defaultImpl;
    protected JsonTypeInfo.Id _idType;
    protected JsonTypeInfo.As _includeAs;
    protected boolean _typeIdVisible;
    protected String _typeProperty;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[JsonTypeInfo.Id.values().length];
            b = iArr;
            try {
                iArr[JsonTypeInfo.Id.DEDUCTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[JsonTypeInfo.Id.CLASS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[JsonTypeInfo.Id.MINIMAL_CLASS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[JsonTypeInfo.Id.NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[JsonTypeInfo.Id.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[JsonTypeInfo.Id.CUSTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[JsonTypeInfo.As.values().length];
            a = iArr2;
            try {
                iArr2[JsonTypeInfo.As.WRAPPER_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[JsonTypeInfo.As.PROPERTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[JsonTypeInfo.As.WRAPPER_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[JsonTypeInfo.As.EXTERNAL_PROPERTY.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[JsonTypeInfo.As.EXISTING_PROPERTY.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public cu2() {
        this._typeIdVisible = false;
    }

    public static cu2 noTypeInfoBuilder() {
        return new cu2().init(JsonTypeInfo.Id.NONE, (n63) null);
    }

    protected boolean allowPrimitiveTypes(MapperConfig<?> mapperConfig, JavaType javaType) {
        return false;
    }

    @Override // defpackage.x63
    public m63 buildTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, Collection collection) {
        if (this._idType == JsonTypeInfo.Id.NONE) {
            return null;
        }
        if (javaType.isPrimitive() && !allowPrimitiveTypes(deserializationConfig, javaType)) {
            return null;
        }
        n63 n63VarIdResolver = idResolver(deserializationConfig, javaType, verifyBaseTypeValidity(deserializationConfig, javaType), collection, false, true);
        JavaType javaTypeDefineDefaultImpl = defineDefaultImpl(deserializationConfig, javaType);
        if (this._idType == JsonTypeInfo.Id.DEDUCTION) {
            return new AsDeductionTypeDeserializer(javaType, n63VarIdResolver, javaTypeDefineDefaultImpl, deserializationConfig, collection);
        }
        int i = a.a[this._includeAs.ordinal()];
        if (i == 1) {
            return new AsArrayTypeDeserializer(javaType, n63VarIdResolver, this._typeProperty, this._typeIdVisible, javaTypeDefineDefaultImpl);
        }
        if (i != 2) {
            if (i == 3) {
                return new AsWrapperTypeDeserializer(javaType, n63VarIdResolver, this._typeProperty, this._typeIdVisible, javaTypeDefineDefaultImpl);
            }
            if (i == 4) {
                return new AsExternalTypeDeserializer(javaType, n63VarIdResolver, this._typeProperty, this._typeIdVisible, javaTypeDefineDefaultImpl);
            }
            if (i != 5) {
                throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this._includeAs);
            }
        }
        return new AsPropertyTypeDeserializer(javaType, n63VarIdResolver, this._typeProperty, this._typeIdVisible, javaTypeDefineDefaultImpl, this._includeAs);
    }

    @Override // defpackage.x63
    public z63 buildTypeSerializer(SerializationConfig serializationConfig, JavaType javaType, Collection collection) {
        if (this._idType == JsonTypeInfo.Id.NONE) {
            return null;
        }
        if (javaType.isPrimitive() && !allowPrimitiveTypes(serializationConfig, javaType)) {
            return null;
        }
        if (this._idType == JsonTypeInfo.Id.DEDUCTION) {
            return ja.n();
        }
        n63 n63VarIdResolver = idResolver(serializationConfig, javaType, subTypeValidator(serializationConfig), collection, true, false);
        int i = a.a[this._includeAs.ordinal()];
        if (i == 1) {
            return new ia(n63VarIdResolver, null);
        }
        if (i == 2) {
            return new ma(n63VarIdResolver, null, this._typeProperty);
        }
        if (i == 3) {
            return new na(n63VarIdResolver, null);
        }
        if (i == 4) {
            return new la(n63VarIdResolver, null, this._typeProperty);
        }
        if (i == 5) {
            return new ka(n63VarIdResolver, null, this._typeProperty);
        }
        throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this._includeAs);
    }

    @Override // defpackage.x63
    public /* bridge */ /* synthetic */ x63 defaultImpl(Class cls) {
        return defaultImpl((Class<?>) cls);
    }

    protected JavaType defineDefaultImpl(DeserializationConfig deserializationConfig, JavaType javaType) {
        Class<?> cls = this._defaultImpl;
        if (cls != null) {
            if (cls == Void.class || cls == dr1.class) {
                return deserializationConfig.getTypeFactory().constructType(this._defaultImpl);
            }
            if (javaType.hasRawClass(cls)) {
                return javaType;
            }
            if (javaType.isTypeOrSuperTypeOf(this._defaultImpl)) {
                return deserializationConfig.getTypeFactory().constructSpecializedType(javaType, this._defaultImpl);
            }
            if (javaType.hasRawClass(this._defaultImpl)) {
                return javaType;
            }
        }
        if (!deserializationConfig.isEnabled(MapperFeature.USE_BASE_TYPE_AS_DEFAULT_IMPL) || javaType.isAbstract()) {
            return null;
        }
        return javaType;
    }

    @Override // defpackage.x63
    public Class<?> getDefaultImpl() {
        return this._defaultImpl;
    }

    public String getTypeProperty() {
        return this._typeProperty;
    }

    protected n63 idResolver(MapperConfig<?> mapperConfig, JavaType javaType, PolymorphicTypeValidator polymorphicTypeValidator, Collection<NamedType> collection, boolean z, boolean z2) {
        n63 n63Var = this._customIdResolver;
        if (n63Var != null) {
            return n63Var;
        }
        JsonTypeInfo.Id id = this._idType;
        if (id == null) {
            throw new IllegalStateException("Cannot build, 'init()' not yet called");
        }
        int i = a.b[id.ordinal()];
        if (i == 1 || i == 2) {
            return wx.i(javaType, mapperConfig, polymorphicTypeValidator);
        }
        if (i == 3) {
            return nk1.j(javaType, mapperConfig, polymorphicTypeValidator);
        }
        if (i == 4) {
            return t63.i(mapperConfig, javaType, collection, z, z2);
        }
        if (i == 5) {
            return null;
        }
        throw new IllegalStateException("Do not know how to construct standard type id resolver for idType: " + this._idType);
    }

    public boolean isTypeIdVisible() {
        return this._typeIdVisible;
    }

    protected PolymorphicTypeValidator reportInvalidBaseType(MapperConfig<?> mapperConfig, JavaType javaType, PolymorphicTypeValidator polymorphicTypeValidator) {
        throw new IllegalArgumentException(String.format("Configured `PolymorphicTypeValidator` (of type %s) denied resolution of all subtypes of base type %s", ay.h(polymorphicTypeValidator), ay.h(javaType.getRawClass())));
    }

    public PolymorphicTypeValidator subTypeValidator(MapperConfig mapperConfig) {
        return mapperConfig.getPolymorphicTypeValidator();
    }

    protected PolymorphicTypeValidator verifyBaseTypeValidity(MapperConfig<?> mapperConfig, JavaType javaType) {
        PolymorphicTypeValidator polymorphicTypeValidatorSubTypeValidator = subTypeValidator(mapperConfig);
        JsonTypeInfo.Id id = this._idType;
        if (id == JsonTypeInfo.Id.CLASS || id == JsonTypeInfo.Id.MINIMAL_CLASS) {
            PolymorphicTypeValidator.Validity validityValidateBaseType = polymorphicTypeValidatorSubTypeValidator.validateBaseType(mapperConfig, javaType);
            if (validityValidateBaseType == PolymorphicTypeValidator.Validity.DENIED) {
                return reportInvalidBaseType(mapperConfig, javaType, polymorphicTypeValidatorSubTypeValidator);
            }
            if (validityValidateBaseType == PolymorphicTypeValidator.Validity.ALLOWED) {
                return LaissezFaireSubTypeValidator.instance;
            }
        }
        return polymorphicTypeValidatorSubTypeValidator;
    }

    @Override // defpackage.x63
    public cu2 defaultImpl(Class<?> cls) {
        this._defaultImpl = cls;
        return this;
    }

    @Override // defpackage.x63
    public cu2 inclusion(JsonTypeInfo.As as) {
        if (as == null) {
            throw new IllegalArgumentException("includeAs cannot be null");
        }
        this._includeAs = as;
        return this;
    }

    @Override // defpackage.x63
    public cu2 init(JsonTypeInfo.Id id, n63 n63Var) {
        if (id == null) {
            throw new IllegalArgumentException("idType cannot be null");
        }
        this._idType = id;
        this._customIdResolver = n63Var;
        this._typeProperty = id.getDefaultPropertyName();
        return this;
    }

    @Override // defpackage.x63
    public cu2 typeIdVisibility(boolean z) {
        this._typeIdVisible = z;
        return this;
    }

    @Override // defpackage.x63
    public cu2 typeProperty(String str) {
        if (str == null || str.isEmpty()) {
            str = this._idType.getDefaultPropertyName();
        }
        this._typeProperty = str;
        return this;
    }

    @Override // defpackage.x63
    public cu2 withDefaultImpl(Class cls) {
        if (this._defaultImpl == cls) {
            return this;
        }
        ay.n0(cu2.class, this, "withDefaultImpl");
        return new cu2(this, cls);
    }

    protected cu2(cu2 cu2Var, Class cls) {
        this._typeIdVisible = false;
        this._idType = cu2Var._idType;
        this._includeAs = cu2Var._includeAs;
        this._typeProperty = cu2Var._typeProperty;
        this._typeIdVisible = cu2Var._typeIdVisible;
        this._customIdResolver = cu2Var._customIdResolver;
        this._defaultImpl = cls;
    }
}
