package defpackage;

import android.location.Location;
import androidx.camera.core.v;
import androidx.camera.core.x;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public final class bj0 {
    private static final String c = "bj0";
    private static final ThreadLocal d = new a();
    private static final ThreadLocal e = new b();
    private static final ThreadLocal f = new c();
    private static final List g = n();
    private static final List h = Arrays.asList("ImageWidth", "ImageLength", "PixelXDimension", "PixelYDimension", "Compression", "JPEGInterchangeFormat", "JPEGInterchangeFormatLength", "ThumbnailImageLength", "ThumbnailImageWidth", "ThumbnailOrientation");
    private final dj0 a;
    private boolean b = false;

    class a extends ThreadLocal {
        a() {
        }

        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy:MM:dd", Locale.US);
        }
    }

    class b extends ThreadLocal {
        b() {
        }

        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss", Locale.US);
        }
    }

    class c extends ThreadLocal {
        c() {
        }

        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
        }
    }

    private static final class d {

        static final class a {
            final double a;

            a(double d) {
                this.a = d;
            }

            double a() {
                return this.a / 2.23694d;
            }
        }

        static a a(double d) {
            return new a(d * 0.621371d);
        }

        static a b(double d) {
            return new a(d * 1.15078d);
        }

        static a c(double d) {
            return new a(d);
        }
    }

    private bj0(dj0 dj0Var) {
        this.a = dj0Var;
    }

    private void a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strF = f(jCurrentTimeMillis);
        this.a.g0("DateTime", strF);
        try {
            this.a.g0("SubSecTime", Long.toString(jCurrentTimeMillis - d(strF).getTime()));
        } catch (ParseException unused) {
        }
    }

    private static Date c(String str) {
        return ((SimpleDateFormat) d.get()).parse(str);
    }

    private static Date d(String str) {
        return ((SimpleDateFormat) f.get()).parse(str);
    }

    private static Date e(String str) {
        return ((SimpleDateFormat) e.get()).parse(str);
    }

    private static String f(long j) {
        return ((SimpleDateFormat) f.get()).format(new Date(j));
    }

    public static bj0 h(File file) {
        return i(file.toString());
    }

    public static bj0 i(String str) {
        return new bj0(new dj0(str));
    }

    public static bj0 j(v vVar) {
        ByteBuffer byteBufferB = vVar.r()[0].b();
        byteBufferB.rewind();
        byte[] bArr = new byte[byteBufferB.capacity()];
        byteBufferB.get(bArr);
        return k(new ByteArrayInputStream(bArr));
    }

    public static bj0 k(InputStream inputStream) {
        return new bj0(new dj0(inputStream));
    }

    public static List n() {
        return Arrays.asList("ImageWidth", "ImageLength", "BitsPerSample", "Compression", "PhotometricInterpretation", "Orientation", "SamplesPerPixel", "PlanarConfiguration", "YCbCrSubSampling", "YCbCrPositioning", "XResolution", "YResolution", "ResolutionUnit", "StripOffsets", "RowsPerStrip", "StripByteCounts", "JPEGInterchangeFormat", "JPEGInterchangeFormatLength", "TransferFunction", "WhitePoint", "PrimaryChromaticities", "YCbCrCoefficients", "ReferenceBlackWhite", "DateTime", "ImageDescription", "Make", "Model", "Software", "Artist", "Copyright", "ExifVersion", "FlashpixVersion", "ColorSpace", "Gamma", "PixelXDimension", "PixelYDimension", "ComponentsConfiguration", "CompressedBitsPerPixel", "MakerNote", "UserComment", "RelatedSoundFile", "DateTimeOriginal", "DateTimeDigitized", "OffsetTime", "OffsetTimeOriginal", "OffsetTimeDigitized", "SubSecTime", "SubSecTimeOriginal", "SubSecTimeDigitized", "ExposureTime", "FNumber", "ExposureProgram", "SpectralSensitivity", "PhotographicSensitivity", "OECF", "SensitivityType", "StandardOutputSensitivity", "RecommendedExposureIndex", "ISOSpeed", "ISOSpeedLatitudeyyy", "ISOSpeedLatitudezzz", "ShutterSpeedValue", "ApertureValue", "BrightnessValue", "ExposureBiasValue", "MaxApertureValue", "SubjectDistance", "MeteringMode", "LightSource", "Flash", "SubjectArea", "FocalLength", "FlashEnergy", "SpatialFrequencyResponse", "FocalPlaneXResolution", "FocalPlaneYResolution", "FocalPlaneResolutionUnit", "SubjectLocation", "ExposureIndex", "SensingMethod", "FileSource", "SceneType", "CFAPattern", "CustomRendered", "ExposureMode", "WhiteBalance", "DigitalZoomRatio", "FocalLengthIn35mmFilm", "SceneCaptureType", "GainControl", "Contrast", "Saturation", "Sharpness", "DeviceSettingDescription", "SubjectDistanceRange", "ImageUniqueID", "CameraOwnerName", "BodySerialNumber", "LensSpecification", "LensMake", "LensModel", "LensSerialNumber", "GPSVersionID", "GPSLatitudeRef", "GPSLatitude", "GPSLongitudeRef", "GPSLongitude", "GPSAltitudeRef", "GPSAltitude", "GPSTimeStamp", "GPSSatellites", "GPSStatus", "GPSMeasureMode", "GPSDOP", "GPSSpeedRef", "GPSSpeed", "GPSTrackRef", "GPSTrack", "GPSImgDirectionRef", "GPSImgDirection", "GPSMapDatum", "GPSDestLatitudeRef", "GPSDestLatitude", "GPSDestLongitudeRef", "GPSDestLongitude", "GPSDestBearingRef", "GPSDestBearing", "GPSDestDistanceRef", "GPSDestDistance", "GPSProcessingMethod", "GPSAreaInformation", "GPSDateStamp", "GPSDifferential", "GPSHPositioningError", "InteroperabilityIndex", "ThumbnailImageLength", "ThumbnailImageWidth", "ThumbnailOrientation", "DNGVersion", "DefaultCropSize", "ThumbnailImage", "PreviewImageStart", "PreviewImageLength", "AspectFrame", "SensorBottomBorder", "SensorLeftBorder", "SensorRightBorder", "SensorTopBorder", "ISO", "JpgFromRaw", "Xmp", "NewSubfileType", "SubfileType");
    }

    private long x(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return d(str).getTime();
        } catch (ParseException unused) {
            return -1L;
        }
    }

    private long y(String str, String str2) {
        if (str == null && str2 == null) {
            return -1L;
        }
        if (str2 == null) {
            try {
                return c(str).getTime();
            } catch (ParseException unused) {
                return -1L;
            }
        }
        if (str == null) {
            try {
                return e(str2).getTime();
            } catch (ParseException unused2) {
                return -1L;
            }
        }
        return x(str + " " + str2);
    }

    public void A() throws Throwable {
        if (!this.b) {
            a();
        }
        this.a.b0();
    }

    public void b(Location location) {
        this.a.h0(location);
    }

    public void g(bj0 bj0Var) {
        ArrayList<String> arrayList = new ArrayList(g);
        arrayList.removeAll(h);
        for (String str : arrayList) {
            String strM = this.a.m(str);
            String strM2 = bj0Var.a.m(str);
            if (strM != null && !strM.equals(strM2)) {
                bj0Var.a.g0(str, strM);
            }
        }
    }

    public void l() {
        int i;
        switch (r()) {
            case 2:
                i = 1;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 3;
                break;
            case 5:
                i = 6;
                break;
            case 6:
                i = 5;
                break;
            case 7:
                i = 8;
                break;
            case 8:
                i = 7;
                break;
            default:
                i = 2;
                break;
        }
        this.a.g0("Orientation", String.valueOf(i));
    }

    public void m() {
        int i;
        switch (r()) {
            case 2:
                i = 3;
                break;
            case 3:
                i = 2;
                break;
            case 4:
                i = 1;
                break;
            case 5:
                i = 8;
                break;
            case 6:
                i = 7;
                break;
            case 7:
                i = 6;
                break;
            case 8:
                i = 5;
                break;
            default:
                i = 4;
                break;
        }
        this.a.g0("Orientation", String.valueOf(i));
    }

    public String o() {
        return this.a.m("ImageDescription");
    }

    public int p() {
        return this.a.o("ImageLength", 0);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0092  */
    public Location q() {
        byte b2;
        double dA;
        String strM = this.a.m("GPSProcessingMethod");
        double[] dArrS = this.a.s();
        double dL = this.a.l(0.0d);
        double dN = this.a.n("GPSSpeed", 0.0d);
        String strM2 = this.a.m("GPSSpeedRef");
        if (strM2 == null) {
            strM2 = "K";
        }
        long jY = y(this.a.m("GPSDateStamp"), this.a.m("GPSTimeStamp"));
        if (dArrS == null) {
            return null;
        }
        if (strM == null) {
            strM = c;
        }
        Location location = new Location(strM);
        location.setLatitude(dArrS[0]);
        location.setLongitude(dArrS[1]);
        if (dL != 0.0d) {
            location.setAltitude(dL);
        }
        if (dN != 0.0d) {
            int iHashCode = strM2.hashCode();
            if (iHashCode != 75) {
                if (iHashCode != 77) {
                    if (iHashCode == 78 && strM2.equals("N")) {
                        b2 = 1;
                    } else {
                        b2 = -1;
                    }
                } else if (strM2.equals("M")) {
                    b2 = 0;
                } else {
                    b2 = -1;
                }
            } else if (strM2.equals("K")) {
                b2 = 2;
            } else {
                b2 = -1;
            }
            if (b2 != 0) {
                dA = b2 != 1 ? d.a(dN).a() : d.b(dN).a();
            } else {
                dA = d.c(dN).a();
            }
            location.setSpeed((float) dA);
        }
        if (jY != -1) {
            location.setTime(jY);
        }
        return location;
    }

    public int r() {
        return this.a.o("Orientation", 0);
    }

    public int s() {
        switch (r()) {
            case 3:
            case 4:
                return Opcodes.GETFIELD;
            case 5:
                return 270;
            case 6:
            case 7:
                return 90;
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public long t() {
        long jX = x(this.a.m("DateTimeOriginal"));
        if (jX == -1) {
            return -1L;
        }
        String strM = this.a.m("SubSecTimeOriginal");
        if (strM == null) {
            return jX;
        }
        try {
            long j = Long.parseLong(strM);
            while (j > 1000) {
                j /= 10;
            }
            return jX + j;
        } catch (NumberFormatException unused) {
            return jX;
        }
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "Exif{width=%s, height=%s, rotation=%d, isFlippedVertically=%s, isFlippedHorizontally=%s, location=%s, timestamp=%s, description=%s}", Integer.valueOf(u()), Integer.valueOf(p()), Integer.valueOf(s()), Boolean.valueOf(w()), Boolean.valueOf(v()), q(), Long.valueOf(t()), o());
    }

    public int u() {
        return this.a.o("ImageWidth", 0);
    }

    public boolean v() {
        return r() == 2;
    }

    public boolean w() {
        int iR = r();
        return iR == 4 || iR == 5 || iR == 7;
    }

    public void z(int i) {
        if (i % 90 != 0) {
            x.k(c, String.format(Locale.US, "Can only rotate in right angles (eg. 0, 90, 180, 270). %d is unsupported.", Integer.valueOf(i)));
            this.a.g0("Orientation", String.valueOf(0));
            return;
        }
        int i2 = i % 360;
        int iR = r();
        while (i2 < 0) {
            i2 += 90;
            switch (iR) {
                case 2:
                    iR = 5;
                    break;
                case 3:
                case 8:
                    iR = 6;
                    break;
                case 4:
                    iR = 7;
                    break;
                case 5:
                    iR = 4;
                    break;
                case 6:
                    iR = 1;
                    break;
                case 7:
                    iR = 2;
                    break;
                default:
                    iR = 8;
                    break;
            }
        }
        while (i2 > 0) {
            i2 -= 90;
            switch (iR) {
                case 2:
                    iR = 7;
                    break;
                case 3:
                    iR = 8;
                    break;
                case 4:
                    iR = 5;
                    break;
                case 5:
                    iR = 2;
                    break;
                case 6:
                    iR = 3;
                    break;
                case 7:
                    iR = 4;
                    break;
                case 8:
                    iR = 1;
                    break;
                default:
                    iR = 6;
                    break;
            }
        }
        this.a.g0("Orientation", String.valueOf(iR));
    }
}
