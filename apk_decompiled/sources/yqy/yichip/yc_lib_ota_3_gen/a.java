package yqy.yichip.yc_lib_ota_3_gen;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import defpackage.l63;
import defpackage.mm3;
import defpackage.nm3;
import defpackage.q60;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static final String E = "a";
    private long a;
    private String b;
    private long c;
    private long d;
    private long e;
    private long g;
    private long h;
    private long i;
    private long j;
    private long k;
    private ArrayList l;
    private ArrayList u;
    private long m = 0;
    private long n = 0;
    private long o = 0;
    private long p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f452q = 0;
    private long r = 0;
    private long s = 0;
    private long t = 0;
    private long v = 0;
    private long w = 0;
    private long x = 0;
    private long y = 0;
    private long z = 0;
    private long A = 0;
    private long B = 0;
    private long C = 0;
    private nm3 D = null;
    private long f = 4097;

    public a(String str) throws Throwable {
        this.a = 0L;
        this.b = str;
        long j = j();
        this.c = j;
        this.g = j + PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        String str2 = E;
        Log.d(str2, "OTA部分解析结果：" + m());
        this.h = 24577L;
        long jI = i();
        this.d = jI;
        this.i = jI + 24576;
        Log.d(str2, "Normal部分解析结果：" + l());
        long jK = k();
        this.a = jK;
        if (jK == 0) {
            this.j = 0L;
            this.k = 0L;
            Log.e(str2, "PCM 获取的偏移地址为0");
        } else {
            this.j = jK + 1;
            this.k = c();
            Log.d(str2, "PCM部分解析结果：" + n());
        }
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
        File file = new File(this.b);
        if (!file.exists()) {
            Log.e(E, "analyzeFlashNormalPart222()-->文件不存在!");
            return;
        }
        Log.d(E, "解析Normal部分...");
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
                                    this.v = jD + 1;
                                    long j11 = jD - j8;
                                    for (int i = 0; i < j11; i++) {
                                        bufferedReader.readLine();
                                    }
                                    j8 += j11;
                                    sb.setLength(0);
                                    j9 = 0;
                                }
                                long j12 = this.v;
                                if (j12 <= 0 || j8 < j12) {
                                    j = 0;
                                    j10 = j10;
                                    jE = jE;
                                } else {
                                    long j13 = this.i;
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
                                                this.w = j8;
                                                this.x = j8 + 1;
                                                j14 = 4;
                                                j10 = 0;
                                            }
                                            if (j9 <= j14 || j8 < this.x || this.B != 0) {
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
                                                        this.y = j8 - 1;
                                                        this.z = j8;
                                                        Iterator it = this.u.iterator();
                                                        long j17 = 0;
                                                        while (it.hasNext()) {
                                                            mm3 mm3Var = (mm3) it.next();
                                                            if (mm3Var.d() == 18555 && mm3Var.b() == 3) {
                                                                long jE4 = l63.e(mm3Var.a());
                                                                Log.d(E, "xipStartLine = " + jE4);
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
                                                        this.A = j8;
                                                        this.B = j8 + 1;
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
                                                    this.u.add(mm3Var2);
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
                                                    j4 = this.B;
                                                    if (j8 >= j4) {
                                                        j3 = 0;
                                                        if (j4 != 0) {
                                                            j5 = j10 + 1;
                                                            if (j5 == 2) {
                                                                Log.d(E, "Normal部分：totalLine = " + j8 + ",mNormalCodeSubCm0StartLine = " + this.B);
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
                                                                this.C = j8 + jE5;
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
                                                j4 = this.B;
                                                if (j8 >= j4) {
                                                    j3 = 0;
                                                    if (j4 != 0) {
                                                        j5 = j10 + 1;
                                                        if (j5 == 2) {
                                                            Log.d(E, "Normal部分：totalLine = " + j8 + ",mNormalCodeSubCm0StartLine = " + this.B);
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
        File file = new File(this.b);
        if (!file.exists()) {
            Log.e(E, "analyzeFlashOTAPart222()-->文件不存在!");
            return;
        }
        Log.d(E, "解析OTA部分...");
        this.l = new ArrayList();
        this.m = 0L;
        this.n = 0L;
        this.o = 0L;
        this.p = 0L;
        this.f452q = 0L;
        this.r = 0L;
        this.s = 0L;
        this.t = 0L;
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
                                    long j13 = this.f;
                                    long j14 = j7 + 2;
                                    if (j13 > j14) {
                                        this.m = j13 + 3;
                                        long j15 = (j13 + 3) - j14;
                                        for (int i2 = 0; i2 < j15; i2++) {
                                            bufferedReader.readLine();
                                        }
                                        sb.setLength(0);
                                        j7 = j12 + j15;
                                        j8 = 0;
                                    } else {
                                        this.g = j13;
                                        j7 = j12;
                                    }
                                } else {
                                    j7 = j12;
                                }
                                long j16 = this.m;
                                if (j16 <= 0 || j7 < j16) {
                                    j = 0;
                                    j10 = j10;
                                } else {
                                    long j17 = this.g;
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
                                                this.n = j7;
                                                this.o = j7 + 1;
                                                j18 = 4;
                                                j9 = 0;
                                            }
                                            if (j8 <= j18 || j7 < this.o || this.s != 0) {
                                                jE = j10;
                                            } else {
                                                long j19 = j9 + 1;
                                                if (j19 <= 2) {
                                                    if (!sb.toString().equals("aa55".substring(0, sb.toString().length()))) {
                                                        this.p = j7 - 1;
                                                        this.f452q = j7;
                                                        long jE4 = 0;
                                                        for (mm3 mm3Var : this.l) {
                                                            if (mm3Var.d() == 18555 && mm3Var.b() == 3) {
                                                                jE4 = l63.e(mm3Var.a());
                                                                Log.d(E, "OTA部分：xipStartLine = " + jE4);
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
                                                        this.r = j7;
                                                        this.s = j7 + 1;
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
                                                    this.l.add(mm3Var2);
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
                                                    j4 = this.s;
                                                    if (j7 >= j4) {
                                                        j3 = 0;
                                                        if (j4 != 0) {
                                                            j9++;
                                                            if (j9 == 2) {
                                                                Log.d(E, "OTA部分：totalLine = " + j7 + ",mOTACodeSubCm0StartLine = " + this.s);
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
                                                                this.t = j7 + jE2;
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
                                                j4 = this.s;
                                                if (j7 >= j4) {
                                                    j3 = 0;
                                                    if (j4 != 0) {
                                                        j9++;
                                                        if (j9 == 2) {
                                                            Log.d(E, "OTA部分：totalLine = " + j7 + ",mOTACodeSubCm0StartLine = " + this.s);
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
                                                            this.t = j7 + jE2;
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

    /* JADX WARN: Code duplicated, block: B:64:0x010c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x010e A[Catch: IOException -> 0x010a, TRY_LEAVE, TryCatch #7 {IOException -> 0x010a, blocks: (B:61:0x0106, B:65:0x010e), top: B:95:0x0106 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0126 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x0128 A[Catch: IOException -> 0x0124, TRY_LEAVE, TryCatch #9 {IOException -> 0x0124, blocks: (B:73:0x0120, B:77:0x0128), top: B:97:0x0120 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0106 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private long c() throws Throwable {
        Throwable th;
        BufferedReader bufferedReader;
        long j;
        File file = new File(this.b);
        long j2 = 0;
        if (!file.exists()) {
            Log.e(E, "analyzeFlashPCMPart222()-->文件不存在!");
            return 0L;
        }
        Log.d(E, "解析PCM...");
        HashMap map = new HashMap();
        this.e = 0L;
        FileInputStream fileInputStream = null;
        this.D = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2));
                    int i = 0;
                    j = 0;
                    while (true) {
                        try {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                long j3 = j + 1;
                                if (j3 == 1) {
                                    long j4 = this.j;
                                    long j5 = j + 2;
                                    if (j4 > j5) {
                                        long j6 = j4 - j5;
                                        for (int i2 = 0; i2 < j6; i2++) {
                                            bufferedReader.readLine();
                                        }
                                        j3 += j6;
                                    } else {
                                        this.k = j4;
                                    }
                                }
                                j = j3;
                                if (j >= this.j) {
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
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    e.printStackTrace();
                                    j = j2;
                                    return j;
                                }
                            } else if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            j = j2;
                            return j;
                        } catch (IOException e4) {
                            e = e4;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                } catch (IOException e5) {
                                    e = e5;
                                    e.printStackTrace();
                                    j = j2;
                                    return j;
                                }
                            } else if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            j = j2;
                            return j;
                        }
                    }
                    long jA = 0;
                    for (int i3 = 0; i3 < map.size(); i3++) {
                        jA += (long) q60.a((String) map.get(Integer.valueOf(i3)));
                    }
                    Log.d(E, "pcmCheckSum = " + jA);
                    try {
                        long j7 = this.j;
                        long j8 = (j - j7) + 1;
                        this.e = j8;
                        this.D = new nm3(j7, j, j8, jA);
                        fileInputStream2.close();
                        bufferedReader.close();
                        try {
                            fileInputStream2.close();
                            bufferedReader.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    } catch (FileNotFoundException e7) {
                        e = e7;
                        fileInputStream = fileInputStream2;
                        j2 = j;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        } else if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        j = j2;
                    } catch (IOException e8) {
                        e = e8;
                        fileInputStream = fileInputStream2;
                        j2 = j;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        } else if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        j = j2;
                    }
                } catch (FileNotFoundException e9) {
                    e = e9;
                    bufferedReader = null;
                } catch (IOException e10) {
                    e = e10;
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (FileNotFoundException e11) {
            e = e11;
            bufferedReader = null;
        } catch (IOException e12) {
            e = e12;
            bufferedReader = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
        }
        return j;
    }

    private nm3 d(long j, long j2) throws Throwable {
        Throwable th;
        BufferedReader bufferedReader;
        nm3 nm3Var;
        FileInputStream fileInputStream = null;
        if (j > j2) {
            Log.e(E, "getCheckSumByStartEndLine()-->codeStartLine > codeEndLine !");
            return null;
        }
        File file = new File(this.b);
        if (!file.exists()) {
            Log.e(E, "getCheckSumByStartEndLine()-->文件不存在!");
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
                        Log.d(E, "getCheckSumByStartEndLine()--> checkSum = " + jA);
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
    static Map e(String str, long j, long j2, int i, int i2) throws Throwable {
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
        String str2 = E;
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
                                Log.d(E, "packetNum = " + i8);
                                int length = i3;
                                int length2 = length;
                                for (Integer num : map.keySet()) {
                                    length += ((String) map.get(num)).length() / 2;
                                    if ((num.intValue() + 1) % i6 == 0) {
                                        Log.d(E, num + "：buck = " + length);
                                        length = i3;
                                    }
                                    if (num.intValue() + 1 == map.size()) {
                                        Log.d(E, num + "：buck = " + length);
                                        length = i3;
                                    }
                                    length2 += ((String) map.get(num)).length() / 2;
                                }
                                Log.d(E, "dataNum = " + length2);
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

    private long i() throws Throwable {
        a();
        ArrayList arrayList = this.u;
        if (arrayList == null) {
            Log.e(E, "mNormalPartBtDataList == null !!");
            return -1L;
        }
        if (arrayList.size() == 0) {
            Log.e(E, "mNormalPartBtDataList.size() == 0 !!");
            return -1L;
        }
        long jE = 0;
        for (mm3 mm3Var : this.u) {
            if (mm3Var.d() == 17248 && mm3Var.b() == 9) {
                byte[] bArr = new byte[3];
                System.arraycopy(mm3Var.a(), 6, bArr, 0, 3);
                jE = l63.e(bArr);
                Log.d(E, "normalPartLength = " + jE);
            } else if (mm3Var.d() == 19271 && mm3Var.b() == 3) {
                long jE2 = l63.e(mm3Var.a());
                Log.d(E, "xxxLength = " + jE2);
            }
        }
        return jE;
    }

    private long j() throws Throwable {
        b();
        ArrayList arrayList = this.l;
        long jE = 0;
        if (arrayList == null) {
            Log.e(E, "getOTAPartLength()--> mOtaPartBtDataList == null !!");
            return 0L;
        }
        if (arrayList.size() == 0) {
            Log.e(E, "getOTAPartLength()--> mOtaPartBtDataList.size() == 0 !!");
            return 0L;
        }
        for (mm3 mm3Var : this.l) {
            if (mm3Var.d() == 17248 && mm3Var.b() == 9) {
                byte[] bArr = new byte[3];
                System.arraycopy(mm3Var.a(), 6, bArr, 0, 3);
                jE = l63.e(bArr);
                Log.d(E, "getOTAPartLength()--> otaPartLength = " + jE);
            } else {
                long jD = mm3Var.d();
                Log.d(E, "getOTAPartLength()--> startAddress = " + jD);
            }
        }
        return jE;
    }

    private long k() {
        long jE = 0;
        for (mm3 mm3Var : this.u) {
            if (mm3Var.d() == 18982) {
                byte[] bArr = new byte[3];
                System.arraycopy(mm3Var.a(), 0, bArr, 0, 3);
                jE = l63.e(bArr);
                Log.d(E, "pcmStartOffset = " + jE);
            }
        }
        return jE;
    }

    public nm3 f() throws Throwable {
        nm3 nm3VarD = d(this.h, this.i);
        if (nm3VarD != null) {
            Log.d(E, nm3VarD.toString());
        }
        return nm3VarD;
    }

    public nm3 g() throws Throwable {
        nm3 nm3VarD = d(this.f, this.g);
        if (nm3VarD != null) {
            Log.d(E, nm3VarD.toString());
        }
        return nm3VarD;
    }

    public nm3 h() {
        if (this.j == 0 || this.k == 0) {
            return null;
        }
        return this.D;
    }

    public String l() {
        StringBuilder sb = new StringBuilder();
        sb.append("FlashFileUtil{mFilePath='");
        sb.append(this.b);
        sb.append('\'');
        sb.append("\nmNormalPartStartLine=");
        sb.append(this.h);
        sb.append("\nmNormalPartEndLine=");
        sb.append(this.i);
        sb.append("\nmNormalPartLength=");
        sb.append(this.d);
        sb.append("\nmNormalCodeSubBtStartLine=");
        sb.append(this.v);
        sb.append("\nmNormalCodeSubBtEndLine=");
        sb.append(this.w);
        sb.append("\nmNormalCodeSubBtDataStartLine=");
        sb.append(this.x);
        sb.append("\nmNormalCodeSubBtDataEndLine=");
        sb.append(this.y);
        sb.append("\nmNormalCodeSubZCodeStartLine=");
        sb.append(this.z);
        sb.append("\nmNormalCodeSubZCodeEndLine=");
        sb.append(this.A);
        sb.append("\nmNormalCodeSubCm0StartLine=");
        sb.append(this.B);
        sb.append("\nmNormalCodeSubCm0EndLine=");
        sb.append(this.C);
        sb.append("\nmNormalPartBtDataList.size() =");
        ArrayList arrayList = this.u;
        sb.append(arrayList == null ? "mNormalPartBtDataList == null" : Integer.valueOf(arrayList.size()));
        sb.append('}');
        return sb.toString();
    }

    public String m() {
        StringBuilder sb = new StringBuilder();
        sb.append("FlashFileUtil{mFilePath='");
        sb.append(this.b);
        sb.append("\nmOTAPartStartLine=");
        sb.append(this.f);
        sb.append("\nmOTAPartEndLine=");
        sb.append(this.g);
        sb.append("\nmOtaPartLength=");
        sb.append(this.c);
        sb.append("\nmOTACodeSubBtStartLine=");
        sb.append(this.m);
        sb.append("\nmOTACodeSubBtEndLine=");
        sb.append(this.n);
        sb.append("\nmOTACodeSubBtDataStartLine=");
        sb.append(this.o);
        sb.append("\nmOTACodeSubBtDataEndLine=");
        sb.append(this.p);
        sb.append("\nmOTACodeSubZCodeStartLine=");
        sb.append(this.f452q);
        sb.append("\nmOTACodeSubZCodeEndLine=");
        sb.append(this.r);
        sb.append("\nmOTACodeSubCm0StartLine=");
        sb.append(this.s);
        sb.append("\nmOTACodeSubCm0EndLine=");
        sb.append(this.t);
        sb.append("\nmOtaPartBtDataList.size() =");
        ArrayList arrayList = this.l;
        sb.append(arrayList == null ? "mOtaPartBtDataList = null" : Integer.valueOf(arrayList.size()));
        sb.append('}');
        return sb.toString();
    }

    public String n() {
        return "FlashFileUtil{mFilePath='" + this.b + "'\nmPCMPartStartLine=" + this.j + "\nmPCMPartEndLine=" + this.k + "\nmPcmPartLength=" + this.e + '}';
    }
}
