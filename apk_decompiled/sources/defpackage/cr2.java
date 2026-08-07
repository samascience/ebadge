package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.j;
import kotlin.collections.u;
import kotlin.text.i;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: loaded from: classes4.dex */
public final class cr2 {
    public static final cr2 a = new cr2();
    private static volatile Map b = u.f();
    private static volatile Map c = u.f();
    private static volatile String d;

    private cr2() {
    }

    public final boolean a(String str) {
        Set<Map.Entry> setO;
        if (str == null || i.Y(str)) {
            return false;
        }
        try {
            o61 o61VarC = r61.c(i.O0(str).toString()).c();
            o61 o61VarQ = o61VarC.q("languageName");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (o61VarQ != null && (setO = o61VarQ.o()) != null) {
                for (Map.Entry entry : setO) {
                    p31.c(entry);
                    linkedHashMap.put((String) entry.getKey(), ((u51) entry.getValue()).e());
                }
            }
            o61 o61VarQ2 = o61VarC.q("languageList");
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            if (o61VarQ2 != null && o61VarQ2.size() > 0) {
                Set<Map.Entry> setO2 = o61VarQ2.o();
                if (setO2 != null) {
                    for (Map.Entry entry2 : setO2) {
                        p31.c(entry2);
                        String str2 = (String) entry2.getKey();
                        u51 u51Var = (u51) entry2.getValue();
                        if (u51Var.f()) {
                            l51 l51VarB = u51Var.b();
                            p31.e(l51VarB, "getAsJsonArray(...)");
                            ArrayList arrayList = new ArrayList(j.t(l51VarB, 10));
                            Iterator it = l51VarB.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((u51) it.next()).e());
                            }
                            linkedHashMap2.put(str2, arrayList);
                        }
                    }
                }
            } else if (!linkedHashMap.isEmpty()) {
                Set setKeySet = linkedHashMap.keySet();
                p31.e(setKeySet, "<get-keys>(...)");
                List<String> listX = j.X(setKeySet);
                for (String str3 : listX) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : listX) {
                        if (!p31.a((String) obj, str3)) {
                            arrayList2.add(obj);
                        }
                    }
                    linkedHashMap2.put(str3, arrayList2);
                }
            }
            if (linkedHashMap.isEmpty() || linkedHashMap2.isEmpty()) {
                return false;
            }
            c = linkedHashMap;
            b = linkedHashMap2;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final String b(String str) {
        p31.f(str, "code");
        return (String) c.get(str);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0088 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x009c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x00a8 A[ORIG_RETURN, RETURN] */
    public final String c(String str) {
        Object next;
        p31.f(str, "displayName");
        String string = i.O0(str).toString();
        Iterator it = c.entrySet().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!p31.a(((Map.Entry) next).getValue(), string));
        Map.Entry entry = (Map.Entry) next;
        String str2 = entry != null ? (String) entry.getKey() : null;
        if (str2 != null) {
            return str2;
        }
        switch (string) {
            case "Chinese":
                return "zh";
            case "Cantonese":
                return "yue";
            case "中文（普通话）":
                return "zh";
            case "English (UK)":
                return "en";
            case "中文":
                return "zh";
            case "粤语":
            case "粵語":
                return "yue";
            case "英语":
                return "en";
            case "普通话":
                return "zh";
            case "English":
                return "en";
            default:
                return null;
        }
    }

    public final Pair d() {
        String str;
        String str2;
        String str3;
        String str4 = (String) j.I(i());
        if (str4 == null || (str = (String) j.I(j(str4))) == null || (str2 = (String) c.get(str4)) == null || (str3 = (String) c.get(str)) == null) {
            return null;
        }
        return d63.a(str2, str3);
    }

    public final String e() {
        return d;
    }

    public final boolean f(String str, String str2) {
        List list;
        p31.f(str, "sourceCode");
        p31.f(str2, "targetCode");
        return (p31.a(str, str2) || (list = (List) b.get(str)) == null || !list.contains(str2)) ? false : true;
    }

    public final boolean g(String str, String str2) {
        String strC;
        p31.f(str, "sourceDisplay");
        p31.f(str2, "targetDisplay");
        String strC2 = c(str);
        if (strC2 == null || (strC = c(str2)) == null) {
            return false;
        }
        return f(strC2, strC);
    }

    public final void h(String str) {
        d = str;
    }

    public final List i() {
        Set setKeySet = c.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (b.containsKey((String) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final List j(String str) {
        p31.f(str, "sourceCode");
        List list = (List) b.get(str);
        if (list == null) {
            return j.j();
        }
        Set setKeySet = c.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (list.contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final ea1 k(String str) {
        p31.f(str, "code");
        String str2 = (String) c.get(str);
        if (str2 == null) {
            return null;
        }
        return new ea1(str2, str2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:49:0x0096 A[RETURN, SYNTHETIC] */
    public final String l(String str) {
        p31.f(str, "displayName");
        String strC = c(str);
        if (strC == null) {
            return null;
        }
        switch (strC) {
            case "de":
                return "German";
            case "en":
                return "English";
            case "es":
                return "Spanish";
            case "fr":
                return "French";
            case "it":
                return "Italian";
            case "ja":
                return "Japanese";
            case "ko":
                return "Korean";
            case "pt":
                return "Portuguese";
            case "ru":
                return "Russian";
            case "zh":
                return "Chinese";
            case "yue":
                return "Chinese";
            default:
                return DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
        }
    }
}
