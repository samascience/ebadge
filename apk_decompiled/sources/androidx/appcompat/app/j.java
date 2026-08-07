package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import defpackage.xz1;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
class j {
    private static j d;
    private final Context a;
    private final LocationManager b;
    private final a c = new a();

    private static class a {
        boolean a;
        long b;

        a() {
        }
    }

    j(Context context, LocationManager locationManager) {
        this.a = context;
        this.b = locationManager;
    }

    static j a(Context context) {
        if (d == null) {
            Context applicationContext = context.getApplicationContext();
            d = new j(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return d;
    }

    private Location b() {
        Location locationC = xz1.b(this.a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location locationC2 = xz1.b(this.a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        if (locationC2 == null || locationC == null) {
            return locationC2 != null ? locationC2 : locationC;
        }
        return locationC2.getTime() > locationC.getTime() ? locationC2 : locationC;
    }

    private Location c(String str) {
        try {
            if (this.b.isProviderEnabled(str)) {
                return this.b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    private boolean e() {
        return this.c.b > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j;
        a aVar = this.c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        i iVarB = i.b();
        iVarB.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        iVarB.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = iVarB.c == 1;
        long j2 = iVarB.b;
        long j3 = iVarB.a;
        iVarB.a(jCurrentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j4 = iVarB.b;
        if (j2 == -1 || j3 == -1) {
            j = jCurrentTimeMillis + 43200000;
        } else {
            if (jCurrentTimeMillis <= j3) {
                j4 = jCurrentTimeMillis > j2 ? j3 : j2;
            }
            j = j4 + 60000;
        }
        aVar.a = z;
        aVar.b = j;
    }

    boolean d() {
        a aVar = this.c;
        if (e()) {
            return aVar.a;
        }
        Location locationB = b();
        if (locationB != null) {
            f(locationB);
            return aVar.a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
