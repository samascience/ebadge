package defpackage;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.a;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public abstract class iw2 {
    @Deprecated
    public Collection<NamedType> collectAndResolveSubtypes(AnnotatedMember annotatedMember, MapperConfig<?> mapperConfig, AnnotationIntrospector annotationIntrospector, JavaType javaType) {
        return collectAndResolveSubtypesByClass(mapperConfig, annotatedMember, javaType);
    }

    public abstract Collection collectAndResolveSubtypesByClass(MapperConfig mapperConfig, AnnotatedMember annotatedMember, JavaType javaType);

    public abstract Collection collectAndResolveSubtypesByClass(MapperConfig mapperConfig, a aVar);

    public abstract Collection collectAndResolveSubtypesByTypeId(MapperConfig mapperConfig, AnnotatedMember annotatedMember, JavaType javaType);

    public abstract Collection collectAndResolveSubtypesByTypeId(MapperConfig mapperConfig, a aVar);

    public abstract iw2 copy();

    public abstract void registerSubtypes(Collection collection);

    public abstract void registerSubtypes(NamedType... namedTypeArr);

    public abstract void registerSubtypes(Class... clsArr);

    @Deprecated
    public Collection<NamedType> collectAndResolveSubtypes(a aVar, MapperConfig<?> mapperConfig, AnnotationIntrospector annotationIntrospector) {
        return collectAndResolveSubtypesByClass(mapperConfig, aVar);
    }
}
