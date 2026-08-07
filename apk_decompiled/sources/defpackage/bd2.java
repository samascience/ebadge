package defpackage;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.util.LRUMap;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes.dex */
public final class bd2 {
    private final a[] a;
    private final int b;
    private final int c;

    /* JADX INFO: Access modifiers changed from: private */
    static final class a {
        public final f71 a;
        public final a b;
        protected final Class c;
        protected final JavaType d;
        protected final boolean e;

        public a(a aVar, q63 q63Var, f71 f71Var) {
            this.b = aVar;
            this.a = f71Var;
            this.e = q63Var.c();
            this.c = q63Var.a();
            this.d = q63Var.b();
        }

        public boolean a(JavaType javaType) {
            return this.e && javaType.equals(this.d);
        }

        public boolean b(Class cls) {
            return this.c == cls && this.e;
        }

        public boolean c(JavaType javaType) {
            return !this.e && javaType.equals(this.d);
        }

        public boolean d(Class cls) {
            return this.c == cls && !this.e;
        }
    }

    public bd2(LRUMap lRUMap) {
        int iB = b(lRUMap.size());
        this.b = iB;
        this.c = iB - 1;
        final a[] aVarArr = new a[iB];
        lRUMap.contents(new BiConsumer() { // from class: ad2
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.a.d(aVarArr, (q63) obj, (f71) obj2);
            }
        });
        this.a = aVarArr;
    }

    private static final int b(int i) {
        int i2 = 8;
        while (i2 < (i <= 64 ? i + i : i + (i >> 2))) {
            i2 += i2;
        }
        return i2;
    }

    public static bd2 c(LRUMap lRUMap) {
        return new bd2(lRUMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(a[] aVarArr, q63 q63Var, f71 f71Var) {
        int iHashCode = q63Var.hashCode() & this.c;
        aVarArr[iHashCode] = new a(aVarArr[iHashCode], q63Var, f71Var);
    }

    public f71 e(JavaType javaType) {
        a aVar = this.a[q63.d(javaType) & this.c];
        if (aVar == null) {
            return null;
        }
        if (aVar.a(javaType)) {
            return aVar.a;
        }
        do {
            aVar = aVar.b;
            if (aVar == null) {
                return null;
            }
        } while (!aVar.a(javaType));
        return aVar.a;
    }

    public f71 f(Class cls) {
        a aVar = this.a[q63.e(cls) & this.c];
        if (aVar == null) {
            return null;
        }
        if (aVar.b(cls)) {
            return aVar.a;
        }
        do {
            aVar = aVar.b;
            if (aVar == null) {
                return null;
            }
        } while (!aVar.b(cls));
        return aVar.a;
    }

    public f71 g(JavaType javaType) {
        a aVar = this.a[q63.f(javaType) & this.c];
        if (aVar == null) {
            return null;
        }
        if (aVar.c(javaType)) {
            return aVar.a;
        }
        do {
            aVar = aVar.b;
            if (aVar == null) {
                return null;
            }
        } while (!aVar.c(javaType));
        return aVar.a;
    }

    public f71 h(Class cls) {
        a aVar = this.a[q63.g(cls) & this.c];
        if (aVar == null) {
            return null;
        }
        if (aVar.d(cls)) {
            return aVar.a;
        }
        do {
            aVar = aVar.b;
            if (aVar == null) {
                return null;
            }
        } while (!aVar.d(cls));
        return aVar.a;
    }
}
