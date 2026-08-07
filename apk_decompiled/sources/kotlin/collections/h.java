package kotlin.collections;

import com.tencent.connect.common.Constants;
import defpackage.ar0;
import defpackage.k81;
import defpackage.p31;
import defpackage.t9;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class h extends g {

    public static final class a implements Iterable, k81 {
        final /* synthetic */ Object[] a;

        public a(Object[] objArr) {
            this.a = objArr;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return t9.a(this.a);
        }
    }

    public static char A(char[] cArr) {
        p31.f(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static Object B(Object[] objArr) {
        p31.f(objArr, "<this>");
        if (objArr.length == 1) {
            return objArr[0];
        }
        return null;
    }

    public static final Collection C(Object[] objArr, Collection collection) {
        p31.f(objArr, "<this>");
        p31.f(collection, "destination");
        for (Object obj : objArr) {
            collection.add(obj);
        }
        return collection;
    }

    public static List D(Object[] objArr) {
        p31.f(objArr, "<this>");
        int length = objArr.length;
        if (length != 0) {
            return length != 1 ? d.E(objArr) : j.e(objArr[0]);
        }
        return j.j();
    }

    public static List E(Object[] objArr) {
        p31.f(objArr, "<this>");
        return new ArrayList(l.g(objArr));
    }

    public static final Set F(Object[] objArr) {
        p31.f(objArr, "<this>");
        int length = objArr.length;
        if (length != 0) {
            return length != 1 ? (Set) C(objArr, new LinkedHashSet(u.c(objArr.length))) : b0.c(objArr[0]);
        }
        return b0.d();
    }

    public static Iterable q(Object[] objArr) {
        p31.f(objArr, "<this>");
        return objArr.length == 0 ? j.j() : new a(objArr);
    }

    public static boolean r(Object[] objArr, Object obj) {
        p31.f(objArr, "<this>");
        return w(objArr, obj) >= 0;
    }

    public static List s(Object[] objArr) {
        p31.f(objArr, "<this>");
        return (List) t(objArr, new ArrayList());
    }

    public static final Collection t(Object[] objArr, Collection collection) {
        p31.f(objArr, "<this>");
        p31.f(collection, "destination");
        for (Object obj : objArr) {
            if (obj != null) {
                collection.add(obj);
            }
        }
        return collection;
    }

    public static int u(Object[] objArr) {
        p31.f(objArr, "<this>");
        return objArr.length - 1;
    }

    public static Object v(Object[] objArr, int i) {
        p31.f(objArr, "<this>");
        if (i < 0 || i >= objArr.length) {
            return null;
        }
        return objArr[i];
    }

    public static final int w(Object[] objArr, Object obj) {
        p31.f(objArr, "<this>");
        int i = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i < length) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i < length2) {
            if (p31.a(obj, objArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final Appendable x(byte[] bArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, ar0 ar0Var) throws IOException {
        p31.f(bArr, "<this>");
        p31.f(appendable, "buffer");
        p31.f(charSequence, "separator");
        p31.f(charSequence2, "prefix");
        p31.f(charSequence3, "postfix");
        p31.f(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i2 = 0;
        for (byte b : bArr) {
            i2++;
            if (i2 > 1) {
                appendable.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (ar0Var != null) {
                appendable.append((CharSequence) ar0Var.invoke(Byte.valueOf(b)));
            } else {
                appendable.append(String.valueOf((int) b));
            }
        }
        if (i >= 0 && i2 > i) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String y(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, ar0 ar0Var) {
        p31.f(bArr, "<this>");
        p31.f(charSequence, "separator");
        p31.f(charSequence2, "prefix");
        p31.f(charSequence3, "postfix");
        p31.f(charSequence4, "truncated");
        return ((StringBuilder) x(bArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, ar0Var)).toString();
    }

    public static /* synthetic */ String z(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, ar0 ar0Var, int i2, Object obj) {
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
        return y(bArr, charSequence, charSequence6, charSequence5, i4, charSequence7, ar0Var);
    }
}
