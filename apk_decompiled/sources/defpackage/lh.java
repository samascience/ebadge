package defpackage;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.AbstractDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializer;
import com.fasterxml.jackson.databind.deser.BuilderBasedDeserializer;
import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdValueProperty;
import com.fasterxml.jackson.databind.deser.impl.ValueInjector;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.IgnorePropertiesUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class lh {
    protected final DeserializationConfig a;
    protected final DeserializationContext b;
    protected final kh c;
    protected final Map d = new LinkedHashMap();
    protected List e;
    protected HashMap f;
    protected HashSet g;
    protected HashSet h;
    protected ValueInstantiator i;
    protected ObjectIdReader j;
    protected SettableAnyProperty k;
    protected boolean l;
    protected AnnotatedMethod m;
    protected q61.a n;

    public lh(kh khVar, DeserializationContext deserializationContext) {
        this.c = khVar;
        this.b = deserializationContext;
        this.a = deserializationContext.getConfig();
    }

    public void A(AnnotatedMethod annotatedMethod, q61.a aVar) {
        this.m = annotatedMethod;
        this.n = aVar;
    }

    public void B(ValueInstantiator valueInstantiator) {
        this.i = valueInstantiator;
    }

    protected Map a(Collection collection) {
        AnnotationIntrospector annotationIntrospector = this.a.getAnnotationIntrospector();
        HashMap map = null;
        if (annotationIntrospector != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                SettableBeanProperty settableBeanProperty = (SettableBeanProperty) it.next();
                List<PropertyName> listFindPropertyAliases = annotationIntrospector.findPropertyAliases(settableBeanProperty.getMember());
                if (listFindPropertyAliases != null && !listFindPropertyAliases.isEmpty()) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    map.put(settableBeanProperty.getName(), listFindPropertyAliases);
                }
            }
        }
        return map == null ? Collections.emptyMap() : map;
    }

    protected boolean b() {
        Boolean feature = this.c.g(null).getFeature(JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        return feature == null ? this.a.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES) : feature.booleanValue();
    }

    protected void c(Collection collection) throws DatabindException {
        if (this.a.canOverrideAccessModifiers()) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                try {
                    ((SettableBeanProperty) it.next()).fixAccess(this.a);
                } catch (IllegalArgumentException e) {
                    d(e);
                }
            }
        }
        SettableAnyProperty settableAnyProperty = this.k;
        if (settableAnyProperty != null) {
            try {
                settableAnyProperty.fixAccess(this.a);
            } catch (IllegalArgumentException e2) {
                d(e2);
            }
        }
        AnnotatedMethod annotatedMethod = this.m;
        if (annotatedMethod != null) {
            try {
                annotatedMethod.fixAccess(this.a.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            } catch (IllegalArgumentException e3) {
                d(e3);
            }
        }
    }

    protected void d(IllegalArgumentException illegalArgumentException) throws DatabindException {
        try {
            this.b.reportBadTypeDefinition(this.c, illegalArgumentException.getMessage(), new Object[0]);
        } catch (DatabindException e) {
            if (e.getCause() == null) {
                e.initCause(illegalArgumentException);
            }
            throw e;
        }
    }

    public void e(String str, SettableBeanProperty settableBeanProperty) {
        if (this.f == null) {
            this.f = new HashMap(4);
        }
        if (this.a.canOverrideAccessModifiers()) {
            try {
                settableBeanProperty.fixAccess(this.a);
            } catch (IllegalArgumentException e) {
                d(e);
            }
        }
        this.f.put(str, settableBeanProperty);
    }

    public void f(SettableBeanProperty settableBeanProperty) {
        k(settableBeanProperty);
    }

    public void g(String str) {
        if (this.g == null) {
            this.g = new HashSet();
        }
        this.g.add(str);
    }

    public void h(String str) {
        if (this.h == null) {
            this.h = new HashSet();
        }
        this.h.add(str);
    }

    public void i(PropertyName propertyName, JavaType javaType, l7 l7Var, AnnotatedMember annotatedMember, Object obj) {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        if (this.a.canOverrideAccessModifiers()) {
            try {
                annotatedMember.fixAccess(this.a.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            } catch (IllegalArgumentException e) {
                d(e);
            }
        }
        this.e.add(new ValueInjector(propertyName, javaType, annotatedMember, obj));
    }

    public void j(SettableBeanProperty settableBeanProperty, boolean z) {
        this.d.put(settableBeanProperty.getName(), settableBeanProperty);
    }

    public void k(SettableBeanProperty settableBeanProperty) {
        SettableBeanProperty settableBeanProperty2 = (SettableBeanProperty) this.d.put(settableBeanProperty.getName(), settableBeanProperty);
        if (settableBeanProperty2 == null || settableBeanProperty2 == settableBeanProperty) {
            return;
        }
        throw new IllegalArgumentException("Duplicate property '" + settableBeanProperty.getName() + "' for " + this.c.A());
    }

    public s51 l() {
        Collection collectionValues = this.d.values();
        c(collectionValues);
        BeanPropertyMap beanPropertyMapConstruct = BeanPropertyMap.construct(this.a, collectionValues, a(collectionValues), b());
        beanPropertyMapConstruct.assignIndexes();
        boolean zIsEnabled = this.a.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION);
        boolean z = !zIsEnabled;
        if (zIsEnabled) {
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                if (((SettableBeanProperty) it.next()).hasViews()) {
                    z = true;
                    break;
                }
            }
        }
        boolean z2 = z;
        if (this.j != null) {
            beanPropertyMapConstruct = beanPropertyMapConstruct.withProperty(new ObjectIdValueProperty(this.j, PropertyMetadata.STD_REQUIRED));
        }
        return new BeanDeserializer(this, this.c, beanPropertyMapConstruct, this.f, this.g, this.l, this.h, z2);
    }

    public AbstractDeserializer m() {
        return new AbstractDeserializer(this, this.c, this.f, this.d);
    }

    public s51 n(JavaType javaType, String str) {
        AnnotatedMethod annotatedMethod = this.m;
        if (annotatedMethod != null) {
            Class<?> rawReturnType = annotatedMethod.getRawReturnType();
            Class<?> rawClass = javaType.getRawClass();
            if (rawReturnType != rawClass && !rawReturnType.isAssignableFrom(rawClass) && !rawClass.isAssignableFrom(rawReturnType)) {
                this.b.reportBadDefinition(this.c.A(), String.format("Build method `%s` has wrong return type (%s), not compatible with POJO type (%s)", this.m.getFullName(), ay.y(rawReturnType), ay.G(javaType)));
            }
        } else if (!str.isEmpty()) {
            this.b.reportBadDefinition(this.c.A(), String.format("Builder class %s does not have build method (name: '%s')", ay.G(this.c.A()), str));
        }
        Collection collectionValues = this.d.values();
        c(collectionValues);
        BeanPropertyMap beanPropertyMapConstruct = BeanPropertyMap.construct(this.a, collectionValues, a(collectionValues), b());
        beanPropertyMapConstruct.assignIndexes();
        boolean zIsEnabled = this.a.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION);
        boolean z = !zIsEnabled;
        if (zIsEnabled) {
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                if (((SettableBeanProperty) it.next()).hasViews()) {
                    z = true;
                    break;
                }
            }
        }
        if (this.j != null) {
            beanPropertyMapConstruct = beanPropertyMapConstruct.withProperty(new ObjectIdValueProperty(this.j, PropertyMetadata.STD_REQUIRED));
        }
        return o(javaType, beanPropertyMapConstruct, z);
    }

    protected s51 o(JavaType javaType, BeanPropertyMap beanPropertyMap, boolean z) {
        return new BuilderBasedDeserializer(this, this.c, javaType, beanPropertyMap, this.f, this.g, this.l, this.h, z);
    }

    public SettableBeanProperty p(PropertyName propertyName) {
        return (SettableBeanProperty) this.d.get(propertyName.getSimpleName());
    }

    public SettableAnyProperty q() {
        return this.k;
    }

    public AnnotatedMethod r() {
        return this.m;
    }

    public List s() {
        return this.e;
    }

    public ObjectIdReader t() {
        return this.j;
    }

    public Iterator u() {
        return this.d.values().iterator();
    }

    public ValueInstantiator v() {
        return this.i;
    }

    public boolean w(String str) {
        return IgnorePropertiesUtil.c(str, this.g, this.h);
    }

    public void x(SettableAnyProperty settableAnyProperty) {
        if (this.k != null && settableAnyProperty != null) {
            throw new IllegalStateException("_anySetter already set to non-null");
        }
        this.k = settableAnyProperty;
    }

    public void y(boolean z) {
        this.l = z;
    }

    public void z(ObjectIdReader objectIdReader) {
        this.j = objectIdReader;
    }
}
