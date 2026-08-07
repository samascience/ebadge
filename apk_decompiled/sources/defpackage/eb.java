package defpackage;

import android.util.Range;
import android.util.Rational;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.x;
import androidx.camera.video.a;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.camera.video.p;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class eb {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int b(int i, Integer num, Integer num2) {
        int iAbs = Math.abs(num.intValue() - i) - Math.abs(num2.intValue() - i);
        return (int) (iAbs == 0 ? Math.signum(num.intValue() - num2.intValue()) : Math.signum(iAbs));
    }

    public static fb c(jb jbVar, Timebase timebase, kb kbVar, a aVar) {
        eh0.a aVarD = jbVar.d();
        return (fb) (aVarD != null ? new gb(jbVar.a(), jbVar.b(), timebase, aVar, kbVar, aVarD) : new hb(jbVar.a(), jbVar.b(), timebase, aVar, kbVar)).get();
    }

    public static jb d(p pVar, vd3 vd3Var) {
        eh0.a aVarJ;
        String strE = p.e(pVar.c());
        int iF = p.f(pVar.c());
        if (vd3Var == null || vd3Var.j() == null) {
            aVarJ = null;
        } else {
            aVarJ = vd3Var.j();
            String strE2 = aVarJ.e();
            int iF2 = aVarJ.f();
            if (Objects.equals(strE2, "audio/none")) {
                x.a("AudioConfigUtil", "EncoderProfiles contains undefined AUDIO mime type so cannot be used. May rely on fallback defaults to derive settings [chosen mime type: " + strE + "(profile: " + iF + ")]");
            } else if (pVar.c() == -1) {
                x.a("AudioConfigUtil", "MediaSpec contains OUTPUT_FORMAT_AUTO. Using EncoderProfiles to derive AUDIO settings [mime type: " + strE2 + "(profile: " + iF2 + ")]");
                strE = strE2;
                iF = iF2;
            } else if (Objects.equals(strE, strE2) && iF == iF2) {
                x.a("AudioConfigUtil", "MediaSpec audio mime/profile matches EncoderProfiles. Using EncoderProfiles to derive AUDIO settings [mime type: " + strE2 + "(profile: " + iF + ")]");
                strE = strE2;
            } else {
                x.a("AudioConfigUtil", "MediaSpec audio mime or profile does not match EncoderProfiles, so EncoderProfiles settings cannot be used. May rely on fallback defaults to derive AUDIO settings [EncoderProfiles mime type: " + strE2 + "(profile: " + iF2 + "), chosen mime type: " + strE + "(profile: " + iF + ")]");
            }
            aVarJ = null;
        }
        jb.a aVar = (jb.a) jb.c(strE).a(iF);
        if (aVarJ != null) {
            aVar.c(aVarJ);
        }
        return aVar.b();
    }

    public static kb e(jb jbVar, a aVar) {
        eh0.a aVarD = jbVar.d();
        return (kb) (aVarD != null ? new lb(aVar, aVarD) : new mb(aVar)).get();
    }

    static int f(a aVar) {
        int iE = aVar.e();
        if (iE == -1) {
            x.a("AudioConfigUtil", "Using default AUDIO source: 5");
            return 5;
        }
        x.a("AudioConfigUtil", "Using provided AUDIO source: " + iE);
        return iE;
    }

    static int g(a aVar) {
        int iF = aVar.f();
        if (iF == -1) {
            x.a("AudioConfigUtil", "Using default AUDIO source format: 2");
            return 2;
        }
        x.a("AudioConfigUtil", "Using provided AUDIO source format: " + iF);
        return iF;
    }

    static int h(int i, int i2, int i3, int i4, int i5, Range range) {
        int iDoubleValue = (int) (((double) i) * new Rational(i2, i3).doubleValue() * new Rational(i4, i5).doubleValue());
        String str = x.f("AudioConfigUtil") ? String.format("Base Bitrate(%dbps) * Channel Count Ratio(%d / %d) * Sample Rate Ratio(%d / %d) = %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(iDoubleValue)) : Constants.STR_EMPTY;
        if (!a.a.equals(range)) {
            Integer num = (Integer) range.clamp(Integer.valueOf(iDoubleValue));
            iDoubleValue = num.intValue();
            if (x.f("AudioConfigUtil")) {
                str = str + String.format("\nClamped to range %s -> %dbps", range, num);
            }
        }
        x.a("AudioConfigUtil", str);
        return iDoubleValue;
    }

    static int i(Range range, int i, int i2, final int i3) {
        ArrayList arrayList = null;
        int i4 = 0;
        int iIntValue = i3;
        while (true) {
            if (!range.contains(Integer.valueOf(iIntValue))) {
                x.a("AudioConfigUtil", "Sample rate " + iIntValue + "Hz is not in target range " + range);
            } else {
                if (AudioSource.o(iIntValue, i, i2)) {
                    return iIntValue;
                }
                x.a("AudioConfigUtil", "Sample rate " + iIntValue + "Hz is not supported by audio source with channel count " + i + " and source format " + i2);
            }
            if (arrayList == null) {
                x.a("AudioConfigUtil", "Trying common sample rates in proximity order to target " + i3 + "Hz");
                arrayList = new ArrayList(kb.a);
                Collections.sort(arrayList, new Comparator() { // from class: db
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return eb.b(i3, (Integer) obj, (Integer) obj2);
                    }
                });
            }
            if (i4 >= arrayList.size()) {
                x.a("AudioConfigUtil", "No sample rate found in target range or supported by audio source. Falling back to default sample rate of 44100Hz");
                return 44100;
            }
            iIntValue = ((Integer) arrayList.get(i4)).intValue();
            i4++;
        }
    }
}
