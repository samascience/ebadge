package defpackage;

import android.content.Context;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class vo3 {
    private Context a;
    private HashMap b = null;
    private a c = null;

    interface a {
        void a(Object obj);
    }

    protected vo3(Context context) {
        this.a = context;
    }

    private HashMap b(HashMap map) {
        HashMap map2 = new HashMap();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            String string = ((String) it.next()).toString();
            map2.put(string, map.get(string));
        }
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
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

    protected void e(HashMap map, a aVar) {
        this.b = b(map);
        this.c = aVar;
        new Thread(new cp3(this)).start();
    }
}
