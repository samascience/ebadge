package com.fasterxml.classmate;

import com.fasterxml.classmate.util.ClassKey;
import com.fasterxml.classmate.util.ResolvedTypeCache;
import com.jieli.jl_rcsp.constant.WatchConstant;
import defpackage.dg2;
import defpackage.gg2;
import defpackage.jg2;
import defpackage.lg2;
import defpackage.mg2;
import defpackage.og2;
import defpackage.pg2;
import defpackage.u63;
import defpackage.zx;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TypeResolver implements Serializable {
    protected final ResolvedTypeCache _resolvedTypes;
    private static final og2[] NO_TYPES = new og2[0];
    private static final jg2 sJavaLangObject = jg2.n(Object.class, null, null, null);
    protected static final HashMap<ClassKey, og2> _primitiveTypes = new HashMap<>(16);

    static {
        for (lg2 lg2Var : lg2.n()) {
            _primitiveTypes.put(new ClassKey(lg2Var.g()), lg2Var);
        }
        HashMap<ClassKey, og2> map = _primitiveTypes;
        map.put(new ClassKey(Void.TYPE), lg2.o());
        map.put(new ClassKey(Object.class), sJavaLangObject);
    }

    public TypeResolver() {
        this(ResolvedTypeCache.lruCache(200));
    }

    private og2 _constructType(zx zxVar, Class<?> cls, b bVar) {
        if (cls.isArray()) {
            return new dg2(cls, bVar, _fromAny(zxVar, cls.getComponentType(), bVar));
        }
        if (!bVar.g() && cls.getTypeParameters().length == 0) {
            bVar = b.b();
        }
        return cls.isInterface() ? new gg2(cls, bVar, _resolveSuperInterfaces(zxVar, cls, bVar)) : new jg2(cls, bVar, _resolveSuperClass(zxVar, cls, bVar), _resolveSuperInterfaces(zxVar, cls, bVar));
    }

    private og2 _fromAny(zx zxVar, Type type, b bVar) {
        if (type instanceof Class) {
            return _fromClass(zxVar, (Class) type, bVar);
        }
        if (type instanceof ParameterizedType) {
            return _fromParamType(zxVar, (ParameterizedType) type, bVar);
        }
        if (type instanceof og2) {
            return (og2) type;
        }
        if (type instanceof GenericType) {
            return _fromGenericType(zxVar, (GenericType) type, bVar);
        }
        if (type instanceof GenericArrayType) {
            return _fromArrayType(zxVar, (GenericArrayType) type, bVar);
        }
        if (type instanceof TypeVariable) {
            return _fromVariable(zxVar, (TypeVariable) type, bVar);
        }
        if (type instanceof WildcardType) {
            return _fromWildcard(zxVar, (WildcardType) type, bVar);
        }
        throw new IllegalArgumentException("Unrecognized type class: " + type.getClass().getName());
    }

    private og2 _fromArrayType(zx zxVar, GenericArrayType genericArrayType, b bVar) {
        og2 og2Var_fromAny = _fromAny(zxVar, genericArrayType.getGenericComponentType(), bVar);
        return new dg2(Array.newInstance((Class<?>) og2Var_fromAny.g(), 0).getClass(), bVar, og2Var_fromAny);
    }

    private og2 _fromClass(zx zxVar, Class<?> cls, b bVar) {
        zx zxVarB;
        og2 og2Var_constructType;
        og2 og2Var = _primitiveTypes.get(new ClassKey(cls));
        if (og2Var != null) {
            return og2Var;
        }
        if (zxVar == null) {
            zxVarB = new zx(cls);
        } else {
            zx zxVarC = zxVar.c(cls);
            if (zxVarC != null) {
                mg2 mg2Var = new mg2(cls, bVar);
                zxVarC.a(mg2Var);
                return mg2Var;
            }
            zxVarB = zxVar.b(cls);
        }
        pg2 pg2VarKey = this._resolvedTypes.key(cls, bVar.i());
        if (pg2VarKey == null) {
            og2Var_constructType = _constructType(zxVarB, cls, bVar);
        } else {
            og2 og2VarFind = this._resolvedTypes.find(pg2VarKey);
            if (og2VarFind == null) {
                og2Var_constructType = _constructType(zxVarB, cls, bVar);
                this._resolvedTypes.put(pg2VarKey, og2Var_constructType);
            } else {
                og2Var_constructType = og2VarFind;
            }
        }
        zxVarB.d(og2Var_constructType);
        return og2Var_constructType;
    }

    private og2 _fromGenericType(zx zxVar, GenericType<?> genericType, b bVar) {
        og2 og2VarE = _fromClass(zxVar, genericType.getClass(), bVar).e(GenericType.class);
        if (og2VarE == null) {
            throw new IllegalArgumentException("Unparameterized GenericType instance (" + genericType.getClass().getName() + ")");
        }
        og2[] og2VarArrI = og2VarE.l().i();
        if (og2VarArrI.length != 0) {
            return og2VarArrI[0];
        }
        throw new IllegalArgumentException("Unparameterized GenericType instance (" + genericType.getClass().getName() + ")");
    }

    private og2 _fromParamType(zx zxVar, ParameterizedType parameterizedType, b bVar) {
        Class<?> cls = (Class) parameterizedType.getRawType();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        int length = actualTypeArguments.length;
        og2[] og2VarArr = new og2[length];
        for (int i = 0; i < length; i++) {
            og2VarArr[i] = _fromAny(zxVar, actualTypeArguments[i], bVar);
        }
        return _fromClass(zxVar, cls, b.a(cls, og2VarArr));
    }

    private og2 _fromVariable(zx zxVar, TypeVariable<?> typeVariable, b bVar) {
        String name = typeVariable.getName();
        og2 og2VarC = bVar.c(name);
        if (og2VarC != null) {
            return og2VarC;
        }
        if (bVar.f(name)) {
            return sJavaLangObject;
        }
        return _fromAny(zxVar, typeVariable.getBounds()[0], bVar.j(name));
    }

    private og2 _fromWildcard(zx zxVar, WildcardType wildcardType, b bVar) {
        return _fromAny(zxVar, wildcardType.getUpperBounds()[0], bVar);
    }

    private og2 _resolveSuperClass(zx zxVar, Class<?> cls, b bVar) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return _fromAny(zxVar, genericSuperclass, bVar);
    }

    private og2[] _resolveSuperInterfaces(zx zxVar, Class<?> cls, b bVar) {
        Type[] genericInterfaces = cls.getGenericInterfaces();
        if (genericInterfaces == null || genericInterfaces.length == 0) {
            return NO_TYPES;
        }
        int length = genericInterfaces.length;
        og2[] og2VarArr = new og2[length];
        for (int i = 0; i < length; i++) {
            og2VarArr[i] = _fromAny(zxVar, genericInterfaces[i], bVar);
        }
        return og2VarArr;
    }

    private void _resolveTypePlaceholders(og2 og2Var, og2 og2Var2) throws IllegalArgumentException {
        List listM = og2Var.m();
        List listM2 = og2Var2.m();
        int size = listM.size();
        for (int i = 0; i < size; i++) {
            og2 og2Var3 = (og2) listM.get(i);
            og2 og2Var4 = (og2) listM2.get(i);
            if (!_verifyAndResolve(og2Var3, og2Var4)) {
                throw new IllegalArgumentException("Type parameter #" + (i + 1) + WatchConstant.FAT_FS_ROOT + size + " differs; expected " + og2Var3.f() + ", got " + og2Var4.f());
            }
        }
    }

    private boolean _verifyAndResolve(og2 og2Var, og2 og2Var2) {
        if (og2Var2 instanceof u63) {
            ((u63) og2Var2).o(og2Var);
            return true;
        }
        if (og2Var.g() != og2Var2.g()) {
            return false;
        }
        List listM = og2Var.m();
        List listM2 = og2Var2.m();
        int size = listM.size();
        for (int i = 0; i < size; i++) {
            if (!_verifyAndResolve((og2) listM.get(i), (og2) listM2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSelfReference(og2 og2Var) {
        return og2Var instanceof mg2;
    }

    public dg2 arrayType(Type type) {
        og2 og2VarResolve = resolve(b.b(), type);
        return new dg2(Array.newInstance((Class<?>) og2VarResolve.g(), 0).getClass(), b.b(), og2VarResolve);
    }

    public og2 resolve(Type type, Type... typeArr) {
        b bVarB;
        Class clsG;
        boolean z = typeArr == null || typeArr.length == 0;
        if (type instanceof Class) {
            bVarB = b.b();
            if (z) {
                return _fromClass(null, (Class) type, bVarB);
            }
            clsG = (Class) type;
        } else if (type instanceof GenericType) {
            bVarB = b.b();
            if (z) {
                return _fromGenericType(null, (GenericType) type, bVarB);
            }
            clsG = _fromAny(null, type, bVarB).g();
        } else if (type instanceof og2) {
            og2 og2Var = (og2) type;
            if (z) {
                return og2Var;
            }
            bVarB = og2Var.l();
            clsG = og2Var.g();
        } else {
            bVarB = b.b();
            if (z) {
                return resolve(bVarB, type);
            }
            clsG = _fromAny(null, type, bVarB).g();
        }
        int length = typeArr.length;
        og2[] og2VarArr = new og2[length];
        for (int i = 0; i < length; i++) {
            og2VarArr[i] = _fromAny(null, typeArr[i], bVarB);
        }
        return _fromClass(null, clsG, b.a(clsG, og2VarArr));
    }

    public og2 resolveSubtype(og2 og2Var, Class<?> cls) throws UnsupportedOperationException, IllegalArgumentException {
        u63[] u63VarArr;
        b bVarB;
        og2 og2VarK = og2Var.k();
        if (og2VarK != null) {
            og2Var = og2VarK;
        }
        Class<?> clsG = og2Var.g();
        if (clsG == cls) {
            return og2Var;
        }
        if (!og2Var.d()) {
            throw new UnsupportedOperationException("Can not subtype primitive or array types (type " + og2Var.h() + ")");
        }
        if (!clsG.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Can not sub-class " + og2Var.f() + " into " + cls.getName());
        }
        int length = cls.getTypeParameters().length;
        if (length == 0) {
            bVarB = b.b();
            u63VarArr = null;
        } else {
            u63[] u63VarArr2 = new u63[length];
            og2[] og2VarArr = new og2[length];
            for (int i = 0; i < length; i++) {
                u63 u63Var = new u63(i);
                u63VarArr2[i] = u63Var;
                og2VarArr[i] = u63Var;
            }
            b bVarA = b.a(cls, og2VarArr);
            u63VarArr = u63VarArr2;
            bVarB = bVarA;
        }
        og2 og2Var_fromClass = _fromClass(null, cls, bVarB);
        og2 og2VarE = og2Var_fromClass.e(clsG);
        if (og2VarE == null) {
            throw new IllegalArgumentException("Internal error: unable to locate supertype (" + cls.getName() + ") for type " + og2Var.f());
        }
        _resolveTypePlaceholders(og2Var, og2VarE);
        if (length == 0) {
            return og2Var_fromClass;
        }
        og2[] og2VarArr2 = new og2[length];
        for (int i2 = 0; i2 < length; i2++) {
            og2 og2VarN = u63VarArr[i2].n();
            if (og2VarN == null) {
                throw new IllegalArgumentException("Failed to find type parameter #" + (i2 + 1) + WatchConstant.FAT_FS_ROOT + length + " for " + cls.getName());
            }
            og2VarArr2[i2] = og2VarN;
        }
        return resolve(cls, og2VarArr2);
    }

    public TypeResolver(ResolvedTypeCache resolvedTypeCache) {
        this._resolvedTypes = resolvedTypeCache;
    }

    public og2 resolve(b bVar, Type type) {
        return _fromAny(null, type, bVar);
    }
}
