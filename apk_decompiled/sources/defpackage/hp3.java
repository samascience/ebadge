package defpackage;

import android.content.Context;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class hp3 {
    private Context a;
    private List b = null;
    private a c = null;

    interface a {
        void a(Object obj);
    }

    protected hp3(Context context) {
        this.a = context;
    }

    private List b(HashMap map, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (strArr == null || strArr.length <= 0) {
            HashMap map2 = new HashMap();
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                String string = ((String) it.next()).toString();
                map2.put(string, map.get(string));
            }
            arrayList.add(map2);
        } else {
            for (String str : strArr) {
                HashMap map3 = new HashMap();
                Iterator it2 = map.keySet().iterator();
                while (it2.hasNext()) {
                    String string2 = ((String) it2.next()).toString();
                    map3.put(string2, map.get(string2));
                }
                map3.put("mcode", str);
                arrayList.add(map3);
            }
        }
        return arrayList;
    }

    private void d(String str) {
        JSONObject jSONObject;
        if (str == null) {
            str = Constants.STR_EMPTY;
        }
        try {
            jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("status", -1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(jSONObject.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List list) throws Throwable {
        int i;
        ym3.b("syncConnect start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        if (list == null || list.size() == 0) {
            ym3.d("syncConnect failed,params list is null or size is 0");
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < list.size()) {
            ym3.b("syncConnect resuest " + i2 + "  start!!!");
            HashMap map = (HashMap) list.get(i2);
            sp3 sp3Var = new sp3(this.a);
            if (sp3Var.d()) {
                String strB = sp3Var.b(map);
                if (strB == null) {
                    strB = Constants.STR_EMPTY;
                }
                ym3.b("syncConnect resuest " + i2 + "  result:" + strB);
                arrayList.add(strB);
                try {
                    JSONObject jSONObject = new JSONObject(strB);
                    if (jSONObject.has("status") && jSONObject.getInt("status") == 0) {
                        ym3.b("auth end and break");
                        d(strB);
                        return;
                    }
                } catch (JSONException unused) {
                    ym3.b("continue-------------------------------");
                }
            } else {
                ym3.b("Current network is not available.");
                arrayList.add(ai0.b("Current network is not available."));
            }
            ym3.b("syncConnect end");
            i2++;
        }
        ym3.b("--iiiiii:" + i2 + "<><>paramList.size():" + list.size() + "<><>authResults.size():" + arrayList.size());
        if (list.size() <= 0 || i2 != list.size() || arrayList.size() <= 0 || i2 != arrayList.size() || (i = i2 - 1) <= 0) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject((String) arrayList.get(i));
            if (!jSONObject2.has("status") || jSONObject2.getInt("status") == 0) {
                return;
            }
            ym3.b("i-1 result is not 0,return first result");
            d((String) arrayList.get(0));
        } catch (JSONException e) {
            d(ai0.b("JSONException:" + e.getMessage()));
        }
    }

    protected void e(HashMap map, String[] strArr, a aVar) {
        this.b = b(map, strArr);
        this.c = aVar;
        new Thread(new op3(this)).start();
    }
}
