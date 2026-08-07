package kotlin.collections;

import com.tencent.connect.common.Constants;
import defpackage.ar0;
import defpackage.d63;
import defpackage.ga2;
import defpackage.p31;
import defpackage.rm2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class t extends s {

    public static final class a implements rm2 {
        final /* synthetic */ Iterable a;

        public a(Iterable iterable) {
            this.a = iterable;
        }

        @Override // defpackage.rm2
        public Iterator iterator() {
            return this.a.iterator();
        }
    }

    public static rm2 C(Iterable iterable) {
        p31.f(iterable, "<this>");
        return new a(iterable);
    }

    public static boolean D(Iterable iterable, Object obj) {
        p31.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        return J(iterable, obj) >= 0;
    }

    public static List E(List list, int i) {
        p31.f(list, "<this>");
        if (i >= 0) {
            return V(list, ga2.b(list.size() - i, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
    }

    public static final Object F(Iterable iterable) {
        p31.f(iterable, "<this>");
        if (iterable instanceof List) {
            return j.G((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static Object G(List list) {
        p31.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object H(Iterable iterable) {
        p31.f(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static Object I(List list) {
        p31.f(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final int J(Iterable iterable, Object obj) {
        p31.f(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(obj);
        }
        int i = 0;
        for (Object obj2 : iterable) {
            if (i < 0) {
                j.s();
            }
            if (p31.a(obj, obj2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final Appendable K(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, ar0 ar0Var) throws IOException {
        p31.f(iterable, "<this>");
        p31.f(appendable, "buffer");
        p31.f(charSequence, "separator");
        p31.f(charSequence2, "prefix");
        p31.f(charSequence3, "postfix");
        p31.f(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i2 = 0;
        for (Object obj : iterable) {
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

    public static /* synthetic */ Appendable L(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, ar0 ar0Var, int i2, Object obj) {
        CharSequence charSequence5 = (i2 & 2) != 0 ? ", " : charSequence;
        int i3 = i2 & 4;
        CharSequence charSequence6 = Constants.STR_EMPTY;
        CharSequence charSequence7 = i3 != 0 ? Constants.STR_EMPTY : charSequence2;
        if ((i2 & 8) == 0) {
            charSequence6 = charSequence3;
        }
        return K(iterable, appendable, charSequence5, charSequence7, charSequence6, (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "..." : charSequence4, (i2 & 64) != 0 ? null : ar0Var);
    }

    public static final String M(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, ar0 ar0Var) {
        p31.f(iterable, "<this>");
        p31.f(charSequence, "separator");
        p31.f(charSequence2, "prefix");
        p31.f(charSequence3, "postfix");
        p31.f(charSequence4, "truncated");
        return ((StringBuilder) K(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, ar0Var)).toString();
    }

    public static /* synthetic */ String N(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, ar0 ar0Var, int i2, Object obj) {
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
        return M(iterable, charSequence, charSequence6, charSequence5, i4, charSequence7, ar0Var);
    }

    public static Object O(List list) {
        p31.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(j.l(list));
    }

    public static Comparable P(Iterable iterable) {
        p31.f(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) > 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static List Q(Collection collection, Iterable iterable) {
        p31.f(collection, "<this>");
        p31.f(iterable, "elements");
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            j.w(arrayList, iterable);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static List R(Collection collection, Object obj) {
        p31.f(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static Object S(Iterable iterable) {
        p31.f(iterable, "<this>");
        if (iterable instanceof List) {
            return T((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final Object T(List list) {
        p31.f(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static List U(Iterable iterable, Comparator comparator) {
        p31.f(iterable, "<this>");
        p31.f(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List listY = Y(iterable);
            j.v(listY, comparator);
            return listY;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return j.X(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        g.p(array, comparator);
        return d.c(array);
    }

    public static final List V(Iterable iterable, int i) {
        p31.f(iterable, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        }
        if (i == 0) {
            return j.j();
        }
        if (iterable instanceof Collection) {
            if (i >= ((Collection) iterable).size()) {
                return j.X(iterable);
            }
            if (i == 1) {
                return j.e(F(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i);
        Iterator it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i2++;
            if (i2 == i) {
                break;
            }
        }
        return l.p(arrayList);
    }

    public static final Collection W(Iterable iterable, Collection collection) {
        p31.f(iterable, "<this>");
        p31.f(collection, "destination");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
        return collection;
    }

    public static List X(Iterable iterable) {
        p31.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return l.p(Y(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return j.j();
        }
        if (size != 1) {
            return j.Z(collection);
        }
        return j.e(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static final List Y(Iterable iterable) {
        p31.f(iterable, "<this>");
        return iterable instanceof Collection ? j.Z((Collection) iterable) : (List) W(iterable, new ArrayList());
    }

    public static List Z(Collection collection) {
        p31.f(collection, "<this>");
        return new ArrayList(collection);
    }

    public static Set a0(Iterable iterable) {
        p31.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return d0.e((Set) W(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return b0.d();
        }
        if (size != 1) {
            return (Set) W(iterable, new LinkedHashSet(u.c(collection.size())));
        }
        return b0.c(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static List b0(Iterable iterable, Iterable iterable2) {
        p31.f(iterable, "<this>");
        p31.f(iterable2, "other");
        Iterator it = iterable.iterator();
        Iterator it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(j.t(iterable, 10), j.t(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(d63.a(it.next(), it2.next()));
        }
        return arrayList;
    }
}
