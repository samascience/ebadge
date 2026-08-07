package yqy.yichip.yc_lib_ota_3_gen.wristband;

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
    private static final String y = "a";
    private String a;
    private long c;
    private long f;
    private long g;
    private ArrayList p;
    private long h = 0;
    private long i = 0;
    private long j = 0;
    private long k = 0;
    private long l = 0;
    private long m = 0;
    private long n = 0;
    private long o = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f454q = 0;
    private long r = 0;
    private long s = 0;
    private long t = 0;
    private long u = 0;
    private long v = 0;
    private long w = 0;
    private long x = 0;
    private long d = 4097;
    private long b = 20480;
    private long e = 20480 + PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;

    public a(String str) throws Throwable {
        this.a = str;
        String str2 = y;
        Log.d(str2, "OTA部分解析结果：" + h());
        this.f = 24577L;
        this.c = b();
        a();
        this.g = this.c + 24576;
        Log.d(str2, "Normal部分解析结果：" + g());
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
        File file = new File(this.a);
        if (!file.exists()) {
            Log.e(y, "analyzeFlashNormalPart222()-->文件不存在!");
            return;
        }
        Log.d(y, "解析Normal部分...");
        this.p = new ArrayList();
        this.f454q = 0L;
        this.r = 0L;
        this.s = 0L;
        this.t = 0L;
        this.u = 0L;
        this.v = 0L;
        this.w = 0L;
        this.x = 0L;
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
                                    this.f454q = jD + 1;
                                    long j11 = jD - j8;
                                    for (int i = 0; i < j11; i++) {
                                        bufferedReader.readLine();
                                    }
                                    j8 += j11;
                                    sb.setLength(0);
                                    j9 = 0;
                                }
                                long j12 = this.f454q;
                                if (j12 <= 0 || j8 < j12) {
                                    j = 0;
                                    j10 = j10;
                                    jE = jE;
                                } else {
                                    long j13 = this.g;
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
                                                this.r = j8;
                                                this.s = j8 + 1;
                                                j14 = 4;
                                                j10 = 0;
                                            }
                                            if (j9 <= j14 || j8 < this.s || this.w != 0) {
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
                                                        this.t = j8 - 1;
                                                        this.u = j8;
                                                        Iterator it = this.p.iterator();
                                                        long j17 = 0;
                                                        while (it.hasNext()) {
                                                            mm3 mm3Var = (mm3) it.next();
                                                            if (mm3Var.d() == 18555 && mm3Var.b() == 3) {
                                                                long jE4 = l63.e(mm3Var.a());
                                                                Log.d(y, "xipStartLine = " + jE4);
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
                                                        this.v = j8;
                                                        this.w = j8 + 1;
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
                                                    this.p.add(mm3Var2);
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
                                                    j4 = this.w;
                                                    if (j8 >= j4) {
                                                        j3 = 0;
                                                        if (j4 != 0) {
                                                            j5 = j10 + 1;
                                                            if (j5 == 2) {
                                                                Log.d(y, "Normal部分：totalLine = " + j8 + ",mNormalCodeSubCm0StartLine = " + this.w);
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
                                                                this.x = j8 + jE5;
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
                                                j4 = this.w;
                                                if (j8 >= j4) {
                                                    j3 = 0;
                                                    if (j4 != 0) {
                                                        j5 = j10 + 1;
                                                        if (j5 == 2) {
                                                            Log.d(y, "Normal部分：totalLine = " + j8 + ",mNormalCodeSubCm0StartLine = " + this.w);
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

    private long b() throws Throwable {
        Throwable th;
        BufferedReader bufferedReader;
        File file = new File(this.a);
        if (!file.exists()) {
            return 0L;
        }
        Log.d(y, "解析Normal到文件结尾，获取Normal长度...");
        HashMap map = new HashMap();
        this.c = 0L;
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2));
                        int i = 0;
                        long j = 0;
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                long j2 = j + 1;
                                if (j2 == 1) {
                                    long j3 = this.f;
                                    long j4 = j + 2;
                                    if (j3 > j4) {
                                        long j5 = j3 - j4;
                                        for (int i2 = 0; i2 < j5; i2++) {
                                            bufferedReader.readLine();
                                        }
                                        j2 += j5;
                                    }
                                }
                                j = j2;
                                if (j >= this.f) {
                                    map.put(Integer.valueOf(i), line);
                                    i++;
                                }
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
                            } catch (Throwable th2) {
                                th = th2;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (bufferedReader == null) {
                                    throw th;
                                }
                                bufferedReader.close();
                                throw th;
                            }
                        }
                        long jA = 0;
                        for (int i3 = 0; i3 < map.size(); i3++) {
                            jA += (long) q60.a((String) map.get(Integer.valueOf(i3)));
                        }
                        Log.d(y, "normalCheckSum = " + jA);
                        this.c = (j - this.f) + 1;
                        fileInputStream2.close();
                        bufferedReader.close();
                        fileInputStream2.close();
                        bufferedReader.close();
                    } catch (FileNotFoundException e4) {
                        e = e4;
                        bufferedReader = null;
                    } catch (IOException e5) {
                        e = e5;
                        bufferedReader = null;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                bufferedReader = null;
            } catch (IOException e7) {
                e = e7;
                bufferedReader = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
            }
        } catch (IOException e8) {
            e8.printStackTrace();
        }
        return this.c;
    }

    private nm3 c(long j, long j2) throws Throwable {
        Throwable th;
        BufferedReader bufferedReader;
        nm3 nm3Var;
        FileInputStream fileInputStream = null;
        if (j > j2) {
            Log.e(y, "getCheckSumByStartEndLine()-->codeStartLine > codeEndLine !");
            return null;
        }
        File file = new File(this.a);
        if (!file.exists()) {
            Log.e(y, "getCheckSumByStartEndLine()-->文件不存在!");
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
                        Log.d(y, "getCheckSumByStartEndLine()--> checkSum = " + jA);
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
    static Map d(String str, long j, long j2, int i, int i2) throws Throwable {
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
        String str2 = y;
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
                                Log.d(y, "packetNum = " + i8);
                                int length = i3;
                                int length2 = length;
                                for (Integer num : map.keySet()) {
                                    length += ((String) map.get(num)).length() / 2;
                                    if ((num.intValue() + 1) % i6 == 0) {
                                        Log.d(y, num + "：buck = " + length);
                                        length = i3;
                                    }
                                    if (num.intValue() + 1 == map.size()) {
                                        Log.d(y, num + "：buck = " + length);
                                        length = i3;
                                    }
                                    length2 += ((String) map.get(num)).length() / 2;
                                }
                                Log.d(y, "dataNum = " + length2);
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

    public nm3 e() throws Throwable {
        nm3 nm3VarC = c(this.f, this.g);
        if (nm3VarC != null) {
            Log.d(y, nm3VarC.toString());
        }
        return nm3VarC;
    }

    public nm3 f() throws Throwable {
        nm3 nm3VarC = c(this.d, this.e);
        if (nm3VarC != null) {
            Log.d(y, nm3VarC.toString());
        }
        return nm3VarC;
    }

    public String g() {
        StringBuilder sb = new StringBuilder();
        sb.append("FlashFileUtil{mFilePath='");
        sb.append(this.a);
        sb.append('\'');
        sb.append("\nmNormalPartStartLine=");
        sb.append(this.f);
        sb.append("\nmNormalPartEndLine=");
        sb.append(this.g);
        sb.append("\nmNormalPartLength=");
        sb.append(this.c);
        sb.append("\nmNormalCodeSubBtStartLine=");
        sb.append(this.f454q);
        sb.append("\nmNormalCodeSubBtEndLine=");
        sb.append(this.r);
        sb.append("\nmNormalCodeSubBtDataStartLine=");
        sb.append(this.s);
        sb.append("\nmNormalCodeSubBtDataEndLine=");
        sb.append(this.t);
        sb.append("\nmNormalCodeSubZCodeStartLine=");
        sb.append(this.u);
        sb.append("\nmNormalCodeSubZCodeEndLine=");
        sb.append(this.v);
        sb.append("\nmNormalCodeSubCm0StartLine=");
        sb.append(this.w);
        sb.append("\nmNormalCodeSubCm0EndLine=");
        sb.append(this.x);
        sb.append("\nmNormalPartBtDataList.size() =");
        ArrayList arrayList = this.p;
        sb.append(arrayList == null ? "mNormalPartBtDataList == null" : Integer.valueOf(arrayList.size()));
        sb.append('}');
        return sb.toString();
    }

    public String h() {
        return "OTA部分{mOTAPartStartLine=" + this.d + ", mOTAPartEndLine=" + this.e + "，mOtaPartLength=" + this.b + '}';
    }
}
