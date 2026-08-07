package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import defpackage.ay;
import defpackage.hi1;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class c extends i {
    private final m d;
    private final boolean e;
    private AnnotatedConstructor f;

    c(AnnotationIntrospector annotationIntrospector, m mVar, boolean z) {
        super(annotationIntrospector);
        this.d = mVar;
        this.e = z;
    }

    private List i(JavaType javaType, Class cls) {
        ay.a aVar;
        ArrayList arrayList;
        int i;
        List listEmptyList;
        if (javaType.isEnumType()) {
            aVar = null;
            arrayList = null;
        } else {
            aVar = null;
            arrayList = null;
            for (ay.a aVar2 : ay.A(javaType.getRawClass())) {
                if (t(aVar2.a())) {
                    if (aVar2.d() == 0) {
                        aVar = aVar2;
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(aVar2);
                    }
                }
            }
        }
        if (arrayList == null) {
            listEmptyList = Collections.emptyList();
            if (aVar == null) {
                return listEmptyList;
            }
            i = 0;
        } else {
            int size = arrayList.size();
            ArrayList arrayList2 = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                arrayList2.add(null);
            }
            i = size;
            listEmptyList = arrayList2;
        }
        if (cls != null) {
            hi1[] hi1VarArr = null;
            for (ay.a aVar3 : ay.A(cls)) {
                if (aVar3.d() == 0) {
                    if (aVar != null) {
                        this.f = q(aVar, aVar3);
                        aVar = null;
                    }
                } else if (arrayList != null) {
                    if (hi1VarArr == null) {
                        hi1VarArr = new hi1[i];
                        for (int i3 = 0; i3 < i; i3++) {
                            hi1VarArr[i3] = new hi1(((ay.a) arrayList.get(i3)).a());
                        }
                    }
                    hi1 hi1Var = new hi1(aVar3.a());
                    for (int i4 = 0; i4 < i; i4++) {
                        if (hi1Var.equals(hi1VarArr[i4])) {
                            listEmptyList.set(i4, s((ay.a) arrayList.get(i4), aVar3));
                            break;
                        }
                    }
                }
            }
        }
        if (aVar != null) {
            this.f = q(aVar, null);
        }
        for (int i5 = 0; i5 < i; i5++) {
            if (((AnnotatedConstructor) listEmptyList.get(i5)) == null) {
                listEmptyList.set(i5, s((ay.a) arrayList.get(i5), null));
            }
        }
        return listEmptyList;
    }

    private List j(TypeFactory typeFactory, JavaType javaType, Class cls) {
        ArrayList arrayList = null;
        for (Method method : ay.z(javaType.getRawClass())) {
            if (k(method)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(method);
            }
        }
        if (arrayList == null) {
            return Collections.emptyList();
        }
        m mVar = this.d;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList2.add(null);
        }
        if (cls != null) {
            hi1[] hi1VarArr = null;
            for (Method method2 : cls.getDeclaredMethods()) {
                if (k(method2)) {
                    if (hi1VarArr == null) {
                        hi1VarArr = new hi1[size];
                        for (int i2 = 0; i2 < size; i2++) {
                            hi1VarArr[i2] = new hi1((Method) arrayList.get(i2));
                        }
                    }
                    hi1 hi1Var = new hi1(method2);
                    for (int i3 = 0; i3 < size; i3++) {
                        if (hi1Var.equals(hi1VarArr[i3])) {
                            arrayList2.set(i3, r((Method) arrayList.get(i3), mVar, method2));
                            break;
                        }
                    }
                }
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            if (((AnnotatedMethod) arrayList2.get(i4)) == null) {
                Method method3 = (Method) arrayList.get(i4);
                arrayList2.set(i4, r(method3, j.e(method3, javaType, typeFactory, mVar), null));
            }
        }
        return arrayList2;
    }

    private static boolean k(Method method) {
        return Modifier.isStatic(method.getModifiers()) && !method.isSynthetic();
    }

    private f m(ay.a aVar, ay.a aVar2) {
        if (!this.e) {
            return i.a();
        }
        AnnotationCollector annotationCollectorE = e(aVar.b());
        if (aVar2 != null) {
            annotationCollectorE = d(annotationCollectorE, aVar2.b());
        }
        return annotationCollectorE.b();
    }

    private final f n(AnnotatedElement annotatedElement, AnnotatedElement annotatedElement2) {
        AnnotationCollector annotationCollectorE = e(annotatedElement.getDeclaredAnnotations());
        if (annotatedElement2 != null) {
            annotationCollectorE = d(annotationCollectorE, annotatedElement2.getDeclaredAnnotations());
        }
        return annotationCollectorE.b();
    }

    private f[] o(Annotation[][] annotationArr, Annotation[][] annotationArr2) {
        if (!this.e) {
            return i.b;
        }
        int length = annotationArr.length;
        f[] fVarArr = new f[length];
        for (int i = 0; i < length; i++) {
            AnnotationCollector annotationCollectorD = d(AnnotationCollector.e(), annotationArr[i]);
            if (annotationArr2 != null) {
                annotationCollectorD = d(annotationCollectorD, annotationArr2[i]);
            }
            fVarArr[i] = annotationCollectorD.b();
        }
        return fVarArr;
    }

    public static a.C0069a p(AnnotationIntrospector annotationIntrospector, TypeFactory typeFactory, m mVar, JavaType javaType, Class cls, boolean z) {
        return new c(annotationIntrospector, mVar, z | (cls != null)).l(typeFactory, javaType, cls);
    }

    private static boolean t(Constructor constructor) {
        return !constructor.isSynthetic();
    }

    a.C0069a l(TypeFactory typeFactory, JavaType javaType, Class cls) {
        List listI = i(javaType, cls);
        List listJ = j(typeFactory, javaType, cls);
        if (this.e) {
            AnnotatedConstructor annotatedConstructor = this.f;
            if (annotatedConstructor != null && this.a.hasIgnoreMarker(annotatedConstructor)) {
                this.f = null;
            }
            int size = listI.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                if (this.a.hasIgnoreMarker((AnnotatedMember) listI.get(size))) {
                    listI.remove(size);
                }
            }
            int size2 = listJ.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    break;
                }
                if (this.a.hasIgnoreMarker((AnnotatedMember) listJ.get(size2))) {
                    listJ.remove(size2);
                }
            }
        }
        return new a.C0069a(this.f, listI, listJ);
    }

    protected AnnotatedConstructor q(ay.a aVar, ay.a aVar2) {
        return new AnnotatedConstructor(this.d, aVar.a(), m(aVar, aVar2), i.b);
    }

    protected AnnotatedMethod r(Method method, m mVar, Method method2) {
        int parameterCount = method.getParameterCount();
        if (this.a == null) {
            return new AnnotatedMethod(mVar, method, i.a(), i.b(parameterCount));
        }
        if (parameterCount == 0) {
            return new AnnotatedMethod(mVar, method, n(method, method2), i.b);
        }
        return new AnnotatedMethod(mVar, method, n(method, method2), o(method.getParameterAnnotations(), method2 == null ? null : method2.getParameterAnnotations()));
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0075  */
    protected AnnotatedConstructor s(ay.a aVar, ay.a aVar2) {
        Annotation[][] annotationArr;
        int iD = aVar.d();
        if (this.a == null) {
            return new AnnotatedConstructor(this.d, aVar.a(), i.a(), i.b(iD));
        }
        if (iD == 0) {
            return new AnnotatedConstructor(this.d, aVar.a(), m(aVar, aVar2), i.b);
        }
        Annotation[][] annotationArrE = aVar.e();
        fVarArrO = null;
        f[] fVarArrO = null;
        if (iD != annotationArrE.length) {
            Class clsC = aVar.c();
            if (ay.L(clsC) && iD == annotationArrE.length + 2) {
                annotationArr = new Annotation[annotationArrE.length + 2][];
                System.arraycopy(annotationArrE, 0, annotationArr, 2, annotationArrE.length);
                fVarArrO = o(annotationArr, null);
            } else {
                if (clsC.isMemberClass() && iD == annotationArrE.length + 1) {
                    annotationArr = new Annotation[annotationArrE.length + 1][];
                    System.arraycopy(annotationArrE, 0, annotationArr, 1, annotationArrE.length);
                    annotationArr[0] = i.c;
                    fVarArrO = o(annotationArr, null);
                }
                if (fVarArrO == null) {
                    throw new IllegalStateException(String.format("Internal error: constructor for %s has mismatch: %d parameters; %d sets of annotations", aVar.c().getName(), Integer.valueOf(iD), Integer.valueOf(annotationArrE.length)));
                }
            }
            annotationArrE = annotationArr;
            if (fVarArrO == null) {
                throw new IllegalStateException(String.format("Internal error: constructor for %s has mismatch: %d parameters; %d sets of annotations", aVar.c().getName(), Integer.valueOf(iD), Integer.valueOf(annotationArrE.length)));
            }
        } else {
            fVarArrO = o(annotationArrE, aVar2 != null ? aVar2.e() : null);
        }
        return new AnnotatedConstructor(this.d, aVar.a(), m(aVar, aVar2), fVarArrO);
    }
}
