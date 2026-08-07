package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.MapperConfigBase;
import com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.introspect.a;
import com.fasterxml.jackson.databind.introspect.h;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import defpackage.ay;
import defpackage.dw0;
import defpackage.iw2;
import defpackage.j10;
import defpackage.l10;
import defpackage.u60;
import defpackage.x63;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public abstract class MapperConfigBase<CFG extends j10, T extends MapperConfigBase<CFG, T>> extends MapperConfig<T> implements Serializable {
    protected final ContextAttributes _attributes;
    protected final ConfigOverrides _configOverrides;
    protected final DatatypeFeatures _datatypeFeatures;
    protected final SimpleMixInResolver _mixIns;
    protected final PropertyName _rootName;
    protected final RootNameLookup _rootNames;
    protected final iw2 _subtypeResolver;
    protected final Class<?> _view;
    protected static final l10 EMPTY_OVERRIDE = l10.empty();
    private static final long DEFAULT_MAPPER_FEATURES = MapperFeature.collectLongDefaults();
    private static final long AUTO_DETECT_MASK = (((MapperFeature.AUTO_DETECT_FIELDS.getLongMask() | MapperFeature.AUTO_DETECT_GETTERS.getLongMask()) | MapperFeature.AUTO_DETECT_IS_GETTERS.getLongMask()) | MapperFeature.AUTO_DETECT_SETTERS.getLongMask()) | MapperFeature.AUTO_DETECT_CREATORS.getLongMask();

    protected MapperConfigBase(BaseSettings baseSettings, iw2 iw2Var, SimpleMixInResolver simpleMixInResolver, RootNameLookup rootNameLookup, ConfigOverrides configOverrides, DatatypeFeatures datatypeFeatures) {
        super(baseSettings, DEFAULT_MAPPER_FEATURES);
        this._mixIns = simpleMixInResolver;
        this._subtypeResolver = iw2Var;
        this._rootNames = rootNameLookup;
        this._rootName = null;
        this._view = null;
        this._attributes = ContextAttributes.getEmpty();
        this._configOverrides = configOverrides;
        this._datatypeFeatures = datatypeFeatures;
    }

    protected DatatypeFeatures _datatypeFeatures() {
        return this._datatypeFeatures;
    }

    protected abstract T _with(DatatypeFeatures datatypeFeatures);

    protected abstract T _withBase(BaseSettings baseSettings);

    protected abstract T _withMapperFeatures(long j);

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig, com.fasterxml.jackson.databind.introspect.h.a
    public h.a copy() {
        throw new UnsupportedOperationException();
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public final l10 findConfigOverride(Class<?> cls) {
        return this._configOverrides.findOverride(cls);
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig, com.fasterxml.jackson.databind.introspect.h.a
    public final Class<?> findMixInClassFor(Class<?> cls) {
        return this._mixIns.findMixInClassFor(cls);
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public PropertyName findRootName(JavaType javaType) {
        PropertyName propertyName = this._rootName;
        return propertyName != null ? propertyName : this._rootNames.findRootName(javaType, this);
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public final Class<?> getActiveView() {
        return this._view;
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public final ContextAttributes getAttributes() {
        return this._attributes;
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public final l10 getConfigOverride(Class<?> cls) {
        l10 l10VarFindOverride = this._configOverrides.findOverride(cls);
        return l10VarFindOverride == null ? EMPTY_OVERRIDE : l10VarFindOverride;
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public final JsonInclude.Value getDefaultInclusion(Class<?> cls, Class<?> cls2) {
        JsonInclude.Value includeAsProperty = getConfigOverride(cls2).getIncludeAsProperty();
        JsonInclude.Value defaultPropertyInclusion = getDefaultPropertyInclusion(cls);
        return defaultPropertyInclusion == null ? includeAsProperty : defaultPropertyInclusion.withOverrides(includeAsProperty);
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public Boolean getDefaultMergeable() {
        return this._configOverrides.getDefaultMergeable();
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public final JsonFormat.Value getDefaultPropertyFormat(Class<?> cls) {
        return this._configOverrides.findFormatDefaults(cls);
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public final JsonIgnoreProperties.Value getDefaultPropertyIgnorals(Class<?> cls) {
        JsonIgnoreProperties.Value ignorals;
        l10 l10VarFindOverride = this._configOverrides.findOverride(cls);
        if (l10VarFindOverride == null || (ignorals = l10VarFindOverride.getIgnorals()) == null) {
            return null;
        }
        return ignorals;
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public final JsonInclude.Value getDefaultPropertyInclusion() {
        return this._configOverrides.getDefaultInclusion();
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public final JsonIncludeProperties.Value getDefaultPropertyInclusions(Class<?> cls, a aVar) {
        AnnotationIntrospector annotationIntrospector = getAnnotationIntrospector();
        if (annotationIntrospector == null) {
            return null;
        }
        return annotationIntrospector.findPropertyInclusionByName(this, aVar);
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public final JsonSetter.Value getDefaultSetterInfo() {
        return this._configOverrides.getDefaultSetterInfo();
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public final VisibilityChecker getDefaultVisibilityChecker() {
        VisibilityChecker defaultVisibility = this._configOverrides.getDefaultVisibility();
        long j = this._mapperFeatures;
        long j2 = AUTO_DETECT_MASK;
        if ((j & j2) == j2) {
            return defaultVisibility;
        }
        if (!isEnabled(MapperFeature.AUTO_DETECT_FIELDS)) {
            defaultVisibility = defaultVisibility.withFieldVisibility(JsonAutoDetect.Visibility.NONE);
        }
        if (!isEnabled(MapperFeature.AUTO_DETECT_GETTERS)) {
            defaultVisibility = defaultVisibility.withGetterVisibility(JsonAutoDetect.Visibility.NONE);
        }
        if (!isEnabled(MapperFeature.AUTO_DETECT_IS_GETTERS)) {
            defaultVisibility = defaultVisibility.withIsGetterVisibility(JsonAutoDetect.Visibility.NONE);
        }
        if (!isEnabled(MapperFeature.AUTO_DETECT_SETTERS)) {
            defaultVisibility = defaultVisibility.withSetterVisibility(JsonAutoDetect.Visibility.NONE);
        }
        return !isEnabled(MapperFeature.AUTO_DETECT_CREATORS) ? defaultVisibility.withCreatorVisibility(JsonAutoDetect.Visibility.NONE) : defaultVisibility;
    }

    public final PropertyName getFullRootName() {
        return this._rootName;
    }

    @Deprecated
    public final String getRootName() {
        PropertyName propertyName = this._rootName;
        if (propertyName == null) {
            return null;
        }
        return propertyName.getSimpleName();
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public final iw2 getSubtypeResolver() {
        return this._subtypeResolver;
    }

    public final int mixInCount() {
        return this._mixIns.localSize();
    }

    public abstract T with(ContextAttributes contextAttributes);

    public abstract T with(iw2 iw2Var);

    public final T withAppendedAnnotationIntrospector(AnnotationIntrospector annotationIntrospector) {
        return (T) _withBase(this._base.withAppendedAnnotationIntrospector(annotationIntrospector));
    }

    public T withAttribute(Object obj, Object obj2) {
        return (T) with(getAttributes().withSharedAttribute(obj, obj2));
    }

    public T withAttributes(Map<?, ?> map) {
        return (T) with(getAttributes().withSharedAttributes(map));
    }

    public final T withFeatures(u60... u60VarArr) {
        return (T) _with(_datatypeFeatures().withFeatures(u60VarArr));
    }

    public final T withInsertedAnnotationIntrospector(AnnotationIntrospector annotationIntrospector) {
        return (T) _withBase(this._base.withInsertedAnnotationIntrospector(annotationIntrospector));
    }

    public abstract T withRootName(PropertyName propertyName);

    public T withRootName(String str) {
        return str == null ? (T) withRootName((PropertyName) null) : (T) withRootName(PropertyName.construct(str));
    }

    public abstract T withView(Class<?> cls);

    public T withoutAttribute(Object obj) {
        return (T) with(getAttributes().withoutSharedAttribute(obj));
    }

    public final T withoutFeatures(u60... u60VarArr) {
        return (T) _with(_datatypeFeatures().withoutFeatures(u60VarArr));
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public Boolean getDefaultMergeable(Class<?> cls) {
        Boolean mergeable;
        l10 l10VarFindOverride = this._configOverrides.findOverride(cls);
        return (l10VarFindOverride == null || (mergeable = l10VarFindOverride.getMergeable()) == null) ? this._configOverrides.getDefaultMergeable() : mergeable;
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public final JsonInclude.Value getDefaultPropertyInclusion(Class<?> cls) {
        JsonInclude.Value include = getConfigOverride(cls).getInclude();
        JsonInclude.Value defaultPropertyInclusion = getDefaultPropertyInclusion();
        return defaultPropertyInclusion == null ? include : defaultPropertyInclusion.withOverrides(include);
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public final T without(MapperFeature... mapperFeatureArr) {
        long j = this._mapperFeatures;
        for (MapperFeature mapperFeature : mapperFeatureArr) {
            j &= ~mapperFeature.getLongMask();
        }
        return j == this._mapperFeatures ? this : (T) _withMapperFeatures(j);
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public PropertyName findRootName(Class<?> cls) {
        PropertyName propertyName = this._rootName;
        return propertyName != null ? propertyName : this._rootNames.findRootName(cls, this);
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public final JsonIgnoreProperties.Value getDefaultPropertyIgnorals(Class<?> cls, a aVar) {
        AnnotationIntrospector annotationIntrospector = getAnnotationIntrospector();
        return JsonIgnoreProperties.Value.merge(annotationIntrospector == null ? null : annotationIntrospector.findPropertyIgnoralByName(this, aVar), getDefaultPropertyIgnorals(cls));
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public final T with(MapperFeature... mapperFeatureArr) {
        long longMask = this._mapperFeatures;
        for (MapperFeature mapperFeature : mapperFeatureArr) {
            longMask |= mapperFeature.getLongMask();
        }
        return longMask == this._mapperFeatures ? this : (T) _withMapperFeatures(longMask);
    }

    public final T without(u60 u60Var) {
        return (T) _with(_datatypeFeatures().without(u60Var));
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public final T with(MapperFeature mapperFeature, boolean z) {
        long longMask;
        if (z) {
            longMask = mapperFeature.getLongMask() | this._mapperFeatures;
        } else {
            longMask = (~mapperFeature.getLongMask()) & this._mapperFeatures;
        }
        return longMask == this._mapperFeatures ? this : (T) _withMapperFeatures(longMask);
    }

    protected MapperConfigBase(MapperConfigBase<CFG, T> mapperConfigBase, iw2 iw2Var, SimpleMixInResolver simpleMixInResolver, RootNameLookup rootNameLookup, ConfigOverrides configOverrides) {
        super(mapperConfigBase, mapperConfigBase._base.copy());
        this._mixIns = simpleMixInResolver;
        this._subtypeResolver = iw2Var;
        this._rootNames = rootNameLookup;
        this._rootName = mapperConfigBase._rootName;
        this._view = mapperConfigBase._view;
        this._attributes = mapperConfigBase._attributes;
        this._configOverrides = configOverrides;
        this._datatypeFeatures = mapperConfigBase._datatypeFeatures;
    }

    public final T with(u60 u60Var) {
        return (T) _with(_datatypeFeatures().with(u60Var));
    }

    @Override // com.fasterxml.jackson.databind.cfg.MapperConfig
    public final VisibilityChecker getDefaultVisibilityChecker(Class<?> cls, a aVar) {
        VisibilityChecker defaultVisibilityChecker;
        if (ay.M(cls)) {
            defaultVisibilityChecker = VisibilityChecker.Std.allPublicInstance();
        } else {
            defaultVisibilityChecker = getDefaultVisibilityChecker();
        }
        AnnotationIntrospector annotationIntrospector = getAnnotationIntrospector();
        if (annotationIntrospector != null) {
            defaultVisibilityChecker = annotationIntrospector.findAutoDetectVisibility(aVar, defaultVisibilityChecker);
        }
        l10 l10VarFindOverride = this._configOverrides.findOverride(cls);
        return l10VarFindOverride != null ? defaultVisibilityChecker.withOverrides(l10VarFindOverride.getVisibility()) : defaultVisibilityChecker;
    }

    public final T with(u60 u60Var, boolean z) {
        DatatypeFeatures datatypeFeatures_datatypeFeatures = _datatypeFeatures();
        return (T) _with(z ? datatypeFeatures_datatypeFeatures.with(u60Var) : datatypeFeatures_datatypeFeatures.without(u60Var));
    }

    public final T with(AnnotationIntrospector annotationIntrospector) {
        return (T) _withBase(this._base.withAnnotationIntrospector(annotationIntrospector));
    }

    public final T with(h hVar) {
        return (T) _withBase(this._base.withClassIntrospector(hVar));
    }

    public final T with(TypeFactory typeFactory) {
        return (T) _withBase(this._base.withTypeFactory(typeFactory));
    }

    protected MapperConfigBase(MapperConfigBase<CFG, T> mapperConfigBase) {
        super(mapperConfigBase);
        this._mixIns = mapperConfigBase._mixIns;
        this._subtypeResolver = mapperConfigBase._subtypeResolver;
        this._rootNames = mapperConfigBase._rootNames;
        this._rootName = mapperConfigBase._rootName;
        this._view = mapperConfigBase._view;
        this._attributes = mapperConfigBase._attributes;
        this._configOverrides = mapperConfigBase._configOverrides;
        this._datatypeFeatures = mapperConfigBase._datatypeFeatures;
    }

    public final T with(x63 x63Var) {
        return (T) _withBase(this._base.withTypeResolverBuilder(x63Var));
    }

    public final T with(PropertyNamingStrategy propertyNamingStrategy) {
        return (T) _withBase(this._base.withPropertyNamingStrategy(propertyNamingStrategy));
    }

    public final T with(AccessorNamingStrategy.Provider provider) {
        return (T) _withBase(this._base.withAccessorNaming(provider));
    }

    public final T with(dw0 dw0Var) {
        return (T) _withBase(this._base.withHandlerInstantiator(dw0Var));
    }

    public final T with(Base64Variant base64Variant) {
        return (T) _withBase(this._base.with(base64Variant));
    }

    public T with(DateFormat dateFormat) {
        return (T) _withBase(this._base.withDateFormat(dateFormat));
    }

    public final T with(Locale locale) {
        return (T) _withBase(this._base.with(locale));
    }

    public final T with(TimeZone timeZone) {
        return (T) _withBase(this._base.with(timeZone));
    }

    protected MapperConfigBase(MapperConfigBase<CFG, T> mapperConfigBase, BaseSettings baseSettings) {
        super(mapperConfigBase, baseSettings);
        this._mixIns = mapperConfigBase._mixIns;
        this._subtypeResolver = mapperConfigBase._subtypeResolver;
        this._rootNames = mapperConfigBase._rootNames;
        this._rootName = mapperConfigBase._rootName;
        this._view = mapperConfigBase._view;
        this._attributes = mapperConfigBase._attributes;
        this._configOverrides = mapperConfigBase._configOverrides;
        this._datatypeFeatures = mapperConfigBase._datatypeFeatures;
    }

    protected MapperConfigBase(MapperConfigBase<CFG, T> mapperConfigBase, long j) {
        super(mapperConfigBase, j);
        this._mixIns = mapperConfigBase._mixIns;
        this._subtypeResolver = mapperConfigBase._subtypeResolver;
        this._rootNames = mapperConfigBase._rootNames;
        this._rootName = mapperConfigBase._rootName;
        this._view = mapperConfigBase._view;
        this._attributes = mapperConfigBase._attributes;
        this._configOverrides = mapperConfigBase._configOverrides;
        this._datatypeFeatures = mapperConfigBase._datatypeFeatures;
    }

    protected MapperConfigBase(MapperConfigBase<CFG, T> mapperConfigBase, iw2 iw2Var) {
        super(mapperConfigBase);
        this._mixIns = mapperConfigBase._mixIns;
        this._subtypeResolver = iw2Var;
        this._rootNames = mapperConfigBase._rootNames;
        this._rootName = mapperConfigBase._rootName;
        this._view = mapperConfigBase._view;
        this._attributes = mapperConfigBase._attributes;
        this._configOverrides = mapperConfigBase._configOverrides;
        this._datatypeFeatures = mapperConfigBase._datatypeFeatures;
    }

    protected MapperConfigBase(MapperConfigBase<CFG, T> mapperConfigBase, PropertyName propertyName) {
        super(mapperConfigBase);
        this._mixIns = mapperConfigBase._mixIns;
        this._subtypeResolver = mapperConfigBase._subtypeResolver;
        this._rootNames = mapperConfigBase._rootNames;
        this._rootName = propertyName;
        this._view = mapperConfigBase._view;
        this._attributes = mapperConfigBase._attributes;
        this._configOverrides = mapperConfigBase._configOverrides;
        this._datatypeFeatures = mapperConfigBase._datatypeFeatures;
    }

    protected MapperConfigBase(MapperConfigBase<CFG, T> mapperConfigBase, Class<?> cls) {
        super(mapperConfigBase);
        this._mixIns = mapperConfigBase._mixIns;
        this._subtypeResolver = mapperConfigBase._subtypeResolver;
        this._rootNames = mapperConfigBase._rootNames;
        this._rootName = mapperConfigBase._rootName;
        this._view = cls;
        this._attributes = mapperConfigBase._attributes;
        this._configOverrides = mapperConfigBase._configOverrides;
        this._datatypeFeatures = mapperConfigBase._datatypeFeatures;
    }

    protected MapperConfigBase(MapperConfigBase<CFG, T> mapperConfigBase, SimpleMixInResolver simpleMixInResolver) {
        super(mapperConfigBase);
        this._mixIns = simpleMixInResolver;
        this._subtypeResolver = mapperConfigBase._subtypeResolver;
        this._rootNames = mapperConfigBase._rootNames;
        this._rootName = mapperConfigBase._rootName;
        this._view = mapperConfigBase._view;
        this._attributes = mapperConfigBase._attributes;
        this._configOverrides = mapperConfigBase._configOverrides;
        this._datatypeFeatures = mapperConfigBase._datatypeFeatures;
    }

    protected MapperConfigBase(MapperConfigBase<CFG, T> mapperConfigBase, ContextAttributes contextAttributes) {
        super(mapperConfigBase);
        this._mixIns = mapperConfigBase._mixIns;
        this._subtypeResolver = mapperConfigBase._subtypeResolver;
        this._rootNames = mapperConfigBase._rootNames;
        this._rootName = mapperConfigBase._rootName;
        this._view = mapperConfigBase._view;
        this._attributes = contextAttributes;
        this._configOverrides = mapperConfigBase._configOverrides;
        this._datatypeFeatures = mapperConfigBase._datatypeFeatures;
    }

    protected MapperConfigBase(MapperConfigBase<CFG, T> mapperConfigBase, DatatypeFeatures datatypeFeatures) {
        super(mapperConfigBase);
        this._mixIns = mapperConfigBase._mixIns;
        this._subtypeResolver = mapperConfigBase._subtypeResolver;
        this._rootNames = mapperConfigBase._rootNames;
        this._rootName = mapperConfigBase._rootName;
        this._view = mapperConfigBase._view;
        this._attributes = mapperConfigBase._attributes;
        this._configOverrides = mapperConfigBase._configOverrides;
        this._datatypeFeatures = datatypeFeatures;
    }
}
