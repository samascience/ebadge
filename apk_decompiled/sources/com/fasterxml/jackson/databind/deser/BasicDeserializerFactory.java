package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.ConstructorDetector;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.impl.JDKValueInstantiators;
import com.fasterxml.jackson.databind.deser.std.ArrayBlockingQueueDeserializer;
import com.fasterxml.jackson.databind.deser.std.AtomicReferenceDeserializer;
import com.fasterxml.jackson.databind.deser.std.CollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.deser.std.EnumDeserializer;
import com.fasterxml.jackson.databind.deser.std.EnumMapDeserializer;
import com.fasterxml.jackson.databind.deser.std.EnumSetDeserializer;
import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer;
import com.fasterxml.jackson.databind.deser.std.MapDeserializer;
import com.fasterxml.jackson.databind.deser.std.MapEntryDeserializer;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringCollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.deser.std.TokenBufferDeserializer;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.introspect.g;
import com.fasterxml.jackson.databind.introspect.l;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.EnumResolver;
import defpackage.a91;
import defpackage.ah;
import defpackage.ay;
import defpackage.b91;
import defpackage.bp2;
import defpackage.cb3;
import defpackage.d7;
import defpackage.e43;
import defpackage.kh;
import defpackage.m63;
import defpackage.mh;
import defpackage.n41;
import defpackage.q33;
import defpackage.q90;
import defpackage.r1;
import defpackage.s51;
import defpackage.w40;
import defpackage.x31;
import defpackage.x40;
import defpackage.x63;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class BasicDeserializerFactory extends com.fasterxml.jackson.databind.deser.a implements Serializable {
    protected final DeserializerFactoryConfig _factoryConfig;
    private static final Class<?> CLASS_OBJECT = Object.class;
    private static final Class<?> CLASS_STRING = String.class;
    private static final Class<?> CLASS_CHAR_SEQUENCE = CharSequence.class;
    private static final Class<?> CLASS_ITERABLE = Iterable.class;
    private static final Class<?> CLASS_MAP_ENTRY = Map.Entry.class;
    private static final Class<?> CLASS_SERIALIZABLE = Serializable.class;
    protected static final PropertyName UNWRAPPED_CREATOR_PARAM_NAME = new PropertyName("@JsonUnwrapped");

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[ConstructorDetector.SingleArgConstructor.values().length];
            b = iArr;
            try {
                iArr[ConstructorDetector.SingleArgConstructor.DELEGATING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[ConstructorDetector.SingleArgConstructor.PROPERTIES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[ConstructorDetector.SingleArgConstructor.REQUIRE_MODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[ConstructorDetector.SingleArgConstructor.HEURISTIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[JsonCreator.Mode.values().length];
            a = iArr2;
            try {
                iArr2[JsonCreator.Mode.DELEGATING.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[JsonCreator.Mode.PROPERTIES.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[JsonCreator.Mode.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    protected static class b {
        static final HashMap a;
        static final HashMap b;

        static {
            HashMap map = new HashMap();
            map.put(Collection.class.getName(), ArrayList.class);
            map.put(List.class.getName(), ArrayList.class);
            map.put(Set.class.getName(), HashSet.class);
            map.put(SortedSet.class.getName(), TreeSet.class);
            map.put(Queue.class.getName(), LinkedList.class);
            map.put(AbstractList.class.getName(), ArrayList.class);
            map.put(AbstractSet.class.getName(), HashSet.class);
            map.put(Deque.class.getName(), LinkedList.class);
            map.put(NavigableSet.class.getName(), TreeSet.class);
            a = map;
            HashMap map2 = new HashMap();
            map2.put(Map.class.getName(), LinkedHashMap.class);
            map2.put(AbstractMap.class.getName(), LinkedHashMap.class);
            map2.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
            map2.put(SortedMap.class.getName(), TreeMap.class);
            map2.put(NavigableMap.class.getName(), TreeMap.class);
            map2.put(ConcurrentNavigableMap.class.getName(), ConcurrentSkipListMap.class);
            b = map2;
        }

        public static Class a(JavaType javaType) {
            return (Class) a.get(javaType.getRawClass().getName());
        }

        public static Class b(JavaType javaType) {
            return (Class) b.get(javaType.getRawClass().getName());
        }
    }

    protected static class c {
        public final DeserializationContext a;
        public final kh b;
        public final VisibilityChecker c;
        public final x40 d;
        public final Map e;
        private List f;
        private int g;
        private List h;
        private int i;

        public c(DeserializationContext deserializationContext, kh khVar, VisibilityChecker visibilityChecker, x40 x40Var, Map map) {
            this.a = deserializationContext;
            this.b = khVar;
            this.c = visibilityChecker;
            this.d = x40Var;
            this.e = map;
        }

        public void a(w40 w40Var) {
            if (this.h == null) {
                this.h = new LinkedList();
            }
            this.h.add(w40Var);
        }

        public void b(w40 w40Var) {
            if (this.f == null) {
                this.f = new LinkedList();
            }
            this.f.add(w40Var);
        }

        public AnnotationIntrospector c() {
            return this.a.getAnnotationIntrospector();
        }

        public boolean d() {
            return this.i > 0;
        }

        public boolean e() {
            return this.g > 0;
        }

        public boolean f() {
            return this.h != null;
        }

        public boolean g() {
            return this.f != null;
        }

        public List h() {
            return this.h;
        }

        public List i() {
            return this.f;
        }

        public void j() {
            this.i++;
        }

        public void k() {
            this.g++;
        }
    }

    protected BasicDeserializerFactory(DeserializerFactoryConfig deserializerFactoryConfig) {
        this._factoryConfig = deserializerFactoryConfig;
    }

    private boolean _checkIfCreatorPropertyBased(AnnotationIntrospector annotationIntrospector, AnnotatedWithParams annotatedWithParams, g gVar) {
        String name;
        if ((gVar == null || !gVar.x()) && annotationIntrospector.findInjectableValue(annotatedWithParams.getParameter(0)) == null) {
            return (gVar == null || (name = gVar.getName()) == null || name.isEmpty() || !gVar.b()) ? false : true;
        }
        return true;
    }

    private void _checkImplicitlyNamedConstructors(DeserializationContext deserializationContext, kh khVar, VisibilityChecker visibilityChecker, AnnotationIntrospector annotationIntrospector, x40 x40Var, List<AnnotatedWithParams> list) throws JsonMappingException {
        int i;
        Iterator<AnnotatedWithParams> it = list.iterator();
        AnnotatedWithParams annotatedWithParams = null;
        AnnotatedWithParams annotatedWithParams2 = null;
        SettableBeanProperty[] settableBeanPropertyArr = null;
        while (true) {
            if (!it.hasNext()) {
                annotatedWithParams = annotatedWithParams2;
                break;
            }
            AnnotatedWithParams next = it.next();
            if (visibilityChecker.isCreatorVisible(next)) {
                int parameterCount = next.getParameterCount();
                SettableBeanProperty[] settableBeanPropertyArr2 = new SettableBeanProperty[parameterCount];
                int i2 = 0;
                while (true) {
                    if (i2 >= parameterCount) {
                        if (annotatedWithParams2 == null) {
                            annotatedWithParams2 = next;
                            settableBeanPropertyArr = settableBeanPropertyArr2;
                            break;
                        }
                        break;
                    }
                    AnnotatedParameter parameter = next.getParameter(i2);
                    PropertyName propertyName_findParamName = _findParamName(parameter, annotationIntrospector);
                    if (propertyName_findParamName == null || propertyName_findParamName.isEmpty()) {
                        break;
                    }
                    settableBeanPropertyArr2[i2] = constructCreatorProperty(deserializationContext, khVar, propertyName_findParamName, parameter.getIndex(), parameter, null);
                    i2++;
                }
            }
        }
        if (annotatedWithParams != null) {
            x40Var.l(annotatedWithParams, false, settableBeanPropertyArr);
            ah ahVar = (ah) khVar;
            for (SettableBeanProperty settableBeanProperty : settableBeanPropertyArr) {
                PropertyName fullName = settableBeanProperty.getFullName();
                if (!ahVar.M(fullName)) {
                    ahVar.G(bp2.z(deserializationContext.getConfig(), settableBeanProperty.getMember(), fullName));
                }
            }
        }
    }

    private a91 _createEnumKeyDeserializer(DeserializationContext deserializationContext, JavaType javaType) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        Class<?> rawClass = javaType.getRawClass();
        kh khVarIntrospect = config.introspect(javaType);
        a91 a91VarFindKeyDeserializerFromAnnotation = findKeyDeserializerFromAnnotation(deserializationContext, khVarIntrospect.t());
        if (a91VarFindKeyDeserializerFromAnnotation != null) {
            return a91VarFindKeyDeserializerFromAnnotation;
        }
        s51 s51Var_findCustomEnumDeserializer = _findCustomEnumDeserializer(rawClass, config, khVarIntrospect);
        if (s51Var_findCustomEnumDeserializer != null) {
            return StdKeyDeserializers.constructDelegatingKeyDeserializer(config, javaType, s51Var_findCustomEnumDeserializer);
        }
        s51 s51VarFindDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, khVarIntrospect.t());
        if (s51VarFindDeserializerFromAnnotation != null) {
            return StdKeyDeserializers.constructDelegatingKeyDeserializer(config, javaType, s51VarFindDeserializerFromAnnotation);
        }
        EnumResolver enumResolverConstructEnumResolver = constructEnumResolver(rawClass, config, khVarIntrospect.j());
        for (AnnotatedMethod annotatedMethod : khVarIntrospect.w()) {
            if (_hasCreatorAnnotation(deserializationContext, annotatedMethod)) {
                if (annotatedMethod.getParameterCount() != 1 || !annotatedMethod.getRawReturnType().isAssignableFrom(rawClass)) {
                    throw new IllegalArgumentException("Unsuitable method (" + annotatedMethod + ") decorated with @JsonCreator (for Enum type " + rawClass.getName() + ")");
                }
                if (annotatedMethod.getRawParameterType(0) == String.class) {
                    if (config.canOverrideAccessModifiers()) {
                        ay.g(annotatedMethod.getMember(), deserializationContext.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                    }
                    return StdKeyDeserializers.constructEnumKeyDeserializer(enumResolverConstructEnumResolver, annotatedMethod);
                }
            }
        }
        return StdKeyDeserializers.constructEnumKeyDeserializer(enumResolverConstructEnumResolver);
    }

    private PropertyName _findParamName(AnnotatedParameter annotatedParameter, AnnotationIntrospector annotationIntrospector) {
        if (annotationIntrospector == null) {
            return null;
        }
        PropertyName propertyNameFindNameForDeserialization = annotationIntrospector.findNameForDeserialization(annotatedParameter);
        if (propertyNameFindNameForDeserialization != null && !propertyNameFindNameForDeserialization.isEmpty()) {
            return propertyNameFindNameForDeserialization;
        }
        String strFindImplicitPropertyName = annotationIntrospector.findImplicitPropertyName(annotatedParameter);
        if (strFindImplicitPropertyName == null || strFindImplicitPropertyName.isEmpty()) {
            return null;
        }
        return PropertyName.construct(strFindImplicitPropertyName);
    }

    private JavaType _mapAbstractType2(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException {
        Class<?> rawClass = javaType.getRawClass();
        if (!this._factoryConfig.hasAbstractTypeResolvers()) {
            return null;
        }
        Iterator<r1> it = this._factoryConfig.abstractTypeResolvers().iterator();
        while (it.hasNext()) {
            JavaType javaTypeFindTypeMapping = it.next().findTypeMapping(deserializationConfig, javaType);
            if (javaTypeFindTypeMapping != null && !javaTypeFindTypeMapping.hasRawClass(rawClass)) {
                return javaTypeFindTypeMapping;
            }
        }
        return null;
    }

    @Deprecated
    protected void _addExplicitAnyCreator(DeserializationContext deserializationContext, kh khVar, x40 x40Var, w40 w40Var) throws JsonMappingException {
        _addExplicitAnyCreator(deserializationContext, khVar, x40Var, w40Var, deserializationContext.getConfig().getConstructorDetector());
    }

    protected void _addExplicitConstructorCreators(DeserializationContext deserializationContext, c cVar, boolean z) throws JsonMappingException {
        kh khVar = cVar.b;
        x40 x40Var = cVar.d;
        AnnotationIntrospector annotationIntrospectorC = cVar.c();
        VisibilityChecker visibilityChecker = cVar.c;
        Map map = cVar.e;
        AnnotatedConstructor annotatedConstructorD = khVar.d();
        if (annotatedConstructorD != null && (!x40Var.o() || _hasCreatorAnnotation(deserializationContext, annotatedConstructorD))) {
            x40Var.r(annotatedConstructorD);
        }
        for (AnnotatedConstructor annotatedConstructor : khVar.u()) {
            JsonCreator.Mode modeFindCreatorAnnotation = annotationIntrospectorC.findCreatorAnnotation(deserializationContext.getConfig(), annotatedConstructor);
            if (JsonCreator.Mode.DISABLED != modeFindCreatorAnnotation) {
                if (modeFindCreatorAnnotation != null) {
                    int i = a.a[modeFindCreatorAnnotation.ordinal()];
                    if (i == 1) {
                        _addExplicitDelegatingCreator(deserializationContext, khVar, x40Var, w40.a(annotationIntrospectorC, annotatedConstructor, null));
                    } else if (i != 2) {
                        _addExplicitAnyCreator(deserializationContext, khVar, x40Var, w40.a(annotationIntrospectorC, annotatedConstructor, (g[]) map.get(annotatedConstructor)), deserializationContext.getConfig().getConstructorDetector());
                    } else {
                        _addExplicitPropertyCreator(deserializationContext, khVar, x40Var, w40.a(annotationIntrospectorC, annotatedConstructor, (g[]) map.get(annotatedConstructor)));
                    }
                    cVar.j();
                } else if (z && visibilityChecker.isCreatorVisible(annotatedConstructor)) {
                    cVar.a(w40.a(annotationIntrospectorC, annotatedConstructor, (g[]) map.get(annotatedConstructor)));
                }
            }
        }
    }

    protected void _addExplicitDelegatingCreator(DeserializationContext deserializationContext, kh khVar, x40 x40Var, w40 w40Var) throws JsonMappingException {
        int iG = w40Var.g();
        SettableBeanProperty[] settableBeanPropertyArr = new SettableBeanProperty[iG];
        int i = -1;
        for (int i2 = 0; i2 < iG; i2++) {
            AnnotatedParameter annotatedParameterI = w40Var.i(i2);
            JacksonInject.Value valueF = w40Var.f(i2);
            if (valueF != null) {
                settableBeanPropertyArr[i2] = constructCreatorProperty(deserializationContext, khVar, null, i2, annotatedParameterI, valueF);
            } else if (i < 0) {
                i = i2;
            } else {
                deserializationContext.reportBadTypeDefinition(khVar, "More than one argument (#%d and #%d) left as delegating for Creator %s: only one allowed", Integer.valueOf(i), Integer.valueOf(i2), w40Var);
            }
        }
        if (i < 0) {
            deserializationContext.reportBadTypeDefinition(khVar, "No argument left as delegating for Creator %s: exactly one required", w40Var);
        }
        if (iG != 1) {
            x40Var.h(w40Var.b(), true, settableBeanPropertyArr, i);
            return;
        }
        _handleSingleArgumentCreator(x40Var, w40Var.b(), true, true);
        g gVarJ = w40Var.j(0);
        if (gVarJ != null) {
            ((l) gVarJ).p0();
        }
    }

    protected void _addExplicitFactoryCreators(DeserializationContext deserializationContext, c cVar, boolean z) throws JsonMappingException {
        kh khVar = cVar.b;
        x40 x40Var = cVar.d;
        AnnotationIntrospector annotationIntrospectorC = cVar.c();
        VisibilityChecker visibilityChecker = cVar.c;
        Map map = cVar.e;
        for (AnnotatedMethod annotatedMethod : khVar.w()) {
            JsonCreator.Mode modeFindCreatorAnnotation = annotationIntrospectorC.findCreatorAnnotation(deserializationContext.getConfig(), annotatedMethod);
            int parameterCount = annotatedMethod.getParameterCount();
            if (modeFindCreatorAnnotation == null) {
                if (z && parameterCount == 1 && visibilityChecker.isCreatorVisible(annotatedMethod)) {
                    cVar.b(w40.a(annotationIntrospectorC, annotatedMethod, null));
                }
            } else if (modeFindCreatorAnnotation != JsonCreator.Mode.DISABLED) {
                if (parameterCount == 0) {
                    x40Var.r(annotatedMethod);
                } else {
                    int i = a.a[modeFindCreatorAnnotation.ordinal()];
                    if (i == 1) {
                        _addExplicitDelegatingCreator(deserializationContext, khVar, x40Var, w40.a(annotationIntrospectorC, annotatedMethod, null));
                    } else if (i != 2) {
                        _addExplicitAnyCreator(deserializationContext, khVar, x40Var, w40.a(annotationIntrospectorC, annotatedMethod, (g[]) map.get(annotatedMethod)), ConstructorDetector.DEFAULT);
                    } else {
                        _addExplicitPropertyCreator(deserializationContext, khVar, x40Var, w40.a(annotationIntrospectorC, annotatedMethod, (g[]) map.get(annotatedMethod)));
                    }
                    cVar.k();
                }
            }
        }
    }

    protected void _addExplicitPropertyCreator(DeserializationContext deserializationContext, kh khVar, x40 x40Var, w40 w40Var) throws JsonMappingException {
        int iG = w40Var.g();
        SettableBeanProperty[] settableBeanPropertyArr = new SettableBeanProperty[iG];
        int i = 0;
        while (i < iG) {
            JacksonInject.Value valueF = w40Var.f(i);
            AnnotatedParameter annotatedParameterI = w40Var.i(i);
            PropertyName propertyNameH = w40Var.h(i);
            if (propertyNameH == null) {
                if (deserializationContext.getAnnotationIntrospector().findUnwrappingNameTransformer(annotatedParameterI) != null) {
                    _reportUnwrappedCreatorProperty(deserializationContext, khVar, annotatedParameterI);
                }
                PropertyName propertyNameD = w40Var.d(i);
                _validateNamedPropertyParameter(deserializationContext, khVar, w40Var, i, propertyNameD, valueF);
                propertyNameH = propertyNameD;
            }
            int i2 = i;
            settableBeanPropertyArr[i2] = constructCreatorProperty(deserializationContext, khVar, propertyNameH, i, annotatedParameterI, valueF);
            i = i2 + 1;
        }
        x40Var.l(w40Var.b(), true, settableBeanPropertyArr);
    }

    /* JADX WARN: Code duplicated, block: B:62:0x0179 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x017b  */
    /* JADX WARN: Code duplicated, block: B:77:0x0150 A[SYNTHETIC] */
    protected void _addImplicitConstructorCreators(DeserializationContext deserializationContext, c cVar, List<w40> list) throws JsonMappingException {
        VisibilityChecker visibilityChecker;
        boolean z;
        Iterator<w40> it;
        int i;
        int i2;
        w40 w40Var;
        VisibilityChecker visibilityChecker2;
        boolean z2;
        Iterator<w40> it2;
        SettableBeanProperty[] settableBeanPropertyArr;
        AnnotatedWithParams annotatedWithParams;
        int i3;
        DeserializationConfig config = deserializationContext.getConfig();
        kh khVar = cVar.b;
        x40 x40Var = cVar.d;
        AnnotationIntrospector annotationIntrospectorC = cVar.c();
        VisibilityChecker visibilityChecker3 = cVar.c;
        boolean zSingleArgCreatorDefaultsToProperties = config.getConstructorDetector().singleArgCreatorDefaultsToProperties();
        Iterator<w40> it3 = list.iterator();
        LinkedList linkedList = null;
        while (it3.hasNext()) {
            w40 next = it3.next();
            int iG = next.g();
            AnnotatedWithParams annotatedWithParamsB = next.b();
            if (iG == 1) {
                g gVarJ = next.j(0);
                if (zSingleArgCreatorDefaultsToProperties || _checkIfCreatorPropertyBased(annotationIntrospectorC, annotatedWithParamsB, gVarJ)) {
                    JacksonInject.Value valueF = next.f(0);
                    PropertyName propertyNameH = next.h(0);
                    if (propertyNameH != null || (propertyNameH = next.d(0)) != null || valueF != null) {
                        x40Var.l(annotatedWithParamsB, false, new SettableBeanProperty[]{constructCreatorProperty(deserializationContext, khVar, propertyNameH, 0, next.i(0), valueF)});
                    }
                } else {
                    _handleSingleArgumentCreator(x40Var, annotatedWithParamsB, false, visibilityChecker3.isCreatorVisible(annotatedWithParamsB));
                    if (gVarJ != null) {
                        ((l) gVarJ).p0();
                    }
                }
                visibilityChecker = visibilityChecker3;
                z = zSingleArgCreatorDefaultsToProperties;
                it = it3;
            } else {
                SettableBeanProperty[] settableBeanPropertyArr2 = new SettableBeanProperty[iG];
                int i4 = -1;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i5 < iG) {
                    AnnotatedParameter parameter = annotatedWithParamsB.getParameter(i5);
                    g gVarJ2 = next.j(i5);
                    JacksonInject.Value valueFindInjectableValue = annotationIntrospectorC.findInjectableValue(parameter);
                    PropertyName fullName = gVarJ2 == null ? null : gVarJ2.getFullName();
                    if (gVarJ2 == null || !gVarJ2.x()) {
                        i = i5;
                        i2 = i4;
                        w40Var = next;
                        visibilityChecker2 = visibilityChecker3;
                        z2 = zSingleArgCreatorDefaultsToProperties;
                        it2 = it3;
                        settableBeanPropertyArr = settableBeanPropertyArr2;
                        annotatedWithParams = annotatedWithParamsB;
                        i3 = iG;
                        if (valueFindInjectableValue != null) {
                            i7++;
                            settableBeanPropertyArr[i] = constructCreatorProperty(deserializationContext, khVar, fullName, i, parameter, valueFindInjectableValue);
                        } else if (annotationIntrospectorC.findUnwrappingNameTransformer(parameter) != null) {
                            _reportUnwrappedCreatorProperty(deserializationContext, khVar, parameter);
                        } else {
                            if (i2 < 0) {
                                i4 = i;
                            }
                            i5 = i + 1;
                            iG = i3;
                            settableBeanPropertyArr2 = settableBeanPropertyArr;
                            annotatedWithParamsB = annotatedWithParams;
                            zSingleArgCreatorDefaultsToProperties = z2;
                            it3 = it2;
                            visibilityChecker3 = visibilityChecker2;
                            next = w40Var;
                        }
                    } else {
                        i6++;
                        i = i5;
                        i2 = i4;
                        z2 = zSingleArgCreatorDefaultsToProperties;
                        settableBeanPropertyArr = settableBeanPropertyArr2;
                        it2 = it3;
                        annotatedWithParams = annotatedWithParamsB;
                        visibilityChecker2 = visibilityChecker3;
                        i3 = iG;
                        w40Var = next;
                        settableBeanPropertyArr[i] = constructCreatorProperty(deserializationContext, khVar, fullName, i, parameter, valueFindInjectableValue);
                    }
                    i4 = i2;
                    i5 = i + 1;
                    iG = i3;
                    settableBeanPropertyArr2 = settableBeanPropertyArr;
                    annotatedWithParamsB = annotatedWithParams;
                    zSingleArgCreatorDefaultsToProperties = z2;
                    it3 = it2;
                    visibilityChecker3 = visibilityChecker2;
                    next = w40Var;
                }
                int i8 = i4;
                w40 w40Var2 = next;
                visibilityChecker = visibilityChecker3;
                z = zSingleArgCreatorDefaultsToProperties;
                it = it3;
                SettableBeanProperty[] settableBeanPropertyArr3 = settableBeanPropertyArr2;
                AnnotatedWithParams annotatedWithParams2 = annotatedWithParamsB;
                int i9 = iG;
                if (i6 > 0 || i7 > 0) {
                    if (i6 + i7 == i9) {
                        x40Var.l(annotatedWithParams2, false, settableBeanPropertyArr3);
                    } else if (i6 == 0 && i7 + 1 == i9) {
                        x40Var.h(annotatedWithParams2, false, settableBeanPropertyArr3, 0);
                    } else {
                        PropertyName propertyNameD = w40Var2.d(i8);
                        if (propertyNameD == null || propertyNameD.isEmpty()) {
                            deserializationContext.reportBadTypeDefinition(khVar, "Argument #%d of constructor %s has no property name annotation; must have name when multiple-parameter constructor annotated as Creator", Integer.valueOf(i8), annotatedWithParams2);
                        }
                        if (x40Var.o()) {
                            if (linkedList == null) {
                                linkedList = new LinkedList();
                            }
                            LinkedList linkedList2 = linkedList;
                            linkedList2.add(annotatedWithParams2);
                            linkedList = linkedList2;
                        }
                    }
                } else if (x40Var.o()) {
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                    }
                    LinkedList linkedList3 = linkedList;
                    linkedList3.add(annotatedWithParams2);
                    linkedList = linkedList3;
                }
            }
            zSingleArgCreatorDefaultsToProperties = z;
            it3 = it;
            visibilityChecker3 = visibilityChecker;
        }
        VisibilityChecker visibilityChecker4 = visibilityChecker3;
        if (linkedList == null || x40Var.p() || x40Var.q()) {
            return;
        }
        _checkImplicitlyNamedConstructors(deserializationContext, khVar, visibilityChecker4, annotationIntrospectorC, x40Var, linkedList);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    protected void _addImplicitFactoryCreators(DeserializationContext deserializationContext, c cVar, List<w40> list) throws JsonMappingException {
        int i;
        VisibilityChecker visibilityChecker;
        Map map;
        Iterator<w40> it;
        SettableBeanProperty[] settableBeanPropertyArr;
        boolean z;
        AnnotatedWithParams annotatedWithParams;
        kh khVar = cVar.b;
        x40 x40Var = cVar.d;
        AnnotationIntrospector annotationIntrospectorC = cVar.c();
        VisibilityChecker visibilityChecker2 = cVar.c;
        Map map2 = cVar.e;
        Iterator<w40> it2 = list.iterator();
        while (it2.hasNext()) {
            w40 next = it2.next();
            int iG = next.g();
            AnnotatedWithParams annotatedWithParamsB = next.b();
            g[] gVarArr = (g[]) map2.get(annotatedWithParamsB);
            if (iG == 1) {
                boolean z2 = false;
                g gVarJ = next.j(0);
                if (_checkIfCreatorPropertyBased(annotationIntrospectorC, annotatedWithParamsB, gVarJ)) {
                    SettableBeanProperty[] settableBeanPropertyArr2 = new SettableBeanProperty[iG];
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    AnnotatedParameter annotatedParameter = null;
                    while (i2 < iG) {
                        AnnotatedParameter parameter = annotatedWithParamsB.getParameter(i2);
                        g gVar = gVarArr == null ? null : gVarArr[i2];
                        JacksonInject.Value valueFindInjectableValue = annotationIntrospectorC.findInjectableValue(parameter);
                        PropertyName fullName = gVar == null ? null : gVar.getFullName();
                        if (gVar == null || !gVar.x()) {
                            i = i2;
                            visibilityChecker = visibilityChecker2;
                            map = map2;
                            it = it2;
                            settableBeanPropertyArr = settableBeanPropertyArr2;
                            z = z2;
                            annotatedWithParams = annotatedWithParamsB;
                            if (valueFindInjectableValue != null) {
                                i4++;
                                settableBeanPropertyArr[i] = constructCreatorProperty(deserializationContext, khVar, fullName, i, parameter, valueFindInjectableValue);
                            } else if (annotationIntrospectorC.findUnwrappingNameTransformer(parameter) != null) {
                                _reportUnwrappedCreatorProperty(deserializationContext, khVar, parameter);
                            } else if (annotatedParameter == null) {
                                annotatedParameter = parameter;
                            }
                        } else {
                            i3++;
                            i = i2;
                            visibilityChecker = visibilityChecker2;
                            settableBeanPropertyArr = settableBeanPropertyArr2;
                            map = map2;
                            z = z2;
                            it = it2;
                            annotatedWithParams = annotatedWithParamsB;
                            settableBeanPropertyArr[i] = constructCreatorProperty(deserializationContext, khVar, fullName, i, parameter, valueFindInjectableValue);
                        }
                        i2 = i + 1;
                        settableBeanPropertyArr2 = settableBeanPropertyArr;
                        z2 = z;
                        annotatedWithParamsB = annotatedWithParams;
                        visibilityChecker2 = visibilityChecker;
                        map2 = map;
                        it2 = it;
                    }
                    VisibilityChecker visibilityChecker3 = visibilityChecker2;
                    Map map3 = map2;
                    Iterator<w40> it3 = it2;
                    SettableBeanProperty[] settableBeanPropertyArr3 = settableBeanPropertyArr2;
                    boolean z3 = z2;
                    AnnotatedWithParams annotatedWithParams2 = annotatedWithParamsB;
                    if (i3 > 0 || i4 > 0) {
                        if (i3 + i4 == iG) {
                            x40Var.l(annotatedWithParams2, z3, settableBeanPropertyArr3);
                        } else if (i3 == 0 && i4 + 1 == iG) {
                            x40Var.h(annotatedWithParams2, z3, settableBeanPropertyArr3, z3 ? 1 : 0);
                        } else {
                            deserializationContext.reportBadTypeDefinition(khVar, "Argument #%d of factory method %s has no property name annotation; must have name when multiple-parameter constructor annotated as Creator", Integer.valueOf(annotatedParameter == null ? -1 : annotatedParameter.getIndex()), annotatedWithParams2);
                        }
                    }
                    it2 = it3;
                    visibilityChecker2 = visibilityChecker3;
                    map2 = map3;
                } else {
                    _handleSingleArgumentCreator(x40Var, annotatedWithParamsB, false, visibilityChecker2.isCreatorVisible(annotatedWithParamsB));
                    if (gVarJ != null) {
                        ((l) gVarJ).p0();
                    }
                }
            }
        }
    }

    protected void _addRecordConstructor(DeserializationContext deserializationContext, c cVar, AnnotatedConstructor annotatedConstructor, List<String> list) throws JsonMappingException {
        int parameterCount = annotatedConstructor.getParameterCount();
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        SettableBeanProperty[] settableBeanPropertyArr = new SettableBeanProperty[parameterCount];
        for (int i = 0; i < parameterCount; i++) {
            AnnotatedParameter parameter = annotatedConstructor.getParameter(i);
            JacksonInject.Value valueFindInjectableValue = annotationIntrospector.findInjectableValue(parameter);
            PropertyName propertyNameFindNameForDeserialization = annotationIntrospector.findNameForDeserialization(parameter);
            if (propertyNameFindNameForDeserialization == null || propertyNameFindNameForDeserialization.isEmpty()) {
                propertyNameFindNameForDeserialization = PropertyName.construct(list.get(i));
            }
            settableBeanPropertyArr[i] = constructCreatorProperty(deserializationContext, cVar.b, propertyNameFindNameForDeserialization, i, parameter, valueFindInjectableValue);
        }
        cVar.d.l(annotatedConstructor, false, settableBeanPropertyArr);
    }

    protected ValueInstantiator _constructDefaultValueInstantiator(DeserializationContext deserializationContext, kh khVar) throws JsonMappingException {
        ArrayList arrayList;
        AnnotatedConstructor annotatedConstructorA;
        DeserializationConfig config = deserializationContext.getConfig();
        VisibilityChecker defaultVisibilityChecker = config.getDefaultVisibilityChecker(khVar.r(), khVar.t());
        ConstructorDetector constructorDetector = config.getConstructorDetector();
        c cVar = new c(deserializationContext, khVar, defaultVisibilityChecker, new x40(khVar, config), _findCreatorsFromProperties(deserializationContext, khVar));
        _addExplicitFactoryCreators(deserializationContext, cVar, !constructorDetector.requireCtorAnnotation());
        if (khVar.A().isConcrete()) {
            if (khVar.A().isRecordType() && (annotatedConstructorA = x31.a(deserializationContext, khVar, (arrayList = new ArrayList()))) != null) {
                _addRecordConstructor(deserializationContext, cVar, annotatedConstructorA, arrayList);
                return cVar.d.n(deserializationContext);
            }
            if (!khVar.D()) {
                _addExplicitConstructorCreators(deserializationContext, cVar, constructorDetector.shouldIntrospectorImplicitConstructors(khVar.r()));
                if (cVar.f() && !cVar.d()) {
                    _addImplicitConstructorCreators(deserializationContext, cVar, cVar.h());
                }
            }
        }
        if (cVar.g() && !cVar.e() && !cVar.d()) {
            _addImplicitFactoryCreators(deserializationContext, cVar, cVar.i());
        }
        return cVar.d.n(deserializationContext);
    }

    protected Map<AnnotatedWithParams, g[]> _findCreatorsFromProperties(DeserializationContext deserializationContext, kh khVar) throws JsonMappingException {
        Map<AnnotatedWithParams, g[]> mapEmptyMap = Collections.emptyMap();
        for (g gVar : khVar.o()) {
            Iterator itJ = gVar.j();
            while (itJ.hasNext()) {
                AnnotatedParameter annotatedParameter = (AnnotatedParameter) itJ.next();
                AnnotatedWithParams owner = annotatedParameter.getOwner();
                g[] gVarArr = mapEmptyMap.get(owner);
                int index = annotatedParameter.getIndex();
                if (gVarArr == null) {
                    if (mapEmptyMap.isEmpty()) {
                        mapEmptyMap = new LinkedHashMap<>();
                    }
                    gVarArr = new g[owner.getParameterCount()];
                    mapEmptyMap.put(owner, gVarArr);
                } else if (gVarArr[index] != null) {
                    deserializationContext.reportBadTypeDefinition(khVar, "Conflict: parameter #%d of %s bound to more than one property; %s vs %s", Integer.valueOf(index), owner, gVarArr[index], gVar);
                }
                gVarArr[index] = gVar;
            }
        }
        return mapEmptyMap;
    }

    protected s51 _findCustomArrayDeserializer(ArrayType arrayType, DeserializationConfig deserializationConfig, kh khVar, m63 m63Var, s51 s51Var) throws JsonMappingException {
        Iterator<q90> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            s51 s51VarFindArrayDeserializer = it.next().findArrayDeserializer(arrayType, deserializationConfig, khVar, m63Var, s51Var);
            if (s51VarFindArrayDeserializer != null) {
                return s51VarFindArrayDeserializer;
            }
        }
        return null;
    }

    protected s51 _findCustomBeanDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, kh khVar) throws JsonMappingException {
        Iterator<q90> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            s51 s51VarFindBeanDeserializer = it.next().findBeanDeserializer(javaType, deserializationConfig, khVar);
            if (s51VarFindBeanDeserializer != null) {
                return s51VarFindBeanDeserializer;
            }
        }
        return null;
    }

    protected s51 _findCustomCollectionDeserializer(CollectionType collectionType, DeserializationConfig deserializationConfig, kh khVar, m63 m63Var, s51 s51Var) throws JsonMappingException {
        Iterator<q90> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            s51 s51VarFindCollectionDeserializer = it.next().findCollectionDeserializer(collectionType, deserializationConfig, khVar, m63Var, s51Var);
            if (s51VarFindCollectionDeserializer != null) {
                return s51VarFindCollectionDeserializer;
            }
        }
        return null;
    }

    protected s51 _findCustomCollectionLikeDeserializer(CollectionLikeType collectionLikeType, DeserializationConfig deserializationConfig, kh khVar, m63 m63Var, s51 s51Var) throws JsonMappingException {
        Iterator<q90> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            s51 s51VarFindCollectionLikeDeserializer = it.next().findCollectionLikeDeserializer(collectionLikeType, deserializationConfig, khVar, m63Var, s51Var);
            if (s51VarFindCollectionLikeDeserializer != null) {
                return s51VarFindCollectionLikeDeserializer;
            }
        }
        return null;
    }

    protected s51 _findCustomEnumDeserializer(Class<?> cls, DeserializationConfig deserializationConfig, kh khVar) throws JsonMappingException {
        Iterator<q90> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            s51 s51VarFindEnumDeserializer = it.next().findEnumDeserializer(cls, deserializationConfig, khVar);
            if (s51VarFindEnumDeserializer != null) {
                return s51VarFindEnumDeserializer;
            }
        }
        return null;
    }

    protected s51 _findCustomMapDeserializer(MapType mapType, DeserializationConfig deserializationConfig, kh khVar, a91 a91Var, m63 m63Var, s51 s51Var) throws JsonMappingException {
        Iterator<q90> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            s51 s51VarFindMapDeserializer = it.next().findMapDeserializer(mapType, deserializationConfig, khVar, a91Var, m63Var, s51Var);
            if (s51VarFindMapDeserializer != null) {
                return s51VarFindMapDeserializer;
            }
        }
        return null;
    }

    protected s51 _findCustomMapLikeDeserializer(MapLikeType mapLikeType, DeserializationConfig deserializationConfig, kh khVar, a91 a91Var, m63 m63Var, s51 s51Var) throws JsonMappingException {
        Iterator<q90> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            s51 s51VarFindMapLikeDeserializer = it.next().findMapLikeDeserializer(mapLikeType, deserializationConfig, khVar, a91Var, m63Var, s51Var);
            if (s51VarFindMapLikeDeserializer != null) {
                return s51VarFindMapLikeDeserializer;
            }
        }
        return null;
    }

    protected s51 _findCustomReferenceDeserializer(ReferenceType referenceType, DeserializationConfig deserializationConfig, kh khVar, m63 m63Var, s51 s51Var) throws JsonMappingException {
        Iterator<q90> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            s51 s51VarFindReferenceDeserializer = it.next().findReferenceDeserializer(referenceType, deserializationConfig, khVar, m63Var, s51Var);
            if (s51VarFindReferenceDeserializer != null) {
                return s51VarFindReferenceDeserializer;
            }
        }
        return null;
    }

    protected s51 _findCustomTreeNodeDeserializer(Class<? extends JsonNode> cls, DeserializationConfig deserializationConfig, kh khVar) throws JsonMappingException {
        Iterator<q90> it = this._factoryConfig.deserializers().iterator();
        while (it.hasNext()) {
            s51 s51VarFindTreeNodeDeserializer = it.next().findTreeNodeDeserializer(cls, deserializationConfig, khVar);
            if (s51VarFindTreeNodeDeserializer != null) {
                return s51VarFindTreeNodeDeserializer;
            }
        }
        return null;
    }

    @Deprecated
    protected AnnotatedMethod _findJsonValueFor(DeserializationConfig deserializationConfig, JavaType javaType) {
        if (javaType == null) {
            return null;
        }
        return deserializationConfig.introspect(javaType).k();
    }

    protected JavaType _findRemappedType(DeserializationConfig deserializationConfig, Class<?> cls) throws JsonMappingException {
        JavaType javaTypeMapAbstractType = mapAbstractType(deserializationConfig, deserializationConfig.constructType(cls));
        if (javaTypeMapAbstractType == null || javaTypeMapAbstractType.hasRawClass(cls)) {
            return null;
        }
        return javaTypeMapAbstractType;
    }

    protected PropertyMetadata _getSetterInfo(DeserializationContext deserializationContext, BeanProperty beanProperty, PropertyMetadata propertyMetadata) {
        Nulls nullsNonDefaultContentNulls;
        JsonSetter.Value valueFindSetterInfo;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        DeserializationConfig config = deserializationContext.getConfig();
        AnnotatedMember member = beanProperty.getMember();
        Nulls nullsNonDefaultValueNulls = null;
        if (member != null) {
            if (annotationIntrospector == null || (valueFindSetterInfo = annotationIntrospector.findSetterInfo(member)) == null) {
                nullsNonDefaultContentNulls = null;
            } else {
                nullsNonDefaultValueNulls = valueFindSetterInfo.nonDefaultValueNulls();
                nullsNonDefaultContentNulls = valueFindSetterInfo.nonDefaultContentNulls();
            }
            JsonSetter.Value setterInfo = config.getConfigOverride(beanProperty.getType().getRawClass()).getSetterInfo();
            if (setterInfo != null) {
                if (nullsNonDefaultValueNulls == null) {
                    nullsNonDefaultValueNulls = setterInfo.nonDefaultValueNulls();
                }
                if (nullsNonDefaultContentNulls == null) {
                    nullsNonDefaultContentNulls = setterInfo.nonDefaultContentNulls();
                }
            }
        } else {
            nullsNonDefaultContentNulls = null;
        }
        JsonSetter.Value defaultSetterInfo = config.getDefaultSetterInfo();
        if (nullsNonDefaultValueNulls == null) {
            nullsNonDefaultValueNulls = defaultSetterInfo.nonDefaultValueNulls();
        }
        if (nullsNonDefaultContentNulls == null) {
            nullsNonDefaultContentNulls = defaultSetterInfo.nonDefaultContentNulls();
        }
        return (nullsNonDefaultValueNulls == null && nullsNonDefaultContentNulls == null) ? propertyMetadata : propertyMetadata.withNulls(nullsNonDefaultValueNulls, nullsNonDefaultContentNulls);
    }

    protected boolean _handleSingleArgumentCreator(x40 x40Var, AnnotatedWithParams annotatedWithParams, boolean z, boolean z2) {
        Class<?> rawParameterType = annotatedWithParams.getRawParameterType(0);
        if (rawParameterType == String.class || rawParameterType == CLASS_CHAR_SEQUENCE) {
            if (z || z2) {
                x40Var.m(annotatedWithParams, z);
            }
            return true;
        }
        if (rawParameterType == Integer.TYPE || rawParameterType == Integer.class) {
            if (z || z2) {
                x40Var.j(annotatedWithParams, z);
            }
            return true;
        }
        if (rawParameterType == Long.TYPE || rawParameterType == Long.class) {
            if (z || z2) {
                x40Var.k(annotatedWithParams, z);
            }
            return true;
        }
        if (rawParameterType == Double.TYPE || rawParameterType == Double.class) {
            if (z || z2) {
                x40Var.i(annotatedWithParams, z);
            }
            return true;
        }
        if (rawParameterType == Boolean.TYPE || rawParameterType == Boolean.class) {
            if (z || z2) {
                x40Var.g(annotatedWithParams, z);
            }
            return true;
        }
        if (rawParameterType == BigInteger.class && (z || z2)) {
            x40Var.f(annotatedWithParams, z);
        }
        if (rawParameterType == BigDecimal.class && (z || z2)) {
            x40Var.e(annotatedWithParams, z);
        }
        if (!z) {
            return false;
        }
        x40Var.h(annotatedWithParams, z, null, 0);
        return true;
    }

    protected boolean _hasCreatorAnnotation(DeserializationContext deserializationContext, d7 d7Var) {
        JsonCreator.Mode modeFindCreatorAnnotation;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        return (annotationIntrospector == null || (modeFindCreatorAnnotation = annotationIntrospector.findCreatorAnnotation(deserializationContext.getConfig(), d7Var)) == null || modeFindCreatorAnnotation == JsonCreator.Mode.DISABLED) ? false : true;
    }

    protected CollectionType _mapAbstractCollectionType(JavaType javaType, DeserializationConfig deserializationConfig) {
        Class<?> clsA = b.a(javaType);
        if (clsA != null) {
            return (CollectionType) deserializationConfig.getTypeFactory().constructSpecializedType(javaType, clsA, true);
        }
        return null;
    }

    protected MapType _mapAbstractMapType(JavaType javaType, DeserializationConfig deserializationConfig) {
        Class<?> clsB = b.b(javaType);
        if (clsB != null) {
            return (MapType) deserializationConfig.getTypeFactory().constructSpecializedType(javaType, clsB, true);
        }
        return null;
    }

    protected void _reportUnwrappedCreatorProperty(DeserializationContext deserializationContext, kh khVar, AnnotatedParameter annotatedParameter) throws JsonMappingException {
        deserializationContext.reportBadTypeDefinition(khVar, "Cannot define Creator parameter %d as `@JsonUnwrapped`: combination not yet supported", Integer.valueOf(annotatedParameter.getIndex()));
    }

    protected void _validateNamedPropertyParameter(DeserializationContext deserializationContext, kh khVar, w40 w40Var, int i, PropertyName propertyName, JacksonInject.Value value) throws JsonMappingException {
        if (propertyName == null && value == null) {
            deserializationContext.reportBadTypeDefinition(khVar, "Argument #%d of constructor %s has no property name (and is not Injectable): can not use as property-based Creator", Integer.valueOf(i), w40Var);
        }
    }

    public ValueInstantiator _valueInstantiatorInstance(DeserializationConfig deserializationConfig, d7 d7Var, Object obj) throws JsonMappingException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof ValueInstantiator) {
            return (ValueInstantiator) obj;
        }
        if (!(obj instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + obj.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
        }
        Class cls = (Class) obj;
        if (ay.J(cls)) {
            return null;
        }
        if (ValueInstantiator.class.isAssignableFrom(cls)) {
            deserializationConfig.getHandlerInstantiator();
            return (ValueInstantiator) ay.l(cls, deserializationConfig.canOverrideAccessModifiers());
        }
        throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<ValueInstantiator>");
    }

    protected SettableBeanProperty constructCreatorProperty(DeserializationContext deserializationContext, kh khVar, PropertyName propertyName, int i, AnnotatedParameter annotatedParameter, JacksonInject.Value value) throws JsonMappingException {
        PropertyName propertyNameFindWrapperName;
        PropertyMetadata propertyMetadata;
        DeserializationConfig config = deserializationContext.getConfig();
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null) {
            propertyMetadata = PropertyMetadata.STD_REQUIRED_OR_OPTIONAL;
            propertyNameFindWrapperName = null;
        } else {
            PropertyMetadata propertyMetadataConstruct = PropertyMetadata.construct(annotationIntrospector.hasRequiredMarker(annotatedParameter), annotationIntrospector.findPropertyDescription(annotatedParameter), annotationIntrospector.findPropertyIndex(annotatedParameter), annotationIntrospector.findPropertyDefaultValue(annotatedParameter));
            propertyNameFindWrapperName = annotationIntrospector.findWrapperName(annotatedParameter);
            propertyMetadata = propertyMetadataConstruct;
        }
        JavaType javaTypeResolveMemberAndTypeAnnotations = resolveMemberAndTypeAnnotations(deserializationContext, annotatedParameter, annotatedParameter.getType());
        BeanProperty.Std std = new BeanProperty.Std(propertyName, javaTypeResolveMemberAndTypeAnnotations, propertyNameFindWrapperName, annotatedParameter, propertyMetadata);
        m63 m63VarFindTypeDeserializer = (m63) javaTypeResolveMemberAndTypeAnnotations.getTypeHandler();
        if (m63VarFindTypeDeserializer == null) {
            m63VarFindTypeDeserializer = findTypeDeserializer(config, javaTypeResolveMemberAndTypeAnnotations);
        }
        CreatorProperty creatorPropertyConstruct = CreatorProperty.construct(propertyName, javaTypeResolveMemberAndTypeAnnotations, std.getWrapperName(), m63VarFindTypeDeserializer, khVar.s(), annotatedParameter, i, value, _getSetterInfo(deserializationContext, std, propertyMetadata));
        s51 s51VarFindDeserializerFromAnnotation = findDeserializerFromAnnotation(deserializationContext, annotatedParameter);
        if (s51VarFindDeserializerFromAnnotation == null) {
            s51VarFindDeserializerFromAnnotation = (s51) javaTypeResolveMemberAndTypeAnnotations.getValueHandler();
        }
        return s51VarFindDeserializerFromAnnotation != null ? creatorPropertyConstruct.withValueDeserializer(deserializationContext.handlePrimaryContextualization(s51VarFindDeserializerFromAnnotation, creatorPropertyConstruct, javaTypeResolveMemberAndTypeAnnotations)) : creatorPropertyConstruct;
    }

    protected EnumResolver constructEnumResolver(Class<?> cls, DeserializationConfig deserializationConfig, AnnotatedMember annotatedMember) {
        if (annotatedMember == null) {
            return EnumResolver.constructFor(deserializationConfig, cls);
        }
        if (deserializationConfig.canOverrideAccessModifiers()) {
            ay.g(annotatedMember.getMember(), deserializationConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return EnumResolver.constructUsingMethod(deserializationConfig, cls, annotatedMember);
    }

    @Override // com.fasterxml.jackson.databind.deser.a
    public s51 createArrayDeserializer(DeserializationContext deserializationContext, ArrayType arrayType, kh khVar) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        JavaType javaTypeMo15getContentType = arrayType.mo15getContentType();
        s51 s51Var = (s51) javaTypeMo15getContentType.getValueHandler();
        m63 m63VarFindTypeDeserializer = (m63) javaTypeMo15getContentType.getTypeHandler();
        if (m63VarFindTypeDeserializer == null) {
            m63VarFindTypeDeserializer = findTypeDeserializer(config, javaTypeMo15getContentType);
        }
        m63 m63Var = m63VarFindTypeDeserializer;
        s51 s51Var_findCustomArrayDeserializer = _findCustomArrayDeserializer(arrayType, config, khVar, m63Var, s51Var);
        if (s51Var_findCustomArrayDeserializer == null) {
            if (s51Var == null) {
                Class<?> rawClass = javaTypeMo15getContentType.getRawClass();
                if (javaTypeMo15getContentType.isPrimitive()) {
                    return PrimitiveArrayDeserializers.forType(rawClass);
                }
                if (rawClass == String.class) {
                    return StringArrayDeserializer.instance;
                }
            }
            s51Var_findCustomArrayDeserializer = new ObjectArrayDeserializer(arrayType, s51Var, m63Var);
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<mh> it = this._factoryConfig.deserializerModifiers().iterator();
            if (it.hasNext()) {
                e43.a(it.next());
                throw null;
            }
        }
        return s51Var_findCustomArrayDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.a
    public s51 createCollectionDeserializer(DeserializationContext deserializationContext, CollectionType collectionType, kh khVar) throws JsonMappingException {
        JavaType javaTypeMo15getContentType = collectionType.mo15getContentType();
        s51 s51Var = (s51) javaTypeMo15getContentType.getValueHandler();
        DeserializationConfig config = deserializationContext.getConfig();
        m63 m63VarFindTypeDeserializer = (m63) javaTypeMo15getContentType.getTypeHandler();
        if (m63VarFindTypeDeserializer == null) {
            m63VarFindTypeDeserializer = findTypeDeserializer(config, javaTypeMo15getContentType);
        }
        m63 m63Var = m63VarFindTypeDeserializer;
        s51 s51Var_findCustomCollectionDeserializer = _findCustomCollectionDeserializer(collectionType, config, khVar, m63Var, s51Var);
        if (s51Var_findCustomCollectionDeserializer == null) {
            Class<?> rawClass = collectionType.getRawClass();
            if (s51Var == null && EnumSet.class.isAssignableFrom(rawClass)) {
                s51Var_findCustomCollectionDeserializer = new EnumSetDeserializer(javaTypeMo15getContentType, null);
            }
        }
        if (s51Var_findCustomCollectionDeserializer == null) {
            if (collectionType.isInterface() || collectionType.isAbstract()) {
                CollectionType collectionType_mapAbstractCollectionType = _mapAbstractCollectionType(collectionType, config);
                if (collectionType_mapAbstractCollectionType != null) {
                    khVar = config.introspectForCreation(collectionType_mapAbstractCollectionType);
                    collectionType = collectionType_mapAbstractCollectionType;
                } else {
                    if (collectionType.getTypeHandler() == null) {
                        throw new IllegalArgumentException("Cannot find a deserializer for non-concrete Collection type " + collectionType);
                    }
                    s51Var_findCustomCollectionDeserializer = AbstractDeserializer.constructForNonPOJO(khVar);
                }
            }
            if (s51Var_findCustomCollectionDeserializer == null) {
                ValueInstantiator valueInstantiatorFindValueInstantiator = findValueInstantiator(deserializationContext, khVar);
                if (!valueInstantiatorFindValueInstantiator.canCreateUsingDefault()) {
                    if (collectionType.hasRawClass(ArrayBlockingQueue.class)) {
                        return new ArrayBlockingQueueDeserializer(collectionType, s51Var, m63Var, valueInstantiatorFindValueInstantiator);
                    }
                    s51 s51VarH = n41.h(deserializationContext, collectionType);
                    if (s51VarH != null) {
                        return s51VarH;
                    }
                }
                s51Var_findCustomCollectionDeserializer = javaTypeMo15getContentType.hasRawClass(String.class) ? new StringCollectionDeserializer(collectionType, s51Var, valueInstantiatorFindValueInstantiator) : new CollectionDeserializer(collectionType, s51Var, m63Var, valueInstantiatorFindValueInstantiator);
            }
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<mh> it = this._factoryConfig.deserializerModifiers().iterator();
            if (it.hasNext()) {
                e43.a(it.next());
                throw null;
            }
        }
        return s51Var_findCustomCollectionDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.a
    public s51 createCollectionLikeDeserializer(DeserializationContext deserializationContext, CollectionLikeType collectionLikeType, kh khVar) throws JsonMappingException {
        JavaType javaTypeMo15getContentType = collectionLikeType.mo15getContentType();
        s51 s51Var = (s51) javaTypeMo15getContentType.getValueHandler();
        DeserializationConfig config = deserializationContext.getConfig();
        m63 m63VarFindTypeDeserializer = (m63) javaTypeMo15getContentType.getTypeHandler();
        if (m63VarFindTypeDeserializer == null) {
            m63VarFindTypeDeserializer = findTypeDeserializer(config, javaTypeMo15getContentType);
        }
        s51 s51Var_findCustomCollectionLikeDeserializer = _findCustomCollectionLikeDeserializer(collectionLikeType, config, khVar, m63VarFindTypeDeserializer, s51Var);
        if (s51Var_findCustomCollectionLikeDeserializer != null && this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<mh> it = this._factoryConfig.deserializerModifiers().iterator();
            if (it.hasNext()) {
                e43.a(it.next());
                throw null;
            }
        }
        return s51Var_findCustomCollectionLikeDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.a
    public s51 createEnumDeserializer(DeserializationContext deserializationContext, JavaType javaType, kh khVar) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        Class<?> rawClass = javaType.getRawClass();
        s51 s51Var_findCustomEnumDeserializer = _findCustomEnumDeserializer(rawClass, config, khVar);
        if (s51Var_findCustomEnumDeserializer == null) {
            if (rawClass == Enum.class) {
                return AbstractDeserializer.constructForNonPOJO(khVar);
            }
            ValueInstantiator valueInstantiator_constructDefaultValueInstantiator = _constructDefaultValueInstantiator(deserializationContext, khVar);
            SettableBeanProperty[] fromObjectArguments = valueInstantiator_constructDefaultValueInstantiator == null ? null : valueInstantiator_constructDefaultValueInstantiator.getFromObjectArguments(deserializationContext.getConfig());
            for (AnnotatedMethod annotatedMethod : khVar.w()) {
                if (_hasCreatorAnnotation(deserializationContext, annotatedMethod)) {
                    if (annotatedMethod.getParameterCount() != 0) {
                        if (!annotatedMethod.getRawReturnType().isAssignableFrom(rawClass)) {
                            deserializationContext.reportBadDefinition(javaType, String.format("Invalid `@JsonCreator` annotated Enum factory method [%s]: needs to return compatible type", annotatedMethod.toString()));
                        }
                        s51Var_findCustomEnumDeserializer = EnumDeserializer.deserializerForCreator(config, rawClass, annotatedMethod, valueInstantiator_constructDefaultValueInstantiator, fromObjectArguments);
                        break;
                    }
                    s51Var_findCustomEnumDeserializer = EnumDeserializer.deserializerForNoArgsCreator(config, rawClass, annotatedMethod);
                    break;
                }
            }
            if (s51Var_findCustomEnumDeserializer == null) {
                s51Var_findCustomEnumDeserializer = new EnumDeserializer(constructEnumResolver(rawClass, config, khVar.j()), Boolean.valueOf(config.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)));
            }
        }
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<mh> it = this._factoryConfig.deserializerModifiers().iterator();
            if (it.hasNext()) {
                e43.a(it.next());
                throw null;
            }
        }
        return s51Var_findCustomEnumDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.a
    public a91 createKeyDeserializer(DeserializationContext deserializationContext, JavaType javaType) throws JsonMappingException {
        kh khVarIntrospectClassAnnotations;
        a91 a91VarFindKeyDeserializerFromAnnotation;
        DeserializationConfig config = deserializationContext.getConfig();
        if (this._factoryConfig.hasKeyDeserializers()) {
            khVarIntrospectClassAnnotations = config.introspectClassAnnotations(javaType);
            Iterator<b91> it = this._factoryConfig.keyDeserializers().iterator();
            a91VarFindKeyDeserializerFromAnnotation = null;
            while (it.hasNext() && (a91VarFindKeyDeserializerFromAnnotation = it.next().findKeyDeserializer(javaType, config, khVarIntrospectClassAnnotations)) == null) {
            }
        } else {
            khVarIntrospectClassAnnotations = null;
            a91VarFindKeyDeserializerFromAnnotation = null;
        }
        if (a91VarFindKeyDeserializerFromAnnotation == null) {
            if (khVarIntrospectClassAnnotations == null) {
                khVarIntrospectClassAnnotations = config.introspectClassAnnotations(javaType.getRawClass());
            }
            a91VarFindKeyDeserializerFromAnnotation = findKeyDeserializerFromAnnotation(deserializationContext, khVarIntrospectClassAnnotations.t());
            if (a91VarFindKeyDeserializerFromAnnotation == null) {
                a91VarFindKeyDeserializerFromAnnotation = javaType.isEnumType() ? _createEnumKeyDeserializer(deserializationContext, javaType) : StdKeyDeserializers.findStringBasedKeyDeserializer(config, javaType);
            }
        }
        if (a91VarFindKeyDeserializerFromAnnotation != null && this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<mh> it2 = this._factoryConfig.deserializerModifiers().iterator();
            if (it2.hasNext()) {
                e43.a(it2.next());
                throw null;
            }
        }
        return a91VarFindKeyDeserializerFromAnnotation;
    }

    @Override // com.fasterxml.jackson.databind.deser.a
    public s51 createMapDeserializer(DeserializationContext deserializationContext, MapType mapType, kh khVar) throws JsonMappingException {
        kh khVarIntrospectForCreation;
        s51 s51VarConstructForNonPOJO;
        MapType mapType2;
        s51 s51Var;
        ValueInstantiator valueInstantiatorFindValueInstantiator;
        EnumMapDeserializer enumMapDeserializer;
        DeserializationConfig config = deserializationContext.getConfig();
        JavaType javaTypeMo16getKeyType = mapType.mo16getKeyType();
        JavaType javaTypeMo15getContentType = mapType.mo15getContentType();
        s51 s51Var2 = (s51) javaTypeMo15getContentType.getValueHandler();
        a91 a91Var = (a91) javaTypeMo16getKeyType.getValueHandler();
        m63 m63Var = (m63) javaTypeMo15getContentType.getTypeHandler();
        m63 m63VarFindTypeDeserializer = m63Var == null ? findTypeDeserializer(config, javaTypeMo15getContentType) : m63Var;
        s51 s51Var_findCustomMapDeserializer = _findCustomMapDeserializer(mapType, config, khVar, a91Var, m63VarFindTypeDeserializer, s51Var2);
        if (s51Var_findCustomMapDeserializer == null) {
            Class<?> rawClass = mapType.getRawClass();
            if (EnumMap.class.isAssignableFrom(rawClass)) {
                if (rawClass == EnumMap.class) {
                    khVarIntrospectForCreation = khVar;
                    valueInstantiatorFindValueInstantiator = null;
                } else {
                    khVarIntrospectForCreation = khVar;
                    valueInstantiatorFindValueInstantiator = findValueInstantiator(deserializationContext, khVarIntrospectForCreation);
                }
                if (!javaTypeMo16getKeyType.isEnumImplType()) {
                    throw new IllegalArgumentException("Cannot construct EnumMap; generic (key) type not available");
                }
                enumMapDeserializer = new EnumMapDeserializer(mapType, valueInstantiatorFindValueInstantiator, null, s51Var2, m63VarFindTypeDeserializer, null);
            } else {
                khVarIntrospectForCreation = khVar;
            }
            if (s51Var_findCustomMapDeserializer == null) {
                s51Var_findCustomMapDeserializer = s51Var_findCustomMapDeserializer;
                if (mapType.isInterface() || mapType.isAbstract()) {
                    s51Var_findCustomMapDeserializer = enumMapDeserializer;
                    s51Var_findCustomMapDeserializer = enumMapDeserializer;
                    MapType mapType_mapAbstractMapType = _mapAbstractMapType(mapType, config);
                    if (mapType_mapAbstractMapType != null) {
                        mapType_mapAbstractMapType.getRawClass();
                        khVarIntrospectForCreation = config.introspectForCreation(mapType_mapAbstractMapType);
                        s51VarConstructForNonPOJO = s51Var_findCustomMapDeserializer;
                    } else {
                        if (mapType.getTypeHandler() == null) {
                            throw new IllegalArgumentException("Cannot find a deserializer for non-concrete Map type " + mapType);
                        }
                        mapType_mapAbstractMapType = mapType;
                        s51VarConstructForNonPOJO = AbstractDeserializer.constructForNonPOJO(khVar);
                    }
                    mapType2 = mapType_mapAbstractMapType;
                    s51Var = s51VarConstructForNonPOJO;
                } else {
                    s51 s51VarI = n41.i(deserializationContext, mapType);
                    if (s51VarI != null) {
                        s51Var_findCustomMapDeserializer = enumMapDeserializer;
                        return s51VarI;
                    }
                    s51Var_findCustomMapDeserializer = enumMapDeserializer;
                    s51Var = s51VarI;
                    mapType2 = mapType;
                }
                kh khVar2 = khVarIntrospectForCreation;
                s51 s51Var3 = s51Var;
                if (s51Var == null) {
                    MapDeserializer mapDeserializer = new MapDeserializer(mapType2, findValueInstantiator(deserializationContext, khVar2), a91Var, s51Var2, m63VarFindTypeDeserializer);
                    JsonIgnoreProperties.Value defaultPropertyIgnorals = config.getDefaultPropertyIgnorals(Map.class, khVar2.t());
                    mapDeserializer.setIgnorableProperties(defaultPropertyIgnorals == null ? null : defaultPropertyIgnorals.findIgnoredForDeserialization());
                    JsonIncludeProperties.Value defaultPropertyInclusions = config.getDefaultPropertyInclusions(Map.class, khVar2.t());
                    mapDeserializer.setIncludableProperties(defaultPropertyInclusions == null ? null : defaultPropertyInclusions.getIncluded());
                    s51Var3 = mapDeserializer;
                }
                s51Var_findCustomMapDeserializer = s51Var3;
            }
        }
        s51Var_findCustomMapDeserializer = s51Var_findCustomMapDeserializer;
        s51Var_findCustomMapDeserializer = enumMapDeserializer;
        if (this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<mh> it = this._factoryConfig.deserializerModifiers().iterator();
            if (it.hasNext()) {
                e43.a(it.next());
                throw null;
            }
        }
        return s51Var_findCustomMapDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.a
    public s51 createMapLikeDeserializer(DeserializationContext deserializationContext, MapLikeType mapLikeType, kh khVar) throws JsonMappingException {
        JavaType javaTypeMo16getKeyType = mapLikeType.mo16getKeyType();
        JavaType javaTypeMo15getContentType = mapLikeType.mo15getContentType();
        DeserializationConfig config = deserializationContext.getConfig();
        s51 s51Var = (s51) javaTypeMo15getContentType.getValueHandler();
        a91 a91Var = (a91) javaTypeMo16getKeyType.getValueHandler();
        m63 m63VarFindTypeDeserializer = (m63) javaTypeMo15getContentType.getTypeHandler();
        if (m63VarFindTypeDeserializer == null) {
            m63VarFindTypeDeserializer = findTypeDeserializer(config, javaTypeMo15getContentType);
        }
        s51 s51Var_findCustomMapLikeDeserializer = _findCustomMapLikeDeserializer(mapLikeType, config, khVar, a91Var, m63VarFindTypeDeserializer, s51Var);
        if (s51Var_findCustomMapLikeDeserializer != null && this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<mh> it = this._factoryConfig.deserializerModifiers().iterator();
            if (it.hasNext()) {
                e43.a(it.next());
                throw null;
            }
        }
        return s51Var_findCustomMapLikeDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.a
    public s51 createReferenceDeserializer(DeserializationContext deserializationContext, ReferenceType referenceType, kh khVar) throws JsonMappingException {
        JavaType javaTypeMo15getContentType = referenceType.mo15getContentType();
        s51 s51Var = (s51) javaTypeMo15getContentType.getValueHandler();
        DeserializationConfig config = deserializationContext.getConfig();
        m63 m63VarFindTypeDeserializer = (m63) javaTypeMo15getContentType.getTypeHandler();
        if (m63VarFindTypeDeserializer == null) {
            m63VarFindTypeDeserializer = findTypeDeserializer(config, javaTypeMo15getContentType);
        }
        m63 m63Var = m63VarFindTypeDeserializer;
        s51 s51Var_findCustomReferenceDeserializer = _findCustomReferenceDeserializer(referenceType, config, khVar, m63Var, s51Var);
        if (s51Var_findCustomReferenceDeserializer == null && referenceType.isTypeOrSubTypeOf(AtomicReference.class)) {
            return new AtomicReferenceDeserializer(referenceType, referenceType.getRawClass() != AtomicReference.class ? findValueInstantiator(deserializationContext, khVar) : null, m63Var, s51Var);
        }
        if (s51Var_findCustomReferenceDeserializer != null && this._factoryConfig.hasDeserializerModifiers()) {
            Iterator<mh> it = this._factoryConfig.deserializerModifiers().iterator();
            if (it.hasNext()) {
                e43.a(it.next());
                throw null;
            }
        }
        return s51Var_findCustomReferenceDeserializer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fasterxml.jackson.databind.deser.a
    public s51 createTreeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, kh khVar) throws JsonMappingException {
        Class<?> rawClass = javaType.getRawClass();
        s51 s51Var_findCustomTreeNodeDeserializer = _findCustomTreeNodeDeserializer(rawClass, deserializationConfig, khVar);
        return s51Var_findCustomTreeNodeDeserializer != null ? s51Var_findCustomTreeNodeDeserializer : JsonNodeDeserializer.getDeserializer(rawClass);
    }

    protected s51 findContentDeserializerFromAnnotation(DeserializationContext deserializationContext, d7 d7Var) throws JsonMappingException {
        Object objFindContentDeserializer;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null || (objFindContentDeserializer = annotationIntrospector.findContentDeserializer(d7Var)) == null) {
            return null;
        }
        return deserializationContext.deserializerInstance(d7Var, objFindContentDeserializer);
    }

    public s51 findDefaultDeserializer(DeserializationContext deserializationContext, JavaType javaType, kh khVar) throws JsonMappingException {
        JavaType javaType_findRemappedType;
        JavaType javaType_findRemappedType2;
        Class<?> rawClass = javaType.getRawClass();
        if (rawClass == CLASS_OBJECT || rawClass == CLASS_SERIALIZABLE) {
            DeserializationConfig config = deserializationContext.getConfig();
            if (this._factoryConfig.hasAbstractTypeResolvers()) {
                javaType_findRemappedType = _findRemappedType(config, List.class);
                javaType_findRemappedType2 = _findRemappedType(config, Map.class);
            } else {
                javaType_findRemappedType = null;
                javaType_findRemappedType2 = null;
            }
            return new UntypedObjectDeserializer(javaType_findRemappedType, javaType_findRemappedType2);
        }
        if (rawClass == CLASS_STRING || rawClass == CLASS_CHAR_SEQUENCE) {
            return StringDeserializer.instance;
        }
        Class<?> cls = CLASS_ITERABLE;
        if (rawClass == cls) {
            TypeFactory typeFactory = deserializationContext.getTypeFactory();
            JavaType[] javaTypeArrFindTypeParameters = typeFactory.findTypeParameters(javaType, cls);
            return createCollectionDeserializer(deserializationContext, typeFactory.constructCollectionType(Collection.class, (javaTypeArrFindTypeParameters == null || javaTypeArrFindTypeParameters.length != 1) ? TypeFactory.unknownType() : javaTypeArrFindTypeParameters[0]), khVar);
        }
        if (rawClass == CLASS_MAP_ENTRY) {
            JavaType javaTypeContainedTypeOrUnknown = javaType.containedTypeOrUnknown(0);
            JavaType javaTypeContainedTypeOrUnknown2 = javaType.containedTypeOrUnknown(1);
            m63 m63VarFindTypeDeserializer = (m63) javaTypeContainedTypeOrUnknown2.getTypeHandler();
            if (m63VarFindTypeDeserializer == null) {
                m63VarFindTypeDeserializer = findTypeDeserializer(deserializationContext.getConfig(), javaTypeContainedTypeOrUnknown2);
            }
            return new MapEntryDeserializer(javaType, (a91) javaTypeContainedTypeOrUnknown.getValueHandler(), (s51) javaTypeContainedTypeOrUnknown2.getValueHandler(), m63VarFindTypeDeserializer);
        }
        String name = rawClass.getName();
        if (rawClass.isPrimitive() || name.startsWith("java.")) {
            s51 s51VarA = NumberDeserializers.a(rawClass, name);
            if (s51VarA == null) {
                s51VarA = DateDeserializers.a(rawClass, name);
            }
            if (s51VarA != null) {
                return s51VarA;
            }
        }
        if (rawClass == q33.class) {
            return new TokenBufferDeserializer();
        }
        s51 s51VarFindOptionalStdDeserializer = findOptionalStdDeserializer(deserializationContext, javaType, khVar);
        return s51VarFindOptionalStdDeserializer != null ? s51VarFindOptionalStdDeserializer : com.fasterxml.jackson.databind.deser.std.a.a(deserializationContext, rawClass, name);
    }

    protected s51 findDeserializerFromAnnotation(DeserializationContext deserializationContext, d7 d7Var) throws JsonMappingException {
        Object objFindDeserializer;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null || (objFindDeserializer = annotationIntrospector.findDeserializer(d7Var)) == null) {
            return null;
        }
        return deserializationContext.deserializerInstance(d7Var, objFindDeserializer);
    }

    protected a91 findKeyDeserializerFromAnnotation(DeserializationContext deserializationContext, d7 d7Var) throws JsonMappingException {
        Object objFindKeyDeserializer;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null || (objFindKeyDeserializer = annotationIntrospector.findKeyDeserializer(d7Var)) == null) {
            return null;
        }
        return deserializationContext.keyDeserializerInstance(d7Var, objFindKeyDeserializer);
    }

    protected s51 findOptionalStdDeserializer(DeserializationContext deserializationContext, JavaType javaType, kh khVar) throws JsonMappingException {
        return OptionalHandlerFactory.instance.findDeserializer(javaType, deserializationContext.getConfig(), khVar);
    }

    public m63 findPropertyContentTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, AnnotatedMember annotatedMember) throws JsonMappingException {
        x63 x63VarFindPropertyContentTypeResolver = deserializationConfig.getAnnotationIntrospector().findPropertyContentTypeResolver(deserializationConfig, annotatedMember, javaType);
        JavaType javaTypeMo15getContentType = javaType.mo15getContentType();
        return x63VarFindPropertyContentTypeResolver == null ? findTypeDeserializer(deserializationConfig, javaTypeMo15getContentType) : x63VarFindPropertyContentTypeResolver.buildTypeDeserializer(deserializationConfig, javaTypeMo15getContentType, deserializationConfig.getSubtypeResolver().collectAndResolveSubtypesByTypeId(deserializationConfig, annotatedMember, javaTypeMo15getContentType));
    }

    public m63 findPropertyTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, AnnotatedMember annotatedMember) throws JsonMappingException {
        x63 x63VarFindPropertyTypeResolver = deserializationConfig.getAnnotationIntrospector().findPropertyTypeResolver(deserializationConfig, annotatedMember, javaType);
        if (x63VarFindPropertyTypeResolver == null) {
            return findTypeDeserializer(deserializationConfig, javaType);
        }
        try {
            return x63VarFindPropertyTypeResolver.buildTypeDeserializer(deserializationConfig, javaType, deserializationConfig.getSubtypeResolver().collectAndResolveSubtypesByTypeId(deserializationConfig, annotatedMember, javaType));
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw InvalidDefinitionException.from((JsonParser) null, ay.o(e), javaType).withCause(e);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.a
    public m63 findTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException {
        JavaType javaTypeMapAbstractType;
        com.fasterxml.jackson.databind.introspect.a aVarT = deserializationConfig.introspectClassAnnotations(javaType.getRawClass()).t();
        x63 x63VarFindTypeResolver = deserializationConfig.getAnnotationIntrospector().findTypeResolver(deserializationConfig, aVarT, javaType);
        if (x63VarFindTypeResolver == null && (x63VarFindTypeResolver = deserializationConfig.getDefaultTyper(javaType)) == null) {
            return null;
        }
        Collection collectionCollectAndResolveSubtypesByTypeId = deserializationConfig.getSubtypeResolver().collectAndResolveSubtypesByTypeId(deserializationConfig, aVarT);
        if (x63VarFindTypeResolver.getDefaultImpl() == null && javaType.isAbstract() && (javaTypeMapAbstractType = mapAbstractType(deserializationConfig, javaType)) != null && !javaTypeMapAbstractType.hasRawClass(javaType.getRawClass())) {
            x63VarFindTypeResolver = x63VarFindTypeResolver.withDefaultImpl(javaTypeMapAbstractType.getRawClass());
        }
        try {
            return x63VarFindTypeResolver.buildTypeDeserializer(deserializationConfig, javaType, collectionCollectAndResolveSubtypesByTypeId);
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw InvalidDefinitionException.from((JsonParser) null, ay.o(e), javaType).withCause(e);
        }
    }

    public ValueInstantiator findValueInstantiator(DeserializationContext deserializationContext, kh khVar) throws JsonMappingException {
        DeserializationConfig config = deserializationContext.getConfig();
        com.fasterxml.jackson.databind.introspect.a aVarT = khVar.t();
        Object objFindValueInstantiator = deserializationContext.getAnnotationIntrospector().findValueInstantiator(aVarT);
        ValueInstantiator valueInstantiator_valueInstantiatorInstance = objFindValueInstantiator != null ? _valueInstantiatorInstance(config, aVarT, objFindValueInstantiator) : null;
        if (valueInstantiator_valueInstantiatorInstance == null && (valueInstantiator_valueInstantiatorInstance = JDKValueInstantiators.a(config, khVar.r())) == null) {
            valueInstantiator_valueInstantiatorInstance = _constructDefaultValueInstantiator(deserializationContext, khVar);
        }
        if (this._factoryConfig.hasValueInstantiators()) {
            for (cb3 cb3Var : this._factoryConfig.valueInstantiators()) {
                valueInstantiator_valueInstantiatorInstance = cb3Var.findValueInstantiator(config, khVar, valueInstantiator_valueInstantiatorInstance);
                if (valueInstantiator_valueInstantiatorInstance == null) {
                    deserializationContext.reportBadTypeDefinition(khVar, "Broken registered ValueInstantiators (of type %s): returned null ValueInstantiator", cb3Var.getClass().getName());
                }
            }
        }
        return valueInstantiator_valueInstantiatorInstance != null ? valueInstantiator_valueInstantiatorInstance.createContextual(deserializationContext, khVar) : valueInstantiator_valueInstantiatorInstance;
    }

    public DeserializerFactoryConfig getFactoryConfig() {
        return this._factoryConfig;
    }

    public boolean hasExplicitDeserializerFor(DeserializationConfig deserializationConfig, Class<?> cls) {
        while (cls.isArray()) {
            cls = cls.getComponentType();
        }
        if (Enum.class.isAssignableFrom(cls)) {
            return true;
        }
        String name = cls.getName();
        if (!name.startsWith("java.")) {
            if (name.startsWith("com.fasterxml.")) {
                return JsonNode.class.isAssignableFrom(cls) || cls == q33.class;
            }
            return OptionalHandlerFactory.instance.hasDeserializerFor(cls);
        }
        if (Collection.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls)) {
            return true;
        }
        if (Number.class.isAssignableFrom(cls)) {
            return NumberDeserializers.a(cls, name) != null;
        }
        return com.fasterxml.jackson.databind.deser.std.a.b(cls) || cls == CLASS_STRING || cls == Boolean.class || cls == EnumMap.class || cls == AtomicReference.class || DateDeserializers.b(cls);
    }

    @Override // com.fasterxml.jackson.databind.deser.a
    public JavaType mapAbstractType(DeserializationConfig deserializationConfig, JavaType javaType) throws JsonMappingException {
        while (true) {
            JavaType javaType_mapAbstractType2 = _mapAbstractType2(deserializationConfig, javaType);
            if (javaType_mapAbstractType2 == null) {
                return javaType;
            }
            Class<?> rawClass = javaType.getRawClass();
            Class<?> rawClass2 = javaType_mapAbstractType2.getRawClass();
            if (rawClass == rawClass2 || !rawClass.isAssignableFrom(rawClass2)) {
                throw new IllegalArgumentException("Invalid abstract type resolution from " + javaType + " to " + javaType_mapAbstractType2 + ": latter is not a subtype of former");
            }
            javaType = javaType_mapAbstractType2;
        }
    }

    @Deprecated
    protected JavaType modifyTypeByAnnotation(DeserializationContext deserializationContext, d7 d7Var, JavaType javaType) throws JsonMappingException {
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        return annotationIntrospector == null ? javaType : annotationIntrospector.refineDeserializationType(deserializationContext.getConfig(), d7Var, javaType);
    }

    protected JavaType resolveMemberAndTypeAnnotations(DeserializationContext deserializationContext, AnnotatedMember annotatedMember, JavaType javaType) throws JsonMappingException {
        a91 a91VarKeyDeserializerInstance;
        AnnotationIntrospector annotationIntrospector = deserializationContext.getAnnotationIntrospector();
        if (annotationIntrospector == null) {
            return javaType;
        }
        if (javaType.isMapLikeType() && javaType.mo16getKeyType() != null && (a91VarKeyDeserializerInstance = deserializationContext.keyDeserializerInstance(annotatedMember, annotationIntrospector.findKeyDeserializer(annotatedMember))) != null) {
            javaType = ((MapLikeType) javaType).withKeyValueHandler(a91VarKeyDeserializerInstance);
            javaType.mo16getKeyType();
        }
        if (javaType.hasContentType()) {
            s51 s51VarDeserializerInstance = deserializationContext.deserializerInstance(annotatedMember, annotationIntrospector.findContentDeserializer(annotatedMember));
            if (s51VarDeserializerInstance != null) {
                javaType = javaType.withContentValueHandler(s51VarDeserializerInstance);
            }
            m63 m63VarFindPropertyContentTypeDeserializer = findPropertyContentTypeDeserializer(deserializationContext.getConfig(), javaType, annotatedMember);
            if (m63VarFindPropertyContentTypeDeserializer != null) {
                javaType = javaType.withContentTypeHandler(m63VarFindPropertyContentTypeDeserializer);
            }
        }
        m63 m63VarFindPropertyTypeDeserializer = findPropertyTypeDeserializer(deserializationContext.getConfig(), javaType, annotatedMember);
        if (m63VarFindPropertyTypeDeserializer != null) {
            javaType = javaType.withTypeHandler(m63VarFindPropertyTypeDeserializer);
        }
        return annotationIntrospector.refineDeserializationType(deserializationContext.getConfig(), annotatedMember, javaType);
    }

    @Deprecated
    protected JavaType resolveType(DeserializationContext deserializationContext, kh khVar, JavaType javaType, AnnotatedMember annotatedMember) throws JsonMappingException {
        return resolveMemberAndTypeAnnotations(deserializationContext, annotatedMember, javaType);
    }

    @Override // com.fasterxml.jackson.databind.deser.a
    public final com.fasterxml.jackson.databind.deser.a withAbstractTypeResolver(r1 r1Var) {
        return withConfig(this._factoryConfig.withAbstractTypeResolver(r1Var));
    }

    @Override // com.fasterxml.jackson.databind.deser.a
    public final com.fasterxml.jackson.databind.deser.a withAdditionalDeserializers(q90 q90Var) {
        return withConfig(this._factoryConfig.withAdditionalDeserializers(q90Var));
    }

    @Override // com.fasterxml.jackson.databind.deser.a
    public final com.fasterxml.jackson.databind.deser.a withAdditionalKeyDeserializers(b91 b91Var) {
        return withConfig(this._factoryConfig.withAdditionalKeyDeserializers(b91Var));
    }

    protected abstract com.fasterxml.jackson.databind.deser.a withConfig(DeserializerFactoryConfig deserializerFactoryConfig);

    public final com.fasterxml.jackson.databind.deser.a withDeserializerModifier(mh mhVar) {
        return withConfig(this._factoryConfig.withDeserializerModifier(mhVar));
    }

    @Override // com.fasterxml.jackson.databind.deser.a
    public final com.fasterxml.jackson.databind.deser.a withValueInstantiators(cb3 cb3Var) {
        return withConfig(this._factoryConfig.withValueInstantiators(cb3Var));
    }

    protected void _addExplicitAnyCreator(DeserializationContext deserializationContext, kh khVar, x40 x40Var, w40 w40Var, ConstructorDetector constructorDetector) throws JsonMappingException {
        PropertyName propertyName;
        boolean z;
        int iE;
        if (1 != w40Var.g()) {
            if (!constructorDetector.singleArgCreatorDefaultsToProperties() && (iE = w40Var.e()) >= 0 && (constructorDetector.singleArgCreatorDefaultsToDelegating() || w40Var.h(iE) == null)) {
                _addExplicitDelegatingCreator(deserializationContext, khVar, x40Var, w40Var);
                return;
            } else {
                _addExplicitPropertyCreator(deserializationContext, khVar, x40Var, w40Var);
                return;
            }
        }
        AnnotatedParameter annotatedParameterI = w40Var.i(0);
        JacksonInject.Value valueF = w40Var.f(0);
        int i = a.b[constructorDetector.singleArgMode().ordinal()];
        if (i == 1) {
            propertyName = null;
            z = false;
        } else if (i == 2) {
            PropertyName propertyNameH = w40Var.h(0);
            if (propertyNameH == null) {
                _validateNamedPropertyParameter(deserializationContext, khVar, w40Var, 0, propertyNameH, valueF);
            }
            z = true;
            propertyName = propertyNameH;
        } else if (i != 3) {
            g gVarJ = w40Var.j(0);
            PropertyName propertyNameC = w40Var.c(0);
            z = (propertyNameC == null && valueF == null) ? false : true;
            if (!z && gVarJ != null) {
                propertyNameC = w40Var.h(0);
                z = propertyNameC != null && gVarJ.b();
            }
            propertyName = propertyNameC;
        } else {
            deserializationContext.reportBadTypeDefinition(khVar, "Single-argument constructor (%s) is annotated but no 'mode' defined; `CreatorDetector`configured with `SingleArgConstructor.REQUIRE_MODE`", w40Var.b());
            return;
        }
        if (z) {
            x40Var.l(w40Var.b(), true, new SettableBeanProperty[]{constructCreatorProperty(deserializationContext, khVar, propertyName, 0, annotatedParameterI, valueF)});
            return;
        }
        _handleSingleArgumentCreator(x40Var, w40Var.b(), true, true);
        g gVarJ2 = w40Var.j(0);
        if (gVarJ2 != null) {
            ((l) gVarJ2).p0();
        }
    }
}
