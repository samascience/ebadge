package defpackage;

import android.location.Location;
import android.os.Build;
import com.baidu.location.Jni;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zq3 {
    private a a;
    private int b;
    long c = 0;
    private static ArrayList d = new ArrayList();
    private static ArrayList e = new ArrayList();
    private static ArrayList f = new ArrayList();
    private static String g = bq3.a + "/yo.dat";
    private static String h = bq3.a + "/yoh.dat";
    private static String i = bq3.a + "/yom.dat";
    private static String j = bq3.a + "/yol.dat";
    private static String k = bq3.a + "/yor.dat";
    private static File l = null;
    private static int m = 8;
    private static int n = 8;
    private static int o = 16;
    private static int p = 2048;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static double f460q = 0.0d;
    private static double r = 0.1d;
    private static double s = 30.0d;
    private static double t = 100.0d;
    private static int u = 0;
    private static int v = 64;
    private static int w = 128;
    private static Location x = null;
    private static Location y = null;
    private static Location z = null;
    private static eq3 A = null;
    private static zq3 B = null;
    private static long C = 0;

    private class a extends np3 {
        boolean k = false;
        int l = 0;
        int m = 0;
        private ArrayList n = new ArrayList();
        private boolean o = true;

        public a() {
            this.d = new HashMap();
        }

        @Override // defpackage.np3
        public void a() {
            Map map;
            StringBuilder sb;
            String str;
            if (this.l != 1) {
                this.a = fq3.y();
            }
            this.b = 2;
            if (this.n != null) {
                for (int i = 0; i < this.n.size(); i++) {
                    if (this.l == 1) {
                        map = this.d;
                        sb = new StringBuilder();
                        str = "cldc[";
                    } else {
                        map = this.d;
                        sb = new StringBuilder();
                        str = "cltr[";
                    }
                    sb.append(str);
                    sb.append(i);
                    sb.append("]");
                    map.put(sb.toString(), this.n.get(i));
                }
                this.d.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
                if (this.l != 1) {
                    this.d.put("qt", "cltrg");
                }
            }
        }

        @Override // defpackage.np3
        public void d(boolean z) {
            if (z && this.c != null) {
                ArrayList arrayList = this.n;
                if (arrayList != null) {
                    arrayList.clear();
                }
                try {
                    JSONObject jSONObject = new JSONObject(this.c);
                    if (jSONObject.has("ison") && jSONObject.getInt("ison") == 0) {
                        this.o = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Map map = this.d;
            if (map != null) {
                map.clear();
            }
            this.k = false;
        }

        public synchronized void f() {
            ExecutorService executorServiceC;
            String strY;
            String strY2;
            int i;
            try {
                if (this.k) {
                    return;
                }
                int i2 = np3.j;
                if (i2 > 4 && (i = this.m) < i2) {
                    this.m = i + 1;
                    return;
                }
                this.m = 0;
                this.k = true;
                this.l = 0;
                try {
                    ArrayList arrayList = this.n;
                    if (arrayList == null || arrayList.size() < 1) {
                        if (this.n == null) {
                            this.n = new ArrayList();
                        }
                        this.l = 0;
                        int length = 0;
                        while (true) {
                            String strA = null;
                            String strL = this.l < 2 ? zq3.l() : null;
                            if (strL == null && this.l != 1 && this.o) {
                                this.l = 2;
                                try {
                                    strA = aq3.a();
                                } catch (Exception unused) {
                                }
                            } else {
                                this.l = 1;
                                strA = strL;
                            }
                            if (strA == null) {
                                break;
                            }
                            if (!strA.contains("err!")) {
                                this.n.add(strA);
                                length += strA.length();
                                if (length >= cn3.d) {
                                    break;
                                }
                            }
                        }
                    }
                    ArrayList arrayList2 = this.n;
                    if (arrayList2 == null || arrayList2.size() < 1) {
                        ArrayList arrayList3 = this.n;
                        if (arrayList3 != null) {
                            arrayList3.clear();
                        }
                        this.k = false;
                        return;
                    }
                    if (this.l != 1) {
                        executorServiceC = xq3.a().c();
                        if (executorServiceC != null) {
                            strY2 = fq3.y();
                            b(executorServiceC, strY2);
                        } else {
                            strY = fq3.y();
                            e(strY);
                        }
                    } else {
                        executorServiceC = xq3.a().c();
                        if (executorServiceC != null) {
                            strY2 = fp3.a;
                            b(executorServiceC, strY2);
                        } else {
                            strY = fp3.a;
                            e(strY);
                        }
                    }
                } catch (Exception unused2) {
                    ArrayList arrayList4 = this.n;
                    if (arrayList4 != null) {
                        arrayList4.clear();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private zq3() {
        String strF;
        this.a = null;
        this.b = 0;
        this.a = new a();
        this.b = 0;
        if (Build.VERSION.SDK_INT <= 28 || (strF = fq3.F()) == null) {
            return;
        }
        g = strF + "/yo2.dat";
        h = strF + "/yoh2.dat";
        i = strF + "/yom2.dat";
        j = strF + "/yol2.dat";
        k = strF + "/yor2.dat";
    }

    private static synchronized int a(List list, int i2) {
        if (list != null && i2 <= 256) {
            if (i2 >= 0) {
                try {
                    if (l == null) {
                        File file = new File(g);
                        l = file;
                        if (!file.exists()) {
                            l = null;
                            return -2;
                        }
                    }
                    RandomAccessFile randomAccessFile = new RandomAccessFile(l, "rw");
                    if (randomAccessFile.length() < 1) {
                        randomAccessFile.close();
                        return -3;
                    }
                    long j2 = i2;
                    randomAccessFile.seek(j2);
                    int i3 = randomAccessFile.readInt();
                    int i4 = randomAccessFile.readInt();
                    int i5 = randomAccessFile.readInt();
                    int i6 = randomAccessFile.readInt();
                    long j3 = randomAccessFile.readLong();
                    long j4 = j3;
                    if (g(i3, i4, i5, i6, j3)) {
                        int i7 = 1;
                        if (i4 >= 1) {
                            byte[] bArr = new byte[p];
                            int i8 = m;
                            while (i8 > 0 && i4 > 0) {
                                long j5 = (((i3 + i4) - i7) % i5) * i6;
                                byte[] bArr2 = bArr;
                                long j6 = j4;
                                randomAccessFile.seek(j5 + j6);
                                int i9 = randomAccessFile.readInt();
                                if (i9 > 0 && i9 < i6) {
                                    randomAccessFile.read(bArr2, 0, i9);
                                    int i10 = i9 - 1;
                                    if (bArr2[i10] == 0) {
                                        list.add(new String(bArr2, 0, i10));
                                    }
                                }
                                i8--;
                                i4--;
                                j4 = j6;
                                bArr = bArr2;
                                i7 = 1;
                            }
                            randomAccessFile.seek(j2);
                            randomAccessFile.writeInt(i3);
                            randomAccessFile.writeInt(i4);
                            randomAccessFile.writeInt(i5);
                            randomAccessFile.writeInt(i6);
                            randomAccessFile.writeLong(j4);
                            randomAccessFile.close();
                            return m - i8;
                        }
                    }
                    randomAccessFile.close();
                    return -4;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return -5;
                }
            }
        }
        return -1;
    }

    private static String b(int i2) {
        String str;
        ArrayList arrayList;
        String str2 = null;
        if (i2 == 1) {
            str = h;
            arrayList = d;
        } else if (i2 == 2) {
            str = i;
            arrayList = e;
        } else {
            if (i2 == 3) {
                str = j;
            } else {
                if (i2 != 4) {
                    return null;
                }
                str = k;
            }
            arrayList = f;
        }
        if (arrayList == null) {
            return null;
        }
        if (arrayList.size() < 1) {
            k(str, arrayList);
        }
        synchronized (zq3.class) {
            int size = arrayList.size();
            if (size > 0) {
                int i3 = size - 1;
                try {
                    String str3 = (String) arrayList.get(i3);
                    try {
                        arrayList.remove(i3);
                    } catch (Exception unused) {
                    }
                    str2 = str3;
                } catch (Exception unused2) {
                }
            }
        }
        return str2;
    }

    public static synchronized zq3 c() {
        try {
            if (B == null) {
                B = new zq3();
            }
        } catch (Throwable th) {
            throw th;
        }
        return B;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0034  */
    /* JADX WARN: Code duplicated, block: B:30:0x0060 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x0062 A[Catch: Exception -> 0x00e7, TryCatch #0 {Exception -> 0x00e7, blocks: (B:27:0x0037, B:28:0x005b, B:31:0x0062, B:33:0x0066, B:40:0x00ca, B:35:0x0097, B:42:0x00ce, B:45:0x00e3), top: B:48:0x0037 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0066 A[Catch: Exception -> 0x00e7, TryCatch #0 {Exception -> 0x00e7, blocks: (B:27:0x0037, B:28:0x005b, B:31:0x0062, B:33:0x0066, B:40:0x00ca, B:35:0x0097, B:42:0x00ce, B:45:0x00e3), top: B:48:0x0037 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0095 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0097 A[Catch: Exception -> 0x00e7, TryCatch #0 {Exception -> 0x00e7, blocks: (B:27:0x0037, B:28:0x005b, B:31:0x0062, B:33:0x0066, B:40:0x00ca, B:35:0x0097, B:42:0x00ce, B:45:0x00e3), top: B:48:0x0037 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00e1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:50:0x00cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x00ce A[EDGE_INSN: B:51:0x00ce->B:42:0x00ce BREAK  A[LOOP:0: B:28:0x005b->B:40:0x00ca], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:33:0x0066, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:35:0x0097, please report this as an issue */
    private static void d(int i2, boolean z2) {
        String str;
        ArrayList arrayList;
        File file;
        RandomAccessFile randomAccessFile;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int size;
        int i8;
        int i9;
        try {
            if (i2 != 1) {
                if (i2 == 2) {
                    str = i;
                    if (z2) {
                    }
                    file = new File(str);
                    if (!file.exists()) {
                        q(str);
                    }
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(4L);
                    i3 = randomAccessFile.readInt();
                    i4 = randomAccessFile.readInt();
                    i5 = randomAccessFile.readInt();
                    i6 = randomAccessFile.readInt();
                    i7 = randomAccessFile.readInt();
                    size = arrayList.size();
                    while (true) {
                        i8 = 0;
                        if (size <= n) {
                            break;
                        }
                        if (z2) {
                            i7++;
                        }
                        if (i5 >= i3) {
                            if (!z2) {
                                i8 = 1;
                                break;
                            }
                            randomAccessFile.seek((i6 * i4) + 128);
                            byte[] bytes = (((String) arrayList.get(0)) + (char) 0).getBytes();
                            randomAccessFile.writeInt(bytes.length);
                            randomAccessFile.write(bytes, 0, bytes.length);
                            arrayList.remove(0);
                            i9 = i6 + 1;
                            if (i9 <= i5) {
                                i8 = i9;
                            }
                            i6 = i8;
                        } else {
                            randomAccessFile.seek((i4 * i5) + 128);
                            byte[] bytes2 = (((String) arrayList.get(0)) + (char) 0).getBytes();
                            randomAccessFile.writeInt(bytes2.length);
                            randomAccessFile.write(bytes2, 0, bytes2.length);
                            arrayList.remove(0);
                            i5++;
                        }
                        size--;
                    }
                    randomAccessFile.seek(12L);
                    randomAccessFile.writeInt(i5);
                    randomAccessFile.writeInt(i6);
                    randomAccessFile.writeInt(i7);
                    randomAccessFile.close();
                    if (i8 != 0 || i2 >= 4) {
                        return;
                    }
                    d(i2 + 1, true);
                    return;
                }
                if (i2 == 3) {
                    str = j;
                    if (z2) {
                    }
                    file = new File(str);
                    if (!file.exists()) {
                        q(str);
                    }
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(4L);
                    i3 = randomAccessFile.readInt();
                    i4 = randomAccessFile.readInt();
                    i5 = randomAccessFile.readInt();
                    i6 = randomAccessFile.readInt();
                    i7 = randomAccessFile.readInt();
                    size = arrayList.size();
                    while (true) {
                        i8 = 0;
                        if (size <= n) {
                            break;
                            break;
                        }
                        if (z2) {
                            i7++;
                        }
                        if (i5 >= i3) {
                            if (!z2) {
                                i8 = 1;
                                break;
                            }
                            randomAccessFile.seek((i6 * i4) + 128);
                            byte[] bytes3 = (((String) arrayList.get(0)) + (char) 0).getBytes();
                            randomAccessFile.writeInt(bytes3.length);
                            randomAccessFile.write(bytes3, 0, bytes3.length);
                            arrayList.remove(0);
                            i9 = i6 + 1;
                            if (i9 <= i5) {
                                i8 = i9;
                            }
                            i6 = i8;
                        } else {
                            randomAccessFile.seek((i4 * i5) + 128);
                            byte[] bytes4 = (((String) arrayList.get(0)) + (char) 0).getBytes();
                            randomAccessFile.writeInt(bytes4.length);
                            randomAccessFile.write(bytes4, 0, bytes4.length);
                            arrayList.remove(0);
                            i5++;
                        }
                        size--;
                    }
                    randomAccessFile.seek(12L);
                    randomAccessFile.writeInt(i5);
                    randomAccessFile.writeInt(i6);
                    randomAccessFile.writeInt(i7);
                    randomAccessFile.close();
                    if (i8 != 0) {
                        return;
                    } else {
                        return;
                    }
                }
                if (i2 != 4) {
                    return;
                }
                str = k;
                if (!z2) {
                    return;
                }
                arrayList = f;
                file = new File(str);
                if (!file.exists()) {
                    q(str);
                }
                randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(4L);
                i3 = randomAccessFile.readInt();
                i4 = randomAccessFile.readInt();
                i5 = randomAccessFile.readInt();
                i6 = randomAccessFile.readInt();
                i7 = randomAccessFile.readInt();
                size = arrayList.size();
                while (true) {
                    i8 = 0;
                    if (size <= n) {
                        break;
                        break;
                    }
                    if (z2) {
                        i7++;
                    }
                    if (i5 >= i3) {
                        if (!z2) {
                            i8 = 1;
                            break;
                        }
                        randomAccessFile.seek((i6 * i4) + 128);
                        byte[] bytes5 = (((String) arrayList.get(0)) + (char) 0).getBytes();
                        randomAccessFile.writeInt(bytes5.length);
                        randomAccessFile.write(bytes5, 0, bytes5.length);
                        arrayList.remove(0);
                        i9 = i6 + 1;
                        if (i9 <= i5) {
                            i8 = i9;
                        }
                        i6 = i8;
                    } else {
                        randomAccessFile.seek((i4 * i5) + 128);
                        byte[] bytes6 = (((String) arrayList.get(0)) + (char) 0).getBytes();
                        randomAccessFile.writeInt(bytes6.length);
                        randomAccessFile.write(bytes6, 0, bytes6.length);
                        arrayList.remove(0);
                        i5++;
                    }
                    size--;
                }
                randomAccessFile.seek(12L);
                randomAccessFile.writeInt(i5);
                randomAccessFile.writeInt(i6);
                randomAccessFile.writeInt(i7);
                randomAccessFile.close();
                if (i8 != 0) {
                    return;
                } else {
                    return;
                }
                arrayList = e;
                file = new File(str);
                if (!file.exists()) {
                    q(str);
                }
                randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(4L);
                i3 = randomAccessFile.readInt();
                i4 = randomAccessFile.readInt();
                i5 = randomAccessFile.readInt();
                i6 = randomAccessFile.readInt();
                i7 = randomAccessFile.readInt();
                size = arrayList.size();
                while (true) {
                    i8 = 0;
                    if (size <= n) {
                        break;
                        break;
                    }
                    if (z2) {
                        i7++;
                    }
                    if (i5 >= i3) {
                        if (!z2) {
                            i8 = 1;
                            break;
                        }
                        randomAccessFile.seek((i6 * i4) + 128);
                        byte[] bytes7 = (((String) arrayList.get(0)) + (char) 0).getBytes();
                        randomAccessFile.writeInt(bytes7.length);
                        randomAccessFile.write(bytes7, 0, bytes7.length);
                        arrayList.remove(0);
                        i9 = i6 + 1;
                        if (i9 <= i5) {
                            i8 = i9;
                        }
                        i6 = i8;
                    } else {
                        randomAccessFile.seek((i4 * i5) + 128);
                        byte[] bytes8 = (((String) arrayList.get(0)) + (char) 0).getBytes();
                        randomAccessFile.writeInt(bytes8.length);
                        randomAccessFile.write(bytes8, 0, bytes8.length);
                        arrayList.remove(0);
                        i5++;
                    }
                    size--;
                }
                randomAccessFile.seek(12L);
                randomAccessFile.writeInt(i5);
                randomAccessFile.writeInt(i6);
                randomAccessFile.writeInt(i7);
                randomAccessFile.close();
                if (i8 != 0) {
                    return;
                } else {
                    return;
                }
            }
            str = h;
            if (z2) {
                return;
            }
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(4L);
            i3 = randomAccessFile.readInt();
            i4 = randomAccessFile.readInt();
            i5 = randomAccessFile.readInt();
            i6 = randomAccessFile.readInt();
            i7 = randomAccessFile.readInt();
            size = arrayList.size();
            while (true) {
                i8 = 0;
                if (size <= n) {
                    break;
                    break;
                }
                if (z2) {
                    i7++;
                }
                if (i5 >= i3) {
                    if (!z2) {
                        i8 = 1;
                        break;
                    }
                    randomAccessFile.seek((i6 * i4) + 128);
                    byte[] bytes9 = (((String) arrayList.get(0)) + (char) 0).getBytes();
                    randomAccessFile.writeInt(bytes9.length);
                    randomAccessFile.write(bytes9, 0, bytes9.length);
                    arrayList.remove(0);
                    i9 = i6 + 1;
                    if (i9 <= i5) {
                        i8 = i9;
                    }
                    i6 = i8;
                } else {
                    randomAccessFile.seek((i4 * i5) + 128);
                    byte[] bytes10 = (((String) arrayList.get(0)) + (char) 0).getBytes();
                    randomAccessFile.writeInt(bytes10.length);
                    randomAccessFile.write(bytes10, 0, bytes10.length);
                    arrayList.remove(0);
                    i5++;
                }
                size--;
            }
            randomAccessFile.seek(12L);
            randomAccessFile.writeInt(i5);
            randomAccessFile.writeInt(i6);
            randomAccessFile.writeInt(i7);
            randomAccessFile.close();
            if (i8 != 0) {
                return;
            } else {
                return;
            }
        } catch (Exception unused) {
            return;
        }
        arrayList = d;
        file = new File(str);
        if (!file.exists()) {
            q(str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:63:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:82:0x0147  */
    /* JADX WARN: Code duplicated, block: B:85:0x014e  */
    /* JADX WARN: Code duplicated, block: B:87:0x0152  */
    /* JADX WARN: Code duplicated, block: B:88:0x0157  */
    /* JADX WARN: Code duplicated, block: B:93:0x0165  */
    /* JADX WARN: Code duplicated, block: B:96:0x0170  */
    public static void e(bn3 bn3Var, eq3 eq3Var, Location location, String str) {
        StringBuilder sb;
        String strG;
        String strG2;
        String strE;
        StringBuilder sb2;
        String strG3;
        String strG4;
        String strE2;
        String strE3;
        if ((fq3.n == 3 && !i(location, eq3Var) && !j(location, false)) || bn3Var == null || bn3Var.d()) {
            return;
        }
        if (bn3Var.a()) {
            if (!i(location, eq3Var)) {
                eq3Var = null;
            }
            String strG5 = fq3.g(bn3Var, eq3Var, location, str, 1);
            if (strG5 != null) {
                if (Build.VERSION.SDK_INT > 28) {
                    strE3 = Jni.g(strG5);
                } else {
                    String strG6 = Jni.g(strG5);
                    strE3 = (strG6 == null || strG6.length() >= 1000) ? Jni.e(strG5) : strG6;
                }
                f(strE3);
                y = location;
                x = location;
                if (eq3Var != null) {
                    A = eq3Var;
                    return;
                }
                return;
            }
            return;
        }
        if (eq3Var != null && eq3Var.u() && i(location, eq3Var)) {
            if (h(location) || so3.h().t()) {
                if (!h(location) && so3.h().t()) {
                    sb2 = new StringBuilder();
                    sb2.append("&cfr=3");
                } else if (so3.h().t()) {
                    str = "&cfr=2" + str;
                }
                strG3 = fq3.g(bn3Var, eq3Var, location, str, 2);
                if (strG3 != null) {
                    if (Build.VERSION.SDK_INT > 28) {
                        strE2 = Jni.g(strG3);
                    } else {
                        strG4 = Jni.g(strG3);
                        if (strG4 != null || strG4.length() >= 1000) {
                            strE2 = Jni.e(strG3);
                        } else {
                            strE2 = strG4;
                        }
                    }
                    m(strE2);
                    z = location;
                    x = location;
                    A = eq3Var;
                    return;
                }
                return;
            }
            sb2 = new StringBuilder();
            sb2.append("&cfr=1");
            sb2.append(str);
            str = sb2.toString();
            strG3 = fq3.g(bn3Var, eq3Var, location, str, 2);
            if (strG3 != null) {
                if (Build.VERSION.SDK_INT > 28) {
                    strE2 = Jni.g(strG3);
                } else {
                    strG4 = Jni.g(strG3);
                    if (strG4 != null) {
                        strE2 = Jni.e(strG3);
                    } else {
                        strE2 = Jni.e(strG3);
                    }
                }
                m(strE2);
                z = location;
                x = location;
                A = eq3Var;
                return;
            }
            return;
        }
        if (h(location) || so3.h().t()) {
            if (!h(location) && so3.h().t()) {
                sb = new StringBuilder();
                sb.append("&cfr=3");
            } else if (so3.h().t()) {
                str = "&cfr=2" + str;
            }
            if (!i(location, eq3Var)) {
                eq3Var = null;
            }
            strG = fq3.g(bn3Var, eq3Var, location, str, 3);
            if (strG != null) {
                if (Build.VERSION.SDK_INT > 28) {
                    strE = Jni.g(strG);
                } else {
                    strG2 = Jni.g(strG);
                    if (strG2 != null || strG2.length() >= 1000) {
                        strE = Jni.e(strG);
                    } else {
                        strE = strG2;
                    }
                }
                o(strE);
                x = location;
                if (eq3Var != null) {
                    A = eq3Var;
                }
            }
        }
        sb = new StringBuilder();
        sb.append("&cfr=1");
        sb.append(str);
        str = sb.toString();
        if (!i(location, eq3Var)) {
            eq3Var = null;
        }
        strG = fq3.g(bn3Var, eq3Var, location, str, 3);
        if (strG != null) {
            if (Build.VERSION.SDK_INT > 28) {
                strE = Jni.g(strG);
            } else {
                strG2 = Jni.g(strG);
                if (strG2 != null) {
                    strE = Jni.e(strG);
                } else {
                    strE = Jni.e(strG);
                }
            }
            o(strE);
            x = location;
            if (eq3Var != null) {
                A = eq3Var;
            }
        }
    }

    private static void f(String str) {
        s(str);
    }

    private static boolean g(int i2, int i3, int i4, int i5, long j2) {
        return i2 >= 0 && i2 < i4 && i3 >= 0 && i3 <= i4 && i4 >= 0 && i4 <= 1024 && i5 >= 128 && i5 <= 1024;
    }

    private static boolean h(Location location) {
        if (location == null) {
            return false;
        }
        Location location2 = y;
        if (location2 == null || x == null) {
            y = location;
            return true;
        }
        double dDistanceTo = location.distanceTo(location2);
        return ((double) location.distanceTo(x)) > (((((double) fq3.w) * dDistanceTo) * dDistanceTo) + (((double) fq3.x) * dDistanceTo)) + ((double) fq3.y);
    }

    private static boolean i(Location location, eq3 eq3Var) {
        List list;
        boolean z2 = false;
        if (location != null && eq3Var != null && (list = eq3Var.a) != null && !list.isEmpty()) {
            if (eq3Var.j(A)) {
                return false;
            }
            z2 = true;
            if (z == null) {
                z = location;
            }
        }
        return z2;
    }

    public static boolean j(Location location, boolean z2) {
        return mp3.w(x, location, z2);
    }

    private static boolean k(String str, List list) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(8L);
            int i2 = randomAccessFile.readInt();
            int i3 = randomAccessFile.readInt();
            int i4 = randomAccessFile.readInt();
            byte[] bArr = new byte[p];
            int i5 = n + 1;
            boolean z2 = false;
            while (i5 > 0 && i3 > 0) {
                if (i3 < i4) {
                    i4 = 0;
                }
                try {
                    randomAccessFile.seek(((i3 - 1) * i2) + 128);
                    int i6 = randomAccessFile.readInt();
                    if (i6 > 0 && i6 < i2) {
                        randomAccessFile.read(bArr, 0, i6);
                        int i7 = i6 - 1;
                        if (bArr[i7] == 0) {
                            list.add(0, new String(bArr, 0, i7));
                            z2 = true;
                        }
                    }
                    i5--;
                    i3--;
                } catch (Exception unused) {
                    return z2;
                }
            }
            randomAccessFile.seek(12L);
            randomAccessFile.writeInt(i3);
            randomAccessFile.writeInt(i4);
            randomAccessFile.close();
            return z2;
        } catch (Exception unused2) {
            return false;
        }
    }

    public static String l() {
        return t();
    }

    private static void m(String str) {
        s(str);
    }

    private static void o(String str) {
        s(str);
    }

    public static void p() {
        n = 0;
        d(1, false);
        d(2, false);
        d(3, false);
        n = 8;
    }

    private static void q(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return;
            }
            File file2 = new File(bq3.a);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (!file.createNewFile()) {
                file = null;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(32);
            randomAccessFile.writeInt(2048);
            randomAccessFile.writeInt(5120);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    public static String r() {
        File file = new File(i);
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(20L);
                int i2 = randomAccessFile.readInt();
                if (i2 > 128) {
                    String str = "&p1=" + i2;
                    randomAccessFile.seek(20L);
                    randomAccessFile.writeInt(0);
                    randomAccessFile.close();
                    return str;
                }
                randomAccessFile.close();
            } catch (Exception unused) {
            }
        }
        File file2 = new File(j);
        if (file2.exists()) {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                randomAccessFile2.seek(20L);
                int i3 = randomAccessFile2.readInt();
                if (i3 > 256) {
                    String str2 = "&p2=" + i3;
                    randomAccessFile2.seek(20L);
                    randomAccessFile2.writeInt(0);
                    randomAccessFile2.close();
                    return str2;
                }
                randomAccessFile2.close();
            } catch (Exception unused2) {
            }
        }
        File file3 = new File(k);
        if (file3.exists()) {
            try {
                RandomAccessFile randomAccessFile3 = new RandomAccessFile(file3, "rw");
                randomAccessFile3.seek(20L);
                int i4 = randomAccessFile3.readInt();
                if (i4 > 512) {
                    String str3 = "&p3=" + i4;
                    randomAccessFile3.seek(20L);
                    randomAccessFile3.writeInt(0);
                    randomAccessFile3.close();
                    return str3;
                }
                randomAccessFile3.close();
            } catch (Exception unused3) {
            }
        }
        return null;
    }

    private static synchronized void s(String str) {
        ArrayList arrayList;
        try {
            if (str.contains("err!")) {
                return;
            }
            int i2 = fq3.m;
            if (i2 == 1) {
                arrayList = d;
            } else if (i2 == 2) {
                arrayList = e;
            } else if (i2 != 3) {
                return;
            } else {
                arrayList = f;
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() <= o) {
                arrayList.add(str);
            }
            if (arrayList.size() >= o) {
                d(i2, false);
            }
            while (arrayList.size() > o) {
                arrayList.remove(0);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private static String t() {
        String strB = null;
        for (int i2 = 1; i2 < 5; i2++) {
            strB = b(i2);
            if (strB != null) {
                return strB;
            }
        }
        a(f, v);
        if (f.size() > 0) {
            strB = (String) f.get(0);
            f.remove(0);
        }
        if (strB != null) {
            return strB;
        }
        a(f, u);
        if (f.size() > 0) {
            strB = (String) f.get(0);
            f.remove(0);
        }
        if (strB != null) {
            return strB;
        }
        a(f, w);
        if (f.size() <= 0) {
            return strB;
        }
        String str = (String) f.get(0);
        f.remove(0);
        return str;
    }

    public void n() {
        if (jq3.c().q() && !fq3.r()) {
            this.a.f();
        }
    }
}
