package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import defpackage.an2;
import defpackage.f71;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    protected final boolean a;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.ser.impl.a$a, reason: collision with other inner class name */
    private static final class C0071a extends a {
        private final Class b;
        private final Class c;
        private final f71 d;
        private final f71 e;

        public C0071a(a aVar, Class cls, f71 f71Var, Class cls2, f71 f71Var2) {
            super(aVar);
            this.b = cls;
            this.d = f71Var;
            this.c = cls2;
            this.e = f71Var2;
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.a
        public a j(Class cls, f71 f71Var) {
            return new c(this, new f[]{new f(this.b, this.d), new f(this.c, this.e), new f(cls, f71Var)});
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.a
        public f71 k(Class cls) {
            if (cls == this.b) {
                return this.d;
            }
            if (cls == this.c) {
                return this.e;
            }
            return null;
        }
    }

    private static final class b extends a {
        public static final b b = new b(false);
        public static final b c = new b(true);

        protected b(boolean z) {
            super(z);
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.a
        public a j(Class cls, f71 f71Var) {
            return new e(this, cls, f71Var);
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.a
        public f71 k(Class cls) {
            return null;
        }
    }

    private static final class c extends a {
        private final f[] b;

        public c(a aVar, f[] fVarArr) {
            super(aVar);
            this.b = fVarArr;
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.a
        public a j(Class cls, f71 f71Var) {
            f[] fVarArr = this.b;
            int length = fVarArr.length;
            if (length == 8) {
                return this.a ? new e(this, cls, f71Var) : this;
            }
            f[] fVarArr2 = (f[]) Arrays.copyOf(fVarArr, length + 1);
            fVarArr2[length] = new f(cls, f71Var);
            return new c(this, fVarArr2);
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.a
        public f71 k(Class cls) {
            f[] fVarArr = this.b;
            f fVar = fVarArr[0];
            if (fVar.a == cls) {
                return fVar.b;
            }
            f fVar2 = fVarArr[1];
            if (fVar2.a == cls) {
                return fVar2.b;
            }
            f fVar3 = fVarArr[2];
            if (fVar3.a == cls) {
                return fVar3.b;
            }
            switch (fVarArr.length) {
                case 8:
                    f fVar4 = fVarArr[7];
                    if (fVar4.a == cls) {
                        return fVar4.b;
                    }
                case 7:
                    f fVar5 = fVarArr[6];
                    if (fVar5.a == cls) {
                        return fVar5.b;
                    }
                case 6:
                    f fVar6 = fVarArr[5];
                    if (fVar6.a == cls) {
                        return fVar6.b;
                    }
                case 5:
                    f fVar7 = fVarArr[4];
                    if (fVar7.a == cls) {
                        return fVar7.b;
                    }
                case 4:
                    f fVar8 = fVarArr[3];
                    if (fVar8.a == cls) {
                        return fVar8.b;
                    }
                    return null;
                default:
                    return null;
            }
        }
    }

    public static final class d {
        public final f71 a;
        public final a b;

        public d(f71 f71Var, a aVar) {
            this.a = f71Var;
            this.b = aVar;
        }
    }

    private static final class e extends a {
        private final Class b;
        private final f71 c;

        public e(a aVar, Class cls, f71 f71Var) {
            super(aVar);
            this.b = cls;
            this.c = f71Var;
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.a
        public a j(Class cls, f71 f71Var) {
            return new C0071a(this, this.b, this.c, cls, f71Var);
        }

        @Override // com.fasterxml.jackson.databind.ser.impl.a
        public f71 k(Class cls) {
            if (cls == this.b) {
                return this.c;
            }
            return null;
        }
    }

    private static final class f {
        public final Class a;
        public final f71 b;

        public f(Class cls, f71 f71Var) {
            this.a = cls;
            this.b = f71Var;
        }
    }

    protected a(boolean z) {
        this.a = z;
    }

    public static a c() {
        return b.b;
    }

    public static a d() {
        return b.c;
    }

    public final d a(JavaType javaType, f71 f71Var) {
        return new d(f71Var, j(javaType.getRawClass(), f71Var));
    }

    public final d b(Class cls, f71 f71Var) {
        return new d(f71Var, j(cls, f71Var));
    }

    public final d e(Class cls, an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        f71 f71VarFindKeySerializer = an2Var.findKeySerializer((Class<?>) cls, beanProperty);
        return new d(f71VarFindKeySerializer, j(cls, f71VarFindKeySerializer));
    }

    public final d f(JavaType javaType, an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        f71 f71VarFindPrimaryPropertySerializer = an2Var.findPrimaryPropertySerializer(javaType, beanProperty);
        return new d(f71VarFindPrimaryPropertySerializer, j(javaType.getRawClass(), f71VarFindPrimaryPropertySerializer));
    }

    public final d g(Class cls, an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        f71 f71VarFindPrimaryPropertySerializer = an2Var.findPrimaryPropertySerializer((Class<?>) cls, beanProperty);
        return new d(f71VarFindPrimaryPropertySerializer, j(cls, f71VarFindPrimaryPropertySerializer));
    }

    public final d h(JavaType javaType, an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        f71 f71VarFindContentValueSerializer = an2Var.findContentValueSerializer(javaType, beanProperty);
        return new d(f71VarFindContentValueSerializer, j(javaType.getRawClass(), f71VarFindContentValueSerializer));
    }

    public final d i(Class cls, an2 an2Var, BeanProperty beanProperty) throws JsonMappingException {
        f71 f71VarFindContentValueSerializer = an2Var.findContentValueSerializer((Class<?>) cls, beanProperty);
        return new d(f71VarFindContentValueSerializer, j(cls, f71VarFindContentValueSerializer));
    }

    public abstract a j(Class cls, f71 f71Var);

    public abstract f71 k(Class cls);

    protected a(a aVar) {
        this.a = aVar.a;
    }
}
