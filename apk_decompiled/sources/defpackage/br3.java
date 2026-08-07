package defpackage;

import android.location.GnssNavigationMessage;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
class br3 extends Handler {
    final /* synthetic */ ar3 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    br3(ar3 ar3Var, Looper looper) {
        super(looper);
        this.a = ar3Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            Bundle data = message.getData();
            try {
                Location location = (Location) data.getParcelable("loc");
                data.getInt("satnum");
                if (location != null) {
                    pp3.a().d(location);
                    return;
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (i == 2) {
            zq3.e(uq3.g(), jq3.c().v(), uq3.h(), uq3.a());
            return;
        }
        if (i == 3) {
            zq3.e(uq3.g(), null, uq3.h(), ro3.b().l());
            return;
        }
        if (i == 4) {
            boolean zQ = jq3.c().q();
            if (fq3.r()) {
                zQ = false;
            }
            if (zQ) {
                dq3.c().l();
            }
            try {
                if (this.a.b != null) {
                    this.a.b.sendEmptyMessageDelayed(4, fq3.u);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            yq3.a().c();
            return;
        }
        if (i == 7) {
            zq3.c().n();
            return;
        }
        if (i == 8 || i == 9) {
            message.getData();
            return;
        }
        if (i != 11) {
            return;
        }
        Bundle data2 = message.getData();
        try {
            yq3.a().b((GnssNavigationMessage) data2.getParcelable("gnss_navigation_message"), data2.getLong("gps_time"));
        } catch (Exception unused) {
        }
    }
}
