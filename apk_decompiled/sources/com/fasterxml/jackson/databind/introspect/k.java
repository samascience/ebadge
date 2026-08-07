package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.tencent.connect.common.Constants;
import defpackage.ay;
import defpackage.lt1;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class k {
    protected final MapperConfig a;
    protected final AccessorNamingStrategy b;
    protected final boolean c;
    protected final JavaType d;
    protected final a e;
    protected final VisibilityChecker f;
    protected final AnnotationIntrospector g;
    protected final boolean h;
    protected boolean i;
    protected LinkedHashMap j;
    protected LinkedList k;
    protected Map l;
    protected LinkedList m;
    protected LinkedList n;
    protected LinkedList o;
    protected LinkedList p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected LinkedList f230q;
    protected LinkedList r;
    protected HashSet s;
    protected LinkedHashMap t;
    protected final boolean u;
    protected String v;

    protected k(MapperConfig mapperConfig, boolean z, JavaType javaType, a aVar, AccessorNamingStrategy accessorNamingStrategy) {
        this.v = "set";
        this.a = mapperConfig;
        this.c = z;
        this.d = javaType;
        this.e = aVar;
        if (mapperConfig.isAnnotationProcessingEnabled()) {
            this.h = true;
            this.g = mapperConfig.getAnnotationIntrospector();
        } else {
            this.h = false;
            this.g = AnnotationIntrospector.nopInstance();
        }
        this.f = mapperConfig.getDefaultVisibilityChecker(javaType.getRawClass(), aVar);
        this.b = accessorNamingStrategy;
        this.u = mapperConfig.isEnabled(MapperFeature.USE_STD_BEAN_NAMING);
    }

    private static AccessorNamingStrategy a(MapperConfig mapperConfig, a aVar, String str) {
        if (str == null) {
            str = "set";
        }
        return new DefaultAccessorNamingStrategy.Provider().withSetterPrefix(str).forPOJO(mapperConfig, aVar);
    }

    private boolean i(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((l) it.next()).getMetadata().hasIndex()) {
                return true;
            }
        }
        return false;
    }

    private String j(String str) {
        PropertyName propertyName;
        Map map = this.l;
        return (map == null || (propertyName = (PropertyName) map.get(n(str))) == null) ? str : propertyName.getSimpleName();
    }

    private PropertyNamingStrategy m() {
        Object objFindNamingStrategy = this.g.findNamingStrategy(this.e);
        if (objFindNamingStrategy == null) {
            return this.a.getPropertyNamingStrategy();
        }
        if (objFindNamingStrategy instanceof PropertyNamingStrategy) {
            return (PropertyNamingStrategy) objFindNamingStrategy;
        }
        if (!(objFindNamingStrategy instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned PropertyNamingStrategy definition of type " + objFindNamingStrategy.getClass().getName() + "; expected type PropertyNamingStrategy or Class<PropertyNamingStrategy> instead");
        }
        Class cls = (Class) objFindNamingStrategy;
        if (cls == PropertyNamingStrategy.class) {
            return null;
        }
        if (PropertyNamingStrategy.class.isAssignableFrom(cls)) {
            this.a.getHandlerInstantiator();
            return (PropertyNamingStrategy) ay.l(cls, this.a.canOverrideAccessModifiers());
        }
        throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<PropertyNamingStrategy>");
    }

    private PropertyName n(String str) {
        return PropertyName.construct(str, null);
    }

    public AnnotatedMember A() {
        if (!this.i) {
            y();
        }
        LinkedList linkedList = this.m;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            O("Multiple 'any-getter' methods defined (%s vs %s)", this.m.get(0), this.m.get(1));
        }
        return (AnnotatedMember) this.m.getFirst();
    }

    public AnnotatedMember B() {
        if (!this.i) {
            y();
        }
        LinkedList linkedList = this.p;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            O("Multiple 'any-setter' fields defined (%s vs %s)", this.p.get(0), this.p.get(1));
        }
        return (AnnotatedMember) this.p.getFirst();
    }

    public AnnotatedMethod C() {
        if (!this.i) {
            y();
        }
        LinkedList linkedList = this.o;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            O("Multiple 'any-setter' methods defined (%s vs %s)", this.o.get(0), this.o.get(1));
        }
        return (AnnotatedMethod) this.o.getFirst();
    }

    public a D() {
        return this.e;
    }

    public MapperConfig E() {
        return this.a;
    }

    public Set F() {
        return this.s;
    }

    public Map G() {
        if (!this.i) {
            y();
        }
        return this.t;
    }

    public AnnotatedMember H() {
        if (!this.i) {
            y();
        }
        LinkedList linkedList = this.f230q;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1 && !w(this.f230q)) {
            O("Multiple 'as-key' properties defined (%s vs %s)", this.f230q.get(0), this.f230q.get(1));
        }
        return (AnnotatedMember) this.f230q.get(0);
    }

    public AnnotatedMember I() {
        if (!this.i) {
            y();
        }
        LinkedList linkedList = this.r;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1 && !w(this.r)) {
            O("Multiple 'as-value' properties defined (%s vs %s)", this.r.get(0), this.r.get(1));
        }
        return (AnnotatedMember) this.r.get(0);
    }

    public AnnotatedMethod J() {
        AnnotatedMember annotatedMemberI = I();
        if (annotatedMemberI instanceof AnnotatedMethod) {
            return (AnnotatedMethod) annotatedMemberI;
        }
        return null;
    }

    public lt1 K() {
        lt1 lt1VarFindObjectIdInfo = this.g.findObjectIdInfo(this.e);
        return lt1VarFindObjectIdInfo != null ? this.g.findObjectReferenceInfo(this.e, lt1VarFindObjectIdInfo) : lt1VarFindObjectIdInfo;
    }

    public List L() {
        return new ArrayList(M().values());
    }

    protected Map M() {
        if (!this.i) {
            y();
        }
        return this.j;
    }

    public JavaType N() {
        return this.d;
    }

    protected void O(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        throw new IllegalArgumentException("Problem with definition of " + this.e + ": " + str);
    }

    protected void b(Map map, AnnotatedParameter annotatedParameter) {
        JsonCreator.Mode modeFindCreatorAnnotation;
        String strFindImplicitPropertyName = this.g.findImplicitPropertyName(annotatedParameter);
        if (strFindImplicitPropertyName == null) {
            strFindImplicitPropertyName = Constants.STR_EMPTY;
        }
        PropertyName propertyNameFindNameForDeserialization = this.g.findNameForDeserialization(annotatedParameter);
        boolean z = (propertyNameFindNameForDeserialization == null || propertyNameFindNameForDeserialization.isEmpty()) ? false : true;
        if (!z) {
            if (strFindImplicitPropertyName.isEmpty() || (modeFindCreatorAnnotation = this.g.findCreatorAnnotation(this.a, annotatedParameter.getOwner())) == null || modeFindCreatorAnnotation == JsonCreator.Mode.DISABLED) {
                return;
            } else {
                propertyNameFindNameForDeserialization = PropertyName.construct(strFindImplicitPropertyName);
            }
        }
        PropertyName propertyName = propertyNameFindNameForDeserialization;
        String strJ = j(strFindImplicitPropertyName);
        l lVarO = (z && strJ.isEmpty()) ? o(map, propertyName) : p(map, strJ);
        lVarO.U(annotatedParameter, propertyName, z, true, false);
        this.k.add(lVarO);
    }

    protected void c(Map map) {
        if (this.h) {
            Iterator it = this.e.i().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AnnotatedConstructor annotatedConstructor = (AnnotatedConstructor) it.next();
                if (this.k == null) {
                    this.k = new LinkedList();
                }
                int parameterCount = annotatedConstructor.getParameterCount();
                for (int i = 0; i < parameterCount; i++) {
                    b(map, annotatedConstructor.getParameter(i));
                }
            }
            for (AnnotatedMethod annotatedMethod : this.e.k()) {
                if (this.k == null) {
                    this.k = new LinkedList();
                }
                int parameterCount2 = annotatedMethod.getParameterCount();
                for (int i2 = 0; i2 < parameterCount2; i2++) {
                    b(map, annotatedMethod.getParameter(i2));
                }
            }
        }
    }

    protected void d(Map map) {
        PropertyName propertyNameN;
        boolean z;
        boolean z2;
        boolean z3;
        AnnotationIntrospector annotationIntrospector = this.g;
        boolean z4 = (this.c || this.a.isEnabled(MapperFeature.ALLOW_FINAL_FIELDS_AS_MUTATORS)) ? false : true;
        boolean zIsEnabled = this.a.isEnabled(MapperFeature.PROPAGATE_TRANSIENT_MARKER);
        for (AnnotatedField annotatedField : this.e.e()) {
            Boolean bool = Boolean.TRUE;
            if (bool.equals(annotationIntrospector.hasAsKey(this.a, annotatedField))) {
                if (this.f230q == null) {
                    this.f230q = new LinkedList();
                }
                this.f230q.add(annotatedField);
            }
            if (bool.equals(annotationIntrospector.hasAsValue(annotatedField))) {
                if (this.r == null) {
                    this.r = new LinkedList();
                }
                this.r.add(annotatedField);
            } else {
                boolean zEquals = bool.equals(annotationIntrospector.hasAnyGetter(annotatedField));
                boolean zEquals2 = bool.equals(annotationIntrospector.hasAnySetter(annotatedField));
                if (zEquals || zEquals2) {
                    if (zEquals) {
                        if (this.n == null) {
                            this.n = new LinkedList();
                        }
                        this.n.add(annotatedField);
                    }
                    if (zEquals2) {
                        if (this.p == null) {
                            this.p = new LinkedList();
                        }
                        this.p.add(annotatedField);
                    }
                } else {
                    String strFindImplicitPropertyName = annotationIntrospector.findImplicitPropertyName(annotatedField);
                    if (strFindImplicitPropertyName == null) {
                        strFindImplicitPropertyName = annotatedField.getName();
                    }
                    String strModifyFieldName = this.b.modifyFieldName(annotatedField, strFindImplicitPropertyName);
                    if (strModifyFieldName != null) {
                        PropertyName propertyNameN2 = n(strModifyFieldName);
                        PropertyName propertyNameFindRenameByField = annotationIntrospector.findRenameByField(this.a, annotatedField, propertyNameN2);
                        if (propertyNameFindRenameByField != null && !propertyNameFindRenameByField.equals(propertyNameN2)) {
                            if (this.l == null) {
                                this.l = new HashMap();
                            }
                            this.l.put(propertyNameFindRenameByField, propertyNameN2);
                        }
                        PropertyName propertyNameFindNameForSerialization = this.c ? annotationIntrospector.findNameForSerialization(annotatedField) : annotationIntrospector.findNameForDeserialization(annotatedField);
                        boolean z5 = propertyNameFindNameForSerialization != null;
                        if (z5 && propertyNameFindNameForSerialization.isEmpty()) {
                            z = false;
                            propertyNameN = n(strModifyFieldName);
                        } else {
                            propertyNameN = propertyNameFindNameForSerialization;
                            z = z5;
                        }
                        boolean zIsFieldVisible = propertyNameN != null;
                        if (!zIsFieldVisible) {
                            zIsFieldVisible = this.f.isFieldVisible(annotatedField);
                        }
                        boolean zHasIgnoreMarker = annotationIntrospector.hasIgnoreMarker(annotatedField);
                        if (!annotatedField.isTransient() || z5) {
                            z2 = zHasIgnoreMarker;
                            z3 = zIsFieldVisible;
                        } else {
                            z2 = zIsEnabled ? true : zHasIgnoreMarker;
                            z3 = false;
                        }
                        if (!z4 || propertyNameN != null || z2 || !Modifier.isFinal(annotatedField.getModifiers())) {
                            p(map, strModifyFieldName).V(annotatedField, propertyNameN, z, z3, z2);
                        }
                    }
                }
            }
        }
    }

    protected void e(Map map, AnnotatedMethod annotatedMethod, AnnotationIntrospector annotationIntrospector) {
        PropertyName propertyName;
        boolean z;
        boolean z2;
        String strFindImplicitPropertyName;
        boolean zIsGetterVisible;
        Class<?> rawReturnType = annotatedMethod.getRawReturnType();
        if (rawReturnType != Void.TYPE) {
            if (rawReturnType != Void.class || this.a.isEnabled(MapperFeature.ALLOW_VOID_VALUED_PROPERTIES)) {
                Boolean bool = Boolean.TRUE;
                if (bool.equals(annotationIntrospector.hasAnyGetter(annotatedMethod))) {
                    if (this.m == null) {
                        this.m = new LinkedList();
                    }
                    this.m.add(annotatedMethod);
                    return;
                }
                if (bool.equals(annotationIntrospector.hasAsKey(this.a, annotatedMethod))) {
                    if (this.f230q == null) {
                        this.f230q = new LinkedList();
                    }
                    this.f230q.add(annotatedMethod);
                    return;
                }
                if (bool.equals(annotationIntrospector.hasAsValue(annotatedMethod))) {
                    if (this.r == null) {
                        this.r = new LinkedList();
                    }
                    this.r.add(annotatedMethod);
                    return;
                }
                PropertyName propertyNameFindNameForSerialization = annotationIntrospector.findNameForSerialization(annotatedMethod);
                boolean z3 = false;
                boolean z4 = propertyNameFindNameForSerialization != null;
                if (z4) {
                    String strFindImplicitPropertyName2 = annotationIntrospector.findImplicitPropertyName(annotatedMethod);
                    if (strFindImplicitPropertyName2 == null && (strFindImplicitPropertyName2 = this.b.findNameForRegularGetter(annotatedMethod, annotatedMethod.getName())) == null) {
                        strFindImplicitPropertyName2 = this.b.findNameForIsGetter(annotatedMethod, annotatedMethod.getName());
                    }
                    if (strFindImplicitPropertyName2 == null) {
                        strFindImplicitPropertyName2 = annotatedMethod.getName();
                    }
                    if (propertyNameFindNameForSerialization.isEmpty()) {
                        propertyNameFindNameForSerialization = n(strFindImplicitPropertyName2);
                    } else {
                        z3 = z4;
                    }
                    propertyName = propertyNameFindNameForSerialization;
                    z = z3;
                    z2 = true;
                    strFindImplicitPropertyName = strFindImplicitPropertyName2;
                } else {
                    strFindImplicitPropertyName = annotationIntrospector.findImplicitPropertyName(annotatedMethod);
                    if (strFindImplicitPropertyName == null) {
                        strFindImplicitPropertyName = this.b.findNameForRegularGetter(annotatedMethod, annotatedMethod.getName());
                    }
                    if (strFindImplicitPropertyName == null) {
                        strFindImplicitPropertyName = this.b.findNameForIsGetter(annotatedMethod, annotatedMethod.getName());
                        if (strFindImplicitPropertyName == null) {
                            return;
                        } else {
                            zIsGetterVisible = this.f.isIsGetterVisible(annotatedMethod);
                        }
                    } else {
                        zIsGetterVisible = this.f.isGetterVisible(annotatedMethod);
                    }
                    propertyName = propertyNameFindNameForSerialization;
                    z2 = zIsGetterVisible;
                    z = z4;
                }
                p(map, j(strFindImplicitPropertyName)).W(annotatedMethod, propertyName, z, z2, annotationIntrospector.hasIgnoreMarker(annotatedMethod));
            }
        }
    }

    protected void f(Map map) {
        for (AnnotatedMember annotatedMember : this.e.e()) {
            l(this.g.findInjectableValue(annotatedMember), annotatedMember);
        }
        for (AnnotatedMethod annotatedMethod : this.e.n()) {
            if (annotatedMethod.getParameterCount() == 1) {
                l(this.g.findInjectableValue(annotatedMethod), annotatedMethod);
            }
        }
    }

    protected void g(Map map) {
        for (AnnotatedMethod annotatedMethod : this.e.n()) {
            int parameterCount = annotatedMethod.getParameterCount();
            if (parameterCount == 0) {
                e(map, annotatedMethod, this.g);
            } else if (parameterCount == 1) {
                h(map, annotatedMethod, this.g);
            } else if (parameterCount == 2 && Boolean.TRUE.equals(this.g.hasAnySetter(annotatedMethod))) {
                if (this.o == null) {
                    this.o = new LinkedList();
                }
                this.o.add(annotatedMethod);
            }
        }
    }

    protected void h(Map map, AnnotatedMethod annotatedMethod, AnnotationIntrospector annotationIntrospector) {
        PropertyName propertyName;
        boolean z;
        boolean zIsSetterVisible;
        String strFindImplicitPropertyName;
        PropertyName propertyNameFindNameForDeserialization = annotationIntrospector.findNameForDeserialization(annotatedMethod);
        boolean z2 = false;
        boolean z3 = propertyNameFindNameForDeserialization != null;
        if (z3) {
            String strFindImplicitPropertyName2 = annotationIntrospector.findImplicitPropertyName(annotatedMethod);
            if (strFindImplicitPropertyName2 == null) {
                strFindImplicitPropertyName2 = this.b.findNameForMutator(annotatedMethod, annotatedMethod.getName());
            }
            if (strFindImplicitPropertyName2 == null) {
                strFindImplicitPropertyName2 = annotatedMethod.getName();
            }
            if (propertyNameFindNameForDeserialization.isEmpty()) {
                propertyNameFindNameForDeserialization = n(strFindImplicitPropertyName2);
            } else {
                z2 = z3;
            }
            propertyName = propertyNameFindNameForDeserialization;
            z = z2;
            zIsSetterVisible = true;
            strFindImplicitPropertyName = strFindImplicitPropertyName2;
        } else {
            strFindImplicitPropertyName = annotationIntrospector.findImplicitPropertyName(annotatedMethod);
            if (strFindImplicitPropertyName == null) {
                strFindImplicitPropertyName = this.b.findNameForMutator(annotatedMethod, annotatedMethod.getName());
            }
            if (strFindImplicitPropertyName == null) {
                return;
            }
            propertyName = propertyNameFindNameForDeserialization;
            zIsSetterVisible = this.f.isSetterVisible(annotatedMethod);
            z = z3;
        }
        p(map, j(strFindImplicitPropertyName)).X(annotatedMethod, propertyName, z, zIsSetterVisible, annotationIntrospector.hasIgnoreMarker(annotatedMethod));
    }

    protected void k(String str) {
        if (this.c || str == null) {
            return;
        }
        if (this.s == null) {
            this.s = new HashSet();
        }
        this.s.add(str);
    }

    protected void l(JacksonInject.Value value, AnnotatedMember annotatedMember) {
        if (value == null) {
            return;
        }
        Object id = value.getId();
        if (this.t == null) {
            this.t = new LinkedHashMap();
        }
        AnnotatedMember annotatedMember2 = (AnnotatedMember) this.t.put(id, annotatedMember);
        if (annotatedMember2 == null || annotatedMember2.getClass() != annotatedMember.getClass()) {
            return;
        }
        throw new IllegalArgumentException("Duplicate injectable value with id '" + id + "' (of type " + id.getClass().getName() + ")");
    }

    protected l o(Map map, PropertyName propertyName) {
        String simpleName = propertyName.getSimpleName();
        l lVar = (l) map.get(simpleName);
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this.a, this.g, this.c, propertyName);
        map.put(simpleName, lVar2);
        return lVar2;
    }

    protected l p(Map map, String str) {
        l lVar = (l) map.get(str);
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this.a, this.g, this.c, PropertyName.construct(str));
        map.put(str, lVar2);
        return lVar2;
    }

    protected void q(Map map) {
        boolean zIsEnabled = this.a.isEnabled(MapperFeature.INFER_PROPERTY_MUTATORS);
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((l) it.next()).r0(zIsEnabled, this.c ? null : this);
        }
    }

    protected void r(Map map) {
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            if (!lVar.a0()) {
                it.remove();
            } else if (lVar.Z()) {
                if (lVar.Y()) {
                    lVar.q0();
                    if (!lVar.a()) {
                        k(lVar.getName());
                    }
                } else {
                    it.remove();
                    k(lVar.getName());
                }
            }
        }
    }

    protected void s(Map map) {
        HashSet hashSet;
        Iterator it = map.entrySet().iterator();
        LinkedList<l> linkedList = null;
        while (it.hasNext()) {
            l lVar = (l) ((Map.Entry) it.next()).getValue();
            Set setE0 = lVar.e0();
            if (!setE0.isEmpty()) {
                it.remove();
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                if (setE0.size() == 1) {
                    linkedList.add(lVar.t0((PropertyName) setE0.iterator().next()));
                } else {
                    linkedList.addAll(lVar.c0(setE0));
                }
            }
        }
        if (linkedList != null) {
            for (l lVar2 : linkedList) {
                String name = lVar2.getName();
                l lVar3 = (l) map.get(name);
                if (lVar3 == null) {
                    map.put(name, lVar2);
                } else {
                    lVar3.T(lVar2);
                }
                if (v(lVar2, this.k) && (hashSet = this.s) != null) {
                    hashSet.remove(name);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00af  */
    protected void t(Map map, PropertyNamingStrategy propertyNamingStrategy) {
        String strNameForGetterMethod;
        l[] lVarArr = (l[]) map.values().toArray(new l[map.size()]);
        map.clear();
        for (l lVarU0 : lVarArr) {
            PropertyName fullName = lVarU0.getFullName();
            if (lVarU0.x() && !this.a.isEnabled(MapperFeature.ALLOW_EXPLICIT_PROPERTY_RENAMING)) {
                strNameForGetterMethod = null;
            } else if (this.c) {
                if (lVarU0.m0()) {
                    strNameForGetterMethod = propertyNamingStrategy.nameForGetterMethod(this.a, lVarU0.l(), fullName.getSimpleName());
                } else if (lVarU0.t()) {
                    strNameForGetterMethod = propertyNamingStrategy.nameForField(this.a, lVarU0.k(), fullName.getSimpleName());
                } else {
                    strNameForGetterMethod = null;
                }
            } else if (lVarU0.v()) {
                strNameForGetterMethod = propertyNamingStrategy.nameForSetterMethod(this.a, lVarU0.l0(), fullName.getSimpleName());
            } else if (lVarU0.s()) {
                strNameForGetterMethod = propertyNamingStrategy.nameForConstructorParameter(this.a, lVarU0.i(), fullName.getSimpleName());
            } else if (lVarU0.t()) {
                strNameForGetterMethod = propertyNamingStrategy.nameForField(this.a, lVarU0.h0(), fullName.getSimpleName());
            } else if (lVarU0.m0()) {
                strNameForGetterMethod = propertyNamingStrategy.nameForGetterMethod(this.a, lVarU0.i0(), fullName.getSimpleName());
            } else {
                strNameForGetterMethod = null;
            }
            if (strNameForGetterMethod == null || fullName.hasSimpleName(strNameForGetterMethod)) {
                strNameForGetterMethod = fullName.getSimpleName();
            } else {
                lVarU0 = lVarU0.u0(strNameForGetterMethod);
            }
            l lVar = (l) map.get(strNameForGetterMethod);
            if (lVar == null) {
                map.put(strNameForGetterMethod, lVarU0);
            } else {
                lVar.T(lVarU0);
            }
            v(lVarU0, this.k);
        }
    }

    protected void u(Map map) {
        PropertyName propertyNameFindWrapperName;
        Iterator it = map.entrySet().iterator();
        LinkedList<l> linkedList = null;
        while (it.hasNext()) {
            l lVar = (l) ((Map.Entry) it.next()).getValue();
            AnnotatedMember annotatedMemberO = lVar.o();
            if (annotatedMemberO != null && (propertyNameFindWrapperName = this.g.findWrapperName(annotatedMemberO)) != null && propertyNameFindWrapperName.hasSimpleName() && !propertyNameFindWrapperName.equals(lVar.getFullName())) {
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                linkedList.add(lVar.t0(propertyNameFindWrapperName));
                it.remove();
            }
        }
        if (linkedList != null) {
            for (l lVar2 : linkedList) {
                String name = lVar2.getName();
                l lVar3 = (l) map.get(name);
                if (lVar3 == null) {
                    map.put(name, lVar2);
                } else {
                    lVar3.T(lVar2);
                }
            }
        }
    }

    protected boolean v(l lVar, List list) {
        if (list != null) {
            String strJ0 = lVar.j0();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((l) list.get(i)).j0().equals(strJ0)) {
                    list.set(i, lVar);
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean w(List list) {
        do {
            AnnotatedMember annotatedMember = (AnnotatedMember) list.get(0);
            AnnotatedMember annotatedMember2 = (AnnotatedMember) list.get(1);
            if (annotatedMember instanceof AnnotatedField) {
                if (!(annotatedMember2 instanceof AnnotatedMethod)) {
                    return false;
                }
                list.remove(0);
            } else {
                if (!(annotatedMember instanceof AnnotatedMethod) || !(annotatedMember2 instanceof AnnotatedField)) {
                    return false;
                }
                list.remove(1);
            }
        } while (list.size() > 1);
        return true;
    }

    protected void x(Map map) {
        Collection<l> collectionValues;
        AnnotationIntrospector annotationIntrospector = this.g;
        Boolean boolFindSerializationSortAlphabetically = annotationIntrospector.findSerializationSortAlphabetically(this.e);
        boolean zShouldSortPropertiesAlphabetically = boolFindSerializationSortAlphabetically == null ? this.a.shouldSortPropertiesAlphabetically() : boolFindSerializationSortAlphabetically.booleanValue();
        boolean zI = i(map.values());
        String[] strArrFindSerializationPropertyOrder = annotationIntrospector.findSerializationPropertyOrder(this.e);
        if (zShouldSortPropertiesAlphabetically || zI || this.k != null || strArrFindSerializationPropertyOrder != null) {
            int size = map.size();
            Map treeMap = zShouldSortPropertiesAlphabetically ? new TreeMap() : new LinkedHashMap(size + size);
            for (l lVar : map.values()) {
                treeMap.put(lVar.getName(), lVar);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(size + size);
            if (strArrFindSerializationPropertyOrder != null) {
                for (String name : strArrFindSerializationPropertyOrder) {
                    l lVar2 = (l) treeMap.remove(name);
                    if (lVar2 == null) {
                        for (l lVar3 : map.values()) {
                            if (name.equals(lVar3.j0())) {
                                name = lVar3.getName();
                                lVar2 = lVar3;
                                break;
                            }
                        }
                    }
                    if (lVar2 != null) {
                        linkedHashMap.put(name, lVar2);
                    }
                }
            }
            if (zI) {
                TreeMap treeMap2 = new TreeMap();
                Iterator it = treeMap.entrySet().iterator();
                while (it.hasNext()) {
                    l lVar4 = (l) ((Map.Entry) it.next()).getValue();
                    Integer index = lVar4.getMetadata().getIndex();
                    if (index != null) {
                        treeMap2.put(index, lVar4);
                        it.remove();
                    }
                }
                for (l lVar5 : treeMap2.values()) {
                    linkedHashMap.put(lVar5.getName(), lVar5);
                }
            }
            if (this.k != null && (!zShouldSortPropertiesAlphabetically || this.a.isEnabled(MapperFeature.SORT_CREATOR_PROPERTIES_FIRST))) {
                if (zShouldSortPropertiesAlphabetically) {
                    TreeMap treeMap3 = new TreeMap();
                    for (l lVar6 : this.k) {
                        treeMap3.put(lVar6.getName(), lVar6);
                    }
                    collectionValues = treeMap3.values();
                } else {
                    collectionValues = this.k;
                }
                for (l lVar7 : collectionValues) {
                    String name2 = lVar7.getName();
                    if (treeMap.containsKey(name2)) {
                        linkedHashMap.put(name2, lVar7);
                    }
                }
            }
            linkedHashMap.putAll(treeMap);
            map.clear();
            map.putAll(linkedHashMap);
        }
    }

    protected void y() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        d(linkedHashMap);
        g(linkedHashMap);
        if (!this.e.m()) {
            c(linkedHashMap);
        }
        r(linkedHashMap);
        q(linkedHashMap);
        s(linkedHashMap);
        f(linkedHashMap);
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            ((l) it.next()).o0(this.c);
        }
        PropertyNamingStrategy propertyNamingStrategyM = m();
        if (propertyNamingStrategyM != null) {
            t(linkedHashMap, propertyNamingStrategyM);
        }
        Iterator it2 = linkedHashMap.values().iterator();
        while (it2.hasNext()) {
            ((l) it2.next()).s0();
        }
        if (this.a.isEnabled(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME)) {
            u(linkedHashMap);
        }
        x(linkedHashMap);
        this.j = linkedHashMap;
        this.i = true;
    }

    public AnnotatedMember z() {
        if (!this.i) {
            y();
        }
        LinkedList linkedList = this.n;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() > 1) {
            O("Multiple 'any-getter' fields defined (%s vs %s)", this.n.get(0), this.n.get(1));
        }
        return (AnnotatedMember) this.n.getFirst();
    }

    protected k(MapperConfig mapperConfig, boolean z, JavaType javaType, a aVar, String str) {
        this(mapperConfig, z, javaType, aVar, a(mapperConfig, aVar, str));
        this.v = str;
    }
}
