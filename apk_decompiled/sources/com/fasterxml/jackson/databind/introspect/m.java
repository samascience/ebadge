package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public interface m {

    public static class a implements m {
        private final TypeFactory a;
        private final TypeBindings b;

        public a(TypeFactory typeFactory, TypeBindings typeBindings) {
            this.a = typeFactory;
            this.b = typeBindings;
        }

        @Override // com.fasterxml.jackson.databind.introspect.m
        public JavaType a(Type type) {
            return this.a.resolveMemberType(type, this.b);
        }
    }

    JavaType a(Type type);
}
