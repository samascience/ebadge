package defpackage;

import com.tencent.connect.common.Constants;
import java.util.Iterator;
import kotlin.Result;
import kotlin.collections.j;
import kotlin.d;
import kotlin.text.i;
import org.json.JSONObject;
import xfkj.fitpro.ui.activities.device.electronicBadgeDevice.AiAccessNative;

/* JADX INFO: loaded from: classes4.dex */
public final class c5 {
    public static final c5 a = new c5();

    private c5() {
    }

    private final String c(String str) {
        Object objM69constructorimpl;
        String strOptString;
        String string = i.O0(str).toString();
        if (!i.G(string, "{", false, 2, null)) {
            return string;
        }
        try {
            Result.a aVar = Result.Companion;
            JSONObject jSONObject = new JSONObject(string);
            Iterator it = j.m("token", "apiKey", "api_key", "accessKey", Constants.PARAM_ACCESS_TOKEN, "dashScopeApiKey").iterator();
            do {
                if (!it.hasNext()) {
                    strOptString = null;
                    break;
                }
                strOptString = jSONObject.optString((String) it.next());
                p31.c(strOptString);
                if (strOptString.length() <= 0) {
                    strOptString = null;
                }
            } while (strOptString == null);
            objM69constructorimpl = Result.m69constructorimpl(strOptString);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            objM69constructorimpl = Result.m69constructorimpl(d.a(th));
        }
        String str2 = (String) (Result.m75isFailureimpl(objM69constructorimpl) ? null : objM69constructorimpl);
        return str2 == null ? string : str2;
    }

    private final String d(JSONObject jSONObject, String... strArr) {
        String str;
        int length = strArr.length;
        int i = 0;
        while (true) {
            str = null;
            if (i >= length) {
                break;
            }
            String strOptString = jSONObject.optString(strArr[i]);
            p31.c(strOptString);
            str = strOptString.length() > 0 ? strOptString : null;
            if (str != null) {
                break;
            }
            i++;
        }
        return str;
    }

    private final Long e(JSONObject jSONObject, String... strArr) {
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                return null;
            }
            String str = strArr[i];
            if (jSONObject.has(str) && !jSONObject.isNull(str)) {
                long jOptLong = jSONObject.optLong(str, -1L);
                if (jOptLong > 0) {
                    return Long.valueOf(jOptLong);
                }
                String strOptString = jSONObject.optString(str);
                p31.e(strOptString, "optString(...)");
                Long lO = i.o(i.O0(strOptString).toString());
                if (lO == null) {
                    continue;
                } else {
                    Long l = lO.longValue() > 0 ? lO : null;
                    if (l != null) {
                        return Long.valueOf(l.longValue());
                    }
                }
            }
            i++;
        }
    }

    private final d5 f(String str) {
        Object objM69constructorimpl;
        String strC = c(str);
        String string = i.O0(str).toString();
        if (!i.G(string, "{", false, 2, null)) {
            return new d5(strC, null, null, null, null, null);
        }
        try {
            Result.a aVar = Result.Companion;
            JSONObject jSONObject = new JSONObject(string);
            objM69constructorimpl = Result.m69constructorimpl(new d5(strC, d(jSONObject, "translateUrl", "translate_url"), d(jSONObject, "multimodalWsUrl", "multimodal_ws_url", "wsUrl", "ws_url", "bailianMultimodalWsUrl", "bailian_multimodal_ws_url"), d(jSONObject, "workspaceId", "workspace_id", "bailianWorkspaceId", "bailian_workspace_id"), d(jSONObject, "appId", Constants.JumpUrlConstants.URL_KEY_APPID, "bailianAppId", "bailian_app_id"), e(jSONObject, "expires_at", "expiresAt")));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            objM69constructorimpl = Result.m69constructorimpl(d.a(th));
        }
        if (Result.m72exceptionOrNullimpl(objM69constructorimpl) != null) {
            objM69constructorimpl = new d5(strC, null, null, null, null, null);
        }
        return (d5) objM69constructorimpl;
    }

    public final d5 a(String str, String str2) {
        p31.f(str, "encryptedKeyB64");
        p31.f(str2, "encryptedDataB64");
        return f(b(str, str2));
    }

    public final String b(String str, String str2) {
        p31.f(str, "encryptedKeyB64");
        p31.f(str2, "encryptedDataB64");
        return AiAccessNative.decryptToRawPlaintextNative(str, str2);
    }
}
