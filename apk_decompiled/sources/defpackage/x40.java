package defpackage;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.std.StdValueInstantiator;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import java.lang.reflect.Member;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class x40 {
    protected static final String[] j = {"default", "from-String", "from-int", "from-long", "from-big-integer", "from-double", "from-big-decimal", "from-boolean", "delegate", "property-based", "array-delegate"};
    protected final kh a;
    protected final boolean b;
    protected final boolean c;
    protected final AnnotatedWithParams[] d = new AnnotatedWithParams[11];
    protected int e = 0;
    protected boolean f = false;
    protected SettableBeanProperty[] g;
    protected SettableBeanProperty[] h;
    protected SettableBeanProperty[] i;

    public x40(kh khVar, MapperConfig mapperConfig) {
        this.a = khVar;
        this.b = mapperConfig.canOverrideAccessModifiers();
        this.c = mapperConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS);
    }

    private JavaType a(DeserializationContext deserializationContext, AnnotatedWithParams annotatedWithParams, SettableBeanProperty[] settableBeanPropertyArr) {
        if (!this.f || annotatedWithParams == null) {
            return null;
        }
        int i = 0;
        if (settableBeanPropertyArr != null) {
            int length = settableBeanPropertyArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (settableBeanPropertyArr[i2] == null) {
                    i = i2;
                    break;
                }
            }
        }
        DeserializationConfig config = deserializationContext.getConfig();
        JavaType parameterType = annotatedWithParams.getParameterType(i);
        AnnotationIntrospector annotationIntrospector = config.getAnnotationIntrospector();
        if (annotationIntrospector == null) {
            return parameterType;
        }
        AnnotatedParameter parameter = annotatedWithParams.getParameter(i);
        Object objFindDeserializer = annotationIntrospector.findDeserializer(parameter);
        return objFindDeserializer != null ? parameterType.withValueHandler(deserializationContext.deserializerInstance(parameter, objFindDeserializer)) : annotationIntrospector.refineDeserializationType(config, parameter, parameterType);
    }

    private AnnotatedMember b(AnnotatedMember annotatedMember) {
        if (annotatedMember != null && this.b) {
            ay.g((Member) annotatedMember.getAnnotated(), this.c);
        }
        return annotatedMember;
    }

    protected boolean c(AnnotatedWithParams annotatedWithParams) {
        return ay.L(annotatedWithParams.getDeclaringClass()) && "valueOf".equals(annotatedWithParams.getName());
    }

    protected void d(int i, boolean z, AnnotatedWithParams annotatedWithParams, AnnotatedWithParams annotatedWithParams2) {
        throw new IllegalArgumentException(String.format("Conflicting %s creators: already had %s creator %s, encountered another: %s", j[i], z ? "explicitly marked" : "implicitly discovered", annotatedWithParams, annotatedWithParams2));
    }

    public void e(AnnotatedWithParams annotatedWithParams, boolean z) {
        s(annotatedWithParams, 6, z);
    }

    public void f(AnnotatedWithParams annotatedWithParams, boolean z) {
        s(annotatedWithParams, 4, z);
    }

    public void g(AnnotatedWithParams annotatedWithParams, boolean z) {
        s(annotatedWithParams, 7, z);
    }

    public void h(AnnotatedWithParams annotatedWithParams, boolean z, SettableBeanProperty[] settableBeanPropertyArr, int i) {
        if (annotatedWithParams.getParameterType(i).isCollectionLikeType()) {
            if (s(annotatedWithParams, 10, z)) {
                this.h = settableBeanPropertyArr;
            }
        } else if (s(annotatedWithParams, 8, z)) {
            this.g = settableBeanPropertyArr;
        }
    }

    public void i(AnnotatedWithParams annotatedWithParams, boolean z) {
        s(annotatedWithParams, 5, z);
    }

    public void j(AnnotatedWithParams annotatedWithParams, boolean z) {
        s(annotatedWithParams, 2, z);
    }

    public void k(AnnotatedWithParams annotatedWithParams, boolean z) {
        s(annotatedWithParams, 3, z);
    }

    public void l(AnnotatedWithParams annotatedWithParams, boolean z, SettableBeanProperty[] settableBeanPropertyArr) {
        Integer num;
        if (s(annotatedWithParams, 9, z)) {
            if (settableBeanPropertyArr.length > 1) {
                HashMap map = new HashMap();
                int length = settableBeanPropertyArr.length;
                for (int i = 0; i < length; i++) {
                    String name = settableBeanPropertyArr[i].getName();
                    if ((!name.isEmpty() || settableBeanPropertyArr[i].getInjectableValueId() == null) && (num = (Integer) map.put(name, Integer.valueOf(i))) != null) {
                        throw new IllegalArgumentException(String.format("Duplicate creator property \"%s\" (index %s vs %d) for type %s ", name, num, Integer.valueOf(i), ay.X(this.a.r())));
                    }
                }
            }
            this.i = settableBeanPropertyArr;
        }
    }

    public void m(AnnotatedWithParams annotatedWithParams, boolean z) {
        s(annotatedWithParams, 1, z);
    }

    public ValueInstantiator n(DeserializationContext deserializationContext) {
        DeserializationConfig config = deserializationContext.getConfig();
        JavaType javaTypeA = a(deserializationContext, this.d[8], this.g);
        JavaType javaTypeA2 = a(deserializationContext, this.d[10], this.h);
        StdValueInstantiator stdValueInstantiator = new StdValueInstantiator(config, this.a.A());
        AnnotatedWithParams[] annotatedWithParamsArr = this.d;
        stdValueInstantiator.configureFromObjectSettings(annotatedWithParamsArr[0], annotatedWithParamsArr[8], javaTypeA, this.g, annotatedWithParamsArr[9], this.i);
        stdValueInstantiator.configureFromArraySettings(this.d[10], javaTypeA2, this.h);
        stdValueInstantiator.configureFromStringCreator(this.d[1]);
        stdValueInstantiator.configureFromIntCreator(this.d[2]);
        stdValueInstantiator.configureFromLongCreator(this.d[3]);
        stdValueInstantiator.configureFromBigIntegerCreator(this.d[4]);
        stdValueInstantiator.configureFromDoubleCreator(this.d[5]);
        stdValueInstantiator.configureFromBigDecimalCreator(this.d[6]);
        stdValueInstantiator.configureFromBooleanCreator(this.d[7]);
        return stdValueInstantiator;
    }

    public boolean o() {
        return this.d[0] != null;
    }

    public boolean p() {
        return this.d[8] != null;
    }

    public boolean q() {
        return this.d[9] != null;
    }

    public void r(AnnotatedWithParams annotatedWithParams) {
        this.d[0] = (AnnotatedWithParams) b(annotatedWithParams);
    }

    protected boolean s(AnnotatedWithParams annotatedWithParams, int i, boolean z) {
        boolean z2;
        int i2 = 1 << i;
        this.f = true;
        AnnotatedWithParams annotatedWithParams2 = this.d[i];
        if (annotatedWithParams2 != null) {
            if ((this.e & i2) == 0) {
                z2 = !z;
            } else {
                if (!z) {
                    return false;
                }
                z2 = true;
            }
            if (z2 && annotatedWithParams2.getClass() == annotatedWithParams.getClass()) {
                Class<?> rawParameterType = annotatedWithParams2.getRawParameterType(0);
                Class<?> rawParameterType2 = annotatedWithParams.getRawParameterType(0);
                if (rawParameterType == rawParameterType2) {
                    if (c(annotatedWithParams)) {
                        return false;
                    }
                    if (!c(annotatedWithParams2)) {
                        d(i, z, annotatedWithParams2, annotatedWithParams);
                    }
                } else {
                    if (rawParameterType2.isAssignableFrom(rawParameterType)) {
                        return false;
                    }
                    if (!rawParameterType.isAssignableFrom(rawParameterType2)) {
                        if (rawParameterType.isPrimitive() == rawParameterType2.isPrimitive()) {
                            d(i, z, annotatedWithParams2, annotatedWithParams);
                        } else if (rawParameterType.isPrimitive()) {
                            return false;
                        }
                    }
                }
            }
        }
        if (z) {
            this.e |= i2;
        }
        this.d[i] = (AnnotatedWithParams) b(annotatedWithParams);
        return true;
    }
}
