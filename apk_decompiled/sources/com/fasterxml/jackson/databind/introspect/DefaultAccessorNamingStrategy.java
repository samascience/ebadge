package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import defpackage.kh;
import defpackage.q61;
import defpackage.x31;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class DefaultAccessorNamingStrategy extends AccessorNamingStrategy {
    protected final MapperConfig a;
    protected final com.fasterxml.jackson.databind.introspect.a b;
    protected final a c;
    protected final boolean d;
    protected final boolean e;
    protected final String f;
    protected final String g;
    protected final String h;

    public static class Provider extends AccessorNamingStrategy.Provider implements Serializable {
        private static final long serialVersionUID = 1;
        protected final a _baseNameValidator;
        protected final String _getterPrefix;
        protected final String _isGetterPrefix;
        protected final String _setterPrefix;
        protected final String _withPrefix;

        public Provider() {
            this("set", "with", "get", "is", (a) null);
        }

        @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy.Provider
        public AccessorNamingStrategy forBuilder(MapperConfig<?> mapperConfig, com.fasterxml.jackson.databind.introspect.a aVar, kh khVar) {
            AnnotationIntrospector annotationIntrospector = mapperConfig.isAnnotationProcessingEnabled() ? mapperConfig.getAnnotationIntrospector() : null;
            q61.a aVarFindPOJOBuilderConfig = annotationIntrospector != null ? annotationIntrospector.findPOJOBuilderConfig(aVar) : null;
            return new DefaultAccessorNamingStrategy(mapperConfig, aVar, aVarFindPOJOBuilderConfig == null ? this._withPrefix : aVarFindPOJOBuilderConfig.b, this._getterPrefix, this._isGetterPrefix, this._baseNameValidator);
        }

        @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy.Provider
        public AccessorNamingStrategy forPOJO(MapperConfig<?> mapperConfig, com.fasterxml.jackson.databind.introspect.a aVar) {
            return new DefaultAccessorNamingStrategy(mapperConfig, aVar, this._setterPrefix, this._getterPrefix, this._isGetterPrefix, this._baseNameValidator);
        }

        @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy.Provider
        public AccessorNamingStrategy forRecord(MapperConfig<?> mapperConfig, com.fasterxml.jackson.databind.introspect.a aVar) {
            return new c(mapperConfig, aVar);
        }

        public Provider withBaseNameValidator(a aVar) {
            return new Provider(this, aVar);
        }

        public Provider withBuilderPrefix(String str) {
            return new Provider(this, this._setterPrefix, str, this._getterPrefix, this._isGetterPrefix);
        }

        public Provider withFirstCharAcceptance(boolean z, boolean z2) {
            return withBaseNameValidator(b.b(z, z2));
        }

        public Provider withGetterPrefix(String str) {
            return new Provider(this, this._setterPrefix, this._withPrefix, str, this._isGetterPrefix);
        }

        public Provider withIsGetterPrefix(String str) {
            return new Provider(this, this._setterPrefix, this._withPrefix, this._getterPrefix, str);
        }

        public Provider withSetterPrefix(String str) {
            return new Provider(this, str, this._withPrefix, this._getterPrefix, this._isGetterPrefix);
        }

        protected Provider(Provider provider, String str, String str2, String str3, String str4) {
            this(str, str2, str3, str4, provider._baseNameValidator);
        }

        protected Provider(Provider provider, a aVar) {
            this(provider._setterPrefix, provider._withPrefix, provider._getterPrefix, provider._isGetterPrefix, aVar);
        }

        protected Provider(String str, String str2, String str3, String str4, a aVar) {
            this._setterPrefix = str;
            this._withPrefix = str2;
            this._getterPrefix = str3;
            this._isGetterPrefix = str4;
            this._baseNameValidator = aVar;
        }
    }

    public interface a {
        boolean a(char c, String str, int i);
    }

    public static class b implements a {
        private final boolean a;
        private final boolean b;

        protected b(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }

        public static a b(boolean z, boolean z2) {
            if (z || z2) {
                return new b(z, z2);
            }
            return null;
        }

        @Override // com.fasterxml.jackson.databind.introspect.DefaultAccessorNamingStrategy.a
        public boolean a(char c, String str, int i) {
            if (Character.isLetter(c)) {
                return this.a || !Character.isLowerCase(c);
            }
            return this.b;
        }
    }

    public static class c extends DefaultAccessorNamingStrategy {
        protected final Set i;

        public c(MapperConfig mapperConfig, com.fasterxml.jackson.databind.introspect.a aVar) {
            super(mapperConfig, aVar, null, "get", "is", null);
            String[] strArrB = x31.b(aVar.getRawType());
            this.i = strArrB == null ? Collections.emptySet() : new HashSet(Arrays.asList(strArrB));
        }

        @Override // com.fasterxml.jackson.databind.introspect.DefaultAccessorNamingStrategy, com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy
        public String findNameForRegularGetter(AnnotatedMethod annotatedMethod, String str) {
            return this.i.contains(str) ? str : super.findNameForRegularGetter(annotatedMethod, str);
        }
    }

    protected DefaultAccessorNamingStrategy(MapperConfig mapperConfig, com.fasterxml.jackson.databind.introspect.a aVar, String str, String str2, String str3, a aVar2) {
        this.a = mapperConfig;
        this.b = aVar;
        this.d = mapperConfig.isEnabled(MapperFeature.USE_STD_BEAN_NAMING);
        this.e = mapperConfig.isEnabled(MapperFeature.ALLOW_IS_GETTERS_FOR_NON_BOOLEAN);
        this.h = str;
        this.f = str2;
        this.g = str3;
        this.c = aVar2;
    }

    protected boolean a(AnnotatedMethod annotatedMethod) {
        Class<?> rawType = annotatedMethod.getRawType();
        if (!rawType.isArray()) {
            return false;
        }
        String name = rawType.getComponentType().getName();
        if (name.contains(".cglib")) {
            return name.startsWith("net.sf.cglib") || name.startsWith("org.hibernate.repackage.cglib") || name.startsWith("org.springframework.cglib");
        }
        return false;
    }

    protected boolean b(AnnotatedMethod annotatedMethod) {
        return annotatedMethod.getRawType().getName().startsWith("groovy.lang");
    }

    protected String c(String str, int i) {
        int length = str.length();
        if (length == i) {
            return null;
        }
        char cCharAt = str.charAt(i);
        a aVar = this.c;
        if (aVar != null && !aVar.a(cCharAt, str, i)) {
            return null;
        }
        char lowerCase = Character.toLowerCase(cCharAt);
        if (cCharAt == lowerCase) {
            return str.substring(i);
        }
        StringBuilder sb = new StringBuilder(length - i);
        sb.append(lowerCase);
        while (true) {
            i++;
            if (i >= length) {
                break;
            }
            char cCharAt2 = str.charAt(i);
            char lowerCase2 = Character.toLowerCase(cCharAt2);
            if (cCharAt2 == lowerCase2) {
                sb.append((CharSequence) str, i, length);
                break;
            }
            sb.append(lowerCase2);
        }
        return sb.toString();
    }

    protected String d(String str, int i) {
        int length = str.length();
        if (length == i) {
            return null;
        }
        char cCharAt = str.charAt(i);
        a aVar = this.c;
        if (aVar != null && !aVar.a(cCharAt, str, i)) {
            return null;
        }
        char lowerCase = Character.toLowerCase(cCharAt);
        if (cCharAt == lowerCase) {
            return str.substring(i);
        }
        int i2 = i + 1;
        if (i2 < length && Character.isUpperCase(str.charAt(i2))) {
            return str.substring(i);
        }
        StringBuilder sb = new StringBuilder(length - i);
        sb.append(lowerCase);
        sb.append((CharSequence) str, i2, length);
        return sb.toString();
    }

    @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy
    public String findNameForIsGetter(AnnotatedMethod annotatedMethod, String str) {
        if (this.g == null) {
            return null;
        }
        Class<?> rawType = annotatedMethod.getRawType();
        if ((this.e || rawType == Boolean.class || rawType == Boolean.TYPE) && str.startsWith(this.g)) {
            return this.d ? d(str, 2) : c(str, 2);
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy
    public String findNameForMutator(AnnotatedMethod annotatedMethod, String str) {
        String str2 = this.h;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        return this.d ? d(str, this.h.length()) : c(str, this.h.length());
    }

    @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy
    public String findNameForRegularGetter(AnnotatedMethod annotatedMethod, String str) {
        String str2 = this.f;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        if ("getCallbacks".equals(str)) {
            if (a(annotatedMethod)) {
                return null;
            }
        } else if ("getMetaClass".equals(str) && b(annotatedMethod)) {
            return null;
        }
        return this.d ? d(str, this.f.length()) : c(str, this.f.length());
    }

    @Override // com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy
    public String modifyFieldName(AnnotatedField annotatedField, String str) {
        return str;
    }
}
