package defpackage;

import android.location.GnssNavigationMessage;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public class ar3 {
    private static Object d = new Object();
    private static ar3 e;
    private HandlerThread a;
    private Handler b;
    private boolean c = false;

    ar3() {
    }

    public static ar3 b() {
        ar3 ar3Var;
        synchronized (d) {
            try {
                if (e == null) {
                    e = new ar3();
                }
                ar3Var = e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return ar3Var;
    }

    public void c(GnssNavigationMessage gnssNavigationMessage, long j) {
        if (!this.c || gnssNavigationMessage == null) {
            return;
        }
        try {
            Handler handler = this.b;
            if (handler != null) {
                Message messageObtainMessage = handler.obtainMessage(11);
                Bundle bundle = new Bundle();
                bundle.putParcelable("gnss_navigation_message", gnssNavigationMessage);
                bundle.putLong("gps_time", j);
                messageObtainMessage.setData(bundle);
                messageObtainMessage.sendToTarget();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void d(Location location, int i) {
        if (!this.c || location == null) {
            return;
        }
        try {
            Handler handler = this.b;
            if (handler != null) {
                Message messageObtainMessage = handler.obtainMessage(1);
                Bundle bundle = new Bundle();
                bundle.putParcelable("loc", new Location(location));
                bundle.putInt("satnum", i);
                messageObtainMessage.setData(bundle);
                messageObtainMessage.sendToTarget();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void e() {
        if (this.c) {
            try {
                Handler handler = this.b;
                if (handler != null) {
                    handler.obtainMessage(3).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void f() {
        if (this.c) {
            try {
                Handler handler = this.b;
                if (handler != null) {
                    handler.obtainMessage(2).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void g() {
        if (this.c) {
            try {
                Handler handler = this.b;
                if (handler != null) {
                    handler.obtainMessage(7).sendToTarget();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void h() {
        if (this.c) {
            return;
        }
        this.c = true;
        if (this.a == null) {
            HandlerThread handlerThread = new HandlerThread("LocUploadThreadManager");
            this.a = handlerThread;
            handlerThread.start();
            if (this.a != null) {
                this.b = new br3(this, this.a.getLooper());
            }
        }
        try {
            Handler handler = this.b;
            if (handler != null) {
                handler.obtainMessage(5).sendToTarget();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            Handler handler2 = this.b;
            if (handler2 != null) {
                handler2.sendEmptyMessageDelayed(4, fq3.u);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void i() {
        if (this.c) {
            pp3.a().k();
            try {
                Handler handler = this.b;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.b = null;
            try {
                HandlerThread handlerThread = this.a;
                if (handlerThread != null) {
                    handlerThread.quit();
                    this.a.interrupt();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.a = null;
            this.c = false;
        }
    }
}
