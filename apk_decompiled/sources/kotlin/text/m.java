package kotlin.text;

import com.tencent.connect.common.Constants;
import defpackage.ar0;
import defpackage.p31;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class m extends j {
    private static final ar0 d(final String str) {
        return str.length() == 0 ? new ar0() { // from class: kotlin.text.k
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return m.e((String) obj);
            }
        } : new ar0() { // from class: kotlin.text.l
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return m.f(str, (String) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String e(String str) {
        p31.f(str, "line");
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String f(String str, String str2) {
        p31.f(str2, "line");
        return str + str2;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0019  */
    /* JADX WARN: Code duplicated, block: B:15:? A[RETURN, SYNTHETIC] */
    private static final int g(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (!b.c(str.charAt(i))) {
                if (i == -1) {
                    return str.length();
                }
                return i;
            }
            i++;
        }
        i = -1;
        if (i == -1) {
            return str.length();
        }
        return i;
    }

    public static final String h(String str, String str2) {
        String str3;
        p31.f(str, "<this>");
        p31.f(str2, "newIndent");
        List listF0 = w.f0(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listF0) {
            if (!i.Y((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.j.t(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(g((String) it.next())));
        }
        Integer num = (Integer) kotlin.collections.j.P(arrayList2);
        int i = 0;
        int iIntValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * listF0.size());
        ar0 ar0VarD = d(str2);
        int iL = kotlin.collections.j.l(listF0);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listF0) {
            int i2 = i + 1;
            if (i < 0) {
                kotlin.collections.j.s();
            }
            String str4 = (String) obj2;
            if ((i == 0 || i == iL) && i.Y(str4)) {
                str4 = null;
            } else {
                String strP0 = y.P0(str4, iIntValue);
                if (strP0 != null && (str3 = (String) ar0VarD.invoke(strP0)) != null) {
                    str4 = str3;
                }
            }
            if (str4 != null) {
                arrayList3.add(str4);
            }
            i = i2;
        }
        return ((StringBuilder) kotlin.collections.j.L(arrayList3, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
    }

    public static final String i(String str, String str2, String str3) {
        int i;
        String str4;
        p31.f(str, "<this>");
        p31.f(str2, "newIndent");
        p31.f(str3, "marginPrefix");
        if (i.Y(str3)) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        List listF0 = w.f0(str);
        int length = str.length() + (str2.length() * listF0.size());
        ar0 ar0VarD = d(str2);
        int iL = kotlin.collections.j.l(listF0);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : listF0) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.collections.j.s();
            }
            String str5 = (String) obj;
            String strSubstring = null;
            if ((i2 == 0 || i2 == iL) && i.Y(str5)) {
                str5 = null;
            } else {
                int length2 = str5.length();
                int i4 = 0;
                while (true) {
                    if (i4 >= length2) {
                        i = -1;
                        break;
                    }
                    if (!b.c(str5.charAt(i4))) {
                        i = i4;
                        break;
                    }
                    i4++;
                }
                if (i != -1) {
                    int i5 = i;
                    if (i.F(str5, str3, i, false, 4, null)) {
                        int length3 = i5 + str3.length();
                        p31.d(str5, "null cannot be cast to non-null type java.lang.String");
                        strSubstring = str5.substring(length3);
                        p31.e(strSubstring, "substring(...)");
                    }
                }
                if (strSubstring != null && (str4 = (String) ar0VarD.invoke(strSubstring)) != null) {
                    str5 = str4;
                }
            }
            if (str5 != null) {
                arrayList.add(str5);
            }
            i2 = i3;
        }
        return ((StringBuilder) kotlin.collections.j.L(arrayList, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
    }

    public static String j(String str) {
        p31.f(str, "<this>");
        return h(str, Constants.STR_EMPTY);
    }

    public static final String k(String str, String str2) {
        p31.f(str, "<this>");
        p31.f(str2, "marginPrefix");
        return i(str, Constants.STR_EMPTY, str2);
    }

    public static /* synthetic */ String l(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return k(str, str2);
    }
}
