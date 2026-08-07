package defpackage;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.a;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.tencent.connect.common.Constants;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public abstract class t60 {
    private static final int MAX_ERROR_STR_LEN = 500;

    private JavaType a(JavaType javaType, String str, PolymorphicTypeValidator polymorphicTypeValidator, int i) throws JsonMappingException {
        MapperConfig<?> config = getConfig();
        PolymorphicTypeValidator.Validity validityValidateSubClassName = polymorphicTypeValidator.validateSubClassName(config, javaType, str.substring(0, i));
        if (validityValidateSubClassName == PolymorphicTypeValidator.Validity.DENIED) {
            return (JavaType) _throwSubtypeNameNotAllowed(javaType, str, polymorphicTypeValidator);
        }
        JavaType javaTypeConstructFromCanonical = getTypeFactory().constructFromCanonical(str);
        if (!javaTypeConstructFromCanonical.isTypeOrSubTypeOf(javaType.getRawClass())) {
            return (JavaType) _throwNotASubtype(javaType, str);
        }
        PolymorphicTypeValidator.Validity validity = PolymorphicTypeValidator.Validity.ALLOWED;
        return (validityValidateSubClassName == validity || polymorphicTypeValidator.validateSubType(config, javaType, javaTypeConstructFromCanonical) == validity) ? javaTypeConstructFromCanonical : (JavaType) _throwSubtypeClassNotAllowed(javaType, str, polymorphicTypeValidator);
    }

    protected String _colonConcat(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        return str + ": " + str2;
    }

    protected String _desc(String str) {
        return str == null ? "[N/A]" : _truncate(str);
    }

    protected final String _format(String str, Object... objArr) {
        return objArr.length > 0 ? String.format(str, objArr) : str;
    }

    protected String _quotedString(String str) {
        return str == null ? "[N/A]" : String.format("\"%s\"", _truncate(str));
    }

    protected <T> T _throwNotASubtype(JavaType javaType, String str) throws JsonMappingException {
        throw invalidTypeIdException(javaType, str, "Not a subtype");
    }

    protected <T> T _throwSubtypeClassNotAllowed(JavaType javaType, String str, PolymorphicTypeValidator polymorphicTypeValidator) throws JsonMappingException {
        throw invalidTypeIdException(javaType, str, "Configured `PolymorphicTypeValidator` (of type " + ay.h(polymorphicTypeValidator) + ") denied resolution");
    }

    protected <T> T _throwSubtypeNameNotAllowed(JavaType javaType, String str, PolymorphicTypeValidator polymorphicTypeValidator) throws JsonMappingException {
        throw invalidTypeIdException(javaType, str, "Configured `PolymorphicTypeValidator` (of type " + ay.h(polymorphicTypeValidator) + ") denied resolution");
    }

    protected final String _truncate(String str) {
        if (str == null) {
            return Constants.STR_EMPTY;
        }
        if (str.length() <= 500) {
            return str;
        }
        return str.substring(0, 500) + "]...[" + str.substring(str.length() - 500);
    }

    public JavaType constructType(Type type) {
        if (type == null) {
            return null;
        }
        return getTypeFactory().constructType(type);
    }

    public f40 converterInstance(d7 d7Var, Object obj) throws JsonMappingException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof f40) {
            return (f40) obj;
        }
        if (!(obj instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + obj.getClass().getName() + "; expected type Converter or Class<Converter> instead");
        }
        Class cls = (Class) obj;
        if (cls == f40.a.class || ay.J(cls)) {
            return null;
        }
        if (f40.class.isAssignableFrom(cls)) {
            MapperConfig config = getConfig();
            config.getHandlerInstantiator();
            return (f40) ay.l(cls, config.canOverrideAccessModifiers());
        }
        throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<Converter>");
    }

    public abstract MapperConfig getConfig();

    public abstract TypeFactory getTypeFactory();

    protected abstract JsonMappingException invalidTypeIdException(JavaType javaType, String str, String str2);

    public ObjectIdGenerator<?> objectIdGeneratorInstance(d7 d7Var, lt1 lt1Var) throws JsonMappingException {
        Class clsC = lt1Var.c();
        MapperConfig config = getConfig();
        config.getHandlerInstantiator();
        return ((ObjectIdGenerator) ay.l(clsC, config.canOverrideAccessModifiers())).forScope(lt1Var.f());
    }

    public a objectIdResolverInstance(d7 d7Var, lt1 lt1Var) {
        Class clsE = lt1Var.e();
        MapperConfig config = getConfig();
        config.getHandlerInstantiator();
        e43.a(ay.l(clsE, config.canOverrideAccessModifiers()));
        return null;
    }

    public abstract Object reportBadDefinition(JavaType javaType, String str);

    public <T> T reportBadDefinition(Class<?> cls, String str) throws JsonMappingException {
        return (T) reportBadDefinition(constructType(cls), str);
    }

    public JavaType resolveAndValidateSubType(JavaType javaType, String str, PolymorphicTypeValidator polymorphicTypeValidator) throws JsonMappingException {
        int iIndexOf = str.indexOf(60);
        if (iIndexOf > 0) {
            return a(javaType, str, polymorphicTypeValidator, iIndexOf);
        }
        MapperConfig<?> config = getConfig();
        PolymorphicTypeValidator.Validity validityValidateSubClassName = polymorphicTypeValidator.validateSubClassName(config, javaType, str);
        if (validityValidateSubClassName == PolymorphicTypeValidator.Validity.DENIED) {
            return (JavaType) _throwSubtypeNameNotAllowed(javaType, str, polymorphicTypeValidator);
        }
        try {
            Class<?> clsFindClass = getTypeFactory().findClass(str);
            if (!javaType.isTypeOrSuperTypeOf(clsFindClass)) {
                return (JavaType) _throwNotASubtype(javaType, str);
            }
            JavaType javaTypeConstructSpecializedType = config.getTypeFactory().constructSpecializedType(javaType, clsFindClass);
            return (validityValidateSubClassName != PolymorphicTypeValidator.Validity.INDETERMINATE || polymorphicTypeValidator.validateSubType(config, javaType, javaTypeConstructSpecializedType) == PolymorphicTypeValidator.Validity.ALLOWED) ? javaTypeConstructSpecializedType : (JavaType) _throwSubtypeClassNotAllowed(javaType, str, polymorphicTypeValidator);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Exception e) {
            throw invalidTypeIdException(javaType, str, String.format("problem: (%s) %s", e.getClass().getName(), ay.o(e)));
        }
    }

    public JavaType resolveSubType(JavaType javaType, String str) throws JsonMappingException {
        if (str.indexOf(60) > 0) {
            JavaType javaTypeConstructFromCanonical = getTypeFactory().constructFromCanonical(str);
            if (javaTypeConstructFromCanonical.isTypeOrSubTypeOf(javaType.getRawClass())) {
                return javaTypeConstructFromCanonical;
            }
        } else {
            try {
                Class<?> clsFindClass = getTypeFactory().findClass(str);
                if (javaType.isTypeOrSuperTypeOf(clsFindClass)) {
                    return getTypeFactory().constructSpecializedType(javaType, clsFindClass);
                }
            } catch (ClassNotFoundException unused) {
                return null;
            } catch (Exception e) {
                throw invalidTypeIdException(javaType, str, String.format("problem: (%s) %s", e.getClass().getName(), ay.o(e)));
            }
        }
        throw invalidTypeIdException(javaType, str, "Not a subtype");
    }
}
