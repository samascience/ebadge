package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zs {
    private final a b;
    private final String c;
    private final Map a = new HashMap();
    private wu2 d = null;

    public interface a {
        Object a(CameraCharacteristics.Key key);
    }

    private zs(CameraCharacteristics cameraCharacteristics, String str) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.b = new xs(cameraCharacteristics);
        } else {
            this.b = new ys(cameraCharacteristics);
        }
        this.c = str;
    }

    private boolean c(CameraCharacteristics.Key key) {
        return key.equals(CameraCharacteristics.SENSOR_ORIENTATION);
    }

    public static zs d(CameraCharacteristics cameraCharacteristics, String str) {
        return new zs(cameraCharacteristics, str);
    }

    public Object a(CameraCharacteristics.Key key) {
        if (c(key)) {
            return this.b.a(key);
        }
        synchronized (this) {
            try {
                Object obj = this.a.get(key);
                if (obj != null) {
                    return obj;
                }
                Object objA = this.b.a(key);
                if (objA != null) {
                    this.a.put(key, objA);
                }
                return objA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public wu2 b() {
        if (this.d == null) {
            try {
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                if (streamConfigurationMap == null) {
                    throw new IllegalArgumentException("StreamConfigurationMap is null!");
                }
                this.d = wu2.e(streamConfigurationMap, new gy1(this.c));
            } catch (AssertionError e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
        return this.d;
    }
}
