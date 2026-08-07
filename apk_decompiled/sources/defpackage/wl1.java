package defpackage;

import com.google.gson.internal.LinkedTreeMap;
import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import u33.a;

/* JADX INFO: loaded from: classes.dex */
public class wl1 extends e63 {
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
            if (linkedTreeMap2.containsKey("output")) {
                aVar.g(linkedTreeMap2.get("output").toString());
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

    private void i(a81 a81Var, Map map) throws IOException {
        if (map != null) {
            a81Var.y();
            for (Map.Entry entry : map.entrySet()) {
                a81Var.k0((String) entry.getKey());
                k(a81Var, entry.getValue());
            }
            a81Var.V();
        }
    }

    private void j(a81 a81Var, t33 t33Var) throws IOException {
        a81Var.y();
        a81Var.k0("id").P0(t33Var.a());
        a81Var.k0(SocialConstants.PARAM_TYPE).P0(t33Var.d());
        if (t33Var.b() != null) {
            a81Var.k0("index").O0(t33Var.b());
        }
        if (t33Var instanceof u33) {
            u33.a aVarG = ((u33) t33Var).g();
            a81Var.k0("function").y();
            if (aVarG != null) {
                a81Var.k0("name").P0(aVarG.c());
                a81Var.k0("arguments").P0(aVarG.b());
                a81Var.k0("output").P0(aVarG.d());
            }
            a81Var.V();
        }
        a81Var.V();
    }

    private void k(a81 a81Var, Object obj) throws IOException {
        if (obj == null) {
            a81Var.t0();
            return;
        }
        if (obj instanceof String) {
            a81Var.P0((String) obj);
            return;
        }
        if (obj instanceof Integer) {
            a81Var.O0((Integer) obj);
            return;
        }
        if (obj instanceof Long) {
            a81Var.O0((Long) obj);
            return;
        }
        if (obj instanceof Double) {
            a81Var.O0((Double) obj);
            return;
        }
        if (obj instanceof Float) {
            a81Var.O0((Float) obj);
            return;
        }
        if (obj instanceof Boolean) {
            a81Var.N0((Boolean) obj);
            return;
        }
        if (obj instanceof Character) {
            a81Var.M0(((Character) obj).charValue());
            return;
        }
        if (!(obj instanceof List)) {
            if (obj instanceof Map) {
                i(a81Var, (Map) obj);
                return;
            } else {
                a81Var.P0(obj.toString());
                return;
            }
        }
        a81Var.w();
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            k(a81Var, it.next());
        }
        a81Var.D();
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00d8  */
    @Override // defpackage.e63
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public vl1 b(a71 a71Var) {
        Map map = (Map) t71.a.fromJson(a71Var, Map.class);
        vl1 vl1Var = new vl1();
        if (map.containsKey("role")) {
            vl1Var.m((String) map.get("role"));
            map.remove("role");
        }
        if (map.containsKey("content")) {
            Object obj = map.get("content");
            if (obj instanceof String) {
                vl1Var.j(Arrays.asList(Collections.singletonMap("text", (String) obj)));
            } else {
                vl1Var.j((List) obj);
            }
            map.remove("content");
        }
        if (map.containsKey("annotations")) {
            vl1Var.i((List) map.get("annotations"));
            map.remove("annotations");
        }
        if (map.containsKey("reasoning_content")) {
            vl1Var.l((String) map.get("reasoning_content"));
            map.remove("reasoning_content");
        }
        if (map.containsKey("tool_calls")) {
            Object obj2 = map.get("tool_calls");
            if (obj2 instanceof List) {
                List list = (List) obj2;
                if (list.isEmpty() || !(list.get(0) instanceof LinkedTreeMap)) {
                    vl1Var.o(list);
                } else {
                    LinkedTreeMap linkedTreeMap = (LinkedTreeMap) list.get(0);
                    if (linkedTreeMap.containsKey(SocialConstants.PARAM_TYPE) && linkedTreeMap.get(SocialConstants.PARAM_TYPE).toString().equals("function")) {
                        vl1Var.toolCalls = new ArrayList();
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            vl1Var.toolCalls.add(f((LinkedTreeMap) it.next()));
                        }
                    } else {
                        vl1Var.o(list);
                    }
                }
            }
            map.remove("tool_calls");
        }
        if (map.containsKey("tool_call_id")) {
            vl1Var.n((String) map.get("tool_call_id"));
            map.remove("tool_call_id");
        }
        if (map.containsKey("name")) {
            vl1Var.k((String) map.get("name"));
            map.remove("name");
        }
        return vl1Var;
    }

    @Override // defpackage.e63
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void e(a81 a81Var, vl1 vl1Var) throws IOException {
        a81Var.y();
        a81Var.k0("role");
        a81Var.P0(vl1Var.f());
        a81Var.k0("content");
        a81Var.w();
        Iterator it = vl1Var.c().iterator();
        while (it.hasNext()) {
            i(a81Var, (Map) it.next());
        }
        a81Var.D();
        if (vl1Var.b() != null) {
            a81Var.k0("annotations");
            a81Var.w();
            Iterator it2 = vl1Var.b().iterator();
            while (it2.hasNext()) {
                i(a81Var, (Map) it2.next());
            }
            a81Var.D();
        }
        if (vl1Var.e() != null) {
            a81Var.k0("reasoning_content");
            a81Var.P0(vl1Var.e());
        }
        if (vl1Var.h() != null) {
            a81Var.k0("tool_calls");
            a81Var.w();
            for (t33 t33Var : (t33[]) t71.fromJson(t71.toJson(vl1Var.h()), t33[].class)) {
                j(a81Var, t33Var);
            }
            a81Var.D();
        }
        if (vl1Var.g() != null) {
            a81Var.k0("tool_call_id");
            a81Var.P0(vl1Var.g());
        }
        if (vl1Var.d() != null) {
            a81Var.k0("name");
            a81Var.P0(vl1Var.d());
        }
        a81Var.V();
    }
}
