package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class z extends ng {
    private final List a;

    public z(List list) {
        p31.f(list, "wifiHotspots");
        this.a = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof z) && p31.a(this.a, ((z) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "AIGlassesScannedWifiHotspotsEvent(wifiHotspots=" + this.a + ")";
    }
}
