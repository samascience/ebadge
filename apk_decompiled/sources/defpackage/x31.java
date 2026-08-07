package defpackage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class x31 {

    static class a {
        protected final kh a;
        protected final DeserializationConfig b;
        protected final AnnotationIntrospector c;
        protected final List d;
        protected final AnnotatedConstructor e;
        protected final b[] f;

        a(DeserializationContext deserializationContext, kh khVar) {
            this.a = khVar;
            this.c = deserializationContext.getAnnotationIntrospector();
            this.b = deserializationContext.getConfig();
            b[] bVarArrB = c.c().b(khVar.r());
            this.f = bVarArrB;
            AnnotatedConstructor annotatedConstructorD = null;
            if (bVarArrB == null) {
                this.d = khVar.u();
                this.e = null;
                return;
            }
            int length = bVarArrB.length;
            if (length != 0) {
                List<AnnotatedConstructor> listU = khVar.u();
                this.d = listU;
                loop0: for (AnnotatedConstructor annotatedConstructor : listU) {
                    if (annotatedConstructor.getParameterCount() == length) {
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                annotatedConstructorD = annotatedConstructor;
                                break loop0;
                            } else if (!annotatedConstructor.getRawParameterType(i).equals(this.f[i].a)) {
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                }
            } else {
                annotatedConstructorD = khVar.d();
                this.d = Collections.singletonList(annotatedConstructorD);
            }
            if (annotatedConstructorD != null) {
                this.e = annotatedConstructorD;
                return;
            }
            throw new IllegalArgumentException("Failed to find the canonical Record constructor of type " + ay.G(this.a.A()));
        }

        public AnnotatedConstructor a(List list) {
            for (AnnotatedConstructor annotatedConstructor : this.d) {
                JsonCreator.Mode modeFindCreatorAnnotation = this.c.findCreatorAnnotation(this.b, annotatedConstructor);
                if (modeFindCreatorAnnotation != null && JsonCreator.Mode.DISABLED != modeFindCreatorAnnotation && (JsonCreator.Mode.DELEGATING == modeFindCreatorAnnotation || annotatedConstructor != this.e)) {
                    return null;
                }
            }
            b[] bVarArr = this.f;
            if (bVarArr == null) {
                return null;
            }
            for (b bVar : bVarArr) {
                list.add(bVar.b);
            }
            return this.e;
        }
    }

    static class b {
        public final Class a;
        public final String b;

        public b(Class cls, String str) {
            this.a = cls;
            this.b = str;
        }
    }

    static class c {
        private static final c d;
        private static final RuntimeException e;
        private final Method a;
        private final Method b;
        private final Method c;

        static {
            c cVar = null;
            try {
                e = null;
                cVar = new c();
            } catch (RuntimeException e2) {
                e = e2;
            }
            d = cVar;
            e = e;
        }

        private c() {
            try {
                this.a = Class.class.getMethod("getRecordComponents", null);
                Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
                this.b = cls.getMethod("getName", null);
                this.c = cls.getMethod("getType", null);
            } catch (Exception e2) {
                throw new RuntimeException(String.format("Failed to access Methods needed to support `java.lang.Record`: (%s) %s", e2.getClass().getName(), e2.getMessage()), e2);
            }
        }

        public static c c() {
            RuntimeException runtimeException = e;
            if (runtimeException == null) {
                return d;
            }
            throw runtimeException;
        }

        public String[] a(Class cls) {
            Object[] objArrD = d(cls);
            if (objArrD == null) {
                return null;
            }
            String[] strArr = new String[objArrD.length];
            for (int i = 0; i < objArrD.length; i++) {
                try {
                    strArr[i] = (String) this.b.invoke(objArrD[i], null);
                } catch (Exception e2) {
                    throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", Integer.valueOf(i), Integer.valueOf(objArrD.length), ay.X(cls)), e2);
                }
            }
            return strArr;
        }

        public b[] b(Class cls) {
            Object[] objArrD = d(cls);
            if (objArrD == null) {
                return null;
            }
            b[] bVarArr = new b[objArrD.length];
            for (int i = 0; i < objArrD.length; i++) {
                try {
                    try {
                        bVarArr[i] = new b((Class) this.c.invoke(objArrD[i], null), (String) this.b.invoke(objArrD[i], null));
                    } catch (Exception e2) {
                        throw new IllegalArgumentException(String.format("Failed to access type of field #%d (of %d) of Record type %s", Integer.valueOf(i), Integer.valueOf(objArrD.length), ay.X(cls)), e2);
                    }
                } catch (Exception e3) {
                    throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", Integer.valueOf(i), Integer.valueOf(objArrD.length), ay.X(cls)), e3);
                }
            }
            return bVarArr;
        }

        protected Object[] d(Class cls) {
            try {
                return (Object[]) this.a.invoke(cls, null);
            } catch (Exception e2) {
                if (jn1.b(e2)) {
                    return null;
                }
                throw new IllegalArgumentException("Failed to access RecordComponents of type " + ay.X(cls));
            }
        }
    }

    public static AnnotatedConstructor a(DeserializationContext deserializationContext, kh khVar, List list) {
        return new a(deserializationContext, khVar).a(list);
    }

    public static String[] b(Class cls) {
        return c.c().a(cls);
    }
}
