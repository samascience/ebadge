package androidx.camera.core.impl.utils;

import android.os.Build;
import android.util.Pair;
import androidx.camera.core.impl.CameraCaptureMetaData$FlashState;
import androidx.camera.core.v;
import androidx.camera.core.x;
import cn.bertsir.zbar.Qr.Config;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.tencent.connect.common.Constants;
import defpackage.b52;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: loaded from: classes.dex */
public class ExifData {
    static final String[] c = {Constants.STR_EMPTY, "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    private static final d[] d;
    private static final d[] e;
    private static final d[] f;
    static final d[] g;
    private static final d[] h;
    static final d[][] i;
    static final HashSet j;
    private final List a;
    private final ByteOrder b;

    public enum WhiteBalanceMode {
        AUTO,
        MANUAL
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CameraCaptureMetaData$FlashState.values().length];
            a = iArr;
            try {
                iArr[CameraCaptureMetaData$FlashState.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CameraCaptureMetaData$FlashState.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CameraCaptureMetaData$FlashState.FIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final class b {
        private static final Pattern c = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
        private static final Pattern d = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
        private static final Pattern e = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
        static final List f = Collections.list(new a());
        final List a = Collections.list(new C0007b());
        private final ByteOrder b;

        class a implements Enumeration {
            int a = 0;

            a() {
            }

            @Override // java.util.Enumeration
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public HashMap nextElement() {
                HashMap map = new HashMap();
                for (d dVar : ExifData.i[this.a]) {
                    map.put(dVar.b, dVar);
                }
                this.a++;
                return map;
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.a < ExifData.i.length;
            }
        }

        /* JADX INFO: renamed from: androidx.camera.core.impl.utils.ExifData$b$b, reason: collision with other inner class name */
        class C0007b implements Enumeration {
            int a = 0;

            C0007b() {
            }

            @Override // java.util.Enumeration
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map nextElement() {
                this.a++;
                return new HashMap();
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.a < ExifData.i.length;
            }
        }

        class c implements Enumeration {
            final Enumeration a;

            c() {
                this.a = Collections.enumeration(b.this.a);
            }

            @Override // java.util.Enumeration
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map nextElement() {
                return new HashMap((Map) this.a.nextElement());
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.a.hasMoreElements();
            }
        }

        b(ByteOrder byteOrder) {
            this.b = byteOrder;
        }

        private static Pair b(String str) {
            if (str.contains(",")) {
                String[] strArrSplit = str.split(",", -1);
                Pair pairB = b(strArrSplit[0]);
                if (((Integer) pairB.first).intValue() == 2) {
                    return pairB;
                }
                for (int i = 1; i < strArrSplit.length; i++) {
                    Pair pairB2 = b(strArrSplit[i]);
                    int iIntValue = (((Integer) pairB2.first).equals(pairB.first) || ((Integer) pairB2.second).equals(pairB.first)) ? ((Integer) pairB.first).intValue() : -1;
                    int iIntValue2 = (((Integer) pairB.second).intValue() == -1 || !(((Integer) pairB2.first).equals(pairB.second) || ((Integer) pairB2.second).equals(pairB.second))) ? -1 : ((Integer) pairB.second).intValue();
                    if (iIntValue == -1 && iIntValue2 == -1) {
                        return new Pair(2, -1);
                    }
                    if (iIntValue == -1) {
                        pairB = new Pair(Integer.valueOf(iIntValue2), -1);
                    } else if (iIntValue2 == -1) {
                        pairB = new Pair(Integer.valueOf(iIntValue), -1);
                    }
                }
                return pairB;
            }
            if (!str.contains(WatchConstant.FAT_FS_ROOT)) {
                try {
                    try {
                        long j = Long.parseLong(str);
                        if (j < 0 || j > 65535) {
                            return j < 0 ? new Pair(9, -1) : new Pair(4, -1);
                        }
                        return new Pair(3, 4);
                    } catch (NumberFormatException unused) {
                        return new Pair(2, -1);
                    }
                } catch (NumberFormatException unused2) {
                    Double.parseDouble(str);
                    return new Pair(12, -1);
                }
            }
            String[] strArrSplit2 = str.split(WatchConstant.FAT_FS_ROOT, -1);
            if (strArrSplit2.length == 2) {
                try {
                    long j2 = (long) Double.parseDouble(strArrSplit2[0]);
                    long j3 = (long) Double.parseDouble(strArrSplit2[1]);
                    if (j2 >= 0 && j3 >= 0) {
                        if (j2 <= 2147483647L && j3 <= 2147483647L) {
                            return new Pair(10, 5);
                        }
                        return new Pair(5, -1);
                    }
                    return new Pair(10, -1);
                } catch (NumberFormatException unused3) {
                }
            }
            return new Pair(2, -1);
        }

        private void d(String str, String str2, List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((Map) it.next()).containsKey(str)) {
                    return;
                }
            }
            e(str, str2, list);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private void e(String str, String str2, List list) {
            int i;
            int i2;
            int i3;
            b bVar = this;
            String str3 = str;
            String strReplaceAll = str2;
            if (("DateTime".equals(str3) || "DateTimeOriginal".equals(str3) || "DateTimeDigitized".equals(str3)) && strReplaceAll != null) {
                boolean zFind = d.matcher(strReplaceAll).find();
                boolean zFind2 = e.matcher(strReplaceAll).find();
                if (str2.length() != 19 || (!zFind && !zFind2)) {
                    x.k("ExifData", "Invalid value for " + str3 + " : " + strReplaceAll);
                    return;
                }
                if (zFind2) {
                    strReplaceAll = strReplaceAll.replaceAll("-", ":");
                }
            }
            if ("ISOSpeedRatings".equals(str3)) {
                str3 = "PhotographicSensitivity";
            }
            String str4 = str3;
            int i4 = 2;
            int i5 = 1;
            if (strReplaceAll != null && ExifData.j.contains(str4)) {
                if (str4.equals("GPSTimeStamp")) {
                    Matcher matcher = c.matcher(strReplaceAll);
                    if (!matcher.find()) {
                        x.k("ExifData", "Invalid value for " + str4 + " : " + strReplaceAll);
                        return;
                    }
                    strReplaceAll = Integer.parseInt((String) b52.g(matcher.group(1))) + "/1," + Integer.parseInt((String) b52.g(matcher.group(2))) + "/1," + Integer.parseInt((String) b52.g(matcher.group(3))) + "/1";
                } else {
                    try {
                        strReplaceAll = new e(Double.parseDouble(strReplaceAll)).toString();
                    } catch (NumberFormatException e2) {
                        x.l("ExifData", "Invalid value for " + str4 + " : " + strReplaceAll, e2);
                        return;
                    }
                }
            }
            int i6 = 0;
            int i7 = 0;
            while (i7 < ExifData.i.length) {
                d dVar = (d) ((HashMap) f.get(i7)).get(str4);
                if (dVar == null) {
                    i = i7;
                    i2 = i5;
                } else {
                    if (strReplaceAll != null) {
                        Pair pairB = b(strReplaceAll);
                        if (dVar.c == ((Integer) pairB.first).intValue() || dVar.c == ((Integer) pairB.second).intValue()) {
                            i3 = dVar.c;
                        } else {
                            int i8 = dVar.d;
                            if (i8 == -1 || !(i8 == ((Integer) pairB.first).intValue() || dVar.d == ((Integer) pairB.second).intValue())) {
                                i3 = dVar.c;
                                if (i3 == i5 || i3 == 7 || i3 == i4) {
                                }
                            } else {
                                i3 = dVar.d;
                            }
                        }
                        String str5 = WatchConstant.FAT_FS_ROOT;
                        switch (i3) {
                            case 1:
                                i = i7;
                                i2 = i5;
                                ((Map) list.get(i)).put(str4, androidx.camera.core.impl.utils.b.a(strReplaceAll));
                                break;
                            case 2:
                            case 7:
                                i = i7;
                                i2 = i5;
                                ((Map) list.get(i)).put(str4, androidx.camera.core.impl.utils.b.e(strReplaceAll));
                                break;
                            case 3:
                                i = i7;
                                i2 = i5;
                                String[] strArrSplit = strReplaceAll.split(",", -1);
                                int[] iArr = new int[strArrSplit.length];
                                for (int i9 = 0; i9 < strArrSplit.length; i9++) {
                                    iArr[i9] = Integer.parseInt(strArrSplit[i9]);
                                }
                                ((Map) list.get(i)).put(str4, androidx.camera.core.impl.utils.b.i(iArr, bVar.b));
                                break;
                            case 4:
                                i = i7;
                                i2 = i5;
                                String[] strArrSplit2 = strReplaceAll.split(",", -1);
                                long[] jArr = new long[strArrSplit2.length];
                                for (int i10 = 0; i10 < strArrSplit2.length; i10++) {
                                    jArr[i10] = Long.parseLong(strArrSplit2[i10]);
                                }
                                ((Map) list.get(i)).put(str4, androidx.camera.core.impl.utils.b.g(jArr, bVar.b));
                                break;
                            case 5:
                                String str6 = WatchConstant.FAT_FS_ROOT;
                                String[] strArrSplit3 = strReplaceAll.split(",", -1);
                                e[] eVarArr = new e[strArrSplit3.length];
                                int i11 = i6;
                                while (i11 < strArrSplit3.length) {
                                    String str7 = str6;
                                    String[] strArrSplit4 = strArrSplit3[i11].split(str7, -1);
                                    eVarArr[i11] = new e((long) Double.parseDouble(strArrSplit4[i6]), (long) Double.parseDouble(strArrSplit4[1]));
                                    i11++;
                                    str6 = str7;
                                    i7 = i7;
                                    i6 = 0;
                                }
                                i = i7;
                                i2 = 1;
                                ((Map) list.get(i)).put(str4, androidx.camera.core.impl.utils.b.h(eVarArr, bVar.b));
                                break;
                            case 9:
                                String[] strArrSplit5 = strReplaceAll.split(",", -1);
                                int[] iArr2 = new int[strArrSplit5.length];
                                for (int i12 = i6; i12 < strArrSplit5.length; i12++) {
                                    iArr2[i12] = Integer.parseInt(strArrSplit5[i12]);
                                }
                                ((Map) list.get(i7)).put(str4, androidx.camera.core.impl.utils.b.c(iArr2, bVar.b));
                                i = i7;
                                i2 = 1;
                                break;
                            case 10:
                                String[] strArrSplit6 = strReplaceAll.split(",", -1);
                                e[] eVarArr2 = new e[strArrSplit6.length];
                                int i13 = i6;
                                while (i13 < strArrSplit6.length) {
                                    String[] strArrSplit7 = strArrSplit6[i13].split(str5, -1);
                                    eVarArr2[i13] = new e((long) Double.parseDouble(strArrSplit7[i6]), (long) Double.parseDouble(strArrSplit7[i5]));
                                    i13++;
                                    str5 = str5;
                                    i5 = 1;
                                }
                                bVar = this;
                                ((Map) list.get(i7)).put(str4, androidx.camera.core.impl.utils.b.d(eVarArr2, bVar.b));
                                i = i7;
                                i2 = 1;
                                break;
                            case 12:
                                String[] strArrSplit8 = strReplaceAll.split(",", -1);
                                double[] dArr = new double[strArrSplit8.length];
                                for (int i14 = i6; i14 < strArrSplit8.length; i14++) {
                                    dArr[i14] = Double.parseDouble(strArrSplit8[i14]);
                                }
                                ((Map) list.get(i7)).put(str4, androidx.camera.core.impl.utils.b.b(dArr, bVar.b));
                                break;
                        }
                    } else {
                        ((Map) list.get(i7)).remove(str4);
                    }
                    i = i7;
                    i2 = i5;
                }
                i7 = i + 1;
                i5 = i2;
                i4 = 2;
                i6 = 0;
            }
        }

        public ExifData a() {
            ArrayList list = Collections.list(new c());
            if (!((Map) list.get(1)).isEmpty()) {
                d("ExposureProgram", String.valueOf(0), list);
                d("ExifVersion", "0230", list);
                d("ComponentsConfiguration", "1,2,3,0", list);
                d("MeteringMode", String.valueOf(0), list);
                d("LightSource", String.valueOf(0), list);
                d("FlashpixVersion", "0100", list);
                d("FocalPlaneResolutionUnit", String.valueOf(2), list);
                d("FileSource", String.valueOf(3), list);
                d("SceneType", String.valueOf(1), list);
                d("CustomRendered", String.valueOf(0), list);
                d("SceneCaptureType", String.valueOf(0), list);
                d("Contrast", String.valueOf(0), list);
                d("Saturation", String.valueOf(0), list);
                d("Sharpness", String.valueOf(0), list);
            }
            if (!((Map) list.get(2)).isEmpty()) {
                d("GPSVersionID", "2300", list);
                d("GPSSpeedRef", "K", list);
                d("GPSTrackRef", "T", list);
                d("GPSImgDirectionRef", "T", list);
                d("GPSDestBearingRef", "T", list);
                d("GPSDestDistanceRef", "K", list);
            }
            return new ExifData(this.b, list);
        }

        public b c(String str, String str2) {
            e(str, str2, this.a);
            return this;
        }

        public b f(long j) {
            return c("ExposureTime", String.valueOf(j / TimeUnit.SECONDS.toNanos(1L)));
        }

        public b g(CameraCaptureMetaData$FlashState cameraCaptureMetaData$FlashState) {
            int i;
            if (cameraCaptureMetaData$FlashState == CameraCaptureMetaData$FlashState.UNKNOWN) {
                return this;
            }
            int i2 = a.a[cameraCaptureMetaData$FlashState.ordinal()];
            if (i2 == 1) {
                i = 0;
            } else if (i2 == 2) {
                i = 32;
            } else {
                if (i2 != 3) {
                    x.k("ExifData", "Unknown flash state: " + cameraCaptureMetaData$FlashState);
                    return this;
                }
                i = 1;
            }
            if ((i & 1) == 1) {
                c("LightSource", String.valueOf(4));
            }
            return c("Flash", String.valueOf(i));
        }

        public b h(float f2) {
            return c("FocalLength", new e((long) (f2 * 1000.0f), 1000L).toString());
        }

        public b i(int i) {
            return c("ImageLength", String.valueOf(i));
        }

        public b j(int i) {
            return c("ImageWidth", String.valueOf(i));
        }

        public b k(int i) {
            return c("SensitivityType", String.valueOf(3)).c("PhotographicSensitivity", String.valueOf(Math.min(65535, i)));
        }

        public b l(float f2) {
            return c("FNumber", String.valueOf(f2));
        }

        public b m(int i) {
            int i2;
            if (i == 0) {
                i2 = 1;
            } else if (i == 90) {
                i2 = 6;
            } else if (i == 180) {
                i2 = 3;
            } else if (i != 270) {
                x.k("ExifData", "Unexpected orientation value: " + i + ". Must be one of 0, 90, 180, 270.");
                i2 = 0;
            } else {
                i2 = 8;
            }
            return c("Orientation", String.valueOf(i2));
        }

        public b n(WhiteBalanceMode whiteBalanceMode) {
            String strValueOf;
            int iOrdinal = whiteBalanceMode.ordinal();
            if (iOrdinal != 0) {
                strValueOf = iOrdinal != 1 ? null : String.valueOf(1);
            } else {
                strValueOf = String.valueOf(0);
            }
            return c("WhiteBalance", strValueOf);
        }
    }

    static {
        d[] dVarArr = {new d("ImageWidth", 256, 3, 4), new d("ImageLength", Config.Y_DENSITY, 3, 4), new d("Make", 271, 2), new d("Model", 272, 2), new d("Orientation", 274, 3), new d("XResolution", 282, 5), new d("YResolution", DfuBaseService.NOTIFICATION_ID, 5), new d("ResolutionUnit", 296, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("YCbCrPositioning", 531, 3), new d("SubIFDPointer", 330, 4), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4)};
        d = dVarArr;
        d[] dVarArr2 = {new d("ExposureTime", 33434, 5), new d("FNumber", 33437, 5), new d("ExposureProgram", 34850, 3), new d("PhotographicSensitivity", 34855, 3), new d("SensitivityType", 34864, 3), new d("ExifVersion", 36864, 2), new d("DateTimeOriginal", 36867, 2), new d("DateTimeDigitized", 36868, 2), new d("ComponentsConfiguration", 37121, 7), new d("ShutterSpeedValue", 37377, 10), new d("ApertureValue", 37378, 5), new d("BrightnessValue", 37379, 10), new d("ExposureBiasValue", 37380, 10), new d("MaxApertureValue", 37381, 5), new d("MeteringMode", 37383, 3), new d("LightSource", 37384, 3), new d("Flash", 37385, 3), new d("FocalLength", 37386, 5), new d("SubSecTime", 37520, 2), new d("SubSecTimeOriginal", 37521, 2), new d("SubSecTimeDigitized", 37522, 2), new d("FlashpixVersion", 40960, 7), new d("ColorSpace", 40961, 3), new d("PixelXDimension", 40962, 3, 4), new d("PixelYDimension", 40963, 3, 4), new d("InteroperabilityIFDPointer", 40965, 4), new d("FocalPlaneResolutionUnit", 41488, 3), new d("SensingMethod", 41495, 3), new d("FileSource", 41728, 7), new d("SceneType", 41729, 7), new d("CustomRendered", 41985, 3), new d("ExposureMode", 41986, 3), new d("WhiteBalance", 41987, 3), new d("SceneCaptureType", 41990, 3), new d("Contrast", 41992, 3), new d("Saturation", 41993, 3), new d("Sharpness", 41994, 3)};
        e = dVarArr2;
        d[] dVarArr3 = {new d("GPSVersionID", 0, 1), new d("GPSLatitudeRef", 1, 2), new d("GPSLatitude", 2, 5, 10), new d("GPSLongitudeRef", 3, 2), new d("GPSLongitude", 4, 5, 10), new d("GPSAltitudeRef", 5, 1), new d("GPSAltitude", 6, 5), new d("GPSTimeStamp", 7, 5), new d("GPSSpeedRef", 12, 2), new d("GPSTrackRef", 14, 2), new d("GPSImgDirectionRef", 16, 2), new d("GPSDestBearingRef", 23, 2), new d("GPSDestDistanceRef", 25, 2)};
        f = dVarArr3;
        g = new d[]{new d("SubIFDPointer", 330, 4), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("InteroperabilityIFDPointer", 40965, 4)};
        d[] dVarArr4 = {new d("InteroperabilityIndex", 1, 2)};
        h = dVarArr4;
        i = new d[][]{dVarArr, dVarArr2, dVarArr3, dVarArr4};
        j = new HashSet(Arrays.asList("FNumber", "ExposureTime", "GPSTimeStamp"));
    }

    ExifData(ByteOrder byteOrder, List list) {
        b52.j(list.size() == i.length, "Malformed attributes list. Number of IFDs mismatch.");
        this.b = byteOrder;
        this.a = list;
    }

    public static b a() {
        return new b(ByteOrder.BIG_ENDIAN).c("Orientation", String.valueOf(1)).c("XResolution", "72/1").c("YResolution", "72/1").c("ResolutionUnit", String.valueOf(2)).c("YCbCrPositioning", String.valueOf(1)).c("Make", Build.MANUFACTURER).c("Model", Build.MODEL);
    }

    public static ExifData b(v vVar, int i2) {
        b bVarA = a();
        if (vVar.h0() != null) {
            vVar.h0().b(bVarA);
        }
        bVarA.m(i2);
        return bVarA.j(vVar.getWidth()).i(vVar.getHeight()).a();
    }

    Map c(int i2) {
        b52.c(i2, 0, i.length, "Invalid IFD index: " + i2 + ". Index should be between [0, EXIF_TAGS.length] ");
        return (Map) this.a.get(i2);
    }

    public ByteOrder d() {
        return this.b;
    }
}
