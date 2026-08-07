package defpackage;

import com.google.gson.internal.LinkedTreeMap;
import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import u33.a;

/* JADX INFO: loaded from: classes.dex */
public class yi1 extends e63 {
    private u33 f(LinkedTreeMap linkedTreeMap) {
        u33 u33Var = new u33();
        if (linkedTreeMap.containsKey("function")) {
            u33.a aVar = u33Var.new a();
            LinkedTreeMap linkedTreeMap2 = (LinkedTreeMap) linkedTreeMap.get("function");
            if (linkedTreeMap2.containsKey("name")) {
                aVar.f(linkedTreeMap2.get("name").toString());
            }
            if (linkedTreeMap2.containsKey("arguments")) {
                aVar.e(linkedTreeMap2.get("arguments").toString());
            }
            u33Var.h(aVar);
        }
        u33Var.k(linkedTreeMap.get(SocialConstants.PARAM_TYPE).toString());
        if (linkedTreeMap.containsKey("id")) {
            u33Var.i(linkedTreeMap.get("id").toString());
        }
        if (linkedTreeMap.containsKey("index")) {
            Object obj = linkedTreeMap.get("index");
            if (obj instanceof Number) {
                u33Var.j(Integer.valueOf(((Number) obj).intValue()));
            }
        }
        return u33Var;
    }

    private List g(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            LinkedTreeMap linkedTreeMap = (LinkedTreeMap) it.next();
            String str = (String) linkedTreeMap.get(SocialConstants.PARAM_TYPE);
            if ("text".equals(str)) {
                arrayList.add(i(linkedTreeMap));
            } else if ("image_url".equals(str)) {
                arrayList.add(h(linkedTreeMap));
            }
        }
        return arrayList;
    }

    private bj1 h(LinkedTreeMap linkedTreeMap) {
        LinkedTreeMap linkedTreeMap2 = (LinkedTreeMap) linkedTreeMap.get("image_url");
        b11.b bVarF = b11.a().f((String) linkedTreeMap2.get(SocialConstants.PARAM_URL));
        if (linkedTreeMap2.containsKey("detail")) {
            bVarF.d((String) linkedTreeMap2.get("detail"));
        }
        return bj1.d().g((String) linkedTreeMap.get(SocialConstants.PARAM_TYPE)).e(bVarF.c()).d();
    }

    private cj1 i(LinkedTreeMap linkedTreeMap) {
        cj1.c cVarH = cj1.d().i((String) linkedTreeMap.get(SocialConstants.PARAM_TYPE)).h((String) linkedTreeMap.get("text"));
        if (linkedTreeMap.containsKey("cache_control")) {
            LinkedTreeMap linkedTreeMap2 = (LinkedTreeMap) linkedTreeMap.get("cache_control");
            cj1.b.a aVarF = cj1.b.a().f((String) linkedTreeMap2.get(SocialConstants.PARAM_TYPE));
            if (linkedTreeMap2.containsKey("ttl")) {
                Object obj = linkedTreeMap2.get("ttl");
                aVarF.e(obj instanceof Number ? String.valueOf(((Number) obj).intValue()) : String.valueOf(obj));
            }
            cVarH.f(aVarF.c());
        }
        return cVarH.e();
    }

    private void l(a81 a81Var, u33 u33Var) throws IOException {
        a81Var.y();
        u33.a aVarG = u33Var.g();
        a81Var.k0("name");
        a81Var.P0(aVarG.c());
        a81Var.k0("arguments");
        a81Var.P0(aVarG.b());
        a81Var.V();
    }

    @Override // defpackage.e63
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public xi1 b(a71 a71Var) {
        Map map = (Map) t71.a.fromJson(a71Var, Map.class);
        xi1 xi1Var = new xi1();
        if (map.containsKey("role")) {
            xi1Var.n((String) map.get("role"));
            map.remove("role");
        }
        if (map.containsKey("content")) {
            Object obj = map.get("content");
            if (obj instanceof String) {
                xi1Var.k((String) obj);
            } else if (obj instanceof List) {
                xi1Var.l(g((List) obj));
            }
            map.remove("content");
        }
        if (map.containsKey("reasoning_content")) {
            xi1Var.m((String) map.get("reasoning_content"));
            map.remove("reasoning_content");
        }
        if (map.containsKey("tool_calls")) {
            xi1Var.toolCalls = new ArrayList();
            List<LinkedTreeMap> arrayList = (List) map.get("tool_calls");
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            for (LinkedTreeMap linkedTreeMap : arrayList) {
                if (linkedTreeMap.get(SocialConstants.PARAM_TYPE).toString().equals("function")) {
                    xi1Var.toolCalls.add(f(linkedTreeMap));
                }
            }
            map.remove("tool_calls");
        }
        return xi1Var;
    }

    @Override // defpackage.e63
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void e(a81 a81Var, xi1 xi1Var) throws IOException {
        a81Var.y();
        a81Var.k0("role");
        a81Var.P0(xi1Var.h());
        if (xi1Var.c() != null) {
            a81Var.k0("content");
            a81Var.P0(xi1Var.c());
        }
        if (xi1Var.d() != null) {
            a81Var.k0("content").w();
            for (zi1 zi1Var : xi1Var.d()) {
                if (zi1Var.b().equals("text")) {
                    cj1 cj1Var = (cj1) zi1Var;
                    a81Var.y();
                    a81Var.k0(SocialConstants.PARAM_TYPE);
                    a81Var.P0("text");
                    a81Var.k0("text");
                    a81Var.P0(cj1Var.f());
                    if (cj1Var.e() != null) {
                        a81Var.k0("cache_control");
                        a81Var.y();
                        a81Var.k0(SocialConstants.PARAM_TYPE);
                        a81Var.P0(cj1Var.e().d());
                        a81Var.k0("ttl");
                        a81Var.P0(cj1Var.e().c());
                        a81Var.V();
                    }
                    a81Var.V();
                } else if (zi1Var.b().equals("image_url")) {
                    a81Var.y();
                    a81Var.k0(SocialConstants.PARAM_TYPE);
                    a81Var.P0("image_url");
                    a81Var.k0("image_url");
                    a81Var.y();
                    a81Var.k0(SocialConstants.PARAM_URL);
                    b11 b11VarE = ((bj1) zi1Var).e();
                    a81Var.P0(b11VarE.d());
                    if (b11VarE.c() != null) {
                        a81Var.k0("detail");
                        a81Var.P0(b11VarE.c());
                    }
                    a81Var.V();
                    a81Var.V();
                }
            }
            a81Var.D();
        }
        if (xi1Var.g() != null) {
            a81Var.k0("reasoning_content");
            a81Var.P0(xi1Var.g());
        }
        if (xi1Var.j() != null) {
            a81Var.k0("tool_calls").w();
            for (t33 t33Var : xi1Var.j()) {
                a81Var.y();
                String strD = t33Var.d();
                a81Var.k0(SocialConstants.PARAM_TYPE);
                a81Var.P0(strD);
                a81Var.k0("id");
                a81Var.P0(t33Var.a());
                a81Var.k0("index");
                a81Var.O0(t33Var.b());
                a81Var.k0("function");
                if (strD.equals("function")) {
                    l(a81Var, (u33) t33Var);
                }
                a81Var.V();
            }
            a81Var.D();
        }
        if (xi1Var.i() != null) {
            a81Var.k0("tool_call_id");
            a81Var.P0(xi1Var.i());
        }
        if (xi1Var.e() != null) {
            a81Var.k0("name");
            a81Var.P0(xi1Var.e());
        }
        if (xi1Var.f() != null) {
            a81Var.k0("partial");
            a81Var.N0(xi1Var.f());
        }
        a81Var.V();
    }
}
