package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class yr1 implements wr1 {
    private final Context a;
    private final Notification.Builder b;
    private final xr1.d c;
    private RemoteViews d;
    private RemoteViews e;
    private final List f = new ArrayList();
    private final Bundle g = new Bundle();
    private int h;
    private RemoteViews i;

    static class a {
        static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        static Notification.Builder e(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        static Notification.Builder f(Notification.Builder builder, boolean z) {
            return builder.setGroupSummary(z);
        }

        static Notification.Builder g(Notification.Builder builder, boolean z) {
            return builder.setLocalOnly(z);
        }

        static Notification.Builder h(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    static class b {
        static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        static Notification.Builder c(Notification.Builder builder, int i) {
            return builder.setColor(i);
        }

        static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        static Notification.Builder f(Notification.Builder builder, int i) {
            return builder.setVisibility(i);
        }
    }

    static class c {
        static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        static Notification.Builder b(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        static Notification.Builder c(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    static class d {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z) {
            return builder.setAllowGeneratedReplies(z);
        }

        static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    static class e {
        static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        static Notification.Builder b(Notification.Builder builder, int i) {
            return builder.setBadgeIconType(i);
        }

        static Notification.Builder c(Notification.Builder builder, boolean z) {
            return builder.setColorized(z);
        }

        static Notification.Builder d(Notification.Builder builder, int i) {
            return builder.setGroupAlertBehavior(i);
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        static Notification.Builder g(Notification.Builder builder, long j) {
            return builder.setTimeoutAfter(j);
        }
    }

    static class f {
        static Notification.Action.Builder a(Notification.Action.Builder builder, int i) {
            return builder.setSemanticAction(i);
        }
    }

    static class g {
        static Notification.Builder a(Notification.Builder builder, boolean z) {
            return builder.setAllowSystemGeneratedContextualActions(z);
        }

        static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z) {
            return builder.setContextual(z);
        }
    }

    static class h {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z) {
            return builder.setAuthenticationRequired(z);
        }

        static Notification.Builder b(Notification.Builder builder, int i) {
            return builder.setForegroundServiceBehavior(i);
        }
    }

    yr1(xr1.d dVar) {
        int i;
        this.c = dVar;
        Context context = dVar.a;
        this.a = context;
        Notification.Builder builderA = e.a(context, dVar.K);
        this.b = builderA;
        Notification notification = dVar.R;
        builderA.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, dVar.i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.e).setContentText(dVar.f).setContentInfo(dVar.k).setContentIntent(dVar.g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.h, (notification.flags & 128) != 0).setNumber(dVar.l).setProgress(dVar.t, dVar.u, dVar.v);
        IconCompat iconCompat = dVar.j;
        c.b(builderA, iconCompat == null ? null : iconCompat.j(context));
        builderA.setSubText(dVar.f445q).setUsesChronometer(dVar.o).setPriority(dVar.m);
        Iterator it = dVar.b.iterator();
        while (it.hasNext()) {
            b((xr1.a) it.next());
        }
        Bundle bundle = dVar.D;
        if (bundle != null) {
            this.g.putAll(bundle);
        }
        int i2 = Build.VERSION.SDK_INT;
        this.d = dVar.H;
        this.e = dVar.I;
        this.b.setShowWhen(dVar.n);
        a.g(this.b, dVar.z);
        a.e(this.b, dVar.w);
        a.h(this.b, dVar.y);
        a.f(this.b, dVar.x);
        this.h = dVar.O;
        b.b(this.b, dVar.C);
        b.c(this.b, dVar.E);
        b.f(this.b, dVar.F);
        b.d(this.b, dVar.G);
        b.e(this.b, notification.sound, notification.audioAttributes);
        List listE = i2 < 28 ? e(f(dVar.c), dVar.U) : dVar.U;
        if (listE != null && !listE.isEmpty()) {
            Iterator it2 = listE.iterator();
            while (it2.hasNext()) {
                b.a(this.b, (String) it2.next());
            }
        }
        this.i = dVar.J;
        if (dVar.d.size() > 0) {
            Bundle bundle2 = dVar.c().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i3 = 0; i3 < dVar.d.size(); i3++) {
                bundle4.putBundle(Integer.toString(i3), zr1.a((xr1.a) dVar.d.get(i3)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            dVar.c().putBundle("android.car.EXTENSIONS", bundle2);
            this.g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i4 = Build.VERSION.SDK_INT;
        Object obj = dVar.T;
        if (obj != null) {
            c.c(this.b, obj);
        }
        this.b.setExtras(dVar.D);
        d.e(this.b, dVar.s);
        RemoteViews remoteViews = dVar.H;
        if (remoteViews != null) {
            d.c(this.b, remoteViews);
        }
        RemoteViews remoteViews2 = dVar.I;
        if (remoteViews2 != null) {
            d.b(this.b, remoteViews2);
        }
        RemoteViews remoteViews3 = dVar.J;
        if (remoteViews3 != null) {
            d.d(this.b, remoteViews3);
        }
        e.b(this.b, dVar.L);
        e.e(this.b, dVar.r);
        e.f(this.b, dVar.M);
        e.g(this.b, dVar.N);
        e.d(this.b, dVar.O);
        if (dVar.B) {
            e.c(this.b, dVar.A);
        }
        if (!TextUtils.isEmpty(dVar.K)) {
            this.b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        if (i4 >= 28) {
            Iterator it3 = dVar.c.iterator();
            if (it3.hasNext()) {
                e43.a(it3.next());
                throw null;
            }
        }
        if (i4 >= 29) {
            g.a(this.b, dVar.Q);
            g.b(this.b, xr1.c.a(null));
        }
        if (i4 >= 31 && (i = dVar.P) != 0) {
            h.b(this.b, i);
        }
        if (dVar.S) {
            if (this.c.x) {
                this.h = 2;
            } else {
                this.h = 1;
            }
            this.b.setVibrate(null);
            this.b.setSound(null);
            int i5 = notification.defaults & (-4);
            notification.defaults = i5;
            this.b.setDefaults(i5);
            if (TextUtils.isEmpty(this.c.w)) {
                a.e(this.b, "silent");
            }
            e.d(this.b, this.h);
        }
    }

    private void b(xr1.a aVar) {
        IconCompat iconCompatD = aVar.d();
        Notification.Action.Builder builderA = c.a(iconCompatD != null ? iconCompatD.i() : null, aVar.h(), aVar.a());
        if (aVar.e() != null) {
            for (RemoteInput remoteInput : ve2.b(aVar.e())) {
                a.c(builderA, remoteInput);
            }
        }
        Bundle bundle = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        int i = Build.VERSION.SDK_INT;
        d.a(builderA, aVar.b());
        bundle.putInt("android.support.action.semanticAction", aVar.f());
        if (i >= 28) {
            f.a(builderA, aVar.f());
        }
        if (i >= 29) {
            g.c(builderA, aVar.j());
        }
        if (i >= 31) {
            h.a(builderA, aVar.i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.g());
        a.b(builderA, bundle);
        a.a(this.b, a.d(builderA));
    }

    private static List e(List list, List list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        y9 y9Var = new y9(list.size() + list2.size());
        y9Var.addAll(list);
        y9Var.addAll(list2);
        return new ArrayList(y9Var);
    }

    private static List f(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return arrayList;
        }
        e43.a(it.next());
        throw null;
    }

    @Override // defpackage.wr1
    public Notification.Builder a() {
        return this.b;
    }

    public Notification c() {
        Bundle bundleA;
        RemoteViews remoteViewsF;
        RemoteViews remoteViewsD;
        xr1.e eVar = this.c.p;
        if (eVar != null) {
            eVar.b(this);
        }
        RemoteViews remoteViewsE = eVar != null ? eVar.e(this) : null;
        Notification notificationD = d();
        if (remoteViewsE != null) {
            notificationD.contentView = remoteViewsE;
        } else {
            RemoteViews remoteViews = this.c.H;
            if (remoteViews != null) {
                notificationD.contentView = remoteViews;
            }
        }
        if (eVar != null && (remoteViewsD = eVar.d(this)) != null) {
            notificationD.bigContentView = remoteViewsD;
        }
        if (eVar != null && (remoteViewsF = this.c.p.f(this)) != null) {
            notificationD.headsUpContentView = remoteViewsF;
        }
        if (eVar != null && (bundleA = xr1.a(notificationD)) != null) {
            eVar.a(bundleA);
        }
        return notificationD;
    }

    protected Notification d() {
        return this.b.build();
    }
}
