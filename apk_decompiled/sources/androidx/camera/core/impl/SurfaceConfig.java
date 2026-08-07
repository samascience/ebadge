package androidx.camera.core.impl;

import android.util.Size;
import defpackage.dy2;
import defpackage.ir2;

/* JADX INFO: loaded from: classes.dex */
public abstract class SurfaceConfig {

    public enum ConfigSize {
        VGA(0),
        s720p(1),
        PREVIEW(2),
        s1440p(3),
        RECORD(4),
        MAXIMUM(5),
        ULTRA_MAXIMUM(6),
        NOT_SUPPORT(7);

        final int mId;

        ConfigSize(int i) {
            this.mId = i;
        }

        int getId() {
            return this.mId;
        }
    }

    public enum ConfigType {
        PRIV,
        YUV,
        JPEG,
        JPEG_R,
        RAW
    }

    SurfaceConfig() {
    }

    public static SurfaceConfig a(ConfigType configType, ConfigSize configSize) {
        return new f(configType, configSize, 0L);
    }

    public static SurfaceConfig b(ConfigType configType, ConfigSize configSize, long j) {
        return new f(configType, configSize, j);
    }

    public static ConfigType e(int i) {
        if (i == 35) {
            return ConfigType.YUV;
        }
        if (i == 256) {
            return ConfigType.JPEG;
        }
        if (i == 4101) {
            return ConfigType.JPEG_R;
        }
        return i == 32 ? ConfigType.RAW : ConfigType.PRIV;
    }

    public static SurfaceConfig h(int i, int i2, Size size, dy2 dy2Var) {
        ConfigType configTypeE = e(i2);
        ConfigSize configSize = ConfigSize.NOT_SUPPORT;
        int iC = ir2.c(size);
        if (i == 1) {
            if (iC <= ir2.c(dy2Var.i(i2))) {
                configSize = ConfigSize.s720p;
            } else if (iC <= ir2.c(dy2Var.g(i2))) {
                configSize = ConfigSize.s1440p;
            }
        } else if (iC <= ir2.c(dy2Var.b())) {
            configSize = ConfigSize.VGA;
        } else if (iC <= ir2.c(dy2Var.e())) {
            configSize = ConfigSize.PREVIEW;
        } else if (iC <= ir2.c(dy2Var.f())) {
            configSize = ConfigSize.RECORD;
        } else if (iC <= ir2.c(dy2Var.c(i2))) {
            configSize = ConfigSize.MAXIMUM;
        } else {
            Size sizeK = dy2Var.k(i2);
            if (sizeK != null && iC <= ir2.c(sizeK)) {
                configSize = ConfigSize.ULTRA_MAXIMUM;
            }
        }
        return a(configTypeE, configSize);
    }

    public abstract ConfigSize c();

    public abstract ConfigType d();

    public abstract long f();

    public final boolean g(SurfaceConfig surfaceConfig) {
        return surfaceConfig.c().getId() <= c().getId() && surfaceConfig.d() == d();
    }
}
