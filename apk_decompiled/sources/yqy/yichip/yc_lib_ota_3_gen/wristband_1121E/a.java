package yqy.yichip.yc_lib_ota_3_gen.wristband_1121E;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.tencent.connect.common.Constants;
import defpackage.dm3;
import defpackage.l63;
import defpackage.lm3;
import defpackage.mm3;
import defpackage.nm3;
import defpackage.om3;
import defpackage.q60;
import defpackage.ym0;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static final String N = "a";
    private static int O = 0;
    private static int P = 0;
    private static int Q = 19271;
    private ArrayList D;
    private long a;
    private long b;
    private long c;
    private int d;
    private String e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;
    private long o;
    private long p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f456q;
    private long r;
    private long s;
    private long t;
    private ArrayList u;
    private long v = 0;
    private long w = 0;
    private long x = 0;
    private long y = 0;
    private long z = 0;
    private long A = 0;
    private long B = 0;
    private long C = 0;
    private long E = 0;
    private long F = 0;
    private long G = 0;
    private long H = 0;
    private long I = 0;
    private long J = 0;
    private long K = 0;
    private long L = 0;
    private nm3 M = null;

    public a(String str, int i) throws Throwable {
        this.e = str;
        this.d = i;
        if (i == 11) {
            P = 3;
            O = 20284;
        } else {
            P = 2;
            O = 20279;
        }
        this.m = 24577L;
        long jN = n();
        this.g = jN;
        this.n = jN + 24576;
        String str2 = N;
        Log.d(str2, "Normal部分解析结果：" + x());
        this.k = 4097L;
        long jP = p();
        this.f = jP;
        this.l = jP + PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        Log.d(str2, "OTA部分解析结果：" + y());
        i();
        l();
        r();
        Log.d(str2, "Beep/Font/UI Icon 3部分解析结果：" + w());
        nm3 nm3VarO = o();
        StringBuilder sb = new StringBuilder();
        sb.append("OTA部分checkSum：");
        String str3 = Constants.STR_EMPTY;
        sb.append(nm3VarO == null ? Constants.STR_EMPTY : nm3VarO.toString());
        Log.d(str2, sb.toString());
        nm3 nm3VarM = m();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Normal部分checkSum：");
        sb2.append(nm3VarM == null ? Constants.STR_EMPTY : nm3VarM.toString());
        Log.d(str2, sb2.toString());
        nm3 nm3VarH = h();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Beep部分checkSum：");
        sb3.append(nm3VarH == null ? Constants.STR_EMPTY : nm3VarH.toString());
        Log.d(str2, sb3.toString());
        nm3 nm3VarK = k();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Font部分checkSum：");
        sb4.append(nm3VarK == null ? Constants.STR_EMPTY : nm3VarK.toString());
        Log.d(str2, sb4.toString());
        nm3 nm3VarQ = q();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("UI Icon部分checkSum：");
        sb5.append(nm3VarQ != null ? nm3VarQ.toString() : str3);
        Log.d(str2, sb5.toString());
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0269 A[Catch: all -> 0x0084, Exception -> 0x0089, IOException -> 0x008d, FileNotFoundException -> 0x0091, TryCatch #8 {FileNotFoundException -> 0x0091, IOException -> 0x008d, Exception -> 0x0089, all -> 0x0084, blocks: (B:9:0x0047, B:10:0x0051, B:12:0x0057, B:14:0x0065, B:15:0x0079, B:17:0x007e, B:27:0x0095, B:29:0x009e, B:33:0x00aa, B:42:0x00c5, B:44:0x00cf, B:45:0x00d3, B:46:0x00da, B:50:0x00e3, B:51:0x00f0, B:53:0x00f5, B:54:0x00fb, B:57:0x0110, B:59:0x0116, B:61:0x011e, B:63:0x0126, B:65:0x013e, B:66:0x014c, B:68:0x0152, B:70:0x0162, B:72:0x016a, B:79:0x01a5, B:80:0x01ac, B:82:0x01b1, B:83:0x01b7, B:89:0x01dd, B:95:0x01ef, B:99:0x0208, B:100:0x0218, B:102:0x0220, B:108:0x0269, B:112:0x0275, B:114:0x027d, B:116:0x02a9, B:123:0x02c0, B:124:0x02d0, B:126:0x02d5, B:127:0x02db, B:117:0x02ae, B:118:0x02b5, B:84:0x01cd, B:85:0x01d4, B:135:0x0306), top: B:192:0x0047 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x026f  */
    /* JADX WARN: Code duplicated, block: B:112:0x0275 A[Catch: all -> 0x0084, Exception -> 0x0089, IOException -> 0x008d, FileNotFoundException -> 0x0091, TryCatch #8 {FileNotFoundException -> 0x0091, IOException -> 0x008d, Exception -> 0x0089, all -> 0x0084, blocks: (B:9:0x0047, B:10:0x0051, B:12:0x0057, B:14:0x0065, B:15:0x0079, B:17:0x007e, B:27:0x0095, B:29:0x009e, B:33:0x00aa, B:42:0x00c5, B:44:0x00cf, B:45:0x00d3, B:46:0x00da, B:50:0x00e3, B:51:0x00f0, B:53:0x00f5, B:54:0x00fb, B:57:0x0110, B:59:0x0116, B:61:0x011e, B:63:0x0126, B:65:0x013e, B:66:0x014c, B:68:0x0152, B:70:0x0162, B:72:0x016a, B:79:0x01a5, B:80:0x01ac, B:82:0x01b1, B:83:0x01b7, B:89:0x01dd, B:95:0x01ef, B:99:0x0208, B:100:0x0218, B:102:0x0220, B:108:0x0269, B:112:0x0275, B:114:0x027d, B:116:0x02a9, B:123:0x02c0, B:124:0x02d0, B:126:0x02d5, B:127:0x02db, B:117:0x02ae, B:118:0x02b5, B:84:0x01cd, B:85:0x01d4, B:135:0x0306), top: B:192:0x0047 }] */
    /* JADX WARN: Code duplicated, block: B:114:0x027d A[Catch: all -> 0x0084, Exception -> 0x0089, IOException -> 0x008d, FileNotFoundException -> 0x0091, TryCatch #8 {FileNotFoundException -> 0x0091, IOException -> 0x008d, Exception -> 0x0089, all -> 0x0084, blocks: (B:9:0x0047, B:10:0x0051, B:12:0x0057, B:14:0x0065, B:15:0x0079, B:17:0x007e, B:27:0x0095, B:29:0x009e, B:33:0x00aa, B:42:0x00c5, B:44:0x00cf, B:45:0x00d3, B:46:0x00da, B:50:0x00e3, B:51:0x00f0, B:53:0x00f5, B:54:0x00fb, B:57:0x0110, B:59:0x0116, B:61:0x011e, B:63:0x0126, B:65:0x013e, B:66:0x014c, B:68:0x0152, B:70:0x0162, B:72:0x016a, B:79:0x01a5, B:80:0x01ac, B:82:0x01b1, B:83:0x01b7, B:89:0x01dd, B:95:0x01ef, B:99:0x0208, B:100:0x0218, B:102:0x0220, B:108:0x0269, B:112:0x0275, B:114:0x027d, B:116:0x02a9, B:123:0x02c0, B:124:0x02d0, B:126:0x02d5, B:127:0x02db, B:117:0x02ae, B:118:0x02b5, B:84:0x01cd, B:85:0x01d4, B:135:0x0306), top: B:192:0x0047 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x02a9 A[Catch: all -> 0x0084, Exception -> 0x0089, IOException -> 0x008d, FileNotFoundException -> 0x0091, TryCatch #8 {FileNotFoundException -> 0x0091, IOException -> 0x008d, Exception -> 0x0089, all -> 0x0084, blocks: (B:9:0x0047, B:10:0x0051, B:12:0x0057, B:14:0x0065, B:15:0x0079, B:17:0x007e, B:27:0x0095, B:29:0x009e, B:33:0x00aa, B:42:0x00c5, B:44:0x00cf, B:45:0x00d3, B:46:0x00da, B:50:0x00e3, B:51:0x00f0, B:53:0x00f5, B:54:0x00fb, B:57:0x0110, B:59:0x0116, B:61:0x011e, B:63:0x0126, B:65:0x013e, B:66:0x014c, B:68:0x0152, B:70:0x0162, B:72:0x016a, B:79:0x01a5, B:80:0x01ac, B:82:0x01b1, B:83:0x01b7, B:89:0x01dd, B:95:0x01ef, B:99:0x0208, B:100:0x0218, B:102:0x0220, B:108:0x0269, B:112:0x0275, B:114:0x027d, B:116:0x02a9, B:123:0x02c0, B:124:0x02d0, B:126:0x02d5, B:127:0x02db, B:117:0x02ae, B:118:0x02b5, B:84:0x01cd, B:85:0x01d4, B:135:0x0306), top: B:192:0x0047 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:130:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:131:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:205:0x02ae A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:114:0x027d, please report this as an issue */
    private void a() throws Throwable {
        Throwable th;
        BufferedReader bufferedReader;
        long j;
        Object obj;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        File file = new File(this.e);
        if (!file.exists()) {
            Log.e(N, "analyzeFlashNormalPart()-->文件不存在!");
            return;
        }
        Log.d(N, "解析Normal部分...");
        this.D = new ArrayList();
        this.E = 0L;
        this.F = 0L;
        this.G = 0L;
        this.H = 0L;
        this.I = 0L;
        this.J = 0L;
        this.K = 0L;
        this.L = 0L;
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2));
                        try {
                            StringBuilder sb = new StringBuilder();
                            long j8 = 0;
                            long j9 = 0;
                            long j10 = 0;
                            long jE = 0;
                            long jE2 = 0;
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                j8++;
                                sb.append(line);
                                if (j8 == 3) {
                                    long jD = l63.d(l63.h(sb.toString()));
                                    this.E = jD + 1;
                                    long j11 = jD - j8;
                                    for (int i = 0; i < j11; i++) {
                                        bufferedReader.readLine();
                                    }
                                    j8 += j11;
                                    sb.setLength(0);
                                    j9 = 0;
                                }
                                long j12 = this.E;
                                if (j12 <= 0 || j8 < j12) {
                                    j = 0;
                                    j10 = j10;
                                    jE = jE;
                                } else {
                                    long j13 = this.n;
                                    if (j13 == 0 || j8 < j13) {
                                        j9++;
                                        if (j9 == 2) {
                                            if (!sb.toString().equals("aa55")) {
                                                throw new Exception("Normal部分：文件开始Flag异常");
                                            }
                                            sb.setLength(0);
                                        }
                                        if (j9 > 2) {
                                            long j14 = 4;
                                            if (j9 == 4) {
                                                long jE3 = l63.e(l63.h(sb.toString()));
                                                for (int i2 = 0; i2 < jE3; i2++) {
                                                    bufferedReader.readLine();
                                                }
                                                j8 += jE3;
                                                j9 += jE3;
                                                sb.setLength(0);
                                                this.F = j8;
                                                this.G = j8 + 1;
                                                j14 = 4;
                                                j10 = 0;
                                            }
                                            if (j9 <= j14 || j8 < this.G || this.K != 0) {
                                                obj = "aa55";
                                                j10 = j10;
                                                jE = jE;
                                            } else {
                                                long j15 = j10 + 1;
                                                if (j15 <= 2) {
                                                    long j16 = j15;
                                                    if (sb.toString().equals("aa55".substring(0, sb.toString().length()))) {
                                                        j6 = jE;
                                                        j7 = 2;
                                                    } else {
                                                        this.H = j8 - 1;
                                                        this.I = j8;
                                                        Iterator it = this.D.iterator();
                                                        long j17 = 0;
                                                        while (it.hasNext()) {
                                                            mm3 mm3Var = (mm3) it.next();
                                                            if (mm3Var.d() == 18555 && mm3Var.b() == 3) {
                                                                long jE4 = l63.e(mm3Var.a());
                                                                Log.d(N, "xipStartLine = " + jE4);
                                                                j17 = jE4;
                                                            }
                                                            it = it;
                                                            jE = jE;
                                                        }
                                                        j6 = jE;
                                                        if (j17 == 0 || j17 < j9) {
                                                            throw new Exception("Normal部分：未找到CM0代码");
                                                        }
                                                        long j18 = (j17 - j9) - 7;
                                                        for (int i3 = 0; i3 < j18; i3++) {
                                                            bufferedReader.readLine();
                                                        }
                                                        j8 += j18;
                                                        j9 += j18;
                                                        sb.setLength(0);
                                                        this.J = j8;
                                                        this.K = j8 + 1;
                                                        sb.setLength(0);
                                                        j7 = 2;
                                                        j16 = 0;
                                                    }
                                                    if (j16 == j7) {
                                                        sb.setLength(0);
                                                    }
                                                    j15 = j16;
                                                } else {
                                                    j6 = jE;
                                                }
                                                if (j15 == 4) {
                                                    jE = l63.e(l63.h(sb.toString()));
                                                    sb.setLength(0);
                                                } else {
                                                    jE = j6;
                                                }
                                                if (j15 == 6) {
                                                    jE2 = l63.e(l63.h(sb.toString()));
                                                    sb.setLength(0);
                                                }
                                                obj = "aa55";
                                                long j19 = jE2;
                                                if (j15 == jE + 6) {
                                                    byte[] bArrH = l63.h(sb.toString());
                                                    long j20 = j9;
                                                    mm3 mm3Var2 = new mm3();
                                                    mm3Var2.f(bArrH);
                                                    mm3Var2.g(jE);
                                                    mm3Var2.i(j19);
                                                    mm3Var2.h(j8);
                                                    mm3Var2.j((mm3Var2.c() - j15) + 1);
                                                    this.D.add(mm3Var2);
                                                    sb.setLength(0);
                                                    jE2 = j19;
                                                    j9 = j20;
                                                    j2 = 4;
                                                    j10 = 0;
                                                } else {
                                                    jE2 = j19;
                                                    j10 = j15;
                                                }
                                                if (j9 > j2) {
                                                    j4 = this.K;
                                                    if (j8 >= j4) {
                                                        j3 = 0;
                                                        if (j4 != 0) {
                                                            j5 = j10 + 1;
                                                            if (j5 == 2) {
                                                                Log.d(N, "Normal部分：totalLine = " + j8 + ",mNormalCodeSubCm0StartLine = " + this.K);
                                                                if (sb.toString().equals(obj)) {
                                                                    throw new Exception("Normal部分：CM0文件开始Flag异常");
                                                                }
                                                                sb.setLength(0);
                                                            }
                                                            if (j5 <= 2 && j5 == 4) {
                                                                long jE5 = l63.e(l63.h(sb.toString())) + 2;
                                                                for (int i4 = 0; i4 < jE5; i4++) {
                                                                    bufferedReader.readLine();
                                                                }
                                                                sb.setLength(0);
                                                                this.L = j8 + jE5;
                                                                break;
                                                            }
                                                            j10 = j5;
                                                        } else {
                                                            j9 = j9;
                                                        }
                                                    } else {
                                                        j9 = j9;
                                                        j3 = 0;
                                                    }
                                                } else {
                                                    j9 = j9;
                                                    j3 = 0;
                                                }
                                                j9 = j9;
                                            }
                                            j2 = 4;
                                            if (j9 > j2) {
                                                j4 = this.K;
                                                if (j8 >= j4) {
                                                    j3 = 0;
                                                    if (j4 != 0) {
                                                        j5 = j10 + 1;
                                                        if (j5 == 2) {
                                                            Log.d(N, "Normal部分：totalLine = " + j8 + ",mNormalCodeSubCm0StartLine = " + this.K);
                                                            if (sb.toString().equals(obj)) {
                                                                throw new Exception("Normal部分：CM0文件开始Flag异常");
                                                            }
                                                            sb.setLength(0);
                                                        }
                                                        if (j5 <= 2) {
                                                        }
                                                        j10 = j5;
                                                    } else {
                                                        j9 = j9;
                                                    }
                                                } else {
                                                    j9 = j9;
                                                    j3 = 0;
                                                }
                                            } else {
                                                j9 = j9;
                                                j3 = 0;
                                            }
                                            j9 = j9;
                                        } else {
                                            j10 = j10;
                                        }
                                    } else {
                                        j = 0;
                                        j10 = j10;
                                        jE = jE;
                                    }
                                }
                            }
                            fileInputStream2.close();
                            bufferedReader.close();
                            fileInputStream2.close();
                            bufferedReader.close();
                        } catch (FileNotFoundException e) {
                            e = e;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        } catch (IOException e2) {
                            e = e2;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    throw th;
                                }
                            }
                            if (bufferedReader == null) {
                                throw th;
                            }
                            bufferedReader.close();
                            throw th;
                        }
                    } catch (FileNotFoundException e5) {
                        e = e5;
                        bufferedReader = null;
                    } catch (IOException e6) {
                        e = e6;
                        bufferedReader = null;
                    } catch (Exception e7) {
                        e = e7;
                        bufferedReader = null;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (FileNotFoundException e8) {
                e = e8;
                bufferedReader = null;
            } catch (IOException e9) {
                e = e9;
                bufferedReader = null;
            } catch (Exception e10) {
                e = e10;
                bufferedReader = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0249 A[Catch: all -> 0x0082, Exception -> 0x0087, IOException -> 0x008b, FileNotFoundException -> 0x008f, TryCatch #8 {FileNotFoundException -> 0x008f, IOException -> 0x008b, Exception -> 0x0087, all -> 0x0082, blocks: (B:9:0x0047, B:10:0x0051, B:12:0x0057, B:14:0x0067, B:16:0x006f, B:17:0x0077, B:19:0x007c, B:29:0x0093, B:32:0x00a1, B:36:0x00ad, B:45:0x00c6, B:47:0x00d0, B:48:0x00d5, B:49:0x00dc, B:53:0x00e5, B:54:0x00f4, B:56:0x00f9, B:57:0x00ff, B:61:0x0116, B:63:0x011c, B:65:0x0124, B:67:0x012a, B:69:0x0141, B:70:0x014f, B:72:0x0155, B:74:0x0165, B:76:0x016d, B:81:0x0196, B:82:0x019b, B:84:0x01a0, B:85:0x01a6, B:86:0x01b8, B:87:0x01bf, B:90:0x01c4, B:93:0x01ce, B:97:0x01e7, B:99:0x0200, B:101:0x0205, B:107:0x0249, B:111:0x0255, B:113:0x025b, B:115:0x0289, B:122:0x02a2, B:123:0x02b1, B:125:0x02b6, B:126:0x02bc, B:116:0x028e, B:117:0x0295, B:30:0x009d, B:133:0x02e8), top: B:190:0x0047 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x024f  */
    /* JADX WARN: Code duplicated, block: B:111:0x0255 A[Catch: all -> 0x0082, Exception -> 0x0087, IOException -> 0x008b, FileNotFoundException -> 0x008f, TryCatch #8 {FileNotFoundException -> 0x008f, IOException -> 0x008b, Exception -> 0x0087, all -> 0x0082, blocks: (B:9:0x0047, B:10:0x0051, B:12:0x0057, B:14:0x0067, B:16:0x006f, B:17:0x0077, B:19:0x007c, B:29:0x0093, B:32:0x00a1, B:36:0x00ad, B:45:0x00c6, B:47:0x00d0, B:48:0x00d5, B:49:0x00dc, B:53:0x00e5, B:54:0x00f4, B:56:0x00f9, B:57:0x00ff, B:61:0x0116, B:63:0x011c, B:65:0x0124, B:67:0x012a, B:69:0x0141, B:70:0x014f, B:72:0x0155, B:74:0x0165, B:76:0x016d, B:81:0x0196, B:82:0x019b, B:84:0x01a0, B:85:0x01a6, B:86:0x01b8, B:87:0x01bf, B:90:0x01c4, B:93:0x01ce, B:97:0x01e7, B:99:0x0200, B:101:0x0205, B:107:0x0249, B:111:0x0255, B:113:0x025b, B:115:0x0289, B:122:0x02a2, B:123:0x02b1, B:125:0x02b6, B:126:0x02bc, B:116:0x028e, B:117:0x0295, B:30:0x009d, B:133:0x02e8), top: B:190:0x0047 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x025b A[Catch: all -> 0x0082, Exception -> 0x0087, IOException -> 0x008b, FileNotFoundException -> 0x008f, TryCatch #8 {FileNotFoundException -> 0x008f, IOException -> 0x008b, Exception -> 0x0087, all -> 0x0082, blocks: (B:9:0x0047, B:10:0x0051, B:12:0x0057, B:14:0x0067, B:16:0x006f, B:17:0x0077, B:19:0x007c, B:29:0x0093, B:32:0x00a1, B:36:0x00ad, B:45:0x00c6, B:47:0x00d0, B:48:0x00d5, B:49:0x00dc, B:53:0x00e5, B:54:0x00f4, B:56:0x00f9, B:57:0x00ff, B:61:0x0116, B:63:0x011c, B:65:0x0124, B:67:0x012a, B:69:0x0141, B:70:0x014f, B:72:0x0155, B:74:0x0165, B:76:0x016d, B:81:0x0196, B:82:0x019b, B:84:0x01a0, B:85:0x01a6, B:86:0x01b8, B:87:0x01bf, B:90:0x01c4, B:93:0x01ce, B:97:0x01e7, B:99:0x0200, B:101:0x0205, B:107:0x0249, B:111:0x0255, B:113:0x025b, B:115:0x0289, B:122:0x02a2, B:123:0x02b1, B:125:0x02b6, B:126:0x02bc, B:116:0x028e, B:117:0x0295, B:30:0x009d, B:133:0x02e8), top: B:190:0x0047 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x0289 A[Catch: all -> 0x0082, Exception -> 0x0087, IOException -> 0x008b, FileNotFoundException -> 0x008f, TryCatch #8 {FileNotFoundException -> 0x008f, IOException -> 0x008b, Exception -> 0x0087, all -> 0x0082, blocks: (B:9:0x0047, B:10:0x0051, B:12:0x0057, B:14:0x0067, B:16:0x006f, B:17:0x0077, B:19:0x007c, B:29:0x0093, B:32:0x00a1, B:36:0x00ad, B:45:0x00c6, B:47:0x00d0, B:48:0x00d5, B:49:0x00dc, B:53:0x00e5, B:54:0x00f4, B:56:0x00f9, B:57:0x00ff, B:61:0x0116, B:63:0x011c, B:65:0x0124, B:67:0x012a, B:69:0x0141, B:70:0x014f, B:72:0x0155, B:74:0x0165, B:76:0x016d, B:81:0x0196, B:82:0x019b, B:84:0x01a0, B:85:0x01a6, B:86:0x01b8, B:87:0x01bf, B:90:0x01c4, B:93:0x01ce, B:97:0x01e7, B:99:0x0200, B:101:0x0205, B:107:0x0249, B:111:0x0255, B:113:0x025b, B:115:0x0289, B:122:0x02a2, B:123:0x02b1, B:125:0x02b6, B:126:0x02bc, B:116:0x028e, B:117:0x0295, B:30:0x009d, B:133:0x02e8), top: B:190:0x0047 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x0296  */
    /* JADX WARN: Code duplicated, block: B:125:0x02b6 A[Catch: all -> 0x0082, Exception -> 0x0087, IOException -> 0x008b, FileNotFoundException -> 0x008f, LOOP:5: B:123:0x02b1->B:125:0x02b6, LOOP_END, TryCatch #8 {FileNotFoundException -> 0x008f, IOException -> 0x008b, Exception -> 0x0087, all -> 0x0082, blocks: (B:9:0x0047, B:10:0x0051, B:12:0x0057, B:14:0x0067, B:16:0x006f, B:17:0x0077, B:19:0x007c, B:29:0x0093, B:32:0x00a1, B:36:0x00ad, B:45:0x00c6, B:47:0x00d0, B:48:0x00d5, B:49:0x00dc, B:53:0x00e5, B:54:0x00f4, B:56:0x00f9, B:57:0x00ff, B:61:0x0116, B:63:0x011c, B:65:0x0124, B:67:0x012a, B:69:0x0141, B:70:0x014f, B:72:0x0155, B:74:0x0165, B:76:0x016d, B:81:0x0196, B:82:0x019b, B:84:0x01a0, B:85:0x01a6, B:86:0x01b8, B:87:0x01bf, B:90:0x01c4, B:93:0x01ce, B:97:0x01e7, B:99:0x0200, B:101:0x0205, B:107:0x0249, B:111:0x0255, B:113:0x025b, B:115:0x0289, B:122:0x02a2, B:123:0x02b1, B:125:0x02b6, B:126:0x02bc, B:116:0x028e, B:117:0x0295, B:30:0x009d, B:133:0x02e8), top: B:190:0x0047 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:129:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:203:0x028e A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:113:0x025b, please report this as an issue */
    private void b() throws Throwable {
        Throwable th;
        BufferedReader bufferedReader;
        long j;
        long jE;
        long j2;
        long j3;
        long j4;
        long jE2;
        int i;
        long j5;
        long j6;
        File file = new File(this.e);
        if (!file.exists()) {
            Log.e(N, "analyzeFlashOTAPart()-->文件不存在!");
            return;
        }
        Log.d(N, "解析OTA部分...");
        this.u = new ArrayList();
        this.v = 0L;
        this.w = 0L;
        this.x = 0L;
        this.y = 0L;
        this.z = 0L;
        this.A = 0L;
        this.B = 0L;
        this.C = 0L;
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2));
                        try {
                            StringBuilder sb = new StringBuilder();
                            long j7 = 0;
                            long j8 = 0;
                            long j9 = 0;
                            long j10 = 0;
                            long j11 = 0;
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                long j12 = j7 + 1;
                                sb.append(line);
                                if (j12 == 1) {
                                    long j13 = this.k;
                                    long j14 = j7 + 2;
                                    if (j13 > j14) {
                                        this.v = j13 + 3;
                                        long j15 = (j13 + 3) - j14;
                                        for (int i2 = 0; i2 < j15; i2++) {
                                            bufferedReader.readLine();
                                        }
                                        sb.setLength(0);
                                        j7 = j12 + j15;
                                        j8 = 0;
                                    } else {
                                        this.l = j13;
                                        j7 = j12;
                                    }
                                } else {
                                    j7 = j12;
                                }
                                long j16 = this.v;
                                if (j16 <= 0 || j7 < j16) {
                                    j = 0;
                                    j10 = j10;
                                } else {
                                    long j17 = this.l;
                                    if (j17 == 0 || j7 < j17) {
                                        j8++;
                                        if (j8 == 2) {
                                            if (!sb.toString().equals("aa55")) {
                                                throw new Exception("OTA部分：文件开始Flag异常");
                                            }
                                            sb.setLength(0);
                                        }
                                        if (j8 > 2) {
                                            long j18 = 4;
                                            if (j8 == 4) {
                                                long jE3 = l63.e(l63.h(sb.toString()));
                                                for (int i3 = 0; i3 < jE3; i3++) {
                                                    bufferedReader.readLine();
                                                }
                                                j7 += jE3;
                                                j8 += jE3;
                                                sb.setLength(0);
                                                this.w = j7;
                                                this.x = j7 + 1;
                                                j18 = 4;
                                                j9 = 0;
                                            }
                                            if (j8 <= j18 || j7 < this.x || this.B != 0) {
                                                jE = j10;
                                            } else {
                                                long j19 = j9 + 1;
                                                if (j19 <= 2) {
                                                    if (!sb.toString().equals("aa55".substring(0, sb.toString().length()))) {
                                                        this.y = j7 - 1;
                                                        this.z = j7;
                                                        long jE4 = 0;
                                                        for (mm3 mm3Var : this.u) {
                                                            if (mm3Var.d() == 18555 && mm3Var.b() == 3) {
                                                                jE4 = l63.e(mm3Var.a());
                                                                Log.d(N, "OTA部分：xipStartLine = " + jE4);
                                                            }
                                                        }
                                                        if (jE4 == 0 || jE4 < j8) {
                                                            throw new Exception("OTA部分：未找到CM0代码");
                                                        }
                                                        long j20 = (jE4 - j8) - 7;
                                                        for (int i4 = 0; i4 < j20; i4++) {
                                                            bufferedReader.readLine();
                                                        }
                                                        j7 += j20;
                                                        j8 += j20;
                                                        sb.setLength(0);
                                                        this.A = j7;
                                                        this.B = j7 + 1;
                                                        sb.setLength(0);
                                                        j19 = 0;
                                                    }
                                                    if (j19 == 2) {
                                                        sb.setLength(0);
                                                    }
                                                }
                                                if (j19 == 4) {
                                                    jE = l63.e(l63.h(sb.toString()));
                                                    sb.setLength(0);
                                                } else {
                                                    jE = j10;
                                                }
                                                if (j19 == 6) {
                                                    long jE5 = l63.e(l63.h(sb.toString()));
                                                    sb.setLength(0);
                                                    j5 = jE5;
                                                    j6 = 6;
                                                } else {
                                                    j5 = j11;
                                                    j6 = 6;
                                                }
                                                if (j19 == j6 + jE) {
                                                    byte[] bArrH = l63.h(sb.toString());
                                                    long j21 = j8;
                                                    mm3 mm3Var2 = new mm3();
                                                    mm3Var2.f(bArrH);
                                                    mm3Var2.g(jE);
                                                    mm3Var2.i(j5);
                                                    mm3Var2.h(j7);
                                                    mm3Var2.j((mm3Var2.c() - j19) + 1);
                                                    this.u.add(mm3Var2);
                                                    sb.setLength(0);
                                                    j11 = j5;
                                                    j8 = j21;
                                                    j2 = 4;
                                                    j9 = 0;
                                                } else {
                                                    j11 = j5;
                                                    j9 = j19;
                                                }
                                                if (j8 > j2) {
                                                    j4 = this.B;
                                                    if (j7 >= j4) {
                                                        j3 = 0;
                                                        if (j4 != 0) {
                                                            j9++;
                                                            if (j9 == 2) {
                                                                Log.d(N, "OTA部分：totalLine = " + j7 + ",mOTACodeSubCm0StartLine = " + this.B);
                                                                if (sb.toString().equals("aa55")) {
                                                                    throw new Exception("OTA部分：CM0文件开始Flag异常");
                                                                }
                                                                sb.setLength(0);
                                                            }
                                                            if (j9 > 2 && j9 == 4) {
                                                                jE2 = l63.e(l63.h(sb.toString())) + 2;
                                                                for (i = 0; i < jE2; i++) {
                                                                    bufferedReader.readLine();
                                                                }
                                                                sb.setLength(0);
                                                                this.C = j7 + jE2;
                                                                break;
                                                            }
                                                        } else {
                                                            j8 = j8;
                                                            jE = jE;
                                                        }
                                                    } else {
                                                        j8 = j8;
                                                        jE = jE;
                                                        j3 = 0;
                                                    }
                                                } else {
                                                    j8 = j8;
                                                    jE = jE;
                                                    j3 = 0;
                                                }
                                                j8 = j8;
                                                j10 = jE;
                                            }
                                            j2 = 4;
                                            if (j8 > j2) {
                                                j4 = this.B;
                                                if (j7 >= j4) {
                                                    j3 = 0;
                                                    if (j4 != 0) {
                                                        j9++;
                                                        if (j9 == 2) {
                                                            Log.d(N, "OTA部分：totalLine = " + j7 + ",mOTACodeSubCm0StartLine = " + this.B);
                                                            if (sb.toString().equals("aa55")) {
                                                                throw new Exception("OTA部分：CM0文件开始Flag异常");
                                                            }
                                                            sb.setLength(0);
                                                        }
                                                        if (j9 > 2) {
                                                            jE2 = l63.e(l63.h(sb.toString())) + 2;
                                                            while (i < jE2) {
                                                                bufferedReader.readLine();
                                                            }
                                                            sb.setLength(0);
                                                            this.C = j7 + jE2;
                                                            break;
                                                        }
                                                    } else {
                                                        j8 = j8;
                                                        jE = jE;
                                                    }
                                                } else {
                                                    j8 = j8;
                                                    jE = jE;
                                                    j3 = 0;
                                                }
                                            } else {
                                                j8 = j8;
                                                jE = jE;
                                                j3 = 0;
                                            }
                                            j8 = j8;
                                            j10 = jE;
                                        }
                                    } else {
                                        j = 0;
                                        j10 = j10;
                                    }
                                }
                            }
                            fileInputStream2.close();
                            bufferedReader.close();
                            fileInputStream2.close();
                            bufferedReader.close();
                        } catch (FileNotFoundException e) {
                            e = e;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        } catch (IOException e2) {
                            e = e2;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    throw th;
                                }
                            }
                            if (bufferedReader == null) {
                                throw th;
                            }
                            bufferedReader.close();
                            throw th;
                        }
                    } catch (FileNotFoundException e5) {
                        e = e5;
                        bufferedReader = null;
                    } catch (IOException e6) {
                        e = e6;
                        bufferedReader = null;
                    } catch (Exception e7) {
                        e = e7;
                        bufferedReader = null;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                    }
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            } catch (FileNotFoundException e9) {
                e = e9;
                bufferedReader = null;
            } catch (IOException e10) {
                e = e10;
                bufferedReader = null;
            } catch (Exception e11) {
                e = e11;
                bufferedReader = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x0103 A[Catch: IOException -> 0x00ff, TRY_LEAVE, TryCatch #7 {IOException -> 0x00ff, blocks: (B:53:0x00fb, B:57:0x0103), top: B:79:0x00fb }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0119 A[Catch: IOException -> 0x0115, TRY_LEAVE, TryCatch #3 {IOException -> 0x0115, blocks: (B:65:0x0111, B:69:0x0119), top: B:76:0x0111 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0111 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:? A[SYNTHETIC] */
    private long c() throws Throwable {
        Throwable th;
        BufferedReader bufferedReader;
        File file = new File(this.e);
        long j = 0;
        if (!file.exists()) {
            Log.e(N, "analyzeFlashUIPart()-->文件不存在!");
            return 0L;
        }
        Log.d(N, "解析Font...");
        HashMap map = new HashMap();
        this.i = 0L;
        FileInputStream fileInputStream = null;
        this.M = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2));
                int i = 0;
                long j2 = 0;
                while (true) {
                    try {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            long j3 = j2 + 1;
                            if (j3 == 1) {
                                long j4 = this.f456q;
                                long j5 = j2 + 2;
                                if (j4 > j5) {
                                    long j6 = j4 - j5;
                                    for (int i2 = 0; i2 < j6; i2++) {
                                        bufferedReader.readLine();
                                    }
                                    j3 += j6;
                                } else {
                                    this.r = j4;
                                }
                            }
                            j2 = j3;
                            if (j2 >= this.f456q) {
                                map.put(Integer.valueOf(i), line);
                                i++;
                            }
                        } catch (IOException e) {
                            e = e;
                            fileInputStream = fileInputStream2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                throw th;
                            }
                        }
                        if (bufferedReader != null) {
                            throw th;
                        }
                        bufferedReader.close();
                        throw th;
                    }
                    try {
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        } else if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return j;
                    } catch (Throwable th3) {
                        th = th3;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (bufferedReader != null) {
                            throw th;
                        }
                        bufferedReader.close();
                        throw th;
                    }
                }
                Iterator it = map.keySet().iterator();
                long jA = 0;
                while (it.hasNext()) {
                    jA += (long) q60.a((String) map.get((Integer) it.next()));
                }
                Log.d(N, "uiIconCheckSum = " + jA);
                try {
                    long j7 = this.f456q;
                    long j8 = (j2 - j7) + 1;
                    this.i = j8;
                    this.M = new nm3(j7, j2, j8, jA);
                    fileInputStream2.close();
                    bufferedReader.close();
                    try {
                        fileInputStream2.close();
                        bufferedReader.close();
                        return j2;
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        return j2;
                    }
                } catch (IOException e5) {
                    e = e5;
                    fileInputStream = fileInputStream2;
                    j = j2;
                }
            } catch (IOException e6) {
                e = e6;
                bufferedReader = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (IOException e7) {
            e = e7;
            bufferedReader = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
        }
    }

    public static String d(a aVar, ArrayList arrayList) throws Throwable {
        if (aVar == null || arrayList == null) {
            return null;
        }
        Log.d(N, "paramList.size() = " + arrayList.size());
        String strU = u(dm3.b, aVar.e);
        String str = aVar.e;
        int i = aVar.d;
        Iterator it = arrayList.iterator();
        a aVar2 = aVar;
        while (it.hasNext()) {
            lm3 lm3Var = (lm3) it.next();
            String strU2 = u(dm3.c, new Date().toString() + new Random().nextDouble());
            e(aVar2, strU2, lm3Var);
            aVar2 = new a(strU2, i);
            aVar2.a();
            str = strU2;
        }
        ym0.a(str, strU);
        ym0.f(dm3.c);
        Log.d(N, "changeDataFileInfo(): fileUtil.mFilePath: " + aVar.e + ", storeFilePath: " + strU);
        return strU;
    }

    /* JADX WARN: Code duplicated, block: B:153:0x03ac A[Catch: IOException -> 0x0359, TRY_ENTER, TryCatch #0 {IOException -> 0x0359, blocks: (B:153:0x03ac, B:155:0x03b1, B:157:0x03b6, B:159:0x03be, B:165:0x03cd, B:167:0x03d2, B:169:0x03d7, B:171:0x03df, B:120:0x0345), top: B:189:0x014a }] */
    /* JADX WARN: Code duplicated, block: B:155:0x03b1 A[Catch: IOException -> 0x0359, TryCatch #0 {IOException -> 0x0359, blocks: (B:153:0x03ac, B:155:0x03b1, B:157:0x03b6, B:159:0x03be, B:165:0x03cd, B:167:0x03d2, B:169:0x03d7, B:171:0x03df, B:120:0x0345), top: B:189:0x014a }] */
    /* JADX WARN: Code duplicated, block: B:157:0x03b6 A[Catch: IOException -> 0x0359, TryCatch #0 {IOException -> 0x0359, blocks: (B:153:0x03ac, B:155:0x03b1, B:157:0x03b6, B:159:0x03be, B:165:0x03cd, B:167:0x03d2, B:169:0x03d7, B:171:0x03df, B:120:0x0345), top: B:189:0x014a }] */
    /* JADX WARN: Code duplicated, block: B:159:0x03be A[Catch: IOException -> 0x0359, TRY_LEAVE, TryCatch #0 {IOException -> 0x0359, blocks: (B:153:0x03ac, B:155:0x03b1, B:157:0x03b6, B:159:0x03be, B:165:0x03cd, B:167:0x03d2, B:169:0x03d7, B:171:0x03df, B:120:0x0345), top: B:189:0x014a }] */
    /* JADX WARN: Code duplicated, block: B:179:0x0411 A[Catch: IOException -> 0x040d, TryCatch #8 {IOException -> 0x040d, blocks: (B:175:0x0409, B:179:0x0411, B:181:0x0416, B:183:0x041e), top: B:192:0x0409 }] */
    /* JADX WARN: Code duplicated, block: B:181:0x0416 A[Catch: IOException -> 0x040d, TryCatch #8 {IOException -> 0x040d, blocks: (B:175:0x0409, B:179:0x0411, B:181:0x0416, B:183:0x041e), top: B:192:0x0409 }] */
    /* JADX WARN: Code duplicated, block: B:183:0x041e A[Catch: IOException -> 0x040d, TRY_LEAVE, TryCatch #8 {IOException -> 0x040d, blocks: (B:175:0x0409, B:179:0x0411, B:181:0x0416, B:183:0x041e), top: B:192:0x0409 }] */
    /* JADX WARN: Code duplicated, block: B:192:0x0409 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:225:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x0246 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x0248 A[Catch: all -> 0x0193, IOException -> 0x0198, FileNotFoundException -> 0x019c, TryCatch #13 {all -> 0x0193, blocks: (B:50:0x0164, B:55:0x0173, B:57:0x017b, B:61:0x018d, B:69:0x01a0, B:71:0x01ab, B:88:0x023f, B:91:0x0248, B:92:0x025e, B:94:0x0266, B:108:0x02f0, B:111:0x02f9, B:112:0x02ff, B:114:0x0304, B:115:0x030a, B:117:0x030f, B:78:0x01e6, B:80:0x01f2, B:81:0x0201, B:83:0x0206, B:84:0x020c, B:86:0x0217, B:98:0x0294, B:100:0x02a4, B:101:0x02b3, B:103:0x02b8, B:104:0x02be, B:106:0x02c8, B:119:0x0331), top: B:194:0x0164 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0266 A[Catch: all -> 0x0193, IOException -> 0x0198, FileNotFoundException -> 0x019c, LOOP:5: B:93:0x0264->B:94:0x0266, LOOP_END, TryCatch #13 {all -> 0x0193, blocks: (B:50:0x0164, B:55:0x0173, B:57:0x017b, B:61:0x018d, B:69:0x01a0, B:71:0x01ab, B:88:0x023f, B:91:0x0248, B:92:0x025e, B:94:0x0266, B:108:0x02f0, B:111:0x02f9, B:112:0x02ff, B:114:0x0304, B:115:0x030a, B:117:0x030f, B:78:0x01e6, B:80:0x01f2, B:81:0x0201, B:83:0x0206, B:84:0x020c, B:86:0x0217, B:98:0x0294, B:100:0x02a4, B:101:0x02b3, B:103:0x02b8, B:104:0x02be, B:106:0x02c8, B:119:0x0331), top: B:194:0x0164 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x028f  */
    /* JADX WARN: Instruction removed from duplicated block: B:91:0x0248, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:94:0x0266, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v21, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r12v31 */
    /* JADX WARN: Type inference failed for: r12v32 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.io.BufferedOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.io.BufferedOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29, types: [java.io.BufferedOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v36 */
    /* JADX WARN: Type inference failed for: r9v37 */
    /* JADX WARN: Type inference failed for: r9v38 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.BufferedOutputStream, java.io.OutputStream] */
    private static void e(a aVar, String str, lm3 lm3Var) throws Throwable {
        FileInputStream fileInputStream;
        mm3 mm3Var;
        lm3 lm3Var2;
        lm3 lm3Var3;
        ?? fileOutputStream;
        Throwable th;
        ?? r6;
        ?? r9;
        ?? r12;
        String str2;
        boolean z;
        int i;
        String str3 = N;
        Log.d(str3, "changeDataParamToSingleCodeFile(): srcPath: " + aVar.e + ", afterPath: " + str);
        StringBuilder sb = new StringBuilder();
        sb.append("modifyUnit.getUnitLength() = ");
        sb.append(lm3Var.f());
        Log.d(str3, sb.toString());
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = aVar.D;
        int size = arrayList.size() - 1;
        while (true) {
            fileInputStream = null;
            if (size < 0) {
                mm3Var = null;
                break;
            }
            mm3Var = (mm3) arrayList.get(size);
            if (mm3Var.b() == lm3Var.a() && mm3Var.d() == lm3Var.b()) {
                break;
            } else {
                size--;
            }
        }
        mm3 mm3Var2 = null;
        mm3 mm3Var3 = null;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            mm3 mm3Var4 = (mm3) arrayList.get(i2);
            if (mm3Var4.d() == 18555 && mm3Var4.b() == 3) {
                mm3Var2 = mm3Var4;
            } else if (mm3Var4.d() == Q && mm3Var4.b() == 3) {
                mm3Var3 = mm3Var4;
            }
        }
        if (mm3Var2 == null) {
            Log.e(N, "changeDataParamToSingleCodeFile(): xipDataUnit == null ");
            return;
        }
        if (mm3Var3 == null) {
            Log.e(N, "changeDataParamToSingleCodeFile(): xxxLengthDataUnit == null ");
            return;
        }
        if (mm3Var == null) {
            lm3Var2 = new lm3(mm3Var2);
            lm3Var2.g(l63.e(mm3Var2.a()) + ((long) lm3Var.f()));
            lm3Var3 = new lm3(mm3Var3);
            lm3Var3.g(l63.e(mm3Var3.a()) + ((long) lm3Var.f()));
        } else {
            lm3Var2 = null;
            lm3Var3 = null;
        }
        ?? file = new File(aVar.e);
        if (!file.exists()) {
            Log.e(N, "要修改的文件不存在!");
            return;
        }
        ?? file2 = new File(str);
        if (ym0.i(file2)) {
            String str4 = N;
            Log.d(str4, "参数称修改后存放的文件" + str + "已存在！");
            fileOutputStream = str4;
        } else {
            if (!ym0.d(file2)) {
                Log.e(N, "参数修改后存放的文件创建失败！");
                return;
            }
            String str5 = N;
            Log.d(str5, "参数修改后存放的文件创建成功：" + str);
            fileOutputStream = str5;
        }
        try {
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream((File) file);
                    try {
                        file = new BufferedReader(new InputStreamReader(fileInputStream2));
                        try {
                            fileOutputStream = new FileOutputStream((File) file2);
                            try {
                                file2 = new BufferedOutputStream(fileOutputStream);
                                int i3 = 0;
                                while (true) {
                                    try {
                                        try {
                                            String line = file.readLine();
                                            if (line == null) {
                                                break;
                                            }
                                            i3++;
                                            if (mm3Var == null) {
                                                String str6 = "\r\n";
                                                long j = i3;
                                                if (j == mm3Var2.e()) {
                                                    long jC = mm3Var2.c() - mm3Var2.e();
                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                    for (int i4 = 0; i4 < jC; i4++) {
                                                        try {
                                                            file.readLine();
                                                        } catch (FileNotFoundException e) {
                                                            e = e;
                                                        } catch (IOException e2) {
                                                            e = e2;
                                                            fileInputStream = fileInputStream2;
                                                            file = file;
                                                            file2 = file2;
                                                            fileOutputStream = fileOutputStream;
                                                            e.printStackTrace();
                                                            if (fileInputStream != null) {
                                                                fileInputStream.close();
                                                            }
                                                            if (file != 0) {
                                                                file.close();
                                                            }
                                                            if (file2 != 0) {
                                                                file2.flush();
                                                                file2.close();
                                                            }
                                                            if (fileOutputStream != 0) {
                                                                fileOutputStream.flush();
                                                                fileOutputStream.close();
                                                            }
                                                            Log.i(N, "FileOutputStream执行耗时:" + (System.currentTimeMillis() - jCurrentTimeMillis) + " 毫秒");
                                                        }
                                                    }
                                                    i3 = (int) (j + jC);
                                                    byte[] bArrE = lm3Var2.e();
                                                    int length = bArrE.length;
                                                    int i5 = 0;
                                                    while (i5 < length) {
                                                        byte b = bArrE[i5];
                                                        byte[] bArr = bArrE;
                                                        StringBuilder sb2 = new StringBuilder();
                                                        sb2.append(l63.a(b).toLowerCase());
                                                        String str7 = str6;
                                                        sb2.append(str7);
                                                        file2.write(sb2.toString().getBytes());
                                                        i5++;
                                                        str6 = str7;
                                                        bArrE = bArr;
                                                    }
                                                    str2 = str6;
                                                } else {
                                                    jCurrentTimeMillis = jCurrentTimeMillis;
                                                    str2 = str6;
                                                    if (j == mm3Var3.e()) {
                                                        long jC2 = mm3Var3.c() - mm3Var3.e();
                                                        for (int i6 = 0; i6 < jC2; i6++) {
                                                            file.readLine();
                                                        }
                                                        i3 = (int) (j + jC2);
                                                        for (byte b2 : lm3Var3.e()) {
                                                            file2.write((l63.a(b2).toLowerCase() + str2).getBytes());
                                                        }
                                                    } else {
                                                        mm3Var2 = mm3Var2;
                                                        mm3Var3 = mm3Var3;
                                                        z = true;
                                                    }
                                                    if (i3 == aVar.H) {
                                                        if (z) {
                                                            file2.write((line + str2).getBytes());
                                                        }
                                                        for (byte b3 : lm3Var.e()) {
                                                            file2.write((l63.a(b3).toLowerCase() + str2).getBytes());
                                                        }
                                                        z = false;
                                                    } else {
                                                        lm3Var2 = lm3Var2;
                                                        lm3Var3 = lm3Var3;
                                                    }
                                                }
                                                z = false;
                                                if (i3 == aVar.H) {
                                                    if (z) {
                                                        file2.write((line + str2).getBytes());
                                                    }
                                                    while (i < r10) {
                                                        file2.write((l63.a(b3).toLowerCase() + str2).getBytes());
                                                    }
                                                    z = false;
                                                } else {
                                                    lm3Var2 = lm3Var2;
                                                    lm3Var3 = lm3Var3;
                                                }
                                            } else {
                                                jCurrentTimeMillis = jCurrentTimeMillis;
                                                mm3Var2 = mm3Var2;
                                                mm3Var3 = mm3Var3;
                                                str2 = "\r\n";
                                                long j2 = i3;
                                                if (j2 == mm3Var.e()) {
                                                    long jC3 = mm3Var.c() - mm3Var.e();
                                                    for (int i7 = 0; i7 < jC3; i7++) {
                                                        file.readLine();
                                                    }
                                                    i3 = (int) (j2 + jC3);
                                                    for (byte b4 : lm3Var.e()) {
                                                        file2.write((l63.a(b4).toLowerCase() + str2).getBytes());
                                                    }
                                                    z = false;
                                                } else {
                                                    lm3Var2 = lm3Var2;
                                                    lm3Var3 = lm3Var3;
                                                    z = true;
                                                }
                                            }
                                            long j3 = i3;
                                            if (j3 == aVar.n && mm3Var == null) {
                                                long jF = lm3Var.f();
                                                for (int i8 = 0; i8 < jF; i8++) {
                                                    file.readLine();
                                                }
                                                i3 = (int) (j3 + jF);
                                            }
                                            if (z) {
                                                file2.write((line + str2).getBytes());
                                            }
                                            lm3Var2 = lm3Var2;
                                            lm3Var3 = lm3Var3;
                                            jCurrentTimeMillis = jCurrentTimeMillis;
                                            mm3Var2 = mm3Var2;
                                            mm3Var3 = mm3Var3;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            fileInputStream = fileInputStream2;
                                            th = th;
                                            r6 = file;
                                            r9 = file2;
                                            r12 = fileOutputStream;
                                            if (fileInputStream != null) {
                                                try {
                                                    fileInputStream.close();
                                                } catch (IOException e3) {
                                                    e3.printStackTrace();
                                                    throw th;
                                                }
                                            }
                                            if (r6 != 0) {
                                                r6.close();
                                            }
                                            if (r9 != 0) {
                                                r9.flush();
                                                r9.close();
                                            }
                                            if (r12 == 0) {
                                                throw th;
                                            }
                                            r12.flush();
                                            r12.close();
                                            throw th;
                                        }
                                    } catch (FileNotFoundException e4) {
                                        e = e4;
                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                    } catch (IOException e5) {
                                        e = e5;
                                        jCurrentTimeMillis = jCurrentTimeMillis;
                                    }
                                    fileInputStream = fileInputStream2;
                                    file = file;
                                    file2 = file2;
                                    fileOutputStream = fileOutputStream;
                                    e.printStackTrace();
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                    if (file != 0) {
                                        file.close();
                                    }
                                    if (file2 != 0) {
                                        file2.flush();
                                        file2.close();
                                    }
                                    if (fileOutputStream != 0) {
                                        fileOutputStream.flush();
                                        fileOutputStream.close();
                                    }
                                    Log.i(N, "FileOutputStream执行耗时:" + (System.currentTimeMillis() - jCurrentTimeMillis) + " 毫秒");
                                }
                                jCurrentTimeMillis = jCurrentTimeMillis;
                                fileInputStream2.close();
                                file.close();
                                file2.flush();
                                file2.close();
                                fileOutputStream.flush();
                                fileOutputStream.close();
                                fileInputStream2.close();
                                file.close();
                                file2.flush();
                                file2.close();
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            } catch (FileNotFoundException e6) {
                                e = e6;
                                jCurrentTimeMillis = jCurrentTimeMillis;
                                file2 = 0;
                            } catch (IOException e7) {
                                e = e7;
                                jCurrentTimeMillis = jCurrentTimeMillis;
                                file2 = 0;
                            } catch (Throwable th3) {
                                th = th3;
                                file2 = 0;
                            }
                        } catch (FileNotFoundException e8) {
                            e = e8;
                            file2 = 0;
                            file = file;
                            fileOutputStream = file2;
                        } catch (IOException e9) {
                            e = e9;
                            file2 = 0;
                            file = file;
                            fileOutputStream = file2;
                            fileInputStream = fileInputStream2;
                            file = file;
                            file2 = file2;
                            fileOutputStream = fileOutputStream;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (file != 0) {
                                file.close();
                            }
                            if (file2 != 0) {
                                file2.flush();
                                file2.close();
                            }
                            if (fileOutputStream != 0) {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            }
                            Log.i(N, "FileOutputStream执行耗时:" + (System.currentTimeMillis() - jCurrentTimeMillis) + " 毫秒");
                        } catch (Throwable th4) {
                            th = th4;
                            file2 = 0;
                            file = file;
                            fileOutputStream = file2;
                            fileInputStream = fileInputStream2;
                            th = th;
                            r6 = file;
                            r9 = file2;
                            r12 = fileOutputStream;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (r6 != 0) {
                                r6.close();
                            }
                            if (r9 != 0) {
                                r9.flush();
                                r9.close();
                            }
                            if (r12 == 0) {
                                throw th;
                            }
                            r12.flush();
                            r12.close();
                            throw th;
                        }
                    } catch (FileNotFoundException e10) {
                        e = e10;
                        file = 0;
                        file2 = 0;
                    } catch (IOException e11) {
                        e = e11;
                        file = 0;
                        file2 = 0;
                    } catch (Throwable th5) {
                        th = th5;
                        file = 0;
                        file2 = 0;
                    }
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (FileNotFoundException e13) {
            e = e13;
            jCurrentTimeMillis = jCurrentTimeMillis;
            file = 0;
            file2 = 0;
            fileOutputStream = 0;
        } catch (IOException e14) {
            e = e14;
            jCurrentTimeMillis = jCurrentTimeMillis;
            file = 0;
            file2 = 0;
            fileOutputStream = 0;
        } catch (Throwable th7) {
            th = th7;
            r6 = 0;
            r9 = 0;
            r12 = 0;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (r6 != 0) {
                r6.close();
            }
            if (r9 != 0) {
                r9.flush();
                r9.close();
            }
            if (r12 == 0) {
                throw th;
            }
            r12.flush();
            r12.close();
            throw th;
        }
        Log.i(N, "FileOutputStream执行耗时:" + (System.currentTimeMillis() - jCurrentTimeMillis) + " 毫秒");
    }

    private void i() {
        long jT = t(20287, 3);
        this.a = jT;
        this.o = jT + 1;
        long jT2 = t(O, P);
        this.h = jT2;
        this.p = this.a + jT2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.BufferedReader] */
    static Map j(String str, long j, long j2, int i, int i2) throws Throwable {
        Throwable th;
        ?? r9;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        int i3;
        File file = new File(str);
        FileInputStream fileInputStream = null;
        if (!file.exists()) {
            return null;
        }
        int i4 = i2 - 5;
        int i5 = i % i4;
        int i6 = (i / i4) + (i5 > 0 ? 1 : 0);
        String str2 = N;
        StringBuilder sb = new StringBuilder();
        sb.append("perBuckPackNum = ");
        sb.append(i6);
        ?? r10 = ",tackSurplus:";
        sb.append(",tackSurplus:");
        sb.append(i5);
        Log.d(str2, sb.toString());
        HashMap map = new HashMap();
        try {
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream2));
                        try {
                            try {
                                StringBuilder sb2 = new StringBuilder();
                                long j3 = 0;
                                int i7 = 0;
                                int i8 = 0;
                                do {
                                    String line = bufferedReader2.readLine();
                                    if (line == null) {
                                        break;
                                    }
                                    long j4 = j3 + 1;
                                    if (j4 == 1) {
                                        long j5 = j3 + 2;
                                        if (j > j5) {
                                            long j6 = j - j5;
                                            for (int i9 = 0; i9 < j6; i9++) {
                                                bufferedReader2.readLine();
                                            }
                                            j4 += j6;
                                        }
                                    }
                                    j3 = j4;
                                    if (j3 >= j && j3 <= j2) {
                                        int i10 = (i5 != 0 && (i8 + 1) % i6 == 0) ? i5 : i4;
                                        sb2.append(line);
                                        i7++;
                                        if (i7 >= i10) {
                                            map.put(Integer.valueOf(i8), sb2.toString());
                                            sb2.setLength(0);
                                            i8++;
                                            i7 = 0;
                                        }
                                    }
                                } while (j3 <= j2);
                                if (i7 > 0) {
                                    map.put(Integer.valueOf(i8), sb2.toString());
                                    i3 = 0;
                                    sb2.setLength(0);
                                    i8++;
                                } else {
                                    i3 = 0;
                                }
                                Log.d(N, "packetNum = " + i8);
                                int length = i3;
                                int length2 = length;
                                for (Integer num : map.keySet()) {
                                    length += ((String) map.get(num)).length() / 2;
                                    if ((num.intValue() + 1) % i6 == 0) {
                                        Log.d(N, num + "：buck = " + length);
                                        length = i3;
                                    }
                                    if (num.intValue() + 1 == map.size()) {
                                        Log.d(N, num + "：buck = " + length);
                                        length = i3;
                                    }
                                    length2 += ((String) map.get(num)).length() / 2;
                                }
                                Log.d(N, "dataNum = " + length2);
                                try {
                                    fileInputStream2.close();
                                    bufferedReader2.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                fileInputStream2.close();
                                bufferedReader2.close();
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedReader = bufferedReader2;
                                fileInputStream = fileInputStream2;
                                r9 = bufferedReader;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (r9 == 0) {
                                    throw th;
                                }
                                r9.close();
                                throw th;
                            }
                        } catch (FileNotFoundException e3) {
                            e = e3;
                            fileInputStream = fileInputStream2;
                            r10 = bufferedReader2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (r10 != 0) {
                                r10.close();
                            }
                        } catch (IOException e4) {
                            e = e4;
                            fileInputStream = fileInputStream2;
                            r10 = bufferedReader2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (r10 != 0) {
                                r10.close();
                            }
                        }
                    } catch (FileNotFoundException e5) {
                        e = e5;
                        bufferedReader2 = null;
                    } catch (IOException e6) {
                        e = e6;
                        bufferedReader2 = null;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    r9 = r10;
                }
            } catch (FileNotFoundException e7) {
                e = e7;
                r10 = 0;
            } catch (IOException e8) {
                e = e8;
                r10 = 0;
            } catch (Throwable th5) {
                th = th5;
                r9 = 0;
            }
        } catch (IOException e9) {
            e9.printStackTrace();
        }
        return map;
    }

    private void l() {
        long jT = t(20290, 3);
        this.b = jT;
        this.s = jT + 1;
        long jT2 = t(20281, 3);
        this.j = jT2;
        this.t = this.b + jT2;
    }

    private long n() throws Throwable {
        a();
        ArrayList arrayList = this.D;
        if (arrayList == null) {
            Log.e(N, "mNormalPartBtDataList == null !!");
            return -1L;
        }
        if (arrayList.size() != 0) {
            return t(20276, 3);
        }
        Log.e(N, "mNormalPartBtDataList.size() == 0 !!");
        return -1L;
    }

    private long p() throws Throwable {
        b();
        ArrayList arrayList = this.D;
        if (arrayList == null) {
            Log.e(N, "mNormalPartBtDataList == null !!");
            return -1L;
        }
        if (arrayList.size() != 0) {
            return t(20274, 2);
        }
        Log.e(N, "mNormalPartBtDataList.size() == 0 !!");
        return -1L;
    }

    private void r() {
        long jT = t(20293, 3);
        this.c = jT;
        this.f456q = jT + 1;
        this.r = c();
    }

    private static String s(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes(Constants.ENC_UTF_8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException unused) {
            System.out.println("NoSuchAlgorithmException caught!");
            System.exit(-1);
        }
        byte[] bArrDigest = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArrDigest.length; i++) {
            if (Integer.toHexString(bArrDigest[i] & 255).length() == 1) {
                stringBuffer.append("0");
                stringBuffer.append(Integer.toHexString(bArrDigest[i] & 255));
            } else {
                stringBuffer.append(Integer.toHexString(bArrDigest[i] & 255));
            }
        }
        return stringBuffer.substring(8, 24).toString().toUpperCase();
    }

    private long t(int i, int i2) {
        ArrayList arrayList = this.D;
        long jE = -1;
        if (arrayList == null) {
            Log.e(N, "mNormalPartBtDataList == null !!");
            return -1L;
        }
        if (arrayList.size() == 0) {
            Log.e(N, "mNormalPartBtDataList.size() == 0 !!");
            return -1L;
        }
        for (mm3 mm3Var : this.D) {
            if (mm3Var.d() == 20274) {
                int iD = (int) (((long) i) - mm3Var.d());
                int i3 = (iD + i2) - 1;
                if (iD >= 0 && iD <= mm3Var.b() - 1 && i3 >= 0 && i3 <= mm3Var.b() - 1) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(mm3Var.a(), iD, bArr, 0, i2);
                    jE = l63.e(bArr);
                    StringBuilder sb = new StringBuilder();
                    sb.append("找到");
                    if (i == 20274) {
                        sb.append("[OTA长度]");
                    } else if (i == 20276) {
                        sb.append("[Normal长度]");
                    } else if (i == 20287) {
                        sb.append("[Beep开始偏移地址]");
                    } else if (i == O) {
                        sb.append("[Beep长度]");
                    } else if (i == 20290) {
                        sb.append("[Font开始偏移地址]");
                    } else if (i == 20281) {
                        sb.append("[Font长度]");
                    } else if (i == 20293) {
                        sb.append("[UI Icon开始偏移地址]");
                    }
                    sb.append("：memAddress = " + i + ", memDataLen = " + i2 + ", 数据 = " + l63.b(bArr) + ", 小端数据值 = " + jE);
                    String str = N;
                    Log.w(str, sb.toString());
                    Log.w(str, mm3Var.toString());
                    break;
                }
            }
        }
        return jE;
    }

    private static String u(String str, String str2) {
        try {
            str2 = URLDecoder.decode(str2, "utf-8");
            str2.split(WatchConstant.FAT_FS_ROOT);
            String str3 = str + s(str2);
            Log.d(N, "getUniquePath(return): " + str3);
            return str3;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str2;
        }
    }

    private static byte[] v(byte[] bArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            byte b = bArr[(bArr.length - i) - 1];
            bArr[(bArr.length - i) - 1] = bArr[i];
            bArr[i] = b;
        }
        return bArr;
    }

    public nm3 f(long j, long j2) throws Throwable {
        Throwable th;
        BufferedReader bufferedReader;
        nm3 nm3Var;
        FileInputStream fileInputStream = null;
        if (j > j2) {
            Log.e(N, "getCheckSumByStartEndLine()-->codeStartLine > codeEndLine !");
            return null;
        }
        File file = new File(this.e);
        if (!file.exists()) {
            Log.e(N, "getCheckSumByStartEndLine()-->文件不存在!");
            return null;
        }
        HashMap map = new HashMap();
        try {
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2));
                        long j3 = 0;
                        int i = 0;
                        do {
                            try {
                                try {
                                    String line = bufferedReader.readLine();
                                    if (line == null) {
                                        break;
                                    }
                                    long j4 = j3 + 1;
                                    if (j4 == 1) {
                                        long j5 = j3 + 2;
                                        if (j > j5) {
                                            long j6 = j - j5;
                                            for (int i2 = 0; i2 < j6; i2++) {
                                                bufferedReader.readLine();
                                            }
                                            j4 += j6;
                                        }
                                    }
                                    j3 = j4;
                                    if (j3 >= j && j3 <= j2) {
                                        map.put(Integer.valueOf(i), line);
                                        i++;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileInputStream = fileInputStream2;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                            throw th;
                                        }
                                    }
                                    if (bufferedReader == null) {
                                        throw th;
                                    }
                                    bufferedReader.close();
                                    throw th;
                                }
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                nm3Var = null;
                            } catch (IOException e3) {
                                e = e3;
                                nm3Var = null;
                            }
                        } while (j3 <= j2);
                        long jA = 0;
                        for (int i3 = 0; i3 < map.size(); i3++) {
                            jA += (long) q60.a((String) map.get(Integer.valueOf(i3)));
                        }
                        Log.d(N, "getCheckSumByStartEndLine()--> checkSum = " + jA);
                        nm3Var = new nm3(j, j2, (j2 - j) + 1, jA);
                        try {
                            fileInputStream2.close();
                            bufferedReader.close();
                            fileInputStream2.close();
                            bufferedReader.close();
                        } catch (FileNotFoundException e4) {
                            e = e4;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        } catch (IOException e5) {
                            e = e5;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        }
                    } catch (FileNotFoundException e6) {
                        e = e6;
                        bufferedReader = null;
                        nm3Var = null;
                    } catch (IOException e7) {
                        e = e7;
                        bufferedReader = null;
                        nm3Var = null;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                    }
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            } catch (FileNotFoundException e9) {
                e = e9;
                bufferedReader = null;
                nm3Var = null;
            } catch (IOException e10) {
                e = e10;
                bufferedReader = null;
                nm3Var = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
            return nm3Var;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public om3 g() {
        om3 om3Var = new om3();
        if (this.D.size() <= 0) {
            return null;
        }
        for (mm3 mm3Var : this.D) {
            if (mm3Var.d() == 18057 && mm3Var.b() > 0) {
                String str = N;
                Log.d(str, "所选固件的名称在数据单元中：" + mm3Var.toString());
                Log.d(str, "所选固件的名称在数据单元中的数据部分：" + l63.b(mm3Var.a()));
                int iB = (int) (mm3Var.b() - 1);
                byte[] bArr = new byte[iB];
                System.arraycopy(mm3Var.a(), 1, bArr, 0, iB);
                Log.d(str, "所选固件的名称长度 = " + iB);
                Log.d(str, "所选固件的名称(bytes->hex->ascii) = " + l63.g(l63.b(bArr)));
                Log.d(str, "所选固件的耳机名称(bytes->string) = " + new String(bArr));
                om3Var.f(l63.g(l63.b(bArr)));
            } else if (mm3Var.d() == 17977 && mm3Var.b() == 6) {
                om3Var.e(l63.b(v(mm3Var.a())).toLowerCase());
            } else if (mm3Var.d() == 16704 && mm3Var.b() == 6) {
                om3Var.e(l63.b(v(mm3Var.a())).toLowerCase());
            } else if (mm3Var.d() == 17248 && mm3Var.b() == 9) {
                byte[] bArr2 = new byte[2];
                byte[] bArr3 = new byte[4];
                System.arraycopy(mm3Var.a(), 0, bArr2, 0, 2);
                System.arraycopy(mm3Var.a(), 2, bArr3, 0, 4);
                om3Var.g(l63.e(bArr2));
                om3Var.h(l63.b(bArr3));
            }
        }
        return om3Var;
    }

    public nm3 h() throws Throwable {
        nm3 nm3VarF = f(this.o, this.p);
        if (nm3VarF != null) {
            Log.d(N, nm3VarF.toString());
        }
        return nm3VarF;
    }

    public nm3 k() throws Throwable {
        nm3 nm3VarF = f(this.s, this.t);
        if (nm3VarF != null) {
            Log.d(N, nm3VarF.toString());
        }
        return nm3VarF;
    }

    public nm3 m() throws Throwable {
        nm3 nm3VarF = f(this.m, this.n);
        if (nm3VarF != null) {
            Log.d(N, nm3VarF.toString());
        }
        return nm3VarF;
    }

    public nm3 o() throws Throwable {
        nm3 nm3VarF = f(this.k, this.l);
        if (nm3VarF != null) {
            Log.d(N, nm3VarF.toString());
        }
        return nm3VarF;
    }

    public nm3 q() {
        return this.M;
    }

    public String w() {
        return "FlashFileUtil{mFilePath='" + this.e + "'\nmBeepPartStartLine=" + this.o + "\nmBeepPartEndLine=" + this.p + "\nmBeepPartLength=" + this.h + "\nmFontPartStartLine=" + this.s + "\nmFontPartEndLine=" + this.t + "\nmFontPartLength=" + this.j + "\nmUIIconPartStartLine=" + this.f456q + "\nmUIIconPartEndLine=" + this.r + "\nmUIIconPartLength=" + this.i + "\n}";
    }

    public String x() {
        StringBuilder sb = new StringBuilder();
        sb.append("FlashFileUtil{mFilePath='");
        sb.append(this.e);
        sb.append('\'');
        sb.append("\nmNormalPartStartLine=");
        sb.append(this.m);
        sb.append("\nmNormalPartEndLine=");
        sb.append(this.n);
        sb.append("\nmNormalPartLength=");
        sb.append(this.g);
        sb.append("\nmNormalCodeSubBtStartLine=");
        sb.append(this.E);
        sb.append("\nmNormalCodeSubBtEndLine=");
        sb.append(this.F);
        sb.append("\nmNormalCodeSubBtDataStartLine=");
        sb.append(this.G);
        sb.append("\nmNormalCodeSubBtDataEndLine=");
        sb.append(this.H);
        sb.append("\nmNormalCodeSubZCodeStartLine=");
        sb.append(this.I);
        sb.append("\nmNormalCodeSubZCodeEndLine=");
        sb.append(this.J);
        sb.append("\nmNormalCodeSubCm0StartLine=");
        sb.append(this.K);
        sb.append("\nmNormalCodeSubCm0EndLine=");
        sb.append(this.L);
        sb.append("\nmNormalPartBtDataList.size() =");
        ArrayList arrayList = this.D;
        sb.append(arrayList == null ? "mNormalPartBtDataList == null" : Integer.valueOf(arrayList.size()));
        sb.append('}');
        return sb.toString();
    }

    public String y() {
        StringBuilder sb = new StringBuilder();
        sb.append("FlashFileUtil{mFilePath='");
        sb.append(this.e);
        sb.append("\nmOTAPartStartLine=");
        sb.append(this.k);
        sb.append("\nmOTAPartEndLine=");
        sb.append(this.l);
        sb.append("\nmOtaPartLength=");
        sb.append(this.f);
        sb.append("\nmOTACodeSubBtStartLine=");
        sb.append(this.v);
        sb.append("\nmOTACodeSubBtEndLine=");
        sb.append(this.w);
        sb.append("\nmOTACodeSubBtDataStartLine=");
        sb.append(this.x);
        sb.append("\nmOTACodeSubBtDataEndLine=");
        sb.append(this.y);
        sb.append("\nmOTACodeSubZCodeStartLine=");
        sb.append(this.z);
        sb.append("\nmOTACodeSubZCodeEndLine=");
        sb.append(this.A);
        sb.append("\nmOTACodeSubCm0StartLine=");
        sb.append(this.B);
        sb.append("\nmOTACodeSubCm0EndLine=");
        sb.append(this.C);
        sb.append("\nmOtaPartBtDataList.size() =");
        ArrayList arrayList = this.u;
        sb.append(arrayList == null ? "mOtaPartBtDataList = null" : Integer.valueOf(arrayList.size()));
        sb.append('}');
        return sb.toString();
    }
}
