package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes.dex */
public class sp3 {
    private Context a;
    private String b = null;
    private HashMap c = null;
    private String d = null;

    public sp3(Context context) {
        this.a = context;
    }

    private String a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT < 29) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    if (extraInfo == null || !(extraInfo.trim().toLowerCase().equals("cmwap") || extraInfo.trim().toLowerCase().equals("uniwap") || extraInfo.trim().toLowerCase().equals("3gwap") || extraInfo.trim().toLowerCase().equals("ctwap"))) {
                        return "wifi";
                    }
                    return extraInfo.trim().toLowerCase().equals("ctwap") ? "ctwap" : "cmwap";
                }
                return null;
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null) {
                return "wifi";
            }
            boolean zHasTransport = networkCapabilities.hasTransport(1);
            boolean zHasTransport2 = networkCapabilities.hasTransport(0);
            boolean zHasTransport3 = networkCapabilities.hasTransport(3);
            boolean zHasTransport4 = networkCapabilities.hasTransport(6);
            boolean zHasTransport5 = networkCapabilities.hasTransport(4);
            boolean zHasTransport6 = networkCapabilities.hasTransport(5);
            if (zHasTransport) {
                return "WIFI";
            }
            if (zHasTransport2) {
                return "CELLULAR";
            }
            if (zHasTransport3) {
                return "ETHERNET";
            }
            if (zHasTransport4) {
                return "LoWPAN";
            }
            if (zHasTransport5) {
                return "VPN";
            }
            return zHasTransport6 ? "WifiAware" : "wifi";
        } catch (Exception e) {
            if (ym3.a) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0197 A[Catch: all -> 0x0130, TryCatch #9 {all -> 0x0130, blocks: (B:7:0x002e, B:80:0x0135, B:82:0x0139, B:83:0x013c, B:93:0x0165, B:95:0x0169, B:96:0x016c, B:106:0x0193, B:108:0x0197, B:109:0x019a), top: B:139:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:123:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:125:0x0202  */
    /* JADX WARN: Code duplicated, block: B:135:0x0187 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:143:0x0159 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:147:0x01b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x00c1 A[Catch: all -> 0x00dd, TryCatch #23 {all -> 0x00dd, blocks: (B:48:0x00bd, B:50:0x00c1, B:53:0x00df), top: B:145:0x00bd }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0111 A[PHI: r5 r9 r13
      0x0111: PHI (r5v1 boolean) = (r5v0 boolean), (r5v0 boolean), (r5v0 boolean), (r5v3 boolean) binds: [B:89:0x0160, B:102:0x018e, B:115:0x01be, B:63:0x010f] A[DONT_GENERATE, DONT_INLINE]
      0x0111: PHI (r9v6 int) = (r3v2 int), (r3v2 int), (r3v2 int), (r9v22 int) binds: [B:89:0x0160, B:102:0x018e, B:115:0x01be, B:63:0x010f] A[DONT_GENERATE, DONT_INLINE]
      0x0111: PHI (r13v21 'e' java.io.IOException) = 
      (r13v9 'e' java.io.IOException)
      (r13v14 'e' java.io.IOException)
      (r13v19 'e' java.io.IOException)
      (r13v43 'e' java.io.IOException)
     binds: [B:89:0x0160, B:102:0x018e, B:115:0x01be, B:63:0x010f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:66:0x0118 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:82:0x0139 A[Catch: all -> 0x0130, TryCatch #9 {all -> 0x0130, blocks: (B:7:0x002e, B:80:0x0135, B:82:0x0139, B:83:0x013c, B:93:0x0165, B:95:0x0169, B:96:0x016c, B:106:0x0193, B:108:0x0197, B:109:0x019a), top: B:139:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0169 A[Catch: all -> 0x0130, TryCatch #9 {all -> 0x0130, blocks: (B:7:0x002e, B:80:0x0135, B:82:0x0139, B:83:0x013c, B:93:0x0165, B:95:0x0169, B:96:0x016c, B:106:0x0193, B:108:0x0197, B:109:0x019a), top: B:139:0x002e }] */
    /* JADX WARN: Instruction removed from duplicated block: B:125:0x0202, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:50:0x00c1, please report this as an issue */
    private void c(HttpsURLConnection httpsURLConnection) throws Throwable {
        BufferedReader bufferedReader;
        ym3.b("https Post start,url:" + this.b);
        if (this.c == null) {
            this.d = ai0.b("httpsPost request paramters is null.");
            return;
        }
        int responseCode = -1;
        OutputStream outputStream = null;
        BufferedReader bufferedReader2 = null;
        inputStream = null;
        InputStream inputStream = null;
        OutputStream outputStream2 = null;
        OutputStream outputStream3 = null;
        OutputStream outputStream4 = null;
        boolean z = false;
        try {
            try {
                OutputStream outputStream5 = httpsURLConnection.getOutputStream();
                try {
                    try {
                        try {
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream5, Constants.ENC_UTF_8));
                            bufferedWriter.write(e(this.c));
                            ym3.b(e(this.c));
                            bufferedWriter.flush();
                            bufferedWriter.close();
                            httpsURLConnection.connect();
                            try {
                                InputStream inputStream2 = httpsURLConnection.getInputStream();
                                try {
                                    responseCode = httpsURLConnection.getResponseCode();
                                    if (200 == responseCode) {
                                        try {
                                            bufferedReader = new BufferedReader(new InputStreamReader(inputStream2, Constants.ENC_UTF_8));
                                            try {
                                                StringBuffer stringBuffer = new StringBuffer();
                                                while (true) {
                                                    int i = bufferedReader.read();
                                                    if (i == -1) {
                                                        break;
                                                    } else {
                                                        stringBuffer.append((char) i);
                                                    }
                                                }
                                                this.d = stringBuffer.toString();
                                                bufferedReader2 = bufferedReader;
                                            } catch (IOException e) {
                                                e = e;
                                                inputStream = inputStream2;
                                                try {
                                                    if (ym3.a) {
                                                        e.printStackTrace();
                                                        ym3.b("httpsPost parse failed;" + e.getMessage());
                                                    }
                                                    this.d = ai0.a(-11, "httpsPost failed,IOException:" + e.getMessage());
                                                    if (inputStream != null) {
                                                        bufferedReader.close();
                                                        inputStream.close();
                                                    }
                                                    httpsURLConnection.disconnect();
                                                } catch (Throwable th) {
                                                    th = th;
                                                    if (inputStream != null && bufferedReader != null) {
                                                        bufferedReader.close();
                                                        inputStream.close();
                                                    }
                                                    httpsURLConnection.disconnect();
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                inputStream = inputStream2;
                                                if (inputStream != null) {
                                                    bufferedReader.close();
                                                    inputStream.close();
                                                }
                                                httpsURLConnection.disconnect();
                                                throw th;
                                            }
                                        } catch (IOException e2) {
                                            e = e2;
                                            bufferedReader = null;
                                            inputStream = inputStream2;
                                            if (ym3.a) {
                                                e.printStackTrace();
                                                ym3.b("httpsPost parse failed;" + e.getMessage());
                                            }
                                            this.d = ai0.a(-11, "httpsPost failed,IOException:" + e.getMessage());
                                            if (inputStream != null && bufferedReader != null) {
                                                bufferedReader.close();
                                                inputStream.close();
                                            }
                                            httpsURLConnection.disconnect();
                                            if (outputStream5 != null) {
                                                try {
                                                    outputStream5.close();
                                                } catch (IOException e3) {
                                                    e = e3;
                                                    if (ym3.a) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            }
                                            if (z) {
                                            }
                                            if (this.d == null) {
                                                ym3.b("httpsPost failed,mResult is null");
                                                this.d = ai0.a(-1, "httpsPost failed,internal error");
                                                return;
                                            } else {
                                                ym3.b("httpsPost success end,parse result = " + this.d);
                                                return;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            bufferedReader = null;
                                            inputStream = inputStream2;
                                            if (inputStream != null) {
                                                bufferedReader.close();
                                                inputStream.close();
                                            }
                                            httpsURLConnection.disconnect();
                                            throw th;
                                        }
                                    }
                                    if (inputStream2 != null && bufferedReader2 != null) {
                                        bufferedReader2.close();
                                        inputStream2.close();
                                    }
                                    httpsURLConnection.disconnect();
                                    z = true;
                                } catch (IOException e4) {
                                    e = e4;
                                    responseCode = -1;
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            } catch (IOException e5) {
                                e = e5;
                                responseCode = -1;
                                bufferedReader = null;
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedReader = null;
                            }
                            if (outputStream5 != null) {
                                outputStream5.close();
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            outputStream2 = outputStream5;
                            if (outputStream2 != null) {
                                try {
                                    outputStream2.close();
                                } catch (IOException e6) {
                                    if (ym3.a) {
                                        e6.printStackTrace();
                                    }
                                }
                            }
                            throw th;
                        }
                    } catch (MalformedURLException e7) {
                        e = e7;
                        outputStream3 = outputStream5;
                        if (ym3.a) {
                            e.printStackTrace();
                        }
                        this.d = ai0.a(-11, "httpsPost failed,MalformedURLException:" + e.getMessage());
                        if (outputStream3 != null) {
                            try {
                                outputStream3.close();
                            } catch (IOException e8) {
                                e = e8;
                                if (ym3.a) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } catch (IOException e9) {
                        e = e9;
                        outputStream4 = outputStream5;
                        if (ym3.a) {
                            e.printStackTrace();
                        }
                        this.d = ai0.a(-11, "httpsPost failed,IOException:" + e.getMessage());
                        if (outputStream4 != null) {
                            try {
                                outputStream4.close();
                            } catch (IOException e10) {
                                e = e10;
                                if (ym3.a) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } catch (Exception e11) {
                        e = e11;
                        outputStream = outputStream5;
                        if (ym3.a) {
                            e.printStackTrace();
                        }
                        this.d = ai0.a(-11, "httpsPost failed,Exception:" + e.getMessage());
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e12) {
                                e = e12;
                                if (ym3.a) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                } catch (MalformedURLException e13) {
                    e = e13;
                    outputStream3 = outputStream5;
                    if (ym3.a) {
                        e.printStackTrace();
                    }
                    this.d = ai0.a(-11, "httpsPost failed,MalformedURLException:" + e.getMessage());
                    if (outputStream3 != null) {
                        outputStream3.close();
                    }
                } catch (IOException e14) {
                    e = e14;
                    outputStream4 = outputStream5;
                    if (ym3.a) {
                        e.printStackTrace();
                    }
                    this.d = ai0.a(-11, "httpsPost failed,IOException:" + e.getMessage());
                    if (outputStream4 != null) {
                        outputStream4.close();
                    }
                } catch (Exception e15) {
                    e = e15;
                    outputStream = outputStream5;
                    if (ym3.a) {
                        e.printStackTrace();
                    }
                    this.d = ai0.a(-11, "httpsPost failed,Exception:" + e.getMessage());
                    if (outputStream != null) {
                        outputStream.close();
                    }
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (MalformedURLException e16) {
            e = e16;
        } catch (IOException e17) {
            e = e17;
        } catch (Exception e18) {
            e = e18;
        }
        if (z || 200 == responseCode) {
            if (this.d == null) {
                ym3.b("httpsPost failed,mResult is null");
                this.d = ai0.a(-1, "httpsPost failed,internal error");
                return;
            } else {
                ym3.b("httpsPost success end,parse result = " + this.d);
                return;
            }
        }
        ym3.b("httpsPost failed,statusCode:" + responseCode);
        this.d = ai0.a(-11, "httpsPost failed,statusCode:" + responseCode);
    }

    private static String e(HashMap map) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry entry : map.entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            sb.append(URLEncoder.encode((String) entry.getKey(), Constants.ENC_UTF_8));
            sb.append("=");
            sb.append(URLEncoder.encode((String) entry.getValue(), Constants.ENC_UTF_8));
        }
        return sb.toString();
    }

    private HttpsURLConnection f() {
        String str;
        URLConnection uRLConnectionOpenConnection;
        try {
            URL url = new URL(this.b);
            ym3.b("https URL: " + this.b);
            String strA = a(this.a);
            if (strA != null && !strA.equals(Constants.STR_EMPTY)) {
                ym3.b("checkNetwork = " + strA);
                if (strA.equals("cmwap")) {
                    uRLConnectionOpenConnection = url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80)));
                } else {
                    uRLConnectionOpenConnection = strA.equals("ctwap") ? url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80))) : url.openConnection();
                }
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
                httpsURLConnection.setHostnameVerifier(new wp3(this));
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setRequestMethod(Constants.HTTP_POST);
                httpsURLConnection.setConnectTimeout(50000);
                httpsURLConnection.setReadTimeout(50000);
                return httpsURLConnection;
            }
            ym3.d("Current network is not available.");
            this.d = ai0.a(-10, "Current network is not available.");
            return null;
        } catch (MalformedURLException e) {
            if (ym3.a) {
                e.printStackTrace();
                ym3.b(e.getMessage());
            }
            str = "Auth server could not be parsed as a URL.";
            this.d = ai0.a(-11, str);
            return null;
        } catch (Exception e2) {
            if (ym3.a) {
                e2.printStackTrace();
                ym3.b(e2.getMessage());
            }
            str = "Init httpsurlconnection failed.";
            this.d = ai0.a(-11, str);
            return null;
        }
    }

    private HashMap g(HashMap map) {
        HashMap map2 = new HashMap();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            String string = ((String) it.next()).toString();
            map2.put(string, map.get(string));
        }
        return map2;
    }

    protected String b(HashMap map) throws Throwable {
        HashMap mapG = g(map);
        this.c = mapG;
        this.b = (String) mapG.get(SocialConstants.PARAM_URL);
        HttpsURLConnection httpsURLConnectionF = f();
        if (httpsURLConnectionF == null) {
            ym3.d("syncConnect failed,httpsURLConnection is null");
        } else {
            c(httpsURLConnectionF);
        }
        return this.d;
    }

    protected boolean d() {
        ym3.b("checkNetwork start");
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                return networkCapabilities != null && networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16);
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return false;
            }
            ym3.b("checkNetwork end");
            return true;
        } catch (Exception e) {
            if (ym3.a) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
