package defpackage;

import android.text.TextUtils;
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
class rp3 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ boolean b;
    final /* synthetic */ np3 c;

    rp3(np3 np3Var, String str, boolean z) {
        this.c = np3Var;
        this.a = str;
        this.b = z;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x01cf A[Catch: Exception -> 0x01a9, TRY_ENTER, TRY_LEAVE, TryCatch #4 {Exception -> 0x01a9, blocks: (B:91:0x01a5, B:109:0x01cf), top: B:139:0x01a5 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x01d6 A[LOOP:0: B:3:0x001a->B:113:0x01d6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:115:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:130:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:131:0x020c  */
    /* JADX WARN: Code duplicated, block: B:137:0x01ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x01a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:141:0x01f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:0x019c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:147:0x01e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:149:0x01c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:151:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:0x01bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x01fb A[EDGE_INSN: B:170:0x01fb->B:129:0x01fb BREAK  A[LOOP:0: B:3:0x001a->B:113:0x01d6], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x018e  */
    /* JADX WARN: Code duplicated, block: B:99:0x01b8  */
    @Override // java.lang.Runnable
    public void run() throws Throwable {
        OutputStream outputStream;
        OutputStream outputStream2;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        InputStream inputStream2;
        boolean z;
        np3 np3Var = this.c;
        np3Var.a = fp3.a;
        np3Var.a();
        HttpsURLConnection httpsURLConnection = null;
        for (int i = this.c.b; i > 0; i--) {
            try {
                URL url = new URL(this.c.a);
                StringBuffer stringBuffer = new StringBuffer();
                for (Map.Entry entry : this.c.d.entrySet()) {
                    stringBuffer.append((String) entry.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append(entry.getValue());
                    stringBuffer.append("&");
                }
                if (stringBuffer.length() > 0) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                }
                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                try {
                    httpsURLConnection2.setRequestMethod(Constants.HTTP_POST);
                    httpsURLConnection2.setDoInput(true);
                    httpsURLConnection2.setDoOutput(true);
                    httpsURLConnection2.setUseCaches(false);
                    httpsURLConnection2.setConnectTimeout(cn3.a);
                    httpsURLConnection2.setReadTimeout(cn3.a);
                    httpsURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                    httpsURLConnection2.setRequestProperty("Accept-Charset", Constants.ENC_UTF_8);
                    httpsURLConnection2.setRequestProperty("Accept-Encoding", "gzip");
                    String str = fq3.J;
                    if (str != null) {
                        httpsURLConnection2.setRequestProperty("bd-loc-android", str);
                    }
                    if (!TextUtils.isEmpty(this.a)) {
                        httpsURLConnection2.setRequestProperty("Host", this.a);
                    }
                    OutputStream outputStream3 = httpsURLConnection2.getOutputStream();
                    try {
                        outputStream3.write(stringBuffer.toString().getBytes());
                        outputStream3.flush();
                        if (httpsURLConnection2.getResponseCode() == 200) {
                            inputStream2 = httpsURLConnection2.getInputStream();
                            try {
                                String contentEncoding = httpsURLConnection2.getContentEncoding();
                                if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                    inputStream2 = new GZIPInputStream(new BufferedInputStream(inputStream2));
                                }
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int i2 = inputStream2.read(bArr);
                                        if (i2 == -1) {
                                            break;
                                        } else {
                                            byteArrayOutputStream.write(bArr, 0, i2);
                                        }
                                    }
                                    this.c.c = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                                    if (this.b) {
                                        this.c.f = byteArrayOutputStream.toByteArray();
                                    }
                                    this.c.d(true);
                                    z = true;
                                } catch (Error unused) {
                                    outputStream = outputStream3;
                                    httpsURLConnection = httpsURLConnection2;
                                    try {
                                        Log.d("baidu_location_service", "NetworkCommunicationError!");
                                        if (httpsURLConnection != null) {
                                            httpsURLConnection.disconnect();
                                        }
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (Exception unused2) {
                                                Log.d("baidu_location_service", "close os IOException!");
                                            }
                                        }
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Exception unused3) {
                                                Log.d("baidu_location_service", "close is IOException!");
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception unused4) {
                                                Log.d("baidu_location_service", "close baos IOException!");
                                            }
                                        }
                                        z = false;
                                    } catch (Throwable th) {
                                        th = th;
                                        inputStream = inputStream2;
                                        if (httpsURLConnection != null) {
                                            httpsURLConnection.disconnect();
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
                                        if (byteArrayOutputStream == null) {
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
                                } catch (Exception unused8) {
                                    outputStream2 = outputStream3;
                                    httpsURLConnection = httpsURLConnection2;
                                    Log.d("baidu_location_service", "NetworkCommunicationException!");
                                    if (httpsURLConnection != null) {
                                        httpsURLConnection.disconnect();
                                    }
                                    if (outputStream2 != null) {
                                        try {
                                            outputStream2.close();
                                        } catch (Exception unused9) {
                                            Log.d("baidu_location_service", "close os IOException!");
                                        }
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception unused10) {
                                            Log.d("baidu_location_service", "close is IOException!");
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    z = false;
                                } catch (Throwable th2) {
                                    th = th2;
                                    outputStream = outputStream3;
                                    httpsURLConnection = httpsURLConnection2;
                                    inputStream = inputStream2;
                                    if (httpsURLConnection != null) {
                                        httpsURLConnection.disconnect();
                                    }
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (byteArrayOutputStream == null) {
                                        throw th;
                                    }
                                    byteArrayOutputStream.close();
                                    throw th;
                                }
                            } catch (Error unused11) {
                                outputStream = outputStream3;
                                httpsURLConnection = httpsURLConnection2;
                                byteArrayOutputStream = null;
                                Log.d("baidu_location_service", "NetworkCommunicationError!");
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                z = false;
                                if (z) {
                                    break;
                                    if (i > 0) {
                                        np3.j = 0;
                                        return;
                                    }
                                    np3.j++;
                                    np3 np3Var2 = this.c;
                                    np3Var2.c = null;
                                    np3Var2.d(false);
                                }
                            } catch (Exception unused12) {
                                outputStream2 = outputStream3;
                                httpsURLConnection = httpsURLConnection2;
                                byteArrayOutputStream = null;
                                Log.d("baidu_location_service", "NetworkCommunicationException!");
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                if (outputStream2 != null) {
                                    outputStream2.close();
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                z = false;
                                if (z) {
                                    break;
                                    if (i > 0) {
                                        np3.j = 0;
                                        return;
                                    }
                                    np3.j++;
                                    np3 np3Var3 = this.c;
                                    np3Var3.c = null;
                                    np3Var3.d(false);
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                outputStream = outputStream3;
                                httpsURLConnection = httpsURLConnection2;
                                inputStream = inputStream2;
                                byteArrayOutputStream = null;
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (byteArrayOutputStream == null) {
                                    throw th;
                                }
                                byteArrayOutputStream.close();
                                throw th;
                            }
                        } else {
                            z = false;
                            inputStream2 = null;
                            byteArrayOutputStream = null;
                        }
                        httpsURLConnection2.disconnect();
                        try {
                            outputStream3.close();
                        } catch (Exception unused13) {
                            Log.d("baidu_location_service", "close os IOException!");
                        }
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception unused14) {
                                Log.d("baidu_location_service", "close is IOException!");
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused15) {
                                Log.d("baidu_location_service", "close baos IOException!");
                            }
                        }
                        httpsURLConnection = httpsURLConnection2;
                    } catch (Error unused16) {
                        outputStream = outputStream3;
                        httpsURLConnection = httpsURLConnection2;
                        inputStream2 = null;
                        byteArrayOutputStream = null;
                        Log.d("baidu_location_service", "NetworkCommunicationError!");
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        z = false;
                        if (z) {
                            break;
                            if (i > 0) {
                                np3.j = 0;
                                return;
                            }
                            np3.j++;
                            np3 np3Var4 = this.c;
                            np3Var4.c = null;
                            np3Var4.d(false);
                        }
                    } catch (Exception unused17) {
                        outputStream2 = outputStream3;
                        httpsURLConnection = httpsURLConnection2;
                        inputStream2 = null;
                        byteArrayOutputStream = null;
                        Log.d("baidu_location_service", "NetworkCommunicationException!");
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        z = false;
                        if (z) {
                            break;
                            if (i > 0) {
                                np3.j = 0;
                                return;
                            }
                            np3.j++;
                            np3 np3Var5 = this.c;
                            np3Var5.c = null;
                            np3Var5.d(false);
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        outputStream = outputStream3;
                        httpsURLConnection = httpsURLConnection2;
                        byteArrayOutputStream = null;
                        inputStream = null;
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream == null) {
                            throw th;
                        }
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (Error unused18) {
                    httpsURLConnection = httpsURLConnection2;
                    outputStream = null;
                    inputStream2 = null;
                    byteArrayOutputStream = null;
                    Log.d("baidu_location_service", "NetworkCommunicationError!");
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    z = false;
                    if (z) {
                        break;
                        if (i > 0) {
                            np3.j = 0;
                            return;
                        }
                        np3.j++;
                        np3 np3Var6 = this.c;
                        np3Var6.c = null;
                        np3Var6.d(false);
                    }
                } catch (Exception unused19) {
                    httpsURLConnection = httpsURLConnection2;
                    outputStream2 = null;
                    inputStream2 = null;
                    byteArrayOutputStream = null;
                    Log.d("baidu_location_service", "NetworkCommunicationException!");
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    z = false;
                    if (z) {
                        break;
                        if (i > 0) {
                            np3.j = 0;
                            return;
                        }
                        np3.j++;
                        np3 np3Var7 = this.c;
                        np3Var7.c = null;
                        np3Var7.d(false);
                    }
                } catch (Throwable th5) {
                    th = th5;
                    httpsURLConnection = httpsURLConnection2;
                    outputStream = null;
                    byteArrayOutputStream = null;
                    inputStream = null;
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (byteArrayOutputStream == null) {
                        throw th;
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (Error unused20) {
            } catch (Exception unused21) {
            } catch (Throwable th6) {
                th = th6;
            }
            if (z) {
                break;
            }
        }
        if (i > 0) {
            np3.j = 0;
            return;
        }
        np3.j++;
        np3 np3Var8 = this.c;
        np3Var8.c = null;
        np3Var8.d(false);
    }
}
