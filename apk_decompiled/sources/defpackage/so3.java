package defpackage;

import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthNr;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.TelephonyManager$CellInfoCallback;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.location.f;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class so3 {
    private static so3 m;
    public static int n;
    public static int o;
    private static String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static Class f382q;
    private a h;
    private boolean k;
    private TelephonyManager a = null;
    private bn3 b = new bn3();
    private bn3 c = null;
    private List d = null;
    private b e = null;
    private boolean f = false;
    private boolean g = false;
    private long i = 0;
    private Handler j = new Handler();
    private int l = 30;

    /* JADX INFO: Access modifiers changed from: private */
    class a extends TelephonyManager$CellInfoCallback {
        private a() {
        }

        public void onCellInfo(List list) {
            if (list == null) {
                return;
            }
            so3.this.j.post(new xo3(this));
        }

        public void onError(int i, Throwable th) {
            if (th != null) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class b extends PhoneStateListener {
        public b() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellInfoChanged(List list) {
            if (list == null) {
                return;
            }
            so3.this.j.post(new ep3(this));
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            bn3 bn3Var;
            int cdmaDbm;
            if (so3.this.b != null) {
                if (so3.this.b.i == 'g') {
                    bn3Var = so3.this.b;
                    cdmaDbm = signalStrength.getGsmSignalStrength();
                } else {
                    if (so3.this.b.i != 'c') {
                        return;
                    }
                    bn3Var = so3.this.b;
                    cdmaDbm = signalStrength.getCdmaDbm();
                }
                bn3Var.h = cdmaDbm;
            }
        }
    }

    private static class c implements Comparator {
        private c() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(up3 up3Var, up3 up3Var2) {
            return up3Var.a - up3Var2.a;
        }
    }

    private so3() {
        this.k = false;
        if (Build.VERSION.SDK_INT >= 30) {
            this.k = fq3.t("android.telephony.TelephonyManager$CellInfoCallback");
        }
    }

    private void A() {
        List list = this.d;
        if (list == null && this.c == null) {
            return;
        }
        if (list == null && this.c != null) {
            LinkedList linkedList = new LinkedList();
            this.d = linkedList;
            linkedList.add(this.c);
        }
        String strC = fq3.C();
        if (strC == null || this.d == null) {
            return;
        }
        File file = new File(strC + File.separator + "lcvif2.dat");
        int size = this.d.size();
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeLong(((bn3) this.d.get(size - 1)).g);
            randomAccessFile.writeInt(size);
            for (int i = 0; i < 3 - size; i++) {
                randomAccessFile.writeLong(0L);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeLong(-1L);
                randomAccessFile.writeInt(2);
            }
            for (int i2 = 0; i2 < size; i2++) {
                randomAccessFile.writeLong(((bn3) this.d.get(i2)).g);
                randomAccessFile.writeInt(((bn3) this.d.get(i2)).c);
                randomAccessFile.writeInt(((bn3) this.d.get(i2)).d);
                randomAccessFile.writeInt(((bn3) this.d.get(i2)).a);
                randomAccessFile.writeLong(((bn3) this.d.get(i2)).b);
                if (((bn3) this.d.get(i2)).i == 'g') {
                    randomAccessFile.writeInt(1);
                } else if (((bn3) this.d.get(i2)).i == 'c') {
                    randomAccessFile.writeInt(2);
                } else {
                    randomAccessFile.writeInt(3);
                }
            }
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        CellLocation cellLocation;
        bn3 bn3VarD = d(this.b, this.a, false);
        if (bn3VarD != null) {
            r(bn3VarD);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            if (bn3VarD == null || !bn3VarD.c()) {
                try {
                    cellLocation = this.a.getCellLocation();
                } catch (Throwable unused) {
                    cellLocation = null;
                }
                if (cellLocation != null) {
                    f(cellLocation);
                }
            }
        }
    }

    private static int a(int i) {
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    public static int b(CellIdentityNr cellIdentityNr) {
        try {
            return fq3.d(cellIdentityNr, "getHwTac");
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int c(String str) {
        if (str == null || !str.contains("mNrTac")) {
            return -1;
        }
        Matcher matcher = Pattern.compile("mNrTac=(.+?)\\}").matcher(str.replace(" ", Constants.STR_EMPTY));
        while (true) {
            int i = -1;
            while (matcher.find()) {
                if (matcher.groupCount() >= 1) {
                    try {
                        i = Integer.parseInt(matcher.group(1));
                    } catch (Throwable unused) {
                    }
                }
            }
            return i;
        }
    }

    public static bn3 d(bn3 bn3Var, TelephonyManager telephonyManager, boolean z) {
        try {
            n = telephonyManager.getSimState();
            List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            if (allCellInfo == null || allCellInfo.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            bn3 bn3Var2 = null;
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo.isRegistered()) {
                    boolean z2 = bn3Var2 != null;
                    bn3 bn3VarE = e(cellInfo, bn3Var, telephonyManager);
                    if (bn3VarE != null) {
                        if (!bn3VarE.c()) {
                            bn3VarE = null;
                        } else if (z2 && bn3Var2 != null) {
                            bn3Var2.m = bn3VarE.j();
                        }
                        if (bn3Var2 == null) {
                            bn3Var2 = bn3VarE;
                        }
                    }
                }
            }
            p = j(n(arrayList));
            return bn3Var2;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x00b0 A[PHI: r13
      0x00b0: PHI (r13v12 int) = (r13v7 int), (r13v13 int) binds: [B:25:0x00d4, B:14:0x00ae] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:6:0x0052  */
    public static bn3 e(CellInfo cellInfo, bn3 bn3Var, TelephonyManager telephonyManager) {
        int iIntValue;
        CellIdentityNr cellIdentityNrA;
        long jElapsedRealtimeNanos;
        long jCurrentTimeMillis;
        int i = Build.VERSION.SDK_INT;
        bn3 bn3Var2 = new bn3();
        boolean z = true;
        if (cellInfo instanceof CellInfoGsm) {
            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
            CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
            bn3Var2.c = a(cellIdentity.getMcc());
            bn3Var2.d = a(cellIdentity.getMnc());
            bn3Var2.a = a(cellIdentity.getLac());
            bn3Var2.b = a(cellIdentity.getCid());
            bn3Var2.i = 'g';
            bn3Var2.h = cellInfoGsm.getCellSignalStrength().getAsuLevel();
            bn3Var2.k = 2;
            if (i >= 28) {
                bn3Var2.j = cellInfo.getCellConnectionStatus();
            }
        } else if (cellInfo instanceof CellInfoCdma) {
            CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
            CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
            bn3Var2.e = cellIdentity2.getLatitude();
            bn3Var2.f = cellIdentity2.getLongitude();
            bn3Var2.d = a(cellIdentity2.getSystemId());
            bn3Var2.a = a(cellIdentity2.getNetworkId());
            bn3Var2.b = a(cellIdentity2.getBasestationId());
            bn3Var2.i = 'c';
            bn3Var2.h = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
            bn3Var2.k = 1;
            if (i >= 28) {
                bn3Var2.j = cellInfo.getCellConnectionStatus();
            }
            if (bn3Var == null || (iIntValue = bn3Var.c) <= 0) {
                try {
                    String networkOperator = telephonyManager.getNetworkOperator();
                    if (networkOperator == null || networkOperator.length() <= 0 || networkOperator.length() < 3 || (iIntValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue()) < 0) {
                        iIntValue = -1;
                    }
                } catch (Exception unused) {
                }
                if (iIntValue > 0) {
                    bn3Var2.c = iIntValue;
                }
            } else {
                bn3Var2.c = iIntValue;
            }
        } else if (cellInfo instanceof CellInfoLte) {
            CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
            CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
            bn3Var2.c = a(cellIdentity3.getMcc());
            bn3Var2.d = a(cellIdentity3.getMnc());
            bn3Var2.a = a(cellIdentity3.getTac());
            bn3Var2.b = a(cellIdentity3.getCi());
            bn3Var2.i = 'g';
            bn3Var2.h = cellInfoLte.getCellSignalStrength().getAsuLevel();
            bn3Var2.k = 3;
            if (i >= 28) {
                bn3Var2.j = cellInfo.getCellConnectionStatus();
            }
        } else {
            z = false;
        }
        if (!z) {
            try {
                if (cellInfo instanceof CellInfoWcdma) {
                    CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    bn3Var2.c = a(cellIdentity4.getMcc());
                    bn3Var2.d = a(cellIdentity4.getMnc());
                    bn3Var2.a = a(cellIdentity4.getLac());
                    bn3Var2.b = a(cellIdentity4.getCid());
                    bn3Var2.i = 'g';
                    bn3Var2.h = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getAsuLevel();
                    bn3Var2.k = 4;
                    if (Build.VERSION.SDK_INT >= 28) {
                        bn3Var2.j = cellInfo.getCellConnectionStatus();
                    }
                } else if (Build.VERSION.SDK_INT >= 29) {
                    if (bo3.a(cellInfo)) {
                        CellIdentityTdscdma cellIdentity5 = ho3.a(cellInfo).getCellIdentity();
                        if (cellIdentity5.getMccString() != null) {
                            try {
                                bn3Var2.c = Integer.valueOf(cellIdentity5.getMccString()).intValue();
                            } catch (Throwable unused2) {
                            }
                        }
                        if (cellIdentity5.getMncString() != null) {
                            try {
                                bn3Var2.d = Integer.valueOf(cellIdentity5.getMncString()).intValue();
                            } catch (Throwable unused3) {
                            }
                        }
                        bn3Var2.a = a(cellIdentity5.getLac());
                        bn3Var2.b = a(cellIdentity5.getCid());
                        bn3Var2.i = 'g';
                        bn3Var2.h = ho3.a(cellInfo).getCellSignalStrength().getAsuLevel();
                        bn3Var2.k = 5;
                        if (Build.VERSION.SDK_INT >= 28) {
                            bn3Var2.j = cellInfo.getCellConnectionStatus();
                        }
                    } else if (ko3.a(cellInfo)) {
                        try {
                            cellIdentityNrA = gn3.a(lo3.a(cellInfo).getCellIdentity());
                        } catch (Throwable th) {
                            th.printStackTrace();
                            cellIdentityNrA = null;
                        }
                        if (cellIdentityNrA != null) {
                            if (cellIdentityNrA.getMccString() != null) {
                                try {
                                    bn3Var2.c = Integer.valueOf(cellIdentityNrA.getMccString()).intValue();
                                } catch (Throwable unused4) {
                                }
                            }
                            if (cellIdentityNrA.getMncString() != null) {
                                try {
                                    bn3Var2.d = Integer.valueOf(cellIdentityNrA.getMncString()).intValue();
                                } catch (Throwable unused5) {
                                }
                            }
                            int iA = a(cellIdentityNrA.getTac());
                            bn3Var2.a = iA;
                            if (iA == -1) {
                                try {
                                    bn3Var2.a = a(b(cellIdentityNrA));
                                } catch (Throwable unused6) {
                                }
                            }
                            if (bn3Var2.a == -1) {
                                try {
                                    bn3Var2.a = a(c(cellIdentityNrA.toString()));
                                } catch (Throwable unused7) {
                                }
                            }
                            if (bn3Var2.a == -1) {
                                bn3Var2.a = cellIdentityNrA.getTac();
                            }
                            if (cellIdentityNrA.getNci() != Long.MAX_VALUE) {
                                bn3Var2.b = cellIdentityNrA.getNci();
                            }
                            bn3Var2.i = 'g';
                            bn3Var2.k = 6;
                            if (Build.VERSION.SDK_INT >= 28) {
                                bn3Var2.j = cellInfo.getCellConnectionStatus();
                            }
                            CellSignalStrengthNr cellSignalStrengthNrA = on3.a(lo3.a(cellInfo).getCellSignalStrength());
                            bn3Var2.h = cellSignalStrengthNrA.getAsuLevel();
                            if (bn3Var2.c()) {
                                bn3Var2.n = String.format(Locale.US, "%d|%d|%d|%d|%d|%d|%d|%d", Integer.valueOf(cellSignalStrengthNrA.getCsiRsrp()), Integer.valueOf(cellSignalStrengthNrA.getCsiRsrq()), Integer.valueOf(cellSignalStrengthNrA.getCsiSinr()), Integer.valueOf(cellSignalStrengthNrA.getDbm()), Integer.valueOf(cellSignalStrengthNrA.getLevel()), Integer.valueOf(cellSignalStrengthNrA.getSsRsrp()), Integer.valueOf(cellSignalStrengthNrA.getSsRsrq()), Integer.valueOf(cellSignalStrengthNrA.getSsSinr()));
                            }
                        }
                    }
                }
            } catch (Exception unused8) {
            }
        }
        try {
            if (i >= 30) {
                jElapsedRealtimeNanos = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                jCurrentTimeMillis = System.currentTimeMillis();
            } else {
                jElapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            bn3Var2.g = jCurrentTimeMillis - jElapsedRealtimeNanos;
        } catch (Error unused9) {
            bn3Var2.g = System.currentTimeMillis();
        }
        return bn3Var2;
    }

    private bn3 f(CellLocation cellLocation) {
        return g(cellLocation, false);
    }

    private bn3 g(CellLocation cellLocation, boolean z) {
        int iIntValue;
        if (cellLocation == null || this.a == null) {
            return null;
        }
        bn3 bn3Var = new bn3();
        bn3Var.l = 1;
        if (z) {
            bn3Var.g();
        }
        bn3Var.g = System.currentTimeMillis();
        try {
            String networkOperator = this.a.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                if (networkOperator.length() >= 3) {
                    iIntValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    bn3Var.c = iIntValue < 0 ? this.b.c : iIntValue;
                } else {
                    iIntValue = -1;
                }
                String strSubstring = networkOperator.substring(3);
                if (strSubstring != null) {
                    char[] charArray = strSubstring.toCharArray();
                    int i = 0;
                    while (i < charArray.length && Character.isDigit(charArray[i])) {
                        i++;
                    }
                    iIntValue = Integer.valueOf(strSubstring.substring(0, i)).intValue();
                }
                if (iIntValue < 0) {
                    iIntValue = this.b.d;
                }
                bn3Var.d = iIntValue;
            }
            n = this.a.getSimState();
        } catch (Exception unused) {
            o = 1;
        }
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            bn3Var.a = gsmCellLocation.getLac();
            bn3Var.b = gsmCellLocation.getCid();
            bn3Var.i = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            bn3Var.i = 'c';
            if (f382q == null) {
                try {
                    f382q = Class.forName("android.telephony.cdma.CdmaCellLocation");
                } catch (Exception unused2) {
                    f382q = null;
                    return bn3Var;
                }
            }
            Class cls = f382q;
            if (cls != null && cls.isInstance(cellLocation)) {
                try {
                    int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                    if (systemId < 0) {
                        systemId = this.b.d;
                    }
                    bn3Var.d = systemId;
                    bn3Var.b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                    bn3Var.a = ((CdmaCellLocation) cellLocation).getNetworkId();
                    int baseStationLatitude = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                    if (baseStationLatitude < Integer.MAX_VALUE) {
                        bn3Var.e = baseStationLatitude;
                    }
                    int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                    if (baseStationLongitude < Integer.MAX_VALUE) {
                        bn3Var.f = baseStationLongitude;
                    }
                } catch (Exception unused3) {
                    o = 3;
                    return bn3Var;
                }
            }
        }
        r(bn3Var);
        return bn3Var;
    }

    public static synchronized so3 h() {
        try {
            if (m == null) {
                m = new so3();
            }
        } catch (Throwable th) {
            throw th;
        }
        return m;
    }

    private static String j(List list) {
        if (list == null) {
            return null;
        }
        list.size();
        return null;
    }

    private static List n(List list) {
        if (list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return list;
        }
        Collections.sort(list.subList(1, list.size()), new c());
        return list.subList(0, list.size());
    }

    private void r(bn3 bn3Var) {
        if (bn3Var.c()) {
            bn3 bn3Var2 = this.b;
            if (bn3Var2 == null || !bn3Var2.b(bn3Var)) {
                this.b = bn3Var;
                if (!bn3Var.c()) {
                    List list = this.d;
                    if (list != null) {
                        list.clear();
                        return;
                    }
                    return;
                }
                int size = this.d.size();
                bn3 bn3Var3 = size == 0 ? null : (bn3) this.d.get(size - 1);
                if (bn3Var3 != null) {
                    long j = bn3Var3.b;
                    bn3 bn3Var4 = this.b;
                    if (j == bn3Var4.b && bn3Var3.a == bn3Var4.a) {
                        return;
                    }
                }
                this.d.add(this.b);
                if (this.d.size() > 3) {
                    this.d.remove(0);
                }
                A();
                this.g = false;
            }
        }
    }

    private String s(bn3 bn3Var) {
        bn3 bn3VarE;
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = null;
        try {
            List<CellInfo> allCellInfo = this.a.getAllCellInfo();
            if (allCellInfo != null && allCellInfo.size() > 0) {
                sb2.append("&nc=");
                for (CellInfo cellInfo : allCellInfo) {
                    if (!cellInfo.isRegistered() && (bn3VarE = e(cellInfo, this.b, this.a)) != null) {
                        int i = bn3VarE.a;
                        if (i != -1 && bn3VarE.b != -1) {
                            if (bn3Var == null || bn3Var.a != i) {
                                sb = new StringBuilder();
                                sb.append(bn3VarE.a);
                                sb.append("|");
                                sb.append(bn3VarE.b);
                                sb.append("|");
                                sb.append(bn3VarE.h);
                                sb.append(";");
                            } else {
                                sb = new StringBuilder();
                                sb.append("|");
                                sb.append(bn3VarE.b);
                                sb.append("|");
                                sb.append(bn3VarE.h);
                                sb.append(";");
                            }
                            sb2.append(sb.toString());
                        }
                        if (Build.VERSION.SDK_INT > 28 && bn3VarE.k == 6 && bn3VarE.n != null && bn3VarE.c()) {
                            if (sb3 == null) {
                                StringBuilder sb4 = new StringBuilder();
                                try {
                                    sb4.append("&ncnr=");
                                    sb3 = sb4;
                                } catch (Throwable unused) {
                                    sb3 = sb4;
                                }
                            }
                            sb3.append(bn3VarE.h());
                            sb3.append("_");
                            sb3.append(bn3VarE.n);
                            sb3.append(";");
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        if (sb3 == null) {
            return sb2.toString();
        }
        return sb2.toString() + sb3.toString();
    }

    public static String y() {
        String str = p;
        if (str == null || str.length() == 0) {
            return null;
        }
        return p.replace("\n", Constants.STR_EMPTY);
    }

    private void z() {
        String strC = fq3.C();
        if (strC == null) {
            return;
        }
        File file = new File(strC + File.separator + "lcvif2.dat");
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                long j = 0;
                randomAccessFile.seek(0L);
                if (System.currentTimeMillis() - randomAccessFile.readLong() > 60000) {
                    randomAccessFile.close();
                    file.delete();
                    return;
                }
                randomAccessFile.readInt();
                int i = 0;
                while (i < 3) {
                    long j2 = randomAccessFile.readLong();
                    int i2 = randomAccessFile.readInt();
                    int i3 = randomAccessFile.readInt();
                    int i4 = randomAccessFile.readInt();
                    long j3 = randomAccessFile.readLong();
                    int i5 = randomAccessFile.readInt();
                    char c2 = i5 == 1 ? 'g' : (char) 0;
                    if (i5 == 2) {
                        c2 = 'c';
                    }
                    if (j2 != j) {
                        bn3 bn3Var = new bn3(i4, j3, i2, i3, 0, c2, -1);
                        bn3Var.g = j2;
                        if (bn3Var.c()) {
                            this.g = true;
                            this.d.add(bn3Var);
                        }
                    }
                    i++;
                    j = 0;
                }
                randomAccessFile.close();
            } catch (Exception unused) {
                file.delete();
            }
        }
    }

    public String i(bn3 bn3Var) {
        try {
            String strS = s(bn3Var);
            if (strS == null || strS.equals(Constants.STR_EMPTY)) {
                return strS;
            }
            strS.equals("&nc=");
            return strS;
        } catch (Throwable th) {
            th.printStackTrace();
            if (Constants.STR_EMPTY.equals("&nc=")) {
                return null;
            }
            return Constants.STR_EMPTY;
        }
    }

    public String m(bn3 bn3Var) {
        int i;
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(bn3Var.i);
        Locale locale = Locale.CHINA;
        stringBuffer.append(String.format(locale, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(bn3Var.c), Integer.valueOf(bn3Var.d), Integer.valueOf(bn3Var.a), Long.valueOf(bn3Var.b), Integer.valueOf(bn3Var.h)));
        if (bn3Var.e < Integer.MAX_VALUE && (i = bn3Var.f) < Integer.MAX_VALUE) {
            stringBuffer.append(String.format(locale, "&cdmall=%.6f|%.6f", Double.valueOf(((double) i) / 14400.0d), Double.valueOf(((double) bn3Var.e) / 14400.0d)));
        }
        stringBuffer.append("&cl_t=");
        stringBuffer.append(bn3Var.g);
        stringBuffer.append("&cl_api=");
        stringBuffer.append(bn3Var.l);
        stringBuffer.append("&clp=");
        stringBuffer.append(bn3Var.k);
        if (bn3Var.n != null) {
            stringBuffer.append("&clnrs=");
            stringBuffer.append(bn3Var.n);
        }
        if (Build.VERSION.SDK_INT >= 28 && bn3Var.j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs=");
            stringBuffer.append(bn3Var.j);
        }
        try {
            List list = this.d;
            if (list != null && list.size() > 0) {
                int size = this.d.size();
                stringBuffer.append("&clt=");
                for (int i2 = 0; i2 < size; i2++) {
                    bn3 bn3Var2 = (bn3) this.d.get(i2);
                    if (bn3Var2 != null) {
                        int i3 = bn3Var2.c;
                        if (i3 != bn3Var.c) {
                            stringBuffer.append(i3);
                        }
                        stringBuffer.append("|");
                        int i4 = bn3Var2.d;
                        if (i4 != bn3Var.d) {
                            stringBuffer.append(i4);
                        }
                        stringBuffer.append("|");
                        int i5 = bn3Var2.a;
                        if (i5 != bn3Var.a) {
                            stringBuffer.append(i5);
                        }
                        stringBuffer.append("|");
                        long j = bn3Var2.b;
                        if (j != bn3Var.b) {
                            stringBuffer.append(j);
                        }
                        stringBuffer.append("|");
                        stringBuffer.append((System.currentTimeMillis() - bn3Var2.g) / 1000);
                        stringBuffer.append(";");
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (n > 100) {
            n = 0;
        }
        stringBuffer.append("&cs=" + (n + (o << 8)));
        String str = bn3Var.m;
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append("&cl_list=");
        stringBuffer.append(y());
        return stringBuffer.toString();
    }

    public synchronized void o() {
        b bVar;
        if (this.f) {
            return;
        }
        if (f.e) {
            this.a = (TelephonyManager) f.b().getSystemService("phone");
            this.d = new LinkedList();
            this.e = new b();
            z();
            TelephonyManager telephonyManager = this.a;
            if (telephonyManager != null && (bVar = this.e) != null) {
                if (Build.VERSION.SDK_INT < this.l || !this.k) {
                    try {
                        telephonyManager.listen(bVar, 1280);
                    } catch (Exception unused) {
                    }
                }
                this.f = true;
            }
        }
    }

    public synchronized void q() {
        TelephonyManager telephonyManager;
        try {
            if (this.f) {
                b bVar = this.e;
                if (bVar != null && (telephonyManager = this.a) != null) {
                    telephonyManager.listen(bVar, 0);
                }
                this.e = null;
                this.a = null;
                this.d.clear();
                this.d = null;
                A();
                this.f = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean t() {
        return this.g;
    }

    public int u() {
        TelephonyManager telephonyManager = this.a;
        if (telephonyManager == null) {
            return 0;
        }
        try {
            return telephonyManager.getNetworkType();
        } catch (Exception unused) {
            return 0;
        }
    }

    public bn3 v() {
        bn3 bn3Var;
        bn3 bn3Var2 = this.b;
        if ((bn3Var2 == null || !bn3Var2.a() || !this.b.c()) && this.a != null) {
            try {
                B();
                if (Build.VERSION.SDK_INT >= 29 && this.k && System.currentTimeMillis() - this.i > 30000) {
                    this.i = System.currentTimeMillis();
                    if (this.h == null) {
                        this.h = new a();
                    }
                    this.a.requestCellInfoUpdate(f.b().getMainExecutor(), this.h);
                }
            } catch (Exception unused) {
            }
        }
        bn3 bn3Var3 = this.b;
        if (bn3Var3 != null && bn3Var3.f()) {
            this.c = null;
            this.c = new bn3(this.b);
        }
        bn3 bn3Var4 = this.b;
        if (bn3Var4 != null && bn3Var4.e() && (bn3Var = this.c) != null) {
            bn3 bn3Var5 = this.b;
            if (bn3Var5.i == 'g') {
                bn3Var5.d = bn3Var.d;
                bn3Var5.c = bn3Var.c;
            }
        }
        return this.b;
    }

    public String w() {
        int simState = -1;
        try {
            TelephonyManager telephonyManager = this.a;
            if (telephonyManager != null) {
                simState = telephonyManager.getSimState();
            }
        } catch (Exception unused) {
        }
        return "&sim=" + simState;
    }

    public int x() {
        return 0;
    }
}
