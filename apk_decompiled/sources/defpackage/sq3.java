package defpackage;

import android.location.GnssNavigationMessage;
import com.jieli.jl_rcsp.constant.Command;
import io.reactivex.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public class sq3 {
    private static final double[] c = {1999.0d, 8.0d, 22.0d, 0.0d, 0.0d, 0.0d};
    private HashMap a = new HashMap();
    private HashMap b = new HashMap();

    private static class a {
        private static sq3 a = new sq3();
    }

    private class b {
        int a = 0;
        double b = 0.0d;

        public b() {
        }
    }

    private class c {
        private boolean a;
        private boolean b;
        private long c;
        private int d;
        private int e;
        private ArrayList f;
        private ArrayList g;
        private int h;
        private double i;
        private double j;
        private double k;
        private int l;
        private int m;
        private b n;

        public c(int i, int i2) {
            f(i, i2);
            this.h = 0;
            this.i = 0.0d;
            this.j = 0.0d;
            this.k = 0.0d;
            this.l = 0;
            this.m = 0;
            this.n = sq3.this.new b();
        }

        private String a(GnssNavigationMessage gnssNavigationMessage) {
            StringBuilder sb = new StringBuilder();
            for (byte b : gnssNavigationMessage.getData()) {
                sb.append(String.format("%8s", Integer.toBinaryString(b & 255)).replace(' ', '0'));
            }
            return sb.toString();
        }

        private b c(int i, double d) {
            b bVarD = d(sq3.c);
            if (d < -1.0E9d || 1.0E9d < d) {
                d = 0.0d;
            }
            int i2 = (int) d;
            bVarD.a += (i * 604800) + i2;
            bVarD.b = d - ((double) i2);
            return bVarD;
        }

        private b d(double[] dArr) {
            int[] iArr = {1, 32, 60, 91, 121, Opcodes.DCMPG, Opcodes.INVOKEVIRTUAL, Command.CMD_GET_LOW_LATENCY_SETTINGS, 244, 274, 305, 335};
            b bVar = sq3.this.new b();
            int i = (int) dArr[0];
            int i2 = (int) dArr[1];
            int i3 = (int) dArr[2];
            if (i >= 1970 && 2099 >= i && i2 >= 1 && 12 >= i2) {
                int i4 = (((((i - 1970) * 365) + ((i - 1969) / 4)) + iArr[i2 - 1]) + i3) - 2;
                int i5 = (i % 4 != 0 || i2 < 3) ? 0 : 1;
                int iFloor = (int) Math.floor(dArr[5]);
                bVar.a = ((i4 + i5) * 86400) + (((int) dArr[3]) * 3600) + (((int) dArr[4]) * 60) + iFloor;
                bVar.b = dArr[5] - ((double) iFloor);
            }
            return bVar;
        }

        private void e() {
            if (this.f.size() != 0) {
                for (int i = 0; i < this.f.size(); i++) {
                    if (!((String) this.f.get(i)).contains("None")) {
                    }
                }
                this.b = true;
                return;
            }
            this.b = false;
        }

        private void f(int i, int i2) {
            int i3 = this.e;
            int i4 = 5;
            if (i3 != 257 && i3 != 769) {
                if (i3 == 1537) {
                    i4 = 6;
                } else if (i3 != 1281) {
                    i4 = i3 != 1282 ? 0 : 10;
                } else {
                    i4 = 3;
                }
            }
            ArrayList arrayList = this.f;
            if (arrayList != null) {
                arrayList.clear();
            } else {
                this.f = new ArrayList();
            }
            ArrayList arrayList2 = this.g;
            if (arrayList2 != null) {
                arrayList2.clear();
            } else {
                this.g = new ArrayList();
            }
            for (int i5 = 0; i5 < i4; i5++) {
                this.f.add("None");
            }
            this.d = i;
            this.e = i2;
            this.a = false;
            this.b = false;
            this.c = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(GnssNavigationMessage gnssNavigationMessage, long j) {
            int type = gnssNavigationMessage.getType();
            int svid = gnssNavigationMessage.getSvid();
            int submessageId = gnssNavigationMessage.getSubmessageId();
            byte[] data = gnssNavigationMessage.getData();
            if (j - this.c > 1200 || this.a || this.f.size() == 0 || type != this.e || svid != this.d) {
                f(svid, type);
            }
            if ((type == 1282 || type == 1281) && !l()) {
                f(svid, type);
            }
            if (this.f.size() == 0) {
                return;
            }
            int i = this.e;
            boolean z = true;
            int i2 = i == 1537 ? 0 : 1;
            if (i == 1282) {
                if (submessageId != 1) {
                    return;
                }
                q(j(gnssNavigationMessage));
                submessageId = this.l;
            }
            int i3 = submessageId - i2;
            if (i3 >= this.f.size()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (byte b : data) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                sb.append((int) b);
            }
            this.f.set(i3, sb.toString());
            if (type == 1281 || type == 1282) {
                this.g.add(Integer.valueOf(i3));
            }
            if (this.e == 1537) {
                h(a(gnssNavigationMessage));
            }
            e();
            this.c = j;
        }

        private void h(String str) {
            StringBuilder sb;
            int i;
            char cCharAt = str.charAt(0);
            char cCharAt2 = str.charAt(120);
            if (cCharAt == '1' && cCharAt2 == '0') {
                sb = new StringBuilder();
                sb.append(str.substring(2, 18));
                i = 234;
            } else {
                if (cCharAt != '0' || cCharAt2 != '1') {
                    return;
                }
                sb = new StringBuilder();
                sb.append(str.substring(2, 114));
                i = Opcodes.L2D;
            }
            sb.append(str.substring(122, i));
            String string = sb.toString();
            int i2 = Integer.parseInt(string.substring(0, 6), 2);
            if (i2 == 0) {
                k(string);
            } else if (i2 == 1) {
                n(string);
            } else if (i2 == 4) {
                p(string);
            }
        }

        private String j(GnssNavigationMessage gnssNavigationMessage) {
            StringBuilder sb = new StringBuilder();
            byte[] data = gnssNavigationMessage.getData();
            int length = data.length;
            for (int i = 0; i < length; i++) {
                String strReplace = String.format("%8s", Integer.toBinaryString(data[i] & 255)).replace(' ', '0');
                if (i % 4 == 0) {
                    strReplace = strReplace.substring(2, 8);
                }
                sb.append(strReplace);
            }
            return sb.toString();
        }

        private void k(String str) {
            this.h = Integer.parseInt(str.substring(96, 108), 2);
            this.i = Long.parseLong(str.substring(108, 128), 2);
        }

        private boolean l() {
            if (this.g == null) {
                return false;
            }
            for (int i = 0; i < this.g.size(); i++) {
                if (((Integer) this.g.get(i)).intValue() != i) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String m() {
            StringBuilder sb = new StringBuilder();
            if (!this.b) {
                return sb.toString();
            }
            if (this.e == 1537) {
                o();
            }
            sb.append(this.n.a);
            sb.append('|');
            boolean z = true;
            for (int i = 0; i < this.f.size(); i++) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                sb.append((String) this.f.get(i));
            }
            this.a = true;
            return sb.toString();
        }

        private void n(String str) {
            this.j = Long.parseLong(str.substring(16, 30), 2) * 60.0d;
        }

        private void o() {
            int i;
            b bVarC = c(this.h, this.i);
            b bVarC2 = c(this.h, this.j);
            double d = (((double) (bVarC2.a - bVarC.a)) + bVarC2.b) - bVarC.b;
            if (d <= 302400.0d) {
                if (d < -302400.0d) {
                    i = this.h + 1;
                }
                this.n = c(this.h, this.k);
                this.m = this.h + 1024;
            }
            i = this.h - 1;
            this.h = i;
            this.n = c(this.h, this.k);
            this.m = this.h + 1024;
        }

        private void p(String str) {
            this.k = Long.parseLong(str.substring(54, 68), 2) * 60;
        }

        private void q(String str) {
            this.l = Integer.parseInt(str.substring(42, 46), 2);
        }
    }

    public static sq3 a() {
        return a.a;
    }

    public void b(GnssNavigationMessage gnssNavigationMessage, long j) {
        String str;
        HashMap map;
        int svid = gnssNavigationMessage.getSvid();
        int type = gnssNavigationMessage.getType();
        if (type == 257) {
            str = "G";
        } else if (type == 769) {
            str = "R";
        } else if (type == 1537) {
            str = "E";
        } else if (type != 1281) {
            str = type != 1282 ? SchedulerSupport.NONE : "CT";
        } else {
            str = "CO";
        }
        String str2 = str + svid;
        if (str2.contains(SchedulerSupport.NONE) || (map = this.a) == null) {
            return;
        }
        if (!map.containsKey(str2)) {
            this.a.put(str2, new c(svid, type));
        }
        ((c) this.a.get(str2)).g(gnssNavigationMessage, j);
    }

    public ArrayList c() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.a.entrySet()) {
            String str = (String) entry.getKey();
            String strM = ((c) entry.getValue()).m();
            if (strM != null && strM.length() != 0) {
                if (this.b.containsKey(str)) {
                    if (strM.substring(0, 100).equals(((String) this.b.get(str)).substring(0, 100))) {
                    }
                } else {
                    this.b.put(str, strM);
                }
                arrayList.add(str + '|' + strM);
            }
        }
        return arrayList;
    }
}
