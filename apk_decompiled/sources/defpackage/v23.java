package defpackage;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes.dex */
public abstract class v23 {
    private static final String a = System.getProperty("line.separator");

    public static String a(Throwable th) {
        List listB;
        ArrayList arrayList = new ArrayList();
        while (th != null && !arrayList.contains(th)) {
            arrayList.add(th);
            th = th.getCause();
        }
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        int i = size - 1;
        List listB2 = b((Throwable) arrayList.get(i));
        while (true) {
            int i2 = size - 1;
            if (i2 < 0) {
                break;
            }
            if (i2 != 0) {
                listB = b((Throwable) arrayList.get(size - 2));
                c(listB2, listB);
            } else {
                listB = listB2;
            }
            if (i2 == i) {
                arrayList2.add(((Throwable) arrayList.get(i2)).toString());
            } else {
                arrayList2.add(" Caused by: " + ((Throwable) arrayList.get(i2)).toString());
            }
            arrayList2.addAll(listB2);
            listB2 = listB;
            size = i2;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append(a);
        }
        return sb.toString();
    }

    private static List b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        StringTokenizer stringTokenizer = new StringTokenizer(stringWriter.toString(), a);
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            int iIndexOf = strNextToken.indexOf("at");
            if (iIndexOf != -1 && strNextToken.substring(0, iIndexOf).trim().isEmpty()) {
                arrayList.add(strNextToken);
                z = true;
            } else if (z) {
                break;
            }
        }
        return arrayList;
    }

    private static void c(List list, List list2) {
        int size = list.size() - 1;
        for (int size2 = list2.size() - 1; size >= 0 && size2 >= 0; size2--) {
            if (((String) list.get(size)).equals((String) list2.get(size2))) {
                list.remove(size);
            }
            size--;
        }
    }
}
