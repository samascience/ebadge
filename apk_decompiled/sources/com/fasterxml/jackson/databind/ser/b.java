package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.g;
import com.fasterxml.jackson.databind.util.NameTransformer;
import defpackage.an2;
import defpackage.ay;
import defpackage.d7;
import defpackage.f71;
import defpackage.kh;
import defpackage.l7;
import defpackage.p9;
import defpackage.ph;
import defpackage.z63;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final Object g = Boolean.FALSE;
    protected final SerializationConfig a;
    protected final kh b;
    protected final AnnotationIntrospector c;
    protected Object d;
    protected final JsonInclude.Value e;
    protected final boolean f;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonInclude.Include.values().length];
            a = iArr;
            try {
                iArr[JsonInclude.Include.NON_DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonInclude.Include.NON_ABSENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonInclude.Include.NON_EMPTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[JsonInclude.Include.CUSTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[JsonInclude.Include.NON_NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[JsonInclude.Include.ALWAYS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public b(SerializationConfig serializationConfig, kh khVar) {
        this.a = serializationConfig;
        this.b = khVar;
        JsonInclude.Value valueMerge = JsonInclude.Value.merge(khVar.p(JsonInclude.Value.empty()), serializationConfig.getDefaultPropertyInclusion(khVar.r(), JsonInclude.Value.empty()));
        this.e = JsonInclude.Value.merge(serializationConfig.getDefaultPropertyInclusion(), valueMerge);
        this.f = valueMerge.getValueInclusion() == JsonInclude.Include.NON_DEFAULT;
        this.c = serializationConfig.getAnnotationIntrospector();
    }

    protected BeanPropertyWriter a(g gVar, AnnotatedMember annotatedMember, l7 l7Var, JavaType javaType, f71 f71Var, z63 z63Var, JavaType javaType2, boolean z, Object obj, Class[] clsArr) {
        return new BeanPropertyWriter(gVar, annotatedMember, l7Var, javaType, f71Var, z63Var, javaType2, z, obj, clsArr);
    }

    protected Object b(Exception exc, String str, Object obj) {
        Throwable cause = exc;
        while (cause.getCause() != null) {
            cause = cause.getCause();
        }
        ay.h0(cause);
        ay.j0(cause);
        throw new IllegalArgumentException("Failed to get property '" + str + "' of default " + obj.getClass().getName() + " instance");
    }

    protected BeanPropertyWriter c(an2 an2Var, g gVar, JavaType javaType, f71 f71Var, z63 z63Var, z63 z63Var2, AnnotatedMember annotatedMember, boolean z) throws JsonMappingException {
        JavaType javaType2;
        Object objB;
        Object objE;
        boolean z2;
        Object obj;
        Object obj2;
        boolean z3 = false;
        try {
            JavaType javaTypeD = d(annotatedMember, z, javaType);
            if (z63Var2 != null) {
                if (javaTypeD == null) {
                    javaTypeD = javaType;
                }
                if (javaTypeD.mo15getContentType() == null) {
                    an2Var.reportBadPropertyDefinition(this.b, gVar, "serialization type " + javaTypeD + " has no content", new Object[0]);
                }
                JavaType javaTypeWithContentTypeHandler = javaTypeD.withContentTypeHandler(z63Var2);
                javaTypeWithContentTypeHandler.mo15getContentType();
                javaType2 = javaTypeWithContentTypeHandler;
            } else {
                javaType2 = javaTypeD;
            }
            JavaType javaType3 = javaType2 == null ? javaType : javaType2;
            AnnotatedMember annotatedMemberH = gVar.h();
            if (annotatedMemberH == null) {
                return (BeanPropertyWriter) an2Var.reportBadPropertyDefinition(this.b, gVar, "could not determine property type", new Object[0]);
            }
            JsonInclude.Value valueWithOverrides = this.a.getDefaultInclusion(javaType3.getRawClass(), annotatedMemberH.getRawType(), this.e).withOverrides(gVar.c());
            JsonInclude.Include valueInclusion = valueWithOverrides.getValueInclusion();
            if (valueInclusion == JsonInclude.Include.USE_DEFAULTS) {
                valueInclusion = JsonInclude.Include.ALWAYS;
            }
            int i = a.a[valueInclusion.ordinal()];
            Object objB2 = null;
            if (i != 1) {
                if (i == 2) {
                    if (javaType3.isReferenceType()) {
                        obj2 = BeanPropertyWriter.MARKER_FOR_EMPTY;
                    }
                    z2 = true;
                    obj = objB2;
                } else if (i != 3) {
                    if (i != 4) {
                        z3 = i == 5;
                        SerializationFeature serializationFeature = SerializationFeature.WRITE_EMPTY_JSON_ARRAYS;
                        if (javaType3.isContainerType() && !this.a.isEnabled(serializationFeature)) {
                            objB = BeanPropertyWriter.MARKER_FOR_EMPTY;
                        }
                        z2 = z3;
                        obj = objB2;
                    } else {
                        objB = an2Var.includeFilterInstance(gVar, valueWithOverrides.getValueFilter());
                    }
                    obj = objB;
                    z2 = z3;
                } else {
                    obj2 = BeanPropertyWriter.MARKER_FOR_EMPTY;
                }
                obj = obj2;
                z2 = true;
            } else {
                if (!this.f || (objE = e()) == null) {
                    objB2 = ph.b(javaType3);
                    z3 = true;
                } else {
                    if (an2Var.isEnabled(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                        annotatedMember.fixAccess(this.a.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                    }
                    try {
                        objB2 = annotatedMember.getValue(objE);
                    } catch (Exception e) {
                        b(e, gVar.getName(), objE);
                    }
                }
                if (objB2 == null) {
                    z2 = true;
                } else {
                    if (objB2.getClass().isArray()) {
                        objB = p9.b(objB2);
                        obj = objB;
                        z2 = z3;
                    }
                    z2 = z3;
                }
                obj = objB2;
            }
            Class[] clsArrG = gVar.g();
            if (clsArrG == null) {
                clsArrG = this.b.e();
            }
            BeanPropertyWriter beanPropertyWriterA = a(gVar, annotatedMember, this.b.s(), javaType, f71Var, z63Var, javaType2, z2, obj, clsArrG);
            Object objFindNullSerializer = this.c.findNullSerializer(annotatedMember);
            if (objFindNullSerializer != null) {
                beanPropertyWriterA.assignNullSerializer(an2Var.serializerInstance(annotatedMember, objFindNullSerializer));
            }
            NameTransformer nameTransformerFindUnwrappingNameTransformer = this.c.findUnwrappingNameTransformer(annotatedMember);
            return nameTransformerFindUnwrappingNameTransformer != null ? beanPropertyWriterA.unwrappingWriter(nameTransformerFindUnwrappingNameTransformer) : beanPropertyWriterA;
        } catch (JsonMappingException e2) {
            return gVar == null ? (BeanPropertyWriter) an2Var.reportBadDefinition(javaType, ay.o(e2)) : (BeanPropertyWriter) an2Var.reportBadPropertyDefinition(this.b, gVar, ay.o(e2), new Object[0]);
        }
    }

    protected JavaType d(d7 d7Var, boolean z, JavaType javaType) throws JsonMappingException {
        JavaType javaTypeRefineSerializationType = this.c.refineSerializationType(this.a, d7Var, javaType);
        if (javaTypeRefineSerializationType != javaType) {
            Class<?> rawClass = javaTypeRefineSerializationType.getRawClass();
            Class<?> rawClass2 = javaType.getRawClass();
            if (!rawClass.isAssignableFrom(rawClass2) && !rawClass2.isAssignableFrom(rawClass)) {
                throw new IllegalArgumentException("Illegal concrete-type annotation for method '" + d7Var.getName() + "': class " + rawClass.getName() + " not a super-type of (declared) class " + rawClass2.getName());
            }
            javaType = javaTypeRefineSerializationType;
            z = true;
        }
        JsonSerialize.Typing typingFindSerializationTyping = this.c.findSerializationTyping(d7Var);
        if (typingFindSerializationTyping != null && typingFindSerializationTyping != JsonSerialize.Typing.DEFAULT_TYPING) {
            z = typingFindSerializationTyping == JsonSerialize.Typing.STATIC;
        }
        if (z) {
            return javaType.withStaticTyping();
        }
        return null;
    }

    protected Object e() {
        Object objC = this.d;
        if (objC == null) {
            objC = this.b.C(this.a.canOverrideAccessModifiers());
            if (objC == null) {
                objC = g;
            }
            this.d = objC;
        }
        if (objC == g) {
            return null;
        }
        return this.d;
    }
}
