package defpackage;

import com.tencent.open.SocialConstants;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.u;
import kotlin.text.i;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public abstract class mx0 {
    private static final ByteString a;
    private static final ByteString b;

    static {
        ByteString.a aVar = ByteString.Companion;
        a = aVar.d("\"\\");
        b = aVar.d("\t ,=");
    }

    public static final List a(iw0 iw0Var, String str) {
        p31.f(iw0Var, "<this>");
        p31.f(str, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = iw0Var.size();
        for (int i = 0; i < size; i++) {
            if (i.v(str, iw0Var.b(i), true)) {
                try {
                    c(new fo().S(iw0Var.g(i)), arrayList);
                } catch (EOFException e) {
                    r32.a.g().j("Unable to parse challenge", 5, e);
                }
            }
        }
        return arrayList;
    }

    public static final boolean b(eh2 eh2Var) {
        p31.f(eh2Var, "<this>");
        if (p31.a(eh2Var.G0().g(), "HEAD")) {
            return false;
        }
        int iC = eh2Var.C();
        return (((iC >= 100 && iC < 200) || iC == 204 || iC == 304) && pa3.v(eh2Var) == -1 && !i.v("chunked", eh2.g0(eh2Var, "Transfer-Encoding", null, 2, null), true)) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0083  */
    /* JADX WARN: Code duplicated, block: B:35:0x0096  */
    /* JADX WARN: Code duplicated, block: B:36:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ba A[EDGE_INSN: B:59:0x00ba->B:48:0x00ba BREAK  A[LOOP:2: B:22:0x0071->B:47:0x00b8], SYNTHETIC] */
    private static final void c(fo foVar, List list) throws EOFException {
        String strE;
        while (true) {
            String strE2 = null;
            while (true) {
                if (strE2 == null) {
                    g(foVar);
                    strE2 = e(foVar);
                    if (strE2 == null) {
                        return;
                    }
                }
                boolean zG = g(foVar);
                String strE3 = e(foVar);
                if (strE3 == null) {
                    if (foVar.H()) {
                        list.add(new ax(strE2, u.f()));
                        return;
                    }
                    return;
                }
                int iK = pa3.K(foVar, (byte) 61);
                boolean zG2 = g(foVar);
                if (zG || !(zG2 || foVar.H())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int iK2 = iK + pa3.K(foVar, (byte) 61);
                    while (true) {
                        if (strE3 != null) {
                            if (iK2 != 0) {
                                break;
                                break;
                            }
                            if (iK2 <= 1) {
                                return;
                            }
                            if (h(foVar, (byte) 34)) {
                                strE = d(foVar);
                            } else {
                                strE = e(foVar);
                            }
                            if (strE != null) {
                                return;
                            }
                            if (g(foVar)) {
                            }
                            strE3 = null;
                        } else {
                            strE3 = e(foVar);
                            if (!g(foVar)) {
                                iK2 = pa3.K(foVar, (byte) 61);
                                if (iK2 != 0) {
                                    break;
                                }
                                if (iK2 <= 1 || g(foVar)) {
                                    return;
                                }
                                if (h(foVar, (byte) 34)) {
                                    strE = d(foVar);
                                } else {
                                    strE = e(foVar);
                                }
                                if (strE != null || ((String) linkedHashMap.put(strE3, strE)) != null) {
                                    return;
                                }
                                if (g(foVar) && !foVar.H()) {
                                    return;
                                } else {
                                    strE3 = null;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    list.add(new ax(strE2, linkedHashMap));
                    strE2 = strE3;
                } else {
                    Map mapSingletonMap = Collections.singletonMap(null, strE3 + i.y("=", iK));
                    p31.e(mapSingletonMap, "singletonMap<String, Str…ek + \"=\".repeat(eqCount))");
                    list.add(new ax(strE2, mapSingletonMap));
                }
            }
        }
    }

    private static final String d(fo foVar) throws EOFException {
        if (foVar.readByte() != 34) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        fo foVar2 = new fo();
        while (true) {
            long jK = foVar.K(a);
            if (jK == -1) {
                return null;
            }
            if (foVar.e0(jK) == 34) {
                foVar2.b0(foVar, jK);
                foVar.readByte();
                return foVar2.G0();
            }
            if (foVar.size() == jK + 1) {
                return null;
            }
            foVar2.b0(foVar, jK);
            foVar.readByte();
            foVar2.b0(foVar, 1L);
        }
    }

    private static final String e(fo foVar) {
        long jK = foVar.K(b);
        if (jK == -1) {
            jK = foVar.size();
        }
        if (jK != 0) {
            return foVar.s(jK);
        }
        return null;
    }

    public static final void f(i40 i40Var, tx0 tx0Var, iw0 iw0Var) {
        p31.f(i40Var, "<this>");
        p31.f(tx0Var, SocialConstants.PARAM_URL);
        p31.f(iw0Var, "headers");
        if (i40Var == i40.b) {
            return;
        }
        List listE = h40.j.e(tx0Var, iw0Var);
        if (listE.isEmpty()) {
            return;
        }
        i40Var.a(tx0Var, listE);
    }

    private static final boolean g(fo foVar) throws EOFException {
        boolean z = false;
        while (!foVar.H()) {
            byte bE0 = foVar.e0(0L);
            if (bE0 == 44) {
                foVar.readByte();
                z = true;
            } else {
                if (bE0 != 32 && bE0 != 9) {
                    break;
                }
                foVar.readByte();
            }
        }
        return z;
    }

    private static final boolean h(fo foVar, byte b2) {
        return !foVar.H() && foVar.e0(0L) == b2;
    }
}
