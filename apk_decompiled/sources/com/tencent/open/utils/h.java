package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class h {
    private static Map<String, h> a = Collections.synchronizedMap(new HashMap());
    private static String b = null;
    private Context c;
    private String d;
    private JSONObject e = null;
    private long f = 0;
    private int g = 0;
    private boolean h = true;

    private h(Context context, String str) {
        this.c = null;
        this.d = null;
        this.c = context.getApplicationContext();
        this.d = str;
        a();
        b();
    }

    private void b() {
        if (this.g != 0) {
            d("update thread is running, return");
            return;
        }
        this.g = 1;
        final HashMap map = new HashMap();
        map.put("appid", this.d);
        map.put("status_os", Build.VERSION.RELEASE);
        map.put("status_machine", f.a().b(g.a()));
        map.put("status_version", Build.VERSION.SDK);
        map.put("sdkv", Constants.SDK_VERSION);
        map.put("sdkp", "a");
        k.a(new Runnable() { // from class: com.tencent.open.utils.h.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.tencent.open.a.b bVarA = com.tencent.open.a.a.a().a("https://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", map);
                    String strA = bVarA.a();
                    SLog.i("openSDK_LOG.OpenConfig", "update: get config statusCode " + bVarA.d());
                    h.this.a(l.d(strA));
                } catch (Exception e) {
                    SLog.e("openSDK_LOG.OpenConfig", "get config error ", e);
                }
                h.this.g = 0;
            }
        });
    }

    private String c(String str) {
        InputStream inputStreamOpen;
        BufferedReader bufferedReader;
        StringBuffer stringBuffer;
        String str2;
        String string = Constants.STR_EMPTY;
        try {
            try {
                if (this.d != null) {
                    str2 = str + FileUtils.FILE_EXTENSION_SEPARATOR + this.d;
                } else {
                    str2 = str;
                }
                inputStreamOpen = this.c.openFileInput(str2);
                while (true) {
                    try {
                        try {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                stringBuffer.append(line);
                            } catch (IOException e) {
                                e.printStackTrace();
                                inputStreamOpen.close();
                                bufferedReader.close();
                            }
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    } catch (Throwable th) {
                        try {
                            inputStreamOpen.close();
                            bufferedReader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        throw th;
                    }
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                return Constants.STR_EMPTY;
            }
        } catch (FileNotFoundException unused) {
            inputStreamOpen = this.c.getAssets().open(str);
        }
        bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, Charset.forName(Constants.ENC_UTF_8)));
        stringBuffer = new StringBuffer();
        string = stringBuffer.toString();
        inputStreamOpen.close();
        bufferedReader.close();
        return string;
    }

    private void d(String str) {
        if (this.h) {
            SLog.v("openSDK_LOG.OpenConfig", str + "; appid: " + this.d);
        }
    }

    public static h a(Context context, String str) {
        h hVar;
        synchronized (a) {
            try {
                SLog.v("openSDK_LOG.OpenConfig", "getInstance begin");
                if (str != null) {
                    b = str;
                }
                if (str == null && (str = b) == null) {
                    str = "0";
                }
                hVar = a.get(str);
                if (hVar == null) {
                    hVar = new h(context, str);
                    a.put(str, hVar);
                }
                SLog.v("openSDK_LOG.OpenConfig", "getInstance end");
            } catch (Throwable th) {
                throw th;
            }
        }
        return hVar;
    }

    public boolean b(String str) {
        d("get " + str);
        c();
        Object objOpt = this.e.opt(str);
        if (objOpt == null) {
            return false;
        }
        if (objOpt instanceof Integer) {
            return !objOpt.equals(0);
        }
        if (objOpt instanceof Boolean) {
            return ((Boolean) objOpt).booleanValue();
        }
        return false;
    }

    private void a() {
        try {
            this.e = new JSONObject(c("com.tencent.open.config.json"));
        } catch (JSONException unused) {
            this.e = new JSONObject();
        }
    }

    private void a(String str, String str2) {
        try {
            if (this.d != null) {
                str = str + FileUtils.FILE_EXTENSION_SEPARATOR + this.d;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.c.openFileOutput(str, 0), Charset.forName(Constants.ENC_UTF_8));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void c() {
        int iOptInt = this.e.optInt("Common_frequency");
        if (iOptInt == 0) {
            iOptInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f >= iOptInt * 3600000) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        d("cgi back, do update");
        this.e = jSONObject;
        a("com.tencent.open.config.json", jSONObject.toString());
        this.f = SystemClock.elapsedRealtime();
    }

    public int a(String str) {
        d("get " + str);
        c();
        return this.e.optInt(str);
    }
}
