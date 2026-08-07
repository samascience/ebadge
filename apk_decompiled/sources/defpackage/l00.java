package defpackage;

import android.os.Build;
import android.util.Log;
import com.tencent.connect.common.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class l00 {
    public static String a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("service_mode")) {
                String string = jSONObject.getString("service_mode");
                Log.d("CommonUtils", "service_mode: " + string);
                if (string != "1") {
                    if (string == Constants.VIA_TO_TYPE_QZONE) {
                    }
                }
                Log.i("CommonUtils", "Will not obtain hardware information.");
                return str;
            }
            if (jSONObject.has("mode_type")) {
                String string2 = jSONObject.getString("mode_type");
                Log.d("CommonUtils", "mode_type: " + string2);
                if (string2 == "2") {
                    Log.i("CommonUtils", "Will not obtain hardware information.");
                    return str;
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("brand", Build.BRAND);
            jSONObject2.put("model", Build.MODEL);
            jSONObject.put("hardware_info", jSONObject2.toString());
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return Constants.STR_EMPTY;
        }
    }
}
