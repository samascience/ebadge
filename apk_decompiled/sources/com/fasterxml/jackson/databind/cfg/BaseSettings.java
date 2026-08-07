package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.DefaultAccessorNamingStrategy;
import com.fasterxml.jackson.databind.introspect.h;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import defpackage.dw0;
import defpackage.x63;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public final class BaseSettings implements Serializable {
    private static final TimeZone DEFAULT_TIMEZONE = TimeZone.getTimeZone("UTC");
    private static final long serialVersionUID = 1;
    protected final AccessorNamingStrategy.Provider _accessorNaming;
    protected final AnnotationIntrospector _annotationIntrospector;
    protected final h _classIntrospector;
    protected final DateFormat _dateFormat;
    protected final Base64Variant _defaultBase64;
    protected final dw0 _handlerInstantiator;
    protected final Locale _locale;
    protected final PropertyNamingStrategy _propertyNamingStrategy;
    protected final TimeZone _timeZone;
    protected final TypeFactory _typeFactory;
    protected final x63 _typeResolverBuilder;
    protected final PolymorphicTypeValidator _typeValidator;

    public BaseSettings(h hVar, AnnotationIntrospector annotationIntrospector, PropertyNamingStrategy propertyNamingStrategy, TypeFactory typeFactory, x63 x63Var, DateFormat dateFormat, dw0 dw0Var, Locale locale, TimeZone timeZone, Base64Variant base64Variant, PolymorphicTypeValidator polymorphicTypeValidator, AccessorNamingStrategy.Provider provider) {
        this._classIntrospector = hVar;
        this._annotationIntrospector = annotationIntrospector;
        this._propertyNamingStrategy = propertyNamingStrategy;
        this._typeFactory = typeFactory;
        this._typeResolverBuilder = x63Var;
        this._dateFormat = dateFormat;
        this._locale = locale;
        this._timeZone = timeZone;
        this._defaultBase64 = base64Variant;
        this._typeValidator = polymorphicTypeValidator;
        this._accessorNaming = provider;
    }

    private DateFormat _force(DateFormat dateFormat, TimeZone timeZone) {
        if (dateFormat instanceof StdDateFormat) {
            return ((StdDateFormat) dateFormat).withTimeZone(timeZone);
        }
        DateFormat dateFormat2 = (DateFormat) dateFormat.clone();
        dateFormat2.setTimeZone(timeZone);
        return dateFormat2;
    }

    public BaseSettings copy() {
        return new BaseSettings(this._classIntrospector.copy(), this._annotationIntrospector, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, null, this._locale, this._timeZone, this._defaultBase64, this._typeValidator, this._accessorNaming);
    }

    public AccessorNamingStrategy.Provider getAccessorNaming() {
        return this._accessorNaming;
    }

    public AnnotationIntrospector getAnnotationIntrospector() {
        return this._annotationIntrospector;
    }

    public Base64Variant getBase64Variant() {
        return this._defaultBase64;
    }

    public h getClassIntrospector() {
        return this._classIntrospector;
    }

    public DateFormat getDateFormat() {
        return this._dateFormat;
    }

    public dw0 getHandlerInstantiator() {
        return null;
    }

    public Locale getLocale() {
        return this._locale;
    }

    public PolymorphicTypeValidator getPolymorphicTypeValidator() {
        return this._typeValidator;
    }

    public PropertyNamingStrategy getPropertyNamingStrategy() {
        return this._propertyNamingStrategy;
    }

    public TimeZone getTimeZone() {
        TimeZone timeZone = this._timeZone;
        return timeZone == null ? DEFAULT_TIMEZONE : timeZone;
    }

    public TypeFactory getTypeFactory() {
        return this._typeFactory;
    }

    public x63 getTypeResolverBuilder() {
        return this._typeResolverBuilder;
    }

    public boolean hasExplicitTimeZone() {
        return this._timeZone != null;
    }

    public BaseSettings with(Locale locale) {
        return this._locale == locale ? this : new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, null, locale, this._timeZone, this._defaultBase64, this._typeValidator, this._accessorNaming);
    }

    public BaseSettings withAccessorNaming(AccessorNamingStrategy.Provider provider) {
        return this._accessorNaming == provider ? this : new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, null, this._locale, this._timeZone, this._defaultBase64, this._typeValidator, provider);
    }

    public BaseSettings withAnnotationIntrospector(AnnotationIntrospector annotationIntrospector) {
        return this._annotationIntrospector == annotationIntrospector ? this : new BaseSettings(this._classIntrospector, annotationIntrospector, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, null, this._locale, this._timeZone, this._defaultBase64, this._typeValidator, this._accessorNaming);
    }

    public BaseSettings withAppendedAnnotationIntrospector(AnnotationIntrospector annotationIntrospector) {
        return withAnnotationIntrospector(AnnotationIntrospectorPair.create(this._annotationIntrospector, annotationIntrospector));
    }

    public BaseSettings withClassIntrospector(h hVar) {
        return this._classIntrospector == hVar ? this : new BaseSettings(hVar, this._annotationIntrospector, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, null, this._locale, this._timeZone, this._defaultBase64, this._typeValidator, this._accessorNaming);
    }

    public BaseSettings withDateFormat(DateFormat dateFormat) {
        if (this._dateFormat == dateFormat) {
            return this;
        }
        if (dateFormat != null && hasExplicitTimeZone()) {
            dateFormat = _force(dateFormat, this._timeZone);
        }
        return new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, dateFormat, null, this._locale, this._timeZone, this._defaultBase64, this._typeValidator, this._accessorNaming);
    }

    public BaseSettings withHandlerInstantiator(dw0 dw0Var) {
        return this;
    }

    public BaseSettings withInsertedAnnotationIntrospector(AnnotationIntrospector annotationIntrospector) {
        return withAnnotationIntrospector(AnnotationIntrospectorPair.create(annotationIntrospector, this._annotationIntrospector));
    }

    public BaseSettings withPropertyNamingStrategy(PropertyNamingStrategy propertyNamingStrategy) {
        return this._propertyNamingStrategy == propertyNamingStrategy ? this : new BaseSettings(this._classIntrospector, this._annotationIntrospector, propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, null, this._locale, this._timeZone, this._defaultBase64, this._typeValidator, this._accessorNaming);
    }

    public BaseSettings withTypeFactory(TypeFactory typeFactory) {
        return this._typeFactory == typeFactory ? this : new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._propertyNamingStrategy, typeFactory, this._typeResolverBuilder, this._dateFormat, null, this._locale, this._timeZone, this._defaultBase64, this._typeValidator, this._accessorNaming);
    }

    public BaseSettings withTypeResolverBuilder(x63 x63Var) {
        return this._typeResolverBuilder == x63Var ? this : new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._propertyNamingStrategy, this._typeFactory, x63Var, this._dateFormat, null, this._locale, this._timeZone, this._defaultBase64, this._typeValidator, this._accessorNaming);
    }

    public BaseSettings with(TimeZone timeZone) {
        if (timeZone == this._timeZone) {
            return this;
        }
        return new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, _force(this._dateFormat, timeZone == null ? DEFAULT_TIMEZONE : timeZone), null, this._locale, timeZone, this._defaultBase64, this._typeValidator, this._accessorNaming);
    }

    public BaseSettings with(Base64Variant base64Variant) {
        return base64Variant == this._defaultBase64 ? this : new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, null, this._locale, this._timeZone, base64Variant, this._typeValidator, this._accessorNaming);
    }

    public BaseSettings with(PolymorphicTypeValidator polymorphicTypeValidator) {
        return polymorphicTypeValidator == this._typeValidator ? this : new BaseSettings(this._classIntrospector, this._annotationIntrospector, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, null, this._locale, this._timeZone, this._defaultBase64, polymorphicTypeValidator, this._accessorNaming);
    }

    @Deprecated
    public BaseSettings(h hVar, AnnotationIntrospector annotationIntrospector, PropertyNamingStrategy propertyNamingStrategy, TypeFactory typeFactory, x63 x63Var, DateFormat dateFormat, dw0 dw0Var, Locale locale, TimeZone timeZone, Base64Variant base64Variant, PolymorphicTypeValidator polymorphicTypeValidator) {
        this(hVar, annotationIntrospector, propertyNamingStrategy, typeFactory, x63Var, dateFormat, dw0Var, locale, timeZone, base64Variant, polymorphicTypeValidator, new DefaultAccessorNamingStrategy.Provider());
    }
}
