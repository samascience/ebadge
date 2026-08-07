package defpackage;

import com.fasterxml.jackson.core.JsonPointer;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class b1 {
    static it2 f;
    static final Set a = Collections.synchronizedSet(new HashSet());
    static final Set b = Collections.synchronizedSet(new HashSet());
    static final Set c = Collections.synchronizedSet(new HashSet());
    static final Set d = Collections.synchronizedSet(new HashSet());
    static boolean e = false;
    static boolean g = false;
    static boolean h = true;
    static boolean i = true;

    public static int a(StringBuilder sb, String str, int i2, StackTraceElement stackTraceElement, boolean z, boolean z2, String str2) {
        if (i2 <= 0) {
            return 0;
        }
        if (f == null) {
            throw new IllegalArgumentException("Stack trace element serializer not initialized.");
        }
        sb.append(str2);
        if (i2 == 1) {
            sb.append(f.b(stackTraceElement, z, z2));
            return 0;
        }
        sb.append(String.format("%s%s ... %d more", f.a(stackTraceElement), str, Integer.valueOf(i2 - 1)));
        if (!z2) {
            return 0;
        }
        sb.append(f.c(stackTraceElement));
        return 0;
    }

    public static boolean b(String str, Set set) {
        return c(str, set) != null;
    }

    public static String c(String str, Set set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (str.startsWith(str2)) {
                return str2;
            }
        }
        return null;
    }

    public static StackTraceElement[] d(w23 w23Var, int i2) {
        ArrayList arrayList = new ArrayList();
        if (w23Var != null) {
            jt2[] jt2VarArrD = w23Var.d();
            for (int i3 = 0; i3 < jt2VarArrD.length && i3 < i2; i3++) {
                arrayList.add(jt2VarArrD[i3].a());
            }
        }
        return (StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]);
    }

    public static StackTraceElement[] e(w23 w23Var, Set set, Set set2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (w23Var != null) {
            for (jt2 jt2Var : w23Var.d()) {
                String className = jt2Var.a().getClassName();
                if (!k(className)) {
                    if (b(className, set)) {
                        arrayList.addAll(arrayList2);
                        arrayList.add(jt2Var.a());
                    } else if (!b(className, set2)) {
                        arrayList2.add(jt2Var.a());
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(arrayList2);
        }
        return (StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]);
    }

    public static String f(w23 w23Var) {
        return h(w23Var, a, b, c, 0, e, g);
    }

    public static String g(w23 w23Var, String str, boolean z, boolean z2, Set set, Set set2, Set set3, int i2, boolean z3, boolean z4, boolean z5, boolean z6) {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        if (w23Var == null) {
            return Constants.STR_EMPTY;
        }
        String strB = w23Var.b();
        StackTraceElement[] stackTraceElementArrD = i2 > 0 ? d(w23Var, i2) : e(w23Var, set, set3);
        String strC = w23Var.c();
        if (k(strC)) {
            strC = w23Var.c();
        }
        if (z) {
            sb2.append(System.lineSeparator());
            sb2.append(str);
            sb2.append("Caused by: ");
        } else if (z2) {
            sb2.append(System.lineSeparator());
            sb2.append(str);
            sb2.append("Suppressed: ");
        }
        sb2.append(strB);
        if (!k(strC)) {
            sb2.append(": ");
            sb2.append(strC);
        }
        int length = stackTraceElementArrD.length;
        int i3 = 0;
        int i4 = 0;
        String str2 = null;
        StackTraceElement stackTraceElement = null;
        while (i4 < length) {
            StackTraceElement stackTraceElement2 = stackTraceElementArrD[i4];
            String strC2 = c(stackTraceElement2.getClassName(), set2);
            if (strC2 == null) {
                int iA = a(sb2, str2, i3, stackTraceElement, z5, z4, str);
                sb2.append(System.lineSeparator());
                sb2.append(str);
                sb2.append("\tat ");
                if (f == null) {
                    throw new IllegalArgumentException("Stack trace element serializer not initialized.");
                }
                sb2.append(str);
                sb2.append(f.b(stackTraceElement2, z5, z4));
                i3 = iA;
                str2 = null;
            } else if (strC2.equals(str2)) {
                i3++;
            } else {
                a(sb2, str2, i3, stackTraceElement, z5, z4, str);
                sb2.append(System.lineSeparator());
                sb2.append(str);
                sb2.append("\tat ");
                i3 = 1;
                stackTraceElement = stackTraceElement2;
                str2 = strC2;
            }
            i4++;
            stackTraceElementArrD = stackTraceElementArrD;
        }
        a(sb2, str2, i3, stackTraceElement, z5, z4, str);
        w23[] w23VarArrE = w23Var.e();
        if (w23VarArrE != null && w23VarArrE.length > 0 && z6) {
            int length2 = w23VarArrE.length;
            int i5 = 0;
            while (i5 < length2) {
                StringBuilder sb3 = sb2;
                sb3.append(g(w23VarArrE[i5], str + "\t", false, true, set, set2, set3, i2, z3, z4, z5, z6));
                i5++;
                strB = strB;
                sb2 = sb3;
            }
        }
        String str3 = strB;
        StringBuilder sb4 = sb2;
        w23 w23VarA = w23Var.a();
        if (w23VarA == null || b(str3, d) || z3) {
            sb = sb4;
        } else {
            sb = sb4;
            sb.append(g(w23VarA, str, true, false, set, set2, set3, i2, z3, z4, z5, z6));
        }
        return sb.toString();
    }

    public static String h(w23 w23Var, Set set, Set set2, Set set3, int i2, boolean z, boolean z2) {
        return i(w23Var, set, set2, set3, i2, z, z2, h);
    }

    public static String i(w23 w23Var, Set set, Set set2, Set set3, int i2, boolean z, boolean z2, boolean z3) {
        return j(w23Var, false, false, set, set2, set3, i2, z, z2, z3, i);
    }

    public static String j(w23 w23Var, boolean z, boolean z2, Set set, Set set2, Set set3, int i2, boolean z3, boolean z4, boolean z5, boolean z6) {
        return g(w23Var, Constants.STR_EMPTY, z, z2, set, set2, set3, i2, z3, z4, z5, z6);
    }

    public static boolean k(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String l(Class cls) {
        String string;
        int iLastIndexOf;
        if (cls == null) {
            return null;
        }
        try {
            URL resource = cls.getClassLoader().getResource(cls.getName().replace('.', JsonPointer.SEPARATOR) + ".class");
            if (resource == null || (iLastIndexOf = (string = resource.toString()).lastIndexOf(33)) <= 0) {
                return null;
            }
            String strSubstring = string.substring(0, iLastIndexOf);
            int iLastIndexOf2 = strSubstring.lastIndexOf(47);
            if (iLastIndexOf2 > 0) {
                strSubstring = strSubstring.substring(iLastIndexOf2 + 1);
            }
            int iLastIndexOf3 = strSubstring.lastIndexOf(92);
            return iLastIndexOf3 > 0 ? strSubstring.substring(iLastIndexOf3 + 1) : strSubstring;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String m(String str, String str2) {
        boolean z = str != null;
        boolean z2 = str2 != null;
        if (!z && !z2) {
            return Constants.STR_EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(" [");
        if (z) {
            sb.append(str);
        }
        if (z2) {
            if (!z) {
                sb.append(str2);
            } else if (!str.contains(str2)) {
                sb.append(":");
                sb.append(str2);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static String n(String str) {
        int iLastIndexOf;
        return (str != null && (iLastIndexOf = str.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR)) >= 0) ? str.substring(0, iLastIndexOf) : Constants.STR_EMPTY;
    }

    public static void o(String str) {
        a.add(str);
    }

    public static void p(it2 it2Var) {
        f = it2Var;
    }

    public static String q(ry1 ry1Var, Class cls, String str) {
        try {
            Package r0 = cls.getPackage();
            if (r0 != null) {
                return r0.getImplementationVersion();
            }
            Package packageA = ry1Var.a(cls.getClassLoader(), str);
            if (packageA != null) {
                return packageA.getImplementationVersion();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
