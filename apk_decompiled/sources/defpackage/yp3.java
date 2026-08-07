package defpackage;

import android.util.Log;
import com.tencent.connect.common.Constants;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes.dex */
class yp3 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ np3 b;

    yp3(np3 np3Var, String str) {
        this.b = np3Var;
        this.a = str;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:120:0x01ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x01b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:0x01d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:126:0x018b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:130:0x01c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:135:0x01cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x0182 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:155:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x017d  */
    /* JADX WARN: Code duplicated, block: B:93:0x01a6  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.io.ByteArrayOutputStream] */
    @Override // java.lang.Runnable
    public void run() throws Throwable {
        InputStream inputStream;
        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        HttpsURLConnection httpsURLConnection;
        ?? r12;
        this.b.a();
        this.b.a = this.a;
        HttpsURLConnection httpsURLConnection2 = null;
        InputStream inputStream2 = null;
        try {
            try {
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    httpsURLConnection = (HttpsURLConnection) new URL(this.b.a).openConnection();
                    try {
                        httpsURLConnection.setInstanceFollowRedirects(false);
                        httpsURLConnection.setDoOutput(true);
                        httpsURLConnection.setDoInput(true);
                        httpsURLConnection.setConnectTimeout(cn3.a);
                        httpsURLConnection.setReadTimeout(cn3.b);
                        httpsURLConnection.setRequestMethod(Constants.HTTP_POST);
                        httpsURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                        httpsURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                        String str = fq3.J;
                        if (str != null) {
                            httpsURLConnection.setRequestProperty("bd-loc-android", str);
                        }
                        for (Map.Entry entry : this.b.d.entrySet()) {
                            stringBuffer.append((String) entry.getKey());
                            stringBuffer.append("=");
                            stringBuffer.append(entry.getValue());
                            stringBuffer.append("&");
                        }
                        if (stringBuffer.length() > 0) {
                            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                        }
                        outputStream = httpsURLConnection.getOutputStream();
                        try {
                            outputStream.write(stringBuffer.toString().getBytes());
                            outputStream.flush();
                            if (httpsURLConnection.getResponseCode() == 200) {
                                inputStream = httpsURLConnection.getInputStream();
                                try {
                                    String contentEncoding = httpsURLConnection.getContentEncoding();
                                    if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                        inputStream = new GZIPInputStream(new BufferedInputStream(inputStream));
                                    }
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                    try {
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int i = inputStream.read(bArr);
                                            if (i == -1) {
                                                break;
                                            } else {
                                                byteArrayOutputStream2.write(bArr, 0, i);
                                            }
                                        }
                                        this.b.c = new String(byteArrayOutputStream2.toByteArray(), "utf-8");
                                        this.b.d(true);
                                        inputStream2 = inputStream;
                                        r12 = byteArrayOutputStream2;
                                    } catch (Error e) {
                                        e = e;
                                        r12 = byteArrayOutputStream2;
                                        e.printStackTrace();
                                        Log.i("baidu_location_service", "https NetworkCommunicationError!");
                                        np3 np3Var = this.b;
                                        np3Var.c = null;
                                        np3Var.d(false);
                                        if (httpsURLConnection != null) {
                                            httpsURLConnection.disconnect();
                                        }
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (Exception unused) {
                                                Log.d("baidu_location_service", "close os IOException!");
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception unused2) {
                                                Log.d("baidu_location_service", "close is IOException!");
                                            }
                                        }
                                        if (r12 == 0) {
                                            return;
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        r12 = byteArrayOutputStream2;
                                        e.printStackTrace();
                                        Log.i("baidu_location_service", "https NetworkCommunicationException!");
                                        np3 np3Var2 = this.b;
                                        np3Var2.c = null;
                                        np3Var2.d(false);
                                        if (httpsURLConnection != null) {
                                            httpsURLConnection.disconnect();
                                        }
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (Exception unused3) {
                                                Log.d("baidu_location_service", "close os IOException!");
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception unused4) {
                                                Log.d("baidu_location_service", "close is IOException!");
                                            }
                                        }
                                        if (r12 == 0) {
                                            return;
                                        }
                                    }
                                } catch (Error e3) {
                                    e = e3;
                                    r12 = 0;
                                } catch (Exception e4) {
                                    e = e4;
                                    r12 = 0;
                                } catch (Throwable th) {
                                    th = th;
                                    byteArrayOutputStream = null;
                                    httpsURLConnection2 = httpsURLConnection;
                                    if (httpsURLConnection2 != null) {
                                        httpsURLConnection2.disconnect();
                                    }
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (Exception unused5) {
                                            Log.d("baidu_location_service", "close os IOException!");
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Exception unused6) {
                                            Log.d("baidu_location_service", "close is IOException!");
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        throw th;
                                    }
                                    try {
                                        byteArrayOutputStream.close();
                                        throw th;
                                    } catch (Exception unused7) {
                                        Log.d("baidu_location_service", "close baos IOException!");
                                        throw th;
                                    }
                                }
                            } else {
                                np3 np3Var3 = this.b;
                                np3Var3.c = null;
                                np3Var3.d(false);
                                r12 = 0;
                            }
                            httpsURLConnection.disconnect();
                            try {
                                outputStream.close();
                            } catch (Exception unused8) {
                                Log.d("baidu_location_service", "close os IOException!");
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception unused9) {
                                    Log.d("baidu_location_service", "close is IOException!");
                                }
                            }
                            if (r12 == 0) {
                                return;
                            }
                        } catch (Error e5) {
                            e = e5;
                            inputStream = null;
                            r12 = 0;
                        } catch (Exception e6) {
                            e = e6;
                            inputStream = null;
                            r12 = 0;
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = null;
                            byteArrayOutputStream = null;
                        }
                    } catch (Error e7) {
                        e = e7;
                        inputStream = null;
                        outputStream = null;
                        r12 = outputStream;
                        e.printStackTrace();
                        Log.i("baidu_location_service", "https NetworkCommunicationError!");
                        np3 np3Var4 = this.b;
                        np3Var4.c = null;
                        np3Var4.d(false);
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (r12 == 0) {
                            return;
                        }
                        r12.close();
                    } catch (Exception e8) {
                        e = e8;
                        inputStream = null;
                        outputStream = null;
                        r12 = outputStream;
                        e.printStackTrace();
                        Log.i("baidu_location_service", "https NetworkCommunicationException!");
                        np3 np3Var5 = this.b;
                        np3Var5.c = null;
                        np3Var5.d(false);
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (r12 == 0) {
                            return;
                        }
                        r12.close();
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = null;
                        outputStream = null;
                        byteArrayOutputStream = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Error e9) {
                e = e9;
                inputStream = null;
                httpsURLConnection = null;
                outputStream = null;
            } catch (Exception e10) {
                e = e10;
                inputStream = null;
                httpsURLConnection = null;
                outputStream = null;
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
                outputStream = null;
                byteArrayOutputStream = null;
                if (httpsURLConnection2 != null) {
                    httpsURLConnection2.disconnect();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    throw th;
                }
                byteArrayOutputStream.close();
                throw th;
            }
            r12.close();
        } catch (Exception unused10) {
            Log.d("baidu_location_service", "close baos IOException!");
        }
    }
}
