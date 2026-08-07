package defpackage;

import com.baji.protocol.model.DeviceInfo;
import java.util.List;
import kotlin.collections.j;

/* JADX INFO: loaded from: classes4.dex */
public final class w82 {
    private final boolean a;
    private final String b;
    private final List c;
    private final DeviceInfo d;
    private final List e;
    private final boolean f;
    private final String g;

    public w82(boolean z, String str, List list, DeviceInfo deviceInfo, List list2, boolean z2, String str2) {
        p31.f(list, "protocolLogs");
        p31.f(list2, "mediaList");
        this.a = z;
        this.b = str;
        this.c = list;
        this.d = deviceInfo;
        this.e = list2;
        this.f = z2;
        this.g = str2;
    }

    public static /* synthetic */ w82 b(w82 w82Var, boolean z, String str, List list, DeviceInfo deviceInfo, List list2, boolean z2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = w82Var.a;
        }
        if ((i & 2) != 0) {
            str = w82Var.b;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            list = w82Var.c;
        }
        List list3 = list;
        if ((i & 8) != 0) {
            deviceInfo = w82Var.d;
        }
        DeviceInfo deviceInfo2 = deviceInfo;
        if ((i & 16) != 0) {
            list2 = w82Var.e;
        }
        List list4 = list2;
        if ((i & 32) != 0) {
            z2 = w82Var.f;
        }
        boolean z3 = z2;
        if ((i & 64) != 0) {
            str2 = w82Var.g;
        }
        return w82Var.a(z, str3, list3, deviceInfo2, list4, z3, str2);
    }

    public final w82 a(boolean z, String str, List list, DeviceInfo deviceInfo, List list2, boolean z2, String str2) {
        p31.f(list, "protocolLogs");
        p31.f(list2, "mediaList");
        return new w82(z, str, list, deviceInfo, list2, z2, str2);
    }

    public final String c() {
        return this.g;
    }

    public final List d() {
        return this.c;
    }

    public final boolean e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w82)) {
            return false;
        }
        w82 w82Var = (w82) obj;
        return this.a == w82Var.a && p31.a(this.b, w82Var.b) && p31.a(this.c, w82Var.c) && p31.a(this.d, w82Var.d) && p31.a(this.e, w82Var.e) && this.f == w82Var.f && p31.a(this.g, w82Var.g);
    }

    public final boolean f() {
        return this.f;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.a) * 31;
        String str = this.b;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.c.hashCode()) * 31;
        DeviceInfo deviceInfo = this.d;
        int iHashCode3 = (((((iHashCode2 + (deviceInfo == null ? 0 : deviceInfo.hashCode())) * 31) + this.e.hashCode()) * 31) + Boolean.hashCode(this.f)) * 31;
        String str2 = this.g;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ProtocolDebugUiState(isConnected=" + this.a + ", deviceName=" + this.b + ", protocolLogs=" + this.c + ", deviceInfo=" + this.d + ", mediaList=" + this.e + ", isLoading=" + this.f + ", errorMessage=" + this.g + ")";
    }

    public /* synthetic */ w82(boolean z, String str, List list, DeviceInfo deviceInfo, List list2, boolean z2, String str2, int i, y70 y70Var) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? j.j() : list, (i & 8) != 0 ? null : deviceInfo, (i & 16) != 0 ? j.j() : list2, (i & 32) == 0 ? z2 : false, (i & 64) != 0 ? null : str2);
    }
}
