package defpackage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.a;
import com.fasterxml.jackson.databind.introspect.g;
import com.fasterxml.jackson.databind.introspect.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ah extends kh {
    private static final Class[] j = new Class[0];
    protected final k b;
    protected final MapperConfig c;
    protected final AnnotationIntrospector d;
    protected final a e;
    protected Class[] f;
    protected boolean g;
    protected List h;
    protected lt1 i;

    protected ah(k kVar, JavaType javaType, a aVar) {
        super(javaType);
        this.b = kVar;
        MapperConfig mapperConfigE = kVar.E();
        this.c = mapperConfigE;
        if (mapperConfigE == null) {
            this.d = null;
        } else {
            this.d = mapperConfigE.getAnnotationIntrospector();
        }
        this.e = aVar;
    }

    public static ah J(k kVar) {
        return new ah(kVar);
    }

    public static ah K(MapperConfig mapperConfig, JavaType javaType, a aVar) {
        return new ah(mapperConfig, javaType, aVar, Collections.emptyList());
    }

    public static ah L(k kVar) {
        return new ah(kVar);
    }

    @Override // defpackage.kh
    public boolean B() {
        return this.e.l();
    }

    @Override // defpackage.kh
    public Object C(boolean z) {
        AnnotatedConstructor annotatedConstructorJ = this.e.j();
        if (annotatedConstructorJ == null) {
            return null;
        }
        if (z) {
            annotatedConstructorJ.fixAccess(this.c.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        try {
            return annotatedConstructorJ.call();
        } catch (Exception e) {
            e = e;
            while (e.getCause() != null) {
                e = e.getCause();
            }
            ay.h0(e);
            ay.j0(e);
            throw new IllegalArgumentException("Failed to instantiate bean of type " + this.e.getAnnotated().getName() + ": (" + e.getClass().getName() + ") " + ay.o(e), e);
        }
    }

    protected f40 E(Object obj) {
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
            this.c.getHandlerInstantiator();
            return (f40) ay.l(cls, this.c.canOverrideAccessModifiers());
        }
        throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<Converter>");
    }

    protected List F() {
        if (this.h == null) {
            this.h = this.b.L();
        }
        return this.h;
    }

    public boolean G(g gVar) {
        if (M(gVar.getFullName())) {
            return false;
        }
        F().add(gVar);
        return true;
    }

    protected e7 H(AnnotatedMethod annotatedMethod) {
        Class<?> rawParameterType;
        if (!r().isAssignableFrom(annotatedMethod.getRawReturnType())) {
            return null;
        }
        JsonCreator.Mode modeFindCreatorAnnotation = this.d.findCreatorAnnotation(this.c, annotatedMethod);
        if (modeFindCreatorAnnotation != null) {
            if (modeFindCreatorAnnotation == JsonCreator.Mode.DISABLED) {
                return null;
            }
            return e7.a(annotatedMethod, modeFindCreatorAnnotation);
        }
        String name = annotatedMethod.getName();
        if ("valueOf".equals(name) && annotatedMethod.getParameterCount() == 1) {
            return e7.a(annotatedMethod, modeFindCreatorAnnotation);
        }
        if ("fromString".equals(name) && annotatedMethod.getParameterCount() == 1 && ((rawParameterType = annotatedMethod.getRawParameterType(0)) == String.class || CharSequence.class.isAssignableFrom(rawParameterType))) {
            return e7.a(annotatedMethod, modeFindCreatorAnnotation);
        }
        return null;
    }

    public g I(PropertyName propertyName) {
        for (g gVar : F()) {
            if (gVar.u(propertyName)) {
                return gVar;
            }
        }
        return null;
    }

    public boolean M(PropertyName propertyName) {
        return I(propertyName) != null;
    }

    protected boolean N(AnnotatedMethod annotatedMethod) {
        Class<?> rawParameterType;
        if (!r().isAssignableFrom(annotatedMethod.getRawReturnType())) {
            return false;
        }
        JsonCreator.Mode modeFindCreatorAnnotation = this.d.findCreatorAnnotation(this.c, annotatedMethod);
        if (modeFindCreatorAnnotation != null && modeFindCreatorAnnotation != JsonCreator.Mode.DISABLED) {
            return true;
        }
        String name = annotatedMethod.getName();
        if ("valueOf".equals(name) && annotatedMethod.getParameterCount() == 1) {
            return true;
        }
        return "fromString".equals(name) && annotatedMethod.getParameterCount() == 1 && ((rawParameterType = annotatedMethod.getRawParameterType(0)) == String.class || CharSequence.class.isAssignableFrom(rawParameterType));
    }

    public boolean O(String str) {
        Iterator it = F().iterator();
        while (it.hasNext()) {
            if (((g) it.next()).getName().equals(str)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.kh
    public AnnotatedMember a() {
        k kVar = this.b;
        if (kVar == null) {
            return null;
        }
        AnnotatedMember annotatedMemberA = kVar.A();
        if (annotatedMemberA != null) {
            if (Map.class.isAssignableFrom(annotatedMemberA.getRawType())) {
                return annotatedMemberA;
            }
            throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on method %s(): return type is not instance of java.util.Map", annotatedMemberA.getName()));
        }
        AnnotatedMember annotatedMemberZ = this.b.z();
        if (annotatedMemberZ == null) {
            return null;
        }
        if (Map.class.isAssignableFrom(annotatedMemberZ.getRawType())) {
            return annotatedMemberZ;
        }
        throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on field '%s': type is not instance of java.util.Map", annotatedMemberZ.getName()));
    }

    @Override // defpackage.kh
    public AnnotatedMember b() {
        k kVar = this.b;
        if (kVar == null) {
            return null;
        }
        AnnotatedMethod annotatedMethodC = kVar.C();
        if (annotatedMethodC != null) {
            Class<?> rawParameterType = annotatedMethodC.getRawParameterType(0);
            if (rawParameterType == String.class || rawParameterType == Object.class) {
                return annotatedMethodC;
            }
            throw new IllegalArgumentException(String.format("Invalid 'any-setter' annotation on method '%s()': first argument not of type String or Object, but %s", annotatedMethodC.getName(), rawParameterType.getName()));
        }
        AnnotatedMember annotatedMemberB = this.b.B();
        if (annotatedMemberB == null) {
            return null;
        }
        Class<?> rawType = annotatedMemberB.getRawType();
        if (Map.class.isAssignableFrom(rawType) || JsonNode.class.isAssignableFrom(rawType)) {
            return annotatedMemberB;
        }
        throw new IllegalArgumentException(String.format("Invalid 'any-setter' annotation on field '%s': type is not instance of `java.util.Map` or `JsonNode`", annotatedMemberB.getName()));
    }

    @Override // defpackage.kh
    public List c() {
        ArrayList arrayList = null;
        HashSet hashSet = null;
        for (g gVar : F()) {
            AnnotationIntrospector.ReferenceProperty referencePropertyF = gVar.f();
            if (referencePropertyF != null && referencePropertyF.c()) {
                String strB = referencePropertyF.b();
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    hashSet = new HashSet();
                    hashSet.add(strB);
                } else if (!hashSet.add(strB)) {
                    throw new IllegalArgumentException("Multiple back-reference properties with name " + ay.V(strB));
                }
                arrayList.add(gVar);
            }
        }
        return arrayList;
    }

    @Override // defpackage.kh
    public AnnotatedConstructor d() {
        return this.e.j();
    }

    @Override // defpackage.kh
    public Class[] e() {
        if (!this.g) {
            this.g = true;
            AnnotationIntrospector annotationIntrospector = this.d;
            Class<?>[] clsArrFindViews = annotationIntrospector == null ? null : annotationIntrospector.findViews(this.e);
            if (clsArrFindViews == null && !this.c.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION)) {
                clsArrFindViews = j;
            }
            this.f = clsArrFindViews;
        }
        return this.f;
    }

    @Override // defpackage.kh
    public f40 f() {
        AnnotationIntrospector annotationIntrospector = this.d;
        if (annotationIntrospector == null) {
            return null;
        }
        return E(annotationIntrospector.findDeserializationConverter(this.e));
    }

    @Override // defpackage.kh
    public JsonFormat.Value g(JsonFormat.Value value) {
        JsonFormat.Value valueFindFormat;
        AnnotationIntrospector annotationIntrospector = this.d;
        if (annotationIntrospector != null && (valueFindFormat = annotationIntrospector.findFormat(this.e)) != null) {
            value = value == null ? valueFindFormat : value.withOverrides(valueFindFormat);
        }
        JsonFormat.Value defaultPropertyFormat = this.c.getDefaultPropertyFormat(this.e.getRawType());
        if (defaultPropertyFormat != null) {
            return value == null ? defaultPropertyFormat : value.withOverrides(defaultPropertyFormat);
        }
        return value;
    }

    @Override // defpackage.kh
    public Map h() {
        k kVar = this.b;
        return kVar != null ? kVar.G() : Collections.emptyMap();
    }

    @Override // defpackage.kh
    public AnnotatedMember i() {
        k kVar = this.b;
        if (kVar == null) {
            return null;
        }
        return kVar.H();
    }

    @Override // defpackage.kh
    public AnnotatedMember j() {
        k kVar = this.b;
        if (kVar == null) {
            return null;
        }
        return kVar.I();
    }

    @Override // defpackage.kh
    public AnnotatedMethod k() {
        k kVar = this.b;
        if (kVar == null) {
            return null;
        }
        return kVar.J();
    }

    @Override // defpackage.kh
    public AnnotatedMethod l(String str, Class[] clsArr) {
        return this.e.f(str, clsArr);
    }

    @Override // defpackage.kh
    public Class m() {
        AnnotationIntrospector annotationIntrospector = this.d;
        if (annotationIntrospector == null) {
            return null;
        }
        return annotationIntrospector.findPOJOBuilder(this.e);
    }

    @Override // defpackage.kh
    public q61.a n() {
        AnnotationIntrospector annotationIntrospector = this.d;
        if (annotationIntrospector == null) {
            return null;
        }
        return annotationIntrospector.findPOJOBuilderConfig(this.e);
    }

    @Override // defpackage.kh
    public List o() {
        return F();
    }

    @Override // defpackage.kh
    public JsonInclude.Value p(JsonInclude.Value value) {
        JsonInclude.Value valueFindPropertyInclusion;
        AnnotationIntrospector annotationIntrospector = this.d;
        if (annotationIntrospector == null || (valueFindPropertyInclusion = annotationIntrospector.findPropertyInclusion(this.e)) == null) {
            return value;
        }
        return value == null ? valueFindPropertyInclusion : value.withOverrides(valueFindPropertyInclusion);
    }

    @Override // defpackage.kh
    public f40 q() {
        AnnotationIntrospector annotationIntrospector = this.d;
        if (annotationIntrospector == null) {
            return null;
        }
        return E(annotationIntrospector.findSerializationConverter(this.e));
    }

    @Override // defpackage.kh
    public l7 s() {
        return this.e.h();
    }

    @Override // defpackage.kh
    public a t() {
        return this.e;
    }

    @Override // defpackage.kh
    public List u() {
        return this.e.i();
    }

    @Override // defpackage.kh
    public List v() {
        List<AnnotatedConstructor> listI = this.e.i();
        if (listI.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (AnnotatedConstructor annotatedConstructor : listI) {
            JsonCreator.Mode modeFindCreatorAnnotation = this.d.findCreatorAnnotation(this.c, annotatedConstructor);
            if (modeFindCreatorAnnotation != JsonCreator.Mode.DISABLED) {
                arrayList.add(e7.a(annotatedConstructor, modeFindCreatorAnnotation));
            }
        }
        return arrayList;
    }

    @Override // defpackage.kh
    public List w() {
        List<AnnotatedMethod> listK = this.e.k();
        if (listK.isEmpty()) {
            return listK;
        }
        ArrayList arrayList = null;
        for (AnnotatedMethod annotatedMethod : listK) {
            if (N(annotatedMethod)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(annotatedMethod);
            }
        }
        return arrayList == null ? Collections.emptyList() : arrayList;
    }

    @Override // defpackage.kh
    public List x() {
        List listK = this.e.k();
        if (listK.isEmpty()) {
            return Collections.emptyList();
        }
        Iterator it = listK.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            e7 e7VarH = H((AnnotatedMethod) it.next());
            if (e7VarH != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(e7VarH);
            }
        }
        return arrayList == null ? Collections.emptyList() : arrayList;
    }

    @Override // defpackage.kh
    public Set y() {
        k kVar = this.b;
        Set setF = kVar == null ? null : kVar.F();
        return setF == null ? Collections.emptySet() : setF;
    }

    @Override // defpackage.kh
    public lt1 z() {
        return this.i;
    }

    protected ah(MapperConfig mapperConfig, JavaType javaType, a aVar, List list) {
        super(javaType);
        this.b = null;
        this.c = mapperConfig;
        if (mapperConfig == null) {
            this.d = null;
        } else {
            this.d = mapperConfig.getAnnotationIntrospector();
        }
        this.e = aVar;
        this.h = list;
    }

    protected ah(k kVar) {
        this(kVar, kVar.N(), kVar.D());
        this.i = kVar.K();
    }
}
