package defpackage;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.EnumMap;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes.dex */
public class wx extends o63 {
    protected final PolymorphicTypeValidator c;

    public wx(JavaType javaType, TypeFactory typeFactory, PolymorphicTypeValidator polymorphicTypeValidator) {
        super(javaType, typeFactory);
        this.c = polymorphicTypeValidator;
    }

    public static wx i(JavaType javaType, MapperConfig mapperConfig, PolymorphicTypeValidator polymorphicTypeValidator) {
        return new wx(javaType, mapperConfig.getTypeFactory(), polymorphicTypeValidator);
    }

    @Override // defpackage.n63
    public String a(Object obj) {
        return g(obj, obj.getClass(), this.a);
    }

    @Override // defpackage.n63
    public String b() {
        return "class name used as type id";
    }

    @Override // defpackage.n63
    public JavaType d(t60 t60Var, String str) {
        return h(str, t60Var);
    }

    @Override // defpackage.n63
    public String e(Object obj, Class cls) {
        return g(obj, cls, this.a);
    }

    protected String g(Object obj, Class cls, TypeFactory typeFactory) {
        if (ay.L(cls) && !cls.isEnum()) {
            cls = cls.getSuperclass();
        }
        String name = cls.getName();
        if (!name.startsWith("java.util.")) {
            return (name.indexOf(36) < 0 || ay.E(cls) == null || ay.E(this.b.getRawClass()) != null) ? name : this.b.getRawClass().getName();
        }
        if (obj instanceof EnumSet) {
            return typeFactory.constructCollectionType(EnumSet.class, ay.u((EnumSet) obj)).toCanonical();
        }
        return obj instanceof EnumMap ? typeFactory.constructMapType(EnumMap.class, ay.t((EnumMap) obj), Object.class).toCanonical() : name;
    }

    protected JavaType h(String str, t60 t60Var) throws JsonMappingException {
        JavaType javaTypeResolveAndValidateSubType = t60Var.resolveAndValidateSubType(this.b, str, this.c);
        return (javaTypeResolveAndValidateSubType == null && (t60Var instanceof DeserializationContext)) ? ((DeserializationContext) t60Var).handleUnknownTypeId(this.b, str, this, "no such class found") : javaTypeResolveAndValidateSubType;
    }
}
