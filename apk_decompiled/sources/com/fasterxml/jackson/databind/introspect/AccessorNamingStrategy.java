package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.cfg.MapperConfig;
import defpackage.kh;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class AccessorNamingStrategy {

    public static class Base extends AccessorNamingStrategy implements Serializable {
        private static final long serialVersionUID = 1;

        @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy
        public String findNameForIsGetter(AnnotatedMethod annotatedMethod, String str) {
            return null;
        }

        @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy
        public String findNameForMutator(AnnotatedMethod annotatedMethod, String str) {
            return null;
        }

        @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy
        public String findNameForRegularGetter(AnnotatedMethod annotatedMethod, String str) {
            return null;
        }

        @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy
        public String modifyFieldName(AnnotatedField annotatedField, String str) {
            return str;
        }
    }

    public static abstract class Provider implements Serializable {
        private static final long serialVersionUID = 1;

        public abstract AccessorNamingStrategy forBuilder(MapperConfig<?> mapperConfig, a aVar, kh khVar);

        public abstract AccessorNamingStrategy forPOJO(MapperConfig<?> mapperConfig, a aVar);

        public abstract AccessorNamingStrategy forRecord(MapperConfig<?> mapperConfig, a aVar);
    }

    public abstract String findNameForIsGetter(AnnotatedMethod annotatedMethod, String str);

    public abstract String findNameForMutator(AnnotatedMethod annotatedMethod, String str);

    public abstract String findNameForRegularGetter(AnnotatedMethod annotatedMethod, String str);

    public abstract String modifyFieldName(AnnotatedField annotatedField, String str);
}
