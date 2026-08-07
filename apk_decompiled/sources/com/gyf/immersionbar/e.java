package com.gyf.immersionbar;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
final class e extends ContentObserver {
    private ArrayList a;
    private Application b;
    private Boolean c;

    private static class b {
        private static final e a = new e();
    }

    static e b() {
        return b.a;
    }

    void a(i iVar) {
        if (iVar == null) {
            return;
        }
        if (this.a == null) {
            this.a = new ArrayList();
        }
        if (this.a.contains(iVar)) {
            return;
        }
        this.a.add(iVar);
    }

    void c(Application application) {
        Uri uriFor;
        this.b = application;
        if (application == null || application.getContentResolver() == null || this.c.booleanValue() || (uriFor = Settings.System.getUriFor("navigationbar_is_min")) == null) {
            return;
        }
        this.b.getContentResolver().registerContentObserver(uriFor, true, this);
        this.c = Boolean.TRUE;
    }

    void d(i iVar) {
        ArrayList arrayList;
        if (iVar == null || (arrayList = this.a) == null) {
            return;
        }
        arrayList.remove(iVar);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        ArrayList arrayList;
        super.onChange(z);
        Application application = this.b;
        if (application == null || application.getContentResolver() == null || (arrayList = this.a) == null || arrayList.isEmpty()) {
            return;
        }
        int i = Settings.System.getInt(this.b.getContentResolver(), "navigationbar_is_min", 0);
        NavigationBarType navigationBarType = NavigationBarType.CLASSIC;
        if (i == 1) {
            navigationBarType = NavigationBarType.GESTURES;
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((i) it.next()).a(i == 0, navigationBarType);
        }
    }

    private e() {
        super(new Handler(Looper.getMainLooper()));
        this.c = Boolean.FALSE;
    }
}
