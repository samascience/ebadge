package defpackage;

import android.app.Notification;

/* JADX INFO: loaded from: classes.dex */
public final class cp0 {
    private final int a;
    private final int b;
    private final Notification c;

    public cp0(int i, Notification notification, int i2) {
        this.a = i;
        this.c = notification;
        this.b = i2;
    }

    public int a() {
        return this.b;
    }

    public Notification b() {
        return this.c;
    }

    public int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || cp0.class != obj.getClass()) {
            return false;
        }
        cp0 cp0Var = (cp0) obj;
        if (this.a == cp0Var.a && this.b == cp0Var.b) {
            return this.c.equals(cp0Var.c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "ForegroundInfo{mNotificationId=" + this.a + ", mForegroundServiceType=" + this.b + ", mNotification=" + this.c + '}';
    }
}
