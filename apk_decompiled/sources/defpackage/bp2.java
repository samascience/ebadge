package defpackage;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.g;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class bp2 extends g {
    protected final AnnotationIntrospector b;
    protected final AnnotatedMember c;
    protected final PropertyMetadata d;
    protected final PropertyName e;
    protected final JsonInclude.Value f;

    protected bp2(AnnotationIntrospector annotationIntrospector, AnnotatedMember annotatedMember, PropertyName propertyName, PropertyMetadata propertyMetadata, JsonInclude.Value value) {
        this.b = annotationIntrospector;
        this.c = annotatedMember;
        this.e = propertyName;
        this.d = propertyMetadata == null ? PropertyMetadata.STD_OPTIONAL : propertyMetadata;
        this.f = value;
    }

    public static bp2 A(MapperConfig mapperConfig, AnnotatedMember annotatedMember, PropertyName propertyName, PropertyMetadata propertyMetadata, JsonInclude.Include include) {
        return new bp2(mapperConfig.getAnnotationIntrospector(), annotatedMember, propertyName, propertyMetadata, (include == null || include == JsonInclude.Include.USE_DEFAULTS) ? g.a : JsonInclude.Value.construct(include, null));
    }

    public static bp2 B(MapperConfig mapperConfig, AnnotatedMember annotatedMember, PropertyName propertyName, PropertyMetadata propertyMetadata, JsonInclude.Value value) {
        return new bp2(mapperConfig.getAnnotationIntrospector(), annotatedMember, propertyName, propertyMetadata, value);
    }

    public static bp2 z(MapperConfig mapperConfig, AnnotatedMember annotatedMember, PropertyName propertyName) {
        return B(mapperConfig, annotatedMember, propertyName, null, g.a);
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public JsonInclude.Value c() {
        return this.f;
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public PropertyName getFullName() {
        return this.e;
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public PropertyMetadata getMetadata() {
        return this.d;
    }

    @Override // com.fasterxml.jackson.databind.introspect.g, defpackage.in1
    public String getName() {
        return this.e.getSimpleName();
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public PropertyName getWrapperName() {
        AnnotatedMember annotatedMember;
        AnnotationIntrospector annotationIntrospector = this.b;
        if (annotationIntrospector == null || (annotatedMember = this.c) == null) {
            return null;
        }
        return annotationIntrospector.findWrapperName(annotatedMember);
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public AnnotatedParameter i() {
        AnnotatedMember annotatedMember = this.c;
        if (annotatedMember instanceof AnnotatedParameter) {
            return (AnnotatedParameter) annotatedMember;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public Iterator j() {
        AnnotatedParameter annotatedParameterI = i();
        return annotatedParameterI == null ? ay.n() : Collections.singleton(annotatedParameterI).iterator();
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public AnnotatedField k() {
        AnnotatedMember annotatedMember = this.c;
        if (annotatedMember instanceof AnnotatedField) {
            return (AnnotatedField) annotatedMember;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public AnnotatedMethod l() {
        AnnotatedMember annotatedMember = this.c;
        if ((annotatedMember instanceof AnnotatedMethod) && ((AnnotatedMethod) annotatedMember).getParameterCount() == 0) {
            return (AnnotatedMethod) this.c;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public AnnotatedMember o() {
        return this.c;
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public JavaType p() {
        AnnotatedMember annotatedMember = this.c;
        return annotatedMember == null ? TypeFactory.unknownType() : annotatedMember.getType();
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public Class q() {
        AnnotatedMember annotatedMember = this.c;
        return annotatedMember == null ? Object.class : annotatedMember.getRawType();
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public AnnotatedMethod r() {
        AnnotatedMember annotatedMember = this.c;
        if ((annotatedMember instanceof AnnotatedMethod) && ((AnnotatedMethod) annotatedMember).getParameterCount() == 1) {
            return (AnnotatedMethod) this.c;
        }
        return null;
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public boolean s() {
        return this.c instanceof AnnotatedParameter;
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public boolean t() {
        return this.c instanceof AnnotatedField;
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public boolean u(PropertyName propertyName) {
        return this.e.equals(propertyName);
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public boolean v() {
        return r() != null;
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public boolean w() {
        return false;
    }

    @Override // com.fasterxml.jackson.databind.introspect.g
    public boolean x() {
        return false;
    }
}
