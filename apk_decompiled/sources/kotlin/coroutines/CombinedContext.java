package kotlin.coroutines;

import com.tencent.connect.common.Constants;
import defpackage.k83;
import defpackage.or0;
import defpackage.p31;
import defpackage.y70;
import java.io.Serializable;
import kotlin.coroutines.CombinedContext;
import kotlin.coroutines.d;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: loaded from: classes4.dex */
public final class CombinedContext implements d, Serializable {
    private final d.b element;
    private final d left;

    private static final class Serialized implements Serializable {
        public static final a Companion = new a(null);
        private static final long serialVersionUID = 0;
        private final d[] elements;

        public static final class a {
            public /* synthetic */ a(y70 y70Var) {
                this();
            }

            private a() {
            }
        }

        public Serialized(d[] dVarArr) {
            p31.f(dVarArr, "elements");
            this.elements = dVarArr;
        }

        private final Object readResolve() {
            d[] dVarArr = this.elements;
            d dVarPlus = EmptyCoroutineContext.INSTANCE;
            for (d dVar : dVarArr) {
                dVarPlus = dVarPlus.plus(dVar);
            }
            return dVarPlus;
        }

        public final d[] getElements() {
            return this.elements;
        }
    }

    public CombinedContext(d dVar, d.b bVar) {
        p31.f(dVar, "left");
        p31.f(bVar, "element");
        this.left = dVar;
        this.element = bVar;
    }

    private final boolean contains(d.b bVar) {
        return p31.a(get(bVar.getKey()), bVar);
    }

    private final boolean containsAll(CombinedContext combinedContext) {
        while (contains(combinedContext.element)) {
            d dVar = combinedContext.left;
            if (!(dVar instanceof CombinedContext)) {
                p31.d(dVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return contains((d.b) dVar);
            }
            combinedContext = (CombinedContext) dVar;
        }
        return false;
    }

    private final int size() {
        int i = 2;
        CombinedContext combinedContext = this;
        while (true) {
            d dVar = combinedContext.left;
            combinedContext = dVar instanceof CombinedContext ? (CombinedContext) dVar : null;
            if (combinedContext == null) {
                return i;
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toString$lambda$2(String str, d.b bVar) {
        p31.f(str, "acc");
        p31.f(bVar, "element");
        if (str.length() == 0) {
            return bVar.toString();
        }
        return str + ", " + bVar;
    }

    private final Object writeReplace() {
        int size = size();
        final d[] dVarArr = new d[size];
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        fold(k83.a, new or0() { // from class: rz
            @Override // defpackage.or0
            public final Object invoke(Object obj, Object obj2) {
                return CombinedContext.writeReplace$lambda$3(dVarArr, ref$IntRef, (k83) obj, (d.b) obj2);
            }
        });
        if (ref$IntRef.element == size) {
            return new Serialized(dVarArr);
        }
        throw new IllegalStateException("Check failed.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 writeReplace$lambda$3(d[] dVarArr, Ref$IntRef ref$IntRef, k83 k83Var, d.b bVar) {
        p31.f(k83Var, "<unused var>");
        p31.f(bVar, "element");
        int i = ref$IntRef.element;
        ref$IntRef.element = i + 1;
        dVarArr[i] = bVar;
        return k83.a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CombinedContext) {
                CombinedContext combinedContext = (CombinedContext) obj;
                if (combinedContext.size() != size() || !combinedContext.containsAll(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // kotlin.coroutines.d
    public <R> R fold(R r, or0 or0Var) {
        p31.f(or0Var, "operation");
        return (R) or0Var.invoke(this.left.fold(r, or0Var), this.element);
    }

    @Override // kotlin.coroutines.d
    public <E extends d.b> E get(d.c cVar) {
        p31.f(cVar, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e = (E) combinedContext.element.get(cVar);
            if (e != null) {
                return e;
            }
            d dVar = combinedContext.left;
            if (!(dVar instanceof CombinedContext)) {
                return (E) dVar.get(cVar);
            }
            combinedContext = (CombinedContext) dVar;
        }
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    @Override // kotlin.coroutines.d
    public d minusKey(d.c cVar) {
        p31.f(cVar, "key");
        if (this.element.get(cVar) != null) {
            return this.left;
        }
        d dVarMinusKey = this.left.minusKey(cVar);
        if (dVarMinusKey == this.left) {
            return this;
        }
        return dVarMinusKey == EmptyCoroutineContext.INSTANCE ? this.element : new CombinedContext(dVarMinusKey, this.element);
    }

    @Override // kotlin.coroutines.d
    public d plus(d dVar) {
        return d.a.b(this, dVar);
    }

    public String toString() {
        return '[' + ((String) fold(Constants.STR_EMPTY, new or0() { // from class: sz
            @Override // defpackage.or0
            public final Object invoke(Object obj, Object obj2) {
                return CombinedContext.toString$lambda$2((String) obj, (d.b) obj2);
            }
        })) + ']';
    }
}
