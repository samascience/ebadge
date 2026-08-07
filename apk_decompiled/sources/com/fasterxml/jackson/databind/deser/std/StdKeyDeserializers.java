package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.EnumResolver;
import defpackage.a91;
import defpackage.ay;
import defpackage.b91;
import defpackage.e7;
import defpackage.kh;
import defpackage.s51;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class StdKeyDeserializers implements b91, Serializable {
    private static final long serialVersionUID = 1;

    private static a91 _constructCreatorKeyDeserializer(DeserializationConfig deserializationConfig, AnnotatedMember annotatedMember) {
        if (annotatedMember instanceof AnnotatedConstructor) {
            Constructor<?> annotated = ((AnnotatedConstructor) annotatedMember).getAnnotated();
            if (deserializationConfig.canOverrideAccessModifiers()) {
                ay.g(annotated, deserializationConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            }
            return new StdKeyDeserializer.StringCtorKeyDeserializer(annotated);
        }
        Method annotated2 = ((AnnotatedMethod) annotatedMember).getAnnotated();
        if (deserializationConfig.canOverrideAccessModifiers()) {
            ay.g(annotated2, deserializationConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return new StdKeyDeserializer.StringFactoryKeyDeserializer(annotated2);
    }

    private static AnnotatedMethod _findExplicitStringFactoryMethod(List<e7> list) throws JsonMappingException {
        AnnotatedMethod annotatedMethod = null;
        for (e7 e7Var : list) {
            if (e7Var.b != null) {
                if (annotatedMethod != null) {
                    throw new IllegalArgumentException("Multiple suitable annotated Creator factory methods to be used as the Key deserializer for type " + ay.X(((AnnotatedMethod) e7Var.a).getDeclaringClass()));
                }
                annotatedMethod = (AnnotatedMethod) e7Var.a;
            }
        }
        return annotatedMethod;
    }

    private static e7 _findStringConstructor(kh khVar) {
        for (e7 e7Var : khVar.v()) {
            AnnotatedConstructor annotatedConstructor = (AnnotatedConstructor) e7Var.a;
            if (annotatedConstructor.getParameterCount() == 1 && String.class == annotatedConstructor.getRawParameterType(0)) {
                return e7Var;
            }
        }
        return null;
    }

    public static a91 constructDelegatingKeyDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, s51 s51Var) {
        return new StdKeyDeserializer.DelegatingKD(javaType.getRawClass(), s51Var);
    }

    public static a91 constructEnumKeyDeserializer(EnumResolver enumResolver) {
        return new StdKeyDeserializer.EnumKD(enumResolver, null);
    }

    public static a91 findStringBasedKeyDeserializer(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException {
        kh khVarIntrospectForCreation = deserializationConfig.introspectForCreation(javaType);
        e7 e7Var_findStringConstructor = _findStringConstructor(khVarIntrospectForCreation);
        if (e7Var_findStringConstructor != null && e7Var_findStringConstructor.b != null) {
            return _constructCreatorKeyDeserializer(deserializationConfig, (AnnotatedMember) e7Var_findStringConstructor.a);
        }
        List listX = khVarIntrospectForCreation.x();
        listX.removeIf(new Predicate() { // from class: bu2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return StdKeyDeserializers.lambda$findStringBasedKeyDeserializer$0((e7) obj);
            }
        });
        AnnotatedMethod annotatedMethod_findExplicitStringFactoryMethod = _findExplicitStringFactoryMethod(listX);
        if (annotatedMethod_findExplicitStringFactoryMethod != null) {
            return _constructCreatorKeyDeserializer(deserializationConfig, annotatedMethod_findExplicitStringFactoryMethod);
        }
        if (e7Var_findStringConstructor != null) {
            return _constructCreatorKeyDeserializer(deserializationConfig, (AnnotatedMember) e7Var_findStringConstructor.a);
        }
        if (listX.isEmpty()) {
            return null;
        }
        return _constructCreatorKeyDeserializer(deserializationConfig, (AnnotatedMember) ((e7) listX.get(0)).a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findStringBasedKeyDeserializer$0(e7 e7Var) {
        return (((AnnotatedMethod) e7Var.a).getParameterCount() == 1 && ((AnnotatedMethod) e7Var.a).getRawParameterType(0) == String.class && e7Var.b != JsonCreator.Mode.PROPERTIES) ? false : true;
    }

    @Override // defpackage.b91
    public a91 findKeyDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, kh khVar) throws JsonMappingException {
        Class<?> rawClass = javaType.getRawClass();
        if (rawClass.isPrimitive()) {
            rawClass = ay.o0(rawClass);
        }
        return StdKeyDeserializer.forType(rawClass);
    }

    public static a91 constructEnumKeyDeserializer(EnumResolver enumResolver, AnnotatedMethod annotatedMethod) {
        return new StdKeyDeserializer.EnumKD(enumResolver, annotatedMethod);
    }
}
