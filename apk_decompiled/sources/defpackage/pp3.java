package defpackage;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import com.baidu.location.Jni;
import com.baidu.location.f;
import com.seeker.luckychart.animation.ChartCoordinateportAnimator;
import com.tencent.connect.common.Constants;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import kotlinx.coroutines.DebugKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class pp3 {
    private static pp3 M = null;
    public static String N = "0";
    private Handler D;
    private int a = 1;
    private double b = 0.699999988079071d;
    private String c = "3G|4G";
    private int d = 1;
    private int e = 307200;
    private int f = 15;
    private int g = 1;
    private double h = 3.5d;
    private double i = 3.0d;
    private double j = 0.5d;
    private int k = ChartCoordinateportAnimator.FAST_ANIMATION_DURATION;
    private int l = 60;
    private int m = 0;
    private int n = 60;
    private int o = 0;
    private long p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private a f371q = null;
    private boolean r = false;
    private boolean s = false;
    private int t = 0;
    private float u = 0.0f;
    private float v = 0.0f;
    private long w = 0;
    private int x = 500;
    long y = 0;
    Location z = null;
    Location A = null;
    StringBuilder B = null;
    long C = 0;
    private byte[] E = new byte[4];
    private byte[] F = null;
    private int G = 0;
    private List H = null;
    private boolean I = false;
    int J = 0;
    double K = 116.22345545d;
    double L = 40.245667323d;

    class a extends np3 {
        String k = null;

        public a() {
            this.d = new HashMap();
        }

        @Override // defpackage.np3
        public void a() {
            this.a = "https://loc.map.baidu.com/cc.php";
            String strE = Jni.e(this.k);
            this.k = null;
            this.d.put("q", strE);
        }

        @Override // defpackage.np3
        public void d(boolean z) {
            String str;
            if (z && (str = this.c) != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    jSONObject.put("prod", to3.f);
                    jSONObject.put("uptime", System.currentTimeMillis());
                    pp3.this.v(jSONObject.toString());
                } catch (Exception unused) {
                }
            }
            Map map = this.d;
            if (map != null) {
                map.clear();
            }
        }

        public void f(String str) {
            this.k = str;
            e("https://loc.map.baidu.com/cc.php");
        }
    }

    private pp3() {
        this.D = null;
        this.D = new Handler();
    }

    private void A() {
        List list;
        byte b;
        this.H.add((byte) 0);
        this.H.add((byte) 0);
        if (N.equals("0")) {
            list = this.H;
            b = -82;
        } else {
            list = this.H;
            b = -66;
        }
        list.add(Byte.valueOf(b));
        this.H.add((byte) 0);
        this.H.add(Byte.valueOf(this.E[0]));
        this.H.add(Byte.valueOf(this.E[1]));
        this.H.add(Byte.valueOf(this.E[2]));
        this.H.add(Byte.valueOf(this.E[3]));
        int length = this.F.length;
        this.H.add(Byte.valueOf((byte) ((length + 1) & 255)));
        for (int i = 0; i < length; i++) {
            this.H.add(Byte.valueOf(this.F[i]));
        }
    }

    private void B() {
        if (System.currentTimeMillis() - this.p > 86400000) {
            if (this.f371q == null) {
                this.f371q = new a();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(to3.a().b(false));
            stringBuffer.append(ro3.b().l());
            this.f371q.f(stringBuffer.toString());
        }
        C();
    }

    private void C() {
    }

    public static pp3 a() {
        if (M == null) {
            M = new pp3();
        }
        return M;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(File file, String str) {
        String string = UUID.randomUUID().toString();
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            httpsURLConnection.setReadTimeout(10000);
            httpsURLConnection.setConnectTimeout(10000);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setRequestMethod(Constants.HTTP_POST);
            httpsURLConnection.setRequestProperty("Charset", "utf-8");
            httpsURLConnection.setRequestProperty("connection", "close");
            httpsURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + string);
            if (file == null || !file.exists()) {
                return "0";
            }
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("--");
            stringBuffer.append(string);
            stringBuffer.append("\r\n");
            stringBuffer.append("Content-Disposition: form-data; name=\"location_dat\"; filename=\"" + file.getName() + "\"\r\n");
            StringBuilder sb = new StringBuilder();
            sb.append("Content-Type: application/octet-stream; charset=utf-8");
            sb.append("\r\n");
            stringBuffer.append(sb.toString());
            stringBuffer.append("\r\n");
            dataOutputStream.write(stringBuffer.toString().getBytes());
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                dataOutputStream.write(bArr, 0, i);
            }
            fileInputStream.close();
            dataOutputStream.write("\r\n".getBytes());
            dataOutputStream.write(("--" + string + "--\r\n").getBytes());
            dataOutputStream.flush();
            dataOutputStream.close();
            int responseCode = httpsURLConnection.getResponseCode();
            outputStream.close();
            httpsURLConnection.disconnect();
            int i2 = this.o + 400;
            this.o = i2;
            o(i2);
            return responseCode == 200 ? "1" : "0";
        } catch (MalformedURLException | IOException unused) {
            return "0";
        }
    }

    private boolean g(String str, Context context) {
        return true;
    }

    private byte[] h(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((i & (-16777216)) >> 24)};
    }

    private byte[] i(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte bNextInt = (byte) new Random().nextInt(255);
        byte bNextInt2 = (byte) new Random().nextInt(255);
        byte[] bArr = new byte[bytes.length + 2];
        int length = bytes.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            bArr[i2] = (byte) (bytes[i] ^ bNextInt);
            i++;
            i2++;
        }
        bArr[i2] = bNextInt;
        bArr[i2 + 1] = bNextInt2;
        return bArr;
    }

    private String j(String str) {
        Calendar calendar = Calendar.getInstance();
        return String.format(str, Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)));
    }

    private void l(int i) {
        byte[] bArrH = h(i);
        for (int i2 = 0; i2 < 4; i2++) {
            this.H.add(Byte.valueOf(bArrH[i2]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Location location) {
        p(location);
        z();
    }

    private void n() {
        if (this.I) {
            return;
        }
        this.I = true;
        t(to3.f);
        B();
        r();
    }

    private void o(int i) {
        if (i == 0) {
            return;
        }
        try {
            File file = new File(bq3.a + "/grtcf.dat");
            if (!file.exists()) {
                File file2 = new File(bq3.a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    return;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(2L);
                randomAccessFile.writeInt(0);
                randomAccessFile.seek(8L);
                byte[] bytes = "1980_01_01:0".getBytes();
                randomAccessFile.writeInt(bytes.length);
                randomAccessFile.write(bytes);
                randomAccessFile.seek(200L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.seek(800L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.close();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            randomAccessFile2.seek(8L);
            byte[] bytes2 = (j("%d_%02d_%02d") + ":" + i).getBytes();
            randomAccessFile2.writeInt(bytes2.length);
            randomAccessFile2.write(bytes2);
            randomAccessFile2.close();
        } catch (Exception unused) {
        }
    }

    private void p(Location location) {
        if (System.currentTimeMillis() - this.y < this.x || location == null) {
            return;
        }
        if (location.hasSpeed() && location.getSpeed() > this.u) {
            this.u = location.getSpeed();
        }
        try {
            if (this.H == null) {
                this.H = new ArrayList();
                A();
                s(location);
            } else {
                u(location);
            }
        } catch (Exception unused) {
        }
        this.G++;
    }

    private void q(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                    this.a = jSONObject.getInt(DebugKt.DEBUG_PROPERTY_VALUE_ON);
                }
                if (jSONObject.has("bash")) {
                    this.b = jSONObject.getDouble("bash");
                }
                if (jSONObject.has("net")) {
                    this.c = jSONObject.getString("net");
                }
                if (jSONObject.has("tcon")) {
                    this.d = jSONObject.getInt("tcon");
                }
                if (jSONObject.has("tcsh")) {
                    this.e = jSONObject.getInt("tcsh");
                }
                if (jSONObject.has("per")) {
                    this.f = jSONObject.getInt("per");
                }
                if (jSONObject.has("chdron")) {
                    this.g = jSONObject.getInt("chdron");
                }
                if (jSONObject.has("spsh")) {
                    this.h = jSONObject.getDouble("spsh");
                }
                if (jSONObject.has("acsh")) {
                    this.i = jSONObject.getDouble("acsh");
                }
                if (jSONObject.has("stspsh")) {
                    this.j = jSONObject.getDouble("stspsh");
                }
                if (jSONObject.has("drstsh")) {
                    this.k = jSONObject.getInt("drstsh");
                }
                if (jSONObject.has("stper")) {
                    this.l = jSONObject.getInt("stper");
                }
                if (jSONObject.has("nondron")) {
                    this.m = jSONObject.getInt("nondron");
                }
                if (jSONObject.has("nondrper")) {
                    this.n = jSONObject.getInt("nondrper");
                }
                if (jSONObject.has("uptime")) {
                    this.p = jSONObject.getLong("uptime");
                }
                C();
            } catch (JSONException unused) {
            }
        }
    }

    private void r() {
        String[] strArrSplit = "9.2.9.3".split("\\.");
        int length = strArrSplit.length;
        byte[] bArr = this.E;
        bArr[0] = 0;
        bArr[1] = 0;
        bArr[2] = 0;
        bArr[3] = 0;
        if (length >= 4) {
            length = 4;
        }
        for (int i = 0; i < length; i++) {
            try {
                this.E[i] = (byte) (Integer.valueOf(strArrSplit[i]).intValue() & 255);
            } catch (Exception unused) {
            }
        }
        this.F = i(to3.f + ":" + to3.a().c);
    }

    private void s(Location location) {
        this.C = System.currentTimeMillis();
        l((int) (location.getTime() / 1000));
        l((int) (location.getLongitude() * 1000000.0d));
        l((int) (location.getLatitude() * 1000000.0d));
        int i = !location.hasBearing() ? 1 : 0;
        int i2 = !location.hasSpeed() ? 1 : 0;
        if (i > 0) {
            this.H.add((byte) 32);
        } else {
            this.H.add(Byte.valueOf((byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & (-33))));
        }
        if (i2 > 0) {
            this.H.add((byte) -128);
        } else {
            this.H.add(Byte.valueOf((byte) (((byte) (((int) ((((double) location.getSpeed()) * 3.6d) / 4.0d)) & 255)) & 127)));
        }
        this.z = location;
    }

    private void t(String str) {
        try {
            File file = new File(bq3.a + "/grtcf.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(2L);
                int i = randomAccessFile.readInt();
                randomAccessFile.seek(8L);
                int i2 = randomAccessFile.readInt();
                byte[] bArr = new byte[i2];
                randomAccessFile.read(bArr, 0, i2);
                String str2 = new String(bArr);
                if (str2.contains(j("%d_%02d_%02d")) && str2.contains(":")) {
                    try {
                        String[] strArrSplit = str2.split(":");
                        if (strArrSplit.length > 1) {
                            this.o = Integer.valueOf(strArrSplit[1]).intValue();
                        }
                    } catch (Exception unused) {
                    }
                }
                for (int i3 = 1; i3 <= i; i3++) {
                    randomAccessFile.seek(i3 * 2048);
                    int i4 = randomAccessFile.readInt();
                    byte[] bArr2 = new byte[i4];
                    randomAccessFile.read(bArr2, 0, i4);
                    String str3 = new String(bArr2);
                    if (str != null && str3.contains(str)) {
                        q(str3);
                        break;
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00fd A[PHI: r2
      0x00fd: PHI (r2v26 byte) = (r2v18 byte), (r2v30 byte) binds: [B:36:0x011d, B:30:0x00fb] A[DONT_GENERATE, DONT_INLINE]] */
    private void u(Location location) {
        byte bearing;
        if (location == null) {
            return;
        }
        int longitude = (int) ((location.getLongitude() - this.z.getLongitude()) * 1000000.0d);
        int latitude = (int) ((location.getLatitude() - this.z.getLatitude()) * 1000000.0d);
        int i = !location.hasBearing() ? 1 : 0;
        int i2 = !location.hasSpeed() ? 1 : 0;
        char c = longitude > 0 ? (char) 0 : (char) 1;
        int iAbs = Math.abs(longitude);
        char c2 = latitude > 0 ? (char) 0 : (char) 1;
        int iAbs2 = Math.abs(latitude);
        if (this.G > 1) {
            this.A = this.z;
        }
        this.z = location;
        if (this.A != null && location.getTime() > this.A.getTime() && this.z.getTime() - this.A.getTime() < 5000) {
            long time = this.z.getTime() - this.A.getTime();
            float[] fArr = new float[2];
            Location.distanceBetween(this.z.getAltitude(), this.z.getLongitude(), this.A.getLatitude(), this.A.getLongitude(), fArr);
            double speed = ((fArr[0] - (this.A.getSpeed() * time)) * 2.0f) / (time * time);
            if (speed > this.v) {
                this.v = (float) speed;
            }
        }
        this.H.add(Byte.valueOf((byte) (iAbs & 255)));
        this.H.add(Byte.valueOf((byte) ((iAbs & 65280) >> 8)));
        this.H.add(Byte.valueOf((byte) (iAbs2 & 255)));
        this.H.add(Byte.valueOf((byte) ((iAbs2 & 65280) >> 8)));
        if (i > 0) {
            bearing = c2 > 0 ? (byte) 96 : (byte) 32;
            if (c > 0) {
                bearing = (byte) (bearing | (-128));
            }
        } else {
            bearing = (byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & 31);
            if (c2 > 0) {
                bearing = (byte) (bearing | 64);
            }
            if (c > 0) {
                bearing = (byte) (bearing | (-128));
            }
        }
        this.H.add(Byte.valueOf(bearing));
        if (i2 > 0) {
            this.H.add((byte) -128);
        } else {
            this.H.add(Byte.valueOf((byte) (((byte) (((int) ((((double) location.getSpeed()) * 3.6d) / 4.0d)) & 255)) & 127)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str) {
        try {
            File file = new File(bq3.a + "/grtcf.dat");
            if (!file.exists()) {
                File file2 = new File(bq3.a);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    return;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(2L);
                randomAccessFile.writeInt(0);
                randomAccessFile.seek(8L);
                byte[] bytes = "1980_01_01:0".getBytes();
                randomAccessFile.writeInt(bytes.length);
                randomAccessFile.write(bytes);
                randomAccessFile.seek(200L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.seek(800L);
                randomAccessFile.writeBoolean(false);
                randomAccessFile.close();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            randomAccessFile2.seek(2L);
            int i = randomAccessFile2.readInt();
            int i2 = 1;
            while (i2 <= i) {
                randomAccessFile2.seek(i2 * 2048);
                int i3 = randomAccessFile2.readInt();
                byte[] bArr = new byte[i3];
                randomAccessFile2.read(bArr, 0, i3);
                if (new String(bArr).contains(to3.f)) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 >= i) {
                randomAccessFile2.seek(2L);
                randomAccessFile2.writeInt(i2);
            }
            randomAccessFile2.seek(i2 * 2048);
            byte[] bytes2 = str.getBytes();
            randomAccessFile2.writeInt(bytes2.length);
            randomAccessFile2.write(bytes2);
            randomAccessFile2.close();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005b A[Catch: Exception -> 0x005e, TRY_LEAVE, TryCatch #2 {Exception -> 0x005e, blocks: (B:25:0x0056, B:27:0x005b), top: B:35:0x0056 }] */
    private boolean w() throws Throwable {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        FileLock fileLockTryLock = null;
        fileChannel = null;
        RandomAccessFile randomAccessFile2 = null;
        boolean z = false;
        try {
            try {
                File file = new File(fq3.C() + File.separator + "gflk.dat");
                if (!file.exists()) {
                    file.createNewFile();
                }
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    FileChannel channel = randomAccessFile.getChannel();
                    try {
                        fileLockTryLock = channel.tryLock();
                    } catch (Exception unused) {
                        z = true;
                    } catch (Throwable th) {
                        th = th;
                        fileChannel = channel;
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                            } catch (Exception unused2) {
                                throw th;
                            }
                        } else if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        throw th;
                    }
                    if (fileLockTryLock != null) {
                        fileLockTryLock.release();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    randomAccessFile.close();
                } catch (Exception unused3) {
                    randomAccessFile2 = randomAccessFile;
                    if (randomAccessFile2 != null) {
                        randomAccessFile2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception unused4) {
            }
        } catch (Exception unused5) {
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
        return z;
    }

    private boolean x() {
        if (this.r) {
            if (!this.s) {
                if (this.u >= this.j) {
                    return true;
                }
                this.s = true;
                this.t = this.f;
                return true;
            }
            if (this.u >= this.j) {
                this.t = 0;
                this.s = false;
                return true;
            }
            int i = this.t + this.f;
            this.t = i;
            if (i <= this.k || System.currentTimeMillis() - this.w > this.l * 1000) {
                return true;
            }
        } else {
            if (this.u >= this.h || this.v >= this.i) {
                this.r = true;
                return true;
            }
            if (this.m == 1 && System.currentTimeMillis() - this.w > this.n * 1000) {
                return true;
            }
        }
        return false;
    }

    private void y() {
        this.H = null;
        this.C = 0L;
        this.G = 0;
        this.z = null;
        this.A = null;
        this.u = 0.0f;
        this.v = 0.0f;
    }

    private void z() {
        if (this.C == 0 || System.currentTimeMillis() - this.C < this.f * 1000) {
            return;
        }
        if (f.b().getSharedPreferences("loc_navi_mode", 4).getBoolean("is_navi_on", false)) {
            y();
            return;
        }
        if (this.d == 1 && !x()) {
            y();
            return;
        }
        if (to3.f.equals("com.ubercab.driver")) {
            if (w()) {
                y();
                return;
            }
        } else if (!g(to3.f, f.b())) {
            y();
            return;
        }
        List list = this.H;
        if (list != null) {
            int size = list.size();
            this.H.set(0, Byte.valueOf((byte) (size & 255)));
            this.H.set(1, Byte.valueOf((byte) ((65280 & size) >> 8)));
            this.H.set(3, Byte.valueOf((byte) (this.G & 255)));
            byte[] bArr = new byte[size];
            for (int i = 0; i < size; i++) {
                bArr[i] = ((Byte) this.H.get(i)).byteValue();
            }
            File file = new File(fq3.E(), "baidu/tempdata");
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.exists()) {
                File file2 = new File(file, "intime.dat");
                if (file2.exists()) {
                    file2.delete();
                }
                try {
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                    bufferedOutputStream.write(bArr);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    new xp3(this).start();
                } catch (Exception unused) {
                }
            }
            y();
            this.w = System.currentTimeMillis();
        }
    }

    public void d(Location location) {
        if (!this.I) {
            n();
        }
        if (this.a == 1 && this.c.contains(jp3.a(so3.h().u()))) {
            if (this.d != 1 || this.o <= this.e) {
                this.D.post(new tp3(this, location));
            }
        }
    }

    public void k() {
        if (this.I) {
            this.I = false;
            y();
        }
    }
}
