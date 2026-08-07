package defpackage;

import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.x;
import androidx.camera.video.p;
import androidx.camera.video.x0;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class yb3 {
    private static final Map a;
    private static final Timebase b;

    static {
        HashMap map = new HashMap();
        a = map;
        b = Timebase.UPTIME;
        HashMap map2 = new HashMap();
        oc3 oc3Var = oc3.a;
        map2.put(1, oc3Var);
        oc3 oc3Var2 = oc3.c;
        map2.put(2, oc3Var2);
        oc3 oc3Var3 = oc3.d;
        map2.put(4096, oc3Var3);
        map2.put(8192, oc3Var3);
        HashMap map3 = new HashMap();
        map3.put(1, oc3Var);
        map3.put(2, oc3Var2);
        map3.put(4096, oc3Var3);
        map3.put(8192, oc3Var3);
        HashMap map4 = new HashMap();
        map4.put(1, oc3Var);
        map4.put(4, oc3Var2);
        map4.put(4096, oc3Var3);
        map4.put(16384, oc3Var3);
        map4.put(2, oc3Var);
        map4.put(8, oc3Var2);
        map4.put(8192, oc3Var3);
        map4.put(32768, oc3Var3);
        HashMap map5 = new HashMap();
        map5.put(256, oc3Var2);
        map5.put(512, oc3.b);
        map.put("video/hevc", map2);
        map.put("video/av01", map3);
        map.put("video/x-vnd.on2.vp9", map4);
        map.put("video/dolby-vision", map5);
    }

    private static String a(ie0 ie0Var) {
        int iB = ie0Var.b();
        if (iB == 1) {
            return "video/avc";
        }
        if (iB == 3 || iB == 4 || iB == 5) {
            return "video/hevc";
        }
        if (iB == 6) {
            return "video/dolby-vision";
        }
        throw new UnsupportedOperationException("Unsupported dynamic range: " + ie0Var + "\nNo supported default mime type available.");
    }

    public static oc3 b(String str, int i) {
        oc3 oc3Var;
        Map map = (Map) a.get(str);
        if (map != null && (oc3Var = (oc3) map.get(Integer.valueOf(i))) != null) {
            return oc3Var;
        }
        x.k("VideoConfigUtil", String.format("Unsupported mime type %s or profile level %d. Data space is unspecified.", str, Integer.valueOf(i)));
        return oc3.a;
    }

    public static kc3 c(tc3 tc3Var, Timebase timebase, x0 x0Var, Size size, ie0 ie0Var, Range range) {
        eh0.c cVarD = tc3Var.d();
        return (kc3) (cVarD != null ? new mc3(tc3Var.a(), timebase, x0Var, size, cVarD, ie0Var, range) : new lc3(tc3Var.a(), timebase, x0Var, size, ie0Var, range)).get();
    }

    public static tc3 d(p pVar, ie0 ie0Var, vd3 vd3Var) {
        eh0.c cVar;
        b52.j(ie0Var.e(), "Dynamic range must be a fully specified dynamic range [provided dynamic range: " + ie0Var + "]");
        String strH = p.h(pVar.c());
        if (vd3Var != null) {
            Set setC = me0.c(ie0Var);
            Set setB = me0.b(ie0Var);
            Iterator it = vd3Var.d().iterator();
            while (true) {
                if (it.hasNext()) {
                    cVar = (eh0.c) it.next();
                    if (setC.contains(Integer.valueOf(cVar.g())) && setB.contains(Integer.valueOf(cVar.b()))) {
                        String strI = cVar.i();
                        if (Objects.equals(strH, strI)) {
                            x.a("VideoConfigUtil", "MediaSpec video mime matches EncoderProfiles. Using EncoderProfiles to derive VIDEO settings [mime type: " + strH + "]");
                        } else if (pVar.c() == -1) {
                            x.a("VideoConfigUtil", "MediaSpec contains OUTPUT_FORMAT_AUTO. Using CamcorderProfile to derive VIDEO settings [mime type: " + strH + ", dynamic range: " + ie0Var + "]");
                        }
                        strH = strI;
                    }
                } else {
                    cVar = null;
                }
            }
        } else {
            cVar = null;
        }
        if (cVar == null) {
            if (pVar.c() == -1) {
                strH = a(ie0Var);
            }
            if (vd3Var == null) {
                x.a("VideoConfigUtil", "No EncoderProfiles present. May rely on fallback defaults to derive VIDEO settings [chosen mime type: " + strH + ", dynamic range: " + ie0Var + "]");
            } else {
                x.a("VideoConfigUtil", "No video EncoderProfile is compatible with requested output format and dynamic range. May rely on fallback defaults to derive VIDEO settings [chosen mime type: " + strH + ", dynamic range: " + ie0Var + "]");
            }
        }
        tc3.a aVarC = tc3.c(strH);
        if (cVar != null) {
            aVarC.c(cVar);
        }
        return aVarC.b();
    }

    public static int e(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, Range range) {
        int iDoubleValue = (int) (((double) i) * new Rational(i2, i3).doubleValue() * new Rational(i4, i5).doubleValue() * new Rational(i6, i7).doubleValue() * new Rational(i8, i9).doubleValue());
        String str = x.f("VideoConfigUtil") ? String.format("Base Bitrate(%dbps) * Bit Depth Ratio (%d / %d) * Frame Rate Ratio(%d / %d) * Width Ratio(%d / %d) * Height Ratio(%d / %d) = %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(iDoubleValue)) : Constants.STR_EMPTY;
        if (!x0.b.equals(range)) {
            Integer num = (Integer) range.clamp(Integer.valueOf(iDoubleValue));
            int iIntValue = num.intValue();
            if (x.f("VideoConfigUtil")) {
                str = str + String.format("\nClamped to range %s -> %dbps", range, num);
            }
            iDoubleValue = iIntValue;
        }
        x.a("VideoConfigUtil", str);
        return iDoubleValue;
    }

    public static kc3 f(eh0.c cVar) {
        return kc3.d().h(cVar.i()).i(cVar.j()).j(new Size(cVar.k(), cVar.h())).e(cVar.f()).b(cVar.c()).g(b).a();
    }
}
