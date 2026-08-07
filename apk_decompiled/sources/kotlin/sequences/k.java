package kotlin.sequences;

import com.tencent.connect.common.Constants;
import defpackage.ar0;
import defpackage.e53;
import defpackage.k81;
import defpackage.ln0;
import defpackage.p31;
import defpackage.rm2;
import defpackage.yd0;
import defpackage.zd0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class k extends i {

    public static final class a implements Iterable, k81 {
        final /* synthetic */ rm2 a;

        public a(rm2 rm2Var) {
            this.a = rm2Var;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return this.a.iterator();
        }
    }

    public static final class b implements rm2 {
        final /* synthetic */ rm2 a;
        final /* synthetic */ Comparator b;

        b(rm2 rm2Var, Comparator comparator) {
            this.a = rm2Var;
            this.b = comparator;
        }

        @Override // defpackage.rm2
        public Iterator iterator() {
            List listA = k.A(this.a);
            kotlin.collections.j.v(listA, this.b);
            return listA.iterator();
        }
    }

    public static final List A(rm2 rm2Var) {
        p31.f(rm2Var, "<this>");
        return (List) y(rm2Var, new ArrayList());
    }

    public static Iterable k(rm2 rm2Var) {
        p31.f(rm2Var, "<this>");
        return new a(rm2Var);
    }

    public static int l(rm2 rm2Var) {
        p31.f(rm2Var, "<this>");
        Iterator it = rm2Var.iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
            if (i < 0) {
                kotlin.collections.j.r();
            }
        }
        return i;
    }

    public static rm2 m(rm2 rm2Var, int i) {
        p31.f(rm2Var, "<this>");
        if (i >= 0) {
            if (i == 0) {
                return rm2Var;
            }
            return rm2Var instanceof zd0 ? ((zd0) rm2Var).a(i) : new yd0(rm2Var, i);
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static rm2 n(rm2 rm2Var, ar0 ar0Var) {
        p31.f(rm2Var, "<this>");
        p31.f(ar0Var, "predicate");
        return new ln0(rm2Var, true, ar0Var);
    }

    public static final rm2 o(rm2 rm2Var, ar0 ar0Var) {
        p31.f(rm2Var, "<this>");
        p31.f(ar0Var, "predicate");
        return new ln0(rm2Var, false, ar0Var);
    }

    public static final rm2 p(rm2 rm2Var) {
        p31.f(rm2Var, "<this>");
        rm2 rm2VarO = o(rm2Var, new ar0() { // from class: kotlin.sequences.j
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return Boolean.valueOf(k.q(obj));
            }
        });
        p31.d(rm2VarO, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return rm2VarO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q(Object obj) {
        return obj == null;
    }

    public static final Appendable r(rm2 rm2Var, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, ar0 ar0Var) throws IOException {
        p31.f(rm2Var, "<this>");
        p31.f(appendable, "buffer");
        p31.f(charSequence, "separator");
        p31.f(charSequence2, "prefix");
        p31.f(charSequence3, "postfix");
        p31.f(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i2 = 0;
        for (Object obj : rm2Var) {
            i2++;
            if (i2 > 1) {
                appendable.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            kotlin.text.i.a(appendable, obj, ar0Var);
        }
        if (i >= 0 && i2 > i) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String s(rm2 rm2Var, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, ar0 ar0Var) {
        p31.f(rm2Var, "<this>");
        p31.f(charSequence, "separator");
        p31.f(charSequence2, "prefix");
        p31.f(charSequence3, "postfix");
        p31.f(charSequence4, "truncated");
        return ((StringBuilder) r(rm2Var, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, ar0Var)).toString();
    }

    public static /* synthetic */ String t(rm2 rm2Var, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, ar0 ar0Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        int i3 = i2 & 2;
        CharSequence charSequence5 = Constants.STR_EMPTY;
        CharSequence charSequence6 = i3 != 0 ? Constants.STR_EMPTY : charSequence2;
        if ((i2 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i2 & 8) != 0) {
            i = -1;
        }
        int i4 = i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            ar0Var = null;
        }
        return s(rm2Var, charSequence, charSequence6, charSequence5, i4, charSequence7, ar0Var);
    }

    public static Object u(rm2 rm2Var) {
        p31.f(rm2Var, "<this>");
        Iterator it = rm2Var.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static rm2 v(rm2 rm2Var, ar0 ar0Var) {
        p31.f(rm2Var, "<this>");
        p31.f(ar0Var, "transform");
        return new e53(rm2Var, ar0Var);
    }

    public static rm2 w(rm2 rm2Var, ar0 ar0Var) {
        p31.f(rm2Var, "<this>");
        p31.f(ar0Var, "transform");
        return p(new e53(rm2Var, ar0Var));
    }

    public static rm2 x(rm2 rm2Var, Comparator comparator) {
        p31.f(rm2Var, "<this>");
        p31.f(comparator, "comparator");
        return new b(rm2Var, comparator);
    }

    public static final Collection y(rm2 rm2Var, Collection collection) {
        p31.f(rm2Var, "<this>");
        p31.f(collection, "destination");
        Iterator it = rm2Var.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
        return collection;
    }

    public static List z(rm2 rm2Var) {
        p31.f(rm2Var, "<this>");
        Iterator it = rm2Var.iterator();
        if (!it.hasNext()) {
            return kotlin.collections.j.j();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return kotlin.collections.j.e(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
