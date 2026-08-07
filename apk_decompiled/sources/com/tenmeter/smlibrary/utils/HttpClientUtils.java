package com.tenmeter.smlibrary.utils;

import com.tencent.connect.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class HttpClientUtils {
    private static final String TAG = "HttpClientUtils";

    public interface OnRequestCallBack {
        void onError(String str);

        void onSuccess(String str);
    }

    public static void get(final String str, final OnRequestCallBack onRequestCallBack) {
        new Thread() { // from class: com.tenmeter.smlibrary.utils.HttpClientUtils.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws Throwable {
                HttpClientUtils.getRequest(str, onRequestCallBack);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:62:0x0110 A[Catch: IOException -> 0x010c, TRY_LEAVE, TryCatch #10 {IOException -> 0x010c, blocks: (B:58:0x0108, B:62:0x0110), top: B:68:0x0108 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x006c: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:13:0x006c */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v17, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.io.InputStream] */
    public static void getRequest(String str, OnRequestCallBack onRequestCallBack) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        IOException e;
        ?? r7;
        MalformedURLException e2;
        ?? r8;
        String message;
        ?? r9;
        boolean z = false;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod(Constants.HTTP_GET);
                    httpURLConnection.setConnectTimeout(50000);
                    httpURLConnection.setReadTimeout(50000);
                    httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0;");
                    httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                    httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    httpURLConnection.setRequestProperty("Charset", Constants.ENC_UTF_8);
                    httpURLConnection.setRequestProperty("content-Type", "application/json");
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.connect();
                    httpURLConnection.getContentLength();
                    if (httpURLConnection.getResponseCode() == 200) {
                        str = httpURLConnection.getInputStream();
                        try {
                            byteArrayOutputStream2 = new ByteArrayOutputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i = str.read(bArr);
                                    if (i == -1) {
                                        break;
                                    } else {
                                        byteArrayOutputStream2.write(bArr, 0, i);
                                    }
                                }
                                String string = byteArrayOutputStream2.toString();
                                KLog.i(TAG, " result:" + string);
                                z = true;
                                message = string;
                                byteArrayOutputStream3 = byteArrayOutputStream2;
                                r9 = str;
                            } catch (MalformedURLException e3) {
                                e2 = e3;
                                r8 = str;
                                message = e2.getMessage();
                                e2.printStackTrace();
                                if (byteArrayOutputStream2 != null) {
                                    byteArrayOutputStream2.close();
                                }
                                if (r8 != 0) {
                                    r8.close();
                                }
                            } catch (IOException e4) {
                                e = e4;
                                r7 = str;
                                message = e.getMessage();
                                e.printStackTrace();
                                if (byteArrayOutputStream2 != null) {
                                    byteArrayOutputStream2.close();
                                }
                                if (r7 != 0) {
                                    r7.close();
                                }
                            }
                        } catch (MalformedURLException e5) {
                            byteArrayOutputStream2 = null;
                            e2 = e5;
                            r8 = str;
                        } catch (IOException e6) {
                            byteArrayOutputStream2 = null;
                            e = e6;
                            r7 = str;
                        } catch (Throwable th) {
                            th = th;
                            if (byteArrayOutputStream3 != null) {
                                try {
                                    byteArrayOutputStream3.close();
                                    if (str != 0) {
                                        str.close();
                                    }
                                } catch (IOException e7) {
                                    e7.getMessage();
                                    e7.printStackTrace();
                                    throw th;
                                }
                            } else if (str != 0) {
                                str.close();
                            }
                            throw th;
                        }
                    } else {
                        message = "请求失败 code:" + httpURLConnection.getResponseMessage();
                        r9 = 0;
                    }
                    if (byteArrayOutputStream3 != null) {
                        byteArrayOutputStream3.close();
                    }
                    if (r9 != 0) {
                        r9.close();
                    }
                } catch (IOException e8) {
                    message = e8.getMessage();
                    e8.printStackTrace();
                }
            } catch (MalformedURLException e9) {
                byteArrayOutputStream2 = null;
                e2 = e9;
                r8 = 0;
            } catch (IOException e10) {
                byteArrayOutputStream2 = null;
                e = e10;
                r7 = 0;
            } catch (Throwable th2) {
                th = th2;
                str = 0;
            }
            if (z) {
                onRequestCallBack.onSuccess(message);
            } else {
                onRequestCallBack.onError(message);
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream3 = byteArrayOutputStream;
        }
    }

    public static void post(final String str, final String str2, final OnRequestCallBack onRequestCallBack) {
        new Thread() { // from class: com.tenmeter.smlibrary.utils.HttpClientUtils.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws Throwable {
                HttpClientUtils.postRequest(str, str2, onRequestCallBack);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:63:0x011c A[Catch: IOException -> 0x0118, TRY_LEAVE, TryCatch #1 {IOException -> 0x0118, blocks: (B:59:0x0114, B:63:0x011c), top: B:67:0x0114 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.InputStream] */
    public static void postRequest(String str, String str2, OnRequestCallBack onRequestCallBack) throws Throwable {
        String message;
        String message2;
        ?? r6;
        boolean z = false;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod(Constants.HTTP_POST);
                    httpURLConnection.setConnectTimeout(50000);
                    httpURLConnection.setReadTimeout(50000);
                    httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0;");
                    httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                    httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    httpURLConnection.setRequestProperty("Charset", Constants.ENC_UTF_8);
                    httpURLConnection.setRequestProperty("content-Type", "application/json");
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setUseCaches(false);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), Constants.ENC_UTF_8);
                    outputStreamWriter.write(str2);
                    outputStreamWriter.flush();
                    httpURLConnection.connect();
                    httpURLConnection.getContentLength();
                    if (httpURLConnection.getResponseCode() == 200) {
                        str = httpURLConnection.getInputStream();
                        try {
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i = str.read(bArr);
                                    if (i == -1) {
                                        break;
                                    } else {
                                        byteArrayOutputStream2.write(bArr, 0, i);
                                    }
                                }
                                message = byteArrayOutputStream2.toString();
                                KLog.i(TAG, "backStr:" + message);
                                byteArrayOutputStream = byteArrayOutputStream2;
                                z = true;
                                r6 = str;
                            } catch (MalformedURLException e) {
                                e = e;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                message2 = e.getMessage();
                                e.printStackTrace();
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                if (str != 0) {
                                    str.close();
                                }
                                message = message2;
                            } catch (IOException e2) {
                                e = e2;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                message2 = e.getMessage();
                                e.printStackTrace();
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                if (str != 0) {
                                    str.close();
                                }
                                message = message2;
                            } catch (Throwable th) {
                                th = th;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                        if (str != 0) {
                                            str.close();
                                        }
                                    } catch (IOException e3) {
                                        e3.getMessage();
                                        e3.printStackTrace();
                                        throw th;
                                    }
                                } else if (str != 0) {
                                    str.close();
                                }
                                throw th;
                            }
                        } catch (MalformedURLException e4) {
                            e = e4;
                        } catch (IOException e5) {
                            e = e5;
                        }
                    } else {
                        message = "请求失败 code:" + httpURLConnection.getResponseCode();
                        r6 = 0;
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (r6 != 0) {
                        r6.close();
                    }
                } catch (IOException e6) {
                    message = e6.getMessage();
                    e6.printStackTrace();
                }
            } catch (MalformedURLException e7) {
                e = e7;
                str = 0;
            } catch (IOException e8) {
                e = e8;
                str = 0;
            } catch (Throwable th2) {
                th = th2;
                str = 0;
            }
            if (z) {
                onRequestCallBack.onSuccess(message);
            } else {
                onRequestCallBack.onError(message);
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
