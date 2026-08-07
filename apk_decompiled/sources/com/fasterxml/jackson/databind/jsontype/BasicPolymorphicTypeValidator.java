package com.fasterxml.jackson.databind.jsontype;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import java.io.Serializable;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class BasicPolymorphicTypeValidator extends PolymorphicTypeValidator.Base implements Serializable {
    private static final long serialVersionUID = 1;
    protected final c[] _baseTypeMatchers;
    protected final Set<Class<?>> _invalidBaseTypes;
    protected final c[] _subClassMatchers;
    protected final b[] _subTypeNameMatchers;

    public static class a {
        protected a() {
        }
    }

    public static abstract class b {
    }

    public static abstract class c {
    }

    protected BasicPolymorphicTypeValidator(Set<Class<?>> set, c[] cVarArr, b[] bVarArr, c[] cVarArr2) {
        this._invalidBaseTypes = set;
        this._baseTypeMatchers = cVarArr;
        this._subTypeNameMatchers = bVarArr;
        this._subClassMatchers = cVarArr2;
    }

    public static a builder() {
        return new a();
    }

    @Override // com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator.Base, com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator
    public PolymorphicTypeValidator.Validity validateBaseType(MapperConfig<?> mapperConfig, JavaType javaType) {
        Class<?> rawClass = javaType.getRawClass();
        Set<Class<?>> set = this._invalidBaseTypes;
        if (set != null && set.contains(rawClass)) {
            return PolymorphicTypeValidator.Validity.DENIED;
        }
        c[] cVarArr = this._baseTypeMatchers;
        if (cVarArr == null || cVarArr.length <= 0) {
            return PolymorphicTypeValidator.Validity.INDETERMINATE;
        }
        c cVar = cVarArr[0];
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator.Base, com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator
    public PolymorphicTypeValidator.Validity validateSubClassName(MapperConfig<?> mapperConfig, JavaType javaType, String str) throws JsonMappingException {
        b[] bVarArr = this._subTypeNameMatchers;
        if (bVarArr == null || bVarArr.length <= 0) {
            return PolymorphicTypeValidator.Validity.INDETERMINATE;
        }
        b bVar = bVarArr[0];
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator.Base, com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator
    public PolymorphicTypeValidator.Validity validateSubType(MapperConfig<?> mapperConfig, JavaType javaType, JavaType javaType2) throws JsonMappingException {
        if (this._subClassMatchers != null) {
            javaType2.getRawClass();
            c[] cVarArr = this._subClassMatchers;
            if (cVarArr.length > 0) {
                c cVar = cVarArr[0];
                throw null;
            }
        }
        return PolymorphicTypeValidator.Validity.INDETERMINATE;
    }
}
