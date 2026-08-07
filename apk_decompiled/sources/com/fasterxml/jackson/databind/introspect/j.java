package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
abstract class j {
    static TypeBindings a(Method method, JavaType javaType, m mVar) {
        JavaType boundType;
        TypeVariable typeVariableB;
        TypeVariable<Method>[] typeParameters = method.getTypeParameters();
        if (typeParameters.length == 0 || javaType.getBindings().isEmpty()) {
            return null;
        }
        Type genericReturnType = method.getGenericReturnType();
        if (!(genericReturnType instanceof ParameterizedType)) {
            return null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
        if (!Objects.equals(javaType.getRawClass(), parameterizedType.getRawType())) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        ArrayList arrayList = new ArrayList(typeParameters.length);
        ArrayList arrayList2 = new ArrayList(typeParameters.length);
        for (int i = 0; i < actualTypeArguments.length; i++) {
            TypeVariable typeVariableD = d(actualTypeArguments[i]);
            if (typeVariableD != null) {
                String name = typeVariableD.getName();
                if (name == null || (boundType = javaType.getBindings().getBoundType(i)) == null || (typeVariableB = b(typeParameters, name)) == null) {
                    return null;
                }
                if (g(mVar, boundType, typeVariableB.getBounds())) {
                    int iIndexOf = arrayList.indexOf(name);
                    if (iIndexOf != -1) {
                        JavaType javaType2 = (JavaType) arrayList2.get(iIndexOf);
                        if (boundType.equals(javaType2)) {
                            continue;
                        } else {
                            boolean zIsTypeOrSubTypeOf = javaType2.isTypeOrSubTypeOf(boundType.getRawClass());
                            boolean zIsTypeOrSubTypeOf2 = boundType.isTypeOrSubTypeOf(javaType2.getRawClass());
                            if (!zIsTypeOrSubTypeOf && !zIsTypeOrSubTypeOf2) {
                                return null;
                            }
                            if ((zIsTypeOrSubTypeOf ^ zIsTypeOrSubTypeOf2) && zIsTypeOrSubTypeOf2) {
                                arrayList2.set(iIndexOf, boundType);
                            }
                        }
                    } else {
                        arrayList.add(name);
                        arrayList2.add(boundType);
                    }
                } else {
                    continue;
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return TypeBindings.create(arrayList, arrayList2);
    }

    private static TypeVariable b(TypeVariable[] typeVariableArr, String str) {
        if (typeVariableArr != null && str != null) {
            for (TypeVariable typeVariable : typeVariableArr) {
                if (str.equals(typeVariable.getName())) {
                    return typeVariable;
                }
            }
        }
        return null;
    }

    private static ParameterizedType c(Type type) {
        if (type instanceof ParameterizedType) {
            return (ParameterizedType) type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                return c(upperBounds[0]);
            }
        }
        return null;
    }

    private static TypeVariable d(Type type) {
        if (type instanceof TypeVariable) {
            return (TypeVariable) type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                return d(upperBounds[0]);
            }
        }
        return null;
    }

    public static m e(Method method, JavaType javaType, TypeFactory typeFactory, m mVar) {
        TypeBindings typeBindingsA = a(method, javaType, mVar);
        return typeBindingsA == null ? mVar : new m.a(typeFactory, typeBindingsA);
    }

    private static boolean f(m mVar, JavaType javaType, Type type) {
        if (!javaType.isTypeOrSubTypeOf(mVar.a(type).getRawClass())) {
            return false;
        }
        ParameterizedType parameterizedTypeC = c(type);
        if (parameterizedTypeC == null || !Objects.equals(javaType.getRawClass(), parameterizedTypeC.getRawType())) {
            return true;
        }
        Type[] actualTypeArguments = parameterizedTypeC.getActualTypeArguments();
        TypeBindings bindings = javaType.getBindings();
        if (bindings.size() != actualTypeArguments.length) {
            return false;
        }
        for (int i = 0; i < bindings.size(); i++) {
            if (!f(mVar, bindings.getBoundType(i), actualTypeArguments[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean g(m mVar, JavaType javaType, Type[] typeArr) {
        for (Type type : typeArr) {
            if (!f(mVar, javaType, type)) {
                return false;
            }
        }
        return true;
    }
}
