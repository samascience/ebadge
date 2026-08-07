package androidx.camera.core.impl.utils;

import com.baji.protocol.model.ProtocolConstants;
import com.jieli.jl_rcsp.constant.WatchConstant;

/* JADX INFO: loaded from: classes.dex */
final class e {
    private final long a;
    private final long b;

    e(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    long a() {
        return this.b;
    }

    long b() {
        return this.a;
    }

    public String toString() {
        return this.a + WatchConstant.FAT_FS_ROOT + this.b;
    }

    e(double d) {
        this((long) (d * 10000.0d), ProtocolConstants.CONNECTION_TIMEOUT_MS);
    }
}
